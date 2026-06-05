package com.ftdi.j2xx;

import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.util.Log;
import java.nio.ByteBuffer;
import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes3.dex */
class BulkInWorker implements Runnable {
    UsbEndpoint mBulkInEndpoint;
    UsbDeviceConnection mConnection;
    FT_Device mDevice;
    int mNrBuf;
    Semaphore mPauseLock = new Semaphore(1);
    boolean mPaused = false;
    ProcessInCtrl mProInCtrl;
    int mReadTimeout;
    int mTransSize;

    public BulkInWorker(FT_Device fT_Device, ProcessInCtrl processInCtrl, UsbDeviceConnection usbDeviceConnection, UsbEndpoint usbEndpoint) {
        this.mDevice = fT_Device;
        this.mBulkInEndpoint = usbEndpoint;
        this.mConnection = usbDeviceConnection;
        this.mProInCtrl = processInCtrl;
        this.mNrBuf = processInCtrl.getParams().getBufferNumber();
        this.mTransSize = this.mProInCtrl.getParams().getMaxTransferSize();
        this.mReadTimeout = this.mDevice.getDriverParameters().getReadTimeout();
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = 0;
        do {
            try {
                try {
                    if (this.mPaused) {
                        this.mPauseLock.acquire();
                        this.mPauseLock.release();
                    }
                    InBuffer inBufferAcquireWritableBuffer = this.mProInCtrl.acquireWritableBuffer(i);
                    if (inBufferAcquireWritableBuffer.getLength() == 0) {
                        ByteBuffer inputBuffer = inBufferAcquireWritableBuffer.getInputBuffer();
                        inputBuffer.clear();
                        inBufferAcquireWritableBuffer.setBufferId(i);
                        int iBulkTransfer = this.mConnection.bulkTransfer(this.mBulkInEndpoint, inputBuffer.array(), this.mTransSize, this.mReadTimeout);
                        if (iBulkTransfer > 0) {
                            inputBuffer.position(iBulkTransfer);
                            inputBuffer.flip();
                            inBufferAcquireWritableBuffer.setLength(iBulkTransfer);
                            this.mProInCtrl.releaseReadableBuffer(i);
                        }
                    }
                    i = (i + 1) % this.mNrBuf;
                } catch (Exception e) {
                    Log.d("BulkIn::", "Stop BulkIn thread");
                    e.printStackTrace();
                    return;
                }
            } catch (InterruptedException unused) {
                this.mProInCtrl.releaseWritableBuffers();
                this.mProInCtrl.purgeINData();
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                Log.e("BulkIn::", "Fatal error in BulkIn thread");
                return;
            }
        } while (!Thread.interrupted());
        throw new InterruptedException();
    }
}
