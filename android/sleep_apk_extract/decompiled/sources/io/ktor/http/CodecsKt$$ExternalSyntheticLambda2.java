package io.ktor.http;

import android.content.Context;
import android.content.IntentSender;
import androidx.appfunctions.AppFunctionUriGrant;
import androidx.appfunctions.ExecuteAppFunctionResponse;
import androidx.appfunctions.internal.AppSearchAppFunctionReader;
import androidx.appsearch.app.SearchResult;
import androidx.room.RoomConnectionManager;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.view.result.ActivityResultLauncher;
import com.google.firebase.ai.common.util.FirstOrdinalSerializer;
import com.squareup.kotlinpoet.CodeBlock;
import com.squareup.kotlinpoet.CodeWriter;
import com.squareup.kotlinpoet.FileSpec;
import com.squareup.kotlinpoet.ParameterSpec;
import com.squareup.kotlinpoet.ParameterSpecKt;
import com.urbandroid.sleep.activityrecognition.ActivityRecognitionInitializer;
import com.urbandroid.sleep.bluetoothle.BLEScanKt;
import com.urbandroid.sleep.bluetoothle.BLEScanKt$bleScan$receiver$1;
import com.urbandroid.sleep.nearby.core.ConnectionStatus;
import com.urbandroid.sleep.nearby.core.Message;
import com.urbandroid.sleep.nearby.core.ReliableMessageQueue;
import com.urbandroid.sleep.nearby.pairtracking.PairTracking;
import com.urbandroid.sleep.service.automation.ifttt.IftttTrigger;
import com.urbandroid.sleep.service.google.fit.api.GoogleFitApiFactory;
import com.urbandroid.sleep.service.matter.MatterManager;
import com.urbandroid.sleep.smartlight.DiscoveryActivity;
import com.urbandroid.smartlight.common.model.Gateway;
import com.urbandroid.util.RadioUrlParser;
import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.engine.okhttp.OkHttpEngine;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.websocket.PingPongKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KTypeProjection;
import kotlinx.coroutines.CompletableJob;
import kotlinx.io.Buffer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptorImpl;
import kotlinx.serialization.internal.ObjectSerializer;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class CodecsKt$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ CodecsKt$$ExternalSyntheticLambda2(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i = this.$r8$classId;
        Object obj2 = this.f$0;
        switch (i) {
            case 0:
                return CodecsKt.encodeURLPath$lambda$6$lambda$5((StringBuilder) obj2, ((Byte) obj).byteValue());
            case 1:
                return ExecuteAppFunctionResponse.Success.toPlatformExecuteAppFunctionResponse$lambda$0$0((List) obj2, (AppFunctionUriGrant) obj);
            case 2:
                return AppSearchAppFunctionReader.searchTopLevelComponent$lambda$1((AppSearchAppFunctionReader) obj2, (SearchResult) obj);
            case 3:
                return RoomConnectionManager._init_$lambda$1((RoomConnectionManager) obj2, (SupportSQLiteDatabase) obj);
            case 4:
                return FirstOrdinalSerializer.descriptor$lambda$0((FirstOrdinalSerializer) obj2, (ClassSerialDescriptorBuilder) obj);
            case 5:
                return CodeBlock.toString$lambda$5((CodeBlock) obj2, (CodeWriter) obj);
            case 6:
                return FileSpec.writeTo$lambda$2((FileSpec) obj2, (CodeWriter) obj);
            case 7:
                return Boolean.valueOf(FileSpec.emit$lambda$8((ArrayList) obj2, (String) obj));
            case 8:
                return ParameterSpecKt.emit$lambda$0((CodeWriter) obj2, (ParameterSpec) obj);
            case 9:
                return ActivityRecognitionInitializer.Transition.initialize$lambda$0$0((ActivityRecognitionInitializer) obj2, (Void) obj);
            case 10:
                return BLEScanKt.bleScan$lambda$0((BLEScanKt$bleScan$receiver$1) obj2, (Throwable) obj);
            case 11:
                return ReliableMessageQueue.endpoint$lambda$0((ReliableMessageQueue) obj2, (byte[]) obj);
            case 12:
                return PairTracking._init_$lambda$1((PairTracking) obj2, (Message) obj);
            case 13:
                return PairTracking._init_$lambda$2((Context) obj2, (ConnectionStatus) obj);
            case 14:
                return IftttTrigger.doSend$lambda$4((IftttTrigger) obj2, (String) obj);
            case 15:
                return GoogleFitApiFactory.disconnectAppFromFit$lambda$0((GoogleFitApiFactory.DisconnectAppFromFitListener) obj2, (Void) obj);
            case 16:
                return MatterManager.startCommissioning$lambda$0((ActivityResultLauncher) obj2, (IntentSender) obj);
            case 17:
                return DiscoveryActivity.onCreate$lambda$0((DiscoveryActivity) obj2, (Gateway) obj);
            case 18:
                return RadioUrlParser.Type.parse$lambda$0$0((RadioUrlParser.Type) obj2, (String) obj);
            case 19:
                return HttpClient._init_$lambda$0((HttpClient) obj2, (Throwable) obj);
            case 20:
                return HttpClientConfig.install$lambda$5((HttpClientPlugin) obj2, (HttpClient) obj);
            case 21:
                return OkHttpEngine.executeHttpRequest$lambda$2((ResponseBody) obj2, (Throwable) obj);
            case 22:
                return Boolean.valueOf(CodecsKt.forEach$lambda$11((Function1) obj2, (Buffer) obj));
            case 23:
                return ByteWriteChannelOperationsKt.writer$lambda$2$lambda$1((ByteChannel) obj2, (Throwable) obj);
            case 24:
                return ByteWriteChannelOperationsKt.invokeOnCompletion$lambda$0((Function0) obj2, (Throwable) obj);
            case 25:
                return PingPongKt.pinger$lambda$0((CompletableJob) obj2, (Throwable) obj);
            case 26:
                return TypeReference.asString$lambda$0((TypeReference) obj2, (KTypeProjection) obj);
            case 27:
                return SerialDescriptorImpl.toString$lambda$3((SerialDescriptorImpl) obj2, ((Integer) obj).intValue());
            default:
                return ObjectSerializer.descriptor_delegate$lambda$1$lambda$0((ObjectSerializer) obj2, (ClassSerialDescriptorBuilder) obj);
        }
    }
}
