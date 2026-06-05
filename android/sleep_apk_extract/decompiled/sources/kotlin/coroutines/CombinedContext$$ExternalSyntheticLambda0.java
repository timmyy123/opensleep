package kotlin.coroutines;

import com.urbandroid.sleep.service.google.calendar.alarm.GoogleCalendarAlarmManager;
import com.urbandroid.sleep.service.google.calendar.domain.GoogleCalendar;
import java.io.Serializable;
import java.util.Calendar;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$IntRef;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class CombinedContext$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Serializable f$1;

    public /* synthetic */ CombinedContext$$ExternalSyntheticLambda0(Object obj, Serializable serializable, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = serializable;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        int i = this.$r8$classId;
        Serializable serializable = this.f$1;
        Object obj3 = this.f$0;
        switch (i) {
            case 0:
                return CombinedContext.writeReplace$lambda$0((CoroutineContext[]) obj3, (Ref$IntRef) serializable, (Unit) obj, (CoroutineContext.Element) obj2);
            default:
                return Boolean.valueOf(GoogleCalendarAlarmManager.skipNextIfHoliday$lambda$4((GoogleCalendarAlarmManager) obj3, (Calendar) serializable, (GoogleCalendar) obj, (GoogleCalendar.Event) obj2));
        }
    }
}
