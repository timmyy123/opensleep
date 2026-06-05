package org.eclipse.californium.core.network.stack;

import org.eclipse.californium.core.coap.BlockOption;
import org.eclipse.californium.core.coap.OptionSet;
import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.network.Exchange;

/* JADX INFO: loaded from: classes5.dex */
public final class Block1BlockwiseStatus extends BlockwiseStatus {
    private Request request;

    private Block1BlockwiseStatus(int i, int i2) {
        super(i, i2);
    }

    public static Block1BlockwiseStatus forInboundRequest(Exchange exchange, Request request, int i) {
        int contentFormat = request.getOptions().getContentFormat();
        if (request.getOptions().hasSize1()) {
            i = request.getOptions().getSize1().intValue();
        }
        Block1BlockwiseStatus block1BlockwiseStatus = new Block1BlockwiseStatus(i, contentFormat);
        block1BlockwiseStatus.exchange = exchange;
        block1BlockwiseStatus.setFirst(request);
        return block1BlockwiseStatus;
    }

    public static Block1BlockwiseStatus forOutboundRequest(Exchange exchange, Request request, int i) {
        Block1BlockwiseStatus block1BlockwiseStatus = new Block1BlockwiseStatus(0, request.getOptions().getContentFormat());
        block1BlockwiseStatus.request = request;
        block1BlockwiseStatus.exchange = exchange;
        block1BlockwiseStatus.setCurrentSzx(BlockOption.size2Szx(i));
        return block1BlockwiseStatus;
    }

    public void cancelRequest() {
        Request request = this.request;
        if (request != null) {
            request.cancel();
        }
    }

    public synchronized Request getNextRequestBlock() {
        Request request;
        try {
            if (this.request == null) {
                throw new IllegalStateException("no request body");
            }
            int currentNum = getCurrentNum();
            int currentSzx = getCurrentSzx();
            request = new Request(this.request.getCode());
            request.setType(this.request.getType());
            request.setOptions(new OptionSet(this.request.getOptions()));
            request.addMessageObservers(this.request.getMessageObservers());
            if (currentNum == 0) {
                request.getOptions().setSize1(this.request.getPayloadSize());
            }
            if (this.request.isUnintendedPayload()) {
                request.setUnintendedPayload();
            }
            request.setMaxResourceBodySize(this.request.getMaxResourceBodySize());
            int currentSize = getCurrentSize();
            int i = currentNum * currentSize;
            int iMin = Math.min((currentNum + 1) * currentSize, this.request.getPayloadSize());
            int i2 = iMin - i;
            if (i2 > 0) {
                byte[] bArr = new byte[i2];
                System.arraycopy(this.request.getPayload(), i, bArr, 0, i2);
                request.setPayload(bArr);
            }
            boolean z = iMin < this.request.getPayloadSize();
            request.getOptions().setBlock1(currentSzx, z, currentNum);
            setComplete(!z);
        } catch (Throwable th) {
            throw th;
        }
        return request;
    }

    public boolean hasMatchingToken(Response response) {
        return this.request != null && response.getToken().equals(this.request.getToken());
    }

    public synchronized Request getNextRequestBlock(int i, int i2) {
        if (this.request != null) {
            setCurrentNum(i);
            setCurrentSzx(i2);
        } else {
            throw new IllegalStateException("no request body");
        }
        return getNextRequestBlock();
    }
}
