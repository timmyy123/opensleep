package com.urbandroid.sleep.smartwatch.wear;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.Wearable;
import com.urbandroid.common.logging.Logger;

/* JADX INFO: loaded from: classes5.dex */
public class SendMessageTemplate extends ConnectionTemplate {
    private Handler h;
    private String message;
    private byte[] payload;
    private int retries;
    private int retry;

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartwatch.wear.SendMessageTemplate$1, reason: invalid class name */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ String val$nodeId;

        public AnonymousClass1(String str) {
            this.val$nodeId = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0(Integer num) {
            Logger.logInfo("WEAR  Sent " + SendMessageTemplate.this.message + " result " + num);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$1(Runnable runnable, Exception exc) {
            boolean zHasRetries = SendMessageTemplate.this.hasRetries();
            SendMessageTemplate sendMessageTemplate = SendMessageTemplate.this;
            if (!zHasRetries) {
                Logger.logInfo("WEAR Message " + sendMessageTemplate.message + " no more retries");
                return;
            }
            Logger.logInfo("WEAR Message " + sendMessageTemplate.message + " failed retrying");
            SendMessageTemplate.this.h.removeCallbacks(runnable);
            SendMessageTemplate.this.h.postDelayed(runnable, 1000L);
        }

        @Override // java.lang.Runnable
        public void run() {
            Task<Integer> taskSendMessage = Wearable.getMessageClient(SendMessageTemplate.this.context).sendMessage(this.val$nodeId, SendMessageTemplate.this.message, SendMessageTemplate.this.payload);
            taskSendMessage.addOnSuccessListener(new OnSuccessListener() { // from class: com.urbandroid.sleep.smartwatch.wear.SendMessageTemplate$1$$ExternalSyntheticLambda0
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    this.f$0.lambda$run$0((Integer) obj);
                }
            });
            taskSendMessage.addOnFailureListener(new OnFailureListener() { // from class: com.urbandroid.sleep.smartwatch.wear.SendMessageTemplate$1$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    this.f$0.lambda$run$1(this, exc);
                }
            });
        }
    }

    public SendMessageTemplate(Context context, String str) {
        super(context);
        this.payload = null;
        this.retry = 0;
        this.retries = 10;
        this.message = str;
        this.h = new Handler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean hasRetries() {
        boolean z;
        try {
            z = true;
            int i = this.retry + 1;
            this.retry = i;
            if (this.retries - i <= 0) {
                z = false;
            }
            if (!z) {
                this.retry = 0;
            }
            Logger.logInfo("WEAR Message " + this.message + " retry " + this.retry + " / " + this.retries);
        } catch (Throwable th) {
            throw th;
        }
        return z;
    }

    @Override // com.urbandroid.sleep.smartwatch.wear.ConnectionTemplate
    public void doExecute(String str) {
        Logger.logInfo("WEAR Sending message " + this.message + " to node " + str);
        this.h.post(new AnonymousClass1(str));
    }

    public SendMessageTemplate setPayload(byte[] bArr) {
        this.payload = bArr;
        return this;
    }
}
