package org.eclipse.paho.client.mqttv3.internal.websocket;

import adamb.ogg.OggIO$$ExternalSyntheticBUOutline0;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class WebSocketHandshake {
    private static final String ACCEPT_SALT = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    private static final String EMPTY = "";
    private static final String HTTP_HEADER_CONNECTION = "connection";
    private static final String HTTP_HEADER_CONNECTION_VALUE = "upgrade";
    private static final String HTTP_HEADER_SEC_WEBSOCKET_ACCEPT = "sec-websocket-accept";
    private static final String HTTP_HEADER_SEC_WEBSOCKET_PROTOCOL = "sec-websocket-protocol";
    private static final String HTTP_HEADER_UPGRADE = "upgrade";
    private static final String HTTP_HEADER_UPGRADE_WEBSOCKET = "websocket";
    private static final String LINE_SEPARATOR = "\r\n";
    private static final String SHA1_PROTOCOL = "SHA1";
    String host;
    InputStream input;
    OutputStream output;
    int port;
    String uri;

    public WebSocketHandshake(InputStream inputStream, OutputStream outputStream, String str, String str2, int i) {
        this.input = inputStream;
        this.output = outputStream;
        this.uri = str;
        this.host = str2;
        this.port = i;
    }

    private Map getHeaders(ArrayList arrayList) {
        HashMap map = new HashMap();
        for (int i = 1; i < arrayList.size(); i++) {
            String[] strArrSplit = ((String) arrayList.get(i)).split(":");
            map.put(strArrSplit[0].toLowerCase(), strArrSplit[1]);
        }
        return map;
    }

    private void receiveHandshakeResponse(String str) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.input));
        ArrayList arrayList = new ArrayList();
        String line = bufferedReader.readLine();
        if (line == null) {
            OggIO$$ExternalSyntheticBUOutline0.m("WebSocket Response header: Invalid response from Server, It may not support WebSockets.");
            return;
        }
        while (!line.equals("")) {
            arrayList.add(line);
            line = bufferedReader.readLine();
        }
        Map headers = getHeaders(arrayList);
        String str2 = (String) headers.get(HTTP_HEADER_CONNECTION);
        if (str2 == null || str2.equalsIgnoreCase("upgrade")) {
            OggIO$$ExternalSyntheticBUOutline0.m("WebSocket Response header: Incorrect connection header");
            return;
        }
        if (!((String) headers.get("upgrade")).toLowerCase().contains(HTTP_HEADER_UPGRADE_WEBSOCKET)) {
            OggIO$$ExternalSyntheticBUOutline0.m("WebSocket Response header: Incorrect upgrade.");
            return;
        }
        if (((String) headers.get(HTTP_HEADER_SEC_WEBSOCKET_PROTOCOL)) == null) {
            OggIO$$ExternalSyntheticBUOutline0.m("WebSocket Response header: empty sec-websocket-protocol");
            return;
        }
        if (!headers.containsKey(HTTP_HEADER_SEC_WEBSOCKET_ACCEPT)) {
            OggIO$$ExternalSyntheticBUOutline0.m("WebSocket Response header: Missing Sec-WebSocket-Accept");
            return;
        }
        try {
            verifyWebSocketKey(str, (String) headers.get(HTTP_HEADER_SEC_WEBSOCKET_ACCEPT));
        } catch (NoSuchAlgorithmException e) {
            OggIO$$ExternalSyntheticBUOutline0.m(e.getMessage());
        } catch (HandshakeFailedException unused) {
            OggIO$$ExternalSyntheticBUOutline0.m("WebSocket Response header: Incorrect Sec-WebSocket-Key");
        }
    }

    private void sendHandshakeRequest(String str) {
        try {
            String rawPath = "/mqtt";
            URI uri = new URI(this.uri);
            if (uri.getRawPath() != null && !uri.getRawPath().isEmpty()) {
                rawPath = uri.getRawPath();
                if (uri.getRawQuery() != null && !uri.getRawQuery().isEmpty()) {
                    StringBuffer stringBuffer = new StringBuffer(String.valueOf(rawPath));
                    stringBuffer.append("?");
                    stringBuffer.append(uri.getRawQuery());
                    rawPath = stringBuffer.toString();
                }
            }
            PrintWriter printWriter = new PrintWriter(this.output);
            StringBuffer stringBuffer2 = new StringBuffer("GET ");
            stringBuffer2.append(rawPath);
            stringBuffer2.append(" HTTP/1.1\r\n");
            printWriter.print(stringBuffer2.toString());
            StringBuffer stringBuffer3 = new StringBuffer("Host: ");
            stringBuffer3.append(this.host);
            stringBuffer3.append(":");
            stringBuffer3.append(this.port);
            stringBuffer3.append(LINE_SEPARATOR);
            printWriter.print(stringBuffer3.toString());
            printWriter.print("Upgrade: websocket\r\n");
            printWriter.print("Connection: Upgrade\r\n");
            StringBuffer stringBuffer4 = new StringBuffer("Sec-WebSocket-Key: ");
            stringBuffer4.append(str);
            stringBuffer4.append(LINE_SEPARATOR);
            printWriter.print(stringBuffer4.toString());
            printWriter.print("Sec-WebSocket-Protocol: mqttv3.1\r\n");
            printWriter.print("Sec-WebSocket-Version: 13\r\n");
            printWriter.print(LINE_SEPARATOR);
            printWriter.flush();
        } catch (URISyntaxException e) {
            Events$$ExternalSyntheticBUOutline0.m(e);
        }
    }

    private byte[] sha1(String str) {
        return MessageDigest.getInstance(SHA1_PROTOCOL).digest(str.getBytes());
    }

    private void verifyWebSocketKey(String str, String str2) throws HandshakeFailedException {
        String strTrim = Base64.encodeBytes(sha1(String.valueOf(str).concat(ACCEPT_SALT))).trim();
        if (!strTrim.equals(strTrim)) {
            throw new HandshakeFailedException();
        }
    }

    public void execute() throws IOException {
        StringBuffer stringBuffer = new StringBuffer("mqtt-");
        stringBuffer.append(System.currentTimeMillis() / 1000);
        String strEncode = Base64.encode(stringBuffer.toString());
        sendHandshakeRequest(strEncode);
        receiveHandshakeResponse(strEncode);
    }
}
