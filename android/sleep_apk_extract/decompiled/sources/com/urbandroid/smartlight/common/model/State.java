package com.urbandroid.smartlight.common.model;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.urbandroid.smartlight.common.model.Color;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J5\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/urbandroid/smartlight/common/model/State;", "", "color", "Lcom/urbandroid/smartlight/common/model/Color;", "transitionMs", "", "switch", "Lcom/urbandroid/smartlight/common/model/State$Switch;", "emulated", "", "<init>", "(Lcom/urbandroid/smartlight/common/model/Color;ILcom/urbandroid/smartlight/common/model/State$Switch;Z)V", "getColor", "()Lcom/urbandroid/smartlight/common/model/Color;", "getTransitionMs", "()I", "getSwitch", "()Lcom/urbandroid/smartlight/common/model/State$Switch;", "getEmulated", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "Switch", "Companion", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class State {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final State TURN_OFF;
    private static final State TURN_OFF_SLOW;
    private static final State TURN_ON;
    private final Color color;
    private final boolean emulated;
    private final Switch switch;
    private final int transitionMs;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/urbandroid/smartlight/common/model/State$Companion;", "", "<init>", "()V", "TURN_OFF", "Lcom/urbandroid/smartlight/common/model/State;", "getTURN_OFF", "()Lcom/urbandroid/smartlight/common/model/State;", "TURN_OFF_SLOW", "getTURN_OFF_SLOW", "TURN_ON", "getTURN_ON", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final State getTURN_OFF() {
            return State.TURN_OFF;
        }

        public final State getTURN_OFF_SLOW() {
            return State.TURN_OFF_SLOW;
        }

        public final State getTURN_ON() {
            return State.TURN_ON;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/urbandroid/smartlight/common/model/State$Switch;", "", "<init>", "(Ljava/lang/String;I)V", "ON", "OFF", "ON_OFF", "Companion", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Switch {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Switch[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final Switch ON = new Switch("ON", 0);
        public static final Switch OFF = new Switch("OFF", 1);
        public static final Switch ON_OFF = new Switch("ON_OFF", 2);

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/urbandroid/smartlight/common/model/State$Switch$Companion;", "", "<init>", "()V", "of", "Lcom/urbandroid/smartlight/common/model/State$Switch;", "stateOn", "", "(Ljava/lang/Boolean;)Lcom/urbandroid/smartlight/common/model/State$Switch;", "", "(Ljava/lang/Integer;)Lcom/urbandroid/smartlight/common/model/State$Switch;", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Switch of(Integer stateOn) {
                if (stateOn != null) {
                    return stateOn.intValue() == 1 ? Switch.ON : Switch.OFF;
                }
                return null;
            }

            private Companion() {
            }

            public final Switch of(Boolean stateOn) {
                if (stateOn != null) {
                    return stateOn.booleanValue() ? Switch.ON : Switch.OFF;
                }
                return null;
            }
        }

        private static final /* synthetic */ Switch[] $values() {
            return new Switch[]{ON, OFF, ON_OFF};
        }

        static {
            Switch[] switchArr$values = $values();
            $VALUES = switchArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(switchArr$values);
            INSTANCE = new Companion(null);
        }

        private Switch(String str, int i) {
        }

        public static EnumEntries<Switch> getEntries() {
            return $ENTRIES;
        }

        public static Switch valueOf(String str) {
            return (Switch) Enum.valueOf(Switch.class, str);
        }

        public static Switch[] values() {
            return (Switch[]) $VALUES.clone();
        }
    }

    static {
        Switch r5 = Switch.OFF;
        TURN_OFF = new State(null, 10, r5, false, 9, null);
        TURN_OFF_SLOW = new State(null, 10000, r5, false, 9, null);
        TURN_ON = new State(new Color.Hsb(500, 15000, 240, 240), 500, Switch.ON, false, 8, null);
    }

    public /* synthetic */ State(Color color, int i, Switch r4, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : color, i, (i2 & 4) != 0 ? null : r4, (i2 & 8) != 0 ? true : z);
    }

    public static /* synthetic */ State copy$default(State state, Color color, int i, Switch r3, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            color = state.color;
        }
        if ((i2 & 2) != 0) {
            i = state.transitionMs;
        }
        if ((i2 & 4) != 0) {
            r3 = state.switch;
        }
        if ((i2 & 8) != 0) {
            z = state.emulated;
        }
        return state.copy(color, i, r3, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Color getColor() {
        return this.color;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTransitionMs() {
        return this.transitionMs;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Switch getSwitch() {
        return this.switch;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getEmulated() {
        return this.emulated;
    }

    public final State copy(Color color, int transitionMs, Switch r3, boolean emulated) {
        return new State(color, transitionMs, r3, emulated);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof State)) {
            return false;
        }
        State state = (State) other;
        return Intrinsics.areEqual(this.color, state.color) && this.transitionMs == state.transitionMs && this.switch == state.switch && this.emulated == state.emulated;
    }

    public final Color getColor() {
        return this.color;
    }

    public final boolean getEmulated() {
        return this.emulated;
    }

    public final Switch getSwitch() {
        return this.switch;
    }

    public final int getTransitionMs() {
        return this.transitionMs;
    }

    public int hashCode() {
        Color color = this.color;
        int iM = FileInsert$$ExternalSyntheticOutline0.m(this.transitionMs, (color == null ? 0 : color.hashCode()) * 31, 31);
        Switch r3 = this.switch;
        return Boolean.hashCode(this.emulated) + ((iM + (r3 != null ? r3.hashCode() : 0)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("State(color=");
        sb.append(this.color);
        sb.append(", transitionMs=");
        sb.append(this.transitionMs);
        sb.append(", switch=");
        sb.append(this.switch);
        sb.append(", emulated=");
        return Fragment$$ExternalSyntheticOutline1.m(sb, this.emulated, ')');
    }

    public State(Color color, int i, Switch r3, boolean z) {
        this.color = color;
        this.transitionMs = i;
        this.switch = r3;
        this.emulated = z;
    }
}
