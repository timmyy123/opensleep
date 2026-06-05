package androidx.appsearch.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appsearch.app.SearchSpec;
import androidx.appsearch.safeparcel.AbstractSafeParcelable;
import androidx.appsearch.safeparcel.stub.AbstractCreator;
import androidx.core.util.Preconditions;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class JoinSpec extends AbstractSafeParcelable {
    public static final Parcelable.Creator<JoinSpec> CREATOR = new AbstractCreator<JoinSpec>() { // from class: androidx.appsearch.safeparcel.stub.StubCreators$JoinSpecCreator
        @Override // androidx.appsearch.safeparcel.stub.AbstractCreator, android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
            return super.createFromParcel(parcel);
        }

        @Override // androidx.appsearch.safeparcel.stub.AbstractCreator, android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return super.newArray(i);
        }
    };
    private final int mAggregationScoringStrategy;
    private final String mChildPropertyExpression;
    private final int mMaxJoinedResultCount;
    private final String mNestedQuery;
    private final SearchSpec mNestedSearchSpec;

    public static final class Builder {
        private static final SearchSpec EMPTY_SEARCH_SPEC = new SearchSpec.Builder().build();
        private String mChildPropertyExpression;
        private String mNestedQuery = "";
        private SearchSpec mNestedSearchSpec = EMPTY_SEARCH_SPEC;
        private int mMaxJoinedResultCount = 10;
        private int mAggregationScoringStrategy = 0;

        public Builder(String str) {
            Preconditions.checkNotNull(str);
            this.mChildPropertyExpression = str;
        }

        public JoinSpec build() {
            return new JoinSpec(this.mNestedQuery, this.mNestedSearchSpec, this.mChildPropertyExpression, this.mMaxJoinedResultCount, this.mAggregationScoringStrategy);
        }

        public Builder setNestedSearch(String str, SearchSpec searchSpec) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(searchSpec);
            this.mNestedQuery = str;
            this.mNestedSearchSpec = searchSpec;
            return this;
        }
    }

    public JoinSpec(String str, SearchSpec searchSpec, String str2, int i, int i2) {
        Objects.requireNonNull(str);
        this.mNestedQuery = str;
        Objects.requireNonNull(searchSpec);
        this.mNestedSearchSpec = searchSpec;
        Objects.requireNonNull(str2);
        this.mChildPropertyExpression = str2;
        this.mMaxJoinedResultCount = i;
        this.mAggregationScoringStrategy = i2;
    }

    public int getAggregationScoringStrategy() {
        return this.mAggregationScoringStrategy;
    }

    public String getChildPropertyExpression() {
        return this.mChildPropertyExpression;
    }

    public int getMaxJoinedResultCount() {
        return this.mMaxJoinedResultCount;
    }

    public String getNestedQuery() {
        return this.mNestedQuery;
    }

    public SearchSpec getNestedSearchSpec() {
        return this.mNestedSearchSpec;
    }
}
