package com.hecz.android;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.ftdi.j2xx.D2xxManager;
import com.ftdi.j2xx.FT_Device;
import com.hecz.flex.FlexManager;
import com.hecz.player.flex.PcmmPlayer;
import com.hecz.serialcommon.ISerialConnection;
import com.hecz.serialcommon.flex.IFlex;
import com.hecz.serialcommon.flex.IFlexControl;
import java.io.File;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: classes4.dex */
public class J2xx extends Observable implements ISerialConnection, IFlexControl {
    public static D2xxManager ftD2xx;
    private static J2xx instance;
    int actualNumBytes;
    int baudRate;
    byte dataBit;
    private IFlex flex;
    byte flowControl;
    FT_Device ftDev;
    public Context global_context;
    int iReadIndex;
    int iTotalBytes;
    private IFlexListener listener;
    byte[] modemDataBuffer;
    int[] modemReceiveDataBytes;
    byte parity;
    private PcmmPlayer pcmmPlayer;
    byte[] readBuffer;
    char[] readBufferToChar;
    byte[] readDataBuffer;
    byte stopBit;
    byte[] writeBuffer;
    byte[] zmDataBuffer;
    int DevCount = -1;
    int currentPortIndex = -1;
    int portIndex = -1;
    private int allBytes = 0;
    private boolean isExit = false;
    boolean INTERNAL_DEBUG_TRACE = false;
    final String[] contentFormatItems = {"Character", "Hexadecimal"};
    final String[] fontSizeItems = {"5", "6", "7", "8", "10", "12", "14", "16", "18", "20"};
    final String[] echoSettingItems = {"On", "Off"};
    final String TT = "J2XX";
    final int MSG_SPECIAL_INFO = 98;
    final int MSG_UNHANDLED_CASE = 99;
    final byte XON = 17;
    final byte XOFF = 19;
    final int MODE_GENERAL_UART = 0;
    int transferMode = 0;
    int tempTransferMode = 0;
    final int PACTET_SIZE_XMODEM_CHECKSUM = 132;
    final int PACTET_SIZE_XMODEM_CRC = 133;
    final int PACTET_SIZE_XMODEM_1K_CRC = 1029;
    final int DATA_SIZE_128 = 128;
    final int DATA_SIZE_256 = 256;
    final int DATA_SIZE_512 = 512;
    final int DATA_SIZE_1K = 1024;
    final int MODEM_BUFFER_SIZE = 2048;
    byte receivedPacketNumber = 1;
    final int DATA_NONE = 0;
    final int DATA_ACK = 1;
    final int DATA_CHAR_C = 2;
    final int DATA_NAK = 3;
    int ymodemState = 0;
    int modemRemainData = 0;
    final byte LF = 10;
    final byte CR = MqttWireMessage.MESSAGE_TYPE_PINGRESP;
    int totalReceiveDataBytes = 0;
    int totalUpdateDataBytes = 0;
    File mPath = new File(Environment.getExternalStorageDirectory() + "//DIR//");
    File fGetFile = null;
    boolean bBackButtonClick = false;
    HandlerThread handlerThread = null;
    ReadThread readThread = null;
    boolean bSendButtonClick = false;
    boolean bLogButtonClick = false;
    boolean bFormatHex = false;
    boolean bSendHexData = false;
    boolean bContentFormatHex = false;
    int contentFontSize = 12;
    boolean bWriteEcho = true;
    int timesMessageHexFormatWriteData = 0;
    final int TEXT_MAX_LINE = 1000;
    final int UI_READ_BUFFER_SIZE = 10240;
    boolean uart_configured = false;
    String uartSettings = "";
    public int iavailable = 0;
    boolean WriteFileThread_start = false;
    int iFileSize = 0;
    int sendByteCount = 0;
    final int MAX_NUM_BYTES = NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
    boolean bReadTheadEnable = false;
    private OutputStream myOS = new AndroidSerialOutputStream(this);
    private boolean isWaitForResponse = false;
    private boolean isFlexConnected = false;
    public DeviceStatus lastDeviceStatus = DeviceStatus.DEV_NOT_CONFIG;
    int BF = 1000;
    byte[][] test = new byte[1000][];
    int iBF = 0;

