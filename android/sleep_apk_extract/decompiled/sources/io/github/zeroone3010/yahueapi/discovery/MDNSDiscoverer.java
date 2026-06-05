package io.github.zeroone3010.yahueapi.discovery;

import com.facebook.internal.Utility;
import io.github.zeroone3010.yahueapi.HueBridge;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Supplier;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
final class MDNSDiscoverer implements HueBridgeDiscoverer {
    private static final int DISCOVERY_MESSAGE_COUNT = 5;
    private static final long MILLISECONDS_BETWEEN_DISCOVERY_MESSAGES = 950;
    private static final int PORT = 5353;
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) MDNSDiscoverer.class);
    private final Consumer<HueBridge> discoverer;
    private final InetAddress multicastAddress;
    private final DatagramPacket requestPacket;
    private ScheduledFuture requestSendTask;
    private ScheduledExecutorService scheduledExecutorService;
    private MulticastSocket socket;
    private DiscoverState state = DiscoverState.IDLE;

    public MDNSDiscoverer(Consumer<HueBridge> consumer) {
        this.discoverer = consumer;
        try {
            this.multicastAddress = InetAddress.getByName("224.0.0.251");
            this.requestPacket = createRequestPacket();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            Utf8$$ExternalSyntheticBUOutline0.m((Throwable) e);
            throw null;
        }
    }

    private DatagramPacket createRequestPacket() {
        return new DatagramPacket(new byte[]{-66, -17, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 4, 95, 104, 117, 101, 4, 95, 116, 99, 112, 5, 108, 111, 99, 97, 108, 0, 0, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 0, -1}, 33, this.multicastAddress, PORT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void lambda$discoverBridges$0() {
        try {
            startSocket();
            scheduleMessages();
            if (this.state == DiscoverState.IDLE) {
                this.state = DiscoverState.SEARCHING;
            }
            logger.info("mDNS discoverer started");
            while (this.state == DiscoverState.SEARCHING) {
                DatagramPacket datagramPacket = new DatagramPacket(new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE], Utility.DEFAULT_STREAM_BUFFER_SIZE);
                try {
                    this.socket.receive(datagramPacket);
                } catch (Exception e) {
                    if (this.state == DiscoverState.STOPPED) {
                        stop();
                        return null;
                    }
                    e.printStackTrace();
                }
                packetHandler(datagramPacket);
            }
            stop();
            return null;
        } catch (Throwable th) {
            stop();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$scheduleMessages$1() {
        for (int i = 0; i < 5; i++) {
            try {
                try {
                    logger.info("Sending a discovery message");
                    this.socket.send(this.requestPacket);
                    TimeUnit.MILLISECONDS.sleep(MILLISECONDS_BETWEEN_DISCOVERY_MESSAGES);
                } catch (MDNSException e) {
                    logger.warn(e.getMessage());
                    return;
                } catch (IOException e2) {
                    e = e2;
                    this.state = DiscoverState.CRASHED;
                    e.printStackTrace();
                    return;
                } catch (InterruptedException e3) {
                    e = e3;
                    this.state = DiscoverState.CRASHED;
                    e.printStackTrace();
                    return;
                }
            } finally {
                stop();
            }
        }
    }

    private void packetHandler(DatagramPacket datagramPacket) {
        String str = new MDNSResponseParser(datagramPacket, Arrays.asList("_hue", "_tcp", "local")).parse();
        logger.debug("Got MDNS response '{}' from '{}'", str, datagramPacket.getAddress());
        this.discoverer.accept(new HueBridge(str));
    }

    private void scheduleMessages() {
        if (this.state == DiscoverState.SEARCHING) {
            ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            this.scheduledExecutorService = scheduledExecutorServiceNewSingleThreadScheduledExecutor;
            this.requestSendTask = scheduledExecutorServiceNewSingleThreadScheduledExecutor.schedule(new Runnable() { // from class: io.github.zeroone3010.yahueapi.discovery.MDNSDiscoverer$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$scheduleMessages$1();
                }
            }, 0L, TimeUnit.MILLISECONDS);
        }
    }

    private void startSocket() {
        if (this.state == DiscoverState.IDLE) {
            try {
                MulticastSocket multicastSocket = new MulticastSocket();
                this.socket = multicastSocket;
                multicastSocket.setTimeToLive(100);
                TimeUnit.MILLISECONDS.sleep(100L);
                this.state = DiscoverState.SEARCHING;
            } catch (Exception e) {
                this.state = DiscoverState.CRASHED;
                e.printStackTrace();
            }
        }
    }

    private void stop() {
        logger.info("mDNS discoverer stopped");
        this.state = DiscoverState.STOPPED;
        ScheduledFuture scheduledFuture = this.requestSendTask;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.scheduledExecutorService.shutdown();
        }
        MulticastSocket multicastSocket = this.socket;
        if (multicastSocket != null) {
            multicastSocket.close();
        }
    }

    @Override // io.github.zeroone3010.yahueapi.discovery.HueBridgeDiscoverer
    public CompletableFuture<Void> discoverBridges() {
        return CompletableFuture.supplyAsync(new Supplier() { // from class: io.github.zeroone3010.yahueapi.discovery.MDNSDiscoverer$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.lambda$discoverBridges$0();
            }
        });
    }
}
