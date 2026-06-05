package com.google.android.gms.home.internal;

import com.facebook.appevents.UserDataStore;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.internal.serialization.FilterMatcher;
import com.google.android.gms.internal.serialization.FilterMatcherType;
import com.google.android.gms.internal.serialization.FilterObjectTypeSupported;
import com.google.android.gms.internal.serialization.FilterQuery;
import com.google.android.gms.internal.serialization.FilterTraitSupported;
import com.google.android.gms.internal.serialization.ObjectCommand;
import com.google.android.gms.internal.serialization.zzack;
import com.google.android.gms.internal.serialization.zzacw;
import com.google.android.gms.internal.serialization.zzacx;
import com.google.android.gms.internal.serialization.zzadb;
import com.google.android.gms.internal.serialization.zzadm;
import com.google.android.gms.internal.serialization.zzadn;
import com.google.android.gms.internal.serialization.zzado;
import com.google.android.gms.internal.serialization.zzadp;
import com.google.android.gms.internal.serialization.zzadr;
import com.google.android.gms.internal.serialization.zzads;
import com.google.android.gms.internal.serialization.zzadt;
import com.google.android.gms.internal.serialization.zzadw;
import com.google.android.gms.internal.serialization.zzadx;
import com.google.android.gms.internal.serialization.zzaep;
import com.google.android.gms.internal.serialization.zzvj;
import com.google.android.gms.internal.serialization.zzzg;
import com.google.android.gms.tasks.Task;
import com.google.home.HomeError;
import com.google.home.HomeException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.tasks.TasksKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000x\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\u001a>\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u0006H\u0086@¢\u0006\u0002\u0010\u0007\u001a \u0010\u0000\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0086@¢\u0006\u0002\u0010\b\u001a\n\u0010\t\u001a\u00020\n*\u00020\u000b\u001a\n\u0010\t\u001a\u00020\f*\u00020\r\u001a\n\u0010\t\u001a\u00020\u000e*\u00020\u000f\u001a\u0010\u0010\u0010\u001a\u00020\u0011*\b\u0012\u0004\u0012\u00020\u00130\u0012\u001a\n\u0010\u0014\u001a\u00020\u0015*\u00020\u0016\u001a\n\u0010\u0017\u001a\u00020\u0018*\u00020\u0019\u001a\n\u0010\u001a\u001a\u00020\u001b*\u00020\u001c\u001a\n\u0010\t\u001a\u00020\u001d*\u00020\u001e\u001a\u0010\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0012*\u00020!\u001a\u0016\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00150#*\u00020$¨\u0006%"}, d2 = {"valueOrException", "O", "T", "", "Lcom/google/android/gms/tasks/Task;", UserDataStore.FIRST_NAME, "Lkotlin/Function1;", "(Lcom/google/android/gms/tasks/Task;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lcom/google/android/gms/tasks/Task;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toProto", "Lcom/google/protos/home/internal/interaction_api/FilterMatcher$Type;", "Lcom/google/nest/platform/mesh/interaction/FilterMatcherType;", "Lcom/google/protos/home/internal/interaction_api/FilterMatcher;", "Lcom/google/nest/platform/mesh/interaction/FilterMatcher;", "Lcom/google/protos/home/internal/interaction_api/FilterQuery;", "Lcom/google/nest/platform/mesh/interaction/FilterQuery;", "toProtoObjectTraitElementFilter", "Lcom/google/protos/home/internal/interaction_api/ObjectTraitElementFilter;", "", "", "toError", "Lcom/google/home/HomeError;", "Lcom/google/protos/home/internal/interaction_api/Error;", "toEventPayload", "Lcom/google/nest/platform/mesh/interaction/EventPayload;", "Lcom/google/protos/home/internal/interaction_api/EventPayload;", "toEventImportance", "Lcom/google/nest/platform/mesh/interaction/EventImportance;", "Lcom/google/protos/home/internal/interaction_api/EventImportance;", "Lcom/google/protos/home/internal/interaction_api/CommandRequestData;", "Lcom/google/nest/platform/mesh/interaction/ObjectCommand;", "toObjectDataList", "Lcom/google/nest/platform/mesh/serialization/ObjectData;", "Lcom/google/protos/home/internal/interaction_api/ReadObjectsResponse;", "toWriteErrors", "", "Lcom/google/protos/home/internal/interaction_api/WriteObjectsResponse;", "java.com.google.android.gmscore.integ.client.home_home"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class zzd {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object zza(Task task, Continuation continuation) {
        zzc zzcVar;
        if (continuation instanceof zzc) {
            zzcVar = (zzc) continuation;
            int i = zzcVar.zzb;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzcVar.zzb = i - Integer.MIN_VALUE;
            } else {
                zzcVar = new zzc(continuation);
            }
        }
        Object obj = zzcVar.zza;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzcVar.zzb;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                zzcVar.zzb = 1;
                Object objAwait = TasksKt.await(task, zzcVar);
                return objAwait == coroutine_suspended ? coroutine_suspended : objAwait;
            }
            if (i2 == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        } catch (ApiException e) {
            int statusCode = e.getStatusCode();
            String message = e.getMessage();
            if (message == null) {
                message = "";
            }
            throw new HomeException(statusCode, message, e, null, 8, null);
        }
    }

    public static final zzadr zzb(FilterQuery filterQuery) {
        filterQuery.getClass();
        zzadt zzadtVarZza = zzads.zza(zzadr.zzc());
        if (!filterQuery.getObjectIds().isEmpty()) {
            zzadtVarZza.zzc(zzadtVarZza.zzb(), filterQuery.getObjectIds());
        }
        if (!filterQuery.getMatchers().isEmpty()) {
            zzack zzackVarZzd = zzadtVarZza.zzd();
            List<FilterMatcher> matchers = filterQuery.getMatchers();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(matchers, 10));
            for (FilterMatcher filterMatcher : matchers) {
                filterMatcher.getClass();
                zzadp zzadpVarZza = zzado.zza(zzadn.zza());
                FilterMatcherType filterMatcherTypeZza = filterMatcher.zza();
                filterMatcherTypeZza.getClass();
                int zzf = filterMatcherTypeZza.getZzf();
                zzadm zzadmVar = zzf != 0 ? zzf != 1 ? zzf != 2 ? zzf != 3 ? zzadm.OBJECT_TYPE_NOT_SUPPORTED : zzadm.OBJECT_TYPE_SUPPORTED : zzadm.TRAIT_NOT_SUPPORTED : zzadm.TRAIT_SUPPORTED : zzadm.TYPE_UNSPECIFIED;
                if (zzadmVar == null) {
                    zzadmVar = zzadm.TYPE_UNSPECIFIED;
                }
                zzadpVarZza.zzb(zzadmVar);
                if (filterMatcher instanceof FilterTraitSupported) {
                    zzadpVarZza.zzc(((FilterTraitSupported) filterMatcher).getZza());
                } else if (filterMatcher instanceof FilterObjectTypeSupported) {
                    zzadpVarZza.zzd(((FilterObjectTypeSupported) filterMatcher).getZza());
                } else {
                    zzadpVarZza.zzb(zzadm.TYPE_UNSPECIFIED);
                }
                arrayList.add(zzadpVarZza.zza());
            }
            zzadtVarZza.zzf(zzackVarZzd, arrayList);
        }
        return zzadtVarZza.zza();
    }

    public static final zzadx zzc(List list) {
        list.getClass();
        zzadw zzadwVarZzb = zzadx.zzb();
        zzadwVarZzb.getClass();
        List listZza = zzadwVarZzb.zza();
        listZza.getClass();
        new zzack(listZza);
        List list2 = list;
        list2.getClass();
        zzadwVarZzb.zzb(list2);
        zzzg zzzgVarBuild = zzadwVarZzb.build();
        zzzgVarBuild.getClass();
        return (zzadx) zzzgVarBuild;
    }

    public static final HomeError zzd(zzadb zzadbVar) {
        zzadbVar.getClass();
        int iZza = zzadbVar.zza();
        String strZzb = zzadbVar.zzb();
        strZzb.getClass();
        return new HomeError(iZza, strZzb);
    }

    public static final zzacx zze(ObjectCommand objectCommand) {
        objectCommand.getClass();
        zzacw zzacwVarZza = zzacx.zza();
        zzacwVarZza.getClass();
        String objectId = objectCommand.getObjectId();
        objectId.getClass();
        zzacwVarZza.zza(objectId);
        zzaep zzaepVarZza = zzvj.zza(objectCommand.getPayload());
        zzaepVarZza.getClass();
        zzacwVarZza.zzb(zzaepVarZza);
        zzacwVarZza.zzc(objectCommand.getUseTimedCommand());
        zzzg zzzgVarBuild = zzacwVarZza.build();
        zzzgVarBuild.getClass();
        return (zzacx) zzzgVarBuild;
    }
}
