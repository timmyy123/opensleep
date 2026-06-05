package com.urbandroid.sleep.addon.stats.chart;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.ServerProtocol;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.AppContextScope;
import com.urbandroid.sleep.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0002&'B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\u0003J\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0015J\n\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\u0010\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020#H\u0014R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/urbandroid/sleep/addon/stats/chart/ScoreRadarPieView;", "Landroid/view/View;", "Lcom/urbandroid/sleep/AppContextScope;", "appContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "maxValue", "", "data", "", "Lcom/urbandroid/sleep/addon/stats/chart/ScoreRadarPieView$DataRecord;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILjava/util/List;)V", "getAppContext", "()Landroid/content/Context;", "gravity", "getGravity", "()I", "setGravity", "(I)V", "circlePaint", "Landroid/graphics/Paint;", "scorePaint", "labelPaint", "getCenterX", "radius", "centerX", "getCenterY", "centerY", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onSaveInstanceState", "Landroid/os/Parcelable;", "onRestoreInstanceState", ServerProtocol.DIALOG_PARAM_STATE, "Companion", "DataRecord", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ScoreRadarPieView extends View implements AppContextScope {
    private final Context appContext;
    private final Paint circlePaint;
    private List<DataRecord> data;
    private int gravity;
    private final Paint labelPaint;
    private int maxValue;
    private final Paint scorePaint;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScoreRadarPieView(Context context, AttributeSet attributeSet, int i, List<DataRecord> list) {
        super(context, attributeSet);
        context.getClass();
        list.getClass();
        this.appContext = context;
        this.maxValue = i;
        this.data = list;
        this.gravity = 49;
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(getArgb(R.color.score_radar_circle));
        paint.setStrokeWidth(getDimDip(R.dimen.chart_radar_score_circle_stroke));
        paint.setAntiAlias(true);
        this.circlePaint = paint;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        this.scorePaint = paint2;
        Paint paint3 = new Paint();
        paint3.setTextAlign(Paint.Align.CENTER);
        paint3.setAntiAlias(true);
        this.labelPaint = paint3;
    }

    private final int getCenterX(int radius, int centerX) {
        int i = this.gravity & 7;
        return i != 3 ? i != 5 ? centerX : getWidth() - radius : radius;
    }

    private final int getCenterY(int radius, int centerY) {
        int i = this.gravity & 112;
        return i != 48 ? i != 80 ? centerY : getHeight() - radius : radius;
    }

    @Override // com.urbandroid.sleep.AppContextScope
    public Context getAppContext() {
        return this.appContext;
    }

    @Override // com.urbandroid.sleep.AppContextScope
    public /* bridge */ int getArgb(int i) {
        return super.getArgb(i);
    }

    @Override // com.urbandroid.sleep.AppContextScope
    public /* bridge */ float getDimDip(int i) {
        return super.getDimDip(i);
    }

    @Override // com.urbandroid.sleep.AppContextScope
    public /* bridge */ int getDip(int i) {
        return super.getDip(i);
    }

    public final int getGravity() {
        return this.gravity;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.getClass();
        boolean z = getResources().getConfiguration().orientation == 2;
        int height = (z ? getHeight() : getWidth()) / 2;
        int dip = z ? getDip(0) : getDip(26);
        int dip2 = z ? getDip(5) : getDip(26);
        int iMax = (height - Math.max(dip, dip2)) - dip;
        int i = iMax / this.maxValue;
        float centerX = getCenterX(dip2 + iMax, getWidth() / 2);
        float centerY = getCenterY((dip * 3) + iMax, getHeight() / 2);
        float size = 360.0f / this.data.size();
        int i2 = 0;
        for (Object obj : this.data) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            DataRecord dataRecord = (DataRecord) obj;
            this.scorePaint.setColor(getArgb(dataRecord.getColor()));
            float value = dataRecord.getValue() * i;
            RectF rectF = new RectF(centerX - value, centerY - value, value + centerX, value + centerY);
            float f = i2 * size;
            Logger.logInfo("Radar: start " + f + " sweep " + size);
            canvas.drawArc(rectF, f, size, true, this.scorePaint);
            i2 = i3;
        }
        Canvas canvas2 = canvas;
        this.circlePaint.setStyle(Paint.Style.STROKE);
        Iterator<Integer> it = CollectionsKt.getIndices(this.data).iterator();
        while (it.hasNext()) {
            int iNextInt = ((IntIterator) it).nextInt();
            canvas2.save();
            canvas2.rotate(iNextInt * size, centerX, centerY);
            canvas2.drawLine(centerX, centerY, centerX + iMax, centerY, this.circlePaint);
            canvas2.restore();
        }
        Iterator<Integer> it2 = new IntRange(1, this.maxValue).iterator();
        while (it2.hasNext()) {
            canvas2.drawCircle(centerX, centerY, ((IntIterator) it2).nextInt() * i, this.circlePaint);
        }
        this.circlePaint.setStyle(Paint.Style.FILL);
        canvas2.drawCircle(centerX, centerY, getDip(4), this.circlePaint);
        this.labelPaint.setTextSize(height / 12);
        int i4 = 0;
        for (Object obj2 : this.data) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            DataRecord dataRecord2 = (DataRecord) obj2;
            float dip3 = ((this.maxValue * i) - (i / 2)) - getDip(2);
            RectF rectF2 = new RectF(centerX - dip3, centerY - dip3, dip3 + centerX, dip3 + centerY);
            Path path = new Path();
            path.addArc(rectF2, i4 * size, size);
            this.labelPaint.setColor(getArgb(dataRecord2.getValue() >= this.maxValue ? R.color.score_label_max : R.color.score_label));
            canvas2.drawTextOnPath(dataRecord2.getName(), path, 0.0f, 8.0f, this.labelPaint);
            canvas2 = canvas;
            i4 = i5;
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        state.getClass();
        if (!(state instanceof Bundle)) {
            super.onRestoreInstanceState(state);
            return;
        }
        Bundle bundle = (Bundle) state;
        this.maxValue = bundle.getInt("max_value", this.maxValue);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("data");
        parcelableArrayList.getClass();
        this.data = parcelableArrayList;
        super.onRestoreInstanceState(bundle.getParcelable("super_state"));
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("super_state", super.onSaveInstanceState());
        bundle.putInt("max_value", this.maxValue);
        bundle.putParcelableArrayList("data", new ArrayList<>(this.data));
        return bundle;
    }

    public final void setGravity(int i) {
        this.gravity = i;
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001!B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J.\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0003\u0010\u0006\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0011J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010\u0011R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b \u0010\u0011¨\u0006\""}, d2 = {"Lcom/urbandroid/sleep/addon/stats/chart/ScoreRadarPieView$DataRecord;", "Landroid/os/Parcelable;", "", "name", "", SDKConstants.PARAM_VALUE, "color", "<init>", "(Ljava/lang/String;II)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "copy", "(Ljava/lang/String;II)Lcom/urbandroid/sleep/addon/stats/chart/ScoreRadarPieView$DataRecord;", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "I", "getValue", "getColor", "CREATOR", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class DataRecord implements Parcelable {

        /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int color;
        private final String name;
        private final int value;

        /* JADX INFO: renamed from: com.urbandroid.sleep.addon.stats.chart.ScoreRadarPieView$DataRecord$CREATOR, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/urbandroid/sleep/addon/stats/chart/ScoreRadarPieView$DataRecord$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/urbandroid/sleep/addon/stats/chart/ScoreRadarPieView$DataRecord;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/urbandroid/sleep/addon/stats/chart/ScoreRadarPieView$DataRecord;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion implements Parcelable.Creator<DataRecord> {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public DataRecord createFromParcel(Parcel parcel) {
                parcel.getClass();
                return new DataRecord(parcel);
            }

            private Companion() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public DataRecord[] newArray(int size) {
                return new DataRecord[size];
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public DataRecord(Parcel parcel) {
            parcel.getClass();
            String string = parcel.readString();
            string.getClass();
            this(string, parcel.readInt(), parcel.readInt());
        }

        public static /* synthetic */ DataRecord copy$default(DataRecord dataRecord, String str, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = dataRecord.name;
            }
            if ((i3 & 2) != 0) {
                i = dataRecord.value;
            }
            if ((i3 & 4) != 0) {
                i2 = dataRecord.color;
            }
            return dataRecord.copy(str, i, i2);
        }

        public final DataRecord copy(String name, int value, int color) {
            name.getClass();
            return new DataRecord(name, value, color);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DataRecord)) {
                return false;
            }
            DataRecord dataRecord = (DataRecord) other;
            return Intrinsics.areEqual(this.name, dataRecord.name) && this.value == dataRecord.value && this.color == dataRecord.color;
        }

        public final int getColor() {
            return this.color;
        }

        public final String getName() {
            return this.name;
        }

        public final int getValue() {
            return this.value;
        }

        public int hashCode() {
            return Integer.hashCode(this.color) + FileInsert$$ExternalSyntheticOutline0.m(this.value, this.name.hashCode() * 31, 31);
        }

        public String toString() {
            String str = this.name;
            return FileInsert$$ExternalSyntheticOutline0.m(this.color, ")", Fragment$$ExternalSyntheticOutline1.m(this.value, "DataRecord(name=", str, ", value=", ", color="));
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            parcel.getClass();
            parcel.writeString(this.name);
            parcel.writeInt(this.value);
            parcel.writeInt(this.color);
        }

        public DataRecord(String str, int i, int i2) {
            str.getClass();
            this.name = str;
            this.value = i;
            this.color = i2;
        }
    }

    public /* synthetic */ ScoreRadarPieView(Context context, AttributeSet attributeSet, int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 5 : i, list);
    }
}
