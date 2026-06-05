package com.urbandroid.sleep.location;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.urbandroid.common.util.math.sun.LatLonPoint;
import com.urbandroid.common.util.math.sun.SunPosition;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.ResourceUtil;

/* JADX INFO: loaded from: classes.dex */
public class LocationView extends View {
    int height;
    private ILocationListener listener;
    private Location location;
    int width;

    public interface ILocationListener {
        void updateLocation(Location location);
    }

    public LocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
        initLocation();
    }

    private void change(MotionEvent motionEvent) {
        int iRound = Math.round(motionEvent.getX());
        int iRound2 = Math.round(motionEvent.getY());
        int iMax = Math.max(Math.min(iRound, this.width - 1), 1);
        int iMax2 = Math.max(Math.min(iRound2, this.height - 1), 1);
        Location location = new Location(getLat(iMax2), getLon(iMax));
        this.location = location;
        this.listener.updateLocation(location);
        invalidate();
    }

    private double getLat(int i) {
        return ((((double) i) * (-180.0d)) / ((double) this.height)) + 90.0d;
    }

    private double getLon(int i) {
        return ((((double) i) * 360.0d) / ((double) this.width)) - 180.0d;
    }

    private int getX(double d) {
        return (int) ((d + 180.0d) * (((double) this.width) / 360.0d));
    }

    private int getY(double d) {
        return (int) ((90.0d - d) * (((double) this.height) / 180.0d));
    }

    private void initLocation() {
        this.location = SharedApplicationContext.getSettings().getLocation();
    }

    public Location getLocation() {
        return this.location;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Canvas canvas2;
        super.onDraw(canvas);
        Bitmap bitmap = ((BitmapDrawable) getResources().getDrawable(R.drawable.world)).getBitmap();
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3.0f);
        this.width = canvas.getWidth();
        int iRound = Math.round((canvas.getWidth() / bitmap.getWidth()) * bitmap.getHeight());
        this.height = iRound;
        canvas.drawBitmap(Bitmap.createScaledBitmap(bitmap, this.width, iRound, true), 0.0f, 0.0f, paint);
        Bitmap bitmap2 = ResourceUtil.getBitmap(getContext(), R.drawable.ic_action_newmoon);
        int width = bitmap2.getWidth() / 2;
        LatLonPoint latLonPointSunPosition = SunPosition.sunPosition(System.currentTimeMillis());
        double degrees = Math.toDegrees(latLonPointSunPosition.getLat());
        double degrees2 = Math.toDegrees(latLonPointSunPosition.getLon());
        canvas.drawBitmap(ResourceUtil.getBitmap(getContext(), R.drawable.ic_action_sun), getX(degrees2) - width, getY(degrees) - width, paint);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#990099CC"));
        android.location.Location location = new android.location.Location("");
        location.setLatitude(degrees);
        location.setLongitude(degrees2);
        for (int i = 0; i < this.width; i += 6) {
            int i2 = 0;
            while (i2 < this.height) {
                double lat = getLat(i2);
                double lon = getLon(i);
                android.location.Location location2 = new android.location.Location("");
                location2.setLatitude(lat);
                location2.setLongitude(lon);
                if (location2.distanceTo(location) > 1.001879E7d) {
                    canvas2 = canvas;
                    canvas2.drawRect(i - 3, i2 - 3, i + 3, i2 + 3, paint);
                } else {
                    canvas2 = canvas;
                }
                i2 += 6;
                canvas = canvas2;
            }
        }
        Canvas canvas3 = canvas;
        Location location3 = this.location;
        if (location3 != null) {
            float x = getX(location3.getLon()) - width;
            float y = getY(this.location.getLat()) - width;
            canvas3.drawBitmap(bitmap2, x, y, paint);
            canvas3.drawBitmap(bitmap2, x, y, paint);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            change(motionEvent);
            return false;
        }
        if (action != 2) {
            return super.onTouchEvent(motionEvent);
        }
        change(motionEvent);
        return false;
    }

    public void setListener(ILocationListener iLocationListener) {
        this.listener = iLocationListener;
    }
}
