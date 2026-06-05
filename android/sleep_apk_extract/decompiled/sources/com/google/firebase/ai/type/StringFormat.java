package com.google.firebase.ai.type;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001:\u0001\bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/google/firebase/ai/type/StringFormat;", "", SDKConstants.PARAM_VALUE, "", "<init>", "(Ljava/lang/String;)V", "getValue$com_google_firebase_ai_logic_firebase_ai", "()Ljava/lang/String;", "Custom", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class StringFormat {
    private final String value;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/google/firebase/ai/type/StringFormat$Custom;", "Lcom/google/firebase/ai/type/StringFormat;", SDKConstants.PARAM_VALUE, "", "<init>", "(Ljava/lang/String;)V", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Custom extends StringFormat {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Custom(String str) {
            super(str, null);
            str.getClass();
        }
    }

    private StringFormat(String str) {
        this.value = str;
    }

    /* JADX INFO: renamed from: getValue$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    public /* synthetic */ StringFormat(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }
}
