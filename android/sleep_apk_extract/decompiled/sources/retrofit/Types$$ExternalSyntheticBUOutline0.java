package retrofit;

import java.util.NoSuchElementException;
import org.json.hue.JSONException;
import twitter4j.TwitterException;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class Types$$ExternalSyntheticBUOutline0 {
    public static /* synthetic */ void m(String str, int i, Object obj, int i2, Object obj2) {
        throw new IllegalArgumentException(str + i + obj + i2 + obj2);
    }

    public static /* synthetic */ void m$1(String str, Object obj, Object obj2) {
        throw new IllegalArgumentException(str + obj + obj2);
    }

    public static /* synthetic */ void m$2(String str) {
        throw new RuntimeException(str);
    }

    public static /* synthetic */ void m(int i, Object obj, String str) {
        throw new IllegalArgumentException(str + i + obj);
    }

    public static /* synthetic */ void m$1(String str) {
        throw new NullPointerException(str);
    }

    public static /* synthetic */ void m(long j) {
        StringBuilder sb = new StringBuilder();
        sb.append(j);
        sb.append((Object) " is not a positive long value");
        throw new IllegalArgumentException(sb.toString());
    }

    public static /* synthetic */ void m(Exception exc) throws TwitterException {
        throw new TwitterException(exc);
    }

    public static /* synthetic */ void m(String str) {
        throw new NoClassDefFoundError(str);
    }

    public static /* synthetic */ void m() {
        throw new NoSuchElementException();
    }

    public static /* synthetic */ void m(String str, Object obj, Object obj2) {
        throw new JSONException(str + obj + obj2);
    }

    public static /* synthetic */ void m(String str, Object obj, Object obj2, Object obj3) {
        throw new IllegalArgumentException(str + obj + obj2 + obj3);
    }

    public static /* synthetic */ void m(String str, Throwable th) {
        throw new IllegalStateException(str, th);
    }
}
