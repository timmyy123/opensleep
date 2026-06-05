package com.urbandroid.sleep.hr.polar;

import com.urbandroid.sleep.hr.AccelBatch;
import com.urbandroid.sleep.hr.polar.domain.AccData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"mapAccelData", "Lcom/urbandroid/sleep/hr/AccelBatch;", "src", "Lcom/urbandroid/sleep/hr/polar/domain/AccData;", "sampleRate", "", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class PolarBLEClientKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final AccelBatch mapAccelData(AccData accData, int i) {
        List<AccData.AccSample> list = accData.accSamples;
        list.getClass();
        List<AccData.AccSample> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (AccData.AccSample accSample : list2) {
            arrayList.add(new AccelBatch.Point(accSample.x / 100.0f, accSample.y / 100.0f, accSample.z / 100.0f));
        }
        return new AccelBatch(i, accData.timeStamp / 1000000, System.currentTimeMillis(), arrayList);
    }
}
