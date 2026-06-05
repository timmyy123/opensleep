package com.ftdi.j2xx;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import android.hardware.usb.UsbRequest;
import android.util.Log;
import com.ftdi.j2xx.D2xxManager;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: classes3.dex */
public class FT_Device {
    private BulkInWorker mBulkIn;
    UsbEndpoint mBulkInEndpoint;
    private Thread mBulkInThread;
    UsbEndpoint mBulkOutEndpoint;
    Context mContext;
    D2xxManager.FtDeviceInfoListNode mDeviceInfoNode;
    private D2xxManager.DriverParameters mDriverParams;
    private FT_EE_Ctrl mEEPROM;
    long mEventMask;
    TFtEventNotify mEventNotification;
    private int mInterfaceID;
    Boolean mIsOpen;
    private byte mLatencyTimer;
    private int mMaxPacketSize;
    private ProcessInCtrl mProcessInCtrl;
    private Thread mProcessRequestThread;
    TFtSpecialChars mTftSpecialChars;
    private UsbDeviceConnection mUsbConnection;
    UsbDevice mUsbDevice;
    UsbInterface mUsbInterface;
    private UsbRequest mUsbRequest;

    public FT_Device(Context context, UsbManager usbManager, UsbDevice usbDevice, UsbInterface usbInterface) {
        this.mInterfaceID = 0;
        byte[] bArr = new byte[PHIpAddressSearchManager.END_IP_SCAN];
        this.mContext = context;
        this.mDriverParams = new D2xxManager.DriverParameters();
        try {
            this.mUsbDevice = usbDevice;
            this.mUsbInterface = usbInterface;
            this.mBulkOutEndpoint = null;
            this.mBulkInEndpoint = null;
            this.mMaxPacketSize = 0;
            this.mTftSpecialChars = new TFtSpecialChars();
            this.mEventNotification = new TFtEventNotify();
            this.mDeviceInfoNode = new D2xxManager.FtDeviceInfoListNode();
            this.mUsbRequest = new UsbRequest();
            setConnection(usbManager.openDevice(this.mUsbDevice));
            if (getConnection() == null) {
                Log.e("FTDI_Device::", "Failed to open the device!");
                throw new D2xxManager.D2xxException("Failed to open the device!");
            }
            getConnection().claimInterface(this.mUsbInterface, false);
            byte[] rawDescriptors = getConnection().getRawDescriptors();
            int deviceId = this.mUsbDevice.getDeviceId();
            int id = this.mUsbInterface.getId() + 1;
            this.mInterfaceID = id;
            this.mDeviceInfoNode.location = (deviceId << 4) | (id & 15);
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(2);
            byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
            byteBufferAllocate.put(rawDescriptors[12]);
            byteBufferAllocate.put(rawDescriptors[13]);
            this.mDeviceInfoNode.bcdDevice = byteBufferAllocate.getShort(0);
            D2xxManager.FtDeviceInfoListNode ftDeviceInfoListNode = this.mDeviceInfoNode;
            ftDeviceInfoListNode.iSerialNumber = rawDescriptors[16];
            ftDeviceInfoListNode.serialNumber = getConnection().getSerial();
            this.mDeviceInfoNode.id = (this.mUsbDevice.getVendorId() << 16) | this.mUsbDevice.getProductId();
            this.mDeviceInfoNode.breakOnParam = 8;
            getConnection().controlTransfer(-128, 6, rawDescriptors[15] | 768, 0, bArr, PHIpAddressSearchManager.END_IP_SCAN, 0);
            this.mDeviceInfoNode.description = stringFromUtf16le(bArr);
            D2xxManager.FtDeviceInfoListNode ftDeviceInfoListNode2 = this.mDeviceInfoNode;
            switch (ftDeviceInfoListNode2.bcdDevice & 65280) {
                case 512:
                    if (ftDeviceInfoListNode2.iSerialNumber == 0) {
                        this.mEEPROM = new FT_EE_232B_Ctrl(this);
                        this.mDeviceInfoNode.type = 0;
                    } else {
                        ftDeviceInfoListNode2.type = 1;
                        this.mEEPROM = new FT_EE_232A_Ctrl(this);
                    }
                    break;
                case 1024:
                    this.mEEPROM = new FT_EE_232B_Ctrl(this);
                    this.mDeviceInfoNode.type = 0;
                    break;
                case 1280:
                    this.mEEPROM = new FT_EE_2232_Ctrl(this);
                    this.mDeviceInfoNode.type = 4;
                    dualQuadChannelDevice();
                    break;
                case 1536:
                    FT_EE_Ctrl fT_EE_Ctrl = new FT_EE_Ctrl(this);
                    this.mEEPROM = fT_EE_Ctrl;
                    short word = (short) (fT_EE_Ctrl.readWord((short) 0) & 1);
                    this.mEEPROM = null;
                    D2xxManager.FtDeviceInfoListNode ftDeviceInfoListNode3 = this.mDeviceInfoNode;
                    if (word == 0) {
                        ftDeviceInfoListNode3.type = 5;
                        this.mEEPROM = new FT_EE_232R_Ctrl(this);
                    } else {
                        ftDeviceInfoListNode3.type = 5;
                        this.mEEPROM = new FT_EE_245R_Ctrl(this);
                    }
                    break;
                case 1792:
                    ftDeviceInfoListNode2.type = 6;
                    ftDeviceInfoListNode2.flags = 2;
                    dualQuadChannelDevice();
                    this.mEEPROM = new FT_EE_2232H_Ctrl(this);
                    break;
                case 2048:
                    ftDeviceInfoListNode2.type = 7;
                    ftDeviceInfoListNode2.flags = 2;
                    dualQuadChannelDevice();
                    this.mEEPROM = new FT_EE_4232H_Ctrl(this);
                    break;
                case 2304:
                    ftDeviceInfoListNode2.type = 8;
                    ftDeviceInfoListNode2.flags = 2;
                    this.mEEPROM = new FT_EE_232H_Ctrl(this);
                    break;
                case 4096:
                    ftDeviceInfoListNode2.type = 9;
                    this.mEEPROM = new FT_EE_X_Ctrl(this);
                    break;
                case 5888:
                    ftDeviceInfoListNode2.type = 12;
                    ftDeviceInfoListNode2.flags = 2;
                    break;
                case 6144:
                    ftDeviceInfoListNode2.type = 10;
                    if (this.mInterfaceID == 1) {
                        ftDeviceInfoListNode2.flags = 2;
                    } else {
                        ftDeviceInfoListNode2.flags = 0;
                    }
                    break;
                case 6400:
                    ftDeviceInfoListNode2.type = 11;
                    int i = this.mInterfaceID;
                    if (i == 4) {
                        int maxPacketSize = this.mUsbDevice.getInterface(i - 1).getEndpoint(0).getMaxPacketSize();
                        Log.e("dev", "mInterfaceID : " + this.mInterfaceID + "   iMaxPacketSize : " + maxPacketSize);
                        D2xxManager.FtDeviceInfoListNode ftDeviceInfoListNode4 = this.mDeviceInfoNode;
                        if (maxPacketSize == 8) {
                            ftDeviceInfoListNode4.flags = 0;
                        } else {
                            ftDeviceInfoListNode4.flags = 2;
                        }
                    } else {
                        ftDeviceInfoListNode2.flags = 2;
                    }
                    break;
                default:
                    ftDeviceInfoListNode2.type = 3;
                    this.mEEPROM = new FT_EE_Ctrl(this);
                    break;
            }
            D2xxManager.FtDeviceInfoListNode ftDeviceInfoListNode5 = this.mDeviceInfoNode;
            int i2 = ftDeviceInfoListNode5.bcdDevice & 65280;
            if ((i2 == 5888 || i2 == 6144 || i2 == 6400) && ftDeviceInfoListNode5.serialNumber == null) {
                byte[] bArr2 = new byte[16];
                getConnection().controlTransfer(-64, 144, 0, 27, bArr2, 16, 0);
                String str = "";
                for (int i3 = 0; i3 < 8; i3++) {
                    str = str + ((char) bArr2[i3 * 2]);
                }
                this.mDeviceInfoNode.serialNumber = new String(str);
            }
            D2xxManager.FtDeviceInfoListNode ftDeviceInfoListNode6 = this.mDeviceInfoNode;
            int i4 = ftDeviceInfoListNode6.bcdDevice & 65280;
            if (i4 == 6144 || i4 == 6400) {
                int i5 = this.mInterfaceID;
                if (i5 == 1) {
                    ftDeviceInfoListNode6.description = String.valueOf(ftDeviceInfoListNode6.description) + " A";
                    D2xxManager.FtDeviceInfoListNode ftDeviceInfoListNode7 = this.mDeviceInfoNode;
                    ftDeviceInfoListNode7.serialNumber = String.valueOf(ftDeviceInfoListNode7.serialNumber) + "A";
                } else if (i5 == 2) {
                    ftDeviceInfoListNode6.description = String.valueOf(ftDeviceInfoListNode6.description) + " B";
                    D2xxManager.FtDeviceInfoListNode ftDeviceInfoListNode8 = this.mDeviceInfoNode;
                    ftDeviceInfoListNode8.serialNumber = String.valueOf(ftDeviceInfoListNode8.serialNumber) + "B";
                } else if (i5 == 3) {
                    ftDeviceInfoListNode6.description = String.valueOf(ftDeviceInfoListNode6.description) + " C";
                    D2xxManager.FtDeviceInfoListNode ftDeviceInfoListNode9 = this.mDeviceInfoNode;
                    ftDeviceInfoListNode9.serialNumber = String.valueOf(ftDeviceInfoListNode9.serialNumber) + "C";
                } else if (i5 == 4) {
                    ftDeviceInfoListNode6.description = String.valueOf(ftDeviceInfoListNode6.description) + " D";
                    D2xxManager.FtDeviceInfoListNode ftDeviceInfoListNode10 = this.mDeviceInfoNode;
                    ftDeviceInfoListNode10.serialNumber = String.valueOf(ftDeviceInfoListNode10.serialNumber) + "D";
                }
            }
            getConnection().releaseInterface(this.mUsbInterface);
            getConnection().close();
            setConnection(null);
            setClosed();
        } catch (Exception e) {
            if (e.getMessage() != null) {
                Log.e("FTDI_Device::", e.getMessage());
            }
        }
    }

