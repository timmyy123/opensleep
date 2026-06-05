package twitter4j;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.util.Date;
import twitter4j.conf.Configuration;

/* JADX INFO: loaded from: classes5.dex */
final class SavedSearchJSONImpl extends TwitterResponseImpl implements SavedSearch {
    private static final long serialVersionUID = -2281949861485441692L;
    private Date createdAt;
    private long id;
    private String name;
    private int position;
    private String query;

    public SavedSearchJSONImpl(HttpResponse httpResponse, Configuration configuration) {
        super(httpResponse);
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
        }
        JSONObject jSONObjectAsJSONObject = httpResponse.asJSONObject();
        init(jSONObjectAsJSONObject);
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.registerJSONObject(this, jSONObjectAsJSONObject);
        }
    }

    public static ResponseList<SavedSearch> createSavedSearchList(HttpResponse httpResponse, Configuration configuration) throws Throwable {
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
        }
        JSONArray jSONArrayAsJSONArray = httpResponse.asJSONArray();
        try {
            ResponseListImpl responseListImpl = new ResponseListImpl(jSONArrayAsJSONArray.length(), httpResponse);
            for (int i = 0; i < jSONArrayAsJSONArray.length(); i++) {
                JSONObject jSONObject = jSONArrayAsJSONArray.getJSONObject(i);
                SavedSearchJSONImpl savedSearchJSONImpl = new SavedSearchJSONImpl(jSONObject);
                responseListImpl.add(savedSearchJSONImpl);
                if (configuration.isJSONStoreEnabled()) {
                    TwitterObjectFactory.registerJSONObject(savedSearchJSONImpl, jSONObject);
                }
            }
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.registerJSONObject(responseListImpl, jSONArrayAsJSONArray);
            }
            return responseListImpl;
        } catch (JSONException e) {
            throw new TwitterException(e.getMessage() + ":" + httpResponse.asString(), e);
        }
    }

    private void init(JSONObject jSONObject) {
        this.createdAt = ParseUtil.getDate("created_at", jSONObject, "EEE MMM dd HH:mm:ss z yyyy");
        this.query = ParseUtil.getUnescapedString("query", jSONObject);
        this.position = ParseUtil.getInt("position", jSONObject);
        this.name = ParseUtil.getUnescapedString("name", jSONObject);
        this.id = ParseUtil.getLong("id", jSONObject);
    }

    @Override // java.lang.Comparable
    public int compareTo(SavedSearch savedSearch) {
        return (int) (this.id - savedSearch.getId());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SavedSearch) && this.id == ((SavedSearch) obj).getId();
    }

    @Override // twitter4j.SavedSearch
    public long getId() {
        return this.id;
    }

    public int hashCode() {
        return FileInsert$$ExternalSyntheticOutline0.m((FileInsert$$ExternalSyntheticOutline0.m(this.createdAt.hashCode() * 31, 31, this.query) + this.position) * 31, 31, this.name) + ((int) this.id);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SavedSearchJSONImpl{createdAt=");
        sb.append(this.createdAt);
        sb.append(", query='");
        sb.append(this.query);
        sb.append("', position=");
        sb.append(this.position);
        sb.append(", name='");
        sb.append(this.name);
        sb.append("', id=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.id, '}');
    }

    public SavedSearchJSONImpl(JSONObject jSONObject) {
        init(jSONObject);
    }
}
