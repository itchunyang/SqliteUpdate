package com.malone.sqliteupdate;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by luchunyang on 2017/2/10.
 */

public class VersionFactoryFinal {

    static Set<String> list = new LinkedHashSet<>();

    static {
        list.add("com.malone.sqliteupdate.VersionSecond");
        list.add("com.malone.sqliteupdate.VersionThree");
    }

    public static Update getUpdate(int i) {
        Update update = null;
        if (list != null && list.size() > 0) {
            try {
                for (String clsName : list) {
                    Class cls = Class.forName(clsName);

                    VersionCode code = (VersionCode) cls.getAnnotation(VersionCode.class);
                    if (code == null)
                        throw new IllegalStateException(cls.getName() + "类必须使用VersionCode类注解");
                    else {
                        if (i == code.value()) {
                            update = (Update) cls.newInstance();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return update;
    }

    public static int currentDbVersion() {
        return list.size() + 1;
    }
}
