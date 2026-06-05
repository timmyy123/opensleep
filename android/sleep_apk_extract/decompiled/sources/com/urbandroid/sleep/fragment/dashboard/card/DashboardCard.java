package com.urbandroid.sleep.fragment.dashboard.card;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.work.impl.Processor$$ExternalSyntheticLambda1;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.domain.tag.Tag$$ExternalSyntheticLambda1;
import com.urbandroid.sleep.fragment.dashboard.CardBuilder;
import com.urbandroid.sleep.fragment.dashboard.DashboardAdapter;
import com.urbandroid.sleep.fragment.dashboard.detail.SleepDetailActivity;
import com.urbandroid.sleep.fragment.dashboard.morning.MorningActivity;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import com.urbandroid.sleep.nearby.core.Endpoint$$ExternalSyntheticLambda0;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DashboardCard<T extends RecyclerView.ViewHolder> {
    private DashboardAdapter adapter;
    private CardBuilder cardBuilder;
    private Activity context;
    private View currentView;
    private int layout;
    private Type type;
    private boolean screenshot = false;
    private Handler h = new Handler();

    public enum Type {
        NEXT_ALARM,
        BEDTIME,
        SCORE,
        LATEST_GRAPH,
        NO_GRAPHS,
        ADVICE,
        CHART,
        GOAL,
        ADD_ON,
        NOISE,
        NO_NOISE,
        LAST,
        BACKUP,
        NATIVE_AD,
        UNLOCK,
        PROMO,
        RELEASE_NOTES,
        FIRST,
        UNDO,
        SLEEP_TALK,
        SNORING,
        SHORTCUT,
        CHECKLIST,
        NEWS,
        SHOW_CASE,
        NO_AUTO_TRACK,
        ACHIEVEMENTS,
        SLEEP_HYPNOGRAM,
        SLEEP_PHASES,
        SLEEP_ACTIGRAPH,
        SLEEP_TIMELINE,
        SLEEP_SENSOR_HR,
        SLEEP_SENSOR_HRV,
        SLEEP_SENSOR_RR,
        SLEEP_SENSOR_SPO2,
        SLEEP_SENSOR_LIGHT,
        SLEEP_COMMENT,
        SLEEP_DETAIL_SCORE,
        SLEEP_RECORD_NAVIGATION,
        SLEEP_DETAIL_ADVICE_RDI,
        SLEEP_DETAIL_MAP,
        SLEEP_DETAIL_ALL_SENSORS,
        WEATHER,
        DISMISS_NEXT_ALARM,
        AI
    }

    public DashboardCard(Activity activity, Type type, int i) {
        this.context = activity;
        this.type = type;
        this.layout = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getViewHolder$0(DashboardCard dashboardCard, List list) {
        RecyclerView recyclerView = getAdapter().getRecyclerView();
        if (isPinned()) {
            if (recyclerView != null) {
                recyclerView.smoothScrollToPosition(0);
            }
        } else if (dashboardCard instanceof ShowCaseCard) {
            recyclerView.smoothScrollToPosition(list.size() - 1);
            recyclerView.scrollBy(0, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$getViewHolder$1(DashboardCard dashboardCard, View view) {
        CardBuilder cardBuilder = this.cardBuilder;
        if (cardBuilder == null) {
            return false;
        }
        Integer numFindPosition = cardBuilder.findPosition(getContext(), this);
        List<DashboardCard<?>> cards = this.adapter.getCards();
        if (numFindPosition == null) {
            return false;
        }
        setPinned(!isPinned());
        this.cardBuilder.buildCards(this.context);
        Integer numFindPosition2 = this.cardBuilder.findPosition(getContext(), this);
        if (numFindPosition.intValue() >= cards.size()) {
            return false;
        }
        DashboardCard<?> dashboardCard2 = cards.get(numFindPosition.intValue());
        if (numFindPosition2 != null) {
            cards.remove(dashboardCard2);
            this.adapter.notifyItemRemoved(numFindPosition.intValue());
            cards.add(numFindPosition2.intValue(), dashboardCard2);
            this.adapter.notifyItemInserted(numFindPosition2.intValue());
            if (this.context.getClass() == SleepDetailActivity.class || this.context.getClass() == MorningActivity.class) {
                reloadAll();
            }
        } else {
            reloadAll();
        }
        this.h.postDelayed(new Processor$$ExternalSyntheticLambda1(this, dashboardCard, cards, 7), 500L);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeForNow$2() {
        int position = getPosition();
        StringBuilder sbM65m = Fragment$$ExternalSyntheticOutline1.m65m(position, "Dashboard: remove for now ", " ");
        sbM65m.append(this.adapter);
        Logger.logInfo(sbM65m.toString());
        DashboardAdapter dashboardAdapter = this.adapter;
        if (dashboardAdapter == null || position < 0) {
            return;
        }
        dashboardAdapter.getCards().remove(position);
        try {
            this.adapter.notifyItemRemoved(position);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public abstract void bindView(T t);

    public boolean canBeSwiped() {
        return true;
    }

    public boolean canChangePosition() {
        return true;
    }

    public abstract T createViewHolder(View view);

    public DashboardAdapter getAdapter() {
        return this.adapter;
    }

    public Activity getContext() {
        return this.context;
    }

    public int getLayout() {
        return this.layout;
    }

    public String getName() {
        return getNameResource() == -1 ? getClass().getSimpleName() : this.context.getResources().getString(getNameResource());
    }

    public int getNameResource() {
        return -1;
    }

    public String getPinnedSettingKey() {
        return getSettingKey("key_card_pinned_");
    }

    public int getPosition() {
        List<DashboardCard<?>> cards = this.adapter.getCards();
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getType() == getType()) {
                return i;
            }
        }
        return -1;
    }

    public String getRemovedSettingKey() {
        return getSettingKey("key_card_removed_");
    }

    public String getSettingKey(String str) {
        Activity activity = this.context;
        if ((activity instanceof SleepDetailActivity) || (activity instanceof MorningActivity)) {
            return getSettingKeyPerActivity(str);
        }
        StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m(str);
        sbM.append(this.type.name());
        return sbM.toString();
    }

    public String getSettingKeyPerActivity(String str) {
        StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m(str);
        sbM.append(this.type.name());
        sbM.append("_");
        sbM.append(this.context.getClass().getSimpleName());
        return sbM.toString();
    }

    public Type getType() {
        return this.type;
    }

    public T getViewHolder(ViewGroup viewGroup) {
        View viewInflate = InflatorUtil.get(this.context).inflate(getLayout(), viewGroup, false);
        View viewFindViewById = viewInflate.findViewById(R.id.foreground);
        if (viewFindViewById instanceof CardView) {
            ((CardView) viewFindViewById).setCardElevation(0.0f);
        }
        if (viewInflate instanceof CardView) {
            ((CardView) viewInflate).setCardElevation(0.0f);
        }
        if (viewFindViewById != null && isPinnable()) {
            viewFindViewById.setOnLongClickListener(new Tag$$ExternalSyntheticLambda1(this, this, 1));
        }
        this.currentView = viewInflate;
        return (T) createViewHolder(viewInflate);
    }

    public boolean isPinnable() {
        return true;
    }

    public boolean isPinned() {
        return PreferenceManager.getDefaultSharedPreferences(this.context).getBoolean(getPinnedSettingKey(), false);
    }

    public boolean isRemovable() {
        return true;
    }

    public boolean isRemoved() {
        return PreferenceManager.getDefaultSharedPreferences(this.context).getBoolean(getRemovedSettingKey(), false);
    }

    public boolean isScreenReady() {
        return true;
    }

    public boolean isScreenshot() {
        return this.screenshot;
    }

    public boolean isThemeCard() {
        return true;
    }

    public void onCardClicked(View view) {
    }

    public void onCardDestroyed() {
    }

    public void refresh() {
        int position = getPosition();
        DashboardAdapter dashboardAdapter = this.adapter;
        if (dashboardAdapter == null || position < 0) {
            return;
        }
        dashboardAdapter.notifyItemChanged(getPosition());
    }

    public void reloadAll() {
        Logger.logInfo("Dashboard: reload all ");
        DashboardAdapter dashboardAdapter = this.adapter;
        if (dashboardAdapter != null) {
            dashboardAdapter.refreshCards(this.cardBuilder.buildCards(this.context));
        }
    }

    public void removeForNow() {
        this.h.post(new Endpoint$$ExternalSyntheticLambda0(this, 1));
    }

    public void save() {
    }

    public void setAdapter(DashboardAdapter dashboardAdapter) {
        this.adapter = dashboardAdapter;
    }

    public void setCardBuilder(CardBuilder cardBuilder) {
        this.cardBuilder = cardBuilder;
    }

    public void setCardVisibility(Context context, ViewGroup viewGroup, boolean z) {
        if (z) {
            viewGroup.getLayoutParams().height = -2;
            viewGroup.setVisibility(0);
        } else {
            viewGroup.getLayoutParams().height = 0;
            viewGroup.setVisibility(8);
        }
    }

    public void setPinned(boolean z) {
        if (getPinnedSettingKey() != null) {
            PreferenceManager.getDefaultSharedPreferences(this.context).edit().putBoolean(getPinnedSettingKey(), z).apply();
        }
    }

    public void setRemoved(boolean z) {
        if (getRemovedSettingKey() != null) {
            PreferenceManager.getDefaultSharedPreferences(this.context).edit().putBoolean(getRemovedSettingKey(), z).apply();
        }
    }

    public void setRemovedBySwipe() {
        setRemoved(true);
    }

    public void setScreenshot(boolean z) {
        this.screenshot = z;
    }
}
