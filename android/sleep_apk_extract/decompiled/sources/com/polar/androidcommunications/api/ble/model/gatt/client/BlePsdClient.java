package com.polar.androidcommunications.api.ble.model.gatt.client;

import android.util.Pair;
import com.facebook.login.LoginFragment$$ExternalSyntheticLambda0;
import com.polar.androidcommunications.api.ble.BleLogger;
import com.polar.androidcommunications.api.ble.model.gatt.BleGattBase;
import com.polar.androidcommunications.api.ble.model.gatt.BleGattTxInterface;
import com.polar.androidcommunications.common.ble.AtomicSet;
import com.polar.androidcommunications.common.ble.RxUtils;
import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public class BlePsdClient extends BleGattBase {
    private final Object mutexFeature;
    private final AtomicSet<FlowableEmitter<? super PPData>> ppObservers;
    private final AtomicInteger psdCpEnabled;
    private final LinkedBlockingQueue<Pair<byte[], Integer>> psdCpInputQueue;
    private PsdFeature psdFeature;
    private final Object psdMutex;
    private final Scheduler scheduler;
    public static final UUID PSD_SERVICE = UUID.fromString("FB005C20-02E7-F387-1CAD-8ACD2D8DF0C8");
    public static final UUID PSD_FEATURE = UUID.fromString("FB005C21-02E7-F387-1CAD-8ACD2D8DF0C8");
    public static final UUID PSD_CP = UUID.fromString("FB005C22-02E7-F387-1CAD-8ACD2D8DF0C8");
    public static final UUID PSD_PP = UUID.fromString("FB005C26-02E7-F387-1CAD-8ACD2D8DF0C8");

    public static class PPData {
        private final int blockerBit;
        private final int hr;
        private final int ppErrorEstimate;
        private final int ppInMs;
        private final int rc;
        private final int skinContactStatus;
        private final int skinContactSupported;

        public PPData(byte[] bArr) {
            this.rc = (int) (((long) bArr[0]) & 255);
            this.hr = (int) (((long) bArr[1]) & 255);
            this.ppInMs = (int) ((((long) bArr[2]) & 255) | ((((long) bArr[3]) & 255) << 8));
            this.ppErrorEstimate = (int) (((255 & ((long) bArr[5])) << 8) | (((long) bArr[4]) & 255));
            byte b = bArr[6];
            this.blockerBit = b & 1;
            this.skinContactStatus = (b & 2) >> 1;
            this.skinContactSupported = (b & 4) >> 2;
        }
    }

    public static class PsdFeature {
        public boolean accSupported;
        public boolean ecgSupported;
        public boolean ohrSupported;
        public boolean ppSupported;

        public PsdFeature(byte[] bArr) {
            byte b = bArr[0];
            this.ecgSupported = (b & 1) == 1;
            this.ohrSupported = ((b & 2) >> 1) == 1;
            this.accSupported = ((b & 4) >> 2) == 1;
            this.ppSupported = (b & 8) != 0;
        }
    }

    public BlePsdClient(BleGattTxInterface bleGattTxInterface) {
        super(bleGattTxInterface, PSD_SERVICE);
        this.psdMutex = new Object();
        this.psdFeature = null;
        this.mutexFeature = new Object();
        this.psdCpInputQueue = new LinkedBlockingQueue<>();
        this.scheduler = Schedulers.newThread();
        this.ppObservers = new AtomicSet<>();
        addCharacteristicRead(PSD_FEATURE);
        UUID uuid = PSD_CP;
        addCharacteristicNotification(uuid);
        addCharacteristicNotification(PSD_PP);
        this.psdCpEnabled = getNotificationAtomicInteger(uuid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$processServiceData$0(byte[] bArr, FlowableEmitter flowableEmitter) {
        flowableEmitter.onNext(new PPData(bArr));
    }

    private List<byte[]> splitPP(byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < bArr.length) {
            int i2 = i + 7;
            arrayList.add(Arrays.copyOfRange(bArr, i, i2));
            i = i2;
        }
        return arrayList;
    }

    @Override // com.polar.androidcommunications.api.ble.model.gatt.BleGattBase
    public void processServiceData(UUID uuid, byte[] bArr, int i, boolean z) {
        if (uuid.equals(PSD_CP)) {
            this.psdCpInputQueue.add(new Pair<>(bArr, Integer.valueOf(i)));
            return;
        }
        if (uuid.equals(PSD_FEATURE)) {
            synchronized (this.mutexFeature) {
                try {
                    if (i == 0) {
                        this.psdFeature = new PsdFeature(bArr);
                    } else {
                        BleLogger.w("BlePsdClient", "Process service data for feature characteristics with status " + i + ", skipped");
                    }
                    this.mutexFeature.notifyAll();
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        if (i != 0) {
            BleLogger.w("BlePsdClient", "Process service data with status " + i + ", skipped");
            return;
        }
        if (uuid.equals(PSD_PP)) {
            Iterator<byte[]> it = splitPP(bArr).iterator();
            while (it.hasNext()) {
                RxUtils.emitNext(this.ppObservers, new LoginFragment$$ExternalSyntheticLambda0(it.next(), 18));
            }
        }
    }

    @Override // com.polar.androidcommunications.api.ble.model.gatt.BleGattBase
    public void processServiceDataWritten(UUID uuid, int i) {
    }

    @Override // com.polar.androidcommunications.api.ble.model.gatt.BleGattBase
    public void reset() {
        super.reset();
        this.psdCpInputQueue.clear();
        synchronized (this.mutexFeature) {
            this.psdFeature = null;
            this.mutexFeature.notifyAll();
        }
        RxUtils.postDisconnectedAndClearList(this.ppObservers);
    }

    public String toString() {
        return "psd client";
    }
}
