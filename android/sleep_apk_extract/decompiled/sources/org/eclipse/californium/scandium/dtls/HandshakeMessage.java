package org.eclipse.californium.scandium.dtls;

import java.net.InetSocketAddress;
import java.util.Arrays;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.elements.util.DatagramReader;
import org.eclipse.californium.elements.util.DatagramWriter;
import org.eclipse.californium.elements.util.StringUtil;
import org.eclipse.californium.scandium.dtls.AlertMessage;
import org.eclipse.californium.scandium.dtls.cipher.CipherSuite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public abstract class HandshakeMessage extends AbstractMessage {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) HandshakeMessage.class);
    private byte[] byteArray;
    private int messageSeq;
    private HandshakeMessage nextHandshakeMessage;
    private byte[] rawMessage;

    /* JADX INFO: renamed from: org.eclipse.californium.scandium.dtls.HandshakeMessage$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$eclipse$californium$scandium$dtls$HandshakeType;
        static final /* synthetic */ int[] $SwitchMap$org$eclipse$californium$scandium$dtls$cipher$CipherSuite$KeyExchangeAlgorithm;

        static {
            int[] iArr = new int[CipherSuite.KeyExchangeAlgorithm.values().length];
            $SwitchMap$org$eclipse$californium$scandium$dtls$cipher$CipherSuite$KeyExchangeAlgorithm = iArr;
            try {
                iArr[CipherSuite.KeyExchangeAlgorithm.EC_DIFFIE_HELLMAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$cipher$CipherSuite$KeyExchangeAlgorithm[CipherSuite.KeyExchangeAlgorithm.PSK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$cipher$CipherSuite$KeyExchangeAlgorithm[CipherSuite.KeyExchangeAlgorithm.ECDHE_PSK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[HandshakeType.values().length];
            $SwitchMap$org$eclipse$californium$scandium$dtls$HandshakeType = iArr2;
            try {
                iArr2[HandshakeType.HELLO_REQUEST.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$HandshakeType[HandshakeType.CLIENT_HELLO.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$HandshakeType[HandshakeType.SERVER_HELLO.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$HandshakeType[HandshakeType.HELLO_VERIFY_REQUEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$HandshakeType[HandshakeType.CERTIFICATE.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$HandshakeType[HandshakeType.SERVER_KEY_EXCHANGE.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$HandshakeType[HandshakeType.CERTIFICATE_REQUEST.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$HandshakeType[HandshakeType.SERVER_HELLO_DONE.ordinal()] = 8;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$HandshakeType[HandshakeType.CERTIFICATE_VERIFY.ordinal()] = 9;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$HandshakeType[HandshakeType.CLIENT_KEY_EXCHANGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$org$eclipse$californium$scandium$dtls$HandshakeType[HandshakeType.FINISHED.ordinal()] = 11;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    public HandshakeMessage(InetSocketAddress inetSocketAddress) {
        super(inetSocketAddress);
    }

    public static HandshakeMessage fromByteArray(byte[] bArr, InetSocketAddress inetSocketAddress) throws HandshakeException {
        InetSocketAddress inetSocketAddress2;
        HandshakeMessage handshakeMessageFromByteArray;
        HandshakeMessage fragmentedHandshakeMessage;
        try {
            int i = 0;
            DatagramReader datagramReader = new DatagramReader(bArr, false);
            HandshakeMessage handshakeMessage = null;
            HandshakeMessage handshakeMessage2 = null;
            while (true) {
                int i2 = datagramReader.read(8);
                HandshakeType typeByCode = HandshakeType.getTypeByCode(i2);
                if (typeByCode == null) {
                    throw new HandshakeException(String.format("Cannot parse unsupported message type %d", Integer.valueOf(i2)), new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.UNEXPECTED_MESSAGE, inetSocketAddress));
                }
                LOGGER.trace("Parsing HANDSHAKE message of type [{}]", typeByCode);
                int i3 = datagramReader.read(24);
                int i4 = datagramReader.read(16);
                int i5 = datagramReader.read(24);
                int i6 = datagramReader.read(24);
                int iBitsLeft = datagramReader.bitsLeft() / 8;
                if (i6 > iBitsLeft) {
                    throw new HandshakeException(String.format("Message %s fragment length %d exceeds available data %d", typeByCode, Integer.valueOf(i6), Integer.valueOf(iBitsLeft)), new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.DECODE_ERROR, inetSocketAddress));
                }
                DatagramReader datagramReaderCreateRangeReader = datagramReader.createRangeReader(i6);
                int length = bArr.length - (datagramReader.bitsLeft() / 8);
                if (i3 != i6) {
                    int i7 = i6 + i5;
                    if (i7 > i3) {
                        throw new HandshakeException(String.format("Message %s fragment %d exceeds overall length %d", typeByCode, Integer.valueOf(i7), Integer.valueOf(i3)), new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.DECODE_ERROR, inetSocketAddress));
                    }
                    inetSocketAddress2 = inetSocketAddress;
                    try {
                        fragmentedHandshakeMessage = new FragmentedHandshakeMessage(typeByCode, i3, i4, i5, datagramReaderCreateRangeReader.readBytesLeft(), inetSocketAddress2);
                    } catch (IllegalArgumentException e) {
                        e = e;
                        IllegalArgumentException illegalArgumentException = e;
                        LOGGER.debug("Handshake message from peer [{}] malformed", inetSocketAddress2, illegalArgumentException);
                        throw new HandshakeException("Handshake message malformed, " + illegalArgumentException.getMessage(), new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.DECODE_ERROR, inetSocketAddress2));
                    }
                } else {
                    inetSocketAddress2 = inetSocketAddress;
                    if (i5 != 0) {
                        throw new HandshakeException("Message " + typeByCode + " unexpected fragment offset", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.DECODE_ERROR, inetSocketAddress2));
                    }
                    try {
                        handshakeMessageFromByteArray = fromReader(typeByCode, datagramReaderCreateRangeReader, null, inetSocketAddress2);
                    } catch (MissingHandshakeParameterException unused) {
                        handshakeMessageFromByteArray = GenericHandshakeMessage.fromByteArray(typeByCode, inetSocketAddress2);
                    }
                    fragmentedHandshakeMessage = handshakeMessageFromByteArray;
                    fragmentedHandshakeMessage.rawMessage = Arrays.copyOfRange(bArr, i, length);
                    fragmentedHandshakeMessage.setMessageSeq(i4);
                }
                if (handshakeMessage == null) {
                    handshakeMessage = fragmentedHandshakeMessage;
                } else {
                    handshakeMessage2.setNextHandshakeMessage(fragmentedHandshakeMessage);
                }
                if (!datagramReader.bytesAvailable()) {
                    return handshakeMessage;
                }
                i = length;
                handshakeMessage2 = fragmentedHandshakeMessage;
                inetSocketAddress = inetSocketAddress2;
            }
        } catch (IllegalArgumentException e2) {
            e = e2;
            inetSocketAddress2 = inetSocketAddress;
        }
    }

    public static HandshakeMessage fromGenericHandshakeMessage(GenericHandshakeMessage genericHandshakeMessage, HandshakeParameter handshakeParameter) throws HandshakeException {
        InetSocketAddress peer = genericHandshakeMessage.getPeer();
        try {
            HandshakeType messageType = genericHandshakeMessage.getMessageType();
            LOGGER.trace("Parsing HANDSHAKE message of type [{}]", messageType);
            byte[] byteArray = genericHandshakeMessage.toByteArray();
            HandshakeMessage handshakeMessageFromReader = fromReader(messageType, new DatagramReader(genericHandshakeMessage.fragmentToByteArray(), false), handshakeParameter, peer);
            handshakeMessageFromReader.rawMessage = byteArray;
            handshakeMessageFromReader.setMessageSeq(genericHandshakeMessage.getMessageSeq());
            handshakeMessageFromReader.setNextHandshakeMessage(genericHandshakeMessage.getNextHandshakeMessage());
            return handshakeMessageFromReader;
        } catch (IllegalArgumentException e) {
            LOGGER.debug("Handshake message from peer [{}] malformed", peer, e);
            throw new HandshakeException("Handshake message malformed, " + e.getMessage(), new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.DECODE_ERROR, peer));
        }
    }

    private static HandshakeMessage fromReader(HandshakeType handshakeType, DatagramReader datagramReader, HandshakeParameter handshakeParameter, InetSocketAddress inetSocketAddress) throws HandshakeException {
        HandshakeMessage helloRequest;
        AnonymousClass1 anonymousClass1 = null;
        String str = "HandshakeParameter must not be null!";
        switch (AnonymousClass1.$SwitchMap$org$eclipse$californium$scandium$dtls$HandshakeType[handshakeType.ordinal()]) {
            case 1:
                helloRequest = new HelloRequest(inetSocketAddress);
                break;
            case 2:
                helloRequest = ClientHello.fromReader(datagramReader, inetSocketAddress);
                break;
            case 3:
                helloRequest = ServerHello.fromReader(datagramReader, inetSocketAddress);
                break;
            case 4:
                helloRequest = HelloVerifyRequest.fromReader(datagramReader, inetSocketAddress);
                break;
            case 5:
                if (handshakeParameter == null) {
                    throw new MissingHandshakeParameterException(str, anonymousClass1);
                }
                helloRequest = CertificateMessage.fromReader(datagramReader, handshakeParameter.getCertificateType(), inetSocketAddress);
                break;
                break;
            case 6:
                if (handshakeParameter == null) {
                    throw new MissingHandshakeParameterException(str, anonymousClass1);
                }
                helloRequest = readServerKeyExchange(datagramReader, handshakeParameter.getKeyExchangeAlgorithm(), inetSocketAddress);
                break;
                break;
            case 7:
                helloRequest = CertificateRequest.fromReader(datagramReader, inetSocketAddress);
                break;
            case 8:
                helloRequest = new ServerHelloDone(inetSocketAddress);
                break;
            case 9:
                helloRequest = CertificateVerify.fromReader(datagramReader, inetSocketAddress);
                break;
            case 10:
                if (handshakeParameter == null) {
                    throw new MissingHandshakeParameterException(str, anonymousClass1);
                }
                helloRequest = readClientKeyExchange(datagramReader, handshakeParameter.getKeyExchangeAlgorithm(), inetSocketAddress);
                break;
                break;
            case 11:
                helloRequest = Finished.fromReader(datagramReader, inetSocketAddress);
                break;
            default:
                throw new HandshakeException("Cannot parse unsupported message type " + handshakeType, new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.UNEXPECTED_MESSAGE, inetSocketAddress));
        }
        if (datagramReader.bytesAvailable()) {
            throw new HandshakeException(String.format("Too many bytes, %d left, message not completely parsed! message type %s", Integer.valueOf(datagramReader.readBytesLeft().length), handshakeType), new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.DECODE_ERROR, inetSocketAddress));
        }
        return helloRequest;
    }

    private static HandshakeMessage readClientKeyExchange(DatagramReader datagramReader, CipherSuite.KeyExchangeAlgorithm keyExchangeAlgorithm, InetSocketAddress inetSocketAddress) throws HandshakeException {
        int i = AnonymousClass1.$SwitchMap$org$eclipse$californium$scandium$dtls$cipher$CipherSuite$KeyExchangeAlgorithm[keyExchangeAlgorithm.ordinal()];
        if (i == 1) {
            return ECDHClientKeyExchange.fromReader(datagramReader, inetSocketAddress);
        }
        if (i == 2) {
            return PSKClientKeyExchange.fromReader(datagramReader, inetSocketAddress);
        }
        if (i == 3) {
            return EcdhPskClientKeyExchange.fromReader(datagramReader, inetSocketAddress);
        }
        throw new HandshakeException("Unknown key exchange algorithm", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.ILLEGAL_PARAMETER, inetSocketAddress));
    }

    private static HandshakeMessage readServerKeyExchange(DatagramReader datagramReader, CipherSuite.KeyExchangeAlgorithm keyExchangeAlgorithm, InetSocketAddress inetSocketAddress) throws HandshakeException {
        int i = AnonymousClass1.$SwitchMap$org$eclipse$californium$scandium$dtls$cipher$CipherSuite$KeyExchangeAlgorithm[keyExchangeAlgorithm.ordinal()];
        if (i == 1) {
            return EcdhEcdsaServerKeyExchange.fromReader(datagramReader, inetSocketAddress);
        }
        if (i == 2) {
            return PSKServerKeyExchange.fromReader(datagramReader, inetSocketAddress);
        }
        if (i == 3) {
            return EcdhPskServerKeyExchange.fromReader(datagramReader, inetSocketAddress);
        }
        throw new HandshakeException("Unsupported key exchange algorithm", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.ILLEGAL_PARAMETER, inetSocketAddress));
    }

    public void fragmentChanged() {
        this.byteArray = null;
    }

    public abstract byte[] fragmentToByteArray();

    @Override // org.eclipse.californium.scandium.dtls.DTLSMessage
    public final ContentType getContentType() {
        return ContentType.HANDSHAKE;
    }

    public int getFragmentLength() {
        return getMessageLength();
    }

    public int getFragmentOffset() {
        return 0;
    }

    public abstract int getMessageLength();

    public int getMessageSeq() {
        return this.messageSeq;
    }

    public abstract HandshakeType getMessageType();

    public HandshakeMessage getNextHandshakeMessage() {
        return this.nextHandshakeMessage;
    }

    public final byte[] getRawMessage() {
        return this.rawMessage;
    }

    public void setMessageSeq(int i) {
        if (this.byteArray == null) {
            this.messageSeq = i;
        } else {
            Utf8$$ExternalSyntheticBUOutline0.m$3("message is already serialized!");
        }
    }

    public void setNextHandshakeMessage(HandshakeMessage handshakeMessage) {
        this.nextHandshakeMessage = handshakeMessage;
    }

    @Override // org.eclipse.californium.scandium.dtls.DTLSMessage
    public int size() {
        return getFragmentLength() + 12;
    }

    @Override // org.eclipse.californium.scandium.dtls.DTLSMessage
    public byte[] toByteArray() {
        byte[] bArr = this.rawMessage;
        if (bArr != null) {
            return bArr;
        }
        if (this.byteArray == null) {
            DatagramWriter datagramWriter = new DatagramWriter(getFragmentLength() + 12);
            writeTo(datagramWriter);
            this.byteArray = datagramWriter.toByteArray();
        }
        return this.byteArray;
    }

    public String toString() {
        return "\tHandshake Protocol" + StringUtil.lineSeparator() + "\tType: " + getMessageType() + StringUtil.lineSeparator() + "\tPeer: " + getPeer() + StringUtil.lineSeparator() + "\tMessage Sequence No: " + this.messageSeq + StringUtil.lineSeparator() + "\tLength: " + getMessageLength() + StringUtil.lineSeparator();
    }

    public void writeTo(DatagramWriter datagramWriter) {
        datagramWriter.write(getMessageType().getCode(), 8);
        datagramWriter.write(getMessageLength(), 24);
        datagramWriter.write(this.messageSeq, 16);
        datagramWriter.write(getFragmentOffset(), 24);
        datagramWriter.write(getFragmentLength(), 24);
        datagramWriter.writeBytes(fragmentToByteArray());
    }

    public static class MissingHandshakeParameterException extends IllegalArgumentException {
        private static final long serialVersionUID = -5365688530126068164L;

        public /* synthetic */ MissingHandshakeParameterException(String str, AnonymousClass1 anonymousClass1) {
            this(str);
        }

        private MissingHandshakeParameterException(String str) {
            super(str);
        }
    }
}
