package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.util.Log;
import android.webkit.WebSettings;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcr {
    private final Application zzd;
    private final zzco zze;
    private final Executor zzf;
    private final boolean zzg;
    private final AtomicReference zzh = new AtomicReference(new ArrayDeque());
    public final AtomicReference zzb = new AtomicReference(new ArrayDeque());
    private final AtomicReference zzi = new AtomicReference(new ArrayDeque());
    private final AtomicReference zzj = new AtomicReference(new ArrayDeque());
    private final AtomicReference zzk = new AtomicReference(new ArrayDeque());
    private final AtomicReference zzl = new AtomicReference(new ArrayDeque());
    public final AtomicReference zzc = new AtomicReference(new ArrayDeque());
    final AtomicReference zza = new AtomicReference(null);

    public zzcr(zzad zzadVar, Application application, Executor executor, zzco zzcoVar, boolean z) {
        this.zzg = z;
        this.zzd = application;
        this.zze = zzcoVar;
        this.zzf = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzl() {
        String str = (String) this.zza.get();
        if (str == null) {
            Log.w("UserMessagingPlatform", "Metrics reporting URL is not set yet.");
            return;
        }
        AtomicReference atomicReference = this.zzl;
        int size = ((Queue) atomicReference.get()).size();
        for (int i = 0; i < size; i++) {
            zzif zzifVar = (zzif) ((Queue) atomicReference.get()).poll();
            if (zzifVar != null) {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URI(str).toURL().openConnection();
                    httpURLConnection.setRequestProperty("User-Agent", WebSettings.getDefaultUserAgent(this.zzd));
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setReadTimeout(30000);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("Content-Type", "application/protobuf");
                    zzifVar.zzE(httpURLConnection.getOutputStream());
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode != 200 && responseCode != 204) {
                        Log.w("UserMessagingPlatform", "Fail to ping metrics reporting URL: Http error code - " + responseCode + ".\n" + (httpURLConnection.getErrorStream() != null ? new Scanner(httpURLConnection.getErrorStream()).useDelimiter("\\A").next() : null));
                        ((Queue) atomicReference.get()).add(zzifVar);
                    }
                } catch (IOException e) {
                    Log.w("UserMessagingPlatform", "Fail to ping metrics reporting URL: ".concat(String.valueOf(e.getMessage())));
                    ((Queue) this.zzl.get()).add(zzifVar);
                } catch (URISyntaxException e2) {
                    Log.w("UserMessagingPlatform", "Metrics reporting URL " + str + " is not valid: " + e2.getMessage());
                }
            }
        }
    }

    private final void zzm(Queue queue, int i, int i2, String str) {
        Long l = (Long) queue.poll();
        if (l != null) {
            long jCurrentTimeMillis = System.currentTimeMillis() - l.longValue();
            if (str != null) {
                i = i2;
            }
            AtomicReference atomicReference = this.zzl;
            ((Queue) atomicReference.get()).add(this.zze.zza(i, str, jCurrentTimeMillis));
            if (this.zzg) {
                ((ArrayDeque) this.zzc.get()).addAll((Collection) atomicReference.get());
            }
            this.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.consent_sdk.zzcq
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzl();
                }
            });
        }
    }

    public final void zzb(String str) {
        zzm((Queue) this.zzj.get(), 10, 11, str);
    }

    public final void zzc() {
        ((Queue) this.zzj.get()).add(Long.valueOf(System.currentTimeMillis()));
    }

    public final void zzd(String str) {
        zzm((Queue) this.zzb.get(), 4, 5, str);
    }

    public final void zze(String str) {
        zzm((Queue) this.zzi.get(), 6, 7, str);
    }

    public final void zzf() {
        ((Queue) this.zzi.get()).add(Long.valueOf(System.currentTimeMillis()));
    }

    public final void zzg(String str) {
        zzm((Queue) this.zzh.get(), 8, 9, str);
    }

    public final void zzh() {
        ((Queue) this.zzh.get()).add(Long.valueOf(System.currentTimeMillis()));
    }

    public final void zzi() {
        ((Queue) this.zzk.get()).add(Long.valueOf(System.currentTimeMillis()));
    }

    public final void zzj() {
        zzm((Queue) this.zzk.get(), 3, 2, null);
    }

    public final void zzk(String str) {
        this.zza.set(str);
    }
}
