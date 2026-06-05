package com.google.android.gms.internal.ads;

import androidx.datastore.core.DataStore;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgce implements zzgau {
    private final CoroutineScope zza;
    private final zzgsm zzb;
    private final Mutex zzc;
    private final Mutex zzd;
    private final Mutex zze;
    private boolean zzf;
    private zzgas zzg;
    private boolean zzh;
    private final DataStore zzi;
    private final zzdww zzj;

    public zzgce(DataStore dataStore, zzgbg zzgbgVar, zzdww zzdwwVar, zzgbd zzgbdVar) {
        dataStore.getClass();
        zzgbgVar.getClass();
        zzdwwVar.getClass();
        zzgbdVar.getClass();
        this.zzj = zzdwwVar;
        this.zza = zzgbgVar.zza();
        this.zzb = new zzgsm();
        this.zzc = MutexKt.Mutex$default(false, 1, null);
        this.zzd = MutexKt.Mutex$default(false, 1, null);
        this.zze = MutexKt.Mutex$default(false, 1, null);
        this.zzi = dataStore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzA(Continuation continuation) throws Throwable {
        zzgbm zzgbmVar;
        Mutex mutex;
        Throwable th;
        Mutex mutex2;
        if (continuation instanceof zzgbm) {
            zzgbmVar = (zzgbm) continuation;
            int i = zzgbmVar.zzd;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzgbmVar.zzd = i - Integer.MIN_VALUE;
            } else {
                zzgbmVar = new zzgbm(this, continuation);
            }
        }
        Object obj = zzgbmVar.zzb;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzgbmVar.zzd;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = this.zze;
                zzgbmVar.zza = mutex;
                zzgbmVar.zzd = 1;
                if (mutex.lock(null, zzgbmVar) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                mutex2 = (Mutex) zzgbmVar.zza;
                try {
                    ResultKt.throwOnFailure(obj);
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            Mutex mutex3 = (Mutex) zzgbmVar.zza;
            ResultKt.throwOnFailure(obj);
            mutex = mutex3;
            DataStore dataStore = this.zzi;
            zzgbn zzgbnVar = new zzgbn(null);
            zzgbmVar.zza = mutex;
            zzgbmVar.zzd = 2;
            Object objUpdateData = dataStore.updateData(zzgbnVar, zzgbmVar);
            if (objUpdateData != coroutine_suspended) {
                Mutex mutex4 = mutex;
                obj = objUpdateData;
                mutex2 = mutex4;
                mutex2.unlock(null);
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            Mutex mutex5 = mutex;
            th = th3;
            mutex2 = mutex5;
            mutex2.unlock(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzB(long j, Continuation continuation) {
        zzgbl zzgblVar;
        Mutex mutex;
        if (continuation instanceof zzgbl) {
            zzgblVar = (zzgbl) continuation;
            int i = zzgblVar.zze;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzgblVar.zze = i - Integer.MIN_VALUE;
            } else {
                zzgblVar = new zzgbl(this, continuation);
            }
        }
        Object obj = zzgblVar.zzc;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzgblVar.zze;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex mutex2 = this.zzc;
            zzgblVar.zzb = mutex2;
            zzgblVar.zza = j;
            zzgblVar.zze = 1;
            if (mutex2.lock(null, zzgblVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex = mutex2;
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            j = zzgblVar.zza;
            mutex = (Mutex) zzgblVar.zzb;
            ResultKt.throwOnFailure(obj);
        }
        try {
            zzgas zzgasVar = this.zzg;
            if (zzgasVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                zzgasVar = null;
            }
            zzgas zzgasVar2 = this.zzg;
            if (zzgasVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                zzgasVar2 = null;
            }
            long jZzi = j - zzgasVar2.zzi();
            zzgas zzgasVar3 = this.zzg;
            if (zzgasVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                zzgasVar3 = null;
            }
            zzgasVar.zzb(jZzi - zzgasVar3.zzg());
            mutex.unlock(null);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutex.unlock(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzC(Continuation continuation) throws Throwable {
        zzgbq zzgbqVar;
        Mutex mutex;
        Mutex mutex2;
        zzgat zzgatVar;
        Throwable th;
        Mutex mutex3;
        if (continuation instanceof zzgbq) {
            zzgbqVar = (zzgbq) continuation;
            int i = zzgbqVar.zze;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzgbqVar.zze = i - Integer.MIN_VALUE;
            } else {
                zzgbqVar = new zzgbq(this, continuation);
            }
        }
        Object objUpdateData = zzgbqVar.zzc;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzgbqVar.zze;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objUpdateData);
                mutex = this.zzc;
                zzgbqVar.zza = mutex;
                zzgbqVar.zze = 1;
                if (mutex.lock(null, zzgbqVar) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    mutex3 = (Mutex) zzgbqVar.zza;
                    try {
                        ResultKt.throwOnFailure(objUpdateData);
                        mutex3.unlock(null);
                        return Unit.INSTANCE;
                    } catch (Throwable th2) {
                        th = th2;
                        mutex3.unlock(null);
                        throw th;
                    }
                }
                mutex2 = (Mutex) zzgbqVar.zzb;
                zzgatVar = (zzgat) zzgbqVar.zza;
                ResultKt.throwOnFailure(objUpdateData);
                try {
                    DataStore dataStore = this.zzi;
                    zzgbr zzgbrVar = new zzgbr(zzgatVar, null);
                    zzgbqVar.zza = mutex2;
                    zzgbqVar.zzb = null;
                    zzgbqVar.zze = 3;
                    objUpdateData = dataStore.updateData(zzgbrVar, zzgbqVar);
                    if (objUpdateData != coroutine_suspended) {
                        mutex3 = mutex2;
                        mutex3.unlock(null);
                        return Unit.INSTANCE;
                    }
                    return coroutine_suspended;
                } catch (Throwable th3) {
                    th = th3;
                    mutex3 = mutex2;
                    mutex3.unlock(null);
                    throw th;
                }
            }
            mutex = (Mutex) zzgbqVar.zza;
            ResultKt.throwOnFailure(objUpdateData);
            zzgas zzgasVar = this.zzg;
            if (zzgasVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                zzgasVar = null;
            }
            zzgat zzgatVar2 = (zzgat) zzgasVar.zzbm();
            mutex.unlock(null);
            zzgatVar2.getClass();
            mutex2 = this.zze;
            zzgbqVar.zza = zzgatVar2;
            zzgbqVar.zzb = mutex2;
            zzgbqVar.zze = 2;
            if (mutex2.lock(null, zzgbqVar) != coroutine_suspended) {
                zzgatVar = zzgatVar2;
                DataStore dataStore2 = this.zzi;
                zzgbr zzgbrVar2 = new zzgbr(zzgatVar, null);
                zzgbqVar.zza = mutex2;
                zzgbqVar.zzb = null;
                zzgbqVar.zze = 3;
                objUpdateData = dataStore2.updateData(zzgbrVar2, zzgbqVar);
                if (objUpdateData != coroutine_suspended) {
                }
            }
            return coroutine_suspended;
        } catch (Throwable th4) {
            mutex.unlock(null);
            throw th4;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final boolean zzD(zzgat zzgatVar) {
        boolean z;
        List listZzk = zzgatVar.zzk();
        Long l = listZzk != null ? (Long) CollectionsKt.lastOrNull(listZzk) : null;
        boolean z2 = zzgatVar.zzl() > zzgatVar.zzm() && !zzgatVar.zzd();
        if (l != null) {
            z = zzgatVar.zzi() - l.longValue() > 5000;
        }
        return z2 || z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c8, code lost:
    
        if (zzA(r0) == r1) goto L49;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v5, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.google.android.gms.internal.ads.zzgce] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzs(Continuation continuation) {
        zzgbz zzgbzVar;
        Mutex mutex;
        zzgax zzgaxVar;
        if (continuation instanceof zzgbz) {
            zzgbzVar = (zzgbz) continuation;
            int i = zzgbzVar.zzd;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzgbzVar.zzd = i - Integer.MIN_VALUE;
            } else {
                zzgbzVar = new zzgbz(this, continuation);
            }
        }
        Object objFirstOrNull = zzgbzVar.zzb;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r2 = zzgbzVar.zzd;
        try {
            if (r2 == 0) {
                ResultKt.throwOnFailure(objFirstOrNull);
                Mutex mutex2 = this.zze;
                zzgbzVar.zza = mutex2;
                zzgbzVar.zzd = 1;
                if (mutex2.lock(null, zzgbzVar) != coroutine_suspended) {
                    mutex = mutex2;
                }
                return coroutine_suspended;
            }
            if (r2 == 1) {
                Mutex mutex3 = (Mutex) zzgbzVar.zza;
                ResultKt.throwOnFailure(objFirstOrNull);
                mutex = mutex3;
            } else {
                if (r2 != 2) {
                    if (r2 == 3) {
                        ResultKt.throwOnFailure(objFirstOrNull);
                        return Unit.INSTANCE;
                    }
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                Mutex mutex4 = (Mutex) zzgbzVar.zza;
                ResultKt.throwOnFailure(objFirstOrNull);
                r2 = mutex4;
                zzgaxVar = (zzgax) objFirstOrNull;
                if (zzgaxVar != null || zzgaxVar.zza() == 0) {
                    return Unit.INSTANCE;
                }
                for (Map.Entry entry : zzgaxVar.zzb().entrySet()) {
                    zzidy zzidyVarZzbp = ((zzgat) entry.getValue()).zzbp();
                    zzidyVarZzbp.getClass();
                    zzgas zzgasVar = (zzgas) zzidyVarZzbp;
                    Object value = entry.getValue();
                    value.getClass();
                    if (zzD((zzgat) value)) {
                        zzgasVar.zzf(true);
                    }
                    zzdww zzdwwVar = this.zzj;
                    zziee zzieeVarZzbm = zzgasVar.zzbm();
                    zzieeVarZzbm.getClass();
                    zzdwwVar.zza((zzgat) zzieeVarZzbm);
                }
                zzgbzVar.zza = null;
                zzgbzVar.zzd = 3;
            }
            Flow data2 = this.zzi.getData();
            zzgbzVar.zza = mutex;
            zzgbzVar.zzd = 2;
            objFirstOrNull = FlowKt.firstOrNull(data2, zzgbzVar);
            r2 = mutex;
            if (objFirstOrNull != coroutine_suspended) {
                zzgaxVar = (zzgax) objFirstOrNull;
                if (zzgaxVar != null) {
                }
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        } finally {
            r2.unlock(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzt(String str, Continuation continuation) {
        zzgbt zzgbtVar;
        String str2;
        Mutex mutex;
        long j;
        if (continuation instanceof zzgbt) {
            zzgbtVar = (zzgbt) continuation;
            int i = zzgbtVar.zze;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzgbtVar.zze = i - Integer.MIN_VALUE;
            } else {
                zzgbtVar = new zzgbt(this, continuation);
            }
        }
        Object obj = zzgbtVar.zzc;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzgbtVar.zze;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex mutex2 = this.zzc;
            long jCurrentTimeMillis = System.currentTimeMillis();
            zzgbtVar.zzf = str;
            zzgbtVar.zza = mutex2;
            zzgbtVar.zzb = jCurrentTimeMillis;
            zzgbtVar.zze = 1;
            if (mutex2.lock(null, zzgbtVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            str2 = str;
            mutex = mutex2;
            j = jCurrentTimeMillis;
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            j = zzgbtVar.zzb;
            mutex = (Mutex) zzgbtVar.zza;
            str2 = zzgbtVar.zzf;
            ResultKt.throwOnFailure(obj);
        }
        try {
            if (this.zzf) {
                return Unit.INSTANCE;
            }
            this.zzf = true;
            zzidy zzidyVarZzbp = zzgat.zzp().zzbp();
            zzidyVarZzbp.getClass();
            zzgas zzgasVar = (zzgas) zzidyVarZzbp;
            this.zzg = zzgasVar;
            if (zzgasVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                zzgasVar = null;
            }
            zzgasVar.zza(str2);
            zzgasVar.zzj(j);
            mutex.unlock(null);
            return Unit.INSTANCE;
        } finally {
            mutex.unlock(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a9, code lost:
    
        if (zzC(r0) == r1) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0089 A[Catch: all -> 0x0090, TryCatch #0 {all -> 0x0090, blocks: (B:33:0x0085, B:35:0x0089, B:38:0x0092), top: B:51:0x0085 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzu(Continuation continuation) {
        zzgbp zzgbpVar;
        Mutex mutex;
        Mutex mutex2;
        long j;
        zzgas zzgasVar;
        if (continuation instanceof zzgbp) {
            zzgbpVar = (zzgbp) continuation;
            int i = zzgbpVar.zze;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzgbpVar.zze = i - Integer.MIN_VALUE;
            } else {
                zzgbpVar = new zzgbp(this, continuation);
            }
        }
        Object obj = zzgbpVar.zzc;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzgbpVar.zze;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = this.zzd;
                zzgbpVar.zza = mutex;
                zzgbpVar.zze = 1;
                if (mutex.lock(null, zzgbpVar) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 == 1) {
                mutex = (Mutex) zzgbpVar.zza;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i2 == 2) {
                    j = zzgbpVar.zzb;
                    mutex2 = (Mutex) zzgbpVar.zza;
                    ResultKt.throwOnFailure(obj);
                    try {
                        zzgasVar = this.zzg;
                        if (zzgasVar == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                            zzgasVar = null;
                        }
                        zzgasVar.zzo(j);
                        mutex.unlock(null);
                        zzgbpVar.zza = null;
                        zzgbpVar.zze = 3;
                        if (zzB(j, zzgbpVar) != coroutine_suspended) {
                            zzgbpVar.zze = 4;
                        }
                        return coroutine_suspended;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (i2 != 3) {
                    if (i2 == 4) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                zzgbpVar.zze = 4;
            }
            if (this.zzh) {
                return Unit.INSTANCE;
            }
            this.zzh = true;
            Unit unit = Unit.INSTANCE;
            mutex.unlock(null);
            mutex2 = this.zzc;
            long jCurrentTimeMillis = System.currentTimeMillis();
            zzgbpVar.zza = mutex2;
            zzgbpVar.zzb = jCurrentTimeMillis;
            zzgbpVar.zze = 2;
            if (mutex2.lock(null, zzgbpVar) != coroutine_suspended) {
                j = jCurrentTimeMillis;
                zzgasVar = this.zzg;
                if (zzgasVar == null) {
                }
                zzgasVar.zzo(j);
                mutex.unlock(null);
                zzgbpVar.zza = null;
                zzgbpVar.zze = 3;
                if (zzB(j, zzgbpVar) != coroutine_suspended) {
                }
            }
            return coroutine_suspended;
        } finally {
            mutex.unlock(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007f A[Catch: all -> 0x0084, TRY_ENTER, TryCatch #0 {all -> 0x0084, blocks: (B:30:0x0079, B:33:0x007f, B:36:0x0087, B:38:0x008d, B:40:0x0091, B:41:0x0095, B:43:0x00af, B:44:0x00b3, B:46:0x00bc, B:48:0x00c0, B:49:0x00c4, B:50:0x00cc, B:52:0x00d0, B:53:0x00d4, B:55:0x00da, B:57:0x00de, B:58:0x00e2, B:60:0x00fc, B:61:0x0100, B:62:0x0108, B:64:0x010c, B:65:0x0110), top: B:73:0x0079 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008d A[Catch: all -> 0x0084, TryCatch #0 {all -> 0x0084, blocks: (B:30:0x0079, B:33:0x007f, B:36:0x0087, B:38:0x008d, B:40:0x0091, B:41:0x0095, B:43:0x00af, B:44:0x00b3, B:46:0x00bc, B:48:0x00c0, B:49:0x00c4, B:50:0x00cc, B:52:0x00d0, B:53:0x00d4, B:55:0x00da, B:57:0x00de, B:58:0x00e2, B:60:0x00fc, B:61:0x0100, B:62:0x0108, B:64:0x010c, B:65:0x0110), top: B:73:0x0079 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d0 A[Catch: all -> 0x0084, TryCatch #0 {all -> 0x0084, blocks: (B:30:0x0079, B:33:0x007f, B:36:0x0087, B:38:0x008d, B:40:0x0091, B:41:0x0095, B:43:0x00af, B:44:0x00b3, B:46:0x00bc, B:48:0x00c0, B:49:0x00c4, B:50:0x00cc, B:52:0x00d0, B:53:0x00d4, B:55:0x00da, B:57:0x00de, B:58:0x00e2, B:60:0x00fc, B:61:0x0100, B:62:0x0108, B:64:0x010c, B:65:0x0110), top: B:73:0x0079 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00da A[Catch: all -> 0x0084, TryCatch #0 {all -> 0x0084, blocks: (B:30:0x0079, B:33:0x007f, B:36:0x0087, B:38:0x008d, B:40:0x0091, B:41:0x0095, B:43:0x00af, B:44:0x00b3, B:46:0x00bc, B:48:0x00c0, B:49:0x00c4, B:50:0x00cc, B:52:0x00d0, B:53:0x00d4, B:55:0x00da, B:57:0x00de, B:58:0x00e2, B:60:0x00fc, B:61:0x0100, B:62:0x0108, B:64:0x010c, B:65:0x0110), top: B:73:0x0079 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x010c A[Catch: all -> 0x0084, TryCatch #0 {all -> 0x0084, blocks: (B:30:0x0079, B:33:0x007f, B:36:0x0087, B:38:0x008d, B:40:0x0091, B:41:0x0095, B:43:0x00af, B:44:0x00b3, B:46:0x00bc, B:48:0x00c0, B:49:0x00c4, B:50:0x00cc, B:52:0x00d0, B:53:0x00d4, B:55:0x00da, B:57:0x00de, B:58:0x00e2, B:60:0x00fc, B:61:0x0100, B:62:0x0108, B:64:0x010c, B:65:0x0110), top: B:73:0x0079 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzv(Continuation continuation) {
        zzgcd zzgcdVar;
        Mutex mutex;
        Mutex mutex2;
        long j;
        zzgas zzgasVar;
        zzgas zzgasVar2;
        zzgas zzgasVar3;
        if (continuation instanceof zzgcd) {
            zzgcdVar = (zzgcd) continuation;
            int i = zzgcdVar.zze;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzgcdVar.zze = i - Integer.MIN_VALUE;
            } else {
                zzgcdVar = new zzgcd(this, continuation);
            }
        }
        Object obj = zzgcdVar.zzc;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzgcdVar.zze;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = this.zzd;
                zzgcdVar.zza = mutex;
                zzgcdVar.zze = 1;
                if (mutex.lock(null, zzgcdVar) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                j = zzgcdVar.zzb;
                mutex2 = (Mutex) zzgcdVar.zza;
                ResultKt.throwOnFailure(obj);
                try {
                    zzgasVar = this.zzg;
                    if (zzgasVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                        zzgasVar = null;
                    }
                    if (zzgasVar.zzr() > 0) {
                        zzgas zzgasVar4 = this.zzg;
                        if (zzgasVar4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                            zzgasVar4 = null;
                        }
                        List listZzq = zzgasVar4.zzq();
                        listZzq.getClass();
                        Object objLast = CollectionsKt.last((List<? extends Object>) listZzq);
                        objLast.getClass();
                        long jLongValue = j - ((Number) objLast).longValue();
                        zzgas zzgasVar5 = this.zzg;
                        if (zzgasVar5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                            zzgasVar5 = null;
                        }
                        zzgasVar5.zzt();
                        if (jLongValue < 5000) {
                            zzgas zzgasVar6 = this.zzg;
                            if (zzgasVar6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                                zzgasVar6 = null;
                            }
                            zzgasVar6.zzd(zzgasVar6.zzc() + 1);
                        }
                    }
                    zzgasVar2 = this.zzg;
                    if (zzgasVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                        zzgasVar2 = null;
                    }
                    if (zzgasVar2.zzn() > 0) {
                        zzgas zzgasVar7 = this.zzg;
                        if (zzgasVar7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                            zzgasVar7 = null;
                        }
                        List listZzm = zzgasVar7.zzm();
                        listZzm.getClass();
                        Object objLast2 = CollectionsKt.last((List<? extends Object>) listZzm);
                        objLast2.getClass();
                        long jLongValue2 = j - ((Number) objLast2).longValue();
                        zzgas zzgasVar8 = this.zzg;
                        if (zzgasVar8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                            zzgasVar8 = null;
                        }
                        zzgasVar8.zzh(zzgasVar8.zzg() + jLongValue2);
                    }
                    zzgasVar3 = this.zzg;
                    if (zzgasVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                        zzgasVar3 = null;
                    }
                    zzgasVar3.zzp(j);
                    mutex.unlock(null);
                    return Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
            mutex = (Mutex) zzgcdVar.zza;
            ResultKt.throwOnFailure(obj);
            if (!this.zzh) {
                return Unit.INSTANCE;
            }
            this.zzh = false;
            Unit unit = Unit.INSTANCE;
            mutex.unlock(null);
            Mutex mutex3 = this.zzc;
            long jCurrentTimeMillis = System.currentTimeMillis();
            zzgcdVar.zza = mutex3;
            zzgcdVar.zzb = jCurrentTimeMillis;
            zzgcdVar.zze = 2;
            if (mutex3.lock(null, zzgcdVar) != coroutine_suspended) {
                mutex2 = mutex3;
                j = jCurrentTimeMillis;
                zzgasVar = this.zzg;
                if (zzgasVar == null) {
                }
                if (zzgasVar.zzr() > 0) {
                }
                zzgasVar2 = this.zzg;
                if (zzgasVar2 == null) {
                }
                if (zzgasVar2.zzn() > 0) {
                }
                zzgasVar3 = this.zzg;
                if (zzgasVar3 == null) {
                }
                zzgasVar3.zzp(j);
                mutex.unlock(null);
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        } finally {
            mutex.unlock(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00f8, code lost:
    
        if (zzz(r14, r0) == r1) goto L67;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0092 A[Catch: all -> 0x0097, TRY_ENTER, TryCatch #0 {all -> 0x0097, blocks: (B:34:0x008c, B:37:0x0092, B:40:0x0099, B:42:0x009d, B:43:0x00a1, B:45:0x00ab, B:46:0x00af, B:48:0x00bb, B:49:0x00bf, B:51:0x00c6, B:52:0x00ca), top: B:68:0x008c }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009d A[Catch: all -> 0x0097, TryCatch #0 {all -> 0x0097, blocks: (B:34:0x008c, B:37:0x0092, B:40:0x0099, B:42:0x009d, B:43:0x00a1, B:45:0x00ab, B:46:0x00af, B:48:0x00bb, B:49:0x00bf, B:51:0x00c6, B:52:0x00ca), top: B:68:0x008c }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ab A[Catch: all -> 0x0097, TryCatch #0 {all -> 0x0097, blocks: (B:34:0x008c, B:37:0x0092, B:40:0x0099, B:42:0x009d, B:43:0x00a1, B:45:0x00ab, B:46:0x00af, B:48:0x00bb, B:49:0x00bf, B:51:0x00c6, B:52:0x00ca), top: B:68:0x008c }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00bb A[Catch: all -> 0x0097, TryCatch #0 {all -> 0x0097, blocks: (B:34:0x008c, B:37:0x0092, B:40:0x0099, B:42:0x009d, B:43:0x00a1, B:45:0x00ab, B:46:0x00af, B:48:0x00bb, B:49:0x00bf, B:51:0x00c6, B:52:0x00ca), top: B:68:0x008c }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c6 A[Catch: all -> 0x0097, TryCatch #0 {all -> 0x0097, blocks: (B:34:0x008c, B:37:0x0092, B:40:0x0099, B:42:0x009d, B:43:0x00a1, B:45:0x00ab, B:46:0x00af, B:48:0x00bb, B:49:0x00bf, B:51:0x00c6, B:52:0x00ca), top: B:68:0x008c }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzw(Continuation continuation) {
        zzgbx zzgbxVar;
        Mutex mutex;
        Mutex mutex2;
        long j;
        zzgas zzgasVar;
        zzgas zzgasVar2;
        zzgas zzgasVar3;
        zzgas zzgasVar4;
        zzgas zzgasVar5;
        zzgat zzgatVar;
        if (continuation instanceof zzgbx) {
            zzgbxVar = (zzgbx) continuation;
            int i = zzgbxVar.zze;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzgbxVar.zze = i - Integer.MIN_VALUE;
            } else {
                zzgbxVar = new zzgbx(this, continuation);
            }
        }
        Object obj = zzgbxVar.zzc;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzgbxVar.zze;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = this.zzc;
                zzgbxVar.zza = mutex;
                zzgbxVar.zze = 1;
                if (mutex.lock(null, zzgbxVar) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 == 4) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    zzgatVar = (zzgat) zzgbxVar.zza;
                    ResultKt.throwOnFailure(obj);
                    if (this.zzj.zza(zzgatVar)) {
                        String strZza = zzgatVar.zza();
                        strZza.getClass();
                        zzgbxVar.zza = null;
                        zzgbxVar.zze = 4;
                    }
                    return Unit.INSTANCE;
                }
                j = zzgbxVar.zzb;
                mutex2 = (Mutex) zzgbxVar.zza;
                ResultKt.throwOnFailure(obj);
                try {
                    zzgasVar = this.zzg;
                    if (zzgasVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                        zzgasVar = null;
                    }
                    zzgasVar2 = this.zzg;
                    if (zzgasVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                        zzgasVar2 = null;
                    }
                    long jZzi = j - zzgasVar2.zzi();
                    zzgasVar3 = this.zzg;
                    if (zzgasVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                        zzgasVar3 = null;
                    }
                    zzgasVar.zzb(jZzi - zzgasVar3.zzg());
                    zzgasVar4 = this.zzg;
                    if (zzgasVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                        zzgasVar4 = null;
                    }
                    zzgasVar4.zzl(j);
                    zzgasVar5 = this.zzg;
                    if (zzgasVar5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                        zzgasVar5 = null;
                    }
                    zzgat zzgatVar2 = (zzgat) zzgasVar5.zzbm();
                    mutex.unlock(null);
                    zzgatVar2.getClass();
                    zzgbxVar.zza = zzgatVar2;
                    zzgbxVar.zze = 3;
                    if (zzC(zzgbxVar) != coroutine_suspended) {
                        zzgatVar = zzgatVar2;
                        if (this.zzj.zza(zzgatVar)) {
                        }
                        return Unit.INSTANCE;
                    }
                    return coroutine_suspended;
                } catch (Throwable th) {
                    throw th;
                }
            }
            mutex = (Mutex) zzgbxVar.zza;
            ResultKt.throwOnFailure(obj);
            if (!this.zzf) {
                return Unit.INSTANCE;
            }
            this.zzf = false;
            Unit unit = Unit.INSTANCE;
            mutex.unlock(null);
            mutex2 = this.zzc;
            long jCurrentTimeMillis = System.currentTimeMillis();
            zzgbxVar.zza = mutex2;
            zzgbxVar.zzb = jCurrentTimeMillis;
            zzgbxVar.zze = 2;
            if (mutex2.lock(null, zzgbxVar) != coroutine_suspended) {
                j = jCurrentTimeMillis;
                zzgasVar = this.zzg;
                if (zzgasVar == null) {
                }
                zzgasVar2 = this.zzg;
                if (zzgasVar2 == null) {
                }
                long jZzi2 = j - zzgasVar2.zzi();
                zzgasVar3 = this.zzg;
                if (zzgasVar3 == null) {
                }
                zzgasVar.zzb(jZzi2 - zzgasVar3.zzg());
                zzgasVar4 = this.zzg;
                if (zzgasVar4 == null) {
                }
                zzgasVar4.zzl(j);
                zzgasVar5 = this.zzg;
                if (zzgasVar5 == null) {
                }
                zzgat zzgatVar22 = (zzgat) zzgasVar5.zzbm();
                mutex.unlock(null);
                zzgatVar22.getClass();
                zzgbxVar.zza = zzgatVar22;
                zzgbxVar.zze = 3;
                if (zzC(zzgbxVar) != coroutine_suspended) {
                }
            }
            return coroutine_suspended;
        } finally {
            mutex.unlock(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0103, code lost:
    
        if (zzz(r15, r0) == r1) goto L69;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0091 A[Catch: all -> 0x0096, TRY_ENTER, TryCatch #0 {all -> 0x0096, blocks: (B:33:0x008b, B:36:0x0091, B:39:0x0099, B:41:0x009d, B:42:0x00a1, B:44:0x00ab, B:45:0x00af, B:47:0x00bb, B:48:0x00bf, B:50:0x00c6, B:51:0x00ca, B:53:0x00d1, B:54:0x00d5), top: B:70:0x008b }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009d A[Catch: all -> 0x0096, TryCatch #0 {all -> 0x0096, blocks: (B:33:0x008b, B:36:0x0091, B:39:0x0099, B:41:0x009d, B:42:0x00a1, B:44:0x00ab, B:45:0x00af, B:47:0x00bb, B:48:0x00bf, B:50:0x00c6, B:51:0x00ca, B:53:0x00d1, B:54:0x00d5), top: B:70:0x008b }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ab A[Catch: all -> 0x0096, TryCatch #0 {all -> 0x0096, blocks: (B:33:0x008b, B:36:0x0091, B:39:0x0099, B:41:0x009d, B:42:0x00a1, B:44:0x00ab, B:45:0x00af, B:47:0x00bb, B:48:0x00bf, B:50:0x00c6, B:51:0x00ca, B:53:0x00d1, B:54:0x00d5), top: B:70:0x008b }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00bb A[Catch: all -> 0x0096, TryCatch #0 {all -> 0x0096, blocks: (B:33:0x008b, B:36:0x0091, B:39:0x0099, B:41:0x009d, B:42:0x00a1, B:44:0x00ab, B:45:0x00af, B:47:0x00bb, B:48:0x00bf, B:50:0x00c6, B:51:0x00ca, B:53:0x00d1, B:54:0x00d5), top: B:70:0x008b }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c6 A[Catch: all -> 0x0096, TryCatch #0 {all -> 0x0096, blocks: (B:33:0x008b, B:36:0x0091, B:39:0x0099, B:41:0x009d, B:42:0x00a1, B:44:0x00ab, B:45:0x00af, B:47:0x00bb, B:48:0x00bf, B:50:0x00c6, B:51:0x00ca, B:53:0x00d1, B:54:0x00d5), top: B:70:0x008b }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d1 A[Catch: all -> 0x0096, TryCatch #0 {all -> 0x0096, blocks: (B:33:0x008b, B:36:0x0091, B:39:0x0099, B:41:0x009d, B:42:0x00a1, B:44:0x00ab, B:45:0x00af, B:47:0x00bb, B:48:0x00bf, B:50:0x00c6, B:51:0x00ca, B:53:0x00d1, B:54:0x00d5), top: B:70:0x008b }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzx(Continuation continuation) {
        zzgcb zzgcbVar;
        Mutex mutex;
        Mutex mutex2;
        long jCurrentTimeMillis;
        zzgas zzgasVar;
        zzgas zzgasVar2;
        zzgas zzgasVar3;
        zzgas zzgasVar4;
        zzgas zzgasVar5;
        zzgas zzgasVar6;
        zzgat zzgatVar;
        if (continuation instanceof zzgcb) {
            zzgcbVar = (zzgcb) continuation;
            int i = zzgcbVar.zze;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzgcbVar.zze = i - Integer.MIN_VALUE;
            } else {
                zzgcbVar = new zzgcb(this, continuation);
            }
        }
        Object obj = zzgcbVar.zzc;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzgcbVar.zze;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = this.zzc;
                zzgcbVar.zza = mutex;
                zzgcbVar.zze = 1;
                if (mutex.lock(null, zzgcbVar) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 == 4) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    zzgatVar = (zzgat) zzgcbVar.zza;
                    ResultKt.throwOnFailure(obj);
                    if (this.zzj.zza(zzgatVar)) {
                        String strZza = zzgatVar.zza();
                        strZza.getClass();
                        zzgcbVar.zza = null;
                        zzgcbVar.zze = 4;
                    }
                    return Unit.INSTANCE;
                }
                jCurrentTimeMillis = zzgcbVar.zzb;
                mutex2 = (Mutex) zzgcbVar.zza;
                ResultKt.throwOnFailure(obj);
                try {
                    zzgasVar = this.zzg;
                    if (zzgasVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                        zzgasVar = null;
                    }
                    zzgasVar2 = this.zzg;
                    if (zzgasVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                        zzgasVar2 = null;
                    }
                    long jZzi = jCurrentTimeMillis - zzgasVar2.zzi();
                    zzgasVar3 = this.zzg;
                    if (zzgasVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                        zzgasVar3 = null;
                    }
                    zzgasVar.zzb(jZzi - zzgasVar3.zzg());
                    zzgasVar4 = this.zzg;
                    if (zzgasVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                        zzgasVar4 = null;
                    }
                    zzgasVar4.zzk(jCurrentTimeMillis);
                    zzgasVar5 = this.zzg;
                    if (zzgasVar5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                        zzgasVar5 = null;
                    }
                    zzgasVar5.zze(true);
                    zzgasVar6 = this.zzg;
                    if (zzgasVar6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                        zzgasVar6 = null;
                    }
                    zzgat zzgatVar2 = (zzgat) zzgasVar6.zzbm();
                    mutex.unlock(null);
                    zzgatVar2.getClass();
                    zzgcbVar.zza = zzgatVar2;
                    zzgcbVar.zze = 3;
                    if (zzC(zzgcbVar) != coroutine_suspended) {
                        zzgatVar = zzgatVar2;
                        if (this.zzj.zza(zzgatVar)) {
                        }
                        return Unit.INSTANCE;
                    }
                    return coroutine_suspended;
                } catch (Throwable th) {
                    throw th;
                }
            }
            mutex = (Mutex) zzgcbVar.zza;
            ResultKt.throwOnFailure(obj);
            if (!this.zzf) {
                return Unit.INSTANCE;
            }
            this.zzf = false;
            Unit unit = Unit.INSTANCE;
            mutex.unlock(null);
            mutex2 = this.zzc;
            jCurrentTimeMillis = System.currentTimeMillis();
            zzgcbVar.zza = mutex2;
            zzgcbVar.zzb = jCurrentTimeMillis;
            zzgcbVar.zze = 2;
            if (mutex2.lock(null, zzgcbVar) != coroutine_suspended) {
                zzgasVar = this.zzg;
                if (zzgasVar == null) {
                }
                zzgasVar2 = this.zzg;
                if (zzgasVar2 == null) {
                }
                long jZzi2 = jCurrentTimeMillis - zzgasVar2.zzi();
                zzgasVar3 = this.zzg;
                if (zzgasVar3 == null) {
                }
                zzgasVar.zzb(jZzi2 - zzgasVar3.zzg());
                zzgasVar4 = this.zzg;
                if (zzgasVar4 == null) {
                }
                zzgasVar4.zzk(jCurrentTimeMillis);
                zzgasVar5 = this.zzg;
                if (zzgasVar5 == null) {
                }
                zzgasVar5.zze(true);
                zzgasVar6 = this.zzg;
                if (zzgasVar6 == null) {
                }
                zzgat zzgatVar22 = (zzgat) zzgasVar6.zzbm();
                mutex.unlock(null);
                zzgatVar22.getClass();
                zzgcbVar.zza = zzgatVar22;
                zzgcbVar.zze = 3;
                if (zzC(zzgcbVar) != coroutine_suspended) {
                }
            }
            return coroutine_suspended;
        } finally {
            mutex.unlock(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzy(Continuation continuation) {
        zzgbv zzgbvVar;
        Mutex mutex;
        long j;
        if (continuation instanceof zzgbv) {
            zzgbvVar = (zzgbv) continuation;
            int i = zzgbvVar.zze;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzgbvVar.zze = i - Integer.MIN_VALUE;
            } else {
                zzgbvVar = new zzgbv(this, continuation);
            }
        }
        Object obj = zzgbvVar.zzc;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzgbvVar.zze;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex mutex2 = this.zzc;
            long jCurrentTimeMillis = System.currentTimeMillis();
            zzgbvVar.zzb = mutex2;
            zzgbvVar.zza = jCurrentTimeMillis;
            zzgbvVar.zze = 1;
            if (mutex2.lock(null, zzgbvVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex = mutex2;
            j = jCurrentTimeMillis;
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            j = zzgbvVar.zza;
            mutex = (Mutex) zzgbvVar.zzb;
            ResultKt.throwOnFailure(obj);
        }
        try {
            zzgas zzgasVar = this.zzg;
            if (zzgasVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                zzgasVar = null;
            }
            zzgasVar.zzs(j);
            mutex.unlock(null);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutex.unlock(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzz(String str, Continuation continuation) throws Throwable {
        zzgbj zzgbjVar;
        String str2;
        Mutex mutex;
        Throwable th;
        Mutex mutex2;
        if (continuation instanceof zzgbj) {
            zzgbjVar = (zzgbj) continuation;
            int i = zzgbjVar.zze;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzgbjVar.zze = i - Integer.MIN_VALUE;
            } else {
                zzgbjVar = new zzgbj(this, continuation);
            }
        }
        Object objUpdateData = zzgbjVar.zzc;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzgbjVar.zze;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objUpdateData);
                Mutex mutex3 = this.zze;
                zzgbjVar.zza = str;
                zzgbjVar.zzb = mutex3;
                zzgbjVar.zze = 1;
                if (mutex3.lock(null, zzgbjVar) != coroutine_suspended) {
                    str2 = str;
                    mutex = mutex3;
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                mutex2 = (Mutex) zzgbjVar.zza;
                try {
                    ResultKt.throwOnFailure(objUpdateData);
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            mutex = (Mutex) zzgbjVar.zzb;
            str2 = (String) zzgbjVar.zza;
            ResultKt.throwOnFailure(objUpdateData);
            DataStore dataStore = this.zzi;
            zzgbk zzgbkVar = new zzgbk(str2, null);
            zzgbjVar.zza = mutex;
            zzgbjVar.zzb = null;
            zzgbjVar.zze = 2;
            objUpdateData = dataStore.updateData(zzgbkVar, zzgbjVar);
            if (objUpdateData != coroutine_suspended) {
                mutex2 = mutex;
                mutex2.unlock(null);
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            Mutex mutex4 = mutex;
            th = th3;
            mutex2 = mutex4;
            mutex2.unlock(null);
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgau
    public final void zza() {
        BuildersKt__Builders_commonKt.launch$default(this.zza, null, null, new zzgby(this, null), 3, null);
    }

    @Override // com.google.android.gms.internal.ads.zzgau
    public final void zzb(String str) {
        str.getClass();
        zzgsp.zza(this.zza, this.zzb, new zzgbs(this, str, null));
    }

    @Override // com.google.android.gms.internal.ads.zzgau
    public final void zzc() {
        zzgsp.zza(this.zza, this.zzb, new zzgbo(this, null));
    }

    @Override // com.google.android.gms.internal.ads.zzgau
    public final void zzd() {
        zzgsp.zza(this.zza, this.zzb, new zzgcc(this, null));
    }

    @Override // com.google.android.gms.internal.ads.zzgau
    public final void zze() {
        zzgsp.zza(this.zza, this.zzb, new zzgbw(this, null));
    }

    @Override // com.google.android.gms.internal.ads.zzgau
    public final void zzf() {
        zzgsp.zza(this.zza, this.zzb, new zzgca(this, null));
    }

    @Override // com.google.android.gms.internal.ads.zzgau
    public final void zzg() {
        zzgsp.zza(this.zza, this.zzb, new zzgbu(this, null));
    }
}
