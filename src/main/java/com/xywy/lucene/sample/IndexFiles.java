package com.xywy.lucene.sample;

import com.xywy.lucene.lucene.IKAnalyzer;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Date;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * 创建索引
 */
public class IndexFiles {
    private IndexFiles() {
    }

    /**
     * Index all text files under a directory.
     */
    public static void main(String[] args) {
        String indexPath = "E:\\doctor\\index";
        String docsPath = "E:\\doctor\\data";
        //默认设置为添加新索引
        boolean create = true;
        final Path docDir = Paths.get(docsPath);
        if (!Files.isReadable(docDir)) {
            System.out.println("Document directory '" + docDir.toAbsolutePath() + "' does not exist or is not readable, please check the path");
            System.exit(1);
        }

        Date start = new Date();
        try {
            System.out.println("Indexing to directory '" + indexPath + "'...");

            ////获取真实文件在文件系统的存储路径
            Directory dir = FSDirectory.open(Paths.get(indexPath));
//            Analyzer analyzer = new StandardAnalyzer();
            Analyzer analyzer = new IKAnalyzer();
            IndexWriterConfig iwc = new IndexWriterConfig(analyzer);

            if (create) {
                // 在目录中创建一个新索引，删除任何索引 以前索引文件
                iwc.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
            } else {
                // 向现有索引添加新文档:
                iwc.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
            }

            /**
             * 可选:为了更好的索引性能，如果您正在索引许多文档，增加RAM缓冲区。
             * 即增加最大堆JVM的大小(如添加-Xmx512m或-Xmx1g):iwc.setRAMBufferSizeMB(256.0);
             */
            //iwc.setRAMBufferSizeMB(256.0);

            // 构造IndexWriter
            IndexWriter writer = new IndexWriter(dir, iwc);
            indexDocs(writer, docDir);

            //
            /**
             * 注意:如果你想最大化搜索性能，你可以选择在这里调用forcemergence。
             * 这可能是一个非常代价高的操作,所以一般只有当你的索引是相对静态的时候，这是值得的
             */
            // writer.forceMerge(1);
            writer.close();

            Date end = new Date();
            System.out.println(end.getTime() - start.getTime() + " total milliseconds");

        } catch (IOException e) {
            System.out.println(" caught a " + e.getClass() +
                    "\n with message: " + e.getMessage());
        }
    }

    /**
     ** @param writer Writer to the index where the given file/dir info will be stored
     ** @param path The file to index, or the directory to recurse into to find files to index
     ** @throws IOException If there is a low-level I/O error
     *
     */
    static void indexDocs(final IndexWriter writer, Path path) throws IOException {
        if (Files.isDirectory(path)) {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    try {
                        indexDoc(writer, file, attrs.lastModifiedTime().toMillis());
                    } catch (IOException ignore) {
                        // don't index files that can't be read.
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } else {
            indexDoc(writer, path, Files.getLastModifiedTime(path).toMillis());
        }
    }

    /**
     * Indexes a single document
     */
    static void indexDoc(IndexWriter writer, Path file, long lastModified) throws IOException {
        try (InputStream stream = Files.newInputStream(file)) {
            // 创建一个新的、空的文档
            Document doc = new Document();

            Field pathField = new StringField("path", file.toString(), Field.Store.YES);
            doc.add(pathField);

            doc.add(new LongPoint("modified", lastModified));

            doc.add(new TextField("contents", new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))));

            if (writer.getConfig().getOpenMode() == IndexWriterConfig.OpenMode.CREATE) {
                // 新索引，所以我们只添加文档(不能有旧文档):
                System.out.println("adding " + file);
                writer.addDocument(doc);
            } else {
                //现有索引(此文档的旧副本可能已被索引)
                //我们使用updateDocument替换与实际相符的旧文档
                System.out.println("updating " + file);
                writer.updateDocument(new Term("path", file.toString()), doc);
            }
        }
    }
}
