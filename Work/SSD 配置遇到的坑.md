*1. scp命令行*
    
    因为Linux下载数据集速度太慢，改用windows迅雷下载，之后发现不知该如何传输数据集。询问Zeke后得知可以使用scp命令来实现（windows可以用FileZilla直接传输）

*2. caffe要从根目录下运行*

    在配置cifar10 的时候，出现下列错误。
    ubuntu@medilab-template:~/caffe/examples/cifar10$ ./create_cifar10.sh 
    Creating lmdb...
    ./create_cifar10.sh: 13: ./create_cifar10.sh: ./build/examples/cifar10/convert_cifar_data.bin: not found

    查阅后得知，不能直接从脚本所在位置启动，而应该从caffe的根目录启动，然后再开始执行脚本

    PS:真是个奇葩的设定。。。

    （包括后面运行自己选定的数据集的时候，都会出现这样的情况，几乎所有的脚本都要从caffe的根目录开始执行才行。考虑到这些脚本基本都涉及文件的创建，猜测可能是权限管理的原因）

*3. caffe编译时无法找到opencv*

    在编译SSD的时候，出现了undefined reference to cv::imread(cv::String const&, int)’ 这样的错误，一开始我以为是opencv没有安装，还用apt-get命令安装了一下。但是后来检测版本的时候发现已经装过了3.2.0.

    查询后得知，是需要配置makefile文件才可以成功编译
    搜索关键字“PYTHON_”，在其前面添加：

    LIBRARIES += glog gflags protobuf leveldb snappy \
    lmdb boost_system hdf5_hl hdf5 m \
    opencv_core opencv_highgui opencv_imgproc opencv_imgcodecs

    此外我发现还有一处需要修改的地方是在“Makefile.config”里面的“opencv：3”的注释取消掉---技术支持来自zeke

    参考：http://blog.csdn.net/yhl_leo/article/details/52150781
 
 *4 caffe 编译./data/VOC0712/create_list.sh出错*
 
    ubuntu@medilab-template:~/ssd/caffe$ sudo ./data/VOC0712/create_list.sh 
    [sudo] password for ubuntu: 
    Create list for VOC2007 trainval...
    Create list for VOC2012 trainval...
    perl: warning: Setting locale failed.
    perl: warning: Please check that your locale settings:
	    LANGUAGE = (unset),
        LC_ALL = (unset),
        LC_PAPER = "zh_CN.UTF-8",
        LC_ADDRESS = "zh_CN.UTF-8",
        LC_MONETARY = "zh_CN.UTF-8",
        LC_NUMERIC = "zh_CN.UTF-8",
        LC_TELEPHONE = "zh_CN.UTF-8",
        LC_IDENTIFICATION = "zh_CN.UTF-8",
        LC_MEASUREMENT = "zh_CN.UTF-8",
        LC_TIME = "zh_CN.UTF-8",
        LC_NAME = "zh_CN.UTF-8",
        LANG = "en_US.UTF-8"
        are supported and installed on your system.
    perl: warning: Falling back to the standard locale ("C").
    Create list for VOC2007 test...
    libdc1394 error: Failed to initialize libdc1394
    I1114 09:22:49.067718 29680 get_image_size.cpp:61] A total of 4952 images.
    terminate called after throwing an instance of 'std::runtime_error'
      what():  locale::facet::_S_create_c_locale name not valid
    ./data/VOC0712/create_list.sh: line 6: 29680 Aborted                 (core dumped) $bash_dir/../../build/tools/get_image_size $root_dir $dst_file $bash_dir/$dataset"_name_size.txt"
    
    一开始觉得错在libdc1394（如果是opencv，那我只剩下重新编译opencv没有尝试了），现在觉得是语言设定的问题。。。还没解决
    
    
    编码问题，要把编码全部改为en_US.UTF-8
    https://wiki.ubuntu.com.cn/%E4%BF%AE%E6%94%B9locale
    打开/etc/default/locale，添加内容
    LANG=en_US.UTF-8
	LANGUAGE=en_US:en
	LC_CTYPE=en_US.UTF-8
	LC_NUMERIC=en_US.UTF-8
	LC_TIME=en_US.UTF-8
	LC_COLLATE=en_US.UTF-8
	LC_MONETARY=en_US.UTF-8
	LC_MESSAGES=en_US.UTF-8
	LC_PAPER=en_US.UTF-8
	LC_NAME=en_US.UTF-8
	LC_ADDRESS=en_US.UTF-8
	LC_TELEPHONE=en_US.UTF-8
	LC_MEASUREMENT=en_US.UTF-8
	LC_IDENTIFICATION=en_US.UTF-8
	LC_ALL=
    
  *5. create_data.sh,'module' object has no attribute 'LabelMap'*
  	
	https://github.com/weiliu89/caffe/issues/4
  
  *6. MobileNet-SSD配置*
  	记得修改demo.py这个文件，把“net_file”,caffe_model的位置改成绝对路径
