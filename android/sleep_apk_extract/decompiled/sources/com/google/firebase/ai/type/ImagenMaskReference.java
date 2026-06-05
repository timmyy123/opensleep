package com.google.firebase.ai.type;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.philips.lighting.hue.sdk.utilities.impl.Color;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u001d\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/google/firebase/ai/type/ImagenMaskReference;", "Lcom/google/firebase/ai/type/ImagenReferenceImage;", "maskConfig", "Lcom/google/firebase/ai/type/ImagenMaskConfig;", "image", "Lcom/google/firebase/ai/type/ImagenInlineImage;", "<init>", "(Lcom/google/firebase/ai/type/ImagenMaskConfig;Lcom/google/firebase/ai/type/ImagenInlineImage;)V", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ImagenMaskReference extends ImagenReferenceImage {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007J2\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007¨\u0006\u000f"}, d2 = {"Lcom/google/firebase/ai/type/ImagenMaskReference$Companion;", "", "<init>", "()V", "generateMaskAndPadForOutpainting", "", "Lcom/google/firebase/ai/type/ImagenReferenceImage;", "image", "Lcom/google/firebase/ai/type/ImagenInlineImage;", "newDimensions", "Lcom/google/firebase/ai/type/Dimensions;", "newPosition", "Lcom/google/firebase/ai/type/ImagenImagePlacement;", "dilation", "", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ List generateMaskAndPadForOutpainting$default(Companion companion, ImagenInlineImage imagenInlineImage, Dimensions dimensions, ImagenImagePlacement imagenImagePlacement, double d, int i, Object obj) {
            if ((i & 4) != 0) {
                imagenImagePlacement = ImagenImagePlacement.CENTER;
            }
            ImagenImagePlacement imagenImagePlacement2 = imagenImagePlacement;
            if ((i & 8) != 0) {
                d = 0.01d;
            }
            return companion.generateMaskAndPadForOutpainting(imagenInlineImage, dimensions, imagenImagePlacement2, d);
        }

        public final List<ImagenReferenceImage> generateMaskAndPadForOutpainting(ImagenInlineImage image, Dimensions newDimensions, ImagenImagePlacement newPosition, double dilation) {
            image.getClass();
            newDimensions.getClass();
            newPosition.getClass();
            Bitmap bitmapAsBitmap = image.asBitmap();
            if (bitmapAsBitmap.getWidth() > newDimensions.getWidth() || bitmapAsBitmap.getHeight() > newDimensions.getHeight()) {
                throw new IllegalArgumentException("New Dimensions must be strictly larger than original image dimensions. Original image is:" + bitmapAsBitmap.getWidth() + 'x' + bitmapAsBitmap.getHeight() + ", new dimensions are " + newDimensions.getWidth() + 'x' + newDimensions.getHeight());
            }
            ImagenImagePlacement imagenImagePlacementNormalizeToDimensions$com_google_firebase_ai_logic_firebase_ai = newPosition.normalizeToDimensions$com_google_firebase_ai_logic_firebase_ai(new Dimensions(bitmapAsBitmap.getWidth(), bitmapAsBitmap.getHeight()), newDimensions);
            if (imagenImagePlacementNormalizeToDimensions$com_google_firebase_ai_logic_firebase_ai.getX() == null || imagenImagePlacementNormalizeToDimensions$com_google_firebase_ai_logic_firebase_ai.getY() == null) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Error normalizing position for mask and padding.");
                return null;
            }
            Rect rect = new Rect(imagenImagePlacementNormalizeToDimensions$com_google_firebase_ai_logic_firebase_ai.getX().intValue(), imagenImagePlacementNormalizeToDimensions$com_google_firebase_ai_logic_firebase_ai.getY().intValue(), bitmapAsBitmap.getWidth() + imagenImagePlacementNormalizeToDimensions$com_google_firebase_ai_logic_firebase_ai.getX().intValue(), bitmapAsBitmap.getHeight() + imagenImagePlacementNormalizeToDimensions$com_google_firebase_ai_logic_firebase_ai.getY().intValue());
            int width = newDimensions.getWidth();
            int height = newDimensions.getHeight();
            Bitmap.Config config = Bitmap.Config.RGB_565;
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, config);
            bitmapCreateBitmap.getClass();
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(newDimensions.getWidth(), newDimensions.getHeight(), config);
            bitmapCreateBitmap2.getClass();
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
            Paint paint = new Paint();
            paint.setColor(Color.BLACK);
            Paint paint2 = new Paint();
            paint2.setColor(-1);
            canvas.drawPaint(paint2);
            canvas.drawRect(rect, paint);
            canvas2.drawPaint(paint);
            canvas2.drawBitmap(bitmapAsBitmap, (Rect) null, rect, (Paint) null);
            return CollectionsKt.listOf((Object[]) new ImagenReferenceImage[]{new ImagenRawImage(ImagenInlineImageKt.toImagenInlineImage(bitmapCreateBitmap2)), new ImagenRawMask(ImagenInlineImageKt.toImagenInlineImage(bitmapCreateBitmap), Double.valueOf(dilation))});
        }

        private Companion() {
        }

        public static /* synthetic */ List generateMaskAndPadForOutpainting$default(Companion companion, ImagenInlineImage imagenInlineImage, Dimensions dimensions, ImagenImagePlacement imagenImagePlacement, int i, Object obj) {
            if ((i & 4) != 0) {
                imagenImagePlacement = ImagenImagePlacement.CENTER;
            }
            return companion.generateMaskAndPadForOutpainting(imagenInlineImage, dimensions, imagenImagePlacement);
        }

        public final List<ImagenReferenceImage> generateMaskAndPadForOutpainting(ImagenInlineImage image, Dimensions newDimensions, ImagenImagePlacement newPosition) {
            image.getClass();
            newDimensions.getClass();
            newPosition.getClass();
            return generateMaskAndPadForOutpainting(image, newDimensions, newPosition, 0.01d);
        }

        public final List<ImagenReferenceImage> generateMaskAndPadForOutpainting(ImagenInlineImage imagenInlineImage, Dimensions dimensions) {
            imagenInlineImage.getClass();
            dimensions.getClass();
            return generateMaskAndPadForOutpainting$default(this, imagenInlineImage, dimensions, null, 4, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImagenMaskReference(ImagenMaskConfig imagenMaskConfig, ImagenInlineImage imagenInlineImage) {
        super(imagenMaskConfig, null, null, null, imagenInlineImage, null, 46, null);
        imagenMaskConfig.getClass();
    }

    public static final List<ImagenReferenceImage> generateMaskAndPadForOutpainting(ImagenInlineImage imagenInlineImage, Dimensions dimensions, ImagenImagePlacement imagenImagePlacement, double d) {
        return INSTANCE.generateMaskAndPadForOutpainting(imagenInlineImage, dimensions, imagenImagePlacement, d);
    }

    public static final List<ImagenReferenceImage> generateMaskAndPadForOutpainting(ImagenInlineImage imagenInlineImage, Dimensions dimensions, ImagenImagePlacement imagenImagePlacement) {
        return INSTANCE.generateMaskAndPadForOutpainting(imagenInlineImage, dimensions, imagenImagePlacement);
    }

    public static final List<ImagenReferenceImage> generateMaskAndPadForOutpainting(ImagenInlineImage imagenInlineImage, Dimensions dimensions) {
        return INSTANCE.generateMaskAndPadForOutpainting(imagenInlineImage, dimensions);
    }

    public /* synthetic */ ImagenMaskReference(ImagenMaskConfig imagenMaskConfig, ImagenInlineImage imagenInlineImage, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(imagenMaskConfig, (i & 2) != 0 ? null : imagenInlineImage);
    }
}
