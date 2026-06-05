package com.google.home.matter.standard;

import com.google.home.google.ExtendedModeSelectTrait;
import com.google.home.matter.serialization.StringSerializer;
import com.google.home.matter.serialization.ValueSerializer;
import com.google.home.platform.traits.Value;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/matter/standard/ModeSettingSerializer;", "Lcom/google/home/matter/serialization/ValueSerializer;", "Lcom/google/home/google/ExtendedModeSelectTrait$ModeSetting;", "<init>", "()V", "Lcom/google/home/platform/traits/Value;", "valueProto", "deserialize", "(Lcom/google/home/platform/traits/Value;)Lcom/google/home/google/ExtendedModeSelectTrait$ModeSetting;", "java.com.google.home.matter.standard_extended_mode_select_extension-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ModeSettingSerializer implements ValueSerializer<ExtendedModeSelectTrait.ModeSetting> {
    public static final ModeSettingSerializer INSTANCE = new ModeSettingSerializer();

    private ModeSettingSerializer() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.home.matter.serialization.ValueSerializer
    public ExtendedModeSelectTrait.ModeSetting deserialize(Value valueProto) {
        valueProto.getClass();
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        Value value = valueProto.getStructValue().getFieldsList().get(0).getValue();
        value.getClass();
        String strDeserialize = stringSerializer.deserialize(value);
        Value value2 = valueProto.getStructValue().getFieldsList().get(1).getValue();
        value2.getClass();
        return new ExtendedModeSelectTrait.ModeSetting(strDeserialize, stringSerializer.deserialize(value2));
    }
}
