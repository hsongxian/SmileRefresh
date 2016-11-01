# SmileRefresh


![这里写图片描述](http://img.blog.csdn.net/20161013202135750)


####描述:
	PullToRefreshView 是基于v4库的SwipeRefreshLayout上修改的动画的，SwipeRefreshLayout 有的方法PullToRefreshView 也有。
####引入：
 1.在Properties的build.gradle 添加
	
```java
allprojects {
    repositories {
        ......
        maven { url "https://jitpack.io" }

    }
}
```
 2.在Module的build.gradle 添加
```java
    compile 'com.github.songixan:SmileRefresh:1.1'

```

####用法：



 1. xml添加
	```html	
		<com.song.refresh_view.PullToRefreshView
		    xmlns:android="http://schemas.android.com/apk/res/android"
		    xmlns:tools="http://schemas.android.com/tools"
		    android:layout_width="match_parent"
		    android:layout_height="match_parent"
		    android:id="@+id/refreshView"
		    tools:context="com.songxian.smilerefresh.MainActivity">
		
		    <ListView
		        android:id="@+id/list"
		        android:layout_width="match_parent"
		        android:layout_height="match_parent"></ListView>
		
		</com.song.refresh_view.PullToRefreshView>
	```

 2. java设置

- 初始化

```java
		mRefreshView = (PullToRefreshView) findViewById(R.id.refreshView);
		mRefreshView.setColorSchemeColors(Color.RED,Color.BLUE); // 颜色
		mRefreshView.setSmileStrokeWidth(8); // 设置绘制的笑脸的宽度
		mRefreshView.setSmileInterpolator(new LinearInterpolator()); // 笑脸动画转动的插值器
		mRefreshView.setSmileAnimationDuration(2000); // 设置笑脸旋转动画的时长
				//设置下拉刷新监听
			mRefreshView.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() { 
			    @Override
			    public void onRefresh() {
			        requestData(); //请求数据
			    }
			
			});
```



- 刷新完成


```java
// 请求数据完成
 mRefreshView.setRefreshing(false);

```


博客：http://blog.csdn.net/qq_32464809/article/details/52809722
