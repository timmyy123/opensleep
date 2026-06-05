package com.philips.lighting.hue.sdk.util;

import com.philips.lighting.hue.sdk.utilities.impl.PHLog;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes4.dex */
public class PHDnsChecker implements Runnable {
    private static final String TAG = "PHDnsChecker";
    private String mDomainName;
    private InetAddress mIpAddress = null;

    public PHDnsChecker(String str) {
        this.mDomainName = str;
    }

    private synchronized void set(InetAddress inetAddress) {
        this.mIpAddress = inetAddress;
    }

    public synchronized InetAddress get() {
        return this.mIpAddress;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            set(InetAddress.getByName(this.mDomainName));
        } catch (UnknownHostException e) {
            PHLog.d(TAG, e.getMessage());
        }
    }
}
