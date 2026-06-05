package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AutoValue_AndroidClientInfo;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AndroidClientInfo {

    public static abstract class Builder {
        public abstract AndroidClientInfo build();

        public abstract Builder setApplicationBuild(String str);

        public abstract Builder setCountry(String str);

        public abstract Builder setDevice(String str);

        public abstract Builder setFingerprint(String str);

        public abstract Builder setHardware(String str);

        public abstract Builder setLocale(String str);

        public abstract Builder setManufacturer(String str);

        public abstract Builder setMccMnc(String str);

        public abstract Builder setModel(String str);

        public abstract Builder setOsBuild(String str);

        public abstract Builder setProduct(String str);

        public abstract Builder setSdkVersion(Integer num);
    }

    public static Builder builder() {
        return new AutoValue_AndroidClientInfo.Builder();
    }

    public abstract String getApplicationBuild();

    public abstract String getCountry();

    public abstract String getDevice();

    public abstract String getFingerprint();

    public abstract String getHardware();

    public abstract String getLocale();

    public abstract String getManufacturer();

    public abstract String getMccMnc();

    public abstract String getModel();

    public abstract String getOsBuild();

    public abstract String getProduct();

    public abstract Integer getSdkVersion();
}
