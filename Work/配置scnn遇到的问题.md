**配置scnn遇到的问题**
====
*0. 环境*
    
    Theano环境，今天刚在192.168.1.164上部署成功

*1. test_scnn.py 路径*

    把里面的相对路径全部改成绝对路径。我也不知道为什么要改，但真的是改完之后就不会报“No such file 了”
    
    吐槽：这真是一个，非常奇怪的问题

*2. Theano与Lasagne记得升级*
    
    报错：TypeError: __init__() got an unexpected keyword argument 'flip_filters'
    
    检查发现是这些库升级了，所以需要升级
    pip install --upgrade https://github.com/Theano/Theano/archive/master.zip
    pip install --upgrade https://github.com/Lasagne/Lasagne/archive/master.zip
    
    参考：https://github.com/Lasagne/Lasagne/issues/636
    下载速度比较慢，可以先下载下载下来，然后本地安装
 
 
 *3. Theano升级后记得修改配置文件*
 
      报错：
      You are tring to use the old GPU back-end. '
      ValueError: You are tring to use the old GPU back-end. It was removed from Theano. Use device=cuda* now.
      
      解决方案:
      sudo vi ~/.theanorc
      把device=gpu改成device=cuda
      参考：https://stackoverflow.com/questions/44765376/valueerror-you-are-trying-to-use-the-old-gpu-back-end-when-importing-keras
  
  *4. 不知道改啥*
  
       报错：
       ERROR (theano.gpuarray): pygpu was configured but could not be imported or is too old (version 0.7 or higher required)
       Traceback (most recent call last):
       File "/usr/local/lib/python2.7/dist-packages/theano/gpuarray/__init__.py", line 21, in <module>
        import pygpu
       ImportError: No module named pygpu
      
       可能的解决方案：https://github.com/Theano/libgpuarray/issues/393
       
       (也有可能是因为自己没装pygpu，刚装上，http://deeplearning.net/software/libgpuarray/installation.html)
       
  *5. 执行一下，会有惊喜*
        
        sudo ldconfig /usr/local/cuda-8.0/lib64
