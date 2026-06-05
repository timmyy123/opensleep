package com.urbandroid.sleep.sensor.extra;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0005H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/sensor/extra/ExtraDataProducer;", "", "start", "", "onNewValue", "Lkotlin/Function2;", "", "", "stop", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface ExtraDataProducer {
    void start(Function2<? super Float, ? super Long, Unit> onNewValue);

    void stop();
}
