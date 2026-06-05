package com.google.firebase.ai.type;

import android.graphics.Bitmap;
import android.util.Base64;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B-\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\u000bB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\fJ\r\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0011R\u0016\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/google/firebase/ai/type/ImagePart;", "Lcom/google/firebase/ai/type/Part;", "image", "Landroid/graphics/Bitmap;", "displayName", "", "isThought", "", "thoughtSignature", "<init>", "(Landroid/graphics/Bitmap;Ljava/lang/String;ZLjava/lang/String;)V", "(Landroid/graphics/Bitmap;)V", "(Landroid/graphics/Bitmap;Ljava/lang/String;)V", "getImage", "()Landroid/graphics/Bitmap;", "getDisplayName", "()Ljava/lang/String;", "()Z", "getThoughtSignature$com_google_firebase_ai_logic_firebase_ai", "toInlineDataPart", "Lcom/google/firebase/ai/type/InlineDataPart;", "toInlineDataPart$com_google_firebase_ai_logic_firebase_ai", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ImagePart implements Part {
    private final String displayName;
    private final Bitmap image;
    private final boolean isThought;
    private final String thoughtSignature;

    public ImagePart(Bitmap bitmap, String str, boolean z, String str2) {
        bitmap.getClass();
        this.image = bitmap;
        this.displayName = str;
        this.isThought = z;
        this.thoughtSignature = str2;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final Bitmap getImage() {
        return this.image;
    }

    /* JADX INFO: renamed from: getThoughtSignature$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final String getThoughtSignature() {
        return this.thoughtSignature;
    }

    @Override // com.google.firebase.ai.type.Part
    /* JADX INFO: renamed from: isThought, reason: from getter */
    public boolean getIsThought() {
        return this.isThought;
    }

    public final InlineDataPart toInlineDataPart$com_google_firebase_ai_logic_firebase_ai() {
        byte[] bArrDecode = Base64.decode(PartKt.encodeBitmapToBase64Jpeg(this.image), 2);
        bArrDecode.getClass();
        return new InlineDataPart(bArrDecode, "image/jpeg", this.displayName, getIsThought(), this.thoughtSignature);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImagePart(Bitmap bitmap) {
        this(bitmap, null, false, null);
        bitmap.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImagePart(Bitmap bitmap, String str) {
        this(bitmap, str, false, null);
        bitmap.getClass();
        str.getClass();
    }
}
