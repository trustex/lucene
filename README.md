## lucene
基于lucene与IKAnalyzer的中文搜索demo及学习记录
## 开发环境及项目框架介绍
+ IDE:Intellij IDEA
+ 数据库:MySQL ([数据库代码baike.sql]())
+ 项目框架:SpringBoot + lucene 6.6.5 + IKAnalyzer 2012FF
    + lucene 6.6.5:<http://www.apache.org/dyn/closer.lua/lucene/java/6.6.5>
    + IKAnalyzer 2012FF:<https://gitee.com/wltea/IK-Analyzer-2012FF>
## 数据准备
通过Python爬取百度百科的词条数据作为本搜索引擎的基础数据，爬取介绍及操作方式见[PythonSpider](https://github.com/suxiongwei/PythonSpider) 
## 演示步骤
- 1、MySQL服务
- 2、启动服务：SearchApp
- 3、生成索引：访问http://localhost:8080/createIndex生成索引文件
```java
    @GetMapping("/createIndex")
    public String createIndex() {
        // 拉取数据
        List<Baike> baikes = baikeMapper.getAllBaike(10000,0);
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
```

- 4、搜索界面地址：http://localhost:8080/search
```java
    //搜索，实现高亮
    @GetMapping("/getSearchText")
    public ModelAndView getSearchText(String keyWord,String field,ModelAndView mv) throws Exception {
        List<Map> mapList = searchDataBase.search(field, keyWord);
        mv.setViewName("/result");
        mv.addObject("mapList",mapList);
        return mv;
    }
```
![search](https://github.com/suxiongwei/lucene/tree/master/src/main/resources/static/img/search.jpg)
![result](https://github.com/suxiongwei/lucene/tree/master/src/main/resources/static/img/result.jpg)

