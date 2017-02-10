package com.malone.sqliteupdate;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by luchunyang on 2017/2/10.
 */

@VersionCode(2)
public class VersionSecond implements Update {
    public static final String TAG = "VersionSecond";

    @Override
    public void update(SQLiteDatabase db) {
        Log.i(TAG, "update: ");
        //数据库版本升级时会执行这个方法
        //第一步将表A重命名为temp_A
        //第二步创建新表A,此时表结构已加了2列
        //第三步讲temp_A表中的数据插入到表A
        //第四步删除临时表temp_A

    }
}
