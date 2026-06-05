package com.urbandroid.sleep.share;

import android.content.Context;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.share.twitter.TwitterAPI;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class CommonShareService implements IShareService {
    private Collection<IShareService> services;
    private TwitterAPI twitterAPI;

    public CommonShareService(TwitterAPI twitterAPI) {
        HashSet hashSet = new HashSet();
        this.services = hashSet;
        this.twitterAPI = twitterAPI;
        hashSet.add(twitterAPI);
    }

    @Override // com.urbandroid.sleep.share.IShareService
    public void disconnect(Context context) {
        throw new IllegalArgumentException("Not implemented");
    }

    public String getDesc(Context context) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (IShareService iShareService : this.services) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(iShareService.isConnected(context) ? context.getString(R.string.share_connected, iShareService.getName(context)) : context.getString(R.string.share_disconnected, iShareService.getName(context)));
            z = false;
        }
        return sb.toString();
    }

    @Override // com.urbandroid.sleep.share.IShareService
    public String getName(Context context) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (IShareService iShareService : this.services) {
            if (iShareService.isConnected(context)) {
                if (!z) {
                    sb.append(", ");
                }
                sb.append(iShareService.getName(context));
                z = false;
            }
        }
        if (z) {
            sb.append(context.getString(R.string.share_disconnected, ""));
            sb.append(" ");
        }
        return sb.toString();
    }

    public TwitterAPI getTwitterAPI() {
        return this.twitterAPI;
    }

    @Override // com.urbandroid.sleep.share.IShareService
    public void initiateLoginActivity(Context context, Object obj) {
        throw new IllegalArgumentException("Not implemented");
    }

    @Override // com.urbandroid.sleep.share.IShareService
    public boolean isConnected(Context context) {
        Iterator<IShareService> it = this.services.iterator();
        while (it.hasNext()) {
            if (it.next().isConnected(context)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.urbandroid.sleep.share.IShareService
    public void publishImageAndCommentIt(Context context, byte[] bArr, Object obj, IHandler iHandler) {
        CommonShareService commonShareService;
        final Context context2;
        final Object obj2;
        final IHandler iHandler2;
        Iterator<IShareService> it = this.services.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().isConnected(context)) {
                i++;
            }
        }
        final CountDownLatch countDownLatch = new CountDownLatch(i);
        for (final IShareService iShareService : this.services) {
            if (iShareService.isConnected(context)) {
                final String name = iShareService.getName(context);
                Logger.logInfo("Sharing on ..." + name);
                commonShareService = this;
                context2 = context;
                obj2 = obj;
                iHandler2 = iHandler;
                iShareService.publishImageAndCommentIt(context2, bArr, obj2, new AbstractFinishedHandlerAdapter() { // from class: com.urbandroid.sleep.share.CommonShareService.3
                    @Override // com.urbandroid.sleep.share.IHandler
                    public void onError(Exception exc) {
                        Logger.logSevere("Error in " + name, exc);
                        iHandler2.onNotAuthenticated();
                    }

                    @Override // com.urbandroid.sleep.share.IHandler
                    public void onFinished() {
                        Logger.logInfo("Sharing finished..." + name);
                        countDownLatch.countDown();
                    }

                    @Override // com.urbandroid.sleep.share.IHandler
                    public void onNotAuthenticated() {
                        Logger.logSevere("No auth " + name);
                        iShareService.initiateLoginActivity(context2, obj2);
                    }
                });
            } else {
                commonShareService = this;
                context2 = context;
                obj2 = obj;
                iHandler2 = iHandler;
            }
            this = commonShareService;
            context = context2;
            obj = obj2;
            iHandler = iHandler2;
        }
        final IHandler iHandler3 = iHandler;
        new Thread() { // from class: com.urbandroid.sleep.share.CommonShareService.4
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    countDownLatch.await(80L, TimeUnit.SECONDS);
                } catch (InterruptedException unused) {
                }
                Logger.logInfo("Sharing count down...");
                iHandler3.onSuccess();
                iHandler3.onFinished();
            }
        }.start();
    }

    @Override // com.urbandroid.sleep.share.IShareService
    public void publishStatus(Context context, String str, final IHandler iHandler) {
        Iterator<IShareService> it = this.services.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().isConnected(context)) {
                i++;
            }
        }
        final CountDownLatch countDownLatch = new CountDownLatch(i);
        for (IShareService iShareService : this.services) {
            if (iShareService.isConnected(context)) {
                final String name = iShareService.getName(context);
                Logger.logInfo("Sharing on ..." + name);
                iShareService.publishStatus(context, str, new AbstractFinishedHandlerAdapter() { // from class: com.urbandroid.sleep.share.CommonShareService.1
                    @Override // com.urbandroid.sleep.share.IHandler
                    public void onError(Exception exc) {
                        Logger.logSevere("Error in " + name, exc);
                        iHandler.onNotAuthenticated();
                    }

                    @Override // com.urbandroid.sleep.share.IHandler
                    public void onFinished() {
                        Logger.logInfo("Sharing finished..." + name);
                        countDownLatch.countDown();
                    }

                    @Override // com.urbandroid.sleep.share.IHandler
                    public void onNotAuthenticated() {
                        iHandler.onNotAuthenticated();
                    }
                });
            }
        }
        new Thread() { // from class: com.urbandroid.sleep.share.CommonShareService.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    countDownLatch.await(40L, TimeUnit.SECONDS);
                } catch (InterruptedException unused) {
                }
                Logger.logInfo("Sharing count down...");
                iHandler.onSuccess();
                iHandler.onFinished();
            }
        }.start();
    }
}
