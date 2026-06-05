package co.touchlab.kermit;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR$\u0010\u0011\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R0\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0006¨\u0006\u0016"}, d2 = {"Lco/touchlab/kermit/JvmMutableLoggerConfig;", "Lco/touchlab/kermit/MutableLoggerConfig;", "", "Lco/touchlab/kermit/LogWriter;", "logWriters", "<init>", "(Ljava/util/List;)V", "Lco/touchlab/kermit/Severity;", "_minSeverity", "Lco/touchlab/kermit/Severity;", "_loggerList", "Ljava/util/List;", SDKConstants.PARAM_VALUE, "getMinSeverity", "()Lco/touchlab/kermit/Severity;", "setMinSeverity", "(Lco/touchlab/kermit/Severity;)V", "minSeverity", "getLogWriterList", "()Ljava/util/List;", "setLogWriterList", "logWriterList", "kermit-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class JvmMutableLoggerConfig implements MutableLoggerConfig {
    private volatile List<? extends LogWriter> _loggerList;
    private volatile Severity _minSeverity;

    public JvmMutableLoggerConfig(List<? extends LogWriter> list) {
        list.getClass();
        this._minSeverity = BaseLoggerKt.getDEFAULT_MIN_SEVERITY();
        this._loggerList = list;
    }

    @Override // co.touchlab.kermit.LoggerConfig
    public List<LogWriter> getLogWriterList() {
        return this._loggerList;
    }

    @Override // co.touchlab.kermit.LoggerConfig
    /* JADX INFO: renamed from: getMinSeverity, reason: from getter */
    public Severity get_minSeverity() {
        return this._minSeverity;
    }
}
