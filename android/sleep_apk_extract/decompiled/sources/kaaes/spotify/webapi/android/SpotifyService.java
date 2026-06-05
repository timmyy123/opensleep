package kaaes.spotify.webapi.android;

import java.util.Map;
import kaaes.spotify.webapi.android.annotations.DELETEWITHBODY;
import kaaes.spotify.webapi.android.models.Album;
import kaaes.spotify.webapi.android.models.Albums;
import kaaes.spotify.webapi.android.models.AlbumsPager;
import kaaes.spotify.webapi.android.models.Artist;
import kaaes.spotify.webapi.android.models.Artists;
import kaaes.spotify.webapi.android.models.ArtistsCursorPager;
import kaaes.spotify.webapi.android.models.ArtistsPager;
import kaaes.spotify.webapi.android.models.AudioFeaturesTrack;
import kaaes.spotify.webapi.android.models.AudioFeaturesTracks;
import kaaes.spotify.webapi.android.models.CategoriesPager;
import kaaes.spotify.webapi.android.models.Category;
import kaaes.spotify.webapi.android.models.FeaturedPlaylists;
import kaaes.spotify.webapi.android.models.NewReleases;
import kaaes.spotify.webapi.android.models.Pager;
import kaaes.spotify.webapi.android.models.Playlist;
import kaaes.spotify.webapi.android.models.PlaylistFollowPrivacy;
import kaaes.spotify.webapi.android.models.PlaylistSimple;
import kaaes.spotify.webapi.android.models.PlaylistTrack;
import kaaes.spotify.webapi.android.models.PlaylistsPager;
import kaaes.spotify.webapi.android.models.Recommendations;
import kaaes.spotify.webapi.android.models.Result;
import kaaes.spotify.webapi.android.models.SavedAlbum;
import kaaes.spotify.webapi.android.models.SavedTrack;
import kaaes.spotify.webapi.android.models.SeedsGenres;
import kaaes.spotify.webapi.android.models.SnapshotId;
import kaaes.spotify.webapi.android.models.Track;
import kaaes.spotify.webapi.android.models.Tracks;
import kaaes.spotify.webapi.android.models.TracksPager;
import kaaes.spotify.webapi.android.models.TracksToRemove;
import kaaes.spotify.webapi.android.models.TracksToRemoveWithPosition;
import kaaes.spotify.webapi.android.models.UserPrivate;
import kaaes.spotify.webapi.android.models.UserPublic;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.http.QueryMap;

/* JADX INFO: loaded from: classes5.dex */
public interface SpotifyService {
    public static final String ALBUM_TYPE = "album_type";
    public static final String COUNTRY = "country";
    public static final String FIELDS = "fields";
    public static final String LIMIT = "limit";
    public static final String LOCALE = "locale";
    public static final String MARKET = "market";
    public static final String OFFSET = "offset";
    public static final String TIMESTAMP = "timestamp";
    public static final String TIME_RANGE = "time_range";

    @PUT("/me/albums")
    Result addToMySavedAlbums(@Query("ids") String str);

    @PUT("/me/albums")
    void addToMySavedAlbums(@Query("ids") String str, Callback<Object> callback);

    @PUT("/me/tracks")
    Result addToMySavedTracks(@Query("ids") String str);

    @PUT("/me/tracks")
    void addToMySavedTracks(@Query("ids") String str, Callback<Object> callback);

    @POST("/users/{user_id}/playlists/{playlist_id}/tracks")
    SnapshotId addTracksToPlaylist(@Path("user_id") String str, @Path("playlist_id") String str2, @QueryMap Map<String, Object> map, @Body Map<String, Object> map2);

    @POST("/users/{user_id}/playlists/{playlist_id}/tracks")
    void addTracksToPlaylist(@Path("user_id") String str, @Path("playlist_id") String str2, @QueryMap Map<String, Object> map, @Body Map<String, Object> map2, Callback<Pager<PlaylistTrack>> callback);

    @GET("/users/{user_id}/playlists/{playlist_id}/followers/contains")
    void areFollowingPlaylist(@Path("user_id") String str, @Path("playlist_id") String str2, @Query("ids") String str3, Callback<boolean[]> callback);

