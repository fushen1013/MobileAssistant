package com.example.dell.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by dell on 2015/11/5.
 */
public class LoginActivity extends Activity {
    private Button btn_login,btn_reg;
    private EditText edt_account, edt_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Bmob.initialize(this,"5186b379b8f8c50c6868477758e8a2ee");
        initView();
    }

    private void initView(){
        edt_account = (EditText) findViewById(R.id.edt_account);
        edt_password = (EditText) findViewById(R.id.edt_password);
        btn_reg = (Button) findViewById(R.id.btn_reg);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegActivity.class);
                startActivity(intent);
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.setUsername(edt_account.getText().toString().trim());
                user.setPassword(edt_password.getText().toString().trim());
                user.login(LoginActivity.this, new SaveListener() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(LoginActivity.this, "????????", Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent2);
                    }

                    @Override
                    public void onFailure(int i, String s) {
                        Toast.makeText(LoginActivity.this, "?????¡ì¡ã?"+s, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }


}



