package com.xywy.lucene.api;

import com.xywy.lucene.mapper.DoctorMapper;
import com.xywy.lucene.model.DoctorWithBLOBs;
import com.xywy.lucene.util.IndexDataBase;
import com.xywy.lucene.util.SearchDataBase;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class SearchController {
    @Autowired
    private DoctorMapper doctorMapper;
    @Autowired
    private IndexDataBase indexDataBase;
    @Autowired
    private SearchDataBase searchDataBase;

    @GetMapping("/createIndex")
    public String createIndex() {
        // 拉取数据
        List<DoctorWithBLOBs> queryCategories = doctorMapper.getDoctors(5,0);

        DoctorWithBLOBs doctor = new DoctorWithBLOBs();
        //获取字段
        for (int i = 0; i < queryCategories.size(); i++) {
            //获取每行数据
            doctor = queryCategories.get(i);
            //创建Document对象
            Document doc = new Document();
            //获取每列数据

            Field name = new Field("name", doctor.getName(), TextField.TYPE_STORED);
            Field goodat = new Field("goodat", doctor.getGoodat(), TextField.TYPE_STORED);
            Field info = new Field("info", doctor.getInfo(), TextField.TYPE_STORED);
            Field pinyin = new Field("pinyin", doctor.getPinyin(), TextField.TYPE_STORED);
            //添加到Document中
            doc.add(name);
            doc.add(goodat);
            doc.add(info);
            doc.add(pinyin);
            //调用，创建索引库
            indexDataBase.write(doc);

        }
        return "成功";
    }

    //搜索，实现高亮
    @GetMapping("/searchDoctor")
    public List<Map> getFood(String keyWord) throws Exception {
        return searchDataBase.search("goodat", keyWord);
    }
}