    public enum DeviceStatus {
        DEV_NOT_CONNECT,
        DEV_NOT_CONFIG,
        DEV_CONFIG
    }

    public class HandlerThread extends Thread {
        private IFlexListener listener;

        public HandlerThread(IFlexListener iFlexListener) {
            this.listener = iFlexListener;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                J2xx j2xx = J2xx.this;
                if (true == j2xx.bContentFormatHex) {
                    j2xx.readData(10240, j2xx.readBuffer);
                } else if (j2xx.transferMode == 0 && j2xx.readData(10240, j2xx.readBuffer) == 0) {
                    J2xx j2xx2 = J2xx.this;
                    boolean z = j2xx2.WriteFileThread_start;
                    boolean z2 = j2xx2.isWaitForResponse;
                    J2xx j2xx3 = J2xx.this;
                    if (z2) {
                        Log.i("J2XX", "status == 0x00 ".concat(new String(j2xx3.readBuffer, 0, j2xx3.actualNumBytes)));
                        J2xx.this.isWaitForResponse = false;
                        if (J2xx.this.actualNumBytes > 0) {
                            int i = 0;
                            while (true) {
                                J2xx j2xx4 = J2xx.this;
                                if (i >= j2xx4.actualNumBytes) {
                                    break;
                                }
                                if (j2xx4.readBuffer[i] == 49) {
                                    j2xx4.isFlexConnected = true;
                                    FlexManager flexManager = FlexManager.getInstance();
                                    J2xx j2xx5 = J2xx.this;
                                    j2xx5.flex = flexManager.setAndroidFlex(j2xx5, j2xx5);
                                    J2xx j2xx6 = J2xx.this;
                                    j2xx6.addObserver((Observer) j2xx6.flex);
                                    J2xx.this.pcmmPlayer = new PcmmPlayer();
                                    if (this.listener != null) {
                                        Log.i("J2XX", "MSG_CONNECTED");
                                        this.listener.onConnected();
                                    }
                                } else {
                                    i++;
                                }
                            }
                        }
                    } else if (j2xx3.isFlexConnected) {
                        J2xx.this.setChanged();
                        J2xx j2xx7 = J2xx.this;
                        j2xx7.notifyObservers(Arrays.copyOfRange(j2xx7.readBuffer, 0, j2xx7.actualNumBytes));
                    }
                    J2xx.this.actualNumBytes = 0;
                }
            }
        }

