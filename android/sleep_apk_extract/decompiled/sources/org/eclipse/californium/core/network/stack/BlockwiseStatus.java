package org.eclipse.californium.core.network.stack;

import java.nio.ByteBuffer;
import java.util.concurrent.ScheduledFuture;
import org.eclipse.californium.core.coap.BlockOption;
import org.eclipse.californium.core.coap.Message;
import org.eclipse.californium.core.coap.OptionSet;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.elements.EndpointContext;
import org.eclipse.californium.elements.EndpointContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BlockwiseStatus {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) BlockwiseStatus.class);
    private int blockCount;
    protected final ByteBuffer buf;
    private ScheduledFuture<?> cleanUpTask;
    private boolean complete;
    private final int contentFormat;
    private int currentNum;
    private int currentSzx;
    protected Exchange exchange;
    private Message first;
    protected EndpointContext followUpEndpointContext;
    protected boolean randomAccess;

    public BlockwiseStatus(int i, int i2) {
        this.buf = ByteBuffer.allocate(i);
        this.contentFormat = i2;
    }

    public final synchronized boolean addBlock(byte[] bArr) {
        boolean z;
        if (bArr == null) {
            z = true;
        } else {
            try {
                if (this.buf.remaining() >= bArr.length) {
                    this.buf.put(bArr);
                    z = true;
                } else {
                    LOGGER.debug("resource body exceeds buffer size [{}]", Integer.valueOf(getBufferSize()));
                    z = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.blockCount++;
        return z;
    }

    public final synchronized void assembleReceivedMessage(Message message) {
        try {
            if (message == null) {
                throw new NullPointerException("message must not be null");
            }
            Message message2 = this.first;
            if (message2 == null) {
                throw new IllegalStateException("first message is not set");
            }
            if (message2.getSourceContext() == null) {
                throw new IllegalStateException("first message has no peer context");
            }
            if (this.first.getSourceContext().getPeerAddress() == null) {
                throw new IllegalStateException("first message has no peer address");
            }
            message.setSourceContext(this.first.getSourceContext());
            message.setType(this.first.getType());
            message.setMID(this.first.getMID());
            message.setToken(this.first.getToken());
            message.setOptions(new OptionSet(this.first.getOptions()));
            message.getOptions().removeBlock1();
            message.getOptions().removeBlock2();
            if (!message.isIntendedPayload()) {
                message.setUnintendedPayload();
            }
            message.setPayload(getBody());
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized int getBlockCount() {
        return this.blockCount;
    }

    public final synchronized byte[] getBody() {
        byte[] bArr;
        this.buf.flip();
        bArr = new byte[this.buf.remaining()];
        this.buf.get(bArr).clear();
        return bArr;
    }

    public final synchronized int getBufferSize() {
        return this.buf.capacity();
    }

    public final synchronized int getCurrentNum() {
        return this.currentNum;
    }

    public final synchronized int getCurrentSize() {
        return BlockOption.szx2Size(this.currentSzx);
    }

    public final synchronized int getCurrentSzx() {
        return this.currentSzx;
    }

    public synchronized EndpointContext getFollowUpEndpointContext(EndpointContext endpointContext) {
        try {
            EndpointContext endpointContext2 = this.followUpEndpointContext;
            if (endpointContext2 == null || !endpointContext2.getPeerAddress().equals(endpointContext.getPeerAddress())) {
                Exchange exchange = this.exchange;
                if (exchange != null) {
                    this.followUpEndpointContext = EndpointContextUtil.getFollowUpEndpointContext(exchange.getRequest().getDestinationContext(), endpointContext);
                } else {
                    this.followUpEndpointContext = endpointContext;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.followUpEndpointContext;
    }

    public final boolean hasContentFormat(int i) {
        return this.contentFormat == i;
    }

    public final synchronized boolean isComplete() {
        return this.complete;
    }

    public final synchronized boolean isRandomAccess() {
        return this.randomAccess;
    }

    public final synchronized void setBlockCleanupHandle(ScheduledFuture<?> scheduledFuture) {
        try {
            ScheduledFuture<?> scheduledFuture2 = this.cleanUpTask;
            if (scheduledFuture2 != null) {
                scheduledFuture2.cancel(false);
            }
            this.cleanUpTask = scheduledFuture;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void setComplete(boolean z) {
        ScheduledFuture<?> scheduledFuture;
        this.complete = z;
        if (z && (scheduledFuture = this.cleanUpTask) != null) {
            scheduledFuture.cancel(false);
            this.cleanUpTask = null;
        }
    }

    public final synchronized void setCurrentNum(int i) {
        this.currentNum = i;
    }

    public final synchronized void setCurrentSzx(int i) {
        this.currentSzx = i;
    }

    public final synchronized void setFirst(Message message) {
        this.first = message;
        message.setProtectFromOffload();
    }

    public void timeoutCurrentTranfer() {
        final Exchange exchange;
        synchronized (this) {
            exchange = this.exchange;
        }
        if (exchange == null || exchange.isComplete()) {
            return;
        }
        exchange.execute(new Runnable() { // from class: org.eclipse.californium.core.network.stack.BlockwiseStatus.1
            @Override // java.lang.Runnable
            public void run() {
                Exchange exchange2 = exchange;
                exchange2.setTimedOut(exchange2.getCurrentRequest());
            }
        });
    }

    public synchronized String toString() {
        return String.format("[currentNum=%d, currentSzx=%d, bufferSize=%d, complete=%b, random access=%b]", Integer.valueOf(this.currentNum), Integer.valueOf(this.currentSzx), Integer.valueOf(getBufferSize()), Boolean.valueOf(this.complete), Boolean.valueOf(this.randomAccess));
    }
}
