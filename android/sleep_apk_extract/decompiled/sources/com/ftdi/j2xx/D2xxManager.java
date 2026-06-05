package com.ftdi.j2xx;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions;

/* JADX INFO: loaded from: classes3.dex */
public class D2xxManager {
    private static Context mContext;
    private static D2xxManager mInstance;
    private static PendingIntent mPendingIntent;
    private static IntentFilter mPermissionFilter;
    private static List mSupportedDevices = new ArrayList(Arrays.asList(new FtVidPid(1027, 24597), new FtVidPid(1027, 24596), new FtVidPid(1027, 24593), new FtVidPid(1027, 24592), new FtVidPid(1027, 24577), new FtVidPid(1027, 24582), new FtVidPid(1027, 24604), new FtVidPid(1027, 64193), new FtVidPid(1027, 64194), new FtVidPid(1027, 64195), new FtVidPid(1027, 64196), new FtVidPid(1027, 64197), new FtVidPid(1027, 64198), new FtVidPid(1027, 24594), new FtVidPid(2220, 4133), new FtVidPid(5590, 1), new FtVidPid(1027, 24599)));
    private static BroadcastReceiver mUsbDevicePermissions = new BroadcastReceiver() { // from class: com.ftdi.j2xx.D2xxManager.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("com.ftdi.j2xx".equals(intent.getAction())) {
                synchronized (this) {
                    try {
                        UsbDevice usbDevice = (UsbDevice) intent.getParcelableExtra(DeviceRequestsHelper.DEVICE_INFO_DEVICE);
                        if (!intent.getBooleanExtra("permission", false)) {
                            Log.d("D2xx::", "permission denied for device " + usbDevice);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    };
    private static UsbManager mUsbManager;
    private ArrayList mFtdiDevices;
    private BroadcastReceiver mUsbPlugEvents = new BroadcastReceiver() { // from class: com.ftdi.j2xx.D2xxManager.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (!"android.hardware.usb.action.USB_DEVICE_DETACHED".equals(action)) {
                if ("android.hardware.usb.action.USB_DEVICE_ATTACHED".equals(action)) {
                    D2xxManager.this.addUsbDevice((UsbDevice) intent.getParcelableExtra(DeviceRequestsHelper.DEVICE_INFO_DEVICE));
                    return;
                }
                return;
            }
            UsbDevice usbDevice = (UsbDevice) intent.getParcelableExtra(DeviceRequestsHelper.DEVICE_INFO_DEVICE);
            while (true) {
                FT_Device fT_DeviceFindDevice = D2xxManager.this.findDevice(usbDevice);
                if (fT_DeviceFindDevice == null) {
                    return;
                }
                fT_DeviceFindDevice.close();
                synchronized (D2xxManager.this.mFtdiDevices) {
                    D2xxManager.this.mFtdiDevices.remove(fT_DeviceFindDevice);
                }
            }
        }
    };

    public static class D2xxException extends IOException {
        private static final long serialVersionUID = 1;

        public D2xxException(String str) {
            super(str);
        }
    }

    public static class DriverParameters {
        private int mBufferSize = 16384;
        private int mMaxTransferSize = 16384;
        private int mNrBuffers = 16;
        private int mRxTimeout = DisconnectedBufferOptions.DISCONNECTED_BUFFER_SIZE_DEFAULT;

        public int getBufferNumber() {
            return this.mNrBuffers;
        }

        public int getMaxBufferSize() {
            return this.mBufferSize;
        }

        public int getMaxTransferSize() {
            return this.mMaxTransferSize;
        }

        public int getReadTimeout() {
            return this.mRxTimeout;
        }

        public boolean setBufferNumber(int i) {
            if (i < 2 || i > 16) {
                Log.e("D2xx::", "***nrBuffers Out of correct range***");
                return false;
            }
            this.mNrBuffers = i;
            return true;
        }

        public boolean setMaxBufferSize(int i) {
            if (i < 64 || i > 262144) {
                Log.e("D2xx::", "***bufferSize Out of correct range***");
                return false;
            }
            this.mBufferSize = i;
            return true;
        }

        public boolean setMaxTransferSize(int i) {
            if (i < 64 || i > 262144) {
                Log.e("D2xx::", "***maxTransferSize Out of correct range***");
                return false;
            }
            this.mMaxTransferSize = i;
            return true;
        }

        public boolean setReadTimeout(int i) {
            this.mRxTimeout = i;
            return true;
        }
    }

    public static class FtDeviceInfoListNode {
        public short bcdDevice;
        public int breakOnParam;
        public String description;
        public int flags;
        public byte iSerialNumber;
        public int id;
        public short lineStatus;
        public int location;
        public short modemStatus;
        public String serialNumber;
        public int type;
    }

    private D2xxManager(Context context) throws D2xxException {
        Log.v("D2xx::", "Start constructor");
        if (context == null) {
            throw new D2xxException("D2xx init failed: Can not find parentContext!");
        }
        updateContext(context);
        if (!findUsbManger()) {
            throw new D2xxException("D2xx init failed: Can not find UsbManager!");
        }
        this.mFtdiDevices = new ArrayList();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
        ContextCompat.registerReceiver(context, this.mUsbPlugEvents, intentFilter, 2);
        Log.v("D2xx::", "End constructor");
    }

    private void clearDevices() {
        synchronized (this.mFtdiDevices) {
            try {
                int size = this.mFtdiDevices.size();
                for (int i = 0; i < size; i++) {
                    this.mFtdiDevices.remove(0);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FT_Device findDevice(UsbDevice usbDevice) {
        FT_Device fT_Device;
        synchronized (this.mFtdiDevices) {
            try {
                int size = this.mFtdiDevices.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        fT_Device = null;
                        break;
                    }
                    fT_Device = (FT_Device) this.mFtdiDevices.get(i);
                    if (!fT_Device.getUsbDevice().equals(usbDevice)) {
                        i++;
                    }
                }
            } finally {
            }
        }
        return fT_Device;
    }

    private static boolean findUsbManger() {
        Context context;
        if (mUsbManager == null && (context = mContext) != null) {
            mUsbManager = (UsbManager) context.getApplicationContext().getSystemService("usb");
        }
        return mUsbManager != null;
    }

    public static synchronized D2xxManager getInstance(Context context) {
        try {
            if (mInstance == null) {
                mInstance = new D2xxManager(context);
            }
            if (context != null) {
                updateContext(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return mInstance;
    }

    private boolean isPermitted(UsbDevice usbDevice) {
        if (!mUsbManager.hasPermission(usbDevice)) {
            mUsbManager.requestPermission(usbDevice, mPendingIntent);
        }
        return mUsbManager.hasPermission(usbDevice);
    }

    private boolean tryOpen(Context context, FT_Device fT_Device, DriverParameters driverParameters) {
        if (fT_Device == null || context == null) {
            return false;
        }
        fT_Device.setContext(context);
        if (driverParameters != null) {
            fT_Device.setDriverParameters(driverParameters);
        }
        return fT_Device.openDevice(mUsbManager) && fT_Device.isOpen();
    }

    private static synchronized boolean updateContext(Context context) {
        if (context == null) {
            return false;
        }
        if (mContext != context) {
            mContext = context;
            mPendingIntent = PendingIntent.getBroadcast(context.getApplicationContext(), 0, new Intent("com.ftdi.j2xx"), 201326592);
            IntentFilter intentFilter = new IntentFilter("com.ftdi.j2xx");
            mPermissionFilter = intentFilter;
            ContextCompat.registerReceiver(mContext, mUsbDevicePermissions, intentFilter, 2);
        }
        return true;
    }

    public int addUsbDevice(UsbDevice usbDevice) {
        if (!isFtDevice(usbDevice)) {
            return 0;
        }
        int interfaceCount = usbDevice.getInterfaceCount();
        int i = 0;
        for (int i2 = 0; i2 < interfaceCount; i2++) {
            if (isPermitted(usbDevice)) {
                synchronized (this.mFtdiDevices) {
                    try {
                        FT_Device fT_DeviceFindDevice = findDevice(usbDevice);
                        if (fT_DeviceFindDevice == null) {
                            fT_DeviceFindDevice = new FT_Device(mContext, mUsbManager, usbDevice, usbDevice.getInterface(i2));
                        } else {
                            fT_DeviceFindDevice.setContext(mContext);
                            this.mFtdiDevices.remove(fT_DeviceFindDevice);
                        }
                        this.mFtdiDevices.add(fT_DeviceFindDevice);
                        i++;
                    } finally {
                    }
                }
            }
        }
        return i;
    }

    public int createDeviceInfoList(Context context) {
        int size;
        ArrayList arrayList = new ArrayList();
        if (context == null) {
            return 0;
        }
        updateContext(context);
        for (UsbDevice usbDevice : mUsbManager.getDeviceList().values()) {
            if (isFtDevice(usbDevice)) {
                int interfaceCount = usbDevice.getInterfaceCount();
                for (int i = 0; i < interfaceCount; i++) {
                    if (isPermitted(usbDevice)) {
                        synchronized (this.mFtdiDevices) {
                            try {
                                FT_Device fT_DeviceFindDevice = findDevice(usbDevice);
                                if (fT_DeviceFindDevice == null) {
                                    fT_DeviceFindDevice = new FT_Device(context, mUsbManager, usbDevice, usbDevice.getInterface(i));
                                } else {
                                    this.mFtdiDevices.remove(fT_DeviceFindDevice);
                                    fT_DeviceFindDevice.setContext(context);
                                }
                                arrayList.add(fT_DeviceFindDevice);
                            } finally {
                            }
                        }
                    }
                }
            }
        }
        synchronized (this.mFtdiDevices) {
            clearDevices();
            this.mFtdiDevices = arrayList;
            size = arrayList.size();
        }
        return size;
    }

    public boolean isFtDevice(UsbDevice usbDevice) {
        if (mContext == null) {
            return false;
        }
        FtVidPid ftVidPid = new FtVidPid(usbDevice.getVendorId(), usbDevice.getProductId());
        boolean zContains = mSupportedDevices.contains(ftVidPid);
        Log.v("D2xx::", ftVidPid.toString());
        return zContains;
    }

    public synchronized FT_Device openByIndex(Context context, int i, DriverParameters driverParameters) {
        if (i < 0) {
            return null;
        }
        if (context == null) {
            return null;
        }
        updateContext(context);
        FT_Device fT_Device = (FT_Device) this.mFtdiDevices.get(i);
        return tryOpen(context, fT_Device, driverParameters) ? fT_Device : null;
    }

    public synchronized FT_Device openByIndex(Context context, int i) {
        return openByIndex(context, i, null);
    }
}
