*1. 不可以改app下面的build.gradle*
    
    指望着测试方便，就添加了一个debug的标签，结果发现一旦添加就会导致sdk注册不成功

*2. 导入curi的三个库时，发现如果是compile会编译超长的时间（30分钟），但如果是implementation会出错*
    
    直接把代码导入进去，而不是作为module调用

*3. 导入aar文件的时候，要分debug compile--给debug准备的和compile--release版本准备的*

*4. 导入project模块的方式*
    
    在module下的build.gradle中把项目改成library，然后修改library的androidminist.xml，再把applicationID给注释掉，去module目录下的androidmanifest把<meta-data>的DJI SDK Key给注释掉（会不会有安全隐患，遥感部分需要用key来做遥控嘛）；去需要添加依赖的module下的Androidmanifest，在application条目下添加tools:replace="android:name"-----至此应该基本完成了

*5. 改成library之后，不能使用switch语句*

    对于R.id.XXX这样的常量，不能够使用swicth语句（好像是因为涉及到动态编译的问题），对应的要全部修改成if else
