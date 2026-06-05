package com.urbandroid.sleep.location.weather;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.location.Location;
import com.urbandroid.sleep.location.weather.Weather;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes.dex */
public class NorwegianWeatherService {

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'SUN' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class Symbol {
        private static final /* synthetic */ Symbol[] $VALUES;
        public static final Symbol CLOUD;
        public static final Symbol DARK_DRIZZLESUN;
        public static final Symbol DARK_DRIZZLETHUNDERSUN;
        public static final Symbol DARK_HEAVYSLEETSUN;
        public static final Symbol DARK_HEAVYSLEETTHUNDERSUN;
        public static final Symbol DARK_HEAVYSNOWSUN;
        public static final Symbol DARK_HEAVYSNOWTHUNDERSUN;
        public static final Symbol DARK_LIGHTCLOUD;
        public static final Symbol DARK_LIGHTRAINSUN;
        public static final Symbol DARK_LIGHTRAINTHUNDERSUN;
        public static final Symbol DARK_LIGHTSLEETSUN;
        public static final Symbol DARK_LIGHTSLEETTHUNDERSUN;
        public static final Symbol DARK_LIGHTSNOWSUN;
        public static final Symbol DARK_LIGHTSNOWTHUNDERSUN;
        public static final Symbol DARK_PARTLYCLOUD;
        public static final Symbol DARK_RAINSUN;
        public static final Symbol DARK_RAINTHUNDERSUN;
        public static final Symbol DARK_SLEETSUN;
        public static final Symbol DARK_SLEETSUNTHUNDER;
        public static final Symbol DARK_SNOWSUN;
        public static final Symbol DARK_SNOWSUNTHUNDER;
        public static final Symbol DARK_SUN;
        public static final Symbol DRIZZLE;
        public static final Symbol DRIZZLESUN;
        public static final Symbol DRIZZLETHUNDER;
        public static final Symbol DRIZZLETHUNDERSUN;
        public static final Symbol FOG;
        public static final Symbol HEAVYSLEET;
        public static final Symbol HEAVYSLEETSUN;
        public static final Symbol HEAVYSLEETTHUNDER;
        public static final Symbol HEAVYSLEETTHUNDERSUN;
        public static final Symbol HEAVYSNOW;
        public static final Symbol HEAVYSNOWSUN;
        public static final Symbol HEAVYSNOWTHUNDER;
        public static final Symbol HEAVYSNOWTHUNDERSUN;
        public static final Symbol LIGHTCLOUD;
        public static final Symbol LIGHTRAIN;
        public static final Symbol LIGHTRAINSUN;
        public static final Symbol LIGHTRAINTHUNDER;
        public static final Symbol LIGHTRAINTHUNDERSUN;
        public static final Symbol LIGHTSLEET;
        public static final Symbol LIGHTSLEETSUN;
        public static final Symbol LIGHTSLEETTHUNDER;
        public static final Symbol LIGHTSLEETTHUNDERSUN;
        public static final Symbol LIGHTSNOW;
        public static final Symbol LIGHTSNOWSUN;
        public static final Symbol LIGHTSNOWTHUNDER;
        public static final Symbol LIGHTSNOWTHUNDERSUN;
        public static final Symbol PARTLYCLOUD;
        public static final Symbol RAIN;
        public static final Symbol RAINSUN;
        public static final Symbol RAINTHUNDER;
        public static final Symbol RAINTHUNDERSUN;
        public static final Symbol SLEET;
        public static final Symbol SLEETSUN;
        public static final Symbol SLEETSUNTHUNDER;
        public static final Symbol SLEETTHUNDER;
        public static final Symbol SNOW;
        public static final Symbol SNOWSUN;
        public static final Symbol SNOWSUNTHUNDER;
        public static final Symbol SNOWTHUNDER;
        public static final Symbol SUN;
        private Weather.Condition condition;
        private String tag;

        private static /* synthetic */ Symbol[] $values() {
            return new Symbol[]{SUN, LIGHTCLOUD, PARTLYCLOUD, CLOUD, LIGHTRAINSUN, LIGHTRAINTHUNDERSUN, SLEETSUN, SNOWSUN, LIGHTRAIN, RAIN, RAINTHUNDER, SLEET, SNOW, SNOWTHUNDER, FOG, SLEETSUNTHUNDER, SNOWSUNTHUNDER, LIGHTRAINTHUNDER, SLEETTHUNDER, DRIZZLETHUNDERSUN, RAINTHUNDERSUN, LIGHTSLEETTHUNDERSUN, HEAVYSLEETTHUNDERSUN, LIGHTSNOWTHUNDERSUN, HEAVYSNOWTHUNDERSUN, DRIZZLETHUNDER, LIGHTSLEETTHUNDER, HEAVYSLEETTHUNDER, LIGHTSNOWTHUNDER, HEAVYSNOWTHUNDER, DRIZZLESUN, RAINSUN, LIGHTSLEETSUN, HEAVYSLEETSUN, LIGHTSNOWSUN, HEAVYSNOWSUN, DRIZZLE, LIGHTSLEET, HEAVYSLEET, LIGHTSNOW, HEAVYSNOW, DARK_SUN, DARK_LIGHTCLOUD, DARK_PARTLYCLOUD, DARK_LIGHTRAINSUN, DARK_LIGHTRAINTHUNDERSUN, DARK_SLEETSUN, DARK_SNOWSUN, DARK_SLEETSUNTHUNDER, DARK_SNOWSUNTHUNDER, DARK_DRIZZLETHUNDERSUN, DARK_RAINTHUNDERSUN, DARK_LIGHTSLEETTHUNDERSUN, DARK_HEAVYSLEETTHUNDERSUN, DARK_LIGHTSNOWTHUNDERSUN, DARK_HEAVYSNOWTHUNDERSUN, DARK_DRIZZLESUN, DARK_RAINSUN, DARK_LIGHTSLEETSUN, DARK_HEAVYSLEETSUN, DARK_LIGHTSNOWSUN, DARK_HEAVYSNOWSUN};
        }

        static {
            Weather.Condition condition = Weather.Condition.CLEAR;
            SUN = new Symbol("SUN", 0, "Sun", condition);
            Weather.Condition condition2 = Weather.Condition.CLOUD;
            LIGHTCLOUD = new Symbol("LIGHTCLOUD", 1, "LightCloud", condition2);
            PARTLYCLOUD = new Symbol("PARTLYCLOUD", 2, "PartlyCloud", condition2);
            CLOUD = new Symbol("CLOUD", 3, "Cloud", Weather.Condition.OVERCAST);
            Weather.Condition condition3 = Weather.Condition.RAIN;
            LIGHTRAINSUN = new Symbol("LIGHTRAINSUN", 4, "LightRainSun", condition3);
            Weather.Condition condition4 = Weather.Condition.STORM;
            LIGHTRAINTHUNDERSUN = new Symbol("LIGHTRAINTHUNDERSUN", 5, "LightRainThunderSun", condition4);
            SLEETSUN = new Symbol("SLEETSUN", 6, "SleetSun", condition3);
            Weather.Condition condition5 = Weather.Condition.SNOW;
            SNOWSUN = new Symbol("SNOWSUN", 7, "SnowSun", condition5);
            LIGHTRAIN = new Symbol("LIGHTRAIN", 8, "LightRain", condition3);
            RAIN = new Symbol("RAIN", 9, "Rain", condition3);
            RAINTHUNDER = new Symbol("RAINTHUNDER", 10, "RainThunder", condition4);
            SLEET = new Symbol("SLEET", 11, "Sleet", condition3);
            SNOW = new Symbol("SNOW", 12, "Snow", condition5);
            SNOWTHUNDER = new Symbol("SNOWTHUNDER", 13, "SnowThunder", condition5);
            FOG = new Symbol("FOG", 14, "Fog", Weather.Condition.FOG);
            SLEETSUNTHUNDER = new Symbol("SLEETSUNTHUNDER", 15, "SleetSunThunder", condition4);
            SNOWSUNTHUNDER = new Symbol("SNOWSUNTHUNDER", 16, "SnowSunThunder", condition5);
            LIGHTRAINTHUNDER = new Symbol("LIGHTRAINTHUNDER", 17, "LightRainThunder", condition3);
            SLEETTHUNDER = new Symbol("SLEETTHUNDER", 18, "SleetThunder", condition3);
            DRIZZLETHUNDERSUN = new Symbol("DRIZZLETHUNDERSUN", 19, "DrizzleThunderSun", condition3);
            RAINTHUNDERSUN = new Symbol("RAINTHUNDERSUN", 20, "RainThunderSun", condition3);
            LIGHTSLEETTHUNDERSUN = new Symbol("LIGHTSLEETTHUNDERSUN", 21, "LightSleetThunderSun", condition3);
            HEAVYSLEETTHUNDERSUN = new Symbol("HEAVYSLEETTHUNDERSUN", 22, "HeavySleetThunderSun", condition4);
            LIGHTSNOWTHUNDERSUN = new Symbol("LIGHTSNOWTHUNDERSUN", 23, "LightSnowThunderSun", condition5);
            HEAVYSNOWTHUNDERSUN = new Symbol("HEAVYSNOWTHUNDERSUN", 24, "HeavySnowThunderSun", condition5);
            DRIZZLETHUNDER = new Symbol("DRIZZLETHUNDER", 25, "DrizzleThunder", condition3);
            LIGHTSLEETTHUNDER = new Symbol("LIGHTSLEETTHUNDER", 26, "LightSleetThunder", condition3);
            HEAVYSLEETTHUNDER = new Symbol("HEAVYSLEETTHUNDER", 27, "HeavySleetThunder", condition4);
            LIGHTSNOWTHUNDER = new Symbol("LIGHTSNOWTHUNDER", 28, "LightSnowThunder", condition5);
            HEAVYSNOWTHUNDER = new Symbol("HEAVYSNOWTHUNDER", 29, "HeavySnowThunder", condition5);
            Weather.Condition condition6 = Weather.Condition.MIST;
            DRIZZLESUN = new Symbol("DRIZZLESUN", 30, "DrizzleSun", condition6);
            RAINSUN = new Symbol("RAINSUN", 31, "RainSun", condition3);
            LIGHTSLEETSUN = new Symbol("LIGHTSLEETSUN", 32, "LightSleetSun", condition3);
            HEAVYSLEETSUN = new Symbol("HEAVYSLEETSUN", 33, "HeavySleetSun", condition3);
            LIGHTSNOWSUN = new Symbol("LIGHTSNOWSUN", 34, "LightSnowSun", condition5);
            HEAVYSNOWSUN = new Symbol("HEAVYSNOWSUN", 35, "HeavysnowSun", condition5);
            DRIZZLE = new Symbol("DRIZZLE", 36, "Drizzle", condition6);
            LIGHTSLEET = new Symbol("LIGHTSLEET", 37, "LightSleet", condition3);
            HEAVYSLEET = new Symbol("HEAVYSLEET", 38, "HeavySleet", condition3);
            LIGHTSNOW = new Symbol("LIGHTSNOW", 39, "LightSnow", condition5);
            HEAVYSNOW = new Symbol("HEAVYSNOW", 40, "HeavySnow", condition5);
            DARK_SUN = new Symbol("DARK_SUN", 41, "Dark_Sun", condition);
            DARK_LIGHTCLOUD = new Symbol("DARK_LIGHTCLOUD", 42, "Dark_LightCloud", condition2);
            DARK_PARTLYCLOUD = new Symbol("DARK_PARTLYCLOUD", 43, "Dark_PartlyCloud", condition2);
            DARK_LIGHTRAINSUN = new Symbol("DARK_LIGHTRAINSUN", 44, "Dark_LightRainSun", condition3);
            DARK_LIGHTRAINTHUNDERSUN = new Symbol("DARK_LIGHTRAINTHUNDERSUN", 45, "Dark_LightRainThunderSun", condition3);
            DARK_SLEETSUN = new Symbol("DARK_SLEETSUN", 46, "Dark_SleetSun", condition3);
            DARK_SNOWSUN = new Symbol("DARK_SNOWSUN", 47, "Dark_SnowSun", condition5);
            DARK_SLEETSUNTHUNDER = new Symbol("DARK_SLEETSUNTHUNDER", 48, "Dark_SleetSunThunder", condition4);
            DARK_SNOWSUNTHUNDER = new Symbol("DARK_SNOWSUNTHUNDER", 49, "Dark_SnowSunThunder", condition5);
            DARK_DRIZZLETHUNDERSUN = new Symbol("DARK_DRIZZLETHUNDERSUN", 50, "Dark_DrizzleThunderSun", condition3);
            DARK_RAINTHUNDERSUN = new Symbol("DARK_RAINTHUNDERSUN", 51, "Dark_RainThunderSun", condition3);
            DARK_LIGHTSLEETTHUNDERSUN = new Symbol("DARK_LIGHTSLEETTHUNDERSUN", 52, "Dark_LightSleetThunderSun", condition3);
            DARK_HEAVYSLEETTHUNDERSUN = new Symbol("DARK_HEAVYSLEETTHUNDERSUN", 53, "Dark_HeavySleetThunderSun", condition4);
            DARK_LIGHTSNOWTHUNDERSUN = new Symbol("DARK_LIGHTSNOWTHUNDERSUN", 54, "Dark_LightSnowThunderSun", condition5);
            DARK_HEAVYSNOWTHUNDERSUN = new Symbol("DARK_HEAVYSNOWTHUNDERSUN", 55, "Dark_HeavySnowThunderSun", condition5);
            DARK_DRIZZLESUN = new Symbol("DARK_DRIZZLESUN", 56, "Dark_DrizzleSun", condition6);
            DARK_RAINSUN = new Symbol("DARK_RAINSUN", 57, "Dark_RainSun", condition3);
            DARK_LIGHTSLEETSUN = new Symbol("DARK_LIGHTSLEETSUN", 58, "Dark_LightSleetSun", condition3);
            DARK_HEAVYSLEETSUN = new Symbol("DARK_HEAVYSLEETSUN", 59, "Dark_HeavySleetSun", condition3);
            DARK_LIGHTSNOWSUN = new Symbol("DARK_LIGHTSNOWSUN", 60, "Dark_LightSnowSun", condition5);
            DARK_HEAVYSNOWSUN = new Symbol("DARK_HEAVYSNOWSUN", 61, "Dark_HeavysnowSun", condition5);
            $VALUES = $values();
        }

        private Symbol(String str, int i, String str2, Weather.Condition condition) {
            this.tag = str2;
            this.condition = condition;
        }

        public static Symbol findByTag(String str) {
            for (Symbol symbol : values()) {
                if (symbol.getTag().equals(str)) {
                    return symbol;
                }
            }
            return null;
        }

        public static Symbol valueOf(String str) {
            return (Symbol) Enum.valueOf(Symbol.class, str);
        }

        public static Symbol[] values() {
            return (Symbol[]) $VALUES.clone();
        }

        public Weather.Condition getCondition() {
            return this.condition;
        }

        public String getTag() {
            return this.tag;
        }
    }

