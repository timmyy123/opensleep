package org.eclipse.paho.client.mqttv3.internal;

import com.facebook.internal.ServerProtocol;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttAck;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttConnack;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttSuback;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class Token {
    private static final String CLASS_NAME;
    static /* synthetic */ Class class$0;
    private static final Logger log;
    private String key;
    private volatile boolean completed = false;
    private boolean pendingComplete = false;
    private boolean sent = false;
    private Object responseLock = new Object();
    private Object sentLock = new Object();
    protected MqttMessage message = null;
    private MqttWireMessage response = null;
    private MqttException exception = null;
    private String[] topics = null;
    private IMqttAsyncClient client = null;
    private IMqttActionListener callback = null;
    private Object userContext = null;
    private int messageID = 0;
    private boolean notified = false;

    static {
        Class<Token> cls = class$0;
        if (cls == null) {
            cls = Token.class;
            class$0 = cls;
        }
        String name = cls.getName();
        CLASS_NAME = name;
        log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, name);
    }

    public Token(String str) {
        log.setResourceName(str);
    }

    public boolean checkResult() throws MqttException {
        if (getException() == null) {
            return true;
        }
        throw getException();
    }

    public IMqttActionListener getActionCallback() {
        return this.callback;
    }

    public IMqttAsyncClient getClient() {
        return this.client;
    }

    public MqttException getException() {
        return this.exception;
    }

    public int[] getGrantedQos() {
        int[] iArr = new int[0];
        MqttWireMessage mqttWireMessage = this.response;
        return mqttWireMessage instanceof MqttSuback ? ((MqttSuback) mqttWireMessage).getGrantedQos() : iArr;
    }

    public String getKey() {
        return this.key;
    }

    public MqttMessage getMessage() {
        return this.message;
    }

    public int getMessageID() {
        return this.messageID;
    }

    public MqttWireMessage getResponse() {
        return this.response;
    }

    public boolean getSessionPresent() {
        MqttWireMessage mqttWireMessage = this.response;
        if (mqttWireMessage instanceof MqttConnack) {
            return ((MqttConnack) mqttWireMessage).getSessionPresent();
        }
        return false;
    }

    public String[] getTopics() {
        return this.topics;
    }

    public Object getUserContext() {
        return this.userContext;
    }

    public MqttWireMessage getWireMessage() {
        return this.response;
    }

    public boolean isComplete() {
        return this.completed;
    }

    public boolean isCompletePending() {
        return this.pendingComplete;
    }

    public boolean isInUse() {
        return (getClient() == null || isComplete()) ? false : true;
    }

    public boolean isNotified() {
        return this.notified;
    }

    public void markComplete(MqttWireMessage mqttWireMessage, MqttException mqttException) {
        log.fine(CLASS_NAME, "markComplete", "404", new Object[]{getKey(), mqttWireMessage, mqttException});
        synchronized (this.responseLock) {
            try {
                if (mqttWireMessage instanceof MqttAck) {
                    this.message = null;
                }
                this.pendingComplete = true;
                this.response = mqttWireMessage;
                this.exception = mqttException;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void notifyComplete() {
        log.fine(CLASS_NAME, "notifyComplete", "404", new Object[]{getKey(), this.response, this.exception});
        synchronized (this.responseLock) {
            try {
                if (this.exception == null && this.pendingComplete) {
                    this.completed = true;
                    this.pendingComplete = false;
                } else {
                    this.pendingComplete = false;
                }
                this.responseLock.notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.sentLock) {
            this.sent = true;
            this.sentLock.notifyAll();
        }
    }

    public void notifySent() {
        log.fine(CLASS_NAME, "notifySent", "403", new Object[]{getKey()});
        synchronized (this.responseLock) {
            this.response = null;
            this.completed = false;
        }
        synchronized (this.sentLock) {
            this.sent = true;
            this.sentLock.notifyAll();
        }
    }

    public void reset() throws MqttException {
        if (isInUse()) {
            throw new MqttException(32201);
        }
        log.fine(CLASS_NAME, "reset", "410", new Object[]{getKey()});
        this.client = null;
        this.completed = false;
        this.response = null;
        this.sent = false;
        this.exception = null;
        this.userContext = null;
    }

    public void setActionCallback(IMqttActionListener iMqttActionListener) {
        this.callback = iMqttActionListener;
    }

    public void setClient(IMqttAsyncClient iMqttAsyncClient) {
        this.client = iMqttAsyncClient;
    }

    public void setException(MqttException mqttException) {
        synchronized (this.responseLock) {
            this.exception = mqttException;
        }
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMessage(MqttMessage mqttMessage) {
        this.message = mqttMessage;
    }

    public void setMessageID(int i) {
        this.messageID = i;
    }

    public void setNotified(boolean z) {
        this.notified = z;
    }

    public void setTopics(String[] strArr) {
        this.topics = strArr;
    }

    public void setUserContext(Object obj) {
        this.userContext = obj;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("key=");
        stringBuffer.append(getKey());
        stringBuffer.append(" ,topics=");
        if (getTopics() != null) {
            for (int i = 0; i < getTopics().length; i++) {
                stringBuffer.append(getTopics()[i]);
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(" ,usercontext=");
        stringBuffer.append(getUserContext());
        stringBuffer.append(" ,isComplete=");
        stringBuffer.append(isComplete());
        stringBuffer.append(" ,isNotified=");
        stringBuffer.append(isNotified());
        stringBuffer.append(" ,exception=");
        stringBuffer.append(getException());
        stringBuffer.append(" ,actioncallback=");
        stringBuffer.append(getActionCallback());
        return stringBuffer.toString();
    }

    public void waitForCompletion(long j) {
        Logger logger = log;
        String str = CLASS_NAME;
        logger.fine(str, "waitForCompletion", "407", new Object[]{getKey(), new Long(j), this});
        if (waitForResponse(j) != null || this.completed) {
            checkResult();
            return;
        }
        logger.fine(str, "waitForCompletion", "406", new Object[]{getKey(), this});
        MqttException mqttException = new MqttException(32000);
        this.exception = mqttException;
        throw mqttException;
    }

    public MqttWireMessage waitForResponse(long j) {
        synchronized (this.responseLock) {
            try {
                Logger logger = log;
                String str = CLASS_NAME;
                String key = getKey();
                Long l = new Long(j);
                Boolean bool = new Boolean(this.sent);
                Boolean bool2 = new Boolean(this.completed);
                MqttException mqttException = this.exception;
                logger.fine(str, "waitForResponse", "400", new Object[]{key, l, bool, bool2, mqttException == null ? "false" : ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, this.response, this}, mqttException);
                while (!this.completed) {
                    if (this.exception == null) {
                        try {
                            log.fine(CLASS_NAME, "waitForResponse", "408", new Object[]{getKey(), new Long(j)});
                            Object obj = this.responseLock;
                            if (j <= 0) {
                                obj.wait();
                            } else {
                                obj.wait(j);
                            }
                        } catch (InterruptedException e) {
                            this.exception = new MqttException(e);
                        }
                    }
                    if (!this.completed) {
                        MqttException mqttException2 = this.exception;
                        if (mqttException2 != null) {
                            log.fine(CLASS_NAME, "waitForResponse", "401", null, mqttException2);
                            throw this.exception;
                        }
                        if (j > 0) {
                            break;
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        log.fine(CLASS_NAME, "waitForResponse", "402", new Object[]{getKey(), this.response});
        return this.response;
    }

    public void waitUntilSent() {
        boolean z;
        synchronized (this.sentLock) {
            try {
                synchronized (this.responseLock) {
                    MqttException mqttException = this.exception;
                    if (mqttException != null) {
                        throw mqttException;
                    }
                }
                while (true) {
                    z = this.sent;
                    if (z) {
                        break;
                    }
                    try {
                        log.fine(CLASS_NAME, "waitUntilSent", "409", new Object[]{getKey()});
                        this.sentLock.wait();
                    } catch (InterruptedException unused) {
                    }
                }
                if (!z) {
                    MqttException mqttException2 = this.exception;
                    if (mqttException2 != null) {
                        throw mqttException2;
                    }
                    throw ExceptionHelper.createMqttException(6);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void waitForCompletion() {
        waitForCompletion(-1L);
    }

    public MqttWireMessage waitForResponse() {
        return waitForResponse(-1L);
    }
}
