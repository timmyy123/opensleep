package com.google.home.matter.standard;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0005\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lcom/google/home/matter/standard/OnOffCommands;", "", "", "off", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "on", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface OnOffCommands {
    Object off(Continuation<? super Unit> continuation);

    Object on(Continuation<? super Unit> continuation);
}
