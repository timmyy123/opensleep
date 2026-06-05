package com.urbandroid.sleep.domain;

import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.snoring.newfftresult.FftResultRaw;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import org.jtransforms.fft.FloatFFT_1D;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u0007\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0005\u001a\u000e\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0005\u001a\u0014\u0010\u0007\u001a\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¨\u0006\u000b"}, d2 = {"diagnoseRawActigraph", "", "a", "", "", "", "diagnoseNormalizedAmplitudesActigraph", "chart", "data", "", "", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class RawActigraphDiagnosticsKt {
    public static final String chart(List<Double> list) {
        list.getClass();
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (Math.abs(((Number) obj).doubleValue()) <= Double.MAX_VALUE) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return "";
        }
        Double dM2456maxOrNull = CollectionsKt___CollectionsKt.m2456maxOrNull((Iterable<Double>) arrayList);
        dM2456maxOrNull.getClass();
        double dDoubleValue = dM2456maxOrNull.doubleValue();
        Double dM2458minOrNull = CollectionsKt___CollectionsKt.m2458minOrNull((Iterable<Double>) arrayList);
        dM2458minOrNull.getClass();
        double dDoubleValue2 = dM2458minOrNull.doubleValue();
        double d = (dDoubleValue - dDoubleValue2) / 7.0d;
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append("▁▂▃▄▅▆▇█".charAt(Math.min(7, Math.max(0, (int) Math.floor((((Number) it.next()).doubleValue() - dDoubleValue2) / d)))));
        }
        return sb.toString();
    }

    public static final String diagnoseNormalizedAmplitudesActigraph(float[] fArr) {
        fArr.getClass();
        StringBuilder sb = new StringBuilder("Raw actigraph diagnostics: ");
        try {
            sb.append("Size: ");
            sb.append(fArr.length);
            sb.append(", ");
            sb.append("NA count: ");
            ArrayList arrayList = new ArrayList();
            for (float f : fArr) {
                if (f < 0.0f) {
                    arrayList.add(Float.valueOf(f));
                }
            }
            sb.append(arrayList.size());
            ArrayList arrayList2 = new ArrayList();
            for (float f2 : fArr) {
                if (f2 >= 0.0f) {
                    arrayList2.add(Float.valueOf(f2));
                }
            }
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList3.add(Float.valueOf(Math.min(3.0f, ((Number) it.next()).floatValue())));
            }
            float[] floatArray = CollectionsKt.toFloatArray(arrayList3);
            if (floatArray.length >= 32) {
                new FloatFFT_1D(floatArray.length).realForward(floatArray);
                FftResultRaw fftResultRaw = new FftResultRaw(floatArray, 0.1f, false);
                int iMax = Math.max(1, fftResultRaw.size() / 100);
                int size = fftResultRaw.size();
                int iMax2 = Math.max(2, (size - iMax) / 30);
                int i = iMax2 / 2;
                ArrayList arrayList4 = new ArrayList();
                while (iMax < size - iMax2) {
                    arrayList4.add(Double.valueOf(fftResultRaw.getEnergySumNorm(fftResultRaw.getFrequency(iMax), fftResultRaw.getFrequency(iMax + iMax2))));
                    iMax += i;
                }
                sb.append("\nActivity FFT: " + chart(arrayList4));
            }
        } catch (Exception e) {
            Logger.logSevere("diagnoseNormalizedAmplitudesActigraph", e);
        }
        return sb.toString();
    }

    public static final String diagnoseRawActigraph(float[] fArr) {
        fArr.getClass();
        float[] fArr2 = AdaptiveNormalizationFilter.normalizeAmplitudes(fArr).output;
        fArr2.getClass();
        return diagnoseNormalizedAmplitudesActigraph(fArr2);
    }

    public static final String diagnoseRawActigraph(Collection<Float> collection) {
        collection.getClass();
        return diagnoseRawActigraph(CollectionsKt.toFloatArray(collection));
    }
}
