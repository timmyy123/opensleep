package io.opencensus.trace.export;

import io.opencensus.trace.Status;
import io.opencensus.trace.export.SampledSpanStore;
import java.util.Map;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
final class AutoValue_SampledSpanStore_PerSpanNameSummary extends SampledSpanStore.PerSpanNameSummary {
    private final Map<Status.CanonicalCode, Integer> numbersOfErrorSampledSpans;
    private final Map<Object, Integer> numbersOfLatencySampledSpans;

    public AutoValue_SampledSpanStore_PerSpanNameSummary(Map<Object, Integer> map, Map<Status.CanonicalCode, Integer> map2) {
        if (map == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("Null numbersOfLatencySampledSpans");
            throw null;
        }
        this.numbersOfLatencySampledSpans = map;
        if (map2 != null) {
            this.numbersOfErrorSampledSpans = map2;
        } else {
            Types$$ExternalSyntheticBUOutline0.m$1("Null numbersOfErrorSampledSpans");
            throw null;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SampledSpanStore.PerSpanNameSummary) {
            SampledSpanStore.PerSpanNameSummary perSpanNameSummary = (SampledSpanStore.PerSpanNameSummary) obj;
            if (this.numbersOfLatencySampledSpans.equals(perSpanNameSummary.getNumbersOfLatencySampledSpans()) && this.numbersOfErrorSampledSpans.equals(perSpanNameSummary.getNumbersOfErrorSampledSpans())) {
                return true;
            }
        }
        return false;
    }

    @Override // io.opencensus.trace.export.SampledSpanStore.PerSpanNameSummary
    public Map<Status.CanonicalCode, Integer> getNumbersOfErrorSampledSpans() {
        return this.numbersOfErrorSampledSpans;
    }

    @Override // io.opencensus.trace.export.SampledSpanStore.PerSpanNameSummary
    public Map<Object, Integer> getNumbersOfLatencySampledSpans() {
        return this.numbersOfLatencySampledSpans;
    }

    public int hashCode() {
        return this.numbersOfErrorSampledSpans.hashCode() ^ ((this.numbersOfLatencySampledSpans.hashCode() ^ 1000003) * 1000003);
    }

    public String toString() {
        return "PerSpanNameSummary{numbersOfLatencySampledSpans=" + this.numbersOfLatencySampledSpans + ", numbersOfErrorSampledSpans=" + this.numbersOfErrorSampledSpans + "}";
    }
}
