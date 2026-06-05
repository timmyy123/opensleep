package com.urbandroid.sleep.smartlight;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.ViewExtKt;
import com.urbandroid.sleep.ai.AiActivity$$ExternalSyntheticLambda6;
import com.urbandroid.sleep.captcha.IntentIntegrator;
import com.urbandroid.sleep.captcha.IntentResult;
import com.urbandroid.sleep.fragment.NoiseFragment$$ExternalSyntheticLambda6;
import com.urbandroid.sleep.gui.TintUtil;
import com.urbandroid.sleep.gui.ToolbarUtil;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import com.urbandroid.smartlight.common.Common_smartlightKt;
import com.urbandroid.smartlight.common.discovery.Discovery;
import com.urbandroid.smartlight.common.discovery.GatewayDiscovery;
import com.urbandroid.smartlight.common.model.AuthenticatedGateway;
import com.urbandroid.smartlight.common.model.Gateway;
import com.urbandroid.smartlight.ikea.tradfri.TradfriKt;
import io.ktor.http.CodecsKt$$ExternalSyntheticLambda2;
import io.ktor.http.Url$$ExternalSyntheticLambda1;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt___StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u000234B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u0019H\u0014J\"\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\u000e\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%J\u0018\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020(2\u0006\u0010\u0016\u001a\u00020)H\u0002J\u0006\u0010*\u001a\u00020\u0019J\u0010\u0010+\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\f\u0010,\u001a\u00020\u0019*\u00020\u0017H\u0002J\u0010\u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020%2\u0006\u00101\u001a\u000202H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/urbandroid/sleep/smartlight/DiscoveryActivity;", "Lcom/urbandroid/common/BaseActivity;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "job", "Lkotlinx/coroutines/CompletableJob;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "adapter", "Lcom/urbandroid/sleep/smartlight/RecyclerAdapter;", "progressBar", "Landroid/widget/ProgressBar;", "discovery", "Lcom/urbandroid/smartlight/common/discovery/GatewayDiscovery;", "gateway", "Lcom/urbandroid/smartlight/common/model/Gateway;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "showProgressBar", "enable", "", "inputSecurityCode", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "Lcom/urbandroid/smartlight/common/model/Gateway$Tradfri;", "discover", "handleSelectedGateway", "authenticate", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "BridgeType", "ScanResult", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DiscoveryActivity extends BaseActivity implements CoroutineScope, FeatureLogger {
    private RecyclerAdapter adapter;
    private final CoroutineContext coroutineContext;
    private GatewayDiscovery discovery;
    private volatile Gateway gateway;
    private final CompletableJob job;
    private ProgressBar progressBar;
    private final String tag = Common_smartlightKt.TAG;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/urbandroid/sleep/smartlight/DiscoveryActivity$BridgeType;", "", "<init>", "(Ljava/lang/String;I)V", "YaHue", "Hue", "Tradfri", "Dirigera", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class BridgeType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ BridgeType[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final BridgeType YaHue = new BridgeType("YaHue", 0);
        public static final BridgeType Hue = new BridgeType("Hue", 1);
        public static final BridgeType Tradfri = new BridgeType("Tradfri", 2);
        public static final BridgeType Dirigera = new BridgeType("Dirigera", 3);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/urbandroid/sleep/smartlight/DiscoveryActivity$BridgeType$Companion;", "", "<init>", "()V", "current", "Lcom/urbandroid/sleep/smartlight/DiscoveryActivity$BridgeType;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final BridgeType current(AppCompatActivity activity) {
                activity.getClass();
                return ((MaterialButton) activity.findViewById(R.id.bridge_tradfri)).isChecked() ? BridgeType.Tradfri : ((MaterialButton) activity.findViewById(R.id.bridge_yahue)).isChecked() ? BridgeType.YaHue : BridgeType.Hue;
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ BridgeType[] $values() {
            return new BridgeType[]{YaHue, Hue, Tradfri, Dirigera};
        }

        static {
            BridgeType[] bridgeTypeArr$values = $values();
            $VALUES = bridgeTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(bridgeTypeArr$values);
            INSTANCE = new Companion(null);
        }

        private BridgeType(String str, int i) {
        }

        public static BridgeType valueOf(String str) {
            return (BridgeType) Enum.valueOf(BridgeType.class, str);
        }

        public static BridgeType[] values() {
            return (BridgeType[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/urbandroid/sleep/smartlight/DiscoveryActivity$ScanResult;", "", "", "securityCode", "mac", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSecurityCode", "getMac", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class ScanResult {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final String tag = Common_smartlightKt.TAG;
        private final String mac;
        private final String securityCode;

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0005R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/urbandroid/sleep/smartlight/DiscoveryActivity$ScanResult$Companion;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "parse", "Lcom/urbandroid/sleep/smartlight/DiscoveryActivity$ScanResult;", "data", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion implements FeatureLogger {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Override // com.urbandroid.common.FeatureLogger
            public String getTag() {
                return ScanResult.tag;
            }

            public final ScanResult parse(String data2) {
                data2.getClass();
                List listSplit$default = StringsKt.split$default(data2, new String[]{","}, 0, 6);
                String upperCase = (String) listSplit$default.get(0);
                String str = (String) listSplit$default.get(1);
                int length = upperCase.length();
                if (length == 12) {
                    upperCase = CollectionsKt.joinToString$default(StringsKt___StringsKt.chunked(upperCase, 2), ":", null, null, null, 62).toUpperCase(Locale.ROOT);
                    upperCase.getClass();
                } else if (length == 17) {
                    upperCase = StringsKt.replace$default(upperCase, "-", ":").toUpperCase(Locale.ROOT);
                    upperCase.getClass();
                }
                return new ScanResult(str, upperCase);
            }

            private Companion() {
            }
        }

        public ScanResult(String str, String str2) {
            str.getClass();
            str2.getClass();
            this.securityCode = str;
            this.mac = str2;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ScanResult)) {
                return false;
            }
            ScanResult scanResult = (ScanResult) other;
            return Intrinsics.areEqual(this.securityCode, scanResult.securityCode) && Intrinsics.areEqual(this.mac, scanResult.mac);
        }

        public final String getSecurityCode() {
            return this.securityCode;
        }

        public int hashCode() {
            return this.mac.hashCode() + (this.securityCode.hashCode() * 31);
        }

        public String toString() {
            return FileInsert$$ExternalSyntheticOutline0.m("ScanResult(securityCode=", this.securityCode, ", mac=", this.mac, ")");
        }
    }

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BridgeType.values().length];
            try {
                iArr[BridgeType.Hue.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BridgeType.YaHue.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BridgeType.Tradfri.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BridgeType.Dirigera.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartlight.DiscoveryActivity$authenticate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.smartlight.DiscoveryActivity$authenticate$1", f = "DiscoveryActivity.kt", l = {}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Gateway $this_authenticate;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Gateway gateway, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_authenticate = gateway;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = DiscoveryActivity.this.new AnonymousClass1(this.$this_authenticate, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            DiscoveryActivity discoveryActivity = DiscoveryActivity.this;
            String str = "HUE Authentication required  launch  " + CoroutineScopeKt.isActive(coroutineScope) + " thread " + Thread.currentThread().getName() + " ACTIVITY SCOPE " + DiscoveryActivity.this.job.isActive();
            Logger.logInfo(Logger.defaultTag, discoveryActivity.getTag() + ": " + str, null);
            GatewayDiscovery gatewayDiscovery = new GatewayDiscovery(DiscoveryActivity.this);
            Gateway gateway = this.$this_authenticate;
            final DiscoveryActivity discoveryActivity2 = DiscoveryActivity.this;
            gatewayDiscovery.authenticate(gateway, new Discovery.AuthListener<Gateway>() { // from class: com.urbandroid.sleep.smartlight.DiscoveryActivity.authenticate.1.1
                @Override // com.urbandroid.smartlight.common.discovery.Discovery.AuthListener
                public void authRequired(Gateway gateway2) {
                    gateway2.getClass();
                    DiscoveryActivity discoveryActivity3 = discoveryActivity2;
                    String str2 = Logger.defaultTag;
                    Logger.logInfo(str2, discoveryActivity3.getTag() + ": " + ("auth required " + gateway2), null);
                    if (gateway2 instanceof Gateway.Tradfri) {
                        DiscoveryActivity discoveryActivity4 = discoveryActivity2;
                        Logger.logInfo(Logger.defaultTag, discoveryActivity4.getTag() + ": no pushlink ", null);
                        return;
                    }
                    boolean z = gateway2 instanceof Gateway.Hue;
                    DiscoveryActivity discoveryActivity5 = discoveryActivity2;
                    if (z) {
                        String str3 = "HUE Authentication required - showing pushlink " + CoroutineScopeKt.isActive(coroutineScope) + " thread " + Thread.currentThread().getName() + " ACTIVITY SCOPE " + discoveryActivity2.job.isActive();
                        Logger.logInfo(Logger.defaultTag, discoveryActivity5.getTag() + ": " + str3, null);
                        new PHPushlinkDialogFragment().show(discoveryActivity2.getSupportFragmentManager(), "pushlink");
                        return;
                    }
                    String str4 = "HUE Authentication required - showing pushlink " + CoroutineScopeKt.isActive(coroutineScope) + " thread " + Thread.currentThread().getName() + " ACTIVITY SCOPE " + discoveryActivity2.job.isActive();
                    Logger.logInfo(Logger.defaultTag, discoveryActivity5.getTag() + ": " + str4, null);
                    new GeneralPushlinkDialogFragment().show(discoveryActivity2.getSupportFragmentManager(), "pushlinkNew");
                }

                @Override // com.urbandroid.smartlight.common.discovery.Discovery.AuthListener
                public void failed(Gateway gateway2) {
                    gateway2.getClass();
                    DiscoveryActivity discoveryActivity3 = discoveryActivity2;
                    String str2 = Logger.defaultTag;
                    Logger.logSevere(str2, discoveryActivity3.getTag() + ": " + ("Authentication failed " + gateway2), null);
                    Toast.makeText(discoveryActivity2, R.string.could_not_find_bridge, 1).show();
                }

                @Override // com.urbandroid.smartlight.common.discovery.Discovery.AuthListener
                public void success(AuthenticatedGateway gateway2) {
                    gateway2.getClass();
                    DiscoveryActivity discoveryActivity3 = discoveryActivity2;
                    String str2 = Logger.defaultTag;
                    Logger.logSevere(str2, discoveryActivity3.getTag() + ": " + ("Authentication success " + gateway2), null);
                    DiscoveryActivity discoveryActivity4 = discoveryActivity2;
                    gateway2.save(discoveryActivity4);
                    discoveryActivity2.startActivity(new Intent(discoveryActivity4, (Class<?>) LightActivity.class));
                    discoveryActivity2.finish();
                }
            });
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartlight.DiscoveryActivity$discover$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.smartlight.DiscoveryActivity$discover$1", f = "DiscoveryActivity.kt", l = {}, m = "invokeSuspend", v = 2)
    public static final class C21751 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C21751(Continuation<? super C21751> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DiscoveryActivity.this.new C21751(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C21751) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            GatewayDiscovery gatewayDiscovery = null;
            if (this.label != 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            GatewayDiscovery gatewayDiscovery2 = DiscoveryActivity.this.discovery;
            if (gatewayDiscovery2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("discovery");
            } else {
                gatewayDiscovery = gatewayDiscovery2;
            }
            final DiscoveryActivity discoveryActivity = DiscoveryActivity.this;
            gatewayDiscovery.discover(new Discovery.Listener<Gateway>() { // from class: com.urbandroid.sleep.smartlight.DiscoveryActivity.discover.1.1
                @Override // com.urbandroid.smartlight.common.discovery.Discovery.Listener
                public void failed(String message) {
                    message.getClass();
                    discoveryActivity.showProgressBar(false);
                    Toast.makeText(discoveryActivity, "Failure " + message, 1).show();
                    Toast.makeText(discoveryActivity, R.string.no_connection, 1).show();
                }

                @Override // com.urbandroid.smartlight.common.discovery.Discovery.Listener
                public void found(Gateway gateway) {
                    gateway.getClass();
                    RecyclerAdapter recyclerAdapter = discoveryActivity.adapter;
                    if (recyclerAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        recyclerAdapter = null;
                    }
                    recyclerAdapter.addGateway(gateway);
                    DiscoveryActivity discoveryActivity2 = discoveryActivity;
                    String strValueOf = String.valueOf(gateway);
                    Logger.logInfo(Logger.defaultTag, discoveryActivity2.getTag() + ": " + strValueOf, null);
                }

                @Override // com.urbandroid.smartlight.common.discovery.Discovery.Listener
                public void onStart() {
                    discoveryActivity.showProgressBar(true);
                }

                @Override // com.urbandroid.smartlight.common.discovery.Discovery.Listener
                public void onStop() {
                    DiscoveryActivity discoveryActivity2 = discoveryActivity;
                    RecyclerAdapter recyclerAdapter = null;
                    Logger.logInfo(Logger.defaultTag, discoveryActivity2.getTag() + ": onStop", null);
                    discoveryActivity.showProgressBar(false);
                    RecyclerAdapter recyclerAdapter2 = discoveryActivity.adapter;
                    if (recyclerAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    } else {
                        recyclerAdapter = recyclerAdapter2;
                    }
                    if (recyclerAdapter.getGateways().size() == 0) {
                        ((TextView) discoveryActivity.findViewById(R.id.no_devices)).setVisibility(0);
                    }
                }
            });
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartlight.DiscoveryActivity$showProgressBar$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.smartlight.DiscoveryActivity$showProgressBar$1", f = "DiscoveryActivity.kt", l = {}, m = "invokeSuspend", v = 2)
    public static final class C21761 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $enable;
        int label;
        final /* synthetic */ DiscoveryActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C21761(boolean z, DiscoveryActivity discoveryActivity, Continuation<? super C21761> continuation) {
            super(2, continuation);
            this.$enable = z;
            this.this$0 = discoveryActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C21761(this.$enable, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C21761) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ProgressBar progressBar = null;
            if (this.label != 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            boolean z = this.$enable;
            ProgressBar progressBar2 = this.this$0.progressBar;
            if (z) {
                if (progressBar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                } else {
                    progressBar = progressBar2;
                }
                ViewExtKt.show(progressBar);
            } else {
                if (progressBar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                } else {
                    progressBar = progressBar2;
                }
                ViewExtKt.gone(progressBar);
            }
            return Unit.INSTANCE;
        }
    }

    public DiscoveryActivity() {
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default(null, 1, null);
        this.job = completableJobSupervisorJob$default;
        this.coroutineContext = Dispatchers.getMain().plus(completableJobSupervisorJob$default).plus(new DiscoveryActivity$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, this));
    }

    private final void authenticate(Gateway gateway) {
        String str = "authenticate gateway " + gateway.toAnonymized();
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + str, null);
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new AnonymousClass1(gateway, null), 3, null);
    }

    private final void handleSelectedGateway(Gateway gateway) {
        this.gateway = gateway;
        if (!(gateway instanceof Gateway.Tradfri)) {
            authenticate(gateway);
            return;
        }
        Gateway.Tradfri tradfri = (Gateway.Tradfri) gateway;
        String secretCode = tradfri.getSecretCode();
        if (secretCode == null || secretCode.length() == 0) {
            inputSecurityCode(this, tradfri);
        } else {
            authenticate(gateway);
        }
    }

    private final void inputSecurityCode(Context context, Gateway.Tradfri gateway) {
        View viewInflate = InflatorUtil.INSTANCE.get(context).inflate(R.layout.dialog_smartlight_edit_or_scan, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.edit);
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(context);
        materialAlertDialogBuilder.setTitle(R.string.smartlight_bridge_code);
        materialAlertDialogBuilder.setView(viewInflate);
        materialAlertDialogBuilder.setPositiveButton(R.string.button_ok, (DialogInterface.OnClickListener) new NoiseFragment$$ExternalSyntheticLambda6(9));
        materialAlertDialogBuilder.setNegativeButton(R.string.button_cancel, (DialogInterface.OnClickListener) null);
        AlertDialog alertDialogCreate = materialAlertDialogBuilder.create();
        alertDialogCreate.getClass();
        viewInflate.findViewById(R.id.edit).requestFocus();
        AuthenticatedGateway authenticatedGatewayLoad = AuthenticatedGateway.INSTANCE.load(context);
        if (authenticatedGatewayLoad != null && Intrinsics.areEqual(authenticatedGatewayLoad.getId(), gateway.getId()) && (authenticatedGatewayLoad instanceof AuthenticatedGateway.Tradfri)) {
            textView.setText(((AuthenticatedGateway.Tradfri) authenticatedGatewayLoad).getSecretCode());
        }
        viewInflate.findViewById(R.id.scan).setOnClickListener(new AiActivity$$ExternalSyntheticLambda6(alertDialogCreate, this, 23));
        alertDialogCreate.show();
        alertDialogCreate.getButton(-1).setOnClickListener(new DiscoveryActivity$$ExternalSyntheticLambda5(textView, alertDialogCreate, this, gateway, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void inputSecurityCode$lambda$0$0(DialogInterface dialogInterface, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void inputSecurityCode$lambda$2(AlertDialog alertDialog, DiscoveryActivity discoveryActivity, View view) {
        alertDialog.dismiss();
        new IntentIntegrator(discoveryActivity).initiateScan(CollectionsKt.mutableListOf("QR_CODE_MODE"), 49373);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void inputSecurityCode$lambda$3(TextView textView, AlertDialog alertDialog, DiscoveryActivity discoveryActivity, Gateway.Tradfri tradfri, View view) {
        CharSequence text = textView.getText();
        if (text == null || text.length() == 0) {
            return;
        }
        CharSequence text2 = textView.getText();
        String string = text2 != null ? text2.toString() : null;
        if (string != null) {
            discoveryActivity.authenticate(Gateway.Tradfri.copy$default(tradfri, null, null, 0, string, 7, null));
        }
        alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(DiscoveryActivity discoveryActivity, Gateway gateway) {
        gateway.getClass();
        discoveryActivity.handleSelectedGateway(gateway);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$1(EditText editText, DiscoveryActivity discoveryActivity) {
        String string = editText.getText().toString();
        if (string.length() > 0) {
            BridgeType bridgeTypeCurrent = BridgeType.INSTANCE.current(discoveryActivity);
            int i = bridgeTypeCurrent == null ? -1 : WhenMappings.$EnumSwitchMapping$0[bridgeTypeCurrent.ordinal()];
            if (i == -1) {
                Logger.logWarning(Logger.defaultTag, discoveryActivity.getTag() + ": No bridge type found", null);
            } else if (i == 1) {
                discoveryActivity.handleSelectedGateway(new Gateway.Hue(string, string, null));
            } else if (i == 2) {
                discoveryActivity.handleSelectedGateway(new Gateway.YaHue(string, string, null, "Philips HUE"));
            } else if (i == 3) {
                discoveryActivity.handleSelectedGateway(new Gateway.Tradfri(string, null, 0, null, 14, null));
            } else {
                if (i != 4) {
                    Home$$ExternalSyntheticBUOutline0.m();
                    return null;
                }
                discoveryActivity.handleSelectedGateway(new Gateway.Dirigera("gw2", string, TradfriKt.DIRIGERA_PORT, null));
            }
        }
        return Unit.INSTANCE;
    }

    public final void discover() {
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new C21751(null), 3, null);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data2) {
        super.onActivityResult(requestCode, resultCode, data2);
        StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(requestCode, resultCode, "onActivityResult: ", ", ", ", ");
        sbM.append(data2);
        String string = sbM.toString();
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + string, null);
        if (resultCode == -1 && requestCode == 49373 && data2 != null) {
            IntentResult activityResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data2);
            if (activityResult == null) {
                Logger.logWarning(Logger.defaultTag, getTag() + ": no scan result found", null);
                return;
            }
            ScanResult.Companion companion = ScanResult.INSTANCE;
            String contents = activityResult.getContents();
            contents.getClass();
            ScanResult scanResult = companion.parse(contents);
            if (scanResult != null && this.gateway != null) {
                Gateway gateway = this.gateway;
                if (gateway == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gateway");
                    gateway = null;
                }
                if (scanResult.getSecurityCode().length() > 0 && (gateway instanceof Gateway.Tradfri)) {
                    this.gateway = Gateway.Tradfri.copy$default((Gateway.Tradfri) gateway, null, null, 0, scanResult.getSecurityCode(), 7, null);
                    Gateway gateway2 = this.gateway;
                    if (gateway2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("gateway");
                        gateway2 = null;
                    }
                    authenticate(gateway2);
                }
            }
            String str = Logger.defaultTag;
            Logger.logInfo(str, getTag() + ": " + ("scan result: " + scanResult), null);
        }
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smartlight_discovery);
        TintUtil.tint(this);
        ToolbarUtil.apply(this);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        View viewFindViewById = findViewById(R.id.progressBar);
        viewFindViewById.getClass();
        this.progressBar = (ProgressBar) viewFindViewById;
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(new ArrayList(), new CodecsKt$$ExternalSyntheticLambda2(this, 17));
        this.adapter = recyclerAdapter;
        recyclerView.setAdapter(recyclerAdapter);
        EditText editText = (EditText) findViewById(R.id.bridge_ip_address);
        final Url$$ExternalSyntheticLambda1 url$$ExternalSyntheticLambda1 = new Url$$ExternalSyntheticLambda1(editText, this, 8);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.urbandroid.sleep.smartlight.DiscoveryActivity.onCreate.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView view, int actionId, KeyEvent keyEvent) {
                if (actionId != 6 && ((keyEvent == null || keyEvent.getAction() != 0) && (keyEvent == null || keyEvent.getAction() != 66))) {
                    return false;
                }
                url$$ExternalSyntheticLambda1.invoke();
                return true;
            }
        });
        findViewById(R.id.bridge_ip_ok).setOnClickListener(new DiscoveryActivity$$ExternalSyntheticLambda2(url$$ExternalSyntheticLambda1, 0));
        this.discovery = new GatewayDiscovery(this);
        discover();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.getClass();
        getMenuInflater().inflate(R.menu.light_discovery_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        GatewayDiscovery gatewayDiscovery = null;
        Job.cancel$default(this.job, null, 1, null);
        GatewayDiscovery gatewayDiscovery2 = this.discovery;
        if (gatewayDiscovery2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("discovery");
        } else {
            gatewayDiscovery = gatewayDiscovery2;
        }
        gatewayDiscovery.close();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        item.getClass();
        if (item.getItemId() == R.id.menu_item_refresh) {
            GatewayDiscovery gatewayDiscovery = null;
            Job.cancel$default(this.job, null, 1, null);
            GatewayDiscovery gatewayDiscovery2 = this.discovery;
            if (gatewayDiscovery2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("discovery");
            } else {
                gatewayDiscovery = gatewayDiscovery2;
            }
            gatewayDiscovery.close();
            finish();
            startActivity(new Intent(this, (Class<?>) DiscoveryActivity.class));
        } else {
            finish();
        }
        return true;
    }

    public final void showProgressBar(boolean enable) {
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new C21761(enable, this, null), 3, null);
    }
}
