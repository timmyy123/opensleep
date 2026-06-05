package com.hecz.android;

/* JADX INFO: loaded from: classes4.dex */
public class HintParams {
    private int red = 0;
    private int green = 0;
    private int blue = 0;
    private short redStep = 0;
    private short greenStep = 0;
    private short blueStep = 0;
    private int pwm = 0;
    private short pwmStep = 0;
    private int redWay = 0;
    private int greenWay = 0;
    private int blueWay = 0;
    private int pwmWay = 0;
    private long hintDuration = 0;
    private short hintPwm = 0;

    public int getBlue() {
        return this.blue;
    }

    public short getBlueStep() {
        return this.blueStep;
    }

    public int getBlueWay() {
        return this.blueWay;
    }

    public int getGreen() {
        return this.green;
    }

    public short getGreenStep() {
        return this.greenStep;
    }

    public int getGreenWay() {
        return this.greenWay;
    }

    public long getHintDuration() {
        return this.hintDuration;
    }

    public short getHintPwm() {
        return this.hintPwm;
    }

    public int getPwm() {
        return this.pwm;
    }

    public short getPwmStep() {
        return this.pwmStep;
    }

    public int getPwmWay() {
        return this.pwmWay;
    }

    public int getRed() {
        return this.red;
    }

    public short getRedStep() {
        return this.redStep;
    }

    public int getRedWay() {
        return this.redWay;
    }

    public void setBlue(int i) {
        this.blue = i;
    }

    public void setGreen(int i) {
        this.green = i;
    }

    public void setGreenStep(short s) {
        this.greenStep = s;
    }

    public void setGreenWay(int i) {
        this.greenWay = i;
    }

    public void setHintDuration(long j) {
        this.hintDuration = j;
    }

    public void setHintPwm(short s) {
        this.hintPwm = s;
    }

    public void setPwm(int i) {
        this.pwm = i;
    }

    public void setPwmStep(short s) {
        this.pwmStep = s;
    }

    public void setPwmWay(int i) {
        this.pwmWay = i;
    }

    public void setRed(int i) {
        this.red = i;
    }
}
