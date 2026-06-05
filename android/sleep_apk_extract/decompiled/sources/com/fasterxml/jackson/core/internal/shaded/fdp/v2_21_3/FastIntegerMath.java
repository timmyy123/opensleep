package com.fasterxml.jackson.core.internal.shaded.fdp.v2_21_3;

import java.math.BigInteger;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
abstract class FastIntegerMath {
    public static final BigInteger FIVE = BigInteger.valueOf(5);
    static final BigInteger TEN_POW_16 = BigInteger.valueOf(10000000000000000L);
    static final BigInteger FIVE_POW_16 = BigInteger.valueOf(152587890625L);
    private static final BigInteger[] SMALL_POWERS_OF_TEN = {BigInteger.ONE, BigInteger.TEN, BigInteger.valueOf(100), BigInteger.valueOf(1000), BigInteger.valueOf(10000), BigInteger.valueOf(100000), BigInteger.valueOf(1000000), BigInteger.valueOf(10000000), BigInteger.valueOf(100000000), BigInteger.valueOf(1000000000), BigInteger.valueOf(10000000000L), BigInteger.valueOf(100000000000L), BigInteger.valueOf(1000000000000L), BigInteger.valueOf(10000000000000L), BigInteger.valueOf(100000000000000L), BigInteger.valueOf(1000000000000000L)};

    public static BigInteger computePowerOfTen(NavigableMap<Integer, BigInteger> navigableMap, int i) {
        BigInteger[] bigIntegerArr = SMALL_POWERS_OF_TEN;
        if (i < bigIntegerArr.length) {
            return bigIntegerArr[i];
        }
        if (navigableMap == null) {
            return FIVE.pow(i).shiftLeft(i);
        }
        Map.Entry<Integer, BigInteger> entryFloorEntry = navigableMap.floorEntry(Integer.valueOf(i));
        Integer key = entryFloorEntry.getKey();
        return key.intValue() == i ? entryFloorEntry.getValue() : FftMultiplier.multiply(entryFloorEntry.getValue(), computePowerOfTen(navigableMap, i - key.intValue()));
    }

    public static BigInteger computeTenRaisedByNFloor16Recursive(NavigableMap<Integer, BigInteger> navigableMap, int i) {
        int i2 = i & (-16);
        Map.Entry<Integer, BigInteger> entryFloorEntry = navigableMap.floorEntry(Integer.valueOf(i2));
        int iIntValue = entryFloorEntry.getKey().intValue();
        BigInteger value = entryFloorEntry.getValue();
        if (iIntValue == i2) {
            return value;
        }
        int i3 = i2 - iIntValue;
        BigInteger bigIntegerComputeTenRaisedByNFloor16Recursive = navigableMap.get(Integer.valueOf(i3));
        if (bigIntegerComputeTenRaisedByNFloor16Recursive == null) {
            bigIntegerComputeTenRaisedByNFloor16Recursive = computeTenRaisedByNFloor16Recursive(navigableMap, i3);
            navigableMap.put(Integer.valueOf(i3), bigIntegerComputeTenRaisedByNFloor16Recursive);
        }
        return FftMultiplier.multiply(value, bigIntegerComputeTenRaisedByNFloor16Recursive);
    }

    public static NavigableMap<Integer, BigInteger> createPowersOfTenFloor16Map() {
        TreeMap treeMap = new TreeMap();
        treeMap.put(0, BigInteger.ONE);
        treeMap.put(16, TEN_POW_16);
        return treeMap;
    }

    public static long estimateNumBits(long j) {
        return ((j * 3402) >>> 10) + 1;
    }

    public static NavigableMap<Integer, BigInteger> fillPowersOf10Floor16(int i, int i2) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(0, BigInteger.valueOf(5L));
        treeMap.put(16, FIVE_POW_16);
        fillPowersOfNFloor16Recursive(treeMap, i, i2);
        for (Map.Entry entry : treeMap.entrySet()) {
            entry.setValue(((BigInteger) entry.getValue()).shiftLeft(((Integer) entry.getKey()).intValue()));
        }
        return treeMap;
    }

    public static void fillPowersOfNFloor16Recursive(NavigableMap<Integer, BigInteger> navigableMap, int i, int i2) {
        if (i2 - i <= 18) {
            return;
        }
        int iSplitFloor16 = splitFloor16(i, i2);
        int i3 = i2 - iSplitFloor16;
        if (navigableMap.containsKey(Integer.valueOf(i3))) {
            return;
        }
        fillPowersOfNFloor16Recursive(navigableMap, i, iSplitFloor16);
        fillPowersOfNFloor16Recursive(navigableMap, iSplitFloor16, i2);
        navigableMap.put(Integer.valueOf(i3), computeTenRaisedByNFloor16Recursive(navigableMap, i3));
    }

    public static int splitFloor16(int i, int i2) {
        return i2 - ((((i2 - i) + 31) >>> 5) << 4);
    }

    public static long unsignedMultiplyHigh(long j, long j2) {
        long j3 = j & 4294967295L;
        long j4 = j >>> 32;
        long j5 = j2 & 4294967295L;
        long j6 = j2 >>> 32;
        long j7 = j4 * j6;
        long j8 = j6 * j3;
        return j7 + ((((j4 * j5) + ((j3 * j5) >>> 32)) + (4294967295L & j8)) >>> 32) + (j8 >>> 32);
    }
}
