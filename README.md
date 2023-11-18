# 讯飞Retro2

![](/app/src/main/res/mipmap-xhdpi/ic_launcher.png)

通过Xposed模块将键盘上的F3（输入法切换）和F4（字符输入）映射到了#和*按键上。本模块要求系统必须支持Xposed，而且版本号最低为Api.33

## 食用方法

- 直接运行

前往 release 页面下载文件，解压后执行：`adb install xxx.apk` (xxx替换成文件名)，然后在xposed里打开模块并重启输入法。

- 自己编译

下载本Repo后在Android Studio打开即可。

## 注意

**特别的，只测试了讯飞输入法ZTE定制版，版本号（V8.0.6855_01430818/201811151511）。其他版本不确定能正常运行。**

**本程序造成的后果与本人无关。**
