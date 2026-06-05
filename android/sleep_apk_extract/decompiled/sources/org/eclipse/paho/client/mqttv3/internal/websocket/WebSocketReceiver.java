package org.eclipse.paho.client.mqttv3.internal.websocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class WebSocketReceiver implements Runnable {
    private static final String CLASS_NAME;
    static /* synthetic */ Class class$0;
    private static final Logger log;
    private InputStream input;
    private PipedOutputStream pipedOutputStream;
    private volatile boolean receiving;
    private boolean running = false;
    private boolean stopping = false;
    private Object lifecycle = new Object();
    private Thread receiverThread = null;

    static {
        Class<WebSocketReceiver> cls = class$0;
        if (cls == null) {
            cls = WebSocketReceiver.class;
            class$0 = cls;
        }
        String name = cls.getName();
        CLASS_NAME = name;
        log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, name);
    }

    public WebSocketReceiver(InputStream inputStream, PipedInputStream pipedInputStream) throws IOException {
        this.input = inputStream;
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        this.pipedOutputStream = pipedOutputStream;
        pipedInputStream.connect(pipedOutputStream);
    }

    private void closeOutputStream() {
        try {
            this.pipedOutputStream.close();
        } catch (IOException unused) {
        }
    }

    public boolean isReceiving() {
        return this.receiving;
    }

    public boolean isRunning() {
        return this.running;
    }

    @Override // java.lang.Runnable
    public void run() {
        WebSocketFrame webSocketFrame;
        PipedOutputStream pipedOutputStream;
        while (this.running && this.input != null) {
            try {
                log.fine(CLASS_NAME, "run", "852");
                this.receiving = this.input.available() > 0;
                webSocketFrame = new WebSocketFrame(this.input);
            } catch (IOException unused) {
                stop();
            }
            if (!webSocketFrame.isCloseFlag()) {
                int i = 0;
                while (true) {
                    int length = webSocketFrame.getPayload().length;
                    pipedOutputStream = this.pipedOutputStream;
                    if (i >= length) {
                        break;
                    }
                    pipedOutputStream.write(webSocketFrame.getPayload()[i]);
                    i++;
                }
                pipedOutputStream.flush();
            } else if (!this.stopping) {
                throw new IOException("Server sent a WebSocket Frame with the Stop OpCode");
            }
            this.receiving = false;
        }
    }

    public void start(String str) {
        log.fine(CLASS_NAME, "start", "855");
        synchronized (this.lifecycle) {
            try {
                if (!this.running) {
                    this.running = true;
                    Thread thread = new Thread(this, str);
                    this.receiverThread = thread;
                    thread.start();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void stop() {
        this.stopping = true;
        synchronized (this.lifecycle) {
            log.fine(CLASS_NAME, "stop", "850");
            if (this.running) {
                this.running = false;
                this.receiving = false;
                closeOutputStream();
                if (!Thread.currentThread().equals(this.receiverThread)) {
                    try {
                        this.receiverThread.join();
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
        this.receiverThread = null;
        log.fine(CLASS_NAME, "stop", "851");
    }
}
