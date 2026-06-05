package com.polar.androidcommunications.api.ble.model.gatt.client.psftp;

import androidx.core.util.Pair;
import androidx.work.ListenableFutureKt$$ExternalSyntheticLambda0;
import com.polar.androidcommunications.api.ble.BleLogger;
import com.polar.androidcommunications.api.ble.exceptions.BleCharacteristicNotificationNotEnabled;
import com.polar.androidcommunications.api.ble.exceptions.BleDisconnected;
import com.polar.androidcommunications.api.ble.model.gatt.BleGattBase;
import com.polar.androidcommunications.api.ble.model.gatt.BleGattTxInterface;
import com.polar.androidcommunications.api.ble.model.gatt.client.psftp.BlePsFtpUtils;
import com.polar.androidcommunications.api.ble.model.proto.CommunicationsPftpRequest$PbPFtpOperation;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes4.dex */
public class BlePsFtpClient extends BleGattBase {
    private Flowable<Object> _sharedWaitNotificationFlowable;
    private final AtomicBoolean currentOperationWrite;
    private final List<String> extendedWriteTimeoutFilePaths;
    private final LinkedBlockingQueue<Pair<byte[], Integer>> mtuInputQueue;
    private final AtomicBoolean mtuWaiting;
    private final LinkedBlockingQueue<Pair<byte[], Integer>> notificationInputQueue;
    private final AtomicInteger notificationPacketsWritten;
    private final AtomicBoolean notificationWaiting;
    private final AtomicInteger packetsCount;
    private final AtomicInteger packetsWritten;
    private final AtomicInteger packetsWrittenWithResponse;
    private final AtomicInteger pftpD2HNotificationEnabled;
    private final AtomicInteger pftpMtuEnabled;
    private final Object pftpNotificationMutex;
    private final Object pftpOperationMutex;
    private final Object pftpWaitNotificationMutex;
    private final Object pftpWaitNotificationSharedMutex;
    private final AtomicBoolean useAttributeLevelResponse;

    public BlePsFtpClient(BleGattTxInterface bleGattTxInterface) {
        super(bleGattTxInterface, BlePsFtpUtils.RFC77_PFTP_SERVICE, true);
        this.mtuInputQueue = new LinkedBlockingQueue<>();
        this.notificationInputQueue = new LinkedBlockingQueue<>();
        this.packetsWritten = new AtomicInteger(0);
        this.packetsWrittenWithResponse = new AtomicInteger(0);
        this.mtuWaiting = new AtomicBoolean(false);
        this.currentOperationWrite = new AtomicBoolean(false);
        this.notificationWaiting = new AtomicBoolean(false);
        this.notificationPacketsWritten = new AtomicInteger(0);
        this.packetsCount = new AtomicInteger(5);
        this.extendedWriteTimeoutFilePaths = Collections.singletonList("/SYNCPART.TGZ");
        this.useAttributeLevelResponse = new AtomicBoolean(false);
        this.pftpOperationMutex = new Object();
        this.pftpNotificationMutex = new Object();
        this.pftpWaitNotificationMutex = new Object();
        this.pftpWaitNotificationSharedMutex = new Object();
        this._sharedWaitNotificationFlowable = null;
        UUID uuid = BlePsFtpUtils.RFC77_PFTP_MTU_CHARACTERISTIC;
        addCharacteristicNotification(uuid);
        UUID uuid2 = BlePsFtpUtils.RFC77_PFTP_D2H_CHARACTERISTIC;
        addCharacteristicNotification(uuid2);
        addCharacteristic(BlePsFtpUtils.RFC77_PFTP_H2D_CHARACTERISTIC);
        this.pftpMtuEnabled = getNotificationAtomicInteger(uuid);
        this.pftpD2HNotificationEnabled = getNotificationAtomicInteger(uuid2);
        setIsPrimaryService(true);
    }

    private long getWriteTimeoutForFilePath(String str) {
        Iterator<String> it = this.extendedWriteTimeoutFilePaths.iterator();
        while (it.hasNext()) {
            if (str.startsWith(it.next())) {
                return 900L;
            }
        }
        return 90L;
    }

