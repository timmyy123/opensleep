package com.facebook.ads.redexgen.core;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.internal.NativeProtocol;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.at, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1062at extends WebViewClient {
    public static byte[] A05;
    public final WeakReference<C1421gi> A02;
    public final WeakReference<InterfaceC1059aq> A03;
    public final WeakReference<C1054al> A04;
    public final InterfaceC1058ap A01 = new InterfaceC1058ap() { // from class: com.facebook.ads.redexgen.X.M4
        @Override // com.facebook.ads.redexgen.core.InterfaceC1058ap
        public final boolean AAf(String str) {
            return C1062at.A04(str);
        }
    };
    public WeakReference<InterfaceC1060ar> A00 = new WeakReference<>(null);

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 44);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{28, 31, 18, 8, 9, 71, 31, 17, 28, 19, 22, 37, 42, 27, 37, 39, 48, 45, 50, 45, 48, 61, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 3, 9, 31, 2, 4, 9, 67, 4, 3, 25, 8, 3, 25, 67, MqttWireMessage.MESSAGE_TYPE_PINGREQ, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 25, 4, 2, 3, 67, 59, 36, 40, 58, 119, 120, 114, 100, 121, 127, 114, 56, 127, 120, 98, 115, 120, 98, 56, 117, 119, 98, 115, 113, 121, 100, 111, 56, 84, 68, 89, 65, 69, 87, 84, 90, 83, 117, 101, 120, 96, 100, 114, 101, 72, 113, 118, 123, 123, 117, 118, 116, 124, 72, 98, 101, 123, 51, 54, 35, 54, 97, 102, 124, 109, 102, 124, 2, 5, 27, 77, 87, 31, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 10, 55, 30, 1, MqttWireMessage.MESSAGE_TYPE_PINGRESP, 31};
    }

    public C1062at(WeakReference<C1421gi> weakReference, WeakReference<InterfaceC1059aq> weakReference2, WeakReference<C1054al> weakReference3) {
        this.A02 = weakReference;
        this.A03 = weakReference2;
        this.A04 = weakReference3;
    }

    private void A02(String str, C1421gi c1421gi) {
        c1421gi.A08().ABC(A00(11, 11, 104), AbstractC0833Td.A09, new C0834Te(A00(111, 5, 91) + str));
    }

    private boolean A03(WebView webView, String str) {
        Intent intent;
        String strA00 = A00(116, 8, 68);
        C1421gi c1421gi = this.A02.get();
        if (c1421gi != null) {
            if ((M3.A0A && (TextUtils.isEmpty(str) || A00(0, 11, 81).equals(str))) || !this.A01.AAf(str)) {
                return true;
            }
            try {
                Uri uri = XB.A00(str);
                String scheme = uri.getScheme();
                try {
                    boolean zA14 = C0871Up.A14(c1421gi);
                    String strA002 = A00(48, 33, 58);
                    String strA003 = A00(22, 26, 65);
                    String strA004 = A00(105, 6, 36);
                    if (zA14) {
                        if (!M3.A0D.contains(scheme) && !A00(101, 4, 123).equals(scheme)) {
                            if (strA004.equalsIgnoreCase(scheme)) {
                                intent = Intent.parseUri(str, 1);
                                intent.setComponent(null);
                                intent.setSelector(null);
                            } else {
                                intent = new Intent(strA003, uri);
                            }
                            intent.addCategory(strA002);
                            if (Build.VERSION.SDK_INT >= 30) {
                                intent.setFlags(268436480);
                            } else {
                                intent.setFlags(ClientDefaults.MAX_MSG_SIZE);
                            }
                            try {
                                if (!C0925Wu.A0D(c1421gi, intent)) {
                                    A02(str, c1421gi);
                                }
                                return true;
                            } catch (C0923Ws unused) {
                                if (strA004.equals(scheme)) {
                                    String stringExtra = intent.getStringExtra(A00(81, 20, 59));
                                    if (!TextUtils.isEmpty(stringExtra)) {
                                        if (!C0925Wu.A0D(c1421gi, new Intent(strA003, XB.A00(stringExtra)))) {
                                            A02(str, c1421gi);
                                        }
                                        return true;
                                    }
                                }
                                C0834Te c0834Te = new C0834Te(A00(111, 5, 91) + str);
                                c0834Te.A05(1);
                                c1421gi.A08().ABD(A00(11, 11, 104), AbstractC0833Td.A06, c0834Te);
                                return true;
                            }
                        }
                        return false;
                    }
                    if (!M3.A0A || !strA004.equalsIgnoreCase(scheme)) {
                        if ((M3.A0A && AbstractC0930Xb.A04(str)) || !M3.A0D.contains(scheme)) {
                            return C0925Wu.A0D(c1421gi, new Intent(strA003, uri));
                        }
                    } else {
                        Intent uri2 = Intent.parseUri(str, 1);
                        uri2.addCategory(strA002);
                        uri2.setComponent(null);
                        uri2.setSelector(null);
                        if (c1421gi.getPackageManager().resolveActivity(uri2, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != null && C0925Wu.A0D(c1421gi, uri2)) {
                            webView.goBack();
                            return true;
                        }
                    }
                } catch (Exception e) {
                    c1421gi.A08().ABD(strA00, AbstractC0833Td.A2d, new C0834Te(e));
                    c1421gi.A0F().AA2(e.toString());
                }
                return false;
            } catch (SecurityException e2) {
                c1421gi.A08().ABD(strA00, AbstractC0833Td.A2d, new C0834Te(e2));
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean A04(String str) {
        return true;
    }

    public final void A05(WeakReference<InterfaceC1060ar> weakReference) {
        this.A00 = weakReference;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        C1054al timingLogger = this.A04.get();
        if (timingLogger != null) {
            timingLogger.A03();
        }
        InterfaceC1059aq interfaceC1059aq = this.A03.get();
        if (interfaceC1059aq != null) {
            interfaceC1059aq.AF7(str);
        }
        InterfaceC1060ar interfaceC1060ar = this.A00.get();
        if (interfaceC1060ar != null) {
            interfaceC1060ar.ADB(webView.canGoBack());
            interfaceC1060ar.ADx(webView.canGoForward());
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        InterfaceC1059aq listener = this.A03.get();
        if (listener != null) {
            listener.AF9(str);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        C1421gi c1421gi = this.A02.get();
        if (c1421gi != null) {
            StringBuilder sb = new StringBuilder();
            String strA00 = A00(0, 0, 109);
            String errorMessage = AbstractC0930Xb.A01(i, sb.append(strA00).append(str).toString(), strA00 + str2);
            c1421gi.A0F().A9z(errorMessage);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        C1421gi c1421gi = this.A02.get();
        if (c1421gi != null) {
            int errorCode = webResourceError.getErrorCode();
            StringBuilder sb = new StringBuilder();
            String strA00 = A00(0, 0, 109);
            String errorMessage = AbstractC0930Xb.A01(errorCode, sb.append(strA00).append((Object) webResourceError.getDescription()).toString(), strA00 + webResourceRequest.getUrl());
            c1421gi.A0F().A9z(errorMessage);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        C1421gi context = this.A02.get();
        if (context != null) {
            context.A0F().AA0();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        C1421gi context = this.A02.get();
        if (context != null) {
            context.A0F().AA1();
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        AbstractC1067ay.A0D(AbstractC0833Td.A2e);
        InterfaceC1059aq listener = this.A03.get();
        if (listener != null) {
            listener.AFe();
            return true;
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return A03(webView, webResourceRequest.getUrl().toString());
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return A03(webView, str);
    }
}
