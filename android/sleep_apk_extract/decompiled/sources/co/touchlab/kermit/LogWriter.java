package co.touchlab.kermit;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J,\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&¨\u0006\u000e"}, d2 = {"Lco/touchlab/kermit/LogWriter;", "", "()V", "isLoggable", "", "tag", "", SDKConstants.PARAM_DEBUG_MESSAGE_SEVERITY, "Lco/touchlab/kermit/Severity;", "log", "", "message", "throwable", "", "kermit-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class LogWriter {
    public boolean isLoggable(String tag, Severity severity) {
        tag.getClass();
        severity.getClass();
        return true;
    }

    public abstract void log(Severity severity, String message, String tag, Throwable throwable);
}
