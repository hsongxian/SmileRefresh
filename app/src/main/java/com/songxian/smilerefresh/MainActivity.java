package com.songxian.smilerefresh;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.song.refresh_view.PullToRefreshView;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private PullToRefreshView mRefreshView;
    private List<String> mData;
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }


    private void init() {

        mListView = (ListView)findViewById(R.id.list);
        mRefreshView = (PullToRefreshView) findViewById(R.id.refreshView);
        mRefreshView.setColorSchemeColors(Color.RED,Color.BLUE); // 颜色
//        mRefreshView.setSmileStrokeWidth(8); // 设置绘制的笑脸的宽度
//        mRefreshView.setSmileInterpolator(new LinearInterpolator()); // 笑脸动画转动的插值器
//        mRefreshView.setSmileAnimationDuration(2000); // 设置笑脸旋转动画的时长

        mRefreshView.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                requestData();
            }

        });

        mData = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            mData.add(String.valueOf(i));
        mAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mData);
        mListView.setAdapter(mAdapter);

    }


    private void requestData() {
        mRefreshView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mData.add(0, "新来的朋友");
                mAdapter.notifyDataSetChanged();
                mRefreshView.setRefreshing(false);
            }
        },5000);
    }
}
