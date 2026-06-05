package com.squareup.kotlinpoet;

import com.squareup.kotlinpoet.ContextReceivable$Builder;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\u0010\b\u0000\u0010\u0002 \u0001*\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0003R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"com/squareup/kotlinpoet/ContextReceivable$Builder", "Lcom/squareup/kotlinpoet/ContextReceivable$Builder;", "T", "", "", "Lcom/squareup/kotlinpoet/TypeName;", "getContextReceiverTypes", "()Ljava/util/List;", "getContextReceiverTypes$annotations", "()V", "contextReceiverTypes", "kotlinpoet"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ContextReceivable$Builder<T extends ContextReceivable$Builder<? extends T>> {
    List<TypeName> getContextReceiverTypes();
}
