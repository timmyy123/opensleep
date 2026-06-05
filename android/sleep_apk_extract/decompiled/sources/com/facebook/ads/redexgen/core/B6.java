package com.facebook.ads.redexgen.core;

import android.media.MediaCodec;
import android.os.SystemClock;
import android.util.Log;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class B6 {
    public static byte[] A03;
    public boolean A00 = false;
    public final ConcurrentLinkedQueue<B4> A01 = new ConcurrentLinkedQueue<>();
    public final /* synthetic */ B7 A02;

    static {
        A05();
    }

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 52);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A03 = new byte[]{-89, -38, -59, -57, -46, -42, -53, -47, -48, -126, -39, -54, -57, -48, -126, -42, -44, -37, -53, -48, -55, -126, -42, -47, -126, -53, -48, -43, -42, -61, -48, -42, -53, -61, -42, -57, -126, -121, -43, -100, -126, -121, -43, -72, -48, -49, -44, -52, -82, -38, -49, -48, -50, -69, -38, -38, -41, -70, -37, -33, -44, -40, -44, -27, -48, -49, -59, -46, -46, -49, -46, -115, -41, -56, -55, -52, -59, -115, -46, -59, -52, -59, -63, -45, -59, -115, -61, -49, -60, -59, -61, -115, -58, -46, -49, -51, -115, -45, -59, -44, -115, -58, -55, -50, -63, -52, -52, -39, -102, -128, -123, -45, -40, -27, -27, -30, -27, -96, -22, -37, -36, -33, -40, -96, -27, -40, -33, -40, -44, -26, -40, -96, -42, -30, -41, -40, -42, -96, -39, -27, -30, -32, -96, -26, -40, -25, -83, -109, -104, -26, -34, -15, -24, -23, -27, -38, -14, -34, -21, -85, -89, -38, -17, -86, -89, -20, -21, -36, -89, -67, -38, -17, -86, -35, -58, -34, -35, -30, -38, -68, -24, -35, -34, -36, -70, -35, -38, -23, -19, -34, -21};
    }

    public B6(B7 b7) {
        this.A02 = b7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public B0 A02(boolean z, C1577jQ c1577jQ, EnumC1574jL enumC1574jL, String str) throws Exception {
        Set<B0> set;
        if (this.A02.A0I(z, c1577jQ) && B7.A0G(str, c1577jQ)) {
            synchronized (this.A02.A04) {
                set = this.A02.A04.get(str);
            }
            if (set != null) {
                synchronized (set) {
                    if (!set.isEmpty()) {
                        B7 b7 = this.A02;
                        b7.A00--;
                        Iterator<B0> it = set.iterator();
                        B0 ret = it.next();
                        it.remove();
                        this.A02.A03().A0A(z, str, enumC1574jL, ret.hashCode());
                        return ret;
                    }
                }
            }
        }
        try {
            C1572jJ c1572jJA05 = this.A02.A03().A05(z, str, enumC1574jL);
            B0 b0A03 = A03(z, str);
            this.A02.A03().A06(c1572jJA05, b0A03.hashCode());
            return b0A03;
        } catch (Exception e) {
            throw new MediaCodecInitializationException(str, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public B0 A03(boolean z, String str) throws Exception {
        String strA04 = A04(150, 41, 69);
        if (z && B7.A0E(str)) {
            try {
                return (B0) Class.forName(strA04).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e) {
                Log.w(A04(43, 23, 55), String.format(A04(0, 43, 46), strA04, e.getMessage()));
            }
        }
        return new C1846o6(MediaCodec.createByCodecName(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: A07, reason: merged with bridge method [inline-methods] */
    public void A0B(EnumC1574jL enumC1574jL) {
        String strA04;
        String str;
        B7 b7;
        Set<B0> set;
        for (B4 b4 : this.A01) {
            try {
                try {
                    if (!b4.A05) {
                        A08(b4.A01, enumC1574jL, Boolean.valueOf(b4.A04), b4.A00);
                    } else {
                        try {
                            try {
                                this.A02.A05 = SystemClock.elapsedRealtime();
                                b4.A00.reset();
                                b7 = this.A02;
                            } catch (Throwable th) {
                                this.A02.A05 = -1L;
                                throw th;
                            }
                        } catch (IllegalStateException unused) {
                            A09(b4.A02, b4.A00);
                            b7 = this.A02;
                        }
                        b7.A05 = -1L;
                        if (b4.A03) {
                            synchronized (this.A02.A04) {
                                set = this.A02.A04.get(b4.A02);
                            }
                            if (set != null) {
                                synchronized (set) {
                                    set.add(b4.A00);
                                    this.A02.A00++;
                                }
                            }
                        }
                    }
                    try {
                        synchronized (this.A01) {
                            this.A01.remove(b4);
                        }
                    } catch (Exception e) {
                        strA04 = A04(43, 23, 55);
                        str = String.format(A04(66, 46, 44), e.getMessage());
                        Log.w(strA04, str);
                    }
                } catch (Exception e2) {
                    Log.w(A04(43, 23, 55), String.format(A04(112, 38, 63), e2.getMessage()));
                    try {
                        synchronized (this.A01) {
                            this.A01.remove(b4);
                        }
                    } catch (Exception e3) {
                        strA04 = A04(43, 23, 55);
                        str = String.format(A04(66, 46, 44), e3.getMessage());
                        Log.w(strA04, str);
                    }
                }
            } catch (Throwable th2) {
                try {
                } catch (Exception e4) {
                    Log.w(A04(43, 23, 55), String.format(A04(66, 46, 44), e4.getMessage()));
                }
                synchronized (this.A01) {
                    this.A01.remove(b4);
                    throw th2;
                }
            }
        }
    }

    private void A08(C1577jQ c1577jQ, EnumC1574jL enumC1574jL, Boolean bool, B0 b0) {
        try {
            if (!c1577jQ.A0R || (!bool.booleanValue() && !c1577jQ.A0Q)) {
                b0.stop();
            }
        } finally {
            this.A02.A03().A08(enumC1574jL, b0.hashCode());
            b0.AHb();
            this.A02.A03().A07(enumC1574jL, b0.hashCode());
        }
    }

    private void A09(String str, B0 b0) {
        Set<B0> set;
        synchronized (this.A02.A04) {
            set = this.A02.A04.get(str);
        }
        if (set != null) {
            synchronized (set) {
                if (set.remove(b0)) {
                    B7 b7 = this.A02;
                    b7.A00--;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void A0A(boolean z, C1577jQ c1577jQ, final EnumC1574jL enumC1574jL, String str, B0 b0) throws Throwable {
        boolean z2 = false;
        if (this.A02.A0I(z, c1577jQ) && B7.A0G(str, c1577jQ)) {
            if (c1577jQ.A0L && !this.A00) {
                this.A00 = true;
                Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(new Runnable() { // from class: com.facebook.ads.redexgen.X.B5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.A00.A0B(enumC1574jL);
                    }
                }, 5L, Math.max(1000, c1577jQ.A08), TimeUnit.MILLISECONDS);
            }
            boolean z3 = true;
            Set<B0> setA06 = null;
            if (this.A02.A00 < c1577jQ.A07) {
                synchronized (this.A02.A04) {
                    setA06 = this.A02.A04.get(str);
                    if (setA06 == null) {
                        setA06 = this.A02.A06();
                        this.A02.A04.put(str, setA06);
                    }
                }
                synchronized (setA06) {
                    if (setA06.contains(b0)) {
                        z3 = false;
                    } else if (((z && c1577jQ.A0N) || (!z && c1577jQ.A0M)) && setA06.size() < c1577jQ.A06) {
                        z2 = true;
                        z3 = false;
                    }
                }
            }
            if (!z3) {
                long j = -1;
                try {
                    try {
                        try {
                            if (!c1577jQ.A0L) {
                                try {
                                    this.A02.A05 = SystemClock.elapsedRealtime();
                                    b0.reset();
                                    if (z2 && setA06 != null) {
                                        synchronized (setA06) {
                                            setA06.add(b0);
                                            this.A02.A00++;
                                        }
                                    }
                                    if (!c1577jQ.A0L) {
                                        return;
                                    }
                                    this.A02.A05 = -1L;
                                    return;
                                } catch (Throwable th) {
                                    th = th;
                                }
                            } else {
                                try {
                                    B4 b4 = new B4(b0, c1577jQ, str, z, z2, true);
                                    synchronized (this.A01) {
                                        try {
                                            this.A01.add(b4);
                                        } catch (Throwable th2) {
                                            th = th2;
                                            while (true) {
                                                try {
                                                    throw th;
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                }
                                            }
                                        }
                                    }
                                    if (!c1577jQ.A0L) {
                                    }
                                } catch (IllegalStateException unused) {
                                    j = -1;
                                    A09(str, b0);
                                    if (!c1577jQ.A0L) {
                                        this.A02.A05 = j;
                                    }
                                    if (c1577jQ.A0L) {
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    j = -1;
                                }
                            }
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    } catch (IllegalStateException unused2) {
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
                if (!c1577jQ.A0L) {
                    this.A02.A05 = j;
                }
                throw th;
            }
        }
        if (c1577jQ.A0L) {
            A08(c1577jQ, enumC1574jL, Boolean.valueOf(z), b0);
            return;
        }
        B4 b42 = new B4(b0, c1577jQ, str, z, false, false);
        synchronized (this.A01) {
            this.A01.add(b42);
        }
    }
}
