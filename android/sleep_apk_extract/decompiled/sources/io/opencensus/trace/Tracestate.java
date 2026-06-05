package io.opencensus.trace;

import io.opencensus.internal.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Tracestate {

    public static final class Builder {
        private static final Tracestate EMPTY = Tracestate.create(Collections.EMPTY_LIST);

        @Nullable
        private ArrayList<Object> entries;
        private final Tracestate parent;

        private Builder(Tracestate tracestate) {
            Utils.checkNotNull(tracestate, "parent");
            this.parent = tracestate;
            this.entries = null;
        }

        public Tracestate build() {
            ArrayList<Object> arrayList = this.entries;
            return arrayList == null ? this.parent : Tracestate.create(arrayList);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Tracestate create(List<Object> list) {
        Utils.checkState(list.size() <= 32, "Invalid size");
        return new AutoValue_Tracestate(Collections.unmodifiableList(list));
    }

    public abstract List<Object> getEntries();
}
