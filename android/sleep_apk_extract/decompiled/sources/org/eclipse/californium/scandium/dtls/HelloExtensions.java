package org.eclipse.californium.scandium.dtls;

import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.eclipse.californium.elements.util.DatagramReader;
import org.eclipse.californium.elements.util.DatagramWriter;
import org.eclipse.californium.elements.util.StringUtil;
import org.eclipse.californium.scandium.dtls.AlertMessage;
import org.eclipse.californium.scandium.dtls.HelloExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public final class HelloExtensions {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) HelloExtensions.class);
    private final List<HelloExtension> extensions;

    public HelloExtensions(List<HelloExtension> list) {
        ArrayList arrayList = new ArrayList();
        this.extensions = arrayList;
        arrayList.addAll(list);
    }

    public static HelloExtensions fromReader(DatagramReader datagramReader, InetSocketAddress inetSocketAddress) throws HandshakeException {
        try {
            ArrayList arrayList = new ArrayList();
            DatagramReader datagramReaderCreateRangeReader = datagramReader.createRangeReader(datagramReader.read(16));
            while (datagramReaderCreateRangeReader.bytesAvailable()) {
                int i = datagramReaderCreateRangeReader.read(16);
                DatagramReader datagramReaderCreateRangeReader2 = datagramReaderCreateRangeReader.createRangeReader(datagramReaderCreateRangeReader.read(16));
                HelloExtension helloExtensionFromExtensionDataReader = HelloExtension.fromExtensionDataReader(i, datagramReaderCreateRangeReader2, inetSocketAddress);
                if (datagramReaderCreateRangeReader2.bytesAvailable()) {
                    throw new HandshakeException(String.format("Too many bytes, %d left, hello extension not completely parsed! hello extension type %d", Integer.valueOf(datagramReaderCreateRangeReader2.readBytesLeft().length), Integer.valueOf(i)), new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.DECODE_ERROR, inetSocketAddress));
                }
                if (helloExtensionFromExtensionDataReader == null) {
                    LOGGER.debug("Peer included an unknown extension type code [{}] in its Hello message", Integer.valueOf(i));
                } else {
                    if (getExtension(arrayList, helloExtensionFromExtensionDataReader.getType()) != null) {
                        throw new HandshakeException("Hello message contains extension " + helloExtensionFromExtensionDataReader.getType() + " more than once!", new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.DECODE_ERROR, inetSocketAddress));
                    }
                    arrayList.add(helloExtensionFromExtensionDataReader);
                }
            }
            return new HelloExtensions(arrayList);
        } catch (IllegalArgumentException e) {
            throw new HandshakeException("Hello message contained malformed extensions, " + e.getMessage(), new AlertMessage(AlertMessage.AlertLevel.FATAL, AlertMessage.AlertDescription.DECODE_ERROR, inetSocketAddress));
        }
    }

    private static HelloExtension getExtension(List<HelloExtension> list, HelloExtension.ExtensionType extensionType) {
        if (extensionType == null) {
            return null;
        }
        for (HelloExtension helloExtension : list) {
            if (extensionType.equals(helloExtension.getType())) {
                return helloExtension;
            }
        }
        return null;
    }

    public void addExtension(HelloExtension helloExtension) {
        if (helloExtension != null) {
            if (getExtension(helloExtension.getType()) == null) {
                this.extensions.add(helloExtension);
            } else {
                Gson$$ExternalSyntheticBUOutline0.m("Hello Extension of type ", helloExtension.getType(), " already added!");
            }
        }
    }

    public List<HelloExtension> getExtensions() {
        return Collections.unmodifiableList(this.extensions);
    }

    public int getLength() {
        Iterator<HelloExtension> it = this.extensions.iterator();
        int length = 0;
        while (it.hasNext()) {
            length += it.next().getLength();
        }
        return length;
    }

    public boolean isEmpty() {
        return this.extensions.isEmpty();
    }

    public byte[] toByteArray() {
        if (this.extensions.isEmpty()) {
            return new byte[0];
        }
        DatagramWriter datagramWriter = new DatagramWriter();
        datagramWriter.write(getLength(), 16);
        Iterator<HelloExtension> it = this.extensions.iterator();
        while (it.hasNext()) {
            datagramWriter.writeBytes(it.next().toByteArray());
        }
        return datagramWriter.toByteArray();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("\t\tExtensions Length: ");
        sb.append(getLength());
        for (HelloExtension helloExtension : this.extensions) {
            sb.append(StringUtil.lineSeparator());
            sb.append(helloExtension);
        }
        return sb.toString();
    }

    public HelloExtensions() {
        this.extensions = new ArrayList();
    }

    public final HelloExtension getExtension(HelloExtension.ExtensionType extensionType) {
        return getExtension(this.extensions, extensionType);
    }
}
