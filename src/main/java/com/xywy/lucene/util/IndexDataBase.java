package com.xywy.lucene.util;

import ch.qos.logback.core.util.FileUtil;
import com.xywy.lucene.lucene.BaiKeBeanIndex;
import com.xywy.lucene.lucene.IKAnalyzer;
import com.xywy.lucene.model.Baike;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component//使用@Configuration也可以
@PropertySource(value = "classpath:config.yml")//配置文件路径
public class IndexDataBase {
    //Lucene索引文件路径
    @Value("indexPath")
    private String indexPath;

    //定义分词器
    static Analyzer analyzer = new IKAnalyzer();
    /**
     * 封裝一个方法，用于将数据库中的数据解析为一个个关键字词存储到索引文件中
     * @param baikes
     */
    public void write(List<Baike> baikes){
//        try {
//            //索引库的存储目录
//            Directory dir = FSDirectory.open(Paths.get(indexPath));
//
//            IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
//
//            //传入目录和分词器
//            IndexWriter writer = new IndexWriter(dir, iwc);
//            //写入到目录文件中
//            writer.addDocument(doc);
//            //提交事务
//            writer.commit();
//            //关闭流
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        try {
            int totalCount = baikes.size();
            int perThreadCount = 3000;
            int threadCount = totalCount/perThreadCount + (totalCount%perThreadCount == 0 ? 0 : 1);
            ExecutorService pool = Executors.newFixedThreadPool(threadCount);
            CountDownLatch countDownLatch1 = new CountDownLatch(1);
            CountDownLatch countDownLatch2 = new CountDownLatch(threadCount);

            for(int i = 0; i < threadCount; i++) {
                int start = i*perThreadCount;
                int end = (i+1) * perThreadCount < totalCount ? (i+1) * perThreadCount : totalCount;
                List<Baike> subList = baikes.subList(start, end);
                Runnable runnable = new BaiKeBeanIndex("index",i, countDownLatch1, countDownLatch2, subList);
                //子线程交给线程池管理
                pool.execute(runnable);
            }
            countDownLatch1.countDown();
            System.out.println("开始创建索引");
            //等待所有线程都完成
            countDownLatch2.await();
            //线程全部完成工作
            System.out.println("所有线程都创建索引完毕");
            //释放线程池资源
            pool.shutdown();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public String getIndexPath() {
        return indexPath;
    }

    public void setIndexPath(String indexPath) {
        this.indexPath = indexPath;
    }
}
