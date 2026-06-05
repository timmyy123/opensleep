package com.google.firebase.ai.common;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.work.Data$$ExternalSyntheticLambda0;
import com.fasterxml.jackson.core.JsonFactory;
import com.google.firebase.Firebase;
import com.google.firebase.FirebaseKt;
import com.google.firebase.ai.type.APINotConfiguredException;
import com.google.firebase.ai.type.Candidate;
import com.google.firebase.ai.type.FinishReason;
import com.google.firebase.ai.type.GRpcErrorResponse;
import com.google.firebase.ai.type.GenerateContentResponse;
import com.google.firebase.ai.type.InvalidAPIKeyException;
import com.google.firebase.ai.type.PromptBlockedException;
import com.google.firebase.ai.type.PromptFeedback;
import com.google.firebase.ai.type.QuotaExceededException;
import com.google.firebase.ai.type.ResponseStoppedException;
import com.google.firebase.ai.type.SerializationException;
import com.google.firebase.ai.type.ServerException;
import com.google.firebase.ai.type.ServiceDisabledException;
import com.google.firebase.ai.type.UnsupportedUserLocationException;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.http.ContentType;
import io.ktor.http.ContentTypesKt;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpStatusCode;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.serialization.json.ClassDiscriminatorMode;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010\n\u001a\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a\f\u0010\u000f\u001a\u00020\u0010*\u00020\u0010H\u0002\"\u001a\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0011"}, d2 = {JsonFactory.FORMAT_NAME_JSON, "Lkotlinx/serialization/json/Json;", "getJSON$annotations", "()V", "getJSON", "()Lkotlinx/serialization/json/Json;", "validateResponse", "", "response", "Lio/ktor/client/statement/HttpResponse;", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getServiceDisabledErrorDetailsOrNull", "Lcom/google/firebase/ai/type/GRpcErrorResponse$GRpcError$GRpcErrorDetails;", "error", "Lcom/google/firebase/ai/type/GRpcErrorResponse$GRpcError;", "validate", "Lcom/google/firebase/ai/type/GenerateContentResponse$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class APIControllerKt {
    private static final Json JSON = JsonKt.Json$default(null, new Data$$ExternalSyntheticLambda0(17), 1, null);

    /* JADX INFO: renamed from: com.google.firebase.ai.common.APIControllerKt$validateResponse$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.ai.common.APIControllerKt", f = "APIController.kt", l = {444, 447}, m = "validateResponse")
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return APIControllerKt.validateResponse(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit JSON$lambda$0(JsonBuilder jsonBuilder) {
        jsonBuilder.getClass();
        jsonBuilder.setIgnoreUnknownKeys(true);
        jsonBuilder.setPrettyPrint(false);
        jsonBuilder.setLenient(true);
        jsonBuilder.setExplicitNulls(false);
        jsonBuilder.setClassDiscriminatorMode(ClassDiscriminatorMode.NONE);
        return Unit.INSTANCE;
    }

    public static final Json getJSON() {
        return JSON;
    }

    public static /* synthetic */ void getJSON$annotations() {
    }

    private static final GRpcErrorResponse.GRpcError.GRpcErrorDetails getServiceDisabledErrorDetailsOrNull(GRpcErrorResponse.GRpcError gRpcError) {
        List<GRpcErrorResponse.GRpcError.GRpcErrorDetails> details = gRpcError.getDetails();
        Object obj = null;
        if (details == null) {
            return null;
        }
        Iterator<T> it = details.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            GRpcErrorResponse.GRpcError.GRpcErrorDetails gRpcErrorDetails = (GRpcErrorResponse.GRpcError.GRpcErrorDetails) next;
            if (Intrinsics.areEqual(gRpcErrorDetails.getReason(), "SERVICE_DISABLED") && Intrinsics.areEqual(gRpcErrorDetails.getDomain(), "googleapis.com")) {
                obj = next;
                break;
            }
        }
        return (GRpcErrorResponse.GRpcError.GRpcErrorDetails) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final GenerateContentResponse.Internal validate(GenerateContentResponse.Internal internal) {
        Object next;
        List<Candidate.Internal> candidates = internal.getCandidates();
        int i = 2;
        Throwable th = null;
        Object[] objArr = 0;
        if ((candidates == null || candidates.isEmpty()) && internal.getPromptFeedback() == null) {
            throw new SerializationException("Error deserializing response, found no valid fields", null, 2, null);
        }
        PromptFeedback.Internal promptFeedback = internal.getPromptFeedback();
        if (promptFeedback != null && promptFeedback.getBlockReason() != null) {
            throw new PromptBlockedException(internal.toPublic$com_google_firebase_ai_logic_firebase_ai(), null, null);
        }
        List<Candidate.Internal> candidates2 = internal.getCandidates();
        if (candidates2 != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = candidates2.iterator();
            while (it.hasNext()) {
                FinishReason.Internal finishReason = ((Candidate.Internal) it.next()).getFinishReason();
                if (finishReason != null) {
                    arrayList.add(finishReason);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                if (((FinishReason.Internal) next) != FinishReason.Internal.STOP) {
                    break;
                }
            }
            if (((FinishReason.Internal) next) != null) {
                throw new ResponseStoppedException(internal.toPublic$com_google_firebase_ai_logic_firebase_ai(), th, i, objArr == true ? 1 : 0);
            }
        }
        return internal;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ab, code lost:
    
        if (r9 == r1) goto L32;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object validateResponse(HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        StringBuilder sb;
        String message;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object objBodyAsText$default = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        int i3 = 1;
        int i4 = 2;
        Throwable th = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        Object[] objArr6 = 0;
        Object[] objArr7 = 0;
        Object[] objArr8 = 0;
        Object[] objArr9 = 0;
        Object[] objArr10 = 0;
        Object[] objArr11 = 0;
        Object[] objArr12 = 0;
        Object[] objArr13 = 0;
        Object[] objArr14 = 0;
        Object[] objArr15 = 0;
        Object[] objArr16 = 0;
        Object[] objArr17 = 0;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objBodyAsText$default);
            HttpStatusCode status = httpResponse.getStatus();
            HttpStatusCode.Companion companion = HttpStatusCode.INSTANCE;
            if (Intrinsics.areEqual(status, companion.getOK())) {
                return Unit.INSTANCE;
            }
            ContentType html = ContentType.Text.INSTANCE.getHtml();
            Charset charsetForName = Charset.forName("utf-8");
            charsetForName.getClass();
            ContentType contentTypeWithCharset = ContentTypesKt.withCharset(html, charsetForName);
            if (Intrinsics.areEqual(httpResponse.getStatus(), companion.getNotFound()) && Intrinsics.areEqual(HttpMessagePropertiesKt.contentType(httpResponse), contentTypeWithCharset)) {
                StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m("URL not found. Please verify the location used to create the `FirebaseAI` object\n          | See https://cloud.google.com/vertex-ai/generative-ai/docs/learn/locations#available-regions\n          | for the list of available locations. Raw response: ");
                anonymousClass1.L$0 = sbM;
                anonymousClass1.label = 1;
                Object objBodyAsText$default2 = HttpResponseKt.bodyAsText$default(httpResponse, null, anonymousClass1, 1, null);
                if (objBodyAsText$default2 != coroutine_suspended) {
                    objBodyAsText$default = objBodyAsText$default2;
                    sb = sbM;
                    sb.append((String) objBodyAsText$default);
                    throw new ServerException(StringsKt__IndentKt.trimMargin$default(sb.toString(), null, 1, null), objArr2 == true ? 1 : 0, i4, objArr == true ? 1 : 0);
                }
            } else {
                anonymousClass1.label = 2;
                objBodyAsText$default = HttpResponseKt.bodyAsText$default(httpResponse, null, anonymousClass1, 1, null);
            }
            return coroutine_suspended;
        }
        if (i2 == 1) {
            sb = (StringBuilder) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objBodyAsText$default);
            sb.append((String) objBodyAsText$default);
            throw new ServerException(StringsKt__IndentKt.trimMargin$default(sb.toString(), null, 1, null), objArr2 == true ? 1 : 0, i4, objArr == true ? 1 : 0);
        }
        if (i2 != 2) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        ResultKt.throwOnFailure(objBodyAsText$default);
        String str = (String) objBodyAsText$default;
        try {
            Json json = JSON;
            json.getSerializersModule();
            GRpcErrorResponse.GRpcError error = ((GRpcErrorResponse) json.decodeFromString(GRpcErrorResponse.INSTANCE.serializer(), str)).getError();
            String message2 = error.getMessage();
            if (StringsKt.contains$default(message2, "API key not valid")) {
                throw new InvalidAPIKeyException(message2, objArr6 == true ? 1 : 0, i4, objArr5 == true ? 1 : 0);
            }
            if (Intrinsics.areEqual(message2, "User location is not supported for the API use.")) {
                throw new UnsupportedUserLocationException(objArr8 == true ? 1 : 0, i3, objArr7 == true ? 1 : 0);
            }
            if (StringsKt.contains$default(message2, "quota")) {
                throw new QuotaExceededException(message2, objArr10 == true ? 1 : 0, i4, objArr9 == true ? 1 : 0);
            }
            if (StringsKt.contains$default(message2, "The prompt could not be submitted")) {
                throw new PromptBlockedException(message2, objArr12 == true ? 1 : 0, i4, objArr11 == true ? 1 : 0);
            }
            if (StringsKt.contains$default(message2, "genai config not found")) {
                throw new APINotConfiguredException("The Gemini Developer API is not enabled, to enable and configure, see https://firebase.google.com/docs/ai-logic/faq-and-troubleshooting?api=dev#error-genai-config-not-found", objArr14 == true ? 1 : 0, i4, objArr13 == true ? 1 : 0);
            }
            GRpcErrorResponse.GRpcError.GRpcErrorDetails serviceDisabledErrorDetailsOrNull = getServiceDisabledErrorDetailsOrNull(error);
            if (serviceDisabledErrorDetailsOrNull == null) {
                throw new ServerException(message2, objArr16 == true ? 1 : 0, i4, objArr15 == true ? 1 : 0);
            }
            Map<String, String> metadata = serviceDisabledErrorDetailsOrNull.getMetadata();
            if (Intrinsics.areEqual(metadata != null ? metadata.get("service") : null, "firebasevertexai.googleapis.com")) {
                message = StringsKt.trimIndent("\n        The Firebase AI SDK requires the Vertex AI in Firebase API\n        (`firebasevertexai.googleapis.com`) to be enabled in your Firebase project. Enable this API\n        by visiting the Firebase Console at\n        https://console.firebase.google.com/project/" + FirebaseKt.getOptions(Firebase.INSTANCE).getProjectId() + "/genai\n        and clicking \"Get started\". If you enabled this API recently, wait a few minutes for the\n        action to propagate to our systems and then retry.\n      ");
            } else {
                message = error.getMessage();
            }
            throw new ServiceDisabledException(message, th, i4, objArr17 == true ? 1 : 0);
        } catch (Throwable th2) {
            throw new ServerException("Unexpected Response:\n" + str + ' ' + th2, objArr4 == true ? 1 : 0, i4, objArr3 == true ? 1 : 0);
        }
    }
}
