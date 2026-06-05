package androidx.appsearch.usagereporting;

import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public abstract class TakenAction {
    private final long mActionTimestampMillis;
    private final int mActionType;
    private final long mDocumentTtlMillis;
    private final String mId;
    private final String mNamespace;

    public static final class Builder extends BuilderImpl<Builder> {
        public Builder(String str, String str2, long j, int i) {
            super(str, str2, j, i);
        }
    }

    public static class BuilderImpl<T extends BuilderImpl<T>> {
        protected long mActionTimestampMillis;
        protected int mActionType;
        protected long mDocumentTtlMillis = 5184000000L;
        protected final String mId;
        protected final String mNamespace;

        public BuilderImpl(String str, String str2, long j, int i) {
            this.mNamespace = (String) Preconditions.checkNotNull(str);
            this.mId = (String) Preconditions.checkNotNull(str2);
            this.mActionTimestampMillis = j;
            this.mActionType = i;
        }

        public TakenAction build() {
            throw new UnsupportedOperationException();
        }

        public T setDocumentTtlMillis(long j) {
            this.mDocumentTtlMillis = j;
            return this;
        }
    }

    public TakenAction(String str, String str2, long j, long j2, int i) {
        this.mNamespace = (String) Preconditions.checkNotNull(str);
        this.mId = (String) Preconditions.checkNotNull(str2);
        this.mDocumentTtlMillis = j;
        this.mActionTimestampMillis = j2;
        this.mActionType = i;
    }

    public long getActionTimestampMillis() {
        return this.mActionTimestampMillis;
    }

    public int getActionType() {
        return this.mActionType;
    }

    public long getDocumentTtlMillis() {
        return this.mDocumentTtlMillis;
    }

    public String getId() {
        return this.mId;
    }

    public String getNamespace() {
        return this.mNamespace;
    }
}
