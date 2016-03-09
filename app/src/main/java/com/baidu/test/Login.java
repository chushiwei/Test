package com.baidu.test;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by Administrator on 2016/3/1 0001.
 */

public class Login extends AppCompatActivity {
    EditText editText, editText2;
    Button button;
    String url = "http://10.0.2.2:8080/wlz_project/LoginServlet";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        editText = (EditText) findViewById(R.id.tv);
        editText2 = (EditText) findViewById(R.id.t2);
        button = (Button) findViewById(R.id.bt);
        Log.i("tag","下种子");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                String psw = editText2.getText().toString();
                RequestParams requestParams = new RequestParams(url);
                requestParams.addParameter("txtName", name);
                requestParams.addParameter("txtPwd", psw);

                x.http().post(requestParams, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        if (result != null) {
                            try {
                                JSONObject object = new JSONObject(result);
                                String status = object.getString("status");
                                Toast.makeText(x.app(), status, Toast.LENGTH_LONG).show();
                            } catch (Exception e) {

                            }

                        }


                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        Toast.makeText(x.app(), "", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancelled(CancelledException cex) {

                    }

                    @Override
                    public void onFinished() {
                        Toast.makeText(x.app(), "", Toast.LENGTH_LONG).show();
                    }
                });

            }
        });


    }
}