    @GET("/users/{user_id}/playlists/{playlist_id}/followers/contains")
    Boolean[] areFollowingPlaylist(@Path("user_id") String str, @Path("playlist_id") String str2, @Query("ids") String str3);

    @PUT("/users/{user_id}/playlists/{playlist_id}")
    Result changePlaylistDetails(@Path("user_id") String str, @Path("playlist_id") String str2, @Body Map<String, Object> map);

    @PUT("/users/{user_id}/playlists/{playlist_id}")
    void changePlaylistDetails(@Path("user_id") String str, @Path("playlist_id") String str2, @Body Map<String, Object> map, Callback<Result> callback);

    @GET("/me/albums/contains")
    void containsMySavedAlbums(@Query("ids") String str, Callback<boolean[]> callback);

    @GET("/me/albums/contains")
    Boolean[] containsMySavedAlbums(@Query("ids") String str);

    @GET("/me/tracks/contains")
    void containsMySavedTracks(@Query("ids") String str, Callback<boolean[]> callback);

    @GET("/me/tracks/contains")
    Boolean[] containsMySavedTracks(@Query("ids") String str);

    @POST("/users/{user_id}/playlists")
    Playlist createPlaylist(@Path("user_id") String str, @Body Map<String, Object> map);

    @POST("/users/{user_id}/playlists")
    void createPlaylist(@Path("user_id") String str, @Body Map<String, Object> map, Callback<Playlist> callback);

    @PUT("/me/following?type=artist")
    Result followArtists(@Query("ids") String str);

    @PUT("/me/following?type=artist")
    void followArtists(@Query("ids") String str, Callback<Object> callback);

    @PUT("/users/{user_id}/playlists/{playlist_id}/followers")
    Result followPlaylist(@Path("user_id") String str, @Path("playlist_id") String str2);

    @PUT("/users/{user_id}/playlists/{playlist_id}/followers")
    Result followPlaylist(@Path("user_id") String str, @Path("playlist_id") String str2, @Body PlaylistFollowPrivacy playlistFollowPrivacy);

    @PUT("/users/{user_id}/playlists/{playlist_id}/followers")
    void followPlaylist(@Path("user_id") String str, @Path("playlist_id") String str2, @Body PlaylistFollowPrivacy playlistFollowPrivacy, Callback<Result> callback);

    @PUT("/users/{user_id}/playlists/{playlist_id}/followers")
    void followPlaylist(@Path("user_id") String str, @Path("playlist_id") String str2, Callback<Result> callback);

    @PUT("/me/following?type=user")
    Result followUsers(@Query("ids") String str);

    @PUT("/me/following?type=user")
    void followUsers(@Query("ids") String str, Callback<Object> callback);

    @GET("/albums/{id}")
    Album getAlbum(@Path("id") String str);

    @GET("/albums/{id}")
    Album getAlbum(@Path("id") String str, @QueryMap Map<String, Object> map);

    @GET("/albums/{id}")
    void getAlbum(@Path("id") String str, @QueryMap Map<String, Object> map, Callback<Album> callback);

    @GET("/albums/{id}")
    void getAlbum(@Path("id") String str, Callback<Album> callback);

    @GET("/albums/{id}/tracks")
    Pager<Track> getAlbumTracks(@Path("id") String str);

    @GET("/albums/{id}/tracks")
    Pager<Track> getAlbumTracks(@Path("id") String str, @QueryMap Map<String, Object> map);

    @GET("/albums/{id}/tracks")
    void getAlbumTracks(@Path("id") String str, @QueryMap Map<String, Object> map, Callback<Pager<Track>> callback);

    @GET("/albums/{id}/tracks")
    void getAlbumTracks(@Path("id") String str, Callback<Pager<Track>> callback);

    @GET("/albums")
    Albums getAlbums(@Query("ids") String str);

    @GET("/albums")
    Albums getAlbums(@Query("ids") String str, @QueryMap Map<String, Object> map);

    @GET("/albums")
    void getAlbums(@Query("ids") String str, @QueryMap Map<String, Object> map, Callback<Albums> callback);

    @GET("/albums")
    void getAlbums(@Query("ids") String str, Callback<Albums> callback);

