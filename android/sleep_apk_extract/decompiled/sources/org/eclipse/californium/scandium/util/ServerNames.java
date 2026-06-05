package org.eclipse.californium.scandium.util;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.elements.util.DatagramReader;
import org.eclipse.californium.elements.util.DatagramWriter;
import org.eclipse.californium.scandium.util.ServerName;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class ServerNames implements Iterable<ServerName> {
    int encodedLength;
    private final Set<ServerName> names;

    /* JADX INFO: renamed from: org.eclipse.californium.scandium.util.ServerNames$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$eclipse$californium$scandium$util$ServerName$NameType;

        static {
            int[] iArr = new int[ServerName.NameType.values().length];
            $SwitchMap$org$eclipse$californium$scandium$util$ServerName$NameType = iArr;
            try {
                iArr[ServerName.NameType.HOST_NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private ServerNames() {
        this.names = new LinkedHashSet();
    }

    public static ServerNames newInstance(ServerName serverName) {
        if (serverName != null) {
            return new ServerNames(serverName);
        }
        Types$$ExternalSyntheticBUOutline0.m$1("server name must not be null");
        return null;
    }

    private static byte[] readHostName(DatagramReader datagramReader) {
        if (datagramReader.bitsLeft() >= 16) {
            int i = datagramReader.read(16);
            if (datagramReader.bytesAvailable(i)) {
                return datagramReader.readBytes(i);
            }
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("ServerNames: no hostname found!");
        return null;
    }

    public ServerNames add(ServerName serverName) {
        if (serverName == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("server name must not be null");
            return null;
        }
        if (this.names.contains(serverName)) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("there already is a name of the given type");
            return null;
        }
        this.names.add(serverName);
        int i = this.encodedLength + 3;
        this.encodedLength = i;
        this.encodedLength = i + serverName.getName().length;
        return this;
    }

    public void decode(DatagramReader datagramReader) {
        DatagramReader datagramReaderCreateRangeReader = datagramReader.createRangeReader(datagramReader.read(16));
        while (datagramReaderCreateRangeReader.bytesAvailable()) {
            ServerName.NameType nameTypeFromCode = ServerName.NameType.fromCode(datagramReaderCreateRangeReader.readNextByte());
            if (AnonymousClass1.$SwitchMap$org$eclipse$californium$scandium$util$ServerName$NameType[nameTypeFromCode.ordinal()] != 1) {
                throw new IllegalArgumentException("ServerNames: unknown name_type!", new IllegalArgumentException(nameTypeFromCode.name()));
            }
            add(ServerName.from(nameTypeFromCode, readHostName(datagramReaderCreateRangeReader)));
        }
    }

    public void encode(DatagramWriter datagramWriter) {
        datagramWriter.write(this.encodedLength, 16);
        for (ServerName serverName : this.names) {
            datagramWriter.writeByte(serverName.getType().getCode());
            datagramWriter.write(serverName.getName().length, 16);
            datagramWriter.writeBytes(serverName.getName());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ServerNames.class != obj.getClass()) {
            return false;
        }
        ServerNames serverNames = (ServerNames) obj;
        return this.names.size() == serverNames.names.size() && this.names.containsAll(serverNames.names);
    }

    public int getEncodedLength() {
        return this.encodedLength;
    }

    public ServerName getServerName(ServerName.NameType nameType) {
        for (ServerName serverName : this.names) {
            if (serverName.getType().equals(nameType)) {
                return serverName;
            }
        }
        return null;
    }

    public int hashCode() {
        Iterator<ServerName> it = this.names.iterator();
        int iHashCode = 1;
        while (it.hasNext()) {
            iHashCode = (iHashCode * 31) + it.next().hashCode();
        }
        return iHashCode;
    }

    @Override // java.lang.Iterable
    public Iterator<ServerName> iterator() {
        return this.names.iterator();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ServerNames[");
        Iterator<ServerName> it = this.names.iterator();
        while (it.hasNext()) {
            sb.append(it.next().getNameAsString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private ServerNames(ServerName serverName) {
        this();
        add(serverName);
    }

    public static ServerNames newInstance() {
        return new ServerNames();
    }
}
