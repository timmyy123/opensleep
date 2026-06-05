package com.facebook.ads.redexgen.core;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7P, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C7P extends AbstractC1475ha {
    public static TimeInterpolator A0B;
    public static String[] A0C = {"5", "w4FteHoxEZNBcBknXysU1QdwgOlgu", "XTfmSewcFvVIPqcU8HiF2JwhBroc2", "gTOT0dcLAsFp3JXaujmr6eSvv", "MioH3rC6822UBFONR3LUPujrkCbYq", "9Rk7JcSITmrZ17kamSQ7i6v9RKdnt", "plmSW6Ql", "PR6dCqey"};
    public ArrayList<RK> A0A = new ArrayList<>();
    public ArrayList<RK> A07 = new ArrayList<>();
    public ArrayList<C0754Qa> A09 = new ArrayList<>();
    public ArrayList<QZ> A08 = new ArrayList<>();
    public ArrayList<ArrayList<RK>> A01 = new ArrayList<>();
    public ArrayList<ArrayList<C0754Qa>> A05 = new ArrayList<>();
    public ArrayList<ArrayList<QZ>> A03 = new ArrayList<>();
    public ArrayList<RK> A00 = new ArrayList<>();
    public ArrayList<RK> A04 = new ArrayList<>();
    public ArrayList<RK> A06 = new ArrayList<>();
    public ArrayList<RK> A02 = new ArrayList<>();

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 9 out of bounds for length 9
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    @Override // com.facebook.ads.redexgen.core.AbstractC0777Qy
    public final void A0H() {
        int size;
        for (int size2 = this.A09.size() - 1; size2 >= 0; size2--) {
            C0754Qa c0754Qa = this.A09.get(size2);
            View view = c0754Qa.A04.A0H;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            A0U(c0754Qa.A04);
            this.A09.remove(size2);
        }
        for (int size3 = this.A0A.size() - 1; size3 >= 0; size3--) {
            A0V(this.A0A.get(size3));
            this.A0A.remove(size3);
        }
        for (int size4 = this.A07.size() - 1; size4 >= 0; size4--) {
            RK rk = this.A07.get(size4);
            rk.A0H.setAlpha(1.0f);
            A0T(rk);
            this.A07.remove(size4);
        }
        for (int size5 = this.A08.size() - 1; size5 >= 0; size5--) {
            ArrayList<QZ> arrayList = this.A08;
            String[] strArr = A0C;
            if (strArr[0].length() == strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0C;
            strArr2[4] = "IUveBZzBDFrSzC13ImzzVKkvQDdr2";
            strArr2[5] = "sCoWws78k8eiD0jPt8s7ggXNZv987";
            A00(arrayList.get(size5));
        }
        this.A08.clear();
        if (A0M()) {
            for (int size6 = this.A05.size() - 1; size6 >= 0; size6--) {
                ArrayList<C0754Qa> arrayList2 = this.A05.get(size6);
                for (int size7 = arrayList2.size() - 1; size7 >= 0; size7--) {
                    C0754Qa c0754Qa2 = arrayList2.get(size7);
                    View view2 = c0754Qa2.A04.A0H;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    A0U(c0754Qa2.A04);
                    arrayList2.remove(size7);
                    if (arrayList2.isEmpty()) {
                        this.A05.remove(arrayList2);
                    }
                }
            }
            for (int size8 = this.A01.size() - 1; size8 >= 0; size8--) {
                ArrayList<RK> arrayList3 = this.A01.get(size8);
                for (int size9 = arrayList3.size() - 1; size9 >= 0; size9--) {
                    RK rk2 = arrayList3.get(size9);
                    rk2.A0H.setAlpha(1.0f);
                    A0T(rk2);
                    arrayList3.remove(size9);
                    if (arrayList3.isEmpty()) {
                        ArrayList<ArrayList<RK>> arrayList4 = this.A01;
                        String[] strArr3 = A0C;
                        if (strArr3[0].length() != strArr3[3].length()) {
                            String[] strArr4 = A0C;
                            strArr4[7] = "VBPMrKBD";
                            strArr4[6] = "WZFlfD4M";
                            arrayList4.remove(arrayList3);
                        } else {
                            arrayList4.remove(arrayList3);
                        }
                    }
                }
            }
            ArrayList<ArrayList<QZ>> arrayList5 = this.A03;
            String[] strArr5 = A0C;
            if (strArr5[7].length() != strArr5[6].length()) {
                size = arrayList5.size() - 1;
            } else {
                String[] strArr6 = A0C;
                strArr6[2] = "1rfkrkAxI3SWkdgenr27gUX73o6p1";
                strArr6[1] = "SSeA7srmTqf1oxxrlzMYS1BTDHSjo";
                size = arrayList5.size() - 1;
            }
            while (size >= 0) {
                ArrayList<QZ> arrayList6 = this.A03.get(size);
                for (int size10 = arrayList6.size() - 1; size10 >= 0; size10--) {
                    A00(arrayList6.get(size10));
                    if (arrayList6.isEmpty()) {
                        this.A03.remove(arrayList6);
                    }
                }
                size--;
            }
            A03(this.A06);
            A03(this.A04);
            A03(this.A00);
            A03(this.A02);
            A0G();
        }
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.core.AbstractC1475ha
    public final boolean A0Z(RK rk, int i, int i2, int i3, int i4) {
        View view = rk.A0H;
        int translationX = i + ((int) rk.A0H.getTranslationX());
        int translationY = i2 + ((int) rk.A0H.getTranslationY());
        A02(rk);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            A0U(rk);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX(-i5);
        }
        if (i6 != 0) {
            view.setTranslationY(-i6);
        }
        this.A09.add(new C0754Qa(rk, translationX, translationY, i3, i4));
        return true;
    }

    private void A00(QZ qz) {
        if (qz.A05 != null) {
            A05(qz, qz.A05);
        }
        if (qz.A04 != null) {
            A05(qz, qz.A04);
        }
    }

    private void A01(RK rk) {
        View view = rk.A0H;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.A06.add(rk);
        ViewPropertyAnimator animation = viewPropertyAnimatorAnimate.setDuration(A0D());
        animation.alpha(0.0f).setListener(new QU(this, rk, viewPropertyAnimatorAnimate, view)).start();
    }

    private void A02(RK rk) {
        if (A0B == null) {
            A0B = new ValueAnimator().getInterpolator();
        }
        rk.A0H.animate().setInterpolator(A0B);
        A0L(rk);
    }

    private final void A03(List<RK> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).A0H.animate().cancel();
        }
    }

    private void A04(List<QZ> list, RK rk) {
        for (int size = list.size() - 1; size >= 0; size--) {
            QZ changeInfo = list.get(size);
            if (A05(changeInfo, rk) && changeInfo.A05 == null && changeInfo.A04 == null) {
                list.remove(changeInfo);
            }
        }
    }

    private boolean A05(QZ qz, RK rk) {
        boolean z = false;
        if (qz.A04 == rk) {
            qz.A04 = null;
        } else {
            RK rk2 = qz.A05;
            String[] strArr = A0C;
            if (strArr[2].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0C;
            strArr2[0] = "F";
            strArr2[3] = "q2hYYatvKRTsdUwOPBYP5pb4s";
            if (rk2 == rk) {
                qz.A05 = null;
                z = true;
            } else {
                return false;
            }
        }
        rk.A0H.setAlpha(1.0f);
        rk.A0H.setTranslationX(0.0f);
        rk.A0H.setTranslationY(0.0f);
        A0W(rk, z);
        return true;
    }

    /* JADX WARN: Incorrect condition in loop: B:10:0x0033 */
    @Override // com.facebook.ads.redexgen.core.AbstractC0777Qy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A0I() {
        boolean z = !this.A0A.isEmpty();
        boolean removalsPending = this.A09.isEmpty();
        boolean z2 = !removalsPending;
        boolean removalsPending2 = this.A08.isEmpty();
        boolean z3 = !removalsPending2;
        boolean removalsPending3 = this.A07.isEmpty();
        boolean z4 = !removalsPending3;
        if (!z && !z2 && !z4 && !z3) {
            return;
        }
        Iterator<RK> it = this.A0A.iterator();
        while (removalsPending) {
            A01(it.next());
        }
        this.A0A.clear();
        if (z2) {
            ArrayList<C0754Qa> arrayList = new ArrayList<>();
            arrayList.addAll(this.A09);
            this.A05.add(arrayList);
            this.A09.clear();
            QR qr = new QR(this, arrayList);
            if (z) {
                Ph.A0E(arrayList.get(0).A04.A0H, qr, A0D());
            } else {
                qr.run();
            }
        }
        if (z3) {
            ArrayList<QZ> arrayList2 = new ArrayList<>();
            arrayList2.addAll(this.A08);
            this.A03.add(arrayList2);
            this.A08.clear();
            QS qs = new QS(this, arrayList2);
            if (z) {
                Ph.A0E(arrayList2.get(0).A05.A0H, qs, A0D());
            } else {
                qs.run();
            }
        }
        if (z4) {
            ArrayList<RK> arrayList3 = new ArrayList<>();
            arrayList3.addAll(this.A07);
            this.A01.add(arrayList3);
            this.A07.clear();
            QT qt = new QT(this, arrayList3);
            if (z || z2 || z3) {
                Ph.A0E(arrayList3.get(0).A0H, qt, Math.max(z2 ? A0C() : 0L, z3 ? A0B() : 0L) + (z ? A0D() : 0L));
            } else {
                qt.run();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0777Qy
    public final void A0L(RK rk) {
        View view = rk.A0H;
        view.animate().cancel();
        for (int i = this.A09.size() - 1; i >= 0; i--) {
            if (this.A09.get(i).A04 == rk) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                A0U(rk);
                this.A09.remove(i);
            }
        }
        A04(this.A08, rk);
        if (this.A0A.remove(rk)) {
            view.setAlpha(1.0f);
            A0V(rk);
        }
        if (this.A07.remove(rk)) {
            view.setAlpha(1.0f);
            String[] strArr = A0C;
            if (strArr[2].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0C;
            strArr2[4] = "yxRUaByjpu2evyevZXzo5CX3I8dRP";
            strArr2[5] = "IuT2zeZcrCaCkdpAEhiSgQgKuQzMH";
            A0T(rk);
        }
        for (int i2 = this.A03.size() - 1; i2 >= 0; i2--) {
            ArrayList<QZ> arrayList = this.A03.get(i2);
            A04(arrayList, rk);
            if (arrayList.isEmpty()) {
                this.A03.remove(i2);
            }
        }
        for (int size = this.A05.size() - 1; size >= 0; size--) {
            ArrayList<C0754Qa> arrayList2 = this.A05.get(size);
            int i3 = arrayList2.size() - 1;
            while (true) {
                if (i3 < 0) {
                    break;
                }
                if (arrayList2.get(i3).A04 == rk) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    A0U(rk);
                    arrayList2.remove(i3);
                    if (arrayList2.isEmpty()) {
                        this.A05.remove(size);
                    }
                } else {
                    i3--;
                }
            }
        }
        for (int size2 = this.A01.size() - 1; size2 >= 0; size2--) {
            ArrayList<RK> arrayList3 = this.A01.get(size2);
            if (arrayList3.remove(rk)) {
                view.setAlpha(1.0f);
                A0T(rk);
                if (arrayList3.isEmpty()) {
                    this.A01.remove(size2);
                }
            }
        }
        this.A06.remove(rk);
        this.A00.remove(rk);
        this.A02.remove(rk);
        this.A04.remove(rk);
        A0b();
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0777Qy
    public final boolean A0M() {
        return (this.A07.isEmpty() && this.A08.isEmpty() && this.A09.isEmpty() && this.A0A.isEmpty() && this.A04.isEmpty() && this.A06.isEmpty() && this.A00.isEmpty() && this.A02.isEmpty() && this.A05.isEmpty() && this.A01.isEmpty() && this.A03.isEmpty()) ? false : true;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0777Qy
    public final boolean A0S(RK rk, List<Object> payloads) {
        return !payloads.isEmpty() || super.A0S(rk, payloads);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1475ha
    public final boolean A0X(RK rk) {
        A02(rk);
        rk.A0H.setAlpha(0.0f);
        this.A07.add(rk);
        return true;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1475ha
    public final boolean A0Y(RK rk) {
        A02(rk);
        this.A0A.add(rk);
        return true;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1475ha
    public final boolean A0a(RK rk, RK rk2, int i, int i2, int i3, int i4) {
        if (rk == rk2) {
            return A0Z(rk, i, i2, i3, i4);
        }
        float translationX = rk.A0H.getTranslationX();
        float translationY = rk.A0H.getTranslationY();
        float prevTranslationY = rk.A0H.getAlpha();
        A02(rk);
        float prevTranslationX = i3 - i;
        int deltaY = (int) (prevTranslationX - translationX);
        float prevTranslationX2 = i4 - i2;
        int deltaX = (int) (prevTranslationX2 - translationY);
        rk.A0H.setTranslationX(translationX);
        rk.A0H.setTranslationY(translationY);
        rk.A0H.setAlpha(prevTranslationY);
        if (rk2 != null) {
            A02(rk2);
            float prevTranslationX3 = -deltaY;
            rk2.A0H.setTranslationX(prevTranslationX3);
            float prevTranslationX4 = -deltaX;
            rk2.A0H.setTranslationY(prevTranslationX4);
            rk2.A0H.setAlpha(0.0f);
        }
        this.A08.add(new QZ(rk, rk2, i, i2, i3, i4));
        return true;
    }

    public final void A0b() {
        if (!A0M()) {
            A0G();
        }
    }

    public final void A0c(QZ qz) {
        View view;
        RK holder = qz.A05;
        if (holder == null) {
            view = null;
        } else {
            view = holder.A0H;
        }
        RK holder2 = qz.A04;
        View view2 = holder2 != null ? holder2.A0H : null;
        if (view != null) {
            ViewPropertyAnimator oldViewAnim = view.animate().setDuration(A0B());
            this.A02.add(qz.A05);
            oldViewAnim.translationX(qz.A02 - qz.A00);
            oldViewAnim.translationY(qz.A03 - qz.A01);
            oldViewAnim.alpha(0.0f).setListener(new QX(this, qz, oldViewAnim, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.A02.add(qz.A04);
            viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(A0B()).alpha(1.0f).setListener(new QY(this, qz, viewPropertyAnimatorAnimate, view2)).start();
        }
    }

    public final void A0d(RK rk) {
        View view = rk.A0H;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.A00.add(rk);
        ViewPropertyAnimator animation = viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(A0A());
        animation.setListener(new QV(this, rk, view, viewPropertyAnimatorAnimate)).start();
    }

    public final void A0e(RK rk, int i, int i2, int i3, int i4) {
        View view = rk.A0H;
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (i5 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i6 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.A04.add(rk);
        viewPropertyAnimatorAnimate.setDuration(A0C()).setListener(new QW(this, rk, i5, view, i6, viewPropertyAnimatorAnimate)).start();
    }
}
