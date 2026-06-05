package twitter4j;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.io.Serializable;
import retrofit.Types$$ExternalSyntheticBUOutline0;
import twitter4j.conf.Configuration;

/* JADX INFO: loaded from: classes5.dex */
class AccountSettingsJSONImpl extends TwitterResponseImpl implements AccountSettings, Serializable {
    private static final long serialVersionUID = 603189815663175766L;
    private final String ALLOW_DMS_FROM;
    private final boolean ALWAYS_USE_HTTPS;
    private final boolean DISCOVERABLE_BY_EMAIL;
    private final boolean GEO_ENABLED;
    private final String LANGUAGE;
    private final String SCREEN_NAME;
    private final String SLEEP_END_TIME;
    private final String SLEEP_START_TIME;
    private final boolean SLEEP_TIME_ENABLED;
    private final TimeZone TIMEZONE;
    private final Location[] TREND_LOCATION;

    private AccountSettingsJSONImpl(HttpResponse httpResponse, JSONObject jSONObject) throws TwitterException {
        super(httpResponse);
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("sleep_time");
            this.SLEEP_TIME_ENABLED = ParseUtil.getBoolean("enabled", jSONObject2);
            this.SLEEP_START_TIME = jSONObject2.getString("start_time");
            this.SLEEP_END_TIME = jSONObject2.getString(SDKConstants.PARAM_TOURNAMENTS_END_TIME);
            if (jSONObject.isNull("trend_location")) {
                this.TREND_LOCATION = new Location[0];
            } else {
                JSONArray jSONArray = jSONObject.getJSONArray("trend_location");
                this.TREND_LOCATION = new Location[jSONArray.length()];
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.TREND_LOCATION[i] = new LocationJSONImpl(jSONArray.getJSONObject(i));
                }
            }
            this.GEO_ENABLED = ParseUtil.getBoolean("geo_enabled", jSONObject);
            this.LANGUAGE = jSONObject.getString("language");
            this.ALWAYS_USE_HTTPS = ParseUtil.getBoolean("always_use_https", jSONObject);
            this.DISCOVERABLE_BY_EMAIL = ParseUtil.getBoolean("discoverable_by_email", jSONObject);
            if (jSONObject.isNull("time_zone")) {
                this.TIMEZONE = null;
            } else {
                this.TIMEZONE = new TimeZoneJSONImpl(jSONObject.getJSONObject("time_zone"));
            }
            this.SCREEN_NAME = jSONObject.getString("screen_name");
            this.ALLOW_DMS_FROM = jSONObject.getString("allow_dms_from");
        } catch (JSONException e) {
            Types$$ExternalSyntheticBUOutline0.m(e);
            throw null;
        }
    }

    public AccountSettingsJSONImpl(HttpResponse httpResponse, Configuration configuration) {
        this(httpResponse, httpResponse.asJSONObject());
        if (configuration.isJSONStoreEnabled()) {
            TwitterObjectFactory.clearThreadLocalMap();
            TwitterObjectFactory.registerJSONObject(this, httpResponse.asJSONObject());
        }
    }
}
