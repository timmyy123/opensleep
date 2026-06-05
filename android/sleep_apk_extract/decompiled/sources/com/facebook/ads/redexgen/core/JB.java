package com.facebook.ads.redexgen.core;

import com.facebook.ads.androidx.media3.common.Metadata;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.ApicFrame;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.CommentFrame;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.Id3Frame;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.InternalFrame;
import com.facebook.ads.androidx.media3.extractor.metadata.id3.TextInformationFrame;
import com.facebook.ads.androidx.media3.extractor.metadata.mp4.MdtaMetadataEntry;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.home.platform.traits.ValidationIssue;
import com.philips.lighting.hue.sdk.PHMessageType;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class JB {
    public static byte[] A00;
    public static String[] A01 = {"2wlLAi1WuzYFfEvZW32vVPJ5Bwt", "YkyEBC9wotVctjd0bq2yd6adI23G7lVv", "xTa74Gd8mmjLhBr3AhNOZq7PG2aGdO0B", "p3qN6hAzoYwqWBvMhosUwQnKcUkBt8zF", "0OnRHtWQjgHaV2S6FDGpcil60tQyV0By", "UEDUqjQ95OaJrzUGDo5yyQUmJHM", "zVAQANohgezaRkzu6srZmtdtFdKVX5LI", "leG0dnxIJE6TcUSwjLY2rjhL2vKn6U3o"};
    public static final String[] A02;

    public static String A0A(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 17);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0B() {
        A00 = new byte[]{-108, -118, 105, -84, -86, -71, -82, -75, -75, -86, 82, 115, -124, -123, -125, 114, 116, -123, 119, -103, -97, -102, -93, -59, -53, -58, -126, -84, -61, -36, -36, -99, -65, -59, -64, 124, -84, -47, -54, -57, -54, -20, -8, -2, -4, -3, -14, -20, -95, -58, -46, -49, -115, -80, -43, -50, -53, -117, -74, -66, -81, -68, -72, -100, -71, -83, -75, -90, -47, -39, -54, -41, -45, -58, -39, -50, -37, -54, -82, -38, -49, -42, -46, -37, -31, -79, -34, -39, -35, -43, -78, -29, -27, -111, -61, -32, -44, -36, -113, -61, -78, -73, -67, 110, -62, -74, -77, -81, -62, -64, -77, -58, -6, -23, -18, -12, -25, -12, -12, -16, -63, -10, -31, -18, -12, -25, -31, -14, -28, -27, -73, -42, -31, -31, -42, -39, -73, -42, -25, -28, -26, -22, -38, 122, -103, -85, -85, 117, -104, -108, -89, -101, -66, -69, -56, -69, -59, -21, -28, -15, -22, -11, -28, -121, -82, -84, 101, -121, -90, -77, -87, -59, -20, -22, -93, -27, -24, -28, -9, 86, -128, 117, 119, 127, 52, 97, 121, -120, 117, -128, -102, -60, -51, -67, -65, -54, -71, -53, -53, 108, -106, -97, -113, -99, -49, -4, -4, 1, 6, -83, -49, -18, 0, 0, -82, -34, -47, -51, -41, -50, -47, -51, -32, 83, -125, 122, -123, 97, -128, -127, 108, -118, -117, -118, -101, -114, -99, -123, -89, -82, -74, -85, -91, 111, -108, -115, -103, -114, -111, -98, 76, 121, -95, -97, -107, -113, 101, -118, -125, -112, -107, -111, -112, -117, -80, -79, -76, -76, -73, -67, -68, 116, -103, -96, -93, -90, -92, 110, -109, -99, -108, -98, -97, -108, -116, -103, 75, 114, -116, -103, -110, -98, -97, -116, 75, 125, -116, -101, -63, -26, -16, -25, -15, -14, -25, -33, -20, -98, -48, -33, -18, 126, -93, -83, -92, -82, -81, -92, -100, -87, 91, -115, -86, -98, -90, -91, -50, -61, -43, -43, -53, -59, -126, -76, -47, -59, -51, -72, -31, -42, -24, -24, -34, -40, -42, -31, -77, -36, -27, -46, -106, -65, -56, -75, -128, -101, -62, -56, -58, -72, 112, -100, -102, -110, -111, -90, -45, -1, -2, 4, -11, -3, 0, -1, 2, -15, 2, 9, -80, -45, -8, 2, -7, 3, 4, -7, -15, -2, -102, -58, -52, -59, -53, -55, -48, 99, -110, -113, -109, -109, -113, -106, -123, -110, 97, -109, -118, -110, -91, -62, -49, -60, -58, -56, -27, -14, -25, -23, -92, -52, -27, -16, -16, 123, -104, -87, -94, -82, -104, -83, -100, -63, -30, -34, -15, -27, -99, -54, -30, -15, -34, -23, -60, -23, -13, -29, -17, -101, -58, -50, -59, -53, -68, -60, -57, -58, -107, -61, -74, -78, -66, -122, -76, -73, -81, 98, 104, 98, -124, -93, -75, -75, -81, -35, -32, -40, -117, -66, -38, -41, -38, -111, -62, -81, 116, -91, -110, -93, -92, -107, -96, -107, -58, -74, -59, -95, -98, -87, -110, -82, -64, -58, 109, -103, -74, -64, -63, -78, -69, -74, -69, -76, -51, -21, -12, -19, -21, -4, -15, -21, -71, -32, -39, -41, -24, -26, -29, 126, -91, -98, -100, -83, -85, -88, -100, -91, -102, -84, -95, 102, -115, -122, -124, -107, -109, -112, -113, -118, -124, -106, -66, -64, 125, -84, -96, -90, -95, -101, -121, -73, -76, -79, 111, -118, -79, -73, -75, -89, -111, -63, -66, -69, 121, -96, -79, -81, -76, -70, -69, 104, -104, -107, -110, -121, -124, -111, -122, -120, 105, -100, -108, -119, -106, -115, -111, -119, -110, -104, -123, -112, -91, -64, -56, -53, -60, -61, 127, -45, -50, 127, -49, -64, -47, -46, -60, 127, -62, -50, -52, -52, -60, -51, -45, 127, -64, -45, -45, -47, -56, -63, -44, -45, -60, -103, 127, 93, 120, -128, -125, 124, 123, 55, -117, -122, 55, -121, 120, -119, -118, 124, 55, 122, -122, -115, 124, -119, 55, 120, -119, -117, 55, 120, -117, -117, -119, -128, 121, -116, -117, 124, 116, -113, -105, -102, -109, -110, 78, -94, -99, 78, -98, -113, -96, -95, -109, 78, -105, -100, -110, -109, -90, 93, -111, -99, -93, -100, -94, 78, -113, -94, -94, -96, -105, -112, -93, -94, -109, 104, 78, -67, -40, -32, -29, -36, -37, -105, -21, -26, -105, -25, -40, -23, -22, -36, -105, -22, -21, -40, -27, -37, -40, -23, -37, -105, -34, -36, -27, -23, -36, -105, -38, -26, -37, -36, -75, -48, -40, -37, -44, -45, -113, -29, -34, -113, -33, -48, -31, -30, -44, -113, -29, -44, -25, -29, -113, -48, -29, -29, -31, -40, -47, -28, -29, -44, -87, -113, 115, -114, -106, -103, -110, -111, 77, -95, -100, 77, -99, -114, -97, -96, -110, 77, -94, -106, -101, -95, 101, 77, -114, -95, -95, -97, -106, -113, -94, -95, -110, 77, -93, -114, -103, -94, -110, -47, -20, -12, -9, -16, -17, -85, -1, -6, -85, -5, -20, -3, -2, -16, -85, 0, -12, -7, -1, -61, -85, -20, -1, -1, -3, -12, -19, 0, -1, -16, -59, -85, -60, -33, -15, -14, -98, -60, -13, -15, -25, -19, -20, -84, -43, -46, -47, -71, -30, -33, -34, -96, -59, -30, -42, -34, -103, -62, -65, -66, -65, -62, -59, -72, -116, -72, -85, -85, -71, -70, -65, -78, -85, -60, -13, -20, -23, -62, -15, -17, -27, -21, -22, 109, 83, 108, -101, -108, -111, -102, -76, -64, -72, -111, -85, -72, -79, -67, -66, -85, 108, -122, -105, -122, -116, -118, -119, -93, -76, -93, -87, -89, 98, -108, -79, -91, -83, -98, -61, -58, -71, -72, -61, -74, -34, -48, 91, -125, -121, -124, 121, -128, -118, -78, -73, -85, -84, -90, -121, -81, -76, -88, -87, -93, 96, -110, -81, -93, -85, -107, -64, -61, -68, -75, -77, 120, -111, -94, -108, 80, -126, -97, -109, -101, -93, -68, -51, -65, -66, -54, -51, -64, 115, -112, -116, -95, -92, 75, 120, -112, -97, -116, -105, -87, -54, -47, 
        -114, -87, -48, -47, 112, -105, -99, -101, -115, -53, -8, -16, -14, -8, -11, -59, -64, -55, -124, -113, -112, -119, -128, -114, 124, 127, -111, -124, -114, -118, -115, -108, -62, -51, -50, -57, -66, -52, -64, -70, -55, -59, -66, -52, -52, -105, -70, -70, -80, -73, -77, -68, -62, 126, -93, -103, -98, -102, 117, -102, -112, -107, -111, 89, 126, -101, -113, -105, -56, -19, -29, -12, -14, -13, -15, -24, -32, -21, -105, -68, -78, -61, -63, -62, -64, -67, 123, -107, -67, -62, -74, -46, -9, -4, -3, -5, -2, -10, -18, -9, -3, -22, -11, -96, -59, -54, -53, -55, -52, -60, -68, -59, -53, -72, -61, 119, -89, -58, -57, -48, -11, -6, -5, -7, -4, -12, -20, -11, -5, -24, -13, -89, -39, -10, -22, -14, -48, -25, -13, -90, -56, -25, -12, -22, -66, -43, -18, -18, -117, -94, -69, -69, 108, -121, -74, -81, -84, -110, -72, -73, -72, -126, -83, -90, -97, -92, -99, -45, -6, -23, -3, -4, -6, -9, -21, -13, -84, -63, -44, -55, -50, -124, -99, -98, -84, -98, -95, -99, -92, -100, 113, -108, 82, 107, -114, 124, -97, -91, -98, -105, -107, 127, -109, -90, -102, 82, -124, -95, -107, -99, 99, 123, 122, 127, -118, 119, -118, 127, -116, 123, -36, -12, 1, -12, -3, -10, 4, -12, 115, -117, -102, -121, -118, -121, -102, -121, 123, -102, -113, -110, 112, -120, -105, -124, -113, -88, -48, -50, -60, -66, -68, -57, -63, -44, -25, -36, -30, -31, -44, -33, -109, -71, -30, -33, -34, -51, -32, -13, -24, -11, -28, -97, -64, -20, -28, -15, -24, -30, -32, -19, -37, -14, -4, -16, -7, -18, 0, 0, -10, -16, -18, -7, -83, -60, -44, -60, 127, -93, -60, -44, -45, -46, -62, -57, -60, 127, -74, -60, -53, -53, -60, 106, -127, -109, 60, 93, -125, -127, -85, -62, -44, 125, -81, -52, -54, -66, -53, -47, -58, -64, 104, 127, -111, 58, 113, 123, -112, 127, -39, -6, -12, -2, -16, -78, -39, -111, -90, -42, -55, -59, -49, -34, -105, -76, -84, -79, -83, -69, -65, -32, -43, -30, -47, -58, -21, -33, -36, -23, -33, -2, -13, -14, -16, 2, 3, -104, -73, -76, -77, -87, -114, -83, -86, -79, -87, 94, -114, -77, -84, -87, -56, -25, -24, -95, -64, -63, 126, -105, -64, -67, -68, -122, -91, -90, 101, 124, -85, -92, -95, -43, -12, -9, -13, -91, -52, -9, -12, -12, -5, -22, 99, -126, -122, -121, 64, 99, -120, -127, 126, -35, -4, 0, 1, -70, -33, -4, -16, -8, -56, -25, -17, -35, -22, -104, -70, -39, -28, -28, -39, -36, -89, -55, -72, -59, -62, -54, -123, -89, -98, -94, -86, -88, -120, -86, -89, -97, -86, -99, -85, -85, -95, -82, -99, 88, -118, -89, -101, -93, 115, -106, -100, -123, -116, -120, -111, -105, -33, 2, 8, -14, -9, -16, -13, -12, -5, -8, -14, 99, -122, -116, 118, 123, 120, 119, 120, 127, 124, 118, 51, 101, -126, 118, 126, -92, -57, -51, -56, -58, -75, -62, -73, -71, 113, -106, -113, -116, -88, -51, -58, -61, 120, -86, -57, -69, -61, -46, -90, -62, -62, -47, -32, -100, -85, -64, -81, -42, -23, -21, -21, -27, -23, -90, -71, -56, -58, -61, -41, -22, -5, -18, -5, -26, -15, 122, -112, -95, -100, -112, -107, -111, -117, 72, 123, -105, -99, -108, -87, -58, -70, -62, -50, -21, -33, -25, -100, -94, -100, -50, -21, -24, -24, -29, -15, -4, 3, -15, 110, 124, -120, 125, 124, -31, -17, 2, -9, 0, -13, -84, -63, -56, -66, -64, -70, -45, -66, -122, -101, -94, -86, -89, -88, -95, -104, -90, -34, -10, -20, -104, -80, -82, -75, -75, -86, -87, 101, -70, -77, -80, -77, -76, -68, -77, 101, -78, -86, -71, -90, -87, -90, -71, -90, 101, -86, -77, -71, -73, -66, 127, 101, -60, -35, -32, -24, -111, -69, -46, -34, 111, -120, -117, -109, 60, 110, -117, 127, -121, -35, -7, -8, -21, -2, -21, -29, -1, 5, -4, -70, -42, -36, -43, -53, -121, -86, -45, -48, -41, -49, -21, -15, -22, -32, -16, -18, -35, -33, -25, -42, -14, -8, -9, -21, -24, -11, -15, -93, -43, -14, -26, -18, -38, -9, -24, -22, -20, -62, -33, -48, -46, -44, -113, -63, -34, -46, -38, -34, -5, -16, -16, -18, -13, 126, -94, -108, -103, -110, -43, -5, -17, -14, -22, -15, -16, -21, -27, -94, -44, -15, -27, -19, 120, -98, -110, -107, -115, -108, -109, -98, -54, -16, -27, -21, -33, -25, -26, -25, -61, -80, -69, -79, -45, -63, -49, -52, -80, -97, -87, -84, -100, -117, -105, -107, -83, -100, -88, -89, -94, -110, -96, -111, 116, 105, 116, 81, -32, -43, -32, -66, -62, -66, -77, -97, -55, -59, -70, -89, -51, -55, -56, -52, -87, -89, -104, -96, -75, -76, -80, -109, -116, -117, -121, 121, -83, -84, -88, -100, -107, -108, -112, -111, -107, -108, -112, -107, -46, -47, -47, -61, 122, 124, 121, 110, 117, 125, -29, -27, -30, -41, -34, -26, -30, -34, -31, -29, -112, -99, -86, -93, -85, -80, -63, -65, -60, -54, -53, -102, -85, -87, -82, -76, -75, 115, -113, -76, -86, -69, -71, -70, -72, -81, -89, -78, 104, 121, -122, -122, -125, -122, -81, -61, -51, -68, -50, -61, 123, -88, -64, -49, -68, -57, -48, -21, -20, -100, -80, -84, 124, -102, -119, -111, -108, -115, -102, 125, -101, -118, -105, -116, -114, -56, -26, -35, -42, -43, -32, -103, -73, -82, -75, 114, -115, -76, -75, 108, -118, -121, -120, 56, 106, -121, 123, -125, -65, -67, -74, -66, -74, -49, -45, -58, -60, -48, -56, -49, -54, -37, -58, -59, -127, -60, -48, -41, -58, -45, -127, -62, -45, -43, -127, -57, -51, -62, -56, -44, -101, -127, -87, -62, -74, -76, -65, -116, -92, -89, -95, -103, 85, -126, -86, -88, -98, 
        -104, -60, -48, -50, -113, -62, -49, -59, -45, -48, -54, -59, -113, -60, -62, -47, -43, -42, -45, -58, -113, -57, -47, -44, -31, -27, -39, -33, -35, -89, -30, -24, -35, -33, -46, -42, -54, -48, -50, -104, -39, -41, -48, -58, -65, -75};
    }

    static {
        A0B();
        A02 = new String[]{A0A(199, 5, 25), A0A(325, 12, 81), A0A(388, 7, 70), A0A(408, 5, 80), A0A(442, 5, 111), A0A(887, 4, 109), A0A(963, 6, 61), A0A(997, 7, 80), A0A(1144, 4, 99), A0A(1240, 5, 18), A0A(1311, 7, 11), A0A(1352, 6, 55), A0A(1363, 5, 102), A0A(1390, 3, 103), A0A(1535, 3, 111), A0A(1538, 3, 95), A0A(1545, 6, 115), A0A(1576, 4, 70), A0A(1868, 6, 75), A0A(1068, 10, 110), A0A(67, 11, 84), A0A(1624, 3, 122), A0A(431, 11, 108), A0A(1450, 6, 70), A0A(1696, 10, 107), A0A(568, 11, 59), A0A(78, 7, 92), A0A(1934, 8, 52), A0A(1985, 5, 66), A0A(1148, 9, 48), A0A(891, 6, 107), A0A(1922, 6, 24), A0A(337, 9, 100), A0A(1091, 12, 120), A0A(18, 4, 37), A0A(1004, 5, 23), A0A(903, 4, 66), A0A(1686, 10, 86), A0A(940, 6, 3), A0A(1338, 5, 122), A0A(57, 10, 57), A0A(143, 4, 39), A0A(1682, 4, 127), A0A(1522, 4, 16), A0A(1719, 5, 118), A0A(1210, 10, 5), A0A(1103, 16, 70), A0A(1119, 17, 118), A0A(552, 6, 39), A0A(946, 6, 50), A0A(423, 8, 38), A0A(1874, 17, 53), A0A(539, 10, 16), A0A(1393, 8, 64), A0A(579, 9, 18), A0A(456, 5, 64), A0A(1706, 13, 114), A0A(360, 6, 28), A0A(404, 4, 13), A0A(907, 7, 57), A0A(1909, 6, 107), A0A(298, 13, 109), A0A(1401, 8, 37), A0A(1161, 6, 39), A0A(1265, 15, 110), A0A(230, 7, 24), A0A(1330, 8, 9), A0A(1486, 11, 126), A0A(1541, 4, 57), A0A(1615, 9, 34), A0A(1915, 7, 23), A0A(1190, 5, 20), A0A(1928, 6, 99), A0A(31, 9, 75), A0A(22, 9, 81), A0A(1375, 5, 55), A0A(1551, 5, 67), A0A(1245, 7, 74), A0A(1580, 11, 107), A0A(969, 9, 31), A0A(857, 4, 85), A0A(861, 9, 98), A0A(1252, 13, 98), A0A(1740, 5, 26), A0A(846, 11, 109), A0A(151, 5, 72), A0A(1176, 5, 79), A0A(1556, 7, 116), A0A(237, 6, 49), A0A(FacebookRequestErrorClassification.EC_INVALID_TOKEN, 9, 71), A0A(120, 10, 111), A0A(952, 11, 47), A0A(1462, 16, 39), A0A(1497, 16, 2), A0A(1745, 14, 113), A0A(1667, 9, 11), A0A(163, 8, 52), A0A(271, 6, 32), A0A(498, 14, 60), A0A(40, 8, 120), A0A(1009, 6, 114), A0A(1734, 6, 122), A0A(256, 7, 17), A0A(1358, 5, 95), A0A(243, 13, 27), A0A(1676, 6, 121), A0A(1759, 8, 20), A0A(ValidationIssue.UNSUPPORTED_ENTITY_COMMAND_FIELD_NUMBER, 10, 124), A0A(1456, 6, 36), A0A(1409, 11, 116), A0A(1601, 6, 125), A0A(1659, 8, 96), A0A(346, 4, 95), A0A(1863, 5, 43), A0A(1596, 5, 10), A0A(870, 8, 66), A0A(130, 6, 100), A0A(1438, 12, 103), A0A(1563, 13, 23), A0A(878, 9, 53), A0A(491, 4, 64), A0A(1526, 9, 71), A0A(472, 9, 90), A0A(1, 9, 56), A0A(558, 10, 49), A0A(413, 10, 115), A0A(937, 3, 94), A0A(461, 11, 49), A0A(350, 10, 66), A0A(978, 8, 74), A0A(1891, 6, 3), A0A(1053, 5, 36), A0A(223, 7, 0), A0A(48, 9, 79), A0A(1380, 10, 45), A0A(147, 4, 34), A0A(277, 21, 26), A0A(986, 11, 26), A0A(179, 11, 3), A0A(395, 9, 15), A0A(366, 22, 127), A0A(311, 14, 42), A0A(1220, 8, 126), A0A(1591, 5, 127), A0A(1897, 12, 74), A0A(85, 5, 95), A0A(PHMessageType.BRIDGE_NOT_FOUND, 4, 55), A0A(1767, 8, 102), A0A(10, 8, 0), A0A(90, 8, 96), A0A(136, 7, 100), A0A(156, 7, 114), A0A(171, 8, 114), A0A(214, 9, 91), A0A(263, 8, 55), A0A(447, 9, 70), A0A(481, 3, 60), A0A(495, 3, 75), A0A(512, 8, 119), A0A(520, 7, 99), A0A(527, 12, 40), A0A(549, 3, 64), A0A(588, 12, 19), A0A(914, 6, 20), A0A(931, 6, 70), A0A(1015, 3, 107), A0A(1045, 8, 61), A0A(1078, 13, 61), A0A(1136, 8, 117), A0A(1167, 9, 119), A0A(1181, 9, 39), A0A(1195, 6, 31), A0A(1201, 9, 33), A0A(1318, 12, 76), A0A(1343, 9, 83), A0A(1420, 9, 2), A0A(1429, 9, 124), A0A(1513, 9, 67), A0A(1607, 8, 72), A0A(1724, 10, 94), A0A(1942, 9, 7), A0A(1990, 11, 36), A0A(1280, 12, 124), A0A(111, 9, 116), A0A(98, 13, 61), A0A(1292, 19, 78), A0A(1368, 7, 126), A0A(1058, 10, 27), A0A(897, 6, 21), A0A(484, 7, 31), A0A(920, 11, 49), A0A(1478, 8, 18)};
    }

    public static int A00(C02284v c02284v) {
        c02284v.A0g(4);
        if (c02284v.A0C() == 1684108385) {
            c02284v.A0g(8);
            int atomType = c02284v.A0I();
            return atomType;
        }
        AbstractC02134g.A07(A0A(1228, 12, 21), A0A(776, 37, 28));
        return -1;
    }

    public static ApicFrame A01(C02284v c02284v) {
        String mimeType;
        int iA0C = c02284v.A0C();
        int iA0C2 = c02284v.A0C();
        String strA0A = A0A(1228, 12, 21);
        if (iA0C2 == 1684108385) {
            int atomSize = c02284v.A0C();
            int flags = AbstractC0570Iu.A00(atomSize);
            if (flags == 13) {
                mimeType = A0A(2024, 10, 103);
            } else {
                int atomType = A01[2].charAt(3);
                if (atomType != 55) {
                    throw new RuntimeException();
                }
                A01[4] = "MnY2PyFo9hB3t88wZMSEKgq9v2VMSjoX";
                mimeType = flags == 14 ? A0A(2034, 9, 88) : null;
            }
            if (mimeType == null) {
                AbstractC02134g.A07(strA0A, A0A(1955, 30, 80) + flags);
                return null;
            }
            c02284v.A0g(4);
            int atomSize2 = iA0C - 16;
            byte[] bArr = new byte[atomSize2];
            int atomSize3 = bArr.length;
            c02284v.A0k(bArr, 0, atomSize3);
            return new ApicFrame(mimeType, null, 3, bArr);
        }
        AbstractC02134g.A07(strA0A, A0A(635, 35, 6));
        return null;
    }

    public static CommentFrame A02(int i, C02284v c02284v) {
        int iA0C = c02284v.A0C();
        int atomType = c02284v.A0C();
        if (atomType == 1684108385) {
            c02284v.A0g(8);
            int atomSize = iA0C - 16;
            String strA0V = c02284v.A0V(atomSize);
            return new CommentFrame(A0A(2043, 3, 64), strA0V, strA0V);
        }
        AbstractC02134g.A07(A0A(1228, 12, 21), A0A(600, 35, 78) + AbstractC0570Iu.A02(i));
        return null;
    }

    @MetaExoPlayerCustomization("Replace ImmutableList with MetaExoPlayerCustomizedCollections")
    public static Id3Frame A03(int i, String str, C02284v c02284v, boolean z, boolean z2) {
        int iA00 = A00(c02284v);
        if (z2) {
            iA00 = Math.min(1, iA00);
        }
        if (iA00 >= 0) {
            if (z) {
                return new TextInformationFrame(str, null, MetaExoPlayerCustomizedCollections.A03(Integer.toString(iA00)));
            }
            return new CommentFrame(A0A(2043, 3, 64), str, Integer.toString(iA00));
        }
        AbstractC02134g.A07(A0A(1228, 12, 21), A0A(813, 33, 122) + AbstractC0570Iu.A02(i));
        return null;
    }

    public static Id3Frame A04(C02284v c02284v) {
        int position = c02284v.A09();
        int shortType = c02284v.A0C() + position;
        int typeTopByte = c02284v.A0C();
        int position2 = typeTopByte >> 24;
        int endPosition = position2 & PHIpAddressSearchManager.END_IP_SCAN;
        try {
            if (endPosition == 169 || endPosition == 253) {
                int i = 16777215 & typeTopByte;
                if (i == 6516084) {
                    return A02(typeTopByte, c02284v);
                }
                if (i != 7233901 && i != 7631467) {
                    if (i != 6516589 && i != 7828084) {
                        if (i == 6578553) {
                            return A07(typeTopByte, A0A(1795, 4, 61), c02284v);
                        }
                        if (i == 4280916) {
                            return A07(typeTopByte, A0A(1807, 4, 93), c02284v);
                        }
                        if (i == 7630703) {
                            return A07(typeTopByte, A0A(1843, 4, 109), c02284v);
                        }
                        if (i == 6384738) {
                            return A07(typeTopByte, A0A(1775, 4, 94), c02284v);
                        }
                        if (i == 7108978) {
                            return A07(typeTopByte, A0A(1951, 4, 89), c02284v);
                        }
                        if (A01[7].charAt(0) != 122) {
                            A01[4] = "PbKnEML0B11BnhLl3Mtx38aJxEbcIZXa";
                            if (i == 6776174) {
                                return A07(typeTopByte, A0A(1791, 4, 72), c02284v);
                            }
                            if (i == 6779504) {
                                return A07(typeTopByte, A0A(1799, 4, 15), c02284v);
                            }
                            AbstractC02134g.A04(A0A(1228, 12, 21), A0A(1627, 32, 52) + AbstractC0570Iu.A02(typeTopByte));
                            c02284v.A0f(shortType);
                            return null;
                        }
                        throw new RuntimeException();
                    }
                    return A07(typeTopByte, A0A(1787, 4, 55), c02284v);
                }
                return A07(typeTopByte, A0A(1803, 4, 123), c02284v);
            }
            if (typeTopByte == 1735291493) {
                return A08(c02284v);
            }
            if (typeTopByte == 1684632427) {
                return A06(typeTopByte, A0A(1815, 4, 104), c02284v);
            }
            if (typeTopByte == 1953655662) {
                return A06(typeTopByte, A0A(1819, 4, 68), c02284v);
            }
            if (typeTopByte == 1953329263) {
                return A03(typeTopByte, A0A(1779, 4, 110), c02284v, true, false);
            }
            if (typeTopByte == 1668311404) {
                return A03(typeTopByte, A0A(1783, 4, 75), c02284v, true, true);
            }
            if (typeTopByte == 1668249202) {
                return A01(c02284v);
            }
            if (typeTopByte == 1631670868) {
                return A07(typeTopByte, A0A(1811, 4, 100), c02284v);
            }
            if (typeTopByte == 1936682605) {
                return A07(typeTopByte, A0A(1839, 4, 48), c02284v);
            }
            if (typeTopByte == 1936679276) {
                TextInformationFrame textInformationFrameA07 = A07(typeTopByte, A0A(1823, 4, 80), c02284v);
                c02284v.A0f(shortType);
                if (A01[6].charAt(4) == 97) {
                    throw new RuntimeException();
                }
                A01[7] = "epTijY4hwIfyK6Q0xvepfr5SAL28SSUw";
                return textInformationFrameA07;
            }
            if (typeTopByte == 1936679282) {
                return A07(typeTopByte, A0A(1827, 4, 39), c02284v);
            }
            if (typeTopByte == 1936679265) {
                return A07(typeTopByte, A0A(1835, 4, 48), c02284v);
            }
            if (typeTopByte == 1936679791) {
                return A07(typeTopByte, A0A(1831, 4, 72), c02284v);
            }
            if (typeTopByte == 1920233063) {
                return A03(typeTopByte, A0A(1018, 14, 42), c02284v, false, false);
            }
            if (typeTopByte == 1885823344) {
                return A03(typeTopByte, A0A(1032, 13, 104), c02284v, false, true);
            }
            if (typeTopByte == 1936683886) {
                return A07(typeTopByte, A0A(1853, 10, 126), c02284v);
            }
            if (A01[7].charAt(0) != 122) {
                A01[4] = "pV0yRHtOnOdCVty8ixamggbGH5FhKnUJ";
                if (typeTopByte == 1953919848) {
                    return A07(typeTopByte, A0A(1847, 6, 21), c02284v);
                }
                if (typeTopByte == 757935405) {
                    return A05(c02284v, shortType);
                }
                AbstractC02134g.A04(A0A(1228, 12, 21), A0A(1627, 32, 52) + AbstractC0570Iu.A02(typeTopByte));
                c02284v.A0f(shortType);
                return null;
            }
            throw new RuntimeException();
        } finally {
            c02284v.A0f(shortType);
        }
    }

    public static InternalFrame A05(C02284v c02284v, int i) {
        String value = null;
        String strA0V = null;
        int dataAtomSize = -1;
        int i2 = -1;
        while (c02284v.A09() < i) {
            int iA09 = c02284v.A09();
            int iA0C = c02284v.A0C();
            int atomType = c02284v.A0C();
            c02284v.A0g(4);
            if (atomType != 1835360622) {
                String name = A01[4];
                if (name.charAt(25) != 'K') {
                    String[] strArr = A01;
                    strArr[5] = "JVGoTp7T8xzIQyvAboD10EgQeDn";
                    strArr[0] = "oWnbXWx2gT7g8u5EiokBSonVOEo";
                    if (atomType == 1851878757) {
                        int atomSize = iA0C - 12;
                        String name2 = A01[4];
                        if (name2.charAt(25) != 'K') {
                            A01[4] = "6EpugQkpjs7rX5NGp1Ll5uLRGR85ANu7";
                            strA0V = c02284v.A0V(atomSize);
                        } else {
                            A01[4] = "5nO40B7voyTUJRlNV8nWBmeQc0qMYuUc";
                            strA0V = c02284v.A0V(atomSize);
                        }
                    } else {
                        if (atomType == 1684108385) {
                            dataAtomSize = iA09;
                            i2 = iA0C;
                        }
                        int atomType2 = iA0C - 12;
                        String name3 = A01[6];
                        if (name3.charAt(4) != 'a') {
                            A01[6] = "OUGbKqv4DQRZ6ZMDSZ4GLgFK1Zu9JZ4h";
                            c02284v.A0g(atomType2);
                        }
                    }
                }
                throw new RuntimeException();
            }
            value = c02284v.A0V(iA0C - 12);
        }
        if (value != null && strA0V != null && dataAtomSize != -1) {
            c02284v.A0f(dataAtomSize);
            c02284v.A0g(16);
            String name4 = c02284v.A0V(i2 - 16);
            return new InternalFrame(value, strA0V, name4);
        }
        String name5 = A01[2];
        if (name5.charAt(3) != '7') {
            A01[6] = "Pny7g4ALAPjP1sEOQKIEe3hwXHFHBnHT";
            return null;
        }
        A01[2] = "23t7EWVWW6UeOH8M5NloDpISa9w3oKew";
        return null;
    }

    @MetaExoPlayerCustomization("Replace ImmutableList with MetaExoPlayerCustomizedCollections")
    public static TextInformationFrame A06(int i, String str, C02284v c02284v) {
        int iA0C = c02284v.A0C();
        int atomType = c02284v.A0C();
        if (atomType == 1684108385 && iA0C >= 22) {
            c02284v.A0g(10);
            int iA0M = c02284v.A0M();
            if (iA0M > 0) {
                String str2 = A0A(0, 0, 71) + iA0M;
                int count = c02284v.A0M();
                if (count > 0) {
                    str2 = str2 + A0A(0, 1, 84) + count;
                }
                return new TextInformationFrame(str, null, MetaExoPlayerCustomizedCollections.A03(str2));
            }
        }
        AbstractC02134g.A07(A0A(1228, 12, 21), A0A(670, 39, 29) + AbstractC0570Iu.A02(i));
        return null;
    }

    @MetaExoPlayerCustomization("Replace ImmutableList with MetaExoPlayerCustomizedCollections")
    public static TextInformationFrame A07(int i, String str, C02284v c02284v) {
        int iA0C = c02284v.A0C();
        int atomType = c02284v.A0C();
        if (atomType == 1684108385) {
            c02284v.A0g(8);
            int atomSize = iA0C - 16;
            return new TextInformationFrame(str, null, MetaExoPlayerCustomizedCollections.A03(c02284v.A0V(atomSize)));
        }
        AbstractC02134g.A07(A0A(1228, 12, 21), A0A(744, 32, 94) + AbstractC0570Iu.A02(i));
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    @MetaExoPlayerCustomization("Replace ImmutableList with MetaExoPlayerCustomizedCollections")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static TextInformationFrame A08(C02284v c02284v) {
        String str;
        int iA00 = A00(c02284v);
        if (iA00 > 0) {
            int genreCode = A02.length;
            if (iA00 <= genreCode) {
                int genreCode2 = iA00 - 1;
                str = A02[genreCode2];
            } else {
                str = null;
            }
        }
        if (str != null) {
            return new TextInformationFrame(A0A(1791, 4, 72), null, MetaExoPlayerCustomizedCollections.A03(str));
        }
        AbstractC02134g.A07(A0A(1228, 12, 21), A0A(709, 35, 102));
        return null;
    }

    public static MdtaMetadataEntry A09(C02284v c02284v, int i, String str) {
        while (true) {
            int typeIndicator = c02284v.A09();
            if (typeIndicator < i) {
                int atomType = c02284v.A0C();
                int atomPosition = c02284v.A0C();
                if (atomPosition == 1684108385) {
                    int localeIndicator = c02284v.A0C();
                    int typeIndicator2 = c02284v.A0C();
                    int atomType2 = atomType - 16;
                    byte[] bArr = new byte[atomType2];
                    c02284v.A0k(bArr, 0, atomType2);
                    return new MdtaMetadataEntry(str, bArr, typeIndicator2, localeIndicator);
                }
                c02284v.A0f(typeIndicator + atomType);
            } else {
                return null;
            }
        }
    }

    public static void A0C(int i, Metadata metadata, Metadata metadata2, C01722p c01722p, Metadata... metadataArr) {
        Metadata metadata3 = new Metadata(new Metadata.Entry[0]);
        if (i == 1) {
            if (metadata != null) {
                metadata3 = metadata;
            }
        } else if (i == 2 && metadata2 != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= metadata2.A02()) {
                    break;
                }
                Metadata.Entry entry = metadata2.A03(i2);
                if (entry instanceof MdtaMetadataEntry) {
                    MdtaMetadataEntry mdtaMetadataEntry = (MdtaMetadataEntry) entry;
                    if (A0A(2001, 23, 80).equals(mdtaMetadataEntry.A02)) {
                        metadata3 = new Metadata(mdtaMetadataEntry);
                        break;
                    }
                }
                i2++;
            }
        }
        for (Metadata formatMetadata : metadataArr) {
            metadata3 = metadata3.A04(formatMetadata);
        }
        if (metadata3.A02() > 0) {
            c01722p.A0v(metadata3);
        }
    }

    public static void A0D(int i, HK hk, C01722p c01722p) {
        if (i == 1 && hk.A03()) {
            c01722p.A0d(hk.A00).A0e(hk.A01);
        }
    }
}