    @GET("/artists/{id}")
    Artist getArtist(@Path("id") String str);

    @GET("/artists/{id}")
    void getArtist(@Path("id") String str, Callback<Artist> callback);

    @GET("/artists/{id}/albums")
    Pager<Album> getArtistAlbums(@Path("id") String str);

    @GET("/artists/{id}/albums")
    Pager<Album> getArtistAlbums(@Path("id") String str, @QueryMap Map<String, Object> map);

    @GET("/artists/{id}/albums")
    void getArtistAlbums(@Path("id") String str, @QueryMap Map<String, Object> map, Callback<Pager<Album>> callback);

    @GET("/artists/{id}/albums")
    void getArtistAlbums(@Path("id") String str, Callback<Pager<Album>> callback);

    @GET("/artists/{id}/top-tracks")
    Tracks getArtistTopTrack(@Path("id") String str, @Query("country") String str2);

    @GET("/artists/{id}/top-tracks")
    void getArtistTopTrack(@Path("id") String str, @Query("country") String str2, Callback<Tracks> callback);

    @GET("/artists")
    Artists getArtists(@Query("ids") String str);

    @GET("/artists")
    void getArtists(@Query("ids") String str, Callback<Artists> callback);

    @GET("/browse/categories")
    CategoriesPager getCategories(@QueryMap Map<String, Object> map);

    @GET("/browse/categories")
    void getCategories(@QueryMap Map<String, Object> map, Callback<CategoriesPager> callback);

    @GET("/browse/categories/{category_id}")
    Category getCategory(@Path("category_id") String str, @QueryMap Map<String, Object> map);

    @GET("/browse/categories/{category_id}")
    void getCategory(@Path("category_id") String str, @QueryMap Map<String, Object> map, Callback<Category> callback);

    @GET("/browse/featured-playlists")
    FeaturedPlaylists getFeaturedPlaylists();

    @GET("/browse/featured-playlists")
    FeaturedPlaylists getFeaturedPlaylists(@QueryMap Map<String, Object> map);

    @GET("/browse/featured-playlists")
    void getFeaturedPlaylists(@QueryMap Map<String, Object> map, Callback<FeaturedPlaylists> callback);

    @GET("/browse/featured-playlists")
    void getFeaturedPlaylists(Callback<FeaturedPlaylists> callback);

    @GET("/me/following?type=artist")
    ArtistsCursorPager getFollowedArtists();

    @GET("/me/following?type=artist")
    ArtistsCursorPager getFollowedArtists(@QueryMap Map<String, Object> map);

    @GET("/me/following?type=artist")
    void getFollowedArtists(@QueryMap Map<String, Object> map, Callback<ArtistsCursorPager> callback);

    @GET("/me/following?type=artist")
    void getFollowedArtists(Callback<ArtistsCursorPager> callback);

    @GET("/me")
    UserPrivate getMe();

    @GET("/me")
    void getMe(Callback<UserPrivate> callback);

    @GET("/me/playlists")
    Pager<PlaylistSimple> getMyPlaylists();

    @GET("/me/playlists")
    Pager<PlaylistSimple> getMyPlaylists(@QueryMap Map<String, Object> map);

    @GET("/me/playlists")
    void getMyPlaylists(@QueryMap Map<String, Object> map, Callback<Pager<PlaylistSimple>> callback);

    @GET("/me/playlists")
    void getMyPlaylists(Callback<Pager<PlaylistSimple>> callback);

    @GET("/me/albums")
    Pager<SavedAlbum> getMySavedAlbums();

    @GET("/me/albums")
    Pager<SavedAlbum> getMySavedAlbums(@QueryMap Map<String, Object> map);

    @GET("/me/albums")
    void getMySavedAlbums(@QueryMap Map<String, Object> map, Callback<Pager<SavedAlbum>> callback);

    @GET("/me/albums")
    void getMySavedAlbums(Callback<Pager<SavedAlbum>> callback);

    @GET("/me/tracks")
    Pager<SavedTrack> getMySavedTracks();

    @GET("/me/tracks")
    Pager<SavedTrack> getMySavedTracks(@QueryMap Map<String, Object> map);

