# Survey汇报

- Lyrebird:[demo音频](https://twitter.com/search?q=from%3ALyrebirdAI%20to%3ABarackObama%20OR%20to%3ArealDonaldTrump)
```
一个国外的API, 没有深入测试,听了demo音频,感觉效果不好(机械音比较明显)
```

- [Ekho](http://www.eguidedog.net/ekho.php)
```
开源的中文语音合成软件,支持粤语, 普通话, 诏安客语, 藏语. 
```

- [WaveNet](https://deepmind.com/blog/wavenet-generative-model-raw-audio/),[Deep Voice](http://research.baidu.com/deep-voice-3-2000-speaker-neural-text-speech/)
```
都是最近两年的论文,据说效果很好,但是均未开源
```

- [deep-voice-conversion](https://github.com/andabi/deep-voice-conversion)
```
第一轮学习:用普遍的语音库进行训练,从而学习发音的基本特征
第二轮学习:通过Kate Winslet的2小时audio book学习该人的语音语调,进行定制化操作
```
### 缺点
1. 没有Train好的model,如果想要使用就要自己从头训练
2. 该项目目前所训练的都是英文语料库,不知道如果要生成中文的语音,效果会如何

- [Merlin](https://github.com/CSTR-Edinburgh/merlin)
```
都说这个工具包很好用,也从网上看到了两个教程(http://shartoo.github.io/merlin-tts/ , https://sentiment-mining.blogspot.my/2017/07/merlin.html).
```
### 缺点
1. 操作起来很复杂,尤其是准备数据集这一块.一方面需要自己label想要转化成的声音,其次还需要准备好像deep-voice-conversion第一阶段的训练材料,而第二个链接中提到的中文语速库,链接失效了,好像不能用
2. 第二阶段的数据集,目前想到的是将林志玲的影视作品的声音截取下来,但不知这样是否会涉及到侵权
