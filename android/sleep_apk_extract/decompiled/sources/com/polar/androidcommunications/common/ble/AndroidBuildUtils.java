package com.polar.androidcommunications.common.ble;

import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/polar/androidcommunications/common/ble/AndroidBuildUtils;", "", "Companion", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class AndroidBuildUtils {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007¨\u0006\b"}, d2 = {"Lcom/polar/androidcommunications/common/ble/AndroidBuildUtils$Companion;", "", "()V", "getBrand", "", "getBuildVersion", "", "getModel", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getBrand() {
            String str = Build.BRAND;
            str.getClass();
            return str;
        }

        public final int getBuildVersion() {
            return Build.VERSION.SDK_INT;
        }

        public final String getModel() {
            String str = Build.MODEL;
            str.getClass();
            return str;
        }

        private Companion() {
        }
    }

    public static final String getBrand() {
        return INSTANCE.getBrand();
    }

    public static final int getBuildVersion() {
        return INSTANCE.getBuildVersion();
    }

    public static final String getModel() {
        return INSTANCE.getModel();
    }
}
