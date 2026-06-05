package co.touchlab.kermit;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\"\u0014\u0010\u0001\u001a\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005\"$\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"", "lock", "Ljava/lang/Object;", "", "internalDefaultTag", "Ljava/lang/String;", SDKConstants.PARAM_VALUE, "getDefaultTag", "()Ljava/lang/String;", "setDefaultTag", "(Ljava/lang/String;)V", "defaultTag", "kermit_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public abstract class DefaultsJVMKt {
    private static volatile String internalDefaultTag = "";
    private static final Object lock = new Object();

    public static final String getDefaultTag() {
        return internalDefaultTag;
    }
}
