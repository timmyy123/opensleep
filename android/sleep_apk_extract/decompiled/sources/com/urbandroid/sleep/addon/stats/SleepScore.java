package com.urbandroid.sleep.addon.stats;

import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.model.Measure;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class SleepScore {
    private float durationLimitFrom;
    private float durationLimitTo;
    private int maxScore;
    private int measurePercentageCount;
    private float measurePercentageSum;
    private final Map<ScoreMeasure, ScoreResult> measureScoreMap;
    private int score;

    public static class ScoreResult {
        public Type color;
        public int progress;

        public enum Type {
            POSITIVE,
            NEGATIVE,
            NEUTRAL
        }

        public float progressFloat() {
            return this.progress / 100.0f;
        }
    }

    public SleepScore() {
        this.durationLimitFrom = 410.0f;
        this.durationLimitTo = 540.0f;
        this.measureScoreMap = new LinkedHashMap();
        this.score = -1;
        this.measurePercentageSum = -1.0f;
        this.measurePercentageCount = 0;
        this.maxScore = 0;
    }

    public float getDurationLimitFrom() {
        return this.durationLimitFrom;
    }

    public float getDurationLimitTo() {
        return this.durationLimitTo;
    }

    public Map<ScoreMeasure, ScoreResult> getMeasureScoreMap() {
        return this.measureScoreMap;
    }

    public int getScore() {
        return this.score;
    }

    public int getScoreMax() {
        return Math.max(this.maxScore, 3);
    }

    public float getScorePercentage() {
        Map<ScoreMeasure, ScoreResult> map = this.measureScoreMap;
        ArrayList arrayList = new ArrayList();
        Iterator<ScoreResult> it = map.values().iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(it.next().progressFloat()));
        }
        Collections.sort(arrayList);
        int iMin = Math.min(arrayList.size(), 3);
        float fFloatValue = 0.0f;
        for (int i = 0; i < iMin; i++) {
            fFloatValue += ((Float) arrayList.get(i)).floatValue();
        }
        float f = fFloatValue / iMin;
        if (Float.isNaN(f)) {
            return 0.0f;
        }
        return f;
    }

    public void setAge(int i) {
        if (i <= 0) {
            return;
        }
        if (i >= 6 && i <= 13) {
            this.durationLimitFrom = 540.0f;
            this.durationLimitTo = 720.0f;
        }
        if (i >= 14 && i <= 17) {
            this.durationLimitFrom = 480.0f;
            this.durationLimitTo = 660.0f;
        }
        if (i >= 18 && i <= 25) {
            this.durationLimitFrom = 420.0f;
            this.durationLimitTo = 600.0f;
        }
        if (i >= 65) {
            this.durationLimitFrom = 360.0f;
            this.durationLimitTo = 600.0f;
        }
    }

    public ScoreResult updateMeasure(ScoreMeasure scoreMeasure, float f) {
        ScoreResult scoreResult = new ScoreResult();
        ScoreMeasure scoreMeasure2 = ScoreMeasure.DURATION;
        if (scoreMeasure == scoreMeasure2) {
            scoreMeasure.setLimitPositive(this.durationLimitFrom);
            scoreMeasure.setLimitNegative(this.durationLimitTo);
        }
        if (this.score == -1) {
            this.score = 0;
        }
        this.maxScore++;
        Boolean bool = scoreMeasure.max;
        if (bool == null) {
            float f2 = scoreMeasure.limitPositive;
            if (f >= f2 && f <= scoreMeasure.limitNegative) {
                this.score++;
            }
            if (scoreMeasure == scoreMeasure2) {
                scoreResult.progress = Math.max(Math.min(Math.round((f / SharedApplicationContext.getSettings().getIdealSleepMinutes()) * 100.0f), 100), 0);
                scoreResult.color = (f >= scoreMeasure.limitPositive && f <= scoreMeasure.limitNegative) ? ScoreResult.Type.POSITIVE : ScoreResult.Type.NEGATIVE;
            } else {
                if (f < f2) {
                    scoreResult.progress = Math.max(Math.min(Math.round((f / f2) * 100.0f), 100), 0);
                } else {
                    float f3 = scoreMeasure.limitNegative;
                    if (f > f3) {
                        scoreResult.progress = Math.max(Math.min(Math.round((2.0f - (f / f3)) * 100.0f), 100), 0);
                    } else {
                        scoreResult.progress = 100;
                    }
                }
                double d = f;
                scoreResult.color = (d >= ((double) scoreMeasure.limitPositive) * 0.75d && d <= ((double) scoreMeasure.limitNegative) * 1.25d) ? ScoreResult.Type.POSITIVE : ScoreResult.Type.NEGATIVE;
            }
            StringBuilder sb = new StringBuilder("Score: ");
            sb.append(scoreMeasure);
            sb.append(" = ");
            sb.append(f);
            sb.append(" type ");
            sb.append(scoreResult.color);
            sb.append(" progress ");
            zza$$ExternalSyntheticOutline0.m(sb, scoreResult.progress);
        } else {
            boolean zBooleanValue = bool.booleanValue();
            float f4 = scoreMeasure.limitPositive;
            if (zBooleanValue) {
                float f5 = scoreMeasure.limitNegative / 2.0f;
                scoreResult.progress = (int) Math.max(Math.min(Math.round(((f - f5) * 100.0f) / (f4 - f5)), 100L), 0L);
                float f6 = scoreMeasure.limitPositive;
                if (f >= f6) {
                    this.score++;
                }
                scoreResult.color = f < scoreMeasure.limitNegative ? ScoreResult.Type.NEGATIVE : f > f6 ? ScoreResult.Type.POSITIVE : ScoreResult.Type.NEUTRAL;
                StringBuilder sb2 = new StringBuilder("Score: ");
                sb2.append(scoreMeasure);
                sb2.append("(");
                sb2.append(f5);
                sb2.append(" - ");
                sb2.append(f4);
                sb2.append(") = ");
                sb2.append(f);
                sb2.append(" type ");
                sb2.append(scoreResult.color);
                sb2.append(" progress ");
                zza$$ExternalSyntheticOutline0.m(sb2, scoreResult.progress);
            } else {
                float f7 = scoreMeasure.limitNegative * 2.0f;
                scoreResult.progress = (int) Math.max(Math.min(Math.round(((f7 - f) * 100.0f) / (f7 - f4)), 100L), 0L);
                float f8 = scoreMeasure.limitPositive;
                if (f <= f8) {
                    this.score++;
                }
                scoreResult.color = f > scoreMeasure.limitNegative ? ScoreResult.Type.NEGATIVE : f < f8 ? ScoreResult.Type.POSITIVE : ScoreResult.Type.NEUTRAL;
                StringBuilder sb3 = new StringBuilder("Score: ");
                sb3.append(scoreMeasure);
                sb3.append("(");
                sb3.append(f4);
                sb3.append(" - ");
                sb3.append(f7);
                sb3.append(") = ");
                sb3.append(f);
                sb3.append(" type ");
                sb3.append(scoreResult.color);
                sb3.append(" progress ");
                zza$$ExternalSyntheticOutline0.m(sb3, scoreResult.progress);
            }
        }
        this.measureScoreMap.put(scoreMeasure, scoreResult);
        return scoreResult;
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'IRREGULARITY' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class ScoreMeasure {
        private static final /* synthetic */ ScoreMeasure[] $VALUES;
        public static final ScoreMeasure DEEP_SLEEP;
        public static final ScoreMeasure EFFICIENCY;
        public static final ScoreMeasure HR;
        public static final ScoreMeasure HRV;
        public static final ScoreMeasure IRREGULARITY;
        public static final ScoreMeasure RATING;
        public static final ScoreMeasure RDI;
        public static final ScoreMeasure SNORE;
        private int color;
        private int colorScore;
        private int icon;
        private int iconWhite;
        private int label;
        public float limitNegative;
        public float limitPositive;
        public Boolean max;
        private Measure measure;
        public static final ScoreMeasure SCORE = new ScoreMeasure("SCORE", 0, Measure.SCORE, R.drawable.ic_star_outline, R.drawable.ic_star_outline_white, 80.0f, 30.0f, R.string.score, R.color.tint, R.color.tint);
        public static final ScoreMeasure DURATION = new ScoreMeasure("DURATION", 1, Measure.DURATION, R.drawable.ic_timer, R.drawable.ic_timer_white, 410.0f, 540.0f, R.string.stats_caption_sleep, R.color.tint, R.color.tint);

        private static /* synthetic */ ScoreMeasure[] $values() {
            return new ScoreMeasure[]{SCORE, DURATION, IRREGULARITY, DEEP_SLEEP, EFFICIENCY, SNORE, RATING, HR, HRV, RDI};
        }

        static {
            Measure measure = Measure.IRREGULARITY;
            Boolean bool = Boolean.TRUE;
            IRREGULARITY = new ScoreMeasure("IRREGULARITY", 2, measure, R.drawable.ic_action_irregularity, R.drawable.ic_action_irregularity_white, bool, 0.9f, 0.75f, R.string.sleep_variance, R.color.irregularity, R.color.irregularity_score);
            DEEP_SLEEP = new ScoreMeasure("DEEP_SLEEP", 3, Measure.DEEP_SLEEP, R.drawable.ic_action_track, R.drawable.ic_action_track_white, bool, 0.2f, 0.1f, R.string.label_deep_sleep, R.color.score_deep_sleep, R.color.score_deep_sleep_score);
            EFFICIENCY = new ScoreMeasure("EFFICIENCY", 4, Measure.EFFICIENCY, R.drawable.ic_eye, R.drawable.ic_eye_white, bool, 0.95f, 0.85f, R.string.sleep_efficiency, R.color.efficiency, R.color.efficiency_score);
            Measure measure2 = Measure.SNORING_SCORE;
            Boolean bool2 = Boolean.FALSE;
            SNORE = new ScoreMeasure("SNORE", 5, measure2, R.drawable.ic_action_noise, R.drawable.ic_action_noise_white, bool2, 0.04f, 0.1f, R.string.stats_caption_snore, R.color.snore, R.color.snore_score);
            RATING = new ScoreMeasure("RATING", 6, Measure.RATING, R.drawable.ic_star_outline, R.drawable.ic_star_outline_white, bool, 3.8f, 2.5f, R.string.axis_rating, R.color.rating, R.color.rating_score);
            HR = new ScoreMeasure("HR", 7, Measure.HR, R.drawable.ic_action_love, R.drawable.ic_action_love_white, null, 35.0f, 55.0f, R.string.hr_short, R.color.hr, R.color.hr_score);
            HRV = new ScoreMeasure("HRV", 8, Measure.HRV_GAIN, R.drawable.ic_action_hrv, R.drawable.ic_action_hrv_white, bool, 2.0f, -5.0f, R.string.hrv_gain, R.color.hrv, R.color.hrv_score);
            RDI = new ScoreMeasure("RDI", 9, Measure.RDI, R.drawable.ic_action_cpap, R.drawable.ic_action_cpap_white, bool2, 10.0f, 20.0f, R.string.respiration, R.color.rdi, R.color.rdi_score);
            $VALUES = $values();
        }

        private ScoreMeasure(String str, int i, Measure measure, int i2, int i3, float f, float f2, int i4, int i5, int i6) {
            this(str, i, measure, i2, i3, null, f, f2, i4, i5, i6);
        }

        public static ScoreMeasure valueOf(String str) {
            return (ScoreMeasure) Enum.valueOf(ScoreMeasure.class, str);
        }

        public static ScoreMeasure[] values() {
            return (ScoreMeasure[]) $VALUES.clone();
        }

        public int getColor() {
            return this.color;
        }

        public int getColorScore() {
            return this.colorScore;
        }

        public String getEnglishNamesForAi() {
            return this == DURATION ? "Sleep duration" : this == DEEP_SLEEP ? "Deep sleep - percentage of the night I spend in deep sleep - " : this == EFFICIENCY ? "Efficiency which means percentage of the night I'm really sleeping and not being awake " : this == IRREGULARITY ? "Regularity of my sleep " : this == RATING ? "My subjective rating of sleep expressed with number of stars out a maximum of 5 " : this == HRV ? "Heart rate variability aka HRV increase in late sleep " : this == HR ? "Resting heart rate aka HR during sleep " : this == RDI ? "Respiratory disturbance aka RDI " : this == SNORE ? "Percentage of my sleep I have spend snoring " : name().toLowerCase();
        }

        public int getIcon() {
            return this.icon;
        }

        public int getIconWhite() {
            return this.iconWhite;
        }

        public int getLabel() {
            return this.label;
        }

        public Measure getMeasure() {
            return this.measure;
        }

        public void setLimitNegative(float f) {
            this.limitNegative = f;
        }

        public void setLimitPositive(float f) {
            this.limitPositive = f;
        }

        private ScoreMeasure(String str, int i, Measure measure, int i2, int i3, Boolean bool, float f, float f2, int i4, int i5, int i6) {
            this.max = bool;
            this.limitPositive = f;
            this.limitNegative = f2;
            this.label = i4;
            this.color = i5;
            this.icon = i2;
            this.iconWhite = i3;
            this.measure = measure;
            this.colorScore = i6;
        }
    }

    public SleepScore(int i, int i2) {
        this.durationLimitFrom = 410.0f;
        this.durationLimitTo = 540.0f;
        this.measureScoreMap = new LinkedHashMap();
        this.measurePercentageSum = -1.0f;
        this.measurePercentageCount = 0;
        this.score = i;
        this.maxScore = i2;
    }
}
