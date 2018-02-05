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
