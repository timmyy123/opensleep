package io.rebble.pebblekit2.client;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002H¦@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lio/rebble/pebblekit2/client/PebbleAndroidAppPicker;", "", "", "getCurrentlySelectedApp", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "client-api"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface PebbleAndroidAppPicker {
    Object getCurrentlySelectedApp(Continuation<? super String> continuation);
}
