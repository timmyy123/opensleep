package com.ftdi.j2xx;

import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
class ProcessRequestWorker implements Runnable {
    int mNrBuf;
    private ProcessInCtrl mProInCtrl;

    public ProcessRequestWorker(ProcessInCtrl processInCtrl) {
        this.mProInCtrl = processInCtrl;
        this.mNrBuf = processInCtrl.getParams().getBufferNumber();
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = 0;
        do {
            try {
                InBuffer inBufferAcquireReadableBuffer = this.mProInCtrl.acquireReadableBuffer(i);
                if (inBufferAcquireReadableBuffer.getLength() > 0) {
                    this.mProInCtrl.processBulkInData(inBufferAcquireReadableBuffer);
                    inBufferAcquireReadableBuffer.purge();
                }
                this.mProInCtrl.releaseWritableBuffer(i);
                i = (i + 1) % this.mNrBuf;
            } catch (InterruptedException e) {
                Log.d("ProcessRequestThread::", "Device has been closed.");
                e.printStackTrace();
                return;
            } catch (Exception e2) {
                Log.e("ProcessRequestThread::", "Fatal error!");
                e2.printStackTrace();
                return;
            }
        } while (!Thread.interrupted());
        throw new InterruptedException();
    }
}
