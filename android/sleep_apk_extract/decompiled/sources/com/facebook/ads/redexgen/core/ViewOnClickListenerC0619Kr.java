package com.facebook.ads.redexgen.core;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Kr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class ViewOnClickListenerC0619Kr extends AbstractC1106bb implements View.OnClickListener {
    public static byte[] A0E;
    public static String[] A0F = {"zJy5N3L509NIqOAGCBmq2SY7W4xK8HwT", "H2", "E", "vMyDxD7xbIgTd", "0bWjMiKAxESivC84rSJqWsF4vTTr4zpm", "NIsgbM1VoVKu1UXdUm6ipB03AExBFzGo", "hF", "2iAtRdiONhZPMieR3MSLVzPYox5YjbDW"};
    public static final int A0G;
    public int A00;
    public int A01;
    public Bitmap A02;
    public Paint A03;
    public Rect A04;
    public C1421gi A05;
    public XO A06;
    public C0625Kx A07;
    public String A08;
    public String A09;
    public boolean A0A;
    public boolean A0B;
    public final C1100bV A0C;
    public final Map<String, String> A0D;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0E, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 121);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A0E = new byte[]{-30, -21, -24, -30, -22, -34, -14, -18, -12, -15, -30, -28, -23, -27, -80, -16, -24, -10, -10, -24, -15, -22, -24, -11, 28, 38, 18, 41, -27, 18, 23, 24, 38, 28, 26, 33, 93, 91, 77, 90, 75, 84, 81, 75, 83};
    }

    static {
        A04();
        A0G = (int) (XX.A02 * 24.0f);
    }

    public ViewOnClickListenerC0619Kr(C1421gi c1421gi, AbstractC1586jd abstractC1586jd, C0679Na c0679Na, VA va, InterfaceC0962Yh interfaceC0962Yh, C1366fp c1366fp, Y2 y2, InterfaceC0936Xh interfaceC0936Xh) {
        this(c1421gi, abstractC1586jd.A0w(), c0679Na, abstractC1586jd.A29().A0J().A06(), va, interfaceC0962Yh, c1366fp, y2, abstractC1586jd.A2A(), interfaceC0936Xh);
        this.A0C.A08(abstractC1586jd);
    }

    public ViewOnClickListenerC0619Kr(C1421gi c1421gi, String str, C0679Na c0679Na, VA va, InterfaceC0962Yh interfaceC0962Yh, C1366fp c1366fp, Y2 y2, C0685Ng c0685Ng) {
        this(c1421gi, str, c0679Na, false, va, interfaceC0962Yh, c1366fp, y2, c0685Ng);
    }

    public ViewOnClickListenerC0619Kr(C1421gi c1421gi, String str, C0679Na c0679Na, boolean z, VA va, InterfaceC0962Yh interfaceC0962Yh, C1366fp c1366fp, Y2 y2, C0685Ng c0685Ng) {
        super(c1421gi, c0679Na);
        this.A0D = new HashMap();
        this.A0B = false;
        this.A05 = c1421gi;
        this.A0A = z;
        this.A0C = new C1100bV(c1421gi, str, c1366fp, y2, va, c0685Ng, interfaceC0962Yh);
        setOnClickListener(this);
        YB.A0G(1001, this);
    }

    public ViewOnClickListenerC0619Kr(C1421gi c1421gi, String str, C0679Na c0679Na, boolean z, VA va, InterfaceC0962Yh interfaceC0962Yh, C1366fp c1366fp, Y2 y2, C0685Ng c0685Ng, InterfaceC0936Xh interfaceC0936Xh) {
        super(c1421gi, c0679Na);
        this.A0D = new HashMap();
        this.A0B = false;
        this.A05 = c1421gi;
        this.A0A = z;
        this.A0C = new C1100bV(c1421gi, str, c1366fp, y2, va, c0685Ng, interfaceC0962Yh, interfaceC0936Xh);
        setOnClickListener(this);
        YB.A0G(1001, this);
    }

    public static Bitmap A00(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    private void A02() {
        if (this.A0A && this.A09 != null) {
            this.A02 = A00(YN.A03(this.A05, this.A09.contains(A01(12, 12, 10)) ? YM.MESSENGER : YM.WHATSAPP));
            this.A03 = new Paint();
            setPadding(A0G, 0, A0G, 0);
        }
    }

    private void A03() {
        if (this.A06 != null) {
            XO xo = this.A06;
            if (A0F[0].charAt(27) != 'K') {
                throw new RuntimeException();
            }
            String[] strArr = A0F;
            strArr[6] = "Jn";
            strArr[1] = "nM";
            xo.A06();
        }
        if (this.A07 != null) {
            this.A07.A04();
        }
    }

    public static boolean A05(AbstractC1586jd abstractC1586jd) {
        return ((long) abstractC1586jd.A25()) > 0 && abstractC1586jd.A23() >= 0;
    }

    public final EnumC0670Mq A0E(String str) {
        if (TextUtils.isEmpty(this.A08) || TextUtils.isEmpty(this.A09)) {
            return EnumC0670Mq.A09;
        }
        A03();
        this.A0D.put(A01(0, 12, 6), str);
        this.A0D.put(A01(24, 12, 58), String.valueOf(this.A0B));
        return this.A0C.A05(this.A08, this.A09, this.A0D);
    }

    public final boolean A0F(AbstractC1586jd abstractC1586jd, AbstractC0956Yb abstractC0956Yb) {
        if (this.A06 != null || !A05(abstractC1586jd) || abstractC1586jd.A2D().A02() == null || abstractC1586jd.A2D().A01() == null) {
            return false;
        }
        this.A07 = new C0625Kx(abstractC1586jd.A23(), abstractC1586jd.A25(), abstractC1586jd.A24(), abstractC1586jd.A2D().A02(), abstractC1586jd.A2D().A01(), abstractC0956Yb, this);
        this.A06 = new XO(abstractC1586jd.A25(), this.A07);
        this.A06.A07();
        return true;
    }

    public C1100bV getCtaActionHelper() {
        return this.A0C;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            A0E(A01(36, 9, 111));
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        A03();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.A02 != null) {
            this.A04 = new Rect(0, 0, this.A02.getWidth(), this.A02.getHeight());
            this.A01 = this.A02.getWidth();
            this.A00 = 12;
            int shift = (this.A01 + this.A00) / 2;
            canvas.save();
            canvas.translate(shift, 0.0f);
        }
        super.onDraw(canvas);
        if (this.A02 != null) {
            float width = (getWidth() / 2.0f) - ((getPaint().measureText((String) getText()) + 10.0f) / 2.0f);
            float textWidth = this.A01;
            float f = width - textWidth;
            float textWidth2 = this.A00;
            int i = (int) (f - textWidth2);
            int top = (getHeight() / 2) - (this.A01 / 2);
            int left = this.A01;
            Rect destRect = new Rect(i, top, left + i, this.A01 + top);
            canvas.drawBitmap(this.A02, this.A04, destRect, this.A03);
            canvas.restore();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0) {
            A03();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (!z) {
            A03();
        }
    }

    public void setCreativeAsCtaLoggingHelper(XS xs) {
        this.A0C.A09(xs);
    }

    public void setCta(C0681Nc c0681Nc, String str, Map<String, String> extraData) {
        setCta(c0681Nc, str, extraData, null);
    }

    public void setCta(C0681Nc c0681Nc, String str, Map<String, String> extraData, InterfaceC0936Xh interfaceC0936Xh, InterfaceC1099bU interfaceC1099bU) {
        setCta(c0681Nc, str, extraData, interfaceC1099bU);
        this.A0C.A0A(interfaceC0936Xh);
    }

    public void setCta(C0681Nc c0681Nc, String str, Map<String, String> extraData, InterfaceC1099bU interfaceC1099bU) {
        this.A08 = str;
        this.A09 = c0681Nc.A05();
        this.A0D.putAll(extraData);
        this.A0C.A0B(interfaceC1099bU);
        String strA04 = c0681Nc.A04();
        if (!TextUtils.isEmpty(strA04)) {
            String buttonText = this.A09;
            if (!TextUtils.isEmpty(buttonText)) {
                setText(strA04);
                A02();
                return;
            }
        }
        setVisibility(8);
    }

    public void setIsInAppBrowser(boolean z) {
        this.A0C.A0C(z);
    }

    public void setV2Design(boolean z) {
        this.A0B = z;
    }
}
