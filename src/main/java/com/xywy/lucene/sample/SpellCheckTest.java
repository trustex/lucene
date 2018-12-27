package com.xywy.lucene.sample;
import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.spell.PlainTextDictionary;
import org.apache.lucene.search.spell.SpellChecker;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
public class SpellCheckTest {
    private static String dicpath = "/Users/suxiongwei/project/lucene/src/main/resources/dictionary.dic";
    private Document document;
    private Directory directory = new RAMDirectory();
    private IndexWriter indexWriter;
    //拼写检查
    private SpellChecker spellchecker;
    //创建测试索引
    public void CreateIndex(String content) throws IOException{
        IndexWriterConfig config = new IndexWriterConfig(new StandardAnalyzer());
        indexWriter = new IndexWriter(directory, config);
        document = new Document();
        document.add(new TextField("content",content,Store.YES));
        try {
            indexWriter.addDocument(document);
            indexWriter.commit();
            indexWriter.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void search(String word, int numSug) {
        directory = new RAMDirectory();
        try {
            IndexWriterConfig config = new IndexWriterConfig(new StandardAnalyzer());
            spellchecker = new SpellChecker(directory);
            //初始化字典目录
            //最后一个fullMerge参数表示拼写检查索引是否需要全部合并
            // 一句话总结：indexDictionary就是将字典文件里的词进行ngram操作后得到多个词然后分别写入索引。
            spellchecker.indexDictionary(new PlainTextDictionary(Paths.get(dicpath)),config,true);
            //这里的参数numSug表示返回的建议个数
            String[] suggests = spellchecker.suggestSimilar(word, numSug);  //用来计算最后返回的建议词
            //判断两个词的相似度，默认实现是LevensteinDistance，至于LevensteinDistance算法实现自己去看LevensteinDistance源码吧。
            if (suggests != null && suggests.length > 0) {
                for (String suggest : suggests) {
                    System.out.println("您是不是想要找：" + suggest);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        SpellCheckTest spellCheckTest = new SpellCheckTest();
        spellCheckTest.CreateIndex("《屌丝男士》不是传统意义上的情景喜剧，有固定时长和单一场景，" +
                "以及简单的生活细节。而是一部具有鲜明网络特点，舞台感十足，" +
                "整体没有剧情衔接，固定的演员演绎着并不固定角色的笑话集。");
        spellCheckTest.CreateIndex("屌丝男士的拍摄构想，首先源于“屌丝文化”在中国的刮起的现象级春风，" +
                "红透了整片天空，全中国上下可谓无人不屌丝，无人不爱屌丝。");
        spellCheckTest.CreateIndex("德国的一部由女演员玛蒂娜-希尔主演的系列短剧，凭借其疯癫荒诞、自high" +
                "耍贱、三俗无下限的表演风格，在中国取得了巨大成功，红火程度远远超过了德国。不仅位居国内各" +
                "个视频网站的下载榜和点播榜高位，且在微博和媒体间，引发了坊间热议和话题传播。网友们更是" +
                "形象地将其翻译为《屌丝女士》，对其无比热衷。于是我们决定着手拍一部属于中国人，" +
                "带强烈国人屌丝色彩的《屌丝男士》。");

        String word = "屌是男士";
        spellCheckTest.search(word, 1);

//        File directory = new File("");// 参数为空
//        String courseFile = directory.getCanonicalPath();
//        System.out.println(courseFile);
//
//
//        // 第四种： D:\git\daotie\daotie
//        System.out.println(System.getProperty("user.dir"));
    }
}
