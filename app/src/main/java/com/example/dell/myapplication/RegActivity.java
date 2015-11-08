package com.example.dell.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.listener.SaveListener;

/**
 * Created by dell on 2015/11/5.
 */
public class RegActivity extends Activity {
    private Button btn_login,btn_reg;
    private EditText edt_account, edt_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        initView();
    }

    private void initView() {
        edt_account = (EditText) findViewById(R.id.edt_account);
        edt_password = (EditText) findViewById(R.id.edt_password);
        btn_reg = (Button) findViewById(R.id.btn_reg);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegActivity.this,RegActivity.class);
                startActivity(intent);
            }
        });
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.setUsername(edt_account.getText().toString().trim());
                user.setPassword(edt_password.getText().toString().trim());
                user.setInfo("个人移动助理用户");
                user.signUp(RegActivity.this, new SaveListener() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(RegActivity.this,"注册成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(int i, String s) {
                        Toast.makeText(RegActivity.this, "注册失败"+s,Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
