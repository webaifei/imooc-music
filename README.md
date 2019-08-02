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
