package com.fxkxb.mycontentproviderexecutor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * 对user表进行操作
         */

        // 设置URI
        Uri uriUser = Uri.parse("content://com.fxkxb.mycontentprovider.provider/user");

        // 插入表中数据
        ContentValues values = new ContentValues();
        values.put("_id", 4);
        values.put("name", "Jordan");


        // 获取ContentResolver
        ContentResolver resolver =  getContentResolver();
        // 通过ContentResolver 根据URI 向ContentProvider中插入数据
        resolver.insert(uriUser,values);

        // 通过ContentResolver 向ContentProvider中查询数据
        Cursor cursor = resolver.query(uriUser, new String[]{"_id","name"}, null, null, null);
        while (cursor.moveToNext()){
            Log.e("TAG", "\"query book:\" + cursor.getInt(0) +\" \"+ cursor.getString(1)");
            // 将表中数据全部输出
        }
        cursor.close();
        // 关闭游标

        /**
         * 对job表进行操作
         */
        // 和上述类似,只是URI需要更改,从而匹配不同的URI CODE,从而找到不同的数据资源
        Uri uriJob = Uri.parse("content://com.fxkxb.mycontentprovider.provider/job");

        // 插入表中数据
        ContentValues values2 = new ContentValues();
        values2.put("_id", 4);
        values2.put("job", "NBA Player");

        // 获取ContentResolver
        ContentResolver resolver2 =  getContentResolver();
        // 通过ContentResolver 根据URI 向ContentProvider中插入数据
        resolver2.insert(uriJob,values2);

        // 通过ContentResolver 向ContentProvider中查询数据
        Cursor cursor2 = resolver2.query(uriJob, new String[]{"_id","job"}, null, null, null);
        while (cursor2.moveToNext()){

            // 将表中数据全部输出
            Log.e("TAG", "\"query job:\" + cursor2.getInt(0) +\" \"+ cursor2.getString(1)");
        }
        cursor2.close();
        // 关闭游标
    }
}