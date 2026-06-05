package com.squareup.picasso;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.graphics.Bitmap;
import android.net.Uri;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public final class Request {
    private static final long TOO_LONG_LOG = 5000000000L;
    public final boolean centerCrop;
    public final boolean centerInside;
    public final Bitmap.Config config;
    public final boolean hasRotationPivot;
    int id;
    int networkPolicy;
    public final boolean onlyScaleDown;
    public final Picasso.Priority priority;
    public final int resourceId;
    public final float rotationDegrees;
    public final float rotationPivotX;
    public final float rotationPivotY;
    public final String stableKey;
    long started;
    public final int targetHeight;
    public final int targetWidth;
    public final List<Transformation> transformations;
    public final Uri uri;

    public static final class Builder {
        private boolean centerCrop;
        private boolean centerInside;
        private Bitmap.Config config;
        private boolean hasRotationPivot;
        private boolean onlyScaleDown;
        private Picasso.Priority priority;
        private int resourceId;
        private float rotationDegrees;
        private float rotationPivotX;
        private float rotationPivotY;
        private String stableKey;
        private int targetHeight;
        private int targetWidth;
        private List<Transformation> transformations;
        private Uri uri;

        public Builder(Uri uri, int i, Bitmap.Config config) {
            this.uri = uri;
            this.resourceId = i;
            this.config = config;
        }

        public Request build() {
            boolean z = this.centerInside;
            if (z && this.centerCrop) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Center crop and center inside can not be used together.");
                return null;
            }
            boolean z2 = this.centerCrop;
            if (z2 && this.targetWidth == 0 && this.targetHeight == 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Center crop requires calling resize with positive width and height.");
                return null;
            }
            if (z && this.targetWidth == 0 && this.targetHeight == 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Center inside requires calling resize with positive width and height.");
                return null;
            }
            if (this.priority == null) {
                this.priority = Picasso.Priority.NORMAL;
            }
            return new Request(this.uri, this.resourceId, this.stableKey, this.transformations, this.targetWidth, this.targetHeight, z2, z, this.onlyScaleDown, this.rotationDegrees, this.rotationPivotX, this.rotationPivotY, this.hasRotationPivot, this.config, this.priority);
        }

        public boolean hasImage() {
            return (this.uri == null && this.resourceId == 0) ? false : true;
        }

        public boolean hasSize() {
            return (this.targetWidth == 0 && this.targetHeight == 0) ? false : true;
        }

        public Builder resize(int i, int i2) {
            if (i < 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Width must be positive number or 0.");
                return null;
            }
            if (i2 < 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Height must be positive number or 0.");
                return null;
            }
            if (i2 == 0 && i == 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("At least one dimension has to be positive number.");
                return null;
            }
            this.targetWidth = i;
            this.targetHeight = i2;
            return this;
        }

        public Builder transform(Transformation transformation) {
            if (transformation == null) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Transformation must not be null.");
                return null;
            }
            if (transformation.key() == null) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Transformation key must not be null.");
                return null;
            }
            if (this.transformations == null) {
                this.transformations = new ArrayList(2);
            }
            this.transformations.add(transformation);
            return this;
        }
    }

    private Request(Uri uri, int i, String str, List<Transformation> list, int i2, int i3, boolean z, boolean z2, boolean z3, float f, float f2, float f3, boolean z4, Bitmap.Config config, Picasso.Priority priority) {
        this.uri = uri;
        this.resourceId = i;
        this.stableKey = str;
        if (list == null) {
            this.transformations = null;
        } else {
            this.transformations = Collections.unmodifiableList(list);
        }
        this.targetWidth = i2;
        this.targetHeight = i3;
        this.centerCrop = z;
        this.centerInside = z2;
        this.onlyScaleDown = z3;
        this.rotationDegrees = f;
        this.rotationPivotX = f2;
        this.rotationPivotY = f3;
        this.hasRotationPivot = z4;
        this.config = config;
        this.priority = priority;
    }

    public String getName() {
        Uri uri = this.uri;
        return uri != null ? String.valueOf(uri.getPath()) : Integer.toHexString(this.resourceId);
    }

    public boolean hasCustomTransformations() {
        return this.transformations != null;
    }

    public boolean hasSize() {
        return (this.targetWidth == 0 && this.targetHeight == 0) ? false : true;
    }

    public String logId() {
        long jNanoTime = System.nanoTime() - this.started;
        if (jNanoTime > TOO_LONG_LOG) {
            StringBuilder sb = new StringBuilder();
            sb.append(plainId());
            sb.append('+');
            return FileInsert$$ExternalSyntheticOutline0.m(sb, jNanoTime / 1000000000, 's');
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(plainId());
        sb2.append('+');
        return FileInsert$$ExternalSyntheticOutline0.m(jNanoTime / 1000000, "ms", sb2);
    }

    public boolean needsMatrixTransform() {
        return hasSize() || this.rotationDegrees != 0.0f;
    }

    public boolean needsTransformation() {
        return needsMatrixTransform() || hasCustomTransformations();
    }

    public String plainId() {
        return FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder("[R"), this.id, ']');
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Request{");
        int i = this.resourceId;
        if (i > 0) {
            sb.append(i);
        } else {
            sb.append(this.uri);
        }
        List<Transformation> list = this.transformations;
        if (list != null && !list.isEmpty()) {
            for (Transformation transformation : this.transformations) {
                sb.append(' ');
                sb.append(transformation.key());
            }
        }
        if (this.stableKey != null) {
            sb.append(" stableKey(");
            sb.append(this.stableKey);
            sb.append(')');
        }
        if (this.targetWidth > 0) {
            sb.append(" resize(");
            sb.append(this.targetWidth);
            sb.append(',');
            sb.append(this.targetHeight);
            sb.append(')');
        }
        if (this.centerCrop) {
            sb.append(" centerCrop");
        }
        if (this.centerInside) {
            sb.append(" centerInside");
        }
        if (this.rotationDegrees != 0.0f) {
            sb.append(" rotation(");
            sb.append(this.rotationDegrees);
            if (this.hasRotationPivot) {
                sb.append(" @ ");
                sb.append(this.rotationPivotX);
                sb.append(',');
                sb.append(this.rotationPivotY);
            }
            sb.append(')');
        }
        if (this.config != null) {
            sb.append(' ');
            sb.append(this.config);
        }
        sb.append('}');
        return sb.toString();
    }
}
