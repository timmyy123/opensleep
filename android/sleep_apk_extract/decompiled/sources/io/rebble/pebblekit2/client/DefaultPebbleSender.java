package io.rebble.pebblekit2.client;

import android.content.Context;
import android.os.Bundle;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.os.BundleKt;
import com.facebook.share.internal.ShareConstants;
import io.rebble.pebblekit2.common.UniversalRequestResponse;
import io.rebble.pebblekit2.common.model.PebbleDictionaryItem;
import io.rebble.pebblekit2.common.model.PebbleDictionarySerializationKt;
import io.rebble.pebblekit2.common.model.TransmissionResult;
import io.rebble.pebblekit2.common.model.TransmissionResultSerializationKt;
import io.rebble.pebblekit2.common.model.WatchIdentifier;
import io.rebble.pebblekit2.common.util.AidlCoroutinesKt;
import io.rebble.pebblekit2.common.util.SuspendingBindingConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.ranges.RangesKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b\u000b\u0010\fJN\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\r2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\bj\u0002`\u00112\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0013H\u0096@¢\u0006\u0004\b\u0015\u0010\u0016J6\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\r2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0013H\u0096@¢\u0006\u0004\b\u0017\u0010\u0018J6\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\r2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0013H\u0096@¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lio/rebble/pebblekit2/client/DefaultPebbleSender;", "Lio/rebble/pebblekit2/client/PebbleSender;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "<init>", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "bundle", "", "Lio/rebble/pebblekit2/common/model/WatchIdentifier;", "Lio/rebble/pebblekit2/common/model/TransmissionResult;", "sendRequestForWatches", "(Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/util/UUID;", "watchappUUID", "Lkotlin/UInt;", "Lio/rebble/pebblekit2/common/model/PebbleDictionaryItem;", "Lio/rebble/pebblekit2/common/model/PebbleDictionary;", "data", "", "watches", "sendDataToPebble", "(Ljava/util/UUID;Ljava/util/Map;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startAppOnTheWatch", "(Ljava/util/UUID;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopAppOnTheWatch", "", "close", "()V", "Lio/rebble/pebblekit2/common/util/SuspendingBindingConnection;", "Lio/rebble/pebblekit2/common/UniversalRequestResponse;", "connector", "Lio/rebble/pebblekit2/common/util/SuspendingBindingConnection;", "client_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DefaultPebbleSender implements PebbleSender {
    private final SuspendingBindingConnection<UniversalRequestResponse> connector;

    /* JADX INFO: renamed from: io.rebble.pebblekit2.client.DefaultPebbleSender$sendRequestForWatches$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "io.rebble.pebblekit2.client.DefaultPebbleSender", f = "DefaultPebbleSender.kt", l = {160, 162}, m = "sendRequestForWatches", v = 2)
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultPebbleSender.this.sendRequestForWatches(null, this);
        }
    }

    public DefaultPebbleSender(Context context) {
        context.getClass();
        this.connector = new SuspendingBindingConnection<>(context, new DefaultPebbleSender$connector$1(context, null), DefaultPebbleSender$connector$2.INSTANCE, 0, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006b, code lost:
    
        if (r8 == r1) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object sendRequestForWatches(Bundle bundle, Continuation<? super Map<WatchIdentifier, ? extends TransmissionResult>> continuation) {
        AnonymousClass1 anonymousClass1;
        Object unknown;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object orConnect = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(orConnect);
            SuspendingBindingConnection<UniversalRequestResponse> suspendingBindingConnection = this.connector;
            anonymousClass1.L$0 = bundle;
            anonymousClass1.label = 1;
            orConnect = suspendingBindingConnection.getOrConnect(anonymousClass1);
            if (orConnect != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(orConnect);
            Bundle bundle2 = (Bundle) orConnect;
            if (bundle2 != null) {
                Bundle bundle3 = bundle2.getBundle("TRANSMISSION_RESULTS");
                if (bundle3 == null) {
                    bundle3 = new Bundle();
                }
                Set<String> setKeySet = bundle3.keySet();
                setKeySet.getClass();
                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(setKeySet, 10)), 16));
                for (String str : setKeySet) {
                    Bundle bundle4 = bundle3.getBundle(str);
                    if (bundle4 == null || (unknown = TransmissionResultSerializationKt.fromBundle(TransmissionResult.INSTANCE, bundle4)) == null) {
                        unknown = new TransmissionResult.Unknown("Missing TransmissionResult in PebbleSender result bundle");
                    }
                    str.getClass();
                    Pair pair = TuplesKt.to(WatchIdentifier.m2349boximpl(WatchIdentifier.m2350constructorimpl(str)), unknown);
                    linkedHashMap.put(pair.getFirst(), pair.getSecond());
                }
                return linkedHashMap;
            }
            return null;
        }
        bundle = (Bundle) anonymousClass1.L$0;
        ResultKt.throwOnFailure(orConnect);
        UniversalRequestResponse universalRequestResponse = (UniversalRequestResponse) orConnect;
        if (universalRequestResponse != null) {
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(bundle);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(universalRequestResponse);
            anonymousClass1.label = 2;
            orConnect = AidlCoroutinesKt.request(universalRequestResponse, bundle, anonymousClass1);
        }
        return null;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.connector.close();
    }

    @Override // io.rebble.pebblekit2.client.PebbleSender
    public Object sendDataToPebble(UUID uuid, Map<UInt, ? extends PebbleDictionaryItem> map, List<WatchIdentifier> list, Continuation<? super Map<WatchIdentifier, ? extends TransmissionResult>> continuation) {
        String[] strArr;
        Pair pair = TuplesKt.to(ShareConstants.ACTION, "SEND_DATA_TO_WATCH");
        Pair pair2 = TuplesKt.to("WATCHAPP_UUID", uuid.toString());
        Pair pair3 = TuplesKt.to("DATA_DICTIONARY", PebbleDictionarySerializationKt.toBundle(map));
        if (list != null) {
            List<WatchIdentifier> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((WatchIdentifier) it.next()).getValue());
            }
            strArr = (String[]) arrayList.toArray(new String[0]);
        } else {
            strArr = null;
        }
        return sendRequestForWatches(BundleKt.bundleOf(pair, pair2, pair3, TuplesKt.to("WATCHES_ID", strArr)), continuation);
    }

    @Override // io.rebble.pebblekit2.client.PebbleSender
    public Object startAppOnTheWatch(UUID uuid, List<WatchIdentifier> list, Continuation<? super Map<WatchIdentifier, ? extends TransmissionResult>> continuation) {
        String[] strArr;
        Pair pair = TuplesKt.to(ShareConstants.ACTION, "START_APP");
        Pair pair2 = TuplesKt.to("WATCHAPP_UUID", uuid.toString());
        if (list != null) {
            List<WatchIdentifier> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((WatchIdentifier) it.next()).getValue());
            }
            strArr = (String[]) arrayList.toArray(new String[0]);
        } else {
            strArr = null;
        }
        return sendRequestForWatches(BundleKt.bundleOf(pair, pair2, TuplesKt.to("WATCHES_ID", strArr)), continuation);
    }

    @Override // io.rebble.pebblekit2.client.PebbleSender
    public Object stopAppOnTheWatch(UUID uuid, List<WatchIdentifier> list, Continuation<? super Map<WatchIdentifier, ? extends TransmissionResult>> continuation) {
        String[] strArr;
        Pair pair = TuplesKt.to(ShareConstants.ACTION, "STOP_APP");
        Pair pair2 = TuplesKt.to("WATCHAPP_UUID", uuid.toString());
        if (list != null) {
            List<WatchIdentifier> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(((WatchIdentifier) it.next()).getValue());
            }
            strArr = (String[]) arrayList.toArray(new String[0]);
        } else {
            strArr = null;
        }
        return sendRequestForWatches(BundleKt.bundleOf(pair, pair2, TuplesKt.to("WATCHES_ID", strArr)), continuation);
    }
}
