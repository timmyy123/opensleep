package com.urbandroid.sleep.hr;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001JG\u0010\n\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\"\u0010\t\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\b\u0012\u0004\u0012\u00028\u0000`\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/hr/ReceiverClient;", "", "T", "Lcom/urbandroid/sleep/hr/Capability;", "capability", "Lkotlin/Function2;", "", "", "Lcom/urbandroid/sleep/hr/CapabilitySubscriber;", "subscriber", "subscribe", "(Lcom/urbandroid/sleep/hr/Capability;Lkotlin/jvm/functions/Function2;)V", "stop", "()V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface ReceiverClient {
    void stop();

    <T> void subscribe(Capability<T> capability, Function2<? super T, ? super Long, Unit> subscriber);
}
