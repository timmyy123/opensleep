package androidx.appsearch.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appsearch.safeparcel.AbstractSafeParcelable;
import androidx.appsearch.safeparcel.stub.AbstractCreator;
import androidx.appsearch.util.BundleUtil;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
public final class SearchSpec extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SearchSpec> CREATOR = new AbstractCreator<SearchSpec>() { // from class: androidx.appsearch.safeparcel.stub.StubCreators$SearchSpecCreator
        @Override // androidx.appsearch.safeparcel.stub.AbstractCreator, android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
            return super.createFromParcel(parcel);
        }

        @Override // androidx.appsearch.safeparcel.stub.AbstractCreator, android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return super.newArray(i);
        }
    };
    private final String mAdvancedRankingExpression;
    private final int mDefaultEmbeddingSearchMetricType;
    private final List<EmbeddingVector> mEmbeddingParameters;
    private final List<String> mEnabledFeatures;
    private final List<String> mFilterDocumentIds;
    private final int mGroupingLimit;
    private final List<String> mInformationalRankingExpressions;
    private final JoinSpec mJoinSpec;
    private final int mMaxSnippetSize;
    private final List<String> mNamespaces;
    private final int mOrder;
    private final List<String> mPackageNames;
    final Bundle mProjectionTypePropertyMasks;
    private final int mRankingStrategy;
    private final int mResultCountPerPage;
    private final int mResultGroupingTypeFlags;
    private final boolean mRetrieveEmbeddingMatchInfos;
    private final List<String> mSchemas;
    private final String mSearchSourceLogTag;
    private final List<String> mSearchStringParameters;
    private final int mSnippetCount;
    private final int mSnippetCountPerProperty;
    private final int mTermMatchType;
    final Bundle mTypePropertyFilters;
    final Bundle mTypePropertyWeightsField;

    public SearchSpec(int i, List<String> list, List<String> list2, Bundle bundle, List<String> list3, int i2, int i3, int i4, int i5, int i6, int i7, Bundle bundle2, int i8, int i9, Bundle bundle3, JoinSpec joinSpec, String str, List<String> list4, String str2, List<EmbeddingVector> list5, int i10, List<String> list6, List<String> list7, List<String> list8, boolean z) {
        this.mTermMatchType = i;
        this.mSchemas = Collections.unmodifiableList((List) Preconditions.checkNotNull(list));
        this.mNamespaces = Collections.unmodifiableList((List) Preconditions.checkNotNull(list2));
        this.mTypePropertyFilters = (Bundle) Preconditions.checkNotNull(bundle);
        this.mPackageNames = Collections.unmodifiableList((List) Preconditions.checkNotNull(list3));
        this.mResultCountPerPage = i2;
        this.mRankingStrategy = i3;
        this.mOrder = i4;
        this.mSnippetCount = i5;
        this.mSnippetCountPerProperty = i6;
        this.mMaxSnippetSize = i7;
        this.mProjectionTypePropertyMasks = (Bundle) Preconditions.checkNotNull(bundle2);
        this.mResultGroupingTypeFlags = i8;
        this.mGroupingLimit = i9;
        this.mTypePropertyWeightsField = (Bundle) Preconditions.checkNotNull(bundle3);
        this.mJoinSpec = joinSpec;
        this.mAdvancedRankingExpression = (String) Preconditions.checkNotNull(str);
        this.mEnabledFeatures = Collections.unmodifiableList((List) Preconditions.checkNotNull(list4));
        this.mSearchSourceLogTag = str2;
        if (list5 != null) {
            this.mEmbeddingParameters = Collections.unmodifiableList(list5);
        } else {
            this.mEmbeddingParameters = Collections.EMPTY_LIST;
        }
        this.mDefaultEmbeddingSearchMetricType = i10;
        if (list6 != null) {
            this.mInformationalRankingExpressions = Collections.unmodifiableList(list6);
        } else {
            this.mInformationalRankingExpressions = Collections.EMPTY_LIST;
        }
        this.mSearchStringParameters = list7 != null ? Collections.unmodifiableList(list7) : Collections.EMPTY_LIST;
        this.mFilterDocumentIds = list8 != null ? Collections.unmodifiableList(list8) : Collections.EMPTY_LIST;
        this.mRetrieveEmbeddingMatchInfos = z;
    }

    public String getAdvancedRankingExpression() {
        return this.mAdvancedRankingExpression;
    }

    public int getDefaultEmbeddingSearchMetricType() {
        return this.mDefaultEmbeddingSearchMetricType;
    }

    public List<EmbeddingVector> getEmbeddingParameters() {
        return this.mEmbeddingParameters;
    }

    public List<String> getEnabledFeatures() {
        return this.mEnabledFeatures;
    }

    public List<String> getFilterDocumentIds() {
        return this.mFilterDocumentIds;
    }

    public List<String> getFilterNamespaces() {
        List<String> list = this.mNamespaces;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public List<String> getFilterPackageNames() {
        List<String> list = this.mPackageNames;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public Map<String, List<String>> getFilterProperties() {
        Set<String> setKeySet = this.mTypePropertyFilters.keySet();
        ArrayMap arrayMap = new ArrayMap(setKeySet.size());
        for (String str : setKeySet) {
            arrayMap.put(str, (List) Preconditions.checkNotNull(this.mTypePropertyFilters.getStringArrayList(str)));
        }
        return arrayMap;
    }

    public List<String> getFilterSchemas() {
        List<String> list = this.mSchemas;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public List<String> getInformationalRankingExpressions() {
        return this.mInformationalRankingExpressions;
    }

    public JoinSpec getJoinSpec() {
        return this.mJoinSpec;
    }

    public int getMaxSnippetSize() {
        return this.mMaxSnippetSize;
    }

    public int getOrder() {
        return this.mOrder;
    }

    public Map<String, List<String>> getProjections() {
        Set<String> setKeySet = this.mProjectionTypePropertyMasks.keySet();
        ArrayMap arrayMap = new ArrayMap(setKeySet.size());
        for (String str : setKeySet) {
            ArrayList<String> stringArrayList = this.mProjectionTypePropertyMasks.getStringArrayList(str);
            Objects.requireNonNull(stringArrayList);
            arrayMap.put(str, stringArrayList);
        }
        return arrayMap;
    }

    public Map<String, Map<String, Double>> getPropertyWeights() {
        Set<String> setKeySet = this.mTypePropertyWeightsField.keySet();
        ArrayMap arrayMap = new ArrayMap(setKeySet.size());
        for (String str : setKeySet) {
            Bundle bundle = this.mTypePropertyWeightsField.getBundle(str);
            if (bundle != null) {
                Set<String> setKeySet2 = bundle.keySet();
                ArrayMap arrayMap2 = new ArrayMap(setKeySet2.size());
                for (String str2 : setKeySet2) {
                    arrayMap2.put(str2, Double.valueOf(bundle.getDouble(str2)));
                }
                arrayMap.put(str, arrayMap2);
            }
        }
        return arrayMap;
    }

    public int getRankingStrategy() {
        return this.mRankingStrategy;
    }

    public int getResultCountPerPage() {
        return this.mResultCountPerPage;
    }

    public int getResultGroupingLimit() {
        return this.mGroupingLimit;
    }

    public int getResultGroupingTypeFlags() {
        return this.mResultGroupingTypeFlags;
    }

    public String getSearchSourceLogTag() {
        return this.mSearchSourceLogTag;
    }

    public List<String> getSearchStringParameters() {
        return this.mSearchStringParameters;
    }

    public int getSnippetCount() {
        return this.mSnippetCount;
    }

    public int getSnippetCountPerProperty() {
        return this.mSnippetCountPerProperty;
    }

    public int getTermMatch() {
        return this.mTermMatchType;
    }

    public boolean isListFilterHasPropertyFunctionEnabled() {
        return this.mEnabledFeatures.contains("LIST_FILTER_HAS_PROPERTY_FUNCTION");
    }

    public boolean isListFilterMatchScoreExpressionFunctionEnabled() {
        return this.mEnabledFeatures.contains("LIST_FILTER_MATCH_SCORE_EXPRESSION_FUNCTION");
    }

    public boolean isListFilterQueryLanguageEnabled() {
        return this.mEnabledFeatures.contains("LIST_FILTER_QUERY_LANGUAGE");
    }

    public boolean isNumericSearchEnabled() {
        return this.mEnabledFeatures.contains("NUMERIC_SEARCH");
    }

    public boolean isScorablePropertyRankingEnabled() {
        return this.mEnabledFeatures.contains("SCHEMA_SCORABLE_PROPERTY_CONFIG");
    }

    public boolean isVerbatimSearchEnabled() {
        return this.mEnabledFeatures.contains("VERBATIM_SEARCH");
    }

    public static final class Builder {
        private JoinSpec mJoinSpec;
        private String mSearchSourceLogTag;
        private List<String> mSchemas = new ArrayList();
        private List<String> mNamespaces = new ArrayList();
        private Bundle mTypePropertyFilters = new Bundle();
        private List<String> mPackageNames = new ArrayList();
        private ArraySet<String> mEnabledFeatures = new ArraySet<>();
        private Bundle mProjectionTypePropertyMasks = new Bundle();
        private Bundle mTypePropertyWeights = new Bundle();
        private List<EmbeddingVector> mEmbeddingParameters = new ArrayList();
        private List<String> mSearchStringParameters = new ArrayList();
        private List<String> mFilterDocumentIds = new ArrayList();
        private int mResultCountPerPage = 10;
        private int mTermMatchType = 2;
        private int mDefaultEmbeddingSearchMetricType = 1;
        private int mSnippetCount = 0;
        private int mSnippetCountPerProperty = 10000;
        private int mMaxSnippetSize = 0;
        private int mRankingStrategy = 0;
        private int mOrder = 0;
        private int mGroupingTypeFlags = 0;
        private int mGroupingLimit = 0;
        private String mAdvancedRankingExpression = "";
        private List<String> mInformationalRankingExpressions = new ArrayList();
        private boolean mRetrieveEmbeddingMatchInfos = false;
        private boolean mBuilt = false;

        private void modifyEnabledFeature(String str, boolean z) {
            resetIfBuilt();
            ArraySet<String> arraySet = this.mEnabledFeatures;
            if (z) {
                arraySet.add(str);
            } else {
                arraySet.remove(str);
            }
        }

        private void resetIfBuilt() {
            if (this.mBuilt) {
                this.mSchemas = new ArrayList(this.mSchemas);
                this.mTypePropertyFilters = BundleUtil.deepCopy(this.mTypePropertyFilters);
                this.mNamespaces = new ArrayList(this.mNamespaces);
                this.mPackageNames = new ArrayList(this.mPackageNames);
                this.mProjectionTypePropertyMasks = BundleUtil.deepCopy(this.mProjectionTypePropertyMasks);
                this.mTypePropertyWeights = BundleUtil.deepCopy(this.mTypePropertyWeights);
                this.mEmbeddingParameters = new ArrayList(this.mEmbeddingParameters);
                this.mInformationalRankingExpressions = new ArrayList(this.mInformationalRankingExpressions);
                this.mSearchStringParameters = new ArrayList(this.mSearchStringParameters);
                this.mFilterDocumentIds = new ArrayList(this.mFilterDocumentIds);
                this.mBuilt = false;
            }
        }

        public Builder addFilterDocumentClasses(Collection<? extends Class<?>> collection) {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            ArrayList arrayList = new ArrayList(collection.size());
            DocumentClassFactoryRegistry documentClassFactoryRegistry = DocumentClassFactoryRegistry.getInstance();
            Iterator<? extends Class<?>> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(documentClassFactoryRegistry.getOrCreateFactory((Class) it.next()).getSchemaName());
            }
            addFilterSchemas(arrayList);
            return this;
        }

        public Builder addFilterNamespaces(String... strArr) {
            Preconditions.checkNotNull(strArr);
            resetIfBuilt();
            return addFilterNamespaces(Arrays.asList(strArr));
        }

        public Builder addFilterPackageNames(String... strArr) {
            Preconditions.checkNotNull(strArr);
            resetIfBuilt();
            return addFilterPackageNames(Arrays.asList(strArr));
        }

        public Builder addFilterSchemas(Collection<String> collection) {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            this.mSchemas.addAll(collection);
            return this;
        }

        public SearchSpec build() {
            int i;
            JoinSpec joinSpec = this.mJoinSpec;
            int i2 = this.mRankingStrategy;
            if (joinSpec != null) {
                if (i2 != 8 && joinSpec.getAggregationScoringStrategy() != 0) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("Aggregate scoring strategy has been set in the nested JoinSpec, but ranking strategy is not RANKING_STRATEGY_JOIN_AGGREGATE_SCORE");
                    return null;
                }
            } else if (i2 == 8) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("Attempting to rank based on joined documents, but no JoinSpec provided");
                return null;
            }
            if (this.mTypePropertyWeights.isEmpty() || (i = this.mRankingStrategy) == 3 || i == 9) {
                this.mBuilt = true;
                return new SearchSpec(this.mTermMatchType, this.mSchemas, this.mNamespaces, this.mTypePropertyFilters, this.mPackageNames, this.mResultCountPerPage, this.mRankingStrategy, this.mOrder, this.mSnippetCount, this.mSnippetCountPerProperty, this.mMaxSnippetSize, this.mProjectionTypePropertyMasks, this.mGroupingTypeFlags, this.mGroupingLimit, this.mTypePropertyWeights, this.mJoinSpec, this.mAdvancedRankingExpression, new ArrayList(this.mEnabledFeatures), this.mSearchSourceLogTag, this.mEmbeddingParameters, this.mDefaultEmbeddingSearchMetricType, this.mInformationalRankingExpressions, this.mSearchStringParameters, this.mFilterDocumentIds, this.mRetrieveEmbeddingMatchInfos);
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2("Property weights are only compatible with the RANKING_STRATEGY_RELEVANCE_SCORE and RANKING_STRATEGY_ADVANCED_RANKING_EXPRESSION ranking strategies.");
            return null;
        }

        public Builder setJoinSpec(JoinSpec joinSpec) {
            resetIfBuilt();
            this.mJoinSpec = (JoinSpec) Preconditions.checkNotNull(joinSpec);
            return this;
        }

        public Builder setListFilterQueryLanguageEnabled(boolean z) {
            modifyEnabledFeature("LIST_FILTER_QUERY_LANGUAGE", z);
            return this;
        }

        public Builder setNumericSearchEnabled(boolean z) {
            modifyEnabledFeature("NUMERIC_SEARCH", z);
            return this;
        }

        public Builder setVerbatimSearchEnabled(boolean z) {
            modifyEnabledFeature("VERBATIM_SEARCH", z);
            return this;
        }

        public Builder addFilterNamespaces(Collection<String> collection) {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            this.mNamespaces.addAll(collection);
            return this;
        }

        public Builder addFilterPackageNames(Collection<String> collection) {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            this.mPackageNames.addAll(collection);
            return this;
        }

        public Builder addFilterDocumentClasses(Class<?>... clsArr) {
            Preconditions.checkNotNull(clsArr);
            resetIfBuilt();
            return addFilterDocumentClasses(Arrays.asList(clsArr));
        }
    }
}
