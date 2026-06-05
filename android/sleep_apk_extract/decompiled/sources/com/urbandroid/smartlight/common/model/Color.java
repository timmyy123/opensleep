package com.urbandroid.smartlight.common.model;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0006\u0007\b\t\n\u000bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005\u0082\u0001\u0006\f\u0005\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/urbandroid/smartlight/common/model/Color;", "", "<init>", "()V", "asD65", "Lcom/urbandroid/smartlight/common/model/Color$D65;", "D65", "Brightness", "Hsv", "Hsb", "HsvCt", "Rgb", "Lcom/urbandroid/smartlight/common/model/Color$Brightness;", "Lcom/urbandroid/smartlight/common/model/Color$Hsb;", "Lcom/urbandroid/smartlight/common/model/Color$Hsv;", "Lcom/urbandroid/smartlight/common/model/Color$HsvCt;", "Lcom/urbandroid/smartlight/common/model/Color$Rgb;", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class Color {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/urbandroid/smartlight/common/model/Color$Brightness;", "Lcom/urbandroid/smartlight/common/model/Color;", "brightness", "", "<init>", "(I)V", "getBrightness", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Brightness extends Color {
        private final int brightness;

        public Brightness(int i) {
            super(null);
            this.brightness = i;
        }

        public static /* synthetic */ Brightness copy$default(Brightness brightness, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = brightness.brightness;
            }
            return brightness.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getBrightness() {
            return this.brightness;
        }

        public final Brightness copy(int brightness) {
            return new Brightness(brightness);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Brightness) && this.brightness == ((Brightness) other).brightness;
        }

        public final int getBrightness() {
            return this.brightness;
        }

        public int hashCode() {
            return Integer.hashCode(this.brightness);
        }

        public String toString() {
            return FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder("Brightness(brightness="), this.brightness, ')');
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u000e\u001a\u00020\u0000J\u0006\u0010\u000f\u001a\u00020\u0000J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0000J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ.\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u0012\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/urbandroid/smartlight/common/model/Color$D65;", "Lcom/urbandroid/smartlight/common/model/Color;", "x", "", "y", "z", "<init>", "(IILjava/lang/Integer;)V", "getX", "()I", "getY", "getZ", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "toD65WithMinZ", "mapToCt", "distance", "", "other", "component1", "component2", "component3", "copy", "(IILjava/lang/Integer;)Lcom/urbandroid/smartlight/common/model/Color$D65;", "equals", "", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "Companion", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class D65 extends Color {
        private final int x;
        private final int y;
        private final Integer z;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final D65 COLD = new D65(24930, 24694, 128);
        private static final D65 NORMAL = new D65(30140, 26909, 128);
        private static final D65 WARM = new D65(33135, 27211, 128);

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/urbandroid/smartlight/common/model/Color$D65$Companion;", "", "<init>", "()V", "COLD", "Lcom/urbandroid/smartlight/common/model/Color$D65;", "getCOLD", "()Lcom/urbandroid/smartlight/common/model/Color$D65;", "NORMAL", "getNORMAL", "WARM", "getWARM", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final D65 getCOLD() {
                return D65.COLD;
            }

            public final D65 getNORMAL() {
                return D65.NORMAL;
            }

            public final D65 getWARM() {
                return D65.WARM;
            }

            private Companion() {
            }
        }

        public D65(int i, int i2, Integer num) {
            super(null);
            this.x = i;
            this.y = i2;
            this.z = num;
        }

        public static /* synthetic */ D65 copy$default(D65 d65, int i, int i2, Integer num, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = d65.x;
            }
            if ((i3 & 2) != 0) {
                i2 = d65.y;
            }
            if ((i3 & 4) != 0) {
                num = d65.z;
            }
            return d65.copy(i, i2, num);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getX() {
            return this.x;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getY() {
            return this.y;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getZ() {
            return this.z;
        }

        public final D65 copy(int x, int y, Integer z) {
            return new D65(x, y, z);
        }

        public final double distance(D65 other) {
            other.getClass();
            return Math.sqrt(Math.pow(Math.abs(other.y - this.y), 2.0d) + Math.pow(Math.abs(other.x - this.x), 2.0d));
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof D65)) {
                return false;
            }
            D65 d65 = (D65) other;
            return this.x == d65.x && this.y == d65.y && Intrinsics.areEqual(this.z, d65.z);
        }

        public final int getX() {
            return this.x;
        }

        public final int getY() {
            return this.y;
        }

        public final Integer getZ() {
            return this.z;
        }

        public int hashCode() {
            int iM = FileInsert$$ExternalSyntheticOutline0.m(this.y, Integer.hashCode(this.x) * 31, 31);
            Integer num = this.z;
            return iM + (num == null ? 0 : num.hashCode());
        }

        public final D65 mapToCt() {
            D65 d65 = COLD;
            double dDistance = distance(d65);
            D65 d652 = NORMAL;
            double dDistance2 = distance(d652);
            D65 d653 = WARM;
            double dDistance3 = distance(d653);
            if (dDistance2 > dDistance || dDistance2 > dDistance3) {
                if (dDistance3 <= dDistance && dDistance3 <= dDistance2) {
                    return d653;
                }
                if (dDistance <= dDistance2 && dDistance <= dDistance3) {
                    return d65;
                }
            }
            return d652;
        }

        public final D65 toD65WithMinZ() {
            Integer num = this.z;
            return copy$default(this, 0, 0, num != null ? Integer.valueOf(RangesKt.coerceAtLeast(num.intValue(), 1)) : null, 3, null);
        }

        public String toString() {
            return "D65(x=" + this.x + ", y=" + this.y + ", z=" + this.z + ')';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/urbandroid/smartlight/common/model/Color$Hsv;", "Lcom/urbandroid/smartlight/common/model/Color;", "hue", "", "saturation", SDKConstants.PARAM_VALUE, "<init>", "(III)V", "getHue", "()I", "getSaturation", "getValue", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Hsv extends Color {
        private final int hue;
        private final int saturation;
        private final int value;

        public Hsv(int i, int i2, int i3) {
            super(null);
            this.hue = i;
            this.saturation = i2;
            this.value = i3;
        }

        public static /* synthetic */ Hsv copy$default(Hsv hsv, int i, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = hsv.hue;
            }
            if ((i4 & 2) != 0) {
                i2 = hsv.saturation;
            }
            if ((i4 & 4) != 0) {
                i3 = hsv.value;
            }
            return hsv.copy(i, i2, i3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getHue() {
            return this.hue;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getSaturation() {
            return this.saturation;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getValue() {
            return this.value;
        }

        public final Hsv copy(int hue, int saturation, int value) {
            return new Hsv(hue, saturation, value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Hsv)) {
                return false;
            }
            Hsv hsv = (Hsv) other;
            return this.hue == hsv.hue && this.saturation == hsv.saturation && this.value == hsv.value;
        }

        public final int getHue() {
            return this.hue;
        }

        public final int getSaturation() {
            return this.saturation;
        }

        public final int getValue() {
            return this.value;
        }

        public int hashCode() {
            return Integer.hashCode(this.value) + FileInsert$$ExternalSyntheticOutline0.m(this.saturation, Integer.hashCode(this.hue) * 31, 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Hsv(hue=");
            sb.append(this.hue);
            sb.append(", saturation=");
            sb.append(this.saturation);
            sb.append(", value=");
            return FileInsert$$ExternalSyntheticOutline0.m(sb, this.value, ')');
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/urbandroid/smartlight/common/model/Color$HsvCt;", "Lcom/urbandroid/smartlight/common/model/Color;", UserDataStore.CITY, "", "hue", "saturation", SDKConstants.PARAM_VALUE, "<init>", "(IIII)V", "getCt", "()I", "getHue", "getSaturation", "getValue", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class HsvCt extends Color {
        private final int ct;
        private final int hue;
        private final int saturation;
        private final int value;

        public HsvCt(int i, int i2, int i3, int i4) {
            super(null);
            this.ct = i;
            this.hue = i2;
            this.saturation = i3;
            this.value = i4;
        }

        public static /* synthetic */ HsvCt copy$default(HsvCt hsvCt, int i, int i2, int i3, int i4, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                i = hsvCt.ct;
            }
            if ((i5 & 2) != 0) {
                i2 = hsvCt.hue;
            }
            if ((i5 & 4) != 0) {
                i3 = hsvCt.saturation;
            }
            if ((i5 & 8) != 0) {
                i4 = hsvCt.value;
            }
            return hsvCt.copy(i, i2, i3, i4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getCt() {
            return this.ct;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getHue() {
            return this.hue;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getSaturation() {
            return this.saturation;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getValue() {
            return this.value;
        }

        public final HsvCt copy(int ct, int hue, int saturation, int value) {
            return new HsvCt(ct, hue, saturation, value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HsvCt)) {
                return false;
            }
            HsvCt hsvCt = (HsvCt) other;
            return this.ct == hsvCt.ct && this.hue == hsvCt.hue && this.saturation == hsvCt.saturation && this.value == hsvCt.value;
        }

        public final int getCt() {
            return this.ct;
        }

        public final int getHue() {
            return this.hue;
        }

        public final int getSaturation() {
            return this.saturation;
        }

        public final int getValue() {
            return this.value;
        }

        public int hashCode() {
            return Integer.hashCode(this.value) + FileInsert$$ExternalSyntheticOutline0.m(this.saturation, FileInsert$$ExternalSyntheticOutline0.m(this.hue, Integer.hashCode(this.ct) * 31, 31), 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("HsvCt(ct=");
            sb.append(this.ct);
            sb.append(", hue=");
            sb.append(this.hue);
            sb.append(", saturation=");
            sb.append(this.saturation);
            sb.append(", value=");
            return FileInsert$$ExternalSyntheticOutline0.m(sb, this.value, ')');
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/urbandroid/smartlight/common/model/Color$Rgb;", "Lcom/urbandroid/smartlight/common/model/Color;", "red", "", "blue", "green", "<init>", "(III)V", "getRed", "()I", "getBlue", "getGreen", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Rgb extends Color {
        private final int blue;
        private final int green;
        private final int red;

        public Rgb(int i, int i2, int i3) {
            super(null);
            this.red = i;
            this.blue = i2;
            this.green = i3;
        }

        public static /* synthetic */ Rgb copy$default(Rgb rgb, int i, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = rgb.red;
            }
            if ((i4 & 2) != 0) {
                i2 = rgb.blue;
            }
            if ((i4 & 4) != 0) {
                i3 = rgb.green;
            }
            return rgb.copy(i, i2, i3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getRed() {
            return this.red;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getBlue() {
            return this.blue;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getGreen() {
            return this.green;
        }

        public final Rgb copy(int red, int blue, int green) {
            return new Rgb(red, blue, green);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Rgb)) {
                return false;
            }
            Rgb rgb = (Rgb) other;
            return this.red == rgb.red && this.blue == rgb.blue && this.green == rgb.green;
        }

        public final int getBlue() {
            return this.blue;
        }

        public final int getGreen() {
            return this.green;
        }

        public final int getRed() {
            return this.red;
        }

        public int hashCode() {
            return Integer.hashCode(this.green) + FileInsert$$ExternalSyntheticOutline0.m(this.blue, Integer.hashCode(this.red) * 31, 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Rgb(red=");
            sb.append(this.red);
            sb.append(", blue=");
            sb.append(this.blue);
            sb.append(", green=");
            return FileInsert$$ExternalSyntheticOutline0.m(sb, this.green, ')');
        }
    }

    public /* synthetic */ Color(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final D65 asD65() {
        if (this instanceof Brightness) {
            return ColorsKt.toTradfri((Brightness) this);
        }
        if (this instanceof D65) {
            return (D65) this;
        }
        if (this instanceof Rgb) {
            return ColorsKt.toTradfri((Rgb) this);
        }
        if (this instanceof Hsb) {
            return ColorsKt.toTradfri(ColorsKt.toRgb((Hsb) this));
        }
        if (this instanceof Hsv) {
            return ColorsKt.toTradfri(ColorsKt.toRgb((Hsv) this));
        }
        if (this instanceof HsvCt) {
            return ColorsKt.toTradfri(ColorsKt.toRgb((HsvCt) this));
        }
        Home$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    private Color() {
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/urbandroid/smartlight/common/model/Color$Hsb;", "Lcom/urbandroid/smartlight/common/model/Color;", UserDataStore.CITY, "", "hue", "saturation", "brightness", "<init>", "(IIII)V", "getCt", "()I", "getHue", "getSaturation", "getBrightness", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Hsb extends Color {
        private final int brightness;
        private final int ct;
        private final int hue;
        private final int saturation;

        public Hsb(int i, int i2, int i3, int i4) {
            super(null);
            this.ct = i;
            this.hue = i2;
            this.saturation = i3;
            this.brightness = i4;
        }

        public static /* synthetic */ Hsb copy$default(Hsb hsb, int i, int i2, int i3, int i4, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                i = hsb.ct;
            }
            if ((i5 & 2) != 0) {
                i2 = hsb.hue;
            }
            if ((i5 & 4) != 0) {
                i3 = hsb.saturation;
            }
            if ((i5 & 8) != 0) {
                i4 = hsb.brightness;
            }
            return hsb.copy(i, i2, i3, i4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getCt() {
            return this.ct;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getHue() {
            return this.hue;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getSaturation() {
            return this.saturation;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getBrightness() {
            return this.brightness;
        }

        public final Hsb copy(int ct, int hue, int saturation, int brightness) {
            return new Hsb(ct, hue, saturation, brightness);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Hsb)) {
                return false;
            }
            Hsb hsb = (Hsb) other;
            return this.ct == hsb.ct && this.hue == hsb.hue && this.saturation == hsb.saturation && this.brightness == hsb.brightness;
        }

        public final int getBrightness() {
            return this.brightness;
        }

        public final int getCt() {
            return this.ct;
        }

        public final int getHue() {
            return this.hue;
        }

        public final int getSaturation() {
            return this.saturation;
        }

        public int hashCode() {
            return Integer.hashCode(this.brightness) + FileInsert$$ExternalSyntheticOutline0.m(this.saturation, FileInsert$$ExternalSyntheticOutline0.m(this.hue, Integer.hashCode(this.ct) * 31, 31), 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Hsb(ct=");
            sb.append(this.ct);
            sb.append(", hue=");
            sb.append(this.hue);
            sb.append(", saturation=");
            sb.append(this.saturation);
            sb.append(", brightness=");
            return FileInsert$$ExternalSyntheticOutline0.m(sb, this.brightness, ')');
        }

        public /* synthetic */ Hsb(int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? 500 : i, i2, i3, i4);
        }
    }
}
