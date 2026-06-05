package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
final class zzgii extends zzgix {
    private final Context zza;

    public zzgii(zzaxm zzaxmVar, zzght zzghtVar, Context context, zzgqh zzgqhVar) {
        super("oPdLdhb7u3yhL0H4stSlq4J5+zu0hSfWU/8UAjsk/lyj10+V9FvGXbYfhf9vKrdX", "5RX+K+L/30Yl3K6xXlprdD5z7VBWrJlQaCLdeoJJHfI=", zzaxmVar, zzghtVar, zzgqhVar.zza(115));
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzgix
    public final void zza(Method method, zzaxm zzaxmVar) {
        Object[] objArr = (Object[]) method.invoke("", this.zza);
        objArr.getClass();
        synchronized (zzaxmVar) {
            try {
                zzaxmVar.zzO(((Integer) objArr[0]).intValue());
                int i = 1;
                zzaxmVar.zzd(((Integer) objArr[1]).intValue());
                zzaxmVar.zze(((Integer) objArr[2]).intValue());
                zzaxmVar.zzab(((Integer) objArr[3]).intValue());
                Boolean bool = (Boolean) objArr[4];
                if (bool == null) {
                    zzaxmVar.zzaf(3);
                } else {
                    zzaxmVar.zzaf(true != bool.booleanValue() ? 1 : 2);
                }
                Boolean bool2 = (Boolean) objArr[5];
                if (bool2 == null) {
                    zzaxmVar.zzae(3);
                } else {
                    if (true == bool2.booleanValue()) {
                        i = 2;
                    }
                    zzaxmVar.zzae(i);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
