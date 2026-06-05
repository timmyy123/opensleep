package com.squareup.kotlinpoet;

import com.google.android.material.button.MaterialButton;
import com.urbandroid.sleep.alarmclock.Alarm;
import com.urbandroid.sleep.alarmclock.RepeatChipPreference;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$BooleanRef;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class TypeSpec$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ TypeSpec$$ExternalSyntheticLambda0(Object obj, Object obj2, Object obj3, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i = this.$r8$classId;
        Object obj2 = this.f$2;
        Object obj3 = this.f$1;
        Object obj4 = this.f$0;
        switch (i) {
            case 0:
                return TypeSpec.emit$lambda$3$lambda$2((Ref$BooleanRef) obj4, (Map) obj3, (CodeWriter) obj2, (ParameterSpec) obj);
            default:
                return RepeatChipPreference.updateUIControls$lambda$0$0((Alarm.DaysOfWeek) obj4, (MaterialButton) obj3, (RepeatChipPreference) obj2, (Long) obj);
        }
    }
}
