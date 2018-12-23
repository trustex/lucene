package com.xywy.lucene.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;

import com.xywy.lucene.lucene.IKAnalyzer;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.search.spell.SpellChecker;
import org.apache.lucene.search.suggest.FileDictionary;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;


public class SuggestUtil {
    public static void main(String[] args) {
        Directory spellIndexDirectory;
        try {
            spellIndexDirectory = FSDirectory.open(Paths.get("suggest", new String[0]));

            SpellChecker spellchecker = new SpellChecker(spellIndexDirectory);
            Analyzer analyzer = new IKAnalyzer(true);
            IndexWriterConfig config = new IndexWriterConfig(analyzer);
            config.setOpenMode(OpenMode.CREATE_OR_APPEND);
            spellchecker.setAccuracy(0f);
            //HighFrequencyDictionary dire = new HighFrequencyDictionary(reader, field, thresh)
            spellchecker.indexDictionary(new FileDictionary(SuggestUtil.class.getClassLoader().getResourceAsStream("suggest.txt")), config, false);
            String[] similars = spellchecker.suggestSimilar("中国", 10);
            for (String similar : similars) {
                System.out.println(similar);
            }
            spellIndexDirectory.close();
            spellchecker.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}