package com.urbandroid.sleep.service.health.session.filter;

import com.urbandroid.sleep.service.health.session.HealthSession;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes5.dex */
public abstract class ActivityTypeFilter implements HealthSessionFilter {
    public static final ActivityTypeFilter SPORT = new AnonymousClass1();
    public static final ActivityTypeFilter WALKING = new AnonymousClass2();
    public static final ActivityTypeFilter SLEEP = new AnonymousClass3();
    private static final /* synthetic */ ActivityTypeFilter[] $VALUES = $values();

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.health.session.filter.ActivityTypeFilter$1, reason: invalid class name */
    public enum AnonymousClass1 extends ActivityTypeFilter {
        public /* synthetic */ AnonymousClass1() {
            this("SPORT", 0);
        }

        @Override // com.urbandroid.sleep.service.health.session.filter.HealthSessionFilter
        public boolean accept(HealthSession healthSession) {
            return healthSession.isSportActivity();
        }

        private AnonymousClass1(String str, int i) {
            super(str, i, 0);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.health.session.filter.ActivityTypeFilter$2, reason: invalid class name */
    public enum AnonymousClass2 extends ActivityTypeFilter {
        public /* synthetic */ AnonymousClass2() {
            this("WALKING", 1);
        }

        @Override // com.urbandroid.sleep.service.health.session.filter.HealthSessionFilter
        public boolean accept(HealthSession healthSession) {
            return healthSession.isWalkingActivity();
        }

        private AnonymousClass2(String str, int i) {
            super(str, i, 0);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.health.session.filter.ActivityTypeFilter$3, reason: invalid class name */
    public enum AnonymousClass3 extends ActivityTypeFilter {
        public /* synthetic */ AnonymousClass3() {
            this("SLEEP", 2);
        }

        @Override // com.urbandroid.sleep.service.health.session.filter.HealthSessionFilter
        public boolean accept(HealthSession healthSession) {
            return healthSession.isSleepActivity();
        }

        private AnonymousClass3(String str, int i) {
            super(str, i, 0);
        }
    }

    private static /* synthetic */ ActivityTypeFilter[] $values() {
        return new ActivityTypeFilter[]{SPORT, WALKING, SLEEP};
    }

    public /* synthetic */ ActivityTypeFilter(String str, int i, int i2) {
        this(str, i);
    }

    public static ActivityTypeFilter valueOf(String str) {
        return (ActivityTypeFilter) Enum.valueOf(ActivityTypeFilter.class, str);
    }

    public static ActivityTypeFilter[] values() {
        return (ActivityTypeFilter[]) $VALUES.clone();
    }

    private ActivityTypeFilter(String str, int i) {
    }
}
