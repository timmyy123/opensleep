package com.google.firebase.ai.type;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/google/firebase/ai/type/ImagenPersonFilterLevel;", "", "internalVal", "", "<init>", "(Ljava/lang/String;)V", "getInternalVal$com_google_firebase_ai_logic_firebase_ai", "()Ljava/lang/String;", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ImagenPersonFilterLevel {
    private final String internalVal;
    public static final ImagenPersonFilterLevel ALLOW_ALL = new ImagenPersonFilterLevel("allow_all");
    public static final ImagenPersonFilterLevel ALLOW_ADULT = new ImagenPersonFilterLevel("allow_adult");
    public static final ImagenPersonFilterLevel BLOCK_ALL = new ImagenPersonFilterLevel("dont_allow");

    private ImagenPersonFilterLevel(String str) {
        this.internalVal = str;
    }

    /* JADX INFO: renamed from: getInternalVal$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final String getInternalVal() {
        return this.internalVal;
    }
}
