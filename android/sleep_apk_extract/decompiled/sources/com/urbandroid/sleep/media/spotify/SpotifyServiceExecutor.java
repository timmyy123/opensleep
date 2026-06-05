package com.urbandroid.sleep.media.spotify;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.GraphResponse;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.share.internal.ShareConstants;
import com.urbandroid.common.AsyncContext;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.Utils;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.string.Joiner;
import com.urbandroid.common.util.string.PrependSizeTokenizer;
import com.urbandroid.sleep.media.spotify.SpotifyServiceExecutor;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kaaes.spotify.webapi.android.SpotifyService;
import kaaes.spotify.webapi.android.models.Album;
import kaaes.spotify.webapi.android.models.ArtistSimple;
import kaaes.spotify.webapi.android.models.Image;
import kaaes.spotify.webapi.android.models.Pager;
import kaaes.spotify.webapi.android.models.PlaylistSimple;
import kaaes.spotify.webapi.android.models.SavedAlbum;
import kaaes.spotify.webapi.android.models.SavedTrack;
import kaaes.spotify.webapi.android.models.Track;
import kaaes.spotify.webapi.android.models.UserPrivate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0003\u0014\u0015\u0016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ(\u0010\u000f\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/urbandroid/sleep/media/spotify/SpotifyServiceExecutor;", "Lcom/urbandroid/common/FeatureLogger;", "service", "Lkaaes/spotify/webapi/android/SpotifyService;", "<init>", "(Lkaaes/spotify/webapi/android/SpotifyService;)V", "tag", "", "getTag", "()Ljava/lang/String;", "getUser", "", "resultListener", "Lcom/urbandroid/sleep/media/spotify/SpotifyServiceExecutor$ResultListener;", "Lkaaes/spotify/webapi/android/models/UserPrivate;", "getUris", "", "Lcom/urbandroid/sleep/media/spotify/SpotifyServiceExecutor$SpotifyUri;", "types", "Lcom/urbandroid/sleep/media/spotify/SpotifyServiceExecutor$SpotifyUriType;", "SpotifyUriType", "SpotifyUri", "ResultListener", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SpotifyServiceExecutor implements FeatureLogger {
    private final SpotifyService service;
    private final String tag;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/media/spotify/SpotifyServiceExecutor$ResultListener;", "T", "", GraphResponse.SUCCESS_KEY, "", "result", "(Ljava/lang/Object;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public interface ResultListener<T> {
        void success(T result);
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0015\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001b\u0010\rR\u001f\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001f\u0010\rR\u0011\u0010!\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b \u0010\r¨\u0006#"}, d2 = {"Lcom/urbandroid/sleep/media/spotify/SpotifyServiceExecutor$SpotifyUri;", "", "Lcom/urbandroid/sleep/media/spotify/SpotifyServiceExecutor$SpotifyUriType;", "type", "", ShareConstants.MEDIA_URI, "title", "", "artists", "img", "<init>", "(Lcom/urbandroid/sleep/media/spotify/SpotifyServiceExecutor$SpotifyUriType;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "serialize", "()Ljava/lang/String;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "Lcom/urbandroid/sleep/media/spotify/SpotifyServiceExecutor$SpotifyUriType;", "getType", "()Lcom/urbandroid/sleep/media/spotify/SpotifyServiceExecutor$SpotifyUriType;", "Ljava/lang/String;", "getUri", "getTitle", "Ljava/util/List;", "getArtists", "()Ljava/util/List;", "getImg", "getArtistString", "artistString", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class SpotifyUri {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final List<String> artists;
        private final String img;
        private final String title;
        private final SpotifyUriType type;
        private final String uri;

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J>\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\fJ\u0014\u0010\u0010\u001a\u0004\u0018\u00010\t*\b\u0012\u0004\u0012\u00020\u000f0\fH\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\tJ\u0018\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\tH\u0002R0\u0010\u0011\u001a\u0012\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\t0\t\u0018\u00010\f*\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/urbandroid/sleep/media/spotify/SpotifyServiceExecutor$SpotifyUri$Companion;", "", "<init>", "()V", "from", "Lcom/urbandroid/sleep/media/spotify/SpotifyServiceExecutor$SpotifyUri;", "type", "Lcom/urbandroid/sleep/media/spotify/SpotifyServiceExecutor$SpotifyUriType;", ShareConstants.MEDIA_URI, "", "title", "artists", "", "Lkaaes/spotify/webapi/android/models/ArtistSimple;", "images", "Lkaaes/spotify/webapi/android/models/Image;", "pickImage", "names", "kotlin.jvm.PlatformType", "getNames", "(Ljava/util/List;)Ljava/util/List;", "deserialize", "data", "deserializeArtists", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final List<String> deserializeArtists(String data2) {
                ArrayList arrayList = new ArrayList();
                try {
                    PrependSizeTokenizer prependSizeTokenizer = new PrependSizeTokenizer(data2);
                    while (prependSizeTokenizer.hasToken()) {
                        String strNextToken = prependSizeTokenizer.nextToken();
                        strNextToken.getClass();
                        arrayList.add(strNextToken);
                    }
                    return arrayList;
                } catch (Exception e) {
                    Logger.logSevere(null, e);
                    return arrayList;
                }
            }

            private final List<String> getNames(List<? extends ArtistSimple> list) {
                if (list == null) {
                    return null;
                }
                List<? extends ArtistSimple> list2 = list;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((ArtistSimple) it.next()).name);
                }
                return arrayList;
            }

            private final String pickImage(List<? extends Image> list) {
                Object next;
                Object next2;
                List listSortedWith = CollectionsKt.sortedWith(list, new Comparator() { // from class: com.urbandroid.sleep.media.spotify.SpotifyServiceExecutor$SpotifyUri$Companion$pickImage$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        Integer num = ((Image) t).width;
                        Integer numValueOf = Integer.valueOf(num != null ? num.intValue() : Integer.MAX_VALUE);
                        Integer num2 = ((Image) t2).width;
                        return ComparisonsKt.compareValues(numValueOf, Integer.valueOf(num2 != null ? num2.intValue() : Integer.MAX_VALUE));
                    }
                });
                Iterator it = listSortedWith.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    Integer num = ((Image) next).width;
                    if (num == null) {
                        num = null;
                    }
                    if (num != null && num.intValue() >= 64) {
                        break;
                    }
                }
                Image image = (Image) next;
                if (image == null) {
                    Iterator it2 = CollectionsKt.asReversed(listSortedWith).iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it2.next();
                        Integer num2 = ((Image) next2).width;
                        if (num2 == null) {
                            num2 = null;
                        }
                        if (num2 != null && num2.intValue() < 64) {
                            break;
                        }
                    }
                    image = (Image) next2;
                    if (image == null) {
                        image = (Image) CollectionsKt.firstOrNull((List) list);
                    }
                }
                if (image != null) {
                    return image.url;
                }
                return null;
            }

            public final SpotifyUri deserialize(String data2) {
                if (data2 == null || data2.length() < 2) {
                    Logger.logWarning("item Wrong data: " + data2, null);
                    return null;
                }
                PrependSizeTokenizer prependSizeTokenizer = new PrependSizeTokenizer(data2);
                String strNextToken = prependSizeTokenizer.nextToken();
                strNextToken.getClass();
                SpotifyUriType spotifyUriTypeValueOf = SpotifyUriType.valueOf(strNextToken);
                String strNextToken2 = prependSizeTokenizer.nextToken();
                strNextToken2.getClass();
                String strNextToken3 = prependSizeTokenizer.nextToken();
                strNextToken3.getClass();
                return new SpotifyUri(spotifyUriTypeValueOf, strNextToken2, strNextToken3, SpotifyUri.INSTANCE.deserializeArtists(prependSizeTokenizer.nextToken()), prependSizeTokenizer.nextToken());
            }

            public final SpotifyUri from(SpotifyUriType type, String uri, String title, List<? extends ArtistSimple> artists, List<? extends Image> images) {
                type.getClass();
                uri.getClass();
                title.getClass();
                return new SpotifyUri(type, uri, title, getNames(artists), images != null ? pickImage(images) : null);
            }

            private Companion() {
            }
        }

        public SpotifyUri(SpotifyUriType spotifyUriType, String str, String str2, List<String> list, String str3) {
            spotifyUriType.getClass();
            str.getClass();
            str2.getClass();
            this.type = spotifyUriType;
            this.uri = str;
            this.title = str2;
            this.artists = list;
            this.img = str3;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other == null || !Intrinsics.areEqual(SpotifyUri.class, other.getClass())) {
                return false;
            }
            return Intrinsics.areEqual(this.uri, ((SpotifyUri) other).uri);
        }

        public final String getArtistString() {
            List<String> list = this.artists;
            if (list == null || list.isEmpty()) {
                return "";
            }
            String str = this.artists.get(0);
            return ((Object) str) + (this.artists.size() != 1 ? " ..." : "");
        }

        public final List<String> getArtists() {
            return this.artists;
        }

        public final String getImg() {
            return this.img;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getUri() {
            return this.uri;
        }

        public int hashCode() {
            return this.uri.hashCode();
        }

        public final String serialize() {
            try {
                Joiner joinerOn = Joiner.on("");
                Joiner.ItemMapper itemMapper = Joiner.PREPEND_SIZE_ITEM_MAPPER;
                Joiner map = joinerOn.map(itemMapper);
                List<String> listEmptyList = this.artists;
                if (listEmptyList == null) {
                    listEmptyList = CollectionsKt.emptyList();
                }
                String strJoin = Joiner.on("").map(itemMapper).join(CollectionsKt.listOf((Object[]) new String[]{this.type.name(), this.uri, this.title, map.join(listEmptyList), this.img}));
                strJoin.getClass();
                return strJoin;
            } catch (Exception e) {
                Logger.logSevere(null, e);
                return "";
            }
        }

        public String toString() {
            SpotifyUriType spotifyUriType = this.type;
            String str = this.uri;
            String str2 = this.title;
            List<String> list = this.artists;
            String str3 = this.img;
            StringBuilder sb = new StringBuilder("SpotifyUri(type=");
            sb.append(spotifyUriType);
            sb.append(", uri=");
            sb.append(str);
            sb.append(", title=");
            sb.append(str2);
            sb.append(", artists=");
            sb.append(list);
            sb.append(", img=");
            return FileInsert$$ExternalSyntheticOutline0.m(sb, str3, ")");
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbandroid/sleep/media/spotify/SpotifyServiceExecutor$SpotifyUriType;", "", "<init>", "(Ljava/lang/String;I)V", "TRACK", "ALBUM", "PLAYLIST", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class SpotifyUriType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SpotifyUriType[] $VALUES;
        public static final SpotifyUriType TRACK = new SpotifyUriType("TRACK", 0);
        public static final SpotifyUriType ALBUM = new SpotifyUriType("ALBUM", 1);
        public static final SpotifyUriType PLAYLIST = new SpotifyUriType("PLAYLIST", 2);

        private static final /* synthetic */ SpotifyUriType[] $values() {
            return new SpotifyUriType[]{TRACK, ALBUM, PLAYLIST};
        }

        static {
            SpotifyUriType[] spotifyUriTypeArr$values = $values();
            $VALUES = spotifyUriTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(spotifyUriTypeArr$values);
        }

        private SpotifyUriType(String str, int i) {
        }

        public static SpotifyUriType valueOf(String str) {
            return (SpotifyUriType) Enum.valueOf(SpotifyUriType.class, str);
        }

        public static SpotifyUriType[] values() {
            return (SpotifyUriType[]) $VALUES.clone();
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.media.spotify.SpotifyServiceExecutor$getUris$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/urbandroid/common/AsyncContext;", "Lcom/urbandroid/sleep/media/spotify/SpotifyServiceExecutor;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.media.spotify.SpotifyServiceExecutor$getUris$1", f = "SpotifyServiceExecutor.kt", l = {103}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<AsyncContext<SpotifyServiceExecutor>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ResultListener<List<SpotifyUri>> $resultListener;
        final /* synthetic */ List<SpotifyUriType> $types;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ SpotifyServiceExecutor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(List<? extends SpotifyUriType> list, SpotifyServiceExecutor spotifyServiceExecutor, ResultListener<List<SpotifyUri>> resultListener, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$types = list;
            this.this$0 = spotifyServiceExecutor;
            this.$resultListener = resultListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int invokeSuspend$lambda$0(SavedAlbum savedAlbum, SavedAlbum savedAlbum2) {
            String str = savedAlbum.added_at;
            String str2 = savedAlbum2.added_at;
            str2.getClass();
            return -str.compareTo(str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int invokeSuspend$lambda$2(SavedTrack savedTrack, SavedTrack savedTrack2) {
            String str = savedTrack.added_at;
            String str2 = savedTrack2.added_at;
            str2.getClass();
            return -str.compareTo(str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$3(ResultListener resultListener, List list, SpotifyServiceExecutor spotifyServiceExecutor) {
            resultListener.success(list);
            return Unit.INSTANCE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$types, this.this$0, this.$resultListener, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AsyncContext<SpotifyServiceExecutor> asyncContext, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(asyncContext, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AsyncContext asyncContext = (AsyncContext) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ArrayList arrayList = new ArrayList();
                Map<String, Object> mutableMap = MapsKt.toMutableMap(SpotifyServiceExecutorKt.options);
                final int i2 = 0;
                if (this.$types.contains(SpotifyUriType.ALBUM)) {
                    try {
                        ArrayList arrayList2 = new ArrayList();
                        int i3 = 0;
                        while (arrayList2.size() < 250) {
                            mutableMap.put(SpotifyService.OFFSET, Boxing.boxInt(i3));
                            Pager<SavedAlbum> mySavedAlbums = this.this$0.service.getMySavedAlbums(mutableMap);
                            List<SavedAlbum> list = mySavedAlbums.items;
                            list.getClass();
                            arrayList2.addAll(list);
                            if (mySavedAlbums.next == null) {
                                break;
                            }
                            i3 += 50;
                        }
                        CollectionsKt.sortWith(arrayList2, new Comparator() { // from class: com.urbandroid.sleep.media.spotify.SpotifyServiceExecutor$getUris$1$$ExternalSyntheticLambda0
                            @Override // java.util.Comparator
                            public final int compare(Object obj2, Object obj3) {
                                switch (i2) {
                                    case 0:
                                        return SpotifyServiceExecutor.AnonymousClass1.invokeSuspend$lambda$0((SavedAlbum) obj2, (SavedAlbum) obj3);
                                    default:
                                        return SpotifyServiceExecutor.AnonymousClass1.invokeSuspend$lambda$2((SavedTrack) obj2, (SavedTrack) obj3);
                                }
                            }
                        });
                        for (SavedAlbum savedAlbum : arrayList2.subList(0, Math.min(arrayList2.size(), 50))) {
                            SpotifyServiceExecutor spotifyServiceExecutor = this.this$0;
                            Album album = savedAlbum.album;
                            String str = "Album: " + album.name + " " + album.uri;
                            Logger.logDebug(Logger.defaultTag, spotifyServiceExecutor.getTag() + ": " + str, null);
                            SpotifyUri.Companion companion = SpotifyUri.INSTANCE;
                            SpotifyUriType spotifyUriType = SpotifyUriType.ALBUM;
                            String str2 = savedAlbum.album.uri;
                            str2.getClass();
                            String str3 = savedAlbum.album.name;
                            str3.getClass();
                            Album album2 = savedAlbum.album;
                            arrayList.add(companion.from(spotifyUriType, str2, str3, album2.artists, album2.images));
                        }
                    } catch (Exception e) {
                        SpotifyServiceExecutor spotifyServiceExecutor2 = this.this$0;
                        Logger.logSevere(Logger.defaultTag, spotifyServiceExecutor2.getTag() + ": read albums failure", e);
                    }
                }
                if (this.$types.contains(SpotifyUriType.PLAYLIST)) {
                    try {
                        ArrayList<PlaylistSimple> arrayList3 = new ArrayList();
                        int i4 = 0;
                        while (arrayList3.size() < 101) {
                            mutableMap.put(SpotifyService.OFFSET, Boxing.boxInt(i4));
                            Pager<PlaylistSimple> myPlaylists = this.this$0.service.getMyPlaylists(mutableMap);
                            List<PlaylistSimple> list2 = myPlaylists.items;
                            list2.getClass();
                            arrayList3.addAll(list2);
                            if (myPlaylists.next == null) {
                                break;
                            }
                            i4 += 50;
                        }
                        SpotifyServiceExecutor spotifyServiceExecutor3 = this.this$0;
                        for (PlaylistSimple playlistSimple : arrayList3) {
                            String str4 = "playlist " + playlistSimple.uri + " " + playlistSimple.name;
                            Logger.logDebug(Logger.defaultTag, spotifyServiceExecutor3.getTag() + ": " + str4, null);
                            SpotifyUri.Companion companion2 = SpotifyUri.INSTANCE;
                            SpotifyUriType spotifyUriType2 = SpotifyUriType.PLAYLIST;
                            String str5 = playlistSimple.uri;
                            str5.getClass();
                            String str6 = playlistSimple.name;
                            str6.getClass();
                            arrayList.add(companion2.from(spotifyUriType2, str5, str6, null, playlistSimple.images));
                        }
                    } catch (Exception e2) {
                        SpotifyServiceExecutor spotifyServiceExecutor4 = this.this$0;
                        Logger.logSevere(Logger.defaultTag, spotifyServiceExecutor4.getTag() + ": read playlists failure", e2);
                    }
                }
                if (this.$types.contains(SpotifyUriType.TRACK)) {
                    try {
                        ArrayList arrayList4 = new ArrayList();
                        int i5 = 0;
                        while (arrayList4.size() < 150) {
                            mutableMap.put(SpotifyService.OFFSET, Boxing.boxInt(i5));
                            Pager<SavedTrack> mySavedTracks = this.this$0.service.getMySavedTracks(mutableMap);
                            List<SavedTrack> list3 = mySavedTracks.items;
                            list3.getClass();
                            arrayList4.addAll(list3);
                            if (mySavedTracks.next == null) {
                                break;
                            }
                            i5 += 50;
                        }
                        final int i6 = 1;
                        CollectionsKt.sortWith(arrayList4, new Comparator() { // from class: com.urbandroid.sleep.media.spotify.SpotifyServiceExecutor$getUris$1$$ExternalSyntheticLambda0
                            @Override // java.util.Comparator
                            public final int compare(Object obj2, Object obj3) {
                                switch (i6) {
                                    case 0:
                                        return SpotifyServiceExecutor.AnonymousClass1.invokeSuspend$lambda$0((SavedAlbum) obj2, (SavedAlbum) obj3);
                                    default:
                                        return SpotifyServiceExecutor.AnonymousClass1.invokeSuspend$lambda$2((SavedTrack) obj2, (SavedTrack) obj3);
                                }
                            }
                        });
                        for (SavedTrack savedTrack : arrayList4.subList(0, Math.min(arrayList4.size(), 50))) {
                            SpotifyServiceExecutor spotifyServiceExecutor5 = this.this$0;
                            Track track = savedTrack.track;
                            String str7 = "Track: " + track.name + " " + track.uri;
                            Logger.logDebug(Logger.defaultTag, spotifyServiceExecutor5.getTag() + ": " + str7, null);
                            SpotifyUri.Companion companion3 = SpotifyUri.INSTANCE;
                            SpotifyUriType spotifyUriType3 = SpotifyUriType.TRACK;
                            String str8 = savedTrack.track.uri;
                            str8.getClass();
                            String str9 = savedTrack.track.name;
                            str9.getClass();
                            arrayList.add(companion3.from(spotifyUriType3, str8, str9, savedTrack.track.artists, null));
                        }
                    } catch (Exception e3) {
                        SpotifyServiceExecutor spotifyServiceExecutor6 = this.this$0;
                        Logger.logSevere(Logger.defaultTag, spotifyServiceExecutor6.getTag() + ": read tracks failure", e3);
                    }
                }
                SpotifyServiceExecutor$getUris$1$$ExternalSyntheticLambda2 spotifyServiceExecutor$getUris$1$$ExternalSyntheticLambda2 = new SpotifyServiceExecutor$getUris$1$$ExternalSyntheticLambda2(this.$resultListener, arrayList, 0);
                this.L$0 = SpillingKt.nullOutSpilledVariable(asyncContext);
                this.L$1 = SpillingKt.nullOutSpilledVariable(arrayList);
                this.L$2 = SpillingKt.nullOutSpilledVariable(mutableMap);
                this.label = 1;
                if (Utils.uiThread(asyncContext, spotifyServiceExecutor$getUris$1$$ExternalSyntheticLambda2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.media.spotify.SpotifyServiceExecutor$getUser$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/urbandroid/common/AsyncContext;", "Lcom/urbandroid/sleep/media/spotify/SpotifyServiceExecutor;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.media.spotify.SpotifyServiceExecutor$getUser$1", f = "SpotifyServiceExecutor.kt", l = {30}, m = "invokeSuspend", v = 2)
    public static final class C21361 extends SuspendLambda implements Function2<AsyncContext<SpotifyServiceExecutor>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ResultListener<UserPrivate> $resultListener;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C21361(ResultListener<UserPrivate> resultListener, Continuation<? super C21361> continuation) {
            super(2, continuation);
            this.$resultListener = resultListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(ResultListener resultListener, UserPrivate userPrivate, SpotifyServiceExecutor spotifyServiceExecutor) {
            resultListener.success(userPrivate);
            return Unit.INSTANCE;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C21361 c21361 = SpotifyServiceExecutor.this.new C21361(this.$resultListener, continuation);
            c21361.L$0 = obj;
            return c21361;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AsyncContext<SpotifyServiceExecutor> asyncContext, Continuation<? super Unit> continuation) {
            return ((C21361) create(asyncContext, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AsyncContext asyncContext = (AsyncContext) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            UserPrivate me = null;
            int i2 = 1;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    me = SpotifyServiceExecutor.this.service.getMe();
                } catch (Exception e) {
                    SpotifyServiceExecutor spotifyServiceExecutor = SpotifyServiceExecutor.this;
                    String str = Logger.defaultTag;
                    Logger.logSevere(str, spotifyServiceExecutor.getTag() + ": " + ("Failure getting spotify user: " + e), null);
                }
                SpotifyServiceExecutor$getUris$1$$ExternalSyntheticLambda2 spotifyServiceExecutor$getUris$1$$ExternalSyntheticLambda2 = new SpotifyServiceExecutor$getUris$1$$ExternalSyntheticLambda2(this.$resultListener, me, i2);
                this.L$0 = SpillingKt.nullOutSpilledVariable(asyncContext);
                this.L$1 = SpillingKt.nullOutSpilledVariable(me);
                this.label = 1;
                if (Utils.uiThread(asyncContext, spotifyServiceExecutor$getUris$1$$ExternalSyntheticLambda2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public SpotifyServiceExecutor(SpotifyService spotifyService) {
        spotifyService.getClass();
        this.service = spotifyService;
        this.tag = "Spotify";
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    public final void getUris(ResultListener<List<SpotifyUri>> resultListener, List<? extends SpotifyUriType> types) {
        resultListener.getClass();
        types.getClass();
        Utils.doAsyncThrowOnUI(this, new AnonymousClass1(types, this, resultListener, null));
    }

    public final void getUser(ResultListener<UserPrivate> resultListener) {
        resultListener.getClass();
        Utils.doAsyncThrowOnUI(this, new C21361(resultListener, null));
    }
}
