package com.philips.lighting.hue.sdk;

/* JADX INFO: loaded from: classes4.dex */
public interface PHBridgeSearchManager {
    String getPortalAddress();

    void ipAddressSearch();

    void portalSearch();

    void search(boolean z, boolean z2);

    void search(boolean z, boolean z2, boolean z3);

    void setPortalAddress(String str);

    void upnpSearch();
}
