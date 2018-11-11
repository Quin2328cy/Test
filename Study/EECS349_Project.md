## Decision Tree and Visualization
#### 生成Decision Tree
> 问题：没办法后续剪枝
```
无法避免过拟合，只能用前序剪枝，设置Classifier或者Regression里的参数max_depth, min_samples_split；这基本决定了decision tree只会是一个实验性的方案
```

#### Visualization
> 概况：直接绘图：
```
Update:直接存为PDF可以查看，但是属性值不好确认
因为树的结构过大，会以0.13的比例进行缩放导致无法直接查看，只好转存为svg格式，但是Visio也无法很好的打开，只好尝试直接输出各属性值所占的比例

```

```python
# -*- coding: utf-8 -*-
import os 
import re 
import numpy as np
from sklearn.feature_extraction.text import CountVectorizer
import pandas as pd 
from sklearn.tree import export_graphviz
import pydotplus 

train_filename = 'F:/codes/Python/EECS349/Project/train.json'
test_filename = 'F:/codes/Python/EECS349/Project/test.json'


print('读取训练集')
train = pd.read_json(train_filename)
train.head()
# 最大特征数量 
vectorizer = CountVectorizer(max_features = 500)
# 训练集菜单
ingredients = train['ingredients']
# print ingredients 
# 菜直接的逗号 换成空格 构造词袋 
words_list = [' '.join(x) for x in ingredients]
print(len(words_list))


print('构造词袋')
# 各个词出现的次数 并转换成矩阵的形式 
bag_of_words = vectorizer.fit(words_list)
bag_of_words = vectorizer.transform(words_list).toarray()
print(bag_of_words.shape)
# print bag_of_words 


print('read test ')
test = pd.read_json(test_filename)
test.head()
print('test')
print('............')
test_ingredients = test['ingredients']
test_ingredients_words = [' '.join(x) for x in test_ingredients]
test_ingredients_arrays = vectorizer.transform(test_ingredients_words).toarray()
''''                           决策树                                        '''
print("决策树 模型")
from sklearn import tree
import pydotplus
from IPython.display import Image
import matplotlib.pyplot as plt
from itertools import product
forest = tree.DecisionTreeClassifier(max_depth=20)
forest = forest.fit(bag_of_words,train['cuisine'])
dot_data = tree.export_graphviz(forest, out_file=None) 
graph = pydotplus.graph_from_dot_data(dot_data)
print('predict')
result = forest.predict(test_ingredients_arrays)
output = pd.DataFrame( data={"id":test["id"], "cuisine":result} )
print(result)

import graphviz
print('draw')
graph = graphviz.Source(dot_data)
graph.render('example.gv', directory='E:\\log_reg', view=True)
print('Save example.gv file!\n')
#graph.write_png("F:/codes/Python/EECS349/Project/tree.png")


```

> .gv文件转svg
```shell
 dot -Tsvg -O .\example.gv 
```

> 也可以通过存储规则文件以查看（但是不知道对应的label是什么，也很难可视化）
```python
tree.export_graphviz(forest, out_file='F:/codes/Python/EECS349/Project/trees.txt')
```

> 直接转为PDF，很大，需要用chrome才能比较好的预览.
```python
dot_data = tree.export_graphviz(forest, out_file=None) 
graph = pydotplus.graph_from_dot_data(dot_data)
Image(graph.create_png())
#graph.write_pdf('F:/codes/Python/EECS349/Project/iris.pdf')
```
> 参考链接
> https://blog.csdn.net/ydyang1126/article/details/78842952


2. 
