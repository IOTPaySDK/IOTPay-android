package com.iotpaycreditdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private static final String MSG = "MSG";
    private TextView editTextTextMultiLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        editTextTextMultiLine = findViewById(R.id.editTextTextMultiLine);
        init();

    }
    public static void startAction(Context context, String msg) {
        Intent intent = new Intent(context, ResultActivity.class);
        intent.putExtra(MSG, msg);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
    private void init(){
        String msg = (String) getIntent().getSerializableExtra(MSG);
        editTextTextMultiLine.setText(msg);
    }
    public void back(View v){
        finish();
    }
}