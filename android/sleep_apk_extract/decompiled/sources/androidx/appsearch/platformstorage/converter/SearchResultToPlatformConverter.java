package androidx.appsearch.platformstorage.converter;

import adamb.ogg.OggIO$$ExternalSyntheticBUOutline0;
import android.app.appsearch.SearchResult;
import android.os.Build;
import android.util.Log;
import androidx.appsearch.app.SearchResult;
import androidx.appsearch.platformstorage.util.AppSearchVersionUtil;
import androidx.core.util.Preconditions;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class SearchResultToPlatformConverter {

    public static class ApiHelperForB {
        public static List<Double> getInformationalRankingSignals(SearchResult searchResult) {
            return searchResult.getInformationalRankingSignals();
        }

        public static Map<String, List<String>> getParentTypeMap(SearchResult searchResult) {
            return searchResult.getParentTypeMap();
        }
    }

    public static class ApiHelperForT {
        public static int getSubmatchRangeEnd(SearchResult.MatchInfo matchInfo) {
            return matchInfo.getSubmatchRange().getEnd();
        }

        public static int getSubmatchRangeStart(SearchResult.MatchInfo matchInfo) {
            return matchInfo.getSubmatchRange().getStart();
        }
    }

    public static class ApiHelperForU {
        public static List<SearchResult> getJoinedResults(SearchResult searchResult) {
            return searchResult.getJoinedResults();
        }
    }

    private static SearchResult.MatchInfo toJetpackMatchInfo(SearchResult.MatchInfo matchInfo) {
        Preconditions.checkNotNull(matchInfo);
        SearchResult.MatchInfo.Builder snippetRange = new SearchResult.MatchInfo.Builder(matchInfo.getPropertyPath()).setExactMatchRange(new SearchResult.MatchRange(matchInfo.getExactMatchRange().getStart(), matchInfo.getExactMatchRange().getEnd())).setSnippetRange(new SearchResult.MatchRange(matchInfo.getSnippetRange().getStart(), matchInfo.getSnippetRange().getEnd()));
        if (Build.VERSION.SDK_INT >= 33) {
            snippetRange.setSubmatchRange(new SearchResult.MatchRange(ApiHelperForT.getSubmatchRangeStart(matchInfo), ApiHelperForT.getSubmatchRangeEnd(matchInfo)));
        }
        return snippetRange.build();
    }

    public static androidx.appsearch.app.SearchResult toJetpackSearchResult(android.app.appsearch.SearchResult searchResult) {
        Preconditions.checkNotNull(searchResult);
        SearchResult.Builder rankingSignal = new SearchResult.Builder(searchResult.getPackageName(), searchResult.getDatabaseName()).setGenericDocument(GenericDocumentToPlatformConverter.toJetpackGenericDocument(searchResult.getGenericDocument())).setRankingSignal(searchResult.getRankingSignal());
        List<SearchResult.MatchInfo> matchInfos = searchResult.getMatchInfos();
        for (int i = 0; i < matchInfos.size(); i++) {
            rankingSignal.addMatchInfo(toJetpackMatchInfo(matchInfos.get(i)));
        }
        if (Build.VERSION.SDK_INT >= 34) {
            Iterator<android.app.appsearch.SearchResult> it = ApiHelperForU.getJoinedResults(searchResult).iterator();
            while (it.hasNext()) {
                rankingSignal.addJoinedResult(toJetpackSearchResult(OggIO$$ExternalSyntheticBUOutline0.m2m((Object) it.next())));
            }
        }
        if (AppSearchVersionUtil.isAtLeastB()) {
            List<Double> informationalRankingSignals = ApiHelperForB.getInformationalRankingSignals(searchResult);
            for (int i2 = 0; i2 < informationalRankingSignals.size(); i2++) {
                rankingSignal.addInformationalRankingSignal(informationalRankingSignals.get(i2).doubleValue());
            }
            try {
                rankingSignal.setParentTypeMap(ApiHelperForB.getParentTypeMap(searchResult));
            } catch (NoSuchMethodError e) {
                Log.e("AppSearchSearchResPlatC", "Failed to set parent type map.", e);
            }
        }
        return rankingSignal.build();
    }
}
