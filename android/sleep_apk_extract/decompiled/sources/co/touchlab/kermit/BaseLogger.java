package co.touchlab.kermit;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J/\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lco/touchlab/kermit/BaseLogger;", "", "Lco/touchlab/kermit/LoggerConfig;", "config", "<init>", "(Lco/touchlab/kermit/LoggerConfig;)V", "Lco/touchlab/kermit/Severity;", SDKConstants.PARAM_DEBUG_MESSAGE_SEVERITY, "", "tag", "", "throwable", "message", "", "processLog", "(Lco/touchlab/kermit/Severity;Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V", "Lco/touchlab/kermit/LoggerConfig;", "getConfig", "()Lco/touchlab/kermit/LoggerConfig;", "kermit-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class BaseLogger {
    private final LoggerConfig config;

    public BaseLogger(LoggerConfig loggerConfig) {
        loggerConfig.getClass();
        this.config = loggerConfig;
    }

    public LoggerConfig getConfig() {
        return this.config;
    }

    public final void processLog(Severity severity, String tag, Throwable throwable, String message) {
        severity.getClass();
        tag.getClass();
        message.getClass();
        for (LogWriter logWriter : getConfig().getLogWriterList()) {
            if (logWriter.isLoggable(tag, severity)) {
                logWriter.log(severity, message, tag, throwable);
            }
        }
    }
}
