package org.eclipse.californium.core.network.deduplication;

import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import org.eclipse.californium.core.network.KeyMID;
import org.eclipse.californium.core.network.config.NetworkConfig;
import org.eclipse.californium.core.network.deduplication.SweepDeduplicator;
import org.eclipse.californium.elements.util.ClockUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public final class SweepPerPeerDeduplicator extends SweepDeduplicator {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) SweepPerPeerDeduplicator.class);
    private final ConcurrentMap<Object, Queue<KeyMID>> incomingPerPeerMessages;
    private final int messagePerPeer;

    public class SweepAlgorithm implements Runnable {
        private int lastSizeDiff;

        private SweepAlgorithm() {
        }

        private void sweep() {
            if (SweepPerPeerDeduplicator.this.incomingMessages.isEmpty()) {
                return;
            }
            long jNanoRealtime = ClockUtil.nanoRealtime();
            long nanos = jNanoRealtime - TimeUnit.MILLISECONDS.toNanos(SweepPerPeerDeduplicator.this.exchangeLifetime);
            int size = SweepPerPeerDeduplicator.this.incomingMessages.size();
            int i = 0;
            int i2 = 0;
            for (Map.Entry entry : SweepPerPeerDeduplicator.this.incomingPerPeerMessages.entrySet()) {
                Queue queue = (Queue) entry.getValue();
                if (queue.isEmpty()) {
                    SweepPerPeerDeduplicator.this.incomingPerPeerMessages.remove(entry.getKey());
                } else {
                    int size2 = queue.size() + i2;
                    while (true) {
                        KeyMID keyMID = (KeyMID) queue.peek();
                        if (keyMID == null) {
                            break;
                        }
                        SweepDeduplicator.DedupExchange dedupExchange = SweepPerPeerDeduplicator.this.incomingMessages.get(keyMID);
                        long j = dedupExchange == null ? -1L : dedupExchange.nanoTimestamp - nanos;
                        if (j < 0) {
                            if (dedupExchange != null) {
                                SweepPerPeerDeduplicator.this.incomingMessages.remove(keyMID, dedupExchange);
                                SweepPerPeerDeduplicator.LOGGER.trace("Mark-And-Sweep removes {}", keyMID);
                            } else {
                                i++;
                            }
                            SweepPerPeerDeduplicator.this.removeSame(queue, keyMID);
                        } else if (SweepPerPeerDeduplicator.LOGGER.isTraceEnabled()) {
                            SweepPerPeerDeduplicator.LOGGER.trace("Time left {}ms", Long.valueOf(j / 1000000));
                        }
                    }
                    i2 = size2;
                }
            }
            SweepPerPeerDeduplicator.LOGGER.debug("Sweep run took {}ms", Long.valueOf((ClockUtil.nanoRealtime() - jNanoRealtime) / 1000000));
            if (i > 0) {
                SweepPerPeerDeduplicator.LOGGER.warn("{} exchanges missing", Integer.valueOf(i));
            }
            int i3 = size - i2;
            if (Math.abs(this.lastSizeDiff) > 1000 && Math.abs(i3) > 1000) {
                SweepPerPeerDeduplicator.LOGGER.info("Map size {} differs from queues size {}!", Integer.valueOf(size), Integer.valueOf(i2));
            }
            this.lastSizeDiff = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SweepPerPeerDeduplicator.LOGGER.trace("Start Mark-And-Sweep with {} entries", Integer.valueOf(SweepPerPeerDeduplicator.this.incomingMessages.size()));
                sweep();
            } catch (Throwable th) {
                SweepPerPeerDeduplicator.LOGGER.warn("Exception in Mark-and-Sweep algorithm", th);
            }
        }
    }

    public SweepPerPeerDeduplicator(NetworkConfig networkConfig) {
        super(networkConfig);
        this.incomingPerPeerMessages = new ConcurrentHashMap();
        this.algorithm = new SweepAlgorithm();
        this.messagePerPeer = networkConfig.getInt("PEERS_MARK_AND_SWEEP_MESSAGES");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSame(Queue<KeyMID> queue, KeyMID keyMID) {
        Iterator<KeyMID> it = queue.iterator();
        while (it.hasNext()) {
            if (it.next() == keyMID) {
                it.remove();
                return;
            }
        }
    }

    @Override // org.eclipse.californium.core.network.deduplication.SweepDeduplicator
    public void clear() {
        super.clear();
        this.incomingPerPeerMessages.clear();
    }

    @Override // org.eclipse.californium.core.network.deduplication.SweepDeduplicator
    public void onAdd(KeyMID keyMID, boolean z) {
        Object peer = keyMID.getPeer();
        Queue<KeyMID> queuePutIfAbsent = this.incomingPerPeerMessages.get(peer);
        if (queuePutIfAbsent == null) {
            ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(this.messagePerPeer);
            arrayBlockingQueue.add(keyMID);
            queuePutIfAbsent = this.incomingPerPeerMessages.putIfAbsent(peer, arrayBlockingQueue);
            if (queuePutIfAbsent == null) {
                return;
            }
        }
        if (z) {
            queuePutIfAbsent.remove(keyMID);
        }
        while (!queuePutIfAbsent.offer(keyMID)) {
            this.incomingMessages.remove(queuePutIfAbsent.poll());
        }
    }
}
