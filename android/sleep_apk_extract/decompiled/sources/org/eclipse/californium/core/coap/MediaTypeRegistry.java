package org.eclipse.californium.core.coap;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.compiler.core.AppFunctionXmlGenerator;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public abstract class MediaTypeRegistry {
    private static final HashMap<Integer, String[]> registry = new HashMap<>();

    static {
        add(-1, "unknown", "???");
        add(0, "text/plain", "txt");
        add(40, "application/link-format", "wlnk");
        add(41, "application/xml", AppFunctionXmlGenerator.XML_EXTENSION);
        add(42, "application/octet-stream", "bin");
        add(46, "application/xmpp+xml", "xmpp");
        add(47, "application/exi", "exi");
        add(50, "application/json", "json");
        add(60, "application/cbor", "cbor");
        add(110, "application/senml+json", "json");
        add(112, "application/senml+cbor", "cbor");
        add(11542, "application/vnd.oma.lwm2m+tlv", "tlv");
        add(11543, "application/vnd.oma.lwm2m+json", "json");
    }

    private static void add(int i, String str, String str2) {
        registry.put(Integer.valueOf(i), new String[]{str, str2});
    }

    public static String toString(int i) {
        if (i == -1) {
            return "undefined";
        }
        String[] strArr = registry.get(Integer.valueOf(i));
        return strArr != null ? strArr[0] : FileInsert$$ExternalSyntheticOutline0.m(i, "unknown/");
    }
}
