package androidx.appsearch.app;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appsearch.safeparcel.AbstractSafeParcelable;
import androidx.appsearch.safeparcel.GenericDocumentParcel;
import androidx.appsearch.safeparcel.stub.AbstractCreator;
import androidx.appsearch.util.BundleUtil;
import androidx.collection.ArrayMap;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
public final class SearchResult extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SearchResult> CREATOR = new AbstractCreator<SearchResult>() { // from class: androidx.appsearch.safeparcel.stub.StubCreators$SearchResultCreator
        @Override // androidx.appsearch.safeparcel.stub.AbstractCreator, android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
            return super.createFromParcel(parcel);
        }

        @Override // androidx.appsearch.safeparcel.stub.AbstractCreator, android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return super.newArray(i);
        }
    };
    private final String mDatabaseName;
    final GenericDocumentParcel mDocument;
    private GenericDocument mDocumentCached;
    private final List<Double> mInformationalRankingSignals;
    private final List<SearchResult> mJoinedResults;
    final List<MatchInfo> mMatchInfos;
    private List<MatchInfo> mMatchInfosCached;
    private final String mPackageName;
    final Bundle mParentTypeMap;
    private final double mRankingSignal;

    public static final class EmbeddingMatchInfo extends AbstractSafeParcelable {
    }

    public static final class MatchRange {
        private final int mEnd;
        private final int mStart;

        public MatchRange(int i, int i2) {
            if (i > i2) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Start point must be less than or equal to end point");
                throw null;
            }
            this.mStart = i;
            this.mEnd = i2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MatchRange)) {
                return false;
            }
            MatchRange matchRange = (MatchRange) obj;
            return getStart() == matchRange.getStart() && getEnd() == matchRange.getEnd();
        }

        public int getEnd() {
            return this.mEnd;
        }

        public int getStart() {
            return this.mStart;
        }

        public int hashCode() {
            return ObjectsCompat.hash(Integer.valueOf(this.mStart), Integer.valueOf(this.mEnd));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("MatchRange { start: ");
            sb.append(this.mStart);
            sb.append(" , end: ");
            return FileInsert$$ExternalSyntheticOutline0.m(this.mEnd, "}", sb);
        }
    }

    public static final class TextMatchInfo extends AbstractSafeParcelable {
        public static final Parcelable.Creator<TextMatchInfo> CREATOR = new AbstractCreator<TextMatchInfo>() { // from class: androidx.appsearch.safeparcel.stub.StubCreators$TextMatchInfoCreator
            @Override // androidx.appsearch.safeparcel.stub.AbstractCreator, android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
                return super.createFromParcel(parcel);
            }

            @Override // androidx.appsearch.safeparcel.stub.AbstractCreator, android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return super.newArray(i);
            }
        };
        private MatchRange mExactMatchRangeCached;
        final int mExactMatchRangeEnd;
        final int mExactMatchRangeStart;
        final int mSnippetRangeEnd;
        final int mSnippetRangeStart;
        final int mSubmatchRangeEnd;
        final int mSubmatchRangeStart;
        private MatchRange mWindowRangeCached;
        private String mPropertyPath = null;
        private GenericDocument mDocument = null;

        public TextMatchInfo(int i, int i2, int i3, int i4, int i5, int i6) {
            this.mExactMatchRangeStart = i;
            this.mExactMatchRangeEnd = i2;
            this.mSubmatchRangeStart = i3;
            this.mSubmatchRangeEnd = i4;
            this.mSnippetRangeStart = i5;
            this.mSnippetRangeEnd = i6;
        }

        public MatchRange getExactMatchRange() {
            if (this.mExactMatchRangeCached == null) {
                this.mExactMatchRangeCached = new MatchRange(this.mExactMatchRangeStart, this.mExactMatchRangeEnd);
            }
            return this.mExactMatchRangeCached;
        }

        public MatchRange getSnippetRange() {
            if (this.mWindowRangeCached == null) {
                this.mWindowRangeCached = new MatchRange(this.mSnippetRangeStart, this.mSnippetRangeEnd);
            }
            return this.mWindowRangeCached;
        }

        public void setDocument(GenericDocument genericDocument) {
            this.mDocument = (GenericDocument) Preconditions.checkNotNull(genericDocument);
        }

        public void setPropertyPath(String str) {
            this.mPropertyPath = (String) Preconditions.checkNotNull(str);
        }
    }

    public SearchResult(GenericDocumentParcel genericDocumentParcel, List<MatchInfo> list, String str, String str2, double d, List<SearchResult> list2, List<Double> list3, Bundle bundle) {
        this.mDocument = (GenericDocumentParcel) Preconditions.checkNotNull(genericDocumentParcel);
        this.mMatchInfos = (List) Preconditions.checkNotNull(list);
        this.mPackageName = (String) Preconditions.checkNotNull(str);
        this.mDatabaseName = (String) Preconditions.checkNotNull(str2);
        this.mRankingSignal = d;
        this.mJoinedResults = Collections.unmodifiableList((List) Preconditions.checkNotNull(list2));
        if (list3 != null) {
            this.mInformationalRankingSignals = Collections.unmodifiableList(list3);
        } else {
            this.mInformationalRankingSignals = Collections.EMPTY_LIST;
        }
        if (bundle != null) {
            this.mParentTypeMap = bundle;
        } else {
            this.mParentTypeMap = Bundle.EMPTY;
        }
    }

    public String getDatabaseName() {
        return this.mDatabaseName;
    }

    public GenericDocument getGenericDocument() {
        if (this.mDocumentCached == null) {
            this.mDocumentCached = new GenericDocument(this.mDocument);
        }
        return this.mDocumentCached;
    }

    public List<Double> getInformationalRankingSignals() {
        return this.mInformationalRankingSignals;
    }

    public List<SearchResult> getJoinedResults() {
        return this.mJoinedResults;
    }

    public List<MatchInfo> getMatchInfos() {
        if (this.mMatchInfosCached == null) {
            this.mMatchInfosCached = new ArrayList(this.mMatchInfos.size());
            for (int i = 0; i < this.mMatchInfos.size(); i++) {
                MatchInfo matchInfo = this.mMatchInfos.get(i);
                matchInfo.setDocument(getGenericDocument());
                if (matchInfo.getTextMatch() != null) {
                    matchInfo.mTextMatch.setPropertyPath(matchInfo.getPropertyPath());
                }
                List<MatchInfo> list = this.mMatchInfosCached;
                if (list != null) {
                    list.add(matchInfo);
                }
            }
            this.mMatchInfosCached = Collections.unmodifiableList(this.mMatchInfosCached);
        }
        return (List) Preconditions.checkNotNull(this.mMatchInfosCached);
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public Map<String, List<String>> getParentTypeMap() {
        Set<String> setKeySet = this.mParentTypeMap.keySet();
        ArrayMap arrayMap = new ArrayMap(setKeySet.size());
        for (String str : setKeySet) {
            ArrayList<String> stringArrayList = this.mParentTypeMap.getStringArrayList(str);
            if (stringArrayList != null) {
                arrayMap.put(str, stringArrayList);
            }
        }
        return arrayMap;
    }

    public double getRankingSignal() {
        return this.mRankingSignal;
    }

    public static final class MatchInfo extends AbstractSafeParcelable {
        public static final Parcelable.Creator<MatchInfo> CREATOR = new AbstractCreator<MatchInfo>() { // from class: androidx.appsearch.safeparcel.stub.StubCreators$MatchInfoCreator
            @Override // androidx.appsearch.safeparcel.stub.AbstractCreator, android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
                return super.createFromParcel(parcel);
            }

            @Override // androidx.appsearch.safeparcel.stub.AbstractCreator, android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return super.newArray(i);
            }
        };
        final int mExactMatchRangeEnd;
        final int mExactMatchRangeStart;
        private final String mPropertyPath;
        final int mSnippetRangeEnd;
        final int mSnippetRangeStart;
        final int mSubmatchRangeEnd;
        final int mSubmatchRangeStart;
        private final TextMatchInfo mTextMatch;
        private PropertyPath mPropertyPathObject = null;
        private GenericDocument mDocument = null;

        public MatchInfo(String str, int i, int i2, int i3, int i4, int i5, int i6, TextMatchInfo textMatchInfo, EmbeddingMatchInfo embeddingMatchInfo) {
            String str2 = (String) Preconditions.checkNotNull(str);
            this.mPropertyPath = str2;
            this.mExactMatchRangeStart = i;
            this.mExactMatchRangeEnd = i2;
            this.mSubmatchRangeStart = i3;
            this.mSubmatchRangeEnd = i4;
            this.mSnippetRangeStart = i5;
            this.mSnippetRangeEnd = i6;
            if (textMatchInfo == null) {
                TextMatchInfo textMatchInfo2 = new TextMatchInfo(i, i2, i3, i4, i5, i6);
                textMatchInfo2.setPropertyPath(str2);
                textMatchInfo = textMatchInfo2;
            }
            this.mTextMatch = textMatchInfo;
        }

        public EmbeddingMatchInfo getEmbeddingMatch() {
            return null;
        }

        public MatchRange getExactMatchRange() {
            TextMatchInfo textMatchInfo = this.mTextMatch;
            return textMatchInfo == null ? new MatchRange(0, 0) : textMatchInfo.getExactMatchRange();
        }

        public String getPropertyPath() {
            return this.mPropertyPath;
        }

        public MatchRange getSnippetRange() {
            TextMatchInfo textMatchInfo = this.mTextMatch;
            return textMatchInfo == null ? new MatchRange(0, 0) : textMatchInfo.getSnippetRange();
        }

        public TextMatchInfo getTextMatch() {
            return this.mTextMatch;
        }

        public void setDocument(GenericDocument genericDocument) {
            this.mDocument = (GenericDocument) Preconditions.checkNotNull(genericDocument);
            TextMatchInfo textMatchInfo = this.mTextMatch;
            if (textMatchInfo != null) {
                textMatchInfo.setDocument(genericDocument);
            }
        }

        public static final class Builder {
            private MatchRange mExactMatchRange;
            private final String mPropertyPath;
            private MatchRange mSnippetRange;
            private MatchRange mSubmatchRange;

            public Builder(MatchInfo matchInfo) {
                this.mExactMatchRange = new MatchRange(0, 0);
                this.mSubmatchRange = new MatchRange(-1, -1);
                this.mSnippetRange = new MatchRange(0, 0);
                Preconditions.checkNotNull(matchInfo);
                this.mPropertyPath = matchInfo.mPropertyPath;
                matchInfo.getEmbeddingMatch();
                this.mExactMatchRange = matchInfo.getExactMatchRange();
                this.mSubmatchRange = new MatchRange(matchInfo.mSubmatchRangeStart, matchInfo.mSubmatchRangeEnd);
                this.mSnippetRange = matchInfo.getSnippetRange();
            }

            public MatchInfo build() {
                TextMatchInfo textMatchInfo = new TextMatchInfo(this.mExactMatchRange.getStart(), this.mExactMatchRange.getEnd(), this.mSubmatchRange.getStart(), this.mSubmatchRange.getEnd(), this.mSnippetRange.getStart(), this.mSnippetRange.getEnd());
                textMatchInfo.setPropertyPath(this.mPropertyPath);
                return new MatchInfo(this.mPropertyPath, this.mExactMatchRange.getStart(), this.mExactMatchRange.getEnd(), this.mSubmatchRange.getStart(), this.mSubmatchRange.getEnd(), this.mSnippetRange.getStart(), this.mSnippetRange.getEnd(), textMatchInfo, null);
            }

            public Builder setExactMatchRange(MatchRange matchRange) {
                this.mExactMatchRange = (MatchRange) Preconditions.checkNotNull(matchRange);
                return this;
            }

            public Builder setSnippetRange(MatchRange matchRange) {
                this.mSnippetRange = (MatchRange) Preconditions.checkNotNull(matchRange);
                return this;
            }

            public Builder setSubmatchRange(MatchRange matchRange) {
                this.mSubmatchRange = (MatchRange) Preconditions.checkNotNull(matchRange);
                return this;
            }

            public Builder(String str) {
                this.mExactMatchRange = new MatchRange(0, 0);
                this.mSubmatchRange = new MatchRange(-1, -1);
                this.mSnippetRange = new MatchRange(0, 0);
                this.mPropertyPath = (String) Preconditions.checkNotNull(str);
            }
        }
    }

    public static final class Builder {
        private boolean mBuilt;
        private final String mDatabaseName;
        private GenericDocument mGenericDocument;
        private List<Double> mInformationalRankingSignals;
        private List<SearchResult> mJoinedResults;
        private List<MatchInfo> mMatchInfos;
        private final String mPackageName;
        private Bundle mParentTypeMap;
        private double mRankingSignal;

        public Builder(SearchResult searchResult) {
            this.mMatchInfos = new ArrayList();
            this.mInformationalRankingSignals = new ArrayList();
            this.mParentTypeMap = new Bundle();
            this.mJoinedResults = new ArrayList();
            this.mBuilt = false;
            Preconditions.checkNotNull(searchResult);
            this.mPackageName = searchResult.getPackageName();
            this.mDatabaseName = searchResult.getDatabaseName();
            this.mGenericDocument = searchResult.getGenericDocument();
            this.mRankingSignal = searchResult.getRankingSignal();
            this.mInformationalRankingSignals = new ArrayList(searchResult.getInformationalRankingSignals());
            setParentTypeMap(searchResult.getParentTypeMap());
            List<MatchInfo> matchInfos = searchResult.getMatchInfos();
            for (int i = 0; i < matchInfos.size(); i++) {
                addMatchInfo(new MatchInfo.Builder(matchInfos.get(i)).build());
            }
            List<SearchResult> joinedResults = searchResult.getJoinedResults();
            for (int i2 = 0; i2 < joinedResults.size(); i2++) {
                addJoinedResult(joinedResults.get(i2));
            }
        }

        private void resetIfBuilt() {
            if (this.mBuilt) {
                this.mMatchInfos = new ArrayList(this.mMatchInfos);
                this.mJoinedResults = new ArrayList(this.mJoinedResults);
                this.mInformationalRankingSignals = new ArrayList(this.mInformationalRankingSignals);
                this.mParentTypeMap = BundleUtil.deepCopy(this.mParentTypeMap);
                this.mBuilt = false;
            }
        }

        public Builder addInformationalRankingSignal(double d) {
            resetIfBuilt();
            this.mInformationalRankingSignals.add(Double.valueOf(d));
            return this;
        }

        public Builder addJoinedResult(SearchResult searchResult) {
            resetIfBuilt();
            this.mJoinedResults.add(searchResult);
            return this;
        }

        public Builder addMatchInfo(MatchInfo matchInfo) {
            Preconditions.checkState(matchInfo.mDocument == null, "This MatchInfo is already associated with a SearchResult and can't be reassigned");
            resetIfBuilt();
            this.mMatchInfos.add(matchInfo);
            return this;
        }

        public SearchResult build() {
            this.mBuilt = true;
            return new SearchResult(this.mGenericDocument.getDocumentParcel(), this.mMatchInfos, this.mPackageName, this.mDatabaseName, this.mRankingSignal, this.mJoinedResults, this.mInformationalRankingSignals, this.mParentTypeMap);
        }

        public Builder clearMatchInfos() {
            resetIfBuilt();
            this.mMatchInfos.clear();
            return this;
        }

        public Builder setGenericDocument(GenericDocument genericDocument) {
            Preconditions.checkNotNull(genericDocument);
            resetIfBuilt();
            this.mGenericDocument = genericDocument;
            return this;
        }

        public Builder setParentTypeMap(Map<String, List<String>> map) {
            Preconditions.checkNotNull(map);
            resetIfBuilt();
            this.mParentTypeMap.clear();
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                Preconditions.checkNotNull(entry.getKey());
                Preconditions.checkNotNull(entry.getValue());
                ArrayList<String> arrayList = new ArrayList<>(entry.getValue().size());
                for (int i = 0; i < entry.getValue().size(); i++) {
                    arrayList.add((String) Preconditions.checkNotNull(entry.getValue().get(i)));
                }
                this.mParentTypeMap.putStringArrayList(entry.getKey(), arrayList);
            }
            return this;
        }

        public Builder setRankingSignal(double d) {
            resetIfBuilt();
            this.mRankingSignal = d;
            return this;
        }

        public Builder(String str, String str2) {
            this.mMatchInfos = new ArrayList();
            this.mInformationalRankingSignals = new ArrayList();
            this.mParentTypeMap = new Bundle();
            this.mJoinedResults = new ArrayList();
            this.mBuilt = false;
            this.mPackageName = (String) Preconditions.checkNotNull(str);
            this.mDatabaseName = (String) Preconditions.checkNotNull(str2);
        }
    }
}
