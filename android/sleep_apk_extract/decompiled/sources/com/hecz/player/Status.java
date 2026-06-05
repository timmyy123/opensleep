package com.hecz.player;

/* JADX INFO: loaded from: classes4.dex */
public class Status {
    private int state = 0;

    public synchronized int getState() {
        return this.state;
    }

    public IListenerOfPlayer getStatusListener() {
        return null;
    }

    public synchronized void setState(int i) {
        getStatusListener();
        this.state = i;
    }

    public String toString() {
        switch (this.state) {
            case 0:
                return "POWER_OFF";
            case 1:
                return "FADE_IN";
            case 2:
                return "STARTED";
            case 3:
                return "FADE_OUT";
            case 4:
                return "PAUSE";
            case 5:
                return "STOP";
            case 6:
                return "PREPARING";
            case 7:
                return "SILENT";
            default:
                return "ERROR!!";
        }
    }
}
