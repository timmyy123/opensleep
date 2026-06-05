package androidx.transition;

import android.view.View;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TransitionValues {
    public View view;
    public final Map<String, Object> values = new HashMap();
    final ArrayList<Transition> mTargetedTransitions = new ArrayList<>();

    public TransitionValues(View view) {
        this.view = view;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TransitionValues)) {
            return false;
        }
        TransitionValues transitionValues = (TransitionValues) obj;
        return this.view == transitionValues.view && this.values.equals(transitionValues.values);
    }

    public int hashCode() {
        return this.values.hashCode() + (this.view.hashCode() * 31);
    }

    public String toString() {
        StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n", "    view = ");
        sbM.append(this.view);
        sbM.append("\n");
        String strConcat = sbM.toString().concat("    values:");
        for (String str : this.values.keySet()) {
            strConcat = strConcat + "    " + str + ": " + this.values.get(str) + "\n";
        }
        return strConcat;
    }
}