    private void dualQuadChannelDevice() {
        int i = this.mInterfaceID;
        if (i == 1) {
            D2xxManager.FtDeviceInfoListNode ftDeviceInfoListNode = this.mDeviceInfoNode;
            ftDeviceInfoListNode.serialNumber = String.valueOf(ftDeviceInfoListNode.serialNumber).concat("A");
            D2xxManager.FtDeviceInfoListNode ftDeviceInfoListNode2 = this.mDeviceInfoNode;
            ftDeviceInfoListNode2.description = String.valueOf(ftDeviceInfoListNode2.description).concat(" A");
            return;
        }
        if (i == 2) {
            D2xxManager.FtDeviceInfoListNode ftDeviceInfoListNode3 = this.mDeviceInfoNode;
            ftDeviceInfoListNode3.serialNumber = String.valueOf(ftDeviceInfoListNode3.serialNumber).concat("B");
            D2xxManager.FtDeviceInfoListNode ftDeviceInfoListNode4 = this.mDeviceInfoNode;
            ftDeviceInfoListNode4.description = String.valueOf(ftDeviceInfoListNode4.description).concat(" B");
            return;
        }
        if (i == 3) {
            D2xxManager.FtDeviceInfoListNode ftDeviceInfoListNode5 = this.mDeviceInfoNode;
            ftDeviceInfoListNode5.serialNumber = String.valueOf(ftDeviceInfoListNode5.serialNumber).concat("C");
            D2xxManager.FtDeviceInfoListNode ftDeviceInfoListNode6 = this.mDeviceInfoNode;
            ftDeviceInfoListNode6.description = String.valueOf(ftDeviceInfoListNode6.description).concat(" C");
            return;
        }
        if (i == 4) {
            D2xxManager.FtDeviceInfoListNode ftDeviceInfoListNode7 = this.mDeviceInfoNode;
            ftDeviceInfoListNode7.serialNumber = String.valueOf(ftDeviceInfoListNode7.serialNumber).concat("D");
            D2xxManager.FtDeviceInfoListNode ftDeviceInfoListNode8 = this.mDeviceInfoNode;
            ftDeviceInfoListNode8.description = String.valueOf(ftDeviceInfoListNode8.description).concat(" D");
        }
    }

