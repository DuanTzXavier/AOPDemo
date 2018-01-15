package com.tzduan.aopdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.tzduan.remix.annotation.MethodSpand;
import com.tzduan.remix.demo;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.test);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getString("toast");
            }
        });
        textView.setText("1");
        textView.setText(R.string.app_name);
    }

    public void getString(String a) {
        Toast.makeText(this, a, Toast.LENGTH_SHORT).show();
        Log.i("xxx", "toast");
        i();
    }

    @MethodSpand
    private void i() {
        demo.a();
    }
}
