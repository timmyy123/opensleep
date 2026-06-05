package com.facebook.ads.redexgen.core;

import android.widget.FrameLayout;
import com.facebook.ads.AdClosedListener;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC0984Zd extends FrameLayout {
    public static String[] A0E = {"5RNIIKEidNz4CxH4JgV5654XoKm2WCRJ", "1p9zA", "TyFhTVOKfwCiarLUW0", "qGg1KSsP6zNQFhXHIMmjZGXDOHal5qmq", "ysvkaelauuCqE6L7ICudiIGq1Ejo0wOd", "BlsqFJOSCgQfST", "dpiEaUs9Aor9er1WGZ", "tfv9H94"};
    public int A00;
    public AdClosedListener A01;
    public EnumC0713Oi A02;
    public C0714Oj A03;
    public C0715Ok A04;
    public InterfaceC0983Zc A05;
    public final C0711Og A06;
    public final C1421gi A07;
    public final VA A08;
    public final InterfaceC0962Yh A09;
    public final InterfaceC0963Yi A0A;
    public final String A0B;
    public final C0691Nm A0C;
    public final InterfaceC0986Zf A0D;

    public abstract void A0O();

    public abstract void A0P();

    public abstract void A0R(C0715Ok c0715Ok, EnumC0713Oi enumC0713Oi);

    public abstract boolean A0S();

    public AbstractC0984Zd(C1421gi c1421gi, VA va, String str) {
        this(c1421gi, va, str, null, null, null);
    }

    public AbstractC0984Zd(C1421gi c1421gi, VA va, String str, C0691Nm c0691Nm, InterfaceC0963Yi interfaceC0963Yi, InterfaceC0962Yh interfaceC0962Yh) {
        super(c1421gi);
        this.A00 = 0;
        this.A02 = EnumC0713Oi.A05;
        this.A04 = null;
        this.A0D = new MF(this);
        this.A07 = c1421gi;
        this.A08 = va;
        this.A0A = interfaceC0963Yi;
        this.A09 = interfaceC0962Yh;
        this.A0B = str;
        this.A0C = c0691Nm;
        this.A06 = AbstractC0712Oh.A00(this.A07.A02());
    }

    public static /* synthetic */ int A02(AbstractC0984Zd abstractC0984Zd) {
        int i = abstractC0984Zd.A00;
        abstractC0984Zd.A00 = i + 1;
        return i;
    }

    public static /* synthetic */ int A03(AbstractC0984Zd abstractC0984Zd) {
        int i = abstractC0984Zd.A00;
        abstractC0984Zd.A00 = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0E() {
        if (this.A03.A0A()) {
            this.A08.AB3(this.A0B, this.A03.A02());
            this.A03.A03();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0F() {
        this.A04 = null;
        this.A03.A05();
        A0O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0G(C0715Ok c0715Ok) {
        this.A03.A08(this.A02);
        A0Q(c0715Ok, this.A02);
        N8.A01(this.A07).A0L();
        if (A0S()) {
            A0E();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0H(C0715Ok c0715Ok) {
        this.A04 = c0715Ok;
        this.A03.A09(this.A02, this.A00);
        A0R(c0715Ok, this.A02);
    }

    public final void A0M() {
        A0E();
    }

    public final void A0N() {
        this.A03 = new C0714Oj(new VI(this.A0B, this.A08));
        if (this.A0A != null) {
            InterfaceC0963Yi interfaceC0963Yi = this.A0A;
            if (A0E[0].charAt(22) == 'O') {
                throw new RuntimeException();
            }
            A0E[7] = "FLAi4P2";
            interfaceC0963Yi.AFA(true);
        }
        if (this.A05 != null) {
            this.A05.ACs();
        }
        A0F();
    }

    public void A0Q(C0715Ok c0715Ok, EnumC0713Oi enumC0713Oi) {
        if (this.A01 != null) {
            this.A07.A0F().ABV();
            this.A01.onAdClosed();
        }
    }

    public void setAdReportingCallbackListener(InterfaceC0983Zc interfaceC0983Zc) {
        this.A05 = interfaceC0983Zc;
    }

    public void setOnAdClosedListener(AdClosedListener adClosedListener) {
        this.A01 = adClosedListener;
    }
}
