package com.goo1e.smartbutiler.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.goo1e.smartbutiler.R;

/**
 * BezierText
 * Created by SoftpaseFar on 2017/4/9.
 */

public class BezierTextActivity extends BaseActivity implements View.OnClickListener {

    private Button btn_bezier_second_text;
    private Button btn_bezier_third_text;
    private Button btn_bezier_using_text;
    private Button btn_bezier_wave_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bezier_line_text);
        initView();
    }

    private void initView() {
        btn_bezier_second_text = (Button) findViewById(R.id.btn_bezier_second_text);
        btn_bezier_second_text.setOnClickListener(this);
        btn_bezier_third_text = (Button) findViewById(R.id.btn_bezier_third_text);
        btn_bezier_third_text.setOnClickListener(this);
        btn_bezier_using_text = (Button) findViewById(R.id.btn_bezier_using_text);
        btn_bezier_using_text.setOnClickListener(this);
        btn_bezier_wave_text = (Button) findViewById(R.id.btn_bezier_wave_text);
        btn_bezier_wave_text.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_bezier_second_text:
                startActivity(new Intent(this, SecondBezierTextActivity.class));
                break;
            case R.id.btn_bezier_third_text:
                startActivity(new Intent(this, ThirdBezierTextActivity.class));
                break;
            case R.id.btn_bezier_using_text:
                startActivity(new Intent(this, UsingBezierTextActivity.class));
                break;
            case R.id.btn_bezier_wave_text:
                startActivity(new Intent(this, WaveBezierTextActivity.class));
                break;
        }
    }
}
