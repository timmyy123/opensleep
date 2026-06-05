package com.google.firebase.ai.type;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/google/firebase/ai/type/ImagenSubjectReferenceType;", "", SDKConstants.PARAM_VALUE, "", "<init>", "(Ljava/lang/String;)V", "getValue$com_google_firebase_ai_logic_firebase_ai", "()Ljava/lang/String;", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ImagenSubjectReferenceType {
    private final String value;
    public static final ImagenSubjectReferenceType PERSON = new ImagenSubjectReferenceType("SUBJECT_TYPE_PERSON");
    public static final ImagenSubjectReferenceType ANIMAL = new ImagenSubjectReferenceType("SUBJECT_TYPE_ANIMAL");
    public static final ImagenSubjectReferenceType PRODUCT = new ImagenSubjectReferenceType("SUBJECT_TYPE_PRODUCT");

    private ImagenSubjectReferenceType(String str) {
        this.value = str;
    }

    /* JADX INFO: renamed from: getValue$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final String getValue() {
        return this.value;
    }
}
