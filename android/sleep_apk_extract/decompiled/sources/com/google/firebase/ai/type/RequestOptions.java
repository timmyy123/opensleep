package com.google.firebase.ai.type;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\u00020\u0001B-\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB\u001d\b\u0017\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\rR\u0016\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/google/firebase/ai/type/RequestOptions;", "", "timeout", "Lkotlin/time/Duration;", "endpoint", "", "apiVersion", "autoFunctionCallingTurnLimit", "", "<init>", "(JLjava/lang/String;Ljava/lang/String;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "timeoutInMillis", "", "(JI)V", "getTimeout-UwyO8pc$com_google_firebase_ai_logic_firebase_ai", "()J", "J", "getEndpoint$com_google_firebase_ai_logic_firebase_ai", "()Ljava/lang/String;", "getApiVersion$com_google_firebase_ai_logic_firebase_ai", "getAutoFunctionCallingTurnLimit$com_google_firebase_ai_logic_firebase_ai", "()I", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RequestOptions {
    private final String apiVersion;
    private final int autoFunctionCallingTurnLimit;
    private final String endpoint;
    private final long timeout;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ RequestOptions(long j, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 1) != 0) {
            Duration.Companion companion = Duration.INSTANCE;
            j = Duration.m2536getInWholeMillisecondsimpl(DurationKt.toDuration(180, DurationUnit.SECONDS));
        }
        this(j, (i2 & 2) != 0 ? 10 : i);
    }

    /* JADX INFO: renamed from: getApiVersion$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final String getApiVersion() {
        return this.apiVersion;
    }

    /* JADX INFO: renamed from: getAutoFunctionCallingTurnLimit$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final int getAutoFunctionCallingTurnLimit() {
        return this.autoFunctionCallingTurnLimit;
    }

    /* JADX INFO: renamed from: getEndpoint$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final String getEndpoint() {
        return this.endpoint;
    }

    /* JADX INFO: renamed from: getTimeout-UwyO8pc$com_google_firebase_ai_logic_firebase_ai, reason: not valid java name and from getter */
    public final long getTimeout() {
        return this.timeout;
    }

    public RequestOptions(long j) {
        this(j, 0, 2, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ RequestOptions(long j, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, str2, i);
    }

    private RequestOptions(long j, String str, String str2, int i) {
        str.getClass();
        str2.getClass();
        this.timeout = j;
        this.endpoint = str;
        this.apiVersion = str2;
        this.autoFunctionCallingTurnLimit = i;
    }

    public /* synthetic */ RequestOptions(long j, String str, String str2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i2 & 2) != 0 ? "https://firebasevertexai.googleapis.com" : str, (i2 & 4) != 0 ? "v1beta" : str2, i, null);
    }

    public RequestOptions() {
        this(0L, 0, 3, (DefaultConstructorMarker) null);
    }

    public RequestOptions(long j, int i) {
        this(DurationKt.toDuration(j, DurationUnit.MILLISECONDS), null, null, i, 6, null);
    }
}