    public static String parseNorwegianWeather(String str) {
        String[] strArrSplit = splitCamelCase(str).split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArrSplit.length; i++) {
            String strConcat = strArrSplit[i];
            if (strConcat.startsWith("Dark_")) {
                strConcat = "Polar night: ".concat(strConcat.substring(5));
            }
            if (strConcat.equals("Sun")) {
                strConcat = "Sunny";
            } else if (strConcat.equals("Cloud")) {
                strConcat = "Cloudy";
            }
            sb.append(strConcat);
            sb.append(" ");
        }
        return sb.toString();
    }

    public static String splitCamelCase(String str) {
        return str.replaceAll("(?<=[A-Z])(?=[A-Z][a-z])|(?<=[^A-Z])(?=[A-Z])|(?<=[A-Za-z])(?=[^A-Za-z])", " ");
    }

    public Weather getWeather(Location location) {
        InputStream inputStream;
        int i;
        XmlPullParser xmlPullParserNewPullParser;
        int next;
        try {
            Logger.logDebug("Getting weather for location " + location.toString());
            URL url = new URL("https://api.met.no/weatherapi/locationforecast/2.0/classic?lat=" + location.getLat() + "&lon=" + location.getLon());
            StringBuilder sb = new StringBuilder("NorwegianWeather URL ");
            sb.append(url);
            Logger.logInfo(sb.toString());
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
            xmlPullParserNewPullParser = xmlPullParserFactoryNewInstance.newPullParser();
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("User-Agent", "SleepAsAndroid");
            Logger.logInfo("NorwegianWeather weather response " + httpURLConnection.getResponseCode());
            inputStream = httpURLConnection.getInputStream();
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            xmlPullParserNewPullParser.setInput(inputStream, null);
            int eventType = xmlPullParserNewPullParser.getEventType();
            String attributeValue = "";
            float fFloatValue = 99999.0f;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            int iRound = 99999;
            float fFloatValue2 = 99999.0f;
            boolean z5 = false;
            for (i = 1; eventType != i; i = 1) {
                String name = xmlPullParserNewPullParser.getName();
                if (2 != eventType) {
                    if (z5 && z && z2 && z3 && z4) {
                        break;
                    }
                    next = xmlPullParserNewPullParser.next();
                } else {
                    if ("temperature".equals(name) && !z5) {
                        fFloatValue = Float.valueOf(xmlPullParserNewPullParser.getAttributeValue(null, SDKConstants.PARAM_VALUE)).floatValue() + 273.15f;
                        z5 = true;
                    } else if ("windSpeed".equals(name) && !z) {
                        fFloatValue2 = Float.valueOf(xmlPullParserNewPullParser.getAttributeValue(null, "mps")).floatValue();
                        z = true;
                    } else if ("cloudiness".equals(name) && !z2) {
                        iRound = Math.round(Float.valueOf(xmlPullParserNewPullParser.getAttributeValue(null, "percent")).floatValue());
                        z2 = true;
                    } else if ("precipitation".equals(name) && !z3) {
                        Float.valueOf(xmlPullParserNewPullParser.getAttributeValue(null, SDKConstants.PARAM_VALUE)).getClass();
                        z3 = true;
                    } else if (!"symbol".equals(name) || z4) {
                        next = xmlPullParserNewPullParser.next();
                    } else {
                        attributeValue = xmlPullParserNewPullParser.getAttributeValue(null, "id");
                        z4 = true;
                    }
                }
                eventType = next;
            }
            Weather weather = new Weather(Symbol.findByTag(attributeValue).getCondition(), fFloatValue);
            weather.setWindSpeed(fFloatValue2);
            weather.setCloudCoverage(iRound);
            weather.setDesc(parseNorwegianWeather(attributeValue));
            Logger.logDebug("Weather received " + weather.getTemperature() + " " + weather.getCondition() + " " + weather.getCloudCoverage());
            weather.setSource("MET Norway");
            if (inputStream != null) {
                try {
                    inputStream.close();
                    return weather;
                } catch (IOException e) {
                    Logger.logSevere(e);
                }
            }
            return weather;
        } catch (Throwable th2) {
            th = th2;
            try {
                Logger.logInfo("Error retrieving weather " + th);
                Logger.logSevere(th);
                if (inputStream == null) {
                    return null;
                }
                try {
                    inputStream.close();
                    return null;
                } catch (IOException e2) {
                    Logger.logSevere(e2);
                    return null;
                }
            } finally {
            }
        }
    }
}
