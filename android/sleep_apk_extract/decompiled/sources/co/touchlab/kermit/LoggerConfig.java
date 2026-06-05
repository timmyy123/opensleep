package co.touchlab.kermit;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lco/touchlab/kermit/LoggerConfig;", "", "logWriterList", "", "Lco/touchlab/kermit/LogWriter;", "getLogWriterList", "()Ljava/util/List;", "minSeverity", "Lco/touchlab/kermit/Severity;", "getMinSeverity", "()Lco/touchlab/kermit/Severity;", "kermit-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface LoggerConfig {
    List<LogWriter> getLogWriterList();

    Severity getMinSeverity();
}
