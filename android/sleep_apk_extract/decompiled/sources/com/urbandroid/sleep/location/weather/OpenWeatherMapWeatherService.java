package com.urbandroid.sleep.location.weather;

import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.InputStreamUtil;
import com.urbandroid.sleep.location.Location;
import com.urbandroid.sleep.location.weather.Weather;
import java.net.URL;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class OpenWeatherMapWeatherService {
    private Weather.Condition retrieveCondition(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return null;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            String string = jSONArray.getJSONObject(i).getString("main");
            for (Weather.Condition condition : Weather.Condition.values()) {
                if (string.toLowerCase().contains(condition.toString().toLowerCase())) {
                    return condition;
                }
            }
        }
        return null;
    }

    private String retrieveDesc(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jSONArray.length(); i++) {
            sb.append(jSONArray.getJSONObject(i).getString("description"));
            sb.append(" ");
        }
        return sb.toString();
    }

    public Weather getWeather(Location location) {
        try {
            JSONObject jSONObject = new JSONObject(InputStreamUtil.read(new URL("https://api.openweathermap.org/data/2.5/weather?lat=" + location.getLat() + "&lon=" + location.getLon() + "&lang=" + Locale.getDefault().getLanguage() + "&APPID=f9ad345af265f14ece66dd64a7599db4").openStream()));
            JSONObject jSONObject2 = jSONObject.getJSONObject("main");
            double d = jSONObject2.getDouble("temp");
            int i = jSONObject2.getInt("humidity");
            JSONArray jSONArray = jSONObject.getJSONArray("weather");
            Weather.Condition conditionRetrieveCondition = retrieveCondition(jSONArray);
            Weather weather = new Weather(conditionRetrieveCondition, (float) d);
            if (jSONObject2.has("clouds")) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject("clouds");
                if (jSONObject2.has("all")) {
                    weather.setCloudCoverage(jSONObject3.getInt("all"));
                }
                if (conditionRetrieveCondition == null) {
                    if (weather.getCloudCoverage() < 10) {
                        weather.setCondition(Weather.Condition.CLEAR);
                    } else {
                        weather.setCondition(Weather.Condition.CLOUD);
                    }
                }
            }
            weather.setDesc(retrieveDesc(jSONArray));
            weather.setHumidity(i);
            if (jSONObject2.has("wind")) {
                weather.setWindSpeed((float) jSONObject2.getJSONObject("wind").getDouble("speed"));
            }
            Logger.logDebug("Weather received " + weather.getTemperature() + " " + weather.getCondition() + " " + weather.getCloudCoverage());
            weather.setSource("OpenWeatherMap");
            return weather;
        } catch (Exception e) {
            Logger.logSevere(e);
            Logger.logInfo("Error retrieving weather " + e);
            return null;
        }
    }
}
