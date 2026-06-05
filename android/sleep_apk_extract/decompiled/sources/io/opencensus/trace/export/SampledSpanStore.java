package io.opencensus.trace.export;

import io.opencensus.internal.Utils;
import io.opencensus.trace.Status;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public abstract class SampledSpanStore {

    public static final class NoopSampledSpanStore extends SampledSpanStore {
        private static final PerSpanNameSummary EMPTY_PER_SPAN_NAME_SUMMARY;
        private final Set<String> registeredSpanNames;

        static {
            Map map = Collections.EMPTY_MAP;
            EMPTY_PER_SPAN_NAME_SUMMARY = PerSpanNameSummary.create(map, map);
        }

        private NoopSampledSpanStore() {
            this.registeredSpanNames = new HashSet();
        }

        @Override // io.opencensus.trace.export.SampledSpanStore
        public void registerSpanNamesForCollection(Collection<String> collection) {
            Utils.checkNotNull(collection, "spanNames");
            synchronized (this.registeredSpanNames) {
                this.registeredSpanNames.addAll(collection);
            }
        }
    }

    public static abstract class PerSpanNameSummary {
        public static PerSpanNameSummary create(Map<Object, Integer> map, Map<Status.CanonicalCode, Integer> map2) {
            return new AutoValue_SampledSpanStore_PerSpanNameSummary(Collections.unmodifiableMap(new HashMap((Map) Utils.checkNotNull(map, "numbersOfLatencySampledSpans"))), Collections.unmodifiableMap(new HashMap((Map) Utils.checkNotNull(map2, "numbersOfErrorSampledSpans"))));
        }

        public abstract Map<Status.CanonicalCode, Integer> getNumbersOfErrorSampledSpans();

        public abstract Map<Object, Integer> getNumbersOfLatencySampledSpans();
    }

    public static SampledSpanStore newNoopSampledSpanStore() {
        return new NoopSampledSpanStore();
    }

    @Deprecated
    public abstract void registerSpanNamesForCollection(Collection<String> collection);
}
