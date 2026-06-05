package io.rebble.pebblekit2.client;

import io.rebble.pebblekit2.common.model.PebbleDictionaryItem;
import io.rebble.pebblekit2.common.model.TransmissionResult;
import io.rebble.pebblekit2.common.model.WatchIdentifier;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.coroutines.Continuation;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001JP\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u00072\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH¦@¢\u0006\u0004\b\r\u0010\u000eJ8\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH¦@¢\u0006\u0004\b\u000f\u0010\u0010J8\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH¦@¢\u0006\u0004\b\u0011\u0010\u0010¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lio/rebble/pebblekit2/client/PebbleSender;", "Ljava/lang/AutoCloseable;", "Ljava/util/UUID;", "watchappUUID", "", "Lkotlin/UInt;", "Lio/rebble/pebblekit2/common/model/PebbleDictionaryItem;", "Lio/rebble/pebblekit2/common/model/PebbleDictionary;", "data", "", "Lio/rebble/pebblekit2/common/model/WatchIdentifier;", "watches", "Lio/rebble/pebblekit2/common/model/TransmissionResult;", "sendDataToPebble", "(Ljava/util/UUID;Ljava/util/Map;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startAppOnTheWatch", "(Ljava/util/UUID;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopAppOnTheWatch", "client-api"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface PebbleSender extends AutoCloseable {
    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object sendDataToPebble$default(PebbleSender pebbleSender, UUID uuid, Map map, List list, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            Utf8$$ExternalSyntheticBUOutline0.m("Super calls with default arguments not supported in this target, function: sendDataToPebble");
            return null;
        }
        if ((i & 4) != 0) {
            list = null;
        }
        return pebbleSender.sendDataToPebble(uuid, map, list, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object startAppOnTheWatch$default(PebbleSender pebbleSender, UUID uuid, List list, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            Utf8$$ExternalSyntheticBUOutline0.m("Super calls with default arguments not supported in this target, function: startAppOnTheWatch");
            return null;
        }
        if ((i & 2) != 0) {
            list = null;
        }
        return pebbleSender.startAppOnTheWatch(uuid, list, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object stopAppOnTheWatch$default(PebbleSender pebbleSender, UUID uuid, List list, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            Utf8$$ExternalSyntheticBUOutline0.m("Super calls with default arguments not supported in this target, function: stopAppOnTheWatch");
            return null;
        }
        if ((i & 2) != 0) {
            list = null;
        }
        return pebbleSender.stopAppOnTheWatch(uuid, list, continuation);
    }

    Object sendDataToPebble(UUID uuid, Map<UInt, ? extends PebbleDictionaryItem> map, List<WatchIdentifier> list, Continuation<? super Map<WatchIdentifier, ? extends TransmissionResult>> continuation);

    Object startAppOnTheWatch(UUID uuid, List<WatchIdentifier> list, Continuation<? super Map<WatchIdentifier, ? extends TransmissionResult>> continuation);

    Object stopAppOnTheWatch(UUID uuid, List<WatchIdentifier> list, Continuation<? super Map<WatchIdentifier, ? extends TransmissionResult>> continuation);
}
