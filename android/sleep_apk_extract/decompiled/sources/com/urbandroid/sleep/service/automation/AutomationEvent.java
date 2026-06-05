package com.urbandroid.sleep.service.automation;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.activityrecognition.ActivityBootReceiver$$ExternalSyntheticOutline0;
import com.urbandroid.sleep.alarmclock.Alarm;
import com.urbandroid.sleep.alarmclock.Alarms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000bJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u000bR#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/urbandroid/sleep/service/automation/AutomationEvent;", "", "", "eventName", "", "values", "Landroid/content/Intent;", "originalIntent", "<init>", "(Ljava/lang/String;Ljava/util/Map;Landroid/content/Intent;)V", "toJSON", "()Ljava/lang/String;", "valuesToJSON", InAppPurchaseConstants.METHOD_TO_STRING, "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getEventName", "Ljava/util/Map;", "getValues", "()Ljava/util/Map;", "Landroid/content/Intent;", "getOriginalIntent", "()Landroid/content/Intent;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class AutomationEvent {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String eventName;
    private final Intent originalIntent;
    private final Map<String, String> values;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fJ$\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\u0010"}, d2 = {"Lcom/urbandroid/sleep/service/automation/AutomationEvent$Companion;", "", "<init>", "()V", "fromIntent", "Lcom/urbandroid/sleep/service/automation/AutomationEvent;", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "fromSleepEvent", "sleepEvent", "Lcom/urbandroid/sleep/service/automation/AutomationEventMapping;", "intentToValues", "", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Map<String, String> intentToValues(Intent intent, Context context) {
            String strReplace;
            String strValueOf;
            String str;
            int intExtra = intent.getIntExtra("alarm_id", -1);
            Integer numValueOf = Integer.valueOf(intExtra);
            if (intExtra == -1) {
                numValueOf = null;
            }
            if (numValueOf != null) {
                Alarm alarm = Alarms.getAlarm(context.getContentResolver(), numValueOf.intValue());
                strValueOf = String.valueOf(alarm != null ? Long.valueOf(alarm.time) : null);
                strReplace = (alarm == null || (str = alarm.label) == null) ? null : new Regex("[\n\t]", RegexOption.MULTILINE).replace(str, "");
            } else {
                strReplace = null;
                strValueOf = null;
            }
            ArrayList arrayList = new ArrayList();
            if (strValueOf != null) {
                arrayList.add(strValueOf);
            }
            if (strReplace != null) {
                arrayList.add(strReplace);
            }
            Logger.logDebug("intentToValues values " + arrayList, null);
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList, 10)), 16));
            for (Object obj : arrayList) {
                linkedHashMap.put(SDKConstants.PARAM_VALUE + (arrayList.indexOf((String) obj) + 1), obj);
            }
            return linkedHashMap;
        }

        public final AutomationEvent fromIntent(Intent intent, Context context) {
            intent.getClass();
            context.getClass();
            final String str = "automation";
            final boolean z = false;
            FeatureLogger featureLogger = new FeatureLogger() { // from class: com.urbandroid.sleep.service.automation.AutomationEvent$Companion$fromIntent$$inlined$featureLog$default$1
                @Override // com.urbandroid.common.FeatureLogger
                public String getTag() {
                    String str2 = str;
                    boolean z2 = z;
                    StringBuilder sbM = FileInsert$$ExternalSyntheticOutline0.m(str2);
                    String strConcat = "";
                    if (z2) {
                        String strM = Build.VERSION.SDK_INT >= 26 ? ActivityBootReceiver$$ExternalSyntheticOutline0.m() : null;
                        if (strM == null) {
                            strConcat = null;
                        } else if (!StringsKt.isBlank(strM)) {
                            strConcat = ":".concat(strM);
                        }
                    }
                    sbM.append(strConcat);
                    return sbM.toString();
                }
            };
            String action = intent.getAction();
            if (action == null) {
                String strM = FileInsert$$ExternalSyntheticOutline0.m("intent does not contain event - ", ContextExtKt.stringify$default(intent, null, 1, null));
                Logger.logWarning(Logger.defaultTag, featureLogger.getTag() + ": " + strM, null);
                return null;
            }
            AutomationEventMapping automationEventMappingFindByAction = AutomationEventMapping.INSTANCE.findByAction(action);
            if (automationEventMappingFindByAction == null) {
                String strM2 = FileInsert$$ExternalSyntheticOutline0.m("No SleepEvent found for '", action, "'");
                Logger.logInfo(Logger.defaultTag, featureLogger.getTag() + ": " + strM2, null);
                return null;
            }
            if (automationEventMappingFindByAction == AutomationEventMapping.ALARM_SNOOZE_CANCELED) {
                automationEventMappingFindByAction = AutomationEventMapping.ALARM_ALERT_DISMISS;
            }
            String strM3 = FileInsert$$ExternalSyntheticOutline0.m("event: ", automationEventMappingFindByAction.getAction());
            Logger.logInfo(Logger.defaultTag, featureLogger.getTag() + ": " + strM3, null);
            String lowerCase = automationEventMappingFindByAction.name().toLowerCase(Locale.ROOT);
            lowerCase.getClass();
            return new AutomationEvent(lowerCase, AutomationEvent.INSTANCE.intentToValues(intent, context), intent);
        }

        public final AutomationEvent fromSleepEvent(AutomationEventMapping sleepEvent) {
            sleepEvent.getClass();
            return new AutomationEvent(sleepEvent.getAction(), MapsKt.emptyMap(), new Intent());
        }

        private Companion() {
        }
    }

    public AutomationEvent(String str, Map<String, String> map, Intent intent) {
        str.getClass();
        map.getClass();
        intent.getClass();
        this.eventName = str;
        this.values = map;
        this.originalIntent = intent;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AutomationEvent)) {
            return false;
        }
        AutomationEvent automationEvent = (AutomationEvent) other;
        return Intrinsics.areEqual(this.eventName, automationEvent.eventName) && Intrinsics.areEqual(this.values, automationEvent.values) && Intrinsics.areEqual(this.originalIntent, automationEvent.originalIntent);
    }

    public final String getEventName() {
        return this.eventName;
    }

    public int hashCode() {
        return this.originalIntent.hashCode() + ((this.values.hashCode() + (this.eventName.hashCode() * 31)) * 31);
    }

    public final String toJSON() {
        String string = new JSONObject(MapsKt.plus(this.values, new Pair("event", this.eventName))).toString();
        string.getClass();
        return string;
    }

    public String toString() {
        return "AutomationEvent(eventName=" + this.eventName + ", values=" + this.values + ", originalIntent=" + this.originalIntent + ")";
    }

    public final String valuesToJSON() {
        String string = new JSONObject(this.values).toString();
        string.getClass();
        return string;
    }
}
