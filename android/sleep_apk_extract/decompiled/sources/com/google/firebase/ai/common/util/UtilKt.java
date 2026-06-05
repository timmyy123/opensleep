package com.google.firebase.ai.common.util;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¨\u0006\u0004"}, d2 = {"fullModelName", "", "name", "trimmedModelName", "com.google.firebase-ai-logic-firebase-ai"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class UtilKt {
    public static final String fullModelName(String str) {
        str.getClass();
        String str2 = StringsKt.contains$default(str, MqttTopic.TOPIC_LEVEL_SEPARATOR) ? str : null;
        return str2 == null ? "models/".concat(str) : str2;
    }

    public static final String trimmedModelName(String str) {
        str.getClass();
        return (String) CollectionsKt.last(StringsKt.split$default(str, new String[]{MqttTopic.TOPIC_LEVEL_SEPARATOR}, 0, 6));
    }
}
