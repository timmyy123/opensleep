package androidx.webkit;

import com.facebook.internal.AnalyticsEvents;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class WebMessageCompat {
    private final byte[] mArrayBuffer;
    private final WebMessagePortCompat[] mPorts;
    private final String mString;
    private final int mType;

    public WebMessageCompat(byte[] bArr, WebMessagePortCompat[] webMessagePortCompatArr) {
        Objects.requireNonNull(bArr);
        this.mArrayBuffer = bArr;
        this.mString = null;
        this.mPorts = webMessagePortCompatArr;
        this.mType = 1;
    }

    private void checkType(int i) {
        if (i == this.mType) {
            return;
        }
        Events$$ExternalSyntheticBUOutline0.m("Wrong data accessor type detected. ", typeToString(this.mType), " expected, but got ", typeToString(i));
    }

    private String typeToString(int i) {
        return i != 0 ? i != 1 ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN : "ArrayBuffer" : "String";
    }

    public String getData() {
        checkType(0);
        return this.mString;
    }

    public WebMessageCompat(String str, WebMessagePortCompat[] webMessagePortCompatArr) {
        this.mString = str;
        this.mArrayBuffer = null;
        this.mPorts = webMessagePortCompatArr;
        this.mType = 0;
    }
}
