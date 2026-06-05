package twitter4j;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.io.Serializable;
import retrofit.Types$$ExternalSyntheticBUOutline0;
import twitter4j.conf.Configuration;

/* JADX INFO: loaded from: classes5.dex */
final class CategoryJSONImpl implements Serializable {
    private static final long serialVersionUID = 3811335888122469876L;
    private String name;
    private int size;
    private String slug;

    public CategoryJSONImpl(JSONObject jSONObject) {
        init(jSONObject);
    }

    public static ResponseList<Object> createCategoriesList(JSONArray jSONArray, HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        try {
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.clearThreadLocalMap();
            }
            ResponseListImpl responseListImpl = new ResponseListImpl(jSONArray.length(), httpResponse);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                CategoryJSONImpl categoryJSONImpl = new CategoryJSONImpl(jSONObject);
                responseListImpl.add(categoryJSONImpl);
                if (configuration.isJSONStoreEnabled()) {
                    TwitterObjectFactory.registerJSONObject(categoryJSONImpl, jSONObject);
                }
            }
            if (configuration.isJSONStoreEnabled()) {
                TwitterObjectFactory.registerJSONObject(responseListImpl, jSONArray);
            }
            return responseListImpl;
        } catch (JSONException e) {
            Types$$ExternalSyntheticBUOutline0.m(e);
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CategoryJSONImpl.class != obj.getClass()) {
            return false;
        }
        CategoryJSONImpl categoryJSONImpl = (CategoryJSONImpl) obj;
        if (this.size != categoryJSONImpl.size) {
            return false;
        }
        String str = this.name;
        String str2 = categoryJSONImpl.name;
        if (str == null ? str2 != null : !str.equals(str2)) {
            return false;
        }
        String str3 = this.slug;
        String str4 = categoryJSONImpl.slug;
        return str3 == null ? str4 == null : str3.equals(str4);
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.slug;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.size;
    }

    public void init(JSONObject jSONObject) {
        this.name = jSONObject.getString("name");
        this.slug = jSONObject.getString("slug");
        this.size = ParseUtil.getInt("size", jSONObject);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CategoryJSONImpl{name='");
        sb.append(this.name);
        sb.append("', slug='");
        sb.append(this.slug);
        sb.append("', size=");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.size, '}');
    }

    public static ResponseList<Object> createCategoriesList(HttpResponse httpResponse, Configuration configuration) {
        return createCategoriesList(httpResponse.asJSONArray(), httpResponse, configuration);
    }
}
