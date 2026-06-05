package com.google.devtools.ksp.processing;

import com.google.devtools.ksp.symbol.KSAnnotated;
import com.google.devtools.ksp.symbol.KSName;
import kotlin.Metadata;
import kotlin.sequences.Sequence;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J'\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH'¢\u0006\u0004\b\u000b\u0010\f¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/google/devtools/ksp/processing/Resolver;", "", "", "annotationName", "", "inDepth", "Lkotlin/sequences/Sequence;", "Lcom/google/devtools/ksp/symbol/KSAnnotated;", "getSymbolsWithAnnotation", "(Ljava/lang/String;Z)Lkotlin/sequences/Sequence;", "Lcom/google/devtools/ksp/symbol/KSName;", "getModuleName", "()Lcom/google/devtools/ksp/symbol/KSName;", "api"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface Resolver {
    static /* synthetic */ Sequence getSymbolsWithAnnotation$default(Resolver resolver, String str, boolean z, int i, Object obj) {
        if (obj != null) {
            Utf8$$ExternalSyntheticBUOutline0.m("Super calls with default arguments not supported in this target, function: getSymbolsWithAnnotation");
            return null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return resolver.getSymbolsWithAnnotation(str, z);
    }

    KSName getModuleName();

    Sequence<KSAnnotated> getSymbolsWithAnnotation(String annotationName, boolean inDepth);
}
