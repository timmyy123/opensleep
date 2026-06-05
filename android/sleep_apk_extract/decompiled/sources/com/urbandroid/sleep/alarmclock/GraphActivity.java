package com.urbandroid.sleep.alarmclock;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.snackbar.Snackbar;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.NewAddRecordActivity;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.settings.SearchActivity;
import com.urbandroid.sleep.async.ImportDataAsyncTask;
import com.urbandroid.sleep.async.ProgressContext;
import com.urbandroid.sleep.domain.undo.UndoOperationGroup;
import com.urbandroid.sleep.fragment.GraphFragment;
import com.urbandroid.sleep.gui.MenuUtil;
import com.urbandroid.sleep.gui.ToolbarUtil;
import com.urbandroid.sleep.gui.toolbar.OffsetListener;
import com.urbandroid.sleep.gui.toolbar.OffsetObserver;
import com.urbandroid.sleep.gui.view.ComponentColorUtilKt;
import com.urbandroid.sleep.service.SharedApplicationContext;

/* JADX INFO: loaded from: classes4.dex */
public class GraphActivity extends BaseActivity implements OffsetObserver {
    private static long lastShownUndoOperationTimestamp;
    private GraphFragment fragment;
    private int verticalOffset = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        startActivity(new Intent(this, (Class<?>) NewAddRecordActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        SearchActivity.start(this, R.id.search_lenses_graphs, true);
    }

    @Override // com.urbandroid.sleep.gui.toolbar.OffsetObserver
    public int getVerticalOffset() {
        return this.verticalOffset;
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        GlobalInitializator.initializeIfRequired(this);
        setContentView(R.layout.activity_graph);
        ToolbarUtil.apply(this);
        final int i = 1;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.graphs);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        this.fragment = (GraphFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        ComponentColorUtilKt.color(findViewById(R.id.fab));
        final int i2 = 0;
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.GraphActivity$$ExternalSyntheticLambda0
            public final /* synthetic */ GraphActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3 = i2;
                GraphActivity graphActivity = this.f$0;
                switch (i3) {
                    case 0:
                        graphActivity.lambda$onCreate$0(view);
                        break;
                    default:
                        graphActivity.lambda$onCreate$1(view);
                        break;
                }
            }
        });
        if (getIntent() != null && getIntent().hasExtra("no_toolbar") && findViewById(R.id.appbar) != null) {
            ((AppBarLayout) findViewById(R.id.appbar)).setExpanded(false);
        }
        View viewFindViewById = findViewById(R.id.search_button);
        viewFindViewById.setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.GraphActivity$$ExternalSyntheticLambda0
            public final /* synthetic */ GraphActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3 = i;
                GraphActivity graphActivity = this.f$0;
                switch (i3) {
                    case 0:
                        graphActivity.lambda$onCreate$0(view);
                        break;
                    default:
                        graphActivity.lambda$onCreate$1(view);
                        break;
                }
            }
        });
        ((AppBarLayout) findViewById(R.id.appbar)).addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new OffsetListener(this, this, viewFindViewById));
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings_menu, menu);
        MenuUtil.showIcons(menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        }
        if (itemId != R.id.menu_doc) {
            return false;
        }
        ViewIntent.urlCustomTab(this, "https://sleep.urbandroid.org/docs//sleep/how_to_read_sleep_graphs.html");
        return true;
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.fragment.setVisible();
        if (getIntent() != null) {
            long longExtra = getIntent().getLongExtra("date", -1L);
            int intExtra = getIntent().getIntExtra("date_offset", 0);
            if (longExtra != -1) {
                this.fragment.scrollTo(longExtra, intExtra);
            }
        }
    }

    @Override // com.urbandroid.sleep.gui.toolbar.OffsetObserver
    public void setExpanded(boolean z) {
    }

    @Override // com.urbandroid.sleep.gui.toolbar.OffsetObserver
    public void setVerticalOffset(int i) {
        this.verticalOffset = i;
    }

    public void showUndoAfterDeleteAll() {
        Snackbar.make(findViewById(R.id.root), R.string.menu_delete_old, -2).setAction(R.string.undo, new View.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.GraphActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new ImportDataAsyncTask(new ProgressContext(GraphActivity.this), GraphActivity.this, new Runnable() { // from class: com.urbandroid.sleep.alarmclock.GraphActivity.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GraphActivity.this.fragment.setDataUpdated();
                    }
                }) { // from class: com.urbandroid.sleep.alarmclock.GraphActivity.2.2
                    @Override // com.urbandroid.sleep.async.ImportDataAsyncTask, com.urbandroid.sleep.async.AbstractProgressAsyncTask
                    public String getSuccessString() {
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }).show();
        this.fragment.setDataUpdated();
    }

    public void showUndoToastIfNeeded() {
        UndoOperationGroup currentUndoOperation = SharedApplicationContext.getInstance().getSleepRecordRepository().getCurrentUndoOperation();
        if (currentUndoOperation == null || currentUndoOperation.timestamp() <= lastShownUndoOperationTimestamp || currentUndoOperation.timestamp() < System.currentTimeMillis() - 15000) {
            return;
        }
        Logger.logInfo("Undo: Going to show undo operation (" + currentUndoOperation.getName() + ") for timestamp: " + currentUndoOperation.timestamp() + " lastShownUndoOperationTimestamp: " + lastShownUndoOperationTimestamp);
        lastShownUndoOperationTimestamp = currentUndoOperation.timestamp();
        Snackbar.make(findViewById(R.id.root), currentUndoOperation.getName(), -2).setAction(R.string.undo, new View.OnClickListener() { // from class: com.urbandroid.sleep.alarmclock.GraphActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SharedApplicationContext.getInstance().getSleepRecordRepository().performUndo();
                GraphActivity.this.fragment.setDataUpdated();
            }
        }).show();
    }
}
