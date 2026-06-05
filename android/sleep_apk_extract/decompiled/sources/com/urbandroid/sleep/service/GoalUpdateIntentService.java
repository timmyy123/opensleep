package com.urbandroid.sleep.service;

import android.content.Context;
import android.content.Intent;
import androidx.core.app.FixedJobIntentService;
import com.urbandroid.sleep.addon.stats.goal.GoalDetailActivity;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.addon.stats.model.StatRepo;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.domain.goal.Goal;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class GoalUpdateIntentService extends FixedJobIntentService {
    public static double getCurrentGoalValue(Context context, Goal goal) {
        try {
            StatRepo statRepo = new StatRepo();
            statRepo.initialize(context, 60);
            List<StatRecord> mergedStatRecords = statRepo.getMergedStatRecords();
            if (mergedStatRecords == null || mergedStatRecords.size() <= 0) {
                return goal.type.getDefaultBase();
            }
            List<StatRecord> listFilterGoalRecords = Goal.filterGoalRecords(goal, mergedStatRecords, new Date(), 30);
            goal.nextTarget = Goal.getNextTarget(context, goal, mergedStatRecords);
            return Goal.createAggregator(context, goal.type).aggregate(listFilterGoalRecords);
        } catch (Exception unused) {
            return goal.type.getDefaultBase();
        }
    }

    public static void updateGoalProgress(Context context, Goal goal) {
        if (goal != null) {
            goal.current = getCurrentGoalValue(context, goal);
            goal.lastUpdate = System.currentTimeMillis();
            new Settings(context).setCurrentGoal(goal);
        }
    }

    @Override // androidx.core.app.JobIntentService
    public void onHandleWork(Intent intent) {
        GlobalInitializator.initializeIfRequired(this);
        Goal currentGoal = new Settings(getApplicationContext()).getCurrentGoal();
        if (currentGoal == null) {
            return;
        }
        updateGoalProgress(getApplicationContext(), currentGoal);
        if (currentGoal.getProgressDays() < currentGoal.getGoalDays() || currentGoal.getProgress() < 1.0d || currentGoal.status != Goal.Status.IN_PROGRESS) {
            return;
        }
        GoalDetailActivity.start(getApplicationContext());
    }
}
