package com.goo1e.smartbutiler.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.goo1e.smartbutiler.R;
import com.goo1e.smartbutiler.entity.MyUser;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

/**
 * 忘记或者重置密码
 * Created by SoftpaseFar on 2017/4/1.
 */

public class ForgetPasswordActivity extends BaseActivity implements View.OnClickListener {
    private Button btn_forget_password;
    private EditText et_email;

    //private EditText et_now;
    //private EditText et_new;
    // private EditText et_new_password;
    //private Button btn_update_password;
    //private EditText et_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        initView();
    }

    //初始化View
    private void initView() {
        btn_forget_password = (Button) findViewById(R.id.btn_forget_password);
        et_email = (EditText) findViewById(R.id.et_email);
        btn_forget_password.setOnClickListener(this);

        //et_now = (EditText) findViewById(et_now);
        //et_new = (EditText) findViewById(et_new);
        //et_name = (EditText) findViewById(et_name);
        //et_new_password = (EditText) findViewById(et_new_password);
        //btn_update_password = (Button) findViewById(btn_update_password);
        //btn_update_password.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_forget_password:
                //1.获取输入框的邮箱
                final String email = et_email.getText().toString().trim();
                //2.验证邮箱的合法性、是否为空
                if(!TextUtils.isEmpty(email)) {
                    //3.发送邮件
                    MyUser.resetPasswordByEmail(email, new UpdateListener() {
                        @Override
                        public void done(BmobException e) {
                            if(e == null) {
                                Toast.makeText(ForgetPasswordActivity.this, "邮件已发送至:" + email + "\n\t请查收", Toast.LENGTH_SHORT).show();
                                finish();
                            }else {
                                Toast.makeText(ForgetPasswordActivity.this, "邮箱发送失败", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else {
                    Toast.makeText(this, "输入框不能为空", Toast.LENGTH_SHORT).show();
                }
                break;
//            case btn_update_password:
//                //1.获取输入框的值
//                String name = et_name.getText().toString().trim();
//                String now = et_now.getText().toString().trim();
//                String news = et_new.getText().toString().trim();
//                String new_password = et_new_password.getText().toString().trim();
//                //2.判断是否为空
//                if(!TextUtils.isEmpty(name) & !TextUtils.isEmpty(now) & !TextUtils.isEmpty(news) & !TextUtils.isEmpty(new_password)) {
//                    //3.检验两次密码是否一致
//                    if(news.equals(new_password)) {
//                        //重置密码
//                        MyUser.updateCurrentUserPassword(now, news, new UpdateListener() {
//                            @Override
//                            public void done(BmobException e) {
//                                if(e == null) {
//                                    Toast.makeText(ForgetPasswordActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
//                                    finish();
//                                }else {
//                                    Toast.makeText(ForgetPasswordActivity.this, "修改失败", Toast.LENGTH_SHORT).show();
//                                }
//                            }
//                        });
//                    }else {
//                        Toast.makeText(this, "两次密码不一致", Toast.LENGTH_SHORT).show();
//                    }
//                }else {
//                    Toast.makeText(this, "输入框不能为空", Toast.LENGTH_SHORT).show();
//                }
//
//
//                //3.修改密码
//                break;
        }
    }
}
