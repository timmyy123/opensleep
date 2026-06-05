package com.urbandroid.common;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public abstract class RecreateCounter {
    private static Map<Class, Long> lastRecreateTsMap = new HashMap();
    private static Map<Class, Integer> lastRecreateCountMap = new HashMap();

    public static boolean canRecreate(Class cls) {
        Long l = lastRecreateTsMap.get(cls);
        if (l != null && System.currentTimeMillis() - l.longValue() > 3000) {
            lastRecreateCountMap.put(cls, 0);
        }
        Integer num = lastRecreateCountMap.get(cls);
        return num == null || num.intValue() < 5;
    }

    public static void recreatedCalled(Class cls) {
        Long l = lastRecreateTsMap.get(cls);
        if (l == null || System.currentTimeMillis() - l.longValue() >= 3000) {
            lastRecreateCountMap.put(cls, 0);
        } else {
            Integer num = lastRecreateCountMap.get(cls);
            lastRecreateCountMap.put(cls, num == null ? 1 : Integer.valueOf(num.intValue() + 1));
        }
        lastRecreateTsMap.put(cls, Long.valueOf(System.currentTimeMillis()));
    }
}
