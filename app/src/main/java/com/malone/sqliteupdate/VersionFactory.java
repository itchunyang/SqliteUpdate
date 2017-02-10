package com.malone.sqliteupdate;

/**
 * Created by luchunyang on 2017/2/10.
 * 第一个版本
 */

public class VersionFactory {
    public static Update getUpdate(int i){
        Update update = null;
        switch (i){
            case 2:
                update = new VersionSecond();
                break;
            case 3:
                update = new VersionThree();
                break;
        }

        return update;
    }
}
