package org.eclipse.californium.elements;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.eclipse.californium.elements.exception.EndpointMismatchException;
import org.eclipse.californium.elements.util.Bytes;
import org.eclipse.californium.elements.util.ClockUtil;
import org.eclipse.californium.elements.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class UDPConnector implements Connector {
    static final ThreadGroup ELEMENTS_THREAD_GROUP;
    public static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) UDPConnector.class);
    protected volatile InetSocketAddress effectiveAddr;
    private volatile EndpointContextMatcher endpointContextMatcher;
    protected final InetSocketAddress localAddr;
    protected boolean multicast;
    private final BlockingQueue<RawData> outgoing;
    private volatile RawDataChannel receiver;
    private boolean reuseAddress;
    protected volatile boolean running;
    private volatile DatagramSocket socket;
    private final List<Thread> receiverThreads = new LinkedList();
    private final List<Thread> senderThreads = new LinkedList();
    private int receiveBufferSize = 0;
    private int sendBufferSize = 0;
    private int senderCount = 1;
    private int receiverCount = 1;
    private int receiverPacketSize = 2048;

    public abstract class NetworkStageThread extends Thread {
        public NetworkStageThread(String str) {
            super(UDPConnector.ELEMENTS_THREAD_GROUP, str);
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            UDPConnector.LOGGER.debug("Starting network stage thread [{}]", getName());
            while (UDPConnector.this.running) {
                try {
                    work();
                    if (!UDPConnector.this.running) {
                        UDPConnector.LOGGER.debug("Network stage thread [{}] was stopped successfully", getName());
                        return;
                    }
                    continue;
                } catch (InterruptedIOException e) {
                    UDPConnector.LOGGER.trace("Network stage thread [{}] was stopped successfully at:", getName(), e);
                } catch (IOException e2) {
                    if (UDPConnector.this.running) {
                        UDPConnector.LOGGER.error("Exception in network stage thread [{}]:", getName(), e2);
                    } else {
                        UDPConnector.LOGGER.trace("Network stage thread [{}] was stopped successfully at:", getName(), e2);
                    }
                } catch (InterruptedException e3) {
                    UDPConnector.LOGGER.trace("Network stage thread [{}] was stopped successfully at:", getName(), e3);
                } catch (Throwable th) {
                    UDPConnector.LOGGER.error("Exception in network stage thread [{}]:", getName(), th);
                }
            }
        }

        public abstract void work();
    }

    public class Receiver extends NetworkStageThread {
        private DatagramPacket datagram;
        private int size;

        private Receiver(String str) {
            super(str);
            this.size = UDPConnector.this.receiverPacketSize + 1;
            int i = this.size;
            this.datagram = new DatagramPacket(new byte[i], i);
        }

        @Override // org.eclipse.californium.elements.UDPConnector.NetworkStageThread
        public void work() throws IOException {
            this.datagram.setLength(this.size);
            DatagramSocket datagramSocket = UDPConnector.this.socket;
            if (datagramSocket != null) {
                datagramSocket.receive(this.datagram);
                UDPConnector.this.processDatagram(this.datagram);
            }
        }
    }

    public class Sender extends NetworkStageThread {
        private DatagramPacket datagram;

        private Sender(String str) {
            super(str);
            this.datagram = new DatagramPacket(Bytes.EMPTY, 0);
        }

        @Override // org.eclipse.californium.elements.UDPConnector.NetworkStageThread
        public void work() {
            RawData rawData = (RawData) UDPConnector.this.outgoing.take();
            EndpointContext endpointContext = rawData.getEndpointContext();
            InetSocketAddress peerAddress = endpointContext.getPeerAddress();
            UdpEndpointContext udpEndpointContext = new UdpEndpointContext(peerAddress);
            EndpointContextMatcher endpointContextMatcher = UDPConnector.this.endpointContextMatcher;
            if (endpointContextMatcher != null && !endpointContextMatcher.isToBeSent(endpointContext, udpEndpointContext)) {
                UDPConnector.LOGGER.warn("UDPConnector ({}) drops {} bytes to {}:{}", UDPConnector.this.effectiveAddr, Integer.valueOf(this.datagram.getLength()), peerAddress.getAddress(), Integer.valueOf(peerAddress.getPort()));
                rawData.onError(new EndpointMismatchException());
                return;
            }
            this.datagram.setData(rawData.getBytes());
            this.datagram.setSocketAddress(peerAddress);
            DatagramSocket datagramSocket = UDPConnector.this.socket;
            if (datagramSocket == null) {
                rawData.onError(new IOException("socket already closed!"));
                return;
            }
            try {
                rawData.onContextEstablished(udpEndpointContext);
                datagramSocket.send(this.datagram);
                rawData.onSent();
            } catch (IOException e) {
                rawData.onError(e);
            }
            UDPConnector.LOGGER.debug("UDPConnector ({}) sent {} bytes to {}:{}", this, Integer.valueOf(this.datagram.getLength()), this.datagram.getAddress(), Integer.valueOf(this.datagram.getPort()));
        }
    }

    static {
        ThreadGroup threadGroup = new ThreadGroup("Californium/Elements");
        ELEMENTS_THREAD_GROUP = threadGroup;
        threadGroup.setDaemon(false);
    }

    public UDPConnector(InetSocketAddress inetSocketAddress) {
        if (inetSocketAddress == null) {
            this.localAddr = new InetSocketAddress(0);
        } else {
            this.localAddr = inetSocketAddress;
        }
        this.running = false;
        this.effectiveAddr = this.localAddr;
        this.outgoing = new LinkedBlockingQueue();
    }

    private void notifyMsgAsInterrupted(RawData rawData) {
        rawData.onError(new InterruptedIOException("Connector is not running."));
    }

    @Override // org.eclipse.californium.elements.Connector
    public InetSocketAddress getAddress() {
        return this.effectiveAddr;
    }

    @Override // org.eclipse.californium.elements.Connector
    public String getProtocol() {
        return "UDP";
    }

    public void init(DatagramSocket datagramSocket) throws SocketException {
        this.socket = datagramSocket;
        this.effectiveAddr = (InetSocketAddress) datagramSocket.getLocalSocketAddress();
        int i = this.receiveBufferSize;
        if (i != 0) {
            datagramSocket.setReceiveBufferSize(i);
        }
        this.receiveBufferSize = datagramSocket.getReceiveBufferSize();
        int i2 = this.sendBufferSize;
        if (i2 != 0) {
            datagramSocket.setSendBufferSize(i2);
        }
        this.sendBufferSize = datagramSocket.getSendBufferSize();
        this.running = true;
        LOGGER.info("UDPConnector starts up {} sender threads and {} receiver threads", Integer.valueOf(this.senderCount), Integer.valueOf(this.receiverCount));
        int i3 = 0;
        while (true) {
            if (i3 >= this.receiverCount) {
                break;
            }
            this.receiverThreads.add(new Receiver("UDP-Receiver-" + this.localAddr + "[" + i3 + "]"));
            i3++;
        }
        for (int i4 = 0; i4 < this.senderCount; i4++) {
            this.senderThreads.add(new Sender("UDP-Sender-" + this.localAddr + "[" + i4 + "]"));
        }
        Iterator<Thread> it = this.receiverThreads.iterator();
        while (it.hasNext()) {
            it.next().start();
        }
        Iterator<Thread> it2 = this.senderThreads.iterator();
        while (it2.hasNext()) {
            it2.next().start();
        }
        LOGGER.info("UDPConnector listening on {}, recv buf = {}, send buf = {}, recv packet size = {}", this.effectiveAddr, Integer.valueOf(this.receiveBufferSize), Integer.valueOf(this.sendBufferSize), Integer.valueOf(this.receiverPacketSize));
    }

    public void processDatagram(DatagramPacket datagramPacket) {
        RawDataChannel rawDataChannel = this.receiver;
        if (datagramPacket.getLength() > this.receiverPacketSize) {
            LOGGER.debug("UDPConnector ({}) received truncated UDP datagram from {}:{}. Maximum size allowed {}. Discarding ...", this.effectiveAddr, datagramPacket.getAddress(), Integer.valueOf(datagramPacket.getPort()), Integer.valueOf(this.receiverPacketSize));
            return;
        }
        if (rawDataChannel == null) {
            LOGGER.debug("UDPConnector ({}) received UDP datagram from {}:{} without receiver. Discarding ...", this.effectiveAddr, datagramPacket.getAddress(), Integer.valueOf(datagramPacket.getPort()));
            return;
        }
        long jNanoRealtime = ClockUtil.nanoRealtime();
        String string = StringUtil.toString(this.effectiveAddr);
        if (this.multicast) {
            string = FileInsert$$ExternalSyntheticOutline0.m("mc/", string);
        }
        LOGGER.debug("UDPConnector ({}) received {} bytes from {}:{}", string, Integer.valueOf(datagramPacket.getLength()), datagramPacket.getAddress(), Integer.valueOf(datagramPacket.getPort()));
        rawDataChannel.receiveData(RawData.inbound(Arrays.copyOfRange(datagramPacket.getData(), datagramPacket.getOffset(), datagramPacket.getLength()), new UdpEndpointContext(new InetSocketAddress(datagramPacket.getAddress(), datagramPacket.getPort())), this.multicast, jNanoRealtime));
    }

    @Override // org.eclipse.californium.elements.Connector
    public void send(RawData rawData) {
        boolean z;
        if (rawData == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Message must not be null");
            return;
        }
        synchronized (this) {
            try {
                z = this.running;
                if (z) {
                    this.outgoing.add(rawData);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            return;
        }
        notifyMsgAsInterrupted(rawData);
    }

    @Override // org.eclipse.californium.elements.Connector
    public void setEndpointContextMatcher(EndpointContextMatcher endpointContextMatcher) {
        this.endpointContextMatcher = endpointContextMatcher;
    }

    @Override // org.eclipse.californium.elements.Connector
    public void setRawDataReceiver(RawDataChannel rawDataChannel) {
        this.receiver = rawDataChannel;
    }

    public void setReceiveBufferSize(int i) {
        this.receiveBufferSize = i;
    }

    public void setReceiverPacketSize(int i) {
        this.receiverPacketSize = i;
    }

    public void setReceiverThreadCount(int i) {
        this.receiverCount = i;
    }

    public void setSendBufferSize(int i) {
        this.sendBufferSize = i;
    }

    public void setSenderThreadCount(int i) {
        this.senderCount = i;
    }

    @Override // org.eclipse.californium.elements.Connector
    public synchronized void start() {
        if (this.running) {
            return;
        }
        DatagramSocket datagramSocket = new DatagramSocket((SocketAddress) null);
        datagramSocket.setReuseAddress(this.reuseAddress);
        datagramSocket.bind(this.localAddr);
        init(datagramSocket);
    }

    @Override // org.eclipse.californium.elements.Connector
    public void stop() {
        ArrayList arrayList = new ArrayList(this.outgoing.size());
        synchronized (this) {
            try {
                if (this.running) {
                    this.running = false;
                    Iterator<Thread> it = this.senderThreads.iterator();
                    while (it.hasNext()) {
                        it.next().interrupt();
                    }
                    Iterator<Thread> it2 = this.receiverThreads.iterator();
                    while (it2.hasNext()) {
                        it2.next().interrupt();
                    }
                    this.outgoing.drainTo(arrayList);
                    if (this.socket != null) {
                        this.socket.close();
                        this.socket = null;
                    }
                    for (Thread thread : this.senderThreads) {
                        thread.interrupt();
                        try {
                            thread.join(1000L);
                        } catch (InterruptedException unused) {
                        }
                    }
                    this.senderThreads.clear();
                    for (Thread thread2 : this.receiverThreads) {
                        thread2.interrupt();
                        try {
                            thread2.join(1000L);
                        } catch (InterruptedException unused2) {
                        }
                    }
                    this.receiverThreads.clear();
                    LOGGER.info("UDPConnector on [{}] has stopped.", this.effectiveAddr);
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        notifyMsgAsInterrupted((RawData) it3.next());
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String toString() {
        return getProtocol() + "-" + StringUtil.toString(getAddress());
    }
}
