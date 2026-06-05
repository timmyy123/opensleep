package io.ktor.client.plugins;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.call.SavedCallKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.utils.io.charsets.MalformedInputException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "response", "Lio/ktor/client/statement/HttpResponse;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.DefaultResponseValidationKt$addDefaultResponseValidation$1$1", f = "DefaultResponseValidation.kt", l = {40, 46}, m = "invokeSuspend")
public final class DefaultResponseValidationKt$addDefaultResponseValidation$1$1 extends SuspendLambda implements Function2<HttpResponse, Continuation<? super Unit>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public DefaultResponseValidationKt$addDefaultResponseValidation$1$1(Continuation<? super DefaultResponseValidationKt$addDefaultResponseValidation$1$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DefaultResponseValidationKt$addDefaultResponseValidation$1$1 defaultResponseValidationKt$addDefaultResponseValidation$1$1 = new DefaultResponseValidationKt$addDefaultResponseValidation$1$1(continuation);
        defaultResponseValidationKt$addDefaultResponseValidation$1$1.L$0 = obj;
        return defaultResponseValidationKt$addDefaultResponseValidation$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        return ((DefaultResponseValidationKt$addDefaultResponseValidation$1$1) create(httpResponse, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(1:(1:(8:6|55|7|29|33|(2:38|(1:(1:47)(1:46))(1:42))(1:37)|48|49)(2:9|10))(1:11))(2:12|(2:14|15)(2:16|(2:50|51)(3:21|(0)|27)))|24|53|25|(6:28|29|33|(2:38|(1:(2:44|47)(0))(0))(0)|48|49)|27) */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00cb, code lost:
    
        r11 = r12;
        r0 = r1;
        r1 = r6;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f6  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) throws Throwable {
        HttpResponse httpResponse;
        int value;
        Object objSave;
        HttpResponse httpResponse2;
        int i;
        HttpResponse httpResponse3;
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            httpResponse = (HttpResponse) this.L$0;
            if (!((Boolean) httpResponse.getCall().getAttributes().get(HttpCallValidatorKt.getExpectSuccessAttributeKey())).booleanValue()) {
                DefaultResponseValidationKt.LOGGER.trace("Skipping default response validation for " + httpResponse.getCall().getRequest().getUrl());
                return Unit.INSTANCE;
            }
            value = httpResponse.getStatus().getValue();
            HttpClientCall call = httpResponse.getCall();
            if (value < 300 || call.getAttributes().contains(DefaultResponseValidationKt.ValidateMark)) {
                return Unit.INSTANCE;
            }
            this.L$0 = httpResponse;
            this.I$0 = value;
            this.label = 1;
            objSave = SavedCallKt.save(call, this);
            if (objSave != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            i = this.I$0;
            httpResponse3 = (HttpResponse) this.L$1;
            httpResponse2 = (HttpResponse) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                str = (String) obj;
            } catch (MalformedInputException unused) {
                str = "<body failed decoding>";
            }
            Throwable responseException = (300 <= i || i >= 400) ? (400 <= i || i >= 500) ? (500 <= i || i >= 600) ? new ResponseException(httpResponse3, str) : new ServerResponseException(httpResponse3, str) : new ClientRequestException(httpResponse3, str) : new RedirectResponseException(httpResponse3, str);
            DefaultResponseValidationKt.LOGGER.trace("Default response validation for " + httpResponse2.getCall().getRequest().getUrl() + " failed with " + responseException);
            throw responseException;
        }
        value = this.I$0;
        HttpResponse httpResponse4 = (HttpResponse) this.L$0;
        ResultKt.throwOnFailure(obj);
        objSave = obj;
        httpResponse = httpResponse4;
        HttpClientCall httpClientCall = (HttpClientCall) objSave;
        httpClientCall.getAttributes().put(DefaultResponseValidationKt.ValidateMark, Unit.INSTANCE);
        HttpResponse response = httpClientCall.getResponse();
        this.L$0 = httpResponse;
        this.L$1 = response;
        this.I$0 = value;
        this.label = 2;
        Object objBodyAsText$default = HttpResponseKt.bodyAsText$default(response, null, this, 1, null);
        if (objBodyAsText$default != coroutine_suspended) {
            HttpResponse httpResponse5 = httpResponse;
            obj = objBodyAsText$default;
            httpResponse2 = httpResponse5;
            i = value;
            httpResponse3 = response;
            str = (String) obj;
            if (300 <= i) {
            }
            DefaultResponseValidationKt.LOGGER.trace("Default response validation for " + httpResponse2.getCall().getRequest().getUrl() + " failed with " + responseException);
            throw responseException;
        }
        return coroutine_suspended;
    }
}
