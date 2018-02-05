# 2.5
## 机器学习相关
- Loss Function
```
在传统的二次cost function中,会出现误差越大,梯度下降越慢的情况,其速度最快是误差处于中间位置的情况
|
| 改进
|
交叉熵:当误差越大时,训练时的梯度也就越大,从而会加快训练的速度
```
参考[交叉熵代价函数](http://blog.csdn.net/u014313009/article/details/51043064)

- 批处理
```python
for i in range(1000):
    batch_xs, batch_ys = mnist.train.next_batch(100)
    sess.run(train_step, feed_dict={x: batch_xs, y_: batch_ys})
```
```
理想情况下，我们希望用我们所有的数据来进行每一步的训练，因为这能给我们更好的训练结果，但显然这需要很大的计算开销．所以，每一次训练我们可以使用不同的数据子集，这样做既可以减少计算开销，又可以最大化地学习到数据集的总体特性
```
- 权重初始化
```
初始化时应加入轻微噪声，
来打破对称性，防止零梯度的问题
```

## 语法相关

- placeholder
```
占位符,声明和使用分开.感觉是为了方便不需要在书写训练逻辑的时候就指定数据的值-形参
```

- reduce_sum
```
对于矩阵求和的一个扩增.reduce_sum(arg0,arg1). arg0表示输入的矩阵,arg1可不赋值或赋值为0/1. 0表示对矩阵纵向求和,1表示对矩阵横向求和. 不赋值则表示整体求和,输出一个值
```

- tf.train.GradientDescentOptimizer(0.01).minimize(cross_entropy)
```
感觉tensorflow真的是逆天哦,真适合自己进行训练
```
- argmax
```
返回一个向量中最大值的索引
```

- 交互回话 (InteractiveSession)
```
交互会话能让你在运行图的时候，插入一些构建计算图的操作。这能给使
用交互式文本 shell 如 iPython 带来便利。如果你没有使用 InteractiveSession 的话，你需
要在开始 session 和加载图之前，构建整个计算图
```
- tf.nn.conv2d(input, filter, strides, padding, use_cudnn_on_gpu=None, name=None)
```
第一个参数input：指需要做卷积的输入图像，它要求是一个Tensor，具有[batch, in_height, in_width, in_channels]这样的shape，具体含义是[训练时一个batch的图片数量, 图片高度, 图片宽度, 图像通道数]，注意这是一个4维的Tensor，要求类型为float32和float64其中之一

第二个参数filter：相当于CNN中的卷积核，它要求是一个Tensor，具有[filter_height, filter_width, in_channels, out_channels]这样的shape，具体含义是[卷积核的高度，卷积核的宽度，图像通道数，卷积核个数]，要求类型与参数input相同，有一个地方需要注意，第三维in_channels，就是参数input的第四维

第三个参数strides：卷积时在图像每一维的步长，这是一个一维的向量，长度4

第四个参数padding：string类型的量，只能是"SAME","VALID"其中之一，这个值决定了不同的卷积方式（后面会介绍）

第五个参数：use_cudnn_on_gpu:bool类型，是否使用cudnn加速，默认为true

结果返回一个Tensor，这个输出，就是我们常说的feature map，shape仍然是[batch, height, width, channels]这种形式。
```
[参考](https://www.cnblogs.com/qggg/p/6832342.html)

