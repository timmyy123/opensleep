package com.google.firebase.ai.type;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/google/firebase/ai/type/ImagenMaskMode;", "", SDKConstants.PARAM_VALUE, "", "<init>", "(Ljava/lang/String;)V", "getValue$com_google_firebase_ai_logic_firebase_ai", "()Ljava/lang/String;", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ImagenMaskMode {
    private final String value;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ImagenMaskMode USER_PROVIDED = new ImagenMaskMode("MASK_MODE_USER_PROVIDED");
    private static final ImagenMaskMode BACKGROUND = new ImagenMaskMode("MASK_MODE_BACKGROUND");
    private static final ImagenMaskMode FOREGROUND = new ImagenMaskMode("MASK_MODE_FOREGROUND");
    private static final ImagenMaskMode SEMANTIC = new ImagenMaskMode("MASK_MODE_SEMANTIC");

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/google/firebase/ai/type/ImagenMaskMode$Companion;", "", "<init>", "()V", "USER_PROVIDED", "Lcom/google/firebase/ai/type/ImagenMaskMode;", "getUSER_PROVIDED", "()Lcom/google/firebase/ai/type/ImagenMaskMode;", "BACKGROUND", "getBACKGROUND", "FOREGROUND", "getFOREGROUND", "SEMANTIC", "getSEMANTIC", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ImagenMaskMode getBACKGROUND() {
            return ImagenMaskMode.BACKGROUND;
        }

        public final ImagenMaskMode getFOREGROUND() {
            return ImagenMaskMode.FOREGROUND;
        }

        public final ImagenMaskMode getSEMANTIC() {
            return ImagenMaskMode.SEMANTIC;
        }

        public final ImagenMaskMode getUSER_PROVIDED() {
            return ImagenMaskMode.USER_PROVIDED;
        }

        private Companion() {
        }
    }

    private ImagenMaskMode(String str) {
        this.value = str;
    }

    /* JADX INFO: renamed from: getValue$com_google_firebase_ai_logic_firebase_ai, reason: from getter */
    public final String getValue() {
        return this.value;
    }
}
