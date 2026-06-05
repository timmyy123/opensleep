package com.urbandroid.sleep.alarmclock;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.fragment.StatsFragmentNew;
import com.urbandroid.sleep.graph.SleepGraphImageGenerator;
import com.urbandroid.sleep.gui.TintUtil;
import com.urbandroid.sleep.gui.ToolbarUtil;
import com.urbandroid.sleep.share.image.ShareDataUtil;
import java.io.IOException;
import java.util.Date;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\u00020\u00138\u0016X\u0096D¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/urbandroid/sleep/alarmclock/StatsActivity;", "Lcom/urbandroid/common/BaseActivity;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/Menu;", "menu", "", "onCreateOptionsMenu", "(Landroid/view/Menu;)Z", "Landroid/view/MenuItem;", "item", "onOptionsItemSelected", "(Landroid/view/MenuItem;)Z", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "Lcom/urbandroid/sleep/fragment/StatsFragmentNew;", "fragment", "Lcom/urbandroid/sleep/fragment/StatsFragmentNew;", "getFragment", "()Lcom/urbandroid/sleep/fragment/StatsFragmentNew;", "setFragment", "(Lcom/urbandroid/sleep/fragment/StatsFragmentNew;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StatsActivity extends BaseActivity implements FeatureLogger {
    private StatsFragmentNew fragment;
    private final String tag = "StatsActivity";

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GlobalInitializator.initializeIfRequired(this);
        setContentView(R.layout.activity_stats);
        TintUtil.tint(this);
        ToolbarUtil.apply(this);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(R.string.stats);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        Fragment fragmentFindFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragment);
        fragmentFindFragmentById.getClass();
        StatsFragmentNew statsFragmentNew = (StatsFragmentNew) fragmentFindFragmentById;
        this.fragment = statsFragmentNew;
        statsFragmentNew.setVisible();
        ((MaterialButton) findViewById(R.id.fab)).setOnClickListener(new EditActivity$$ExternalSyntheticLambda0(this, 4));
        getWindow().setEnterTransition(null);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu_stats, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        RecyclerView recyclerView;
        item.getClass();
        int itemId = item.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        }
        if (itemId == R.id.menu_doc) {
            ViewIntent.urlCustomTab(this, "https://sleep.urbandroid.org/docs//sleep/sleepscore.html#sleepscore-dimensions");
            return true;
        }
        if (itemId != R.id.menu_share) {
            return false;
        }
        StatsFragmentNew statsFragmentNew = this.fragment;
        if (statsFragmentNew != null && (recyclerView = statsFragmentNew.getRecyclerView()) != null && recyclerView.getAdapter() != null) {
            String strM = FileInsert$$ExternalSyntheticOutline0.m("graph_detail_", DateUtil.getDatetimestamp(new Date()), ".png");
            try {
                ShareDataUtil.saveData(this, strM, SleepGraphImageGenerator.generateSleepGraph((Context) this, (View) recyclerView, true));
                startActivity(ShareDataUtil.createIntent(this, strM, getString(R.string.score) + ", " + getString(R.string.app_name_long)));
            } catch (IOException e) {
                Logger.logSevere(e);
                Toast.makeText(this, R.string.save_to_card_failed, 0).show();
            }
        }
        return true;
    }
}
