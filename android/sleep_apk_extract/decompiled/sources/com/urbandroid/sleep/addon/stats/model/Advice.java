package com.urbandroid.sleep.addon.stats.model;

import android.app.Activity;
import com.urbandroid.common.util.RandUtil;
import com.urbandroid.sleep.domain.goal.Goal;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class Advice {
    private String[] advice;
    private String body;
    private Goal.Type goalType;
    private int priority;
    private String readMoreLink;
    private Type type;

    public enum Type {
        CONGRATS,
        CAUTION,
        INDIFFERENT
    }

    public Advice(Type type, String str, String[] strArr, int i, String str2) {
        this.type = type;
        this.body = str;
        this.advice = strArr;
        this.priority = i;
        this.readMoreLink = str2;
    }

    public static Advice selectMostSevereAdvice(Activity activity, List<Advice> list) {
        if (list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        for (Advice advice : list) {
            if (advice.getType() == Type.CAUTION) {
                i--;
                arrayList2.add(advice);
            } else if (advice.getType() == Type.CONGRATS) {
                i++;
                arrayList.add(advice);
            }
        }
        Advice advice2 = list.get(0);
        if (i < 0 && arrayList2.size() > 0) {
            advice2 = (Advice) arrayList2.get(Math.max(0, Math.min(RandUtil.range(0, arrayList2.size() - 1), arrayList2.size() - 1)));
        }
        return (i < 0 || arrayList.size() <= 0) ? advice2 : (Advice) arrayList.get(Math.max(0, Math.min(RandUtil.range(0, arrayList.size() - 1), arrayList.size() - 1)));
    }

    public Advice addGoal(Goal.Type type) {
        this.goalType = type;
        return this;
    }

    public String[] getAdvice() {
        return this.advice;
    }

    public String getBody() {
        return this.body;
    }

    public Goal.Type getGoalType() {
        return this.goalType;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getReadMoreLink() {
        return this.readMoreLink;
    }

    public Type getType() {
        return this.type;
    }

    public Advice setReadMoreLink(String str) {
        this.readMoreLink = str;
        return this;
    }

    public Advice(Type type, String str, String[] strArr, int i) {
        this(type, str, strArr, i, null);
    }
}
