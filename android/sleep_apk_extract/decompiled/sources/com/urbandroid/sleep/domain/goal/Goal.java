package com.urbandroid.sleep.domain.goal;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.addon.stats.model.StatRepo;
import com.urbandroid.sleep.addon.stats.model.aggregator.IListAggregator;
import com.urbandroid.sleep.addon.stats.model.aggregator.MeasureAverageAggregator;
import com.urbandroid.sleep.addon.stats.model.aggregator.MeasureListAggregator;
import com.urbandroid.sleep.addon.stats.model.aggregator.SleepIrregularityMeasureAggregator;
import com.urbandroid.sleep.addon.stats.model.extractor.AwakeExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.BedtimeHourExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.DeepSleepLengthExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.DurationExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.IrregularityExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.RegularityIndexGoalExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.SnoozeExtractor;
import com.urbandroid.sleep.addon.stats.model.extractor.SnoringExtractor;
import com.urbandroid.sleep.domain.achievement.Achievement;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import org.achartengine.chart.TimeChart;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b)\u0018\u0000 a2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0003bcaBo\b\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0013\u0010\u0014B-\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0015J\r\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u0004\u0018\u00010\f¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\"\u0010#J\r\u0010%\u001a\u00020$¢\u0006\u0004\b%\u0010&J\r\u0010'\u001a\u00020$¢\u0006\u0004\b'\u0010&J\r\u0010(\u001a\u00020$¢\u0006\u0004\b(\u0010&J\r\u0010)\u001a\u00020$¢\u0006\u0004\b)\u0010&J\u000f\u0010*\u001a\u00020\fH\u0016¢\u0006\u0004\b*\u0010!J\u0018\u0010-\u001a\u00020,2\u0006\u0010+\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b-\u0010.J\u001a\u00100\u001a\u00020$2\b\u0010+\u001a\u0004\u0018\u00010/H\u0096\u0002¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020,H\u0016¢\u0006\u0004\b2\u00103J\u0015\u00105\u001a\u00020,2\u0006\u00104\u001a\u00020\u0007¢\u0006\u0004\b5\u00106J\u0017\u00109\u001a\u00020\u00022\b\u00108\u001a\u0004\u0018\u000107¢\u0006\u0004\b9\u0010:J\u0015\u0010=\u001a\u00020\f2\u0006\u0010<\u001a\u00020;¢\u0006\u0004\b=\u0010>J\r\u0010?\u001a\u00020$¢\u0006\u0004\b?\u0010&R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010@R\u0016\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010@R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010AR\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010BR\u0016\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010BR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010C\u001a\u0004\bD\u0010!\"\u0004\bE\u0010#R$\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010C\u001a\u0004\bF\u0010!\"\u0004\bG\u0010#R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010CR\u0016\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010HR\u0016\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010@R\u0016\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010@R\u0016\u0010\u0010\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010BR$\u0010J\u001a\u00020,2\u0006\u0010I\u001a\u00020,8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u00103R$\u0010\u001a\u001a\u00020\u00022\u0006\u0010M\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bN\u0010O\"\u0004\bP\u0010\u001fR\u0011\u0010R\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bQ\u0010OR\u0011\u0010T\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bS\u0010OR\u0011\u0010V\u001a\u00020,8F¢\u0006\u0006\u001a\u0004\bU\u00103R\u0011\u0010X\u001a\u00020,8F¢\u0006\u0006\u001a\u0004\bW\u00103R\u0011\u0010Z\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\bY\u0010OR\u0011\u0010\\\u001a\u00020,8F¢\u0006\u0006\u001a\u0004\b[\u00103R\u0011\u0010^\u001a\u00020,8F¢\u0006\u0006\u001a\u0004\b]\u00103R\u0011\u0010_\u001a\u00020,8F¢\u0006\u0006\u001a\u0004\b5\u00103R\u0011\u0010`\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b`\u0010&¨\u0006d"}, d2 = {"Lcom/urbandroid/sleep/domain/goal/Goal;", "", "", "base", "target", "Lcom/urbandroid/sleep/domain/goal/Goal$Type;", "type", "", "startTime", SDKConstants.PARAM_END_TIME, "Lcom/urbandroid/sleep/domain/goal/Goal$Status;", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "", "subscriptionId", "subscriptionToken", "current", "lastUpdate", "nextTarget", "orderId", "<init>", "(DDLcom/urbandroid/sleep/domain/goal/Goal$Type;JJLcom/urbandroid/sleep/domain/goal/Goal$Status;Ljava/lang/String;Ljava/lang/String;DJDLjava/lang/String;)V", "(DLcom/urbandroid/sleep/domain/goal/Goal$Type;JJ)V", "", "setDurationWeek", "()V", "setDurationMonth", "percentage", "calculateTarget", "(D)D", "rollbackTarget", "validateAndFix", "(D)V", "getOrderId", "()Ljava/lang/String;", "setOrderId", "(Ljava/lang/String;)V", "", "updateStatus", "()Z", "didSucceedNow", "canRefund", "completedPreliminarily", InAppPurchaseConstants.METHOD_TO_STRING, "o", "", "compareTo", "(Lcom/urbandroid/sleep/domain/goal/Goal;)I", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "time", "getProgressDays", "(J)I", "Ljava/util/Date;", "day", "getProgressWholeDays", "(Ljava/util/Date;)D", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "getGoalTitle", "(Landroid/content/Context;)Ljava/lang/String;", "hasMotivationFee", "D", "Lcom/urbandroid/sleep/domain/goal/Goal$Type;", "J", "Ljava/lang/String;", "getSubscriptionId", "setSubscriptionId", "getSubscriptionToken", "setSubscriptionToken", "Lcom/urbandroid/sleep/domain/goal/Goal$Status;", SDKConstants.PARAM_VALUE, "mode", "I", "getMode", "p", "getPercentage", "()D", "setPercentage", "getProgress", "progress", "getTimeProgress", "timeProgress", "getTimeProgressInt", "timeProgressInt", "getTimeProgressDays", "timeProgressDays", "getTimeProgressDaysDouble", "timeProgressDaysDouble", "getProgressInt", "progressInt", "getGoalDays", "goalDays", "progressDays", "isInApp", "Companion", "Status", "Type", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class Goal implements Comparable<Goal> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public double base;
    public double current;
    public long endTime;
    public long lastUpdate;
    private int mode;
    public double nextTarget;
    private String orderId;
    public long startTime;
    public Status status;
    private String subscriptionId;
    private String subscriptionToken;
    public double target;
    public Type type;

    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0013J)\u0010\u0016\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u0018\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0018\u0010\u0017J)\u0010\u0019\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0019\u0010\u0017J\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010\u001e\u001a\u00020\u001d2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ#\u0010 \u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0004\b \u0010!J3\u0010%\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0015\u001a\u00020\u00142\u0010\u0010$\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\"H\u0007¢\u0006\u0004\b%\u0010&J\u001d\u0010'\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b'\u0010(J7\u0010-\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0010\u0010$\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\"2\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b-\u0010.JA\u0010/\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010\u0015\u001a\u00020\u00142\u0010\u0010$\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\"2\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010,\u001a\u00020+H\u0007¢\u0006\u0004\b/\u00100J=\u00101\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010\u0015\u001a\u00020\u00142\u0010\u0010$\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\"2\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b1\u00100J\u001d\u00102\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b2\u0010(J\u0015\u00103\u001a\u00020+2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b3\u00104J\u0015\u00105\u001a\u00020+2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b5\u00104J\u0015\u00107\u001a\u0002062\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b7\u00108R\u0014\u00109\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010;\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b;\u0010:R\u0014\u0010<\u001a\u00020+8\u0006X\u0086T¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010>\u001a\u00020+8\u0006X\u0086T¢\u0006\u0006\n\u0004\b>\u0010=¨\u0006?"}, d2 = {"Lcom/urbandroid/sleep/domain/goal/Goal$Companion;", "", "<init>", "()V", "Lcom/urbandroid/sleep/addon/stats/model/extractor/IValueExtractor;", "extractor", "", SDKConstants.PARAM_VALUE, "", "unit", "", "formatMeasure", "(Lcom/urbandroid/sleep/addon/stats/model/extractor/IValueExtractor;DZ)Ljava/lang/String;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/urbandroid/sleep/domain/goal/Goal$Type;", "type", "getGoalTitle", "(Landroid/content/Context;Lcom/urbandroid/sleep/domain/goal/Goal$Type;)Ljava/lang/String;", "(Landroid/content/Context;Lcom/urbandroid/sleep/addon/stats/model/extractor/IValueExtractor;)Ljava/lang/String;", "Lcom/urbandroid/sleep/domain/goal/Goal;", "goal", "getBaseFormatted", "(Landroid/content/Context;Lcom/urbandroid/sleep/domain/goal/Goal;Z)Ljava/lang/String;", "getProgressFormatted", "getTargetFormatted", "serialized", "fromSerialized", "(Ljava/lang/String;)Lcom/urbandroid/sleep/domain/goal/Goal;", "Lcom/urbandroid/sleep/addon/stats/model/aggregator/IListAggregator;", "createAggregator", "(Landroid/content/Context;Lcom/urbandroid/sleep/domain/goal/Goal$Type;)Lcom/urbandroid/sleep/addon/stats/model/aggregator/IListAggregator;", "createExtractor", "(Landroid/content/Context;Lcom/urbandroid/sleep/domain/goal/Goal$Type;)Lcom/urbandroid/sleep/addon/stats/model/extractor/IValueExtractor;", "", "Lcom/urbandroid/sleep/addon/stats/model/StatRecord;", "records", "getNextTarget", "(Landroid/content/Context;Lcom/urbandroid/sleep/domain/goal/Goal;Ljava/util/List;)D", "getNextTargetString", "(Landroid/content/Context;Lcom/urbandroid/sleep/domain/goal/Goal;)Ljava/lang/String;", "Ljava/util/Date;", "toDay", "", "days", "filterGoalRecordsIgnoreStart", "(Ljava/util/List;Ljava/util/Date;I)Ljava/util/List;", "filterGoalRecords", "(Lcom/urbandroid/sleep/domain/goal/Goal;Ljava/util/List;Ljava/util/Date;I)Ljava/util/List;", "filterGoalRecordsAfterGoalStart", "getGoalStateString", "getGoalIcon", "(Lcom/urbandroid/sleep/domain/goal/Goal$Type;)I", "getGoalFunnyName", "Lcom/urbandroid/sleep/domain/achievement/Achievement$Type;", "getAchievementMapping", "(Lcom/urbandroid/sleep/domain/goal/Goal$Type;)Lcom/urbandroid/sleep/domain/achievement/Achievement$Type;", "min_percentage_step", "D", "max_percentage", "DEFAULT_GOAL_DAYS", "I", "WEEK_GOAL_DAYS", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {

        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Type.values().length];
                try {
                    iArr[Type.IRREGULARITY.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Type.DURATION.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Type.SNORING.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Type.DEEP_SLEEP.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[Type.SNOOZE.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[Type.AWAKE.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[Type.FALL_ASLEEP_HOUR.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[Type.REGULARITY.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String formatMeasure(IValueExtractor extractor, double value, boolean unit) {
            return FileInsert$$ExternalSyntheticOutline0.m$1(extractor.getValuePresentation(value), unit ? FileInsert$$ExternalSyntheticOutline0.m(" ", extractor.getUnit()) : "");
        }

        public static /* synthetic */ String getBaseFormatted$default(Companion companion, Context context, Goal goal, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            return companion.getBaseFormatted(context, goal, z);
        }

        public static /* synthetic */ String getProgressFormatted$default(Companion companion, Context context, Goal goal, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            return companion.getProgressFormatted(context, goal, z);
        }

        public static /* synthetic */ String getTargetFormatted$default(Companion companion, Context context, Goal goal, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            return companion.getTargetFormatted(context, goal, z);
        }

        public final IListAggregator createAggregator(Context context, Type type) {
            return (type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) == 1 ? new MeasureListAggregator(new SleepIrregularityMeasureAggregator(null, null, context)) : new MeasureListAggregator(new MeasureAverageAggregator(createExtractor(context, type)));
        }

        public final IValueExtractor createExtractor(Context context, Type type) {
            switch (type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                case 1:
                    return new IrregularityExtractor(context);
                case 2:
                    return new DurationExtractor(context);
                case 3:
                    return new SnoringExtractor(context);
                case 4:
                    return new DeepSleepLengthExtractor(context);
                case 5:
                    return new SnoozeExtractor(context);
                case 6:
                    return new AwakeExtractor(context);
                case 7:
                    return new BedtimeHourExtractor(context);
                case 8:
                    return new RegularityIndexGoalExtractor(context);
                default:
                    return new DurationExtractor(context);
            }
        }

        public final List<StatRecord> filterGoalRecords(Goal goal, List<? extends StatRecord> records, Date toDay, int days) {
            goal.getClass();
            if (goal.type == Type.IRREGULARITY) {
                return filterGoalRecordsIgnoreStart(records, toDay, days);
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(toDay);
            calendar.add(5, 1);
            DateUtil.resetCalendarTimeDayStart(calendar);
            Date time = calendar.getTime();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(goal.startTime);
            calendar2.add(5, 1);
            DateUtil.resetCalendarTimeDayStart(calendar2);
            List<StatRecord> listFilterRecords = StatRepo.filterRecords(records, calendar2.getTime(), time);
            if (listFilterRecords.size() != 0) {
                return listFilterRecords;
            }
            calendar2.add(5, -(days + 2));
            DateUtil.resetCalendarTimeDayEnd(calendar2);
            List<StatRecord> listFilterRecords2 = StatRepo.filterRecords(records, calendar2.getTime(), time);
            listFilterRecords2.getClass();
            return listFilterRecords2;
        }

        public final List<StatRecord> filterGoalRecordsAfterGoalStart(Goal goal, List<? extends StatRecord> records, Date toDay, int days) {
            goal.getClass();
            toDay.getClass();
            if (goal.type == Type.IRREGULARITY) {
                return filterGoalRecordsIgnoreStart(records, toDay, days);
            }
            Logger.logInfo("Goal: before " + toDay);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(toDay);
            calendar.add(5, 1);
            DateUtil.resetCalendarTimeDayStart(calendar);
            Date time = calendar.getTime();
            Logger.logInfo("Goal: after " + time);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(goal.startTime);
            calendar2.add(5, 1);
            DateUtil.resetCalendarTimeDayStart(calendar2);
            Date time2 = calendar2.getTime();
            List<StatRecord> listFilterRecords = StatRepo.filterRecords(records, time2, time);
            int size = listFilterRecords.size();
            StringBuilder sb = new StringBuilder("Goal: RESULTS ");
            sb.append(time2);
            sb.append(" ");
            sb.append(time);
            sb.append(" ");
            zza$$ExternalSyntheticOutline0.m(sb, size);
            return listFilterRecords;
        }

        public final List<StatRecord> filterGoalRecordsIgnoreStart(List<? extends StatRecord> records, Date toDay, int days) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(toDay);
            calendar.add(5, 1);
            DateUtil.resetCalendarTimeDayStart(calendar);
            Date time = calendar.getTime();
            calendar.add(5, -(days + 2));
            DateUtil.resetCalendarTimeDayEnd(calendar);
            List<StatRecord> listFilterRecords = StatRepo.filterRecords(records, calendar.getTime(), time);
            listFilterRecords.getClass();
            return listFilterRecords;
        }

        public final Goal fromSerialized(String serialized) {
            List listEmptyList;
            if (serialized == null) {
                return null;
            }
            List<String> listSplit = new Regex(";;;").split(serialized, 0);
            if (listSplit.isEmpty()) {
                listEmptyList = CollectionsKt.emptyList();
            } else {
                ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
                while (listIterator.hasPrevious()) {
                    if (listIterator.previous().length() != 0) {
                        listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                        break;
                    }
                }
                listEmptyList = CollectionsKt.emptyList();
            }
            String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
            if (strArr.length == 9) {
                return new Goal(Double.parseDouble(strArr[0]), Double.parseDouble(strArr[1]), Type.valueOf(strArr[2]), Long.parseLong(strArr[3]), Long.parseLong(strArr[4]), Status.valueOf(strArr[5]), strArr[6], "", Double.parseDouble(strArr[7]), Long.parseLong(strArr[8]), 0.0d, null, 3072, null);
            }
            if (strArr.length == 10) {
                try {
                    return new Goal(Double.parseDouble(strArr[0]), Double.parseDouble(strArr[1]), Type.valueOf(strArr[2]), Long.parseLong(strArr[3]), Long.parseLong(strArr[4]), Status.valueOf(strArr[5]), strArr[6], strArr[7], Double.parseDouble(strArr[8]), Long.parseLong(strArr[9]), 0.0d, null, 3072, null);
                } catch (Exception e) {
                    Logger.logSevere(e);
                    return null;
                }
            }
            if (strArr.length == 11) {
                try {
                    return new Goal(Double.parseDouble(strArr[0]), Double.parseDouble(strArr[1]), Type.valueOf(strArr[2]), Long.parseLong(strArr[3]), Long.parseLong(strArr[4]), Status.valueOf(strArr[5]), strArr[6], strArr[7], Double.parseDouble(strArr[8]), Long.parseLong(strArr[9]), 0.0d, null, 3072, null);
                } catch (Exception e2) {
                    Logger.logSevere(e2);
                    return null;
                }
            }
            if (strArr.length != 12) {
                return null;
            }
            try {
                return new Goal(Double.parseDouble(strArr[0]), Double.parseDouble(strArr[1]), Type.valueOf(strArr[2]), Long.parseLong(strArr[3]), Long.parseLong(strArr[4]), Status.valueOf(strArr[5]), strArr[6], strArr[7], Double.parseDouble(strArr[8]), Long.parseLong(strArr[9]), Double.parseDouble(strArr[10]), strArr[11], null);
            } catch (Exception e3) {
                Logger.logSevere(e3);
                return null;
            }
        }

        public final Achievement.Type getAchievementMapping(Type type) {
            type.getClass();
            switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                case 1:
                    return Achievement.Type.GOAL_REGULARITY;
                case 2:
                    return Achievement.Type.GOAL_DURATION;
                case 3:
                    return Achievement.Type.GOAL_SNORING;
                case 4:
                    return Achievement.Type.GOAL_DEEP;
                case 5:
                    return Achievement.Type.GOAL_SNOOZE;
                case 6:
                    return Achievement.Type.GOAL_AWAKE;
                case 7:
                    return Achievement.Type.GOAL_BEDTIME;
                case 8:
                    return Achievement.Type.GOAL_REGULARITY;
                default:
                    Home$$ExternalSyntheticBUOutline0.m();
                    return null;
            }
        }

        public final String getBaseFormatted(Context context, Goal goal, boolean unit) {
            goal.getClass();
            return formatMeasure(createExtractor(context, goal.type), goal.base, unit);
        }

        public final int getGoalFunnyName(Type type) {
            type.getClass();
            switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                case 1:
                    return R.string.goal_regularity;
                case 2:
                    return R.string.goal_duration;
                case 3:
                    return R.string.goal_snoring;
                case 4:
                    return R.string.goal_deep_sleep;
                case 5:
                    return R.string.goal_snooze;
                case 6:
                    return R.string.goal_awake;
                case 7:
                    return R.string.goal_fall_asleep;
                case 8:
                    return R.string.goal_regularity;
                default:
                    Home$$ExternalSyntheticBUOutline0.m();
                    return 0;
            }
        }

        public final int getGoalIcon(Type type) {
            type.getClass();
            switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                case 1:
                    return R.drawable.ic_goal_regularity;
                case 2:
                    return R.drawable.ic_goal_duration;
                case 3:
                    return R.drawable.ic_goal_snoring;
                case 4:
                    return R.drawable.ic_lullaby_whale;
                case 5:
                    return R.drawable.ic_sound_cockoo;
                case 6:
                    return R.drawable.ic_goal_awake;
                case 7:
                    return R.drawable.ic_goal_bedtime;
                case 8:
                    return R.drawable.ic_goal_regularity;
                default:
                    Home$$ExternalSyntheticBUOutline0.m();
                    return 0;
            }
        }

        public final String getGoalStateString(Context context, Goal goal) {
            context.getClass();
            goal.getClass();
            StringBuilder sb = new StringBuilder();
            Status status = goal.status;
            if (status == Status.SUCCESS || status == Status.FAILED) {
                sb.append(context.getResources().getString(goal.status.getTextRes()));
                sb.append(" ");
            } else {
                sb.append(context.getResources().getString(R.string.days_left, Long.valueOf(Math.round((1.0d - goal.getProgressWholeDays(new Date())) * ((double) goal.getGoalDays())))));
            }
            return sb.toString();
        }

        public final String getGoalTitle(Context context, IValueExtractor extractor) {
            context.getClass();
            extractor.getClass();
            return Locale.GERMAN.getLanguage().equals(Locale.getDefault().getLanguage()) ? FileInsert$$ExternalSyntheticOutline0.m$1(extractor.getMeasureName(), " ", context.getString(R.string.improve)) : FileInsert$$ExternalSyntheticOutline0.m$1(context.getString(R.string.improve), " ", extractor.getMeasureName());
        }

        public final double getNextTarget(Context context, Goal goal, List<? extends StatRecord> records) {
            goal.getClass();
            Calendar.getInstance().add(5, 1);
            List<StatRecord> listFilterGoalRecordsAfterGoalStart = filterGoalRecordsAfterGoalStart(goal, records, new Date(), goal.getGoalDays());
            Iterator<T> it = listFilterGoalRecordsAfterGoalStart.iterator();
            double value = 0.0d;
            while (it.hasNext()) {
                value += Goal.INSTANCE.createExtractor(context, goal.type).getValue((StatRecord) it.next());
            }
            return (((double) (listFilterGoalRecordsAfterGoalStart.size() + 1)) * goal.target) - value;
        }

        public final String getNextTargetString(Context context, Goal goal) {
            context.getClass();
            goal.getClass();
            IValueExtractor iValueExtractorCreateExtractor = createExtractor(context, goal.type);
            iValueExtractorCreateExtractor.getClass();
            String measureName = iValueExtractorCreateExtractor.getMeasureName();
            measureName.getClass();
            Locale locale = Locale.getDefault();
            locale.getClass();
            String lowerCase = measureName.toLowerCase(locale);
            lowerCase.getClass();
            String valuePresentation = iValueExtractorCreateExtractor.getValuePresentation(goal.nextTarget);
            String unit = iValueExtractorCreateExtractor.getUnit();
            unit.getClass();
            Locale locale2 = Locale.getDefault();
            locale2.getClass();
            String lowerCase2 = unit.toLowerCase(locale2);
            lowerCase2.getClass();
            String string = context.getString(R.string.advice_goal_fullfill, lowerCase, FileInsert$$ExternalSyntheticOutline0.m$1(valuePresentation, " ", lowerCase2));
            string.getClass();
            return string;
        }

        public final String getProgressFormatted(Context context, Goal goal, boolean unit) {
            goal.getClass();
            return formatMeasure(createExtractor(context, goal.type), goal.current, unit);
        }

        public final String getTargetFormatted(Context context, Goal goal, boolean unit) {
            goal.getClass();
            return formatMeasure(createExtractor(context, goal.type), goal.target, unit);
        }

        private Companion() {
        }

        public final String getGoalTitle(Context context, Type type) {
            context.getClass();
            type.getClass();
            return getGoalTitle(context, createExtractor(context, type));
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\f"}, d2 = {"Lcom/urbandroid/sleep/domain/goal/Goal$Status;", "", "textRes", "", "<init>", "(Ljava/lang/String;II)V", "INITIAL", "IN_PROGRESS", "SUCCESS", "FAILED", "getTextRes", "()I", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Status {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Status[] $VALUES;
        private final int textRes;
        public static final Status INITIAL = new Status("INITIAL", 0, R.string.in_progress);
        public static final Status IN_PROGRESS = new Status("IN_PROGRESS", 1, R.string.in_progress);
        public static final Status SUCCESS = new Status("SUCCESS", 2, R.string.sucess);
        public static final Status FAILED = new Status("FAILED", 3, R.string.failed);

        private static final /* synthetic */ Status[] $values() {
            return new Status[]{INITIAL, IN_PROGRESS, SUCCESS, FAILED};
        }

        static {
            Status[] statusArr$values = $values();
            $VALUES = statusArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(statusArr$values);
        }

        private Status(String str, int i, int i2) {
            this.textRes = i2;
        }

        public static Status valueOf(String str) {
            return (Status) Enum.valueOf(Status.class, str);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }

        public final int getTextRes() {
            return this.textRes;
        }
    }

    public Goal(double d, Type type, long j, long j2) {
        long timeInMillis;
        type.getClass();
        this.status = Status.INITIAL;
        this.nextTarget = -1.0d;
        int mode = 1;
        this.mode = 1;
        this.base = d;
        this.current = d;
        this.type = type;
        this.startTime = j;
        this.lastUpdate = j;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j == -1 ? System.currentTimeMillis() : j);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        long timeInMillis2 = calendar.getTimeInMillis();
        if (j2 == -1) {
            calendar.setTimeInMillis(timeInMillis2);
            calendar.add(5, 30);
            calendar.set(11, 23);
            calendar.set(12, 59);
            calendar.set(13, 59);
            timeInMillis = calendar.getTimeInMillis();
        } else {
            calendar.setTimeInMillis(j2);
            calendar.set(11, 23);
            calendar.set(12, 59);
            calendar.set(13, 59);
            timeInMillis = calendar.getTimeInMillis();
        }
        this.endTime = timeInMillis;
        if (timeInMillis >= timeInMillis2) {
            if (type.getMode() != 0) {
                mode = type.getMode();
            } else if (d > 9.0d) {
                mode = -1;
            }
            this.mode = mode;
            calculateTarget(type.getStep() * ((double) mode) * 3.0d);
            return;
        }
        throw new IllegalArgumentException((new Date(timeInMillis).toString() + " end time smaller than start time " + new Date(timeInMillis2)).toString());
    }

    public static final IListAggregator createAggregator(Context context, Type type) {
        return INSTANCE.createAggregator(context, type);
    }

    public static final IValueExtractor createExtractor(Context context, Type type) {
        return INSTANCE.createExtractor(context, type);
    }

    public static final List<StatRecord> filterGoalRecords(Goal goal, List<? extends StatRecord> list, Date date, int i) {
        return INSTANCE.filterGoalRecords(goal, list, date, i);
    }

    public static final Goal fromSerialized(String str) {
        return INSTANCE.fromSerialized(str);
    }

    public static final double getNextTarget(Context context, Goal goal, List<? extends StatRecord> list) {
        return INSTANCE.getNextTarget(context, goal, list);
    }

    public final double calculateTarget(double percentage) {
        double d = (percentage + 1.0d) * this.base;
        this.target = d;
        if (d > this.type.getMax()) {
            this.target = this.type.getMax();
        }
        return this.target;
    }

    public final boolean canRefund() {
        if (!hasMotivationFee()) {
            return false;
        }
        if (getProgressDays() <= 7 || this.status == Status.SUCCESS) {
            return true;
        }
        return getProgress() >= 1.0d && this.status == Status.IN_PROGRESS;
    }

    @Override // java.lang.Comparable
    public int compareTo(Goal o) {
        o.getClass();
        return Intrinsics.compare(o.endTime, this.endTime);
    }

    public final boolean completedPreliminarily() {
        return this.status == Status.IN_PROGRESS && getProgress() >= 1.0d;
    }

    public final boolean didSucceedNow() {
        Status status;
        return updateStatus() && this.status != (status = Status.SUCCESS) && this.status == status;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Goal)) {
            return false;
        }
        Goal goal = (Goal) o;
        return Double.compare(goal.target, this.target) == 0 && this.startTime == goal.startTime && this.endTime == goal.endTime && this.type == goal.type;
    }

    public final int getGoalDays() {
        return (int) ((this.endTime - this.startTime) / TimeChart.DAY);
    }

    public final String getGoalTitle(Context context) {
        context.getClass();
        return INSTANCE.getGoalTitle(context, this.type);
    }

    public final int getMode() {
        return this.mode;
    }

    public final String getOrderId() {
        String str = this.orderId;
        if (str != null) {
            str.getClass();
            if (str.length() == 0) {
                return null;
            }
        }
        return this.orderId;
    }

    public final double getPercentage() {
        return (this.target / this.base) - 1.0d;
    }

    public final double getProgress() {
        double timeProgressDaysDouble = ((getTimeProgressDaysDouble() + 1.0d) * (this.current - this.base)) / ((this.target - this.base) * ((double) RangesKt.coerceAtLeast(getGoalDays() + 1, getTimeProgressDays() + 1)));
        Logger.logInfo("Goal: progress " + this.base + " -> " + this.current + " <- " + this.target + " time " + getTimeProgressDays());
        StringBuilder sb = new StringBuilder("Goal: progress ");
        sb.append(timeProgressDaysDouble);
        Logger.logInfo(sb.toString());
        return timeProgressDaysDouble;
    }

    public final int getProgressDays() {
        return getProgressDays(System.currentTimeMillis());
    }

    public final int getProgressInt() {
        return (int) Math.round(getProgress() * 100.0d);
    }

    public final double getProgressWholeDays(Date day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(day);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        long timeInMillis = calendar.getTimeInMillis();
        calendar.setTimeInMillis(this.startTime);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        long timeInMillis2 = calendar.getTimeInMillis();
        calendar.setTimeInMillis(this.endTime);
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        return Math.min(Math.max((timeInMillis - timeInMillis2) / (calendar.getTimeInMillis() - timeInMillis2), 0.0d), 1.0d);
    }

    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    public final String getSubscriptionToken() {
        return this.subscriptionToken;
    }

    public final double getTimeProgress() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.startTime;
        return (jCurrentTimeMillis - j) / (this.endTime - j);
    }

    public final int getTimeProgressDays() {
        return (int) ((System.currentTimeMillis() - this.startTime) / TimeChart.DAY);
    }

    public final double getTimeProgressDaysDouble() {
        return (System.currentTimeMillis() - this.startTime) / 8.64E7d;
    }

    public final int getTimeProgressInt() {
        return (int) Math.round(getTimeProgress() * 100.0d);
    }

    public final boolean hasMotivationFee() {
        String str = this.subscriptionId;
        if (str == null || this.subscriptionToken == null) {
            return false;
        }
        str.getClass();
        if (str.length() <= 0) {
            return false;
        }
        String str2 = this.subscriptionToken;
        str2.getClass();
        return str2.length() > 0;
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.target);
        int iHashCode = (this.type.hashCode() + (((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) * 31)) * 31;
        long j = this.startTime;
        int i = (iHashCode + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.endTime;
        return i + ((int) (j2 ^ (j2 >>> 32)));
    }

    public final boolean isInApp() {
        return this.orderId != null;
    }

    public final void setDurationMonth() {
    }

    public final void setDurationWeek() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(this.startTime);
        calendar.add(5, 7);
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        long timeInMillis = calendar.getTimeInMillis();
        this.endTime = timeInMillis;
        if (timeInMillis != -1) {
            calendar.setTimeInMillis(timeInMillis);
            calendar.set(11, 23);
            calendar.set(12, 59);
            calendar.set(13, 59);
            this.endTime = calendar.getTimeInMillis();
        }
        this.endTime = this.endTime;
    }

    public final void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public final void setSubscriptionId(String str) {
        this.subscriptionId = str;
    }

    public final void setSubscriptionToken(String str) {
        this.subscriptionToken = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.base);
        sb.append(";;;");
        sb.append(this.target);
        sb.append(";;;");
        sb.append(this.type);
        sb.append(";;;");
        sb.append(this.startTime);
        sb.append(";;;");
        sb.append(this.endTime);
        sb.append(";;;");
        sb.append(this.status);
        sb.append(";;;");
        String str = this.subscriptionId;
        if (str == null) {
            str = "";
        }
        sb.append(str);
        sb.append(";;;");
        String str2 = this.subscriptionToken;
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str2);
        sb.append(";;;");
        sb.append(this.current);
        sb.append(";;;");
        sb.append(this.lastUpdate);
        sb.append(";;;");
        sb.append(this.nextTarget);
        sb.append(";;;");
        String str3 = this.orderId;
        sb.append(str3 != null ? str3 : "");
        return sb.toString();
    }

    public final boolean updateStatus() {
        if (this.status == Status.INITIAL) {
            this.status = Status.IN_PROGRESS;
        }
        if (this.status != Status.IN_PROGRESS) {
            return false;
        }
        if (getProgress() >= 1.0d && getProgressDays() > getGoalDays() / 2) {
            this.status = Status.SUCCESS;
            return true;
        }
        if (getTimeProgress() < 1.0d) {
            return false;
        }
        if (getProgress() >= 1.0d) {
            this.status = Status.SUCCESS;
        } else {
            this.status = Status.FAILED;
        }
        return true;
    }

    public final void validateAndFix(double rollbackTarget) {
        double percentage = getPercentage();
        if (percentage > -0.01d && percentage < 0.01d) {
            calculateTarget(percentage >= 0.0d ? 0.01d : -0.01d);
        }
        if (this.type.getMode() > 0 && percentage < 0.0d) {
            this.target = rollbackTarget;
        } else if (this.type.getMode() < 0 && percentage > 0.0d) {
            this.target = rollbackTarget;
        }
        if (percentage < -0.5d) {
            calculateTarget(-0.5d);
        } else if (percentage > 0.5d) {
            calculateTarget(0.5d);
        }
    }

    public final int getProgressDays(long time) {
        return (int) ((time - this.startTime) / TimeChart.DAY);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u001a\b\u0086\u0081\u0002\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B/\b\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tR$\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rR$\u0010\u0007\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0007\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u0011\u0010\u0010\"\u0004\b\u0012\u0010\u0013R$\u0010\u0006\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d¨\u0006\u001e"}, d2 = {"Lcom/urbandroid/sleep/domain/goal/Goal$Type;", "", "", "mode", "", "step", "defaultBase", "max", "<init>", "(Ljava/lang/String;IIDDD)V", SDKConstants.PARAM_VALUE, "I", "getMode", "()I", "D", "getMax", "()D", "getStep", "setStep", "(D)V", "getDefaultBase", "Companion", "DURATION", "FALL_ASLEEP_HOUR", "IRREGULARITY", "REGULARITY", "AWAKE", "DEEP_SLEEP", "SNORING", "SNOOZE", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        private double defaultBase;
        private double max;
        private int mode;
        private double step;
        public static final Type DURATION = new Type("DURATION", 0, 0, 0.02d, 7.0d, 10.0d);
        public static final Type FALL_ASLEEP_HOUR = new Type("FALL_ASLEEP_HOUR", 1, -1, 0.01d, 23.0d, 0.0d, 8, null);
        public static final Type IRREGULARITY = new Type("IRREGULARITY", 2, -1, 0.02d, 60.0d, 0.0d, 8, null);
        public static final Type REGULARITY = new Type("REGULARITY", 3, 1, 0.01d, 0.0d, 0.99d, 4, null);
        public static final Type AWAKE = new Type("AWAKE", 4, -1, 0.05d, 0.0d, 0.0d, 12, null);
        public static final Type DEEP_SLEEP = new Type("DEEP_SLEEP", 5, 1, 0.02d, 0.0d, 0.0d, 12, null);
        public static final Type SNORING = new Type("SNORING", 6, -1, 0.05d, 0.0d, 0.0d, 12, null);
        public static final Type SNOOZE = new Type("SNOOZE", 7, -1, 0.05d, 0.0d, 0.0d, 12, null);

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{DURATION, FALL_ASLEEP_HOUR, IRREGULARITY, REGULARITY, AWAKE, DEEP_SLEEP, SNORING, SNOOZE};
        }

        static {
            Type[] typeArr$values = $values();
            $VALUES = typeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(typeArr$values);
            INSTANCE = new Companion(null);
        }

        public /* synthetic */ Type(String str, int i, int i2, double d, double d2, double d3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, i2, (i3 & 2) != 0 ? 0.05d : d, (i3 & 4) != 0 ? 0.0d : d2, (i3 & 8) != 0 ? Double.MAX_VALUE : d3);
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public final double getDefaultBase() {
            return this.defaultBase;
        }

        public final double getMax() {
            return this.max;
        }

        public final int getMode() {
            return this.mode;
        }

        public final double getStep() {
            return this.step;
        }

        private Type(String str, int i, int i2, double d, double d2, double d3) {
            this.mode = i2;
            this.step = d;
            this.defaultBase = d2;
            this.max = d3;
        }
    }

    public /* synthetic */ Goal(double d, double d2, Type type, long j, long j2, Status status, String str, String str2, double d3, long j3, double d4, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(d, d2, type, j, j2, status, str, str2, d3, j3, (i & 1024) != 0 ? -1.0d : d4, (i & 2048) != 0 ? null : str3);
    }

    private Goal(double d, double d2, Type type, long j, long j2, Status status, String str, String str2, double d3, long j3, double d4, String str3) {
        Status status2 = Status.INITIAL;
        this.mode = 1;
        this.base = d;
        this.target = d2;
        this.type = type;
        this.startTime = j;
        this.endTime = j2;
        this.status = status;
        this.subscriptionId = str;
        this.subscriptionToken = str2;
        this.current = d3;
        this.lastUpdate = j3;
        this.nextTarget = d4;
        this.orderId = str3;
    }

    public /* synthetic */ Goal(double d, Type type, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(d, type, (i & 4) != 0 ? System.currentTimeMillis() : j, (i & 8) != 0 ? -1L : j2);
    }

    public /* synthetic */ Goal(double d, double d2, Type type, long j, long j2, Status status, String str, String str2, double d3, long j3, double d4, String str3, DefaultConstructorMarker defaultConstructorMarker) {
        this(d, d2, type, j, j2, status, str, str2, d3, j3, d4, str3);
    }
}
