package com.urbandroid.sleep.addon.stats.advice;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.model.Advice;
import com.urbandroid.sleep.addon.stats.model.NoRecordsException;
import com.urbandroid.sleep.addon.stats.model.StatRepo;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.gui.MenuUtil;
import com.urbandroid.sleep.gui.TintUtil;
import com.urbandroid.sleep.gui.ToolbarUtil;
import com.urbandroid.sleep.gui.fab.ScrollAnimator;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AdviceActivity extends BaseActivity {
    private ScrollAnimator scrollAnimator = null;

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        GlobalInitializator.initializeIfRequired(this);
        setContentView(R.layout.activity_advice);
        ToolbarUtil.apply(this);
        TintUtil.tint(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        SharedApplicationContext.getSettings().addShowCaseShown("sc_advice");
        new AsyncTask<Void, Void, List<Advice>>() { // from class: com.urbandroid.sleep.addon.stats.advice.AdviceActivity.1
            @Override // android.os.AsyncTask
            public List<Advice> doInBackground(Void... voidArr) {
                Calendar calendar = Calendar.getInstance();
                calendar.add(6, -100);
                StatRepo statRepo = new StatRepo();
                try {
                    statRepo.initialize(AdviceActivity.this, calendar.getTime(), StatRepo.Mode.FULL);
                    return statRepo.getAdvice(AdviceActivity.this);
                } catch (NoRecordsException unused) {
                    return null;
                }
            }

            @Override // android.os.AsyncTask
            public void onPostExecute(List<Advice> list) {
                super.onPostExecute(list);
                AdviceActivity.this.findViewById(R.id.progress).setVisibility(8);
                if (list == null || list.size() == 0) {
                    AdviceActivity.this.findViewById(R.id.no_data).setVisibility(0);
                    ((AnimatedVectorDrawable) ((ImageView) AdviceActivity.this.findViewById(R.id.no_data_image)).getDrawable()).start();
                    return;
                }
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                for (Advice advice : list) {
                    i++;
                    if (advice.getType() == Advice.Type.CAUTION) {
                        i2++;
                    } else if (advice.getType() == Advice.Type.CONGRATS) {
                        i3++;
                    }
                }
                AdviceActivity adviceActivity = AdviceActivity.this;
                if (i > 0) {
                    adviceActivity.findViewById(R.id.no_data).setVisibility(8);
                } else {
                    adviceActivity.findViewById(R.id.no_data).setVisibility(0);
                }
                ViewGroup viewGroup = (ViewGroup) InflatorUtil.get(AdviceActivity.this).inflate(R.layout.activity_advice_title, (ViewGroup) null, false);
                if (i3 + i2 > 0) {
                    if (i3 >= 0) {
                        ((TextView) viewGroup.findViewById(R.id.score)).setText(i3 + " / " + i);
                    }
                    if (i2 >= 0) {
                        ((TextView) viewGroup.findViewById(R.id.score_second)).setText(i2 + " / " + i);
                    }
                }
                ListView listView = (ListView) AdviceActivity.this.findViewById(R.id.list);
                listView.setNestedScrollingEnabled(true);
                listView.setAdapter((ListAdapter) new AdviceAdapter(AdviceActivity.this, new ArrayList(list)));
                listView.addHeaderView(viewGroup);
                listView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.urbandroid.sleep.addon.stats.advice.AdviceActivity.1.1
                    @Override // android.widget.AbsListView.OnScrollListener
                    public void onScroll(AbsListView absListView, int i4, int i5, int i6) {
                        if (AdviceActivity.this.scrollAnimator == null) {
                            AdviceActivity.this.scrollAnimator = new ScrollAnimator(AdviceActivity.this);
                        }
                        AdviceActivity.this.scrollAnimator.scroll(i4);
                    }

                    @Override // android.widget.AbsListView.OnScrollListener
                    public void onScrollStateChanged(AbsListView absListView, int i4) {
                    }
                });
            }

            @Override // android.os.AsyncTask
            public void onPreExecute() {
                super.onPreExecute();
                AdviceActivity.this.findViewById(R.id.progress).setVisibility(0);
            }
        }.execute(new Void[0]);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu_stats, menu);
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
        ViewIntent.urlCustomTab(this, "https://sleep.urbandroid.org/docs//sleep/advice.html");
        return true;
    }
}
