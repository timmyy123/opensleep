package com.urbandroid.sleep.smartwatch.garmin;

import android.content.Context;
import com.garmin.android.connectiq.ConnectIQ;
import com.garmin.android.connectiq.IQApp;
import com.garmin.android.connectiq.IQDevice;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class MessageHandler$$ExternalSyntheticLambda0 implements ConnectIQ.IQOpenApplicationListener {
    public final /* synthetic */ MessageHandler f$0;
    public final /* synthetic */ Context f$1;

    public /* synthetic */ MessageHandler$$ExternalSyntheticLambda0(MessageHandler messageHandler, Context context) {
        this.f$0 = messageHandler;
        this.f$1 = context;
    }

    public final void onOpenApplicationResponse(IQDevice iQDevice, IQApp iQApp, ConnectIQ.IQOpenApplicationStatus iQOpenApplicationStatus) {
        this.f$0.lambda$handleMessageFromSleep$0(this.f$1, iQDevice, iQApp, iQOpenApplicationStatus);
    }
}
