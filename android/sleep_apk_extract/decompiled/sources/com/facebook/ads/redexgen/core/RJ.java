package com.facebook.ads.redexgen.core;

import android.os.Build;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class RJ implements Runnable {
    public static byte[] A07;
    public static String[] A08 = {"YAUr0vF6CX8YQIb3U2BTwiKsPx4egdml", "mCzYZBoaiKXOzjUHkKBQEDESozpM1xd6", "icS38dGHdjVFjizVfUSTymHnsbTrfSoO", "cz24QPO5JMZmQB4F0QhCndjSq8meDVtx", "FtYcbE5Uq8HUJyIzKb3J4QjvmALEd3tS", "OczTw8YbFDCs0vVm57WwAmFlfg0gTpir", "toWNn3QT1tQgvY3MKWHjSENw", "YozzgSFsuZbL3IkC1bDOEp8MFgumFV8x"};
    public OverScroller A01;
    public int A02;
    public int A03;
    public final /* synthetic */ C7M A06;
    public Interpolator A00 = C7M.A1A;
    public boolean A04 = false;
    public boolean A05 = false;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            byte b = bArrCopyOfRange[i4];
            if (A08[6].length() == 25) {
                throw new RuntimeException();
            }
            String[] strArr = A08;
            strArr[1] = "lXzWc938MQZaj6BgS1Y9BEfSDAuAR6qF";
            strArr[5] = "B8zmNNge3ag7Hwi7A1PWi4fqxiL6HNqU";
            bArrCopyOfRange[i4] = (byte) ((b - i3) - 123);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        byte[] bArr = {64, 68, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 65, 81, 96, 93, 90, 90};
        String[] strArr = A08;
        if (strArr[1].charAt(2) != strArr[5].charAt(2)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A08;
        strArr2[7] = "TeOjcoFpg61NRcWtZ7RqEgvJb0vCzhPX";
        strArr2[0] = "wzSzDJFWC0w6xe3VuPJPH24U0YXOvF2u";
        A07 = bArr;
    }

    static {
        A03();
    }

    public RJ(C7M c7m) {
        this.A06 = c7m;
        this.A01 = new OverScroller(c7m.getContext(), C7M.A1A);
    }

    private float A00(float f) {
        return (float) Math.sin((f - 0.5f) * 0.47123894f);
    }

    private int A01(int i, int i2, int i3, int i4) {
        int absDx;
        int containerSize = Math.abs(i);
        int delta = Math.abs(i2);
        int duration = containerSize > delta ? 1 : 0;
        int halfContainerSize = (int) Math.sqrt((i3 * i3) + (i4 * i4));
        int absDx2 = (int) Math.sqrt((i * i) + (i2 * i2));
        C7M c7m = this.A06;
        int width = duration != 0 ? c7m.getWidth() : c7m.getHeight();
        int velocity = width / 2;
        float fA00 = velocity + (velocity * A00(Math.min(1.0f, (absDx2 * 1.0f) / width)));
        if (halfContainerSize > 0) {
            absDx = Math.round(Math.abs(fA00 / halfContainerSize) * 1000.0f) * 4;
        } else {
            if (duration == 0) {
                containerSize = delta;
            }
            absDx = (int) (((containerSize / width) + 1.0f) * 300.0f);
        }
        int iMin = Math.min(absDx, 2000);
        int absDx3 = A08[2].charAt(23);
        if (absDx3 != 110) {
            throw new RuntimeException();
        }
        String[] strArr = A08;
        strArr[7] = "0orcdyFTKXkoGK9yWPRw9CMcRo5SNB9j";
        strArr[0] = "sq5WBRFpbSiYOu42pzh1wsqhDGiHcevd";
        return iMin;
    }

    private final void A04() {
        this.A05 = false;
        this.A04 = true;
    }

    private final void A05() {
        this.A04 = false;
        if (this.A05) {
            A07();
        }
    }

    private final void A06(int i, int i2, int i3, int i4) {
        A0B(i, i2, A01(i, i2, i3, i4));
    }

    public final void A07() {
        if (this.A04) {
            this.A05 = true;
        } else {
            this.A06.removeCallbacks(this);
            Ph.A0D(this.A06, this);
        }
    }

    public final void A08() {
        this.A06.removeCallbacks(this);
        this.A01.abortAnimation();
    }

    public final void A09(int i, int i2) {
        this.A06.setScrollState(2);
        this.A03 = 0;
        this.A02 = 0;
        this.A01.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        A07();
    }

    public final void A0A(int i, int i2) {
        A06(i, i2, 0, 0);
    }

    public final void A0B(int i, int i2, int i3) {
        A0C(i, i2, i3, C7M.A1A);
    }

    public final void A0C(int i, int i2, int i3, Interpolator interpolator) {
        if (this.A00 != interpolator) {
            this.A00 = interpolator;
            this.A01 = new OverScroller(this.A06.getContext(), interpolator);
        }
        this.A06.setScrollState(2);
        this.A03 = 0;
        this.A02 = 0;
        this.A01.startScroll(0, 0, i, i2, i3);
        if (Build.VERSION.SDK_INT < 23) {
            OverScroller overScroller = this.A01;
            if (A08[2].charAt(23) != 'n') {
                throw new RuntimeException();
            }
            String[] strArr = A08;
            strArr[1] = "88zIldbbkktihn9hTQ4sgRWvKPoy0Har";
            strArr[5] = "wazVAycqzf9kUc8ZZnvbPZ6jaLgaodB2";
            overScroller.computeScrollOffset();
        }
        A07();
    }

    public final void A0D(int i, int i2, Interpolator interpolator) {
        int iA01 = A01(i, i2, 0, 0);
        if (interpolator == null) {
            interpolator = C7M.A1A;
        }
        A0C(i, i2, iA01, interpolator);
        if (A08[6].length() == 25) {
            throw new RuntimeException();
        }
        A08[3] = "4ylqCkbib8Hqjgb9G4JU7JWl2ANwoVnp";
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.A06.A06 == null) {
            A08();
            return;
        }
        A04();
        this.A06.A1K();
        OverScroller overScroller = this.A01;
        RF rf = this.A06.A06.A02;
        if (overScroller.computeScrollOffset()) {
            int[] iArr = this.A06.A16;
            int overscrollX = overScroller.getCurrX();
            int velY = overScroller.getCurrY();
            int vresult = overscrollX - this.A02;
            int velX = velY - this.A03;
            int iA1f = 0;
            int iA1g = 0;
            this.A02 = overscrollX;
            this.A03 = velY;
            int i = 0;
            int i2 = 0;
            if (this.A06.A1w(vresult, velX, iArr, null, 1)) {
                vresult -= iArr[0];
                velX -= iArr[1];
            }
            if (this.A06.A04 != null) {
                this.A06.A1L();
                this.A06.A1M();
                P4.A01(A02(0, 9, 115));
                C7M c7m = this.A06;
                RH rh = this.A06.A0s;
                String[] strArr = A08;
                if (strArr[7].charAt(6) != strArr[0].charAt(6)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A08;
                strArr2[1] = "nozOsXlmQMzJhvkopjwZaheFFVNTeY58";
                strArr2[5] = "LtzfvJebeScyRtmgs1USyUey2pVvSmq5";
                c7m.A1j(rh);
                if (vresult != 0) {
                    R2 r2 = this.A06.A06;
                    RA ra = this.A06.A0r;
                    C7M c7m2 = this.A06;
                    if (A08[4].charAt(19) != '9') {
                        A08[4] = "aF9lT9JucYAVgVWisB0rNkK4be7J2iGb";
                        iA1f = r2.A1f(vresult, ra, c7m2.A0s);
                        i = vresult - iA1f;
                    } else {
                        iA1f = r2.A1f(vresult, ra, c7m2.A0s);
                        i = vresult - iA1f;
                    }
                }
                if (velX != 0) {
                    R2 r22 = this.A06.A06;
                    RA ra2 = this.A06.A0r;
                    if (A08[4].charAt(19) != 57) {
                        String[] strArr3 = A08;
                        strArr3[7] = "UcFH7yF8zZNprQitZtXhkmlCMHIdnioP";
                        strArr3[0] = "hCBROqFKcvdbLIHuO2wEis8Nwj1iktft";
                        iA1g = r22.A1g(velX, ra2, this.A06.A0s);
                        i2 = velX - iA1g;
                    } else {
                        iA1g = r22.A1g(velX, ra2, this.A06.A0s);
                        i2 = velX - iA1g;
                    }
                }
                P4.A00();
                this.A06.A1Q();
                this.A06.A1N();
                this.A06.A1p(false);
                if (rf != null && !rf.A0E() && rf.A0F()) {
                    int x = this.A06.A0s.A03();
                    if (x == 0) {
                        rf.A09();
                    } else if (rf.A07() >= x) {
                        rf.A0A(x - 1);
                        rf.A04(vresult - i, velX - i2);
                    } else {
                        int y = vresult - i;
                        if (A08[4].charAt(19) != 57) {
                            String[] strArr4 = A08;
                            strArr4[1] = "2vzJUgZGYJyf60lr7OoRSSfYHAbPRQwN";
                            strArr4[5] = "FZzkKBCO3vggmWhfitA4hZZwekV7eOzC";
                            rf.A04(y, velX - i2);
                        } else {
                            rf.A04(y, velX - i2);
                        }
                    }
                }
            }
            if (!this.A06.A0v.isEmpty()) {
                this.A06.invalidate();
            }
            if (this.A06.getOverScrollMode() != 2) {
                C7M c7m3 = this.A06;
                String[] strArr5 = A08;
                if (strArr5[7].charAt(6) != strArr5[0].charAt(6)) {
                    throw new RuntimeException();
                }
                A08[6] = "k";
                c7m3.A1b(vresult, velX);
            }
            int dy = iA1f;
            int hresult = iA1g;
            if (!this.A06.A1v(dy, hresult, i, i2, null, 1) && (i != 0 || i2 != 0)) {
                int x2 = (int) overScroller.getCurrVelocity();
                int dx = 0;
                if (i != overscrollX) {
                    if (i < 0) {
                        dx = -x2;
                    } else {
                        dx = i > 0 ? x2 : 0;
                    }
                }
                if (i2 != velY) {
                    if (i2 < 0) {
                        x2 = -x2;
                    } else if (i2 <= 0) {
                        x2 = 0;
                    }
                } else {
                    x2 = 0;
                }
                if (this.A06.getOverScrollMode() != 2) {
                    this.A06.A1a(dx, x2);
                }
                if ((dx != 0 || i == overscrollX || overScroller.getFinalX() == 0) && (x2 != 0 || i2 == velY || overScroller.getFinalY() == 0)) {
                    overScroller.abortAnimation();
                }
            }
            if (iA1f != 0 || iA1g != 0) {
                C7M c7m4 = this.A06;
                if (A08[6].length() != 25) {
                    A08[3] = "MhQkdHLAPY6K0mrvY0I8ZqPtgRA1J8Gx";
                    c7m4.A1d(iA1f, iA1g);
                } else {
                    A08[6] = "5ZFiatMajPEhKsDar8BqfzNMKoQTJ";
                    c7m4.A1d(iA1f, iA1g);
                }
            }
            if (!this.A06.awakenScrollBars()) {
                this.A06.invalidate();
            }
            boolean z = (vresult == 0 && velX == 0) || (vresult != 0 && this.A06.A06.A22() && iA1f == vresult) || (velX != 0 && this.A06.A06.A23() && iA1g == velX);
            if (overScroller.isFinished() || (!z && !this.A06.A1t(1))) {
                this.A06.setScrollState(0);
                if (C7M.A1E) {
                    this.A06.A02.A02();
                }
                this.A06.A1Z(1);
            } else {
                A07();
                if (this.A06.A03 != null) {
                    this.A06.A03.A0B(this.A06, vresult, velX);
                }
            }
        }
        if (rf != null) {
            if (rf.A0E()) {
                rf.A04(0, 0);
            }
            if (!this.A05) {
                rf.A09();
            }
        }
        A05();
    }
}
