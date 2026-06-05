package com.urbandroid.sleep.hr.berry.parser;

import com.facebook.internal.Utility;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.hr.berry.BerryOximeterBLEClient$$ExternalSyntheticLambda0;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes.dex */
public class DataParser {
    private final PackageReceivedListener listener;

    /* JADX INFO: renamed from: protocol, reason: collision with root package name */
    private volatile Protocol f66protocol;
    private volatile Thread thread;
    private ProtocolVersion protocalVarsion = ProtocolVersion.V1;
    private final LinkedBlockingQueue<Integer> bufferQueue = new LinkedBlockingQueue<>(Utility.DEFAULT_STREAM_BUFFER_SIZE);
    private volatile boolean stopRequested = false;
    private int BERRY_LEN = 18;

    public interface PackageReceivedListener {
    }

    public enum Protocol {
        BCI,
        ISRAEL,
        AUTO
    }

    public enum ProtocolVersion {
        V1,
        V2
    }

    public DataParser(Protocol protocol2, PackageReceivedListener packageReceivedListener) {
        this.f66protocol = protocol2;
        this.listener = packageReceivedListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getData() {
        return this.bufferQueue.take().intValue();
    }

    private int toUnsignedInt(byte b) {
        return b & 255;
    }

    public void add(byte[] bArr) {
        if (this.stopRequested) {
            return;
        }
        if (this.bufferQueue.remainingCapacity() < bArr.length) {
            Logger.logInfo("DataParser: The queue is full. Discarding all buffered data");
            this.bufferQueue.clear();
        }
        for (byte b : bArr) {
            try {
                this.bufferQueue.put(Integer.valueOf(toUnsignedInt(b)));
            } catch (InterruptedException unused) {
                Logger.logInfo("DataParser: producer thread interrupted");
            }
        }
    }

    public void start() {
        this.thread = new Thread(new ParseRunnable(this, 0));
        this.thread.start();
    }

    public void stop() {
        this.stopRequested = true;
        if (this.thread != null) {
            this.thread.interrupt();
        }
    }

    public class ParseRunnable implements Runnable {

        /* JADX INFO: renamed from: data, reason: collision with root package name */
        private int f67data;
        private int n55;
        private int nAutoTest;
        private int naa;
        private int nbb;
        private int[] packageData;

        private ParseRunnable() {
            this.nAutoTest = 0;
            this.n55 = 0;
            this.naa = 0;
            this.nbb = 0;
        }

        @Override // java.lang.Runnable
        public void run() {
            DataParser dataParser;
            try {
                try {
                    Logger.logInfo("DataParser: started");
                    while (!DataParser.this.stopRequested) {
                        int iOrdinal = DataParser.this.f66protocol.ordinal();
                        int i = 1;
                        if (iOrdinal != 0) {
                            if (iOrdinal == 1) {
                                this.f67data = DataParser.this.getData();
                                int i2 = DataParser.this.protocalVarsion == ProtocolVersion.V1 ? 170 : 187;
                                if (this.f67data == 85) {
                                    int data2 = DataParser.this.getData();
                                    this.f67data = data2;
                                    if (data2 == i2) {
                                        int[] iArr = new int[12];
                                        this.packageData = iArr;
                                        iArr[0] = 85;
                                        iArr[1] = i2;
                                        for (int i3 = 2; i3 < 12; i3++) {
                                            this.packageData[i3] = DataParser.this.getData();
                                        }
                                        ((BerryOximeterBLEClient$$ExternalSyntheticLambda0) DataParser.this.listener).packageReceived(DataParser.this.f66protocol, this.packageData);
                                    }
                                }
                            } else if (iOrdinal == 2) {
                                int data3 = DataParser.this.getData();
                                this.f67data = data3;
                                int i4 = this.nAutoTest + 1;
                                this.nAutoTest = i4;
                                if (data3 == 85) {
                                    this.n55++;
                                }
                                if (data3 == 170) {
                                    this.naa++;
                                }
                                if (data3 == 187) {
                                    this.nbb++;
                                }
                                if (i4 % 20 == 0) {
                                    Logger.logInfo("DataParser: nAutoTest=" + this.nAutoTest + ", n55=" + this.n55 + ", naa=" + this.naa + ", nbb: " + this.nbb);
                                }
                                if (this.nAutoTest > 60) {
                                    int i5 = this.n55;
                                    if ((i5 < 9 || this.nbb < 9) && i5 > 1 && this.nbb > 1) {
                                        DataParser.this.f66protocol = Protocol.ISRAEL;
                                        DataParser.this.protocalVarsion = ProtocolVersion.V2;
                                        Logger.logInfo("DataParser: nAutoTest - ISRAEL V2");
                                    } else if ((i5 < 9 || this.naa < 9) && i5 > 1 && this.naa > 1) {
                                        DataParser.this.f66protocol = Protocol.ISRAEL;
                                        Logger.logInfo("DataParser: nAutoTest - ISRAEL");
                                    } else {
                                        DataParser.this.f66protocol = Protocol.BCI;
                                        Logger.logInfo("DataParser: nAutoTest - BCI");
                                    }
                                    this.nAutoTest = 0;
                                    this.n55 = 0;
                                    this.naa = 0;
                                    this.nbb = 0;
                                }
                            }
                        } else {
                            int data4 = DataParser.this.getData();
                            this.f67data = data4;
                            int[] iArr2 = new int[5];
                            this.packageData = iArr2;
                            if ((data4 & 128) > 0) {
                                iArr2[0] = data4;
                                while (true) {
                                    dataParser = DataParser.this;
                                    if (i >= 5) {
                                        break;
                                    }
                                    int data5 = dataParser.getData();
                                    this.f67data = data5;
                                    if ((data5 & 128) == 0) {
                                        this.packageData[i] = data5;
                                    }
                                    i++;
                                }
                                ((BerryOximeterBLEClient$$ExternalSyntheticLambda0) dataParser.listener).packageReceived(DataParser.this.f66protocol, this.packageData);
                            }
                        }
                    }
                    Logger.logInfo("DataParser: stopped");
                } catch (InterruptedException unused) {
                    Logger.logInfo("DataParser: consumer thread interrupted");
                    Logger.logInfo("DataParser: stopped");
                }
            } catch (Throwable th) {
                Logger.logInfo("DataParser: stopped");
                throw th;
            }
        }

        public /* synthetic */ ParseRunnable(DataParser dataParser, int i) {
            this();
        }
    }
}