        public void setListener(IFlexListener iFlexListener) {
            this.listener = iFlexListener;
        }
    }

    public class ReadThread extends Thread {
        final int USB_DATA_BUFFER = Utility.DEFAULT_STREAM_BUFFER_SIZE;
        IFlexListener mHandler;

        public ReadThread(IFlexListener iFlexListener) {
            this.mHandler = iFlexListener;
            setPriority(10);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            J2xx j2xx;
            J2xx j2xx2;
            byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
            J2xx.this.bReadTheadEnable = true;
            int i = 0;
            while (!J2xx.this.isExit) {
                while (!J2xx.this.bReadTheadEnable) {
                    try {
                        Thread.sleep(50L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                DeviceStatus deviceStatusCheckDevice = J2xx.this.checkDevice();
                J2xx j2xx3 = J2xx.this;
                if (deviceStatusCheckDevice != j2xx3.lastDeviceStatus && this.mHandler != null) {
                    j2xx3.lastDeviceStatus = deviceStatusCheckDevice;
                    if (!deviceStatusCheckDevice.equals(DeviceStatus.DEV_CONFIG)) {
                        Log.i("J2XX", "MSG_DISCONNECT - " + deviceStatusCheckDevice);
                        if (J2xx.this.listener != null) {
                            J2xx.this.listener.onDisconnect();
                        }
                    }
                }
                while (true) {
                    j2xx = J2xx.this;
                    if (j2xx.iTotalBytes <= 57343) {
                        break;
                    }
                    try {
                        Thread.sleep(50L);
                    } catch (InterruptedException e3) {
                        e3.printStackTrace();
                    }
                }
                int queueStatus = j2xx.ftDev.getQueueStatus();
                if (queueStatus > 0) {
                    if (queueStatus > 8192) {
                        queueStatus = 8192;
                    }
                    J2xx.this.ftDev.read(bArr, queueStatus);
                    J2xx.this.totalReceiveDataBytes += queueStatus;
                    int i2 = 0;
                    while (true) {
                        j2xx2 = J2xx.this;
                        if (i2 >= queueStatus) {
                            break;
                        }
                        j2xx2.readDataBuffer[i] = bArr[i2];
                        i = (i + 1) % NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
                        i2++;
                    }
                    int i3 = j2xx2.iReadIndex;
                    if (i >= i3) {
                        j2xx2.iTotalBytes = i - i3;
                    } else {
                        j2xx2.iTotalBytes = (NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST - i3) + i;
                    }
                }
            }
            DLog.e("J2XX", "read thread terminate...");
        }

        public void setListener(IFlexListener iFlexListener) {
            this.mHandler = iFlexListener;
            J2xx.this.bReadTheadEnable = true;
        }
    }

    public static J2xx getInstance() {
        if (instance == null) {
            instance = new J2xx();
        }
        return instance;
    }

    @Override // com.hecz.serialcommon.ISerialConnection
    public void addSerialEventObserver(Observer observer) {
    }

    @Override // com.hecz.serialcommon.flex.IFlexControl
    public void changePCMMState(boolean z) {
    }

    public DeviceStatus checkDevice() {
        FT_Device fT_Device = this.ftDev;
        return (fT_Device == null || !fT_Device.isOpen()) ? DeviceStatus.DEV_NOT_CONNECT : !this.uart_configured ? DeviceStatus.DEV_NOT_CONFIG : DeviceStatus.DEV_CONFIG;
    }

    @Override // com.hecz.serialcommon.ISerialConnection
    public void close() {
    }

    public void connectFunction() {
        FT_Device fT_Device;
        Log.i("J2XX", "connectFunction");
        if (this.portIndex + 1 > this.DevCount) {
            this.portIndex = 0;
        }
        if (this.currentPortIndex == this.portIndex && (fT_Device = this.ftDev) != null && true == fT_Device.isOpen()) {
            return;
        }
        if (true == this.bReadTheadEnable) {
            this.bReadTheadEnable = false;
            try {
                Thread.sleep(50L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        FT_Device fT_Device2 = this.ftDev;
        Context context = this.global_context;
        if (fT_Device2 == null) {
            this.ftDev = ftD2xx.openByIndex(context, this.portIndex);
        } else {
            this.ftDev = ftD2xx.openByIndex(context, this.portIndex);
        }
        this.uart_configured = false;
        FT_Device fT_Device3 = this.ftDev;
        if (fT_Device3 != null && true == fT_Device3.isOpen()) {
            this.currentPortIndex = this.portIndex;
            if (this.bReadTheadEnable) {
                return;
            }
            ReadThread readThread = this.readThread;
            if (readThread != null) {
                readThread.setListener(this.listener);
                return;
            }
            ReadThread readThread2 = new ReadThread(this.listener);
            this.readThread = readThread2;
            readThread2.start();
        }
    }

    public void createDeviceList() {
        int iCreateDeviceInfoList = ftD2xx.createDeviceInfoList(this.global_context);
        if (iCreateDeviceInfoList <= 0) {
            this.DevCount = -1;
            this.currentPortIndex = -1;
        } else if (this.DevCount != iCreateDeviceInfoList) {
            this.DevCount = iCreateDeviceInfoList;
        }
    }

    public void flexIsConnected() {
        readData(10240, this.readBuffer);
        Log.i("J2XX", "flexIsConnected");
        this.isFlexConnected = false;
        for (int i = 0; i < 4 && !this.isFlexConnected; i++) {
            sendData("L");
            try {
                Thread.sleep(20L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.isWaitForResponse = true;
            sendData("u1836");
            try {
                Thread.sleep(250L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    public IFlex getFlex() {
        return this.flex;
    }

    @Override // com.hecz.serialcommon.ISerialConnection
    public OutputStream getOs() {
        return this.myOS;
    }

    @Override // com.hecz.serialcommon.ISerialConnection
    public int getVersionInt() {
        return 2;
    }

    public void initPort(Context context, IFlexListener iFlexListener) {
        this.listener = iFlexListener;
        Log.i("J2XX", "INIT PORT");
        try {
            ftD2xx = D2xxManager.getInstance(context);
        } catch (D2xxManager.D2xxException unused) {
            Log.e("J2XX", "getInstance fail!!");
        }
        this.global_context = context;
        this.modemReceiveDataBytes = new int[]{0};
        this.modemDataBuffer = new byte[2048];
        this.zmDataBuffer = new byte[2048];
        this.writeBuffer = new byte[512];
        this.readBuffer = new byte[10240];
        this.readBufferToChar = new char[10240];
        this.readDataBuffer = new byte[NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST];
        this.actualNumBytes = 0;
        HandlerThread handlerThread = this.handlerThread;
        if (handlerThread == null) {
            HandlerThread handlerThread2 = new HandlerThread(iFlexListener);
            this.handlerThread = handlerThread2;
            handlerThread2.start();
        } else {
            handlerThread.setListener(iFlexListener);
        }
        this.baudRate = 57600;
        this.stopBit = (byte) 1;
        this.dataBit = (byte) 8;
        this.parity = (byte) 0;
        this.flowControl = (byte) 0;
        this.portIndex = 0;
    }

    public void pause() {
        if (this.isFlexConnected) {
            this.pcmmPlayer.pPause();
        }
    }

    public void prepareFlex() {
        int i;
        if (this.isFlexConnected) {
            this.pcmmPlayer.pPrepare();
            int i2 = 1000;
            while (true) {
                i = i2 - 1;
                if (i2 <= 0 || this.flex.isCommandQueueEmpty()) {
                    break;
                }
                try {
                    Thread.sleep(20L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i2 = i;
            }
            if (i <= 0) {
                Log.e("J2XX", "Command queue is not empty!");
            }
        }
    }

    public byte readData(int i, byte[] bArr) {
        int i2;
        if (i < 1 || (i2 = this.iTotalBytes) == 0) {
            this.actualNumBytes = 0;
            return (byte) 1;
        }
        if (i > i2) {
            i = i2;
        }
        this.iTotalBytes = i2 - i;
        this.actualNumBytes = i;
        for (int i3 = 0; i3 < i; i3++) {
            byte[] bArr2 = this.readDataBuffer;
            int i4 = this.iReadIndex;
            bArr[i3] = bArr2[i4];
            this.iReadIndex = (i4 + 1) % NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        return (byte) 0;
    }

    public void runOnce() {
        if (this.isFlexConnected) {
            this.pcmmPlayer.runOnce();
        }
    }

    public void sendData(int i, byte[] bArr) {
        FT_Device fT_Device = this.ftDev;
        if (fT_Device == null) {
            return;
        }
        if (!fT_Device.isOpen()) {
            DLog.e("J2XX", "SendData: device not open");
            return;
        }
        this.test[this.iBF] = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.test[this.iBF][i2] = bArr[i2];
        }
        this.allBytes += i;
        if (i > 0 && bArr != null) {
            int iWrite = this.ftDev.write(this.test[this.iBF], i);
            if (iWrite != i) {
                DLog.e("J2XX", "Error in send buf - sent = " + iWrite + ", buffer.length = " + i);
            }
            try {
                Thread.sleep(2L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int i3 = this.iBF + 1;
        this.iBF = i3;
        if (i3 >= this.BF) {
            this.iBF = 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setConfig(int i, byte b, byte b2, byte b3, byte b4) {
        byte b5;
        if (this.ftDev.isOpen()) {
            short s = 0;
            this.ftDev.setBitMode((byte) 0, (byte) 0);
            this.ftDev.setBaudRate(i);
            byte b6 = b != 7 ? (byte) 8 : (byte) 7;
            byte b7 = (b2 == 1 || b2 != 2) ? (byte) 0 : (byte) 2;
            if (b3 == 0) {
                b5 = 0;
            } else if (b3 == 1) {
                b5 = 1;
            } else if (b3 == 2) {
                b5 = 2;
            } else if (b3 != 3) {
                b5 = 4;
                if (b3 != 4) {
                }
            } else {
                b5 = 3;
            }
            this.ftDev.setDataCharacteristics(b6, b7, b5);
            if (b4 != 0) {
                if (b4 == 1) {
                    s = 256;
                } else if (b4 == 2) {
                    s = 512;
                } else if (b4 == 3) {
                    s = 1024;
                }
            }
            this.ftDev.setFlowControl(s, (byte) 17, (byte) 19);
            setUARTInfoString();
            this.uart_configured = true;
            Log.i("J2XX", "setConfig - ftDev = " + this.ftDev.getDeviceInfo().description);
            flexIsConnected();
        }
    }

    public void setPort(Context context, IFlexListener iFlexListener) {
        this.global_context = context;
        this.handlerThread.setListener(iFlexListener);
    }

    public void setSoundTimeRatio(double d) {
        this.flex.setSoundTimeRatio(d);
    }

    public void setUARTInfoString() {
        byte b = this.parity;
        String str = b != 0 ? b != 1 ? b != 2 ? b != 3 ? b != 4 ? new String("None") : new String("Space") : new String("Mark") : new String("Even") : new String("Odd") : new String("None");
        byte b2 = this.flowControl;
        this.uartSettings = "Port " + this.portIndex + "; UART Setting  -  Baudrate:" + this.baudRate + "  StopBit:" + ((int) this.stopBit) + "  DataBit:" + ((int) this.dataBit) + "  Parity:" + str + "  FlowControl:" + (b2 != 0 ? b2 != 1 ? b2 != 2 ? b2 != 3 ? new String("None") : new String("XOFF/XON") : new String("DTR/DSR") : new String("CTS/RTS") : new String("None"));
    }

    public void start() {
        new Thread() { // from class: com.hecz.android.J2xx.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                do {
                    J2xx.this.createDeviceList();
                    Log.i("J2XX", "Start DevCount = " + J2xx.this.DevCount);
                    J2xx j2xx = J2xx.this;
                    if (j2xx.DevCount > 0) {
                        j2xx.connectFunction();
                        J2xx.this.setUARTInfoString();
                        J2xx j2xx2 = J2xx.this;
                        j2xx2.setConfig(j2xx2.baudRate, j2xx2.dataBit, j2xx2.stopBit, j2xx2.parity, j2xx2.flowControl);
                    } else {
                        try {
                            Thread.sleep(500L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } while (J2xx.this.DevCount == 0);
            }
        }.start();
    }

    public void startFlex() {
        if (this.isFlexConnected) {
            this.pcmmPlayer.pStart();
        }
    }

    public void stopFlex() {
        if (this.isFlexConnected) {
            this.pcmmPlayer.pStop();
            FlexManager.getFlex().getFlashTab().resetFlashTab();
        }
    }

    public void sendData(String str) {
        if (str.length() == 0) {
            return;
        }
        Log.i("J2XX", "send:".concat(str));
        int length = str.length();
        int i = 0;
        while (true) {
            byte[] bArr = this.writeBuffer;
            if (i < length) {
                bArr[i] = (byte) str.charAt(i);
                i++;
            } else {
                sendData(length, bArr);
                return;
            }
        }
    }

    public void sendData(byte b) {
        DLog.e("J2XX", "send buf:" + Integer.toHexString(b));
        this.ftDev.write(new byte[]{b}, 1);
        try {
            Thread.sleep(5L);
        } catch (InterruptedException unused) {
        }
    }
}
