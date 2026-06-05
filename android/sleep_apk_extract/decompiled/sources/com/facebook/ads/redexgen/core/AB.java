package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import com.facebook.ads.androidx.media3.common.Timeline;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomizations;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class AB implements Handler.Callback, InterfaceC1831nq, InterfaceC0469Ev, InterfaceC0418Cw, C6P, InterfaceC02867b {
    public static byte[] A0x;
    public static String[] A0y = {"EvYOBb0fNCsu7OcAaOZNwoEPwn2", "8jIqnMhTOhQ3fU", "vmW", "edZR1F4oYcKYyzs7tUfX3dHGMGqqrKBY", "TI8UsWNSVk9Jh7srInWeHwVEqkc209d4", "AVB8fiMNMM9Dy8Zuh880FwllBoFt5PF1", "1mkHXRje2n0Pvvw2j", "LF2w13BN71krhrKRtprOb2x3jYcy1FYO"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public long A04;
    public long A06;
    public C02686j A07;
    public C02726n A08;
    public C7Z A0A;

    @MetaExoPlayerCustomization("D18870411: Adding start stall debug reason")
    public InterfaceC1890oo A0B;
    public C03057u A0C;
    public InterfaceC0419Cx A0D;
    public boolean A0G;
    public boolean A0H;
    public boolean A0I;
    public boolean A0K;
    public boolean A0M;
    public boolean A0N;
    public boolean A0O;
    public boolean A0P;
    public boolean A0Q;
    public boolean A0R;
    public boolean A0S;
    public boolean A0T;
    public boolean A0U;
    public boolean A0V;
    public InterfaceC1890oo[] A0W;
    public final long A0Y;
    public final long A0Z;
    public final Handler A0a;
    public final HandlerThread A0b;
    public final C1948pl A0c;
    public final C1946pj A0d;
    public final AnonymousClass45 A0e;
    public final C4X A0f;
    public final C1898ow A0g;
    public final C02716m A0h;
    public final AnonymousClass74 A0i;
    public final C1886ok A0k;
    public final AbstractC0470Ew A0l;
    public final C0471Ex A0m;
    public final F6 A0n;
    public final C03379g A0o;
    public final ArrayList<C02706l> A0p;
    public final boolean A0q;
    public final boolean A0r;
    public final boolean A0s;
    public final boolean A0t;
    public final boolean A0u;
    public final InterfaceC1890oo[] A0v;
    public final InterfaceC03007p[] A0w;
    public long A05 = -9223372036854775807L;

    @MetaExoPlayerCustomization("D18870411: Adding start stall debug reason")
    public EnumC1547ir A0E = EnumC1547ir.A09;

    @MetaExoPlayerCustomization("D63737392: Added for negative testing")
    public boolean A0J = false;

    @MetaExoPlayerCustomization("D63737392: Added for negative testing")
    public C7W A09 = null;

    @MetaExoPlayerCustomization("D63737392: Added for negative testing")
    public boolean A0L = false;

    @MetaExoPlayerCustomization("D71523094: Added for negative testing")
    public Integer A0F = null;
    public final C7E A0j = new C7E();

    @MetaExoPlayerCustomization
    public final int A0X = A00();

    public static String A0D(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0x, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            byte b = bArrCopyOfRange[i4];
            if (A0y[1].length() == 31) {
                throw new RuntimeException();
            }
            String[] strArr = A0y;
            strArr[2] = "wOV";
            strArr[6] = "lGv9KfQpa0xBFnWlu";
            bArrCopyOfRange[i4] = (byte) ((b - i3) - 57);
        }
        return new String(bArrCopyOfRange);
    }

    /* JADX WARN: Code restructure failed: missing block: B:186:0x03ab, code lost:
    
        r24.A0R = r24.A0P;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x03bb, code lost:
    
        if (com.facebook.ads.redexgen.core.AB.A0y[5].charAt(1) == 'q') goto L220;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x03bd, code lost:
    
        r2 = com.facebook.ads.redexgen.core.AB.A0y;
        r2[4] = "Uyz0TdICBPSSMiRUHh3H6S4m2yqjGOAg";
        r2[3] = "3B1Lhsj2yRloVQBWBzqqqLZ9kauiXzuH";
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x03cb, code lost:
    
        if (r24.A0B == null) goto L193;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x03d4, code lost:
    
        if (r24.A0B.A9N() != 1) goto L193;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x03d6, code lost:
    
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x03d7, code lost:
    
        A0W(2, r8);
        A0O();
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x043f, code lost:
    
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x044b, code lost:
    
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 25 out of bounds for length 25
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    /* JADX WARN: Removed duplicated region for block: B:123:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01fa  */
    @MetaExoPlayerCustomization("D18870411: Adding start stall debug reason")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A0F() throws AD, IOException {
        String[] strArr;
        boolean z;
        long jAKe = this.A0e.AKe();
        A0P();
        if (!this.A0j.A0N()) {
            A0I();
            A0a(jAKe, 10L);
            return;
        }
        C7A c7aA0F = this.A0j.A0F();
        C7A c7aA0G = this.A0j.A0G();
        AnonymousClass54.A02(A0D(353, 10, 65));
        A0Q();
        long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        c7aA0F.A07.A60(this.A0A.A0C - this.A0Y, this.A0r);
        boolean z2 = false;
        boolean zAAP = true;
        boolean z3 = true;
        boolean z4 = this.A0W.length > 1;
        InterfaceC1890oo[] interfaceC1890ooArr = this.A0W;
        int length = interfaceC1890ooArr.length;
        int i = 0;
        while (true) {
            String strA0D = A0D(223, 35, 31);
            String strA0D2 = A0D(0, 21, 22);
            if (i < length) {
                InterfaceC1890oo interfaceC1890oo = interfaceC1890ooArr[i];
                interfaceC1890oo.AIX(this.A06, jElapsedRealtime);
                if (c7aA0G.A00.A05) {
                    boolean z5 = this.A0O;
                    if (A0y[0].length() == 16) {
                        break;
                    }
                    String[] strArr2 = A0y;
                    strArr2[4] = "S4Fyq0ZfVTRLxRTM4wwKz81RK4qT5SRq";
                    strArr2[3] = "dt9NVxX1YAgTPnpY37Axx0Ou68rzEGgN";
                    if (z5) {
                        if (!interfaceC1890oo.A9p()) {
                            boolean z6 = this.A0H;
                            if (A0y[0].length() != 16) {
                                A0y[5] = "eiShONRNAduVJjGMnbACFBBBapCf3AHm";
                                if (!z6) {
                                    if (this.A0A.A0C != -1) {
                                        long jA01 = C2Y.A01(this.A0A.A0C - this.A0A.A02);
                                        if (A0y[7].charAt(12) == '2') {
                                            throw new RuntimeException();
                                        }
                                        A0y[5] = "BlhxJ9uFvDlxNeph5MIqggmIWIv4QApO";
                                        if (jA01 > 1000) {
                                            interfaceC1890oo.AJN();
                                        }
                                    }
                                }
                            } else {
                                String[] strArr3 = A0y;
                                strArr3[4] = "JgPz5rm3gJhJD0DUOH89UMmPp4ssm19B";
                                strArr3[3] = "EHDY1dQAFQsMAYBzgGAEpHtmXIGNI89a";
                                if (!z6) {
                                }
                            }
                        }
                    } else if (A0y[5].charAt(1) != 'q') {
                        String[] strArr4 = A0y;
                        strArr4[4] = "usLdHWXdVdc1eYm8Xo8iItMQczfdPoTF";
                        strArr4[3] = "jdYe6RXL6unoORbHA5yicze0YAqR3j0n";
                        if (this.A0H) {
                            boolean zA9p = interfaceC1890oo.A9p();
                            if (A0y[7].charAt(12) == '2') {
                                throw new RuntimeException();
                            }
                            A0y[5] = "gun24np1Fz9ULZxkMCl3omnFVmny067U";
                            if (zA9p) {
                                interfaceC1890oo.AJN();
                            }
                        }
                    } else if (this.A0H) {
                    }
                    if (!(interfaceC1890oo instanceof C01341b)) {
                        z4 = z4 && interfaceC1890oo.AAP();
                    }
                    zAAP = !zAAP && interfaceC1890oo.AAP();
                    z = !interfaceC1890oo.AAe() || interfaceC1890oo.AAP() || A17(interfaceC1890oo);
                    if (!z) {
                        z2 = true;
                        try {
                            interfaceC1890oo.ACU();
                        } catch (C1907p5 e) {
                            if (!e.getClass().equals(C1907p5.class)) {
                                throw e;
                            }
                            if (!this.A0N) {
                                throw e;
                            }
                            if (this.A05 == -9223372036854775807L) {
                                Log.w(strA0D2, strA0D + e.getMessage());
                                this.A05 = System.currentTimeMillis();
                                if (this.A0q) {
                                    this.A0a.obtainMessage(4, e).sendToTarget();
                                }
                            } else if (System.currentTimeMillis() - this.A05 > this.A0Z) {
                                throw e;
                            }
                        }
                        this.A0B = interfaceC1890oo;
                        if (A0y[7].charAt(12) == '2') {
                            break;
                        } else {
                            A0y[5] = "qlbqZn2WmIl9Oup3QtCZToOsAISM7SD4";
                        }
                    }
                    z3 = !z3 && z;
                    i++;
                } else {
                    if (!(interfaceC1890oo instanceof C01341b)) {
                    }
                    if (zAAP) {
                        if (interfaceC1890oo.AAe()) {
                            if (!z) {
                            }
                            if (z3) {
                            }
                            i++;
                        }
                    }
                }
            } else {
                if (!z3) {
                    A0I();
                }
                if (this.A0Q && z4 && !zAAP) {
                    for (InterfaceC1890oo interfaceC1890oo2 : this.A0W) {
                        if (interfaceC1890oo2 instanceof C01341b) {
                            interfaceC1890oo2.AIX(9223372036854775806L, 9223372036854775806L);
                            zAAP = interfaceC1890oo2.AAP();
                        }
                    }
                }
                long j = c7aA0F.A00.A00;
                boolean z7 = false;
                if (!zAAP || (j != -9223372036854775807L && j > this.A0A.A0C)) {
                    if (this.A0A.A00 == 2 && A19(z3)) {
                        if (this.A0J && !this.A0L) {
                            this.A0L = true;
                            this.A0F = A0B();
                            if (this.A0F != null && this.A0F.intValue() > 0) {
                                A0a(jAKe, this.A0F.intValue());
                                return;
                            }
                        }
                        if (this.A0B != null) {
                            int iA9N = this.A0B.A9N();
                            if (A0y[5].charAt(1) != 'q') {
                                A0y[1] = "FUTTGuZgInj0HgAB4TKGqFNOnZ8TLHiw";
                                if (iA9N == 1) {
                                    z7 = true;
                                }
                            } else if (iA9N == 1) {
                            }
                        }
                        A0t(this.A0E, z7);
                        if (this.A0P) {
                            A0N();
                        }
                        this.A0B = null;
                    } else if (this.A0A.A00 == 3) {
                        if (this.A0W.length == 0) {
                        }
                    }
                    if (this.A0A.A00 == 2) {
                        for (InterfaceC1890oo interfaceC1890oo3 : this.A0W) {
                            z2 = true;
                            try {
                                interfaceC1890oo3.ACU();
                            } catch (C1907p5 e2) {
                                if (!e2.getClass().equals(C1907p5.class)) {
                                    throw e2;
                                }
                                boolean z8 = this.A0N;
                                if (A0y[1].length() != 31) {
                                    A0y[0] = "ROTBjRrt9pmtd4l9PrsJpq4cigEOLmNk";
                                    if (!z8) {
                                        throw e2;
                                    }
                                    if (this.A05 != -9223372036854775807L) {
                                        Log.w(strA0D2, strA0D + e2.getMessage());
                                        this.A05 = System.currentTimeMillis();
                                        if (this.A0q) {
                                            this.A0a.obtainMessage(4, e2).sendToTarget();
                                        }
                                    } else {
                                        long jCurrentTimeMillis = System.currentTimeMillis() - this.A05;
                                        long j2 = this.A0Z;
                                        if (A0y[5].charAt(1) != 'q') {
                                            A0y[1] = "nYRcp";
                                            if (jCurrentTimeMillis > j2) {
                                                throw e2;
                                            }
                                        } else {
                                            A0y[0] = "0hUy";
                                            if (jCurrentTimeMillis > j2) {
                                                throw e2;
                                            }
                                        }
                                    }
                                } else {
                                    if (!z8) {
                                        throw e2;
                                    }
                                    if (this.A05 != -9223372036854775807L) {
                                    }
                                }
                            }
                        }
                    }
                    boolean z9 = this.A0P;
                    strArr = A0y;
                    if (strArr[4].charAt(1) != strArr[3].charAt(1)) {
                        A0y[0] = "CfnO3oWhmhBZYFdKQQ3";
                        if ((z9 && this.A0A.A00 == 3) || this.A0A.A00 == 2) {
                            A0a(jAKe, this.A0X);
                        } else if (this.A0W.length == 0 || this.A0A.A00 == 4) {
                            this.A0f.AIT(2);
                        } else {
                            A0a(jAKe, 1000L);
                        }
                        if (!z2) {
                            this.A05 = -9223372036854775807L;
                        }
                        AnonymousClass54.A00();
                        return;
                    }
                } else {
                    C7B c7b = c7aA0F.A00;
                    String[] strArr5 = A0y;
                    if (strArr5[2].length() == strArr5[6].length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr6 = A0y;
                    strArr6[2] = "uQd";
                    strArr6[6] = "zdLpoimG1uHaXVEOP";
                    if (c7b.A05) {
                        A0V(4);
                        A0O();
                    }
                    if (this.A0A.A00 == 2) {
                    }
                    boolean z92 = this.A0P;
                    strArr = A0y;
                    if (strArr[4].charAt(1) != strArr[3].charAt(1)) {
                    }
                }
            }
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A0P() throws AD, IOException {
        if (this.A0D == null) {
            return;
        }
        if (this.A02 > 0) {
            this.A0D.ACT();
            return;
        }
        A0J();
        C7A c7aA0E = this.A0j.A0E();
        if (c7aA0E != null && !c7aA0E.A0R()) {
            boolean z = this.A0A.A0A;
            if (A0y[1].length() != 31) {
                A0y[5] = "JakbFE5sCqyiHPWhcmq5QKrahWaBlD8R";
                if (!z) {
                    A0w(false);
                }
            }
            throw new RuntimeException();
        }
        A0y(false);
        if (this.A0j.A0N()) {
            C7A c7aA0F = this.A0j.A0F();
            C7A c7aA0G = this.A0j.A0G();
            boolean z2 = false;
            while (this.A0P && c7aA0F != c7aA0G && this.A06 >= c7aA0F.A0I().A0H(this.A0K)) {
                if (z2) {
                    A0H();
                }
                int i = c7aA0F.A00.A07 ? 0 : 3;
                C7A c7a = c7aA0F;
                c7aA0F = this.A0j.A0B();
                A0g(c7a);
                C7Z c7z = this.A0A;
                C1829no c1829no = c7aA0F.A00.A04;
                long j = c7aA0F.A00.A03;
                if (A0y[7].charAt(12) == '2') {
                    throw new RuntimeException();
                }
                String[] strArr = A0y;
                strArr[4] = "OGZbExKcucXIKKZQBdHGOATJ9dYdrwhN";
                strArr[3] = "TJxPjvISq11gHqp4fguKhlEOGAavfVmH";
                this.A0A = c7z.A06(c1829no, j, c7aA0F.A00.A02, A01());
                this.A0h.A04(i);
                A0Q();
                z2 = true;
            }
            C7B c7b = c7aA0G.A00;
            String[] strArr2 = A0y;
            if (strArr2[4].charAt(1) != strArr2[3].charAt(1)) {
                A0y[7] = "WHxPanRASNJPtq4bnE3dJm5Kco7OvEcN";
                if (c7b.A05) {
                    for (int i2 = 0; i2 < this.A0v.length; i2++) {
                        InterfaceC1890oo interfaceC1890oo = this.A0v[i2];
                        DT dt = c7aA0G.A09[i2];
                        if (dt != null && interfaceC1890oo.A9D() == dt && interfaceC1890oo.A9p()) {
                            interfaceC1890oo.AJN();
                        }
                    }
                    return;
                }
                if (c7aA0G.A0I() == null) {
                    return;
                }
                C7A c7aA0I = c7aA0G.A0I();
                String[] strArr3 = A0y;
                if (strArr3[4].charAt(1) != strArr3[3].charAt(1)) {
                    A0y[7] = "aMxVvZtAQBe9jxU0Z4NX1LXmsoJEfXr7";
                    if (c7aA0I.A02) {
                        for (int i3 = 0; i3 < this.A0v.length; i3++) {
                            InterfaceC1890oo interfaceC1890oo2 = this.A0v[i3];
                            DT dt2 = c7aA0G.A09[i3];
                            if (interfaceC1890oo2.A9D() != dt2) {
                                return;
                            }
                            if (dt2 != null && !interfaceC1890oo2.A9p()) {
                                return;
                            }
                        }
                        C0471Ex c0471ExA0K = c7aA0G.A0K();
                        C7A c7aA0C = this.A0j.A0C();
                        C0471Ex c0471ExA0K2 = c7aA0C.A0K();
                        boolean z3 = c7aA0C.A07.AHQ() != -9223372036854775807L;
                        for (int i4 = 0; i4 < this.A0v.length; i4++) {
                            InterfaceC1890oo interfaceC1890oo3 = this.A0v[i4];
                            if (c0471ExA0K.A00(i4)) {
                                if (z3) {
                                    interfaceC1890oo3.AJN();
                                } else {
                                    boolean zAAN = interfaceC1890oo3.AAN();
                                    if (A0y[0].length() != 16) {
                                        A0y[1] = "9mAYXkFxI0mZazBGslnkswropOC4T";
                                        if (zAAN) {
                                            continue;
                                        } else {
                                            InterfaceC1793nE interfaceC1793nE = c0471ExA0K2.A04[i4];
                                            boolean zA00 = c0471ExA0K2.A00(i4);
                                            boolean z4 = this.A0w[i4].A9N() == -2;
                                            C03037s c03037s = c0471ExA0K.A03[i4];
                                            C03037s c03037s2 = c0471ExA0K2.A03[i4];
                                            if (A0y[1].length() == 31) {
                                                throw new RuntimeException();
                                            }
                                            A0y[1] = "R6UwS9N6ly40SGlMhcEQ765TyuQep";
                                            if (zA00 && c03037s2.equals(c03037s) && !z4) {
                                                C1981qI[] c1981qIArrA1A = A1A(interfaceC1793nE);
                                                Log.e(A0D(0, 21, 22), A0D(392, 13, 67));
                                                interfaceC1890oo3.AIa(c1981qIArrA1A, c7aA0C.A09[i4], c7aA0C.A0H(this.A0K), c7aA0C.A0B());
                                            } else {
                                                interfaceC1890oo3.AJN();
                                            }
                                        }
                                    } else {
                                        A0y[0] = "RavyRccOc8FddTyMpAZEZ";
                                        if (zAAN) {
                                            continue;
                                        }
                                    }
                                }
                            }
                        }
                        return;
                    }
                    return;
                }
            }
            throw new RuntimeException();
        }
    }

    public static void A0R() {
        A0x = new byte[]{-108, -57, -66, -97, -69, -80, -56, -76, -63, -104, -68, -65, -69, -104, -67, -61, -76, -63, -67, -80, -69, -15, 36, 27, -4, 24, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 37, 17, 30, -11, 25, 28, 24, -11, 26, 32, 17, 30, 26, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 24, -26, -12, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 26, 16, 24, 17, 30, -87, -57, -50, -49, -46, -55, -50, -57, -128, -51, -59, -45, -45, -63, -57, -59, -45, -128, -45, -59, -50, -44, -128, -63, -58, -44, -59, -46, -128, -46, -59, -52, -59, -63, -45, -59, -114, -107, -70, -64, -79, -66, -70, -83, -72, 108, -66, -63, -70, -64, -75, -71, -79, 108, -79, -66, -66, -69, -66, 122, -54, -26, -37, -13, -36, -37, -35, -27, -102, -33, -20, -20, -23, -20, -88, -114, -86, -97, -73, -96, -97, -95, -87, -114, -83, -79, -89, -78, -89, -83, -84, -117, -79, 120, 94, 99, -94, 106, 94, -96, -77, -92, -92, -93, -80, -93, -94, -126, -77, -80, -97, -78, -89, -83, -84, -117, -79, 120, 94, 99, -94, 106, 94, -84, -93, -74, -78, -118, -83, -97, -94, -114, -83, -79, -89, -78, -89, -83, -84, -117, -79, 120, 94, 99, -94, -76, -48, -42, -45, -60, -58, -127, -58, -45, -45, -48, -45, -113, -72, -39, -44, -43, -123, -53, -58, -50, -47, -54, -55, -109, -78, -97, -91, -84, -67, -59, -56, -57, -54, -71, -54, -63, -60, -47, 120, -63, -65, -58, -57, -54, -63, -58, -65, 120, -53, -52, -54, -67, -71, -59, 120, -67, -54, -54, -57, -54, -110, 120, -108, -78, -71, -87, -82, -89, 96, -76, -81, 96, -77, -91, -82, -92, 96, -83, -91, -77, -77, -95, -89, -91, 96, -81, -82, 96, -95, 96, -92, -91, -95, -92, 96, -76, -88, -78, -91, -95, -92, 110, 5, 30, 21, 40, 32, 21, 19, 36, 21, 20, -48, 21, 34, 34, 31, 34, -48, 20, 21, 28, 25, 38, 21, 34, 25, 30, 23, -48, 29, 21, 35, 35, 17, 23, 21, -48, 31, 30, -48, 21, 40, 36, 21, 34, 30, 17, 28, -48, 36, 24, 34, 21, 17, 20, -34, -34, -23, -51, -23, -25, -33, -47, -23, -20, -27, 37, 29, 28, 33, 25, 8, 29, 42, 33, 39, 28, 1, 28, -70, -81, -68, -77, -71, -82, -102, -71, -67, -77, -66, -77, -71, -72, -97, -67, -18, -31, -20, -24, -35, -33, -31, -49, -16, -18, -31, -35, -23};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 18 out of bounds for length 16
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    /* JADX WARN: Removed duplicated region for block: B:84:0x021b A[PHI: r8
      0x021b: PHI (r8v4 com.facebook.ads.redexgen.X.no) = (r8v2 com.facebook.ads.redexgen.X.no), (r8v6 com.facebook.ads.redexgen.X.no) binds: [B:93:0x024d, B:83:0x0219] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A0e(C02696k c02696k) throws AD {
        C1829no c1829no;
        if (c02696k.A01 != this.A0D) {
            return;
        }
        Timeline timeline = this.A0A.A03;
        Timeline timeline2 = c02696k.A00;
        this.A0A = this.A0A.A04(timeline2);
        A0M();
        if (this.A02 > 0) {
            this.A0h.A03(this.A02);
            this.A02 = 0;
            if (this.A08 != null) {
                Pair<Object, Long> pairA09 = A09(this.A08, true);
                this.A08 = null;
                if (pairA09 == null) {
                    A0G();
                    return;
                }
                Object obj = pairA09.first;
                long jLongValue = ((Long) pairA09.second).longValue();
                C1829no c1829noA0K = this.A0j.A0K(timeline2, obj, jLongValue);
                this.A0A = this.A0A.A06(c1829noA0K, c1829noA0K.A00() ? 0L : jLongValue, jLongValue, this.A0A.A0D);
                return;
            }
            if (A0y[1].length() == 31) {
                throw new RuntimeException();
            }
            String[] strArr = A0y;
            strArr[2] = "O4I";
            strArr[6] = "ahZa31gq0LeVPqA4e";
            if (0 != 0) {
                throw new NullPointerException(A0D(376, 16, 17));
            }
            if (this.A0A.A02 == -9223372036854775807L) {
                if (timeline2.A0N()) {
                    A0G();
                    return;
                }
                Pair<Object, Long> pairA08 = A08(timeline2, timeline2.A0B(this.A0V), -9223372036854775807L);
                Object obj2 = pairA08.first;
                long jLongValue2 = ((Long) pairA08.second).longValue();
                C1829no c1829noA0K2 = this.A0j.A0K(timeline2, obj2, jLongValue2);
                C7Z c7z = this.A0A;
                String[] strArr2 = A0y;
                if (strArr2[2].length() == strArr2[6].length()) {
                    throw new RuntimeException();
                }
                A0y[0] = "JR6dPBbFHW2aBR0iQ91GP51A";
                this.A0A = c7z.A06(c1829noA0K2, c1829noA0K2.A00() ? 0L : jLongValue2, jLongValue2, this.A0A.A0D);
                return;
            }
            return;
        }
        Object obj3 = this.A0A.A05.A04;
        long j = this.A0A.A01;
        if (timeline.A0N()) {
            if (timeline2.A0N()) {
                return;
            }
            C1829no c1829noA0K3 = this.A0j.A0K(timeline2, obj3, j);
            this.A0A = this.A0A.A06(c1829noA0K3, c1829noA0K3.A00() ? 0L : j, j, this.A0A.A0D);
            return;
        }
        C7A c7aA0D = this.A0j.A0D();
        Object obj4 = c7aA0D == null ? this.A0A.A05.A04 : c7aA0D.A08;
        int iA0A = timeline2.A0A(obj4);
        if (iA0A != -1) {
            C7Z c7z2 = this.A0A;
            String[] strArr3 = A0y;
            if (strArr3[4].charAt(1) != strArr3[3].charAt(1)) {
                String[] strArr4 = A0y;
                strArr4[4] = "QYIV2IuM2tD6Cg4Dd0tvfiQK4IQ6icHf";
                strArr4[3] = "hXYkHU7O6zP410ynmzMqamHjkcWcTxII";
                c1829no = c7z2.A05;
                if (c1829no.A00()) {
                    C1829no c1829noA0K4 = this.A0j.A0K(timeline2, Integer.valueOf(iA0A), j);
                    if (!c1829noA0K4.equals(c1829no)) {
                        this.A0A = this.A0A.A06(c1829noA0K4, A06(c1829noA0K4, c1829noA0K4.A00() ? 0L : j), j, A01());
                        return;
                    }
                }
            } else {
                c1829no = c7z2.A05;
                if (c1829no.A00()) {
                }
            }
            C7E c7e = this.A0j;
            long j2 = this.A06;
            if (A0y[1].length() == 31) {
                throw new RuntimeException();
            }
            String[] strArr5 = A0y;
            strArr5[4] = "30gHr5wufVP7jVH5IRZCDYCZy2V5u0Zf";
            strArr5[3] = "xPVmpg9j3VPOmOyowbQUJ4kDfZKAMzov";
            if (!c7e.A0Q(timeline2, c1829no, j2)) {
                A0x(false);
            }
            A0v(false);
            return;
        }
        Object objA0C = A0C(obj4, timeline, timeline2);
        if (objA0C == null) {
            A0G();
            return;
        }
        Pair<Object, Long> pairA082 = A08(timeline2, timeline2.A0J(objA0C, this.A0c).A00, -9223372036854775807L);
        Object obj5 = pairA082.first;
        long jLongValue3 = ((Long) pairA082.second).longValue();
        C1829no c1829noA0K5 = this.A0j.A0K(timeline2, obj5, jLongValue3);
        if (c7aA0D != null) {
            while (c7aA0D.A0I() != null) {
                c7aA0D = c7aA0D.A0I();
                if (c7aA0D.A00.A04.equals(c1829noA0K5)) {
                    C7E c7e2 = this.A0j;
                    String[] strArr6 = A0y;
                    if (strArr6[4].charAt(1) != strArr6[3].charAt(1)) {
                        A0y[0] = "lm8nmDAIswUHpj0OrSP7ctv";
                        c7aA0D.A00 = c7e2.A0I(timeline2, c7aA0D.A00);
                    } else {
                        c7aA0D.A00 = c7e2.A0I(timeline2, c7aA0D.A00);
                    }
                }
            }
        }
        long jA06 = A06(c1829noA0K5, c1829noA0K5.A00() ? 0L : jLongValue3);
        C7Z c7z3 = this.A0A;
        long jA01 = A01();
        String[] strArr7 = A0y;
        if (strArr7[4].charAt(1) == strArr7[3].charAt(1)) {
            throw new RuntimeException();
        }
        String[] strArr8 = A0y;
        strArr8[2] = "HJD";
        strArr8[6] = "HIUAzKTwmQi0tOVOF";
        this.A0A = c7z3.A06(c1829noA0K5, jA06, jLongValue3, jA01);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 22 out of bounds for length 20
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    private void A0f(C02726n c02726n) throws Throwable {
        long jLongValue;
        C1829no c1829noA0K;
        long jLongValue2;
        boolean z;
        this.A0h.A03(1);
        Pair<Object, Long> pairA09 = A09(c02726n, true);
        if (pairA09 == null) {
            c1829noA0K = A0A();
            jLongValue2 = -9223372036854775807L;
            jLongValue = -9223372036854775807L;
            z = true;
        } else {
            Object obj = pairA09.first;
            jLongValue = ((Long) pairA09.second).longValue();
            c1829noA0K = this.A0j.A0K(this.A0A.A03, obj, jLongValue);
            if (c1829noA0K.A00()) {
                jLongValue2 = 0;
                z = true;
            } else {
                jLongValue2 = ((Long) pairA09.second).longValue();
                z = c02726n.A01 == -9223372036854775807L;
            }
        }
        try {
            try {
                if (this.A0D == null || this.A02 > 0) {
                    this.A08 = c02726n;
                    this.A07 = null;
                } else {
                    try {
                        if (jLongValue2 == -9223372036854775807L) {
                            A0V(4);
                            A13(false, true, false);
                        } else {
                            long jA6r = jLongValue2;
                            if (c1829noA0K.equals(this.A0A.A05)) {
                                C7A c7aA0F = this.A0j.A0F();
                                if (c7aA0F != null && jA6r != 0) {
                                    jA6r = c7aA0F.A07.A6r(jA6r, this.A0C);
                                }
                                if (C2Y.A01(jA6r) == C2Y.A01(this.A0A.A0C)) {
                                    this.A0A = this.A0A.A06(c1829noA0K, this.A0A.A0C, jLongValue, A01());
                                    if (z) {
                                        this.A0h.A04(2);
                                        return;
                                    }
                                    return;
                                }
                            }
                            long jA06 = A06(c1829noA0K, jA6r);
                            z |= jLongValue2 != jA06;
                            jLongValue2 = jA06;
                        }
                    } catch (Throwable th) {
                        th = th;
                        this.A0A = this.A0A.A06(c1829noA0K, jLongValue2, jLongValue, A01());
                        if (z) {
                            this.A0h.A04(2);
                        }
                        throw th;
                    }
                }
                this.A0A = this.A0A.A06(c1829noA0K, jLongValue2, jLongValue, A01());
                if (z) {
                    this.A0h.A04(2);
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    static {
        A0R();
    }

    public AB(InterfaceC1890oo[] interfaceC1890ooArr, AbstractC0470Ew abstractC0470Ew, C0471Ex c0471Ex, AnonymousClass74 anonymousClass74, F6 f6, boolean z, int i, boolean z2, Handler handler, AnonymousClass45 anonymousClass45, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, long j, boolean z9, int i2, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, C8O c8o) {
        this.A0v = interfaceC1890ooArr;
        this.A0l = abstractC0470Ew;
        this.A0m = c0471Ex;
        this.A0i = anonymousClass74;
        this.A0n = f6;
        this.A0P = z;
        this.A03 = i;
        this.A0V = z2;
        this.A0a = handler;
        this.A0e = anonymousClass45;
        this.A0U = z3;
        this.A0H = z4;
        this.A0G = z5;
        this.A0M = z6;
        this.A0I = z7;
        this.A0T = z8;
        this.A0Z = j;
        this.A0q = z9;
        this.A00 = i2;
        this.A0u = z11;
        this.A0s = z10;
        this.A0O = z12;
        this.A0Q = z13;
        this.A0K = z14;
        this.A0t = z15;
        this.A0N = j > 0;
        this.A0Y = anonymousClass74.A70(c8o);
        this.A0r = anonymousClass74.AIn(c8o);
        this.A0C = C03057u.A03;
        this.A0A = new C7Z(Timeline.A02, -9223372036854775807L, C1811nW.A06, c0471Ex);
        this.A0h = new C02716m();
        this.A0w = new InterfaceC03007p[interfaceC1890ooArr.length];
        for (int i3 = 0; i3 < interfaceC1890ooArr.length; i3++) {
            interfaceC1890ooArr[i3].AA9(i3, c8o);
            this.A0w[i3] = interfaceC1890ooArr[i3].A7D();
        }
        this.A0g = new C1898ow(this, anonymousClass45);
        this.A0k = new C1886ok(anonymousClass45);
        this.A0o = z11 ? new C03379g(anonymousClass45) : null;
        this.A0p = new ArrayList<>();
        this.A0W = new InterfaceC1890oo[0];
        this.A0d = new C1946pj();
        this.A0c = new C1948pl();
        abstractC0470Ew.A02(this, f6);
        this.A0b = new HandlerThread(A0D(21, 29, 115), -16);
        this.A0b.start();
        this.A0f = anonymousClass45.A5P(this.A0b.getLooper(), this);
    }

    @MetaExoPlayerCustomization
    private int A00() {
        int exoplayerThreadPollingIntervalMs = MetaExoPlayerUpgradeConfig.A00(EnumC1582jY.A04);
        if (exoplayerThreadPollingIntervalMs > 0) {
            return exoplayerThreadPollingIntervalMs;
        }
        return 10;
    }

    private long A01() {
        return A04(this.A0A.A0B);
    }

    private final long A02() {
        long loadingPeriodStartPositionUs;
        C7A c7aA0E = this.A0j.A0E();
        if (c7aA0E == null) {
            loadingPeriodStartPositionUs = 0;
        } else {
            loadingPeriodStartPositionUs = A05(c7aA0E);
        }
        if (c7aA0E == null || loadingPeriodStartPositionUs == -9223372036854775807L) {
            return 0L;
        }
        return c7aA0E.A0C(loadingPeriodStartPositionUs);
    }

    private final long A03() {
        long jA0C;
        C7A c7aA0F = this.A0j.A0F();
        if (c7aA0F == null) {
            jA0C = 0;
        } else {
            jA0C = c7aA0F.A0C(c7aA0F.A0D(this.A06));
        }
        return jA0C + A02();
    }

    private long A04(long j) {
        C7A c7aA0E = this.A0j.A0E();
        if (c7aA0E == null) {
            return 0L;
        }
        return j - c7aA0E.A0D(this.A06);
    }

    private final long A05(C7A c7a) {
        long jMin = Long.MAX_VALUE;
        DT[] dtArr = c7a.A09;
        for (int i = 0; i < dtArr.length; i++) {
            if (dtArr[i] instanceof DU) {
                long periodStartPositionUs = ((DU) dtArr[i]).A89();
                jMin = Math.min(jMin, periodStartPositionUs);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return -9223372036854775807L;
        }
        return jMin;
    }

    private long A06(C1829no c1829no, long j) throws AD {
        return A07(false, c1829no, j, this.A0j.A0F() != this.A0j.A0G());
    }

    private long A07(boolean z, C1829no c1829no, long j, boolean z2) throws AD {
        A0O();
        this.A0R = false;
        A0V(2);
        C7A c7aA0F = this.A0j.A0F();
        C7A c7aA0B = c7aA0F;
        while (true) {
            if (c7aA0B == null) {
                break;
            }
            if (A18(c1829no, j, c7aA0B)) {
                this.A0j.A0S(c7aA0B);
                break;
            }
            c7aA0B = this.A0j.A0B();
        }
        if (c7aA0F != c7aA0B || z2) {
            for (InterfaceC1890oo interfaceC1890oo : this.A0W) {
                A0l(interfaceC1890oo);
            }
            this.A0W = new InterfaceC1890oo[0];
            if (A0y[1].length() == 31) {
                throw new RuntimeException();
            }
            String[] strArr = A0y;
            strArr[4] = "70t8rv27mnV5UL6KHl8v284ienTbIO4o";
            strArr[3] = "4hBvGCC7ZdKRW68bijyzpqxjpy9h3CGi";
            c7aA0F = null;
        }
        if (c7aA0B != null) {
            A0g(c7aA0F);
            if (c7aA0B.A01) {
                j = c7aA0B.A07.AJ8(j, z);
                c7aA0B.A07.A60(j - this.A0Y, this.A0r);
            }
            A0Y(j);
            A0w(this.A0G);
        } else {
            this.A0j.A0M(true);
            A0Y(j);
        }
        A0v(false);
        this.A0f.AJA(2);
        return j;
    }

    private Pair<Object, Long> A08(Timeline timeline, int i, long j) {
        return timeline.A0D(this.A0d, this.A0c, i, j);
    }

    private Pair<Object, Long> A09(C02726n c02726n, boolean z) {
        int iA0A;
        Timeline timeline = this.A0A.A03;
        Timeline timeline2 = c02726n.A02;
        if (timeline.A0N()) {
            return null;
        }
        if (timeline2.A0N()) {
            timeline2 = timeline;
        }
        try {
            Pair<Object, Long> periodPosition = timeline2.A0E(this.A0d, this.A0c, c02726n.A00, c02726n.A01);
            if (timeline == timeline2 || (iA0A = timeline.A0A(periodPosition.first)) != -1) {
                return periodPosition;
            }
            if (!z || A0C(periodPosition.first, timeline2, timeline) == null) {
                return null;
            }
            return A08(timeline, timeline.A0H(iA0A, this.A0c).A00, -9223372036854775807L);
        } catch (IndexOutOfBoundsException unused) {
            throw new C01732q(timeline, c02726n.A00, c02726n.A01);
        }
    }

    private C1829no A0A() {
        Timeline timeline = this.A0A.A03;
        if (timeline.A0N()) {
            return C7Z.A0E;
        }
        return new C1829no(timeline.A0M(timeline.A0K(timeline.A0B(this.A0V), this.A0d).A00));
    }

    @MetaExoPlayerCustomization(type = {"NEW_METHOD"}, value = "D71523094: Added for negative testing")
    private final Integer A0B() {
        C7V playbackLatencyConfig;
        if (this.A09 == null || (playbackLatencyConfig = this.A09.A02()) == null) {
            String[] strArr = A0y;
            if (strArr[2].length() != strArr[6].length()) {
                A0y[7] = "1rqbEBrQgQNr61xUccdMybR9UEwvq3L8";
                return null;
            }
        } else {
            int iA00 = playbackLatencyConfig.A00();
            if (A0y[0].length() != 16) {
                String[] strArr2 = A0y;
                strArr2[2] = "KUZ";
                strArr2[6] = "wQAKuizVIm50S6vdz";
                return Integer.valueOf(iA00);
            }
        }
        throw new RuntimeException();
    }

    private Object A0C(Object obj, Timeline timeline, Timeline timeline2) {
        int iA0A = timeline.A0A(obj);
        int i = -1;
        int maxIterations = timeline.A06();
        for (int newPeriodIndex = 0; newPeriodIndex < maxIterations && i == -1 && (iA0A = timeline.A09(iA0A, this.A0c, this.A0d, this.A03, this.A0V)) != -1; newPeriodIndex++) {
            i = timeline2.A0A(timeline.A0M(iA0A));
        }
        if (i == -1) {
            return null;
        }
        return timeline2.A0M(i);
    }

    private void A0E() {
        C7A c7aA0E = this.A0j.A0E();
        if (c7aA0E == null) {
            return;
        }
        c7aA0E.A07.A4s(c7aA0E.A0D(this.A06));
    }

    private void A0G() {
        A0V(4);
        A13(false, true, false);
    }

    private void A0H() {
        int i;
        if (this.A0h.A06(this.A0A)) {
            Handler handler = this.A0a;
            int i2 = this.A0h.A01;
            if (this.A0h.A03) {
                i = this.A0h.A00;
            } else {
                i = -1;
            }
            handler.obtainMessage(0, i2, i, this.A0A).sendToTarget();
            this.A0h.A05(this.A0A);
        }
    }

    private void A0I() throws IOException {
        C7A c7aA0E = this.A0j.A0E();
        C7A readingPeriodHolder = this.A0j.A0G();
        if (c7aA0E != null && !c7aA0E.A02) {
            if (readingPeriodHolder != null) {
                C7A loadingPeriodHolder = readingPeriodHolder.A0I();
                if (loadingPeriodHolder != c7aA0E) {
                    return;
                }
            }
            for (InterfaceC1890oo interfaceC1890oo : this.A0W) {
                if (!interfaceC1890oo.A9p()) {
                    return;
                }
            }
            c7aA0E.A07.ACS();
        }
    }

    private void A0J() throws IOException {
        this.A0j.A0L(this.A06);
        if (this.A0j.A0O()) {
            C7B c7bA0H = this.A0j.A0H(this.A06, this.A0A);
            if (c7bA0H == null) {
                this.A0D.ACT();
                return;
            }
            this.A0j.A0J(this.A0w, this.A0t ? 60000000L : 0L, this.A0l, this.A0i.A6v(), this.A0D, c7bA0H, this.A0m).AH5(this, c7bA0H.A03);
            A0y(true);
            A0v(false);
        }
    }

    private void A0K() {
        A13(true, true, true);
        this.A0i.AFc(C8O.A03);
        A0V(1);
        this.A0b.quit();
        synchronized (this) {
            this.A0S = true;
            notifyAll();
        }
    }

    private void A0L() throws AD {
        boolean z;
        if (!this.A0j.A0N()) {
            return;
        }
        float f = this.A0g.A8m().A01;
        C7A periodHolder = this.A0j.A0G();
        boolean z2 = true;
        for (C7A c7aA0F = this.A0j.A0F(); c7aA0F != null && c7aA0F.A02; c7aA0F = c7aA0F.A0I()) {
            C0471Ex c0471ExA0L = c7aA0F.A0L(f, this.A0A.A03);
            if (c0471ExA0L != null) {
                if (z2) {
                    C7A c7aA0F2 = this.A0j.A0F();
                    boolean zA0S = this.A0j.A0S(c7aA0F2);
                    boolean[] zArr = new boolean[this.A0v.length];
                    long jA0G = c7aA0F2.A0G(c0471ExA0L, this.A0A.A0C, zA0S, zArr);
                    if (this.A0A.A00 != 4 && jA0G != this.A0A.A0C) {
                        this.A0A = this.A0A.A06(this.A0A.A05, jA0G, this.A0A.A01, A01());
                        this.A0h.A04(4);
                        A0Y(jA0G);
                    }
                    int i = 0;
                    boolean[] zArr2 = new boolean[this.A0v.length];
                    for (int i2 = 0; i2 < this.A0v.length; i2++) {
                        InterfaceC1890oo interfaceC1890oo = this.A0v[i2];
                        zArr2[i2] = interfaceC1890oo.A9A() != 0;
                        DT dt = c7aA0F2.A09[i2];
                        if (dt != null) {
                            i++;
                        }
                        if (zArr2[i2]) {
                            DT dtA9D = interfaceC1890oo.A9D();
                            if (A0y[7].charAt(12) == '2') {
                                throw new RuntimeException();
                            }
                            A0y[1] = "PyyQ9suxdi7C";
                            if (dt != dtA9D) {
                                A0l(interfaceC1890oo);
                            } else if (zArr[i2]) {
                                interfaceC1890oo.AIm(this.A06);
                            }
                        }
                    }
                    this.A0A = this.A0A.A07(c7aA0F2.A0J(), c7aA0F2.A0K());
                    A14(zArr2, i);
                    z = false;
                } else {
                    this.A0j.A0S(c7aA0F);
                    if (c7aA0F.A02) {
                        z = false;
                        c7aA0F.A0F(c0471ExA0L, Math.max(c7aA0F.A00.A03, c7aA0F.A0D(this.A06)), false);
                    } else {
                        z = false;
                    }
                }
                A0v(true);
                if (this.A0A.A00 != 4) {
                    A0w(z);
                    A0Q();
                    this.A0f.AJA(2);
                    return;
                }
                return;
            }
            if (c7aA0F == periodHolder) {
                z2 = false;
            }
        }
    }

    private void A0M() {
        for (int size = this.A0p.size() - 1; size >= 0; size--) {
            if (!A16(this.A0p.get(size))) {
                this.A0p.get(size).A03.A0A(false);
                this.A0p.remove(size);
            }
        }
        Collections.sort(this.A0p);
    }

    private void A0N() throws AD {
        this.A0R = false;
        this.A0g.A05();
        this.A0k.A00();
        if (this.A0u) {
            this.A0o.A00();
        }
        for (InterfaceC1890oo interfaceC1890oo : this.A0W) {
            interfaceC1890oo.start();
        }
    }

    private void A0O() throws AD {
        this.A0g.A06();
        this.A0k.A01();
        if (this.A0u) {
            this.A0o.A01();
        }
        for (InterfaceC1890oo interfaceC1890oo : this.A0W) {
            A0m(interfaceC1890oo);
        }
    }

    private void A0Q() throws AD {
        if (!this.A0j.A0N()) {
            return;
        }
        C7A c7aA0F = this.A0j.A0F();
        long jAHQ = c7aA0F.A07.AHQ();
        if (jAHQ != -9223372036854775807L) {
            A0Y(jAHQ);
            if (jAHQ != this.A0A.A0C) {
                this.A0A = this.A0A.A06(this.A0A.A05, jAHQ, this.A0A.A01, A01());
                this.A0h.A04(4);
            }
        } else {
            C1898ow c1898ow = this.A0g;
            C7A playingPeriodHolder = this.A0j.A0G();
            this.A06 = c1898ow.A04(c7aA0F != playingPeriodHolder);
            long jA0D = c7aA0F.A0D(this.A06);
            A0Z(this.A0A.A0C, jA0D);
            this.A0A.A0C = jA0D;
        }
        C7A playingPeriodHolder2 = this.A0j.A0E();
        this.A0A.A0B = playingPeriodHolder2.A09();
        this.A0A.A0D = A01();
        this.A0A.A0D = c7aA0F.A0C(this.A0A.A0C);
    }

    private void A0S(byte b) {
        C7A c7aA0E = this.A0j.A0E();
        if (c7aA0E != null && this.A0U) {
            c7aA0E.A07.AKb(b);
        }
    }

    private void A0T(float f) {
        for (C7A c7aA0D = this.A0j.A0D(); c7aA0D != null && c7aA0D.A02; c7aA0D = c7aA0D.A0I()) {
            for (InterfaceC1793nE interfaceC1793nE : c7aA0D.A0K().A04) {
                if (interfaceC1793nE != null) {
                    interfaceC1793nE.AFJ(f);
                }
            }
        }
    }

    private void A0U(int i) throws AD {
        this.A03 = i;
        if (!this.A0j.A0P(this.A0A.A03, i)) {
            if (A0y[0].length() == 16) {
                throw new RuntimeException();
            }
            A0y[5] = "F0pbcDG7mrKSFF2ySsjJdp1en5xQxzay";
            A0x(true);
        }
        A0v(false);
    }

    private void A0V(int i) {
        if (this.A0A.A00 != i) {
            this.A0A = this.A0A.A01(i);
            if (i == 2) {
                this.A04 = System.currentTimeMillis();
            } else {
                this.A04 = -1L;
            }
        }
    }

    private void A0W(int i, boolean z) {
        if (this.A0A.A00 != i) {
            C7Z c7zA03 = this.A0A.A03(i, z);
            if (A0y[1].length() == 31) {
                throw new RuntimeException();
            }
            A0y[1] = "pTubBuiOOGTe";
            this.A0A = c7zA03;
            if (i == 2) {
                this.A04 = System.currentTimeMillis();
            } else {
                this.A04 = -1L;
            }
        }
    }

    private void A0X(int i, boolean playing, int i2) throws AD {
        C7A c7aA0F = this.A0j.A0F();
        InterfaceC1890oo interfaceC1890oo = this.A0v[i];
        this.A0W[i2] = interfaceC1890oo;
        if (interfaceC1890oo.A9A() == 0) {
            C7A c7aA0G = this.A0j.A0G();
            C7A playingPeriodHolder = this.A0j.A0F();
            boolean z = c7aA0G == playingPeriodHolder;
            C03037s c03037s = c7aA0F.A0K().A03[i];
            C1981qI[] c1981qIArrA1A = A1A(c7aA0F.A0K().A04[i]);
            boolean z2 = this.A0P && this.A0A.A00 == 3;
            interfaceC1890oo.A6L(c03037s, c1981qIArrA1A, c7aA0F.A09[i], this.A06, !playing && z2, z, c7aA0G.A0H(this.A0K), c7aA0F.A0B());
            this.A0g.A09(interfaceC1890oo);
            if (z2) {
                interfaceC1890oo.start();
            }
        }
    }

    private void A0Y(long j) throws AD {
        long jA0E;
        if (this.A0j.A0N()) {
            jA0E = this.A0j.A0F().A0E(j);
        } else {
            jA0E = ((long) (this.A0t ? 60000000 : 0)) + j;
        }
        this.A06 = jA0E;
        this.A0g.A07(this.A06);
        for (InterfaceC1890oo interfaceC1890oo : this.A0W) {
            long j2 = this.A06;
            String[] strArr = A0y;
            if (strArr[2].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            A0y[5] = "3LWS1la82nevxXslk8B3HGv7gilut34u";
            interfaceC1890oo.AIm(j2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0108 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00fd A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A0Z(long j, long j2) throws AD {
        C02706l c02706l;
        C02706l nextInfo;
        int i;
        int currentPeriodIndex;
        if (this.A0p.isEmpty() || this.A0A.A05.A00()) {
            return;
        }
        C7Z c7z = this.A0A;
        if (A0y[0].length() != 16) {
            String[] strArr = A0y;
            strArr[4] = "N4EB4VnnGuurJLGLQe09RRoMwim7ZTwR";
            strArr[3] = "el7QB6NOzA9v772mMpBH3ujflXdKxCpX";
            if (c7z.A02 == j) {
                j--;
            }
            int iA0A = this.A0A.A03.A0A(this.A0A.A05.A04);
            int currentPeriodIndex2 = this.A01;
            if (currentPeriodIndex2 > 0) {
                ArrayList<C02706l> arrayList = this.A0p;
                int currentPeriodIndex3 = this.A01;
                int i2 = currentPeriodIndex3 - 1;
                if (A0y[1].length() != 31) {
                    String[] strArr2 = A0y;
                    strArr2[2] = "q3c";
                    strArr2[6] = "HlTr3zIzL5MxTNWEN";
                    c02706l = arrayList.get(i2);
                }
            } else {
                c02706l = null;
            }
            while (c02706l != null && (c02706l.A00 > iA0A || (c02706l.A00 == iA0A && c02706l.A01 > j))) {
                int currentPeriodIndex4 = this.A01;
                this.A01 = currentPeriodIndex4 - 1;
                int currentPeriodIndex5 = this.A01;
                if (currentPeriodIndex5 > 0) {
                    ArrayList<C02706l> arrayList2 = this.A0p;
                    int currentPeriodIndex6 = this.A01;
                    c02706l = arrayList2.get(currentPeriodIndex6 - 1);
                } else {
                    c02706l = null;
                }
            }
            int i3 = this.A01;
            int currentPeriodIndex7 = this.A0p.size();
            if (i3 < currentPeriodIndex7) {
                ArrayList<C02706l> arrayList3 = this.A0p;
                int currentPeriodIndex8 = this.A01;
                nextInfo = arrayList3.get(currentPeriodIndex8);
            } else {
                nextInfo = null;
            }
            while (nextInfo != null && nextInfo.A02 != null) {
                int i4 = nextInfo.A00;
                if (A0y[5].charAt(1) != 'q') {
                    A0y[1] = "urcr7rEa5cce4ZESz6";
                    if (i4 >= iA0A) {
                        int i5 = nextInfo.A00;
                        if (A0y[7].charAt(12) == '2') {
                            throw new RuntimeException();
                        }
                        A0y[7] = "Pqus3FB2V0wQm49ac7wvllFxwdLgqwrG";
                        if (i5 != iA0A || nextInfo.A01 > j) {
                            break;
                        }
                    }
                    int currentPeriodIndex9 = this.A01;
                    this.A01 = currentPeriodIndex9 + 1;
                    i = this.A01;
                    currentPeriodIndex = this.A0p.size();
                    if (i >= currentPeriodIndex) {
                        ArrayList<C02706l> arrayList4 = this.A0p;
                        int currentPeriodIndex10 = this.A01;
                        C02706l nextInfo2 = arrayList4.get(currentPeriodIndex10);
                        nextInfo = nextInfo2;
                    } else {
                        nextInfo = null;
                    }
                } else {
                    if (i4 >= iA0A) {
                    }
                    int currentPeriodIndex92 = this.A01;
                    this.A01 = currentPeriodIndex92 + 1;
                    i = this.A01;
                    currentPeriodIndex = this.A0p.size();
                    if (i >= currentPeriodIndex) {
                    }
                }
            }
            while (nextInfo != null) {
                Object obj = nextInfo.A02;
                if (A0y[1].length() != 31) {
                    String[] strArr3 = A0y;
                    strArr3[2] = "ENU";
                    strArr3[6] = "SOUOSvSypycWuSHSN";
                    if (obj == null) {
                        return;
                    }
                    int currentPeriodIndex11 = nextInfo.A00;
                    if (currentPeriodIndex11 == iA0A && nextInfo.A01 > j && nextInfo.A01 <= j2) {
                        A0j(nextInfo.A03);
                        if (nextInfo.A03.A0B() || nextInfo.A03.A0D()) {
                            ArrayList<C02706l> arrayList5 = this.A0p;
                            int currentPeriodIndex12 = this.A01;
                            arrayList5.remove(currentPeriodIndex12);
                        } else {
                            int currentPeriodIndex13 = this.A01;
                            this.A01 = currentPeriodIndex13 + 1;
                        }
                        int i6 = this.A01;
                        int currentPeriodIndex14 = this.A0p.size();
                        if (i6 < currentPeriodIndex14) {
                            ArrayList<C02706l> arrayList6 = this.A0p;
                            int currentPeriodIndex15 = this.A01;
                            C02706l nextInfo3 = arrayList6.get(currentPeriodIndex15);
                            nextInfo = nextInfo3;
                        } else {
                            nextInfo = null;
                        }
                    } else {
                        return;
                    }
                }
            }
            return;
        }
        throw new RuntimeException();
    }

    private void A0a(long j, long j2) {
        this.A0f.AIT(2);
        this.A0f.AJB(2, j + j2);
    }

    private void A0b(C1960px c1960px) {
        this.A0g.AJd(c1960px);
        if (this.A0o != null) {
            this.A0o.AJd(c1960px);
        }
        if (this.A0k != null) {
            this.A0k.AJd(c1960px);
        }
    }

    private void A0c(C02686j c02686j) throws AD {
        throw new NullPointerException(A0D(376, 16, 17));
    }

    private void A0d(C02686j c02686j, boolean z) throws AD {
        this.A0h.A03(1);
        throw new NullPointerException(A0D(363, 13, 127));
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A0g(C7A c7a) throws AD {
        C7A c7aA0F = this.A0j.A0F();
        if (c7aA0F == null || c7a == c7aA0F) {
            return;
        }
        int i = 0;
        boolean[] zArr = new boolean[this.A0v.length];
        String[] strArr = A0y;
        String str = strArr[4];
        String str2 = strArr[3];
        int enabledRendererCount = str.charAt(1);
        if (enabledRendererCount == str2.charAt(1)) {
            throw new RuntimeException();
        }
        A0y[0] = "";
        for (int i2 = 0; i2 < this.A0v.length; i2++) {
            InterfaceC1890oo interfaceC1890oo = this.A0v[i2];
            zArr[i2] = interfaceC1890oo.A9A() != 0;
            if (c7aA0F.A0K().A00(i2)) {
                i++;
            }
            if (zArr[i2]) {
                C0471Ex c0471ExA0K = c7aA0F.A0K();
                int enabledRendererCount2 = A0y[5].charAt(1);
                if (enabledRendererCount2 != 113) {
                    String[] strArr2 = A0y;
                    strArr2[4] = "5yNp1I7g7IY9vjHrSpd0TTAHnxoP5q4N";
                    strArr2[3] = "spEmpaFlzQc3LcHeWE04rIrq6t30lchN";
                    if (c0471ExA0K.A00(i2)) {
                        if (interfaceC1890oo.AAN() && interfaceC1890oo.A9D() == c7a.A09[i2]) {
                            A0l(interfaceC1890oo);
                        }
                    }
                } else if (c0471ExA0K.A00(i2)) {
                }
            }
        }
        this.A0A = this.A0A.A07(c7aA0F.A0J(), c7aA0F.A0K());
        A14(zArr, i);
    }

    private void A0h(C02887d c02887d) throws AD {
        if (c02887d.A0D()) {
            return;
        }
        try {
            c02887d.A05().A9i(c02887d.A01(), c02887d.A09());
        } finally {
            c02887d.A0A(true);
        }
    }

    private void A0i(C02887d c02887d) throws AD {
        if (c02887d.A02() == -9223372036854775807L) {
            A0j(c02887d);
            return;
        }
        if (this.A0D == null || this.A02 > 0) {
            this.A0p.add(new C02706l(c02887d));
            return;
        }
        C02706l c02706l = new C02706l(c02887d);
        if (A16(c02706l)) {
            this.A0p.add(c02706l);
            Collections.sort(this.A0p);
        } else {
            c02887d.A0A(false);
        }
    }

    private void A0j(C02887d c02887d) throws AD {
        if (c02887d.A03() == this.A0f.A8R()) {
            A0h(c02887d);
            if (this.A0A.A00 == 3 || this.A0A.A00 == 2) {
                this.A0f.AJA(2);
                return;
            }
            return;
        }
        this.A0f.ACj(15, c02887d).A02();
    }

    private void A0k(final C02887d c02887d) {
        Looper looperA03 = c02887d.A03();
        if (!looperA03.getThread().isAlive()) {
            Log.w(A0D(220, 3, 37), A0D(258, 40, 7));
            c02887d.A0A(false);
        } else {
            this.A0e.A5P(looperA03, null).A03(new Runnable() { // from class: com.facebook.ads.redexgen.X.6h
                @Override // java.lang.Runnable
                public final void run() {
                    this.A00.A1E(c02887d);
                }
            });
        }
    }

    private void A0l(InterfaceC1890oo interfaceC1890oo) throws AD {
        this.A0g.A08(interfaceC1890oo);
        A0m(interfaceC1890oo);
        interfaceC1890oo.A5x();
    }

    private void A0m(InterfaceC1890oo interfaceC1890oo) throws AD {
        if (interfaceC1890oo.A9A() == 2) {
            interfaceC1890oo.stop();
        }
    }

    private void A0n(C03057u c03057u) {
        this.A0C = c03057u;
    }

    private void A0o(InterfaceC1830np interfaceC1830np) {
        if (!this.A0j.A0T(interfaceC1830np)) {
            return;
        }
        this.A0j.A0L(this.A06);
        A0w(false);
    }

    private void A0p(InterfaceC1830np interfaceC1830np) throws AD {
        byte b;
        if (!this.A0j.A0T(interfaceC1830np)) {
            return;
        }
        C7A c7aA0E = this.A0j.A0E();
        c7aA0E.A0N(this.A0g.A8m().A01, this.A0A.A03);
        A0s(c7aA0E.A0J(), c7aA0E.A0K());
        if (!this.A0j.A0N()) {
            C7A loadingPeriodHolder = this.A0j.A0B();
            A0Y(loadingPeriodHolder.A00.A03);
            A0g(null);
        }
        if (this.A0M || this.A0P) {
            b = 0;
        } else {
            b = 2;
        }
        A0S(b);
        A10(this.A0P);
        if (A0y[7].charAt(12) == '2') {
            throw new RuntimeException();
        }
        A0y[5] = "0JHOWU68jltYXS7XBlXTYuPeT3LWkLA2";
        A0w(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.DW
    /* JADX INFO: renamed from: A0q, reason: merged with bridge method [inline-methods] */
    public final void ADV(InterfaceC1830np interfaceC1830np) {
        this.A0f.ACj(10, interfaceC1830np).A02();
    }

    private void A0r(InterfaceC0419Cx interfaceC0419Cx, boolean z, boolean z2) {
        this.A02++;
        A13(true, z, z2);
        this.A0i.AFR(C8O.A03);
        this.A0D = interfaceC0419Cx;
        A0V(2);
        interfaceC0419Cx.AH7(this, null);
        this.A0f.AJA(2);
    }

    private void A0s(C1811nW c1811nW, C0471Ex c0471Ex) {
        this.A0i.AGF(new AnonymousClass73(C8O.A03, this.A0A.A03, this.A0A.A04, this.A0A.A0C, A01(), this.A0g.A8m().A01, this.A0P, this.A0R, -9223372036854775807L, this.A04), c1811nW, c0471Ex.A04);
    }

    @MetaExoPlayerCustomization("D18870411: Adding start stall debug reason")
    private void A0t(EnumC1547ir enumC1547ir, boolean z) {
        if (this.A0A.A00 != 3) {
            this.A0A = this.A0A.A02(3, enumC1547ir, z);
            this.A04 = -1L;
        }
    }

    @MetaExoPlayerCustomization(type = {"NEW_METHOD"}, value = "D63737392: Added for negative testing")
    private void A0u(String str) {
        boolean z = false;
        if (str == null) {
            this.A0J = false;
            this.A09 = null;
            return;
        }
        if (str != null && str.length() > 0) {
            z = true;
        }
        this.A0J = z;
        this.A09 = new C7W(str);
    }

    private void A0v(boolean z) {
        C1829no c1829no;
        C7A c7aA0E = this.A0j.A0E();
        if (c7aA0E == null) {
            C7Z c7z = this.A0A;
            if (A0y[1].length() == 31) {
                throw new RuntimeException();
            }
            String[] strArr = A0y;
            strArr[2] = "b0w";
            strArr[6] = "WyMJg745VdMbfing6";
            c1829no = c7z.A05;
        } else {
            c1829no = c7aA0E.A00.A04;
        }
        C1829no loadingMediaPeriodId = this.A0A.A04;
        boolean loadingMediaPeriodChanged = !loadingMediaPeriodId.equals(c1829no);
        if (loadingMediaPeriodChanged) {
            this.A0A = this.A0A.A05(c1829no);
        }
        if ((loadingMediaPeriodChanged || z) && c7aA0E != null && c7aA0E.A02) {
            A0s(c7aA0E.A0J(), c7aA0E.A0K());
        }
    }

    @MetaExoPlayerCustomization("Customized Buffered Duration MS D23157182")
    private void A0w(boolean z) {
        long jA0C;
        C7A c7aA0E = this.A0j.A0E();
        long jA0A = c7aA0E.A0A();
        if (jA0A == Long.MIN_VALUE) {
            A0y(false);
            return;
        }
        long jA0D = c7aA0E.A0D(this.A06);
        if (!this.A0s || c7aA0E == this.A0j.A0F() || this.A0j.A0F() == null) {
            jA0C = c7aA0E.A0C(jA0D);
            if (this.A0O) {
                for (C7A c7aA0F = this.A0j.A0F(); c7aA0F != null && c7aA0F != c7aA0E; c7aA0F = c7aA0F.A0I()) {
                    long nextLoadPositionUs = this.A06;
                    jA0C += c7aA0F.A0C(c7aA0F.A0D(nextLoadPositionUs));
                }
            }
        } else {
            jA0C = A02();
        }
        Timeline timeline = this.A0A.A03;
        C1829no c1829no = c7aA0E.A00.A04;
        float f = this.A0g.A8m().A01;
        boolean z2 = this.A0P || z;
        boolean z3 = this.A0R;
        long nextLoadPositionUs2 = this.A04;
        boolean zAJv = this.A0i.AJv(new AnonymousClass73(null, timeline, c1829no, jA0D, jA0C, f, z2, z3, -9223372036854775807L, nextLoadPositionUs2));
        if (this.A0T && this.A0P && this.A0R && !zAJv && this.A0A.A00 == 2) {
            Long lValueOf = Long.valueOf(jA0D / 1000);
            Long lValueOf2 = Long.valueOf(jA0C / 1000);
            Long lValueOf3 = Long.valueOf(jA0A / 1000);
            String[] strArr = A0y;
            if (strArr[4].charAt(1) == strArr[3].charAt(1)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0y;
            strArr2[2] = "Frr";
            strArr2[6] = "mfKzHFhLmxUYLc6Gx";
            this.A0a.obtainMessage(5, C5C.A0n(A0D(125, 70, 5), lValueOf, lValueOf2, lValueOf3)).sendToTarget();
            this.A0T = false;
        }
        A0y(zAJv);
        if (zAJv) {
            c7aA0E.A0O(this.A06);
        }
    }

    private void A0x(boolean z) throws AD {
        C1829no c1829no = this.A0j.A0F().A00.A04;
        long jA07 = A07(false, c1829no, this.A0A.A0C, true);
        if (jA07 != this.A0A.A0C) {
            this.A0A = this.A0A.A06(c1829no, jA07, this.A0A.A01, A01());
            if (z) {
                C02716m c02716m = this.A0h;
                String[] strArr = A0y;
                if (strArr[4].charAt(1) == strArr[3].charAt(1)) {
                    throw new RuntimeException();
                }
                A0y[5] = "dnthUoDEzHvBWSE2tp3YAJwgKJx1FOWZ";
                c02716m.A04(4);
            }
        }
    }

    private void A0y(boolean z) {
        if (this.A0A.A0A != z) {
            this.A0A = this.A0A.A08(z);
        }
    }

    private void A0z(boolean z) throws AD {
        try {
            this.A0R = false;
            this.A0P = z;
            A10(z);
            if (!z) {
                A0O();
                A0Q();
                A0S((byte) 2);
                if (this.A0I) {
                    A0E();
                }
            } else {
                A0S((byte) 0);
                if (this.A0A.A00 != 3) {
                    if (this.A0A.A00 == 2) {
                        this.A0f.AJA(2);
                    }
                } else {
                    A0N();
                    this.A0f.AJA(2);
                }
            }
        } finally {
            this.A0a.obtainMessage(3, Boolean.valueOf(z)).sendToTarget();
        }
    }

    @MetaExoPlayerCustomization("D19875605 Prevent further error loading once pausing video")
    private void A10(boolean z) {
        C7A loadingPeriod = this.A0j.A0E();
        if (loadingPeriod == null) {
            return;
        }
        loadingPeriod.A07.AJc(z);
    }

    private void A11(boolean z) throws AD {
        this.A0V = z;
        if (!this.A0j.A0R(this.A0A.A03, z)) {
            A0x(true);
        }
        A0v(false);
    }

    private void A12(boolean z, boolean z2) {
        A13(true, z, z);
        this.A0h.A03(this.A02 + (z2 ? 1 : 0));
        this.A02 = 0;
        this.A0i.AG6(C8O.A03);
        A0V(1);
    }

    private void A13(boolean z, boolean z2, boolean z3) {
        long j;
        C1811nW c1811nW;
        C0471Ex c0471Ex;
        this.A0f.AIT(2);
        this.A0R = false;
        this.A0g.A06();
        this.A0k.A01();
        if (this.A0u) {
            this.A0o.A01();
        }
        this.A06 = this.A0t ? 60000000L : 0L;
        for (InterfaceC1890oo interfaceC1890oo : this.A0W) {
            try {
                A0l(interfaceC1890oo);
            } catch (AD | RuntimeException e) {
                Log.e(A0D(0, 21, 22), A0D(208, 12, 44), e);
            }
        }
        this.A0W = new InterfaceC1890oo[0];
        this.A0j.A0M(!z2);
        A0y(false);
        if (z2) {
            this.A08 = null;
        }
        if (z3) {
            Iterator<C02706l> it = this.A0p.iterator();
            while (it.hasNext()) {
                it.next().A03.A0A(false);
            }
            this.A0p.clear();
            this.A01 = 0;
        }
        C1829no c1829noA0A = z2 ? A0A() : this.A0A.A05;
        long j2 = -9223372036854775807L;
        if (z2) {
            j = -9223372036854775807L;
        } else {
            C7Z c7z = this.A0A;
            if (A0y[5].charAt(1) != 'q') {
                String[] strArr = A0y;
                strArr[4] = "7gx390g1msf1u5QKnR2KjvR4WQmRx8YK";
                strArr[3] = "VlC7tbQkEF507tv73u1W2v85d7ApXXNM";
                j = c7z.A0C;
            } else {
                A0y[5] = "C79IK8sPJjEkg2u4SoGimfUAaE3F5yew";
                j = c7z.A0C;
            }
        }
        if (!z2) {
            C7Z c7z2 = this.A0A;
            if (A0y[5].charAt(1) == 'q') {
                throw new RuntimeException();
            }
            String[] strArr2 = A0y;
            strArr2[2] = "uSR";
            strArr2[6] = "FwoZ6mA9qzJ4hrvJt";
            j2 = c7z2.A01;
        }
        Timeline timeline = z3 ? Timeline.A02 : this.A0A.A03;
        int i = this.A0A.A00;
        if (z3) {
            c1811nW = C1811nW.A06;
        } else {
            C7Z c7z3 = this.A0A;
            if (A0y[7].charAt(12) == '2') {
                throw new RuntimeException();
            }
            A0y[5] = "yizxhFEcEwEbIh7DB6ScCbr86G64zHmf";
            c1811nW = c7z3.A06;
        }
        if (z3) {
            c0471Ex = this.A0m;
        } else {
            c0471Ex = this.A0A.A07;
        }
        this.A0A = new C7Z(timeline, c1829noA0A, j, j2, i, false, c1811nW, c0471Ex, c1829noA0A, j, 0L, j);
        if (z && this.A0D != null) {
            this.A0D.AHl(this);
            this.A0D = null;
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x000f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A14(boolean[] zArr, int i) throws AD {
        this.A0W = new InterfaceC1890oo[i];
        int enabledRendererCount = 0;
        C7A c7aA0F = this.A0j.A0F();
        for (int i2 = 0; i2 < enabledRendererCount; i2++) {
            if (c7aA0F.A0K().A00(i2)) {
                A0X(i2, zArr[i2], enabledRendererCount);
                enabledRendererCount++;
            }
        }
    }

    private boolean A15() {
        C7A playingPeriodHolder = this.A0j.A0F();
        C7A c7aA0I = playingPeriodHolder.A0I();
        long j = playingPeriodHolder.A00.A00;
        return j == -9223372036854775807L || this.A0A.A0C < j || (c7aA0I != null && (c7aA0I.A02 || c7aA0I.A00.A04.A00()));
    }

    private boolean A16(C02706l c02706l) {
        if (c02706l.A02 == null) {
            Pair<Object, Long> pairA09 = A09(new C02726n(c02706l.A03.A04(), c02706l.A03.A00(), C2Y.A00(c02706l.A03.A02())), false);
            if (pairA09 == null) {
                return false;
            }
            int iA0A = this.A0A.A03.A0A(pairA09.first);
            if (A0y[5].charAt(1) != 'q') {
                A0y[5] = "NfGCtpMsHKBVYsn3O7a8Zqq9gxyOlhFa";
                c02706l.A01(iA0A, ((Long) pairA09.second).longValue(), pairA09.first);
                return true;
            }
            throw new RuntimeException();
        }
        int iA0A2 = this.A0A.A03.A0A(c02706l.A02);
        if (iA0A2 == -1) {
            return false;
        }
        c02706l.A00 = iA0A2;
        return true;
    }

    private boolean A17(InterfaceC1890oo interfaceC1890oo) {
        C7A c7aA0G = this.A0j.A0G();
        C7A readingPeriodHolder = c7aA0G.A0I();
        if (readingPeriodHolder != null) {
            C7A readingPeriodHolder2 = c7aA0G.A0I();
            if (readingPeriodHolder2.A02 && interfaceC1890oo.A9p()) {
                return true;
            }
        }
        return false;
    }

    private boolean A18(C1829no c1829no, long j, C7A c7a) {
        if (!c1829no.equals(c7a.A00.A04)) {
            return false;
        }
        boolean z = c7a.A02;
        if (A0y[1].length() == 31) {
            throw new RuntimeException();
        }
        A0y[1] = "z9";
        if (z) {
            this.A0A.A03.A0J(this.A0A.A05.A04, this.A0c);
            int iA07 = this.A0c.A07(j);
            if (iA07 != -1) {
                long jA0D = this.A0c.A0D(iA07);
                C7B c7b = c7a.A00;
                if (A0y[5].charAt(1) == 'q') {
                    A0y[5] = "RcBDfVPYXZ1IWswHj8kiKJAUw6BsFYM7";
                    if (jA0D == c7b.A01) {
                        return true;
                    }
                    return false;
                }
                String[] strArr = A0y;
                strArr[4] = "w6QknFDGuvwfcqywG7nwGfdAAoNokq6y";
                strArr[3] = "I5j8Ais0ITqpKL2oROmKoI7QN1W2GqI7";
                if (jA0D == c7b.A01) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00b4  */
    @MetaExoPlayerCustomizations({@MetaExoPlayerCustomization("Customized Buffered Duration MS D23157182"), @MetaExoPlayerCustomization("D18870411: Adding start stall debug reason")})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean A19(boolean z) {
        boolean z2;
        long jA0C;
        if (this.A0W.length == 0) {
            return A15();
        }
        if (!z) {
            if (this.A0B != null) {
                this.A0E = this.A0B.A99();
            }
            return false;
        }
        if (!this.A0A.A0A) {
            return true;
        }
        C7A c7aA0E = this.A0j.A0E();
        if (c7aA0E.A0R()) {
            C7B c7b = c7aA0E.A00;
            if (A0y[7].charAt(12) == '2') {
                throw new RuntimeException();
            }
            A0y[5] = "JVFQROlQoWGuZTJ8G1Kf7NjovTqMHrup";
            z2 = c7b.A05;
        }
        if (!this.A0s || this.A0j.A0F() == this.A0j.A0E() || this.A0j.A0F() == null) {
            jA0C = c7aA0E.A0C(c7aA0E.A0D(this.A06));
        } else {
            jA0C = A03();
        }
        boolean z3 = z2 || this.A0i.AJy(jA0C, this.A0g.A8m().A01, this.A0R, this.A00 > 0 && (this.A04 > 0L ? 1 : (this.A04 == 0L ? 0 : -1)) > 0 && ((System.currentTimeMillis() - this.A04) > ((long) this.A00) ? 1 : ((System.currentTimeMillis() - this.A04) == ((long) this.A00) ? 0 : -1)) < 0, -9223372036854775807L);
        if (!z3) {
            this.A0E = EnumC1547ir.A04;
        }
        return z3;
    }

    public static C1981qI[] A1A(InterfaceC0464Eq interfaceC0464Eq) {
        int length = interfaceC0464Eq != null ? interfaceC0464Eq.length() : 0;
        C1981qI[] c1981qIArr = new C1981qI[length];
        for (int i = 0; i < length; i++) {
            c1981qIArr[i] = interfaceC0464Eq.A8B(i);
        }
        return c1981qIArr;
    }

    public final Looper A1B() {
        return this.A0b.getLooper();
    }

    /* JADX WARN: Incorrect condition in loop: B:9:0x0010 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void A1C() {
        if (this.A0S) {
            return;
        }
        this.A0f.AJA(7);
        boolean z = false;
        while (!wasInterrupted) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z = true;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public final void A1D(Timeline timeline, int i, long j) {
        this.A0f.ACj(3, new C02726n(timeline, i, j)).A02();
    }

    public final /* synthetic */ void A1E(C02887d c02887d) {
        try {
            A0h(c02887d);
        } catch (AD e) {
            Log.e(A0D(0, 21, 22), A0D(298, 55, 119), e);
            throw new RuntimeException(e);
        }
    }

    public final void A1F(InterfaceC0419Cx interfaceC0419Cx, boolean z, boolean z2) {
        this.A0f.ACi(0, z ? 1 : 0, z2 ? 1 : 0, interfaceC0419Cx).A02();
    }

    public final void A1G(boolean z) {
        this.A0f.ACh(1, z ? 1 : 0, 0).A02();
    }

    public final void A1H(boolean z) {
        this.A0f.ACh(6, z ? 1 : 0, 0).A02();
    }

    @Override // com.facebook.ads.redexgen.core.C6P
    public final void AFI(C1960px c1960px) {
        this.A0a.obtainMessage(1, c1960px).sendToTarget();
        A0T(c1960px.A01);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1831nq
    public final void AFS(InterfaceC1830np interfaceC1830np) {
        this.A0f.ACj(9, interfaceC1830np).A02();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0418Cw
    public final void AG1(InterfaceC0419Cx interfaceC0419Cx, Timeline timeline) {
        this.A0f.ACj(8, new C02696k(interfaceC0419Cx, timeline)).A02();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0469Ev
    public final void AGD() {
        this.A0f.AJA(11);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC02867b
    public final synchronized void AJC(C02887d c02887d) {
        if (this.A0S) {
            Log.w(A0D(0, 21, 22), A0D(50, 37, 39));
            c02887d.A0A(false);
        } else {
            this.A0f.ACj(14, c02887d).A02();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) throws Throwable {
        String strA0D = A0D(0, 21, 22);
        try {
        } catch (AD e) {
            Log.e(strA0D, A0D(110, 15, 65), e);
            A12(false, false);
            this.A0a.obtainMessage(2, e).sendToTarget();
            A0H();
        } catch (IOException e2) {
            Log.e(strA0D, A0D(195, 13, 40), e2);
            A12(false, false);
            this.A0a.obtainMessage(2, AD.A01(e2, 2000)).sendToTarget();
            A0H();
        } catch (RuntimeException e3) {
            Log.e(strA0D, A0D(87, 23, 19), e3);
            A12(false, false);
            this.A0a.obtainMessage(2, AD.A02(e3)).sendToTarget();
            A0H();
        }
        switch (message.what) {
            case 0:
                A0r((InterfaceC0419Cx) message.obj, message.arg1 != 0, message.arg2 != 0);
                A0H();
                return true;
            case 1:
                A0z(message.arg1 != 0);
                A0H();
                return true;
            case 2:
                A0F();
                A0H();
                return true;
            case 3:
                A0f((C02726n) message.obj);
                A0H();
                return true;
            case 4:
                A0b((C1960px) message.obj);
                A0H();
                return true;
            case 5:
                A0n((C03057u) message.obj);
                A0H();
                return true;
            case 6:
                A12(message.arg1 != 0, true);
                A0H();
                return true;
            case 7:
                A0K();
                return true;
            case 8:
                A0e((C02696k) message.obj);
                A0H();
                return true;
            case 9:
                A0p((InterfaceC1830np) message.obj);
                A0H();
                return true;
            case 10:
                A0o((InterfaceC1830np) message.obj);
                A0H();
                return true;
            case 11:
                A0L();
                A0H();
                return true;
            case 12:
                A0U(message.arg1);
                A0H();
                return true;
            case 13:
                A11(message.arg1 != 0);
                A0H();
                return true;
            case 14:
                A0i((C02887d) message.obj);
                A0H();
                return true;
            case 15:
                A0k((C02887d) message.obj);
                A0H();
                return true;
            case 16:
                A0H();
                return true;
            case 17:
                A0d(null, false);
                throw null;
            case 18:
                A0c(null);
                throw null;
            case 19:
                A0u((String) message.obj);
                A0H();
                return true;
            default:
                return false;
        }
    }
}
