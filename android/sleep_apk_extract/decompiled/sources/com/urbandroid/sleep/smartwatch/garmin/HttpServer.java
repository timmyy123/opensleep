package com.urbandroid.sleep.smartwatch.garmin;

import android.content.Context;
import com.urbandroid.common.logging.Logger;
import fi.iki.elonen.NanoHTTPD;
import java.util.Map;
import org.json.JSONException;

/* JADX INFO: loaded from: classes5.dex */
public class HttpServer extends NanoHTTPD {
    Context context;
    private final QueueToWatch queueToWatch;

    public HttpServer(int i, Context context) {
        super(i);
        this.queueToWatch = QueueToWatch.getInstance();
        this.context = context;
    }

    private String serveQueue() {
        String queueAsJsonArray = null;
        try {
            queueAsJsonArray = this.queueToWatch.getQueueAsJsonArray();
            this.queueToWatch.queueSendingViaHttpServer();
            this.queueToWatch.emptyQueue();
        } catch (JSONException e) {
            Logger.logSevere("HttpServer#serveQueue", e);
        } catch (Exception e2) {
            Logger.logSevere("HttpServer#serveQueue", e2);
        }
        Logger.logDebug("HttpServer#serveQueue: " + queueAsJsonArray);
        return queueAsJsonArray;
    }

    @Override // fi.iki.elonen.NanoHTTPD
    public NanoHTTPD.Response serve(NanoHTTPD.IHTTPSession iHTTPSession) {
        Map<String, String> parms = iHTTPSession.getParms();
        Logger.logDebug("HttpServer#params: " + parms);
        for (Map.Entry<String, String> entry : parms.entrySet()) {
            try {
                MessageHandler.getInstance().handleMessageFromWatchUsingHTTP(entry.getKey(), entry.getValue(), this.context);
            } catch (Exception e) {
                Logger.logSevere(e);
            }
        }
        return NanoHTTPD.newFixedLengthResponse(serveQueue());
    }
}
