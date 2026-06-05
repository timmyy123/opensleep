package com.spotify.protocol.client;

import com.spotify.protocol.WampClient$Receiver;
import com.spotify.protocol.WampClient$Router;
import com.spotify.protocol.WampMessage;
import com.spotify.protocol.types.Types$RequestId;
import com.spotify.protocol.types.Types$SubscriptionId;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class WampRouterImpl implements WampClient$Router {
    private final Set<WampClient$Receiver> mReceivers = Collections.newSetFromMap(new ConcurrentHashMap());

    private void routeAbort(WampMessage wampMessage) {
        Iterator<WampClient$Receiver> it = this.mReceivers.iterator();
        while (it.hasNext()) {
            it.next().onAbort(wampMessage.getObjectAt(1), wampMessage.getStringAt(2));
        }
    }

    private void routeError(WampMessage wampMessage) {
        for (WampClient$Receiver wampClient$Receiver : this.mReceivers) {
            int intAt = wampMessage.getIntAt(1);
            if (intAt == 32) {
                wampClient$Receiver.onSubscribeError(Types$RequestId.from(wampMessage.getIntAt(2)), wampMessage.getObjectAt(3), wampMessage.getStringAt(4));
            } else if (intAt == 34) {
                wampClient$Receiver.onUnubscribeError(Types$RequestId.from(wampMessage.getIntAt(2)), wampMessage.getObjectAt(3), wampMessage.getStringAt(4));
            } else if (intAt == 48) {
                wampClient$Receiver.onError(Types$RequestId.from(wampMessage.getIntAt(2)), wampMessage.getObjectAt(3), wampMessage.getStringAt(4));
            }
        }
    }

    private void routeEvent(WampMessage wampMessage) {
        Iterator<WampClient$Receiver> it = this.mReceivers.iterator();
        while (it.hasNext()) {
            it.next().onEvent(Types$SubscriptionId.from(wampMessage.getIntAt(1)), wampMessage.getIntAt(2), wampMessage.getObjectAt(5));
        }
    }

    private void routeGoodbye(WampMessage wampMessage) {
        Iterator<WampClient$Receiver> it = this.mReceivers.iterator();
        while (it.hasNext()) {
            it.next().onGoodbye(wampMessage.getObjectAt(1), wampMessage.getStringAt(2));
        }
    }

    private void routeResult(WampMessage wampMessage) {
        Iterator<WampClient$Receiver> it = this.mReceivers.iterator();
        while (it.hasNext()) {
            it.next().onResult(Types$RequestId.from(wampMessage.getIntAt(1)), wampMessage.getObjectAt(2), wampMessage.getObjectAt(3), wampMessage.getObjectAt(4));
        }
    }

    private void routeSubscribed(WampMessage wampMessage) {
        Iterator<WampClient$Receiver> it = this.mReceivers.iterator();
        while (it.hasNext()) {
            it.next().onSubscribed(Types$RequestId.from(wampMessage.getIntAt(1)), Types$SubscriptionId.from(wampMessage.getIntAt(2)));
        }
    }

    private void routeWelcome(WampMessage wampMessage) {
        Iterator<WampClient$Receiver> it = this.mReceivers.iterator();
        while (it.hasNext()) {
            it.next().onWelcome(wampMessage.getIntAt(1), wampMessage.getObjectAt(2));
        }
    }

    @Override // com.spotify.protocol.WampClient$Router
    public void addReceiver(WampClient$Receiver wampClient$Receiver) {
        this.mReceivers.add(wampClient$Receiver);
    }

    @Override // com.spotify.protocol.WampClient$Router
    public boolean route(WampMessage wampMessage) {
        int action = wampMessage.getAction();
        if (action == 2) {
            routeWelcome(wampMessage);
            return true;
        }
        if (action == 3) {
            routeAbort(wampMessage);
            return true;
        }
        if (action == 6) {
            routeGoodbye(wampMessage);
            return true;
        }
        if (action == 8) {
            routeError(wampMessage);
            return true;
        }
        if (action == 33) {
            routeSubscribed(wampMessage);
            return true;
        }
        if (action == 36) {
            routeEvent(wampMessage);
            return true;
        }
        if (action != 50) {
            return false;
        }
        routeResult(wampMessage);
        return true;
    }
}
