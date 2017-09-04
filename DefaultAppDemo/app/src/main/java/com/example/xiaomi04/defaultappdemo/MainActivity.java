package com.example.xiaomi04.defaultappdemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserHandle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.net.URL;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mSendMsgBtn = (Button) findViewById(R.id.mySendMsgBtn);
        mSendMsgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri smsToUri = Uri.parse("smsto:10086");
                Intent mIntent = new Intent( android.content.Intent.ACTION_SENDTO, smsToUri );
                mIntent.putExtra("sms_body", "The SMS text");
                startActivity(mIntent);
            }
        });

        Button mOpenBrowser = (Button) findViewById(R.id.myBrowserBtn);
        mOpenBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri content_url = Uri.parse("http://www.baidu.com");
                intent.setData(content_url);
                startActivity(intent);
            }
        });

        Button mOpenMail = (Button) findViewById(R.id.myMailBtn);
        mOpenMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("mailto:" + "1111111@qq.com");
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                startActivity(intent);
            }
        });

        Button mOpenGallery = (Button) findViewById(R.id.myGellaryBtn);
        mOpenGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 2);
//                Intent intent = new Intent(Intent.ACTION_PICK);
//                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
//                startActivity(intent);
            }
        });

        Button mOpenCalendar = (Button) findViewById(R.id.myCalendarBtn);
        mOpenCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_APP_CALENDAR);
                startActivity(intent);
            }
        });

        final TextView mOpenMailLink = (TextView) findViewById(R.id.myEmailLink);
        mOpenMailLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + mOpenMailLink.getText().toString()));
                startActivity(intent);
            }
        });
    }
}