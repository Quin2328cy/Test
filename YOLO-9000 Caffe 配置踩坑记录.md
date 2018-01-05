# YOLO-9000 地址
  https://github.com/karta0807913/caffe-yolo-9000
 

## 1.需要VOC07+12 test+train数据集（之前没有2012的test数据集，真大，1.7G）

## 2. 编译的时候需要在cmake/Cuda.cmake Line 150 行中加入 "-std=c++11" 的标志，否则编译会报错。另外需要使用"mkdir build && cd build, cmake ..以及 make"的命令来编译

## 3.运行data/yolo/convert.sh时，需要手动创建lmdb文件夹，否则运行不好（这个是真的坑，居然还需要手动创建文件夹）
