package com.polar.androidcommunications.api.ble.model.gatt.client.pmd;

import com.polar.androidcommunications.api.ble.model.gatt.client.pmd.PmdDataFrame;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
public /* synthetic */ class BlePMDClient$processPmdData$frame$1 extends FunctionReferenceImpl implements Function2<PmdMeasurementType, PmdDataFrame.PmdDataFrameType, ULong> {
    public BlePMDClient$processPmdData$frame$1(Object obj) {
        super(2, obj, BlePMDClient.class, "getPreviousFrameTimeStamp", "getPreviousFrameTimeStamp-ZIaKswc(Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdMeasurementType;Lcom/polar/androidcommunications/api/ble/model/gatt/client/pmd/PmdDataFrame$PmdDataFrameType;)J", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ ULong invoke(PmdMeasurementType pmdMeasurementType, PmdDataFrame.PmdDataFrameType pmdDataFrameType) {
        return ULong.m2410boximpl(m877invokeZIaKswc(pmdMeasurementType, pmdDataFrameType));
    }

    /* JADX INFO: renamed from: invoke-ZIaKswc, reason: not valid java name */
    public final long m877invokeZIaKswc(PmdMeasurementType pmdMeasurementType, PmdDataFrame.PmdDataFrameType pmdDataFrameType) {
        pmdMeasurementType.getClass();
        pmdDataFrameType.getClass();
        return ((BlePMDClient) this.receiver).m876getPreviousFrameTimeStampZIaKswc(pmdMeasurementType, pmdDataFrameType);
    }
}
