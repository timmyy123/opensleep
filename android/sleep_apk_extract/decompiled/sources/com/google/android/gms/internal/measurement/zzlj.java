package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public final class zzlj {
    private Context zza;
    private Supplier zzb;
    private Supplier zzc;
    private Supplier zzd;
    private Supplier zze;
    private Supplier zzf;

    public /* synthetic */ zzlj(byte[] bArr) {
    }

    public final zzlj zza(Context context) {
        this.zza = context;
        return this;
    }

    public final zzlk zzb() {
        Preconditions.checkNotNull(this.zza);
        if (this.zzb == null) {
            this.zzb = zzlk.zzf;
        }
        if (this.zzc == null) {
            final Context context = this.zza;
            int i = zzlk.$r8$clinit;
            this.zzc = Suppliers.memoize(new Supplier() { // from class: com.google.android.gms.internal.measurement.zzln
                @Override // com.google.common.base.Supplier
                public final /* synthetic */ Object get() {
                    int i2 = zzlk.$r8$clinit;
                    return new zzmn(zzjx.zza(context));
                }
            });
        }
        if (this.zzd == null) {
            this.zzd = new Supplier() { // from class: com.google.android.gms.internal.measurement.zzli
                @Override // com.google.common.base.Supplier
                public final /* synthetic */ Object get() {
                    return this.zza.zzc();
                }
            };
        }
        if (this.zze == null) {
            Context context2 = this.zza;
            int i2 = zzlk.$r8$clinit;
            final ArrayList arrayList = new ArrayList();
            Collections.addAll(arrayList, zzrx.zza(context2).zza(), new zzsd());
            this.zze = Suppliers.memoize(new Supplier() { // from class: com.google.android.gms.internal.measurement.zzlm
                @Override // com.google.common.base.Supplier
                public final /* synthetic */ Object get() {
                    int i3 = zzlk.$r8$clinit;
                    return new zzru(arrayList);
                }
            });
        }
        if (this.zzf == null) {
            this.zzf = new Supplier() { // from class: com.google.android.gms.internal.measurement.zzlh
                @Override // com.google.common.base.Supplier
                public final /* synthetic */ Object get() {
                    return this.zza.zzd();
                }
            };
        }
        return new zzlk(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, null);
    }

    public final /* synthetic */ Optional zzc() {
        return Optional.of(new zzqi(this.zzb, 10));
    }

    public final /* synthetic */ Optional zzd() {
        Context context = this.zza;
        int i = zzlk.$r8$clinit;
        try {
            return Optional.of(context.getPackageManager().getApplicationInfo("com.google.android.gms", 0));
        } catch (PackageManager.NameNotFoundException unused) {
            return Optional.absent();
        }
    }
}