    @GET("/me/tracks")
    void getMySavedTracks(@QueryMap Map<String, Object> map, Callback<Pager<SavedTrack>> callback);

    @GET("/me/tracks")
    void getMySavedTracks(Callback<Pager<SavedTrack>> callback);

    @GET("/browse/new-releases")
    NewReleases getNewReleases();

    @GET("/browse/new-releases")
    NewReleases getNewReleases(@QueryMap Map<String, Object> map);

    @GET("/browse/new-releases")
    void getNewReleases(@QueryMap Map<String, Object> map, Callback<NewReleases> callback);

    @GET("/browse/new-releases")
    void getNewReleases(Callback<NewReleases> callback);

    @GET("/users/{user_id}/playlists/{playlist_id}")
    Playlist getPlaylist(@Path("user_id") String str, @Path("playlist_id") String str2);

    @GET("/users/{user_id}/playlists/{playlist_id}")
    Playlist getPlaylist(@Path("user_id") String str, @Path("playlist_id") String str2, @QueryMap Map<String, Object> map);

    @GET("/users/{user_id}/playlists/{playlist_id}")
    void getPlaylist(@Path("user_id") String str, @Path("playlist_id") String str2, @QueryMap Map<String, Object> map, Callback<Playlist> callback);

    @GET("/users/{user_id}/playlists/{playlist_id}")
    void getPlaylist(@Path("user_id") String str, @Path("playlist_id") String str2, Callback<Playlist> callback);

    @GET("/users/{user_id}/playlists/{playlist_id}/tracks")
    Pager<PlaylistTrack> getPlaylistTracks(@Path("user_id") String str, @Path("playlist_id") String str2);

    @GET("/users/{user_id}/playlists/{playlist_id}/tracks")
    Pager<PlaylistTrack> getPlaylistTracks(@Path("user_id") String str, @Path("playlist_id") String str2, @QueryMap Map<String, Object> map);

    @GET("/users/{user_id}/playlists/{playlist_id}/tracks")
    void getPlaylistTracks(@Path("user_id") String str, @Path("playlist_id") String str2, @QueryMap Map<String, Object> map, Callback<Pager<PlaylistTrack>> callback);

    @GET("/users/{user_id}/playlists/{playlist_id}/tracks")
    void getPlaylistTracks(@Path("user_id") String str, @Path("playlist_id") String str2, Callback<Pager<PlaylistTrack>> callback);

    @GET("/users/{id}/playlists")
    Pager<PlaylistSimple> getPlaylists(@Path("id") String str);

    @GET("/users/{id}/playlists")
    Pager<PlaylistSimple> getPlaylists(@Path("id") String str, @QueryMap Map<String, Object> map);

    @GET("/users/{id}/playlists")
    void getPlaylists(@Path("id") String str, @QueryMap Map<String, Object> map, Callback<Pager<PlaylistSimple>> callback);

    @GET("/users/{id}/playlists")
    void getPlaylists(@Path("id") String str, Callback<Pager<PlaylistSimple>> callback);

    @GET("/browse/categories/{category_id}/playlists")
    PlaylistsPager getPlaylistsForCategory(@Path("category_id") String str, @QueryMap Map<String, Object> map);

    @GET("/browse/categories/{category_id}/playlists")
    void getPlaylistsForCategory(@Path("category_id") String str, @QueryMap Map<String, Object> map, Callback<PlaylistsPager> callback);

    @GET("/recommendations")
    Recommendations getRecommendations(@QueryMap Map<String, Object> map);

    @GET("/recommendations")
    void getRecommendations(@QueryMap Map<String, Object> map, Callback<Recommendations> callback);

    @GET("/artists/{id}/related-artists")
    Artists getRelatedArtists(@Path("id") String str);

    @GET("/artists/{id}/related-artists")
    void getRelatedArtists(@Path("id") String str, Callback<Artists> callback);

    @GET("/recommendations/available-genre-seeds")
    SeedsGenres getSeedsGenres();

    @GET("/recommendations/available-genre-seeds")
    void getSeedsGenres(Callback<SeedsGenres> callback);

    @GET("/me/top/artists")
    Pager<Artist> getTopArtists();

