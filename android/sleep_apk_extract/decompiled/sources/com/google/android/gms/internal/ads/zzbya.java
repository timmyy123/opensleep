package com.google.android.gms.internal.ads;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbya extends zzbyg {
    private String zza;
    private boolean zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private final Object zzi;
    private final zzcku zzj;
    private final Activity zzk;
    private zzcne zzl;
    private ImageView zzm;
    private LinearLayout zzn;
    private final zzbyh zzo;
    private PopupWindow zzp;
    private RelativeLayout zzq;
    private ViewGroup zzr;

    static {
        CollectionUtils.setOf("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
    }

    public zzbya(zzcku zzckuVar, zzbyh zzbyhVar) {
        super(zzckuVar, "resize");
        this.zza = "top-right";
        this.zzb = true;
        this.zzc = 0;
        this.zzd = 0;
        this.zze = -1;
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = -1;
        this.zzi = new Object();
        this.zzj = zzckuVar;
        this.zzk = zzckuVar.zzj();
        this.zzo = zzbyhVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: zzm, reason: merged with bridge method [inline-methods] */
    public final void zzf(boolean z) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzml)).booleanValue()) {
            this.zzq.removeView((View) this.zzj);
            this.zzp.dismiss();
        } else {
            this.zzp.dismiss();
            this.zzq.removeView((View) this.zzj);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzmm)).booleanValue()) {
            View view = (View) this.zzj;
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
        ViewGroup viewGroup = this.zzr;
        if (viewGroup != null) {
            viewGroup.removeView(this.zzm);
            boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzmn)).booleanValue();
            ViewGroup viewGroup2 = this.zzr;
            if (zBooleanValue) {
                try {
                    zzcku zzckuVar = this.zzj;
                    viewGroup2.addView((View) zzckuVar);
                    zzckuVar.zzaf(this.zzl);
                } catch (IllegalStateException e) {
                    int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to add webview back to view hierarchy.", e);
                    com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "MraidCallResizeHandler.collapseInternal");
                }
            } else {
                zzcku zzckuVar2 = this.zzj;
                viewGroup2.addView((View) zzckuVar2);
                zzckuVar2.zzaf(this.zzl);
            }
        }
        if (z) {
            zzk("default");
            zzbyh zzbyhVar = this.zzo;
            if (zzbyhVar != null) {
                zzbyhVar.zzb();
            }
        }
        this.zzp = null;
        this.zzq = null;
        this.zzr = null;
        this.zzn = null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:126:0x026d A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0009, B:6:0x000d, B:7:0x0012, B:11:0x0017, B:13:0x001f, B:14:0x0024, B:16:0x0026, B:18:0x0030, B:19:0x0035, B:21:0x0037, B:23:0x003d, B:24:0x0042, B:26:0x0044, B:28:0x0052, B:29:0x0063, B:31:0x0071, B:32:0x0082, B:34:0x0090, B:35:0x00a1, B:37:0x00af, B:38:0x00c0, B:40:0x00ce, B:41:0x00dc, B:43:0x00ea, B:44:0x00ec, B:46:0x00f0, B:48:0x00f4, B:50:0x00fa, B:53:0x0102, B:57:0x0124, B:63:0x0134, B:126:0x026d, B:127:0x0272, B:129:0x0274, B:131:0x0291, B:133:0x029d, B:135:0x02d6, B:141:0x034a, B:164:0x03a1, B:165:0x03b9, B:166:0x03d5, B:168:0x03dd, B:169:0x03e4, B:170:0x040b, B:173:0x040e, B:175:0x043c, B:176:0x044e, B:145:0x0359, B:149:0x0368, B:153:0x0377, B:157:0x0386, B:162:0x0397, B:163:0x039b, B:134:0x02d3, B:178:0x0450, B:179:0x0455, B:65:0x0142, B:67:0x0146, B:97:0x01ea, B:92:0x01c8, B:99:0x01f7, B:101:0x01fb, B:103:0x01ff, B:108:0x020d, B:109:0x021c, B:116:0x0244, B:122:0x0254, B:119:0x024a, B:121:0x0252, B:112:0x023b, B:114:0x0241, B:73:0x0161, B:77:0x017d, B:83:0x01a2, B:82:0x0198, B:87:0x01af, B:91:0x01c1, B:96:0x01d6, B:123:0x0259, B:124:0x0262, B:181:0x0457, B:182:0x045c, B:184:0x045e, B:185:0x0463), top: B:189:0x0009, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0274 A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0009, B:6:0x000d, B:7:0x0012, B:11:0x0017, B:13:0x001f, B:14:0x0024, B:16:0x0026, B:18:0x0030, B:19:0x0035, B:21:0x0037, B:23:0x003d, B:24:0x0042, B:26:0x0044, B:28:0x0052, B:29:0x0063, B:31:0x0071, B:32:0x0082, B:34:0x0090, B:35:0x00a1, B:37:0x00af, B:38:0x00c0, B:40:0x00ce, B:41:0x00dc, B:43:0x00ea, B:44:0x00ec, B:46:0x00f0, B:48:0x00f4, B:50:0x00fa, B:53:0x0102, B:57:0x0124, B:63:0x0134, B:126:0x026d, B:127:0x0272, B:129:0x0274, B:131:0x0291, B:133:0x029d, B:135:0x02d6, B:141:0x034a, B:164:0x03a1, B:165:0x03b9, B:166:0x03d5, B:168:0x03dd, B:169:0x03e4, B:170:0x040b, B:173:0x040e, B:175:0x043c, B:176:0x044e, B:145:0x0359, B:149:0x0368, B:153:0x0377, B:157:0x0386, B:162:0x0397, B:163:0x039b, B:134:0x02d3, B:178:0x0450, B:179:0x0455, B:65:0x0142, B:67:0x0146, B:97:0x01ea, B:92:0x01c8, B:99:0x01f7, B:101:0x01fb, B:103:0x01ff, B:108:0x020d, B:109:0x021c, B:116:0x0244, B:122:0x0254, B:119:0x024a, B:121:0x0252, B:112:0x023b, B:114:0x0241, B:73:0x0161, B:77:0x017d, B:83:0x01a2, B:82:0x0198, B:87:0x01af, B:91:0x01c1, B:96:0x01d6, B:123:0x0259, B:124:0x0262, B:181:0x0457, B:182:0x045c, B:184:0x045e, B:185:0x0463), top: B:189:0x0009, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x039b A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:4:0x0009, B:6:0x000d, B:7:0x0012, B:11:0x0017, B:13:0x001f, B:14:0x0024, B:16:0x0026, B:18:0x0030, B:19:0x0035, B:21:0x0037, B:23:0x003d, B:24:0x0042, B:26:0x0044, B:28:0x0052, B:29:0x0063, B:31:0x0071, B:32:0x0082, B:34:0x0090, B:35:0x00a1, B:37:0x00af, B:38:0x00c0, B:40:0x00ce, B:41:0x00dc, B:43:0x00ea, B:44:0x00ec, B:46:0x00f0, B:48:0x00f4, B:50:0x00fa, B:53:0x0102, B:57:0x0124, B:63:0x0134, B:126:0x026d, B:127:0x0272, B:129:0x0274, B:131:0x0291, B:133:0x029d, B:135:0x02d6, B:141:0x034a, B:164:0x03a1, B:165:0x03b9, B:166:0x03d5, B:168:0x03dd, B:169:0x03e4, B:170:0x040b, B:173:0x040e, B:175:0x043c, B:176:0x044e, B:145:0x0359, B:149:0x0368, B:153:0x0377, B:157:0x0386, B:162:0x0397, B:163:0x039b, B:134:0x02d3, B:178:0x0450, B:179:0x0455, B:65:0x0142, B:67:0x0146, B:97:0x01ea, B:92:0x01c8, B:99:0x01f7, B:101:0x01fb, B:103:0x01ff, B:108:0x020d, B:109:0x021c, B:116:0x0244, B:122:0x0254, B:119:0x024a, B:121:0x0252, B:112:0x023b, B:114:0x0241, B:73:0x0161, B:77:0x017d, B:83:0x01a2, B:82:0x0198, B:87:0x01af, B:91:0x01c1, B:96:0x01d6, B:123:0x0259, B:124:0x0262, B:181:0x0457, B:182:0x045c, B:184:0x045e, B:185:0x0463), top: B:189:0x0009, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(Map map) {
        int i;
        int i2;
        int[] iArr;
        int i3;
        int iM;
        int iM2;
        int i4;
        int i5;
        synchronized (this.zzi) {
            try {
                Activity activity = this.zzk;
                if (activity == null) {
                    zzg("Not an activity context. Cannot resize.");
                    return;
                }
                zzcku zzckuVar = this.zzj;
                if (zzckuVar.zzN() == null) {
                    zzg("Webview is not yet available, size is not set.");
                    return;
                }
                if (zzckuVar.zzN().zzg()) {
                    zzg("Is interstitial. Cannot resize an interstitial.");
                    return;
                }
                if (zzckuVar.zzW()) {
                    zzg("Cannot resize an expanded banner.");
                    return;
                }
                if (!TextUtils.isEmpty((CharSequence) map.get(ViewHierarchyConstants.DIMENSION_WIDTH_KEY))) {
                    com.google.android.gms.ads.internal.zzt.zzc();
                    this.zzh = com.google.android.gms.ads.internal.util.zzs.zzS((String) map.get(ViewHierarchyConstants.DIMENSION_WIDTH_KEY));
                }
                if (!TextUtils.isEmpty((CharSequence) map.get(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY))) {
                    com.google.android.gms.ads.internal.zzt.zzc();
                    this.zze = com.google.android.gms.ads.internal.util.zzs.zzS((String) map.get(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY));
                }
                if (!TextUtils.isEmpty((CharSequence) map.get("offsetX"))) {
                    com.google.android.gms.ads.internal.zzt.zzc();
                    this.zzf = com.google.android.gms.ads.internal.util.zzs.zzS((String) map.get("offsetX"));
                }
                if (!TextUtils.isEmpty((CharSequence) map.get("offsetY"))) {
                    com.google.android.gms.ads.internal.zzt.zzc();
                    this.zzg = com.google.android.gms.ads.internal.util.zzs.zzS((String) map.get("offsetY"));
                }
                if (!TextUtils.isEmpty((CharSequence) map.get("allowOffscreen"))) {
                    this.zzb = Boolean.parseBoolean((String) map.get("allowOffscreen"));
                }
                String str = (String) map.get("customClosePosition");
                if (!TextUtils.isEmpty(str)) {
                    this.zza = str;
                }
                if (this.zzh < 0 || this.zze < 0) {
                    zzg("Invalid width and height options. Cannot resize.");
                    return;
                }
                Window window = activity.getWindow();
                if (window != null && window.getDecorView() != null) {
                    com.google.android.gms.ads.internal.zzt.zzc();
                    int[] iArrZzaa = com.google.android.gms.ads.internal.util.zzs.zzaa(activity);
                    com.google.android.gms.ads.internal.zzt.zzc();
                    int[] iArrZzW = com.google.android.gms.ads.internal.util.zzs.zzW(activity);
                    int i6 = iArrZzaa[0];
                    int i7 = iArrZzaa[1];
                    int i8 = this.zzh;
                    if (i8 < 50 || i8 > i6) {
                        i = 0;
                        i2 = 50;
                        int i9 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                        com.google.android.gms.ads.internal.util.client.zzo.zzi("Width is too small or too large.");
                    } else {
                        int i10 = this.zze;
                        if (i10 < 50 || i10 > i7) {
                            i = 0;
                            i2 = 50;
                            int i11 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                            com.google.android.gms.ads.internal.util.client.zzo.zzi("Height is too small or too large.");
                        } else if (i10 == i7 && i8 == i6) {
                            int i12 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                            com.google.android.gms.ads.internal.util.client.zzo.zzi("Cannot resize to a full-screen ad.");
                            i = 0;
                            i2 = 50;
                        } else {
                            boolean z = this.zzb;
                            if (z) {
                                String str2 = this.zza;
                                i2 = 50;
                                switch (str2.hashCode()) {
                                    case -1364013995:
                                        i = 0;
                                        if (str2.equals("center")) {
                                            iM = FileInsert$$ExternalSyntheticOutline0.m(this.zzc, this.zzf, i8 >> 1, -25);
                                            iM2 = ((this.zzd + this.zzg) + (i10 >> 1)) - 25;
                                        }
                                        iM = FileInsert$$ExternalSyntheticOutline0.m(this.zzc, this.zzf, i8, -50);
                                        i4 = this.zzd;
                                        iM2 = this.zzg + i4;
                                        break;
                                    case -1012429441:
                                        i = 0;
                                        if (str2.equals("top-left")) {
                                            iM = this.zzf + this.zzc;
                                            i4 = this.zzd;
                                        } else {
                                            iM = FileInsert$$ExternalSyntheticOutline0.m(this.zzc, this.zzf, i8, -50);
                                            i4 = this.zzd;
                                        }
                                        iM2 = this.zzg + i4;
                                        break;
                                    case -655373719:
                                        i = 0;
                                        if (str2.equals("bottom-left")) {
                                            iM = this.zzf + this.zzc;
                                            i5 = this.zzd;
                                            iM2 = FileInsert$$ExternalSyntheticOutline0.m(i5, this.zzg, i10, -50);
                                        }
                                        iM = FileInsert$$ExternalSyntheticOutline0.m(this.zzc, this.zzf, i8, -50);
                                        i4 = this.zzd;
                                        iM2 = this.zzg + i4;
                                        break;
                                    case 1163912186:
                                        i = 0;
                                        if (str2.equals("bottom-right")) {
                                            iM = FileInsert$$ExternalSyntheticOutline0.m(this.zzc, this.zzf, i8, -50);
                                            i5 = this.zzd;
                                            iM2 = FileInsert$$ExternalSyntheticOutline0.m(i5, this.zzg, i10, -50);
                                        }
                                        iM = FileInsert$$ExternalSyntheticOutline0.m(this.zzc, this.zzf, i8, -50);
                                        i4 = this.zzd;
                                        iM2 = this.zzg + i4;
                                        break;
                                    case 1288627767:
                                        i = 0;
                                        if (str2.equals("bottom-center")) {
                                            iM = FileInsert$$ExternalSyntheticOutline0.m(this.zzc, this.zzf, i8 >> 1, -25);
                                            i5 = this.zzd;
                                            iM2 = FileInsert$$ExternalSyntheticOutline0.m(i5, this.zzg, i10, -50);
                                        }
                                        iM = FileInsert$$ExternalSyntheticOutline0.m(this.zzc, this.zzf, i8, -50);
                                        i4 = this.zzd;
                                        iM2 = this.zzg + i4;
                                        break;
                                    case 1755462605:
                                        if (str2.equals("top-center")) {
                                            iM = FileInsert$$ExternalSyntheticOutline0.m(this.zzc, this.zzf, i8 >> 1, -25);
                                            iM2 = this.zzd + this.zzg;
                                            i = 0;
                                            break;
                                        }
                                    default:
                                        i = 0;
                                        iM = FileInsert$$ExternalSyntheticOutline0.m(this.zzc, this.zzf, i8, -50);
                                        i4 = this.zzd;
                                        iM2 = this.zzg + i4;
                                        break;
                                }
                                if (iM < 0 || iM + 50 > i6 || iM2 < iArrZzW[i] || iM2 + 50 > iArrZzW[1]) {
                                }
                                if (iArr == null) {
                                    zzg("Resize location out of screen or close button is not visible.");
                                    return;
                                }
                                com.google.android.gms.ads.internal.client.zzay.zza();
                                int iZzE = com.google.android.gms.ads.internal.util.client.zzf.zzE(activity, this.zzh);
                                com.google.android.gms.ads.internal.client.zzay.zza();
                                int iZzE2 = com.google.android.gms.ads.internal.util.client.zzf.zzE(activity, this.zze);
                                ViewParent parent = ((View) zzckuVar).getParent();
                                if (!(parent instanceof ViewGroup)) {
                                    zzg("Webview is detached, probably in the middle of a resize or expand.");
                                    return;
                                }
                                ViewGroup viewGroup = (ViewGroup) parent;
                                viewGroup.removeView((View) zzckuVar);
                                PopupWindow popupWindow = this.zzp;
                                if (popupWindow == null) {
                                    this.zzr = viewGroup;
                                    com.google.android.gms.ads.internal.zzt.zzc();
                                    ((View) zzckuVar).setDrawingCacheEnabled(true);
                                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(((View) zzckuVar).getDrawingCache());
                                    ((View) zzckuVar).setDrawingCacheEnabled(i);
                                    ImageView imageView = new ImageView(activity);
                                    this.zzm = imageView;
                                    imageView.setImageBitmap(bitmapCreateBitmap);
                                    this.zzl = zzckuVar.zzN();
                                    this.zzr.addView(this.zzm);
                                } else {
                                    popupWindow.dismiss();
                                }
                                RelativeLayout relativeLayout = new RelativeLayout(activity);
                                this.zzq = relativeLayout;
                                relativeLayout.setBackgroundColor(0);
                                this.zzq.setLayoutParams(new ViewGroup.LayoutParams(iZzE, iZzE2));
                                com.google.android.gms.ads.internal.zzt.zzc();
                                PopupWindow popupWindow2 = new PopupWindow((View) this.zzq, iZzE, iZzE2, false);
                                this.zzp = popupWindow2;
                                popupWindow2.setOutsideTouchable(false);
                                this.zzp.setTouchable(true);
                                this.zzp.setClippingEnabled(!this.zzb);
                                this.zzq.addView((View) zzckuVar, -1, -1);
                                this.zzn = new LinearLayout(activity);
                                com.google.android.gms.ads.internal.client.zzay.zza();
                                int i13 = i2;
                                int iZzE3 = com.google.android.gms.ads.internal.util.client.zzf.zzE(activity, i13);
                                com.google.android.gms.ads.internal.client.zzay.zza();
                                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iZzE3, com.google.android.gms.ads.internal.util.client.zzf.zzE(activity, i13));
                                String str3 = this.zza;
                                switch (str3.hashCode()) {
                                    case -1364013995:
                                        if (!str3.equals("center")) {
                                            layoutParams.addRule(10);
                                            layoutParams.addRule(11);
                                        } else {
                                            layoutParams.addRule(13);
                                        }
                                        break;
                                    case -1012429441:
                                        if (str3.equals("top-left")) {
                                            layoutParams.addRule(10);
                                            layoutParams.addRule(9);
                                            break;
                                        }
                                        break;
                                    case -655373719:
                                        if (str3.equals("bottom-left")) {
                                            layoutParams.addRule(12);
                                            layoutParams.addRule(9);
                                            break;
                                        }
                                        break;
                                    case 1163912186:
                                        if (str3.equals("bottom-right")) {
                                            layoutParams.addRule(12);
                                            layoutParams.addRule(11);
                                            break;
                                        }
                                        break;
                                    case 1288627767:
                                        if (str3.equals("bottom-center")) {
                                            layoutParams.addRule(12);
                                            layoutParams.addRule(14);
                                            break;
                                        }
                                        break;
                                    case 1755462605:
                                        if (str3.equals("top-center")) {
                                            layoutParams.addRule(10);
                                            layoutParams.addRule(14);
                                            break;
                                        }
                                        break;
                                }
                                this.zzn.setOnClickListener(new zzbxy(this));
                                this.zzn.setContentDescription("Close button");
                                this.zzq.addView(this.zzn, layoutParams);
                                try {
                                    PopupWindow popupWindow3 = this.zzp;
                                    View decorView = window.getDecorView();
                                    com.google.android.gms.ads.internal.client.zzay.zza();
                                    int iZzE4 = com.google.android.gms.ads.internal.util.client.zzf.zzE(activity, iArr[0]);
                                    com.google.android.gms.ads.internal.client.zzay.zza();
                                    popupWindow3.showAtLocation(decorView, 0, iZzE4, com.google.android.gms.ads.internal.util.client.zzf.zzE(activity, iArr[1]));
                                    int i14 = iArr[0];
                                    int i15 = iArr[1];
                                    zzbyh zzbyhVar = this.zzo;
                                    if (zzbyhVar != null) {
                                        zzbyhVar.zza(i14, i15, this.zzh, this.zze);
                                    }
                                    this.zzj.zzaf(zzcne.zzc(iZzE, iZzE2));
                                    int i16 = iArr[0];
                                    int i17 = iArr[1];
                                    com.google.android.gms.ads.internal.zzt.zzc();
                                    zzi(i16, i17 - com.google.android.gms.ads.internal.util.zzs.zzW(this.zzk)[0], this.zzh, this.zze);
                                    zzk("resized");
                                    return;
                                } catch (RuntimeException e) {
                                    String message = e.getMessage();
                                    StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 26);
                                    sb.append("Cannot show popup window: ");
                                    sb.append(message);
                                    zzg(sb.toString());
                                    RelativeLayout relativeLayout2 = this.zzq;
                                    zzcku zzckuVar2 = this.zzj;
                                    relativeLayout2.removeView((View) zzckuVar2);
                                    ViewGroup viewGroup2 = this.zzr;
                                    if (viewGroup2 != null) {
                                        viewGroup2.removeView(this.zzm);
                                        this.zzr.addView((View) zzckuVar2);
                                        zzckuVar2.zzaf(this.zzl);
                                    }
                                    return;
                                }
                            }
                            i = 0;
                            i2 = 50;
                            if (z) {
                                iArr = new int[]{this.zzc + this.zzf, this.zzd + this.zzg};
                            } else {
                                com.google.android.gms.ads.internal.zzt.zzc();
                                int[] iArrZzaa2 = com.google.android.gms.ads.internal.util.zzs.zzaa(activity);
                                com.google.android.gms.ads.internal.zzt.zzc();
                                int[] iArrZzW2 = com.google.android.gms.ads.internal.util.zzs.zzW(activity);
                                int i18 = iArrZzaa2[i];
                                int i19 = this.zzc + this.zzf;
                                int i20 = this.zzd + this.zzg;
                                if (i19 < 0) {
                                    i3 = i;
                                } else {
                                    int i21 = this.zzh;
                                    i3 = i19 + i21 > i18 ? i18 - i21 : i19;
                                }
                                int i22 = iArrZzW2[i];
                                if (i20 < i22) {
                                    i20 = i22;
                                } else {
                                    int i23 = this.zze;
                                    int i24 = i20 + i23;
                                    int i25 = iArrZzW2[1];
                                    if (i24 > i25) {
                                        i20 = i25 - i23;
                                    }
                                }
                                iArr = new int[]{i3, i20};
                            }
                            if (iArr == null) {
                            }
                        }
                    }
                    iArr = null;
                    if (iArr == null) {
                    }
                }
                zzg("Activity context is not ready, cannot get window or decor view.");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzb(final boolean z) {
        synchronized (this.zzi) {
            try {
                if (this.zzp != null) {
                    if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzmk)).booleanValue() || Looper.getMainLooper().getThread() == Thread.currentThread()) {
                        zzf(z);
                    } else {
                        zzcfr.zzf.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbxz
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                this.zza.zzf(z);
                            }
                        });
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzc(int i, int i2, boolean z) {
        synchronized (this.zzi) {
            this.zzc = i;
            this.zzd = i2;
        }
    }

    public final boolean zzd() {
        boolean z;
        synchronized (this.zzi) {
            z = this.zzp != null;
        }
        return z;
    }

    public final void zze(int i, int i2) {
        this.zzc = i;
        this.zzd = i2;
    }
}
