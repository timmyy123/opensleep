package com.ftdi.j2xx;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import com.ftdi.j2xx.D2xxManager;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes3.dex */
class ProcessInCtrl {
    private int mBufInCounter;
    private ByteBuffer[] mBuffers;
    private Object mCounterLock;
    private FT_Device mDevice;
    private Condition mFullCon;
    private Lock mInFullLock;
    private InBuffer[] mInputBufs;
    private ByteBuffer mMainBuf;
    private Pipe mMainPipe;
    private Pipe.SinkChannel mMainSink;
    private Pipe.SourceChannel mMainSource;
    private int mMaxPacketSize;
    private int mNrBuf;
    private D2xxManager.DriverParameters mParams;
    private Condition mReadInCon;
    private Lock mReadInLock;
    private Semaphore[] mReadable;
    private boolean mSinkFull;
    private Object mSinkFullLock;
    private Semaphore[] mWritable;

    public ProcessInCtrl(FT_Device fT_Device) {
        this.mDevice = fT_Device;
        D2xxManager.DriverParameters driverParameters = fT_Device.getDriverParameters();
        this.mParams = driverParameters;
        this.mNrBuf = driverParameters.getBufferNumber();
        int maxBufferSize = this.mParams.getMaxBufferSize();
        this.mMaxPacketSize = this.mDevice.getMaxPacketSize();
        int i = this.mNrBuf;
        this.mWritable = new Semaphore[i];
        this.mReadable = new Semaphore[i];
        this.mInputBufs = new InBuffer[i];
        this.mBuffers = new ByteBuffer[256];
        ReentrantLock reentrantLock = new ReentrantLock();
        this.mInFullLock = reentrantLock;
        this.mFullCon = reentrantLock.newCondition();
        this.mSinkFull = false;
        ReentrantLock reentrantLock2 = new ReentrantLock();
        this.mReadInLock = reentrantLock2;
        this.mReadInCon = reentrantLock2.newCondition();
        this.mCounterLock = new Object();
        this.mSinkFullLock = new Object();
        resetBufCount();
        this.mMainBuf = ByteBuffer.allocateDirect(maxBufferSize);
        try {
            Pipe pipeOpen = Pipe.open();
            this.mMainPipe = pipeOpen;
            this.mMainSink = pipeOpen.sink();
            this.mMainSource = this.mMainPipe.source();
        } catch (IOException e) {
            Log.d("ProcessInCtrl", "Create mMainPipe failed!");
            e.printStackTrace();
        }
        for (int i2 = 0; i2 < this.mNrBuf; i2++) {
            this.mInputBufs[i2] = new InBuffer(maxBufferSize);
            this.mReadable[i2] = new Semaphore(1);
            this.mWritable[i2] = new Semaphore(1);
            try {
                acquireReadableBuffer(i2);
            } catch (Exception e2) {
                Log.d("ProcessInCtrl", "Acquire read buffer " + i2 + " failed!");
                e2.printStackTrace();
            }
        }
    }

    private int decBufCount(int i) {
        int i2;
        synchronized (this.mCounterLock) {
            i2 = this.mBufInCounter - i;
            this.mBufInCounter = i2;
        }
        return i2;
    }

    private void extractReadData(InBuffer inBuffer) {
        int i;
        short s;
        int i2;
        ByteBuffer inputBuffer = inBuffer.getInputBuffer();
        int length = inBuffer.getLength();
        if (length > 0) {
            int i3 = this.mMaxPacketSize;
            boolean z = true;
            int i4 = (length / i3) + (length % i3 > 0 ? 1 : 0);
            int i5 = 0;
            int i6 = 0;
            short s2 = 0;
            short s3 = 0;
            while (i5 < i4) {
                if (i5 == i4 - 1) {
                    inputBuffer.limit(length);
                    int i7 = this.mMaxPacketSize * i5;
                    inputBuffer.position(i7);
                    byte b = inputBuffer.get();
                    D2xxManager.FtDeviceInfoListNode ftDeviceInfoListNode = this.mDevice.mDeviceInfoNode;
                    short s4 = (short) (b & 240);
                    s = (short) (ftDeviceInfoListNode.modemStatus ^ s4);
                    ftDeviceInfoListNode.modemStatus = s4;
                    this.mDevice.mDeviceInfoNode.lineStatus = (short) (inputBuffer.get() & 255);
                    i2 = i7 + 2;
                    if (inputBuffer.hasRemaining()) {
                        s3 = (short) (this.mDevice.mDeviceInfoNode.lineStatus & 30);
                        i = length;
                    } else {
                        i = length;
                        s3 = 0;
                    }
                } else {
                    i = (i5 + 1) * this.mMaxPacketSize;
                    inputBuffer.limit(i);
                    int i8 = (this.mMaxPacketSize * i5) + 2;
                    inputBuffer.position(i8);
                    s = s2;
                    i2 = i8;
                }
                i6 += i - i2;
                this.mBuffers[i5] = inputBuffer.slice();
                i5++;
                s2 = s;
            }
            if (i6 != 0) {
                try {
                    long jWrite = this.mMainSink.write(this.mBuffers, 0, i4);
                    if (jWrite != i6) {
                        Log.d("extractReadData::", "written != totalData, written= " + jWrite + " totalData=" + i6);
                    }
                    incBufCount((int) jWrite);
                    this.mReadInLock.lock();
                    this.mReadInCon.signalAll();
                    this.mReadInLock.unlock();
                } catch (Exception e) {
                    Log.d("extractReadData::", "Write data to sink failed!!");
                    e.printStackTrace();
                }
            } else {
                z = false;
            }
            inputBuffer.clear();
            processEventChars(z, s2, s3);
        }
    }

