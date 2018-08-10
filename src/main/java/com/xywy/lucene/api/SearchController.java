package com.xywy.lucene.api;

import com.xywy.lucene.mapper.BaikeMapper;
import com.xywy.lucene.model.Baike;
import com.xywy.lucene.util.IndexDataBase;
import com.xywy.lucene.util.SearchDataBase;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
public class SearchController {
    @Autowired private BaikeMapper baikeMapper;
    @Autowired private IndexDataBase indexDataBase;
    @Autowired private SearchDataBase searchDataBase;


    @GetMapping("/createIndex")
    public String createIndex(int limit,int offset) {
        // 拉取数据
        List<Baike> baikes = baikeMapper.getAllBaike(limit,offset);

        Baike baike = new Baike();
        //获取字段
        for (int i = 0; i < baikes.size(); i++) {
            //获取每行数据
            baike = baikes.get(i);
            //创建Document对象
            Document doc = new Document();
            //获取每列数据

            Field id = new Field("id", baike.getId()+"", TextField.TYPE_STORED);
            Field title = new Field("title", baike.getTitle(), TextField.TYPE_STORED);
            Field summary = new Field("summary", baike.getSummary(), TextField.TYPE_STORED);
            //添加到Document中
            doc.add(id);
            doc.add(title);
            doc.add(summary);
            //调用，创建索引库
            indexDataBase.write(doc);

        }
        return "成功";
    }

    //搜索，实现高亮
    @GetMapping("/getSearchText")
    public ModelAndView getSearchText(String keyWord,String field,ModelAndView mv) throws Exception {
        if(keyWord == null || keyWord.equals("")){
            mv.setViewName("/error");
            mv.addObject("message","查询关键词不能为空");
        }
        List<Map> mapList = searchDataBase.search(field, keyWord);
        mv.setViewName("/result");
        mv.addObject("mapList",mapList);
        return mv;
    }

    @GetMapping(value = "/search")
    public ModelAndView test(ModelAndView mv) {
        mv.setViewName("/search");
        mv.addObject("title","欢迎使用Thymeleaf!");
        return mv;
    }



}
