package androidx.core.view;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class DisplayShapeCompat {
    static final DisplayShapeCompat EMPTY = new DisplayShapeCompat("", 0, 0, 1.0f, 0, 0, 0, 1.0f);
    private final Impl mImpl;

    public interface Impl {
    }

    public static class ImplBase implements Impl {
        private final int mDisplayHeight;
        private final String mDisplayShapeSpec;
        private final int mDisplayWidth;
        private final int mOffsetX;
        private final int mOffsetY;
        private final float mPhysicalPixelDisplaySizeRatio;
        private final int mRotation;
        private final float mScale;

        public ImplBase(String str, int i, int i2, float f, int i3, int i4, int i5, float f2) {
            this.mDisplayShapeSpec = str;
            this.mDisplayWidth = i;
            this.mDisplayHeight = i2;
            this.mPhysicalPixelDisplaySizeRatio = f;
            this.mRotation = i3;
            this.mOffsetX = i4;
            this.mOffsetY = i5;
            this.mScale = f2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ImplBase)) {
                return false;
            }
            ImplBase implBase = (ImplBase) obj;
            return Objects.equals(this.mDisplayShapeSpec, implBase.mDisplayShapeSpec) && this.mDisplayWidth == implBase.mDisplayWidth && this.mDisplayHeight == implBase.mDisplayHeight && this.mPhysicalPixelDisplaySizeRatio == implBase.mPhysicalPixelDisplaySizeRatio && this.mRotation == implBase.mRotation && this.mOffsetX == implBase.mOffsetX && this.mOffsetY == implBase.mOffsetY && this.mScale == implBase.mScale;
        }

        public int hashCode() {
            return Objects.hash(this.mDisplayShapeSpec, Integer.valueOf(this.mDisplayWidth), Integer.valueOf(this.mDisplayHeight), Float.valueOf(this.mPhysicalPixelDisplaySizeRatio), Integer.valueOf(this.mRotation), Integer.valueOf(this.mOffsetX), Integer.valueOf(this.mOffsetY), Float.valueOf(this.mScale));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("DisplayShapeCompat{ spec=");
            String str = this.mDisplayShapeSpec;
            sb.append(str != null ? Integer.valueOf(str.hashCode()) : "null");
            sb.append(" displayWidth=");
            sb.append(this.mDisplayWidth);
            sb.append(" displayHeight=");
            sb.append(this.mDisplayHeight);
            sb.append(" physicalPixelDisplaySizeRatio=");
            sb.append(this.mPhysicalPixelDisplaySizeRatio);
            sb.append(" rotation=");
            sb.append(this.mRotation);
            sb.append(" offsetX=");
            sb.append(this.mOffsetX);
            sb.append(" offsetY=");
            sb.append(this.mOffsetY);
            sb.append(" scale=");
            sb.append(this.mScale);
            sb.append("}");
            return sb.toString();
        }
    }

    private DisplayShapeCompat(String str, int i, int i2, float f, int i3, int i4, int i5, float f2) {
        this.mImpl = new ImplBase(str, i, i2, f, i3, i4, i5, f2);
    }

    public static DisplayShapeCompat create(int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
        return new DisplayShapeCompat(createSpecString(i, i2, z, i3, i4, i5, i6), i, i2, 1.0f, 0, 0, 0, 1.0f);
    }

    private static String createSpecString(int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
        if (z) {
            int i7 = i / 2;
            int i8 = i2 / 2;
            StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(i8, i7, "M0,", " A", ",");
            Fragment$$ExternalSyntheticOutline1.m(sbM, i8, " 0 1,1 ", i, ",");
            Fragment$$ExternalSyntheticOutline1.m(sbM, i8, " A", i7, ",");
            sbM.append(i8);
            sbM.append(" 0 1,1 0,");
            sbM.append(i8);
            sbM.append(" Z");
            return sbM.toString();
        }
        StringBuilder sb = new StringBuilder("M ");
        int iMin = Math.min(i / 2, i2 / 2);
        int iMin2 = Math.min(iMin, i3);
        int iMin3 = Math.min(iMin, i4);
        int iMin4 = Math.min(iMin, i5);
        int iMin5 = Math.min(iMin, i6);
        sb.append(iMin2);
        sb.append(",0 L ");
        sb.append(i - iMin3);
        sb.append(",0");
        if (iMin3 > 0) {
            Fragment$$ExternalSyntheticOutline1.m(sb, " A ", iMin3, ",", iMin3);
            Fragment$$ExternalSyntheticOutline1.m(sb, " 0 0,1 ", i, ",", iMin3);
        }
        sb.append(" L ");
        sb.append(i);
        sb.append(",");
        sb.append(i2 - iMin4);
        if (iMin4 > 0) {
            Fragment$$ExternalSyntheticOutline1.m(sb, " A ", iMin4, ",", iMin4);
            sb.append(" 0 0,1 ");
            sb.append(i - iMin4);
            sb.append(",");
            sb.append(i2);
        }
        Fragment$$ExternalSyntheticOutline1.m(sb, " L ", iMin5, ",", i2);
        if (iMin5 > 0) {
            Fragment$$ExternalSyntheticOutline1.m(sb, " A ", iMin5, ",", iMin5);
            sb.append(" 0 0,1 0,");
            sb.append(i2 - iMin5);
        }
        if (iMin2 > 0) {
            Fragment$$ExternalSyntheticOutline1.m(sb, " L 0,", iMin2, " A ", iMin2);
            Fragment$$ExternalSyntheticOutline1.m(sb, ",", iMin2, " 0 0,1 ", iMin2);
            sb.append(",0");
        }
        sb.append(" Z");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DisplayShapeCompat) {
            return Objects.equals(this.mImpl, ((DisplayShapeCompat) obj).mImpl);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.mImpl);
    }

    public String toString() {
        return this.mImpl.toString();
    }
}
