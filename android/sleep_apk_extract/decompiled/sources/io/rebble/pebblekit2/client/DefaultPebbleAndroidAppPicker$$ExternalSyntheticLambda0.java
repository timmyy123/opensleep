package io.rebble.pebblekit2.client;

import android.content.Context;
import com.urbandroid.sleep.activityrecognition.ActivityBootReceiver;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class DefaultPebbleAndroidAppPicker$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Context f$0;

    public /* synthetic */ DefaultPebbleAndroidAppPicker$$ExternalSyntheticLambda0(Context context, int i) {
        this.$r8$classId = i;
        this.f$0 = context;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i = this.$r8$classId;
        Context context = this.f$0;
        switch (i) {
            case 0:
                return DefaultPebbleAndroidAppPicker.createOrGetDataStore$lambda$1$0(context);
            default:
                return ActivityBootReceiver.onReceive$lambda$0(context);
        }
    }
}
