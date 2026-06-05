package com.google.firebase.ai.type;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/google/firebase/ai/type/ImagenGCSImage;", "", "gcsUri", "", "mimeType", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getGcsUri", "()Ljava/lang/String;", "getMimeType", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ImagenGCSImage {
    private final String gcsUri;
    private final String mimeType;

    public ImagenGCSImage(String str, String str2) {
        str.getClass();
        str2.getClass();
        this.gcsUri = str;
        this.mimeType = str2;
    }

    public final String getGcsUri() {
        return this.gcsUri;
    }

    public final String getMimeType() {
        return this.mimeType;
    }
}
