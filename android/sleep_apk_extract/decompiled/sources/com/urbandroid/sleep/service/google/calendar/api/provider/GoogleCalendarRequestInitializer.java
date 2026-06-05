package com.urbandroid.sleep.service.google.calendar.api.provider;

import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.google.api.services.calendar.CalendarRequest;
import com.google.api.services.calendar.CalendarRequestInitializer;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/urbandroid/sleep/service/google/calendar/api/provider/GoogleCalendarRequestInitializer;", "Lcom/google/api/services/calendar/CalendarRequestInitializer;", "Lcom/urbandroid/common/FeatureLogger;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "apiKey", "", "token", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "tag", "getTag", "()Ljava/lang/String;", "sha1", "initializeCalendarRequest", "", "request", "Lcom/google/api/services/calendar/CalendarRequest;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GoogleCalendarRequestInitializer extends CalendarRequestInitializer implements FeatureLogger {
    private final String apiKey;
    private final Context context;
    private final String sha1;
    private final String tag;
    private final String token;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleCalendarRequestInitializer(Context context, String str, String str2) {
        super(str);
        context.getClass();
        str.getClass();
        str2.getClass();
        this.context = context;
        this.apiKey = str;
        this.token = str2;
        this.tag = "calendar:request";
        this.sha1 = ContextExtKt.sha1(context);
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // com.google.api.services.calendar.CalendarRequestInitializer
    public void initializeCalendarRequest(CalendarRequest<?> request) {
        request.getClass();
        super.initializeCalendarRequest(request);
        request.setKey2(this.apiKey);
        request.setOauthToken2(this.token);
        request.getRequestHeaders().set("X-Android-Package", (Object) this.context.getPackageName());
        request.getRequestHeaders().set("X-Android-Cert", (Object) this.sha1);
        String oauthToken = request.getOauthToken();
        String strConcat = "token=".concat(ContextExtKt.cut(oauthToken, 8) + "..." + ContextExtKt.cutFromEnd(oauthToken, 8));
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + strConcat, null);
    }
}
