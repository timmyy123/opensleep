package com.launchdarkly.eventsource;

import com.launchdarkly.logging.LDLogger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
final class EventParser {
    private static final Pattern DIGITS_ONLY = Pattern.compile("^[\\d]+$");
    private byte[] chunkData;
    private int chunkOffset;
    private int chunkSize;
    private int currentLineLength;
    private IncrementalMessageDataInputStream currentMessageDataStream;
    private ByteArrayOutputStream dataBuffer = new ByteArrayOutputStream(1000);
    private boolean dataLineEnded;
    private String eventName;
    private Set<String> expectFields;
    private String fieldName;
    private boolean haveData;
    private final ResponseHeaders headers;
    private String lastEventId;
    private boolean lineEnded;
    private BufferedLineParser lineParser;
    private final LDLogger logger;
    private final URI origin;
    private boolean skipRestOfLine;
    private boolean skipRestOfMessage;
    private final boolean streamEventData;
    private ByteArrayOutputStream valueBuffer;

    public EventParser(InputStream inputStream, URI uri, int i, boolean z, Set<String> set, LDLogger lDLogger, ResponseHeaders responseHeaders) {
        this.lineParser = new BufferedLineParser(inputStream, i);
        this.origin = uri;
        this.streamEventData = z;
        this.expectFields = set;
        this.logger = lDLogger;
        this.headers = responseHeaders;
    }

