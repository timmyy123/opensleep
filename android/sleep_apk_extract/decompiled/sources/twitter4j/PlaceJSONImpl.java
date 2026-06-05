package twitter4j;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import retrofit.Types$$ExternalSyntheticBUOutline0;
import twitter4j.conf.Configuration;

/* JADX INFO: loaded from: classes5.dex */
final class PlaceJSONImpl extends TwitterResponseImpl implements Place, Serializable {
    private static final long serialVersionUID = -6368276880878829754L;
    private GeoLocation[][] boundingBoxCoordinates;
    private String boundingBoxType;
    private Place[] containedWithIn;
    private String country;
    private String countryCode;
    private String fullName;
    private GeoLocation[][] geometryCoordinates;
    private String geometryType;
    private String id;
    private String name;
    private String placeType;
    private String streetAddress;
    private String url;

    public PlaceJSONImpl(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        super(httpResponse);
        JSONObject jSONObjectAsJSONObject = httpResponse.asJSONObject();
        init(jSONObjectAsJSONObject);
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
            TwitterObjectFactory.registerJSONObject(this, jSONObjectAsJSONObject);
        }
    }

    public static ResponseList<Place> createPlaceList(JSONArray jSONArray, HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
        }
        try {
            int length = jSONArray.length();
            ResponseListImpl responseListImpl = new ResponseListImpl(length, httpResponse);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                PlaceJSONImpl placeJSONImpl = new PlaceJSONImpl(jSONObject);
                responseListImpl.add(placeJSONImpl);
                if (configuration.isJSONStoreEnabled()) {
                    TwitterObjectFactory.registerJSONObject(placeJSONImpl, jSONObject);
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

    private void init(JSONObject jSONObject) throws TwitterException {
        try {
            this.name = ParseUtil.getUnescapedString("name", jSONObject);
            this.streetAddress = ParseUtil.getUnescapedString("street_address", jSONObject);
            this.countryCode = ParseUtil.getRawString("country_code", jSONObject);
            this.id = ParseUtil.getRawString("id", jSONObject);
            this.country = ParseUtil.getRawString("country", jSONObject);
            if (jSONObject.isNull("place_type")) {
                this.placeType = ParseUtil.getRawString("type", jSONObject);
            } else {
                this.placeType = ParseUtil.getRawString("place_type", jSONObject);
            }
            this.url = ParseUtil.getRawString("url", jSONObject);
            this.fullName = ParseUtil.getRawString("full_name", jSONObject);
            if (jSONObject.isNull("bounding_box")) {
                this.boundingBoxType = null;
                this.boundingBoxCoordinates = null;
            } else {
                JSONObject jSONObject2 = jSONObject.getJSONObject("bounding_box");
                this.boundingBoxType = ParseUtil.getRawString("type", jSONObject2);
                this.boundingBoxCoordinates = JSONImplFactory.coordinatesAsGeoLocationArray(jSONObject2.getJSONArray("coordinates"));
            }
            if (jSONObject.isNull("geometry")) {
                this.geometryType = null;
                this.geometryCoordinates = null;
            } else {
                JSONObject jSONObject3 = jSONObject.getJSONObject("geometry");
                this.geometryType = ParseUtil.getRawString("type", jSONObject3);
                JSONArray jSONArray = jSONObject3.getJSONArray("coordinates");
                if (this.geometryType.equals("Point")) {
                    GeoLocation[][] geoLocationArr = (GeoLocation[][]) Array.newInstance((Class<?>) GeoLocation.class, 1, 1);
                    this.geometryCoordinates = geoLocationArr;
                    geoLocationArr[0][0] = new GeoLocation(jSONArray.getDouble(1), jSONArray.getDouble(0));
                } else if (this.geometryType.equals("Polygon")) {
                    this.geometryCoordinates = JSONImplFactory.coordinatesAsGeoLocationArray(jSONArray);
                } else {
                    this.geometryType = null;
                    this.geometryCoordinates = null;
                }
            }
            if (jSONObject.isNull("contained_within")) {
                this.containedWithIn = null;
                return;
            }
            JSONArray jSONArray2 = jSONObject.getJSONArray("contained_within");
            this.containedWithIn = new Place[jSONArray2.length()];
            for (int i = 0; i < jSONArray2.length(); i++) {
                this.containedWithIn[i] = new PlaceJSONImpl(jSONArray2.getJSONObject(i));
            }
        } catch (JSONException e) {
            throw new TwitterException(e.getMessage() + ":" + jSONObject.toString(), e);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(Place place) {
        return this.id.compareTo(place.getId());
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return (obj instanceof Place) && ((Place) obj).getId().equals(this.id);
    }

    @Override // twitter4j.Place
    public String getId() {
        return this.id;
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PlaceJSONImpl{name='");
        sb.append(this.name);
        sb.append("', streetAddress='");
        sb.append(this.streetAddress);
        sb.append("', countryCode='");
        sb.append(this.countryCode);
        sb.append("', id='");
        sb.append(this.id);
        sb.append("', country='");
        sb.append(this.country);
        sb.append("', placeType='");
        sb.append(this.placeType);
        sb.append("', url='");
        sb.append(this.url);
        sb.append("', fullName='");
        sb.append(this.fullName);
        sb.append("', boundingBoxType='");
        sb.append(this.boundingBoxType);
        sb.append("', boundingBoxCoordinates=");
        GeoLocation[][] geoLocationArr = this.boundingBoxCoordinates;
        sb.append(geoLocationArr == null ? null : Arrays.asList(geoLocationArr));
        sb.append(", geometryType='");
        sb.append(this.geometryType);
        sb.append("', geometryCoordinates=");
        GeoLocation[][] geoLocationArr2 = this.geometryCoordinates;
        sb.append(geoLocationArr2 == null ? null : Arrays.asList(geoLocationArr2));
        sb.append(", containedWithIn=");
        Place[] placeArr = this.containedWithIn;
        return Fragment$$ExternalSyntheticOutline1.m(sb, placeArr != null ? Arrays.asList(placeArr) : null, '}');
    }

    public PlaceJSONImpl(JSONObject jSONObject) throws TwitterException {
        init(jSONObject);
    }

    public static ResponseList<Place> createPlaceList(HttpResponse httpResponse, Configuration configuration) throws TwitterException {
        JSONObject jSONObjectAsJSONObject;
        try {
            jSONObjectAsJSONObject = httpResponse.asJSONObject();
            try {
                return createPlaceList(jSONObjectAsJSONObject.getJSONObject("result").getJSONArray("places"), httpResponse, configuration);
            } catch (JSONException e) {
                e = e;
                throw new TwitterException(e.getMessage() + ":" + jSONObjectAsJSONObject.toString(), e);
            }
        } catch (JSONException e2) {
            e = e2;
            jSONObjectAsJSONObject = null;
        }
    }
}
