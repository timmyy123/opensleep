package io.ktor.client;

import com.urbandroid.sleep.fragment.dashboard.share.BitmapComposer;
import com.urbandroid.sleep.functions.C$AppFunctions_AppFunctionInvoker;
import com.urbandroid.sleep.hr.berry.BerryOximeterSocketClient;
import com.urbandroid.sleep.hr.polar.BleSmartWatch;
import com.urbandroid.sleep.hr.polar.PolarBLEClient;
import com.urbandroid.sleep.smartwatch.phaser.CoroutineRunner;
import io.ktor.client.engine.okhttp.OkHttpEngine;
import io.ktor.client.request.ClientUpgradeContent;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.HttpHeaderValueParserKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.serialization.json.JsonElementSerializer;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class HttpClientConfig$$ExternalSyntheticLambda4 implements Function0 {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ HttpClientConfig$$ExternalSyntheticLambda4(int i) {
        this.$r8$classId = i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                return HttpClientConfig.install$lambda$5$lambda$4();
            case 1:
                return Integer.valueOf(BitmapComposer.maxMemory_delegate$lambda$0());
            case 2:
                return C$AppFunctions_AppFunctionInvoker.unsafeInvoke$lambda$0();
            case 3:
                return C$AppFunctions_AppFunctionInvoker.unsafeInvoke$lambda$1();
            case 4:
                return Unit.INSTANCE;
            case 5:
                return Unit.INSTANCE;
            case 6:
                return Boolean.valueOf(BerryOximeterSocketClient.start$lambda$0());
            case 7:
                return Boolean.valueOf(BleSmartWatch.scheduleInstanceAliveCheck$lambda$0());
            case 8:
                return Boolean.valueOf(PolarBLEClient.schedulePpiStreamRestart$lambda$0());
            case 9:
                return Long.valueOf(System.currentTimeMillis());
            case 10:
                return Boolean.valueOf(CoroutineRunner.scheduleWithFixedDelay$lambda$0());
            case 11:
                return OkHttpEngine.okHttpClientPrototype_delegate$lambda$5();
            case 12:
                return Unit.INSTANCE;
            case 13:
                return Unit.INSTANCE;
            case 14:
                return Unit.INSTANCE;
            case 15:
                return ClientUpgradeContent.content_delegate$lambda$0();
            case 16:
                return HttpRequestBuilder.setCapability$lambda$0();
            case 17:
                return HttpHeaderValueParserKt.parseHeaderValue$lambda$4();
            case 18:
                return HttpHeaderValueParserKt.parseHeaderValueItem$lambda$6();
            case 19:
                return JsonElementSerializer.descriptor$lambda$5$lambda$0();
            case 20:
                return JsonElementSerializer.descriptor$lambda$5$lambda$1();
            case 21:
                return JsonElementSerializer.descriptor$lambda$5$lambda$2();
            case 22:
                return JsonElementSerializer.descriptor$lambda$5$lambda$3();
            default:
                return JsonElementSerializer.descriptor$lambda$5$lambda$4();
        }
    }
}
