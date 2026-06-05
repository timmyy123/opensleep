package com.polar.androidcommunications.common.ble;

import androidx.work.WorkerKt$$ExternalSyntheticLambda0;
import com.polar.androidcommunications.api.ble.exceptions.BleDisconnected;
import com.polar.androidcommunications.api.ble.model.gatt.BleGattTxInterface;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.CompletableEmitter;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.core.FlowableOnSubscribe;
import io.reactivex.rxjava3.core.SingleEmitter;
import java.util.Iterator;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class RxUtils {

    public interface Emitter<T> {
        void item(T t);
    }

    public static <T> void emitNext(AtomicSet<T> atomicSet, Emitter<T> emitter) {
        Iterator<T> it = atomicSet.objects().iterator();
        while (it.hasNext()) {
            emitter.item(it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$monitorNotifications$0(boolean z, BleGattTxInterface bleGattTxInterface, FlowableEmitter[] flowableEmitterArr, AtomicSet atomicSet, FlowableEmitter flowableEmitter) {
        if (z && !bleGattTxInterface.isConnected()) {
            flowableEmitter.tryOnError(new BleDisconnected());
        } else {
            flowableEmitterArr[0] = flowableEmitter;
            atomicSet.add(flowableEmitter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$monitorNotifications$1(AtomicSet atomicSet, FlowableEmitter[] flowableEmitterArr) {
        atomicSet.remove(flowableEmitterArr[0]);
    }

    public static <E> Flowable<E> monitorNotifications(final AtomicSet<FlowableEmitter<? super E>> atomicSet, final BleGattTxInterface bleGattTxInterface, final boolean z) {
        final FlowableEmitter[] flowableEmitterArr = new FlowableEmitter[1];
        return Flowable.create(new FlowableOnSubscribe() { // from class: com.polar.androidcommunications.common.ble.RxUtils$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.core.FlowableOnSubscribe
            public final void subscribe(FlowableEmitter flowableEmitter) {
                RxUtils.lambda$monitorNotifications$0(z, bleGattTxInterface, flowableEmitterArr, atomicSet, flowableEmitter);
            }
        }, BackpressureStrategy.BUFFER).doFinally(new WorkerKt$$ExternalSyntheticLambda0(atomicSet, flowableEmitterArr, 16)).serialize();
    }

    public static <T> void postDisconnectedAndClearList(AtomicSet<T> atomicSet) {
        postError(atomicSet, new BleDisconnected());
    }

    public static <T> void postError(AtomicSet<T> atomicSet, Throwable th) {
        for (T t : atomicSet.objects()) {
            if (t instanceof SingleEmitter) {
                SingleEmitter singleEmitter = (SingleEmitter) t;
                if (!singleEmitter.isDisposed()) {
                    singleEmitter.tryOnError(th);
                }
            } else if (t instanceof FlowableEmitter) {
                FlowableEmitter flowableEmitter = (FlowableEmitter) t;
                if (!flowableEmitter.isCancelled()) {
                    flowableEmitter.tryOnError(th);
                }
            } else if (!(t instanceof CompletableEmitter)) {
                Utf8$$ExternalSyntheticBUOutline0.m$1((Object) "emitter type not found");
                return;
            } else {
                CompletableEmitter completableEmitter = (CompletableEmitter) t;
                if (!completableEmitter.isDisposed()) {
                    completableEmitter.tryOnError(th);
                }
            }
        }
        atomicSet.clear();
    }

    public static <T> void postExceptionAndClearList(AtomicSet<T> atomicSet, Throwable th) {
        postError(atomicSet, th);
    }
}
