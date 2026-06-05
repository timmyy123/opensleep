package com.google.android.datatransport.cct.internal;

import android.util.SparseArray;
import com.google.android.datatransport.cct.internal.AutoValue_NetworkConnectionInfo;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NetworkConnectionInfo {

    public static abstract class Builder {
        public abstract NetworkConnectionInfo build();

        public abstract Builder setMobileSubtype(MobileSubtype mobileSubtype);

        public abstract Builder setNetworkType(NetworkType networkType);
    }

    public enum MobileSubtype {
        UNKNOWN_MOBILE_SUBTYPE(0),
        GPRS(1),
        EDGE(2),
        UMTS(3),
        CDMA(4),
        EVDO_0(5),
        EVDO_A(6),
        RTT(7),
        HSDPA(8),
        HSUPA(9),
        HSPA(10),
        IDEN(11),
        EVDO_B(12),
        LTE(13),
        EHRPD(14),
        HSPAP(15),
        GSM(16),
        TD_SCDMA(17),
        IWLAN(18),
        LTE_CA(19),
        COMBINED(100);

        private static final SparseArray<MobileSubtype> valueMap;
        private final int value;

        static {
            MobileSubtype mobileSubtype = UNKNOWN_MOBILE_SUBTYPE;
            MobileSubtype mobileSubtype2 = GPRS;
            MobileSubtype mobileSubtype3 = EDGE;
            MobileSubtype mobileSubtype4 = UMTS;
            MobileSubtype mobileSubtype5 = CDMA;
            MobileSubtype mobileSubtype6 = EVDO_0;
            MobileSubtype mobileSubtype7 = EVDO_A;
            MobileSubtype mobileSubtype8 = RTT;
            MobileSubtype mobileSubtype9 = HSDPA;
            MobileSubtype mobileSubtype10 = HSUPA;
            MobileSubtype mobileSubtype11 = HSPA;
            MobileSubtype mobileSubtype12 = IDEN;
            MobileSubtype mobileSubtype13 = EVDO_B;
            MobileSubtype mobileSubtype14 = LTE;
            MobileSubtype mobileSubtype15 = EHRPD;
            MobileSubtype mobileSubtype16 = HSPAP;
            MobileSubtype mobileSubtype17 = GSM;
            MobileSubtype mobileSubtype18 = TD_SCDMA;
            MobileSubtype mobileSubtype19 = IWLAN;
            MobileSubtype mobileSubtype20 = LTE_CA;
            SparseArray<MobileSubtype> sparseArray = new SparseArray<>();
            valueMap = sparseArray;
            sparseArray.put(0, mobileSubtype);
            sparseArray.put(1, mobileSubtype2);
            sparseArray.put(2, mobileSubtype3);
            sparseArray.put(3, mobileSubtype4);
            sparseArray.put(4, mobileSubtype5);
            sparseArray.put(5, mobileSubtype6);
            sparseArray.put(6, mobileSubtype7);
            sparseArray.put(7, mobileSubtype8);
            sparseArray.put(8, mobileSubtype9);
            sparseArray.put(9, mobileSubtype10);
            sparseArray.put(10, mobileSubtype11);
            sparseArray.put(11, mobileSubtype12);
            sparseArray.put(12, mobileSubtype13);
            sparseArray.put(13, mobileSubtype14);
            sparseArray.put(14, mobileSubtype15);
            sparseArray.put(15, mobileSubtype16);
            sparseArray.put(16, mobileSubtype17);
            sparseArray.put(17, mobileSubtype18);
            sparseArray.put(18, mobileSubtype19);
            sparseArray.put(19, mobileSubtype20);
        }

        MobileSubtype(int i) {
            this.value = i;
        }

        public static MobileSubtype forNumber(int i) {
            return valueMap.get(i);
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum NetworkType {
        MOBILE(0),
        WIFI(1),
        MOBILE_MMS(2),
        MOBILE_SUPL(3),
        MOBILE_DUN(4),
        MOBILE_HIPRI(5),
        WIMAX(6),
        BLUETOOTH(7),
        DUMMY(8),
        ETHERNET(9),
        MOBILE_FOTA(10),
        MOBILE_IMS(11),
        MOBILE_CBS(12),
        WIFI_P2P(13),
        MOBILE_IA(14),
        MOBILE_EMERGENCY(15),
        PROXY(16),
        VPN(17),
        NONE(-1);

        private static final SparseArray<NetworkType> valueMap;
        private final int value;

        static {
            NetworkType networkType = MOBILE;
            NetworkType networkType2 = WIFI;
            NetworkType networkType3 = MOBILE_MMS;
            NetworkType networkType4 = MOBILE_SUPL;
            NetworkType networkType5 = MOBILE_DUN;
            NetworkType networkType6 = MOBILE_HIPRI;
            NetworkType networkType7 = WIMAX;
            NetworkType networkType8 = BLUETOOTH;
            NetworkType networkType9 = DUMMY;
            NetworkType networkType10 = ETHERNET;
            NetworkType networkType11 = MOBILE_FOTA;
            NetworkType networkType12 = MOBILE_IMS;
            NetworkType networkType13 = MOBILE_CBS;
            NetworkType networkType14 = WIFI_P2P;
            NetworkType networkType15 = MOBILE_IA;
            NetworkType networkType16 = MOBILE_EMERGENCY;
            NetworkType networkType17 = PROXY;
            NetworkType networkType18 = VPN;
            NetworkType networkType19 = NONE;
            SparseArray<NetworkType> sparseArray = new SparseArray<>();
            valueMap = sparseArray;
            sparseArray.put(0, networkType);
            sparseArray.put(1, networkType2);
            sparseArray.put(2, networkType3);
            sparseArray.put(3, networkType4);
            sparseArray.put(4, networkType5);
            sparseArray.put(5, networkType6);
            sparseArray.put(6, networkType7);
            sparseArray.put(7, networkType8);
            sparseArray.put(8, networkType9);
            sparseArray.put(9, networkType10);
            sparseArray.put(10, networkType11);
            sparseArray.put(11, networkType12);
            sparseArray.put(12, networkType13);
            sparseArray.put(13, networkType14);
            sparseArray.put(14, networkType15);
            sparseArray.put(15, networkType16);
            sparseArray.put(16, networkType17);
            sparseArray.put(17, networkType18);
            sparseArray.put(-1, networkType19);
        }

        NetworkType(int i) {
            this.value = i;
        }

        public static NetworkType forNumber(int i) {
            return valueMap.get(i);
        }

        public int getValue() {
            return this.value;
        }
    }

    public static Builder builder() {
        return new AutoValue_NetworkConnectionInfo.Builder();
    }

    public abstract MobileSubtype getMobileSubtype();

    public abstract NetworkType getNetworkType();
}
