package com.google.firebase.ai.type;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B!\b\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0002\b\u000fR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/google/firebase/ai/type/ImagenImagePlacement;", "", "x", "", "y", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getX", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getY", "normalizeToDimensions", "imageDimensions", "Lcom/google/firebase/ai/type/Dimensions;", "canvasDimensions", "normalizeToDimensions$com_google_firebase_ai_logic_firebase_ai", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ImagenImagePlacement {
    public static final ImagenImagePlacement BOTTOM_CENTER;
    public static final ImagenImagePlacement BOTTOM_LEFT;
    public static final ImagenImagePlacement BOTTOM_RIGHT;
    public static final ImagenImagePlacement CENTER;
    public static final ImagenImagePlacement LEFT_CENTER;
    public static final ImagenImagePlacement RIGHT_CENTER;
    public static final ImagenImagePlacement TOP_CENTER;
    public static final ImagenImagePlacement TOP_RIGHT;
    private final Integer x;
    private final Integer y;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final ImagenImagePlacement TOP_LEFT = new ImagenImagePlacement(0, 0);

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0007R\u0010\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/google/firebase/ai/type/ImagenImagePlacement$Companion;", "", "<init>", "()V", "fromCoordinate", "Lcom/google/firebase/ai/type/ImagenImagePlacement;", "x", "", "y", "CENTER", "TOP_CENTER", "BOTTOM_CENTER", "LEFT_CENTER", "RIGHT_CENTER", "TOP_LEFT", "TOP_RIGHT", "BOTTOM_LEFT", "BOTTOM_RIGHT", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ImagenImagePlacement fromCoordinate(int x, int y) {
            return new ImagenImagePlacement(Integer.valueOf(x), Integer.valueOf(y), null);
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        int i = 3;
        CENTER = new ImagenImagePlacement(null == true ? 1 : 0, null == true ? 1 : 0, i, null == true ? 1 : 0);
        TOP_CENTER = new ImagenImagePlacement(null == true ? 1 : 0, null == true ? 1 : 0, i, null == true ? 1 : 0);
        BOTTOM_CENTER = new ImagenImagePlacement(null == true ? 1 : 0, null == true ? 1 : 0, i, null == true ? 1 : 0);
        LEFT_CENTER = new ImagenImagePlacement(null == true ? 1 : 0, null == true ? 1 : 0, i, null == true ? 1 : 0);
        RIGHT_CENTER = new ImagenImagePlacement(null == true ? 1 : 0, null == true ? 1 : 0, i, null == true ? 1 : 0);
        TOP_RIGHT = new ImagenImagePlacement(null == true ? 1 : 0, null == true ? 1 : 0, i, null == true ? 1 : 0);
        BOTTOM_LEFT = new ImagenImagePlacement(null == true ? 1 : 0, null == true ? 1 : 0, i, null == true ? 1 : 0);
        BOTTOM_RIGHT = new ImagenImagePlacement(null == true ? 1 : 0, null == true ? 1 : 0, i, null == true ? 1 : 0);
    }

    public /* synthetic */ ImagenImagePlacement(Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2);
    }

    public static final ImagenImagePlacement fromCoordinate(int i, int i2) {
        return INSTANCE.fromCoordinate(i, i2);
    }

    public final Integer getX() {
        return this.x;
    }

    public final Integer getY() {
        return this.y;
    }

    public final ImagenImagePlacement normalizeToDimensions$com_google_firebase_ai_logic_firebase_ai(Dimensions imageDimensions, Dimensions canvasDimensions) {
        imageDimensions.getClass();
        canvasDimensions.getClass();
        if (this.x != null && this.y != null) {
            return this;
        }
        int height = canvasDimensions.getHeight() / 2;
        int width = canvasDimensions.getWidth() / 2;
        int height2 = imageDimensions.getHeight() / 2;
        int width2 = imageDimensions.getWidth() / 2;
        if (Intrinsics.areEqual(this, CENTER)) {
            return new ImagenImagePlacement(Integer.valueOf(width - width2), Integer.valueOf(height - height2));
        }
        if (Intrinsics.areEqual(this, TOP_CENTER)) {
            return new ImagenImagePlacement(Integer.valueOf(width - width2), 0);
        }
        if (Intrinsics.areEqual(this, BOTTOM_CENTER)) {
            return new ImagenImagePlacement(Integer.valueOf(width - width2), Integer.valueOf(canvasDimensions.getHeight() - imageDimensions.getHeight()));
        }
        if (Intrinsics.areEqual(this, LEFT_CENTER)) {
            return new ImagenImagePlacement(0, Integer.valueOf(height - height2));
        }
        if (Intrinsics.areEqual(this, RIGHT_CENTER)) {
            return new ImagenImagePlacement(Integer.valueOf(canvasDimensions.getWidth() - imageDimensions.getWidth()), Integer.valueOf(height - height2));
        }
        if (Intrinsics.areEqual(this, TOP_RIGHT)) {
            return new ImagenImagePlacement(Integer.valueOf(canvasDimensions.getWidth() - imageDimensions.getWidth()), 0);
        }
        if (Intrinsics.areEqual(this, BOTTOM_LEFT)) {
            return new ImagenImagePlacement(0, Integer.valueOf(canvasDimensions.getHeight() - imageDimensions.getHeight()));
        }
        if (Intrinsics.areEqual(this, BOTTOM_RIGHT)) {
            return new ImagenImagePlacement(Integer.valueOf(canvasDimensions.getWidth() - imageDimensions.getWidth()), Integer.valueOf(canvasDimensions.getHeight() - imageDimensions.getHeight()));
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Unknown ImagenImagePlacement instance, cannot normalize");
        return null;
    }

    private ImagenImagePlacement(Integer num, Integer num2) {
        this.x = num;
        this.y = num2;
    }

    public /* synthetic */ ImagenImagePlacement(Integer num, Integer num2, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, num2);
    }
}
