package com.urbandroid.sleep.service.automation.ifttt;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.service.automation.AutomationEvent;
import com.urbandroid.sleep.service.automation.AutomationTrigger;
import io.ktor.http.CodecsKt$$ExternalSyntheticLambda2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0094@¢\u0006\u0002\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/urbandroid/sleep/service/automation/ifttt/IftttTrigger;", "Lcom/urbandroid/sleep/service/automation/AutomationTrigger;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", IntrospectionHelper.AppFunctionAnnotation.PROPERTY_IS_ENABLED, "", "()Z", "doSend", "event", "Lcom/urbandroid/sleep/service/automation/AutomationEvent;", "timeoutInMs", "", "(Lcom/urbandroid/sleep/service/automation/AutomationEvent;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class IftttTrigger extends AutomationTrigger {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IftttTrigger(Context context) {
        super(context, "ifttt");
        context.getClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit doSend$lambda$4(IftttTrigger iftttTrigger, String str) {
        str.getClass();
        Logger.logDebug(Logger.defaultTag, iftttTrigger.getTag() + ": " + str, null);
        if (StringsKt.contains$default(str, "You sent an invalid key.")) {
            throw new IftttInvalidKeyException();
        }
        return Unit.INSTANCE;
    }

    @Override // com.urbandroid.sleep.service.automation.AutomationTrigger
    public Object doSend(AutomationEvent automationEvent, long j, Continuation<? super Boolean> continuation) throws IOException {
        String iftttKey = ContextExtKt.getSettings(getContext()).getIftttKey();
        iftttKey.getClass();
        if (StringsKt.isBlank(iftttKey)) {
            iftttKey = null;
        }
        if (iftttKey == null) {
            String strM$1 = FileInsert$$ExternalSyntheticOutline0.m$1(automationEvent.getEventName(), " - key missing");
            Logger.logWarning(Logger.defaultTag, getTag() + ": " + strM$1, null);
            return Boxing.boxBoolean(false);
        }
        URL url = new URL(Fragment$$ExternalSyntheticOutline1.m("https://maker.ifttt.com/trigger/", automationEvent.getEventName(), "/with/key/", URLEncoder.encode(iftttKey, "utf-8")));
        String strM$12 = FileInsert$$ExternalSyntheticOutline0.m$1(automationEvent.getEventName(), " post: ", FileInsert$$ExternalSyntheticOutline0.m("https://maker.ifttt.com/trigger/", automationEvent.getEventName(), "/with/key/XXXXXXXXXXXXX"));
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM$12, null);
        String strValuesToJSON = automationEvent.valuesToJSON();
        String strM$13 = FileInsert$$ExternalSyntheticOutline0.m$1(automationEvent.getEventName(), " sending body: ", strValuesToJSON);
        Logger.logDebug(Logger.defaultTag, getTag() + ": " + strM$13, null);
        URLConnection uRLConnectionOpenConnection = url.openConnection();
        uRLConnectionOpenConnection.getClass();
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setDoOutput(true);
        int i = (int) j;
        httpURLConnection.setConnectTimeout(i);
        httpURLConnection.setReadTimeout(i);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("charset", "utf-8");
        Charset charset = Charsets.UTF_8;
        byte[] bytes = strValuesToJSON.getBytes(charset);
        bytes.getClass();
        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bytes.length));
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoOutput(true);
        OutputStream outputStream = httpURLConnection.getOutputStream();
        try {
            byte[] bytes2 = strValuesToJSON.getBytes(charset);
            bytes2.getClass();
            outputStream.write(bytes2);
            outputStream.flush();
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(outputStream, null);
            int responseCode = httpURLConnection.getResponseCode();
            String str = automationEvent.getEventName() + " response code: " + responseCode;
            Logger.logInfo(Logger.defaultTag, getTag() + ": " + str, null);
            if (responseCode == 401) {
                String strConcat = "invalid maker channel key: ".concat(iftttKey);
                Logger.logWarning(Logger.defaultTag, getTag() + ": " + strConcat, null);
                throw new IftttInvalidKeyException();
            }
            if (responseCode == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                inputStream.getClass();
                TextStreamsKt.forEachLine(new BufferedReader(new InputStreamReader(inputStream, charset)), new CodecsKt$$ExternalSyntheticLambda2(this, 14));
                return Boxing.boxBoolean(true);
            }
            throw new IOException("IFTTT failure " + automationEvent.getEventName() + " http response code: " + responseCode);
        } finally {
        }
    }

    @Override // com.urbandroid.sleep.service.automation.AutomationTrigger
    public boolean isEnabled() {
        if (!ContextExtKt.getSettings(getContext()).isIfttt()) {
            return false;
        }
        String iftttKey = ContextExtKt.getSettings(getContext()).getIftttKey();
        iftttKey.getClass();
        return !StringsKt.isBlank(iftttKey);
    }
}
