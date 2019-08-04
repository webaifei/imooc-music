# imooc 音乐实战

### 修改statusBar的颜色
1. 通过修改 res/values/styles.xml 中的colorPrimaryDark
```
<item name="colorPrimaryDark">@color/mainColor</item>
```
2. 通过设置android:statusBarColor 的值
```
// 优先级更高 默认值 继承自colorPrimaryDark
<item name="android:statusBarColor">#dddddd</item>
```

### navigationBar 的封装

### 组件复用
1. 使用 include
2. 使用 style 类似css的class
3. 使用自定义view


### 过场动画
1. 使用android:windowAnimationStyle 来自定义过场动画
2. 具体定义 查看anim下的动画文件

### RecycleView的使用
1. gradle引入
```
implementation 'com.android.support:recyclerview-v7:28.0.0'
```
2. layout文件中 增加RecycleView代码
```
<android.support.v7.widget.RecyclerView
    android:id="@+id/ms_types_list"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">
</android.support.v7.widget.RecyclerView>
```
3. activity中设置RecycleView
```
// 获取当前RecyclerView 引用
findViewById(R.id.ms_types_list);
// 设置显示形式 grid 还是list
setLayoutManager(new GridLayoutManager...)
// 实现adapter
new MyCustomAdapter();
// 使用adapter
setAdapter
// 设置间隔
addItemDecoration
```
### 权限
1. android:usesCleartextTraffic="true"  设置允许加载http资源
2. <uses-permission android:name="android.permission.INTERNET"/> 开启网络权限