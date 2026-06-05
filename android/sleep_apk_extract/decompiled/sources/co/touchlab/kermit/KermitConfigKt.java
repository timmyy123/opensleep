package co.touchlab.kermit;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¨\u0006\u0005"}, d2 = {"mutableLoggerConfigInit", "Lco/touchlab/kermit/MutableLoggerConfig;", "logWriters", "", "Lco/touchlab/kermit/LogWriter;", "kermit-core_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public abstract class KermitConfigKt {
    public static final MutableLoggerConfig mutableLoggerConfigInit(List<? extends LogWriter> list) {
        list.getClass();
        return new JvmMutableLoggerConfig(list);
    }
}
