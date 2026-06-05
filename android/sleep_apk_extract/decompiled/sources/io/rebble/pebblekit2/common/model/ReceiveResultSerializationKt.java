package io.rebble.pebblekit2.common.model;

import android.os.Bundle;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import io.rebble.pebblekit2.common.model.ReceiveResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/rebble/pebblekit2/common/model/ReceiveResult;", "Landroid/os/Bundle;", "toBundle", "(Lio/rebble/pebblekit2/common/model/ReceiveResult;)Landroid/os/Bundle;", "common_release"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class ReceiveResultSerializationKt {
    public static final Bundle toBundle(ReceiveResult receiveResult) {
        String str;
        receiveResult.getClass();
        Bundle bundle = new Bundle();
        if (Intrinsics.areEqual(receiveResult, ReceiveResult.Ack.INSTANCE)) {
            str = "ACK";
        } else {
            if (!Intrinsics.areEqual(receiveResult, ReceiveResult.Nack.INSTANCE)) {
                Home$$ExternalSyntheticBUOutline0.m();
                return null;
            }
            str = "NACK";
        }
        bundle.putString("TYPE", str);
        return bundle;
    }
}