    @GET("/me/top/artists")
    Pager<Artist> getTopArtists(@QueryMap Map<String, Object> map);

    @GET("/me/top/artists")
    void getTopArtists(@QueryMap Map<String, Object> map, Callback<Pager<Artist>> callback);

    @GET("/me/top/artists")
    void getTopArtists(Callback<Pager<Artist>> callback);

    @GET("/me/top/tracks")
    Pager<Track> getTopTracks();

    @GET("/me/top/tracks")
    Pager<Track> getTopTracks(@QueryMap Map<String, Object> map);

    @GET("/me/top/tracks")
    void getTopTracks(@QueryMap Map<String, Object> map, Callback<Pager<Track>> callback);

    @GET("/me/top/tracks")
    void getTopTracks(Callback<Pager<Track>> callback);

    @GET("/tracks/{id}")
    Track getTrack(@Path("id") String str);

    @GET("/tracks/{id}")
    Track getTrack(@Path("id") String str, @QueryMap Map<String, Object> map);

    @GET("/tracks/{id}")
    void getTrack(@Path("id") String str, @QueryMap Map<String, Object> map, Callback<Track> callback);

    @GET("/tracks/{id}")
    void getTrack(@Path("id") String str, Callback<Track> callback);

    @GET("/audio-features/{id}")
    AudioFeaturesTrack getTrackAudioFeatures(@Path("id") String str);

    @GET("/audio-features/{id}")
    void getTrackAudioFeatures(@Path("id") String str, Callback<AudioFeaturesTrack> callback);

    @GET("/tracks")
    Tracks getTracks(@Query("ids") String str);

    @GET("/tracks")
    Tracks getTracks(@Query("ids") String str, @QueryMap Map<String, Object> map);

    @GET("/tracks")
    void getTracks(@Query("ids") String str, @QueryMap Map<String, Object> map, Callback<Tracks> callback);

    @GET("/tracks")
    void getTracks(@Query("ids") String str, Callback<Tracks> callback);

    @GET("/audio-features")
    AudioFeaturesTracks getTracksAudioFeatures(@Query("ids") String str);

    @GET("/audio-features")
    void getTracksAudioFeatures(@Query("ids") String str, Callback<AudioFeaturesTracks> callback);

    @GET("/users/{id}")
    UserPublic getUser(@Path("id") String str);

    @GET("/users/{id}")
    void getUser(@Path("id") String str, Callback<UserPublic> callback);

    @GET("/me/following/contains?type=artist")
    void isFollowingArtists(@Query("ids") String str, Callback<boolean[]> callback);

    @GET("/me/following/contains?type=artist")
    Boolean[] isFollowingArtists(@Query("ids") String str);

    @GET("/me/following/contains?type=user")
    void isFollowingUsers(@Query("ids") String str, Callback<boolean[]> callback);

    @GET("/me/following/contains?type=user")
    Boolean[] isFollowingUsers(@Query("ids") String str);

    @DELETE("/me/albums")
    Result removeFromMySavedAlbums(@Query("ids") String str);

    @DELETE("/me/albums")
    void removeFromMySavedAlbums(@Query("ids") String str, Callback<Object> callback);

    @DELETE("/me/tracks")
    Result removeFromMySavedTracks(@Query("ids") String str);

    @DELETE("/me/tracks")
    void removeFromMySavedTracks(@Query("ids") String str, Callback<Object> callback);

    @DELETEWITHBODY("/users/{user_id}/playlists/{playlist_id}/tracks")
    SnapshotId removeTracksFromPlaylist(@Path("user_id") String str, @Path("playlist_id") String str2, @Body TracksToRemove tracksToRemove);

    @DELETEWITHBODY("/users/{user_id}/playlists/{playlist_id}/tracks")
    SnapshotId removeTracksFromPlaylist(@Path("user_id") String str, @Path("playlist_id") String str2, @Body TracksToRemoveWithPosition tracksToRemoveWithPosition);

    @DELETEWITHBODY("/users/{user_id}/playlists/{playlist_id}/tracks")
    void removeTracksFromPlaylist(@Path("user_id") String str, @Path("playlist_id") String str2, @Body TracksToRemove tracksToRemove, Callback<SnapshotId> callback);

