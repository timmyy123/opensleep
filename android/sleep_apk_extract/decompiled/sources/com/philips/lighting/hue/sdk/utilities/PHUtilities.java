package com.philips.lighting.hue.sdk.utilities;

import com.philips.lighting.hue.sdk.bridge.impl.PHHueResourcesConstants;
import com.philips.lighting.hue.sdk.clip.serialisation.sensors.PHSwitchSerializer1;
import com.philips.lighting.hue.sdk.utilities.impl.Color;
import com.philips.lighting.hue.sdk.utilities.impl.PHHueHelper;
import com.philips.lighting.hue.sdk.utilities.impl.PointF;
import com.philips.lighting.model.sensor.metadata.PHSwitchDeviceInfo;
import j$.util.DesugarTimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.json.hue.JSONArray;
import org.json.hue.JSONException;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class PHUtilities {
    private static final int CPT_BLUE = 2;
    private static final int CPT_GREEN = 1;
    private static final int CPT_RED = 0;
    private static final List<String> GAMUT_A_BULBS_LIST;
    private static final List<String> GAMUT_B_BULBS_LIST;
    private static final List<String> GAMUT_C_BULBS_LIST;
    private static final List<String> MULTI_SOURCE_LUMINAIRES;
    private static List<PointF> colorPointsGamut_A = new ArrayList();
    private static List<PointF> colorPointsGamut_B = new ArrayList();
    private static List<PointF> colorPointsGamut_C = new ArrayList();
    private static List<PointF> colorPointsDefault = new ArrayList();

    static {
        ArrayList arrayList = new ArrayList();
        GAMUT_A_BULBS_LIST = arrayList;
        ArrayList arrayList2 = new ArrayList();
        GAMUT_B_BULBS_LIST = arrayList2;
        ArrayList arrayList3 = new ArrayList();
        GAMUT_C_BULBS_LIST = arrayList3;
        ArrayList arrayList4 = new ArrayList();
        MULTI_SOURCE_LUMINAIRES = arrayList4;
        arrayList.add("LLC001");
        arrayList.add("LLC005");
        arrayList.add("LLC006");
        arrayList.add("LLC007");
        arrayList.add("LLC010");
        arrayList.add("LLC011");
        arrayList.add("LLC012");
        arrayList.add("LLC014");
        arrayList.add("LLC013");
        arrayList.add("LST001");
        arrayList2.add("LCT001");
        arrayList2.add("LCT002");
        arrayList2.add("LCT003");
        arrayList2.add("LCT004");
        arrayList2.add("LLM001");
        arrayList2.add("LCT005");
        arrayList2.add("LCT006");
        arrayList2.add("LCT007");
        arrayList3.add("LLC020");
        arrayList3.add("LST002");
        arrayList4.add("HBL001");
        arrayList4.add("HBL002");
        arrayList4.add("HBL003");
        arrayList4.add("HIL001");
        arrayList4.add("HIL002");
        arrayList4.add("HEL001");
        arrayList4.add("HEL002");
        colorPointsGamut_A.add(new PointF(0.703f, 0.296f));
        colorPointsGamut_A.add(new PointF(0.214f, 0.709f));
        colorPointsGamut_A.add(new PointF(0.139f, 0.081f));
        colorPointsGamut_B.add(new PointF(0.674f, 0.322f));
        colorPointsGamut_B.add(new PointF(0.408f, 0.517f));
        colorPointsGamut_B.add(new PointF(0.168f, 0.041f));
        colorPointsGamut_C.add(new PointF(0.692f, 0.308f));
        colorPointsGamut_C.add(new PointF(0.17f, 0.7f));
        colorPointsGamut_C.add(new PointF(0.153f, 0.048f));
        colorPointsDefault.add(new PointF(1.0f, 0.0f));
        colorPointsDefault.add(new PointF(0.0f, 1.0f));
        colorPointsDefault.add(new PointF(0.0f, 0.0f));
    }

    public static float[] calculateXY(int i, String str) {
        float fRed = Color.red(i) / 255.0f;
        float fGreen = Color.green(i) / 255.0f;
        float fBlue = Color.blue(i) / 255.0f;
        float fPow = fRed > 0.04045f ? (float) Math.pow((fRed + 0.055f) / 1.055f, 2.4000000953674316d) : fRed / 12.92f;
        float fPow2 = fGreen > 0.04045f ? (float) Math.pow((fGreen + 0.055f) / 1.055f, 2.4000000953674316d) : fGreen / 12.92f;
        float fPow3 = fBlue > 0.04045f ? (float) Math.pow((fBlue + 0.055f) / 1.055f, 2.4000000953674316d) : fBlue / 12.92f;
        float f = (0.162028f * fPow3) + (0.154324f * fPow2) + (0.664511f * fPow);
        float f2 = (0.047685f * fPow3) + (0.668433f * fPow2) + (0.283881f * fPow);
        float f3 = f + f2 + (fPow3 * 0.986039f) + (fPow2 * 0.07231f) + (fPow * 8.8E-5f);
        float f4 = f / f3;
        float[] fArr = {f4, f2 / f3};
        if (Float.isNaN(f4)) {
            fArr[0] = 0.0f;
        }
        if (Float.isNaN(fArr[1])) {
            fArr[1] = 0.0f;
        }
        PointF pointF = new PointF(fArr[0], fArr[1]);
        List<PointF> listColorPointsForModel = colorPointsForModel(str);
        if (!checkPointInLampsReach(pointF, listColorPointsForModel)) {
            PointF closestPointToPoints = getClosestPointToPoints(listColorPointsForModel.get(0), listColorPointsForModel.get(1), pointF);
            PointF closestPointToPoints2 = getClosestPointToPoints(listColorPointsForModel.get(2), listColorPointsForModel.get(0), pointF);
            PointF closestPointToPoints3 = getClosestPointToPoints(listColorPointsForModel.get(1), listColorPointsForModel.get(2), pointF);
            float distanceBetweenTwoPoints = getDistanceBetweenTwoPoints(pointF, closestPointToPoints);
            float distanceBetweenTwoPoints2 = getDistanceBetweenTwoPoints(pointF, closestPointToPoints2);
            float distanceBetweenTwoPoints3 = getDistanceBetweenTwoPoints(pointF, closestPointToPoints3);
            if (distanceBetweenTwoPoints2 < distanceBetweenTwoPoints) {
                closestPointToPoints = closestPointToPoints2;
                distanceBetweenTwoPoints = distanceBetweenTwoPoints2;
            }
            if (distanceBetweenTwoPoints3 >= distanceBetweenTwoPoints) {
                closestPointToPoints3 = closestPointToPoints;
            }
            fArr[0] = closestPointToPoints3.x;
            fArr[1] = closestPointToPoints3.y;
        }
        fArr[0] = PHHueHelper.precision(fArr[0]);
        fArr[1] = PHHueHelper.precision(fArr[1]);
        return fArr;
    }

    public static float[] calculateXYFromRGB(int i, int i2, int i3, String str) {
        return calculateXY(Color.rgb(i, i2, i3), str);
    }

    private static boolean checkPointInLampsReach(PointF pointF, List<PointF> list) {
        if (pointF != null && list != null) {
            PointF pointF2 = list.get(0);
            PointF pointF3 = list.get(1);
            PointF pointF4 = list.get(2);
            PointF pointF5 = new PointF(pointF3.x - pointF2.x, pointF3.y - pointF2.y);
            PointF pointF6 = new PointF(pointF4.x - pointF2.x, pointF4.y - pointF2.y);
            PointF pointF7 = new PointF(pointF.x - pointF2.x, pointF.y - pointF2.y);
            float fCrossProduct = crossProduct(pointF7, pointF6) / crossProduct(pointF5, pointF6);
            float fCrossProduct2 = crossProduct(pointF5, pointF7) / crossProduct(pointF5, pointF6);
            if (fCrossProduct >= 0.0f && fCrossProduct2 >= 0.0f && fCrossProduct + fCrossProduct2 <= 1.0f) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x014a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int colorFromXY(float[] fArr, String str) {
        if (fArr == null || str == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(PHHueResourcesConstants.TXT_INVALID_INPUT);
            return 0;
        }
        PointF pointF = new PointF(fArr[0], fArr[1]);
        List<PointF> listColorPointsForModel = colorPointsForModel(str);
        if (!checkPointInLampsReach(pointF, listColorPointsForModel)) {
            PointF closestPointToPoints = getClosestPointToPoints(listColorPointsForModel.get(0), listColorPointsForModel.get(1), pointF);
            PointF closestPointToPoints2 = getClosestPointToPoints(listColorPointsForModel.get(2), listColorPointsForModel.get(0), pointF);
            PointF closestPointToPoints3 = getClosestPointToPoints(listColorPointsForModel.get(1), listColorPointsForModel.get(2), pointF);
            float distanceBetweenTwoPoints = getDistanceBetweenTwoPoints(pointF, closestPointToPoints);
            float distanceBetweenTwoPoints2 = getDistanceBetweenTwoPoints(pointF, closestPointToPoints2);
            float distanceBetweenTwoPoints3 = getDistanceBetweenTwoPoints(pointF, closestPointToPoints3);
            if (distanceBetweenTwoPoints2 < distanceBetweenTwoPoints) {
                closestPointToPoints = closestPointToPoints2;
                distanceBetweenTwoPoints = distanceBetweenTwoPoints2;
            }
            if (distanceBetweenTwoPoints3 >= distanceBetweenTwoPoints) {
                closestPointToPoints3 = closestPointToPoints;
            }
            pointF.x = closestPointToPoints3.x;
            pointF.y = closestPointToPoints3.y;
        }
        float f = pointF.x;
        float f2 = pointF.y;
        float f3 = 1.0f;
        float f4 = (1.0f - f) - f2;
        float f5 = 1.0f / f2;
        float f6 = f * f5;
        float f7 = f5 * f4;
        float f8 = ((1.656492f * f6) - 0.354851f) - (0.255038f * f7);
        float f9 = (0.036152f * f7) + ((-f6) * 0.707196f) + 1.655397f;
        float f10 = (f7 * 1.01153f) + ((f6 * 0.051713f) - 0.121364f);
        if (f8 > f10 && f8 > f9 && f8 > 1.0f) {
            f9 /= f8;
            f10 /= f8;
            f8 = 1.0f;
        } else if (f9 > f10 && f9 > f8 && f9 > 1.0f) {
            f8 /= f9;
            f10 /= f9;
            f9 = 1.0f;
        } else if (f10 > f8 && f10 > f9 && f10 > 1.0f) {
            f8 /= f10;
            f9 /= f10;
            f10 = 1.0f;
        }
        float fPow = f8 <= 0.0031308f ? f8 * 12.92f : (((float) Math.pow(f8, 0.4166666567325592d)) * 1.055f) - 0.055f;
        float fPow2 = f9 <= 0.0031308f ? f9 * 12.92f : (((float) Math.pow(f9, 0.4166666567325592d)) * 1.055f) - 0.055f;
        float fPow3 = f10 <= 0.0031308f ? f10 * 12.92f : (((float) Math.pow(f10, 0.4166666567325592d)) * 1.055f) - 0.055f;
        if (fPow > fPow3 && fPow > fPow2) {
            if (fPow > 1.0f) {
                fPow2 /= fPow;
                fPow3 /= fPow;
            }
            if (f3 < 0.0f) {
                f3 = 0.0f;
            }
            if (fPow2 < 0.0f) {
                fPow2 = 0.0f;
            }
            if (fPow3 < 0.0f) {
                fPow3 = 0.0f;
            }
            return Color.rgb((int) (f3 * 255.0f), (int) (fPow2 * 255.0f), (int) (fPow3 * 255.0f));
        }
        if (fPow2 <= fPow3 || fPow2 <= fPow) {
            if (fPow3 > fPow && fPow3 > fPow2 && fPow3 > 1.0f) {
                fPow /= fPow3;
                fPow2 /= fPow3;
                fPow3 = 1.0f;
            }
        } else if (fPow2 > 1.0f) {
            fPow /= fPow2;
            fPow3 /= fPow2;
            fPow2 = 1.0f;
        }
        f3 = fPow;
        if (f3 < 0.0f) {
        }
        if (fPow2 < 0.0f) {
        }
        if (fPow3 < 0.0f) {
        }
        return Color.rgb((int) (f3 * 255.0f), (int) (fPow2 * 255.0f), (int) (fPow3 * 255.0f));
    }

    private static List<PointF> colorPointsForModel(String str) {
        if (str == null) {
            str = " ";
        }
        return (GAMUT_B_BULBS_LIST.contains(str) || MULTI_SOURCE_LUMINAIRES.contains(str)) ? colorPointsGamut_B : GAMUT_A_BULBS_LIST.contains(str) ? colorPointsGamut_A : GAMUT_C_BULBS_LIST.contains(str) ? colorPointsGamut_C : colorPointsDefault;
    }

    private static float crossProduct(PointF pointF, PointF pointF2) {
        return (pointF.x * pointF2.y) - (pointF.y * pointF2.x);
    }

    public static int dpToPx(int i, double d) {
        return (int) Math.round(d * ((double) (i / 160)));
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x003b A[PHI: r1
      0x003b: PHI (r1v10 float) = (r1v7 float), (r1v8 float) binds: [B:7:0x0039, B:10:0x0041] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static PointF getClosestPointToPoints(PointF pointF, PointF pointF2, PointF pointF3) {
        if (pointF == null || pointF2 == null || pointF3 == null) {
            return null;
        }
        PointF pointF4 = new PointF(pointF3.x - pointF.x, pointF3.y - pointF.y);
        PointF pointF5 = new PointF(pointF2.x - pointF.x, pointF2.y - pointF.y);
        float f = pointF5.x;
        float f2 = pointF5.y;
        float f3 = ((pointF4.y * f2) + (pointF4.x * f)) / ((f2 * f2) + (f * f));
        float f4 = 0.0f;
        if (f3 < 0.0f) {
            f3 = f4;
        } else {
            f4 = 1.0f;
            if (f3 > 1.0f) {
            }
        }
        return new PointF((f * f3) + pointF.x, (f2 * f3) + pointF.y);
    }

    private static float getDistanceBetweenTwoPoints(PointF pointF, PointF pointF2) {
        float f = pointF.x - pointF2.x;
        float f2 = pointF.y - pointF2.y;
        return (float) Math.sqrt((f2 * f2) + (f * f));
    }

    public static List<PHSwitchDeviceInfo> getSwitchKnowledgeBase() {
        return PHSwitchSerializer1.getKnowledgeBase();
    }

    public static boolean isJSONValid(String str) {
        try {
            try {
                new JSONObject(str);
                return true;
            } catch (JSONException unused) {
                return false;
            }
        } catch (JSONException unused2) {
            new JSONArray(str);
            return true;
        }
    }

    public static double pxToDp(int i, int i2) {
        return i2 / (i / 160);
    }

    public static Date stringToDate(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", new Locale("nl_NL"));
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone(str2));
        try {
            return simpleDateFormat.parse(str);
        } catch (ParseException unused) {
            return null;
        }
    }

    public static Date stringToDateForTime(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss", new Locale("nl_NL"));
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        try {
            return simpleDateFormat.parse(str);
        } catch (ParseException unused) {
            return null;
        }
    }

    public static Date stringToDate(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(str);
        } catch (ParseException unused) {
            return null;
        }
    }
}
