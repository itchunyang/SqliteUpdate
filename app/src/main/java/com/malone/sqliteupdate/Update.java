package com.malone.sqliteupdate;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by luchunyang on 2017/2/10.
 */

public interface Update {
    /**
     * 以后数据库版本每升级一次，就创建一个子类继承Upgrade类，实现update方法，在方法内执行你的业务逻辑，比如表结构变更;
     */
    public void update(SQLiteDatabase db);
}
