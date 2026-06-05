package com.urbandroid.sleep.hr.berry;

import com.urbandroid.sleep.hr.berry.parser.DataParser;
import com.urbandroid.sleep.hr.berry.parser.OximeterResult;
import com.urbandroid.sleep.hr.berry.parser.OximeterResultListener;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BerryOximeterBLEClient$$ExternalSyntheticLambda0 implements OximeterResultListener, DataParser.PackageReceivedListener {
    public final /* synthetic */ BerryOximeterBLEClient f$0;

    public /* synthetic */ BerryOximeterBLEClient$$ExternalSyntheticLambda0(BerryOximeterBLEClient berryOximeterBLEClient) {
        this.f$0 = berryOximeterBLEClient;
    }

    public void newPulse(OximeterResult oximeterResult) {
        BerryOximeterBLEClient._init_$lambda$0(this.f$0, oximeterResult);
    }

    public void packageReceived(DataParser.Protocol protocol2, int[] iArr) {
        BerryOximeterBLEClient._init_$lambda$1(this.f$0, protocol2, iArr);
    }
}