    private boolean findDeviceEndpoints() {
        for (int i = 0; i < this.mUsbInterface.getEndpointCount(); i++) {
            Log.i("FTDI_Device::", "EP: ".concat(String.format("0x%02X", Integer.valueOf(this.mUsbInterface.getEndpoint(i).getAddress()))));
            if (this.mUsbInterface.getEndpoint(i).getType() == 2) {
                int direction = this.mUsbInterface.getEndpoint(i).getDirection();
                UsbInterface usbInterface = this.mUsbInterface;
                if (direction == 128) {
                    UsbEndpoint endpoint = usbInterface.getEndpoint(i);
                    this.mBulkInEndpoint = endpoint;
                    this.mMaxPacketSize = endpoint.getMaxPacketSize();
                } else {
                    this.mBulkOutEndpoint = usbInterface.getEndpoint(i);
                }
            } else {
                Log.i("FTDI_Device::", "Not Bulk Endpoint");
            }
        }
        return (this.mBulkOutEndpoint == null || this.mBulkInEndpoint == null) ? false : true;
    }

    private final boolean isBmDevice() {
        return isFt232b() || isFt2232() || isFt232r() || isFt2232h() || isFt4232h() || isFt232h() || isFt232ex();
    }

    private final boolean isFt2232() {
        return (this.mDeviceInfoNode.bcdDevice & 65280) == 1280;
    }

