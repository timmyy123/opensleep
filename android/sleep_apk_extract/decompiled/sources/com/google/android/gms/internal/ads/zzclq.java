package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.Predicate;
import com.google.common.util.concurrent.ListenableFuture;
import com.philips.lighting.hue.sdk.utilities.impl.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import oauth.signpost.OAuth;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class zzclq extends FrameLayout implements zzcku {
    private final zzcku zza;
    private final zzchc zzb;
    private final AtomicBoolean zzc;

    /* JADX WARN: Multi-variable type inference failed */
    public zzclq(zzcku zzckuVar, zzdzl zzdzlVar) {
        super(zzckuVar.getContext());
        this.zzc = new AtomicBoolean();
        this.zza = zzckuVar;
        this.zzb = new zzchc(zzckuVar.zzK(), this, this, zzdzlVar);
        addView((View) zzckuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final boolean canGoBack() {
        return this.zza.canGoBack();
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void destroy() {
        final zzell zzellVarZzV;
        final zzeln zzelnVarZzU = zzU();
        if (zzelnVarZzU != null) {
            zzgam zzgamVar = com.google.android.gms.ads.internal.util.zzs.zza;
            zzgamVar.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzclp
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    com.google.android.gms.ads.internal.zzt.zzu().zzf(zzelnVarZzU.zza());
                }
            });
            final zzcku zzckuVar = this.zza;
            Objects.requireNonNull(zzckuVar);
            zzgamVar.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzclm
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzckuVar.destroy();
                }
            }, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgl)).intValue());
            return;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgn)).booleanValue() || (zzellVarZzV = zzV()) == null) {
            this.zza.destroy();
        } else {
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcln
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    final zzclq zzclqVar = this.zza;
                    zzellVarZzV.zze(new zzfuv() { // from class: com.google.android.gms.internal.ads.zzclo
                        @Override // com.google.android.gms.internal.ads.zzfuv
                        public final /* synthetic */ void zza(boolean z) {
                            zzclqVar.zzaM(true);
                        }
                    });
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void goBack() {
        this.zza.goBack();
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void loadData(String str, String str2, String str3) {
        this.zza.loadData(str, "text/html", str3);
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.zza.loadDataWithBaseURL(str, str2, "text/html", OAuth.ENCODING, null);
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void loadUrl(String str) {
        this.zza.loadUrl(str);
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        zzcku zzckuVar = this.zza;
        if (zzckuVar != null) {
            zzckuVar.onAdClicked();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void onPause() {
        this.zzb.zze();
        this.zza.onPause();
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void onResume() {
        this.zza.onResume();
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzcku
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zza.setOnClickListener(onClickListener);
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzcku
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.zza.setOnTouchListener(onTouchListener);
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.zza.setWebChromeClient(webChromeClient);
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void setWebViewClient(WebViewClient webViewClient) {
        this.zza.setWebViewClient(webViewClient);
    }

    @Override // com.google.android.gms.internal.ads.zzchn
    public final void zzA(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzchn
    public final void zzB(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzcku, com.google.android.gms.internal.ads.zzckl
    public final zzfkf zzC() {
        return this.zza.zzC();
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final WebView zzD() {
        return (WebView) this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzcku, com.google.android.gms.internal.ads.zzcmp
    public final View zzE() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final List zzF() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt != this.zza) {
                arrayList.add(childAt);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzG() {
        this.zza.zzG();
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzH(int i) {
        this.zza.zzH(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzI() {
        this.zza.zzI();
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzJ() {
        this.zza.zzJ();
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final Context zzK() {
        return this.zza.zzK();
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final com.google.android.gms.ads.internal.overlay.zzm zzL() {
        return this.zza.zzL();
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final com.google.android.gms.ads.internal.overlay.zzm zzM() {
        return this.zza.zzM();
    }

    @Override // com.google.android.gms.internal.ads.zzcku, com.google.android.gms.internal.ads.zzcmm
    public final zzcne zzN() {
        return this.zza.zzN();
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final String zzO() {
        return this.zza.zzO();
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final zzcms zzP() {
        return ((zzclx) this.zza).zzaS();
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final WebViewClient zzQ() {
        return this.zza.zzQ();
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final boolean zzR() {
        return this.zza.zzR();
    }

    @Override // com.google.android.gms.internal.ads.zzcku, com.google.android.gms.internal.ads.zzcmn
    public final zzbap zzS() {
        return this.zza.zzS();
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final zzflc zzT() {
        return this.zza.zzT();
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final zzeln zzU() {
        return this.zza.zzU();
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final zzell zzV() {
        return this.zza.zzV();
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final boolean zzW() {
        return this.zza.zzW();
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final boolean zzX() {
        return this.zza.zzX();
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzY() {
        this.zzb.zzf();
        this.zza.zzY();
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final boolean zzZ() {
        return this.zza.zzZ();
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zza(String str) {
        ((zzclx) this.zza).zzaP(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.ads.zzcku
    public final boolean zzaA(boolean z, int i) {
        if (!this.zzc.compareAndSet(false, true)) {
            return true;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzbx)).booleanValue()) {
            return false;
        }
        zzcku zzckuVar = this.zza;
        if (zzckuVar.getParent() instanceof ViewGroup) {
            ((ViewGroup) zzckuVar.getParent()).removeView((View) zzckuVar);
        }
        zzckuVar.zzaA(z, i);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final boolean zzaB() {
        return this.zzc.get();
    }

    @Override // com.google.android.gms.internal.ads.zzcku, com.google.android.gms.internal.ads.zzcmb
    public final zzfki zzaC() {
        return this.zza.zzaC();
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzaD(zzfkf zzfkfVar, zzfki zzfkiVar) {
        this.zza.zzaD(zzfkfVar, zzfkiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzaE(boolean z) {
        this.zza.zzaE(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final ListenableFuture zzaF() {
        return this.zza.zzaF();
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzaG(boolean z) {
        this.zza.zzaG(true);
    }

    @Override // com.google.android.gms.internal.ads.zzcmk
    public final void zzaH(com.google.android.gms.ads.internal.overlay.zzc zzcVar, boolean z, boolean z2, String str) {
        this.zza.zzaH(zzcVar, z, z2, str);
    }

    @Override // com.google.android.gms.internal.ads.zzcmk
    public final void zzaI(boolean z, int i, boolean z2) {
        this.zza.zzaI(z, i, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzcmk
    public final void zzaJ(boolean z, int i, String str, boolean z2, boolean z3) {
        this.zza.zzaJ(z, i, str, z2, z3);
    }

    @Override // com.google.android.gms.internal.ads.zzcmk
    public final void zzaK(boolean z, int i, String str, String str2, boolean z2) {
        this.zza.zzaK(z, i, str, str2, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzcmk
    public final void zzaL(String str, String str2, int i) {
        this.zza.zzaL(str, str2, 14);
    }

    public final /* synthetic */ void zzaM(boolean z) {
        final zzcku zzckuVar = this.zza;
        zzgam zzgamVar = com.google.android.gms.ads.internal.util.zzs.zza;
        Objects.requireNonNull(zzckuVar);
        zzgamVar.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcll
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzckuVar.destroy();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final boolean zzaa() {
        return this.zza.zzaa();
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzab(String str, zzbpq zzbpqVar) {
        this.zza.zzab(str, zzbpqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzac(String str, zzbpq zzbpqVar) {
        this.zza.zzac(str, zzbpqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzad(String str, Predicate predicate) {
        this.zza.zzad(str, predicate);
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzae(com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        this.zza.zzae(zzmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzaf(zzcne zzcneVar) {
        this.zza.zzaf(zzcneVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzag(boolean z) {
        this.zza.zzag(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzah() {
        this.zza.zzah();
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzai(Context context) {
        this.zza.zzai(context);
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzaj(boolean z) {
        this.zza.zzaj(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzak(zzeln zzelnVar) {
        this.zza.zzak(zzelnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzal(zzell zzellVar) {
        this.zza.zzal(zzellVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzam(int i) {
        this.zza.zzam(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzan(com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        this.zza.zzan(zzmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzao(boolean z) {
        this.zza.zzao(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzap() {
        this.zza.zzap();
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzaq(zzblr zzblrVar) {
        this.zza.zzaq(zzblrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final zzblr zzar() {
        return this.zza.zzar();
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzas(boolean z) {
        this.zza.zzas(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzat() {
        setBackgroundColor(0);
        this.zza.setBackgroundColor(0);
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzau(String str, String str2, String str3) {
        this.zza.zzau(str, str2, null);
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzav() {
        zzeln zzelnVarZzU;
        zzell zzellVarZzV;
        TextView textView = new TextView(getContext());
        com.google.android.gms.ads.internal.zzt.zzc();
        textView.setText(com.google.android.gms.ads.internal.util.zzs.zzB());
        textView.setTextSize(15.0f);
        textView.setTextColor(-1);
        textView.setPadding(5, 0, 5, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.DKGRAY);
        gradientDrawable.setCornerRadius(8.0f);
        textView.setBackground(gradientDrawable);
        addView(textView, new FrameLayout.LayoutParams(-2, -2, 49));
        bringChildToFront(textView);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgn)).booleanValue() && (zzellVarZzV = zzV()) != null) {
            zzellVarZzV.zzf(textView);
        } else if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgm)).booleanValue() && (zzelnVarZzU = zzU()) != null && zzelnVarZzU.zzb()) {
            com.google.android.gms.ads.internal.zzt.zzu().zzg(zzelnVarZzU.zza(), textView);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzaw(boolean z) {
        this.zza.zzaw(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzax(zzblo zzbloVar) {
        this.zza.zzax(zzbloVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final void zzay(zzbgd zzbgdVar) {
        this.zza.zzay(zzbgdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcku
    public final zzbgd zzaz() {
        return this.zza.zzaz();
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zzb(String str, JSONObject jSONObject) {
        ((zzclx) this.zza).zzc(str, jSONObject.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zzc(String str, String str2) {
        this.zza.zzc("window.inspectorInfo", str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbsm
    public final void zzd(String str, JSONObject jSONObject) {
        this.zza.zzd(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzdky
    public final void zzdR() {
        zzcku zzckuVar = this.zza;
        if (zzckuVar != null) {
            zzckuVar.zzdR();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbeq
    public final void zzdj(zzbep zzbepVar) {
        this.zza.zzdj(zzbepVar);
    }

    @Override // com.google.android.gms.ads.internal.zzn
    public final void zzdk() {
        this.zza.zzdk();
    }

    @Override // com.google.android.gms.ads.internal.zzn
    public final void zzdl() {
        this.zza.zzdl();
    }

    @Override // com.google.android.gms.internal.ads.zzchn
    public final zzchc zzdm() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzchn
    public final void zzdn(boolean z) {
        this.zza.zzdn(false);
    }

    @Override // com.google.android.gms.internal.ads.zzdky
    public final void zzdu() {
        zzcku zzckuVar = this.zza;
        if (zzckuVar != null) {
            zzckuVar.zzdu();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsm
    public final void zze(String str, Map map) {
        this.zza.zze(str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzcku, com.google.android.gms.internal.ads.zzchn
    public final zzcma zzh() {
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzchn
    public final zzbjc zzi() {
        return this.zza.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzcku, com.google.android.gms.internal.ads.zzcmg, com.google.android.gms.internal.ads.zzchn
    public final Activity zzj() {
        return this.zza.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzcku, com.google.android.gms.internal.ads.zzchn
    public final com.google.android.gms.ads.internal.zza zzk() {
        return this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzchn
    public final void zzl() {
        this.zza.zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzchn
    public final String zzm() {
        return this.zza.zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzchn
    public final String zzn() {
        return this.zza.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzchn
    public final void zzo(int i) {
        this.zza.zzo(i);
    }

    @Override // com.google.android.gms.internal.ads.zzchn
    public final int zzp() {
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzcku, com.google.android.gms.internal.ads.zzchn
    public final zzbjd zzq() {
        return this.zza.zzq();
    }

    @Override // com.google.android.gms.internal.ads.zzchn
    public final zzcja zzr(String str) {
        return this.zza.zzr(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcku, com.google.android.gms.internal.ads.zzcmo, com.google.android.gms.internal.ads.zzchn
    public final VersionInfoParcel zzs() {
        return this.zza.zzs();
    }

    @Override // com.google.android.gms.internal.ads.zzcku, com.google.android.gms.internal.ads.zzchn
    public final void zzt(String str, zzcja zzcjaVar) {
        this.zza.zzt(str, zzcjaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzchn
    public final void zzu(boolean z, long j) {
        this.zza.zzu(z, j);
    }

    @Override // com.google.android.gms.internal.ads.zzchn
    public final void zzv(int i) {
        this.zzb.zzg(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcku, com.google.android.gms.internal.ads.zzchn
    public final void zzw(zzcma zzcmaVar) {
        this.zza.zzw(zzcmaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzchn
    public final int zzx() {
        return ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzeL)).booleanValue() ? this.zza.getMeasuredHeight() : getMeasuredHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzchn
    public final int zzy() {
        return ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzeL)).booleanValue() ? this.zza.getMeasuredWidth() : getMeasuredWidth();
    }

    @Override // com.google.android.gms.internal.ads.zzchn
    public final void zzz() {
        this.zza.zzz();
    }
}
