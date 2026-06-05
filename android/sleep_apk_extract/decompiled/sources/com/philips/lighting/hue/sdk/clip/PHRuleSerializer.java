package com.philips.lighting.hue.sdk.clip;

import com.philips.lighting.model.rule.PHRule;
import java.util.List;
import org.json.hue.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface PHRuleSerializer extends PHSerializer {
    boolean canCreate();

    boolean canDelete();

    boolean canFetchAll();

    boolean canRead();

    boolean canUpdate();

    JSONObject createRule(PHRule pHRule);

    List<PHRule> parseRules(JSONObject jSONObject);

    JSONObject updateRule(PHRule pHRule);

    boolean validateAPI(PHRule pHRule);
}
