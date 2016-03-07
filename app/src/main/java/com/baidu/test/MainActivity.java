package com.baidu.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.xutils.common.Callback;
import org.xutils.http.HttpMethod;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class MainActivity extends AppCompatActivity {

    EditText editText, editText2;
    Button button;
    String url = "http://10.0.2.2:8080/wlz_project/ModifyUser?t=add";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.tv);
        editText2 = (EditText) findViewById(R.id.t2);
        button = (Button) findViewById(R.id.bt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                String psw = editText2.getText().toString();

// xutlis的post方式传值
                RequestParams params = new RequestParams(url);

                params.addParameter("txtUser", name);
                params.addParameter("txtPwd", psw);
                params.addParameter("txtJf", 100);
                params.addParameter("txtYe", 100);
                params.addParameter("txtQd", 100);
                params.addParameter("txtRw", 100);
                params.addParameter("txtHb", 100);
                x.http().post(params, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {

                        Toast.makeText(x.app(), "注册成功", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(MainActivity.this
                                , Login.class));
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        Toast.makeText(x.app(), "注册error", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancelled(CancelledException cex) {

                    }

                    @Override
                    public void onFinished() {
                        Toast.makeText(x.app(), "注册over", Toast.LENGTH_LONG).show();
                    }
                });

            }
        });

    }
}
