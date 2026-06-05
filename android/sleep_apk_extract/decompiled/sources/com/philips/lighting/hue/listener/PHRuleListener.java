package com.philips.lighting.hue.listener;

import com.philips.lighting.model.rule.PHRule;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface PHRuleListener extends PHBridgeAPIListener {
    void onReceivingRuleDetails(PHRule pHRule);

    void onRuleReceived(List<PHRule> list);
}
