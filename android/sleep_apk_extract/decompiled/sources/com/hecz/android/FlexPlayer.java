package com.hecz.android;

import android.content.Context;
import android.util.Log;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.hecz.flex.FlexManager;
import com.hecz.serialcommon.flex.FlashTab;
import com.hecz.serialcommon.flex.IFlex;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;

/* JADX INFO: loaded from: classes4.dex */
public class FlexPlayer {
    J2xx j2xx = J2xx.getInstance();
    private boolean isInitied = false;

    public void initPort(Context context, IFlexListener iFlexListener) {
        Log.i("J2XX", "initPort");
        if (this.isInitied) {
            Log.i("J2XX", "initPort (TRUE)");
            this.j2xx.setPort(context, iFlexListener);
            this.j2xx.flexIsConnected();
        } else {
            Log.i("J2XX", "initPort (FALSE)");
            this.j2xx.initPort(context, iFlexListener);
            this.j2xx.start();
            this.isInitied = true;
        }
    }

    public void insert2Buffer(double d, double d2, double d3) {
        FlexManager.getFlex().insert2flashTab(d, d2, d3);
    }

    public boolean isBufferAcceptData() {
        IFlex flex = FlexManager.getFlex();
        return flex != null && flex.getFlashTab().getPcmmNData() < 500;
    }

    public void pause() {
        this.j2xx.pause();
    }

    public void prepare() {
        this.j2xx.prepareFlex();
    }

    public void resetBuffer() {
        FlashTab flashTab;
        IFlex flex = FlexManager.getFlex();
        if (flex == null || (flashTab = flex.getFlashTab()) == null) {
            return;
        }
        flashTab.resetFlashTab();
    }

    public void runOnce() {
        this.j2xx.runOnce();
    }

    public void sendData(String str) {
        this.j2xx.sendData(str);
    }

    public void setIntensity(int i) {
        IFlex flex = this.j2xx.getFlex();
        if (flex != null) {
            flex.setPwm(i);
        }
    }

    public void setRgb(int i, int i2, int i3) {
        IFlex flex = this.j2xx.getFlex();
        if (flex != null) {
            flex.setRgb(i, i2, i3);
            StringBuilder sb = new StringBuilder("SET RGB = ");
            Fragment$$ExternalSyntheticOutline1.m(sb, i, ", ", i2, ", ");
            sb.append(i3);
            Log.i("J2XX", sb.toString());
        }
    }

    public void setSoundTimeRatio(double d) {
        this.j2xx.setSoundTimeRatio(d);
    }

    public void start() {
        this.j2xx.startFlex();
    }

    public void stop() {
        this.j2xx.stopFlex();
    }

    public void transition(HintParams hintParams) {
        if (FlexManager.getFlex() == null) {
            return;
        }
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (!FlexManager.getFlex().isCommandQueueEmpty()) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
        this.j2xx.sendData((byte) 116);
        this.j2xx.sendData((byte) 49);
        this.j2xx.sendData((byte) 72);
        this.j2xx.sendData((byte) (hintParams.getRed() & PHIpAddressSearchManager.END_IP_SCAN));
        this.j2xx.sendData((byte) (hintParams.getGreen() & PHIpAddressSearchManager.END_IP_SCAN));
        this.j2xx.sendData((byte) (hintParams.getBlue() & PHIpAddressSearchManager.END_IP_SCAN));
        this.j2xx.sendData((byte) (hintParams.getRedStep() >> 8));
        this.j2xx.sendData((byte) (hintParams.getRedStep() & 255));
        this.j2xx.sendData((byte) (hintParams.getGreenStep() >> 8));
        this.j2xx.sendData((byte) (hintParams.getGreenStep() & 255));
        this.j2xx.sendData((byte) (hintParams.getBlueStep() >> 8));
        this.j2xx.sendData((byte) (hintParams.getBlueStep() & 255));
        this.j2xx.sendData((byte) (hintParams.getPwm() & PHIpAddressSearchManager.END_IP_SCAN));
        this.j2xx.sendData((byte) (hintParams.getPwmStep() >> 8));
        this.j2xx.sendData((byte) (hintParams.getPwmStep() & 255));
        this.j2xx.sendData((byte) (hintParams.getRedWay() & PHIpAddressSearchManager.END_IP_SCAN));
        this.j2xx.sendData((byte) (hintParams.getGreenWay() & PHIpAddressSearchManager.END_IP_SCAN));
        this.j2xx.sendData((byte) (hintParams.getBlueWay() & PHIpAddressSearchManager.END_IP_SCAN));
        this.j2xx.sendData((byte) (hintParams.getPwmWay() & PHIpAddressSearchManager.END_IP_SCAN));
        this.j2xx.sendData((byte) (hintParams.getHintDuration() >> 24));
        this.j2xx.sendData((byte) (hintParams.getHintDuration() >> 16));
        this.j2xx.sendData((byte) (hintParams.getHintDuration() >> 8));
        this.j2xx.sendData((byte) (hintParams.getHintDuration() & 255));
        this.j2xx.sendData((byte) (hintParams.getHintPwm() >> 8));
        this.j2xx.sendData((byte) (hintParams.getHintPwm() & 255));
    }
}
