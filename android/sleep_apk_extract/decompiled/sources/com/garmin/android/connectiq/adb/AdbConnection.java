package com.garmin.android.connectiq.adb;

import android.content.Context;
import android.util.Log;
import com.garmin.android.connectiq.IQDevice;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Arrays;
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions;

/* JADX INFO: loaded from: classes3.dex */
public class AdbConnection {
    private static AdbConnection instance;
    private Context context;
    private ServerSocket server;
    private Socket client = null;
    private int connectionPort = 7381;
    private InputStream inputStream = null;
    private OutputStream outputStream = null;
    private Thread serverThread = null;
    private AdbConnectionListener connListener = null;
    private IQDevice device = new IQDevice(12345, "Simulator");

    public interface AdbConnectionListener {
        void onConnectionStatusChanged(IQDevice iQDevice, IQDevice.IQDeviceStatus iQDeviceStatus);
    }

    public class ServerThread implements Runnable {
        public ServerThread() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AdbConnection adbConnection;
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    try {
                        AdbConnection.this.server = new ServerSocket(AdbConnection.this.connectionPort);
                        AdbConnection.this.server.setSoTimeout(DisconnectedBufferOptions.DISCONNECTED_BUFFER_SIZE_DEFAULT);
                        Log.d("ConnectIQ-AdbConnection", "Waiting for simulator connection.");
                        while (!Thread.currentThread().isInterrupted()) {
                            try {
                                AdbConnection adbConnection2 = AdbConnection.this;
                                adbConnection2.client = adbConnection2.server.accept();
                                break;
                            } catch (SocketTimeoutException unused) {
                            }
                        }
                        AdbConnection.this.inputStream = new BufferedInputStream(AdbConnection.this.client.getInputStream());
                        AdbConnection adbConnection3 = AdbConnection.this;
                        adbConnection3.outputStream = adbConnection3.client.getOutputStream();
                        Log.d("ConnectIQ-AdbConnection", "Simulator connected");
                        if (AdbConnection.this.connListener != null) {
                            AdbConnection.this.connListener.onConnectionStatusChanged(AdbConnection.this.device, IQDevice.IQDeviceStatus.CONNECTED);
                        }
                        adbConnection = AdbConnection.this;
                    } catch (IOException e) {
                        Log.e("ConnectIQ-AdbConnection", "Error creating server socket", e);
                        try {
                            adbConnection = AdbConnection.this;
                        } catch (IOException unused2) {
                        }
                    }
                    adbConnection.server.close();
                    if (AdbConnection.this.client != null) {
                        byte[] bArr = new byte[16384];
                        while (true) {
                            if (Thread.currentThread().isInterrupted() || !AdbConnection.this.client.isConnected() || AdbConnection.this.client.isInputShutdown()) {
                                break;
                            }
                            try {
                                Log.d("ConnectIQ-AdbConnection", "Looking for input from simulator.");
                                int i = AdbConnection.this.inputStream.read(bArr, 0, 16384);
                                if (i == -1) {
                                    Log.d("ConnectIQ-AdbConnection", "End of input reached");
                                    break;
                                }
                                Log.d("ConnectIQ-AdbConnection", "Received " + i + " from simulator");
                                AdbDataHandler.handleMessage(AdbConnection.this.context, Arrays.copyOf(bArr, i));
                            } catch (IOException e2) {
                                Log.e("ConnectIQ-AdbConnection", "Error reading input stream", e2);
                            }
                        }
                        Log.d("ConnectIQ-AdbConnection", "Client connection shut down.");
                        if (AdbConnection.this.connListener != null) {
                            AdbConnection.this.connListener.onConnectionStatusChanged(AdbConnection.this.device, IQDevice.IQDeviceStatus.NOT_CONNECTED);
                        }
                        try {
                            AdbConnection.this.client.close();
                            AdbConnection.this.client = null;
                        } catch (IOException unused3) {
                        }
                    }
                } catch (Throwable th) {
                    try {
                        AdbConnection.this.server.close();
                    } catch (IOException unused4) {
                    }
                    throw th;
                }
            }
        }
    }

    private AdbConnection() {
    }

    public static AdbConnection getInstance() {
        if (instance == null) {
            instance = new AdbConnection();
        }
        return instance;
    }

    public void establishConnection(AdbConnectionListener adbConnectionListener) {
        this.connListener = adbConnectionListener;
        Thread thread = new Thread(new ServerThread());
        this.serverThread = thread;
        thread.start();
    }

    public boolean isActive() {
        Thread thread = this.serverThread;
        return thread != null && thread.isAlive();
    }

    public boolean isConnected() {
        Socket socket = this.client;
        return socket != null && socket.isConnected();
    }

    public boolean sendMessage(byte[] bArr) {
        Socket socket;
        if (this.outputStream != null && (socket = this.client) != null && socket.isConnected() && !this.client.isOutputShutdown()) {
            long length = (bArr.length / 600) * 1000;
            if (length > 0) {
                try {
                    Log.d("ConnectIQ-AdbConnection", "Simulating BLE, sleeping " + length + " milliseconds");
                    Thread.sleep(length);
                } catch (InterruptedException unused) {
                }
            }
            try {
                this.outputStream.write(bArr);
                this.outputStream.flush();
                Log.d("ConnectIQ-AdbConnection", "Wrote " + bArr.length + " bytes to output stream");
                return true;
            } catch (IOException e) {
                Log.e("ConnectIQ-AdbConnection", "Error sending message", e);
            }
        }
        return false;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
