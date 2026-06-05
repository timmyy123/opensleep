package com.urbandroid.sleep.graph;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.preference.PreferenceManager;
import android.util.AttributeSet;
import android.view.View;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.domain.interval.Interval;
import com.urbandroid.sleep.graph.IntervalStyle;
import com.urbandroid.sleep.gui.CanvasExKt;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.PercentileCalculator;
import com.urbandroid.util.ResourceUtil;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class GraphView extends View {
    private int axisPadding;
    private Paint bgPaint;
    private Bitmap blurBitmap;
    private int cardColor;
    private CornerPathEffect cornerPath;
    private boolean doBlur;
    private boolean doClipping;
    private boolean doDpi;
    private boolean doDrawAxisLine;
    private boolean doDrawGraphLine;
    private boolean doDrawHandles;
    private boolean doGradient;
    private boolean doGradientLeftRight;
    private boolean doMirrorLine;
    private boolean doTrimming;
    private boolean drawAverage;
    private boolean drawGradientBackground;
    private boolean drawGraph;
    private boolean drawIntervals;
    private boolean drawTimeSeries;
    private boolean drawXAxis;
    private boolean drawXAxisBars;
    private boolean drawYAxis;
    private boolean exactFit;
    private boolean forceXAxisOffset;
    private long from;
    private int gradientFullColor;
    private Paint gradientPaint;
    private Paint gradientPaintVertical;
    private Paint gradientPaintVerticalRight;
    private int gradientTransColor;
    private Bitmap handleLeft;
    private Bitmap handleRight;
    private Collection<IntervalStyle> intervalStyles;
    private Paint markerPaint;
    private Map<String, Paint> paintCache;
    List<Rect> rects;
    private boolean rotateYAxisLabels;
    private float selectPoint1;
    private float selectPoint1Percent;
    private float selectPoint2;
    private float selectPoint2Percent;
    private Collection<Interval> selectableIntervals;
    private int sleepGraphColor;
    private int sleepGraphLineColor;
    private int textColor;
    private int textOutlineColor;
    private Typeface tf;
    private Collection<TimeSeries> timeSeries;
    private long to;
    private float trimMultipleLimit;
    private Float[] values;
    private IAxisLabels<Float> xAxisLabels;
    private int xAxisOffsetDpi;
    private IAxisLabels<Float> yAxisLabels;
    private float zoomPoint1;
    private float zoomPoint2;

    public class PointTransformer {

        /* JADX INFO: renamed from: data, reason: collision with root package name */
        private GraphData f65data;
        private float maxX;
        private float maxY;
        private float minDataX;
        private float minX;
        private float minY;
        private float rangeX;
        private float xSizing;
        private float ySizing;

        public PointTransformer(GraphData graphData, int i, int i2, int i3, int i4) {
            float f = i2 - i;
            float f2 = i4 - i3;
            this.rangeX = graphData.getXDistance();
            float maxY = graphData.getMaxY();
            if (GraphView.this.trimMultipleLimit > 0.0f && GraphView.this.doTrimming) {
                maxY = Math.min(maxY - graphData.getMinY(), (GraphView.this.trimMultipleLimit * graphData.getYAverage()) - graphData.getMinY());
            }
            maxY = GraphView.this.exactFit ? Math.max(graphData.getMaxY() - graphData.getMinY(), maxY) : maxY;
            maxY = maxY < 0.01f ? 0.01f : maxY;
            if (this.rangeX < 1.0f) {
                this.rangeX = 1.0f;
            }
            this.minDataX = graphData.getMinX();
            this.minX = i;
            this.minY = i3;
            this.maxX = i2;
            this.maxY = i4;
            this.xSizing = f / this.rangeX;
            this.ySizing = f2 / maxY;
            this.f65data = graphData;
        }

        public float getMaxX() {
            return this.maxX;
        }

        public float getMaxY() {
            return this.maxY;
        }

        public float getMinX() {
            return this.minX;
        }

        public float getMinY() {
            return this.minY;
        }

        public float getTransformedX(float f) {
            float f2 = this.minDataX;
            float f3 = f - f2;
            float f4 = this.rangeX;
            if (f3 > f4 / 2.0f) {
                return this.maxX - (((f4 - f) - f2) * this.xSizing);
            }
            return ((f - f2) * this.xSizing) + this.minX;
        }

        public float getTransformedY(float f) {
            float f2 = this.maxY;
            return Math.min(f2, f2 - ((f - this.f65data.getMinY()) * this.ySizing));
        }
    }

    public class TimeSeriesEntry {
        String label;
        float x;
        float y;

        public TimeSeriesEntry(float f, float f2, String str) {
            this.x = f;
            this.y = f2;
            this.label = str;
        }
    }

    public GraphView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.values = new Float[0];
        this.timeSeries = new LinkedList();
        this.intervalStyles = new LinkedList();
        this.axisPadding = 16;
        this.rotateYAxisLabels = false;
        this.selectPoint1Percent = -1.0f;
        this.selectPoint1 = -1.0f;
        this.selectPoint2Percent = -1.0f;
        this.selectPoint2 = -1.0f;
        this.zoomPoint1 = -1.0f;
        this.zoomPoint2 = -1.0f;
        this.trimMultipleLimit = 0.0f;
        this.drawAverage = false;
        this.doBlur = false;
        this.drawGraph = true;
        this.drawGradientBackground = false;
        this.drawIntervals = true;
        this.drawTimeSeries = false;
        this.drawYAxis = true;
        this.drawXAxisBars = true;
        this.drawXAxis = false;
        this.forceXAxisOffset = true;
        this.xAxisOffsetDpi = 24;
        this.doTrimming = true;
        this.doDrawAxisLine = false;
        this.doMirrorLine = false;
        this.doGradient = false;
        this.doGradientLeftRight = false;
        this.doDrawHandles = false;
        this.doDpi = true;
        this.doDrawGraphLine = false;
        this.doClipping = false;
        this.exactFit = false;
        this.paintCache = new HashMap();
        this.cornerPath = new CornerPathEffect(getDip(50));
        this.rects = new ArrayList();
        this.bgPaint = null;
        this.gradientPaint = null;
        this.gradientPaintVertical = null;
        this.gradientPaintVerticalRight = null;
        this.tf = Typeface.create("sans-serif-condensed-medium", 0);
        this.cardColor = ColorUtil.i(context, R.color.graph_time_segments);
        this.gradientFullColor = ColorUtil.i(context, R.color.bg_card);
        this.gradientTransColor = ColorUtil.i(context, R.color.bg_card_trans);
        this.sleepGraphLineColor = ColorUtil.i(context, R.color.primary);
        this.sleepGraphColor = ColorUtil.i(context, R.color.actigraph);
        this.textColor = ColorUtil.i(getContext(), R.color.primary);
        this.textOutlineColor = ColorUtil.i(getContext(), R.color.graph_time_segments);
        try {
            this.trimMultipleLimit = Float.parseFloat(PreferenceManager.getDefaultSharedPreferences(context).getString("trim_graph", "3"));
        } catch (Exception unused) {
        }
        ActivityUtils.setLayerTypeSoftware(this);
        this.handleLeft = ResourceUtil.getBitmap(getContext(), R.drawable.handle_left);
        this.handleRight = ResourceUtil.getBitmap(getContext(), R.drawable.handle_right);
    }

    private Path createMirrorPathFromData(GraphData graphData, PointTransformer pointTransformer, boolean z) {
        Path path = new Path();
        float f = 0.0f;
        path.moveTo(0.0f, pointTransformer.getMaxY() / 2.0f);
        ArrayList<Float[]> arrayList = new ArrayList();
        float f2 = 0.0f;
        for (Float[] fArr : graphData) {
            float transformedX = pointTransformer.getTransformedX(fArr[0].floatValue());
            float transformedY = (pointTransformer.getTransformedY(fArr[1].floatValue()) / 2.0f) + getDip(3);
            path.lineTo(transformedX, transformedY);
            arrayList.add(fArr);
            f = transformedX;
            f2 = transformedY;
        }
        Collections.reverse(arrayList);
        path.lineTo(f, f2);
        path.lineTo(pointTransformer.getMaxX(), pointTransformer.getMaxY() / 2.0f);
        for (Float[] fArr2 : arrayList) {
            path.lineTo(pointTransformer.getTransformedX(fArr2[0].floatValue()), (pointTransformer.getMaxY() - (pointTransformer.getTransformedY(fArr2[1].floatValue()) / 2.0f)) - getDip(3));
        }
        return path;
    }

    private Path createPathFromData(GraphData graphData, PointTransformer pointTransformer, boolean z) {
        Path path = new Path();
        float f = 0.0f;
        boolean z2 = true;
        float f2 = 0.0f;
        for (Float[] fArr : graphData) {
            float transformedX = pointTransformer.getTransformedX(fArr[0].floatValue());
            float transformedY = pointTransformer.getTransformedY(fArr[1].floatValue());
            if (z2) {
                path.moveTo(transformedX, transformedY);
                z2 = false;
            } else {
                path.lineTo(transformedX, transformedY);
            }
            f2 = transformedY;
            f = transformedX;
        }
        path.lineTo(f, f2);
        if (z) {
            path.lineTo(pointTransformer.getMaxX(), pointTransformer.getMaxY() - 1.0f);
            path.lineTo(pointTransformer.getMaxX() - 1.0f, pointTransformer.getMaxY());
            path.lineTo(pointTransformer.getMinX() + 1.0f, pointTransformer.getMaxY());
            path.lineTo(pointTransformer.getMinX(), pointTransformer.getMaxY() - 1.0f);
        }
        return path;
    }

    private void drawAverage(float f, GraphData graphData, PointTransformer pointTransformer, Canvas canvas, int i, int i2) {
        Paint paint = new Paint();
        paint.setStrokeWidth(getDip(2));
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.STROKE);
        setPaintColor(paint, i);
        Path path = new Path();
        path.moveTo(pointTransformer.getMinX(), pointTransformer.getTransformedY(f) - getDip(i2));
        path.lineTo(pointTransformer.getMaxX(), pointTransformer.getTransformedY(f) - getDip(i2));
        canvas.drawPath(path, paint);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x048e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x03ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private <C> void drawInterval(IntervalStyle intervalStyle, PointTimeTransformer pointTimeTransformer, Canvas canvas) {
        int i;
        Paint paint;
        float fMax;
        Canvas canvas2;
        float fMax2;
        Resources resources;
        int patternDrawable;
        IntervalStyle intervalStyle2 = intervalStyle;
        PointTimeTransformer pointTimeTransformer2 = pointTimeTransformer;
        if (intervalStyle2.getIntervals() == null) {
            return;
        }
        if (!intervalStyle2.getIsOnlyInZoom() || isZoom()) {
            float f = -1000.0f;
            for (Interval interval : intervalStyle2.getIntervals()) {
                Paint paint2 = getPaint(this.paintCache, "intervalRectPaint");
                if (intervalStyle2.getIsFilterColor()) {
                    paint2.setColorFilter(new PorterDuffColorFilter(intervalStyle2.getColor(getContext()), PorterDuff.Mode.MULTIPLY));
                }
                paint2.setAntiAlias(true);
                setPaintColor(paint2, intervalStyle2.getColor(getContext()));
                BitmapDrawable bitmapDrawable = (BitmapDrawable) (this.doDpi ? getResources().getDrawable(R.drawable.pattern) : getResources().getDrawable(R.drawable.pattern_nodpi));
                if (intervalStyle2.getPatternDrawable() == R.drawable.pattern2) {
                    bitmapDrawable = (BitmapDrawable) (this.doDpi ? getResources().getDrawable(R.drawable.pattern2) : getResources().getDrawable(R.drawable.pattern2_nodpi));
                }
                if (intervalStyle2.getPatternDrawable() == R.drawable.pattern3) {
                    bitmapDrawable = (BitmapDrawable) (this.doDpi ? getResources().getDrawable(R.drawable.pattern3) : getResources().getDrawable(R.drawable.pattern3_nodpi));
                }
                Bitmap bitmap = bitmapDrawable.getBitmap();
                Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                paint2.setShader(new BitmapShader(bitmap, tileMode, tileMode));
                paint2.setColorFilter(new PorterDuffColorFilter(intervalStyle2.getColor(getContext()), PorterDuff.Mode.MULTIPLY));
                int dip = getDip(intervalStyle2.getStroke());
                Paint paint3 = getPaint(this.paintCache, "intervalMarkerPaint");
                paint3.setStrokeWidth(dip);
                paint3.setStyle(Paint.Style.STROKE);
                paint3.setAntiAlias(true);
                setPaintColor(paint3, intervalStyle2.getColor(getContext()));
                Paint paint4 = getPaint(this.paintCache, "intervalBarPaint");
                Paint.Style style = Paint.Style.FILL;
                paint4.setStyle(style);
                paint4.setAntiAlias(true);
                setPaintColor(paint4, intervalStyle2.getColor(getContext()));
                Paint paint5 = getPaint(this.paintCache, "intervalBgPaint", paint3);
                paint5.setStrokeWidth(dip * 3);
                setPaintColor(paint5, Color.argb(200, 0, 0, 0));
                Paint paint6 = getPaint(this.paintCache, "intervalBg2Paint", paint5);
                paint6.setStyle(style);
                setPaintColor(paint6, this.gradientFullColor);
                Paint paint7 = getPaint(this.paintCache, "intervalTextPaint");
                paint7.setAntiAlias(true);
                setPaintColor(paint7, intervalStyle2.getColor(getContext()));
                paint7.setTextAlign(Paint.Align.CENTER);
                paint7.setColorFilter(new PorterDuffColorFilter(ColorUtil.i(getContext(), R.color.primaryBright), PorterDuff.Mode.DST_IN));
                setPaintColor(paint7, ColorUtil.i(getContext(), R.color.primaryBright));
                Bitmap bitmap2 = intervalStyle2.getDrawable() > 0 ? ResourceUtil.getBitmap(getContext(), intervalStyle2.getDrawable()) : null;
                int size = intervalStyle2.getSize();
                int fromSize = intervalStyle2.getFromSize();
                float offset = (intervalStyle.getOffset() / 100.0f) * (pointTimeTransformer2.getMaxY() - pointTimeTransformer2.getMinY());
                float transformedX = pointTimeTransformer2.getTransformedX(interval.getFrom());
                float transformedX2 = pointTimeTransformer2.getTransformedX(interval.getTo());
                if (intervalStyle.getStyle() == IntervalStyle.Style.RECT) {
                    if (intervalStyle.getPatternDrawable() > 0) {
                        if (this.doDpi) {
                            resources = getResources();
                            patternDrawable = intervalStyle.getPatternDrawable();
                        } else {
                            resources = getResources();
                            patternDrawable = R.drawable.pattern_nodpi;
                        }
                        paint2.setShader(new BitmapShader(((BitmapDrawable) resources.getDrawable(patternDrawable)).getBitmap(), tileMode, tileMode));
                    }
                    float f2 = dip / 2;
                    float maxY = (pointTimeTransformer2.getMaxY() - offset) - f2;
                    float maxY2 = (pointTimeTransformer2.getMaxY() - offset) + f2;
                    i = size;
                    canvas.drawRect(transformedX, maxY, transformedX2, maxY2, paint2);
                    fMax = transformedX;
                    paint = paint3;
                } else {
                    i = size;
                    if (intervalStyle.getStyle() == IntervalStyle.Style.LINE) {
                        float height = bitmap2 != null ? bitmap2.getHeight() / 2.0f : 0.0f;
                        canvas.drawLine(transformedX, (pointTimeTransformer2.getMaxY() - offset) + height, transformedX2, (pointTimeTransformer2.getMaxY() - offset) + height, paint3);
                        float f3 = i;
                        canvas.drawLine(transformedX, ((pointTimeTransformer2.getMaxY() - f3) - offset) + height, transformedX, ((pointTimeTransformer2.getMaxY() + f3) - offset) + height, paint3);
                        canvas.drawLine(transformedX2, ((pointTimeTransformer2.getMaxY() - f3) - offset) + height, transformedX2, ((pointTimeTransformer2.getMaxY() + f3) - offset) + height, paint3);
                        canvas2 = canvas;
                        fMax = transformedX;
                        paint = paint3;
                    } else if (intervalStyle.getStyle() == IntervalStyle.Style.MARKER) {
                        if (bitmap2 != null) {
                            float fRound = Math.round(bitmap2.getWidth() / 2.0f);
                            fMax2 = Math.max(pointTimeTransformer2.getMinX() + fRound, Math.min(pointTimeTransformer2.getMaxX() - fRound, transformedX));
                        } else {
                            fMax2 = transformedX;
                        }
                        canvas.drawLine(transformedX, pointTimeTransformer2.getMaxY(), fMax2, pointTimeTransformer2.getMaxY() - offset, paint3);
                        paint = paint3;
                        fMax = transformedX;
                    } else {
                        paint = paint3;
                        if (intervalStyle.getStyle() == IntervalStyle.Style.BAR) {
                            canvas.drawRect(transformedX, fromSize == 0 ? pointTimeTransformer2.getMaxY() : pointTimeTransformer2.getMaxY() - ((fromSize / 100.0f) * (pointTimeTransformer2.getMaxY() - pointTimeTransformer2.getMinY())), transformedX2, pointTimeTransformer2.getMaxY() - ((i / 100.0f) * (pointTimeTransformer2.getMaxY() - pointTimeTransformer2.getMinY())), paint4);
                            fMax = transformedX;
                            canvas2 = canvas;
                        } else {
                            fMax = transformedX;
                            canvas2 = canvas;
                            if (intervalStyle.getStyle() == IntervalStyle.Style.BAR_ROUND) {
                                CanvasExKt.drawTopRoundRect(canvas2, new RectF(fMax, fromSize == 0 ? pointTimeTransformer.getMaxY() : pointTimeTransformer.getMaxY() - ((fromSize / 100.0f) * (pointTimeTransformer.getMaxY() - pointTimeTransformer.getMinY())), transformedX2, pointTimeTransformer.getMaxY() - ((i / 100.0f) * (pointTimeTransformer.getMaxY() - pointTimeTransformer.getMinY()))), getDip(4), paint4);
                            } else if (intervalStyle.getStyle() == IntervalStyle.Style.RANGE) {
                                float maxY3 = pointTimeTransformer.getMaxY();
                                if (fromSize != 0) {
                                    maxY3 -= (fromSize / 100.0f) * (pointTimeTransformer.getMaxY() - pointTimeTransformer.getMinY());
                                }
                                canvas2.drawRoundRect(new RectF(fMax, maxY3, transformedX2, pointTimeTransformer.getMaxY() - ((i / 100.0f) * (pointTimeTransformer.getMaxY() - pointTimeTransformer.getMinY()))), getDip(4), getDip(4), paint4);
                            }
                        }
                    }
                    if (bitmap2 == null) {
                        IntervalStyle.Style style2 = intervalStyle.getStyle();
                        IntervalStyle.Style style3 = IntervalStyle.Style.POINT;
                        if (style2 == style3 || intervalStyle.getStyle() == IntervalStyle.Style.MARKER) {
                            double width = ((double) (bitmap2.getWidth() / 2.0f)) * 1.5d;
                            float fRound2 = Math.round(bitmap2.getWidth() / 2.0f);
                            fMax = Math.max(pointTimeTransformer.getMinX() + fRound2, Math.min(pointTimeTransformer.getMaxX() - fRound2, fMax));
                            if (intervalStyle.getStyle() != style3) {
                                float f4 = i;
                                float f5 = (float) width;
                                canvas2.drawCircle(fMax, (pointTimeTransformer.getMaxY() + f4) - offset, f5, paint6);
                                canvas2.drawCircle(fMax, (pointTimeTransformer.getMaxY() + f4) - offset, f5, paint);
                                float f6 = fMax - fRound2;
                                canvas2.drawBitmap(bitmap2, f6, ((pointTimeTransformer.getMaxY() + f4) - offset) - fRound2, paint7);
                                canvas2.drawBitmap(bitmap2, f6, ((pointTimeTransformer.getMaxY() + f4) - offset) - fRound2, paint7);
                            } else if (fMax - f > ((double) bitmap2.getWidth()) * 1.2d) {
                                float f7 = fMax - fRound2;
                                float f8 = i;
                                canvas2.drawBitmap(bitmap2, f7, ((pointTimeTransformer.getMaxY() + f8) - offset) - fRound2, paint7);
                                canvas2.drawBitmap(bitmap2, f7, ((pointTimeTransformer.getMaxY() + f8) - offset) - fRound2, paint7);
                                f = fMax;
                            }
                        } else if (fMax - f > ((double) bitmap2.getWidth()) * 1.8d) {
                            canvas2.drawBitmap(bitmap2, fMax, (pointTimeTransformer.getMaxY() - offset) - (bitmap2.getHeight() / 2), paint7);
                            canvas2.drawBitmap(bitmap2, fMax, (pointTimeTransformer.getMaxY() - offset) - (bitmap2.getHeight() / 2), paint7);
                            f = fMax;
                        }
                    }
                    intervalStyle2 = intervalStyle;
                    pointTimeTransformer2 = pointTimeTransformer;
                }
                canvas2 = canvas;
                if (bitmap2 == null) {
                }
                intervalStyle2 = intervalStyle;
                pointTimeTransformer2 = pointTimeTransformer;
            }
        }
    }

    private void drawSelection(float f, float f2, PointTransformer pointTransformer, Canvas canvas, boolean z) {
        if (f == -1.0f || f2 == -1.0f) {
            return;
        }
        float fMin = Math.min(f, f2);
        float fMax = Math.max(f, f2);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        if (z) {
            setPaintColor(paint, ColorUtil.addAlpha(ColorUtil.i(getContext(), R.color.selection), 140));
            Path path = new Path();
            path.moveTo(fMin, pointTransformer.getMinY());
            path.lineTo(fMin, getHeight());
            if (fMax != -1.0f) {
                path.lineTo(fMax, getHeight());
                path.lineTo(fMax, pointTransformer.getMinY());
                path.close();
            }
            if (z) {
                canvas.drawPath(path, paint);
                return;
            }
            return;
        }
        paint.setXfermode(null);
        paint.setStrokeWidth(getDip(2));
        paint.setShader(new LinearGradient(fMin - getDip(1), 0.0f, fMin + getDip(1), canvas.getHeight(), new int[]{ColorUtil.i(getContext(), R.color.transparent), ColorUtil.i(getContext(), R.color.tint), ColorUtil.i(getContext(), R.color.transparent)}, new float[]{0.1f, 0.5f, 0.8f}, Shader.TileMode.CLAMP));
        setPaintColor(paint, ColorUtil.i(getContext(), R.color.tint));
        canvas.drawLine(fMin, 0.0f, fMin, canvas.getHeight(), paint);
        canvas.drawLine(fMax, 0.0f, fMax, canvas.getHeight(), paint);
        if (this.doDrawHandles) {
            canvas.drawBitmap(this.handleLeft, fMin - (this.handleRight.getWidth() / 2.0f), canvas.getHeight() - this.handleLeft.getHeight(), paint);
            canvas.drawBitmap(this.handleRight, fMax - (r0.getWidth() / 2.0f), 0.0f, paint);
        }
        paint.setPathEffect(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x01d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private <C> void drawTimeSerie(TimeSeries timeSeries, PointTransformer pointTransformer, PointTimeTransformer pointTimeTransformer, Canvas canvas, Paint paint) {
        ArrayList arrayList;
        ArrayList arrayList2;
        if (timeSeries.getSeries() == null || timeSeries.getSeries().size() < 3) {
            return;
        }
        Set<Map.Entry<Long, Float>> setEntrySet = timeSeries.getSeries().entrySet();
        Iterator<Map.Entry<Long, Float>> it = setEntrySet.iterator();
        float f = Float.NEGATIVE_INFINITY;
        float f2 = Float.MAX_VALUE;
        while (it.hasNext()) {
            float fScaleYValue = timeSeries.scaleYValue(it.next().getValue().floatValue());
            if (fScaleYValue > f) {
                f = fScaleYValue;
            }
            if (fScaleYValue < f2) {
                f2 = fScaleYValue;
            }
        }
        if (f2 == f) {
            return;
        }
        Float f3 = timeSeries.yRangeMin;
        float fFloatValue = f3 == null ? f2 : f3.floatValue();
        Float f4 = timeSeries.yRangeMax;
        float fFloatValue2 = f4 == null ? f : f4.floatValue();
        paint.setTypeface(this.tf);
        paint.setStrokeWidth(getDip(3));
        paint.setTextSize(getDip(10));
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        Map.Entry<Long, Float> entry = null;
        if (timeSeries.cornerPath) {
            paint.setPathEffect(new CornerPathEffect(getDip(20)));
        } else {
            paint.setPathEffect(null);
        }
        setPaintColor(paint, timeSeries.color);
        Path path = new Path();
        ArrayList arrayList3 = new ArrayList();
        float f5 = 0.0f;
        TimeSeriesEntry timeSeriesEntry = new TimeSeriesEntry(0.0f, 0.0f, "");
        Iterator<Map.Entry<Long, Float>> it2 = setEntrySet.iterator();
        boolean z = false;
        boolean z2 = false;
        boolean z3 = true;
        boolean z4 = true;
        while (it2.hasNext()) {
            Map.Entry<Long, Float> next = it2.next();
            ArrayList arrayList4 = arrayList3;
            float transformedX = pointTimeTransformer.getTransformedX(next.getKey().longValue());
            Iterator<Map.Entry<Long, Float>> it3 = it2;
            float maxY = pointTransformer.getMaxY() - getDip(12);
            float f6 = f5;
            float minY = pointTransformer.getMinY() + getDip(20);
            float fFloatValue3 = next.getValue().floatValue();
            float fScaleYValue2 = timeSeries.scaleYValue(fFloatValue3);
            float dip = ((maxY - (((fScaleYValue2 - fFloatValue) / (fFloatValue2 - fFloatValue)) * (maxY - minY))) + minY) - getDip(20);
            TimeSeriesEntry timeSeriesEntry2 = new TimeSeriesEntry(transformedX, dip, String.valueOf(Math.round(fFloatValue3)));
            boolean z5 = transformedX - timeSeriesEntry.x > ((float) getDip(80)) || (transformedX - timeSeriesEntry.x > ((float) getDip(36)) && Math.abs(dip - timeSeriesEntry.y) > ((float) getDip(56)));
            if (fScaleYValue2 != f) {
                int i = (fScaleYValue2 > f2 ? 1 : (fScaleYValue2 == f2 ? 0 : -1));
            }
            boolean z6 = fScaleYValue2 == f2;
            boolean z7 = fScaleYValue2 == f;
            boolean z8 = Math.abs(f6 - fFloatValue3) >= (f - f2) / 4.0f;
            if ((!z6 || z) && ((!z7 || z2) && !(z5 && z8))) {
                arrayList = arrayList4;
                f5 = f6;
            } else {
                if (z5) {
                    arrayList = arrayList4;
                    arrayList.add(timeSeriesEntry2);
                    if (z6) {
                        z = true;
                    }
                    if (z7) {
                        z2 = true;
                    }
                } else {
                    arrayList = arrayList4;
                    if (z3) {
                        arrayList.remove(timeSeriesEntry);
                        arrayList.add(timeSeriesEntry2);
                        if (z6) {
                            z = true;
                        }
                        if (z7) {
                            timeSeriesEntry = timeSeriesEntry2;
                            z2 = true;
                        }
                    }
                    z3 = fScaleYValue2 == f && fScaleYValue2 != f2;
                    f5 = fFloatValue3;
                }
                timeSeriesEntry = timeSeriesEntry2;
                if (fScaleYValue2 == f) {
                    f5 = fFloatValue3;
                }
            }
            if (z4) {
                path.moveTo(transformedX, dip);
                arrayList2 = arrayList;
                z4 = false;
            } else {
                arrayList2 = arrayList;
                if (!timeSeries.doBreaks || entry == null || next.getKey().longValue() - entry.getKey().longValue() < 900000) {
                    path.lineTo(transformedX, dip);
                } else {
                    canvas.drawPath(path, paint);
                    Path path2 = new Path();
                    path2.moveTo(transformedX, dip);
                    path = path2;
                }
            }
            entry = next;
            arrayList3 = arrayList2;
            it2 = it3;
        }
        ArrayList<TimeSeriesEntry> arrayList5 = arrayList3;
        canvas.drawPath(path, paint);
        if (timeSeries.drawValues) {
            paint.setStyle(Paint.Style.FILL);
            for (TimeSeriesEntry timeSeriesEntry3 : arrayList5) {
                float dip2 = getDip(12);
                float fMin = Math.min(Math.max(timeSeriesEntry3.x, pointTimeTransformer.getMinX() + dip2), pointTimeTransformer.getMaxX() - dip2);
                setPaintColor(paint, timeSeries.color);
                canvas.drawCircle(fMin, timeSeriesEntry3.y - getDip(4), dip2, paint);
                setPaintColor(paint, ColorUtil.i(getContext(), R.color.white));
                canvas.drawText(timeSeriesEntry3.label, fMin, timeSeriesEntry3.y, paint);
            }
        }
    }

    private void drawXAxis(GraphData graphData, PointTransformer pointTransformer, Canvas canvas) {
        Canvas canvas2;
        Paint markerPaint = getMarkerPaint();
        if (this.doBlur || !this.doDrawAxisLine) {
            canvas2 = canvas;
        } else {
            int color = markerPaint.getColor();
            setPaintColor(markerPaint, ColorUtil.i(getContext(), R.color.shade));
            canvas2 = canvas;
            canvas2.drawLine(pointTransformer.getMinX(), pointTransformer.getMaxY(), pointTransformer.getMaxX(), pointTransformer.getMaxY(), markerPaint);
            setPaintColor(markerPaint, color);
        }
        if (this.drawXAxis && this.xAxisLabels != null) {
            int i = 0;
            Typeface typefaceCreate = Typeface.create("sans-serif-condensed-medium", 0);
            Paint paint = getPaint(this.paintCache, "text");
            int i2 = 1;
            paint.setAntiAlias(true);
            setPaintColor(paint, this.textColor);
            Paint.Align align = Paint.Align.LEFT;
            paint.setTextAlign(align);
            paint.setFakeBoldText(true);
            paint.setTextSize(getDip(12));
            paint.setTypeface(typefaceCreate);
            Paint paint2 = getPaint(this.paintCache, "axisOutlined");
            paint2.setStrokeWidth(getDip(2));
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setAntiAlias(true);
            paint2.setTypeface(typefaceCreate);
            setPaintColor(paint2, getTextOutlineColor());
            paint.setTextAlign(align);
            paint2.setFakeBoldText(true);
            paint2.setTextSize(getDip(12));
            AxisBoundaries axisBoundaries = new AxisBoundaries(graphData.getBoundaries(), true);
            ArrayList<Float> arrayList = new ArrayList(this.xAxisLabels.getValues(axisBoundaries));
            Collections.sort(arrayList);
            int i3 = -1;
            for (Float f : arrayList) {
                i3 += i2;
                float transformedX = pointTransformer.getTransformedX(f.floatValue());
                if (transformedX == pointTransformer.getMinX() || transformedX == pointTransformer.getMaxX()) {
                    paint.setTextSize(getDip(14));
                    paint2.setTextSize(getDip(14));
                    i = i2;
                } else {
                    paint.setTextSize(getDip(11));
                    paint2.setTextSize(getDip(11));
                }
                if (i == 0 || i3 == 0 || i3 == arrayList.size() - i2 || (transformedX >= getDip(64) && transformedX <= pointTransformer.getMaxX() - getDip(64))) {
                    if (transformedX < pointTransformer.getMinX() + getDip(this.axisPadding)) {
                        transformedX = pointTransformer.getMinX() + getDip(this.axisPadding);
                    } else if (transformedX > pointTransformer.getMaxX() - getDip(this.axisPadding)) {
                        transformedX = pointTransformer.getMaxX() - getDip(this.axisPadding);
                    }
                    float fMeasureText = transformedX - (paint.measureText(this.xAxisLabels.getLabelAt(axisBoundaries, f)) / 2.0f);
                    canvas2.drawText(this.xAxisLabels.getLabelAt(axisBoundaries, f), fMeasureText, pointTransformer.getMaxY() - getDip(8), paint2);
                    canvas2.drawText(this.xAxisLabels.getLabelAt(axisBoundaries, f), fMeasureText, pointTransformer.getMaxY() - getDip(8), paint);
                }
                i2 = 1;
            }
        }
    }

    private void drawXAxisBars(GraphData graphData, PointTransformer pointTransformer, Canvas canvas, Paint paint) {
        if (this.xAxisLabels == null) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        int i = 1;
        paint.setAntiAlias(true);
        ArrayList arrayList = new ArrayList(this.xAxisLabels.getValues(new AxisBoundaries(graphData.getBoundaries(), true)));
        Collections.sort(arrayList);
        if (arrayList.size() > 2) {
            boolean z = false;
            float f = -1.0f;
            while (i < arrayList.size()) {
                float transformedX = pointTransformer.getTransformedX(((Float) arrayList.get(i)).floatValue());
                setPaintColor(paint, z ? this.cardColor : this.gradientFullColor);
                Canvas canvas2 = canvas;
                canvas2.drawRect(f, pointTransformer.getMinY(), transformedX, pointTransformer.getMaxY(), !z ? paint : getSegmentGradientPaint(pointTransformer.getMaxY(), pointTransformer.getMinY()));
                z = !z;
                i++;
                canvas = canvas2;
                f = transformedX;
            }
            Canvas canvas3 = canvas;
            setPaintColor(paint, z ? this.cardColor : this.gradientFullColor);
            canvas3.drawRect(f, pointTransformer.getMinY(), pointTransformer.getMaxX(), pointTransformer.getMaxY(), paint);
        }
    }

    private void drawYAxis(GraphData graphData, PointTransformer pointTransformer, Canvas canvas) {
        getMarkerPaint();
        if (this.yAxisLabels == null) {
            return;
        }
        int i = 0;
        Typeface typefaceCreate = Typeface.create("sans-serif-condensed-medium", 0);
        Paint paint = getPaint(this.paintCache, "axisText");
        paint.setStrokeWidth(getDip(1));
        paint.setAntiAlias(true);
        setPaintColor(paint, ColorUtil.i(getContext(), R.color.primary));
        Paint.Align align = Paint.Align.LEFT;
        paint.setTextAlign(align);
        paint.setTextSize(getDip(14));
        paint.setFakeBoldText(true);
        paint.setTypeface(typefaceCreate);
        Paint paint2 = getPaint(this.paintCache, "axisOutlined");
        paint2.setStrokeWidth(getDip(2));
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        setPaintColor(paint2, ColorUtil.i(getContext(), R.color.bg_main));
        paint2.setTextAlign(align);
        paint2.setFakeBoldText(true);
        paint2.setTextSize(getDip(14));
        paint2.setTypeface(typefaceCreate);
        AxisBoundaries axisBoundaries = new AxisBoundaries(graphData.getBoundaries(), false);
        boolean z = this.yAxisLabels.getValues(axisBoundaries).size() == 1;
        if (z) {
            Paint.Align align2 = Paint.Align.CENTER;
            paint2.setTextAlign(align2);
            paint.setTextAlign(align2);
        }
        int i2 = 0;
        for (T t : this.yAxisLabels.getValues(axisBoundaries)) {
            float maxY = pointTransformer.getMaxY() - (t.floatValue() * (pointTransformer.getMaxY() - pointTransformer.getMinY()));
            String labelAt = this.yAxisLabels.getLabelAt(axisBoundaries, t);
            Rect rect = new Rect();
            paint.getTextBounds(labelAt, i, labelAt.length(), rect);
            pointTransformer.getMaxY();
            pointTransformer.getMinY();
            Math.abs(rect.height());
            float fAbs = Math.abs(rect.height()) + getDip(4);
            float fMeasureText = paint.measureText(labelAt);
            if (this.rotateYAxisLabels) {
                canvas.save();
                canvas.rotate(-90.0f, pointTransformer.getMinX() + getDip(10), getDip(10) + maxY);
            }
            if (z) {
                float f = maxY + fAbs;
                canvas.drawText(labelAt, (pointTransformer.getMaxX() - pointTransformer.getMinX()) / 2.0f, f, paint2);
                canvas.drawText(labelAt, (pointTransformer.getMaxX() - pointTransformer.getMinX()) / 2.0f, f, paint);
            } else if (i2 % 2 == 1) {
                float f2 = maxY + fAbs;
                canvas.drawText(labelAt, (pointTransformer.getMaxX() - getDip(4)) - fMeasureText, f2, paint2);
                canvas.drawText(labelAt, (pointTransformer.getMaxX() - getDip(4)) - fMeasureText, f2, paint);
            } else {
                float f3 = maxY + fAbs;
                canvas.drawText(labelAt, pointTransformer.getMinX() + getDip(4), f3, paint2);
                canvas.drawText(labelAt, pointTransformer.getMinX() + getDip(4), f3, paint);
            }
            if (this.rotateYAxisLabels) {
                canvas.restore();
            }
            i2++;
            i = 0;
        }
    }

    private void fillGraph(Paint paint, Canvas canvas, Path path) {
        paint.setStyle(Paint.Style.FILL);
        setPaintColor(paint, this.sleepGraphColor);
        canvas.drawPath(path, paint);
    }

    private Paint getBackgroundGradientPaint(float f, float f2) {
        Paint paint = new Paint();
        paint.setShader(new LinearGradient(0.0f, f, 0.0f, f2, this.cardColor, this.gradientFullColor, Shader.TileMode.CLAMP));
        return paint;
    }

    private Paint getBackgroundPaint() {
        if (this.bgPaint == null) {
            Paint paint = new Paint();
            setPaintColor(paint, this.cardColor);
            this.bgPaint = paint;
        }
        return this.bgPaint;
    }

    private float getDensity() {
        if (this.doDpi) {
            return getResources().getDisplayMetrics().density;
        }
        return 1.0f;
    }

    private int getDip(int i) {
        return this.doDpi ? (int) ((i * getResources().getDisplayMetrics().density) + 0.5f) : i;
    }

    private Paint getGradientPaint() {
        if (this.gradientPaint == null) {
            Paint paint = new Paint();
            paint.setShader(new LinearGradient(0.0f, getDip(26), 0.0f, 0.0f, this.gradientTransColor, this.gradientFullColor, Shader.TileMode.CLAMP));
            this.gradientPaint = paint;
        }
        return this.gradientPaint;
    }

    private Paint getMarkerPaint() {
        if (this.markerPaint == null) {
            Paint paint = getPaint(this.paintCache, "axisMarkerPaint");
            this.markerPaint = paint;
            paint.setStrokeWidth(getDip(2));
            this.markerPaint.setAntiAlias(true);
            setPaintColor(this.markerPaint, ColorUtil.i(getContext(), R.color.secondary));
        }
        return this.markerPaint;
    }

    private Paint getPaint(Map<String, Paint> map, String str, Paint paint) {
        if (map.get(str) == null) {
            map.put(str, paint == null ? new Paint() : new Paint(paint));
        }
        Paint paint2 = map.get(str);
        if (this.doBlur && paint2 != null) {
            paint2.setAlpha(12);
        }
        return paint2;
    }

    private PointTransformer getPointTransformerAndPopulateGraphData(GraphData graphData) {
        int width = getWidth() - 5;
        int height = getHeight() - 5;
        graphData.addEquidistant(this.values);
        return new PointTransformer(graphData, 5, width, 5, height);
    }

    private Paint getSegmentGradientPaint(float f, float f2) {
        Paint paint = new Paint();
        int i = this.gradientFullColor;
        paint.setShader(new LinearGradient(0.0f, f, 0.0f, f2, new int[]{i, i, this.cardColor, i, i}, new float[]{0.0f, 0.15f, 0.5f, 0.85f, 1.0f}, Shader.TileMode.CLAMP));
        return paint;
    }

    private Paint getVerticalGradientPaint() {
        if (this.gradientPaintVertical == null) {
            Paint paint = new Paint();
            paint.setShader(new LinearGradient(0.0f, 0.0f, getDip(10), 0.0f, this.gradientFullColor, this.gradientTransColor, Shader.TileMode.CLAMP));
            this.gradientPaintVertical = paint;
        }
        return this.gradientPaintVertical;
    }

    private Paint getVerticalRightGradientPaint(int i) {
        if (this.gradientPaintVerticalRight == null) {
            Paint paint = new Paint();
            paint.setShader(new LinearGradient(i - getDip(10), 0.0f, i, 0.0f, this.gradientTransColor, this.gradientFullColor, Shader.TileMode.CLAMP));
            this.gradientPaintVerticalRight = paint;
        }
        return this.gradientPaintVerticalRight;
    }

    private void setEquidistantValues(Float[] fArr, boolean z) {
        this.exactFit = z;
        if (fArr.length > 10) {
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= fArr.length) {
                    break;
                }
                if (fArr[i].floatValue() <= 0.0f) {
                    i2++;
                }
                i++;
            }
            Float[] fArr2 = (Float[]) Arrays.copyOf(fArr, fArr.length);
            Arrays.sort(fArr2);
            int length = ((fArr2.length - i2) / 20) + i2;
            if (length >= fArr2.length - 1) {
                length = fArr2.length - 1;
            }
            float fFloatValue = length >= 0 ? fArr2[length].floatValue() : 0.0f;
            for (int i3 = 0; i3 < fArr.length; i3++) {
                Float fValueOf = Float.valueOf(Math.abs(fArr[i3].floatValue()));
                fArr[i3] = fValueOf;
                float f = 0.8f * fFloatValue;
                if (fValueOf.floatValue() < f) {
                    fArr[i3] = Float.valueOf(f);
                }
            }
        }
        if (Arrays.equals(fArr, this.values)) {
            return;
        }
        this.values = fArr;
        invalidate();
    }

    private void setPaintColor(Paint paint, int i) {
        paint.setColor(i);
        if (this.doBlur) {
            paint.setAlpha(12);
        }
    }

    public void addIntervalPresentation(IntervalStyle intervalStyle) {
        this.intervalStyles.add(intervalStyle);
    }

    public void addTimeSeries(TimeSeries timeSeries) {
        this.timeSeries.add(timeSeries);
    }

    public void clearSelect() {
        this.selectPoint1 = -1.0f;
        this.selectPoint2 = -1.0f;
        this.selectPoint1Percent = -1.0f;
        this.selectPoint2Percent = -1.0f;
        this.zoomPoint1 = -1.0f;
        this.zoomPoint2 = -1.0f;
        invalidate();
    }

    public float getSelectPoint(float f) {
        return f * getWidth();
    }

    public float getSelectPoint1() {
        return this.selectPoint1;
    }

    public float getSelectPoint1Percent() {
        float f = this.selectPoint1Percent;
        if (f == -1.0f) {
            float f2 = this.zoomPoint1;
            if (f2 >= 0.0f) {
                return f2 / getWidth();
            }
        }
        return f;
    }

    public float getSelectPoint2() {
        return this.selectPoint2;
    }

    public float getSelectPoint2Percent() {
        float f = this.selectPoint2Percent;
        if (f == -1.0f) {
            float f2 = this.zoomPoint2;
            if (f2 >= 0.0f) {
                return f2 / getWidth();
            }
        }
        return f;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Collection<Interval> getSelectedIntervals() {
        boolean z;
        Collection<Interval> collection;
        ArrayList arrayList = new ArrayList();
        if (this.selectableIntervals != null) {
            float f = this.selectPoint1Percent;
            float f2 = this.selectPoint2Percent;
            int i = 0;
            if (f < f2) {
                f2 = this.selectPoint1;
                f = this.selectPoint2;
            } else {
                if (f2 >= f) {
                    if (this.selectPoint1 == -1.0f && this.selectPoint2 == -1.0f) {
                        f = 0.0f;
                        z = true;
                        f2 = 0.0f;
                    }
                }
                PointTransformer pointTransformerAndPopulateGraphData = getPointTransformerAndPopulateGraphData(new GraphData(i, this));
                collection = this.selectableIntervals;
                if (collection != null) {
                    for (Interval interval : collection) {
                        if (z || (pointTransformerAndPopulateGraphData.getTransformedX(interval.getFrom()) > f2 && pointTransformerAndPopulateGraphData.getTransformedX(interval.getTo()) < f)) {
                            arrayList.add(interval);
                        }
                    }
                }
            }
            z = false;
            PointTransformer pointTransformerAndPopulateGraphData2 = getPointTransformerAndPopulateGraphData(new GraphData(i, this));
            collection = this.selectableIntervals;
            if (collection != null) {
            }
        }
        return arrayList;
    }

    public int getTextOutlineColor() {
        return this.textOutlineColor;
    }

    public float getZoomPercentage() {
        return Math.abs(this.zoomPoint2 - this.zoomPoint1) / getWidth();
    }

    public float getZoomPoint1() {
        return this.zoomPoint1;
    }

    public float getZoomPoint1Percent() {
        return this.zoomPoint1 / getWidth();
    }

    public float getZoomPoint2() {
        return this.zoomPoint2;
    }

    public float getZoomPoint2Percent() {
        return this.zoomPoint2 / getWidth();
    }

    public IAxisLabels<Float> getxAxisLabels() {
        return this.xAxisLabels;
    }

    public int getxAxisOffsetDpi() {
        return this.xAxisOffsetDpi;
    }

    public boolean hasIntervalPresentations() {
        return this.intervalStyles.size() > 0;
    }

    public boolean isDrawGradientBackground() {
        return this.drawGradientBackground;
    }

    public boolean isDrawXAxis() {
        return this.drawXAxis;
    }

    public boolean isSelection() {
        return this.selectPoint1 >= 0.0f && this.selectPoint2 >= 0.0f;
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    public boolean isZoom() {
        return this.zoomPoint1 >= 0.0f && this.zoomPoint2 >= 0.0f;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        PointTransformer pointTransformer;
        GraphData graphData;
        int i3;
        int i4;
        int i5;
        Canvas canvas2;
        PointTransformer pointTransformer2;
        int i6;
        Canvas canvas3;
        GraphData graphData2;
        PointTimeTransformer pointTimeTransformer;
        Float fValueOf = Float.valueOf(0.0f);
        Paint paint = getPaint(this.paintCache, "main");
        Float[] fArr = this.values;
        if (fArr == null || fArr.length < 2) {
            this.values = new Float[]{fValueOf, fValueOf};
        }
        int width = getWidth();
        int height = getHeight();
        int i7 = 0;
        if (!this.doBlur && !this.drawGradientBackground) {
            canvas.drawRect(new Rect(0, 0, width, height), getBackgroundPaint());
        }
        float f = this.zoomPoint1;
        if (f >= 0.0f) {
            float fAbs = width / Math.abs(this.zoomPoint2 - f);
            int iMin = 0 - ((int) (Math.min(this.zoomPoint2, this.zoomPoint1) * fAbs));
            width += (int) ((getWidth() - Math.max(this.zoomPoint2, this.zoomPoint1)) * fAbs);
            i = iMin;
        } else {
            i = 0;
        }
        int i8 = width;
        GraphData graphData3 = new GraphData(i7, this);
        graphData3.addEquidistant(this.values);
        int i9 = i;
        PointTransformer pointTransformer3 = new PointTransformer(graphData3, i9, i8, 0, height);
        boolean z = this.drawXAxis;
        int i10 = (z || this.forceXAxisOffset) ? this.xAxisOffsetDpi : 2;
        if (z || this.forceXAxisOffset) {
            i2 = height;
            pointTransformer = new PointTransformer(graphData3, i9, i8, 0, i2 - getDip(i10));
            graphData = graphData3;
            i3 = i9;
            i4 = i8;
        } else {
            pointTransformer = new PointTransformer(graphData3, i9, i8, 0, height);
            i2 = height;
            graphData = graphData3;
            i3 = i9;
            i4 = i8;
        }
        PointTransformer pointTransformer4 = pointTransformer;
        GraphData graphData4 = graphData;
        float f2 = i2;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        PointTimeTransformer pointTimeTransformer2 = new PointTimeTransformer(this, i3, i4, f2, this.from, this.to);
        if (!this.doBlur && this.drawXAxisBars) {
            drawXAxisBars(graphData4, pointTransformer3, canvas, getPaint(this.paintCache, "drawAxis"));
        }
        if (this.doBlur || !isDrawGradientBackground()) {
            i5 = 0;
        } else {
            i5 = 0;
            canvas.drawRect(new Rect(i12, 0, i13, i11), getBackgroundGradientPaint(0.0f, f2));
        }
        if (this.doBlur) {
            canvas2 = canvas;
            pointTransformer2 = pointTransformer3;
        } else {
            try {
                canvas2 = canvas;
                pointTransformer2 = pointTransformer3;
            } catch (Exception e) {
                e = e;
                canvas2 = canvas;
                pointTransformer2 = pointTransformer3;
            }
            try {
                drawSelection(this.selectPoint1, this.selectPoint2, pointTransformer2, canvas2, true);
            } catch (Exception e2) {
                e = e2;
                Logger.logSevere(e);
            }
        }
        Paint paint2 = getPaint(this.paintCache, "blur");
        paint2.setAlpha(PHIpAddressSearchManager.END_IP_SCAN);
        paint2.setColor(ColorUtil.i(getContext(), R.color.bg_card));
        paint2.setStyle(Paint.Style.FILL);
        if (this.doBlur) {
            canvas2.drawPaint(paint2);
        }
        if (this.drawGraph) {
            Path pathCreatePathFromData = createPathFromData(graphData4, pointTransformer4, false);
            Path pathCreateMirrorPathFromData = this.doMirrorLine ? createMirrorPathFromData(graphData4, pointTransformer4, true) : createPathFromData(graphData4, pointTransformer4, true);
            paint.setAntiAlias(true);
            setPaintColor(paint, this.sleepGraphColor);
            if (this.drawXAxis || this.forceXAxisOffset) {
                i6 = i10;
                canvas2.drawRect(new Rect(i12, (i11 - getDip(i6)) - 1, i13, i11), paint);
            } else {
                i6 = i10;
            }
            Paint paint3 = getPaint(this.paintCache, "graphPath", paint);
            paint3.setPathEffect(this.cornerPath);
            fillGraph(paint3, canvas2, pathCreateMirrorPathFromData);
            if (this.doDrawGraphLine) {
                paint3.setShader(null);
                paint3.setStyle(Paint.Style.STROKE);
                paint3.setStrokeWidth(getDip(3));
                setPaintColor(paint3, this.sleepGraphLineColor);
                canvas2.drawPath(pathCreatePathFromData, paint3);
            }
        } else {
            i6 = i10;
        }
        if (this.drawIntervals) {
            for (IntervalStyle intervalStyle : this.intervalStyles) {
                if (intervalStyle.getVisible()) {
                    drawInterval(intervalStyle, pointTimeTransformer2, canvas2);
                }
            }
        }
        if (this.drawTimeSeries) {
            for (TimeSeries timeSeries : this.timeSeries) {
                if (timeSeries.getVisible()) {
                    PointTransformer pointTransformer5 = pointTransformer2;
                    PointTimeTransformer pointTimeTransformer3 = pointTimeTransformer2;
                    drawTimeSerie(timeSeries, pointTransformer5, pointTimeTransformer3, canvas2, getPaint(this.paintCache, "timeSeries"));
                    pointTimeTransformer = pointTimeTransformer3;
                    pointTransformer2 = pointTransformer5;
                } else {
                    pointTimeTransformer = pointTimeTransformer2;
                }
                canvas2 = canvas;
                pointTimeTransformer2 = pointTimeTransformer;
            }
        }
        if (this.doBlur || !this.drawAverage) {
            canvas3 = canvas;
            graphData2 = graphData4;
        } else {
            canvas3 = canvas;
            drawAverage(graphData4.getYAverage(), graphData4, pointTransformer2, canvas3, getResources().getColor(R.color.normal), i6);
            graphData2 = graphData4;
        }
        if (!this.doBlur) {
            if (this.drawGraph && this.trimMultipleLimit > 0.0f && this.doTrimming) {
                canvas3.drawRect(new Rect(i12, 0, i13, getDip(26)), getGradientPaint());
                if (this.doClipping) {
                    canvas3.drawRect(new Rect(i12, i5, i13, getDip(26)), getGradientPaint());
                } else {
                    canvas3.drawRect(new Rect(i12, 0, i13, getDip(26)), getGradientPaint());
                }
            } else if (this.doGradient) {
                canvas3.drawRect(new Rect(i12, 0, i13, getDip(26)), getGradientPaint());
            }
        }
        if (!this.doBlur && (this.drawXAxis || this.doDrawAxisLine)) {
            drawXAxis(graphData2, pointTransformer2, canvas3);
        }
        if (!this.doBlur && this.drawYAxis) {
            drawYAxis(graphData2, pointTransformer2, canvas3);
        }
        if (!this.doBlur) {
            try {
                drawSelection(this.selectPoint1, this.selectPoint2, pointTransformer2, canvas3, false);
            } catch (Exception e3) {
                Logger.logSevere(e3);
            }
        }
        if (!this.doBlur && this.doGradientLeftRight) {
            canvas3.drawRect(new Rect(0, i5, getDip(10), i11), getVerticalGradientPaint());
            canvas3.drawRect(new Rect(i13 - getDip(10), i5, i13, i11), getVerticalRightGradientPaint(i13));
        }
        if (this.doBlur) {
            canvas3.drawBitmap(this.blurBitmap, (canvas3.getWidth() - this.blurBitmap.getWidth()) * 0.5f, (canvas3.getHeight() - this.blurBitmap.getHeight()) * 0.5f, paint2);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (Build.VERSION.SDK_INT >= 29 && this.rects.size() == 0 && this.doDrawHandles) {
            this.rects.add(new Rect(i, i2, i3, getDip(95) + i2));
            this.rects.add(new Rect(i, i4 - getDip(70), i3, i4 + getDip(25)));
            setSystemGestureExclusionRects(this.rects);
        }
    }

    public void resetIntervals() {
        this.intervalStyles.clear();
    }

    public void setAxisPadding(int i) {
        this.axisPadding = i;
    }

    public void setCardColor(int i) {
        this.cardColor = i;
    }

    public void setDoBlur(boolean z) {
        this.doBlur = z;
        if (z) {
            this.blurBitmap = ResourceUtil.getBitmap(getContext(), R.drawable.ic_chart_unlock);
        } else {
            this.blurBitmap = null;
        }
    }

    public void setDoClipping(boolean z) {
        this.doClipping = z;
    }

    public void setDoDpi(boolean z) {
        this.doDpi = z;
    }

    public void setDoDrawAxisLine(boolean z) {
        this.doDrawAxisLine = z;
    }

    public void setDoDrawGraphLine(boolean z) {
        this.doDrawGraphLine = z;
    }

    public void setDoDrawHandles(boolean z) {
        this.doDrawHandles = z;
    }

    public void setDoGradient(boolean z) {
        this.doGradient = z;
    }

    public void setDoLeftRightGradient(boolean z) {
        this.doGradientLeftRight = z;
    }

    public boolean setDoMirrorGraph(boolean z) {
        this.doMirrorLine = z;
        return z;
    }

    public void setDoTrimming(boolean z) {
        this.doTrimming = z;
    }

    public void setDrawAverage(boolean z) {
        this.drawAverage = z;
    }

    public void setDrawGradientBackground(boolean z) {
        this.drawGradientBackground = z;
    }

    public void setDrawGraph(boolean z) {
        this.drawGraph = z;
    }

    public void setDrawIntervals(boolean z) {
        this.drawIntervals = z;
    }

    public void setDrawTimeSeries(boolean z) {
        this.drawTimeSeries = z;
    }

    public void setDrawXAxis(boolean z) {
        this.drawXAxis = z;
    }

    public void setDrawXAxisBars(boolean z) {
        this.drawXAxisBars = z;
    }

    public void setDrawYAxis(boolean z) {
        this.drawYAxis = z;
    }

    public void setForceXAxisOffset(boolean z) {
        this.forceXAxisOffset = z;
    }

    public void setFrom(long j) {
        this.from = j;
    }

    public void setGradientFullColor(int i) {
        this.gradientFullColor = i;
        this.gradientPaint = null;
    }

    public void setGradientTransColor(int i) {
        this.gradientTransColor = i;
        this.gradientPaint = null;
    }

    public void setGraphElementVisibility(String str, Boolean bool) {
        StringBuilder sbM5m = FileInsert$$ExternalSyntheticOutline0.m5m("setGraphElementVisibility: ", str, " ");
        sbM5m.append(bool.toString());
        Logger.logInfo(sbM5m.toString());
        ArrayList<ToggleableGraphElement> arrayList = new ArrayList();
        arrayList.addAll(this.timeSeries);
        arrayList.addAll(this.intervalStyles);
        for (ToggleableGraphElement toggleableGraphElement : arrayList) {
            Logger.logInfo("toggleableGraphElement: " + toggleableGraphElement.getId());
            if (toggleableGraphElement.getId().equals(str)) {
                Logger.logInfo("setting visible: " + bool + " " + str);
                toggleableGraphElement.setVisible(bool.booleanValue());
                invalidate();
                return;
            }
        }
    }

    public void setRotateYAxisLabels(boolean z) {
        this.rotateYAxisLabels = z;
    }

    public void setSelectPoint1(float f) {
        float fMax = Math.max(Math.min(f, getWidth()), 0.0f);
        this.selectPoint1 = fMax;
        float f2 = this.zoomPoint1;
        if (f2 < 0.0f || this.zoomPoint2 < 0.0f) {
            this.selectPoint1Percent = fMax / getWidth();
        } else {
            this.selectPoint1Percent = ((getZoomPercentage() * this.selectPoint1) + f2) / getWidth();
        }
    }

    public void setSelectPoint1Percentage(float f) {
        this.selectPoint1Percent = f;
        float f2 = this.zoomPoint1;
        if (f2 >= 0.0f) {
            float f3 = this.zoomPoint2;
            if (f3 >= 0.0f) {
                this.selectPoint1 = ((f * getWidth()) - this.zoomPoint1) / (Math.abs(f3 - f2) / getWidth());
                return;
            }
        }
        this.selectPoint1 = getWidth() * f;
    }

    public void setSelectPoint2(float f) {
        float fMax = Math.max(Math.min(f, getWidth()), 0.0f);
        this.selectPoint2 = fMax;
        float f2 = this.zoomPoint1;
        if (f2 < 0.0f || this.zoomPoint2 < 0.0f) {
            this.selectPoint2Percent = fMax / getWidth();
        } else {
            this.selectPoint2Percent = ((getZoomPercentage() * this.selectPoint2) + f2) / getWidth();
        }
    }

    public void setSelectPoint2Percentage(float f) {
        this.selectPoint2Percent = f;
        float f2 = this.zoomPoint1;
        if (f2 >= 0.0f) {
            float f3 = this.zoomPoint2;
            if (f3 >= 0.0f) {
                this.selectPoint2 = Math.abs((f * getWidth()) - this.zoomPoint1) / (Math.abs(f3 - f2) / getWidth());
                return;
            }
        }
        this.selectPoint2 = getWidth() * f;
    }

    public void setSelectableIntervals(Collection<Interval> collection) {
        this.selectableIntervals = collection;
    }

    public void setSleepGraphColor(int i) {
        this.sleepGraphColor = i;
    }

    public void setSleepGraphLineColor(int i) {
        this.sleepGraphLineColor = i;
    }

    public void setTextColor(int i) {
        this.textColor = i;
    }

    public void setTextOutlineColor(int i) {
        this.textOutlineColor = i;
    }

    public void setTo(long j) {
        this.to = j;
    }

    public void setTrimMultipleLimit(float f) {
        this.trimMultipleLimit = f;
    }

    public void setXAxisLabels(IAxisLabels<Float> iAxisLabels) {
        this.xAxisLabels = iAxisLabels;
        invalidate();
    }

    public void setYAxisLabels(IAxisLabels<Float> iAxisLabels) {
        this.yAxisLabels = iAxisLabels;
    }

    public void setZoomPoint1(float f) {
        this.zoomPoint1 = f;
        invalidate();
    }

    public void setZoomPoint2(float f) {
        this.zoomPoint2 = f;
        invalidate();
    }

    public void setxAxisOffsetDpi(int i) {
        this.xAxisOffsetDpi = i;
    }

    public class GraphData implements Iterable<Float[]> {
        private GraphValuesBoundaries<Float> boundaries;
        private float count;
        private float sum;
        private LinkedList<Float> xValues;
        private LinkedList<Float> yValues;

        private GraphData() {
            this.xValues = new LinkedList<>();
            this.yValues = new LinkedList<>();
            this.sum = 0.0f;
            this.count = 0.0f;
        }

        private void calculateBoundaries() {
            float fMax;
            if (this.boundaries != null) {
                return;
            }
            Float first = this.xValues.getFirst();
            first.floatValue();
            Float last = this.xValues.getLast();
            last.floatValue();
            PercentileCalculator percentileCalculator = new PercentileCalculator(5, this.yValues);
            float fFloatValue = 100000.0f;
            if (this.yValues.isEmpty()) {
                fMax = 0.0f;
            } else {
                boolean z = GraphView.this.exactFit;
                LinkedList<Float> linkedList = this.yValues;
                if (z) {
                    fMax = Math.max(linkedList.getFirst().floatValue(), 0.0f);
                    fFloatValue = Math.min(this.yValues.getFirst().floatValue(), 100000.0f);
                } else {
                    fMax = Math.max(linkedList.getFirst().floatValue(), 1.0f);
                }
                for (Float f : this.yValues) {
                    if (f.floatValue() > fMax) {
                        fMax = f.floatValue();
                    }
                    if (f.floatValue() < fFloatValue) {
                        fFloatValue = f.floatValue();
                    }
                }
            }
            if (!GraphView.this.exactFit) {
                Float percentileValue = percentileCalculator.getPercentileValue();
                fFloatValue = percentileValue != null ? percentileValue.floatValue() : 0.0f;
            }
            this.boundaries = new GraphValuesBoundaries<>(first, Float.valueOf(fFloatValue), last, Float.valueOf(fMax));
        }

        public void add(float f, float f2) {
            if (!this.xValues.isEmpty() && f < this.xValues.getLast().floatValue()) {
                Utf8$$ExternalSyntheticBUOutline0.m$2(MessageFormat.format("X-values have to be added in an ascending order ({0} vs {1})", Float.valueOf(f), this.xValues.getLast()));
                return;
            }
            if (f2 >= 0.0f) {
                this.sum += f2;
                this.count += 1.0f;
            }
            this.xValues.add(Float.valueOf(f));
            this.yValues.add(Float.valueOf(f2));
            this.boundaries = null;
        }

        public void addEquidistant(Float f) {
            add(this.xValues.isEmpty() ? 0.0f : this.xValues.getLast().floatValue() + 1.0f, f.floatValue());
        }

        public GraphValuesBoundaries<Float> getBoundaries() {
            return this.boundaries;
        }

        public float getMaxY() {
            calculateBoundaries();
            return ((Float) this.boundaries.getMaxY()).floatValue();
        }

        public float getMinX() {
            calculateBoundaries();
            return ((Float) this.boundaries.getMinX()).floatValue();
        }

        public float getMinY() {
            calculateBoundaries();
            return ((Float) this.boundaries.getMinY()).floatValue();
        }

        public float getXDistance() {
            if (this.xValues.isEmpty()) {
                return 0.0f;
            }
            return this.xValues.getLast().floatValue() - this.xValues.getFirst().floatValue();
        }

        public float getYAverage() {
            if (!this.yValues.isEmpty()) {
                float f = this.count;
                if (f != 0.0f) {
                    return this.sum / f;
                }
            }
            return 0.0f;
        }

        @Override // java.lang.Iterable
        public Iterator<Float[]> iterator() {
            return new Iterator<Float[]>() { // from class: com.urbandroid.sleep.graph.GraphView.GraphData.1
                private Iterator<Float> xIterator;
                private Iterator<Float> yIterator;

                {
                    this.xIterator = GraphData.this.xValues.iterator();
                    this.yIterator = GraphData.this.yValues.iterator();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.xIterator.hasNext();
                }

                @Override // java.util.Iterator
                public Float[] next() {
                    return new Float[]{this.xIterator.next(), this.yIterator.next()};
                }

                @Override // java.util.Iterator
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }

        public /* synthetic */ GraphData(int i, GraphView graphView) {
            this();
        }

        public void addEquidistant(Float[] fArr) {
            for (Float f : fArr) {
                f.floatValue();
                addEquidistant(f);
            }
        }
    }

    public class PointTimeTransformer {
        private long from;
        private float maxX;
        private float maxY;
        private float minX;
        private float minY;
        private long to;

        private PointTimeTransformer(float f, float f2, float f3, float f4, long j, long j2) {
            if (j == -1 || j2 == -1) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("From and To not set");
                throw null;
            }
            this.minX = f;
            this.maxX = f2;
            this.minY = f3;
            this.maxY = f4;
            this.from = j;
            this.to = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getMaxX() {
            return this.maxX;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getMaxY() {
            return this.maxY;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getMinX() {
            return this.minX;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getMinY() {
            return this.minY;
        }

        public float getTransformedX(long j) {
            long j2 = this.from;
            if (j < j2) {
                j = j2;
            }
            long j3 = this.to;
            if (j > j3) {
                j = j3;
            }
            float f = this.maxX;
            float f2 = this.minX;
            return (((j - j2) * (f - f2)) / (j3 - j2)) + f2;
        }

        public /* synthetic */ PointTimeTransformer(GraphView graphView, float f, float f2, float f3, long j, long j2) {
            this(f, f2, 0.0f, f3, j, j2);
        }
    }

    private Paint getPaint(Map<String, Paint> map, String str) {
        return getPaint(map, str, null);
    }

    public void setEquidistantValues(List<Float> list, boolean z) {
        setEquidistantValues((Float[]) list.toArray(new Float[0]), z);
    }

    public void setEquidistantValues(float[] fArr, boolean z) {
        Float[] fArr2 = new Float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            fArr2[i] = Float.valueOf(fArr[i]);
        }
        setEquidistantValues(fArr2, z);
    }
}
