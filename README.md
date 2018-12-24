## lucene
基于lucene与IKAnalyzer的中文搜索demo及学习记录<br>

> Lucene是apache下的一个开放源代码的全文检索引擎工具包。提供了完整的查询引擎和索引引擎，部分文本分析引擎。
Lucene的目的是为软件开发人员提供一个简单易用的工具包，以方便的在目标系统中实现全文检索的功能。
###
> IKAnalyzer 是一个开源的，基于java语言开发的轻量级的中文分词工具包最初，它是以开源项目 Lucene为应用主体的，结合词典分词和文法分析
算法的中文分词组件。新版本的IKAnalyzer3.0则发展为 面向Java的公用分词组件，独立于Lucene项目，同时提供了对Lucene的默认优化实现。

## 开发环境及项目框架介绍
+ IDE:Intellij IDEA
+ 数据库:MySQL，建立名为lucene的数据库， ([数据库代码baike.sql](https://github.com/suxiongwei/lucene/blob/master/src/main/resources/static/db/baike.sql))
+ 项目框架:SpringBoot + lucene 6.6.5 + IKAnalyzer 2012FF
    + lucene 6.6.5:<http://www.apache.org/dyn/closer.lua/lucene/java/6.6.5>
    + IKAnalyzer 2012FF:<https://gitee.com/wltea/IK-Analyzer-2012FF>
    
## 学习记录
- 1、[SpellCheck拼写纠错](https://github.com/suxiongwei/lucene/blob/master/src/main/resources/static/md/SpellCheck拼写纠错.md)
- 2、[IKAnalyzer简单介绍](https://github.com/suxiongwei/lucene/blob/master/src/main/resources/static/md/IKAnalyzer简单介绍.md)
- 3、[lucene相关度打分](https://github.com/suxiongwei/lucene/blob/master/src/main/resources/static/md/lucene相关度打分.md)
- 4、[全文检索及lucene如何实现全文检索](https://github.com/suxiongwei/lucene/blob/master/src/main/resources/static/md/全文检索及lucene如何实现全文检索.md)
- 5、[倒排索引](https://github.com/suxiongwei/lucene/blob/master/src/main/resources/static/md/倒排索引.md)
- 6、[字典树](https://github.com/suxiongwei/lucene/blob/master/src/main/resources/static/md/字典树.md)
## 数据准备
介绍以下俩种初始数据的方式:
- 1、通过[数据库代码baike.sql](https://github.com/suxiongwei/lucene/blob/master/src/main/resources/static/db/baike.sql)中
的数据作为初始数据
- 2、通过Python爬取百度百科的词条数据作为本搜索的基础数据，爬取介绍及操作方式见[PythonSpider](https://github.com/suxiongwei/PythonSpider)
## 项目运行
- 1、修改[config.yml](https://github.com/suxiongwei/lucene/tree/master/src/main/resources/config.yml)文件，修改索引生成的目录
- 2、开启MySQL服务
- 3、启动服务：Run SearchApp
- 4、生成索引：访问http://localhost:8080/createIndex?limit=10000&offset=0
```
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
```

- 5、搜索界面地址：http://localhost:8080/search
```
    //搜索，实现高亮
    @GetMapping("search/{q}")
    public List<Map> getSearchText(@PathVariable String q) throws Exception {
        List<Map> mapList = searchDataBase.search("summary", q);
        return mapList;
    }
```
## 运行效果
![search](https://github.com/suxiongwei/lucene/blob/master/src/main/resources/static/img/search.png)

