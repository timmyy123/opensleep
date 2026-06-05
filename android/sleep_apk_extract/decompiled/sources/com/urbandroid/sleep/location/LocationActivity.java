package com.urbandroid.sleep.location;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.math.luckycatlabs.sunrisesunset.SunriseSunsetCalculator;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.gui.ToolbarUtil;
import com.urbandroid.sleep.location.LocationView;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes4.dex */
public class LocationActivity extends BaseActivity implements LocationView.ILocationListener {
    private LocationView locationView;

    private void updateLocationTitle(Location location) {
        Calendar civilSunriseCalendarForDate;
        if (getSupportActionBar() == null || location == null) {
            return;
        }
        try {
            civilSunriseCalendarForDate = new SunriseSunsetCalculator(new com.urbandroid.common.util.math.luckycatlabs.sunrisesunset.dto.Location(location.getLat(), location.getLon()), TimeZone.getDefault()).getCivilSunriseCalendarForDate(Calendar.getInstance());
        } catch (Exception e) {
            Logger.logSevere(e);
            civilSunriseCalendarForDate = null;
        }
        if (civilSunriseCalendarForDate != null) {
            getSupportActionBar().setSubtitle(String.format("%.2f, %.2f, %02d:%02d", Double.valueOf(location.getLat()), Double.valueOf(location.getLon()), Integer.valueOf(civilSunriseCalendarForDate.get(11)), Integer.valueOf(civilSunriseCalendarForDate.get(12))));
        }
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(0);
        SharedApplicationContext.initialize(getApplicationContext(), true);
        ToolbarUtil.apply(this);
        setContentView(R.layout.activity_map);
        LocationView locationView = (LocationView) findViewById(R.id.location_view);
        this.locationView = locationView;
        locationView.setListener(this);
        updateLocationTitle(SharedApplicationContext.getSettings().getLocation());
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.confirm_menu, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        SharedApplicationContext.getSettings().setLocation(this.locationView.getLocation());
        setResult(-1);
        finish();
        return true;
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        super.onUserInteraction();
    }

    @Override // com.urbandroid.sleep.location.LocationView.ILocationListener
    public void updateLocation(Location location) {
        updateLocationTitle(location);
    }
}
