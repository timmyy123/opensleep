package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.ads.DefaultMediaViewVideoRenderer;
import com.facebook.ads.MediaView;
import com.facebook.ads.MediaViewListener;
import com.facebook.ads.MediaViewVideoRenderer;
import com.facebook.ads.NativeAd;
import com.facebook.ads.internal.api.AdComponentView;
import com.facebook.ads.internal.api.AdComponentViewApi;
import com.facebook.ads.internal.api.AdComponentViewParentApi;
import com.facebook.ads.internal.api.AdViewConstructorParams;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.api.MediaViewApi;
import com.facebook.ads.internal.api.NativeAdBaseApi;
import com.facebook.ads.internal.context.Repairable;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.philips.lighting.hue.sdk.utilities.impl.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hC, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1451hC extends C0791Rm implements MediaViewApi, Repairable, T4, InterfaceC0983Zc {
    public static byte[] A0L;
    public static String[] A0M = {"opPNeHLRCwNMjghH70VvpS5N8kNNBiJu", "eEOY2RUjN4bpbDsCyz0GPhNNbfKnjNLD", "VFQc0pqb8IELGhnpfLoj2hUSBo2VhTCu", "GBUHck22", "gxS7cL5mKFosIlCCzwl1gr8LaZQoy", "JvRhV7isjcFk5", "Q8NK4BrUIZ6kI5bk", "yT7QEu4e"};
    public static final String A0N;
    public View A02;
    public View A03;
    public ImageView A04;
    public ImageView A05;
    public RelativeLayout A06;
    public MediaView A07;
    public MediaViewListener A08;
    public MediaViewVideoRenderer A09;
    public AdComponentViewParentApi A0A;
    public C1421gi A0C;
    public XO A0D;
    public C0x A0E;
    public C1074b5 A0F;
    public C1102bX A0G;
    public AnonymousClass62 A0H;
    public C1269eF A0I;
    public boolean A0J;
    public boolean A0K;
    public EnumC0800Rv A0B = EnumC0800Rv.A04;
    public int A01 = 0;
    public int A00 = 0;

    public static String A05(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0L, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A0M;
            if (strArr[6].length() == strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0M;
            strArr2[6] = "ck5ggAbj2vioxfDq";
            strArr2[4] = "NneLGMvrJ83sFMBsADIKrHrKRcoTv";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 74);
            i4++;
        }
    }

    public static void A0C() {
        A0L = new byte[]{-61, -31, -14, -17, -11, -13, -27, -20, -96, -14, -27, -18, -28, -27, -14, -27, -14, -96, -19, -11, -13, -12, -96, -30, -27, -96, -13, -27, -12, -96, -30, -27, -26, -17, -14, -27, -96, -18, -31, -12, -23, -10, -27, -63, -28, -82, 9, 5, 4, 56, 39, 44, 40, 49, 38, 40, 17, 40, 55, 58, 50, 53, 46, -52, -16, -28, -22, -24, -93, -11, -24, -15, -25, -24, -11, -24, -11, -93, -16, -8, -10, -9, -93, -27, -24, -93, -10, -24, -9, -93, -27, -24, -23, -14, -11, -24, -93, -15, -28, -9, -20, -7, -24, -60, -25, -79, -7, 29, 17, 23, 21, -48, 34, 21, 30, 20, 21, 34, 21, 34, -48, 29, 37, 35, 36, -48, 18, 21, -48, 35, 21, 36, -48, 18, 21, 22, 31, 34, 21, -48, 30, 17, 36, 25, 38, 21, -14, 17, 30, 30, 21, 34, -15, 20, -34, -83, -46, -38, -59, -48, -51, -56, -124, -70, -51, -55, -37, -124, -57, -45, -46, -41, -40, -42, -39, -57, -40, -45, -42, -124, -44, -59, -42, -59, -47, -41, -124, -40, -35, -44, -55, -110, -62, -43, -24, -35, -22, -39, -108, -75, -40, -108, -67, -41, -29, -30, -108, -35, -25, -108, -30, -23, -32, -32, -94, -26, -7, -12, -11, -1, -80, 2, -11, -2, -12, -11, 2, -11, 2, -80, -3, 5, 3, 4, -80, -14, -11, -80, 3, -11, 4, -80, -14, -11, -10, -1, 2, -11, -80, -2, -15, 4, -7, 6, -11, -47, -12, -66, -41, -26, -33, -70, -58, -60, -123, -67, -72, -70, -68, -71, -58, -58, -62, -123, -72, -69, -54, -123, -59, -72, -53, -64, -51, -68, -123, -70, -61, -64, -70, -62, -68, -69, -15, -28, -33, -32, -22, -48, -19, -25, -72};
    }

    static {
        A0C();
        A0N = MediaView.class.getSimpleName();
    }

    private void A06() {
        this.A0C.A0F().ABd();
        this.A0G = new C1102bX(this.A0C, false);
        this.A0G.setImagePadding(XV.A0A);
        this.A0G.setImage(YM.FILL_CLOSE);
        this.A0G.A03(0, Color.GRAY, 0, false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(XV.A0G, XV.A0G);
        layoutParams.addRule(11);
        layoutParams.addRule(6, this.A02.getId());
        layoutParams.setMargins(XV.A00, XV.A0U, XV.A0U, XV.A00);
        A0D(this.A0G, layoutParams);
        this.A0A.bringChildToFront(this.A0G);
    }

    private void A07() {
        if (this.A0H != null) {
            this.A0H.setVisibility(8);
            Ph.A0A(this.A0H.getDynamicWebViewController().A0O(), new ColorDrawable(0));
            this.A07.removeView(this.A0H);
            this.A0H = null;
        }
    }

    private void A08() {
        if (this.A0D != null && !this.A0D.A04()) {
            this.A0D.A06();
        }
    }

    private void A09() {
        if (this.A0D != null && !this.A0D.A04()) {
            this.A0D.A07();
        }
    }

    private void A0A() {
        if (!this.A0K) {
            if (this.A03 != null) {
                YB.A0J(this.A0E);
            }
            float f = XX.A02;
            float density = 4.0f * f;
            int hPadding = Math.round(density);
            float density2 = 12.0f * f;
            int vPadding = Math.round(density2);
            this.A0E.setChildSpacing(hPadding);
            this.A0E.setPadding(0, vPadding, 0, vPadding);
            this.A0E.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.A03 = this.A0E;
            this.A07.addView(this.A03, layoutParams);
            return;
        }
        throw new IllegalStateException(A05(0, 46, 54));
    }

    private void A0B() {
        EnumC0931Xc.A04(this.A07, EnumC0931Xc.A0B);
        EnumC0931Xc.A04(this.A0F, EnumC0931Xc.A0B);
        EnumC0931Xc.A04(this.A09, EnumC0931Xc.A0B);
        EnumC0931Xc.A04(this.A03, EnumC0931Xc.A0B);
    }

    private final void A0D(View view, ViewGroup.LayoutParams layoutParams) {
        A01(false);
        this.A07.addView(view, layoutParams);
        A01(true);
    }

    private void A0E(View view, UK uk) {
        if (this.A0I != null) {
            this.A07.removeView(this.A0I);
        }
        if (!uk.A1t()) {
            return;
        }
        String strA1I = uk.A1I();
        if (this.A07.getContext() == null) {
            return;
        }
        this.A0I = AbstractC1268eE.A01(this.A0C, strA1I);
        if (this.A0I != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(5, view.getId());
            layoutParams.addRule(7, view.getId());
            layoutParams.addRule(6, view.getId());
            layoutParams.addRule(8, view.getId());
            layoutParams.addRule(16, view.getId());
            layoutParams.addRule(17, view.getId());
            A0D(this.A0I, layoutParams);
            this.A0A.bringChildToFront(this.A0I);
        }
    }

    private void A0F(ImageView imageView) {
        if (!this.A0K) {
            ImageView imageView2 = this.A04;
            if (A0M[5].length() != 13) {
                throw new RuntimeException();
            }
            A0M[1] = "0pGJtKTiEG7M1QZmgSqLESVqtH6XSoGw";
            if (imageView2 != null) {
                YB.A0J(this.A04);
            }
            imageView.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.A07.addView(imageView, layoutParams);
            imageView.setId(YB.A00());
            this.A04 = imageView;
            return;
        }
        throw new IllegalStateException(A05(106, 49, 102));
    }

    private final void A0G(C1421gi c1421gi, AttributeSet attributeSet, int i, int i2, MediaView mediaView) {
        this.A07 = mediaView;
        A0F(new ImageView(c1421gi, attributeSet, i, i2));
        A0S(new C1074b5(c1421gi, attributeSet, i, i2));
        this.A0E = new C0x(c1421gi, attributeSet, i);
        A0A();
        setVideoRenderer(new DefaultMediaViewVideoRenderer(c1421gi, attributeSet, i, i2));
        A0B();
    }

    private final void A0H(C1421gi c1421gi, AttributeSet attributeSet, int i, MediaView mediaView) {
        this.A07 = mediaView;
        A0F(new ImageView(c1421gi, attributeSet, i));
        A0S(new C1074b5(c1421gi, attributeSet, i));
        this.A0E = new C0x(c1421gi, attributeSet, i);
        A0A();
        setVideoRenderer(new DefaultMediaViewVideoRenderer(c1421gi, attributeSet, i));
        A0B();
    }

    private final void A0I(C1421gi c1421gi, AttributeSet attributeSet, MediaView mediaView) {
        this.A07 = mediaView;
        A0F(new ImageView(c1421gi, attributeSet));
        A0S(new C1074b5(c1421gi, attributeSet));
        this.A0E = new C0x(c1421gi, attributeSet);
        A0A();
        setVideoRenderer(new DefaultMediaViewVideoRenderer(c1421gi, attributeSet));
        A0B();
    }

    private final void A0J(C1421gi c1421gi, MediaView mediaView) {
        this.A07 = mediaView;
        A0F(new ImageView(c1421gi));
        A0S(new C1074b5(c1421gi));
        this.A0E = new C0x(c1421gi);
        A0A();
        setVideoRenderer(new DefaultMediaViewVideoRenderer(c1421gi));
        A0B();
    }

    private void A0K(UK uk) {
        uk.A1j(this);
    }

    private void A0L(final UK uk) {
        if (this.A0G != null) {
            this.A0G.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.ads.redexgen.X.Rw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.A00.A0Z(uk, view);
                }
            });
        }
    }

    private void A0M(UK uk) {
        if (this.A0D != null) {
            this.A0D.A06();
            this.A0D = null;
        }
        if (this.A0G != null) {
            this.A07.removeView(this.A0G);
            this.A0G = null;
        }
        if (uk.A1q()) {
            A06();
            A0L(uk);
            A0P(uk);
            A0K(uk);
        }
    }

    private void A0N(UK uk) {
        this.A00 = 0;
        if (this.A05 != null) {
            this.A07.removeView(this.A05);
            String[] strArr = A0M;
            if (strArr[2].charAt(31) != strArr[0].charAt(31)) {
                throw new RuntimeException();
            }
            A0M[5] = "SLqcyKPzacI72";
            this.A05 = null;
        }
        if (uk.A1r()) {
            this.A0C.A0F().ABe();
            this.A05 = new ImageView(this.A0C);
            this.A05.setImageBitmap(YN.A01(YM.FILL_CLOSE));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(XV.A0G, XV.A0G);
            layoutParams.addRule(11);
            layoutParams.addRule(6, this.A02.getId());
            layoutParams.setMargins(XV.A00, XV.A0U, XV.A0U, XV.A00);
            A0D(this.A05, layoutParams);
            this.A0A.bringChildToFront(this.A05);
            A0O(uk);
        }
    }

    private void A0O(final UK uk) {
        if (this.A05 != null) {
            this.A05.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.ads.redexgen.X.Rx
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.A00.A0a(uk, view);
                }
            });
        }
    }

    private void A0P(UK uk) {
        if (this.A0G != null) {
            int iA0y = uk.A0y();
            this.A0D = new XO(iA0y, new C1452hD(this, iA0y));
            this.A0D.A07();
        }
    }

    private void A0Q(final UK uk, boolean z) {
        if (this.A06 != null) {
            this.A07.removeView(this.A06);
            if (A0M[5].length() != 13) {
                throw new RuntimeException();
            }
            A0M[5] = "ljpGBw4ulgnIo";
            this.A06 = null;
        }
        if (uk.A13() != null && uk.A13().A2U()) {
            this.A06 = new RelativeLayout(this.A0C);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            if (z) {
                layoutParams.addRule(10);
            } else {
                layoutParams.addRule(12);
                layoutParams.addRule(21);
            }
            C1012a5 c1012a5 = new C1012a5(this.A0C, EnumC1029aM.A05);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            if (z) {
                layoutParams2.setMargins(XV.A0A, XV.A0A, XV.A00, XV.A00);
            } else {
                int i = XV.A00;
                String[] strArr = A0M;
                if (strArr[6].length() == strArr[4].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0M;
                strArr2[2] = "wMv0uQjYnC0gE49Cu2XgtVhibZPJIfwu";
                strArr2[0] = "eHWX3hnc2MQEr3W9NzLO2AooGOj1mFxu";
                layoutParams2.setMargins(i, XV.A00, XV.A0U, XV.A0U);
            }
            this.A06.addView(c1012a5, layoutParams2);
            c1012a5.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.ads.redexgen.X.Ry
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.A00.A0Y(uk, view);
                }
            });
            A0D(this.A06, layoutParams);
            this.A0A.bringChildToFront(this.A06);
        }
    }

    private void A0R(UK uk, boolean z, C0883Vb c0883Vb) {
        LM lmA04 = new LM(this.A04, this.A0C).A04();
        if (z) {
            lmA04.A06(new C1459hK(this, uk));
        }
        lmA04.A07(c0883Vb.getUrl());
    }

    private void A0S(C1074b5 c1074b5) {
        if (!this.A0K) {
            if (this.A0F != null) {
                this.A07.removeView(this.A0F);
            }
            c1074b5.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.A07.addView(c1074b5, layoutParams);
            this.A0F = c1074b5;
            return;
        }
        throw new IllegalStateException(A05(63, 43, 57));
    }

    private boolean A0T(NativeAd nativeAd) {
        List<NativeAd> carousel = ((S2) nativeAd.getNativeAdApi()).A04();
        if (carousel == null) {
            return false;
        }
        Iterator<NativeAd> it = carousel.iterator();
        while (it.hasNext()) {
            if (it.next().getAdCoverImage() == null) {
                return false;
            }
        }
        if (A0M[5].length() != 13) {
            throw new RuntimeException();
        }
        String[] strArr = A0M;
        strArr[6] = "NNKiamhSotpSBh0S";
        strArr[4] = "WQowSckFUFZtjqKDGN1yGWQ8HKryj";
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0U(NativeAd nativeAd) {
        return !TextUtils.isEmpty(((S2) nativeAd.getNativeAdApi()).A03());
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x034b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A0W(NativeAd nativeAd) {
        AbstractC1587je abstractC1587je;
        ViewParent parent;
        C1421gi adObjectContext = ((UK) nativeAd.getInternalNativeAd()).A16();
        adObjectContext.A0O(this);
        this.A0C.A0L(adObjectContext);
        this.A0C.A0K(adObjectContext.A0F());
        this.A0K = true;
        UK ukA0L = UK.A0L(nativeAd.getInternalNativeAd());
        ukA0L.A1a(this.A07);
        this.A04.setVisibility(8);
        this.A04.setImageDrawable(null);
        if (ukA0L.A13() != null && ukA0L.A13().A1g()) {
            if (!TextUtils.isEmpty(ukA0L.A13().A29().A0H().A09())) {
                this.A0B = EnumC0800Rv.A05;
                ukA0L.A16().A0F().AJt(M5.A0A);
            } else {
                this.A0B = EnumC0800Rv.A03;
                ukA0L.A16().A0F().AJt(M5.A09);
            }
            A07();
            this.A0F.setVisibility(8);
            this.A0F.setImage(null, null);
            this.A09.setVisibility(8);
            this.A09.unsetNativeAd();
            ((C0804Rz) this.A09.getMediaViewVideoRendererApi()).A03();
            if (this.A03 != null) {
                this.A03.setVisibility(8);
                if (this.A03 instanceof C1065aw) {
                    ((C1065aw) this.A03).A04();
                } else {
                    ((C7M) this.A03).setAdapter(null);
                }
            }
            A01(false);
            this.A0H = new AnonymousClass62(this.A0C, this.A0C.A0A(), new C1457hI(this, ukA0L, nativeAd), ukA0L.A13(), A05(261, 31, 13), 4, ukA0L.A1E());
            EnumC0931Xc.A04(this.A0H, EnumC0931Xc.A0B);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(13);
            this.A07.addView(this.A0H, layoutParams);
            this.A02 = this.A0H;
            bringChildToFront(this.A0H);
            this.A0H.setVisibility(0);
            A0E(this.A0H, ukA0L);
            A01(true);
        } else if (A0T(nativeAd)) {
            this.A0B = EnumC0800Rv.A02;
            ukA0L.A16().A0F().AJt(M5.A04);
            boolean z = ukA0L.A1C() == EnumC0886Ve.A0B;
            if (!C0871Up.A2v(this.A0C) || z) {
                this.A03 = this.A0E;
                ((C0x) this.A03).setCurrentPosition(0);
                ((C0x) this.A03).setShowTextInCarousel(z);
                if (z) {
                    final C1421gi c1421gi = this.A0C;
                    final C0x c0x = (C0x) this.A03;
                    final List<UK> listA1N = ukA0L.A1N();
                    final C0885Vd c0885VdA1B = ukA0L.A1B();
                    abstractC1587je = new AbstractC1587je(c1421gi, c0x, listA1N, c0885VdA1B) { // from class: com.facebook.ads.redexgen.X.7r
                        public final C1421gi A00;
                        public final C0885Vd A01;

                        {
                            super(c0x, listA1N, c1421gi);
                            this.A00 = c1421gi;
                            this.A01 = c0885VdA1B == null ? new C0885Vd() : c0885VdA1B;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        @Override // com.facebook.ads.redexgen.core.AbstractC0769Qq
                        /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
                        public final PX A0F(ViewGroup viewGroup, int i) {
                            return new PX(new C0968Yn(this.A00, this.A01));
                        }

                        @Override // com.facebook.ads.redexgen.core.AbstractC0769Qq
                        /* JADX INFO: renamed from: A0Q */
                        public final void A0K(PX px, int i) {
                            super.A0K(px, i);
                            C0968Yn c0968Yn = (C0968Yn) px.A0p();
                            A0O(c0968Yn.getImageCardView(), i);
                            if (((AbstractC1587je) this).A01.get(i) != null) {
                                c0968Yn.setTitle(((AbstractC1587je) this).A01.get(i).getAdHeadline());
                                c0968Yn.setSubtitle(((AbstractC1587je) this).A01.get(i).getAdLinkDescription());
                                c0968Yn.setButtonText(((AbstractC1587je) this).A01.get(i).getAdCallToAction());
                            }
                            UK uk = ((AbstractC1587je) this).A01.get(i);
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(c0968Yn);
                            uk.A1V(c0968Yn, c0968Yn, arrayList);
                        }
                    };
                } else {
                    final C0x c0x2 = (C0x) this.A03;
                    final List<UK> listA1N2 = ukA0L.A1N();
                    final C1421gi c1421gi2 = this.A0C;
                    abstractC1587je = new AbstractC1587je(c0x2, listA1N2, c1421gi2) { // from class: com.facebook.ads.redexgen.X.7q
                        public final C1421gi A00;

                        {
                            this.A00 = c1421gi2;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        @Override // com.facebook.ads.redexgen.core.AbstractC0769Qq
                        /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
                        public final PX A0F(ViewGroup viewGroup, int i) {
                            return new PX(new C0974Yt(this.A00));
                        }

                        @Override // com.facebook.ads.redexgen.core.AbstractC0769Qq
                        /* JADX INFO: renamed from: A0Q, reason: merged with bridge method [inline-methods] */
                        public final void A0K(PX px, int i) {
                            super.A0K(px, i);
                            C0974Yt c0974Yt = (C0974Yt) px.A0p();
                            ZI imageView = (ZI) c0974Yt.getImageCardView();
                            imageView.setImageDrawable(null);
                            A0O(imageView, i);
                            UK childAd = ((AbstractC1587je) this).A01.get(i);
                            childAd.A16().A0L(this.A00);
                            childAd.A1U(c0974Yt, c0974Yt);
                        }
                    };
                }
                abstractC1587je.A0P(new C1456hH(this, ukA0L));
                ((C7M) this.A03).setAdapter(abstractC1587je);
            } else {
                A01(false);
                int width = this.A07.getWidth();
                if (width == 0) {
                    if (this.A07.getParent() instanceof ViewGroup) {
                        parent = this.A07.getParent();
                    } else {
                        parent = null;
                    }
                    ViewGroup viewGroup = (ViewGroup) parent;
                    while (width == 0 && viewGroup != null) {
                        width = viewGroup.getWidth();
                        boolean z2 = viewGroup.getParent() instanceof ViewGroup;
                        String[] strArr = A0M;
                        if (strArr[2].charAt(31) != strArr[0].charAt(31)) {
                            throw new RuntimeException();
                        }
                        String[] strArr2 = A0M;
                        strArr2[6] = "X2xGJjQ8zu6cU8Eo";
                        strArr2[4] = "AZj2zr3QMe0wQwV9kynIxRcnRDB4X";
                        viewGroup = (ViewGroup) (z2 ? viewGroup.getParent() : null);
                    }
                }
                YB.A0J(this.A03);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams2.addRule(13);
                this.A03 = new C1065aw(this.A0C);
                this.A07.addView(this.A03, layoutParams2);
                ((C1065aw) this.A03).A05(ukA0L, width);
                YB.A0K(this.A03);
                A01(true);
            }
            this.A02 = this.A03;
            A07();
            this.A0F.setVisibility(8);
            this.A0F.setImage(null, null);
            this.A09.setVisibility(8);
            this.A09.unsetNativeAd();
            ((C0804Rz) this.A09.getMediaViewVideoRendererApi()).A03();
            bringChildToFront(this.A03);
            this.A03.setVisibility(0);
            A0E(this.A03, ukA0L);
        } else {
            boolean zA0U = A0U(nativeAd);
            String[] strArr3 = A0M;
            if (strArr3[3].length() != strArr3[7].length()) {
                throw new RuntimeException();
            }
            A0M[5] = "QrlGDx1qLp0kN";
            if (zA0U) {
                this.A0B = EnumC0800Rv.A05;
                this.A01 = ((S2) nativeAd.getNativeAdApi()).A01();
                ukA0L.A16().A0F().AJt(M5.A0D);
                ukA0L.A1n(this.A0J);
                this.A02 = this.A09.getMediaViewVideoRendererApi().getVideoView();
                A07();
                this.A0F.setVisibility(8);
                this.A0F.setImage(null, null);
                if (this.A03 != null) {
                    this.A03.setVisibility(8);
                    if (this.A03 instanceof C1065aw) {
                        ((C1065aw) this.A03).A04();
                    } else {
                        ((C7M) this.A03).setAdapter(null);
                    }
                }
                bringChildToFront(this.A09);
                MediaViewVideoRenderer mediaViewVideoRenderer = this.A09;
                String[] strArr4 = A0M;
                if (strArr4[2].charAt(31) != strArr4[0].charAt(31)) {
                    String[] strArr5 = A0M;
                    strArr5[2] = "KRt7yuKunmEFowe58PEdTHnfFAzQvUNu";
                    strArr5[0] = "FpiuEPXAVB8biFGx18DJjcPDa6TrT1Ju";
                    mediaViewVideoRenderer.setNativeAd(nativeAd);
                    ((C0804Rz) this.A09.getMediaViewVideoRendererApi()).A04(nativeAd);
                    this.A09.setVisibility(0);
                    if (ukA0L.getAdCoverImage() != null) {
                        new LM(this.A07, this.A0C).A05(this.A07.getHeight(), this.A07.getWidth()).A06(new C1455hG(this, ukA0L)).A07(ukA0L.getAdCoverImage().getUrl());
                    }
                    if (BuildConfigApi.isDebug()) {
                        Log.i(A0N, A05(292, 9, 49) + ((S2) nativeAd.getNativeAdApi()).A03());
                    }
                    A0E(this.A09, ukA0L);
                } else {
                    String[] strArr6 = A0M;
                    strArr6[6] = "rknJE6EzKshvoL3E";
                    strArr6[4] = "1VlRGSe6v9ZgAEzaXTE4MJVCDSD8V";
                    mediaViewVideoRenderer.setNativeAd(nativeAd);
                    ((C0804Rz) this.A09.getMediaViewVideoRendererApi()).A04(nativeAd);
                    this.A09.setVisibility(0);
                    if (ukA0L.getAdCoverImage() != null) {
                    }
                    if (BuildConfigApi.isDebug()) {
                    }
                    A0E(this.A09, ukA0L);
                }
            } else if (nativeAd.getAdCoverImage() != null) {
                this.A0B = EnumC0800Rv.A03;
                ukA0L.A16().A0F().AJt(M5.A0B);
                this.A02 = this.A0F.getBodyImageView();
                A07();
                this.A09.setVisibility(8);
                this.A09.unsetNativeAd();
                ((C0804Rz) this.A09.getMediaViewVideoRendererApi()).A03();
                if (this.A03 != null) {
                    this.A03.setVisibility(8);
                    if (this.A03 instanceof C1065aw) {
                        ((C1065aw) this.A03).A04();
                    } else {
                        ((C7M) this.A03).setAdapter(null);
                    }
                }
                bringChildToFront(this.A0F);
                this.A0F.setVisibility(0);
                new LM(this.A0F, this.A0C).A05(this.A07.getHeight(), this.A07.getWidth()).A06(new C1454hF(this, ukA0L)).A07(ukA0L.getAdCoverImage().getUrl());
                A0E(this.A0F, ukA0L);
            }
        }
        A0Q(ukA0L, false);
        A0M(ukA0L);
        A0N(ukA0L);
    }

    public final void A0X(NativeAdBaseApi nativeAdBaseApi, boolean z) {
        C1421gi c1421giA16 = ((UK) nativeAdBaseApi).A16();
        C1421gi adObjectContext = this.A0C;
        adObjectContext.A0L(c1421giA16);
        c1421giA16.A0O(this);
        this.A0K = true;
        UK ukA0L = UK.A0L(nativeAdBaseApi);
        ukA0L.A1Z(this.A07);
        this.A0F.setVisibility(8);
        this.A0F.setImage(null, null);
        this.A09.setVisibility(8);
        this.A09.unsetNativeAd();
        ((C0804Rz) this.A09.getMediaViewVideoRendererApi()).A03();
        if (this.A03 != null) {
            this.A03.setVisibility(8);
            if (this.A03 instanceof C1065aw) {
                ((C1065aw) this.A03).A04();
            } else {
                ((C7M) this.A03).setAdapter(null);
            }
        }
        this.A04.setVisibility(0);
        bringChildToFront(this.A04);
        this.A02 = this.A04;
        C0883Vb adIcon = ukA0L.getAdIcon();
        if (adIcon != null) {
            C0827Sx c0827SxA14 = ukA0L.A14();
            if (A0M[1].charAt(7) == 'A') {
                throw new RuntimeException();
            }
            String[] strArr = A0M;
            strArr[3] = "8vonm0Gh";
            strArr[7] = "EfYx5Mmt";
            Bitmap bitmapA0N = c0827SxA14.A0N(adIcon.getUrl());
            if (bitmapA0N != null) {
                this.A04.setImageBitmap(bitmapA0N);
                if (z) {
                    this.A07.post(new C1460hL(this, ukA0L));
                }
            } else {
                A0R(ukA0L, z, adIcon);
            }
        } else {
            InterfaceC0851Tv interfaceC0851TvA1A = ukA0L.A1A();
            AdErrorType adErrorType = AdErrorType.NATIVE_AD_IS_NOT_LOADED;
            c1421giA16.A0F().A3N(ukA0L.A11(), adErrorType.getErrorCode(), adErrorType.getDefaultErrorMessage());
            if (interfaceC0851TvA1A != null) {
                interfaceC0851TvA1A.ADp(C0893Vm.A00(adErrorType));
            }
            Log.e(A05(46, 17, 121), adErrorType.getDefaultErrorMessage());
            if (nativeAdBaseApi.isAdLoaded()) {
                C1421gi adObjectContext2 = this.A0C;
                adObjectContext2.A08().ABC(A05(258, 3, 44), AbstractC0833Td.A0W, new C0834Te(A05(192, 23, 42)));
            }
        }
        A0E(this.A04, ukA0L);
        if (ukA0L.A1s() && !ukA0L.A1p()) {
            A0Q(ukA0L, true);
        }
    }

    public final /* synthetic */ void A0Y(UK uk, View view) {
        this.A0C.A0F().AAy(EnumC1029aM.A05.name().toLowerCase(Locale.US));
        uk.A1O();
    }

    public final /* synthetic */ void A0Z(UK uk, View view) {
        if (this.A0D != null && uk.A17() != null) {
            if (this.A0D.A04()) {
                this.A0C.A0F().ABb();
                uk.A17().A04();
            } else {
                this.A0C.A0F().ABc();
                uk.A17().onClick(view);
            }
        }
    }

    public final /* synthetic */ void A0a(UK uk, View view) {
        if (uk.A17() != null) {
            if (this.A00 < uk.A0z()) {
                this.A0C.A0F().ABZ();
                uk.A17().onClick(view);
            } else {
                this.A0C.A0F().ABY();
                uk.A17().A04();
            }
            this.A00++;
        }
    }

    public final boolean A0b() {
        if (this.A03 != null) {
            View view = this.A03;
            if (A0M[5].length() != 13) {
                throw new RuntimeException();
            }
            String[] strArr = A0M;
            strArr[3] = "f43XNCk8";
            strArr[7] = "DdRxJSTL";
            if (view.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.T4
    public final C1421gi A6m() {
        return this.A0C;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0983Zc
    public final void ACr() {
        A09();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC0983Zc
    public final void ACs() {
        A08();
    }

    @Override // com.facebook.ads.redexgen.core.C0791Rm, com.facebook.ads.internal.api.AdComponentViewParentApi
    public final void bringChildToFront(View view) {
        if (view != this.A03 && view != this.A09 && view != this.A0F) {
            ImageView imageView = this.A04;
            if (A0M[5].length() != 13) {
                throw new RuntimeException();
            }
            A0M[1] = "R8dYcckG0onv7yQggjKFRkmHXZbq9UJh";
            if (view != imageView) {
                return;
            }
        }
        this.A0A.bringChildToFront(view);
        if (this.A0I != null) {
            this.A0A.bringChildToFront(this.A0I);
        }
        if (this.A06 != null) {
            this.A0A.bringChildToFront(this.A06);
        }
        if (this.A0G != null) {
            this.A0A.bringChildToFront(this.A0G);
        }
        if (this.A05 != null) {
            this.A0A.bringChildToFront(this.A05);
        }
    }

    @Override // com.facebook.ads.internal.api.MediaViewApi
    public final void destroy() {
        this.A09.pause(false);
        this.A09.getMediaViewVideoRendererApi().destroy();
    }

    @Override // com.facebook.ads.internal.api.AdComponentViewApiProvider
    public final AdComponentViewApi getAdComponentViewApi() {
        return this;
    }

    @Override // com.facebook.ads.internal.api.MediaViewApi
    public final View getAdContentsView() {
        return this.A02;
    }

    @Override // com.facebook.ads.internal.api.MediaViewApi
    public final int getMediaHeight() {
        if (this.A0F.getVisibility() == 0) {
            return this.A0F.getImageHeight();
        }
        if (this.A09.getVisibility() == 0) {
            return this.A09.getMediaViewVideoRendererApi().getVideoView().getHeight();
        }
        if (this.A07.getVisibility() == 0) {
            return this.A07.getHeight();
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0055, code lost:
    
        if (r3.getVisibility() == 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0065, code lost:
    
        return r4.A09.getMediaViewVideoRendererApi().getVideoView().getWidth();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x006a, code lost:
    
        if (r3.getVisibility() == 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0073, code lost:
    
        if (r4.A07.getVisibility() != 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007b, code lost:
    
        return r4.A07.getWidth();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007c, code lost:
    
        return 0;
     */
    @Override // com.facebook.ads.internal.api.MediaViewApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int getMediaWidth() {
        if (this.A0F.getVisibility() == 0) {
            int imageWidth = this.A0F.getImageWidth();
            String[] strArr = A0M;
            if (strArr[2].charAt(31) != strArr[0].charAt(31)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0M;
            strArr2[6] = "us0p5hBNoGIfish2";
            strArr2[4] = "DFvDCw92fILzmemlu9XfPwpsPQRiq";
            return imageWidth;
        }
        MediaViewVideoRenderer mediaViewVideoRenderer = this.A09;
        if (A0M[1].charAt(7) != 'A') {
            String[] strArr3 = A0M;
            strArr3[3] = "7zc9sXuG";
            strArr3[7] = "ncWuDUJK";
        }
    }

    @Override // com.facebook.ads.internal.api.MediaViewApi
    public final int getVideoDuration() {
        this.A0C.A0F().ABm();
        return this.A01;
    }

    @Override // com.facebook.ads.internal.api.MediaViewApi
    public final void initialize(AdViewConstructorParams adViewConstructorParams, MediaView mediaView) {
        Context context = adViewConstructorParams.getContext();
        if (context instanceof C1421gi) {
            this.A0C = (C1421gi) context;
        } else {
            this.A0C = C0794Rp.A03(context);
        }
        this.A0C.A0O(this);
        switch (adViewConstructorParams.getInitializationType()) {
            case 0:
                A0J(this.A0C, mediaView);
                break;
            case 1:
                A0I(this.A0C, adViewConstructorParams.getAttributeSet(), mediaView);
                break;
            case 2:
                C1421gi c1421gi = this.A0C;
                AttributeSet attributeSet = adViewConstructorParams.getAttributeSet();
                if (A0M[1].charAt(7) == 'A') {
                    throw new RuntimeException();
                }
                A0M[1] = "4tObUcmoIw93Quo4uXvWt9YCbUPkknut";
                A0H(c1421gi, attributeSet, adViewConstructorParams.getDefStyleAttr(), mediaView);
                break;
                break;
            case 3:
                A0G(this.A0C, adViewConstructorParams.getAttributeSet(), adViewConstructorParams.getDefStyleAttr(), adViewConstructorParams.getDefStyleRes(), mediaView);
                break;
            default:
                throw new IllegalArgumentException(A05(155, 37, 26));
        }
        A01(true);
    }

    @Override // com.facebook.ads.internal.api.MediaViewApi
    public final boolean isVideoContent() {
        this.A0C.A0F().ABl();
        return this.A0B == EnumC0800Rv.A05;
    }

    @Override // com.facebook.ads.redexgen.core.C0791Rm, com.facebook.ads.internal.api.AdComponentViewApi
    public final void onAttachedToView(AdComponentView adComponentView, AdComponentViewParentApi adComponentViewParentApi) {
        super.onAttachedToView(adComponentView, adComponentViewParentApi);
        this.A0A = adComponentViewParentApi;
    }

    @Override // com.facebook.ads.redexgen.core.C0791Rm, com.facebook.ads.internal.api.AdComponentViewParentApi
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        A09();
    }

    @Override // com.facebook.ads.redexgen.core.C0791Rm, com.facebook.ads.internal.api.AdComponentViewParentApi
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        A08();
    }

    @Override // com.facebook.ads.redexgen.core.C0791Rm, com.facebook.ads.internal.api.AdComponentView
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            A09();
        } else {
            A08();
        }
    }

    @Override // com.facebook.ads.internal.context.Repairable
    public final void repair(Throwable th) {
        int width = this.A07.getWidth();
        int currentHeight = this.A07.getHeight();
        if (width > 0 && currentHeight > 0) {
            this.A07.repair(th);
            this.A07.getLayoutParams().width = width;
            this.A07.getLayoutParams().height = currentHeight;
            this.A07.setBackgroundColor(Color.LTGRAY);
            return;
        }
        this.A07.repair(th);
    }

    @Override // com.facebook.ads.internal.api.MediaViewApi
    public final void setListener(MediaViewListener mediaViewListener) {
        this.A08 = mediaViewListener;
        if (mediaViewListener == null) {
            ((C0804Rz) this.A09.getMediaViewVideoRendererApi()).A07(null);
        } else {
            ((C0804Rz) this.A09.getMediaViewVideoRendererApi()).A07(new C1453hE(this, mediaViewListener));
        }
    }

    @Override // com.facebook.ads.internal.api.MediaViewApi
    public final void setVideoRenderer(MediaViewVideoRenderer mediaViewVideoRenderer) {
        if (!this.A0K) {
            if (this.A09 != null) {
                this.A07.removeView(this.A09);
                this.A09.getMediaViewVideoRendererApi().destroy();
            }
            ((C0804Rz) mediaViewVideoRenderer.getMediaViewVideoRendererApi()).A05(this.A0C.A0A());
            mediaViewVideoRenderer.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            ((C1451hC) this.A07.getMediaViewApi()).A0D(mediaViewVideoRenderer, layoutParams);
            this.A09 = mediaViewVideoRenderer;
            this.A0J = !(this.A09 instanceof DefaultMediaViewVideoRenderer);
            mediaViewVideoRenderer.setId(YB.A00());
            return;
        }
        throw new IllegalStateException(A05(215, 43, 70));
    }
}