    private final boolean isFt2232h() {
        return (this.mDeviceInfoNode.bcdDevice & 65280) == 1792;
    }

    private final boolean isFt232b() {
        D2xxManager.FtDeviceInfoListNode ftDeviceInfoListNode = this.mDeviceInfoNode;
        short s = ftDeviceInfoListNode.bcdDevice;
        if ((s & 65280) != 1024) {
            return (s & 65280) == 512 && ftDeviceInfoListNode.iSerialNumber == 0;
        }
        return true;
    }

    private final boolean isFt232ex() {
        return (this.mDeviceInfoNode.bcdDevice & 65280) == 4096;
    }

    private final boolean isFt232h() {
        return (this.mDeviceInfoNode.bcdDevice & 65280) == 2304;
    }

    private final boolean isFt232r() {
        return (this.mDeviceInfoNode.bcdDevice & 65280) == 1536;
    }

    private final boolean isHiSpeed() {
        return isFt232h() || isFt2232h() || isFt4232h();
    }

    private boolean purgeRxTx(boolean z, boolean z2) {
        if (isOpen()) {
            if (z) {
                int iControlTransfer = 0;
                for (int i = 0; i < 6; i++) {
                    iControlTransfer = getConnection().controlTransfer(64, 0, 1, this.mInterfaceID, null, 0, 0);
                }
                if (iControlTransfer <= 0) {
                    this.mProcessInCtrl.purgeINData();
                    if (!z2 && getConnection().controlTransfer(64, 0, 2, this.mInterfaceID, null, 0, 0) == 0) {
                        return true;
                    }
                }
            } else if (!z2) {
            }
        }
        return false;
    }

