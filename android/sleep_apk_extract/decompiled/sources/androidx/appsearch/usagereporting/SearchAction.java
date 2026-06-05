package androidx.appsearch.usagereporting;

import androidx.appsearch.usagereporting.TakenAction;

/* JADX INFO: loaded from: classes.dex */
public class SearchAction extends TakenAction {
    private final int mFetchedResultCount;
    private final String mQuery;

    public static final class Builder extends TakenAction.BuilderImpl<Builder> {
        private int mFetchedResultCount;
        private String mQuery;

        public Builder(String str, String str2, long j, int i) {
            super(str, str2, j, i);
            this.mFetchedResultCount = -1;
        }

        @Override // androidx.appsearch.usagereporting.TakenAction.BuilderImpl
        public SearchAction build() {
            return new SearchAction(this.mNamespace, this.mId, this.mDocumentTtlMillis, this.mActionTimestampMillis, this.mActionType, this.mQuery, this.mFetchedResultCount);
        }

        @Override // androidx.appsearch.usagereporting.TakenAction.BuilderImpl
        public /* bridge */ /* synthetic */ TakenAction.BuilderImpl setDocumentTtlMillis(long j) {
            return super.setDocumentTtlMillis(j);
        }

        public Builder setFetchedResultCount(int i) {
            this.mFetchedResultCount = i;
            return this;
        }

        public Builder setQuery(String str) {
            this.mQuery = str;
            return this;
        }
    }

    public SearchAction(String str, String str2, long j, long j2, int i, String str3, int i2) {
        super(str, str2, j, j2, i);
        this.mQuery = str3;
        this.mFetchedResultCount = i2;
    }

    public int getFetchedResultCount() {
        return this.mFetchedResultCount;
    }

    public String getQuery() {
        return this.mQuery;
    }
}
