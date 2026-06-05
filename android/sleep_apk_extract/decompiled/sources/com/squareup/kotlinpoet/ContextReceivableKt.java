package com.squareup.kotlinpoet;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0002H\u0001¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"buildContextReceivers", "Lcom/squareup/kotlinpoet/ContextReceivers;", "Lcom/squareup/kotlinpoet/ContextReceivable$Builder;", "(Lcom/squareup/kotlinpoet/ContextReceivable$Builder;)Ljava/util/List;", "kotlinpoet"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class ContextReceivableKt {
    public static final List<? extends TypeName> buildContextReceivers(ContextReceivable$Builder<?> contextReceivable$Builder) {
        contextReceivable$Builder.getClass();
        return ContextReceivers.m940constructorimpl(UtilKt.toImmutableList(contextReceivable$Builder.getContextReceiverTypes()));
    }
}
