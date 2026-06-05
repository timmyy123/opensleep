package com.polar.androidcommunications.api.ble.model.advertisement;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.polar.androidcommunications.api.ble.model.polar.BlePolarDeviceIdUtility;
import com.polar.androidcommunications.api.ble.model.polar.PolarAdvDataUtility;
import com.polar.androidcommunications.common.ble.BleUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\b\f\u0018\u0000 D2\u00020\u0001:\u0001DB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\r\u001a\u00020\f2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\u0015\u001a\u00020\f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0018\u001a\u00020\u00172\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0011H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\f¢\u0006\u0004\b\u001d\u0010\u0003J\u0015\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u0017¢\u0006\u0004\b \u0010!R \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00118\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\"R \u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00118\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b#\u0010\"R$\u0010\u001a\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u00178\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001a\u0010%\u001a\u0004\b&\u0010'R$\u0010(\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u00178\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b(\u0010%\u001a\u0004\b)\u0010'R$\u0010+\u001a\u00020*2\u0006\u0010$\u001a\u00020*8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R$\u0010/\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u00178\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b/\u0010%\u001a\u0004\b0\u0010'R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u00101\u001a\u0004\b2\u00103R$\u00104\u001a\u00020*2\u0006\u0010$\u001a\u00020*8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b4\u0010,\u001a\u0004\b5\u0010.R$\u0010\t\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\t\u00106\u001a\u0004\b7\u00108R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\n098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020\n098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010;R$\u0010=\u001a\u00020\n2\u0006\u0010$\u001a\u00020\n8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R$\u0010\u000b\u001a\u00020\n2\u0006\u0010$\u001a\u00020\n8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000b\u0010>\u001a\u0004\bA\u0010@R\u0011\u0010B\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\bB\u0010C¨\u0006E"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/advertisement/BleAdvertisementContent;", "", "<init>", "()V", "", "Lcom/polar/androidcommunications/common/ble/BleUtils$AD_TYPE;", "", "advData", "Lcom/polar/androidcommunications/common/ble/BleUtils$EVENT_TYPE;", "advertisementEventType", "", "rssi", "", "processAdvertisementData", "(Ljava/util/Map;Lcom/polar/androidcommunications/common/ble/BleUtils$EVENT_TYPE;I)V", "processRssi", "(I)V", "Ljava/util/HashMap;", "advertisementData", "Lcom/polar/androidcommunications/api/ble/model/advertisement/BlePolarHrAdvertisement;", "polarHrAdvertisement", "processAdvManufacturerData", "(Ljava/util/HashMap;Lcom/polar/androidcommunications/api/ble/model/advertisement/BlePolarHrAdvertisement;)V", "", "getNameFromAdvData", "(Ljava/util/HashMap;)Ljava/lang/String;", "name", "processName", "(Ljava/lang/String;)V", "resetAdvertisementData", "service", "", "containsService", "(Ljava/lang/String;)Z", "Ljava/util/HashMap;", "advertisementDataAll", "<set-?>", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "polarDeviceType", "getPolarDeviceType", "", "polarDeviceIdInt", "J", "getPolarDeviceIdInt", "()J", "polarDeviceId", "getPolarDeviceId", "Lcom/polar/androidcommunications/api/ble/model/advertisement/BlePolarHrAdvertisement;", "getPolarHrAdvertisement", "()Lcom/polar/androidcommunications/api/ble/model/advertisement/BlePolarHrAdvertisement;", "advertisementTimeStamp", "getAdvertisementTimeStamp", "Lcom/polar/androidcommunications/common/ble/BleUtils$EVENT_TYPE;", "getAdvertisementEventType", "()Lcom/polar/androidcommunications/common/ble/BleUtils$EVENT_TYPE;", "", "rssiValues", "Ljava/util/List;", "sortedRssiValues", "medianRssi", "I", "getMedianRssi", "()I", "getRssi", "isNonConnectableAdvertisement", "()Z", "Companion", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BleAdvertisementContent {
    private long polarDeviceIdInt;
    public final HashMap<BleUtils.AD_TYPE, byte[]> advertisementData = new HashMap<>();
    public final HashMap<BleUtils.AD_TYPE, byte[]> advertisementDataAll = new HashMap<>();
    private String name = "";
    private String polarDeviceType = "";
    private String polarDeviceId = "";
    private final BlePolarHrAdvertisement polarHrAdvertisement = new BlePolarHrAdvertisement();
    private long advertisementTimeStamp = System.currentTimeMillis() / 1000;
    private BleUtils.EVENT_TYPE advertisementEventType = BleUtils.EVENT_TYPE.ADV_IND;
    private final List<Integer> rssiValues = new ArrayList();
    private final List<Integer> sortedRssiValues = new ArrayList();
    private int medianRssi = -100;
    private int rssi = -100;

    public final boolean containsService(String service) {
        int progressionLastElement;
        service.getClass();
        HashMap<BleUtils.AD_TYPE, byte[]> map = this.advertisementData;
        BleUtils.AD_TYPE ad_type = BleUtils.AD_TYPE.GAP_ADTYPE_16BIT_MORE;
        if (map.containsKey(ad_type) || this.advertisementData.containsKey(BleUtils.AD_TYPE.GAP_ADTYPE_16BIT_COMPLETE)) {
            boolean zContainsKey = this.advertisementData.containsKey(ad_type);
            HashMap<BleUtils.AD_TYPE, byte[]> map2 = this.advertisementData;
            byte[] bArr = zContainsKey ? map2.get(ad_type) : map2.get(BleUtils.AD_TYPE.GAP_ADTYPE_16BIT_COMPLETE);
            if (bArr != null) {
                if (!(bArr.length == 0) && (progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, bArr.length - 1, 2)) >= 0) {
                    int i = 0;
                    while (true) {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        if (!Intrinsics.areEqual(String.format("%02X%02X", Arrays.copyOf(new Object[]{Byte.valueOf(bArr[i + 1]), Byte.valueOf(bArr[i])}, 2)), service)) {
                            if (i == progressionLastElement) {
                                break;
                            }
                            i += 2;
                        } else {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNameFromAdvData(HashMap<BleUtils.AD_TYPE, byte[]> advertisementData) {
        byte[] bArr;
        advertisementData.getClass();
        BleUtils.AD_TYPE ad_type = BleUtils.AD_TYPE.GAP_ADTYPE_LOCAL_NAME_COMPLETE;
        if (advertisementData.containsKey(ad_type)) {
            byte[] bArr2 = advertisementData.get(ad_type);
            return bArr2 != null ? new String(bArr2, Charsets.UTF_8) : "";
        }
        BleUtils.AD_TYPE ad_type2 = BleUtils.AD_TYPE.GAP_ADTYPE_LOCAL_NAME_SHORT;
        return (!advertisementData.containsKey(ad_type2) || (bArr = advertisementData.get(ad_type2)) == null) ? "" : new String(bArr, Charsets.UTF_8);
    }

    public final String getPolarDeviceId() {
        return this.polarDeviceId;
    }

    public final long getPolarDeviceIdInt() {
        return this.polarDeviceIdInt;
    }

    public final String getPolarDeviceType() {
        return this.polarDeviceType;
    }

    public final BlePolarHrAdvertisement getPolarHrAdvertisement() {
        return this.polarHrAdvertisement;
    }

    public final int getRssi() {
        return this.rssi;
    }

    public final boolean isNonConnectableAdvertisement() {
        return (this.polarDeviceId.length() <= 0 || this.advertisementData.containsKey(BleUtils.AD_TYPE.GAP_ADTYPE_16BIT_MORE) || this.advertisementData.containsKey(BleUtils.AD_TYPE.GAP_ADTYPE_16BIT_COMPLETE)) ? false : true;
    }

    public final void processAdvManufacturerData(HashMap<BleUtils.AD_TYPE, byte[]> advertisementData, BlePolarHrAdvertisement polarHrAdvertisement) {
        byte[] bArr;
        advertisementData.getClass();
        polarHrAdvertisement.getClass();
        BleUtils.AD_TYPE ad_type = BleUtils.AD_TYPE.GAP_ADTYPE_MANUFACTURER_SPECIFIC;
        boolean z = false;
        if (advertisementData.containsKey(ad_type) && (bArr = advertisementData.get(ad_type)) != null && bArr.length > 3 && bArr[0] == 107 && bArr[1] == 0) {
            int length = 2;
            while (length < bArr.length) {
                int i = bArr[length] & 64;
                if (i == 0) {
                    if (length + 3 <= bArr.length) {
                        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, length, bArr.length);
                        bArrCopyOfRange.getClass();
                        polarHrAdvertisement.processPolarManufacturerData(bArrCopyOfRange);
                        z = true;
                    }
                    length += 5;
                } else if (i != 64) {
                    length = bArr.length;
                } else {
                    int i2 = length + 1;
                    length = i2 < bArr.length ? i2 + (bArr[i2] & 255) + 1 : bArr.length;
                }
            }
        }
        if (z) {
            return;
        }
        polarHrAdvertisement.resetToDefault();
    }

    public final void processAdvertisementData(Map<BleUtils.AD_TYPE, byte[]> advData, BleUtils.EVENT_TYPE advertisementEventType, int rssi) {
        advData.getClass();
        advertisementEventType.getClass();
        this.advertisementData.clear();
        this.advertisementData.putAll(advData);
        this.advertisementDataAll.putAll(advData);
        this.advertisementEventType = advertisementEventType;
        this.advertisementTimeStamp = System.currentTimeMillis() / 1000;
        String nameFromAdvData = getNameFromAdvData(this.advertisementData);
        if (nameFromAdvData.length() > 0) {
            processName(nameFromAdvData);
        }
        processAdvManufacturerData(this.advertisementData, this.polarHrAdvertisement);
        if (rssi < 0) {
            processRssi(rssi);
        }
    }

    public final void processName(String name) {
        long j;
        name.getClass();
        if (name.length() <= 0 || Intrinsics.areEqual(this.name, name)) {
            return;
        }
        this.name = name;
        PolarAdvDataUtility polarAdvDataUtility = PolarAdvDataUtility.INSTANCE;
        if (polarAdvDataUtility.isPolarDevice(name)) {
            this.polarDeviceType = polarAdvDataUtility.getPolarModelNameFromAdvLocalName(name);
            String[] strArr = (String[]) StringsKt.split$default(name, new String[]{" "}, 0, 6).toArray(new String[0]);
            String str = strArr[strArr.length - 1];
            this.polarDeviceId = str;
            if (str.length() == 7) {
                String strAssemblyFullPolarDeviceId = BlePolarDeviceIdUtility.assemblyFullPolarDeviceId(strArr[strArr.length - 1]);
                strAssemblyFullPolarDeviceId.getClass();
                this.polarDeviceId = strAssemblyFullPolarDeviceId;
                this.name = Fragment$$ExternalSyntheticOutline1.m("Polar ", this.polarDeviceType, " ", strAssemblyFullPolarDeviceId);
            }
            try {
                j = Long.parseLong(this.polarDeviceId, CharsKt.checkRadix(16));
            } catch (NumberFormatException unused) {
                j = 0;
            }
            this.polarDeviceIdInt = j;
        }
    }

    public final void processRssi(int rssi) {
        this.rssi = rssi;
        this.rssiValues.add(Integer.valueOf(rssi));
        if (this.rssiValues.size() < 7) {
            this.medianRssi = rssi;
            return;
        }
        this.sortedRssiValues.clear();
        this.sortedRssiValues.addAll(this.rssiValues);
        CollectionsKt.sort(this.sortedRssiValues);
        this.medianRssi = this.sortedRssiValues.get(3).intValue();
        this.rssiValues.remove(0);
    }

    public final void resetAdvertisementData() {
        this.advertisementData.clear();
        this.polarHrAdvertisement.resetToDefault();
    }
}
