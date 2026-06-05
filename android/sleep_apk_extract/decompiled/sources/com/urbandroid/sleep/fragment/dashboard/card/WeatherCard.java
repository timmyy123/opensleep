package com.urbandroid.sleep.fragment.dashboard.card;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Build;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.content.ContextCompat;
import androidx.work.ListenableFutureKt$$ExternalSyntheticLambda0;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.common.util.math.luckycatlabs.sunrisesunset.SunriseSunsetCalculator;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.ai.AiActivity$$ExternalSyntheticLambda6;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import com.urbandroid.sleep.location.Location;
import com.urbandroid.sleep.location.LocationService;
import com.urbandroid.sleep.location.weather.NorwegianWeatherService;
import com.urbandroid.sleep.location.weather.OpenWeatherMapWeatherService;
import com.urbandroid.sleep.location.weather.Weather;
import com.urbandroid.util.SleepPermissionCompat;
import com.urbandroid.util.TtsService;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002:\u00014B\u0019\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b \u0010!J\u0015\u0010#\u001a\u00020\"2\u0006\u0010\u0005\u001a\u00020\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u0010H\u0016¢\u0006\u0004\b&\u0010\u0015J\u0017\u0010'\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b'\u0010\rJ\u000f\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b)\u0010*R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010+\u001a\u0004\b,\u0010-R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010.R\u001a\u00100\u001a\u00020/8\u0016X\u0096D¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103¨\u00065"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/WeatherCard;", "Lcom/urbandroid/common/FeatureLogger;", "Lcom/urbandroid/sleep/fragment/dashboard/card/DashboardCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/WeatherCard$SleepRecordViewHolder;", "Landroid/app/Activity;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/urbandroid/sleep/domain/SleepRecord;", "sleepRecord", "<init>", "(Landroid/app/Activity;Lcom/urbandroid/sleep/domain/SleepRecord;)V", "viewHolder", "", "bindSleepRecordToView", "(Lcom/urbandroid/sleep/fragment/dashboard/card/WeatherCard$SleepRecordViewHolder;)V", "turnOnWifi", "()V", "Landroid/view/View;", "parent", "loadWeather", "(Landroid/app/Activity;Landroid/view/View;)V", "cannotGetLocation", "(Landroid/view/View;)V", "Landroid/content/Context;", "requestWeather", "(Landroid/content/Context;Landroid/view/View;)V", "Lcom/urbandroid/sleep/location/weather/Weather;", "weather", "Lcom/urbandroid/sleep/location/Location;", "location", "renderWeather", "(Landroid/view/View;Lcom/urbandroid/sleep/location/weather/Weather;Lcom/urbandroid/sleep/location/Location;)V", "v", "createViewHolder", "(Landroid/view/View;)Lcom/urbandroid/sleep/fragment/dashboard/card/WeatherCard$SleepRecordViewHolder;", "", "hasConnectivity", "(Landroid/content/Context;)Z", ViewHierarchyConstants.VIEW_KEY, "onCardClicked", "bindView", "", "getNameResource", "()I", "Lcom/urbandroid/sleep/domain/SleepRecord;", "getSleepRecord", "()Lcom/urbandroid/sleep/domain/SleepRecord;", "Lcom/urbandroid/sleep/location/weather/Weather;", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "SleepRecordViewHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class WeatherCard extends DashboardCard<SleepRecordViewHolder> implements FeatureLogger {
    private final SleepRecord sleepRecord;
    private final String tag;
    private Weather weather;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/WeatherCard$SleepRecordViewHolder;", "Lcom/urbandroid/sleep/fragment/dashboard/card/LayeredViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class SleepRecordViewHolder extends LayeredViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SleepRecordViewHolder(View view) {
            super(view);
            view.getClass();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WeatherCard(Activity activity, SleepRecord sleepRecord) {
        super(activity, DashboardCard.Type.WEATHER, R.layout.card_weather);
        sleepRecord.getClass();
        this.sleepRecord = sleepRecord;
        this.tag = "WeatherCard";
    }

    private final void bindSleepRecordToView(SleepRecordViewHolder viewHolder) {
        Activity context = getContext();
        context.getClass();
        View view = viewHolder.itemView;
        view.getClass();
        loadWeather(context, view);
    }

    private final void cannotGetLocation(View parent) {
        if (parent.findViewById(R.id.weather_condition) != null) {
            View viewFindViewById = parent.findViewById(R.id.weather_condition);
            viewFindViewById.getClass();
            ((TextView) viewFindViewById).setText(R.string.no_location);
            View viewFindViewById2 = parent.findViewById(R.id.weather_icon);
            viewFindViewById2.getClass();
            ((ImageView) viewFindViewById2).setImageResource(R.drawable.ic_feature_offline);
        }
        if (parent.findViewById(R.id.foreground) != null) {
            parent.findViewById(R.id.foreground).setOnClickListener(new WeatherCard$$ExternalSyntheticLambda1(this, 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cannotGetLocation$lambda$0(WeatherCard weatherCard, View view) {
        SleepPermissionCompat sleepPermissionCompat = SleepPermissionCompat.INSTANCE;
        Activity context = weatherCard.getContext();
        context.getClass();
        if (!sleepPermissionCompat.isPermissionGranted(context, "android.permission.ACCESS_COARSE_LOCATION")) {
            Activity context2 = weatherCard.getContext();
            context2.getClass();
            if (!sleepPermissionCompat.isPermissionGranted(context2, "android.permission.ACCESS_FINE_LOCATION")) {
                Logger.logInfo("RatingActivity: Enabling WiFi no permission");
                Activity context3 = weatherCard.getContext();
                context3.getClass();
                sleepPermissionCompat.requestPermission(context3, "android.permission.ACCESS_COARSE_LOCATION", 73319);
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                weatherCard.getContext().startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
            } catch (Exception unused) {
                Toast.makeText(weatherCard.getContext(), R.string.general_unspecified_error, 0).show();
            }
        }
    }

    private final void loadWeather(Activity context, final View parent) {
        Weather weather = this.weather;
        if (weather != null) {
            renderWeather(parent, weather, null);
            return;
        }
        if (hasConnectivity(context)) {
            requestWeather(context, parent);
            return;
        }
        if (parent.findViewById(R.id.weather_condition) != null) {
            View viewFindViewById = parent.findViewById(R.id.weather_condition);
            viewFindViewById.getClass();
            ((TextView) viewFindViewById).setText(context.getString(R.string.message_connectivity_wait));
            View viewFindViewById2 = parent.findViewById(R.id.weather_icon);
            viewFindViewById2.getClass();
            ((ImageView) viewFindViewById2).setImageResource(R.drawable.ic_feature_offline);
        }
        parent.findViewById(R.id.foreground).setVisibility(0);
        parent.findViewById(R.id.foreground).setTag(Boolean.FALSE);
        if (parent.findViewById(R.id.foreground) != null) {
            parent.findViewById(R.id.foreground).setOnClickListener(new AiActivity$$ExternalSyntheticLambda6(context, this, 17));
        }
        ContextCompat.registerReceiver(context, new BroadcastReceiver() { // from class: com.urbandroid.sleep.fragment.dashboard.card.WeatherCard$loadWeather$connectivityReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                context2.getClass();
                intent.getClass();
                zza$$ExternalSyntheticOutline0.m("Weather: connectivity change ", this.this$0.hasConnectivity(context2));
                if (this.this$0.hasConnectivity(context2)) {
                    this.this$0.requestWeather(context2, parent);
                    try {
                        Logger.logInfo("Weather: unregister receiver ");
                        context2.unregisterReceiver(this);
                    } catch (Exception e) {
                        Logger.logSevere(e);
                    }
                }
            }
        }, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadWeather$lambda$0(Activity activity, WeatherCard weatherCard, View view) {
        Logger.logInfo("RatingActivity:Enabling WiFi");
        if (Build.VERSION.SDK_INT < 30) {
            SleepPermissionCompat sleepPermissionCompat = SleepPermissionCompat.INSTANCE;
            if (!sleepPermissionCompat.isPermissionGranted(activity, "android.permission.CHANGE_WIFI_STATE")) {
                Logger.logInfo("RatingActivity: Enabling WiFi no permission");
                sleepPermissionCompat.requestPermission(activity, "android.permission.CHANGE_WIFI_STATE", 73309);
                return;
            }
        }
        weatherCard.turnOnWifi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderWeather(View parent, Weather weather, Location location) {
        String desc;
        TextView textView;
        Logger.logInfo("RatingActivity: rendering Weather " + weather);
        if (weather == null) {
            return;
        }
        int i = 0;
        if (weather.getSource() != null) {
            parent.findViewById(R.id.weather_affiliation).setVisibility(0);
            View viewFindViewById = parent.findViewById(R.id.weather_affiliation);
            viewFindViewById.getClass();
            ((TextView) viewFindViewById).setText(weather.getSource());
        }
        if (parent.findViewById(R.id.foreground) != null) {
            parent.findViewById(R.id.foreground).setOnClickListener(new WeatherCard$$ExternalSyntheticLambda1(this, i));
        }
        View viewFindViewById2 = parent.findViewById(R.id.foreground);
        viewFindViewById2.getClass();
        ((ViewGroup) viewFindViewById2).setVisibility(0);
        TextView textView2 = (TextView) parent.findViewById(R.id.weather_temp);
        View viewFindViewById3 = parent.findViewById(R.id.weather_icon);
        viewFindViewById3.getClass();
        ImageView imageView = (ImageView) viewFindViewById3;
        if (textView2 != null) {
            textView2.setText(Weather.getTemperatureString(getContext(), weather));
            textView2.setVisibility(0);
        }
        if (weather.getCloudCoverage() > 50) {
            imageView.setImageResource(R.drawable.ic_weather_clouds);
        } else {
            imageView.setImageResource(R.drawable.ic_weather_cloudy);
        }
        Weather.Condition condition = weather.condition;
        if (condition != null) {
            imageView.setImageResource(condition.getResource());
        }
        TextView textView3 = (TextView) parent.findViewById(R.id.weather_cc);
        if (textView3 != null) {
            if (weather.getCloudCoverage() > 20) {
                textView3.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(getContext(), R.drawable.ic_cloud), (Drawable) null, (Drawable) null, (Drawable) null);
                textView3.setText(weather.getCloudCoverage() + "%");
                textView3.setVisibility(0);
            } else {
                textView3.setVisibility(8);
            }
        }
        TextView textView4 = (TextView) parent.findViewById(R.id.weather_ws);
        if (textView4 != null) {
            if (weather.getWindSpeed() > 9.0f) {
                textView4.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(getContext(), R.drawable.ic_action_wind), (Drawable) null, (Drawable) null, (Drawable) null);
                textView4.setText(Html.fromHtml(Math.round(weather.getWindSpeed()) + "<small>mps</small>"));
                textView4.setVisibility(0);
            } else {
                textView4.setVisibility(8);
            }
        }
        if (location != null && (textView = (TextView) parent.findViewById(R.id.weather_sun)) != null) {
            try {
                Calendar officialSunriseCalendarForDate = new SunriseSunsetCalculator(new com.urbandroid.common.util.math.luckycatlabs.sunrisesunset.dto.Location(location.getLat(), location.getLon()), TimeZone.getDefault()).getOfficialSunriseCalendarForDate(Calendar.getInstance());
                if (new Date().before(officialSunriseCalendarForDate.getTime())) {
                    textView.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(getContext(), R.drawable.ic_action_sunrise), (Drawable) null, (Drawable) null, (Drawable) null);
                    textView.setText(DateUtil.formatTimeShort(getContext(), officialSunriseCalendarForDate.getTime().getTime()));
                    textView.setVisibility(0);
                } else {
                    textView.setVisibility(8);
                }
            } catch (Exception e) {
                textView.setVisibility(0);
                Logger.logSevere(e);
            }
        }
        TextView textView5 = (TextView) parent.findViewById(R.id.weather_condition);
        if (textView5 != null) {
            if (weather.getCondition() == null) {
                textView5.setVisibility(8);
                return;
            }
            if (weather.getDesc() == null) {
                String tag = weather.getCondition().getTag();
                tag.getClass();
                Locale locale = Locale.getDefault();
                locale.getClass();
                desc = tag.toLowerCase(locale);
                desc.getClass();
            } else {
                desc = weather.getDesc();
            }
            textView5.setText(desc);
            textView5.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void renderWeather$lambda$0(WeatherCard weatherCard, View view) {
        ViewIntent.url(weatherCard.getContext(), "https://www.google.com/search?q=weather");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestWeather(Context context, View parent) {
        Logger.logInfo("Weather: requestWeather");
        if (LocationService.getLastLocation(context, new ListenableFutureKt$$ExternalSyntheticLambda0(this, parent, context, 7))) {
            return;
        }
        cannotGetLocation(parent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestWeather$lambda$0(final WeatherCard weatherCard, final View view, final Context context, final Location location) {
        weatherCard.cannotGetLocation(view);
        new AsyncTask<Void, Void, Weather>() { // from class: com.urbandroid.sleep.fragment.dashboard.card.WeatherCard$requestWeather$result$1$1
            @Override // android.os.AsyncTask
            public Weather doInBackground(Void... voids) {
                voids.getClass();
                Logger.logInfo("Weather: Loading weather in background");
                Weather weather = new NorwegianWeatherService().getWeather(location.getCoarse());
                if (weather == null) {
                    weather = new OpenWeatherMapWeatherService().getWeather(location.getCoarse());
                }
                weatherCard.weather = weather;
                return weather;
            }

            @Override // android.os.AsyncTask
            public void onPostExecute(Weather weather) {
                String desc;
                if (weather != null) {
                    weatherCard.renderWeather(view, weather, location);
                    Context context2 = context;
                    String temperatureString = Weather.getTemperatureString(context2, weather);
                    if (weather.getDesc() == null) {
                        String tag = weather.getCondition().getTag();
                        tag.getClass();
                        Locale locale = Locale.getDefault();
                        locale.getClass();
                        desc = tag.toLowerCase(locale);
                        desc.getClass();
                    } else {
                        desc = weather.getDesc();
                    }
                    TtsService.speak(context2, temperatureString + " " + desc);
                }
            }

            @Override // android.os.AsyncTask
            public void onPreExecute() {
                TextView textView;
                super.onPreExecute();
                Logger.logInfo("before loading weather");
                if (view.findViewById(R.id.weather_affiliation) != null) {
                    view.findViewById(R.id.weather_affiliation).setVisibility(8);
                }
                if (view.findViewById(R.id.weather_condition) == null || (textView = (TextView) view.findViewById(R.id.weather_condition)) == null) {
                    return;
                }
                String string = context.getString(R.string.weather);
                String string2 = context.getString(R.string.stats_caption_loading);
                string2.getClass();
                Locale locale = Locale.getDefault();
                locale.getClass();
                String lowerCase = string2.toLowerCase(locale);
                lowerCase.getClass();
                textView.setText(string + " " + lowerCase);
            }
        }.execute(new Void[0]);
    }

    private final void turnOnWifi() {
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                getContext().startActivity(new Intent("android.settings.WIFI_SETTINGS"));
            } catch (Exception unused) {
                Toast.makeText(getContext(), R.string.general_unspecified_error, 1).show();
            }
        } else {
            Object systemService = getContext().getSystemService("wifi");
            systemService.getClass();
            ((WifiManager) systemService).setWifiEnabled(true);
        }
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void bindView(SleepRecordViewHolder viewHolder) {
        viewHolder.getClass();
        bindSleepRecordToView(viewHolder);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public SleepRecordViewHolder createViewHolder(View v) {
        v.getClass();
        return new SleepRecordViewHolder(v);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public int getNameResource() {
        return R.string.weather;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    public final boolean hasConnectivity(Context context) {
        context.getClass();
        try {
            Object systemService = context.getSystemService("connectivity");
            systemService.getClass();
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            Logger.logSevere(th);
            return false;
        }
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void onCardClicked(View view) {
        view.getClass();
    }
}
