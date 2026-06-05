package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.Predicate;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: loaded from: classes3.dex */
@ParametersAreNonnullByDefault
public interface zzcku extends com.google.android.gms.ads.internal.client.zza, zzdky, zzckl, zzbsm, zzcmb, zzcmg, zzbsy, zzbeq, zzcmk, com.google.android.gms.ads.internal.zzn, zzcmn, zzcmo, zzchn, zzcmp {
    boolean canGoBack();

    void destroy();

    @Override // com.google.android.gms.internal.ads.zzcmg, com.google.android.gms.internal.ads.zzchn
    Context getContext();

    int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    int getMeasuredHeight();

    int getMeasuredWidth();

    ViewParent getParent();

    int getWidth();

    void goBack();

    boolean isAttachedToWindow();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    void measure(int i, int i2);

    void onPause();

    void onResume();

    @Override // com.google.android.gms.internal.ads.zzchn
    void setBackgroundColor(int i);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    @Override // com.google.android.gms.internal.ads.zzckl
    zzfkf zzC();

    WebView zzD();

    @Override // com.google.android.gms.internal.ads.zzcmp
    View zzE();

    List zzF();

    void zzG();

    void zzH(int i);

    void zzI();

    void zzJ();

    Context zzK();

    com.google.android.gms.ads.internal.overlay.zzm zzL();

    com.google.android.gms.ads.internal.overlay.zzm zzM();

    @Override // com.google.android.gms.internal.ads.zzcmm
    zzcne zzN();

    String zzO();

    zzcms zzP();

    WebViewClient zzQ();

    boolean zzR();

    @Override // com.google.android.gms.internal.ads.zzcmn
    zzbap zzS();

    zzflc zzT();

    zzeln zzU();

    zzell zzV();

    boolean zzW();

    boolean zzX();

    void zzY();

    boolean zzZ();

    boolean zzaA(boolean z, int i);

    boolean zzaB();

    @Override // com.google.android.gms.internal.ads.zzcmb
    zzfki zzaC();

    void zzaD(zzfkf zzfkfVar, zzfki zzfkiVar);

    void zzaE(boolean z);

    ListenableFuture zzaF();

    void zzaG(boolean z);

    boolean zzaa();

    void zzab(String str, zzbpq zzbpqVar);

    void zzac(String str, zzbpq zzbpqVar);

    void zzad(String str, Predicate predicate);

    void zzae(com.google.android.gms.ads.internal.overlay.zzm zzmVar);

    void zzaf(zzcne zzcneVar);

    void zzag(boolean z);

    void zzah();

    void zzai(Context context);

    void zzaj(boolean z);

    void zzak(zzeln zzelnVar);

    void zzal(zzell zzellVar);

    void zzam(int i);

    void zzan(com.google.android.gms.ads.internal.overlay.zzm zzmVar);

    void zzao(boolean z);

    void zzap();

    void zzaq(zzblr zzblrVar);

    zzblr zzar();

    void zzas(boolean z);

    void zzat();

    void zzau(String str, String str2, String str3);

    void zzav();

    void zzaw(boolean z);

    void zzax(zzblo zzbloVar);

    void zzay(zzbgd zzbgdVar);

    zzbgd zzaz();

    @Override // com.google.android.gms.internal.ads.zzchn
    zzcma zzh();

    @Override // com.google.android.gms.internal.ads.zzcmg, com.google.android.gms.internal.ads.zzchn
    Activity zzj();

    @Override // com.google.android.gms.internal.ads.zzchn
    com.google.android.gms.ads.internal.zza zzk();

    @Override // com.google.android.gms.internal.ads.zzchn
    zzbjd zzq();

    @Override // com.google.android.gms.internal.ads.zzcmo, com.google.android.gms.internal.ads.zzchn
    VersionInfoParcel zzs();

    @Override // com.google.android.gms.internal.ads.zzchn
    void zzt(String str, zzcja zzcjaVar);

    @Override // com.google.android.gms.internal.ads.zzchn
    void zzw(zzcma zzcmaVar);
}
