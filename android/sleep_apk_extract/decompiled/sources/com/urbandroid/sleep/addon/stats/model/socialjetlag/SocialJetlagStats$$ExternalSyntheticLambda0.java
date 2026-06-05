package com.urbandroid.sleep.addon.stats.model.socialjetlag;

import com.urbandroid.sleep.addon.stats.model.socialjetlag.ChronoRecords;
import com.urbandroid.sleep.addon.stats.model.socialjetlag.ValueCache;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class SocialJetlagStats$$ExternalSyntheticLambda0 implements ValueCache.Supplier, ChronoRecords.RecordsToFloat {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SocialJetlagStats f$0;

    public /* synthetic */ SocialJetlagStats$$ExternalSyntheticLambda0(SocialJetlagStats socialJetlagStats, int i) {
        this.$r8$classId = i;
        this.f$0 = socialJetlagStats;
    }

    @Override // com.urbandroid.sleep.addon.stats.model.socialjetlag.ChronoRecords.RecordsToFloat
    public float apply(ChronoRecords chronoRecords) {
        int i = this.$r8$classId;
        SocialJetlagStats socialJetlagStats = this.f$0;
        switch (i) {
            case 1:
                return socialJetlagStats.lambda$getChronotypeHistory$1(chronoRecords);
            default:
                return socialJetlagStats.lambda$getSleepIrregularityHistory$2(chronoRecords);
        }
    }

    @Override // com.urbandroid.sleep.addon.stats.model.socialjetlag.ValueCache.Supplier
    public Object get() {
        return this.f$0.lambda$getSleepIrregularity$0();
    }
}
