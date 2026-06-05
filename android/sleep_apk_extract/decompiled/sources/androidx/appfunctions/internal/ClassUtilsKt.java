package androidx.appfunctions.internal;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.FacebookSdk$$ExternalSyntheticLambda1;
import kotlin.Metadata;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a1\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"findImpl", "T", "", "Ljava/lang/Class;", "prefix", "", "suffix", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "appfunctions"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ClassUtilsKt {
    public static final <T> T findImpl(Class<T> cls, String str, String str2) {
        cls.getClass();
        str.getClass();
        str2.getClass();
        String packageName = cls.getPackageName();
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Required value was null.");
            return null;
        }
        String strM$1 = FileInsert$$ExternalSyntheticOutline0.m$1(str, canonicalName.substring(packageName.length() + 1), str2);
        try {
            Class<?> cls2 = Class.forName(packageName + '.' + strM$1, true, cls.getClassLoader());
            cls2.getClass();
            T t = (T) cls2.getDeclaredConstructor(null).newInstance(null);
            t.getClass();
            return t;
        } catch (ClassNotFoundException e) {
            FacebookSdk$$ExternalSyntheticLambda1.m("Cannot find implementation for ", cls.getCanonicalName(), ". ", strM$1, " does not exist. Is AppFunction annotation processor correctly configured?", e);
            return null;
        } catch (IllegalAccessException e2) {
            FacebookSdk$$ExternalSyntheticLambda1.m(e2, cls.getCanonicalName(), "Cannot access the constructor ");
            return null;
        } catch (InstantiationException e3) {
            FacebookSdk$$ExternalSyntheticLambda1.m(e3, cls.getCanonicalName(), "Failed to create an instance of ");
            return null;
        }
    }
}
