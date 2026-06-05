package com.urbandroid.sleep.share;

import android.content.Context;
import com.urbandroid.common.logging.Logger;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractAsyncShareService extends AbstractShareService {
    public abstract void doPublishImageAndCommentIt(Context context, byte[] bArr, Object obj);

    public abstract void doPublishStatus(Context context, String str);

    @Override // com.urbandroid.sleep.share.IShareService
    public void publishImageAndCommentIt(Context context, final byte[] bArr, final Object obj, IHandler iHandler) {
        new Executor() { // from class: com.urbandroid.sleep.share.AbstractAsyncShareService.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(AbstractAsyncShareService.this, 0);
            }

            @Override // com.urbandroid.sleep.share.AbstractAsyncShareService.Executor
            public void doExecute(Context context2) {
                Logger.logDebug("async publish image on " + AbstractAsyncShareService.this.getName(context2));
                AbstractAsyncShareService.this.doPublishImageAndCommentIt(context2, bArr, obj);
            }
        }.execute(context, iHandler);
    }

    @Override // com.urbandroid.sleep.share.IShareService
    public void publishStatus(Context context, final String str, IHandler iHandler) {
        new Executor() { // from class: com.urbandroid.sleep.share.AbstractAsyncShareService.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(AbstractAsyncShareService.this, 0);
            }

            @Override // com.urbandroid.sleep.share.AbstractAsyncShareService.Executor
            public void doExecute(Context context2) {
                Logger.logDebug("async publish status on " + AbstractAsyncShareService.this.getName(context2));
                AbstractAsyncShareService.this.doPublishStatus(context2, str);
            }
        }.execute(context, iHandler);
    }

    public abstract class Executor {
        private Executor() {
        }

        public abstract void doExecute(Context context);

        public void execute(final Context context, final IHandler iHandler) {
            if (AbstractAsyncShareService.this.isConnected(context)) {
                new Thread() { // from class: com.urbandroid.sleep.share.AbstractAsyncShareService.Executor.1
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r4v3, types: [com.urbandroid.sleep.share.IHandler] */
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            try {
                                if (AbstractAsyncShareService.this.authenticate(context)) {
                                    Logger.logInfo("authenticated into " + AbstractAsyncShareService.this.getName(context));
                                    Executor.this.doExecute(context);
                                    iHandler.onSuccess();
                                } else {
                                    Logger.logInfo("auth failed into " + AbstractAsyncShareService.this.getName(context));
                                    iHandler.onNotAuthenticated();
                                }
                            } catch (Exception e) {
                                Logger.logSevere(e);
                                iHandler.onError(e);
                            }
                            this = iHandler;
                            this.onFinished();
                        } catch (Throwable th) {
                            iHandler.onFinished();
                            throw th;
                        }
                    }
                }.start();
            }
        }

        public /* synthetic */ Executor(AbstractAsyncShareService abstractAsyncShareService, int i) {
            this();
        }
    }
}
