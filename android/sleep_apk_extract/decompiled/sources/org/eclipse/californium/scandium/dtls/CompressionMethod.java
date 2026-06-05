package org.eclipse.californium.scandium.dtls;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.californium.elements.util.DatagramReader;
import org.eclipse.californium.elements.util.DatagramWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public enum CompressionMethod {
    NULL(0),
    DEFLATE(1);

    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) CompressionMethod.class);
    private int code;

    CompressionMethod(int i) {
        this.code = i;
    }

    public static CompressionMethod getMethodByCode(int i) {
        if (i == 0) {
            return NULL;
        }
        if (i == 1) {
            return DEFLATE;
        }
        LOGGER.debug("Unknown compression method code: {}", Integer.valueOf(i));
        return null;
    }

    public static List<CompressionMethod> listFromReader(DatagramReader datagramReader) {
        ArrayList arrayList = new ArrayList();
        while (datagramReader.bytesAvailable()) {
            CompressionMethod methodByCode = getMethodByCode(datagramReader.read(8));
            if (methodByCode != null) {
                arrayList.add(methodByCode);
            }
        }
        return arrayList;
    }

    public static byte[] listToByteArray(List<CompressionMethod> list) {
        DatagramWriter datagramWriter = new DatagramWriter();
        Iterator<CompressionMethod> it = list.iterator();
        while (it.hasNext()) {
            datagramWriter.write(it.next().getCode(), 8);
        }
        return datagramWriter.toByteArray();
    }

    public int getCode() {
        return this.code;
    }
}
