package io.ktor.http;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.widget.EditText;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.CancelWorkRunnable;
import com.urbandroid.sleep.activityrecognition.DetectedTransitionIntentService;
import com.urbandroid.sleep.activityrecognition.DetectedUpdatesIntentService;
import com.urbandroid.sleep.autostart.AutoTrackingReceiver;
import com.urbandroid.sleep.autostart.AutoTrackingService;
import com.urbandroid.sleep.autostart.ExpectedTrackingRange;
import com.urbandroid.sleep.smartlight.DiscoveryActivity;
import io.ktor.client.engine.okhttp.OkHttpEngineKt;
import io.ktor.http.content.OutgoingContent;
import java.util.List;
import java.util.UUID;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.EnumSerializer;
import kotlinx.serialization.internal.ObjectSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.internal.JsonNamesMapKt;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class Url$$ExternalSyntheticLambda1 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ Url$$ExternalSyntheticLambda1(Object obj, Object obj2, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i = this.$r8$classId;
        Object obj = this.f$1;
        Object obj2 = this.f$0;
        switch (i) {
            case 0:
                return Url.encodedPath_delegate$lambda$3((List) obj2, (Url) obj);
            case 1:
                return CancelWorkRunnable.forTag$lambda$3((WorkManagerImpl) obj2, (String) obj);
            case 2:
                return CancelWorkRunnable.forId$lambda$1((WorkManagerImpl) obj2, (UUID) obj);
            case 3:
                return DetectedTransitionIntentService.onHandleWork$lambda$0((Intent) obj2, (DetectedTransitionIntentService) obj);
            case 4:
                return DetectedUpdatesIntentService.onHandleWork$lambda$0((Intent) obj2, (DetectedUpdatesIntentService) obj);
            case 5:
                return AutoTrackingReceiver.onReceive$lambda$0((Context) obj2, (ExpectedTrackingRange) obj);
            case 6:
                return AutoTrackingService.onStartCommand$lambda$2((AutoTrackingService) obj2, (PowerManager.WakeLock) obj);
            case 7:
                return AutoTrackingService.onStartCommand$lambda$3((AutoTrackingService) obj2, (Ref$BooleanRef) obj);
            case 8:
                return DiscoveryActivity.onCreate$lambda$1((EditText) obj2, (DiscoveryActivity) obj);
            case 9:
                return OkHttpEngineKt.convertToOkHttpBody$lambda$4((CoroutineContext) obj2, (OutgoingContent.WriteChannelContent) obj);
            case 10:
                return SealedClassSerializer.descriptor_delegate$lambda$3((String) obj2, (SealedClassSerializer) obj);
            case 11:
                return EnumSerializer.descriptor_delegate$lambda$0((EnumSerializer) obj2, (String) obj);
            case 12:
                return ObjectSerializer.descriptor_delegate$lambda$1((String) obj2, (ObjectSerializer) obj);
            default:
                return JsonNamesMapKt.buildDeserializationNamesMap((SerialDescriptor) obj2, (Json) obj);
        }
    }
}
