package com.xywy.lucene.util;

import com.xywy.lucene.lucene.IKAnalyzer;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component//使用@Configuration也可以
@PropertySource(value = "classpath:config.yml")//配置文件路径
public class SearchDataBase {
    //Lucene索引文件路径
    @Value("${indexPath}")
    private String indexPath;

    //定义分词器
    static Analyzer analyzer = new IKAnalyzer();

    //搜索
    public List<Map> search(String field, String value) throws Exception{

        //索引库的存储目录
        Directory dir = FSDirectory.open(Paths.get(indexPath));
        //读取索引库的存储目录
        // 实例化读取器
        IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(indexPath)));
        //lucence查询解析器，用于指定查询的属性名和分词器
        // 实例化搜索器
        IndexSearcher searcher = new IndexSearcher(reader);
        //搜索
        // 构造QueryParser查询分析器
//        QueryParser parser = new QueryParser(field, analyzer);

        //创建一个MulitFiledQueryParser对象
        //可以指定默认搜索的域是多个
        String[] fields = {"title","summary"};
        MultiFieldQueryParser parser = new MultiFieldQueryParser(fields,analyzer);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        String line = value != null ? value : in.readLine();

        // 构造Query对象
        Query query = parser.parse(line);
        //最终被分词后添加的前缀和后缀处理器，默认是粗体<B></B>
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<font color=").append("\"").append("red").append("\"").append(">");
        SimpleHTMLFormatter htmlFormatter = new SimpleHTMLFormatter(stringBuffer.toString(),"</font>");
        //高亮搜索的词添加到高亮处理器中
        Highlighter highlighter = new Highlighter(htmlFormatter, new QueryScorer(query));

        //获取搜索的结果，指定返回document返回的个数
        // 收集足够的文档显示5页
        TopDocs results = searcher.search(query, 5);
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
        reader.close();
        dir.close();
        return list;
    }

    public String getIndexPath() {
        return indexPath;
    }

    public void setIndexPath(String indexPath) {
        this.indexPath = indexPath;
    }
}
