训练自己的数据集的时候，如果ImageSet/Main下面的test.txt文件里面标注了正负样本，则生成lmdb文件的时候会因为1,-1的影响打不开图片

目前解决方法，保留正样本，把1去掉

也遇到了这上面所说的问题，通过这个博客完美解决了http://blog.csdn.net/10km/article/details/70144925
即windows与linux两个系统的换行不一样，test.txt文本如果是在windows下生成的，在linux下面开始使用的时候就会出问题。解决方法就是在create_list.sh脚本里面修改  sed -i "s/$/.jpg/g" $img_file 为 sed -i "s/\r$/.jpg/g" $img_file
(.xml文件也要这么修改)
