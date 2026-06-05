package com.getpebble.android.kit.util;

import android.content.Context;
import com.getpebble.android.kit.Constants;
import com.getpebble.android.kit.PebbleKit;

/* JADX INFO: loaded from: classes3.dex */
public class SportsState {
    private int timeInSec = 0;
    private float distance = 0.0f;
    private Integer paceInSec = null;
    private Double speed = null;
    private Byte heartBPM = null;
    private String customLabel = null;
    private String customValue = null;
    private SportsState previousState = null;

    private static String convertDistanceToString(float f) {
        return String.format("%.1f", Float.valueOf(f));
    }

    private static String convertSecondsToString(int i) {
        if (i < 0) {
            return null;
        }
        int i2 = i / 3600;
        int i3 = i - (i2 * 3600);
        int i4 = i3 / 60;
        int i5 = i3 - (i4 * 60);
        return i2 > 0 ? String.format("%2d:%02d:%02d", Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i5)) : String.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i5));
    }

    public String getCustomLabel() {
        return this.customLabel;
    }

    public String getCustomValue() {
        return this.customValue;
    }

    public float getDistance() {
        return this.distance;
    }

    public byte getHeartBPM() {
        Byte b = this.heartBPM;
        if (b == null) {
            return (byte) 0;
        }
        return b.byteValue();
    }

    public int getPaceInSec() {
        Integer num = this.paceInSec;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public float getSpeed() {
        Double d = this.speed;
        if (d == null) {
            return 0.0f;
        }
        return d.floatValue();
    }

    public int getTimeInSec() {
        return this.timeInSec;
    }

    public void setCustomLabel(String str) {
        if (str == null) {
            this.customLabel = "";
        } else {
            this.customLabel = str.toUpperCase();
        }
    }

    public void setCustomValue(String str) {
        if (str == null) {
            this.customValue = "";
        } else {
            this.customValue = str;
        }
    }

    public void setDistance(float f) {
        this.distance = Math.max(0.0f, Math.min(f, 99.9f));
    }

    public void setHeartBPM(byte b) {
        this.heartBPM = Byte.valueOf(b);
    }

    public void setPaceInSec(int i) {
        this.speed = null;
        this.paceInSec = Integer.valueOf(Math.max(0, Math.min(i, 3599)));
    }

    public void setSpeed(float f) {
        this.paceInSec = null;
        this.speed = Double.valueOf(Math.max(0.0d, Math.min(f, 99.9d)));
    }

    public void setTimeInSec(int i) {
        this.timeInSec = Math.max(0, Math.min(i, 35999));
    }

    public void synchronize(Context context) {
        boolean z;
        SportsState sportsState = this.previousState;
        if (sportsState == null) {
            sportsState = new SportsState();
            this.previousState = sportsState;
            z = true;
        } else {
            z = false;
        }
        PebbleDictionary pebbleDictionary = new PebbleDictionary();
        if (getTimeInSec() != sportsState.getTimeInSec() || z) {
            sportsState.setTimeInSec(getTimeInSec());
            pebbleDictionary.addString(0, convertSecondsToString(getTimeInSec()));
        }
        if (getDistance() != sportsState.getDistance() || z) {
            sportsState.setDistance(getDistance());
            pebbleDictionary.addString(1, convertDistanceToString(getDistance()));
        }
        if (this.paceInSec != null) {
            pebbleDictionary.addUint8(5, (byte) 1);
            if (getPaceInSec() != sportsState.getPaceInSec()) {
                sportsState.setPaceInSec(getPaceInSec());
                pebbleDictionary.addString(2, convertSecondsToString(getPaceInSec()));
            }
        }
        if (this.speed != null) {
            pebbleDictionary.addUint8(5, (byte) 0);
            if (getSpeed() != sportsState.getSpeed()) {
                sportsState.setSpeed(getSpeed());
                pebbleDictionary.addString(2, convertDistanceToString(getSpeed()));
            }
        }
        if (this.heartBPM != null && getHeartBPM() != sportsState.getHeartBPM()) {
            sportsState.setHeartBPM(getHeartBPM());
            pebbleDictionary.addUint8(6, getHeartBPM());
        }
        if (getCustomLabel() != null && getCustomValue() != null) {
            if (!getCustomLabel().equals(sportsState.getCustomLabel())) {
                sportsState.setCustomLabel(getCustomLabel());
                pebbleDictionary.addString(7, getCustomLabel());
            }
            if (!getCustomValue().equals(sportsState.getCustomValue())) {
                sportsState.setCustomValue(getCustomValue());
                pebbleDictionary.addString(8, getCustomValue());
            }
        }
        PebbleKit.sendDataToPebble(context, Constants.SPORTS_UUID, pebbleDictionary);
    }
}
