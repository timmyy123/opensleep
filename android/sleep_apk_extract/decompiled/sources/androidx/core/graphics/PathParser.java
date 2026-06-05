package androidx.core.graphics;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
public abstract class PathParser {

    public static class ExtractFloatResult {
        int mEndPosition;
        boolean mEndWithNegOrDot;
    }

    private static void addNode(ArrayList<PathDataNode> arrayList, char c, float[] fArr) {
        arrayList.add(new PathDataNode(c, fArr));
    }

    public static boolean canMorph(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr.length != pathDataNodeArr2.length) {
            return false;
        }
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            if (pathDataNodeArr[i].mType != pathDataNodeArr2[i].mType || pathDataNodeArr[i].mParams.length != pathDataNodeArr2[i].mParams.length) {
                return false;
            }
        }
        return true;
    }

    public static float[] copyOfRange(float[] fArr, int i, int i2) {
        if (i > i2) {
            Utf8$$ExternalSyntheticBUOutline0.m$3();
            return null;
        }
        int length = fArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        int iMin = Math.min(i3, length - i);
        float[] fArr2 = new float[i3];
        System.arraycopy(fArr, i, fArr2, 0, iMin);
        return fArr2;
    }

    public static PathDataNode[] createNodesFromPathData(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 1;
        while (i2 < str.length()) {
            int iNextStart = nextStart(str, i2);
            String strTrim = str.substring(i, iNextStart).trim();
            if (!strTrim.isEmpty()) {
                addNode(arrayList, strTrim.charAt(0), getFloats(strTrim));
            }
            i = iNextStart;
            i2 = iNextStart + 1;
        }
        if (i2 - i == 1 && i < str.length()) {
            addNode(arrayList, str.charAt(i), new float[0]);
        }
        return (PathDataNode[]) arrayList.toArray(new PathDataNode[0]);
    }

    public static Path createPathFromPathData(String str) {
        Path path = new Path();
        try {
            PathDataNode.nodesToPath(createNodesFromPathData(str), path);
            return path;
        } catch (RuntimeException e) {
            Utf8$$ExternalSyntheticBUOutline0.m(FileInsert$$ExternalSyntheticOutline0.m("Error in parsing ", str), (Throwable) e);
            return null;
        }
    }

    public static PathDataNode[] deepCopyNodes(PathDataNode[] pathDataNodeArr) {
        PathDataNode[] pathDataNodeArr2 = new PathDataNode[pathDataNodeArr.length];
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            pathDataNodeArr2[i] = new PathDataNode(pathDataNodeArr[i]);
        }
        return pathDataNodeArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0039 A[LOOP:0: B:3:0x0007->B:24:0x0039, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void extract(String str, int i, ExtractFloatResult extractFloatResult) {
        extractFloatResult.mEndWithNegOrDot = false;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (int i2 = i; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == ' ') {
                z = false;
                z3 = true;
                if (z3) {
                }
            } else {
                if (cCharAt != 'E' && cCharAt != 'e') {
                    switch (cCharAt) {
                        case ',':
                            break;
                        case '-':
                            if (i2 == i || z) {
                                z = false;
                            } else {
                                extractFloatResult.mEndWithNegOrDot = true;
                                z = false;
                                z3 = true;
                            }
                            break;
                        case '.':
                            if (z2) {
                                extractFloatResult.mEndWithNegOrDot = true;
                                z = false;
                                z3 = true;
                            } else {
                                z = false;
                                z2 = true;
                            }
                            break;
                        default:
                            z = false;
                            break;
                    }
                } else {
                    z = true;
                }
                if (z3) {
                }
            }
            extractFloatResult.mEndPosition = i2;
        }
        extractFloatResult.mEndPosition = i2;
    }

    private static float[] getFloats(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            ExtractFloatResult extractFloatResult = new ExtractFloatResult();
            int length = str.length();
            int i = 1;
            int i2 = 0;
            while (i < length) {
                extract(str, i, extractFloatResult);
                int i3 = extractFloatResult.mEndPosition;
                if (i < i3) {
                    fArr[i2] = Float.parseFloat(str.substring(i, i3));
                    i2++;
                }
                i = extractFloatResult.mEndWithNegOrDot ? i3 : i3 + 1;
            }
            return copyOfRange(fArr, 0, i2);
        } catch (NumberFormatException e) {
            Utf8$$ExternalSyntheticBUOutline0.m(FileInsert$$ExternalSyntheticOutline0.m("error in parsing \"", str, "\""), (Throwable) e);
            return null;
        }
    }

    private static int nextStart(String str, int i) {
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if ((cCharAt - 'Z') * (cCharAt - 'A') > 0) {
                if ((cCharAt - 'z') * (cCharAt - 'a') > 0) {
                    continue;
                }
                i++;
            }
            if (cCharAt != 'e' && cCharAt != 'E') {
                break;
            }
            i++;
        }
        return i;
    }

    public static void nodesToPath(PathDataNode[] pathDataNodeArr, Path path) {
        float[] fArr = new float[6];
        char c = 'm';
        for (PathDataNode pathDataNode : pathDataNodeArr) {
            PathDataNode.addCommand(path, fArr, c, pathDataNode.mType, pathDataNode.mParams);
            c = pathDataNode.mType;
        }
    }

    public static void updateNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        for (int i = 0; i < pathDataNodeArr2.length; i++) {
            pathDataNodeArr[i].mType = pathDataNodeArr2[i].mType;
            for (int i2 = 0; i2 < pathDataNodeArr2[i].mParams.length; i2++) {
                pathDataNodeArr[i].mParams[i2] = pathDataNodeArr2[i].mParams[i2];
            }
        }
    }

    public static class PathDataNode {
        private final float[] mParams;
        private char mType;

        public PathDataNode(PathDataNode pathDataNode) {
            this.mType = pathDataNode.mType;
            float[] fArr = pathDataNode.mParams;
            this.mParams = PathParser.copyOfRange(fArr, 0, fArr.length);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public static void addCommand(Path path, float[] fArr, char c, char c2, float[] fArr2) {
            int i;
            int i2;
            boolean z;
            boolean z2;
            char c3;
            char c4;
            int i3;
            float f;
            boolean z3;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            boolean z4;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11;
            float f12;
            float f13;
            float f14;
            float f15;
            float f16;
            Path path2 = path;
            boolean z5 = false;
            float f17 = fArr[0];
            boolean z6 = true;
            float f18 = fArr[1];
            char c5 = 2;
            float f19 = fArr[2];
            char c6 = 3;
            float f20 = fArr[3];
            float f21 = fArr[4];
            float f22 = fArr[5];
            switch (c2) {
                case 'A':
                case 'a':
                    i = 7;
                    i2 = i;
                    break;
                case 'C':
                case 'c':
                    i = 6;
                    i2 = i;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i2 = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                default:
                    i2 = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i2 = 4;
                    break;
                case 'Z':
                case 'z':
                    path2.close();
                    path2.moveTo(f21, f22);
                    f17 = f21;
                    f19 = f17;
                    f18 = f22;
                    f20 = f18;
                    i2 = 2;
                    break;
            }
            float f23 = f17;
            float f24 = f18;
            float f25 = f21;
            float f26 = f22;
            int i4 = 0;
            char c7 = c;
            while (i4 < fArr2.length) {
                if (c2 == 'A') {
                    float f27 = f23;
                    float f28 = f24;
                    z = z5;
                    z2 = z6;
                    c3 = c5;
                    c4 = c6;
                    i3 = i4;
                    int i5 = i3 + 5;
                    float f29 = fArr2[i5];
                    int i6 = i3 + 6;
                    float f30 = fArr2[i6];
                    float f31 = fArr2[i3];
                    float f32 = fArr2[i3 + 1];
                    float f33 = fArr2[i3 + 2];
                    if (fArr2[i3 + 3] != 0.0f) {
                        f = 0.0f;
                        z3 = z2;
                    } else {
                        f = 0.0f;
                        z3 = z;
                    }
                    drawArc(path, f27, f28, f29, f30, f31, f32, f33, z3, fArr2[i3 + 4] != f ? z2 : z);
                    f19 = fArr2[i5];
                    f23 = f19;
                    f20 = fArr2[i6];
                    f24 = f20;
                } else if (c2 == 'C') {
                    z = z5;
                    z2 = z6;
                    c3 = c5;
                    c4 = c6;
                    i3 = i4;
                    int i7 = i3 + 2;
                    int i8 = i3 + 3;
                    int i9 = i3 + 4;
                    int i10 = i3 + 5;
                    path2.cubicTo(fArr2[i3], fArr2[i3 + 1], fArr2[i7], fArr2[i8], fArr2[i9], fArr2[i10]);
                    float f34 = fArr2[i9];
                    float f35 = fArr2[i10];
                    float f36 = fArr2[i7];
                    float f37 = fArr2[i8];
                    f23 = f34;
                    f24 = f35;
                    f20 = f37;
                    f19 = f36;
                } else if (c2 != 'H') {
                    if (c2 != 'Q') {
                        z = z5;
                        if (c2 == 'V') {
                            z2 = z6;
                            c3 = c5;
                            c4 = c6;
                            i3 = i4;
                            path2.lineTo(f23, fArr2[i3]);
                            f4 = fArr2[i3];
                        } else if (c2 != 'a') {
                            if (c2 != 'c') {
                                z2 = z6;
                                if (c2 != 'h') {
                                    if (c2 != 'q') {
                                        c3 = c5;
                                        if (c2 != 'v') {
                                            if (c2 != 'L') {
                                                if (c2 != 'M') {
                                                    c4 = c6;
                                                    if (c2 == 'S') {
                                                        if (c7 == 'c' || c7 == 's' || c7 == 'C' || c7 == 'S') {
                                                            f23 = (f23 * 2.0f) - f19;
                                                            f24 = (f24 * 2.0f) - f20;
                                                        }
                                                        float f38 = f23;
                                                        float f39 = f24;
                                                        int i11 = i4 + 1;
                                                        int i12 = i4 + 2;
                                                        int i13 = i4 + 3;
                                                        path2.cubicTo(f38, f39, fArr2[i4], fArr2[i11], fArr2[i12], fArr2[i13]);
                                                        f2 = fArr2[i4];
                                                        f3 = fArr2[i11];
                                                        f23 = fArr2[i12];
                                                        f24 = fArr2[i13];
                                                        i3 = i4;
                                                    } else if (c2 == 'T') {
                                                        if (c7 == 'q' || c7 == 't' || c7 == 'Q' || c7 == 'T') {
                                                            f23 = (f23 * 2.0f) - f19;
                                                            f24 = (f24 * 2.0f) - f20;
                                                        }
                                                        int i14 = i4 + 1;
                                                        path2.quadTo(f23, f24, fArr2[i4], fArr2[i14]);
                                                        float f40 = fArr2[i4];
                                                        f4 = fArr2[i14];
                                                        f19 = f23;
                                                        f20 = f24;
                                                        i3 = i4;
                                                        f23 = f40;
                                                    } else if (c2 == 'l') {
                                                        int i15 = i4 + 1;
                                                        path2.rLineTo(fArr2[i4], fArr2[i15]);
                                                        f23 += fArr2[i4];
                                                        f10 = fArr2[i15];
                                                    } else if (c2 == 'm') {
                                                        float f41 = fArr2[i4];
                                                        f23 += f41;
                                                        float f42 = fArr2[i4 + 1];
                                                        f24 += f42;
                                                        if (i4 > 0) {
                                                            path2.rLineTo(f41, f42);
                                                        } else {
                                                            path2.rMoveTo(f41, f42);
                                                            f25 = f23;
                                                        }
                                                    } else if (c2 == 's') {
                                                        if (c7 == 'c' || c7 == 's' || c7 == 'C' || c7 == 'S') {
                                                            f13 = f24 - f20;
                                                            f14 = f23 - f19;
                                                        } else {
                                                            f14 = 0.0f;
                                                            f13 = 0.0f;
                                                        }
                                                        int i16 = i4 + 1;
                                                        int i17 = i4 + 2;
                                                        int i18 = i4 + 3;
                                                        path2.rCubicTo(f14, f13, fArr2[i4], fArr2[i16], fArr2[i17], fArr2[i18]);
                                                        f7 = fArr2[i4] + f23;
                                                        f8 = fArr2[i16] + f24;
                                                        f23 += fArr2[i17];
                                                        f9 = fArr2[i18];
                                                    } else if (c2 == 't') {
                                                        if (c7 == 'q' || c7 == 't' || c7 == 'Q' || c7 == 'T') {
                                                            f15 = f23 - f19;
                                                            f16 = f24 - f20;
                                                        } else {
                                                            f16 = 0.0f;
                                                            f15 = 0.0f;
                                                        }
                                                        int i19 = i4 + 1;
                                                        path2.rQuadTo(f15, f16, fArr2[i4], fArr2[i19]);
                                                        float f43 = f15 + f23;
                                                        float f44 = f16 + f24;
                                                        f23 += fArr2[i4];
                                                        f24 += fArr2[i19];
                                                        f20 = f44;
                                                        f19 = f43;
                                                    }
                                                } else {
                                                    c4 = c6;
                                                    f11 = fArr2[i4];
                                                    f12 = fArr2[i4 + 1];
                                                    if (i4 > 0) {
                                                        path2.lineTo(f11, f12);
                                                    } else {
                                                        path2.moveTo(f11, f12);
                                                        f23 = f11;
                                                        f25 = f23;
                                                        f24 = f12;
                                                    }
                                                }
                                                f26 = f24;
                                            } else {
                                                c4 = c6;
                                                int i20 = i4 + 1;
                                                path2.lineTo(fArr2[i4], fArr2[i20]);
                                                f11 = fArr2[i4];
                                                f12 = fArr2[i20];
                                            }
                                            f23 = f11;
                                            f24 = f12;
                                        } else {
                                            c4 = c6;
                                            path2.rLineTo(0.0f, fArr2[i4]);
                                            f10 = fArr2[i4];
                                        }
                                        f24 += f10;
                                    } else {
                                        c3 = c5;
                                        c4 = c6;
                                        int i21 = i4 + 1;
                                        int i22 = i4 + 2;
                                        int i23 = i4 + 3;
                                        path2.rQuadTo(fArr2[i4], fArr2[i21], fArr2[i22], fArr2[i23]);
                                        f7 = fArr2[i4] + f23;
                                        f8 = fArr2[i21] + f24;
                                        f23 += fArr2[i22];
                                        f9 = fArr2[i23];
                                    }
                                    f24 += f9;
                                    f19 = f7;
                                    f20 = f8;
                                } else {
                                    c3 = c5;
                                    c4 = c6;
                                    path2.rLineTo(fArr2[i4], 0.0f);
                                    f23 += fArr2[i4];
                                }
                            } else {
                                z2 = z6;
                                c3 = c5;
                                c4 = c6;
                                int i24 = i4 + 2;
                                int i25 = i4 + 3;
                                int i26 = i4 + 4;
                                int i27 = i4 + 5;
                                path2.rCubicTo(fArr2[i4], fArr2[i4 + 1], fArr2[i24], fArr2[i25], fArr2[i26], fArr2[i27]);
                                float f45 = fArr2[i24] + f23;
                                float f46 = fArr2[i25] + f24;
                                f23 += fArr2[i26];
                                f24 += fArr2[i27];
                                f19 = f45;
                                f20 = f46;
                            }
                            i3 = i4;
                        } else {
                            z2 = z6;
                            c3 = c5;
                            c4 = c6;
                            int i28 = i4 + 5;
                            float f47 = fArr2[i28] + f23;
                            int i29 = i4 + 6;
                            float f48 = fArr2[i29] + f24;
                            float f49 = fArr2[i4];
                            float f50 = fArr2[i4 + 1];
                            float f51 = fArr2[i4 + 2];
                            if (fArr2[i4 + 3] != 0.0f) {
                                f5 = 0.0f;
                                f6 = f24;
                                z4 = z2;
                            } else {
                                f5 = 0.0f;
                                f6 = f24;
                                z4 = z;
                            }
                            i3 = i4;
                            boolean z7 = fArr2[i4 + 4] != f5 ? z2 : z;
                            float f52 = f23;
                            drawArc(path, f52, f6, f47, f48, f49, f50, f51, z4, z7);
                            f23 = f52 + fArr2[i28];
                            f24 = f6 + fArr2[i29];
                            f19 = f23;
                            f20 = f24;
                        }
                        f24 = f4;
                    } else {
                        z = z5;
                        z2 = z6;
                        c3 = c5;
                        c4 = c6;
                        i3 = i4;
                        int i30 = i3 + 1;
                        int i31 = i3 + 2;
                        int i32 = i3 + 3;
                        path2.quadTo(fArr2[i3], fArr2[i30], fArr2[i31], fArr2[i32]);
                        f2 = fArr2[i3];
                        f3 = fArr2[i30];
                        f23 = fArr2[i31];
                        f24 = fArr2[i32];
                    }
                    f19 = f2;
                    f20 = f3;
                } else {
                    z = z5;
                    z2 = z6;
                    c3 = c5;
                    c4 = c6;
                    i3 = i4;
                    path2.lineTo(fArr2[i3], f24);
                    f23 = fArr2[i3];
                }
                i4 = i3 + i2;
                path2 = path;
                c7 = c2;
                z5 = z;
                z6 = z2;
                c5 = c3;
                c6 = c4;
            }
            fArr[z5 ? 1 : 0] = f23;
            fArr[z6 ? 1 : 0] = f24;
            fArr[c5] = f19;
            fArr[c6] = f20;
            fArr[4] = f25;
            fArr[5] = f26;
        }

        private static void arcToBezier(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
            double d10 = d3;
            int iCeil = (int) Math.ceil(Math.abs((d9 * 4.0d) / 3.141592653589793d));
            double dCos = Math.cos(d7);
            double dSin = Math.sin(d7);
            double dCos2 = Math.cos(d8);
            double dSin2 = Math.sin(d8);
            double d11 = -d10;
            double d12 = d11 * dCos;
            double d13 = d4 * dSin;
            double d14 = (d12 * dSin2) - (d13 * dCos2);
            double d15 = d11 * dSin;
            double d16 = d4 * dCos;
            double d17 = (dCos2 * d16) + (dSin2 * d15);
            double d18 = d9 / ((double) iCeil);
            double d19 = d17;
            double d20 = d14;
            int i = 0;
            double d21 = d5;
            double d22 = d6;
            double d23 = d8;
            while (i < iCeil) {
                double d24 = d23 + d18;
                double dSin3 = Math.sin(d24);
                double dCos3 = Math.cos(d24);
                double d25 = (((d10 * dCos) * dCos3) + d) - (d13 * dSin3);
                int i2 = i;
                double d26 = (d16 * dSin3) + (d3 * dSin * dCos3) + d2;
                double d27 = (d12 * dSin3) - (d13 * dCos3);
                double d28 = (dCos3 * d16) + (dSin3 * d15);
                double d29 = d24 - d23;
                double dTan = Math.tan(d29 / 2.0d);
                double dSqrt = ((Math.sqrt(((dTan * 3.0d) * dTan) + 4.0d) - 1.0d) * Math.sin(d29)) / 3.0d;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) ((d20 * dSqrt) + d21), (float) ((d19 * dSqrt) + d22), (float) (d25 - (dSqrt * d27)), (float) (d26 - (dSqrt * d28)), (float) d25, (float) d26);
                dSin = dSin;
                d18 = d18;
                d21 = d25;
                d15 = d15;
                dCos = dCos;
                d19 = d28;
                d20 = d27;
                d10 = d3;
                d22 = d26;
                i = i2 + 1;
                iCeil = iCeil;
                d23 = d24;
            }
        }

        private static void drawArc(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
            double d;
            double d2;
            double radians = Math.toRadians(f7);
            double dCos = Math.cos(radians);
            double dSin = Math.sin(radians);
            double d3 = f;
            double d4 = f2;
            double d5 = f5;
            double d6 = ((d4 * dSin) + (d3 * dCos)) / d5;
            double d7 = f6;
            double d8 = ((d4 * dCos) + (((double) (-f)) * dSin)) / d7;
            double d9 = f4;
            double d10 = ((d9 * dSin) + (((double) f3) * dCos)) / d5;
            double d11 = ((d9 * dCos) + (((double) (-f3)) * dSin)) / d7;
            double d12 = d6 - d10;
            double d13 = d8 - d11;
            double d14 = (d6 + d10) / 2.0d;
            double d15 = (d8 + d11) / 2.0d;
            double d16 = (d13 * d13) + (d12 * d12);
            if (d16 == 0.0d) {
                Log.w("PathParser", " Points are coincident");
                return;
            }
            double d17 = (1.0d / d16) - 0.25d;
            if (d17 < 0.0d) {
                Log.w("PathParser", "Points are too far apart " + d16);
                float fSqrt = (float) (Math.sqrt(d16) / 1.99999d);
                drawArc(path, f, f2, f3, f4, f5 * fSqrt, fSqrt * f6, f7, z, z2);
                return;
            }
            double dSqrt = Math.sqrt(d17);
            double d18 = dSqrt * d12;
            double d19 = dSqrt * d13;
            if (z == z2) {
                d = d14 - d19;
                d2 = d15 + d18;
            } else {
                d = d14 + d19;
                d2 = d15 - d18;
            }
            double dAtan2 = Math.atan2(d8 - d2, d6 - d);
            double dAtan22 = Math.atan2(d11 - d2, d10 - d) - dAtan2;
            if (z2 != (dAtan22 >= 0.0d)) {
                dAtan22 = dAtan22 > 0.0d ? dAtan22 - 6.283185307179586d : dAtan22 + 6.283185307179586d;
            }
            double d20 = d * d5;
            double d21 = d2 * d7;
            arcToBezier(path, (d20 * dCos) - (d21 * dSin), (d21 * dCos) + (d20 * dSin), d5, d7, d3, d4, radians, dAtan2, dAtan22);
        }

        @Deprecated
        public static void nodesToPath(PathDataNode[] pathDataNodeArr, Path path) {
            PathParser.nodesToPath(pathDataNodeArr, path);
        }

        public PathDataNode(char c, float[] fArr) {
            this.mType = c;
            this.mParams = fArr;
        }
    }
}
