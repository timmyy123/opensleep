package io.rebble.pebblekit2.client;

import android.os.IBinder;
import io.rebble.pebblekit2.common.UniversalRequestResponse;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class DefaultPebbleSender$connector$2 extends FunctionReferenceImpl implements Function1<IBinder, UniversalRequestResponse> {
    public static final DefaultPebbleSender$connector$2 INSTANCE = new DefaultPebbleSender$connector$2();

    public DefaultPebbleSender$connector$2() {
        super(1, UniversalRequestResponse.Stub.class, "asInterface", "asInterface(Landroid/os/IBinder;)Lio/rebble/pebblekit2/common/UniversalRequestResponse;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final UniversalRequestResponse invoke(IBinder iBinder) {
        return UniversalRequestResponse.Stub.asInterface(iBinder);
    }
}
