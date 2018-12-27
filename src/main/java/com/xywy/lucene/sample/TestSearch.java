package com.xywy.lucene.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.xywy.lucene.lucene.IKAnalyzer;
import com.xywy.lucene.model.Baike;
import com.xywy.lucene.util.SearchUtil;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.*;


public class TestSearch {
    public static void main(String[] args) throws ParseException, InvalidTokenOffsetsException {
        ExecutorService service = Executors.newCachedThreadPool();
        //定义分词器
        Analyzer analyzer = new IKAnalyzer();
        try {
            String value = "中国";
            IndexSearcher searcher = SearchUtil.getIndexSearcherByParentPath("/Users/suxiongwei/project/lucene/index",service);
            String[] fields = {"title","summary"};
            // 构造Query对象
            MultiFieldQueryParser parser = new MultiFieldQueryParser(fields,analyzer);

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
            String line = value != null ? value : in.readLine();
            Query query = parser.parse(line);
            //最终被分词后添加的前缀和后缀处理器，默认是粗体<B></B>
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("<font color=").append("\"").append("red").append("\"").append(">");
            SimpleHTMLFormatter htmlFormatter = new SimpleHTMLFormatter(stringBuffer.toString(),"</font>");
            //高亮搜索的词添加到高亮处理器中
            Highlighter highlighter = new Highlighter(htmlFormatter, new QueryScorer(query));

            //获取搜索的结果，指定返回document返回的个数
            // 收集足够的文档显示5页
//            TopDocs results = searcher.search(query, 5);
            TopDocs results = SearchUtil.getScoreDocsByPerPage(2, 20, searcher, query);
            ScoreDoc[] hits = results.scoreDocs;

            List<Map> list=new ArrayList<Map>();

            //遍历，输出
            for (int i = 0; i < hits.length; i++) {
                int id = hits[i].doc;
                Document hitDoc = searcher.doc(hits[i].doc);
                Map map=new HashMap();
                map.put("id", hitDoc.get("id"));

                //获取到summary
                String name=hitDoc.get("summary");
                //将查询的词和搜索词匹配，匹配到添加前缀和后缀
                TokenStream tokenStream = TokenSources.getAnyTokenStream(searcher.getIndexReader(), id, "summary", analyzer);
                //传入的第二个参数是查询的值
                TextFragment[] frag = highlighter.getBestTextFragments(tokenStream, name, false, 10);
                String baikeValue="";
                for (int j = 0; j < frag.length; j++) {
//                if ((frag[j] != null) && (frag[j].getScore() > 0)) {
                    if ((frag[j] != null)) {
                        //获取 summary 的值
                        baikeValue=baikeValue+((frag[j].toString()));
                    }
                }

                //获取到title
                String title=hitDoc.get("title");
                TokenStream titleTokenStream = TokenSources.getAnyTokenStream(searcher.getIndexReader(), id, "title", analyzer);
                TextFragment[] titleFrag = highlighter.getBestTextFragments(titleTokenStream, title, false, 10);
                String titleValue="";
                for (int j = 0; j < titleFrag.length; j++) {
                    if ((frag[j] != null)) {
                        titleValue=titleValue+((titleFrag[j].toString()));
                    }
                }
                map.put("title", titleValue);
                map.put("summary", baikeValue);
                list.add(map);
            }
            for(Map s:list){
                System.out.println(s.get("summary"));
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            service.shutdownNow();
        }
    }

}
