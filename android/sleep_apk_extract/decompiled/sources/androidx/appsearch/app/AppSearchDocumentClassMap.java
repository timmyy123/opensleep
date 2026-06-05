package androidx.appsearch.app;

import android.util.Log;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.ServiceLoader;

/* JADX INFO: loaded from: classes.dex */
public abstract class AppSearchDocumentClassMap {
    private static final String TAG = "AppSearchDocumentClassM";
    private static volatile Map<String, List<String>> sGlobalMap;
    private static final Object sLock = new Object();
    private static volatile Map<String, Class<?>> sCachedAppSearchClasses = new ArrayMap();

    private static Map<String, List<String>> buildGlobalMapLocked() {
        ServiceLoader serviceLoaderLoad = ServiceLoader.load(AppSearchDocumentClassMap.class, AppSearchDocumentClassMap.class.getClassLoader());
        ArrayMap arrayMap = new ArrayMap();
        Iterator it = serviceLoaderLoad.iterator();
        while (it.hasNext()) {
            for (Map.Entry<String, List<String>> entry : ((AppSearchDocumentClassMap) it.next()).getMap().entrySet()) {
                String key = entry.getKey();
                List arrayList = (List) arrayMap.get(key);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    arrayMap.put(key, arrayList);
                }
                arrayList.addAll(entry.getValue());
            }
        }
        for (K k : arrayMap.keySet()) {
            List list = (List) arrayMap.get(k);
            Objects.requireNonNull(list);
            arrayMap.put(k, Collections.unmodifiableList(list));
        }
        return Collections.unmodifiableMap(arrayMap);
    }

    private static Class<?> getAppSearchDocumentClass(String str) throws ClassNotFoundException {
        Class<?> cls;
        Object obj = sLock;
        synchronized (obj) {
            cls = sCachedAppSearchClasses.get(str);
        }
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str);
        synchronized (obj) {
            sCachedAppSearchClasses.put(str, cls2);
        }
        return cls2;
    }

    public static <T> Class<? extends T> getAssignableClassBySchemaName(Map<String, List<String>> map, String str, Class<T> cls) {
        List<String> list = map.get(str);
        if (list == null) {
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            String str2 = list.get(i);
            try {
                Class<?> appSearchDocumentClass = getAppSearchDocumentClass(str2);
                if (cls.isAssignableFrom(appSearchDocumentClass)) {
                    return (Class<? extends T>) appSearchDocumentClass.asSubclass(cls);
                }
                continue;
            } catch (ClassNotFoundException unused) {
                Log.w(TAG, "Failed to load document class \"" + str2 + "\". Perhaps the class was proguarded out?");
            }
        }
        return null;
    }

    public static Map<String, List<String>> getGlobalMap() {
        if (sGlobalMap == null) {
            synchronized (sLock) {
                try {
                    if (sGlobalMap == null) {
                        sGlobalMap = buildGlobalMapLocked();
                    }
                } finally {
                }
            }
        }
        return sGlobalMap;
    }

    public abstract Map<String, List<String>> getMap();
}
