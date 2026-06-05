package org.eclipse.californium.scandium.dtls;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.net.DatagramPacket;
import java.net.InetSocketAddress;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.elements.util.Bytes;
import org.eclipse.californium.elements.util.DatagramWriter;
import org.eclipse.californium.scandium.dtls.AlertMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class DTLSFlight {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) DTLSFlight.class);
    private final List<EpochMessage> dtlsMessages;
    private int effectiveDatagramSize;
    private final int flightNumber;
    private int maxDatagramSize;
    private int maxFragmentSize;
    private int multiEpoch;
    private MultiHandshakeMessage multiHandshakeMessage;
    private boolean multiUseCid;
    private final List<Record> records;
    private volatile boolean responseCompleted;
    private volatile boolean responseStarted;
    private boolean retransmissionNeeded;
    private final DTLSSession session;
    private int timeout = 0;
    private ScheduledFuture<?> timeoutTask;
    private int tries;
    private boolean useMultiHandshakeMessageRecords;

    /* JADX INFO: renamed from: org.eclipse.californium.scandium.dtls.DTLSFlight$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$eclipse$californium$scandium$dtls$ContentType;

        static {
            int[] iArr = new int[ContentType.values().length];
            $SwitchMap$org$eclipse$californium$scandium$dtls$ContentType = iArr;
            try {
                iArr[ContentType.HANDSHAKE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$ContentType[ContentType.CHANGE_CIPHER_SPEC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public DTLSFlight(DTLSSession dTLSSession, int i) {
        this.retransmissionNeeded = false;
        if (dTLSSession == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Session must not be null");
            throw null;
        }
        if (dTLSSession.getPeer() == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Peer address must not be null");
            throw null;
        }
        this.session = dTLSSession;
        this.records = new ArrayList();
        this.dtlsMessages = new ArrayList();
        this.retransmissionNeeded = true;
        this.flightNumber = i;
    }

    private final void cancelTimeout() {
        ScheduledFuture<?> scheduledFuture = this.timeoutTask;
        if (scheduledFuture != null) {
            if (!scheduledFuture.isDone()) {
                this.timeoutTask.cancel(true);
            }
            this.timeoutTask = null;
        }
    }

    private void flushMultiHandshakeMessages() {
        if (this.multiHandshakeMessage != null) {
            List<Record> list = this.records;
            ContentType contentType = ContentType.HANDSHAKE;
            int i = this.multiEpoch;
            list.add(new Record(contentType, i, this.session.getSequenceNumber(i), this.multiHandshakeMessage, this.session, this.multiUseCid, 0));
            int numberOfHandshakeMessages = this.multiHandshakeMessage.getNumberOfHandshakeMessages();
            int i2 = this.multiEpoch;
            if (numberOfHandshakeMessages > 1) {
                LOGGER.info("Add {} multi handshake message, epoch {} of {} bytes for [{}]", Integer.valueOf(numberOfHandshakeMessages), Integer.valueOf(i2), Integer.valueOf(this.multiHandshakeMessage.getMessageLength()), this.multiHandshakeMessage.getPeer());
            } else {
                LOGGER.debug("Add {} multi handshake message, epoch {} of {} bytes for [{}]", Integer.valueOf(numberOfHandshakeMessages), Integer.valueOf(i2), Integer.valueOf(this.multiHandshakeMessage.getMessageLength()), this.multiHandshakeMessage.getPeer());
            }
            this.multiHandshakeMessage = null;
            this.multiEpoch = 0;
            this.multiUseCid = false;
        }
    }

    public static int incrementTimeout(int i) {
        if (i >= 60000 || (i = i * 2) <= 60000) {
            return i;
        }
        return 60000;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0038 A[PHI: r2
      0x0038: PHI (r2v2 int) = (r2v1 int), (r2v24 int), (r2v24 int) binds: [B:3:0x0018, B:5:0x0027, B:7:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void wrapHandshakeMessage(EpochMessage epochMessage) {
        boolean z;
        HandshakeMessage handshakeMessage = (HandshakeMessage) epochMessage.message;
        int messageLength = handshakeMessage.getMessageLength();
        int maxCiphertextExpansion = this.maxDatagramSize - 25;
        int i = this.maxFragmentSize;
        if (epochMessage.epoch > 0) {
            maxCiphertextExpansion -= this.session.getMaxCiphertextExpansion();
            ConnectionId writeConnectionId = this.session.getWriteConnectionId();
            if (writeConnectionId == null || writeConnectionId.isEmpty()) {
                z = false;
            } else {
                maxCiphertextExpansion -= writeConnectionId.length() + 1;
                z = true;
            }
        }
        if (i > maxCiphertextExpansion) {
            i = maxCiphertextExpansion;
        } else {
            this.effectiveDatagramSize = (this.maxDatagramSize - maxCiphertextExpansion) + i;
        }
        if (messageLength > i) {
            flushMultiHandshakeMessages();
            LOGGER.debug("Splitting up {} message of {} bytes for [{}] into multiple fragments of max. {} bytes", handshakeMessage.getMessageType(), Integer.valueOf(messageLength), handshakeMessage.getPeer(), Integer.valueOf(i));
            byte[] bArrFragmentToByteArray = handshakeMessage.fragmentToByteArray();
            if (bArrFragmentToByteArray.length != messageLength) {
                Utf8$$ExternalSyntheticBUOutline0.m$3(FileInsert$$ExternalSyntheticOutline0.m(bArrFragmentToByteArray.length, "!", Fragment$$ExternalSyntheticOutline1.m65m(messageLength, "message length ", " differs from message ")));
                return;
            }
            int messageSeq = handshakeMessage.getMessageSeq();
            int i2 = 0;
            while (i2 < messageLength) {
                int i3 = i2 + i > messageLength ? messageLength - i2 : i;
                byte[] bArr = new byte[i3];
                System.arraycopy(bArrFragmentToByteArray, i2, bArr, 0, i3);
                int i4 = messageLength;
                FragmentedHandshakeMessage fragmentedHandshakeMessage = new FragmentedHandshakeMessage(handshakeMessage.getMessageType(), i4, messageSeq, i2, bArr, this.session.getPeer());
                LOGGER.debug("fragment for offset {}, {} bytes", Integer.valueOf(i2), Integer.valueOf(fragmentedHandshakeMessage.size()));
                i2 += i3;
                this.records.add(new Record(ContentType.HANDSHAKE, epochMessage.epoch, this.session.getSequenceNumber(epochMessage.epoch), (DTLSMessage) fragmentedHandshakeMessage, this.session, false, 0));
                messageLength = i4;
            }
            return;
        }
        if (this.useMultiHandshakeMessageRecords) {
            if (this.multiHandshakeMessage != null) {
                if (this.multiEpoch == epochMessage.epoch && this.multiUseCid == z) {
                    if (handshakeMessage.size() + this.multiHandshakeMessage.getMessageLength() < i) {
                        this.multiHandshakeMessage.add(handshakeMessage);
                        LOGGER.debug("Add multi-handshake-message {} message of {} bytes for [{}]", handshakeMessage.getMessageType(), Integer.valueOf(messageLength), handshakeMessage.getPeer());
                        return;
                    }
                }
                flushMultiHandshakeMessages();
            }
            if (this.multiHandshakeMessage == null && messageLength + 12 < i) {
                MultiHandshakeMessage multiHandshakeMessage = new MultiHandshakeMessage(this.session.getPeer());
                this.multiHandshakeMessage = multiHandshakeMessage;
                multiHandshakeMessage.add(handshakeMessage);
                this.multiEpoch = epochMessage.epoch;
                this.multiUseCid = z;
                LOGGER.debug("Start multi-handshake-message with {} message of {} bytes for [{}]", handshakeMessage.getMessageType(), Integer.valueOf(messageLength), handshakeMessage.getPeer());
                return;
            }
        }
        this.records.add(new Record(ContentType.HANDSHAKE, epochMessage.epoch, this.session.getSequenceNumber(epochMessage.epoch), handshakeMessage, this.session, z, 0));
        LOGGER.debug("Add {} message of {} bytes for [{}]", handshakeMessage.getMessageType(), Integer.valueOf(messageLength), handshakeMessage.getPeer());
    }

    public void addDtlsMessage(int i, DTLSMessage dTLSMessage) {
        if (dTLSMessage != null) {
            this.dtlsMessages.add(new EpochMessage(i, dTLSMessage, null));
        } else {
            Types$$ExternalSyntheticBUOutline0.m$1("message must not be null!");
        }
    }

    public boolean contains(DTLSMessage dTLSMessage) {
        Iterator<EpochMessage> it = this.dtlsMessages.iterator();
        while (it.hasNext()) {
            if (Arrays.equals(dTLSMessage.toByteArray(), it.next().message.toByteArray())) {
                return true;
            }
        }
        return false;
    }

    public List<DatagramPacket> getDatagrams(int i, int i2, Boolean bool, Boolean bool2, boolean z) {
        int iMin = i;
        DatagramWriter datagramWriter = new DatagramWriter(iMin);
        ArrayList arrayList = new ArrayList();
        boolean zEquals = Boolean.TRUE.equals(bool);
        boolean zEquals2 = Boolean.FALSE.equals(bool2);
        boolean z2 = !zEquals2;
        if (z) {
            iMin = Math.min(512, iMin);
        }
        Logger logger = LOGGER;
        logger.info("Prepare flight {}, using max. datagram size {}, max. fragment size {} [mhm={}, mr={}]", Integer.valueOf(this.flightNumber), Integer.valueOf(iMin), Integer.valueOf(i2), Boolean.valueOf(zEquals), Boolean.valueOf(z2));
        InetSocketAddress peer = this.session.getPeer();
        List<Record> records = getRecords(iMin, i2, zEquals);
        logger.info("Effective max. datagram size {}", Integer.valueOf(this.effectiveDatagramSize));
        int i3 = 0;
        while (i3 < records.size()) {
            Record record = records.get(i3);
            byte[] byteArray = record.toByteArray();
            if (byteArray.length > this.effectiveDatagramSize) {
                LOGGER.error("{} record of {} bytes for peer [{}] exceeds max. datagram size [{}], discarding...", record.getType(), Integer.valueOf(byteArray.length), peer, Integer.valueOf(this.effectiveDatagramSize));
            } else {
                Logger logger2 = LOGGER;
                logger2.trace("Sending record of {} bytes to peer [{}]:\n{}", Integer.valueOf(byteArray.length), peer, record);
                if (!zEquals2 && record.getType() == ContentType.CHANGE_CIPHER_SPEC && (i3 = i3 + 1) < records.size()) {
                    byteArray = Bytes.concatenate(byteArray, records.get(i3).toByteArray());
                }
                if (datagramWriter.size() > ((zEquals2 || (z && bool2 == null)) ? 0 : this.effectiveDatagramSize - byteArray.length)) {
                    byte[] byteArray2 = datagramWriter.toByteArray();
                    arrayList.add(new DatagramPacket(byteArray2, byteArray2.length, peer.getAddress(), peer.getPort()));
                    logger2.debug("Sending datagram of {} bytes to peer [{}]", Integer.valueOf(byteArray2.length), peer);
                }
                datagramWriter.writeBytes(byteArray);
            }
            i3++;
        }
        byte[] byteArray3 = datagramWriter.toByteArray();
        arrayList.add(new DatagramPacket(byteArray3, byteArray3.length, peer.getAddress(), peer.getPort()));
        LOGGER.debug("Sending datagram of {} bytes to peer [{}]", Integer.valueOf(byteArray3.length), peer);
        return arrayList;
    }

    public int getFlightNumber() {
        return this.flightNumber;
    }

    public int getNumberOfMessages() {
        return this.dtlsMessages.size();
    }

    public List<Record> getRecords(int i, int i2, boolean z) throws HandshakeException {
        try {
            if (this.maxDatagramSize == i && this.maxFragmentSize == i2 && this.useMultiHandshakeMessageRecords == z) {
                for (int i3 = 0; i3 < this.records.size(); i3++) {
                    Record record = this.records.get(i3);
                    int epoch = record.getEpoch();
                    this.records.set(i3, new Record(record.getType(), epoch, this.session.getSequenceNumber(epoch), record.getFragment(), this.session, record.useConnectionId(), 0));
                }
            } else {
                this.effectiveDatagramSize = i;
                this.maxDatagramSize = i;
                this.maxFragmentSize = i2;
                this.useMultiHandshakeMessageRecords = z;
                this.records.clear();
                Iterator<EpochMessage> it = this.dtlsMessages.iterator();
                while (it.hasNext()) {
                    wrapMessage(it.next());
                }
                flushMultiHandshakeMessages();
            }
            return this.records;
        } catch (GeneralSecurityException e) {
            this.records.clear();
            throw new HandshakeException("Cannot create record", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.INTERNAL_ERROR, this.session.getPeer()), e);
        }
    }

    public int getTimeout() {
        return this.timeout;
    }

    public int getTries() {
        return this.tries;
    }

    public void incrementTries() {
        this.tries++;
    }

    public boolean isResponseCompleted() {
        return this.responseCompleted;
    }

    public boolean isResponseStarted() {
        return this.responseStarted;
    }

    public boolean isRetransmissionNeeded() {
        return this.retransmissionNeeded;
    }

    public void scheduleRetransmission(ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
        if (this.responseCompleted) {
            return;
        }
        if (!isRetransmissionNeeded()) {
            LOGGER.trace("handshake flight to peer {}, no retransmission!", this.session.getPeer());
            return;
        }
        cancelTimeout();
        try {
            this.timeoutTask = scheduledExecutorService.schedule(runnable, this.timeout, TimeUnit.MILLISECONDS);
            LOGGER.trace("handshake flight to peer {}, retransmission {} ms.", this.session.getPeer(), Integer.valueOf(this.timeout));
        } catch (RejectedExecutionException unused) {
            LOGGER.trace("handshake flight stopped by shutdown.");
        }
    }

    public void setResponseCompleted() {
        this.responseCompleted = true;
        cancelTimeout();
    }

    public void setResponseStarted() {
        this.responseStarted = true;
    }

    public void setRetransmissionNeeded(boolean z) {
        this.retransmissionNeeded = z;
    }

    public void setTimeout(int i) {
        this.timeout = i;
    }

    public final void wrapMessage(EpochMessage epochMessage) throws HandshakeException {
        try {
            DTLSMessage dTLSMessage = epochMessage.message;
            int i = AnonymousClass1.$SwitchMap$org$eclipse$californium$scandium$dtls$ContentType[dTLSMessage.getContentType().ordinal()];
            if (i == 1) {
                wrapHandshakeMessage(epochMessage);
                return;
            }
            if (i == 2) {
                flushMultiHandshakeMessages();
                this.records.add(new Record(dTLSMessage.getContentType(), epochMessage.epoch, this.session.getSequenceNumber(epochMessage.epoch), dTLSMessage, this.session, false, 0));
                LOGGER.debug("Add CCS message of {} bytes for [{}]", Integer.valueOf(dTLSMessage.size()), dTLSMessage.getPeer());
            } else {
                throw new HandshakeException("Cannot create " + dTLSMessage.getContentType() + " record for flight", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.INTERNAL_ERROR, this.session.getPeer()));
            }
        } catch (GeneralSecurityException e) {
            throw new HandshakeException("Cannot create record", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.INTERNAL_ERROR, this.session.getPeer()), e);
        }
    }

    public void incrementTimeout() {
        this.timeout = incrementTimeout(this.timeout);
    }

    public static class EpochMessage {
        private final int epoch;
        private final DTLSMessage message;

        private EpochMessage(int i, DTLSMessage dTLSMessage) {
            this.epoch = i;
            this.message = dTLSMessage;
        }

        public /* synthetic */ EpochMessage(int i, DTLSMessage dTLSMessage, AnonymousClass1 anonymousClass1) {
            this(i, dTLSMessage);
        }
    }
}
