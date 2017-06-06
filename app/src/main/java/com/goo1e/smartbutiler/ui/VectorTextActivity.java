package com.goo1e.smartbutiler.ui;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.goo1e.smartbutiler.R;

/**
 * Vectordrawable测试
 * Created by SoftpaseFar on 2017/4/8.
 */

public class VectorTextActivity extends BaseActivity implements View.OnClickListener {


    private ImageView iv_vectorAn;

    private ImageView iv_color_hart;

    private ImageView iv_bar_search;

    private ImageView tv_path_in;
    private ImageView tv_path_out;

    private ImageView tv_five_star;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vector_text);

        initView();
    }

    private void initView() {
        iv_vectorAn = (ImageView) findViewById(R.id.iv_vectorAn);
        iv_vectorAn.setOnClickListener(this);
        iv_color_hart = (ImageView) findViewById(R.id.iv_color_hart);
        iv_color_hart.setOnClickListener(this);
        iv_bar_search = (ImageView) findViewById(R.id.iv_bar_search);
        iv_bar_search.setOnClickListener(this);
        tv_path_in = (ImageView) findViewById(R.id.tv_path_in);
        tv_path_in.setOnClickListener(this);
        tv_path_out = (ImageView) findViewById(R.id.tv_path_out);
        tv_path_out.setOnClickListener(this);
        tv_five_star = (ImageView) findViewById(R.id.tv_five_star);
        tv_five_star.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_vectorAn:
                startAct(view);
                break;
            case R.id.iv_color_hart:
                startAct(view);
                break;
            case R.id.iv_bar_search:
                startAct(view);
                break;
            case R.id.tv_path_in:
                startAct(view);
                break;
            case R.id.tv_path_out:
                startAct(view);
                break;
            case R.id.tv_five_star:
                ImageView iv_fiv_sta = (ImageView) view;
                AnimatedVectorDrawable drawable_vector_anmi_fivestar = (AnimatedVectorDrawable) getDrawable(R.drawable.vector_anmi_fivestar);
                iv_fiv_sta.setImageDrawable(drawable_vector_anmi_fivestar);
                if (drawable_vector_anmi_fivestar != null) {
                    drawable_vector_anmi_fivestar.start();
                }
                break;
        }

    }

    private void startAct(View view) {
        ImageView v = (ImageView) view;
        Drawable drawable = v.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
    }

}
