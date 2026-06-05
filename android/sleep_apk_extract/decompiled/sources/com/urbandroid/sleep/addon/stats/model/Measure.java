package com.urbandroid.sleep.addon.stats.model;

import android.content.Context;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.SleepScore;
import com.urbandroid.sleep.addon.stats.model.extractor.AwakeExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.AwakeMinutesToHourExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.CyclesExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.DeepSleepExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.DeepSleepFloatExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.DeepSleepLengthExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.DeficitExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.DeficitMinutesToHourExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.DurationExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.DurationMinutesToHourExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.EfficiencyExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.EfficiencyPercentageExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.HrExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.HrvAfterExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.HrvExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.HrvGainExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.IrregularityMinutesToHourExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.MinHrExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.NoiseLevelExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.RatingExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.RatingStarExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.RdiExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.RegularityIndexExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.SnoringMinutesToHourExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.SnoringPercentageFloatExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.StaticValueExtractor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes4.dex */
public abstract class Measure implements IMeasure {
    private static final /* synthetic */ Measure[] $VALUES;
    public static Measure[] ALL_MEASURES;
    public static Measure[] ALL_TWITTER;
    public static Measure[] ALL_WIDGET;
    public static final Measure AWAKE;
    public static final Measure CYCLES;
    public static final Measure DEEP_SLEEP;
    public static final Measure DURATION;
    public static final Measure EFFICIENCY;
    public static final Measure EFFICIENCY_PERCENTAGE;
    public static final Measure HR;
    public static final Measure HRV;
    public static final Measure HRV_GAIN;
    public static final Measure IRREGULARITY;
    public static final Measure LENGTH;
    public static final Measure MIN_HR;
    public static final Measure NOISE_LEVEL;
    public static final Measure QUALITY = new AnonymousClass1();
    public static final Measure RATING;
    public static final Measure RATING_PERCENT;
    public static final Measure RDI;
    public static final Measure SCORE;
    public static final Measure SNORING;
    public static final Measure SNORING_SCORE;
    private final boolean isWeighted;

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.stats.model.Measure$1, reason: invalid class name */
    public enum AnonymousClass1 extends Measure {
        public /* synthetic */ AnonymousClass1() {
            this("QUALITY", 0, true);
        }

        @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
        public IValueExtractor getExtractor(Context context) {
            return new DeepSleepExtractor(context);
        }

        @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
        public IValueExtractor getSecondaryExtractor(Context context) {
            return new DeepSleepLengthExtractor(context);
        }

