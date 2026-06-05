package com.hecz.flex;

import com.hecz.serialcommon.ISerialConnection;
import com.hecz.serialcommon.flex.FlashTab;
import com.hecz.serialcommon.flex.Flex;
import com.hecz.serialcommon.flex.IFlex;
import com.hecz.serialcommon.flex.IFlexControl;

/* JADX INFO: loaded from: classes4.dex */
public class FlexManager {
    private static FlashTab flashTab = FlashTab.getInstance();
    private static IFlex connectedFlex = null;
    private static FlexManager flexManager = null;

    public static IFlex getFlex() {
        return connectedFlex;
    }

    public static FlexManager getInstance() {
        if (flexManager == null) {
            flexManager = new FlexManager();
        }
        return flexManager;
    }

    public IFlex setAndroidFlex(IFlexControl iFlexControl, ISerialConnection iSerialConnection) {
        Flex flex = new Flex(iFlexControl);
        connectedFlex = flex;
        flex.setConnection(iSerialConnection);
        if (iFlexControl != null) {
            iFlexControl.changePCMMState(true);
        }
        return connectedFlex;
    }
}
