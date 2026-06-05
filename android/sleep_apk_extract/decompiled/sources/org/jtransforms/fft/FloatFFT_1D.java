package org.jtransforms.fft;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.apache.commons.math3.util.FastMath;
import org.jtransforms.utils.CommonUtils;
import pl.edu.icm.jlargearrays.ConcurrencyUtils;
import pl.edu.icm.jlargearrays.FloatLargeArray;
import pl.edu.icm.jlargearrays.LargeArray;
import pl.edu.icm.jlargearrays.LargeArrayUtils;
import pl.edu.icm.jlargearrays.LongLargeArray;
import twitter4j.TwitterImpl$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class FloatFFT_1D {
    private static final int[] factors = {4, 2, 3, 5};
    private float[] bk1;
    private FloatLargeArray bk1l;
    private float[] bk2;
    private FloatLargeArray bk2l;
    private int[] ip;
    private LongLargeArray ipl;
    private int n;
    private int nBluestein;
    private long nBluesteinl;
    private int nc;
    private long ncl;
    private long nl;
    private int nw;
    private long nwl;
    private Plans plan;
    private boolean useLargeArrays;
    private float[] w;
    private FloatLargeArray wl;
    private float[] wtable;
    private float[] wtable_r;
    private FloatLargeArray wtable_rl;
    private FloatLargeArray wtablel;

    /* JADX INFO: renamed from: org.jtransforms.fft.FloatFFT_1D$29, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass29 {
        static final /* synthetic */ int[] $SwitchMap$org$jtransforms$fft$FloatFFT_1D$Plans;

        static {
            int[] iArr = new int[Plans.values().length];
            $SwitchMap$org$jtransforms$fft$FloatFFT_1D$Plans = iArr;
            try {
                iArr[Plans.SPLIT_RADIX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jtransforms$fft$FloatFFT_1D$Plans[Plans.MIXED_RADIX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jtransforms$fft$FloatFFT_1D$Plans[Plans.BLUESTEIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum Plans {
        SPLIT_RADIX,
        MIXED_RADIX,
        BLUESTEIN
    }

    public FloatFFT_1D(long j) {
        if (j < 1) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("n must be greater than 0");
            throw null;
        }
        boolean z = CommonUtils.isUseLargeArrays() || j * 2 > ((long) LargeArray.getMaxSizeOf32bitArray());
        this.useLargeArrays = z;
        this.n = (int) j;
        this.nl = j;
        if (z) {
            if (CommonUtils.isPowerOf2(j)) {
                this.plan = Plans.SPLIT_RADIX;
                this.ipl = new LongLargeArray(((long) FastMath.ceil((1 << ((int) (((long) (FastMath.log(this.nl + 0.5f) / FastMath.log(2.0d))) / 2))) + 2)) + 2);
                FloatLargeArray floatLargeArray = new FloatLargeArray(this.nl);
                this.wl = floatLargeArray;
                long j2 = (this.nl * 2) >> 2;
                this.nwl = j2;
                CommonUtils.makewt(j2, this.ipl, floatLargeArray);
                long j3 = this.nl >> 2;
                this.ncl = j3;
                CommonUtils.makect(j3, this.wl, this.nwl, this.ipl);
                return;
            }
            if (CommonUtils.getReminder(this.nl, factors) < 211) {
                this.plan = Plans.MIXED_RADIX;
                this.wtablel = new FloatLargeArray((this.nl * 4) + 15);
                this.wtable_rl = new FloatLargeArray((this.nl * 2) + 15);
                cfftil();
                rfftil();
                return;
            }
            this.plan = Plans.BLUESTEIN;
            long jNextPow2 = CommonUtils.nextPow2((this.nl * 2) - 1);
            this.nBluesteinl = jNextPow2;
            this.bk1l = new FloatLargeArray(jNextPow2 * 2);
            this.bk2l = new FloatLargeArray(this.nBluesteinl * 2);
            this.ipl = new LongLargeArray(((long) FastMath.ceil((1 << ((int) (((long) (FastMath.log(this.nBluesteinl + 0.5f) / FastMath.log(2.0d))) / 2))) + 2)) + 2);
            FloatLargeArray floatLargeArray2 = new FloatLargeArray(this.nBluesteinl);
            this.wl = floatLargeArray2;
            long j4 = (this.nBluesteinl * 2) >> 2;
            this.nwl = j4;
            CommonUtils.makewt(j4, this.ipl, floatLargeArray2);
            long j5 = this.nBluesteinl >> 2;
            this.ncl = j5;
            CommonUtils.makect(j5, this.wl, this.nwl, this.ipl);
            bluesteinil();
            return;
        }
        if (CommonUtils.isPowerOf2(j)) {
            this.plan = Plans.SPLIT_RADIX;
            int[] iArr = new int[((int) FastMath.ceil((1 << (((int) (FastMath.log(j + 0.5f) / FastMath.log(2.0d))) / 2)) + 2)) + 2];
            this.ip = iArr;
            int i = this.n;
            float[] fArr = new float[i];
            this.w = fArr;
            int i2 = (i * 2) >> 2;
            this.nw = i2;
            CommonUtils.makewt(i2, iArr, fArr);
            int i3 = this.n >> 2;
            this.nc = i3;
            CommonUtils.makect(i3, this.w, this.nw, this.ip);
            return;
        }
        if (CommonUtils.getReminder(j, factors) < 211) {
            this.plan = Plans.MIXED_RADIX;
            int i4 = this.n;
            this.wtable = new float[(i4 * 4) + 15];
            this.wtable_r = new float[(i4 * 2) + 15];
            cffti();
            rffti();
            return;
        }
        this.plan = Plans.BLUESTEIN;
        int iNextPow2 = CommonUtils.nextPow2((this.n * 2) - 1);
        this.nBluestein = iNextPow2;
        this.bk1 = new float[iNextPow2 * 2];
        this.bk2 = new float[iNextPow2 * 2];
        int[] iArr2 = new int[((int) FastMath.ceil((1 << (((int) (FastMath.log(iNextPow2 + 0.5f) / FastMath.log(2.0d))) / 2)) + 2)) + 2];
        this.ip = iArr2;
        int i5 = this.nBluestein;
        float[] fArr2 = new float[i5];
        this.w = fArr2;
        int i6 = (i5 * 2) >> 2;
        this.nw = i6;
        CommonUtils.makewt(i6, iArr2, fArr2);
        int i7 = this.nBluestein >> 2;
        this.nc = i7;
        CommonUtils.makect(i7, this.w, this.nw, this.ip);
        bluesteini();
    }

    private void bluestein_real_forward(final FloatLargeArray floatLargeArray, final long j) {
        long j2;
        FloatFFT_1D floatFFT_1D;
        long j3;
        long j4;
        long j5;
        FloatLargeArray floatLargeArray2;
        long j6 = 2;
        FloatLargeArray floatLargeArray3 = new FloatLargeArray(this.nBluesteinl * 2);
        int numberOfThreads = ConcurrencyUtils.getNumberOfThreads();
        if (numberOfThreads <= 1 || this.nl <= CommonUtils.getThreadsBeginN_1D_FFT_2Threads()) {
            j2 = j;
            floatFFT_1D = this;
            j3 = 2;
            j4 = 0;
            j5 = 1;
            floatLargeArray2 = floatLargeArray;
            for (long j7 = 0; j7 < floatFFT_1D.nl; j7++) {
                long j8 = j7 * 2;
                long j9 = j8 + 1;
                long j10 = j2 + j7;
                floatLargeArray3.setFloat(j8, floatFFT_1D.bk1l.getFloat(j8) * floatLargeArray2.getFloat(j10));
                floatLargeArray3.setFloat(j9, floatFFT_1D.bk1l.getFloat(j9) * (-floatLargeArray2.getFloat(j10)));
            }
            CommonUtils.cftbsub(floatFFT_1D.nBluesteinl * 2, floatLargeArray3, 0L, floatFFT_1D.ipl, floatFFT_1D.nwl, floatFFT_1D.wl);
            for (long j11 = 0; j11 < floatFFT_1D.nBluesteinl; j11++) {
                long j12 = j11 * 2;
                long j13 = j12 + 1;
                float f = (floatFFT_1D.bk2l.getFloat(j12) * floatLargeArray3.getFloat(j13)) + (floatFFT_1D.bk2l.getFloat(j13) * floatLargeArray3.getFloat(j12));
                floatLargeArray3.setFloat(j12, (floatFFT_1D.bk2l.getFloat(j12) * floatLargeArray3.getFloat(j12)) - (floatFFT_1D.bk2l.getFloat(j13) * floatLargeArray3.getFloat(j13)));
                floatLargeArray3.setFloat(j13, f);
            }
        } else {
            int i = (numberOfThreads < 4 || this.nl <= CommonUtils.getThreadsBeginN_1D_FFT_4Threads()) ? 2 : 4;
            Future[] futureArr = new Future[i];
            long j14 = i;
            long j15 = this.nl / j14;
            int i2 = 0;
            while (i2 < i) {
                final long j16 = ((long) i2) * j15;
                final long j17 = i2 == i + (-1) ? this.nl : j16 + j15;
                int i3 = i2;
                Future[] futureArr2 = futureArr;
                long j18 = j14;
                final FloatLargeArray floatLargeArray4 = floatLargeArray3;
                floatLargeArray3 = floatLargeArray4;
                futureArr2[i3] = ConcurrencyUtils.submit(new Runnable() { // from class: org.jtransforms.fft.FloatFFT_1D.19
                    @Override // java.lang.Runnable
                    public void run() {
                        for (long j19 = j16; j19 < j17; j19++) {
                            long j20 = 2 * j19;
                            long j21 = j20 + 1;
                            long j22 = j + j19;
                            floatLargeArray4.setFloat(j20, FloatFFT_1D.this.bk1l.getFloat(j20) * floatLargeArray.getFloat(j22));
                            floatLargeArray4.setFloat(j21, FloatFFT_1D.this.bk1l.getFloat(j21) * (-floatLargeArray.getFloat(j22)));
                        }
                    }
                });
                i2 = i3 + 1;
                futureArr = futureArr2;
                j14 = j18;
                j6 = j6;
            }
            Future[] futureArr3 = futureArr;
            long j19 = j14;
            j3 = j6;
            floatFFT_1D = this;
            try {
                ConcurrencyUtils.waitForCompletion(futureArr3);
            } catch (InterruptedException e) {
                Logger.getLogger(FloatFFT_1D.class.getName()).log(Level.SEVERE, (String) null, (Throwable) e);
            } catch (ExecutionException e2) {
                Logger.getLogger(FloatFFT_1D.class.getName()).log(Level.SEVERE, (String) null, (Throwable) e2);
            }
            j2 = j;
            j5 = 1;
            j4 = 0;
            floatLargeArray2 = floatLargeArray;
            CommonUtils.cftbsub(floatFFT_1D.nBluesteinl * j3, floatLargeArray3, 0L, floatFFT_1D.ipl, floatFFT_1D.nwl, floatFFT_1D.wl);
            long j20 = floatFFT_1D.nBluesteinl / j19;
            int i4 = 0;
            while (i4 < i) {
                final long j21 = ((long) i4) * j20;
                int i5 = i4;
                final long j22 = i4 == i + (-1) ? floatFFT_1D.nBluesteinl : j21 + j20;
                final FloatLargeArray floatLargeArray5 = floatLargeArray3;
                floatLargeArray3 = floatLargeArray5;
                futureArr3[i5] = ConcurrencyUtils.submit(new Runnable() { // from class: org.jtransforms.fft.FloatFFT_1D.20
                    @Override // java.lang.Runnable
                    public void run() {
                        for (long j23 = j21; j23 < j22; j23++) {
                            long j24 = 2 * j23;
                            long j25 = j24 + 1;
                            float f2 = (FloatFFT_1D.this.bk2l.getFloat(j24) * floatLargeArray5.getFloat(j25)) + (FloatFFT_1D.this.bk2l.getFloat(j25) * floatLargeArray5.getFloat(j24));
                            FloatLargeArray floatLargeArray6 = floatLargeArray5;
                            floatLargeArray6.setFloat(j24, (FloatFFT_1D.this.bk2l.getFloat(j24) * floatLargeArray6.getFloat(j24)) - (FloatFFT_1D.this.bk2l.getFloat(j25) * floatLargeArray5.getFloat(j25)));
                            floatLargeArray5.setFloat(j25, f2);
                        }
                    }
                });
                i4 = i5 + 1;
            }
            try {
                ConcurrencyUtils.waitForCompletion(futureArr3);
            } catch (InterruptedException e3) {
                Logger.getLogger(FloatFFT_1D.class.getName()).log(Level.SEVERE, (String) null, (Throwable) e3);
            } catch (ExecutionException e4) {
                Logger.getLogger(FloatFFT_1D.class.getName()).log(Level.SEVERE, (String) null, (Throwable) e4);
            }
        }
        CommonUtils.cftfsub(floatFFT_1D.nBluesteinl * j3, floatLargeArray3, 0L, floatFFT_1D.ipl, floatFFT_1D.nwl, floatFFT_1D.wl);
        long j23 = floatFFT_1D.nl % j3;
        FloatLargeArray floatLargeArray6 = floatFFT_1D.bk1l;
        if (j23 == j4) {
            long j24 = j4;
            float f2 = floatLargeArray3.getFloat(j24) * floatLargeArray6.getFloat(j24);
            long j25 = j5;
            floatLargeArray2.setFloat(j2, (floatLargeArray3.getFloat(j25) * floatFFT_1D.bk1l.getFloat(j25)) + f2);
            floatLargeArray2.setFloat(j2 + j25, (floatLargeArray3.getFloat(floatFFT_1D.nl + j25) * floatFFT_1D.bk1l.getFloat(floatFFT_1D.nl + j25)) + (floatLargeArray3.getFloat(floatFFT_1D.nl) * floatFFT_1D.bk1l.getFloat(floatFFT_1D.nl)));
            for (long j26 = j25; j26 < floatFFT_1D.nl / j3; j26++) {
                long j27 = j26 * j3;
                long j28 = j27 + j25;
                floatLargeArray2.setFloat(j2 + j27, (floatLargeArray3.getFloat(j28) * floatFFT_1D.bk1l.getFloat(j28)) + (floatLargeArray3.getFloat(j27) * floatFFT_1D.bk1l.getFloat(j27)));
                floatLargeArray2.setFloat(j2 + j28, (floatLargeArray3.getFloat(j28) * floatFFT_1D.bk1l.getFloat(j27)) + (floatLargeArray3.getFloat(j27) * (-floatFFT_1D.bk1l.getFloat(j28))));
                j25 = 1;
            }
            return;
        }
        long j29 = j4;
        long j30 = j5;
        floatLargeArray2.setFloat(j2, (floatLargeArray3.getFloat(j30) * floatFFT_1D.bk1l.getFloat(j30)) + (floatLargeArray3.getFloat(j29) * floatLargeArray6.getFloat(j29)));
        floatLargeArray2.setFloat(j2 + j30, (floatLargeArray3.getFloat(floatFFT_1D.nl) * floatFFT_1D.bk1l.getFloat(floatFFT_1D.nl - j30)) + (floatLargeArray3.getFloat(floatFFT_1D.nl - j30) * (-floatFFT_1D.bk1l.getFloat(floatFFT_1D.nl))));
        long j31 = j30;
        while (true) {
            long j32 = floatFFT_1D.nl;
            long j33 = (j32 - j30) / j3;
            FloatLargeArray floatLargeArray7 = floatFFT_1D.bk1l;
            if (j31 >= j33) {
                long j34 = j30;
                floatLargeArray2.setFloat((j2 + j32) - j34, (floatLargeArray3.getFloat(floatFFT_1D.nl) * floatFFT_1D.bk1l.getFloat(floatFFT_1D.nl)) + (floatLargeArray3.getFloat(floatFFT_1D.nl - j34) * floatLargeArray7.getFloat(j32 - j34)));
                return;
            }
            long j35 = j31 * j3;
            long j36 = j35 + j30;
            floatLargeArray2.setFloat(j2 + j35, (floatLargeArray3.getFloat(j36) * floatFFT_1D.bk1l.getFloat(j36)) + (floatLargeArray3.getFloat(j35) * floatLargeArray7.getFloat(j35)));
            floatLargeArray2.setFloat(j2 + j36, (floatLargeArray3.getFloat(j36) * floatFFT_1D.bk1l.getFloat(j35)) + (floatLargeArray3.getFloat(j35) * (-floatFFT_1D.bk1l.getFloat(j36))));
            j31++;
            j30 = 1;
        }
    }

    private void bluesteini() {
        float f = 3.1415927f / this.n;
        float[] fArr = this.bk1;
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        int i = 0;
        int i2 = 1;
        while (true) {
            int i3 = this.n;
            if (i2 >= i3) {
                break;
            }
            int i4 = i2 * 2;
            int i5 = (i4 - 1) + i;
            if (i5 >= i3 * 2) {
                i5 -= i3 * 2;
            }
            i = i5;
            double d = i * f;
            this.bk1[i4] = (float) FastMath.cos(d);
            this.bk1[i4 + 1] = (float) FastMath.sin(d);
            i2++;
        }
        float f2 = 1.0f / this.nBluestein;
        float[] fArr2 = this.bk2;
        float[] fArr3 = this.bk1;
        fArr2[0] = fArr3[0] * f2;
        fArr2[1] = fArr3[1] * f2;
        for (int i6 = 2; i6 < this.n * 2; i6 += 2) {
            float[] fArr4 = this.bk2;
            float[] fArr5 = this.bk1;
            fArr4[i6] = fArr5[i6] * f2;
            int i7 = i6 + 1;
            fArr4[i7] = fArr5[i7] * f2;
            int i8 = this.nBluestein;
            fArr4[(i8 * 2) - i6] = fArr4[i6];
            fArr4[((i8 * 2) - i6) + 1] = fArr4[i7];
        }
        CommonUtils.cftbsub(this.nBluestein * 2, this.bk2, 0, this.ip, this.nw, this.w);
    }

    private void bluesteinil() {
        float f = 3.1415927f / this.nl;
        float f2 = 1.0f;
        this.bk1l.setFloat(0L, 1.0f);
        this.bk1l.setFloat(1L, 0.0f);
        int i = 1;
        long j = 0;
        while (true) {
            long j2 = i;
            long j3 = this.nl;
            if (j2 >= j3) {
                break;
            }
            int i2 = i * 2;
            j += (long) (i2 - 1);
            if (j >= j3 * 2) {
                j -= j3 * 2;
            }
            float f3 = f2;
            double d = j * f;
            this.bk1l.setFloat(i2, (float) FastMath.cos(d));
            this.bk1l.setFloat(i2 + 1, (float) FastMath.sin(d));
            i++;
            f2 = f3;
        }
        float f4 = f2 / this.nBluesteinl;
        this.bk2l.setFloat(0L, this.bk1l.getFloat(0L) * f4);
        this.bk2l.setFloat(1L, this.bk1l.getFloat(1L) * f4);
        int i3 = 2;
        while (true) {
            long j4 = i3;
            if (j4 >= this.nl * 2) {
                CommonUtils.cftbsub(this.nBluesteinl * 2, this.bk2l, 0L, this.ipl, this.nwl, this.wl);
                return;
            }
            this.bk2l.setFloat(j4, this.bk1l.getFloat(j4) * f4);
            long j5 = i3 + 1;
            this.bk2l.setFloat(j5, this.bk1l.getFloat(j5) * f4);
            FloatLargeArray floatLargeArray = this.bk2l;
            floatLargeArray.setFloat((this.nBluesteinl * 2) - j4, floatLargeArray.getFloat(j4));
            FloatLargeArray floatLargeArray2 = this.bk2l;
            floatLargeArray2.setFloat(((this.nBluesteinl * 2) - j4) + 1, floatLargeArray2.getFloat(j5));
            i3 += 2;
        }
    }

    public final void cffti() {
        int i;
        int i2;
        float[] fArr;
        int i3 = this.n;
        int i4 = 1;
        if (i3 == 1) {
            return;
        }
        int i5 = i3 * 2;
        int i6 = i3 * 4;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        loop0: while (true) {
            int i10 = i7 + 1;
            i = 2;
            i8 = i10 <= 4 ? factors[i7] : i8 + 2;
            while (true) {
                int i11 = i3 / i8;
                if (i3 - (i8 * i11) != 0) {
                    break;
                }
                i2 = i9 + 1;
                this.wtable[i9 + 2 + i6] = i8;
                if (i8 == 2 && i2 != 1) {
                    int i12 = 2;
                    while (true) {
                        fArr = this.wtable;
                        if (i12 > i2) {
                            break;
                        }
                        int i13 = (i2 - i12) + 2 + i6;
                        fArr[i13 + 1] = fArr[i13];
                        i12++;
                    }
                    fArr[i6 + 2] = 2.0f;
                }
                if (i11 == 1) {
                    break loop0;
                }
                i3 = i11;
                i9 = i2;
            }
            i7 = i10;
        }
        float[] fArr2 = this.wtable;
        int i14 = this.n;
        fArr2[i6] = i14;
        fArr2[i6 + 1] = i2;
        float f = 6.2831855f / i14;
        int i15 = 1;
        int i16 = 1;
        int i17 = 1;
        while (i15 <= i2) {
            i15++;
            int i18 = (int) this.wtable[i15 + i6];
            int i19 = i16 * i18;
            int iM$1 = zzba$$ExternalSyntheticOutline0.m$1(this.n, i19, i);
            int i20 = i18 - 1;
            int i21 = 0;
            while (i4 <= i20) {
                float[] fArr3 = this.wtable;
                fArr3[(i17 - 1) + i5] = 1.0f;
                int i22 = i17 + i5;
                float f2 = 0.0f;
                fArr3[i22] = 0.0f;
                int i23 = i21 + i16;
                float f3 = i23 * f;
                int i24 = 4;
                while (i24 <= iM$1) {
                    i17 += 2;
                    f2 += 1.0f;
                    int i25 = i2;
                    int i26 = i17 + i5;
                    double d = f2 * f3;
                    this.wtable[i26 - 1] = (float) FastMath.cos(d);
                    this.wtable[i26] = (float) FastMath.sin(d);
                    i24 += 2;
                    i2 = i25;
                    i4 = i4;
                }
                int i27 = i2;
                int i28 = i4;
                if (i18 > 5) {
                    int i29 = i17 + i5;
                    float[] fArr4 = this.wtable;
                    fArr4[i22 - 1] = fArr4[i29 - 1];
                    fArr4[i22] = fArr4[i29];
                }
                i4 = i28 + 1;
                i21 = i23;
                i2 = i27;
                i = 2;
            }
            i16 = i19;
            i4 = 1;
        }
    }

    public final void cfftil() {
        long j;
        long j2;
        long j3;
        FloatLargeArray floatLargeArray;
        long j4 = this.nl;
        if (j4 == 1) {
            return;
        }
        long j5 = 2;
        long j6 = j4 * 2;
        long j7 = 4;
        long j8 = j4 * 4;
        long j9 = 0;
        long j10 = 1;
        long j11 = 0;
        long j12 = 0;
        long j13 = 0;
        loop0: while (true) {
            long j14 = j11 + 1;
            long j15 = j14 <= j7 ? factors[(int) j11] : j12 + j5;
            while (true) {
                long j16 = j4 / j15;
                if (j4 - (j15 * j16) != j9) {
                    break;
                }
                j = j13 + 1;
                j2 = j5;
                this.wtablel.setFloat(j13 + j2 + j8, j15);
                if (j15 != j2 || j == 1) {
                    j3 = j15;
                } else {
                    long j17 = j2;
                    while (true) {
                        floatLargeArray = this.wtablel;
                        if (j17 > j) {
                            break;
                        }
                        long j18 = (j - j17) + j2 + j8;
                        floatLargeArray.setFloat(j18 + 1, floatLargeArray.getFloat(j18));
                        j17++;
                        j15 = j15;
                    }
                    j3 = j15;
                    floatLargeArray.setFloat(j8 + j2, 2.0f);
                }
                if (j16 == 1) {
                    break loop0;
                }
                j4 = j16;
                j15 = j3;
                j5 = j2;
                j13 = j;
                j7 = 4;
                j9 = 0;
            }
            j12 = j15;
            j11 = j14;
        }
        this.wtablel.setFloat(j8, this.nl);
        this.wtablel.setFloat(j8 + 1, j);
        float f = 6.2831855f / this.nl;
        long j19 = 1;
        long j20 = 1;
        long j21 = 1;
        while (j19 <= j) {
            j19 += j10;
            long j22 = j;
            long j23 = (long) this.wtablel.getFloat(j19 + j8);
            long j24 = j20 * j23;
            long j25 = this.nl / j24;
            long j26 = j25 + j25 + j2;
            long j27 = j23 - j10;
            long j28 = j10;
            long j29 = 0;
            while (j28 <= j27) {
                long j30 = j26;
                long j31 = j10;
                this.wtablel.setFloat((j21 - j10) + j6, 1.0f);
                long j32 = j21 + j6;
                float f2 = 0.0f;
                this.wtablel.setFloat(j32, 0.0f);
                float f3 = f;
                long j33 = j19;
                long j34 = j29 + j20;
                float f4 = j34 * f3;
                long j35 = 4;
                while (j35 <= j30) {
                    j21 += j2;
                    f2 += 1.0f;
                    long j36 = j34;
                    long j37 = j21 + j6;
                    long j38 = j20;
                    double d = f2 * f4;
                    this.wtablel.setFloat(j37 - j31, (float) FastMath.cos(d));
                    this.wtablel.setFloat(j37, (float) FastMath.sin(d));
                    j35 += j2;
                    f3 = f3;
                    j34 = j36;
                    f4 = f4;
                    j6 = j6;
                    j20 = j38;
                }
                float f5 = f3;
                long j39 = j34;
                long j40 = j6;
                long j41 = j20;
                if (j23 > 5) {
                    long j42 = j21 + j40;
                    FloatLargeArray floatLargeArray2 = this.wtablel;
                    floatLargeArray2.setFloat(j32 - j31, floatLargeArray2.getFloat(j42 - j31));
                    FloatLargeArray floatLargeArray3 = this.wtablel;
                    floatLargeArray3.setFloat(j32, floatLargeArray3.getFloat(j42));
                }
                j28 += j31;
                j10 = j31;
                j26 = j30;
                j19 = j33;
                f = f5;
                j29 = j39;
                j6 = j40;
                j20 = j41;
            }
            j20 = j24;
            j = j22;
        }
    }

    public void radf2(long j, long j2, FloatLargeArray floatLargeArray, long j3, FloatLargeArray floatLargeArray2, long j4, long j5) {
        long j6;
        long j7 = j2 * j;
        long j8 = 2;
        long j9 = j * 2;
        long j10 = 0;
        while (j10 < j2) {
            long j11 = (j10 * j9) + j4;
            long j12 = (j10 * j) + j3;
            float f = floatLargeArray.getFloat(j12);
            float f2 = floatLargeArray.getFloat(j12 + j7);
            floatLargeArray2.setFloat((j11 + j9) - 1, TwitterImpl$$ExternalSyntheticOutline0.m$3(f, f2, floatLargeArray2, j11, f, f2));
            j10++;
            j8 = j8;
        }
        long j13 = j8;
        if (j < j13) {
            return;
        }
        if (j != j13) {
            long j14 = 0;
            while (j14 < j2) {
                j9 = j14 * j;
                long j15 = j9 * j13;
                long j16 = j15 + j;
                long j17 = j9 + j7;
                long j18 = j13;
                while (j18 < j) {
                    long j19 = (j18 - 1) + j5;
                    long j20 = j4 + j18 + j15;
                    long j21 = j4 + (j - j18) + j16;
                    long j22 = j3 + j18;
                    long j23 = j22 + j9;
                    long j24 = j7;
                    long j25 = j22 + j17;
                    long j26 = j14;
                    float f3 = floatLargeArray.getFloat(j23 - 1);
                    float f4 = floatLargeArray.getFloat(j23);
                    float f5 = floatLargeArray.getFloat(j25 - 1);
                    float f6 = floatLargeArray.getFloat(j25);
                    float f7 = this.wtable_rl.getFloat(j19 - 1);
                    float f8 = this.wtable_rl.getFloat(j19);
                    float f9 = (f8 * f6) + (f7 * f5);
                    float f10 = (f7 * f6) - (f8 * f5);
                    floatLargeArray2.setFloat(j20, f4 + f10);
                    floatLargeArray2.setFloat(j21, TwitterImpl$$ExternalSyntheticOutline0.m$3(f3, f9, floatLargeArray2, j20 - 1, f10, f4));
                    floatLargeArray2.setFloat(j21 - 1, f3 - f9);
                    j18 += j13;
                    j14 = j26;
                    j7 = j24;
                }
                j14++;
            }
            j6 = j7;
            if (j % j13 == 1) {
                return;
            }
        } else {
            j6 = j7;
        }
        long j27 = j9 * j13;
        for (long j28 = 0; j28 < j2; j28++) {
            long j29 = j4 + j27 + j;
            long j30 = ((j3 + j) - 1) + (j28 * j);
            floatLargeArray2.setFloat(j29, -floatLargeArray.getFloat(j30 + j6));
            floatLargeArray2.setFloat(j29 - 1, floatLargeArray.getFloat(j30));
        }
    }

    public void radf3(long j, long j2, FloatLargeArray floatLargeArray, long j3, FloatLargeArray floatLargeArray2, long j4, long j5) {
        long j6;
        FloatFFT_1D floatFFT_1D = this;
        FloatLargeArray floatLargeArray3 = floatLargeArray;
        long j7 = j5 + j;
        long j8 = j2 * j;
        long j9 = 0;
        while (true) {
            j6 = 3;
            if (j9 >= j2) {
                break;
            }
            long j10 = j9 * j;
            long j11 = ((j9 * 3) + 1) * j;
            long j12 = j3 + j10;
            long j13 = j12 + j8;
            long j14 = j9;
            long j15 = j12 + (2 * j8);
            float f = floatLargeArray3.getFloat(j12);
            float f2 = floatLargeArray3.getFloat(j13);
            float f3 = floatLargeArray3.getFloat(j15);
            float f4 = f2 + f3;
            floatLargeArray2.setFloat((j10 * 3) + j4, f + f4);
            floatLargeArray2.setFloat(j4 + j11 + j, (f3 - f2) * 0.8660254f);
            floatLargeArray2.setFloat(((j4 + j) - 1) + j11, (f4 * (-0.5f)) + f);
            j9 = j14 + 1;
        }
        if (j == 1) {
            return;
        }
        long j16 = 0;
        while (j16 < j2) {
            long j17 = j16 * j;
            long j18 = j17 * j6;
            long j19 = j17 + j8;
            long j20 = j19 + j8;
            long j21 = j18 + j;
            long j22 = j21 + j;
            long j23 = 2;
            while (j23 < j) {
                long j24 = j23 - 1;
                long j25 = j24 + j5;
                long j26 = j24 + j7;
                float f5 = floatFFT_1D.wtable_rl.getFloat(j25 - 1);
                float f6 = floatFFT_1D.wtable_rl.getFloat(j25);
                float f7 = floatFFT_1D.wtable_rl.getFloat(j26 - 1);
                float f8 = floatFFT_1D.wtable_rl.getFloat(j26);
                long j27 = j3 + j23;
                long j28 = j4 + j23;
                long j29 = j27 + j17;
                long j30 = j27 + j19;
                long j31 = j27 + j20;
                float f9 = floatLargeArray3.getFloat(j29 - 1);
                float f10 = floatLargeArray3.getFloat(j29);
                float f11 = floatLargeArray3.getFloat(j30 - 1);
                float f12 = floatLargeArray3.getFloat(j30);
                float f13 = floatLargeArray3.getFloat(j31 - 1);
                float f14 = floatLargeArray3.getFloat(j31);
                float f15 = (f6 * f12) + (f5 * f11);
                float f16 = (f12 * f5) - (f11 * f6);
                float f17 = (f8 * f14) + (f7 * f13);
                float f18 = (f7 * f14) - (f13 * f8);
                float f19 = f15 + f17;
                float f20 = f16 + f18;
                float f21 = (f19 * (-0.5f)) + f9;
                float f22 = (f20 * (-0.5f)) + f10;
                float f23 = (f16 - f18) * 0.8660254f;
                float f24 = (f17 - f15) * 0.8660254f;
                long j32 = j28 + j18;
                long j33 = j4 + (j - j23) + j21;
                long j34 = j28 + j22;
                floatLargeArray2.setFloat(j32, TwitterImpl$$ExternalSyntheticOutline0.m$1(f9, f19, floatLargeArray2, j32 - 1, f10, f20));
                floatLargeArray2.setFloat(j33, TwitterImpl$$ExternalSyntheticOutline0.m$2(f21, f23, floatLargeArray2, j33 - 1, f24, f22));
                floatLargeArray2.setFloat(j34, TwitterImpl$$ExternalSyntheticOutline0.m$1(f21, f23, floatLargeArray2, j34 - 1, f22, f24));
                j23 += 2;
                floatFFT_1D = this;
                floatLargeArray3 = floatLargeArray;
                j8 = j8;
                j7 = j7;
            }
            j16++;
            floatFFT_1D = this;
            floatLargeArray3 = floatLargeArray;
            j6 = 3;
        }
    }

    public void radf4(long j, long j2, FloatLargeArray floatLargeArray, long j3, FloatLargeArray floatLargeArray2, long j4, long j5) {
        long j6;
        FloatFFT_1D floatFFT_1D = this;
        FloatLargeArray floatLargeArray3 = floatLargeArray;
        long j7 = j5 + j;
        long j8 = j7 + j;
        long j9 = j2 * j;
        long j10 = 0;
        while (j10 < j2) {
            long j11 = j10 * j;
            long j12 = 4 * j11;
            long j13 = j11 + j9;
            long j14 = j13 + j9;
            float f = floatLargeArray3.getFloat(j3 + j11);
            float f2 = floatLargeArray3.getFloat(j3 + j13);
            float f3 = floatLargeArray3.getFloat(j3 + j14);
            float f4 = floatLargeArray3.getFloat(j3 + j14 + j9);
            float f5 = f2 + f4;
            float f6 = f + f3;
            long j15 = j7;
            long j16 = j4 + j12 + j + j;
            floatLargeArray2.setFloat(j4 + j12, f5 + f6);
            long j17 = j16 - 1;
            floatLargeArray2.setFloat(j17, TwitterImpl$$ExternalSyntheticOutline0.m$2(f6, f5, floatLargeArray2, j17 + j + j, f, f3));
            floatLargeArray2.setFloat(j16, f4 - f2);
            j10++;
            j7 = j15;
            j8 = j8;
        }
        long j18 = j7;
        long j19 = j8;
        long j20 = 2;
        if (j < 2) {
            return;
        }
        if (j != 2) {
            long j21 = 0;
            while (j21 < j2) {
                long j22 = j21 * j;
                long j23 = j22 + j9;
                long j24 = j23 + j9;
                long j25 = j24 + j9;
                long j26 = j22 * 4;
                long j27 = j26 + j;
                long j28 = j27 + j;
                long j29 = j28 + j;
                long j30 = j20;
                while (j30 < j) {
                    long j31 = j30 - 1;
                    long j32 = j31 + j5;
                    long j33 = j20;
                    long j34 = j31 + j18;
                    long j35 = j31 + j19;
                    long j36 = j21;
                    float f7 = floatFFT_1D.wtable_rl.getFloat(j32 - 1);
                    float f8 = floatFFT_1D.wtable_rl.getFloat(j32);
                    float f9 = floatFFT_1D.wtable_rl.getFloat(j34 - 1);
                    float f10 = floatFFT_1D.wtable_rl.getFloat(j34);
                    float f11 = floatFFT_1D.wtable_rl.getFloat(j35 - 1);
                    float f12 = floatFFT_1D.wtable_rl.getFloat(j35);
                    long j37 = j3 + j30;
                    long j38 = j4 + j30;
                    long j39 = j4 + (j - j30);
                    long j40 = j37 + j22;
                    long j41 = j37 + j23;
                    long j42 = j37 + j24;
                    long j43 = j37 + j25;
                    long j44 = j9;
                    float f13 = floatLargeArray3.getFloat(j40 - 1);
                    float f14 = floatLargeArray3.getFloat(j40);
                    float f15 = floatLargeArray3.getFloat(j41 - 1);
                    float f16 = floatLargeArray3.getFloat(j41);
                    float f17 = floatLargeArray3.getFloat(j42 - 1);
                    float f18 = floatLargeArray3.getFloat(j42);
                    float f19 = floatLargeArray3.getFloat(j43 - 1);
                    float f20 = floatLargeArray3.getFloat(j43);
                    float f21 = (f8 * f16) + (f7 * f15);
                    float f22 = (f16 * f7) - (f15 * f8);
                    float f23 = (f10 * f18) + (f9 * f17);
                    float f24 = (f9 * f18) - (f17 * f10);
                    float f25 = (f12 * f20) + (f11 * f19);
                    float f26 = (f11 * f20) - (f12 * f19);
                    float f27 = f21 + f25;
                    float f28 = f25 - f21;
                    float f29 = f22 + f26;
                    float f30 = f22 - f26;
                    float f31 = f14 + f24;
                    float f32 = f14 - f24;
                    float f33 = f13 + f23;
                    float f34 = f13 - f23;
                    long j45 = j38 + j26;
                    long j46 = j39 + j27;
                    long j47 = j38 + j28;
                    long j48 = j39 + j29;
                    floatLargeArray2.setFloat(j45 - 1, f27 + f33);
                    floatLargeArray2.setFloat(j45, TwitterImpl$$ExternalSyntheticOutline0.m(f33, f27, floatLargeArray2, j48 - 1, f29, f31));
                    floatLargeArray2.setFloat(j48, f29 - f31);
                    floatLargeArray2.setFloat(j47 - 1, f30 + f34);
                    floatLargeArray2.setFloat(j47, TwitterImpl$$ExternalSyntheticOutline0.m(f34, f30, floatLargeArray2, j46 - 1, f28, f32));
                    floatLargeArray2.setFloat(j46, f28 - f32);
                    j30 += j33;
                    floatFFT_1D = this;
                    floatLargeArray3 = floatLargeArray;
                    j20 = j33;
                    j21 = j36;
                    j9 = j44;
                }
                j21++;
                floatFFT_1D = this;
                floatLargeArray3 = floatLargeArray;
            }
            j6 = j9;
            if (j % j20 == 1) {
                return;
            }
        } else {
            j6 = j9;
        }
        for (long j49 = 0; j49 < j2; j49++) {
            long j50 = j49 * j;
            long j51 = j50 * 4;
            long j52 = j50 + j6;
            long j53 = j52 + j6;
            long j54 = j51 + j;
            long j55 = j54 + j;
            long j56 = (j3 + j) - 1;
            float f35 = floatLargeArray.getFloat(j56 + j50);
            float f36 = floatLargeArray.getFloat(j56 + j52);
            float f37 = floatLargeArray.getFloat(j56 + j53);
            float f38 = floatLargeArray.getFloat(j56 + j53 + j6);
            float f39 = (f36 + f38) * (-0.70710677f);
            float f40 = (f36 - f38) * 0.70710677f;
            long j57 = (j4 + j) - 1;
            floatLargeArray2.setFloat(j57 + j51, f40 + f35);
            floatLargeArray2.setFloat(j57 + j55, f35 - f40);
            floatLargeArray2.setFloat(j4 + j54, f39 - f37);
            floatLargeArray2.setFloat(j4 + j55 + j, f39 + f37);
        }
    }

    public void radf5(long j, long j2, FloatLargeArray floatLargeArray, long j3, FloatLargeArray floatLargeArray2, long j4, long j5) {
        FloatFFT_1D floatFFT_1D = this;
        FloatLargeArray floatLargeArray3 = floatLargeArray;
        long j6 = j5 + j;
        long j7 = j6 + j;
        long j8 = j7 + j;
        long j9 = j2 * j;
        for (long j10 = 0; j10 < j2; j10++) {
            long j11 = j10 * j;
            long j12 = 5 * j11;
            long j13 = j12 + j;
            long j14 = j13 + j;
            long j15 = j14 + j;
            long j16 = j11 + j9;
            long j17 = j16 + j9;
            long j18 = j17 + j9;
            long j19 = (j4 + j) - 1;
            float f = floatLargeArray3.getFloat(j3 + j11);
            float f2 = floatLargeArray3.getFloat(j3 + j16);
            float f3 = floatLargeArray3.getFloat(j3 + j17);
            float f4 = floatLargeArray3.getFloat(j3 + j18);
            float f5 = floatLargeArray3.getFloat(j3 + j18 + j9);
            float f6 = f5 + f2;
            float f7 = f5 - f2;
            float f8 = f4 + f3;
            float f9 = f4 - f3;
            floatLargeArray2.setFloat(j4 + j12, f + f6 + f8);
            floatLargeArray2.setFloat(j19 + j13, (f8 * (-0.809017f)) + (f6 * 0.309017f) + f);
            floatLargeArray2.setFloat(j4 + j14, (f9 * 0.58778524f) + (f7 * 0.95105654f));
            floatLargeArray2.setFloat(j19 + j15, (f8 * 0.309017f) + (f6 * (-0.809017f)) + f);
            floatLargeArray2.setFloat(j4 + j15 + j, (f7 * 0.58778524f) - (f9 * 0.95105654f));
        }
        if (j == 1) {
            return;
        }
        long j20 = 0;
        while (j20 < j2) {
            long j21 = j20 * j;
            long j22 = j21 * 5;
            long j23 = j22 + j;
            long j24 = j23 + j;
            long j25 = j24 + j;
            long j26 = j25 + j;
            long j27 = j21 + j9;
            long j28 = j27 + j9;
            long j29 = j28 + j9;
            long j30 = j29 + j9;
            long j31 = 2;
            while (j31 < j) {
                long j32 = j31 - 1;
                long j33 = j32 + j5;
                long j34 = j32 + j6;
                long j35 = j32 + j7;
                long j36 = j6;
                long j37 = j32 + j8;
                long j38 = j7;
                long j39 = j8;
                float f10 = floatFFT_1D.wtable_rl.getFloat(j33 - 1);
                float f11 = floatFFT_1D.wtable_rl.getFloat(j33);
                float f12 = floatFFT_1D.wtable_rl.getFloat(j34 - 1);
                float f13 = floatFFT_1D.wtable_rl.getFloat(j34);
                float f14 = floatFFT_1D.wtable_rl.getFloat(j35 - 1);
                float f15 = floatFFT_1D.wtable_rl.getFloat(j35);
                float f16 = floatFFT_1D.wtable_rl.getFloat(j37 - 1);
                float f17 = floatFFT_1D.wtable_rl.getFloat(j37);
                long j40 = j3 + j31;
                long j41 = j4 + j31;
                long j42 = j4 + (j - j31);
                long j43 = j40 + j21;
                long j44 = j40 + j27;
                long j45 = j40 + j28;
                long j46 = j40 + j29;
                long j47 = j40 + j30;
                float f18 = floatLargeArray3.getFloat(j43 - 1);
                float f19 = floatLargeArray3.getFloat(j43);
                float f20 = floatLargeArray3.getFloat(j44 - 1);
                float f21 = floatLargeArray3.getFloat(j44);
                float f22 = floatLargeArray3.getFloat(j45 - 1);
                float f23 = floatLargeArray3.getFloat(j45);
                float f24 = floatLargeArray3.getFloat(j46 - 1);
                float f25 = floatLargeArray3.getFloat(j46);
                float f26 = floatLargeArray3.getFloat(j47 - 1);
                float f27 = floatLargeArray3.getFloat(j47);
                float f28 = (f11 * f21) + (f10 * f20);
                float f29 = (f10 * f21) - (f20 * f11);
                float f30 = (f13 * f23) + (f12 * f22);
                float f31 = (f23 * f12) - (f13 * f22);
                float f32 = (f15 * f25) + (f14 * f24);
                float f33 = (f25 * f14) - (f15 * f24);
                float f34 = (f17 * f27) + (f16 * f26);
                float f35 = (f16 * f27) - (f26 * f17);
                float f36 = f28 + f34;
                float f37 = f34 - f28;
                float f38 = f29 - f35;
                float f39 = f29 + f35;
                float f40 = f30 + f32;
                float f41 = f32 - f30;
                float f42 = f31 - f33;
                float f43 = f31 + f33;
                float f44 = (f40 * (-0.809017f)) + (f36 * 0.309017f) + f18;
                float f45 = (f43 * (-0.809017f)) + (f39 * 0.309017f) + f19;
                float f46 = (f40 * 0.309017f) + (f36 * (-0.809017f)) + f18;
                float f47 = (f43 * 0.309017f) + (f39 * (-0.809017f)) + f19;
                float f48 = (f42 * 0.58778524f) + (f38 * 0.95105654f);
                float f49 = (f41 * 0.58778524f) + (f37 * 0.95105654f);
                float f50 = (f38 * 0.58778524f) - (f42 * 0.95105654f);
                float f51 = (f37 * 0.58778524f) - (f41 * 0.95105654f);
                long j48 = j41 + j22;
                long j49 = j42 + j23;
                long j50 = j41 + j24;
                long j51 = j42 + j25;
                long j52 = j41 + j26;
                floatLargeArray2.setFloat(j48 - 1, f18 + f36 + f40);
                floatLargeArray2.setFloat(j48, f19 + f39 + f43);
                floatLargeArray2.setFloat(j50 - 1, f44 + f48);
                floatLargeArray2.setFloat(j50, TwitterImpl$$ExternalSyntheticOutline0.m(f44, f48, floatLargeArray2, j49 - 1, f45, f49));
                floatLargeArray2.setFloat(j49, f49 - f45);
                floatLargeArray2.setFloat(j52 - 1, f46 + f50);
                floatLargeArray2.setFloat(j52, TwitterImpl$$ExternalSyntheticOutline0.m(f46, f50, floatLargeArray2, j51 - 1, f47, f51));
                floatLargeArray2.setFloat(j51, f51 - f47);
                j31 += 2;
                floatFFT_1D = this;
                floatLargeArray3 = floatLargeArray;
                j7 = j38;
                j6 = j36;
                j8 = j39;
            }
            j20++;
            floatFFT_1D = this;
            floatLargeArray3 = floatLargeArray;
        }
    }

    public void radfg(long j, long j2, long j3, long j4, FloatLargeArray floatLargeArray, long j5, FloatLargeArray floatLargeArray2, long j6, long j7) {
        long j8;
        int i;
        FloatFFT_1D floatFFT_1D = this;
        long j9 = j;
        long j10 = j2;
        FloatLargeArray floatLargeArray3 = floatLargeArray;
        FloatLargeArray floatLargeArray4 = floatLargeArray2;
        double d = 6.2831855f / j10;
        float fCos = (float) FastMath.cos(d);
        float fSin = (float) FastMath.sin(d);
        long j11 = 1;
        long j12 = (j10 + 1) / 2;
        long j13 = (j9 - 1) / 2;
        if (j9 != 1) {
            for (long j14 = 0; j14 < j4; j14++) {
                floatLargeArray4.setFloat(j6 + j14, floatLargeArray3.getFloat(j5 + j14));
            }
            long j15 = 1;
            while (j15 < j10) {
                long j16 = j15 * j3 * j9;
                long j17 = 0;
                while (j17 < j3) {
                    long j18 = (j17 * j9) + j16;
                    floatLargeArray4.setFloat(j6 + j18, floatLargeArray3.getFloat(j5 + j18));
                    j17++;
                    j15 = j15;
                }
                j15++;
                j10 = j2;
            }
            int i2 = (j13 > j3 ? 1 : (j13 == j3 ? 0 : -1));
            if (i2 <= 0) {
                long j19 = -j9;
                long j20 = 1;
                while (j20 < j2) {
                    j19 += j9;
                    long j21 = j19 - j11;
                    long j22 = j20 * j3 * j9;
                    long j23 = 2;
                    while (j23 < j9) {
                        j21 += 2;
                        int i3 = i2;
                        long j24 = j19;
                        long j25 = j21 + j7;
                        long j26 = j5 + j23;
                        long j27 = j6 + j23;
                        long j28 = j20;
                        float f = floatFFT_1D.wtable_rl.getFloat(j25 - j11);
                        float f2 = floatFFT_1D.wtable_rl.getFloat(j25);
                        long j29 = 0;
                        while (j29 < j3) {
                            long j30 = (j29 * j9) + j22;
                            float f3 = f2;
                            long j31 = j27 + j30;
                            float f4 = f;
                            long j32 = j26 + j30;
                            long j33 = j29;
                            float f5 = floatLargeArray3.getFloat(j32 - j11);
                            float f6 = floatLargeArray3.getFloat(j32);
                            long j34 = j11;
                            floatLargeArray4.setFloat(j31 - j11, (f3 * f6) + (f4 * f5));
                            floatLargeArray4.setFloat(j31, (f4 * f6) - (f3 * f5));
                            j29 = j33 + j34;
                            f2 = f3;
                            i3 = i3;
                            f = f4;
                            j11 = j34;
                        }
                        j23 += 2;
                        j19 = j24;
                        j20 = j28;
                        i2 = i3;
                    }
                    j20 += j11;
                }
                i = i2;
                j8 = j11;
            } else {
                i = i2;
                j8 = 1;
                long j35 = -j9;
                long j36 = 1;
                while (j36 < j2) {
                    j35 += j9;
                    long j37 = j36 * j3 * j9;
                    long j38 = 0;
                    while (j38 < j3) {
                        long j39 = j35 - 1;
                        long j40 = (j38 * j9) + j37;
                        long j41 = 2;
                        while (j41 < j9) {
                            j39 += 2;
                            long j42 = j39 + j7;
                            long j43 = j35;
                            float f7 = floatFFT_1D.wtable_rl.getFloat(j42 - 1);
                            float f8 = floatFFT_1D.wtable_rl.getFloat(j42);
                            long j44 = j6 + j41 + j40;
                            long j45 = j5 + j41 + j40;
                            float f9 = floatLargeArray3.getFloat(j45 - 1);
                            float f10 = floatLargeArray3.getFloat(j45);
                            floatLargeArray4.setFloat(j44 - 1, (f8 * f10) + (f7 * f9));
                            floatLargeArray4.setFloat(j44, (f10 * f7) - (f8 * f9));
                            j41 += 2;
                            floatFFT_1D = this;
                            j9 = j;
                            j35 = j43;
                            j36 = j36;
                        }
                        j38++;
                        floatFFT_1D = this;
                        j9 = j;
                    }
                    j36++;
                    floatFFT_1D = this;
                    j9 = j;
                }
            }
            if (i >= 0) {
                long j46 = j8;
                while (j46 < j12) {
                    long j47 = j46 * j3 * j;
                    long j48 = (j2 - j46) * j3 * j;
                    for (long j49 = 0; j49 < j3; j49 += j8) {
                        long j50 = j49 * j;
                        long j51 = j50 + j47;
                        long j52 = j50 + j48;
                        long j53 = 2;
                        while (j53 < j) {
                            long j54 = j5 + j53;
                            long j55 = j6 + j53;
                            long j56 = j54 + j51;
                            long j57 = j54 + j52;
                            long j58 = j46;
                            long j59 = j55 + j51;
                            long j60 = j55 + j52;
                            long j61 = j48;
                            float f11 = floatLargeArray4.getFloat(j59 - j8);
                            float f12 = floatLargeArray4.getFloat(j59);
                            float f13 = floatLargeArray4.getFloat(j60 - j8);
                            float f14 = floatLargeArray4.getFloat(j60);
                            floatLargeArray3.setFloat(j56, TwitterImpl$$ExternalSyntheticOutline0.m$1(f11, f13, floatLargeArray3, j56 - j8, f12, f14));
                            floatLargeArray3.setFloat(j57, TwitterImpl$$ExternalSyntheticOutline0.m$2(f12, f14, floatLargeArray3, j57 - j8, f13, f11));
                            j53 += 2;
                            j46 = j58;
                            j48 = j61;
                        }
                    }
                    j46 += j8;
                }
            } else {
                long j62 = j8;
                while (j62 < j12) {
                    long j63 = j62 * j3 * j;
                    long j64 = (j2 - j62) * j3 * j;
                    for (long j65 = 2; j65 < j; j65 += 2) {
                        long j66 = j5 + j65;
                        long j67 = j6 + j65;
                        long j68 = 0;
                        while (j68 < j3) {
                            long j69 = j68 * j;
                            long j70 = j69 + j63;
                            long j71 = j69 + j64;
                            long j72 = j66 + j70;
                            long j73 = j62;
                            long j74 = j66 + j71;
                            long j75 = j67 + j70;
                            long j76 = j67 + j71;
                            long j77 = j64;
                            float f15 = floatLargeArray4.getFloat(j75 - j8);
                            float f16 = floatLargeArray4.getFloat(j75);
                            float f17 = floatLargeArray4.getFloat(j76 - j8);
                            float f18 = floatLargeArray4.getFloat(j76);
                            floatLargeArray3.setFloat(j72, TwitterImpl$$ExternalSyntheticOutline0.m$1(f15, f17, floatLargeArray3, j72 - j8, f16, f18));
                            floatLargeArray3.setFloat(j74, TwitterImpl$$ExternalSyntheticOutline0.m$2(f16, f18, floatLargeArray3, j74 - j8, f17, f15));
                            j68 += j8;
                            j62 = j73;
                            j64 = j77;
                        }
                    }
                    j62 += j8;
                }
            }
        } else {
            j8 = 1;
            LargeArrayUtils.arraycopy(floatLargeArray4, j6, floatLargeArray3, j5, j4);
            floatLargeArray4 = floatLargeArray4;
            floatLargeArray3 = floatLargeArray3;
        }
        long j78 = j8;
        while (j78 < j12) {
            long j79 = j78 * j3 * j;
            long j80 = (j2 - j78) * j3 * j;
            long j81 = 0;
            while (j81 < j3) {
                long j82 = j81 * j;
                long j83 = j82 + j79;
                long j84 = j82 + j80;
                long j85 = j78;
                float f19 = floatLargeArray4.getFloat(j6 + j83);
                float f20 = floatLargeArray4.getFloat(j6 + j84);
                floatLargeArray3.setFloat(j5 + j83, f19 + f20);
                floatLargeArray3.setFloat(j5 + j84, f20 - f19);
                j81 += j8;
                j78 = j85;
                j80 = j80;
            }
            j78 += j8;
        }
        long j86 = (j2 - j8) * j4;
        float f21 = 1.0f;
        float f22 = 0.0f;
        long j87 = j8;
        while (j87 < j12) {
            float f23 = (fCos * f21) - (fSin * f22);
            float f24 = (f22 * fCos) + (f21 * fSin);
            long j88 = j87 * j4;
            long j89 = (j2 - j87) * j4;
            long j90 = 0;
            while (j90 < j4) {
                long j91 = j6 + j90;
                long j92 = j86;
                long j93 = j5 + j90;
                float f25 = f24;
                floatLargeArray4.setFloat(j91 + j88, (floatLargeArray3.getFloat(j93 + j4) * f23) + floatLargeArray3.getFloat(j93));
                floatLargeArray4.setFloat(j91 + j89, floatLargeArray3.getFloat(j93 + j92) * f25);
                j90 += j8;
                f24 = f25;
                j86 = j92;
            }
            long j94 = j86;
            float f26 = f24;
            float f27 = f23;
            long j95 = 2;
            while (j95 < j12) {
                float f28 = (f23 * f27) - (f26 * f24);
                f24 = (f24 * f23) + (f27 * f26);
                long j96 = j95 * j4;
                long j97 = (j2 - j95) * j4;
                long j98 = 0;
                while (j98 < j4) {
                    long j99 = j6 + j98;
                    long j100 = j5 + j98;
                    long j101 = j95;
                    long j102 = j99 + j88;
                    float f29 = f24;
                    floatLargeArray4.setFloat(j102, (floatLargeArray3.getFloat(j100 + j96) * f28) + floatLargeArray4.getFloat(j102));
                    long j103 = j99 + j89;
                    floatLargeArray4.setFloat(j103, (floatLargeArray3.getFloat(j100 + j97) * f29) + floatLargeArray4.getFloat(j103));
                    j98 += j8;
                    j95 = j101;
                    f24 = f29;
                }
                j95 += j8;
                f27 = f28;
            }
            j87 += j8;
            f22 = f26;
            j86 = j94;
            f21 = f23;
        }
        for (long j104 = j8; j104 < j12; j104 += j8) {
            long j105 = j104 * j4;
            for (long j106 = 0; j106 < j4; j106 += j8) {
                long j107 = j6 + j106;
                floatLargeArray4.setFloat(j107, floatLargeArray3.getFloat(j5 + j106 + j105) + floatLargeArray4.getFloat(j107));
            }
        }
        if (j >= j3) {
            for (long j108 = 0; j108 < j3; j108 += j8) {
                long j109 = j108 * j;
                long j110 = j109 * j2;
                for (long j111 = 0; j111 < j; j111 += j8) {
                    floatLargeArray3.setFloat(j5 + j111 + j110, floatLargeArray4.getFloat(j6 + j111 + j109));
                }
            }
        } else {
            for (long j112 = 0; j112 < j; j112 += j8) {
                for (long j113 = 0; j113 < j3; j113 += j8) {
                    long j114 = j113 * j;
                    floatLargeArray3.setFloat((j114 * j2) + j5 + j112, floatLargeArray4.getFloat(j6 + j112 + j114));
                }
            }
        }
        long j115 = j2 * j;
        long j116 = j8;
        while (j116 < j12) {
            long j117 = j116 * j3 * j;
            long j118 = (j2 - j116) * j3 * j;
            long j119 = j116 * 2 * j;
            long j120 = 0;
            while (j120 < j3) {
                long j121 = j120 * j;
                long j122 = j120 * j115;
                floatLargeArray3.setFloat(((((j5 + j) - j8) + j119) - j) + j122, floatLargeArray4.getFloat(j6 + j121 + j117));
                floatLargeArray3.setFloat(j5 + j119 + j122, floatLargeArray4.getFloat(j6 + j121 + j118));
                j120 += j8;
                j115 = j115;
                j116 = j116;
            }
            j116 += j8;
        }
        long j123 = j115;
        if (j9 == 1) {
            return;
        }
        if (j13 >= j3) {
            long j124 = j8;
            while (j124 < j12) {
                long j125 = j124 * j3 * j;
                long j126 = (j2 - j124) * j3 * j;
                long j127 = j124 * 2 * j;
                for (long j128 = 0; j128 < j3; j128 += j8) {
                    long j129 = j128 * j123;
                    long j130 = j128 * j;
                    long j131 = 2;
                    while (j131 < j) {
                        long j132 = j5 + j131 + j127 + j129;
                        long j133 = (((j5 + (j - j131)) + j127) - j) + j129;
                        long j134 = j6 + j131 + j130;
                        long j135 = j124;
                        long j136 = j134 + j125;
                        long j137 = j134 + j126;
                        long j138 = j126;
                        float f30 = floatLargeArray4.getFloat(j136 - j8);
                        float f31 = floatLargeArray4.getFloat(j136);
                        float f32 = floatLargeArray4.getFloat(j137 - j8);
                        float f33 = floatLargeArray4.getFloat(j137);
                        floatLargeArray3.setFloat(j132 - j8, f30 + f32);
                        floatLargeArray3.setFloat(j132, TwitterImpl$$ExternalSyntheticOutline0.m(f30, f32, floatLargeArray3, j133 - j8, f31, f33));
                        floatLargeArray3.setFloat(j133, f33 - f31);
                        j131 += 2;
                        j124 = j135;
                        j126 = j138;
                    }
                }
                j124 += j8;
            }
            return;
        }
        long j139 = j8;
        while (j139 < j12) {
            long j140 = j139 * j3 * j;
            long j141 = (j2 - j139) * j3 * j;
            long j142 = j139 * 2 * j;
            for (long j143 = 2; j143 < j; j143 += 2) {
                long j144 = j5 + j143;
                long j145 = j5 + (j - j143);
                long j146 = j6 + j143;
                long j147 = 0;
                while (j147 < j3) {
                    long j148 = j147 * j123;
                    long j149 = j144 + j142 + j148;
                    long j150 = ((j145 + j142) - j) + j148;
                    long j151 = j146 + (j147 * j);
                    long j152 = j151 + j140;
                    long j153 = j151 + j141;
                    long j154 = j139;
                    float f34 = floatLargeArray4.getFloat(j152 - j8);
                    float f35 = floatLargeArray4.getFloat(j152);
                    float f36 = floatLargeArray4.getFloat(j153 - j8);
                    float f37 = floatLargeArray4.getFloat(j153);
                    floatLargeArray3.setFloat(j149 - j8, f34 + f36);
                    floatLargeArray3.setFloat(j149, TwitterImpl$$ExternalSyntheticOutline0.m(f34, f36, floatLargeArray3, j150 - j8, f35, f37));
                    floatLargeArray3.setFloat(j150, f37 - f35);
                    j147 += j8;
                    j139 = j154;
                    j141 = j141;
                }
            }
            j139 += j8;
        }
    }

    public void realForward(FloatLargeArray floatLargeArray, long j) {
        if (!this.useLargeArrays) {
            if (floatLargeArray.isLarge() || floatLargeArray.isConstant() || j >= 2147483647L) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("The data array is too big.");
                return;
            } else {
                realForward(floatLargeArray.getData(), (int) j);
                return;
            }
        }
        if (this.nl == 1) {
            return;
        }
        int i = AnonymousClass29.$SwitchMap$org$jtransforms$fft$FloatFFT_1D$Plans[this.plan.ordinal()];
        if (i == 1) {
            long j2 = this.nl;
            if (j2 > 4) {
                CommonUtils.cftfsub(j2, floatLargeArray, j, this.ipl, this.nwl, this.wl);
                CommonUtils.rftfsub(this.nl, floatLargeArray, j, this.ncl, this.wl, this.nwl);
            } else if (j2 == 4) {
                CommonUtils.cftx020(floatLargeArray, j);
            }
            long j3 = j + 1;
            float f = floatLargeArray.getFloat(j) - floatLargeArray.getFloat(j3);
            floatLargeArray.setFloat(j, floatLargeArray.getFloat(j3) + floatLargeArray.getFloat(j));
            floatLargeArray.setFloat(j3, f);
            return;
        }
        if (i != 2) {
            if (i != 3) {
                return;
            }
            bluestein_real_forward(floatLargeArray, j);
            return;
        }
        rfftf(floatLargeArray, j);
        long j4 = this.nl;
        while (true) {
            j4--;
            if (j4 < 2) {
                return;
            }
            long j5 = j + j4;
            float f2 = floatLargeArray.getFloat(j5);
            long j6 = j5 - 1;
            floatLargeArray.setFloat(j5, floatLargeArray.getFloat(j6));
            floatLargeArray.setFloat(j6, f2);
        }
    }

    public void rfftf(FloatLargeArray floatLargeArray, long j) {
        long j2;
        FloatLargeArray floatLargeArray2;
        FloatFFT_1D floatFFT_1D = this;
        long j3 = floatFFT_1D.nl;
        if (j3 == 1) {
            return;
        }
        FloatLargeArray floatLargeArray3 = new FloatLargeArray(j3);
        long j4 = floatFFT_1D.nl * 2;
        long j5 = (long) floatFFT_1D.wtable_rl.getFloat(j4 + 1);
        long j6 = floatFFT_1D.nl;
        long j7 = j4 - 1;
        long j8 = 1;
        long j9 = 1;
        while (j9 <= j5) {
            int i = (int) floatFFT_1D.wtable_rl.getFloat((j5 - j9) + 2 + j4);
            long j10 = j6;
            long j11 = i;
            FloatLargeArray floatLargeArray4 = floatLargeArray3;
            long j12 = j10 / j11;
            long j13 = j5;
            long j14 = floatFFT_1D.nl / j10;
            long j15 = j14 * j12;
            long j16 = j7 - (((long) (i - 1)) * j14);
            long j17 = 1 - j8;
            if (i == 2) {
                j6 = j12;
                floatLargeArray3 = floatLargeArray4;
                j2 = j16;
                if (j17 == 0) {
                    floatFFT_1D = this;
                    floatLargeArray2 = floatLargeArray3;
                    floatFFT_1D.radf2(j14, j6, floatLargeArray, j, floatLargeArray2, 0L, j2);
                    floatLargeArray3 = floatLargeArray2;
                    j8 = j17;
                } else {
                    floatFFT_1D = this;
                    floatFFT_1D.radf2(j14, j6, floatLargeArray3, 0L, floatLargeArray, j, j2);
                    j8 = j17;
                }
            } else if (i == 3) {
                j6 = j12;
                floatLargeArray3 = floatLargeArray4;
                j2 = j16;
                if (j17 == 0) {
                    floatFFT_1D = this;
                    floatLargeArray2 = floatLargeArray3;
                    floatFFT_1D.radf3(j14, j6, floatLargeArray, j, floatLargeArray2, 0L, j2);
                    floatLargeArray3 = floatLargeArray2;
                    j8 = j17;
                } else {
                    floatFFT_1D = this;
                    floatFFT_1D.radf3(j14, j6, floatLargeArray3, 0L, floatLargeArray, j, j2);
                    j8 = j17;
                }
            } else if (i == 4) {
                j6 = j12;
                floatLargeArray3 = floatLargeArray4;
                j2 = j16;
                if (j17 == 0) {
                    floatFFT_1D = this;
                    floatLargeArray2 = floatLargeArray3;
                    floatFFT_1D.radf4(j14, j6, floatLargeArray, j, floatLargeArray2, 0L, j2);
                    floatLargeArray3 = floatLargeArray2;
                    j8 = j17;
                } else {
                    floatFFT_1D = this;
                    floatFFT_1D.radf4(j14, j6, floatLargeArray3, 0L, floatLargeArray, j, j2);
                    j8 = j17;
                }
            } else if (i != 5) {
                if (j14 == 1) {
                    j17 = 1 - j17;
                }
                if (j17 == 0) {
                    floatFFT_1D = this;
                    floatFFT_1D.radfg(j14, j11, j12, j15, floatLargeArray, j, floatLargeArray4, 0L, j16);
                    j6 = j12;
                    floatLargeArray3 = floatLargeArray4;
                    j2 = j16;
                    j8 = 1;
                } else {
                    floatFFT_1D = this;
                    floatFFT_1D.radfg(j14, j11, j12, j15, floatLargeArray4, 0L, floatLargeArray, j, j16);
                    j6 = j12;
                    floatLargeArray3 = floatLargeArray4;
                    j2 = j16;
                    j8 = 0;
                }
            } else {
                j6 = j12;
                floatLargeArray3 = floatLargeArray4;
                j2 = j16;
                if (j17 == 0) {
                    floatFFT_1D = this;
                    floatLargeArray2 = floatLargeArray3;
                    floatFFT_1D.radf5(j14, j6, floatLargeArray, j, floatLargeArray2, 0L, j2);
                    floatLargeArray3 = floatLargeArray2;
                    j8 = j17;
                } else {
                    floatFFT_1D = this;
                    floatFFT_1D.radf5(j14, j6, floatLargeArray3, 0L, floatLargeArray, j, j2);
                    j8 = j17;
                }
            }
            j9++;
            j7 = j2;
            j5 = j13;
        }
        if (j8 == 1) {
            return;
        }
        LargeArrayUtils.arraycopy(floatLargeArray3, 0L, floatLargeArray, j, floatFFT_1D.nl);
    }

    public void rffti() {
        int i;
        float[] fArr;
        FloatFFT_1D floatFFT_1D = this;
        int i2 = floatFFT_1D.n;
        int i3 = 1;
        if (i2 == 1) {
            return;
        }
        int i4 = i2 * 2;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        loop0: while (true) {
            int i8 = i5 + 1;
            i6 = i8 <= 4 ? factors[i5] : i6 + 2;
            while (true) {
                int i9 = i2 / i6;
                if (i2 - (i6 * i9) != 0) {
                    break;
                }
                i = i7 + 1;
                floatFFT_1D.wtable_r[i7 + 2 + i4] = i6;
                if (i6 == 2 && i != 1) {
                    int i10 = 2;
                    while (true) {
                        fArr = floatFFT_1D.wtable_r;
                        if (i10 > i) {
                            break;
                        }
                        int i11 = (i - i10) + 2 + i4;
                        fArr[i11 + 1] = fArr[i11];
                        i10++;
                    }
                    fArr[i4 + 2] = 2.0f;
                }
                if (i9 == 1) {
                    break loop0;
                }
                floatFFT_1D = this;
                i7 = i;
                i2 = i9;
            }
            i5 = i8;
        }
        float[] fArr2 = floatFFT_1D.wtable_r;
        int i12 = floatFFT_1D.n;
        fArr2[i4] = i12;
        fArr2[i4 + 1] = i;
        float f = 6.2831855f / i12;
        if (i7 == 0) {
            return;
        }
        int i13 = 1;
        int i14 = 1;
        int i15 = 0;
        while (i13 <= i7) {
            i13++;
            int i16 = (int) floatFFT_1D.wtable_r[i13 + i4];
            int i17 = i14 * i16;
            int i18 = floatFFT_1D.n / i17;
            int i19 = i16 - i3;
            int i20 = i3;
            int i21 = 0;
            while (i20 <= i19) {
                i21 += i14;
                float f2 = i21 * f;
                float f3 = 0.0f;
                int i22 = i3;
                int i23 = 3;
                int i24 = i15;
                while (i23 <= i18) {
                    i24 += 2;
                    f3 += 1.0f;
                    int i25 = i24 + floatFFT_1D.n;
                    float f4 = f;
                    double d = f3 * f2;
                    floatFFT_1D.wtable_r[i25 - 2] = (float) FastMath.cos(d);
                    floatFFT_1D.wtable_r[i25 - 1] = (float) FastMath.sin(d);
                    i23 += 2;
                    floatFFT_1D = this;
                    f = f4;
                }
                i15 += i18;
                i20++;
                floatFFT_1D = this;
                i3 = i22;
            }
            floatFFT_1D = this;
            i14 = i17;
        }
    }

    public void rfftil() {
        long j;
        long j2;
        long j3;
        long j4;
        FloatLargeArray floatLargeArray;
        long j5 = this.nl;
        long j6 = 1;
        if (j5 == 1) {
            return;
        }
        long j7 = 2;
        long j8 = j5 * 2;
        long j9 = 0;
        long j10 = 0;
        long j11 = 0;
        long j12 = 0;
        loop0: while (true) {
            long j13 = j10 + j6;
            j11 = j13 <= 4 ? factors[(int) j10] : j11 + j7;
            while (true) {
                long j14 = j5 / j11;
                if (j5 - (j11 * j14) != j9) {
                    break;
                }
                j = j12 + j6;
                j2 = j6;
                j3 = j7;
                this.wtable_rl.setFloat(j12 + j7 + j8, j11);
                if (j11 != j3 || j == j2) {
                    j4 = j9;
                } else {
                    long j15 = j3;
                    while (true) {
                        floatLargeArray = this.wtable_rl;
                        if (j15 > j) {
                            break;
                        }
                        long j16 = j9;
                        long j17 = (j - j15) + j3 + j8;
                        floatLargeArray.setFloat(j17 + j2, floatLargeArray.getFloat(j17));
                        j15 += j2;
                        j9 = j16;
                    }
                    j4 = j9;
                    floatLargeArray.setFloat(j8 + j3, 2.0f);
                }
                if (j14 == j2) {
                    break loop0;
                }
                j12 = j;
                j5 = j14;
                j6 = j2;
                j7 = j3;
                j9 = j4;
            }
            j10 = j13;
        }
        this.wtable_rl.setFloat(j8, this.nl);
        this.wtable_rl.setFloat(j8 + j2, j);
        float f = 6.2831855f / this.nl;
        if (j12 == j4) {
            return;
        }
        long j18 = j2;
        long j19 = j18;
        long j20 = j4;
        while (j18 <= j12) {
            j18 += j2;
            long j21 = (long) this.wtable_rl.getFloat(j18 + j8);
            long j22 = j19 * j21;
            float f2 = f;
            long j23 = this.nl / j22;
            long j24 = j21 - j2;
            long j25 = j2;
            long j26 = j4;
            while (j25 <= j24) {
                long j27 = j23;
                long j28 = j26 + j19;
                long j29 = j18;
                float f3 = j28 * f2;
                float f4 = 0.0f;
                long j30 = 3;
                long j31 = j20;
                while (j30 <= j27) {
                    j31 += j3;
                    float f5 = f4 + 1.0f;
                    long j32 = j31 + this.nl;
                    long j33 = j19;
                    double d = f5 * f3;
                    this.wtable_rl.setFloat(j32 - j3, (float) FastMath.cos(d));
                    this.wtable_rl.setFloat(j32 - j2, (float) FastMath.sin(d));
                    j30 += j3;
                    f3 = f3;
                    j28 = j28;
                    f4 = f5;
                    j19 = j33;
                }
                long j34 = j28;
                j20 += j27;
                j25 += j2;
                j18 = j29;
                j23 = j27;
                j26 = j34;
            }
            j19 = j22;
            f = f2;
        }
    }

    public void radfg(int i, int i2, int i3, int i4, float[] fArr, int i5, float[] fArr2, int i6, int i7) {
        float f;
        int i8;
        int i9;
        int i10 = i2;
        double d = 6.2831855f / i10;
        float fCos = (float) FastMath.cos(d);
        float fSin = (float) FastMath.sin(d);
        int i11 = (i10 + 1) / 2;
        int i12 = (i - 1) / 2;
        int i13 = 1;
        if (i != 1) {
            i8 = 2;
            for (int i14 = 0; i14 < i4; i14++) {
                fArr2[i6 + i14] = fArr[i5 + i14];
            }
            for (int i15 = 1; i15 < i10; i15++) {
                int i16 = i15 * i3 * i;
                for (int i17 = 0; i17 < i3; i17++) {
                    int i18 = (i17 * i) + i16;
                    fArr2[i6 + i18] = fArr[i5 + i18];
                }
            }
            if (i12 <= i3) {
                int i19 = -i;
                int i20 = 1;
                while (i20 < i10) {
                    i19 += i;
                    int i21 = i19 - 1;
                    int i22 = i20 * i3 * i;
                    int i23 = i13;
                    int i24 = 2;
                    while (i24 < i) {
                        i21 += 2;
                        int i25 = i21 + i7;
                        int i26 = i5 + i24;
                        int i27 = i6 + i24;
                        float f2 = fSin;
                        float[] fArr3 = this.wtable_r;
                        float f3 = fArr3[i25 - 1];
                        float f4 = fArr3[i25];
                        for (int i28 = 0; i28 < i3; i28++) {
                            int i29 = (i28 * i) + i22;
                            int i30 = i27 + i29;
                            int i31 = i26 + i29;
                            float f5 = fArr[i31 - 1];
                            float f6 = fArr[i31];
                            fArr2[i30 - 1] = (f4 * f6) + (f3 * f5);
                            fArr2[i30] = (f6 * f3) - (f5 * f4);
                        }
                        i24 += 2;
                        fSin = f2;
                    }
                    i20++;
                    i13 = i23;
                }
                f = fSin;
                i9 = i13;
            } else {
                f = fSin;
                i9 = 1;
                int i32 = -i;
                int i33 = 1;
                while (i33 < i10) {
                    i32 += i;
                    int i34 = i33 * i3 * i;
                    for (int i35 = 0; i35 < i3; i35++) {
                        int i36 = i32 - 1;
                        int i37 = (i35 * i) + i34;
                        int i38 = 2;
                        while (i38 < i) {
                            i36 += 2;
                            int i39 = i36 + i7;
                            int i40 = i38;
                            float[] fArr4 = this.wtable_r;
                            float f7 = fArr4[i39 - 1];
                            float f8 = fArr4[i39];
                            int i41 = i6 + i40 + i37;
                            int i42 = i5 + i40 + i37;
                            float f9 = fArr[i42 - 1];
                            float f10 = fArr[i42];
                            fArr2[i41 - 1] = (f8 * f10) + (f7 * f9);
                            fArr2[i41] = (f7 * f10) - (f8 * f9);
                            i38 = i40 + 2;
                        }
                    }
                    i33++;
                    i10 = i2;
                }
            }
            if (i12 >= i3) {
                int i43 = i9;
                while (i43 < i11) {
                    int i44 = i43 * i3 * i;
                    int i45 = (i2 - i43) * i3 * i;
                    int i46 = 0;
                    while (i46 < i3) {
                        int i47 = i46 * i;
                        int i48 = i47 + i44;
                        int i49 = i47 + i45;
                        int i50 = i43;
                        for (int i51 = 2; i51 < i; i51 += 2) {
                            int i52 = i5 + i51;
                            int i53 = i6 + i51;
                            int i54 = i52 + i48;
                            int i55 = i52 + i49;
                            int i56 = i53 + i48;
                            int i57 = i53 + i49;
                            float f11 = fArr2[i56 - 1];
                            float f12 = fArr2[i56];
                            float f13 = fArr2[i57 - 1];
                            float f14 = fArr2[i57];
                            fArr[i54 - 1] = f11 + f13;
                            fArr[i54] = f12 + f14;
                            fArr[i55 - 1] = f12 - f14;
                            fArr[i55] = f13 - f11;
                        }
                        i46++;
                        i43 = i50;
                    }
                    i43++;
                }
            } else {
                int i58 = i9;
                while (i58 < i11) {
                    int i59 = i58 * i3 * i;
                    int i60 = (i2 - i58) * i3 * i;
                    int i61 = 2;
                    while (i61 < i) {
                        int i62 = i5 + i61;
                        int i63 = i6 + i61;
                        int i64 = i58;
                        for (int i65 = 0; i65 < i3; i65++) {
                            int i66 = i65 * i;
                            int i67 = i66 + i59;
                            int i68 = i66 + i60;
                            int i69 = i62 + i67;
                            int i70 = i62 + i68;
                            int i71 = i63 + i67;
                            int i72 = i63 + i68;
                            float f15 = fArr2[i71 - 1];
                            float f16 = fArr2[i71];
                            float f17 = fArr2[i72 - 1];
                            float f18 = fArr2[i72];
                            fArr[i69 - 1] = f15 + f17;
                            fArr[i69] = f16 + f18;
                            fArr[i70 - 1] = f16 - f18;
                            fArr[i70] = f17 - f15;
                        }
                        i61 += 2;
                        i58 = i64;
                    }
                    i58++;
                }
            }
        } else {
            f = fSin;
            i8 = 2;
            i9 = 1;
            System.arraycopy(fArr2, i6, fArr, i5, i4);
        }
        for (int i73 = i9; i73 < i11; i73++) {
            int i74 = i73 * i3 * i;
            int i75 = (i2 - i73) * i3 * i;
            for (int i76 = 0; i76 < i3; i76++) {
                int i77 = i76 * i;
                int i78 = i77 + i74;
                int i79 = i77 + i75;
                float f19 = fArr2[i6 + i78];
                float f20 = fArr2[i6 + i79];
                fArr[i78 + i5] = f19 + f20;
                fArr[i79 + i5] = f20 - f19;
            }
        }
        int i80 = (i2 - 1) * i4;
        float f21 = 1.0f;
        float f22 = 0.0f;
        int i81 = i9;
        while (i81 < i11) {
            float f23 = (fCos * f21) - (f * f22);
            f22 = (f22 * fCos) + (f21 * f);
            int i82 = i81 * i4;
            int i83 = (i2 - i81) * i4;
            int i84 = i80;
            for (int i85 = 0; i85 < i4; i85++) {
                int i86 = i6 + i85;
                int i87 = i5 + i85;
                fArr2[i86 + i82] = (fArr[i87 + i4] * f23) + fArr[i87];
                fArr2[i86 + i83] = fArr[i87 + i84] * f22;
            }
            float f24 = f22;
            float f25 = f23;
            int i88 = i8;
            while (i88 < i11) {
                float f26 = (f23 * f25) - (f22 * f24);
                f24 = (f25 * f22) + (f24 * f23);
                int i89 = i88 * i4;
                int i90 = (i2 - i88) * i4;
                int i91 = i88;
                for (int i92 = 0; i92 < i4; i92++) {
                    int i93 = i6 + i92;
                    int i94 = i5 + i92;
                    int i95 = i93 + i82;
                    fArr2[i95] = (fArr[i94 + i89] * f26) + fArr2[i95];
                    int i96 = i93 + i83;
                    fArr2[i96] = (fArr[i94 + i90] * f24) + fArr2[i96];
                }
                i88 = i91 + 1;
                f25 = f26;
            }
            i81++;
            i80 = i84;
            f21 = f23;
        }
        for (int i97 = i9; i97 < i11; i97++) {
            int i98 = i97 * i4;
            for (int i99 = 0; i99 < i4; i99++) {
                int i100 = i6 + i99;
                fArr2[i100] = fArr2[i100] + fArr[i5 + i99 + i98];
            }
        }
        if (i >= i3) {
            for (int i101 = 0; i101 < i3; i101++) {
                int i102 = i101 * i;
                int i103 = i102 * i2;
                for (int i104 = 0; i104 < i; i104++) {
                    fArr[i5 + i104 + i103] = fArr2[i6 + i104 + i102];
                }
            }
        } else {
            for (int i105 = 0; i105 < i; i105++) {
                for (int i106 = 0; i106 < i3; i106++) {
                    int i107 = i106 * i;
                    fArr[(i107 * i2) + i5 + i105] = fArr2[i6 + i105 + i107];
                }
            }
        }
        int i108 = i2 * i;
        for (int i109 = i9; i109 < i11; i109++) {
            int i110 = i109 * i3 * i;
            int i111 = (i2 - i109) * i3 * i;
            int i112 = i109 * 2 * i;
            for (int i113 = 0; i113 < i3; i113++) {
                int i114 = i113 * i;
                int i115 = i113 * i108;
                fArr[((((i5 + i) - 1) + i112) - i) + i115] = fArr2[i114 + i110 + i6];
                fArr[i5 + i112 + i115] = fArr2[i114 + i111 + i6];
            }
        }
        int i116 = i9;
        if (i == i116) {
            return;
        }
        if (i12 >= i3) {
            for (int i117 = i116; i117 < i11; i117++) {
                int i118 = i117 * i3 * i;
                int i119 = (i2 - i117) * i3 * i;
                int i120 = i117 * 2 * i;
                for (int i121 = 0; i121 < i3; i121++) {
                    int i122 = i121 * i108;
                    int i123 = i121 * i;
                    int i124 = i8;
                    while (i124 < i) {
                        int i125 = i108;
                        int i126 = i5 + i124 + i120 + i122;
                        int iM$1 = zzba$$ExternalSyntheticOutline0.m$1(i5 + (i - i124), i120, i, i122);
                        int i127 = i6 + i124 + i123;
                        int i128 = i127 + i118;
                        int i129 = i127 + i119;
                        float f27 = fArr2[i128 - 1];
                        float f28 = fArr2[i128];
                        float f29 = fArr2[i129 - 1];
                        float f30 = fArr2[i129];
                        fArr[i126 - 1] = f27 + f29;
                        fArr[iM$1 - 1] = f27 - f29;
                        fArr[i126] = f28 + f30;
                        fArr[iM$1] = f30 - f28;
                        i124 += 2;
                        i108 = i125;
                    }
                }
            }
            return;
        }
        for (int i130 = i116; i130 < i11; i130++) {
            int i131 = i130 * i3 * i;
            int i132 = (i2 - i130) * i3 * i;
            int i133 = i130 * 2 * i;
            for (int i134 = i8; i134 < i; i134 += 2) {
                int i135 = i5 + i134;
                int i136 = (i - i134) + i5;
                int i137 = i6 + i134;
                int i138 = 0;
                while (i138 < i3) {
                    int i139 = i132;
                    int i140 = i138 * i108;
                    int i141 = i135 + i133 + i140;
                    int iM$12 = zzba$$ExternalSyntheticOutline0.m$1(i136, i133, i, i140);
                    int i142 = i137 + (i138 * i);
                    int i143 = i142 + i131;
                    int i144 = i142 + i139;
                    float f31 = fArr2[i143 - 1];
                    float f32 = fArr2[i143];
                    float f33 = fArr2[i144 - 1];
                    float f34 = fArr2[i144];
                    fArr[i141 - 1] = f31 + f33;
                    fArr[iM$12 - 1] = f31 - f33;
                    fArr[i141] = f32 + f34;
                    fArr[iM$12] = f34 - f32;
                    i138++;
                    i132 = i139;
                }
            }
        }
    }

    public void realForward(float[] fArr, int i) {
        if (this.useLargeArrays) {
            realForward(new FloatLargeArray(fArr), i);
            return;
        }
        if (this.n == 1) {
            return;
        }
        int i2 = AnonymousClass29.$SwitchMap$org$jtransforms$fft$FloatFFT_1D$Plans[this.plan.ordinal()];
        if (i2 == 1) {
            int i3 = this.n;
            if (i3 > 4) {
                CommonUtils.cftfsub(i3, fArr, i, this.ip, this.nw, this.w);
                CommonUtils.rftfsub(this.n, fArr, i, this.nc, this.w, this.nw);
            } else if (i3 == 4) {
                CommonUtils.cftx020(fArr, i);
            }
            float f = fArr[i];
            int i4 = i + 1;
            float f2 = fArr[i4];
            fArr[i] = f + f2;
            fArr[i4] = f - f2;
            return;
        }
        if (i2 != 2) {
            if (i2 != 3) {
                return;
            }
            bluestein_real_forward(fArr, i);
            return;
        }
        rfftf(fArr, i);
        for (int i5 = this.n - 1; i5 >= 2; i5--) {
            int i6 = i + i5;
            float f3 = fArr[i6];
            int i7 = i6 - 1;
            fArr[i6] = fArr[i7];
            fArr[i7] = f3;
        }
    }

    public void realForward(float[] fArr) {
        realForward(fArr, 0);
    }

    public void radf2(int i, int i2, float[] fArr, int i3, float[] fArr2, int i4, int i5) {
        int i6 = i2 * i;
        int i7 = i * 2;
        for (int i8 = 0; i8 < i2; i8++) {
            int i9 = (i8 * i7) + i4;
            int i10 = (i8 * i) + i3;
            int i11 = i10 + i6;
            float f = fArr[i10];
            float f2 = fArr[i11];
            fArr2[i9] = f + f2;
            fArr2[(i9 + i7) - 1] = f - f2;
        }
        int i12 = 2;
        if (i < 2) {
            return;
        }
        if (i != 2) {
            for (int i13 = 0; i13 < i2; i13++) {
                i7 = i13 * i;
                int i14 = i7 * 2;
                int i15 = i14 + i;
                int i16 = i7 + i6;
                int i17 = i12;
                while (i17 < i) {
                    int i18 = (i17 - 1) + i5;
                    int i19 = i4 + i17 + i14;
                    int i20 = i4 + (i - i17) + i15;
                    int i21 = i3 + i17;
                    int i22 = i21 + i7;
                    int i23 = i21 + i16;
                    float f3 = fArr[i22 - 1];
                    float f4 = fArr[i22];
                    float f5 = fArr[i23 - 1];
                    float f6 = fArr[i23];
                    int i24 = i12;
                    float[] fArr3 = this.wtable_r;
                    float f7 = fArr3[i18 - 1];
                    float f8 = fArr3[i18];
                    float f9 = (f8 * f6) + (f7 * f5);
                    float f10 = (f7 * f6) - (f8 * f5);
                    fArr2[i19] = f4 + f10;
                    fArr2[i19 - 1] = f3 + f9;
                    fArr2[i20] = f10 - f4;
                    fArr2[i20 - 1] = f3 - f9;
                    i17 += 2;
                    i12 = i24;
                }
            }
            if (i % 2 == 1) {
                return;
            }
        }
        int i25 = i7 * 2;
        for (int i26 = 0; i26 < i2; i26++) {
            int i27 = i4 + i25 + i;
            int iM$1 = zzba$$ExternalSyntheticOutline0.m$1(i3, i, 1, i26 * i);
            fArr2[i27] = -fArr[iM$1 + i6];
            fArr2[i27 - 1] = fArr[iM$1];
        }
    }

    public void rfftf(float[] fArr, int i) {
        int i2;
        int i3;
        float[] fArr2;
        FloatFFT_1D floatFFT_1D = this;
        int i4 = floatFFT_1D.n;
        if (i4 == 1) {
            return;
        }
        float[] fArr3 = new float[i4];
        int i5 = i4 * 2;
        int i6 = (int) floatFFT_1D.wtable_r[i5 + 1];
        int i7 = i5 - 1;
        int i8 = 1;
        int i9 = 1;
        while (i9 <= i6) {
            int i10 = (int) floatFFT_1D.wtable_r[(i6 - i9) + 2 + i5];
            int i11 = i8;
            int i12 = i4 / i10;
            int i13 = floatFFT_1D.n / i4;
            int i14 = i13 * i12;
            int i15 = i7 - ((i10 - 1) * i13);
            int i16 = 1 - i11;
            if (i10 == 2) {
                i2 = i12;
                i3 = i15;
                if (i16 == 0) {
                    floatFFT_1D = this;
                    floatFFT_1D.radf2(i13, i2, fArr, i, fArr3, 0, i3);
                    i8 = i16;
                } else {
                    floatFFT_1D = this;
                    fArr2 = fArr3;
                    floatFFT_1D.radf2(i13, i2, fArr2, 0, fArr, i, i3);
                    fArr3 = fArr2;
                    i8 = i16;
                }
            } else if (i10 == 3) {
                i2 = i12;
                i3 = i15;
                if (i16 == 0) {
                    floatFFT_1D = this;
                    floatFFT_1D.radf3(i13, i2, fArr, i, fArr3, 0, i3);
                    i8 = i16;
                } else {
                    floatFFT_1D = this;
                    fArr2 = fArr3;
                    floatFFT_1D.radf3(i13, i2, fArr2, 0, fArr, i, i3);
                    fArr3 = fArr2;
                    i8 = i16;
                }
            } else if (i10 == 4) {
                i2 = i12;
                i3 = i15;
                if (i16 == 0) {
                    floatFFT_1D = this;
                    floatFFT_1D.radf4(i13, i2, fArr, i, fArr3, 0, i3);
                    i8 = i16;
                } else {
                    floatFFT_1D = this;
                    fArr2 = fArr3;
                    floatFFT_1D.radf4(i13, i2, fArr2, 0, fArr, i, i3);
                    fArr3 = fArr2;
                    i8 = i16;
                }
            } else if (i10 != 5) {
                if (i13 == 1) {
                    i16 = 1 - i16;
                }
                if (i16 == 0) {
                    float[] fArr4 = fArr3;
                    floatFFT_1D.radfg(i13, i10, i12, i14, fArr, i, fArr4, 0, i15);
                    fArr3 = fArr4;
                    floatFFT_1D = this;
                    i2 = i12;
                    i3 = i15;
                    i8 = 1;
                } else {
                    floatFFT_1D = this;
                    floatFFT_1D.radfg(i13, i10, i12, i14, fArr3, 0, fArr, i, i15);
                    i2 = i12;
                    i3 = i15;
                    i8 = 0;
                }
            } else {
                i2 = i12;
                i3 = i15;
                if (i16 == 0) {
                    floatFFT_1D = this;
                    floatFFT_1D.radf5(i13, i2, fArr, i, fArr3, 0, i3);
                    i8 = i16;
                } else {
                    floatFFT_1D = this;
                    fArr2 = fArr3;
                    floatFFT_1D.radf5(i13, i2, fArr2, 0, fArr, i, i3);
                    fArr3 = fArr2;
                    i8 = i16;
                }
            }
            i9++;
            i4 = i2;
            i7 = i3;
        }
        if (i8 == 1) {
            return;
        }
        System.arraycopy(fArr3, 0, fArr, i, floatFFT_1D.n);
    }

    public void radf3(int i, int i2, float[] fArr, int i3, float[] fArr2, int i4, int i5) {
        float f;
        float f2;
        int i6 = i5 + i;
        int i7 = i2 * i;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            f = -0.5f;
            f2 = 0.8660254f;
            if (i9 >= i2) {
                break;
            }
            int i10 = i9 * i;
            int iM = zzba$$ExternalSyntheticOutline0.m(i9, 3, 1, i);
            int i11 = i3 + i10;
            int i12 = i11 + i7;
            int i13 = (i7 * 2) + i11;
            float f3 = fArr[i11];
            float f4 = fArr[i12];
            float f5 = fArr[i13];
            float f6 = f4 + f5;
            fArr2[(i10 * 3) + i4] = f3 + f6;
            fArr2[i4 + iM + i] = (f5 - f4) * 0.8660254f;
            fArr2[zzba$$ExternalSyntheticOutline0.m$1(i4, i, 1, iM)] = (f6 * (-0.5f)) + f3;
            i9++;
        }
        if (i == 1) {
            return;
        }
        while (i8 < i2) {
            int i14 = i8 * i;
            int i15 = i14 * 3;
            int i16 = i14 + i7;
            int i17 = i16 + i7;
            int i18 = i15 + i;
            int i19 = i18 + i;
            int i20 = 2;
            while (i20 < i) {
                int i21 = i20 - 1;
                int i22 = i21 + i5;
                int i23 = i21 + i6;
                float f7 = f;
                float f8 = f2;
                float[] fArr3 = this.wtable_r;
                float f9 = fArr3[i22 - 1];
                float f10 = fArr3[i22];
                float f11 = fArr3[i23 - 1];
                float f12 = fArr3[i23];
                int i24 = i3 + i20;
                int i25 = i4 + i20;
                int i26 = i24 + i14;
                int i27 = i24 + i16;
                int i28 = i24 + i17;
                float f13 = fArr[i26 - 1];
                float f14 = fArr[i26];
                float f15 = fArr[i27 - 1];
                float f16 = fArr[i27];
                float f17 = fArr[i28 - 1];
                float f18 = fArr[i28];
                float f19 = (f10 * f16) + (f9 * f15);
                float f20 = (f9 * f16) - (f10 * f15);
                float f21 = (f12 * f18) + (f11 * f17);
                float f22 = (f11 * f18) - (f12 * f17);
                float f23 = f19 + f21;
                float f24 = f20 + f22;
                float f25 = (f23 * f7) + f13;
                float f26 = (f24 * f7) + f14;
                float f27 = (f20 - f22) * f8;
                float f28 = (f21 - f19) * f8;
                int i29 = i25 + i15;
                int i30 = (i - i20) + i4 + i18;
                int i31 = i25 + i19;
                fArr2[i29 - 1] = f13 + f23;
                fArr2[i29] = f14 + f24;
                fArr2[i30 - 1] = f25 - f27;
                fArr2[i30] = f28 - f26;
                fArr2[i31 - 1] = f25 + f27;
                fArr2[i31] = f26 + f28;
                i20 += 2;
                f = f7;
                f2 = f8;
            }
            i8++;
            f = f;
        }
    }

    public void radf4(int i, int i2, float[] fArr, int i3, float[] fArr2, int i4, int i5) {
        int i6 = i5 + i;
        int i7 = i6 + i;
        int i8 = i2 * i;
        for (int i9 = 0; i9 < i2; i9++) {
            int i10 = i9 * i;
            int i11 = i10 * 4;
            int i12 = i10 + i8;
            int i13 = i12 + i8;
            int i14 = i13 + i8;
            float f = fArr[i3 + i10];
            float f2 = fArr[i3 + i12];
            float f3 = fArr[i3 + i13];
            float f4 = fArr[i3 + i14];
            float f5 = f2 + f4;
            float f6 = f + f3;
            int i15 = i4 + i11 + i + i;
            fArr2[i4 + i11] = f5 + f6;
            int i16 = i15 - 1;
            fArr2[i16 + i + i] = f6 - f5;
            fArr2[i16] = f - f3;
            fArr2[i15] = f4 - f2;
        }
        int i17 = 2;
        if (i < 2) {
            return;
        }
        if (i != 2) {
            int i18 = 0;
            while (i18 < i2) {
                int i19 = i18 * i;
                int i20 = i19 + i8;
                int i21 = i20 + i8;
                int i22 = i21 + i8;
                int i23 = i19 * 4;
                int i24 = i23 + i;
                int i25 = i24 + i;
                int i26 = i25 + i;
                for (int i27 = i17; i27 < i; i27 += 2) {
                    int i28 = i27 - 1;
                    int i29 = i28 + i5;
                    int i30 = i28 + i6;
                    int i31 = i28 + i7;
                    float[] fArr3 = this.wtable_r;
                    float f7 = fArr3[i29 - 1];
                    float f8 = fArr3[i29];
                    float f9 = fArr3[i30 - 1];
                    float f10 = fArr3[i30];
                    float f11 = fArr3[i31 - 1];
                    float f12 = fArr3[i31];
                    int i32 = i3 + i27;
                    int i33 = i4 + i27;
                    int i34 = i4 + (i - i27);
                    int i35 = i32 + i19;
                    int i36 = i32 + i20;
                    int i37 = i32 + i21;
                    int i38 = i32 + i22;
                    float f13 = fArr[i35 - 1];
                    float f14 = fArr[i35];
                    float f15 = fArr[i36 - 1];
                    float f16 = fArr[i36];
                    float f17 = fArr[i37 - 1];
                    float f18 = fArr[i37];
                    float f19 = fArr[i38 - 1];
                    float f20 = fArr[i38];
                    float f21 = (f8 * f16) + (f7 * f15);
                    float f22 = (f7 * f16) - (f8 * f15);
                    float f23 = (f10 * f18) + (f9 * f17);
                    float f24 = (f9 * f18) - (f10 * f17);
                    float f25 = (f12 * f20) + (f11 * f19);
                    float f26 = (f11 * f20) - (f12 * f19);
                    float f27 = f21 + f25;
                    float f28 = f25 - f21;
                    float f29 = f22 + f26;
                    float f30 = f22 - f26;
                    float f31 = f14 + f24;
                    float f32 = f14 - f24;
                    float f33 = f13 + f23;
                    float f34 = f13 - f23;
                    int i39 = i33 + i23;
                    int i40 = i34 + i24;
                    int i41 = i33 + i25;
                    int i42 = i34 + i26;
                    fArr2[i39 - 1] = f27 + f33;
                    fArr2[i42 - 1] = f33 - f27;
                    fArr2[i39] = f29 + f31;
                    fArr2[i42] = f29 - f31;
                    fArr2[i41 - 1] = f30 + f34;
                    fArr2[i40 - 1] = f34 - f30;
                    fArr2[i41] = f28 + f32;
                    fArr2[i40] = f28 - f32;
                }
                i18++;
                i17 = 2;
            }
            if (i % 2 == 1) {
                return;
            }
        }
        for (int i43 = 0; i43 < i2; i43++) {
            int i44 = i43 * i;
            int i45 = i44 * 4;
            int i46 = i44 + i8;
            int i47 = i46 + i8;
            int i48 = i47 + i8;
            int i49 = i45 + i;
            int i50 = i49 + i;
            int i51 = (i3 + i) - 1;
            float f35 = fArr[i44 + i51];
            float f36 = fArr[i46 + i51];
            float f37 = fArr[i47 + i51];
            float f38 = fArr[i51 + i48];
            float f39 = (f36 + f38) * (-0.70710677f);
            float f40 = (f36 - f38) * 0.70710677f;
            int i52 = (i4 + i) - 1;
            fArr2[i45 + i52] = f40 + f35;
            fArr2[i52 + i50] = f35 - f40;
            fArr2[i4 + i49] = f39 - f37;
            fArr2[i4 + i50 + i] = f39 + f37;
        }
    }

    public void radf5(int i, int i2, float[] fArr, int i3, float[] fArr2, int i4, int i5) {
        float f;
        float f2;
        float f3;
        int i6 = i5 + i;
        int i7 = i6 + i;
        int i8 = i7 + i;
        int i9 = i2 * i;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            f = 0.58778524f;
            f2 = 0.95105654f;
            f3 = -0.809017f;
            if (i11 >= i2) {
                break;
            }
            int i12 = i11 * i;
            int i13 = i12 * 5;
            int i14 = i13 + i;
            int i15 = i14 + i;
            int i16 = i15 + i;
            int i17 = i12 + i9;
            int i18 = i17 + i9;
            int i19 = i18 + i9;
            int i20 = (i4 + i) - 1;
            float f4 = fArr[i3 + i12];
            float f5 = fArr[i3 + i17];
            float f6 = fArr[i3 + i18];
            float f7 = fArr[i3 + i19];
            float f8 = fArr[i3 + i19 + i9];
            float f9 = f8 + f5;
            float f10 = f8 - f5;
            float f11 = f7 + f6;
            float f12 = f7 - f6;
            fArr2[i4 + i13] = f4 + f9 + f11;
            fArr2[i20 + i14] = (f11 * (-0.809017f)) + (f9 * 0.309017f) + f4;
            fArr2[i4 + i15] = (f12 * 0.58778524f) + (f10 * 0.95105654f);
            fArr2[i20 + i16] = (f11 * 0.309017f) + (f9 * (-0.809017f)) + f4;
            fArr2[i4 + i16 + i] = (f10 * 0.58778524f) - (f12 * 0.95105654f);
            i11++;
        }
        if (i == 1) {
            return;
        }
        while (i10 < i2) {
            int i21 = i10 * i;
            int i22 = i21 * 5;
            int i23 = i22 + i;
            int i24 = i23 + i;
            int i25 = i24 + i;
            int i26 = i25 + i;
            int i27 = i21 + i9;
            int i28 = i27 + i9;
            int i29 = i28 + i9;
            int i30 = i29 + i9;
            float f13 = f;
            int i31 = 2;
            while (i31 < i) {
                int i32 = i31 - 1;
                int i33 = i32 + i5;
                int i34 = i32 + i6;
                int i35 = i32 + i7;
                int i36 = i32 + i8;
                float f14 = f2;
                float f15 = f3;
                float[] fArr3 = this.wtable_r;
                float f16 = fArr3[i33 - 1];
                float f17 = fArr3[i33];
                float f18 = fArr3[i34 - 1];
                float f19 = fArr3[i34];
                float f20 = fArr3[i35 - 1];
                float f21 = fArr3[i35];
                float f22 = fArr3[i36 - 1];
                float f23 = fArr3[i36];
                int i37 = i3 + i31;
                int i38 = i4 + i31;
                int i39 = i4 + (i - i31);
                int i40 = i37 + i21;
                int i41 = i37 + i27;
                int i42 = i37 + i28;
                int i43 = i37 + i29;
                int i44 = i37 + i30;
                float f24 = fArr[i40 - 1];
                float f25 = fArr[i40];
                float f26 = fArr[i41 - 1];
                float f27 = fArr[i41];
                float f28 = fArr[i42 - 1];
                float f29 = fArr[i42];
                float f30 = fArr[i43 - 1];
                float f31 = fArr[i43];
                float f32 = fArr[i44 - 1];
                float f33 = fArr[i44];
                float f34 = (f17 * f27) + (f16 * f26);
                float f35 = (f16 * f27) - (f17 * f26);
                float f36 = (f19 * f29) + (f18 * f28);
                float f37 = (f18 * f29) - (f19 * f28);
                float f38 = (f21 * f31) + (f20 * f30);
                float f39 = (f20 * f31) - (f21 * f30);
                float f40 = (f23 * f33) + (f22 * f32);
                float f41 = (f22 * f33) - (f23 * f32);
                float f42 = f34 + f40;
                float f43 = f40 - f34;
                float f44 = f35 - f41;
                float f45 = f35 + f41;
                float f46 = f36 + f38;
                float f47 = f38 - f36;
                float f48 = f37 - f39;
                float f49 = f37 + f39;
                float f50 = (f46 * f15) + (f42 * 0.309017f) + f24;
                float f51 = (f49 * f15) + (f45 * 0.309017f) + f25;
                float f52 = (f46 * 0.309017f) + (f42 * f15) + f24;
                float f53 = (f49 * 0.309017f) + (f45 * f15) + f25;
                float f54 = (f48 * f13) + (f44 * f14);
                float f55 = (f47 * f13) + (f43 * f14);
                float f56 = (f44 * f13) - (f48 * f14);
                float f57 = (f43 * f13) - (f47 * f14);
                int i45 = i38 + i22;
                int i46 = i39 + i23;
                int i47 = i38 + i24;
                int i48 = i39 + i25;
                int i49 = i38 + i26;
                fArr2[i45 - 1] = f24 + f42 + f46;
                fArr2[i45] = f25 + f45 + f49;
                fArr2[i47 - 1] = f50 + f54;
                fArr2[i46 - 1] = f50 - f54;
                fArr2[i47] = f51 + f55;
                fArr2[i46] = f55 - f51;
                fArr2[i49 - 1] = f52 + f56;
                fArr2[i48 - 1] = f52 - f56;
                fArr2[i49] = f53 + f57;
                fArr2[i48] = f57 - f53;
                i31 += 2;
                f2 = f14;
                f3 = f15;
            }
            i10++;
            f = f13;
            f2 = f2;
        }
    }

    private void bluestein_real_forward(final float[] fArr, final int i) {
        FloatFFT_1D floatFFT_1D;
        final float[] fArr2 = new float[this.nBluestein * 2];
        int numberOfThreads = ConcurrencyUtils.getNumberOfThreads();
        if (numberOfThreads > 1 && this.n >= CommonUtils.getThreadsBeginN_1D_FFT_2Threads()) {
            int i2 = (numberOfThreads < 4 || ((long) this.n) < CommonUtils.getThreadsBeginN_1D_FFT_4Threads()) ? 2 : 4;
            Future[] futureArr = new Future[i2];
            int i3 = this.n / i2;
            int i4 = 0;
            while (i4 < i2) {
                final float[] fArr3 = fArr2;
                final int i5 = i4 * i3;
                final int i6 = i4 == i2 + (-1) ? this.n : i5 + i3;
                Runnable runnable = new Runnable() { // from class: org.jtransforms.fft.FloatFFT_1D.17
                    @Override // java.lang.Runnable
                    public void run() {
                        for (int i7 = i5; i7 < i6; i7++) {
                            int i8 = i7 * 2;
                            int i9 = i8 + 1;
                            int i10 = i + i7;
                            fArr3[i8] = fArr[i10] * FloatFFT_1D.this.bk1[i8];
                            fArr3[i9] = (-fArr[i10]) * FloatFFT_1D.this.bk1[i9];
                        }
                    }
                };
                fArr2 = fArr3;
                futureArr[i4] = ConcurrencyUtils.submit(runnable);
                i4++;
            }
            floatFFT_1D = this;
            try {
                ConcurrencyUtils.waitForCompletion(futureArr);
            } catch (InterruptedException e) {
                Logger.getLogger(FloatFFT_1D.class.getName()).log(Level.SEVERE, (String) null, (Throwable) e);
            } catch (ExecutionException e2) {
                Logger.getLogger(FloatFFT_1D.class.getName()).log(Level.SEVERE, (String) null, (Throwable) e2);
            }
            CommonUtils.cftbsub(floatFFT_1D.nBluestein * 2, fArr2, 0, floatFFT_1D.ip, floatFFT_1D.nw, floatFFT_1D.w);
            int i7 = floatFFT_1D.nBluestein / i2;
            int i8 = 0;
            while (i8 < i2) {
                final int i9 = i8 * i7;
                final int i10 = i8 == i2 + (-1) ? floatFFT_1D.nBluestein : i9 + i7;
                futureArr[i8] = ConcurrencyUtils.submit(new Runnable() { // from class: org.jtransforms.fft.FloatFFT_1D.18
                    @Override // java.lang.Runnable
                    public void run() {
                        for (int i11 = i9; i11 < i10; i11++) {
                            int i12 = i11 * 2;
                            int i13 = i12 + 1;
                            float f = (fArr2[i13] * FloatFFT_1D.this.bk2[i12]) + (fArr2[i12] * FloatFFT_1D.this.bk2[i13]);
                            float[] fArr4 = fArr2;
                            fArr4[i12] = (fArr4[i12] * FloatFFT_1D.this.bk2[i12]) - (fArr2[i13] * FloatFFT_1D.this.bk2[i13]);
                            fArr2[i13] = f;
                        }
                    }
                });
                i8++;
            }
            try {
                ConcurrencyUtils.waitForCompletion(futureArr);
            } catch (InterruptedException e3) {
                Logger.getLogger(FloatFFT_1D.class.getName()).log(Level.SEVERE, (String) null, (Throwable) e3);
            } catch (ExecutionException e4) {
                Logger.getLogger(FloatFFT_1D.class.getName()).log(Level.SEVERE, (String) null, (Throwable) e4);
            }
        } else {
            floatFFT_1D = this;
            for (int i11 = 0; i11 < floatFFT_1D.n; i11++) {
                int i12 = i11 * 2;
                int i13 = i12 + 1;
                int i14 = i + i11;
                float f = fArr[i14];
                float[] fArr4 = floatFFT_1D.bk1;
                fArr2[i12] = f * fArr4[i12];
                fArr2[i13] = (-fArr[i14]) * fArr4[i13];
            }
            CommonUtils.cftbsub(floatFFT_1D.nBluestein * 2, fArr2, 0, floatFFT_1D.ip, floatFFT_1D.nw, floatFFT_1D.w);
            for (int i15 = 0; i15 < floatFFT_1D.nBluestein; i15++) {
                int i16 = i15 * 2;
                int i17 = i16 + 1;
                float f2 = fArr2[i16];
                float[] fArr5 = floatFFT_1D.bk2;
                float f3 = fArr5[i17];
                float f4 = fArr2[i17];
                float f5 = fArr5[i16];
                fArr2[i16] = (f2 * f5) - (f4 * f3);
                fArr2[i17] = (f4 * f5) + (f2 * f3);
            }
        }
        CommonUtils.cftfsub(floatFFT_1D.nBluestein * 2, fArr2, 0, floatFFT_1D.ip, floatFFT_1D.nw, floatFFT_1D.w);
        int i18 = floatFFT_1D.n;
        int i19 = i18 % 2;
        float[] fArr6 = floatFFT_1D.bk1;
        if (i19 == 0) {
            fArr[i] = (fArr6[1] * fArr2[1]) + (fArr6[0] * fArr2[0]);
            fArr[i + 1] = (fArr6[i18 + 1] * fArr2[i18 + 1]) + (fArr6[i18] * fArr2[i18]);
            for (int i20 = 1; i20 < floatFFT_1D.n / 2; i20++) {
                int i21 = i20 * 2;
                int i22 = i21 + 1;
                float[] fArr7 = floatFFT_1D.bk1;
                fArr[i + i21] = (fArr7[i22] * fArr2[i22]) + (fArr7[i21] * fArr2[i21]);
                fArr[i + i22] = (fArr7[i21] * fArr2[i22]) + ((-fArr7[i22]) * fArr2[i21]);
            }
            return;
        }
        fArr[i] = (fArr6[1] * fArr2[1]) + (fArr6[0] * fArr2[0]);
        fArr[i + 1] = (fArr6[i18 - 1] * fArr2[i18]) + ((-fArr6[i18]) * fArr2[i18 - 1]);
        int i23 = 1;
        while (true) {
            int i24 = floatFFT_1D.n;
            int i25 = (i24 - 1) / 2;
            float[] fArr8 = floatFFT_1D.bk1;
            if (i23 >= i25) {
                fArr[(i + i24) - 1] = (fArr8[i24] * fArr2[i24]) + (fArr8[i24 - 1] * fArr2[i24 - 1]);
                return;
            }
            int i26 = i23 * 2;
            int i27 = i26 + 1;
            fArr[i + i26] = (fArr8[i27] * fArr2[i27]) + (fArr8[i26] * fArr2[i26]);
            fArr[i + i27] = (fArr8[i26] * fArr2[i27]) + ((-fArr8[i27]) * fArr2[i26]);
            i23++;
        }
    }
}