    private int incBufCount(int i) {
        int i2;
        synchronized (this.mCounterLock) {
            i2 = this.mBufInCounter + i;
            this.mBufInCounter = i2;
        }
        return i2;
    }

    private void resetBufCount() {
        synchronized (this.mCounterLock) {
            this.mBufInCounter = 0;
        }
    }

    public InBuffer acquireReadableBuffer(int i) throws InterruptedException {
        this.mReadable[i].acquire();
        return getBuffer(i);
    }

    public InBuffer acquireWritableBuffer(int i) throws InterruptedException {
        this.mWritable[i].acquire();
        InBuffer buffer = getBuffer(i);
        if (buffer.acquire(i) == null) {
            return null;
        }
        return buffer;
    }

    public void close() {
        for (int i = 0; i < this.mNrBuf; i++) {
            try {
                releaseReadableBuffer(i);
            } catch (Exception e) {
                Log.d("ProcessInCtrl", "Acquire read buffer " + i + " failed!");
                e.printStackTrace();
            }
            this.mInputBufs[i] = null;
            this.mReadable[i] = null;
            this.mWritable[i] = null;
        }
        for (int i2 = 0; i2 < 256; i2++) {
            this.mBuffers[i2] = null;
        }
        this.mWritable = null;
        this.mReadable = null;
        this.mInputBufs = null;
        this.mBuffers = null;
        this.mMainBuf = null;
        if (this.mSinkFull) {
            this.mInFullLock.lock();
            this.mFullCon.signalAll();
            this.mInFullLock.unlock();
        }
        this.mReadInLock.lock();
        this.mReadInCon.signalAll();
        this.mReadInLock.unlock();
        this.mInFullLock = null;
        this.mFullCon = null;
        this.mCounterLock = null;
        this.mReadInLock = null;
        this.mReadInCon = null;
        try {
            this.mMainSink.close();
            this.mMainSink = null;
            this.mMainSource.close();
            this.mMainSource = null;
            this.mMainPipe = null;
        } catch (IOException e2) {
            Log.d("ProcessInCtrl", "Close mMainPipe failed!");
            e2.printStackTrace();
        }
        this.mDevice = null;
        this.mParams = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public InBuffer getBuffer(int i) {
        InBuffer inBuffer;
        synchronized (this.mInputBufs) {
            if (i >= 0) {
                try {
                    inBuffer = i < this.mNrBuf ? this.mInputBufs[i] : null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return inBuffer;
    }

    public int getBytesAvailable() {
        int i;
        synchronized (this.mCounterLock) {
            i = this.mBufInCounter;
        }
        return i;
    }

    public int getFreeSpace() {
        return (this.mParams.getMaxBufferSize() - getBytesAvailable()) - 1;
    }

    public D2xxManager.DriverParameters getParams() {
        return this.mParams;
    }

    public void processBulkInData(InBuffer inBuffer) throws D2xxManager.D2xxException {
        int freeSpace;
        int i;
        try {
            int length = inBuffer.getLength();
            if (length < 2) {
                inBuffer.getInputBuffer().clear();
                return;
            }
            synchronized (this.mSinkFullLock) {
                try {
                    freeSpace = getFreeSpace();
                    i = length - 2;
                    if (freeSpace < i) {
                        Log.d("ProcessBulkIn::", " Buffer is full, waiting for read....");
                        processEventChars(false, (short) 0, (short) 0);
                        this.mInFullLock.lock();
                        this.mSinkFull = true;
                    }
                } finally {
                }
            }
            if (freeSpace < i) {
                this.mFullCon.await();
                this.mInFullLock.unlock();
            }
            extractReadData(inBuffer);
        } catch (InterruptedException e) {
            this.mInFullLock.unlock();
            Log.e("ProcessInCtrl", "Exception in Full await!");
            e.printStackTrace();
        } catch (Exception e2) {
            Log.e("ProcessInCtrl", "Exception in ProcessBulkIN");
            e2.printStackTrace();
            throw new D2xxManager.D2xxException("Fatal error in BulkIn.");
        }
    }

    public int processEventChars(boolean z, short s, short s2) {
        TFtEventNotify tFtEventNotify = new TFtEventNotify();
        FT_Device fT_Device = this.mDevice;
        long j = fT_Device.mEventNotification.Mask;
        tFtEventNotify.Mask = j;
        if (z && (j & 1) != 0) {
            long j2 = fT_Device.mEventMask;
            if ((j2 ^ 1) == 1) {
                fT_Device.mEventMask = j2 | 1;
                Intent intent = new Intent("FT_EVENT_RXCHAR");
                intent.putExtra("message", "FT_EVENT_RXCHAR");
                LocalBroadcastManager.getInstance(this.mDevice.mContext).sendBroadcast(intent);
            }
        }
        if (s != 0 && (tFtEventNotify.Mask & 2) != 0) {
            FT_Device fT_Device2 = this.mDevice;
            long j3 = fT_Device2.mEventMask;
            if ((j3 ^ 2) == 2) {
                fT_Device2.mEventMask = 2 | j3;
                Intent intent2 = new Intent("FT_EVENT_MODEM_STATUS");
                intent2.putExtra("message", "FT_EVENT_MODEM_STATUS");
                LocalBroadcastManager.getInstance(this.mDevice.mContext).sendBroadcast(intent2);
            }
        }
        if (s2 == 0 || (tFtEventNotify.Mask & 4) == 0) {
            return 0;
        }
        FT_Device fT_Device3 = this.mDevice;
        long j4 = fT_Device3.mEventMask;
        if ((j4 ^ 4) != 4) {
            return 0;
        }
        fT_Device3.mEventMask = j4 | 4;
        Intent intent3 = new Intent("FT_EVENT_LINE_STATUS");
        intent3.putExtra("message", "FT_EVENT_LINE_STATUS");
        LocalBroadcastManager.getInstance(this.mDevice.mContext).sendBroadcast(intent3);
        return 0;
    }

    public int purgeINData() {
        int i;
        int bufferNumber = this.mParams.getBufferNumber();
        synchronized (this.mMainBuf) {
            do {
                try {
                    this.mMainSource.configureBlocking(false);
                    i = this.mMainSource.read(this.mMainBuf);
                    this.mMainBuf.clear();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } while (i != 0);
            resetBufCount();
            for (int i2 = 0; i2 < bufferNumber; i2++) {
                InBuffer buffer = getBuffer(i2);
                if (buffer.acquired() && buffer.getLength() > 2) {
                    buffer.purge();
                }
            }
        }
        return 0;
    }

    public int readBulkInData(byte[] bArr, int i, long j) {
        this.mParams.getMaxBufferSize();
        long jCurrentTimeMillis = System.currentTimeMillis();
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, 0, i);
        if (j == 0) {
            j = this.mParams.getReadTimeout();
        }
        while (this.mDevice.isOpen()) {
            if (getBytesAvailable() >= i) {
                synchronized (this.mMainSource) {
                    try {
                        this.mMainSource.read(byteBufferWrap);
                        decBufCount(i);
                    } catch (Exception e) {
                        Log.d("readBulkInData::", "Cannot read data from Source!!");
                        e.printStackTrace();
                    }
                }
                synchronized (this.mSinkFullLock) {
                    try {
                        if (this.mSinkFull) {
                            Log.i("FTDI debug::", "buffer is full , and also re start buffer");
                            this.mInFullLock.lock();
                            this.mFullCon.signalAll();
                            this.mSinkFull = false;
                            this.mInFullLock.unlock();
                        }
                    } finally {
                    }
                }
                return i;
            }
            try {
                this.mReadInLock.lock();
                this.mReadInCon.await(System.currentTimeMillis() - jCurrentTimeMillis, TimeUnit.MILLISECONDS);
                this.mReadInLock.unlock();
            } catch (InterruptedException e2) {
                Log.d("readBulkInData::", "Cannot wait to read data!!");
                e2.printStackTrace();
                this.mReadInLock.unlock();
            }
            if (System.currentTimeMillis() - jCurrentTimeMillis >= j) {
                break;
            }
        }
        return 0;
    }

    public void releaseReadableBuffer(int i) {
        this.mReadable[i].release();
    }

    public void releaseWritableBuffer(int i) {
        synchronized (this.mInputBufs) {
            this.mInputBufs[i].release(i);
        }
        this.mWritable[i].release();
    }

    public void releaseWritableBuffers() {
        int bufferNumber = this.mParams.getBufferNumber();
        for (int i = 0; i < bufferNumber; i++) {
            if (getBuffer(i).acquired()) {
                releaseWritableBuffer(i);
            }
        }
    }
}
