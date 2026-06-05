package com.google.devtools.ksp.processing;

import com.google.devtools.ksp.symbol.KSNode;
import kotlin.Metadata;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\t\u0010\b¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/google/devtools/ksp/processing/KSPLogger;", "", "", "message", "Lcom/google/devtools/ksp/symbol/KSNode;", "symbol", "", "info", "(Ljava/lang/String;Lcom/google/devtools/ksp/symbol/KSNode;)V", "error", "api"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface KSPLogger {
    static /* synthetic */ void info$default(KSPLogger kSPLogger, String str, KSNode kSNode, int i, Object obj) {
        if (obj != null) {
            Utf8$$ExternalSyntheticBUOutline0.m("Super calls with default arguments not supported in this target, function: info");
            return;
        }
        if ((i & 2) != 0) {
            kSNode = null;
        }
        kSPLogger.info(str, kSNode);
    }

    void error(String message, KSNode symbol);

    void info(String message, KSNode symbol);
}
