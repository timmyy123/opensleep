package com.google.home.platform.traits;

import com.google.android.gms.internal.serialization.zzyl;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/google/home/platform/traits/ConditionOrBuilder;", "Lcom/google/protobuf/Duration;", "getForDurationOrNull", "(Lcom/google/home/platform/traits/ConditionOrBuilder;)Lcom/google/protobuf/Duration;", "forDurationOrNull", "home.platform.traits.automation_automation_graph_kmp_proto_ghp_kt_lite_proto"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class ConditionKtKt {
    public static final zzyl getForDurationOrNull(ConditionOrBuilder conditionOrBuilder) {
        conditionOrBuilder.getClass();
        if (conditionOrBuilder.hasForDuration()) {
            return conditionOrBuilder.getForDuration();
        }
        return null;
    }
}
