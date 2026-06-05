package com.urbandroid.sleep.hr.polar.domain;

import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class DeltaFrames {

    public static class ThreeAxisDeltaFramedData {
        public final List<ThreeAxisSample> axisSamples = new ArrayList();
        public final long timeStamp;

        public static class ThreeAxisSample {
            public final float x;
            public final float y;
            public final float z;

            public ThreeAxisSample(float f, float f2, float f3) {
                this.x = f;
                this.y = f2;
                this.z = f3;
            }
        }

        public ThreeAxisDeltaFramedData(byte[] bArr, float f, int i, long j) {
            this.timeStamp = j;
            Iterator<List<Integer>> it = DeltaFrames.parseDeltaFramesAll(bArr, 3, i).iterator();
            while (it.hasNext()) {
                BleUtils.validate(it.next().size() == 3, "delta samples invalid length");
                this.axisSamples.add(new ThreeAxisSample(r6.get(0).intValue() * f, r6.get(1).intValue() * f, r6.get(2).intValue() * f));
            }
        }
    }

    public static List<List<Integer>> parseDeltaFrame(byte[] bArr, int i, int i2, int i3) {
        ArrayList arrayList = new ArrayList();
        for (byte b : bArr) {
            for (int i4 = 0; i4 < 8; i4++) {
                boolean z = true;
                if (((1 << i4) & b) == 0) {
                    z = false;
                }
                arrayList.add(Boolean.valueOf(z));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int i5 = Integer.MAX_VALUE << (i2 - 1);
        int i6 = 0;
        while (i6 < i3) {
            ArrayList arrayList3 = new ArrayList();
            int i7 = 0;
            while (true) {
                int i8 = i7 + 1;
                if (i7 < i) {
                    int i9 = i6 + i2;
                    List listSubList = arrayList.subList(i6, i9);
                    int i10 = 0;
                    for (int i11 = 0; i11 < listSubList.size(); i11++) {
                        i10 |= (((Boolean) listSubList.get(i11)).booleanValue() ? 1 : 0) << i11;
                    }
                    if ((i10 & i5) != 0) {
                        i10 |= i5;
                    }
                    arrayList3.add(Integer.valueOf(i10));
                    i6 = i9;
                    i7 = i8;
                }
            }
            arrayList2.add(arrayList3);
        }
        return arrayList2;
    }

    public static List<Integer> parseDeltaFrameRefSamples(byte[] bArr, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        int i3 = (-1) << (i2 - 1);
        int iCeil = (int) Math.ceil(((double) i2) / 8.0d);
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = i4 + 1;
            if (i4 >= i) {
                return arrayList;
            }
            int iConvertArrayToSignedInt = BleUtils.convertArrayToSignedInt(bArr, i5, iCeil);
            if ((iConvertArrayToSignedInt & i3) != 0) {
                iConvertArrayToSignedInt |= i3;
            }
            i5 += iCeil;
            arrayList.add(Integer.valueOf(iConvertArrayToSignedInt));
            i4 = i6;
        }
    }

    public static List<List<Integer>> parseDeltaFramesAll(byte[] bArr, int i, int i2) {
        List<Integer> deltaFrameRefSamples = parseDeltaFrameRefSamples(bArr, i, i2);
        int iCeil = (int) ((Math.ceil(((double) i2) / 8.0d) * ((double) i)) + 0.0d);
        ArrayList arrayList = new ArrayList(Collections.singleton(deltaFrameRefSamples));
        BleUtils.validate(deltaFrameRefSamples.size() == i, "incorrect number of ref channels");
        while (iCeil < bArr.length) {
            int i3 = iCeil + 1;
            int i4 = bArr[iCeil] & PHIpAddressSearchManager.END_IP_SCAN;
            int i5 = iCeil + 2;
            int i6 = (bArr[i3] & PHIpAddressSearchManager.END_IP_SCAN) * i4 * i;
            int iCeil2 = (int) Math.ceil(((double) i6) / 8.0d);
            byte[] bArr2 = new byte[iCeil2];
            System.arraycopy(bArr, i5, bArr2, 0, iCeil2);
            for (List<Integer> list : parseDeltaFrame(bArr2, i, i4, i6)) {
                BleUtils.validate(list.size() == i, "incorrect number of delta channels");
                List list2 = (List) arrayList.get(arrayList.size() - 1);
                ArrayList arrayList2 = new ArrayList();
                for (int i7 = 0; i7 < i; i7++) {
                    arrayList2.add(Integer.valueOf(list.get(i7).intValue() + ((Integer) list2.get(i7)).intValue()));
                }
                arrayList.addAll(Collections.singleton(arrayList2));
            }
            iCeil = i5 + iCeil2;
        }
        return arrayList;
    }
}
