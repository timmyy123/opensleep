package com.google.firebase.ai.type;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/google/firebase/ai/type/ImagenSafetySettings;", "", "safetyFilterLevel", "Lcom/google/firebase/ai/type/ImagenSafetyFilterLevel;", "personFilterLevel", "Lcom/google/firebase/ai/type/ImagenPersonFilterLevel;", "<init>", "(Lcom/google/firebase/ai/type/ImagenSafetyFilterLevel;Lcom/google/firebase/ai/type/ImagenPersonFilterLevel;)V", "getSafetyFilterLevel$com_google_firebase_ai_logic_firebase_ai", "()Lcom/google/firebase/ai/type/ImagenSafetyFilterLevel;", "getPersonFilterLevel$com_google_firebase_ai_logic_firebase_ai", "()Lcom/google/firebase/ai/type/ImagenPersonFilterLevel;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ImagenSafetySettings {
    private final ImagenPersonFilterLevel personFilterLevel;
    private final ImagenSafetyFilterLevel safetyFilterLevel;

    public ImagenSafetySettings(ImagenSafetyFilterLevel imagenSafetyFilterLevel, ImagenPersonFilterLevel imagenPersonFilterLevel) {
        imagenSafetyFilterLevel.getClass();
        imagenPersonFilterLevel.getClass();
        this.safetyFilterLevel = imagenSafetyFilterLevel;
        this.personFilterLevel = imagenPersonFilterLevel;
    }

    /* JADX INFO: renamed from: getPersonFilterLevel$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final ImagenPersonFilterLevel getPersonFilterLevel() {
        return this.personFilterLevel;
    }

    /* JADX INFO: renamed from: getSafetyFilterLevel$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final ImagenSafetyFilterLevel getSafetyFilterLevel() {
        return this.safetyFilterLevel;
    }
}
