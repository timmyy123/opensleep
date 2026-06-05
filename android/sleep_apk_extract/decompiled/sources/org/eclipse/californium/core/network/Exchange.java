package org.eclipse.californium.core.network;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.FacebookSdk$$ExternalSyntheticLambda1;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.core.coap.BlockOption;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.EmptyMessage;
import org.eclipse.californium.core.coap.Message;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.coap.Token;
import org.eclipse.californium.core.observe.ObserveRelation;
import org.eclipse.californium.elements.EndpointContext;
import org.eclipse.californium.elements.util.ClockUtil;
import org.eclipse.californium.elements.util.SerialExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class Exchange {
    static final boolean DEBUG;
    private static final AtomicInteger INSTANCE_COUNTER;
    private static final Logger LOGGER;
    private volatile BlockOption block1ToAck;
    private Throwable caller;
    private final AtomicBoolean complete;
    private KeyMID currentKeyMID;
    private KeyToken currentKeyToken;
    private volatile Request currentRequest;
    private volatile Response currentResponse;
    private volatile int currentTimeout;
    private volatile Endpoint endpoint;
    private final AtomicReference<EndpointContext> endpointContext;
    private final SerialExecutor executor;
    private volatile int failedTransmissionCount;
    private final int id;
    private final boolean keepRequestInStore;
    private final long nanoTimestamp;
    private final boolean notification;
    private volatile Integer notificationNumber;
    private volatile List<KeyMID> notifications;
    private final Origin origin;
    private KeyToken originalKeyToken;
    private volatile RemoveHandler removeHandler;
    private volatile Request request;
    private volatile Response response;
    private ScheduledFuture<?> retransmissionHandle;
    private final AtomicLong sendNanoTimestamp;
    private volatile boolean timedOut;

    public enum Origin {
        LOCAL,
        REMOTE
    }

    static {
        Logger logger = LoggerFactory.getLogger((Class<?>) Exchange.class);
        LOGGER = logger;
        DEBUG = logger.isTraceEnabled();
        INSTANCE_COUNTER = new AtomicInteger();
    }

    public Exchange(Request request, Origin origin, Executor executor, EndpointContext endpointContext, boolean z) {
        this.complete = new AtomicBoolean();
        this.sendNanoTimestamp = new AtomicLong();
        boolean z2 = false;
        this.failedTransmissionCount = 0;
        AtomicReference<EndpointContext> atomicReference = new AtomicReference<>();
        this.endpointContext = atomicReference;
        if (request == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("request must not be null!");
            throw null;
        }
        this.id = INSTANCE_COUNTER.incrementAndGet();
        this.executor = SerialExecutor.create(executor);
        this.currentRequest = request;
        this.request = request;
        this.origin = origin;
        atomicReference.set(endpointContext);
        if (!z && request.isObserve() && origin == Origin.LOCAL) {
            z2 = true;
        }
        this.keepRequestInStore = z2;
        this.notification = z;
        this.nanoTimestamp = ClockUtil.nanoRealtime();
    }

    private void assertOwner() {
        SerialExecutor serialExecutor = this.executor;
        if (serialExecutor != null) {
            serialExecutor.assertOwner();
        }
    }

    public void assertIncomplete(Object obj) {
        assertOwner();
        if (this.complete.get()) {
            throw new ExchangeCompleteException(this + " is already complete! " + obj, this.caller);
        }
    }

    public long calculateRTT() {
        return (ClockUtil.nanoRealtime() - this.nanoTimestamp) / 1000000;
    }

    public boolean checkOwner() {
        SerialExecutor serialExecutor = this.executor;
        if (serialExecutor != null) {
            return serialExecutor.checkOwner();
        }
        return true;
    }

    public void execute(Runnable runnable) {
        try {
            if (this.executor != null && !checkOwner()) {
                this.executor.execute(runnable);
                return;
            }
            runnable.run();
        } catch (RejectedExecutionException e) {
            LOGGER.debug("{} execute:", this, e);
        } catch (Throwable th) {
            LOGGER.error("{} execute:", this, th);
        }
    }

    public boolean executeComplete() {
        if (this.complete.get()) {
            return false;
        }
        if (this.executor == null || checkOwner()) {
            setComplete();
            return true;
        }
        execute(new Runnable() { // from class: org.eclipse.californium.core.network.Exchange.1
            @Override // java.lang.Runnable
            public void run() {
                if (Exchange.this.complete.get()) {
                    return;
                }
                Exchange.this.setComplete();
            }
        });
        return true;
    }

    public BlockOption getBlock1ToAck() {
        return this.block1ToAck;
    }

    public Throwable getCaller() {
        return this.caller;
    }

    public Request getCurrentRequest() {
        return this.currentRequest;
    }

    public Response getCurrentResponse() {
        return this.currentResponse;
    }

    public int getCurrentTimeout() {
        return this.currentTimeout;
    }

    public EndpointContext getEndpointContext() {
        return this.endpointContext.get();
    }

    public int getFailedTransmissionCount() {
        return this.failedTransmissionCount;
    }

    public KeyMID getKeyMID() {
        return this.currentKeyMID;
    }

    public KeyToken getKeyToken() {
        return this.currentKeyToken;
    }

    public Integer getNotificationNumber() {
        return this.notificationNumber;
    }

    public Origin getOrigin() {
        return this.origin;
    }

    public ObserveRelation getRelation() {
        return null;
    }

    public Request getRequest() {
        return this.request;
    }

    public Response getResponse() {
        return this.response;
    }

    public ScheduledFuture<?> getRetransmissionHandle() {
        return this.retransmissionHandle;
    }

    public long getSendNanoTimestamp() {
        return this.sendNanoTimestamp.get();
    }

    public boolean isComplete() {
        return this.complete.get();
    }

    public boolean isNotification() {
        return this.notification;
    }

    public boolean isOfLocalOrigin() {
        return this.origin == Origin.LOCAL;
    }

    public void removeNotifications() {
        assertOwner();
        RemoveHandler removeHandler = this.removeHandler;
        if (this.notifications == null || this.notifications.isEmpty()) {
            return;
        }
        for (KeyMID keyMID : this.notifications) {
            LOGGER.info("{} removing NON notification: {}", this, keyMID);
            if (removeHandler != null) {
                removeHandler.remove(this, null, keyMID);
            }
        }
        this.notifications.clear();
        throw null;
    }

    public void retransmitResponse() {
        assertOwner();
        if (this.origin == Origin.REMOTE) {
            this.caller = null;
            this.complete.set(false);
        } else {
            throw new IllegalStateException(this + " retransmit on local exchange not allowed!");
        }
    }

    public void sendReject(EndpointContext endpointContext) {
        Request request = this.currentRequest;
        if (!request.hasMID() || request.isRejected()) {
            return;
        }
        request.setRejected(true);
        if (request.isMulticast()) {
            return;
        }
        this.endpoint.sendEmptyMessage(this, EmptyMessage.newRST(request, endpointContext));
    }

    public void setBlock1ToAck(BlockOption blockOption) {
        this.block1ToAck = blockOption;
    }

    public boolean setComplete() {
        assertOwner();
        if (!this.complete.compareAndSet(false, true)) {
            throw new ExchangeCompleteException(this + " already complete!", this.caller);
        }
        if (DEBUG) {
            this.caller = new Throwable(toString());
            Logger logger = LOGGER;
            if (logger.isTraceEnabled()) {
                logger.trace("{}!", this, this.caller);
            } else {
                logger.debug("{}!", this);
            }
        } else {
            LOGGER.debug("{}!", this);
        }
        setRetransmissionHandle(null);
        RemoveHandler removeHandler = this.removeHandler;
        if (removeHandler != null) {
            if (this.origin == Origin.LOCAL) {
                KeyToken keyToken = this.currentKeyToken;
                if (keyToken != null || this.currentKeyMID != null) {
                    removeHandler.remove(this, keyToken, this.currentKeyMID);
                }
                KeyToken keyToken2 = this.currentKeyToken;
                KeyToken keyToken3 = this.originalKeyToken;
                if (keyToken2 != keyToken3) {
                    removeHandler.remove(this, keyToken3, null);
                }
                Logger logger2 = LOGGER;
                if (logger2.isDebugEnabled()) {
                    Request currentRequest = getCurrentRequest();
                    Request request = getRequest();
                    if (request == currentRequest) {
                        logger2.debug("local {} completed {}!", this, request);
                    } else {
                        logger2.debug("local {} completed {} -/- {}!", this, request, currentRequest);
                    }
                }
            } else {
                Response currentResponse = getCurrentResponse();
                if (currentResponse == null) {
                    LOGGER.debug("remote {} rejected (without response)!", this);
                } else {
                    KeyMID keyMID = this.currentKeyMID;
                    if (keyMID != null) {
                        removeHandler.remove(this, null, keyMID);
                    }
                    removeNotifications();
                    Response response = getResponse();
                    if (response == currentResponse || response == null) {
                        LOGGER.debug("Remote {} completed {}!", this, currentResponse);
                    } else {
                        LOGGER.debug("Remote {} completed {} -/- {}!", this, response, currentResponse);
                    }
                }
            }
        }
        return true;
    }

    public void setCurrentRequest(Request request) {
        assertOwner();
        if (this.currentRequest != request) {
            setRetransmissionHandle(null);
            this.failedTransmissionCount = 0;
            LOGGER.debug("{} replace {} by {}", this, this.currentRequest, request);
            this.currentRequest = request;
        }
    }

    public void setCurrentResponse(Response response) {
        assertOwner();
        if (this.currentResponse != response) {
            if (!isOfLocalOrigin() && this.currentKeyMID != null && this.currentResponse != null && this.currentResponse.getType() == CoAP.Type.NON && this.currentResponse.isNotification()) {
                LOGGER.info("{} store NON notification: {}", this, this.currentKeyMID);
                this.notifications.add(this.currentKeyMID);
                this.currentKeyMID = null;
            }
            this.currentResponse = response;
        }
    }

    public void setCurrentTimeout(int i) {
        this.currentTimeout = i;
    }

    public void setEndpoint(Endpoint endpoint) {
        this.endpoint = endpoint;
    }

    public void setEndpointContext(EndpointContext endpointContext) {
        AtomicReference<EndpointContext> atomicReference = this.endpointContext;
        while (!atomicReference.compareAndSet(null, endpointContext)) {
            if (atomicReference.get() != null) {
                this.endpointContext.set(endpointContext);
                return;
            }
        }
        getCurrentRequest().onContextEstablished(endpointContext);
    }

    public void setFailedTransmissionCount(int i) {
        this.failedTransmissionCount = i;
    }

    public void setKeyMID(KeyMID keyMID) {
        KeyMID keyMID2;
        assertOwner();
        if (keyMID.equals(this.currentKeyMID)) {
            return;
        }
        RemoveHandler removeHandler = this.removeHandler;
        if (removeHandler != null && (keyMID2 = this.currentKeyMID) != null) {
            removeHandler.remove(this, null, keyMID2);
        }
        this.currentKeyMID = keyMID;
    }

    public void setKeyToken(KeyToken keyToken) {
        KeyToken keyToken2;
        assertOwner();
        if (!isOfLocalOrigin()) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Token is only supported for local exchanges!");
            return;
        }
        if (keyToken.equals(this.currentKeyToken)) {
            return;
        }
        RemoveHandler removeHandler = this.removeHandler;
        if (removeHandler != null && (keyToken2 = this.currentKeyToken) != null && !keyToken2.equals(this.originalKeyToken)) {
            removeHandler.remove(this, this.currentKeyToken, null);
        }
        this.currentKeyToken = keyToken;
        if (this.keepRequestInStore && this.originalKeyToken == null) {
            this.originalKeyToken = keyToken;
        }
    }

    public void setNotificationNumber(int i) {
        if (i < 0 || i > 16777215) {
            FacebookSdk$$ExternalSyntheticLambda1.m(this, " illegal observe number");
        } else {
            this.notificationNumber = Integer.valueOf(i);
        }
    }

    public void setRemoveHandler(RemoveHandler removeHandler) {
        this.removeHandler = removeHandler;
    }

    public void setRequest(Request request) {
        Token token;
        assertOwner();
        if (this.request != request) {
            if (!this.keepRequestInStore || (token = this.request.getToken()) == null || token.equals(request.getToken())) {
                this.request = request;
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this);
            sb.append(" token missmatch (");
            sb.append(token);
            Utf8$$ExternalSyntheticBUOutline0.m(sb, "!=", request.getToken(), ")!");
        }
    }

    public void setResponse(Response response) {
        assertOwner();
        this.response = response;
    }

    public void setRetransmissionHandle(ScheduledFuture<?> scheduledFuture) {
        assertOwner();
        if (!this.complete.get() || scheduledFuture == null) {
            ScheduledFuture<?> scheduledFuture2 = this.retransmissionHandle;
            this.retransmissionHandle = scheduledFuture;
            if (scheduledFuture2 != null) {
                scheduledFuture2.cancel(false);
            }
        }
    }

    public void setSendNanoTimestamp(long j) {
        this.sendNanoTimestamp.set(j);
    }

    public void setTimedOut(Message message) {
        assertOwner();
        LOGGER.debug("{} timed out {}!", this, message);
        if (isComplete()) {
            return;
        }
        setComplete();
        this.timedOut = true;
        message.setTimedOut(true);
        if (this.request == null || this.request == message || this.currentRequest != message) {
            return;
        }
        this.request.setTimedOut(true);
    }

    public String toString() {
        char c = this.origin == Origin.LOCAL ? 'L' : 'R';
        if (this.complete.get()) {
            StringBuilder sb = new StringBuilder("Exchange[");
            sb.append(c);
            return FileInsert$$ExternalSyntheticOutline0.m(this.id, ", complete]", sb);
        }
        StringBuilder sb2 = new StringBuilder("Exchange[");
        sb2.append(c);
        return FileInsert$$ExternalSyntheticOutline0.m(this.id, "]", sb2);
    }

    public void sendReject() {
        sendReject(this.currentRequest.getSourceContext());
    }

    public Exchange(Request request, Origin origin, Executor executor) {
        this(request, origin, executor, null, false);
    }
}
