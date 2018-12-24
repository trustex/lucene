Lucene对查询关键字和索引文档的相关度进行打分，得分高的就排在前边。如何打分呢？Lucene是在用户进行检索时实时根据搜索的关键字计算出来的，分两步：
- 1）计算出词（Term）的权重
- 2）根据词的权重值，采用空间向量模型算法计算文档相关度得分

## 相关度评分背后的理论
- https://www.elastic.co/guide/cn/elasticsearch/guide/current/scoring-theory.html#tfidf
- Lucene（或 Elasticsearch）使用 布尔模型（Boolean model） 查找匹配文档， 并用一个名为 实用评分函数（practical scoring function） 的公式来计算相关度。这个公式借鉴了 词频/逆向文档频率（term frequency/inverse document frequency） 和 向量空间模型（vector space model），同时也加入了一些现代的新特性，如协调因子（coordination factor），字段长度归一化（field length normalization），以及词或查询语句权重提升。

### 1 布尔模型
布尔模型（Boolean Model） 只是在查询中使用 AND 、 OR 和 NOT （与、或和非）这样的条件来查找匹配的文档，以下查询：
full AND text AND search AND (elasticsearch OR lucene)
会将所有包括词 full 、 text 和 search ，以及 elasticsearch 或 lucene 的文档作为结果集。

### 2 词频/逆向文档频率（TF/IDF）
当匹配到一组文档后，需要根据相关度排序这些文档，不是所有的文档都包含所有词，有些词比其他的词更重要。一个文档的相关度评分部分取决于每个查询词在文档中的 权重 。
#### 1）、词频（term frequency）TF
单个文章的词频，词在文档中出现的词频
词在文档中出现的频度是多少？ 频度越高，权重 越高 。 5 次提到同一词的字段比只提到 1 次的更相关。
#### 2）、逆向文档频率（inverse document frequency）IDF
词在这篇文档中出现过次数/词在所有文章出现的次数
词在集合所有文档里出现的频率是多少？频次越高，权重 越低 。 常用词如 and 或 the 对相关度贡献很少，因为它们在多数文档中都会出现，一些不常见词如 elastic 或 hippopotamus 可以帮助我们快速缩小范围找到感兴趣的文档。
#### 3）、字段长度归一值
字段的长度是多少？ 字段越短，字段的权重 越高 。如果词出现在类似标题 title 这样的字段，要比它出现在内容 body 这样的字段中的相关度更高。

> 词频（term frequency）、逆向文档频率（inverse document frequency）和字段长度归一值（field-length norm）——是在索引时计算并存储的。 最后将它们结合在一起计算单个词在特定文档中的 权重 。

当然，查询通常不止一个词，所以需要一种合并多词权重的方式——向量空间模型（vector space model）。

### 3 向量空间模型（VSM）
向量空间模型（vector space model）<br/> 提供一种比较多词查询的方式，单个评分代表文档与查询的匹配程度，为了做到这点，这个模型将文档和查询都以 向量（vectors） 的形式表示
文档和查询都用向量来表示。<br/>
每一维都对应于一个个别的词组。如果某个词组出现在了文档中，那它在向量中的值就非零。已经发展出了不少的方法来计算这些值，这些值叫做（词组）权重。其中一种最为知名的方式是tf-idf权重<br/>
通过向量运算，可以对各文档和各查询作比较。