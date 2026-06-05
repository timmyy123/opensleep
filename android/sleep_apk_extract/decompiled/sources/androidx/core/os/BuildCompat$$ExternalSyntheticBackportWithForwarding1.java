package androidx.core.os;

import android.app.appfunctions.AppFunctionException;
import android.app.appfunctions.ExecuteAppFunctionResponse;
import android.app.appsearch.GenericDocument;
import android.os.Build;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class BuildCompat$$ExternalSyntheticBackportWithForwarding1 {
    public static /* synthetic */ int m() {
        int i = Build.VERSION.SDK_INT;
        return i < 36 ? i * 100000 : Build.VERSION.SDK_INT_FULL;
    }

    public static /* synthetic */ void m$1() {
    }

    public static /* synthetic */ AppFunctionException m(int i, String str, Bundle bundle) {
        return new AppFunctionException(i, str, bundle);
    }

    public static /* synthetic */ ExecuteAppFunctionResponse m(GenericDocument genericDocument, Bundle bundle) {
        return new ExecuteAppFunctionResponse(genericDocument, bundle);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m57m() {
    }
}
