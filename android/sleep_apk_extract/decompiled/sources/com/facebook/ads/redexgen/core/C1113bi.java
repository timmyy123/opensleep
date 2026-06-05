package com.facebook.ads.redexgen.core;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.facebook.ads.RewardData;
import com.philips.lighting.hue.sdk.utilities.impl.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1113bi extends FrameLayout {
    public static String[] A08 = {"Q8PK8a4jCXFMgXydViX", "2t", "0mtDJDWqZSrfiocTEOLDLA", "JwyFxt7bdt7eCUIm0ln", "fPboxvDBMmOISakSS", "MBnzPw5d2FxZEvBrnzM1TlMBrMh4WSuO", "jLpHRmCuYtO7UfmYbZzhe3ed5a74x24O", "3APcS373YHqcuLzV9G"};
    public AbstractC0956Yb A00;
    public Z3 A01;
    public final AbstractC1586jd A02;
    public final C1421gi A03;
    public final InterfaceC0962Yh A04;
    public final InterfaceC1112bh A05;
    public final C0458Ek A06;
    public final List<View> A07;

    public C1113bi(C1138c7 c1138c7, AbstractC1586jd abstractC1586jd, C0458Ek c0458Ek, DZ dz, AbstractC1084bF abstractC1084bF, InterfaceC0962Yh interfaceC0962Yh, InterfaceC1112bh interfaceC1112bh) {
        this(c1138c7, abstractC1586jd, c0458Ek, interfaceC0962Yh, interfaceC1112bh, dz, abstractC1084bF);
    }

    public C1113bi(C1138c7 c1138c7, AbstractC1586jd abstractC1586jd, C0458Ek c0458Ek, InterfaceC0962Yh interfaceC0962Yh, InterfaceC1112bh interfaceC1112bh, View... viewArr) {
        this(c1138c7.A06(), c1138c7.A0B(), abstractC1586jd, c0458Ek, interfaceC0962Yh, interfaceC1112bh, viewArr);
    }

    public C1113bi(C1421gi c1421gi, AbstractC0956Yb abstractC0956Yb, AbstractC1586jd abstractC1586jd, C0458Ek c0458Ek, InterfaceC0962Yh interfaceC0962Yh, InterfaceC1112bh interfaceC1112bh, View... viewArr) {
        super(c1421gi);
        this.A07 = new ArrayList();
        this.A03 = c1421gi;
        this.A00 = abstractC0956Yb;
        this.A02 = abstractC1586jd;
        for (View view : viewArr) {
            if (view != null) {
                this.A07.add(view);
            }
        }
        this.A04 = interfaceC0962Yh;
        this.A06 = c0458Ek;
        this.A05 = interfaceC1112bh;
        A04();
    }

    private void A04() {
        String strA06;
        RewardData rewardDataA0s = this.A02.A0s();
        if (rewardDataA0s == null) {
            strA06 = this.A02.A2B().A05();
        } else {
            strA06 = this.A02.A2B().A06(rewardDataA0s.getCurrency(), rewardDataA0s.getQuantity());
        }
        this.A01 = new Z3(this.A03, -1, Color.BLACK, strA06, null, this.A02.A2B().A04(), this.A02.A2B().A03(), YN.A01(YM.REWARD_ICON));
        this.A01.A02.setOnClickListener(new ViewOnClickListenerC1110bf(this));
        this.A01.A01.setOnClickListener(new ViewOnClickListenerC1111bg(this));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        addView(this.A01, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A05() {
        if (this.A06 != null) {
            this.A06.A0d(EnumC1300el.A07);
        }
        this.A05.ACt();
        if (!this.A02.A29().A0V()) {
            this.A02.A2H(this.A04);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0024 A[EDGE_INSN: B:23:0x0024->B:8:0x0024 BREAK  A[LOOP:0: B:15:0x004d->B:20:0x0074], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A07(ViewGroup viewGroup) {
        Iterator<View> it;
        String[] strArr;
        if (this.A06 != null && !this.A06.A0o()) {
            C0458Ek c0458Ek = this.A06;
            String[] strArr2 = A08;
            if (strArr2[0].length() == strArr2[3].length()) {
                String[] strArr3 = A08;
                strArr3[4] = "1Ran1dt8ESvXQPCOL";
                strArr3[1] = "wn";
                c0458Ek.A0j(false, false, 11);
                YB.A0O(this.A06, 4);
                if (this.A00 != null) {
                }
                it = this.A07.iterator();
                while (true) {
                    boolean zHasNext = it.hasNext();
                    strArr = A08;
                    if (strArr[5].charAt(31) == strArr[6].charAt(31)) {
                    }
                    View next = it.next();
                    next.clearAnimation();
                    YB.A0O(next, 4);
                }
            }
        } else {
            if (this.A00 != null) {
                YB.A0H(this.A00);
            }
            it = this.A07.iterator();
            while (true) {
                boolean zHasNext2 = it.hasNext();
                strArr = A08;
                if (strArr[5].charAt(31) == strArr[6].charAt(31)) {
                    break;
                }
                String[] strArr4 = A08;
                strArr4[0] = "6LHnkwVNW3v3BurcJpp";
                strArr4[3] = "pBsoAnuzgJgS4JAM4BB";
                if (zHasNext2) {
                    View next2 = it.next();
                    next2.clearAnimation();
                    YB.A0O(next2, 4);
                } else {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    viewGroup.addView(this, layoutParams);
                    this.A05.AEn();
                    return;
                }
            }
        }
        throw new RuntimeException();
    }
}
