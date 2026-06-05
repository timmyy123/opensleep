package com.polar.androidcommunications.api.ble.model.gatt.client;

import com.polar.androidcommunications.api.ble.model.DisInfo;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class BleDisClient$$ExternalSyntheticLambda5 implements Predicate {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ BleDisClient f$0;

    public /* synthetic */ BleDisClient$$ExternalSyntheticLambda5(BleDisClient bleDisClient, int i) {
        this.$r8$classId = i;
        this.f$0 = bleDisClient;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        int i = this.$r8$classId;
        BleDisClient bleDisClient = this.f$0;
        switch (i) {
            case 0:
                return bleDisClient.isValidUUIDString((String) obj);
            default:
                return bleDisClient.lambda$observeDisInfoWithKeysAsStrings$5((DisInfo) obj);
        }
    }
}
