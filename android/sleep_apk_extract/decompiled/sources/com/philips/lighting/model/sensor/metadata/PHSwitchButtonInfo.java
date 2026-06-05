package com.philips.lighting.model.sensor.metadata;

import com.philips.lighting.hue.sdk.utilities.impl.PointD;
import com.philips.lighting.hue.sdk.utilities.impl.RectangleD;

/* JADX INFO: loaded from: classes4.dex */
public class PHSwitchButtonInfo {
    private String buttonId;
    private String buttonImageName;
    private PointD buttonPosition;
    private RectangleD buttonTouchArea;
    private int zigbeeChannel;

    public PHSwitchButtonInfo(String str, int i, String str2, double d, double d2, double d3, double d4, double d5, double d6) {
        this(str, i, str2, new PointD(d, d2), new RectangleD(new PointD(d3, d4), new PointD(d5, d6)));
    }

    public String getButtonId() {
        return this.buttonId;
    }

    public String getButtonImageName() {
        return this.buttonImageName;
    }

    public PointD getButtonPosition() {
        return this.buttonPosition;
    }

    public RectangleD getButtonTouchArea() {
        return this.buttonTouchArea;
    }

    public int getZigbeeChannel() {
        return this.zigbeeChannel;
    }

    public void setButtonId(String str) {
        this.buttonId = str;
    }

    public void setButtonImageName(String str) {
        this.buttonImageName = str;
    }

    public void setButtonPosition(PointD pointD) {
        this.buttonPosition = pointD;
    }

    public void setButtonTouchArea(RectangleD rectangleD) {
        this.buttonTouchArea = rectangleD;
    }

    public void setZigbeeChannel(int i) {
        this.zigbeeChannel = i;
    }

    public PHSwitchButtonInfo(String str, int i, String str2, PointD pointD, RectangleD rectangleD) {
        this.buttonId = str;
        this.zigbeeChannel = i;
        this.buttonImageName = str2;
        this.buttonPosition = pointD;
        this.buttonTouchArea = rectangleD;
    }

    public PHSwitchButtonInfo() {
        this.buttonId = null;
        this.zigbeeChannel = 0;
        this.buttonImageName = null;
        this.buttonPosition = null;
        this.buttonTouchArea = null;
    }
}
