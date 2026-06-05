package com.urbandroid.smartlight.common.model;

import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.urbandroid.smartlight.common.model.State;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0004\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0002\u001a\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"toInt", "", "Lcom/urbandroid/smartlight/common/model/State$Switch;", "toIntOrNull", "(Lcom/urbandroid/smartlight/common/model/State$Switch;)Ljava/lang/Integer;", "toBoolean", "", "toBooleanOrNull", "(Lcom/urbandroid/smartlight/common/model/State$Switch;)Ljava/lang/Boolean;", "smartlight_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class StateKt {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[State.Switch.values().length];
            try {
                iArr[State.Switch.ON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[State.Switch.OFF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[State.Switch.ON_OFF.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean toBoolean(State.Switch r1) {
        r1.getClass();
        int i = WhenMappings.$EnumSwitchMapping$0[r1.ordinal()];
        if (i == 1) {
            return true;
        }
        if (i == 2 || i == 3) {
            return false;
        }
        Home$$ExternalSyntheticBUOutline0.m();
        return false;
    }

    public static final Boolean toBooleanOrNull(State.Switch r0) {
        if (r0 != null) {
            return Boolean.valueOf(toBoolean(r0));
        }
        return null;
    }

    public static final int toInt(State.Switch r0) {
        r0.getClass();
        return toBoolean(r0) ? 1 : 0;
    }

    public static final Integer toIntOrNull(State.Switch r0) {
        if (r0 != null) {
            return Integer.valueOf(toInt(r0));
        }
        return null;
    }
}