    private synchronized void setClosed() {
        this.mIsOpen = Boolean.FALSE;
        this.mDeviceInfoNode.flags &= 2;
    }

    private synchronized void setOpen() {
        this.mIsOpen = Boolean.TRUE;
        this.mDeviceInfoNode.flags |= 1;
    }

    private final String stringFromUtf16le(byte[] bArr) {
        return new String(bArr, 2, bArr[0] - 2, "UTF-16LE");
    }

    public synchronized void close() {
        try {
            Thread thread = this.mProcessRequestThread;
            if (thread != null) {
                thread.interrupt();
            }
            Thread thread2 = this.mBulkInThread;
            if (thread2 != null) {
                thread2.interrupt();
            }
            UsbDeviceConnection usbDeviceConnection = this.mUsbConnection;
            if (usbDeviceConnection != null) {
                usbDeviceConnection.releaseInterface(this.mUsbInterface);
                this.mUsbConnection.close();
                this.mUsbConnection = null;
            }
            ProcessInCtrl processInCtrl = this.mProcessInCtrl;
            if (processInCtrl != null) {
                processInCtrl.close();
            }
            this.mProcessRequestThread = null;
            this.mBulkInThread = null;
            this.mBulkIn = null;
            this.mProcessInCtrl = null;
            setClosed();
        } catch (Throwable th) {
            throw th;
        }
    }

    public UsbDeviceConnection getConnection() {
        return this.mUsbConnection;
    }

    public D2xxManager.FtDeviceInfoListNode getDeviceInfo() {
        return this.mDeviceInfoNode;
    }

    public D2xxManager.DriverParameters getDriverParameters() {
        return this.mDriverParams;
    }

    public byte getLatencyTimer() {
        byte[] bArr = new byte[1];
        if (!isOpen()) {
            return (byte) -1;
        }
        if (getConnection().controlTransfer(-64, 10, 0, this.mInterfaceID, bArr, 1, 0) == 1) {
            return bArr[0];
        }
        return (byte) 0;
    }

    public int getMaxPacketSize() {
        return this.mMaxPacketSize;
    }

    public int getQueueStatus() {
        if (!isOpen()) {
            return -1;
        }
        ProcessInCtrl processInCtrl = this.mProcessInCtrl;
        if (processInCtrl == null) {
            return -2;
        }
        return processInCtrl.getBytesAvailable();
    }

    public UsbDevice getUsbDevice() {
        return this.mUsbDevice;
    }

    public final boolean isFt4232h() {
        return (this.mDeviceInfoNode.bcdDevice & 65280) == 2048;
    }

    public final boolean isMultiIfDevice() {
        return isFt2232() || isFt2232h() || isFt4232h();
    }

    public synchronized boolean isOpen() {
        return this.mIsOpen.booleanValue();
    }

    public synchronized boolean openDevice(UsbManager usbManager) {
        if (isOpen()) {
            return false;
        }
        if (usbManager == null) {
            Log.e("FTDI_Device::", "UsbManager cannot be null.");
            return false;
        }
        if (getConnection() != null) {
            Log.e("FTDI_Device::", "There should not have an UsbConnection.");
            return false;
        }
        setConnection(usbManager.openDevice(this.mUsbDevice));
        if (getConnection() == null) {
            Log.e("FTDI_Device::", "UsbConnection cannot be null.");
            return false;
        }
        if (!getConnection().claimInterface(this.mUsbInterface, true)) {
            Log.e("FTDI_Device::", "ClaimInteface returned false.");
            return false;
        }
        Log.d("FTDI_Device::", "open SUCCESS");
        if (!findDeviceEndpoints()) {
            Log.e("FTDI_Device::", "Failed to find endpoints.");
            return false;
        }
        this.mUsbRequest.initialize(this.mUsbConnection, this.mBulkOutEndpoint);
        Log.d("D2XX::", "**********************Device Opened**********************");
        ProcessInCtrl processInCtrl = new ProcessInCtrl(this);
        this.mProcessInCtrl = processInCtrl;
        this.mBulkIn = new BulkInWorker(this, processInCtrl, getConnection(), this.mBulkInEndpoint);
        Thread thread = new Thread(this.mBulkIn);
        this.mBulkInThread = thread;
        thread.setName("bulkInThread");
        Thread thread2 = new Thread(new ProcessRequestWorker(this.mProcessInCtrl));
        this.mProcessRequestThread = thread2;
        thread2.setName("processRequestThread");
        purgeRxTx(true, true);
        this.mBulkInThread.start();
        this.mProcessRequestThread.start();
        setOpen();
        return true;
    }

