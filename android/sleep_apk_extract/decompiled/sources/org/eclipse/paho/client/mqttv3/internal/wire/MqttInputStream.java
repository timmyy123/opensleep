package org.eclipse.paho.client.mqttv3.internal.wire;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.internal.ClientState;
import org.eclipse.paho.client.mqttv3.internal.ExceptionHelper;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class MqttInputStream extends InputStream {
    private static final String CLASS_NAME;
    static /* synthetic */ Class class$0;
    private static final Logger log;
    private ClientState clientState;
    private DataInputStream in;

    static {
        Class<MqttInputStream> cls = class$0;
        if (cls == null) {
            cls = MqttInputStream.class;
            class$0 = cls;
        }
        String name = cls.getName();
        CLASS_NAME = name;
        log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, name);
    }

    public MqttInputStream(ClientState clientState, InputStream inputStream) {
        this.clientState = clientState;
        this.in = new DataInputStream(inputStream);
    }

    private void readFully(byte[] bArr, int i, int i2) throws IOException {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = 0;
        while (i3 < i2) {
            int i4 = this.in.read(bArr, i + i3, i2 - i3);
            this.clientState.notifyReceivedBytes(i4);
            if (i4 < 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$2();
                return;
            }
            i3 += i4;
        }
    }

    @Override // java.io.InputStream
    public int available() {
        return this.in.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.in.close();
    }

    @Override // java.io.InputStream
    public int read() {
        return this.in.read();
    }

    public MqttWireMessage readMqttWireMessage() throws MqttException, IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte b = this.in.readByte();
        this.clientState.notifyReceivedBytes(1);
        byte b2 = (byte) ((b >>> 4) & 15);
        if (b2 < 1 || b2 > 14) {
            throw ExceptionHelper.createMqttException(32108);
        }
        long value = MqttWireMessage.readMBI(this.in).getValue();
        byteArrayOutputStream.write(b);
        byteArrayOutputStream.write(MqttWireMessage.encodeMBI(value));
        int size = (int) (((long) byteArrayOutputStream.size()) + value);
        byte[] bArr = new byte[size];
        readFully(bArr, byteArrayOutputStream.size(), size - byteArrayOutputStream.size());
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        System.arraycopy(byteArray, 0, bArr, 0, byteArray.length);
        MqttWireMessage mqttWireMessageCreateWireMessage = MqttWireMessage.createWireMessage(bArr);
        log.fine(CLASS_NAME, "readMqttWireMessage", "501", new Object[]{mqttWireMessageCreateWireMessage});
        return mqttWireMessageCreateWireMessage;
    }
}
