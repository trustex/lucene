## 全文检索
- 全文检索是一种将文件中所有文本与检索项匹配的检索方法。它可以根据需要获得全文中有关章、节、段、句、词等信息。计算机程序通过扫描文章中的每一个词，对每一个词建立一个索引，指明该词在文章中出现的次数和位置，当用户查询时根据建立的索引查找，类似于通过字典的检索字表查字的过程。

- 全文检索首先将要查询的目标数据源中的一部分信息提取出来，组成索引，通过查询索引达到搜索目标数据源的目的，所以速度较快。
这种先建立索引，再对索引进行搜索的过程就叫全文检索（Full-text Search）。

- 全文检索系统是一个可以运行的系统，包括建立索引、处理查询返回结果集、增加索引、优化索引结构等功能。

- 全文检索技术是搜索引擎的核心支撑技术。

## lucene实现全文检索
Lucene是apache下的一个开放源代码的全文检索引擎工具包。提供了完整的查询引擎和索引引擎，部分文本分析引擎。Lucene的目的是为软件开发人员提供一个简单易用的工具包，以方便的在目标系统中实现全文检索的功能。
> 搜索就是用户输入关键字，从索引（index）中进行搜索的过程。根据关键字搜索索引，根据索引找到对应的文档，从而找到要搜索的内容（这里指磁盘上的文件）。

### 索引过程的核心类
#### ①IndexWriter 
索引过程的核心组件。这个类负责创建新索引或者打开已有索引，以及向索引中添加、删除或更新被索引文档的信息。可以把IndexWriter看作这样一个对象：它为你提供针对索引文件的写入操作，但不能用于读取或搜索索引。IndexWriter需要开辟一定空间来存储索引，该功能可以由Directory完成。
#### ②Directory 
该类描述了Lucene索引的存放位置。它是一个抽象类，它的子类负责具体指定索引的存储路径。用FSDirectory.open方法来获取真实文件在文件系统的存储路径，然后将它们一次传递给IndexWriter类构造方法。IndexWriter不能直接索引文本，这需要先由Analyzer将文本分割成独立的单词才行。
#### ③Analyzer 
文本文件在被索引之前，需要经过Analyzer（分析器）处理。Analyzer是由IndexWriter的构造方法来指定的，它负责从被索引文本文件中提取语汇单元，并提出剩下的无用信息。如果被索引内容不是纯文本文件，那就需要先将其转换为文本文档。对于要将Lucene集成到应用程序的开发人员来说，选择什么样Analyzer是程序设计中非常关键的一步。分析器的分析对象为文档，该文档包含一些分离的能被索引的域。
#### ④Document 
Document对象代表一些域（Field）的集合。文档的域代表文档或者文档相关的一些元数据。元数据（如作者、标题、主题和修改日期等）都作为文档的不同域单独存储并被索引。Document对象的结构比较简单，为一个包含多个Filed对象容器；Field是指包含能被索引的文本内容的类。
#### ⑤Field 
索引中的每个文档都包含一个或多个不同命名的域，这些域包含在Field类中。每个域都有一个域名和对应的域值，以及一组选项来精确控制Lucene索引操作各个域值。

Field是文档中的域，包括Field名和Field值两部分，一个文档可以包括多个Field，Document只是Field的一个承载体，Field值即为要索引的内容，也是要搜索的内容。

![field](https://github.com/suxiongwei/lucene/blob/master/src/main/resources/static/img/field.png)
### 主要Package介绍
#### org.apache.lucene.document
这个包提供了一些为封装要索引的文档所需要的类，比如 Document, Field。这样，每一个文档最终被封装成了一个 Document 对象。
#### org.apache.lucene.analysis
这个包主要功能是对文档进行分词，因为文档在建立索引之前必须要进行分词，所以这个包的作用可以看成是为建立索引做准备工作。
#### org.apache.lucene.index
这个包提供了一些类来协助创建索引以及对创建好的索引进行更新。这里面有两个基础的类：IndexWriter 和 IndexReader，其中 IndexWriter 是用来创建索引并添加文档到索引中的，IndexReader 是用来删除索引中的文档的。
#### org.apache.lucene.search
这个包提供了对在建立好的索引上进行搜索所需要的类。比如 IndexSearcher 和 Hits, IndexSearcher 定义了在指定的索引上进行搜索的方法，Hits 用来保存搜索得到的结果。

### Analyzer(分析器)，分词过程
Analyzer（分析器）由Tokenizer（分词器）和Filter（过滤器）组成

![field](https://github.com/suxiongwei/lucene/blob/master/src/main/resources/static/img/analyzer.png)

```
Character Filter(字符过滤器)
文本被Tokenizer处理前可能要做一些预处理， 比如去掉里面的HTML标记， 这些处理的算法被称为Character Filter(字符过滤器)

Tokenizer(分词器)
这些算法叫做Tokenizer(分词器)

Token（词元）
全文搜索引擎会用某种算法对要建索引的文档进行分析， 从文档中提取出若干Tokenizer(分词器)

Token Filter(词元处理器)

这些Token会被进一步处理， 比如转成小写等， 这些处理算法被称为TokenFilter(词元处理器)

Term(词)
被处理后的结果被称为Term(词)
```

