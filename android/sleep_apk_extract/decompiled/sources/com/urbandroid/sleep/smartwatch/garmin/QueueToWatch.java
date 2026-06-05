package com.urbandroid.sleep.smartwatch.garmin;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Handler;
import com.garmin.android.connectiq.ConnectIQ;
import com.garmin.android.connectiq.IQApp;
import com.garmin.android.connectiq.IQDevice;
import com.garmin.android.connectiq.exception.InvalidStateException;
import com.garmin.android.connectiq.exception.ServiceUnavailableException;
import com.urbandroid.common.logging.Logger;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class QueueToWatch {
    private static final QueueToWatch ourInstance = new QueueToWatch();
    private List<MessageToWatch> messageQueue = Collections.synchronizedList(new LinkedList());
    private Handler handler = new Handler();
    private int deliveryErrorCount = 0;
    private int deliveryInProgressCount = 0;
    private AtomicBoolean deliveryInProgress = new AtomicBoolean(false);
    private Runnable sendMessageRunnable = new Runnable() { // from class: com.urbandroid.sleep.smartwatch.garmin.QueueToWatch.1
        @Override // java.lang.Runnable
        public void run() {
            QueueToWatch.this.sendNextMessage();
        }
    };

    private QueueToWatch() {
    }

    private void clear() {
        this.messageQueue.clear();
    }

    private void doSendMessage(final MessageToWatch messageToWatch) {
        Logger.logDebug("QueueToWatch: doSendMessage");
        try {
            CIQManager.getInstance().sendMessageToWatch(messageToWatch.toString(), new ConnectIQ.IQSendMessageListener() { // from class: com.urbandroid.sleep.smartwatch.garmin.QueueToWatch.2
                @Override // com.garmin.android.connectiq.ConnectIQ.IQSendMessageListener
                public void onMessageStatus(IQDevice iQDevice, IQApp iQApp, ConnectIQ.IQMessageStatus iQMessageStatus) {
                    Logger.logDebug("QueueToWatch: doSendMessage to watch, status " + iQMessageStatus + ", " + messageToWatch);
                    ConnectIQ.IQMessageStatus iQMessageStatus2 = ConnectIQ.IQMessageStatus.SUCCESS;
                    QueueToWatch queueToWatch = QueueToWatch.this;
                    if (iQMessageStatus != iQMessageStatus2) {
                        queueToWatch.deliveryErrorCount++;
                    } else {
                        queueToWatch.remove(messageToWatch);
                        QueueToWatch.this.messageSentSuccessfullyCallback(messageToWatch);
                        QueueToWatch.this.deliveryErrorCount = 0;
                    }
                    QueueToWatch.this.deliveryInProgress.set(false);
                    if (QueueToWatch.this.size() > 0) {
                        QueueToWatch.this.handler.removeCallbacks(QueueToWatch.this.sendMessageRunnable);
                        QueueToWatch.this.handler.postDelayed(QueueToWatch.this.sendMessageRunnable, QueueToWatch.this.size() > 10 ? 1000L : 3000L);
                    }
                }
            });
        } catch (InvalidStateException e) {
            Logger.logDebug("QueueToWatch: ", e);
        } catch (ServiceUnavailableException e2) {
            Logger.logDebug("QueueToWatch: ", e2);
        }
    }

    public static QueueToWatch getInstance() {
        return ourInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void messageSentSuccessfullyCallback(final MessageToWatch messageToWatch) {
        this.handler.postDelayed(new Runnable() { // from class: com.urbandroid.sleep.smartwatch.garmin.QueueToWatch.3
            @Override // java.lang.Runnable
            public void run() {
                if (messageToWatch.equals(new MessageToWatch("StopApp"))) {
                    ServiceRecoveryManager.getInstance().stopSelfAndDontScheduleRecovery("Cannot deliver StopApp");
                }
            }
        }, 3500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendNextMessage() {
        if (!CIQManager.getInstance().connectIqReady.booleanValue()) {
            this.handler.removeCallbacks(this.sendMessageRunnable);
            this.handler.postDelayed(this.sendMessageRunnable, 3000L);
            return;
        }
        getInstance().logQueue();
        Logger.logDebug("QueueToWatch: sendNextMessage, deliveryErrorCount: " + this.deliveryErrorCount + " delivery in progress " + this.deliveryInProgress.get());
        if (this.deliveryErrorCount > 5) {
            this.handler.removeCallbacks(this.sendMessageRunnable);
            this.deliveryErrorCount = 0;
            if (next() == null || !next().equals(new MessageToWatch("StopApp"))) {
                Logger.logSevere("App went bust. FAILURE_DURING_TRANSFER. No reason to go on like this.");
                return;
            } else {
                ServiceRecoveryManager.getInstance().stopSelfAndDontScheduleRecovery("over max delivery error");
                return;
            }
        }
        if (size() >= 1 && !this.deliveryInProgress.get()) {
            MessageToWatch next = next();
            if (next == null) {
                return;
            }
            Logger.logDebug("QueueToWatch: sendNextMessage: " + next.toString());
            this.deliveryInProgress.set(true);
            this.handler.removeCallbacks(this.sendMessageRunnable);
            this.handler.postDelayed(this.sendMessageRunnable, 20000L);
            doSendMessage(next);
            return;
        }
        if (size() > 0 && this.messageQueue.get(0).equals(new MessageToWatch("StopApp"))) {
            ServiceRecoveryManager.getInstance().stopSelfAndDontScheduleRecovery("Stuck while sending StopApp, watch app probably not running");
        }
        if (this.deliveryInProgress.get()) {
            int i = this.deliveryInProgressCount + 1;
            this.deliveryInProgressCount = i;
            if (i > 5) {
                this.deliveryInProgressCount = 0;
                this.deliveryInProgress.set(false);
                this.handler.removeCallbacks(this.sendMessageRunnable);
                this.handler.postDelayed(this.sendMessageRunnable, 3000L);
            }
        }
    }

    public void cleanup() {
        this.handler.removeCallbacks(this.sendMessageRunnable);
    }

    public Boolean contains(MessageToWatch messageToWatch) {
        return Boolean.valueOf(this.messageQueue.contains(messageToWatch));
    }

    public void emptyQueue() {
        Logger.logDebug("QueueToWatch:  emptying queue, was: " + this.messageQueue);
        clear();
        this.deliveryInProgress.set(false);
    }

    public void enqueue(MessageToWatch messageToWatch) {
        if (!contains(messageToWatch).booleanValue()) {
            this.messageQueue.add(messageToWatch);
            Logger.logDebug("QueueToWatch:  Add to queue: " + messageToWatch);
        }
        this.handler.removeCallbacks(this.sendMessageRunnable);
        this.handler.postDelayed(this.sendMessageRunnable, 1000L);
        logQueue();
    }

    public String getQueueAsJsonArray() {
        JSONArray jSONArray = new JSONArray();
        for (MessageToWatch messageToWatch : this.messageQueue) {
            JSONObject jSONObject = new JSONObject();
            jSONArray.put(jSONObject.put("c", messageToWatch.command));
            jSONArray.put(jSONObject.put("d", messageToWatch.param));
        }
        return jSONArray.toString();
    }

    public void logQueue(String str) {
        if (str.length() < 1) {
            Logger.logDebug("QueueToWatch: " + this.messageQueue);
        } else {
            StringBuilder sbM5m = FileInsert$$ExternalSyntheticOutline0.m5m("QueueToWatch: ", str, " ");
            sbM5m.append(this.messageQueue);
            Logger.logDebug(sbM5m.toString());
        }
    }

    public MessageToWatch next() {
        if (this.messageQueue.size() > 0) {
            return this.messageQueue.get(0);
        }
        return null;
    }

    public void queueSendingViaHttpServer() {
        Iterator<MessageToWatch> it = this.messageQueue.iterator();
        while (it.hasNext()) {
            messageSentSuccessfullyCallback(it.next());
        }
    }

    public void remove(MessageToWatch messageToWatch) {
        this.messageQueue.remove(messageToWatch);
    }

    public int size() {
        return this.messageQueue.size();
    }

    public void logQueue() {
        logQueue("");
    }
}
