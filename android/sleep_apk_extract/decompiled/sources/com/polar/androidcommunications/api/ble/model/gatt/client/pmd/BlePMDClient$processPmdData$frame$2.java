package com.polar.androidcommunications.api.ble.model.gatt.client.pmd;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
public /* synthetic */ class BlePMDClient$processPmdData$frame$2 extends FunctionReferenceImpl implements Function1<PmdMeasurementType, Float> {
    public BlePMDClient$processPmdData$frame$2(Object obj) {
        super(1, obj, BlePMDClient.class, "getFactor", "getFactor(Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdMeasurementType;)F", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Float invoke(PmdMeasurementType pmdMeasurementType) {
        pmdMeasurementType.getClass();
        return Float.valueOf(((BlePMDClient) this.receiver).getFactor(pmdMeasurementType));
    }
}
