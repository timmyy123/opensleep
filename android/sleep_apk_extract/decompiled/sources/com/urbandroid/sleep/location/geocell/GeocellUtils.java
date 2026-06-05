package com.urbandroid.sleep.location.geocell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class GeocellUtils {
    private static final int[] NORTHWEST = {-1, 1};
    private static final int[] NORTH = {0, 1};
    private static final int[] NORTHEAST = {1, 1};
    private static final int[] EAST = {1, 0};
    private static final int[] SOUTHEAST = {1, -1};
    private static final int[] SOUTH = {0, -1};
    private static final int[] SOUTHWEST = {-1, -1};
    private static final int[] WEST = {-1, 0};

    public static String adjacent(String str, int[] iArr) {
        if (str == null) {
            return null;
        }
        int i = iArr[0];
        int i2 = iArr[1];
        char[] charArray = str.toCharArray();
        for (int length = charArray.length - 1; length >= 0 && (i != 0 || i2 != 0); length--) {
            int[] iArrSubdivXY = subdivXY(charArray[length]);
            int i3 = iArrSubdivXY[0];
            int i4 = iArrSubdivXY[1];
            if (i == -1) {
                if (i3 == 0) {
                    i3 = 3;
                } else {
                    i3--;
                    i = 0;
                }
            } else if (i == 1) {
                if (i3 == 3) {
                    i3 = 0;
                } else {
                    i3++;
                    i = 0;
                }
            }
            if (i2 == 1) {
                if (i4 == 3) {
                    i4 = 0;
                } else {
                    i4++;
                    i2 = 0;
                }
            } else if (i2 == -1) {
                if (i4 == 0) {
                    i4 = 3;
                } else {
                    i4--;
                    i2 = 0;
                }
            }
            charArray[length] = subdivChar(new int[]{i3, i4});
        }
        if (i2 != 0) {
            return null;
        }
        return new String(charArray);
    }

    public static List<String> allAdjacents(String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = Arrays.asList(NORTHWEST, NORTH, NORTHEAST, EAST, SOUTHEAST, SOUTH, SOUTHWEST, WEST).iterator();
        while (it.hasNext()) {
            String strAdjacent = adjacent(str, (int[]) it.next());
            if (strAdjacent != null) {
                arrayList.add(strAdjacent);
            }
        }
        return arrayList;
    }

    public static String compute(Point point, int i) {
        StringBuilder sb = new StringBuilder();
        float f = 90.0f;
        float f2 = -90.0f;
        float f3 = 180.0f;
        float f4 = -180.0f;
        while (sb.length() < i) {
            float f5 = f3 - f4;
            float f6 = f5 / 4.0f;
            float f7 = f - f2;
            float f8 = f7 / 4.0f;
            int iMin = Math.min((int) (((point.getLon() - ((double) f4)) * 4.0d) / ((double) f5)), 3);
            int iMin2 = Math.min((int) (((point.getLat() - ((double) f2)) * 4.0d) / ((double) f7)), 3);
            sb.append(subdivChar(new int[]{iMin, iMin2}));
            f2 += iMin2 * f8;
            f = f2 + f8;
            f4 += iMin * f6;
            f3 = f4 + f6;
        }
        return sb.toString();
    }

    public static BoundingBox computeBox(String str) {
        if (str == null) {
            return null;
        }
        BoundingBox boundingBox = new BoundingBox(90.0d, 180.0d, -90.0d, -180.0d);
        StringBuilder sb = new StringBuilder(str);
        while (sb.length() > 0) {
            double east = (boundingBox.getEast() - boundingBox.getWest()) / 4.0d;
            double north = (boundingBox.getNorth() - boundingBox.getSouth()) / 4.0d;
            int[] iArrSubdivXY = subdivXY(sb.charAt(0));
            int i = iArrSubdivXY[0];
            int i2 = iArrSubdivXY[1];
            BoundingBox boundingBox2 = new BoundingBox(boundingBox.getSouth() + (((double) (i2 + 1)) * north), boundingBox.getWest() + (((double) (i + 1)) * east), boundingBox.getSouth() + (north * ((double) i2)), (east * ((double) i)) + boundingBox.getWest());
            sb.deleteCharAt(0);
            boundingBox = boundingBox2;
        }
        return boundingBox;
    }

    public static double distance(Point point, Point point2) {
        double radians = Math.toRadians(point.getLat());
        double radians2 = Math.toRadians(point.getLon());
        double radians3 = Math.toRadians(point2.getLat());
        double radians4 = Math.toRadians(point2.getLon());
        return Math.acos(makeDoubleInRange((Math.cos(radians4 - radians2) * Math.cos(radians3) * Math.cos(radians)) + (Math.sin(radians3) * Math.sin(radians)))) * 6378135.0d;
    }

    public static double makeDoubleInRange(double d) {
        if (d > 1.0d) {
            return 1.0d;
        }
        if (d < -1.0d) {
            return -1.0d;
        }
        return d;
    }

    public static double pointDistance(String str, Point point) {
        BoundingBox boundingBoxComputeBox = computeBox(str);
        boolean z = false;
        boolean z2 = boundingBoxComputeBox.getWest() <= point.getLon() && point.getLon() <= boundingBoxComputeBox.getEast();
        if (boundingBoxComputeBox.getSouth() <= point.getLat() && point.getLat() <= boundingBoxComputeBox.getNorth()) {
            z = true;
        }
        return z2 ? z ? Math.min(Math.min(distance(point, new Point(boundingBoxComputeBox.getSouth(), point.getLon())), distance(point, new Point(boundingBoxComputeBox.getNorth(), point.getLon()))), Math.min(distance(point, new Point(point.getLat(), boundingBoxComputeBox.getEast())), distance(point, new Point(point.getLat(), boundingBoxComputeBox.getWest())))) : Math.min(distance(point, new Point(boundingBoxComputeBox.getSouth(), point.getLon())), distance(point, new Point(boundingBoxComputeBox.getNorth(), point.getLon()))) : z ? Math.min(distance(point, new Point(point.getLat(), boundingBoxComputeBox.getEast())), distance(point, new Point(point.getLat(), boundingBoxComputeBox.getWest()))) : Math.min(Math.min(distance(point, new Point(boundingBoxComputeBox.getSouth(), boundingBoxComputeBox.getEast())), distance(point, new Point(boundingBoxComputeBox.getNorth(), boundingBoxComputeBox.getEast()))), Math.min(distance(point, new Point(boundingBoxComputeBox.getSouth(), boundingBoxComputeBox.getWest())), distance(point, new Point(boundingBoxComputeBox.getNorth(), boundingBoxComputeBox.getWest()))));
    }

    public static char subdivChar(int[] iArr) {
        int i = iArr[1];
        int i2 = iArr[0];
        int i3 = ((i & 2) << 2) | ((i2 & 2) << 1);
        return "0123456789abcdef".charAt((i2 & 1) | ((i & 1) << 1) | i3);
    }

    public static int[] subdivXY(char c) {
        int iIndexOf = "0123456789abcdef".indexOf(c);
        return new int[]{((iIndexOf & 4) >> 1) | (iIndexOf & 1), ((iIndexOf & 2) >> 1) | ((iIndexOf & 8) >> 2)};
    }
}
