package org.eclipse.californium.core.network;

import org.eclipse.californium.core.network.config.NetworkConfig;
import org.eclipse.californium.core.network.stack.CoapStack;

/* JADX INFO: loaded from: classes5.dex */
public interface CoapStackFactory {
    CoapStack createCoapStack(String str, NetworkConfig networkConfig, Outbox outbox, Object obj);
}
