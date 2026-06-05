package androidx.appsearch.app;

import android.util.Log;
import androidx.appsearch.exceptions.AppSearchException;
import androidx.core.util.ObjectsCompat;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class AppSearchResult<ValueType> {
    private final String mErrorMessage;
    private final int mResultCode;
    private final ValueType mResultValue;

    private AppSearchResult(int i, ValueType valuetype, String str) {
        this.mResultCode = i;
        this.mResultValue = valuetype;
        this.mErrorMessage = str;
    }

    public static <ValueType> AppSearchResult<ValueType> newFailedResult(int i, String str) {
        return new AppSearchResult<>(i, null, str);
    }

    public static <ValueType> AppSearchResult<ValueType> newSuccessfulResult(ValueType valuetype) {
        return new AppSearchResult<>(0, valuetype, null);
    }

    public static <ValueType> AppSearchResult<ValueType> throwableToFailedResult(Throwable th) {
        boolean z = th instanceof AppSearchException;
        if (!z || ((AppSearchException) th).getResultCode() != 6) {
            Log.w("AppSearchResult", "Converting throwable to failed result.", th);
        }
        if (z) {
            return ((AppSearchException) th).toAppSearchResult();
        }
        String simpleName = th.getClass().getSimpleName();
        int i = ((th instanceof IllegalStateException) || (th instanceof NullPointerException)) ? 2 : th instanceof IllegalArgumentException ? 3 : th instanceof IOException ? 4 : th instanceof SecurityException ? 8 : 1;
        StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(simpleName, ": ");
        sbM.append(th.getMessage());
        return newFailedResult(i, sbM.toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppSearchResult)) {
            return false;
        }
        AppSearchResult appSearchResult = (AppSearchResult) obj;
        return this.mResultCode == appSearchResult.mResultCode && ObjectsCompat.equals(this.mResultValue, appSearchResult.mResultValue) && ObjectsCompat.equals(this.mErrorMessage, appSearchResult.mErrorMessage);
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    public ValueType getResultValue() {
        if (isSuccess()) {
            return this.mResultValue;
        }
        Home$$ExternalSyntheticBUOutline0.m$2("AppSearchResult is a failure: ", this);
        return null;
    }

    public int hashCode() {
        return ObjectsCompat.hash(Integer.valueOf(this.mResultCode), this.mResultValue, this.mErrorMessage);
    }

    public boolean isSuccess() {
        return getResultCode() == 0;
    }

    public String toString() {
        if (isSuccess()) {
            return "[SUCCESS]: " + this.mResultValue;
        }
        return "[FAILURE(" + this.mResultCode + ")]: " + this.mErrorMessage;
    }
}
