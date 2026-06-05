package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u0014\u0010\u0006\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0003¨\u0006\b"}, d2 = {"useK1Implementation", "", "getUseK1Implementation", "()Z", "newFakeOverridesImplementation", "getNewFakeOverridesImplementation", "loadMetadataDirectly", "getLoadMetadataDirectly", "kotlin-reflection"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class SystemPropertiesKt {
    private static final boolean loadMetadataDirectly;
    private static final boolean newFakeOverridesImplementation;
    private static final boolean useK1Implementation;

    static {
        Object objM2357constructorimpl;
        Object objM2357constructorimpl2;
        Object objM2357constructorimpl3;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM2357constructorimpl = Result.m2357constructorimpl(System.getProperty("kotlin.reflect.jvm.useK1Implementation"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM2357constructorimpl = Result.m2357constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m2362isFailureimpl(objM2357constructorimpl)) {
            objM2357constructorimpl = null;
        }
        String str = (String) objM2357constructorimpl;
        boolean z = false;
        useK1Implementation = str != null && Boolean.parseBoolean(str);
        try {
            objM2357constructorimpl2 = Result.m2357constructorimpl(System.getProperty("kotlin.reflect.jvm.newFakeOverridesImplementation"));
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objM2357constructorimpl2 = Result.m2357constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m2362isFailureimpl(objM2357constructorimpl2)) {
            objM2357constructorimpl2 = null;
        }
        String str2 = (String) objM2357constructorimpl2;
        newFakeOverridesImplementation = str2 != null && Boolean.parseBoolean(str2);
        try {
            objM2357constructorimpl3 = Result.m2357constructorimpl(System.getProperty("kotlin.reflect.jvm.loadMetadataDirectly"));
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.INSTANCE;
            objM2357constructorimpl3 = Result.m2357constructorimpl(ResultKt.createFailure(th3));
        }
        String str3 = (String) (Result.m2362isFailureimpl(objM2357constructorimpl3) ? null : objM2357constructorimpl3);
        if (str3 != null && Boolean.parseBoolean(str3)) {
            z = true;
        }
        loadMetadataDirectly = z;
    }

    public static final boolean getLoadMetadataDirectly() {
        return loadMetadataDirectly;
    }

    public static final boolean getNewFakeOverridesImplementation() {
        return newFakeOverridesImplementation;
    }

    public static final boolean getUseK1Implementation() {
        return useK1Implementation;
    }
}
