package com.urbandroid.util;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ArrayUtil {

    public interface MapFilter<K, V> {
        boolean apply(K k, V v);
    }

    public static String[] getSubarray(String[] strArr, int i, int i2) {
        int iMin = i2 > 0 ? Math.min(i2, strArr.length - i) : strArr.length - i;
        if (iMin < 1) {
            return new String[0];
        }
        String[] strArr2 = new String[iMin];
        System.arraycopy(strArr, i, strArr2, 0, iMin);
        return strArr2;
    }

    public static float[] join(List<float[]> list) {
        Iterator<float[]> it = list.iterator();
        int length = 0;
        while (it.hasNext()) {
            length += it.next().length;
        }
        float[] fArr = new float[length];
        int length2 = 0;
        for (float[] fArr2 : list) {
            System.arraycopy(fArr2, 0, fArr, length2, fArr2.length);
            length2 += fArr2.length;
        }
        return fArr;
    }

    public static float[] toFloatArray(List<Float> list) {
        float[] fArr = new float[list.size()];
        Iterator<Float> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            Float next = it.next();
            int i2 = i + 1;
            fArr[i] = next != null ? next.floatValue() : Float.NaN;
            i = i2;
        }
        return fArr;
    }

    public static <K, V> Map<K, V> toMap(K[] kArr, V[] vArr, MapFilter<K, V> mapFilter) {
        if (kArr.length != vArr.length) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("keys.length != values.length");
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i = 0; i < kArr.length; i++) {
            if (mapFilter == null || mapFilter.apply(kArr[i], vArr[i])) {
                linkedHashMap.put(kArr[i], vArr[i]);
            }
        }
        return linkedHashMap;
    }

    public static String[] getSubarray(String[] strArr, int i) {
        return getSubarray(strArr, i, 0);
    }

    public static float[] join(float[] fArr, float[] fArr2) {
        int length = fArr.length;
        int length2 = fArr2.length;
        float[] fArr3 = new float[length + length2];
        System.arraycopy(fArr, 0, fArr3, 0, length);
        System.arraycopy(fArr2, 0, fArr3, length, length2);
        return fArr3;
    }

    public static <T> T[] join(T[] tArr, T[] tArr2) {
        T[] tArr3 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), tArr.length + tArr2.length));
        System.arraycopy(tArr, 0, tArr3, 0, tArr.length);
        System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
        return tArr3;
    }
}
