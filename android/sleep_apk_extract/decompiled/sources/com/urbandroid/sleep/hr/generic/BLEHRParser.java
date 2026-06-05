package com.urbandroid.sleep.hr.generic;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.bluetooth.BluetoothGattCharacteristic;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.logging.filter.Filters;
import com.urbandroid.common.logging.filter.FrequencyGuards;
import com.urbandroid.common.logging.filter.Matchers;
import com.urbandroid.sleep.bluetoothle.BLEUtilKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096D¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/urbandroid/sleep/hr/generic/BLEHRParser;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "Landroid/bluetooth/BluetoothGattCharacteristic;", "characteristic", "Lcom/urbandroid/sleep/hr/generic/BLEHRParser$HRData;", "parseHrData", "(Landroid/bluetooth/BluetoothGattCharacteristic;)Lcom/urbandroid/sleep/hr/generic/BLEHRParser$HRData;", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "emptyHRData", "Lcom/urbandroid/sleep/hr/generic/BLEHRParser$HRData;", "getEmptyHRData", "()Lcom/urbandroid/sleep/hr/generic/BLEHRParser$HRData;", "HRData", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class BLEHRParser implements FeatureLogger {
    private final HRData emptyHRData;
    private final String tag = "BLEHRParser";

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\tJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\tR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/urbandroid/sleep/hr/generic/BLEHRParser$HRData;", "", "", "hr", "", "rr", "<init>", "(ILjava/util/List;)V", "component1", "()I", "component2", "()Ljava/util/List;", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getHr", "Ljava/util/List;", "getRr", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class HRData {
        private final int hr;
        private final List<Integer> rr;

        public HRData(int i, List<Integer> list) {
            list.getClass();
            this.hr = i;
            this.rr = list;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getHr() {
            return this.hr;
        }

        public final List<Integer> component2() {
            return this.rr;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HRData)) {
                return false;
            }
            HRData hRData = (HRData) other;
            return this.hr == hRData.hr && Intrinsics.areEqual(this.rr, hRData.rr);
        }

        public final int getHr() {
            return this.hr;
        }

        public int hashCode() {
            return this.rr.hashCode() + (Integer.hashCode(this.hr) * 31);
        }

        public String toString() {
            return "HRData(hr=" + this.hr + ", rr=" + this.rr + ")";
        }
    }

    public BLEHRParser() {
        Logger.addFilter(Filters.filter$default(Matchers.startsWith(getTag()), FrequencyGuards.maxCountPerInterval(60, 10), 0, 4, null));
        this.emptyHRData = new HRData(0, CollectionsKt.emptyList());
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    public final HRData parseHrData(BluetoothGattCharacteristic characteristic) {
        characteristic.getClass();
        byte[] value = characteristic.getValue();
        if (value == null || value.length == 0) {
            Logger.logWarning(Logger.defaultTag, getTag() + ": Empty data", null);
            return this.emptyHRData;
        }
        try {
            byte b = value[0];
            int i = (b & 1) != 0 ? 2 : 1;
            boolean z = (b & 8) != 0;
            boolean z2 = (b & 16) != 0;
            Integer intValue = characteristic.getIntValue(i == 1 ? 17 : 18, 1);
            int iIntValue = intValue != null ? intValue.intValue() : 0;
            ArrayList arrayList = new ArrayList();
            if (z2) {
                int i2 = i + 1 + (z ? 2 : 0);
                int length = (value.length - i2) / 2;
                for (int i3 = 0; i3 < length; i3++) {
                    Integer intValue2 = characteristic.getIntValue(18, (i3 * 2) + i2);
                    arrayList.add(Integer.valueOf(intValue2 != null ? intValue2.intValue() : 0));
                }
            }
            return new HRData(iIntValue, arrayList);
        } catch (Exception e) {
            String strM = FileInsert$$ExternalSyntheticOutline0.m("Parsing error: ", BLEUtilKt.toHexString(value));
            Logger.logWarning(Logger.defaultTag, getTag() + ": " + strM, e);
            return this.emptyHRData;
        }
    }
}
