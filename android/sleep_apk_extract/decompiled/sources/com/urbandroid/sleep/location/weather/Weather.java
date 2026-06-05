package com.urbandroid.sleep.location.weather;

import android.content.Context;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.service.Settings;
import java.io.Serializable;
import java.util.Locale;
import java.util.MissingResourceException;

/* JADX INFO: loaded from: classes.dex */
public class Weather implements Serializable {
    public int cloudCoverage;
    public Condition condition;
    public String desc;
    public int humidity;
    public String source;
    public float temperature;
    public float windSpeed;

    public enum Condition {
        CLEAR(R.drawable.ic_weather_sun, "sun"),
        CLOUD(R.drawable.ic_weather_cloudy, "cloudy"),
        RAIN(R.drawable.ic_weather_rain, "rain"),
        STORM(R.drawable.ic_weather_storm, "storm"),
        SNOW(R.drawable.ic_weather_snow, "snow"),
        OVERCAST(R.drawable.ic_weather_clouds, "cloudy"),
        FOG(R.drawable.ic_weather_fog, "fog"),
        MIST(R.drawable.ic_weather_rain, "rain"),
        DRIZZLE(R.drawable.ic_weather_drizzle, "rain"),
        SMOKE(R.drawable.ic_weather_clouds, "smoke");

        private int resource;
        private String tag;

        Condition(int i, String str) {
            this.resource = i;
            this.tag = str;
        }

        public int getResource() {
            return this.resource;
        }

        public String getTag() {
            return this.tag;
        }
    }

    public enum Deg {
        C,
        F,
        K
    }

    public Weather(Condition condition, float f) {
        this.condition = condition;
        this.temperature = f;
    }

    public static int getTemperatureDegrees(Context context, Weather weather) {
        int iOrdinal = getTemperatureDegreesUnit(context).ordinal();
        return iOrdinal != 0 ? iOrdinal != 1 ? iOrdinal != 2 ? (int) Math.round(((double) weather.getTemperature()) - 273.15d) : Math.round(weather.getTemperature()) : (int) Math.round((((((double) weather.getTemperature()) - 273.15d) * 9.0d) / 5.0d) + 32.0d) : (int) Math.round(((double) weather.getTemperature()) - 273.15d);
    }

    public static Deg getTemperatureDegreesUnit(Context context) {
        Deg deg = Deg.C;
        Settings settings = new Settings(context);
        if (settings.getTemperature() == -1) {
            try {
                if (Locale.getDefault().getISO3Country().equals("USA")) {
                    return Deg.F;
                }
            } catch (MissingResourceException unused) {
            }
        } else if (settings.getTemperature() != 0) {
            return Deg.F;
        }
        return deg;
    }

    public static String getTemperatureString(Context context, Weather weather) {
        return Math.round(getTemperatureDegrees(context, weather)) + "°" + getTemperatureDegreesUnit(context);
    }

    public int getCloudCoverage() {
        return this.cloudCoverage;
    }

    public Condition getCondition() {
        return this.condition;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getSource() {
        return this.source;
    }

    public float getTemperature() {
        return this.temperature;
    }

    public int getTemperatureCelesius() {
        return (int) Math.round(((double) this.temperature) - 273.15d);
    }

    public float getWindSpeed() {
        return this.windSpeed;
    }

    public void setCloudCoverage(int i) {
        this.cloudCoverage = i;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setHumidity(int i) {
        this.humidity = i;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setWindSpeed(float f) {
        this.windSpeed = f;
    }

    public String toString() {
        return this.condition + ":" + this.temperature + ":" + this.cloudCoverage + ":" + this.humidity + ":" + this.windSpeed + ":" + this.desc + ":" + this.source;
    }
}