    private boolean canStreamEventDataNow() {
        if (!this.streamEventData) {
            return false;
        }
        Set<String> set = this.expectFields;
        if (set == null) {
            return true;
        }
        if (set.contains("event") && this.eventName == null) {
            return false;
        }
        return (this.expectFields.contains("id") && this.lastEventId == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getNextChunk() throws StreamClosedByServerException {
        boolean z = this.lineEnded;
        this.lineEnded = this.lineParser.read();
        this.chunkData = this.lineParser.getBuffer();
        this.chunkOffset = this.lineParser.getChunkOffset();
        int chunkSize = this.lineParser.getChunkSize();
        this.chunkSize = chunkSize;
        if (chunkSize == 0 && this.lineParser.isEof()) {
            throw new StreamClosedByServerException();
        }
        if (z) {
            this.currentLineLength = this.chunkSize;
        } else {
            this.currentLineLength += this.chunkSize;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String parseFieldName() {
        int i = 0;
        while (i < this.chunkSize && this.chunkData[this.chunkOffset + i] != 58) {
            i++;
        }
        resetValueBuffer();
        if (i == this.chunkSize && !this.lineEnded) {
            return null;
        }
        String str = i == 0 ? "" : new String(this.chunkData, this.chunkOffset, i, Helpers.UTF8);
        int i2 = this.chunkSize;
        if (i < i2) {
            int i3 = i + 1;
            i = (i3 >= i2 || this.chunkData[this.chunkOffset + i3] != 32) ? i3 : i + 2;
        }
        this.chunkOffset += i;
        this.chunkSize = i2 - i;
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetState() {
        this.haveData = false;
        this.dataLineEnded = false;
        this.eventName = null;
        this.fieldName = null;
        resetValueBuffer();
        if (this.dataBuffer.size() != 0) {
            if (this.dataBuffer.size() > 1000) {
                this.dataBuffer = new ByteArrayOutputStream(1000);
            } else {
                this.dataBuffer.reset();
            }
        }
        this.currentMessageDataStream = null;
    }

    private void resetValueBuffer() {
        ByteArrayOutputStream byteArrayOutputStream = this.valueBuffer;
        if (byteArrayOutputStream != null) {
            if (byteArrayOutputStream.size() > 1000) {
                this.valueBuffer = null;
            } else {
                this.valueBuffer.reset();
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private StreamEvent tryNextEvent() throws StreamIOException, StreamClosedByServerException {
        String str;
        IncrementalMessageDataInputStream incrementalMessageDataInputStream = this.currentMessageDataStream;
        if (incrementalMessageDataInputStream != null) {
            this.skipRestOfMessage = true;
            this.currentMessageDataStream = null;
            incrementalMessageDataInputStream.close();
        }
        try {
            getNextChunk();
            if (this.skipRestOfMessage) {
                if (this.lineEnded && this.currentLineLength == 0) {
                    this.skipRestOfMessage = false;
                    resetState();
                }
                return null;
            }
            boolean z = this.skipRestOfLine;
            boolean z2 = this.lineEnded;
            if (z) {
                this.skipRestOfLine = !z2;
                return null;
            }
            if (z2 && this.currentLineLength == 0) {
                if (!this.haveData) {
                    resetState();
                    return null;
                }
                MessageEvent messageEvent = new MessageEvent(this.eventName, Helpers.utf8ByteArrayOutputStreamToString(this.dataBuffer), this.lastEventId, this.origin, this.headers);
                resetState();
                this.logger.debug("Received message: {}", messageEvent);
                return messageEvent;
            }
            if (this.fieldName == null) {
                String fieldName = parseFieldName();
                this.fieldName = fieldName;
                if (fieldName == null) {
                    this.skipRestOfLine = !this.lineEnded;
                    return null;
                }
            }
            if (this.fieldName.equals("data")) {
                if (canStreamEventDataNow()) {
                    IncrementalMessageDataInputStream incrementalMessageDataInputStream2 = new IncrementalMessageDataInputStream();
                    this.currentMessageDataStream = incrementalMessageDataInputStream2;
                    MessageEvent messageEvent2 = new MessageEvent(this.eventName, new InputStreamReader(incrementalMessageDataInputStream2), this.lastEventId, this.origin, this.headers);
                    this.logger.debug("Received message: {}", messageEvent2);
                    return messageEvent2;
                }
                if (this.dataLineEnded) {
                    this.dataBuffer.write(10);
                }
                int i = this.chunkSize;
                if (i != 0) {
                    this.dataBuffer.write(this.chunkData, this.chunkOffset, i);
                }
                boolean z3 = this.lineEnded;
                this.dataLineEnded = z3;
                this.haveData = true;
                if (z3) {
                    this.fieldName = null;
                }
                return null;
            }
            if (!this.lineEnded) {
                if (this.valueBuffer == null) {
                    this.valueBuffer = new ByteArrayOutputStream(1000);
                }
                this.valueBuffer.write(this.chunkData, this.chunkOffset, this.chunkSize);
                return null;
            }
            String str2 = this.fieldName;
            this.fieldName = null;
            ByteArrayOutputStream byteArrayOutputStream = this.valueBuffer;
            if (byteArrayOutputStream == null || byteArrayOutputStream.size() == 0) {
                int i2 = this.chunkSize;
                str = i2 == 0 ? "" : new String(this.chunkData, this.chunkOffset, i2, Helpers.UTF8);
            } else {
                this.valueBuffer.write(this.chunkData, this.chunkOffset, this.chunkSize);
                str = Helpers.utf8ByteArrayOutputStreamToString(this.valueBuffer);
                resetValueBuffer();
            }
            str2.getClass();
            switch (str2) {
                case "":
                    return new CommentEvent(str);
                case "id":
                    if (!str.contains("\u0000")) {
                        this.lastEventId = str;
                    }
                    return null;
                case "event":
                    this.eventName = str;
                    return null;
                case "retry":
                    if (DIGITS_ONLY.matcher(str).matches()) {
                        return new SetRetryDelayEvent(Long.parseLong(str));
                    }
                    return null;
                default:
                    return null;
            }
        } catch (IOException e) {
            throw new StreamIOException(e);
        }
    }

    public StreamEvent nextEvent() throws StreamIOException, StreamClosedByServerException {
        StreamEvent streamEventTryNextEvent;
        do {
            streamEventTryNextEvent = tryNextEvent();
        } while (streamEventTryNextEvent == null);
        return streamEventTryNextEvent;
    }

    public class IncrementalMessageDataInputStream extends InputStream {
        private final AtomicBoolean closed;
        private boolean haveChunk;
        private int readOffset;

        private IncrementalMessageDataInputStream() {
            this.haveChunk = true;
            this.readOffset = 0;
            this.closed = new AtomicBoolean();
        }

        private boolean canGetNextChunk() {
            try {
                EventParser.this.getNextChunk();
                return true;
            } catch (StreamClosedByServerException unused) {
                close();
                return false;
            }
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!this.closed.getAndSet(true) && EventParser.this.currentMessageDataStream == this) {
                EventParser.this.currentMessageDataStream = null;
                EventParser.this.skipRestOfMessage = true;
            }
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws StreamClosedWithIncompleteMessageException {
            while (i2 > 0 && !this.closed.get()) {
                boolean z = this.haveChunk;
                EventParser eventParser = EventParser.this;
                if (z) {
                    boolean z2 = eventParser.skipRestOfLine;
                    EventParser eventParser2 = EventParser.this;
                    if (!z2) {
                        int i3 = eventParser2.chunkSize - this.readOffset;
                        EventParser eventParser3 = EventParser.this;
                        if (i3 > i2) {
                            System.arraycopy(eventParser3.chunkData, EventParser.this.chunkOffset + this.readOffset, bArr, i, i2);
                            this.readOffset += i2;
                            return i2;
                        }
                        System.arraycopy(eventParser3.chunkData, EventParser.this.chunkOffset + this.readOffset, bArr, i, i3);
                        this.haveChunk = false;
                        this.readOffset = 0;
                        return i3;
                    }
                    eventParser2.skipRestOfLine = !eventParser2.lineEnded;
                    this.haveChunk = false;
                } else if (eventParser.lineEnded) {
                    if (!canGetNextChunk()) {
                        throw new StreamClosedWithIncompleteMessageException();
                    }
                    if (EventParser.this.lineEnded && EventParser.this.chunkSize == 0) {
                        this.closed.set(true);
                        EventParser.this.resetState();
                        return -1;
                    }
                    if ("data".equals(EventParser.this.parseFieldName())) {
                        bArr[0] = 10;
                        this.haveChunk = true;
                        return 1;
                    }
                    EventParser.this.skipRestOfLine = !r0.lineEnded;
                } else {
                    if (!canGetNextChunk()) {
                        throw new StreamClosedWithIncompleteMessageException();
                    }
                    this.haveChunk = true;
                }
            }
            return 0;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) {
            return read(bArr, 0, bArr.length);
        }

        @Override // java.io.InputStream
        public int read() throws StreamClosedWithIncompleteMessageException {
            int i;
            byte[] bArr = new byte[0];
            do {
                i = read(bArr, 0, 1);
                if (i < 0) {
                    return i;
                }
            } while (i != 1);
            return bArr[0];
        }
    }
}
