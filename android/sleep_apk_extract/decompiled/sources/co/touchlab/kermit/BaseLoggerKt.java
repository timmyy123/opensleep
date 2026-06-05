package co.touchlab.kermit;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\" \u0010\u0001\u001a\u00020\u00008\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0001\u0010\u0002\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004*\u0016\u0010\t\"\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0012\u0004\u0012\u00020\b0\u0007¨\u0006\n"}, d2 = {"Lco/touchlab/kermit/Severity;", "DEFAULT_MIN_SEVERITY", "Lco/touchlab/kermit/Severity;", "getDEFAULT_MIN_SEVERITY", "()Lco/touchlab/kermit/Severity;", "getDEFAULT_MIN_SEVERITY$annotations", "()V", "Lkotlin/Function0;", "", "MessageBlock", "kermit-core_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public abstract class BaseLoggerKt {
    private static final Severity DEFAULT_MIN_SEVERITY = Severity.Verbose;

    public static final Severity getDEFAULT_MIN_SEVERITY() {
        return DEFAULT_MIN_SEVERITY;
    }
}
