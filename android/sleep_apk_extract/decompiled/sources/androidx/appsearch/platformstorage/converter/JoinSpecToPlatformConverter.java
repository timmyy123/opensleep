package androidx.appsearch.platformstorage.converter;

import android.app.appsearch.JoinSpec;
import android.content.Context;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public abstract class JoinSpecToPlatformConverter {
    public static JoinSpec toPlatformJoinSpec(Context context, androidx.appsearch.app.JoinSpec joinSpec) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(joinSpec);
        return new JoinSpec.Builder(joinSpec.getChildPropertyExpression()).setNestedSearch(joinSpec.getNestedQuery(), SearchSpecToPlatformConverter.toPlatformSearchSpec(context, joinSpec.getNestedSearchSpec())).setMaxJoinedResultCount(joinSpec.getMaxJoinedResultCount()).setAggregationScoringStrategy(joinSpec.getAggregationScoringStrategy()).build();
    }
}
