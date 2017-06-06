package com.goo1e.smartbutiler.ui;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.goo1e.smartbutiler.R;
import com.goo1e.smartbutiler.utils.UtilTools;

import java.util.ArrayList;
import java.util.List;

/**
 * 关于软件
 * Created by SoftpaseFar on 2017/4/14.
 */

public class AboutActivity extends BaseActivity {

    private ListView mListView;
    private List<String> mList = new ArrayList<>();
    private ArrayAdapter<String>mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        //去除阴影
        getSupportActionBar().setElevation(0);

        initView();
    }

    //初始化View
    private void initView() {
        mListView = (ListView) findViewById(R.id.mListView);

        mList.add("应用名称：" + getString(R.string.app_name));
        mList.add("版本号：" + UtilTools.getVersion(this));
        mList.add("官网：www.goo1e.com");

        mAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mList);
        //设置适配器
        mListView.setAdapter(mAdapter);
    }
}