    public int read(byte[] bArr, int i, long j) {
        if (!isOpen()) {
            return -1;
        }
        if (i <= 0) {
            return -2;
        }
        ProcessInCtrl processInCtrl = this.mProcessInCtrl;
        if (processInCtrl == null) {
            return -3;
        }
        return processInCtrl.readBulkInData(bArr, i, j);
    }

    public boolean setBaudRate(int i) {
        byte bFT_GetDivisorHi;
        int[] iArr = new int[2];
        if (isOpen()) {
            switch (i) {
                case 300:
                    iArr[0] = 10000;
                    bFT_GetDivisorHi = 1;
                    break;
                case 600:
                    iArr[0] = 5000;
                    bFT_GetDivisorHi = 1;
                    break;
                case 1200:
                    iArr[0] = 2500;
                    bFT_GetDivisorHi = 1;
                    break;
                case 2400:
                    iArr[0] = 1250;
                    bFT_GetDivisorHi = 1;
                    break;
                case 4800:
                    iArr[0] = 625;
                    bFT_GetDivisorHi = 1;
                    break;
                case 9600:
                    iArr[0] = 16696;
                    bFT_GetDivisorHi = 1;
                    break;
                case 19200:
                    iArr[0] = 32924;
                    bFT_GetDivisorHi = 1;
                    break;
                case 38400:
                    iArr[0] = 49230;
                    bFT_GetDivisorHi = 1;
                    break;
                case 57600:
                    iArr[0] = 52;
                    bFT_GetDivisorHi = 1;
                    break;
                case 115200:
                    iArr[0] = 26;
                    bFT_GetDivisorHi = 1;
                    break;
                case 230400:
                    iArr[0] = 13;
                    bFT_GetDivisorHi = 1;
                    break;
                case 460800:
                    iArr[0] = 16390;
                    bFT_GetDivisorHi = 1;
                    break;
                case 921600:
                    iArr[0] = 32771;
                    bFT_GetDivisorHi = 1;
                    break;
                default:
                    bFT_GetDivisorHi = (isHiSpeed() && i >= 1200) ? FT_BaudRate.FT_GetDivisorHi(i, iArr) : FT_BaudRate.FT_GetDivisor(i, iArr, isBmDevice());
                    break;
            }
            if (isMultiIfDevice() || isFt232h() || isFt232ex()) {
                int i2 = iArr[1] << 8;
                iArr[1] = i2;
                int i3 = i2 & 65280;
                iArr[1] = i3;
                iArr[1] = i3 | this.mInterfaceID;
            }
            if (bFT_GetDivisorHi == 1 && getConnection().controlTransfer(64, 3, iArr[0], iArr[1], null, 0, 0) == 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean setBitMode(byte b, byte b2) {
        int i = this.mDeviceInfoNode.type;
        if (isOpen() && i != 1) {
            if (i != 0 || b2 == 0) {
                if (i != 4 || b2 == 0) {
                    if (i != 5 || b2 == 0) {
                        if (i != 6 || b2 == 0) {
                            if (i != 7 || b2 == 0) {
                                if (i != 8 || b2 == 0 || b2 <= 64) {
                                    if (getConnection().controlTransfer(64, 11, (b2 << 8) | (b & 255), this.mInterfaceID, null, 0, 0) == 0) {
                                        return true;
                                    }
                                }
                            } else if ((b2 & 7) != 0) {
                                if (!((b2 == 2) & (this.mUsbInterface.getId() != 0) & (this.mUsbInterface.getId() != 1))) {
                                }
                            }
                        } else if ((b2 & 95) != 0) {
                            if (!(((b2 & 72) > 0) & (this.mUsbInterface.getId() != 0))) {
                            }
                        }
                    } else if ((b2 & 37) != 0) {
                    }
                } else if ((b2 & 31) != 0) {
                    if (!((b2 == 2) & (this.mUsbInterface.getId() != 0))) {
                    }
                }
            } else if ((b2 & 1) != 0) {
            }
        }
        return false;
    }

    public void setConnection(UsbDeviceConnection usbDeviceConnection) {
        this.mUsbConnection = usbDeviceConnection;
    }

    public synchronized boolean setContext(Context context) {
        boolean z;
        if (context != null) {
            this.mContext = context;
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public boolean setDataCharacteristics(byte b, byte b2, byte b3) {
        if (!isOpen()) {
            return false;
        }
        short s = (short) (((short) (b | (b3 << 8))) | (b2 << MqttWireMessage.MESSAGE_TYPE_UNSUBACK));
        this.mDeviceInfoNode.breakOnParam = s;
        return getConnection().controlTransfer(64, 4, s, this.mInterfaceID, null, 0, 0) == 0;
    }

    public void setDriverParameters(D2xxManager.DriverParameters driverParameters) {
        this.mDriverParams.setMaxBufferSize(driverParameters.getMaxBufferSize());
        this.mDriverParams.setMaxTransferSize(driverParameters.getMaxTransferSize());
        this.mDriverParams.setBufferNumber(driverParameters.getBufferNumber());
        this.mDriverParams.setReadTimeout(driverParameters.getReadTimeout());
    }

    public boolean setDtr() {
        return isOpen() && getConnection().controlTransfer(64, 1, 257, this.mInterfaceID, null, 0, 0) == 0;
    }

    public boolean setFlowControl(short s, byte b, byte b2) {
        short s2;
        if (isOpen()) {
            if (s == 1024) {
                s2 = (short) ((b & 255) | ((short) (b2 << 8)));
            } else {
                s2 = 0;
            }
            if (getConnection().controlTransfer(64, 2, s2, this.mInterfaceID | s, null, 0, 0) == 0) {
                if (s == 256) {
                    return setRts();
                }
                if (s == 512) {
                    return setDtr();
                }
                return true;
            }
        }
        return false;
    }

    public boolean setLatencyTimer(byte b) {
        int i = b & 255;
        if (!isOpen() || getConnection().controlTransfer(64, 9, i, this.mInterfaceID, null, 0, 0) != 0) {
            return false;
        }
        this.mLatencyTimer = b;
        return true;
    }

    public boolean setRts() {
        return isOpen() && getConnection().controlTransfer(64, 1, 514, this.mInterfaceID, null, 0, 0) == 0;
    }

    public int write(byte[] bArr, int i, boolean z) {
        UsbRequest usbRequestRequestWait;
        if (!isOpen() || i < 0) {
            return -1;
        }
        UsbRequest usbRequest = this.mUsbRequest;
        if (z) {
            usbRequest.setClientData(this);
        }
        if (i != 0 ? !usbRequest.queue(ByteBuffer.wrap(bArr), i) : !usbRequest.queue(ByteBuffer.wrap(new byte[1]), i)) {
            i = -1;
        }
        if (z) {
            do {
                usbRequestRequestWait = this.mUsbConnection.requestWait();
                if (usbRequestRequestWait == null) {
                    Log.e("FTDI_Device::", "UsbConnection.requestWait() == null");
                    return -99;
                }
            } while (usbRequestRequestWait.getClientData() != this);
        }
        return i;
    }

    public int read(byte[] bArr, int i) {
        return read(bArr, i, this.mDriverParams.getReadTimeout());
    }

    public int write(byte[] bArr, int i) {
        return write(bArr, i, true);
    }
}