        private AnonymousClass1(String str, int i, boolean z) {
            super(str, i, z, 0);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.stats.model.Measure$10, reason: invalid class name */
    public enum AnonymousClass10 extends Measure {
        public /* synthetic */ AnonymousClass10() {
            this("NOISE_LEVEL", 9, true);
        }

        @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
        public IValueExtractor getExtractor(Context context) {
            return new NoiseLevelExtractor(context);
        }

        @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
        public IValueExtractor getSecondaryExtractor(Context context) {
            return null;
        }

        private AnonymousClass10(String str, int i, boolean z) {
            super(str, i, z, 0);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.stats.model.Measure$11, reason: invalid class name */
    public enum AnonymousClass11 extends Measure {
        public /* synthetic */ AnonymousClass11() {
            this("CYCLES", 10);
        }

        @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
        public IValueExtractor getExtractor(Context context) {
            return new CyclesExtractor(context);
        }

        @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
        public IValueExtractor getSecondaryExtractor(Context context) {
            return null;
        }

        private AnonymousClass11(String str, int i) {
            super(str, i, 0);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.stats.model.Measure$12, reason: invalid class name */
    public enum AnonymousClass12 extends Measure {
        public /* synthetic */ AnonymousClass12() {
            this("AWAKE", 11);
        }

        @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
        public IValueExtractor getExtractor(Context context) {
            return new AwakeExtractor(context);
        }

        @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
        public IValueExtractor getSecondaryExtractor(Context context) {
            return null;
        }

        private AnonymousClass12(String str, int i) {
            super(str, i, 0);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.stats.model.Measure$13, reason: invalid class name */
    public enum AnonymousClass13 extends Measure {
        public /* synthetic */ AnonymousClass13() {
            this("EFFICIENCY", 12);
        }

        @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
        public IValueExtractor getExtractor(Context context) {
            return new EfficiencyExtractor(context);
        }

        @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
        public IValueExtractor getSecondaryExtractor(Context context) {
            return new AwakeMinutesToHourExtractor(context);
        }

        private AnonymousClass13(String str, int i) {
            super(str, i, 0);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.stats.model.Measure$14, reason: invalid class name */
    public enum AnonymousClass14 extends Measure {
        public /* synthetic */ AnonymousClass14() {
            this("EFFICIENCY_PERCENTAGE", 13);
        }

        @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
        public IValueExtractor getExtractor(Context context) {
            return new EfficiencyPercentageExtractor(context);
        }

        @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
        public IValueExtractor getSecondaryExtractor(Context context) {
            return new AwakeMinutesToHourExtractor(context);
        }

        private AnonymousClass14(String str, int i) {
            super(str, i, 0);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.stats.model.Measure$15, reason: invalid class name */
    public enum AnonymousClass15 extends Measure {
        public /* synthetic */ AnonymousClass15() {
            this("HR", 14);
        }

        @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
        public IValueExtractor getExtractor(Context context) {
            return new HrExtractor(context);
        }

        @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
        public IValueExtractor getSecondaryExtractor(Context context) {
            return new MinHrExtractor(context);
        }

        private AnonymousClass15(String str, int i) {
            super(str, i, 0);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.stats.model.Measure$16, reason: invalid class name */
    public enum AnonymousClass16 extends Measure {
        public /* synthetic */ AnonymousClass16() {
            this("MIN_HR", 15);
        }

        @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
        public IValueExtractor getExtractor(Context context) {
            return new MinHrExtractor(context);
        }

        @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
        public IValueExtractor getSecondaryExtractor(Context context) {
            return null;
        }

        private AnonymousClass16(String str, int i) {
            super(str, i, 0);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.stats.model.Measure$17, reason: invalid class name */
    public enum AnonymousClass17 extends Measure {
        public /* synthetic */ AnonymousClass17() {
            this("HRV", 16);
        }

        @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
        public IValueExtractor getExtractor(Context context) {
            return new HrvExtractor(context);
        }

        @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
        public IValueExtractor getSecondaryExtractor(Context context) {
            return null;
        }

        private AnonymousClass17(String str, int i) {
            super(str, i, 0);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.stats.model.Measure$18, reason: invalid class name */
    public enum AnonymousClass18 extends Measure {
        public /* synthetic */ AnonymousClass18() {
            this("HRV_GAIN", 17);
        }

        @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
        public IValueExtractor getExtractor(Context context) {
            return new HrvGainExtractor(context);
        }

        @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
        public IValueExtractor getSecondaryExtractor(Context context) {
            return new HrvAfterExtractor(context);
        }

        private AnonymousClass18(String str, int i) {
            super(str, i, 0);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.stats.model.Measure$19, reason: invalid class name */
    public enum AnonymousClass19 extends Measure {
        public /* synthetic */ AnonymousClass19() {
            this("RDI", 18);
        }

        @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
        public IValueExtractor getExtractor(Context context) {
            return new RdiExtractor(context);
        }

        @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
        public IValueExtractor getSecondaryExtractor(Context context) {
            return null;
        }

        private AnonymousClass19(String str, int i) {
            super(str, i, 0);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.stats.model.Measure$2, reason: invalid class name */
    public enum AnonymousClass2 extends Measure {
        public /* synthetic */ AnonymousClass2() {
            this("DEEP_SLEEP", 1, true);
        }

        @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
        public IValueExtractor getExtractor(Context context) {
            return new DeepSleepFloatExtractor(context);
        }

        @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
        public IValueExtractor getSecondaryExtractor(Context context) {
            return new DeepSleepLengthExtractor(context);
        }

        private AnonymousClass2(String str, int i, boolean z) {
            super(str, i, z, 0);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.stats.model.Measure$20, reason: invalid class name */
    public enum AnonymousClass20 extends Measure {
        public /* synthetic */ AnonymousClass20() {
            this("IRREGULARITY", 19);
        }

        @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
        public IValueExtractor getExtractor(Context context) {
            return new RegularityIndexExtractor(context);
        }

        @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
        public IValueExtractor getSecondaryExtractor(Context context) {
            return new IrregularityMinutesToHourExtractor(context);
        }

        private AnonymousClass20(String str, int i) {
            super(str, i, 0);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.stats.model.Measure$3, reason: invalid class name */
    public enum AnonymousClass3 extends Measure {
        public /* synthetic */ AnonymousClass3() {
            this("LENGTH", 2);
        }

        @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
        public IValueExtractor getExtractor(Context context) {
            return new DurationExtractor(context);
        }

        @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
        public IValueExtractor getSecondaryExtractor(Context context) {
            return new DeficitExtractor(context);
        }

        private AnonymousClass3(String str, int i) {
            super(str, i, 0);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.stats.model.Measure$4, reason: invalid class name */
    public enum AnonymousClass4 extends Measure {
        public /* synthetic */ AnonymousClass4() {
            this("DURATION", 3);
        }

        @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
        public IValueExtractor getExtractor(Context context) {
            return new DurationMinutesToHourExtractor(context);
        }

        @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
        public IValueExtractor getSecondaryExtractor(Context context) {
            return new DeficitMinutesToHourExtractor(context);
        }

        private AnonymousClass4(String str, int i) {
            super(str, i, 0);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.stats.model.Measure$5, reason: invalid class name */
    public enum AnonymousClass5 extends Measure {
        public /* synthetic */ AnonymousClass5() {
            this("SCORE", 4);
        }

        @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
        public IValueExtractor getExtractor(Context context) {
            return null;
        }

        @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
        public IValueExtractor getSecondaryExtractor(Context context) {
            return null;
        }

        private AnonymousClass5(String str, int i) {
            super(str, i, 0);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.stats.model.Measure$6, reason: invalid class name */
    public enum AnonymousClass6 extends Measure {
        public /* synthetic */ AnonymousClass6() {
            this("RATING", 5, true);
        }

        @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
        public IValueExtractor getExtractor(Context context) {
            return new RatingStarExtractor(context);
        }

        @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
        public IValueExtractor getSecondaryExtractor(final Context context) {
            return new StaticValueExtractor("") { // from class: com.urbandroid.sleep.addon.stats.model.Measure.6.1
                @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
                public String getMeasureName() {
                    return context.getString(R.string.axis_rating);
                }

                @Override // com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor
                public double getValue(IMeasureRecord iMeasureRecord) {
                    return 1.0d;
                }
            };
        }

        private AnonymousClass6(String str, int i, boolean z) {
            super(str, i, z, 0);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.stats.model.Measure$7, reason: invalid class name */
    public enum AnonymousClass7 extends Measure {
        public /* synthetic */ AnonymousClass7() {
            this("RATING_PERCENT", 6, true);
        }

        @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
        public IValueExtractor getExtractor(Context context) {
            return new RatingExtractor(context);
        }

        @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
        public IValueExtractor getSecondaryExtractor(Context context) {
            return null;
        }

        private AnonymousClass7(String str, int i, boolean z) {
            super(str, i, z, 0);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.stats.model.Measure$8, reason: invalid class name */
    public enum AnonymousClass8 extends Measure {
        public /* synthetic */ AnonymousClass8() {
            this("SNORING", 7);
        }

        @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
        public IValueExtractor getExtractor(Context context) {
            return new SnoringMinutesToHourExtractor(context);
        }

        @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
        public IValueExtractor getSecondaryExtractor(Context context) {
            return null;
        }

        private AnonymousClass8(String str, int i) {
            super(str, i, 0);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.addon.stats.model.Measure$9, reason: invalid class name */
    public enum AnonymousClass9 extends Measure {
        public /* synthetic */ AnonymousClass9() {
            this("SNORING_SCORE", 8);
        }

        @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
        public IValueExtractor getExtractor(Context context) {
            return new SnoringPercentageFloatExtractor(context);
        }

        @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
        public IValueExtractor getSecondaryExtractor(Context context) {
            return new SnoringMinutesToHourExtractor(context);
        }

        private AnonymousClass9(String str, int i) {
            super(str, i, 0);
        }
    }

    private static /* synthetic */ Measure[] $values() {
        return new Measure[]{QUALITY, DEEP_SLEEP, LENGTH, DURATION, SCORE, RATING, RATING_PERCENT, SNORING, SNORING_SCORE, NOISE_LEVEL, CYCLES, AWAKE, EFFICIENCY, EFFICIENCY_PERCENTAGE, HR, MIN_HR, HRV, HRV_GAIN, RDI, IRREGULARITY};
    }

    static {
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        DEEP_SLEEP = anonymousClass2;
        LENGTH = new AnonymousClass3();
        AnonymousClass4 anonymousClass4 = new AnonymousClass4();
        DURATION = anonymousClass4;
        SCORE = new AnonymousClass5();
        RATING = new AnonymousClass6();
        RATING_PERCENT = new AnonymousClass7();
        SNORING = new AnonymousClass8();
        AnonymousClass9 anonymousClass9 = new AnonymousClass9();
        SNORING_SCORE = anonymousClass9;
        NOISE_LEVEL = new AnonymousClass10();
        CYCLES = new AnonymousClass11();
        AWAKE = new AnonymousClass12();
        AnonymousClass13 anonymousClass13 = new AnonymousClass13();
        EFFICIENCY = anonymousClass13;
        EFFICIENCY_PERCENTAGE = new AnonymousClass14();
        AnonymousClass15 anonymousClass15 = new AnonymousClass15();
        HR = anonymousClass15;
        MIN_HR = new AnonymousClass16();
        HRV = new AnonymousClass17();
        AnonymousClass18 anonymousClass18 = new AnonymousClass18();
        HRV_GAIN = anonymousClass18;
        AnonymousClass19 anonymousClass19 = new AnonymousClass19();
        RDI = anonymousClass19;
        AnonymousClass20 anonymousClass20 = new AnonymousClass20();
        IRREGULARITY = anonymousClass20;
        $VALUES = $values();
        ALL_MEASURES = new Measure[]{anonymousClass4, anonymousClass2, anonymousClass20, anonymousClass13, anonymousClass9, anonymousClass15, anonymousClass18, anonymousClass19};
        ALL_WIDGET = new Measure[]{anonymousClass4, anonymousClass2, anonymousClass20, anonymousClass13, anonymousClass9};
        ALL_TWITTER = new Measure[]{anonymousClass4, anonymousClass2, anonymousClass20, anonymousClass13};
    }

    private Measure(String str, int i, boolean z) {
        this.isWeighted = z;
    }

    public static Measure valueOf(String str) {
        return (Measure) Enum.valueOf(Measure.class, str);
    }

    public static Measure[] values() {
        return (Measure[]) $VALUES.clone();
    }

    @Override // com.urbandroid.sleep.addon.stats.model.IMeasure
    public boolean isWeighted() {
        return this.isWeighted;
    }

    public SleepScore.ScoreMeasure mapToScoreMeasure() {
        int iOrdinal = ordinal();
        if (iOrdinal == 1) {
            return SleepScore.ScoreMeasure.DEEP_SLEEP;
        }
        if (iOrdinal == 8) {
            return SleepScore.ScoreMeasure.SNORE;
        }
        if (iOrdinal == 12) {
            return SleepScore.ScoreMeasure.EFFICIENCY;
        }
        if (iOrdinal == 14) {
            return SleepScore.ScoreMeasure.HR;
        }
        if (iOrdinal == 3) {
            return SleepScore.ScoreMeasure.DURATION;
        }
        if (iOrdinal == 4) {
            return SleepScore.ScoreMeasure.SCORE;
        }
        if (iOrdinal == 5) {
            return SleepScore.ScoreMeasure.RATING;
        }
        switch (iOrdinal) {
            case 17:
                return SleepScore.ScoreMeasure.HRV;
            case 18:
                return SleepScore.ScoreMeasure.RDI;
            case 19:
                return SleepScore.ScoreMeasure.IRREGULARITY;
            default:
                return null;
        }
    }

    public /* synthetic */ Measure(String str, int i, boolean z, int i2) {
        this(str, i, z);
    }

    private Measure(String str, int i) {
        this(str, i, false);
    }

    public /* synthetic */ Measure(String str, int i, int i2) {
        this(str, i);
    }
}
