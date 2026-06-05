package org.eclipse.californium.core.coap;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticBUOutline0;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.core.Utils;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.network.stack.ReliabilityLayerParameters;
import org.eclipse.californium.elements.EndpointContext;
import org.eclipse.californium.elements.util.NetworkInterfacesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Message {
    protected static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) Message.class);
    private volatile byte[] bytes;
    private volatile boolean canceled;
    private volatile EndpointContext destinationContext;
    private volatile boolean duplicate;
    private volatile EndpointContext effectiveDestinationContext;
    private int maxResourceBodySize;
    private volatile long nanoTimestamp;
    private volatile OffloadMode offload;
    private OptionSet options;
    private volatile ReliabilityLayerParameters parameters;
    private byte[] payload;
    private volatile boolean protectFromOffload;
    private volatile boolean rejected;
    private volatile Throwable sendError;
    private volatile boolean sent;
    private volatile EndpointContext sourceContext;
    private volatile boolean timedOut;
    private CoAP.Type type;
    private boolean unintendedPayload;
    private volatile int mid = -1;
    private volatile Token token = null;
    private final AtomicBoolean acknowledged = new AtomicBoolean();
    private final AtomicReference<List<MessageObserver>> messageObservers = new AtomicReference<>();
    private volatile List<MessageObserver> unmodifiableMessageObserversFacade = null;

    public enum OffloadMode {
        PAYLOAD,
        FULL
    }

    public Message(CoAP.Type type) {
        this.type = type;
    }

    private List<MessageObserver> ensureMessageObserverList() {
        boolean z;
        List<MessageObserver> list = this.messageObservers.get();
        if (list != null) {
            return list;
        }
        AtomicReference<List<MessageObserver>> atomicReference = this.messageObservers;
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        while (true) {
            if (atomicReference.compareAndSet(null, copyOnWriteArrayList)) {
                z = true;
                break;
            }
            if (atomicReference.get() != null) {
                z = false;
                break;
            }
        }
        List<MessageObserver> list2 = this.messageObservers.get();
        if (z) {
            this.unmodifiableMessageObserversFacade = Collections.unmodifiableList(list2);
        }
        return list2;
    }

    public boolean acknowledge() {
        if (!isConfirmable() || !this.acknowledged.compareAndSet(false, true)) {
            return false;
        }
        setAcknowledged(true);
        return true;
    }

    public void addMessageObserver(MessageObserver messageObserver) {
        messageObserver.getClass();
        ensureMessageObserverList().add(messageObserver);
    }

    public void addMessageObservers(List<MessageObserver> list) {
        list.getClass();
        if (list.isEmpty()) {
            return;
        }
        ensureMessageObserverList().addAll(list);
    }

    public void cancel() {
        setCanceled(true);
    }

    public byte[] getBytes() {
        if (this.offload != OffloadMode.FULL) {
            return this.bytes;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("message offloaded!");
        return null;
    }

    public EndpointContext getDestinationContext() {
        return this.destinationContext;
    }

    public EndpointContext getEffectiveDestinationContext() {
        return this.effectiveDestinationContext;
    }

    public int getMID() {
        return this.mid;
    }

    public int getMaxResourceBodySize() {
        return this.maxResourceBodySize;
    }

    public List<MessageObserver> getMessageObservers() {
        return this.unmodifiableMessageObserversFacade == null ? Collections.EMPTY_LIST : this.unmodifiableMessageObserversFacade;
    }

    public long getNanoTimestamp() {
        return this.nanoTimestamp;
    }

    public OptionSet getOptions() {
        OptionSet optionSet;
        synchronized (this.acknowledged) {
            try {
                if (this.offload == OffloadMode.FULL) {
                    throw new IllegalStateException("message " + this.offload + " offloaded! " + this);
                }
                if (this.options == null) {
                    this.options = new OptionSet();
                }
                optionSet = this.options;
            } catch (Throwable th) {
                throw th;
            }
        }
        return optionSet;
    }

    public byte[] getPayload() {
        if (this.offload == null) {
            return this.payload;
        }
        Fragment$$ExternalSyntheticBUOutline0.m$1("message ", this.offload, " offloaded!");
        return null;
    }

    public int getPayloadSize() {
        byte[] bArr = this.payload;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public String getPayloadString() {
        if (this.offload == null) {
            byte[] bArr = this.payload;
            return bArr == null ? "" : new String(bArr, CoAP.UTF8_CHARSET);
        }
        Fragment$$ExternalSyntheticBUOutline0.m$1("message ", this.offload, " offloaded!");
        return null;
    }

    public String getPayloadTracingString() {
        byte[] bArr = this.payload;
        if (bArr == null || bArr.length == 0) {
            return "no payload";
        }
        int length = bArr.length;
        int i = 0;
        while (true) {
            if (i < length) {
                byte b = bArr[i];
                if (32 > b && b != 9 && b != 10 && b != 13) {
                    break;
                }
                i++;
            } else {
                CharsetDecoder charsetDecoderNewDecoder = CoAP.UTF8_CHARSET.newDecoder();
                CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
                charsetDecoderNewDecoder.onMalformedInput(codingErrorAction);
                charsetDecoderNewDecoder.onUnmappableCharacter(codingErrorAction);
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
                CharBuffer charBufferAllocate = CharBuffer.allocate(24);
                CoderResult coderResultDecode = charsetDecoderNewDecoder.decode(byteBufferWrap, charBufferAllocate, true);
                charsetDecoderNewDecoder.flush(charBufferAllocate);
                charBufferAllocate.flip();
                if (CoderResult.OVERFLOW == coderResultDecode) {
                    StringBuilder sb = new StringBuilder("\"");
                    sb.append((Object) charBufferAllocate);
                    sb.append("\".. ");
                    return FileInsert$$ExternalSyntheticOutline0.m(bArr.length, " bytes", sb);
                }
                if (!coderResultDecode.isError()) {
                    return "\"" + ((Object) charBufferAllocate) + "\"";
                }
            }
        }
        return Utils.toHexText(bArr, 256);
    }

    public abstract int getRawCode();

    public ReliabilityLayerParameters getReliabilityLayerParameters() {
        return this.parameters;
    }

    public Throwable getSendError() {
        return this.sendError;
    }

    public EndpointContext getSourceContext() {
        return this.sourceContext;
    }

    public String getStatusTracingString() {
        if (this.canceled) {
            return "canceled ";
        }
        if (this.sendError == null) {
            return this.rejected ? "rejected " : this.acknowledged.get() ? "acked " : this.timedOut ? "timeout " : "";
        }
        return this.sendError.getMessage() + " ";
    }

    public Token getToken() {
        return this.token;
    }

    public String getTokenString() {
        return this.token == null ? "null" : this.token.getAsString();
    }

    public CoAP.Type getType() {
        return this.type;
    }

    public boolean hasBlock(BlockOption blockOption) {
        return getPayloadSize() > 0 && blockOption.getOffset() < getPayloadSize();
    }

    public boolean hasEmptyToken() {
        return this.token == null || this.token.isEmpty();
    }

    public boolean hasMID() {
        return this.mid != -1;
    }

    public boolean isAcknowledged() {
        return this.acknowledged.get();
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    public boolean isConfirmable() {
        return getType() == CoAP.Type.CON;
    }

    public boolean isDuplicate() {
        return this.duplicate;
    }

    public boolean isIntendedPayload() {
        return true;
    }

    public boolean isRejected() {
        return this.rejected;
    }

    public boolean isSent() {
        return this.sent;
    }

    public boolean isUnintendedPayload() {
        return this.unintendedPayload;
    }

    public void offload(OffloadMode offloadMode) {
        if (this.protectFromOffload) {
            return;
        }
        synchronized (this.acknowledged) {
            try {
                this.offload = offloadMode;
                if (offloadMode != null) {
                    this.payload = null;
                    if (offloadMode == OffloadMode.FULL) {
                        this.bytes = null;
                        OptionSet optionSet = this.options;
                        if (optionSet != null) {
                            optionSet.clear();
                            this.options = null;
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void onComplete() {
        LOGGER.trace("Message completed {}", this);
        Iterator<MessageObserver> it = getMessageObservers().iterator();
        while (it.hasNext()) {
            it.next().onComplete();
        }
    }

    public void onConnecting() {
        Iterator<MessageObserver> it = getMessageObservers().iterator();
        while (it.hasNext()) {
            it.next().onConnecting();
        }
    }

    public void onContextEstablished(EndpointContext endpointContext) {
        if (endpointContext != null) {
            Iterator<MessageObserver> it = getMessageObservers().iterator();
            while (it.hasNext()) {
                it.next().onContextEstablished(endpointContext);
            }
        }
    }

    public void onDtlsRetransmission(int i) {
        Iterator<MessageObserver> it = getMessageObservers().iterator();
        while (it.hasNext()) {
            it.next().onDtlsRetransmission(i);
        }
    }

    public void removeMessageObserver(MessageObserver messageObserver) {
        messageObserver.getClass();
        List<MessageObserver> list = this.messageObservers.get();
        if (list != null) {
            list.remove(messageObserver);
        }
    }

    public void retransmitting() {
        Iterator<MessageObserver> it = getMessageObservers().iterator();
        while (it.hasNext()) {
            try {
                it.next().onRetransmission();
            } catch (Exception e) {
                LOGGER.error("Faulty MessageObserver for retransmitting events", (Throwable) e);
            }
        }
    }

    public void setAcknowledged(boolean z) {
        this.acknowledged.set(z);
        if (z) {
            Iterator<MessageObserver> it = getMessageObservers().iterator();
            while (it.hasNext()) {
                it.next().onAcknowledgement();
            }
        }
    }

    public void setBytes(byte[] bArr) {
        this.bytes = bArr;
    }

    public void setCanceled(boolean z) {
        this.canceled = z;
        if (z) {
            Iterator<MessageObserver> it = getMessageObservers().iterator();
            while (it.hasNext()) {
                it.next().onCancel();
            }
        }
    }

    public Message setDestinationContext(EndpointContext endpointContext) {
        if (endpointContext != null && NetworkInterfacesUtil.isMultiAddress(endpointContext.getPeerAddress().getAddress())) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Multicast destination is only supported for request!");
            return null;
        }
        this.destinationContext = endpointContext;
        this.effectiveDestinationContext = endpointContext;
        return this;
    }

    public void setDuplicate(boolean z) {
        this.duplicate = z;
    }

    public void setEffectiveDestinationContext(EndpointContext endpointContext) {
        this.effectiveDestinationContext = endpointContext;
    }

    public Message setMID(int i) {
        if (i > 65535 || i < -1) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(i, "The MID must be an unsigned 16-bit number but was "));
            return null;
        }
        if (this.bytes == null) {
            this.mid = i;
            return this;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("already serialized!");
        return null;
    }

    public void setMaxResourceBodySize(int i) {
        this.maxResourceBodySize = i;
    }

    public void setNanoTimestamp(long j) {
        this.nanoTimestamp = j;
    }

    public Message setOptions(OptionSet optionSet) {
        this.options = new OptionSet(optionSet);
        return this;
    }

    public Message setPayload(byte[] bArr) {
        if (bArr == null || bArr.length <= 0 || isIntendedPayload() || isUnintendedPayload()) {
            this.payload = bArr;
            return this;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Message must not have payload!");
        return null;
    }

    public void setProtectFromOffload() {
        this.protectFromOffload = true;
    }

    public void setReadyToSend() {
        Iterator<MessageObserver> it = getMessageObservers().iterator();
        while (it.hasNext()) {
            it.next().onReadyToSend();
        }
    }

    public void setRejected(boolean z) {
        this.rejected = z;
        if (z) {
            Iterator<MessageObserver> it = getMessageObservers().iterator();
            while (it.hasNext()) {
                it.next().onReject();
            }
        }
    }

    public void setRequestDestinationContext(EndpointContext endpointContext) {
        this.destinationContext = endpointContext;
        this.effectiveDestinationContext = endpointContext;
    }

    public void setSendError(Throwable th) {
        this.sendError = th;
        if (th != null) {
            Iterator<MessageObserver> it = getMessageObservers().iterator();
            while (it.hasNext()) {
                it.next().onSendError(th);
            }
        }
    }

    public void setSent(boolean z) {
        boolean z2 = this.sent;
        this.sent = z;
        if (z) {
            Iterator<MessageObserver> it = getMessageObservers().iterator();
            while (it.hasNext()) {
                it.next().onSent(z2);
            }
        }
    }

    public Message setSourceContext(EndpointContext endpointContext) {
        this.sourceContext = endpointContext;
        return this;
    }

    public void setTimedOut(boolean z) {
        this.timedOut = z;
        if (z) {
            Iterator<MessageObserver> it = getMessageObservers().iterator();
            while (it.hasNext()) {
                it.next().onTimeout();
            }
        }
    }

    public Message setToken(Token token) {
        this.token = token;
        if (this.bytes == null) {
            return this;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("already serialized!");
        return null;
    }

    public Message setType(CoAP.Type type) {
        this.type = type;
        return this;
    }

    public void setUnintendedPayload() {
        if (isIntendedPayload()) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Message is already intended to have payload!");
        } else {
            this.unintendedPayload = true;
        }
    }

    public String toTracingString(String str) {
        OffloadMode offloadMode;
        OptionSet optionSet;
        String statusTracingString = getStatusTracingString();
        String payloadTracingString = getPayloadTracingString();
        synchronized (this.acknowledged) {
            offloadMode = this.offload;
            optionSet = this.options;
        }
        return offloadMode == OffloadMode.FULL ? String.format("%s-%-6s MID=%5d, Token=%s %s(offloaded!)", getType(), str, Integer.valueOf(getMID()), getTokenString(), statusTracingString) : offloadMode == OffloadMode.PAYLOAD ? String.format("%s-%-6s MID=%5d, Token=%s, OptionSet=%s, %s(offloaded!)", getType(), str, Integer.valueOf(getMID()), getTokenString(), optionSet, statusTracingString) : String.format("%s-%-6s MID=%5d, Token=%s, OptionSet=%s, %s%s", getType(), str, Integer.valueOf(getMID()), getTokenString(), optionSet, statusTracingString, payloadTracingString);
    }

    public Message() {
    }

    public Message setPayload(String str) {
        if (str == null) {
            this.payload = null;
            return this;
        }
        setPayload(str.getBytes(CoAP.UTF8_CHARSET));
        return this;
    }
}
