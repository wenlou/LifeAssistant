# 毕业设计—生活助手（Rxjva+RxAndroid+Retrofit）

----

### 简介
这是我的毕业设计———生活助手。它主要有以下功能：

 - [x] 登陆注册功能，采用邮箱注册，确认后才能登陆
 - [x] 新闻的展示和获取
 - [x] 当前天气情况，未来几小时天气情况，生活建议，一周七天概况
 - [x] 城市的选择
 - [x] 本地音乐播放
 - [x] 自动定位
 - [x] 缓存数据，减少网络请求，保证离线查看
 - [x] 时钟以及秒表功能
 - [x] 附近美食展示
 - [x] 美食评论功能
 - [x] 日程提醒

---

### 权限
```
	<!--用于进行网络定位-->
	<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>
	<!--用于访问GPS定位-->
	<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
	<!--获取运营商信息，用于支持提供运营商信息相关的接口-->
	<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
	<!--用于访问wifi网络信息，wifi信息会用于进行网络定位-->
	<uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>
	<!--这个权限用于获取wifi的获取权限，wifi信息会用来进行网络定位-->
	<uses-permission android:name="android.permission.CHANGE_WIFI_STATE"/>
	<!--用于访问网络，网络定位需要上网-->
	<uses-permission android:name="android.permission.INTERNET"/>
	<!--用于读取手机当前的状态-->
	<uses-permission android:name="android.permission.READ_PHONE_STATE"/>
	<!--写入扩展存储，向扩展卡写入数据，用于写入缓存定位数据-->
	<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
	<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>

```

---
### 项目

### 主要技术
- Base基础类的封装，toolbar封装，错误页面及加载页面，未登录页面封装；
- Rxjava + Retrofit + Okhttp 封装网络请求 ;
- leancloud用户管理系统及动态管理系统;
- eventBus事件总线的使用;
- PhotoPicker图片选择器;
- 自定义加载对话框及提示框等等;

#### 公开 API

- 天气数据来源于：和风天气
- 城市信息来源于：CSDN
- 地理定位服务： 百度地图
- 新闻来源：聚合数据
- 后台支持：LearnCloud
- 天气背景图：bing每日壁纸
- 附近餐厅信息：百度地图sdk


### 截图

![][image-1]
![][image-2]
![][image-3]
![][image-4]
![][image-5]

----
#### 开源技术
1. [Rxjava][2]
2. [RxAndroid][3]
3. [Retrofit][4]
4. [GLide][5]
5. [ASimpleCache][6]







[2]:	https://github.com/ReactiveX/RxJava
[3]:	https://github.com/ReactiveX/RxAndroid
[4]:	https://github.com/square/retrofit
[5]:	https://github.com/bumptech/glide
[6]:	https://github.com/yangfuhai/ASimpleCache
[image-1]:	/images/1.png
[image-2]:	/images/2.png
[image-3]:	/images/3.png
[image-4]:	/images/4.png
[image-5]:	/images/5.png

