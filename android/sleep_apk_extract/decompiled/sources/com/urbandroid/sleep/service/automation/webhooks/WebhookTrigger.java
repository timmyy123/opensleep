package com.urbandroid.sleep.service.automation.webhooks;

import adamb.ogg.OggIO$$ExternalSyntheticBUOutline0;
import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.automation.AutomationEvent;
import com.urbandroid.sleep.service.automation.AutomationTrigger;
import com.urbandroid.sleep.trial.Base64;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.io.CloseableKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import oauth.signpost.OAuth;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0094@¢\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/urbandroid/sleep/service/automation/webhooks/WebhookTrigger;", "Lcom/urbandroid/sleep/service/automation/AutomationTrigger;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", IntrospectionHelper.AppFunctionAnnotation.PROPERTY_IS_ENABLED, "", "()Z", "doSend", "event", "Lcom/urbandroid/sleep/service/automation/AutomationEvent;", "timeoutInMs", "", "(Lcom/urbandroid/sleep/service/automation/AutomationEvent;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAuthIfNeeded", "", "conn", "Ljava/net/HttpURLConnection;", "url", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class WebhookTrigger extends AutomationTrigger {

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.automation.webhooks.WebhookTrigger$doSend$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.automation.webhooks.WebhookTrigger", f = "WebhookTrigger.kt", l = {36}, m = "doSend", v = 2)
    public static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WebhookTrigger.this.doSend(null, 0L, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebhookTrigger(Context context) {
        super(context, "webhooks");
        context.getClass();
    }

    private final void setAuthIfNeeded(HttpURLConnection conn, String url) {
        URL url2 = new URL(url);
        if (url2.getUserInfo() == null) {
            return;
        }
        String userInfo = url2.getUserInfo();
        userInfo.getClass();
        String strSubstringBefore = StringsKt__StringsKt.substringBefore(userInfo, ":", "");
        String userInfo2 = url2.getUserInfo();
        userInfo2.getClass();
        String strSubstringAfter = StringsKt__StringsKt.substringAfter(userInfo2, ":", "");
        if (strSubstringBefore.length() == 0 || strSubstringAfter.length() == 0) {
            return;
        }
        byte[] bytes = FileInsert$$ExternalSyntheticOutline0.m$1(strSubstringBefore, ":", strSubstringAfter).getBytes(Charsets.UTF_8);
        bytes.getClass();
        conn.setRequestProperty(OAuth.HTTP_AUTHORIZATION_HEADER, "Basic " + Base64.encode(bytes));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    @Override // com.urbandroid.sleep.service.automation.AutomationTrigger
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object doSend(AutomationEvent automationEvent, long j, Continuation<? super Boolean> continuation) throws IOException {
        AnonymousClass1 anonymousClass1;
        String str;
        long j2;
        String str2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object objWithContext = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            String webhooksUrl = ContextExtKt.getSettings(getContext()).getWebhooksUrl();
            webhooksUrl.getClass();
            str = !StringsKt.isBlank(webhooksUrl) ? webhooksUrl : null;
            if (str == null) {
                Logger.logWarning(Logger.defaultTag, getTag() + ": trigger: url missing", null);
                return Boxing.boxBoolean(false);
            }
            CharSequence charSequenceSubSequence = str.subSequence(0, 10);
            String str3 = Logger.defaultTag;
            Logger.logInfo(str3, getTag() + ": " + ("trigger post: " + ((Object) charSequenceSubSequence) + "..."), null);
            String json = automationEvent.toJSON();
            String strConcat = "sending url: ".concat(str);
            Logger.logDebug(Logger.defaultTag, getTag() + ": " + strConcat, null);
            StringBuilder sb = new StringBuilder("sending body: ");
            sb.append(json);
            String string = sb.toString();
            Logger.logDebug(Logger.defaultTag, getTag() + ": " + string, null);
            CoroutineDispatcher io2 = Dispatchers.getIO();
            WebhookTrigger$doSend$conn$1 webhookTrigger$doSend$conn$1 = new WebhookTrigger$doSend$conn$1(str, null);
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(automationEvent);
            anonymousClass1.L$1 = str;
            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(charSequenceSubSequence);
            anonymousClass1.L$3 = json;
            j2 = j;
            anonymousClass1.J$0 = j2;
            anonymousClass1.label = 1;
            objWithContext = BuildersKt.withContext(io2, webhookTrigger$doSend$conn$1, anonymousClass1);
            if (objWithContext == coroutine_suspended) {
                return coroutine_suspended;
            }
            str2 = json;
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            long j3 = anonymousClass1.J$0;
            str2 = (String) anonymousClass1.L$3;
            str = (String) anonymousClass1.L$1;
            ResultKt.throwOnFailure(objWithContext);
            j2 = j3;
        }
        objWithContext.getClass();
        HttpURLConnection httpURLConnection = (HttpURLConnection) objWithContext;
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        int i3 = (int) j2;
        httpURLConnection.setConnectTimeout(i3);
        httpURLConnection.setReadTimeout(i3);
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("charset", "utf-8");
        Charset charset = Charsets.UTF_8;
        byte[] bytes = str2.getBytes(charset);
        bytes.getClass();
        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bytes.length));
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoOutput(true);
        setAuthIfNeeded(httpURLConnection, str);
        OutputStream outputStream = httpURLConnection.getOutputStream();
        try {
            byte[] bytes2 = str2.getBytes(charset);
            bytes2.getClass();
            outputStream.write(bytes2);
            outputStream.flush();
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(outputStream, null);
            int responseCode = httpURLConnection.getResponseCode();
            String strM = FileInsert$$ExternalSyntheticOutline0.m(responseCode, "trigger response code: ");
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM, null);
            if (responseCode == 200) {
                return Boxing.boxBoolean(true);
            }
            OggIO$$ExternalSyntheticBUOutline0.m(FileInsert$$ExternalSyntheticOutline0.m(responseCode, "Webhooks failure http response code: "));
            return null;
        } finally {
        }
    }

    @Override // com.urbandroid.sleep.service.automation.AutomationTrigger
    public boolean isEnabled() {
        Settings settings = ContextExtKt.getSettings(getContext());
        if (!settings.isWebhooks()) {
            return false;
        }
        String webhooksUrl = settings.getWebhooksUrl();
        webhooksUrl.getClass();
        return !StringsKt.isBlank(webhooksUrl);
    }
}
