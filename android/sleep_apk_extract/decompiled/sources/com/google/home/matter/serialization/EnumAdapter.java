package com.google.home.matter.serialization;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.internal.serialization.zzrt;
import com.google.home.matter.serialization.ClusterEnum;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\n\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/google/home/matter/serialization/EnumAdapter;", "RUNTIME", "Lcom/google/home/matter/serialization/ClusterEnum;", "Lcom/google/home/matter/serialization/FieldAdapter;", "Lkotlin/ULong;", "values", "", "<init>", "([Lcom/google/home/matter/serialization/ClusterEnum;)V", "[Lcom/google/home/matter/serialization/ClusterEnum;", "defaultValue", "getDefaultValue", "()Lcom/google/home/matter/serialization/ClusterEnum;", "unknownValue", "Lcom/google/home/matter/serialization/ClusterEnum;", "toRuntime", SDKConstants.PARAM_VALUE, "toRuntime-VKZWuLQ", "(J)Lcom/google/home/matter/serialization/ClusterEnum;", "toRaw", "toRaw-I7RO_PI", "(Lcom/google/home/matter/serialization/ClusterEnum;)J", "java.com.google.home.matter.serialization_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EnumAdapter<RUNTIME extends ClusterEnum> implements FieldAdapter<ULong, RUNTIME> {
    private final RUNTIME unknownValue;
    private final RUNTIME[] values;

    public EnumAdapter(RUNTIME[] runtimeArr) {
        runtimeArr.getClass();
        this.values = runtimeArr;
        for (RUNTIME runtime : runtimeArr) {
            if (runtime.mo457getValuesVKNKU() == -1) {
                this.unknownValue = runtime;
                return;
            }
        }
        Events$$ExternalSyntheticBUOutline0.m$1("Array contains no element matching the predicate.");
        throw null;
    }

    @Override // com.google.home.matter.serialization.FieldAdapter
    public RUNTIME getDefaultValue() {
        return (RUNTIME) ArraysKt.first(this.values);
    }

    @Override // com.google.home.matter.serialization.FieldAdapter
    public /* bridge */ /* synthetic */ ULong toRaw(Object obj) {
        return ULong.m2410boximpl(m556toRawI7RO_PI((ClusterEnum) obj));
    }

    /* JADX INFO: renamed from: toRaw-I7RO_PI, reason: not valid java name */
    public long m556toRawI7RO_PI(RUNTIME value) throws Exception {
        value.getClass();
        if (Intrinsics.areEqual(value, this.unknownValue)) {
            throw new Exception("Tried to write the UnknownValue enum value!");
        }
        return value.mo457getValuesVKNKU();
    }

    @Override // com.google.home.matter.serialization.FieldAdapter
    public /* bridge */ /* synthetic */ Object toRuntime(ULong uLong) {
        return m557toRuntimeVKZWuLQ(uLong.getData());
    }

    /* JADX INFO: renamed from: toRuntime-VKZWuLQ, reason: not valid java name */
    public RUNTIME m557toRuntimeVKZWuLQ(long value) {
        RUNTIME runtime;
        RUNTIME[] runtimeArr = this.values;
        int length = runtimeArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                runtime = null;
                break;
            }
            runtime = runtimeArr[i];
            if (runtime.mo457getValuesVKNKU() == value) {
                break;
            }
            i++;
        }
        if (runtime != null) {
            return runtime;
        }
        RUNTIME runtime2 = this.unknownValue;
        zzrt zzrtVarZzc = SerializationLogger.INSTANCE.getLogger().zzc();
        String strM2414toStringimpl = ULong.m2414toStringimpl(value);
        String traitId = runtime2.getTraitId();
        String typeName = runtime2.getTypeName();
        StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(String.valueOf(strM2414toStringimpl).length() + 48, 1, String.valueOf(traitId)) + String.valueOf(typeName).length());
        FileInsert$$ExternalSyntheticOutline0.m(sb, "Encountered an unknown value of ", strM2414toStringimpl, " for an enum in ", traitId);
        zzrtVarZzc.zza(FileInsert$$ExternalSyntheticOutline0.m(sb, MqttTopic.TOPIC_LEVEL_SEPARATOR, typeName), new Object[0]);
        return runtime2;
    }
}
