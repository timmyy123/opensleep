package com.launchdarkly.eventsource;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.URI;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public class MessageEvent implements StreamEvent {

    /* JADX INFO: renamed from: data, reason: collision with root package name */
    private volatile String f53data;
    private volatile Reader dataReader;
    private final Object dataReaderLock;
    private final String eventName;
    private final ResponseHeaders headers;
    private final String lastEventId;
    private final URI origin;

    public MessageEvent(String str, String str2, String str3, URI uri, ResponseHeaders responseHeaders) {
        this.eventName = str == null ? "message" : str;
        this.f53data = str2 == null ? "" : str2;
        this.dataReader = null;
        this.dataReaderLock = new Object();
        this.lastEventId = str3;
        this.origin = uri;
        this.headers = responseHeaders;
    }

    public void close() {
        synchronized (this.dataReaderLock) {
            if (this.dataReader != null) {
                try {
                    this.dataReader.close();
                } catch (IOException unused) {
                }
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            MessageEvent messageEvent = (MessageEvent) obj;
            if (Objects.equals(getEventName(), messageEvent.getEventName()) && Objects.equals(getData(), messageEvent.getData()) && Objects.equals(getLastEventId(), messageEvent.getLastEventId()) && Objects.equals(getOrigin(), messageEvent.getOrigin())) {
                return true;
            }
        }
        return false;
    }

    public String getData() {
        if (this.f53data != null) {
            return this.f53data;
        }
        synchronized (this.dataReaderLock) {
            try {
                if (this.f53data != null) {
                    return this.f53data;
                }
                char[] cArr = new char[2000];
                StringBuilder sb = new StringBuilder(2000);
                while (true) {
                    try {
                        int i = this.dataReader.read(cArr, 0, 2000);
                        if (i == -1) {
                            break;
                        }
                        sb.append(cArr, 0, i);
                    } catch (IOException unused) {
                    }
                    this.f53data = sb.toString();
                    this.dataReader = new StringReader(this.f53data);
                    return this.f53data;
                }
                this.dataReader.close();
                this.f53data = sb.toString();
                this.dataReader = new StringReader(this.f53data);
                return this.f53data;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String getEventName() {
        return this.eventName;
    }

    public String getLastEventId() {
        return this.lastEventId;
    }

    public URI getOrigin() {
        return this.origin;
    }

    public int hashCode() {
        return Objects.hash(getEventName(), getData(), getLastEventId(), getOrigin());
    }

    public String toString() {
        String string;
        synchronized (this.dataReaderLock) {
            try {
                StringBuilder sb = new StringBuilder("MessageEvent(eventName=");
                sb.append(this.eventName);
                sb.append(",data=");
                sb.append(this.f53data == null ? "<streaming>" : this.f53data);
                if (this.lastEventId != null) {
                    sb.append(",id=");
                    sb.append(this.lastEventId);
                }
                sb.append(",origin=");
                sb.append(this.origin);
                sb.append(')');
                string = sb.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
        return string;
    }

    public MessageEvent(String str, Reader reader, String str2, URI uri, ResponseHeaders responseHeaders) {
        this.f53data = null;
        this.dataReader = reader;
        this.dataReaderLock = new Object();
        this.eventName = str == null ? "message" : str;
        this.lastEventId = str2;
        this.origin = uri;
        this.headers = responseHeaders;
    }
}
