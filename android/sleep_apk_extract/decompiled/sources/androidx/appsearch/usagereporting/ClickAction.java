package androidx.appsearch.usagereporting;

import androidx.appsearch.usagereporting.TakenAction;

/* JADX INFO: loaded from: classes.dex */
public class ClickAction extends TakenAction {
    private final String mQuery;
    private final String mReferencedQualifiedId;
    private final int mResultRankGlobal;
    private final int mResultRankInBlock;
    private final long mTimeStayOnResultMillis;

    public static final class Builder extends TakenAction.BuilderImpl<Builder> {
        private String mQuery;
        private String mReferencedQualifiedId;
        private int mResultRankGlobal;
        private int mResultRankInBlock;
        private long mTimeStayOnResultMillis;

        public Builder(String str, String str2, long j, int i) {
            super(str, str2, j, i);
            this.mResultRankInBlock = -1;
            this.mResultRankGlobal = -1;
            this.mTimeStayOnResultMillis = -1L;
        }

        @Override // androidx.appsearch.usagereporting.TakenAction.BuilderImpl
        public ClickAction build() {
            return new ClickAction(this.mNamespace, this.mId, this.mDocumentTtlMillis, this.mActionTimestampMillis, this.mActionType, this.mQuery, this.mReferencedQualifiedId, this.mResultRankInBlock, this.mResultRankGlobal, this.mTimeStayOnResultMillis);
        }

        @Override // androidx.appsearch.usagereporting.TakenAction.BuilderImpl
        public /* bridge */ /* synthetic */ TakenAction.BuilderImpl setDocumentTtlMillis(long j) {
            return super.setDocumentTtlMillis(j);
        }

        public Builder setQuery(String str) {
            this.mQuery = str;
            return this;
        }

        public Builder setReferencedQualifiedId(String str) {
            this.mReferencedQualifiedId = str;
            return this;
        }

        public Builder setResultRankGlobal(int i) {
            this.mResultRankGlobal = i;
            return this;
        }

        public Builder setResultRankInBlock(int i) {
            this.mResultRankInBlock = i;
            return this;
        }

        public Builder setTimeStayOnResultMillis(long j) {
            this.mTimeStayOnResultMillis = j;
            return this;
        }
    }

    public ClickAction(String str, String str2, long j, long j2, int i, String str3, String str4, int i2, int i3, long j3) {
        super(str, str2, j, j2, i);
        this.mQuery = str3;
        this.mReferencedQualifiedId = str4;
        this.mResultRankInBlock = i2;
        this.mResultRankGlobal = i3;
        this.mTimeStayOnResultMillis = j3;
    }

    public String getQuery() {
        return this.mQuery;
    }

    public String getReferencedQualifiedId() {
        return this.mReferencedQualifiedId;
    }

    public int getResultRankGlobal() {
        return this.mResultRankGlobal;
    }

    public int getResultRankInBlock() {
        return this.mResultRankInBlock;
    }

    public long getTimeStayOnResultMillis() {
        return this.mTimeStayOnResultMillis;
    }
}
