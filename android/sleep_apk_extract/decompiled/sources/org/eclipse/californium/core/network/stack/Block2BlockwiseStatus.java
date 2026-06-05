package org.eclipse.californium.core.network.stack;

import java.util.Arrays;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.core.coap.BlockOption;
import org.eclipse.californium.core.coap.MessageObserverAdapter;
import org.eclipse.californium.core.coap.OptionSet;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.network.Exchange;
import org.eclipse.californium.core.observe.NotificationOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class Block2BlockwiseStatus extends BlockwiseStatus {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) Block2BlockwiseStatus.class);
    private byte[] etag;
    private NotificationOrder order;
    private Response response;

    private Block2BlockwiseStatus(int i, int i2) {
        super(i, i2);
    }

    public static final void crop(Response response, BlockOption blockOption) {
        if (response == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("response message must not be null");
            return;
        }
        if (blockOption == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("block option must not be null");
            return;
        }
        if (!response.hasBlock(blockOption)) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("given response does not contain block");
            return;
        }
        int payloadSize = response.getPayloadSize();
        int offset = blockOption.getOffset();
        int iMin = Math.min(blockOption.getSize() * (blockOption.getNum() + 1), payloadSize);
        int i = iMin - offset;
        LOGGER.debug("cropping response body [size={}] to block {}", Integer.valueOf(payloadSize), blockOption);
        byte[] bArr = new byte[i];
        response.getOptions().setBlock2(blockOption.getSzx(), iMin < payloadSize, blockOption.getNum());
        System.arraycopy(response.getPayload(), offset, bArr, 0, i);
        response.setPayload(bArr);
    }

    private static int determineResponseBlock2Szx(Exchange exchange, int i) {
        BlockOption block2;
        if (exchange.getRequest() == null || (block2 = exchange.getRequest().getOptions().getBlock2()) == null) {
            LOGGER.debug("using default preferred block size for response: {}", Integer.valueOf(i));
            return BlockOption.size2Szx(i);
        }
        LOGGER.debug("using block2 szx from early negotiation in request: {}", Integer.valueOf(block2.getSize()));
        return block2.getSzx();
    }

    public static Block2BlockwiseStatus forInboundResponse(Exchange exchange, Response response, int i) {
        int contentFormat = response.getOptions().getContentFormat();
        if (response.getOptions().hasSize2()) {
            i = response.getOptions().getSize2().intValue();
        }
        Block2BlockwiseStatus block2BlockwiseStatus = new Block2BlockwiseStatus(i, contentFormat);
        block2BlockwiseStatus.setFirst(response);
        block2BlockwiseStatus.exchange = exchange;
        Integer observe = response.getOptions().getObserve();
        if (observe != null && OptionSet.isValidObserveOption(observe.intValue())) {
            block2BlockwiseStatus.order = new NotificationOrder(observe);
            exchange.setNotificationNumber(observe.intValue());
        }
        if (response.getOptions().getETagCount() > 0) {
            block2BlockwiseStatus.etag = response.getOptions().getETags().get(0);
        }
        return block2BlockwiseStatus;
    }

    public static Block2BlockwiseStatus forOutboundResponse(Exchange exchange, Response response, int i) {
        Block2BlockwiseStatus block2BlockwiseStatus = new Block2BlockwiseStatus(response.getPayloadSize(), response.getOptions().getContentFormat());
        block2BlockwiseStatus.response = response;
        block2BlockwiseStatus.exchange = exchange;
        if (response.getPayload() != null) {
            block2BlockwiseStatus.buf.put(response.getPayload());
            block2BlockwiseStatus.buf.flip();
        }
        block2BlockwiseStatus.setCurrentSzx(determineResponseBlock2Szx(exchange, i));
        return block2BlockwiseStatus;
    }

    public static Block2BlockwiseStatus forRandomAccessRequest(Exchange exchange, Request request) {
        BlockOption block2 = request.getOptions().getBlock2();
        if (block2 == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("request must contain block2 option");
            return null;
        }
        Block2BlockwiseStatus block2BlockwiseStatus = new Block2BlockwiseStatus(0, request.getOptions().getContentFormat());
        block2BlockwiseStatus.randomAccess = true;
        block2BlockwiseStatus.exchange = exchange;
        block2BlockwiseStatus.setCurrentNum(block2.getNum());
        block2BlockwiseStatus.setCurrentSzx(block2.getSzx());
        return block2BlockwiseStatus;
    }

    public synchronized boolean addBlock(Response response) {
        if (response == null) {
            throw new NullPointerException("response block must not be null");
        }
        BlockOption block2 = response.getOptions().getBlock2();
        if (block2 == null) {
            throw new IllegalArgumentException("response block has no block2 option");
        }
        if (this.etag != null) {
            if (response.getOptions().getETagCount() != 1) {
                LOGGER.debug("response does not contain a single ETag");
                return false;
            }
            if (!Arrays.equals(this.etag, response.getOptions().getETags().get(0))) {
                LOGGER.debug("response does not contain expected ETag");
                return false;
            }
        }
        boolean zAddBlock = addBlock(response.getPayload());
        if (zAddBlock) {
            setCurrentNum(block2.getNum());
            setCurrentSzx(block2.getSzx());
        }
        return zAddBlock;
    }

    public final void completeNewTranfer(Exchange exchange) {
        Exchange exchange2;
        synchronized (this) {
            exchange2 = this.exchange;
        }
        if (exchange != exchange2) {
            if (exchange.isNotification()) {
                exchange.setComplete();
            } else {
                exchange.getRequest().setCanceled(true);
            }
        }
    }

    public final void completeOldTransfer(Exchange exchange) {
        Exchange exchange2;
        synchronized (this) {
            exchange2 = this.exchange;
            setBlockCleanupHandle(null);
            this.exchange = null;
            this.followUpEndpointContext = null;
        }
        if (exchange2 != null) {
            if (exchange == exchange2) {
                exchange2.setCurrentRequest(exchange2.getRequest());
            } else if (exchange2.isNotification()) {
                exchange2.executeComplete();
            } else {
                exchange2.getRequest().setCanceled(true);
            }
        }
    }

    public final boolean completeResponse() {
        Response response;
        synchronized (this) {
            response = this.response;
        }
        if (response == null) {
            return false;
        }
        setComplete(true);
        response.onComplete();
        return true;
    }

    public synchronized Response getNextResponseBlock() {
        final Response response;
        try {
            if (this.response == null) {
                throw new IllegalStateException("no response to track");
            }
            response = new Response(this.response.getCode());
            response.setDestinationContext(this.response.getDestinationContext());
            response.setOptions(new OptionSet(this.response.getOptions()));
            response.setMaxResourceBodySize(this.response.getMaxResourceBodySize());
            response.addMessageObservers(this.response.getMessageObservers());
            if (getCurrentNum() != 0) {
                response.getOptions().removeObserve();
            } else {
                response.addMessageObserver(new MessageObserverAdapter() { // from class: org.eclipse.californium.core.network.stack.Block2BlockwiseStatus.1
                    @Override // org.eclipse.californium.core.coap.MessageObserverAdapter, org.eclipse.californium.core.coap.MessageObserver
                    public void onReadyToSend() {
                        if (Block2BlockwiseStatus.this.response.getToken() == null) {
                            Block2BlockwiseStatus.this.response.setToken(response.getToken());
                        }
                        if (Block2BlockwiseStatus.this.response.hasMID()) {
                            return;
                        }
                        Block2BlockwiseStatus.this.response.setMID(response.getMID());
                    }
                });
                response.setType(this.response.getType());
                if (this.response.getOptions().getSize2() == null) {
                    response.getOptions().setSize2(this.response.getPayloadSize());
                }
            }
            int bufferSize = getBufferSize();
            int iSzx2Size = BlockOption.szx2Size(getCurrentSzx());
            int currentNum = getCurrentNum() * iSzx2Size;
            boolean z = false;
            if (bufferSize > 0 && currentNum < bufferSize) {
                boolean z2 = true;
                int iMin = Math.min((getCurrentNum() + 1) * iSzx2Size, bufferSize);
                int i = iMin - currentNum;
                byte[] bArr = new byte[i];
                if (iMin >= bufferSize) {
                    z2 = false;
                }
                this.buf.position(currentNum);
                this.buf.get(bArr, 0, i);
                response.setPayload(bArr);
                z = z2;
            }
            setComplete(!z);
            response.getOptions().setBlock2(getCurrentSzx(), z, getCurrentNum());
        } catch (Throwable th) {
            throw th;
        }
        return response;
    }

    public final synchronized Integer getObserve() {
        NotificationOrder notificationOrder;
        notificationOrder = this.order;
        return notificationOrder == null ? null : notificationOrder.getObserve();
    }

    public final synchronized boolean isNew(Response response) {
        if (response == null) {
            throw new NullPointerException("response block must not be null");
        }
        if (!response.getOptions().hasObserve()) {
            return false;
        }
        NotificationOrder notificationOrder = this.order;
        return notificationOrder == null || notificationOrder.isNew(response);
    }

    public final synchronized boolean matchTransfer(Exchange exchange) {
        NotificationOrder notificationOrder;
        Integer notificationNumber = exchange.getNotificationNumber();
        if (notificationNumber == null || (notificationOrder = this.order) == null) {
            return notificationNumber == null && this.order == null;
        }
        return notificationOrder.getObserve().equals(notificationNumber);
    }

    @Override // org.eclipse.californium.core.network.stack.BlockwiseStatus
    public synchronized String toString() {
        String string;
        try {
            string = super.toString();
            if (this.order != null || this.response != null) {
                StringBuilder sb = new StringBuilder(string);
                if (this.order != null) {
                    sb.setLength(string.length() - 1);
                    sb.append(", observe=");
                    sb.append(this.order.getObserve());
                    sb.append("]");
                }
                if (this.response != null) {
                    sb.append(", ");
                    sb.append(this.response);
                }
                string = sb.toString();
            }
        } catch (Throwable th) {
            throw th;
        }
        return string;
    }

    public synchronized Response getNextResponseBlock(BlockOption blockOption) {
        if (this.response != null) {
            setCurrentNum(blockOption.getNum());
            setCurrentSzx(blockOption.getSzx());
        } else {
            throw new IllegalStateException("no response to track");
        }
        return getNextResponseBlock();
    }
}
