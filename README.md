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