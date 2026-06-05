package twitter4j;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class TwitterObjectFactory {
    private static final ThreadLocal<Map> rawJsonMap = new ThreadLocal<Map>() { // from class: twitter4j.TwitterObjectFactory.1
        @Override // java.lang.ThreadLocal
        public Map initialValue() {
            return new HashMap();
        }
    };
    private static boolean registeredAtleastOnce = false;

    public static void clearThreadLocalMap() {
        rawJsonMap.get().clear();
    }

    public static <T> T registerJSONObject(T t, Object obj) {
        registeredAtleastOnce = true;
        rawJsonMap.get().put(t, obj);
        return t;
    }
}
