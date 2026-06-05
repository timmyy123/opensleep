package org.eclipse.californium.scandium.dtls;

import java.net.DatagramPacket;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface RecordLayer {
    void dropReceivedRecord(Record record);

    int getMaxDatagramSize(boolean z);

    boolean isRunning();

    void processRecord(Record record, Connection connection);

    void sendFlight(List<DatagramPacket> list);
}
