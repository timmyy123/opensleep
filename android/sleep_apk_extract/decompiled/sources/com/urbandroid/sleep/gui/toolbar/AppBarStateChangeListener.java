package com.urbandroid.sleep.gui.toolbar;

import com.facebook.internal.ServerProtocol;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H&R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/urbandroid/sleep/gui/toolbar/AppBarStateChangeListener;", "Lcom/google/android/material/appbar/AppBarLayout$OnOffsetChangedListener;", "<init>", "()V", "mCurrentState", "Lcom/urbandroid/sleep/gui/toolbar/AppBarStateChangeListener$State;", "onOffsetChanged", "", "appBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "i", "", "onStateChanged", ServerProtocol.DIALOG_PARAM_STATE, "State", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class AppBarStateChangeListener implements AppBarLayout.OnOffsetChangedListener {
    private State mCurrentState = State.IDLE;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbandroid/sleep/gui/toolbar/AppBarStateChangeListener$State;", "", "<init>", "(Ljava/lang/String;I)V", "EXPANDED", "COLLAPSED", "IDLE", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class State {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ State[] $VALUES;
        public static final State EXPANDED = new State("EXPANDED", 0);
        public static final State COLLAPSED = new State("COLLAPSED", 1);
        public static final State IDLE = new State("IDLE", 2);

        private static final /* synthetic */ State[] $values() {
            return new State[]{EXPANDED, COLLAPSED, IDLE};
        }

        static {
            State[] stateArr$values = $values();
            $VALUES = stateArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(stateArr$values);
        }

        private State(String str, int i) {
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        State state;
        appBarLayout.getClass();
        if (i == 0) {
            State state2 = this.mCurrentState;
            state = State.EXPANDED;
            if (state2 != state) {
                onStateChanged(appBarLayout, state);
            }
        } else {
            int iAbs = Math.abs(i);
            int totalScrollRange = appBarLayout.getTotalScrollRange();
            State state3 = this.mCurrentState;
            if (iAbs >= totalScrollRange) {
                state = State.COLLAPSED;
                if (state3 != state) {
                    onStateChanged(appBarLayout, state);
                }
            } else {
                state = State.IDLE;
                if (state3 != state) {
                    onStateChanged(appBarLayout, state);
                }
            }
        }
        this.mCurrentState = state;
    }

    public abstract void onStateChanged(AppBarLayout appBarLayout, State state);
}