    @DELETEWITHBODY("/users/{user_id}/playlists/{playlist_id}/tracks")
    void removeTracksFromPlaylist(@Path("user_id") String str, @Path("playlist_id") String str2, @Body TracksToRemoveWithPosition tracksToRemoveWithPosition, Callback<SnapshotId> callback);

    @PUT("/users/{user_id}/playlists/{playlist_id}/tracks")
    SnapshotId reorderPlaylistTracks(@Path("user_id") String str, @Path("playlist_id") String str2, @Body Map<String, Object> map);

    @PUT("/users/{user_id}/playlists/{playlist_id}/tracks")
    void reorderPlaylistTracks(@Path("user_id") String str, @Path("playlist_id") String str2, @Body Map<String, Object> map, Callback<SnapshotId> callback);

    @PUT("/users/{user_id}/playlists/{playlist_id}/tracks")
    Result replaceTracksInPlaylist(@Path("user_id") String str, @Path("playlist_id") String str2, @Query("uris") String str3, @Body Object obj);

    @PUT("/users/{user_id}/playlists/{playlist_id}/tracks")
    void replaceTracksInPlaylist(@Path("user_id") String str, @Path("playlist_id") String str2, @Query("uris") String str3, @Body Object obj, Callback<Result> callback);

    @GET("/search?type=album")
    AlbumsPager searchAlbums(@Query("q") String str);

    @GET("/search?type=album")
    AlbumsPager searchAlbums(@Query("q") String str, @QueryMap Map<String, Object> map);

    @GET("/search?type=album")
    void searchAlbums(@Query("q") String str, @QueryMap Map<String, Object> map, Callback<AlbumsPager> callback);

    @GET("/search?type=album")
    void searchAlbums(@Query("q") String str, Callback<AlbumsPager> callback);

    @GET("/search?type=artist")
    ArtistsPager searchArtists(@Query("q") String str);

    @GET("/search?type=artist")
    ArtistsPager searchArtists(@Query("q") String str, @QueryMap Map<String, Object> map);

    @GET("/search?type=artist")
    void searchArtists(@Query("q") String str, @QueryMap Map<String, Object> map, Callback<ArtistsPager> callback);

    @GET("/search?type=artist")
    void searchArtists(@Query("q") String str, Callback<ArtistsPager> callback);

    @GET("/search?type=playlist")
    PlaylistsPager searchPlaylists(@Query("q") String str);

    @GET("/search?type=playlist")
    PlaylistsPager searchPlaylists(@Query("q") String str, @QueryMap Map<String, Object> map);

    @GET("/search?type=playlist")
    void searchPlaylists(@Query("q") String str, @QueryMap Map<String, Object> map, Callback<PlaylistsPager> callback);

    @GET("/search?type=playlist")
    void searchPlaylists(@Query("q") String str, Callback<PlaylistsPager> callback);

    @GET("/search?type=track")
    TracksPager searchTracks(@Query("q") String str);

    @GET("/search?type=track")
    TracksPager searchTracks(@Query("q") String str, @QueryMap Map<String, Object> map);

    @GET("/search?type=track")
    void searchTracks(@Query("q") String str, @QueryMap Map<String, Object> map, Callback<TracksPager> callback);

    @GET("/search?type=track")
    void searchTracks(@Query("q") String str, Callback<TracksPager> callback);

    @DELETE("/me/following?type=artist")
    Result unfollowArtists(@Query("ids") String str);

    @DELETE("/me/following?type=artist")
    void unfollowArtists(@Query("ids") String str, Callback<Object> callback);

    @DELETE("/users/{user_id}/playlists/{playlist_id}/followers")
    Result unfollowPlaylist(@Path("user_id") String str, @Path("playlist_id") String str2);

    @DELETE("/users/{user_id}/playlists/{playlist_id}/followers")
    void unfollowPlaylist(@Path("user_id") String str, @Path("playlist_id") String str2, Callback<Result> callback);

    @DELETE("/me/following?type=user")
    Result unfollowUsers(@Query("ids") String str);

    @DELETE("/me/following?type=user")
    void unfollowUsers(@Query("ids") String str, Callback<Object> callback);
}