    private void handleMtuInterrupted(boolean z, int i) {
        if (this.pftpMtuEnabled.get() == 0 && z) {
            byte[] bArr = {0, 0, 0};
            try {
                if (this.mtuWaiting.get()) {
                    waitPacketsWritten(this.packetsWritten, this.mtuWaiting, i, 90L);
                }
                this.txInterface.transmitMessages(BlePsFtpUtils.RFC77_PFTP_SERVICE, BlePsFtpUtils.RFC77_PFTP_MTU_CHARACTERISTIC, Collections.singletonList(bArr), this.useAttributeLevelResponse.get());
                waitPacketsWritten(this.packetsWritten, this.mtuWaiting, 1, 90L);
                BleLogger.d("BlePsFtpClient", "MTU interrupted. Stream cancel has been successfully send");
            } catch (Throwable unused) {
                BleLogger.e("BlePsFtpClient", "Exception while trying to cancel streaming");
            }
        }
    }

    private void handlePacketError(Pair<byte[], Integer> pair) throws BlePsFtpUtils.PftpResponseError, BlePsFtpUtils.PftpOperationTimeout, BleDisconnected {
        if (!this.txInterface.isConnected()) {
            throw new BleDisconnected("Connection lost during packet read");
        }
        if (pair == null) {
            throw new BlePsFtpUtils.PftpOperationTimeout("Air packet was not received in required timeline");
        }
        throw new BlePsFtpUtils.PftpResponseError("Response error: " + pair.second, pair.second.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0118, code lost:
    
        r19.currentOperationWrite.set(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0123, code lost:
    
        readResponse(new java.io.ByteArrayOutputStream(), r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0126, code lost:
    
        r22.onComplete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x012a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x012f, code lost:
    
        if (r22.isCancelled() == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0131, code lost:
    
        r22.tryOnError(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0136, code lost:
    
        com.polar.androidcommunications.api.ble.BleLogger.e("BlePsFtpClient", "write interrupted while reading response");
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:?, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0168  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ void lambda$write$2(byte[] bArr, ByteArrayInputStream byteArrayInputStream, FlowableEmitter flowableEmitter) {
        ByteArrayInputStream byteArrayInputStream2;
        int i;
        int i2;
        long j;
        int i3;
        synchronized (this.pftpOperationMutex) {
            if (this.pftpMtuEnabled.get() == 0) {
                BleLogger.d("BlePsFtpClient", "Start write");
                this.currentOperationWrite.set(true);
                resetMtuPipe();
                int length = bArr.length;
                int i4 = 0;
                ByteArrayInputStream byteArrayInputStreamMakeCompleteMessageStream = BlePsFtpUtils.makeCompleteMessageStream(new ByteArrayInputStream(bArr), byteArrayInputStream, BlePsFtpUtils.MessageType.REQUEST, 0);
                long jAvailable = byteArrayInputStreamMakeCompleteMessageStream.available();
                BlePsFtpUtils.Rfc76SequenceNumber rfc76SequenceNumber = new BlePsFtpUtils.Rfc76SequenceNumber();
                long writeTimeoutForFilePath = getWriteTimeoutForFilePath(CommunicationsPftpRequest$PbPFtpOperation.parseFrom(bArr).getPath());
                long j2 = 0;
                int i5 = 0;
                long j3 = 0;
                while (true) {
                    try {
                        try {
                            byte[] bArrBuildRfc76MessageFrame = BlePsFtpUtils.buildRfc76MessageFrame(byteArrayInputStreamMakeCompleteMessageStream, i5, this.mtuSize.get(), rfc76SequenceNumber);
                            j = j3 + 1;
                            this.useAttributeLevelResponse.set(j % ((long) this.packetsCount.get()) == j2 ? 1 : i4);
                            this.txInterface.transmitMessage(BlePsFtpUtils.RFC77_PFTP_SERVICE, BlePsFtpUtils.RFC77_PFTP_MTU_CHARACTERISTIC, bArrBuildRfc76MessageFrame, this.useAttributeLevelResponse.get());
                            if (byteArrayInputStreamMakeCompleteMessageStream.available() != 0) {
                                try {
                                    if (this.useAttributeLevelResponse.get()) {
                                        try {
                                            this.packetsWrittenWithResponse.set(i4);
                                            waitPacketsWritten(this.packetsWrittenWithResponse, this.mtuWaiting, 1, writeTimeoutForFilePath);
                                            this.packetsWritten.set(i4);
                                            i = i4;
                                        } catch (InterruptedException unused) {
                                            i2 = i4;
                                            byteArrayInputStream2 = byteArrayInputStreamMakeCompleteMessageStream;
                                            i = 1;
                                            BleLogger.e("BlePsFtpClient", "Frame sending interrupted!");
                                            boolean z = i2;
                                            if (byteArrayInputStream2.available() != 0) {
                                            }
                                            handleMtuInterrupted(z, i);
                                            return;
                                        }
                                    } else {
                                        i = 1;
                                    }
                                    try {
                                        Pair<byte[], Integer> pairPoll = this.mtuInputQueue.poll();
                                        if (pairPoll != null && pairPoll.second.intValue() == 0) {
                                            BleLogger.e("BlePsFtpClient", "Frame sending interrupted by device!");
                                            BlePsFtpUtils.PftpRfc76ResponseHeader pftpRfc76ResponseHeaderProcessRfc76MessageFrameHeader = BlePsFtpUtils.processRfc76MessageFrameHeader(pairPoll.first);
                                            if (pftpRfc76ResponseHeaderProcessRfc76MessageFrameHeader.status == 0) {
                                                if (!flowableEmitter.isCancelled()) {
                                                    flowableEmitter.tryOnError(new BlePsFtpUtils.PftpResponseError("Stream canceled: ", pftpRfc76ResponseHeaderProcessRfc76MessageFrameHeader.error));
                                                }
                                            } else if (!flowableEmitter.isCancelled()) {
                                                flowableEmitter.tryOnError(new Throwable("Stream canceled"));
                                            }
                                            return;
                                        }
                                    } catch (InterruptedException unused2) {
                                        i3 = i4;
                                        byteArrayInputStream2 = byteArrayInputStreamMakeCompleteMessageStream;
                                        i2 = i3;
                                        BleLogger.e("BlePsFtpClient", "Frame sending interrupted!");
                                        boolean z2 = i2;
                                        if (byteArrayInputStream2.available() != 0) {
                                            z2 = 1;
                                        }
                                        handleMtuInterrupted(z2, i);
                                        return;
                                    }
                                } catch (InterruptedException unused3) {
                                    i = i4;
                                    i3 = i == true ? 1 : 0;
                                }
                            } else {
                                i = i4;
                            }
                            byteArrayInputStream2 = byteArrayInputStreamMakeCompleteMessageStream;
                        } catch (InterruptedException unused4) {
                            int i6 = i4;
                            byteArrayInputStream2 = byteArrayInputStreamMakeCompleteMessageStream;
                            i = i6 == true ? 1 : 0;
                            i2 = i6;
                        }
                        try {
                            flowableEmitter.onNext(Long.valueOf(((jAvailable - ((long) byteArrayInputStreamMakeCompleteMessageStream.available())) - ((long) length)) - 2));
                            if (byteArrayInputStream2.available() == 0) {
                                break;
                            }
                            i4 = 0;
                            byteArrayInputStreamMakeCompleteMessageStream = byteArrayInputStream2;
                            j3 = j;
                            i5 = 1;
                            j2 = 0;
                        } catch (InterruptedException unused5) {
                            i2 = 0;
                            BleLogger.e("BlePsFtpClient", "Frame sending interrupted!");
                            boolean z22 = i2;
                            if (byteArrayInputStream2.available() != 0) {
                            }
                            handleMtuInterrupted(z22, i);
                            return;
                        }
                    } catch (Throwable th) {
                        if (!flowableEmitter.isCancelled()) {
                            flowableEmitter.tryOnError(th);
                        }
                        return;
                    }
                }
            } else if (!flowableEmitter.isCancelled()) {
                throw new BleCharacteristicNotificationNotEnabled("PS-FTP MTU not enabled");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$write$3(Subscription subscription) {
        this.txInterface.gattClientRequestStopScanning();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$write$4() {
        this.txInterface.gattClientResumeScanning();
        this.currentOperationWrite.set(false);
    }

    private void resetMtuPipe() {
        BleLogger.d("BlePsFtpClient", "mtu reseted");
        this.mtuInputQueue.clear();
        this.packetsWritten.set(0);
        this.mtuWaiting.set(false);
    }

    private void waitPacketsWritten(AtomicInteger atomicInteger, AtomicBoolean atomicBoolean, int i, long j) {
        try {
            atomicBoolean.set(true);
            while (atomicInteger.get() < i) {
                synchronized (atomicInteger) {
                    try {
                        if (atomicInteger.get() != i) {
                            int i2 = atomicInteger.get();
                            atomicInteger.wait(1000 * j);
                            if (i2 == atomicInteger.get()) {
                                if (!this.txInterface.isConnected()) {
                                    throw new BleDisconnected("Connection lost during waiting packets to be written");
                                }
                                throw new BlePsFtpUtils.PftpOperationTimeout("Operation timeout while waiting packets written");
                            }
                        }
                    } finally {
                    }
                }
                if (!this.txInterface.isConnected()) {
                    throw new BleDisconnected("Connection lost during waiting packets to be written");
                }
            }
        } finally {
            atomicBoolean.set(false);
            atomicInteger.set(0);
        }
    }

    @Override // com.polar.androidcommunications.api.ble.model.gatt.BleGattBase
    public Completable clientReady(boolean z) {
        return waitPsFtpClientReady(z);
    }

    @Override // com.polar.androidcommunications.api.ble.model.gatt.BleGattBase
    public void processServiceData(UUID uuid, byte[] bArr, int i, boolean z) {
        if (i != 0) {
            BleLogger.w("BlePsFtpClient", "Process service data with status $status, skipping data");
            return;
        }
        if (bArr.length == 0) {
            BleLogger.e("BlePsFtpClient", "Received 0 length packet");
            return;
        }
        if (!uuid.equals(BlePsFtpUtils.RFC77_PFTP_MTU_CHARACTERISTIC)) {
            if (uuid.equals(BlePsFtpUtils.RFC77_PFTP_D2H_CHARACTERISTIC)) {
                synchronized (this.notificationInputQueue) {
                    this.notificationInputQueue.add(new Pair<>(bArr, Integer.valueOf(i)));
                    this.notificationInputQueue.notifyAll();
                }
                return;
            }
            return;
        }
        synchronized (this.mtuInputQueue) {
            this.mtuInputQueue.add(new Pair<>(bArr, Integer.valueOf(i)));
            this.mtuInputQueue.notifyAll();
        }
        if (this.currentOperationWrite.get() && this.mtuWaiting.get() && bArr.length == 3) {
            synchronized (this.packetsWritten) {
                this.packetsWritten.incrementAndGet();
                this.packetsWritten.notifyAll();
            }
        }
    }

    @Override // com.polar.androidcommunications.api.ble.model.gatt.BleGattBase
    public void processServiceDataWritten(UUID uuid, int i) {
        if (i != 0) {
            BleLogger.e("BlePsFtpClient", "Failed to write chr UUID: " + uuid.toString() + " status: " + i);
            return;
        }
        if (uuid.equals(BlePsFtpUtils.RFC77_PFTP_MTU_CHARACTERISTIC)) {
            synchronized (this.packetsWritten) {
                this.packetsWritten.incrementAndGet();
                this.packetsWritten.notifyAll();
            }
            return;
        }
        if (uuid.equals(BlePsFtpUtils.RFC77_PFTP_H2D_CHARACTERISTIC)) {
            synchronized (this.notificationPacketsWritten) {
                this.notificationPacketsWritten.incrementAndGet();
                this.notificationPacketsWritten.notifyAll();
            }
        }
    }

    @Override // com.polar.androidcommunications.api.ble.model.gatt.BleGattBase
    public void processServiceDataWrittenWithResponse(UUID uuid, int i) {
        if (i == 0 && uuid.equals(BlePsFtpUtils.RFC77_PFTP_MTU_CHARACTERISTIC)) {
            synchronized (this.packetsWrittenWithResponse) {
                this.packetsWrittenWithResponse.incrementAndGet();
                this.packetsWrittenWithResponse.notifyAll();
            }
        }
        processServiceDataWritten(uuid, i);
    }

    public void readResponse(ByteArrayOutputStream byteArrayOutputStream, long j) throws InterruptedException, BlePsFtpUtils.PftpResponseError, BlePsFtpUtils.PftpOperationTimeout, BleDisconnected {
        BlePsFtpUtils.Rfc76SequenceNumber rfc76SequenceNumber = new BlePsFtpUtils.Rfc76SequenceNumber();
        BlePsFtpUtils.PftpRfc76ResponseHeader pftpRfc76ResponseHeader = new BlePsFtpUtils.PftpRfc76ResponseHeader();
        long j2 = 0;
        int i = 0;
        while (this.txInterface.isConnected()) {
            synchronized (this.mtuInputQueue) {
                try {
                    if (this.mtuInputQueue.isEmpty()) {
                        this.mtuInputQueue.wait(1000 * j);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            Pair<byte[], Integer> pairPoll = this.mtuInputQueue.poll(90L, TimeUnit.SECONDS);
            if (pairPoll == null || pairPoll.second.intValue() != 0) {
                handlePacketError(pairPoll);
            } else {
                BlePsFtpUtils.processRfc76MessageFrameHeader(pftpRfc76ResponseHeader, pairPoll.first);
                if (rfc76SequenceNumber.getSeq() != pftpRfc76ResponseHeader.sequenceNumber) {
                    if (pftpRfc76ResponseHeader.status == 3) {
                        this.txInterface.transmitMessages(BlePsFtpUtils.RFC77_PFTP_SERVICE, BlePsFtpUtils.RFC77_PFTP_MTU_CHARACTERISTIC, Collections.singletonList(new byte[]{0, 0, 0}), true);
                        waitPacketsWritten(this.packetsWritten, this.mtuWaiting, 1, j);
                        BleLogger.d("BlePsFtpClient", "Sequence number mismatch. Stream cancel has been successfully send");
                    }
                    throw new BlePsFtpUtils.PftpResponseError("Air packet lost!", 303);
                }
                rfc76SequenceNumber.increment();
                int i2 = pftpRfc76ResponseHeader.status;
                long j3 = i2;
                if (i != pftpRfc76ResponseHeader.next) {
                    throw new BlePsFtpUtils.PftpResponseError("Protocol error stream is out of sync", 200);
                }
                if (i2 == 0) {
                    if (pftpRfc76ResponseHeader.error != 0) {
                        throw new BlePsFtpUtils.PftpResponseError("Request failed: ", pftpRfc76ResponseHeader.error);
                    }
                    return;
                } else {
                    if (i2 != 1 && i2 != 3) {
                        throw new BlePsFtpUtils.PftpResponseError("Protocol error, undefined status received", 200);
                    }
                    byte[] bArr = pftpRfc76ResponseHeader.payload;
                    byteArrayOutputStream.write(bArr, 0, bArr.length);
                    i = 1;
                    j2 = j3;
                }
            }
            if (j2 != 3) {
                BleLogger.d("BlePsFtpClient", "RFC76 message has read successfully");
                return;
            }
        }
        throw new BleDisconnected("Connection lost during read response");
    }

    @Override // com.polar.androidcommunications.api.ble.model.gatt.BleGattBase
    public void reset() {
        super.reset();
        this.currentOperationWrite.set(false);
        this.mtuInputQueue.clear();
        synchronized (this.mtuInputQueue) {
            this.mtuInputQueue.notifyAll();
        }
        this.packetsWritten.set(0);
        synchronized (this.packetsWritten) {
            this.packetsWritten.notifyAll();
        }
        this.packetsWrittenWithResponse.set(0);
        synchronized (this.packetsWrittenWithResponse) {
            this.packetsWrittenWithResponse.notifyAll();
        }
        this.notificationInputQueue.clear();
        synchronized (this.notificationInputQueue) {
            this.notificationInputQueue.notifyAll();
        }
        this.notificationPacketsWritten.set(0);
        synchronized (this.notificationPacketsWritten) {
            this.notificationPacketsWritten.notifyAll();
        }
        this.mtuWaiting.set(false);
        this.notificationWaiting.set(false);
    }

    public String toString() {
        return "RFC77 Service";
    }

    public Completable waitPsFtpClientReady(boolean z, Scheduler scheduler) {
        return Completable.concatArray(waitNotificationEnabled(BlePsFtpUtils.RFC77_PFTP_MTU_CHARACTERISTIC, z, scheduler), waitNotificationEnabled(BlePsFtpUtils.RFC77_PFTP_D2H_CHARACTERISTIC, z, scheduler));
    }

    public Flowable<Long> write(byte[] bArr, ByteArrayInputStream byteArrayInputStream, Scheduler scheduler) {
        return Flowable.create(new ListenableFutureKt$$ExternalSyntheticLambda0(this, bArr, byteArrayInputStream, 6), BackpressureStrategy.LATEST).doOnSubscribe(new BlePsFtpClient$$ExternalSyntheticLambda1(this)).doFinally(new BlePsFtpClient$$ExternalSyntheticLambda1(this)).subscribeOn(scheduler).serialize();
    }

    public Completable waitPsFtpClientReady(boolean z) {
        return waitPsFtpClientReady(z, Schedulers.io());
    }

    public Flowable<Long> write(byte[] bArr, ByteArrayInputStream byteArrayInputStream) {
        return write(bArr, byteArrayInputStream, Schedulers.newThread());
    }
}
