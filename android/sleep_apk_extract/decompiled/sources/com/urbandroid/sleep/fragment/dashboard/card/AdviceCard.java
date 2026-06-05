package com.urbandroid.sleep.fragment.dashboard.card;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.advice.AdviceActivity;
import com.urbandroid.sleep.addon.stats.advice.AdviceAdapter;
import com.urbandroid.sleep.addon.stats.model.Advice;
import com.urbandroid.sleep.addon.stats.model.NoRecordsException;
import com.urbandroid.sleep.addon.stats.model.StatRepo;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import java.util.Calendar;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AdviceCard extends DashboardCard<AdviceViewHolder> {
    private static List<Advice> adviceList;

    public class AdviceViewHolder extends LayeredViewHolder {
        public AdviceViewHolder(View view) {
            super(view);
        }
    }

    public AdviceCard(Activity activity) {
        super(activity, DashboardCard.Type.ADVICE, R.layout.card_advice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindViewDelayed(AdviceViewHolder adviceViewHolder) {
        Advice adviceSelectMostSevereAdvice;
        StringBuilder sb = new StringBuilder("Dashboard: advice bindDelayed ");
        List<Advice> list = adviceList;
        Object objValueOf = list;
        if (list != null) {
            objValueOf = Integer.valueOf(list.size());
        }
        sb.append(objValueOf);
        Logger.logInfo(sb.toString());
        List<Advice> list2 = adviceList;
        if (list2 == null || list2.size() <= 0 || (adviceSelectMostSevereAdvice = Advice.selectMostSevereAdvice(getContext(), adviceList)) == null) {
            return;
        }
        AdviceAdapter.mapAdviceToView(getContext(), R.id.foreground, adviceViewHolder.itemView, adviceSelectMostSevereAdvice, true);
        ((TextView) adviceViewHolder.itemView.findViewById(R.id.title)).setText(R.string.advice);
        setCardVisibility(getContext(), (ViewGroup) adviceViewHolder.itemView, true);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void bindView(final AdviceViewHolder adviceViewHolder) {
        Logger.logInfo("Dashboard: advice hide");
        List<Advice> list = adviceList;
        if (list != null) {
            if (list.size() == 0) {
                setCardVisibility(getContext(), (ViewGroup) adviceViewHolder.itemView, false);
            }
            bindViewDelayed(adviceViewHolder);
        } else {
            setCardVisibility(getContext(), (ViewGroup) adviceViewHolder.itemView, false);
            Logger.logInfo("Dashboard: advice start async");
            new AsyncTask<Void, Void, List<Advice>>() { // from class: com.urbandroid.sleep.fragment.dashboard.card.AdviceCard.1
                @Override // android.os.AsyncTask
                public List<Advice> doInBackground(Void... voidArr) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(6, -100);
                    StatRepo statRepo = new StatRepo();
                    try {
                        statRepo.initialize(AdviceCard.this.getContext(), calendar.getTime(), StatRepo.Mode.FULL);
                        AdviceCard.adviceList = statRepo.getAdvice(AdviceCard.this.getContext());
                        StringBuilder sb = new StringBuilder("Dashboard: advice background ");
                        sb.append(AdviceCard.adviceList != null ? Integer.valueOf(AdviceCard.adviceList.size()) : AdviceCard.adviceList);
                        Logger.logInfo(sb.toString());
                    } catch (NoRecordsException unused) {
                    }
                    return null;
                }

                @Override // android.os.AsyncTask
                public void onPostExecute(List<Advice> list2) {
                    super.onPostExecute(list2);
                    Logger.logInfo("Dashboard: advice post");
                    AdviceCard.this.bindViewDelayed(adviceViewHolder);
                }
            }.execute(new Void[0]);
        }
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public AdviceViewHolder createViewHolder(View view) {
        return new AdviceViewHolder(view);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public int getNameResource() {
        return R.string.advice;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void onCardClicked(View view) {
        getContext().startActivity(new Intent(getContext(), (Class<?>) AdviceActivity.class));
    }
}
