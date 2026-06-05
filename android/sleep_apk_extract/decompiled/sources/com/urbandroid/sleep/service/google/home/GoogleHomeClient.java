package com.urbandroid.sleep.service.google.home;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.home.DeviceTypeFactory;
import com.google.home.FactoryRegistry;
import com.google.home.Home;
import com.google.home.HomeClient;
import com.google.home.HomeConfig;
import com.google.home.HomeDevice;
import com.google.home.HomeException;
import com.google.home.HomeObjectsFlow;
import com.google.home.PermissionsResult;
import com.google.home.PermissionsResultStatus;
import com.google.home.PermissionsState;
import com.google.home.TraitFactory;
import com.google.home.matter.standard.ColorControl;
import com.google.home.matter.standard.ColorControlTrait;
import com.google.home.matter.standard.ColorTemperatureLightDevice;
import com.google.home.matter.standard.DimmableLightDevice;
import com.google.home.matter.standard.ExtendedColorLightDevice;
import com.google.home.matter.standard.LevelControl;
import com.google.home.matter.standard.LevelControlTrait;
import com.google.home.matter.standard.OnOff;
import com.google.home.matter.standard.OnOffLightDevice;
import com.google.home.platform.traits.ValidationIssue;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.smartlight.common.model.Light;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.UByte;
import kotlin.UShort;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 02\u00020\u0001:\u00010B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0087@¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0087@¢\u0006\u0004\b\r\u0010\nJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0087@¢\u0006\u0004\b\u000e\u0010\nJ\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000fH\u0087@¢\u0006\u0004\b\u0010\u0010\nJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0013\u0010\u0014J$\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fH\u0087@¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0087@¢\u0006\u0004\b\u001a\u0010\u001bJ&\u0010\u001f\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0086@¢\u0006\u0004\b\u001f\u0010 J \u0010\u001f\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0086@¢\u0006\u0004\b\u001f\u0010!J&\u0010#\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010#\u001a\u00020\"H\u0086@¢\u0006\u0004\b#\u0010$J&\u0010%\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010#\u001a\u00020\"H\u0086@¢\u0006\u0004\b%\u0010$J\u0017\u0010(\u001a\u00020\b2\u0006\u0010'\u001a\u00020&H\u0007¢\u0006\u0004\b(\u0010)R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010-\u001a\u0004\b.\u0010/¨\u00061"}, d2 = {"Lcom/urbandroid/sleep/service/google/home/GoogleHomeClient;", "", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/google/home/HomeClient;", "client", "<init>", "(Landroid/content/Context;Lcom/google/home/HomeClient;)V", "", "requestPermissionsSuspend", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lcom/google/home/HomeDevice;", "getLightDevices", "getOnOffDevices", "", "getDevices", DeviceRequestsHelper.DEVICE_INFO_DEVICE, "Lcom/urbandroid/smartlight/common/model/Light;", "getLightForDevice", "(Lcom/google/home/HomeDevice;)Lcom/urbandroid/smartlight/common/model/Light;", "lights", "getSelectedDevices", "(Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "id", "getSelectedDevice", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "devices", "", "turnOn", "toggle", "(Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lcom/google/home/HomeDevice;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "level", "(Ljava/util/List;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "color", "Lcom/urbandroid/sleep/service/google/home/GoogleHomePermission;", "listener", "requestPermissionsIfNeeded", "(Lcom/urbandroid/sleep/service/google/home/GoogleHomePermission;)V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcom/google/home/HomeClient;", "getClient", "()Lcom/google/home/HomeClient;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GoogleHomeClient {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile GoogleHomeClient instance;
    private final HomeClient client;
    private final Context context;

    /* JADX INFO: loaded from: classes4.dex */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/urbandroid/sleep/service/google/home/GoogleHomeClient$Companion;", "", "<init>", "()V", "instance", "Lcom/urbandroid/sleep/service/google/home/GoogleHomeClient;", "getInstance", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GoogleHomeClient getInstance(Context context) {
            GoogleHomeClient googleHomeClient;
            context.getClass();
            GoogleHomeClient googleHomeClient2 = GoogleHomeClient.instance;
            if (googleHomeClient2 != null) {
                return googleHomeClient2;
            }
            synchronized (this) {
                FactoryRegistry factoryRegistry = new FactoryRegistry(CollectionsKt.listOf((Object[]) new TraitFactory[]{ColorControl.INSTANCE, LevelControl.INSTANCE, OnOff.INSTANCE}), CollectionsKt.listOf((Object[]) new DeviceTypeFactory[]{ExtendedColorLightDevice.INSTANCE, ColorTemperatureLightDevice.INSTANCE, DimmableLightDevice.INSTANCE, OnOffLightDevice.INSTANCE}));
                Home.Companion companion = Home.INSTANCE;
                Context applicationContext = context.getApplicationContext();
                applicationContext.getClass();
                HomeClient client = companion.getClient(applicationContext, new HomeConfig(false, Dispatchers.getIO(), factoryRegistry, 1, null));
                googleHomeClient = GoogleHomeClient.instance;
                if (googleHomeClient == null) {
                    Context applicationContext2 = context.getApplicationContext();
                    applicationContext2.getClass();
                    googleHomeClient = new GoogleHomeClient(applicationContext2, client, null);
                    GoogleHomeClient.instance = googleHomeClient;
                }
            }
            return googleHomeClient;
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PermissionsResultStatus.values().length];
            try {
                iArr[PermissionsResultStatus.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PermissionsResultStatus.CANCELLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.home.GoogleHomeClient$color$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.home.GoogleHomeClient", f = "GoogleHomeClient.kt", l = {236, 237, 243, 244}, m = "color", v = 2)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleHomeClient.this.color(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.home.GoogleHomeClient$getSelectedDevice$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.home.GoogleHomeClient", f = "GoogleHomeClient.kt", l = {177}, m = "getSelectedDevice", v = 2)
    public static final class C21631 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C21631(Continuation<? super C21631> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleHomeClient.this.getSelectedDevice(null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.home.GoogleHomeClient$getSelectedDevices$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.home.GoogleHomeClient", f = "GoogleHomeClient.kt", l = {170}, m = "getSelectedDevices", v = 2)
    public static final class C21641 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C21641(Continuation<? super C21641> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleHomeClient.this.getSelectedDevices(null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.home.GoogleHomeClient$level$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.home.GoogleHomeClient", f = "GoogleHomeClient.kt", l = {218, 219}, m = "level", v = 2)
    public static final class C21651 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public C21651(Continuation<? super C21651> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleHomeClient.this.level(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.home.GoogleHomeClient$requestPermissionsSuspend$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.home.GoogleHomeClient", f = "GoogleHomeClient.kt", l = {83}, m = "requestPermissionsSuspend", v = 2)
    public static final class C21671 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C21671(Continuation<? super C21671> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleHomeClient.this.requestPermissionsSuspend(this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.home.GoogleHomeClient$toggle$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.home.GoogleHomeClient", f = "GoogleHomeClient.kt", l = {186, 188, FacebookRequestErrorClassification.EC_INVALID_TOKEN}, m = "toggle", v = 2)
    public static final class C21681 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public C21681(Continuation<? super C21681> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleHomeClient.this.toggle((List<? extends HomeDevice>) null, false, (Continuation<? super Unit>) this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.home.GoogleHomeClient$toggle$3, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.home.GoogleHomeClient", f = "GoogleHomeClient.kt", l = {ValidationIssue.UNSUPPORTED_ENTITY_TRAIT_FIELD_NUMBER, ValidationIssue.UNSUPPORTED_ENTITY_COMMAND_FIELD_NUMBER, ValidationIssue.UNSUPPORTED_ENTITY_PARAMETER_VALUE_FIELD_NUMBER}, m = "toggle", v = 2)
    public static final class AnonymousClass3 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GoogleHomeClient.this.toggle((HomeDevice) null, false, (Continuation<? super Unit>) this);
        }
    }

    private GoogleHomeClient(Context context, HomeClient homeClient) {
        this.context = context;
        this.client = homeClient;
    }

    public static final GoogleHomeClient getInstance(Context context) {
        return INSTANCE.getInstance(context);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:(1:116)|75|76|110|77|(4:80|124|81|(8:83|84|128|85|86|120|87|(5:90|91|92|140|(1:37)))(3:100|140|(1:37)))) */
    /* JADX WARN: Can't wrap try/catch for region: R(6:(1:126)|41|42|112|43|(4:46|114|47|(8:49|50|122|51|52|130|53|(5:56|57|58|140|(1:37)))(3:67|140|(1:37)))) */
    /* JADX WARN: Can't wrap try/catch for region: R(8:49|50|122|51|52|130|53|(5:56|57|58|140|(1:37))) */
    /* JADX WARN: Can't wrap try/catch for region: R(8:83|84|128|85|86|120|87|(5:90|91|92|140|(1:37))) */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0310, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0312, code lost:
    
        r10 = r8;
        r8 = r2;
        r2 = r4;
        r4 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0208, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0209, code lost:
    
        r12 = r13;
        r2 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x020e, code lost:
    
        r13 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0211, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0214, code lost:
    
        r12 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0230, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0231, code lost:
    
        r9 = r2;
        r2 = r4;
        r4 = r7;
        r7 = r12;
        r10 = r15;
        r12 = r8;
        r8 = r13;
        r13 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x02f5, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x02f6, code lost:
    
        r2 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x02f8, code lost:
    
        r1 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x02fb, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01b1 A[Catch: Exception -> 0x0218, TRY_LEAVE, TryCatch #2 {Exception -> 0x0218, blocks: (B:47:0x01ab, B:49:0x01b1), top: B:114:0x01ab }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02aa A[Catch: Exception -> 0x02ff, TRY_LEAVE, TryCatch #7 {Exception -> 0x02ff, blocks: (B:81:0x02a4, B:83:0x02aa), top: B:124:0x02a4 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:100:0x0304 -> B:37:0x0145). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x031b -> B:92:0x02f0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x021d -> B:37:0x0145). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x02eb -> B:91:0x02ed). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object color(List<? extends HomeDevice> list, int i, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        int iCoerceAtMost;
        int iCoerceAtMost2;
        Iterator it;
        List<? extends HomeDevice> list2;
        AnonymousClass1 anonymousClass12;
        Iterable iterable;
        int i2;
        int i3;
        List<? extends HomeDevice> list3;
        Iterable iterable2;
        Iterator it2;
        int i4;
        int i5;
        int i6;
        int i7;
        Exception e;
        char c;
        List<? extends HomeDevice> list4;
        Object obj;
        Iterable iterable3;
        HomeDevice homeDevice;
        int i8;
        ColorControl colorControl;
        Iterable iterable4;
        int i9;
        int i10;
        Exception e2;
        List<? extends HomeDevice> list5;
        HomeDevice homeDevice2;
        Object obj2;
        int i11;
        ColorControl colorControl2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i12 = anonymousClass1.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i12 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object obj3 = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i13 = anonymousClass1.label;
        if (i13 == 0) {
            ResultKt.throwOnFailure(obj3);
            List<? extends HomeDevice> list6 = list;
            iCoerceAtMost = 380 - ((int) ((((double) RangesKt.coerceAtMost(RangesKt.coerceAtLeast(i, 0), 100)) / 100.0d) * 230.0d));
            iCoerceAtMost2 = (int) ((((double) RangesKt.coerceAtMost(RangesKt.coerceAtLeast(i, 0), 100)) / 100.0d) * 45.0d);
            it = list6.iterator();
            list2 = list;
            anonymousClass12 = anonymousClass1;
            iterable = list6;
            i2 = 0;
            i3 = i;
            while (it.hasNext()) {
            }
            return Unit.INSTANCE;
        }
        if (i13 != 1) {
            if (i13 == 2) {
                i7 = anonymousClass1.I$3;
                i6 = anonymousClass1.I$2;
                i5 = anonymousClass1.I$1;
                i4 = anonymousClass1.I$0;
                it2 = (Iterator) anonymousClass1.L$2;
                iterable2 = (Iterable) anonymousClass1.L$1;
                list3 = (List) anonymousClass1.L$0;
                try {
                    ResultKt.throwOnFailure(obj3);
                    c = 2;
                } catch (Exception e3) {
                    e = e3;
                    Logger.logSevere("Home: error " + e.getMessage());
                    it = it2;
                    list2 = list3;
                    iCoerceAtMost = i5;
                    iterable = iterable2;
                    iCoerceAtMost2 = i6;
                    i2 = i7;
                    anonymousClass12 = anonymousClass1;
                    i3 = i4;
                    while (it.hasNext()) {
                    }
                    return Unit.INSTANCE;
                }
                it = it2;
                list2 = list3;
                iCoerceAtMost = i5;
                iterable = iterable2;
                iCoerceAtMost2 = i6;
                i2 = i7;
                anonymousClass12 = anonymousClass1;
                i3 = i4;
                while (it.hasNext()) {
                }
                return Unit.INSTANCE;
            }
            if (i13 != 3) {
                if (i13 != 4) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                i10 = anonymousClass1.I$3;
                iCoerceAtMost2 = anonymousClass1.I$2;
                iCoerceAtMost = anonymousClass1.I$1;
                int i14 = anonymousClass1.I$0;
                it = (Iterator) anonymousClass1.L$2;
                Iterable iterable5 = (Iterable) anonymousClass1.L$1;
                List<? extends HomeDevice> list7 = (List) anonymousClass1.L$0;
                try {
                    ResultKt.throwOnFailure(obj3);
                    i9 = i14;
                    iterable4 = iterable5;
                    list5 = list7;
                } catch (Exception e4) {
                    e2 = e4;
                    i9 = i14;
                    iterable4 = iterable5;
                    list2 = list7;
                    Logger.logSevere("Home: error " + e2.getMessage());
                    i2 = i10;
                    anonymousClass12 = anonymousClass1;
                    i3 = i9;
                    iterable = iterable4;
                    while (it.hasNext()) {
                    }
                    return Unit.INSTANCE;
                }
                i2 = i10;
                list2 = list5;
                anonymousClass12 = anonymousClass1;
                i3 = i9;
                iterable = iterable4;
                while (it.hasNext()) {
                    Object next = it.next();
                    homeDevice2 = (HomeDevice) next;
                    ExtendedColorLightDevice.Companion companion = ExtendedColorLightDevice.INSTANCE;
                    if (homeDevice2.has(companion)) {
                        try {
                        } catch (Exception e5) {
                            e = e5;
                        }
                        final Flow flowType = homeDevice2.type(companion);
                        Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(new Flow<ColorControl>() { // from class: com.urbandroid.sleep.service.google.home.GoogleHomeClient$color$lambda$0$$inlined$map$1

                            /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.home.GoogleHomeClient$color$lambda$0$$inlined$map$1$2, reason: invalid class name */
                            @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
                            public static final class AnonymousClass2<T> implements FlowCollector {
                                final /* synthetic */ FlowCollector $this_unsafeFlow;

                                /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.home.GoogleHomeClient$color$lambda$0$$inlined$map$1$2$1, reason: invalid class name */
                                @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
                                @DebugMetadata(c = "com.urbandroid.sleep.service.google.home.GoogleHomeClient$color$lambda$0$$inlined$map$1$2", f = "GoogleHomeClient.kt", l = {217}, m = "emit", v = 2)
                                public static final class AnonymousClass1 extends ContinuationImpl {
                                    int I$0;
                                    Object L$0;
                                    Object L$1;
                                    Object L$2;
                                    Object L$3;
                                    int label;
                                    /* synthetic */ Object result;

                                    public AnonymousClass1(Continuation continuation) {
                                        super(continuation);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object obj) {
                                        this.result = obj;
                                        this.label |= Integer.MIN_VALUE;
                                        return AnonymousClass2.this.emit(null, this);
                                    }
                                }

                                public AnonymousClass2(FlowCollector flowCollector) {
                                    this.$this_unsafeFlow = flowCollector;
                                }

                                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                                @Override // kotlinx.coroutines.flow.FlowCollector
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                */
                                public final Object emit(Object obj, Continuation continuation) {
                                    AnonymousClass1 anonymousClass1;
                                    if (continuation instanceof AnonymousClass1) {
                                        anonymousClass1 = (AnonymousClass1) continuation;
                                        int i = anonymousClass1.label;
                                        if ((i & Integer.MIN_VALUE) != 0) {
                                            anonymousClass1.label = i - Integer.MIN_VALUE;
                                        } else {
                                            anonymousClass1 = new AnonymousClass1(continuation);
                                        }
                                    }
                                    Object obj2 = anonymousClass1.result;
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i2 = anonymousClass1.label;
                                    if (i2 == 0) {
                                        ResultKt.throwOnFailure(obj2);
                                        FlowCollector flowCollector = this.$this_unsafeFlow;
                                        ColorControl colorControl = ((ExtendedColorLightDevice) obj).getStandardTraits().getColorControl();
                                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                        anonymousClass1.I$0 = 0;
                                        anonymousClass1.label = 1;
                                        if (flowCollector.emit(colorControl, anonymousClass1) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    } else {
                                        if (i2 != 1) {
                                            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                                            return null;
                                        }
                                        ResultKt.throwOnFailure(obj2);
                                    }
                                    return Unit.INSTANCE;
                                }
                            }

                            @Override // kotlinx.coroutines.flow.Flow
                            public Object collect(FlowCollector<? super ColorControl> flowCollector, Continuation continuation2) {
                                Object objCollect = flowType.collect(new AnonymousClass2(flowCollector), continuation2);
                                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                            }
                        });
                        anonymousClass12.L$0 = SpillingKt.nullOutSpilledVariable(list2);
                        anonymousClass12.L$1 = SpillingKt.nullOutSpilledVariable(iterable);
                        anonymousClass12.L$2 = it;
                        anonymousClass12.L$3 = SpillingKt.nullOutSpilledVariable(next);
                        anonymousClass12.L$4 = SpillingKt.nullOutSpilledVariable(homeDevice2);
                        anonymousClass12.L$5 = null;
                        anonymousClass12.I$0 = i3;
                        anonymousClass12.I$1 = iCoerceAtMost;
                        anonymousClass12.I$2 = iCoerceAtMost2;
                        anonymousClass12.I$3 = i2;
                        anonymousClass12.I$4 = 0;
                        anonymousClass12.label = 1;
                        Object objFirstOrNull = FlowKt.firstOrNull(flowDistinctUntilChanged, anonymousClass12);
                        if (objFirstOrNull != coroutine_suspended) {
                            i4 = i3;
                            anonymousClass1 = anonymousClass12;
                            i7 = i2;
                            i6 = iCoerceAtMost2;
                            homeDevice = homeDevice2;
                            int i15 = iCoerceAtMost;
                            iterable3 = iterable;
                            i5 = i15;
                            list4 = list2;
                            obj3 = objFirstOrNull;
                            it2 = it;
                            obj = next;
                            i8 = 0;
                            try {
                            } catch (Exception e6) {
                                e = e6;
                                c = 2;
                            }
                            colorControl = (ColorControl) obj3;
                            if (colorControl == null) {
                                byte bM2367constructorimpl = UByte.m2367constructorimpl((byte) i6);
                                ColorControlTrait.HueDirection hueDirection = ColorControlTrait.HueDirection.ShortestDistance;
                                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(list4);
                                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(iterable3);
                                anonymousClass1.L$2 = it2;
                                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(homeDevice);
                                anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(colorControl);
                                anonymousClass1.I$0 = i4;
                                anonymousClass1.I$1 = i5;
                                anonymousClass1.I$2 = i6;
                                anonymousClass1.I$3 = i7;
                                anonymousClass1.I$4 = i8;
                                c = 2;
                                anonymousClass1.label = 2;
                                AnonymousClass1 anonymousClass13 = anonymousClass1;
                                if (colorControl.mo610moveToHueBLVVrw(bM2367constructorimpl, hueDirection, (short) 10, (byte) 0, (byte) 0, anonymousClass13) != coroutine_suspended) {
                                    iterable2 = iterable3;
                                    anonymousClass1 = anonymousClass13;
                                    list3 = list4;
                                    it = it2;
                                    list2 = list3;
                                    iCoerceAtMost = i5;
                                    iterable = iterable2;
                                    iCoerceAtMost2 = i6;
                                    i2 = i7;
                                    anonymousClass12 = anonymousClass1;
                                    i3 = i4;
                                    while (it.hasNext()) {
                                    }
                                }
                            } else {
                                AnonymousClass1 anonymousClass14 = anonymousClass1;
                                Iterable iterable6 = iterable3;
                                iCoerceAtMost = i5;
                                iterable = iterable6;
                                iCoerceAtMost2 = i6;
                                i3 = i4;
                                it = it2;
                                list2 = list4;
                                i2 = i7;
                                anonymousClass12 = anonymousClass14;
                                while (it.hasNext()) {
                                }
                            }
                        }
                    } else {
                        ColorTemperatureLightDevice.Companion companion2 = ColorTemperatureLightDevice.INSTANCE;
                        if (homeDevice2.has(companion2)) {
                            try {
                            } catch (Exception e7) {
                                e2 = e7;
                            }
                            final Flow flowType2 = homeDevice2.type(companion2);
                            Flow flowDistinctUntilChanged2 = FlowKt.distinctUntilChanged(new Flow<ColorControl>() { // from class: com.urbandroid.sleep.service.google.home.GoogleHomeClient$color$lambda$0$$inlined$map$2

                                /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.home.GoogleHomeClient$color$lambda$0$$inlined$map$2$2, reason: invalid class name */
                                @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
                                public static final class AnonymousClass2<T> implements FlowCollector {
                                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                                    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.home.GoogleHomeClient$color$lambda$0$$inlined$map$2$2$1, reason: invalid class name */
                                    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
                                    @DebugMetadata(c = "com.urbandroid.sleep.service.google.home.GoogleHomeClient$color$lambda$0$$inlined$map$2$2", f = "GoogleHomeClient.kt", l = {217}, m = "emit", v = 2)
                                    public static final class AnonymousClass1 extends ContinuationImpl {
                                        int I$0;
                                        Object L$0;
                                        Object L$1;
                                        Object L$2;
                                        Object L$3;
                                        int label;
                                        /* synthetic */ Object result;

                                        public AnonymousClass1(Continuation continuation) {
                                            super(continuation);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Object invokeSuspend(Object obj) {
                                            this.result = obj;
                                            this.label |= Integer.MIN_VALUE;
                                            return AnonymousClass2.this.emit(null, this);
                                        }
                                    }

                                    public AnonymousClass2(FlowCollector flowCollector) {
                                        this.$this_unsafeFlow = flowCollector;
                                    }

                                    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                                    @Override // kotlinx.coroutines.flow.FlowCollector
                                    /*
                                        Code decompiled incorrectly, please refer to instructions dump.
                                    */
                                    public final Object emit(Object obj, Continuation continuation) {
                                        AnonymousClass1 anonymousClass1;
                                        if (continuation instanceof AnonymousClass1) {
                                            anonymousClass1 = (AnonymousClass1) continuation;
                                            int i = anonymousClass1.label;
                                            if ((i & Integer.MIN_VALUE) != 0) {
                                                anonymousClass1.label = i - Integer.MIN_VALUE;
                                            } else {
                                                anonymousClass1 = new AnonymousClass1(continuation);
                                            }
                                        }
                                        Object obj2 = anonymousClass1.result;
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        int i2 = anonymousClass1.label;
                                        if (i2 == 0) {
                                            ResultKt.throwOnFailure(obj2);
                                            FlowCollector flowCollector = this.$this_unsafeFlow;
                                            ColorControl colorControl = ((ColorTemperatureLightDevice) obj).getStandardTraits().getColorControl();
                                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                            anonymousClass1.I$0 = 0;
                                            anonymousClass1.label = 1;
                                            if (flowCollector.emit(colorControl, anonymousClass1) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                        } else {
                                            if (i2 != 1) {
                                                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                                                return null;
                                            }
                                            ResultKt.throwOnFailure(obj2);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }

                                @Override // kotlinx.coroutines.flow.Flow
                                public Object collect(FlowCollector<? super ColorControl> flowCollector, Continuation continuation2) {
                                    Object objCollect = flowType2.collect(new AnonymousClass2(flowCollector), continuation2);
                                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                                }
                            });
                            anonymousClass12.L$0 = SpillingKt.nullOutSpilledVariable(list2);
                            anonymousClass12.L$1 = SpillingKt.nullOutSpilledVariable(iterable);
                            anonymousClass12.L$2 = it;
                            anonymousClass12.L$3 = SpillingKt.nullOutSpilledVariable(next);
                            anonymousClass12.L$4 = SpillingKt.nullOutSpilledVariable(homeDevice2);
                            anonymousClass12.L$5 = null;
                            anonymousClass12.I$0 = i3;
                            anonymousClass12.I$1 = iCoerceAtMost;
                            anonymousClass12.I$2 = iCoerceAtMost2;
                            anonymousClass12.I$3 = i2;
                            anonymousClass12.I$4 = 0;
                            anonymousClass12.label = 3;
                            Object objFirstOrNull2 = FlowKt.firstOrNull(flowDistinctUntilChanged2, anonymousClass12);
                            if (objFirstOrNull2 != coroutine_suspended) {
                                list5 = list2;
                                obj3 = objFirstOrNull2;
                                iterable4 = iterable;
                                i9 = i3;
                                anonymousClass1 = anonymousClass12;
                                i10 = i2;
                                obj2 = next;
                                i11 = 0;
                                try {
                                } catch (Exception e8) {
                                    e2 = e8;
                                }
                                colorControl2 = (ColorControl) obj3;
                                if (colorControl2 == null) {
                                    short sM2433constructorimpl = UShort.m2433constructorimpl((short) iCoerceAtMost);
                                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(list5);
                                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(iterable4);
                                    anonymousClass1.L$2 = it;
                                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(obj2);
                                    anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(homeDevice2);
                                    anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(colorControl2);
                                    anonymousClass1.I$0 = i9;
                                    anonymousClass1.I$1 = iCoerceAtMost;
                                    anonymousClass1.I$2 = iCoerceAtMost2;
                                    anonymousClass1.I$3 = i10;
                                    anonymousClass1.I$4 = i11;
                                    anonymousClass1.label = 4;
                                    AnonymousClass1 anonymousClass15 = anonymousClass1;
                                    if (colorControl2.mo609moveToColorTemperatureods4cfk(sM2433constructorimpl, (short) 10, (byte) 0, (byte) 0, anonymousClass15) != coroutine_suspended) {
                                        anonymousClass1 = anonymousClass15;
                                        i2 = i10;
                                        list2 = list5;
                                        anonymousClass12 = anonymousClass1;
                                        i3 = i9;
                                        iterable = iterable4;
                                        while (it.hasNext()) {
                                        }
                                    }
                                } else {
                                    AnonymousClass1 anonymousClass16 = anonymousClass1;
                                    i2 = i10;
                                    i3 = i9;
                                    iterable = iterable4;
                                    anonymousClass12 = anonymousClass16;
                                    list2 = list5;
                                    while (it.hasNext()) {
                                    }
                                }
                            }
                        }
                    }
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            i11 = anonymousClass1.I$4;
            i10 = anonymousClass1.I$3;
            iCoerceAtMost2 = anonymousClass1.I$2;
            iCoerceAtMost = anonymousClass1.I$1;
            int i16 = anonymousClass1.I$0;
            HomeDevice homeDevice3 = (HomeDevice) anonymousClass1.L$4;
            obj2 = anonymousClass1.L$3;
            Iterator it3 = (Iterator) anonymousClass1.L$2;
            Iterable iterable7 = (Iterable) anonymousClass1.L$1;
            List<? extends HomeDevice> list8 = (List) anonymousClass1.L$0;
            try {
                ResultKt.throwOnFailure(obj3);
                list5 = list8;
                iterable4 = iterable7;
                homeDevice2 = homeDevice3;
                it = it3;
                i9 = i16;
            } catch (Exception e9) {
                e2 = e9;
                it = it3;
                list2 = list8;
                i9 = i16;
                iterable4 = iterable7;
                Logger.logSevere("Home: error " + e2.getMessage());
                i2 = i10;
                anonymousClass12 = anonymousClass1;
                i3 = i9;
                iterable = iterable4;
                while (it.hasNext()) {
                }
                return Unit.INSTANCE;
            }
            colorControl2 = (ColorControl) obj3;
            if (colorControl2 == null) {
            }
            Logger.logSevere("Home: error " + e2.getMessage());
            i2 = i10;
            anonymousClass12 = anonymousClass1;
            i3 = i9;
            iterable = iterable4;
            while (it.hasNext()) {
            }
            return Unit.INSTANCE;
        }
        i8 = anonymousClass1.I$4;
        i7 = anonymousClass1.I$3;
        i6 = anonymousClass1.I$2;
        i5 = anonymousClass1.I$1;
        i4 = anonymousClass1.I$0;
        HomeDevice homeDevice4 = (HomeDevice) anonymousClass1.L$4;
        Object obj4 = anonymousClass1.L$3;
        Iterator it4 = (Iterator) anonymousClass1.L$2;
        Iterable iterable8 = (Iterable) anonymousClass1.L$1;
        List<? extends HomeDevice> list9 = (List) anonymousClass1.L$0;
        try {
            ResultKt.throwOnFailure(obj3);
            list4 = list9;
            obj = obj4;
            homeDevice = homeDevice4;
            it2 = it4;
            iterable3 = iterable8;
        } catch (Exception e10) {
            e = e10;
            it2 = it4;
            iterable2 = iterable8;
            list3 = list9;
            Logger.logSevere("Home: error " + e.getMessage());
            it = it2;
            list2 = list3;
            iCoerceAtMost = i5;
            iterable = iterable2;
            iCoerceAtMost2 = i6;
            i2 = i7;
            anonymousClass12 = anonymousClass1;
            i3 = i4;
            while (it.hasNext()) {
            }
            return Unit.INSTANCE;
        }
        colorControl = (ColorControl) obj3;
        if (colorControl == null) {
        }
        Logger.logSevere("Home: error " + e.getMessage());
        it = it2;
        list2 = list3;
        iCoerceAtMost = i5;
        iterable = iterable2;
        iCoerceAtMost2 = i6;
        i2 = i7;
        anonymousClass12 = anonymousClass1;
        i3 = i4;
        while (it.hasNext()) {
        }
        return Unit.INSTANCE;
    }

    public final HomeClient getClient() {
        return this.client;
    }

    public final Object getDevices(Continuation<? super Set<? extends HomeDevice>> continuation) {
        return this.client.devices().list(continuation);
    }

    public final Object getLightDevices(Continuation<? super List<? extends HomeDevice>> continuation) {
        final HomeObjectsFlow<HomeDevice> homeObjectsFlowDevices = this.client.devices();
        return FlowKt.first(new Flow<List<? extends HomeDevice>>() { // from class: com.urbandroid.sleep.service.google.home.GoogleHomeClient$getLightDevices$$inlined$map$1

            /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.home.GoogleHomeClient$getLightDevices$$inlined$map$1$2, reason: invalid class name */
            @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.home.GoogleHomeClient$getLightDevices$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
                @DebugMetadata(c = "com.urbandroid.sleep.service.google.home.GoogleHomeClient$getLightDevices$$inlined$map$1$2", f = "GoogleHomeClient.kt", l = {217}, m = "emit", v = 2)
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i = anonymousClass1.label;
                        if ((i & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i - Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    }
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i2 = anonymousClass1.label;
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        ArrayList arrayList = new ArrayList();
                        for (T t : (Set) obj) {
                            HomeDevice homeDevice = (HomeDevice) t;
                            if (homeDevice.has(DimmableLightDevice.INSTANCE) || homeDevice.has(OnOffLightDevice.INSTANCE) || homeDevice.has(ColorTemperatureLightDevice.INSTANCE) || homeDevice.has(ExtendedColorLightDevice.INSTANCE)) {
                                arrayList.add(t);
                            }
                        }
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(arrayList, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i2 != 1) {
                            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super List<? extends HomeDevice>> flowCollector, Continuation continuation2) {
                Object objCollect = homeObjectsFlowDevices.collect(new AnonymousClass2(flowCollector), continuation2);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, continuation);
    }

    public final Light getLightForDevice(HomeDevice device) {
        device.getClass();
        return new Light(device.getId(), device.getZzb(), device.has(DimmableLightDevice.INSTANCE) ? Light.Type.DIM : device.has(ColorTemperatureLightDevice.INSTANCE) ? Light.Type.CT : device.has(ExtendedColorLightDevice.INSTANCE) ? Light.Type.COLOR : Light.Type.SWITCH);
    }

    public final Object getOnOffDevices(Continuation<? super List<? extends HomeDevice>> continuation) {
        final HomeObjectsFlow<HomeDevice> homeObjectsFlowDevices = this.client.devices();
        return FlowKt.first(new Flow<List<? extends HomeDevice>>() { // from class: com.urbandroid.sleep.service.google.home.GoogleHomeClient$getOnOffDevices$$inlined$map$1

            /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.home.GoogleHomeClient$getOnOffDevices$$inlined$map$1$2, reason: invalid class name */
            @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.home.GoogleHomeClient$getOnOffDevices$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
                @DebugMetadata(c = "com.urbandroid.sleep.service.google.home.GoogleHomeClient$getOnOffDevices$$inlined$map$1$2", f = "GoogleHomeClient.kt", l = {217}, m = "emit", v = 2)
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i = anonymousClass1.label;
                        if ((i & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i - Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    }
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i2 = anonymousClass1.label;
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        ArrayList arrayList = new ArrayList();
                        for (T t : (Set) obj) {
                            if (((HomeDevice) t).has(OnOff.INSTANCE)) {
                                arrayList.add(t);
                            }
                        }
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(arrayList, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i2 != 1) {
                            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super List<? extends HomeDevice>> flowCollector, Continuation continuation2) {
                Object objCollect = homeObjectsFlowDevices.collect(new AnonymousClass2(flowCollector), continuation2);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getSelectedDevice(String str, Continuation<? super HomeDevice> continuation) {
        C21631 c21631;
        if (continuation instanceof C21631) {
            c21631 = (C21631) continuation;
            int i = c21631.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c21631.label = i - Integer.MIN_VALUE;
            } else {
                c21631 = new C21631(continuation);
            }
        }
        Object devices = c21631.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c21631.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(devices);
            c21631.L$0 = str;
            c21631.label = 1;
            devices = getDevices(c21631);
            if (devices == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            str = (String) c21631.L$0;
            ResultKt.throwOnFailure(devices);
        }
        for (Object obj : (Iterable) devices) {
            if (Intrinsics.areEqual(((HomeDevice) obj).getId(), str)) {
                return obj;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getSelectedDevices(Set<Light> set, Continuation<? super List<? extends HomeDevice>> continuation) {
        C21641 c21641;
        if (continuation instanceof C21641) {
            c21641 = (C21641) continuation;
            int i = c21641.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c21641.label = i - Integer.MIN_VALUE;
            } else {
                c21641 = new C21641(continuation);
            }
        }
        Object devices = c21641.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c21641.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(devices);
            c21641.L$0 = set;
            c21641.label = 1;
            devices = getDevices(c21641);
            if (devices == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            set = (Set) c21641.L$0;
            ResultKt.throwOnFailure(devices);
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : (Iterable) devices) {
            if (set.contains(getLightForDevice((HomeDevice) obj))) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f4 A[Catch: Exception -> 0x015a, TRY_LEAVE, TryCatch #3 {Exception -> 0x015a, blocks: (B:33:0x00ef, B:35:0x00f4), top: B:55:0x00ef }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00a8 -> B:46:0x018c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0149 -> B:39:0x0150). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0163 -> B:46:0x018c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x0176 -> B:39:0x0150). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object level(List<? extends HomeDevice> list, int i, Continuation<? super Unit> continuation) {
        C21651 c21651;
        Iterable iterable;
        C21651 c216512;
        Iterator it;
        int i2;
        List<? extends HomeDevice> list2;
        int i3;
        List<? extends HomeDevice> list3;
        Iterable iterable2;
        Iterator it2;
        int i4;
        int i5;
        Exception e;
        List<? extends HomeDevice> list4;
        Iterable iterable3;
        Iterator it3;
        int i6;
        C21651 c216513;
        Object obj;
        HomeDevice homeDevice;
        int i7;
        LevelControl levelControl;
        if (continuation instanceof C21651) {
            c21651 = (C21651) continuation;
            int i8 = c21651.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                c21651.label = i8 - Integer.MIN_VALUE;
            } else {
                c21651 = new C21651(continuation);
            }
        }
        Object obj2 = c21651.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = c21651.label;
        Object obj3 = null;
        if (i9 != 0) {
            if (i9 == 1) {
                int i10 = c21651.I$2;
                int i11 = c21651.I$1;
                int i12 = c21651.I$0;
                homeDevice = (HomeDevice) c21651.L$4;
                obj = c21651.L$3;
                Iterator it4 = (Iterator) c21651.L$2;
                Iterable iterable4 = (Iterable) c21651.L$1;
                List<? extends HomeDevice> list5 = (List) c21651.L$0;
                try {
                    ResultKt.throwOnFailure(obj2);
                    it3 = it4;
                    iterable3 = iterable4;
                    list4 = list5;
                    c216513 = c21651;
                    i7 = i10;
                    i5 = i11;
                    i6 = i12;
                } catch (Exception e2) {
                    e = e2;
                    i5 = i11;
                    i4 = i12;
                    it2 = it4;
                    iterable2 = iterable4;
                    list3 = list5;
                    Logger.logSevere("Home: error " + e.getMessage());
                    int i13 = i4;
                    c216512 = c21651;
                    list2 = list3;
                    iterable = iterable2;
                    it = it2;
                    i2 = i5;
                    i3 = i13;
                    obj3 = null;
                    if (it.hasNext()) {
                    }
                }
                levelControl = (LevelControl) obj2;
                if (levelControl == null) {
                }
            } else {
                if (i9 != 2) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                i5 = c21651.I$1;
                i4 = c21651.I$0;
                it2 = (Iterator) c21651.L$2;
                iterable2 = (Iterable) c21651.L$1;
                list3 = (List) c21651.L$0;
                try {
                    ResultKt.throwOnFailure(obj2);
                } catch (Exception e3) {
                    e = e3;
                    Logger.logSevere("Home: error " + e.getMessage());
                }
                int i132 = i4;
                c216512 = c21651;
                list2 = list3;
                iterable = iterable2;
                it = it2;
                i2 = i5;
                i3 = i132;
                obj3 = null;
                if (it.hasNext()) {
                    Object next = it.next();
                    HomeDevice homeDevice2 = (HomeDevice) next;
                    DimmableLightDevice.Companion companion = DimmableLightDevice.INSTANCE;
                    if (homeDevice2.has(companion)) {
                        try {
                        } catch (Exception e4) {
                            e = e4;
                            Iterable iterable5 = iterable;
                            list3 = list2;
                            c21651 = c216512;
                            i4 = i3;
                            i5 = i2;
                            it2 = it;
                            iterable2 = iterable5;
                        }
                        final Flow flowType = homeDevice2.type(companion);
                        Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(new Flow<LevelControl>() { // from class: com.urbandroid.sleep.service.google.home.GoogleHomeClient$level$lambda$0$$inlined$map$1

                            /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.home.GoogleHomeClient$level$lambda$0$$inlined$map$1$2, reason: invalid class name */
                            @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
                            public static final class AnonymousClass2<T> implements FlowCollector {
                                final /* synthetic */ FlowCollector $this_unsafeFlow;

                                /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.home.GoogleHomeClient$level$lambda$0$$inlined$map$1$2$1, reason: invalid class name */
                                @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
                                @DebugMetadata(c = "com.urbandroid.sleep.service.google.home.GoogleHomeClient$level$lambda$0$$inlined$map$1$2", f = "GoogleHomeClient.kt", l = {217}, m = "emit", v = 2)
                                public static final class AnonymousClass1 extends ContinuationImpl {
                                    int I$0;
                                    Object L$0;
                                    Object L$1;
                                    Object L$2;
                                    Object L$3;
                                    int label;
                                    /* synthetic */ Object result;

                                    public AnonymousClass1(Continuation continuation) {
                                        super(continuation);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object obj) {
                                        this.result = obj;
                                        this.label |= Integer.MIN_VALUE;
                                        return AnonymousClass2.this.emit(null, this);
                                    }
                                }

                                public AnonymousClass2(FlowCollector flowCollector) {
                                    this.$this_unsafeFlow = flowCollector;
                                }

                                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                                @Override // kotlinx.coroutines.flow.FlowCollector
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                */
                                public final Object emit(Object obj, Continuation continuation) {
                                    AnonymousClass1 anonymousClass1;
                                    if (continuation instanceof AnonymousClass1) {
                                        anonymousClass1 = (AnonymousClass1) continuation;
                                        int i = anonymousClass1.label;
                                        if ((i & Integer.MIN_VALUE) != 0) {
                                            anonymousClass1.label = i - Integer.MIN_VALUE;
                                        } else {
                                            anonymousClass1 = new AnonymousClass1(continuation);
                                        }
                                    }
                                    Object obj2 = anonymousClass1.result;
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i2 = anonymousClass1.label;
                                    if (i2 == 0) {
                                        ResultKt.throwOnFailure(obj2);
                                        FlowCollector flowCollector = this.$this_unsafeFlow;
                                        LevelControl levelControl = ((DimmableLightDevice) obj).getStandardTraits().getLevelControl();
                                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                        anonymousClass1.I$0 = 0;
                                        anonymousClass1.label = 1;
                                        if (flowCollector.emit(levelControl, anonymousClass1) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    } else {
                                        if (i2 != 1) {
                                            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                                            return null;
                                        }
                                        ResultKt.throwOnFailure(obj2);
                                    }
                                    return Unit.INSTANCE;
                                }
                            }

                            @Override // kotlinx.coroutines.flow.Flow
                            public Object collect(FlowCollector<? super LevelControl> flowCollector, Continuation continuation2) {
                                Object objCollect = flowType.collect(new AnonymousClass2(flowCollector), continuation2);
                                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                            }
                        });
                        c216512.L$0 = SpillingKt.nullOutSpilledVariable(list2);
                        c216512.L$1 = SpillingKt.nullOutSpilledVariable(iterable);
                        c216512.L$2 = it;
                        c216512.L$3 = SpillingKt.nullOutSpilledVariable(next);
                        c216512.L$4 = SpillingKt.nullOutSpilledVariable(homeDevice2);
                        c216512.L$5 = obj3;
                        c216512.I$0 = i3;
                        c216512.I$1 = i2;
                        c216512.I$2 = 0;
                        c216512.label = 1;
                        Object objFirstOrNull = FlowKt.firstOrNull(flowDistinctUntilChanged, c216512);
                        if (objFirstOrNull != coroutine_suspended) {
                            list4 = list2;
                            i6 = i3;
                            i7 = 0;
                            i5 = i2;
                            it3 = it;
                            iterable3 = iterable;
                            homeDevice = homeDevice2;
                            obj = next;
                            obj2 = objFirstOrNull;
                            c216513 = c216512;
                            try {
                            } catch (Exception e5) {
                                e = e5;
                                c21651 = c216513;
                                i4 = i6;
                                it2 = it3;
                                iterable2 = iterable3;
                                list3 = list4;
                            }
                            levelControl = (LevelControl) obj2;
                            if (levelControl == null) {
                                byte bM2367constructorimpl = UByte.m2367constructorimpl((byte) ((RangesKt.coerceAtMost(RangesKt.coerceAtLeast(i6, 0), 100) * PHIpAddressSearchManager.END_IP_SCAN) / 100));
                                UShort uShortM2432boximpl = UShort.m2432boximpl((short) 10);
                                Object obj4 = obj;
                                LevelControlTrait.OptionsBitmap optionsBitmap = new LevelControlTrait.OptionsBitmap(true, false);
                                LevelControlTrait.OptionsBitmap optionsBitmap2 = new LevelControlTrait.OptionsBitmap(true, false);
                                c216513.L$0 = SpillingKt.nullOutSpilledVariable(list4);
                                c216513.L$1 = SpillingKt.nullOutSpilledVariable(iterable3);
                                c216513.L$2 = it3;
                                c216513.L$3 = SpillingKt.nullOutSpilledVariable(obj4);
                                c216513.L$4 = SpillingKt.nullOutSpilledVariable(homeDevice);
                                c216513.L$5 = SpillingKt.nullOutSpilledVariable(levelControl);
                                c216513.I$0 = i6;
                                c216513.I$1 = i5;
                                c216513.I$2 = i7;
                                c216513.label = 2;
                                if (levelControl.mo711moveToLeveligwrCe0(bM2367constructorimpl, uShortM2432boximpl, optionsBitmap, optionsBitmap2, c216513) != coroutine_suspended) {
                                    c21651 = c216513;
                                    i4 = i6;
                                    it2 = it3;
                                    iterable2 = iterable3;
                                    list3 = list4;
                                    int i1322 = i4;
                                    c216512 = c21651;
                                    list2 = list3;
                                    iterable = iterable2;
                                    it = it2;
                                    i2 = i5;
                                    i3 = i1322;
                                }
                            } else {
                                i2 = i5;
                                c216512 = c216513;
                                i3 = i6;
                                it = it3;
                                iterable = iterable3;
                                list2 = list4;
                            }
                        }
                        return coroutine_suspended;
                    }
                    obj3 = null;
                    if (it.hasNext()) {
                        return Unit.INSTANCE;
                    }
                }
            }
            Logger.logSevere("Home: error " + e.getMessage());
            int i13222 = i4;
            c216512 = c21651;
            list2 = list3;
            iterable = iterable2;
            it = it2;
            i2 = i5;
            i3 = i13222;
            obj3 = null;
            if (it.hasNext()) {
            }
        } else {
            ResultKt.throwOnFailure(obj2);
            List<? extends HomeDevice> list6 = list;
            iterable = list6;
            c216512 = c21651;
            it = list6.iterator();
            i2 = 0;
            list2 = list;
            i3 = i;
            if (it.hasNext()) {
            }
        }
    }

    public final void requestPermissionsIfNeeded(GoogleHomePermission listener) {
        listener.getClass();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C21661(listener, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object requestPermissionsSuspend(Continuation<? super Unit> continuation) {
        C21671 c21671;
        PermissionsResult permissionsResult;
        if (continuation instanceof C21671) {
            c21671 = (C21671) continuation;
            int i = c21671.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c21671.label = i - Integer.MIN_VALUE;
            } else {
                c21671 = new C21671(continuation);
            }
        }
        Object objRequestPermissions = c21671.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c21671.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objRequestPermissions);
                Logger.logInfo("Home: request permission");
                HomeClient homeClient = this.client;
                c21671.label = 1;
                objRequestPermissions = homeClient.requestPermissions(true, c21671);
                if (objRequestPermissions == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(objRequestPermissions);
            }
            permissionsResult = (PermissionsResult) objRequestPermissions;
        } catch (HomeException e) {
            permissionsResult = new PermissionsResult(PermissionsResultStatus.ERROR, FileInsert$$ExternalSyntheticOutline0.m("Home: Got HomeException with error: ", e.getMessage()));
        }
        Logger.logInfo("Home: request permission after");
        int i3 = WhenMappings.$EnumSwitchMapping$0[permissionsResult.getStatus().ordinal()];
        if (i3 == 1) {
            Logger.logInfo("Home: Permissions successfully granted.");
        } else if (i3 != 2) {
            Logger.logSevere("Home: Failed to grant permissions with error: " + permissionsResult.getStatus() + ", " + permissionsResult.getErrorMessage());
        } else {
            Logger.logInfo("Home: User cancelled Permissions flow.");
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0184, code lost:
    
        if (r0.off(r1) == r2) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0146, code lost:
    
        r9 = r10;
        r10 = r13;
        r12 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01af, code lost:
    
        r9 = r10;
        r10 = r3;
        r3 = r9;
        r9 = r1;
        r12 = r11;
        r11 = r13;
        r1 = r15;
     */
    /* JADX WARN: Path cross not found for [B:46:0x0156, B:38:0x0112], limit reached: 64 */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00c6 -> B:54:0x01af). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0199 -> B:43:0x0146). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object toggle(List<? extends HomeDevice> list, boolean z, Continuation<? super Unit> continuation) {
        C21681 c21681;
        Iterable iterable;
        C21681 c216812;
        Iterator it;
        int i;
        List<? extends HomeDevice> list2;
        boolean z2;
        List<? extends HomeDevice> list3;
        Iterable iterable2;
        Iterator it2;
        boolean z3;
        int i2;
        Exception e;
        List<? extends HomeDevice> list4;
        Object obj;
        Iterator it3;
        HomeDevice homeDevice;
        boolean z4;
        int i3;
        if (continuation instanceof C21681) {
            c21681 = (C21681) continuation;
            int i4 = c21681.label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                c21681.label = i4 - Integer.MIN_VALUE;
            } else {
                c21681 = new C21681(continuation);
            }
        }
        Object obj2 = c21681.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = c21681.label;
        Object obj3 = null;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj2);
            List<? extends HomeDevice> list5 = list;
            iterable = list5;
            c216812 = c21681;
            it = list5.iterator();
            i = 0;
            list2 = list;
            z2 = z;
            if (!it.hasNext()) {
            }
        } else if (i5 == 1) {
            int i6 = c21681.I$1;
            int i7 = c21681.I$0;
            z4 = c21681.Z$0;
            HomeDevice homeDevice2 = (HomeDevice) c21681.L$4;
            Object obj4 = c21681.L$3;
            it3 = (Iterator) c21681.L$2;
            Iterable iterable3 = (Iterable) c21681.L$1;
            list4 = (List) c21681.L$0;
            try {
                ResultKt.throwOnFailure(obj2);
                i3 = i6;
                i2 = i7;
                homeDevice = homeDevice2;
                iterable2 = iterable3;
                obj = obj4;
            } catch (Exception e2) {
                e = e2;
                i2 = i7;
                z3 = z4;
                it2 = it3;
                iterable2 = iterable3;
                list3 = list4;
                Logger.logSevere("Home: error " + e.getMessage());
                boolean z5 = z3;
                c216812 = c21681;
                list2 = list3;
                iterable = iterable2;
                it = it2;
                i = i2;
                z2 = z5;
                obj3 = null;
                if (!it.hasNext()) {
                }
            }
            OnOff onOff = (OnOff) obj2;
            if (!z4) {
            }
        } else {
            if (i5 != 2 && i5 != 3) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            i2 = c21681.I$0;
            z3 = c21681.Z$0;
            it2 = (Iterator) c21681.L$2;
            iterable2 = (Iterable) c21681.L$1;
            list3 = (List) c21681.L$0;
            try {
                ResultKt.throwOnFailure(obj2);
            } catch (Exception e3) {
                e = e3;
                Logger.logSevere("Home: error " + e.getMessage());
            }
            boolean z52 = z3;
            c216812 = c21681;
            list2 = list3;
            iterable = iterable2;
            it = it2;
            i = i2;
            z2 = z52;
            obj3 = null;
            if (!it.hasNext()) {
                Object next = it.next();
                HomeDevice homeDevice3 = (HomeDevice) next;
                OnOffLightDevice.Companion companion = OnOffLightDevice.INSTANCE;
                if (homeDevice3.has(companion)) {
                    try {
                    } catch (Exception e4) {
                        e = e4;
                        Iterable iterable4 = iterable;
                        list3 = list2;
                        c21681 = c216812;
                        z3 = z2;
                        i2 = i;
                        it2 = it;
                        iterable2 = iterable4;
                        Logger.logSevere("Home: error " + e.getMessage());
                        boolean z522 = z3;
                        c216812 = c21681;
                        list2 = list3;
                        iterable = iterable2;
                        it = it2;
                        i = i2;
                        z2 = z522;
                        obj3 = null;
                        if (!it.hasNext()) {
                        }
                    }
                    final Flow flowType = homeDevice3.type(companion);
                    Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(new Flow<OnOff>() { // from class: com.urbandroid.sleep.service.google.home.GoogleHomeClient$toggle$lambda$0$$inlined$map$1

                        /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.home.GoogleHomeClient$toggle$lambda$0$$inlined$map$1$2, reason: invalid class name */
                        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
                        public static final class AnonymousClass2<T> implements FlowCollector {
                            final /* synthetic */ FlowCollector $this_unsafeFlow;

                            /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.home.GoogleHomeClient$toggle$lambda$0$$inlined$map$1$2$1, reason: invalid class name */
                            @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
                            @DebugMetadata(c = "com.urbandroid.sleep.service.google.home.GoogleHomeClient$toggle$lambda$0$$inlined$map$1$2", f = "GoogleHomeClient.kt", l = {217}, m = "emit", v = 2)
                            public static final class AnonymousClass1 extends ContinuationImpl {
                                int I$0;
                                Object L$0;
                                Object L$1;
                                Object L$2;
                                Object L$3;
                                int label;
                                /* synthetic */ Object result;

                                public AnonymousClass1(Continuation continuation) {
                                    super(continuation);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    this.result = obj;
                                    this.label |= Integer.MIN_VALUE;
                                    return AnonymousClass2.this.emit(null, this);
                                }
                            }

                            public AnonymousClass2(FlowCollector flowCollector) {
                                this.$this_unsafeFlow = flowCollector;
                            }

                            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                            @Override // kotlinx.coroutines.flow.FlowCollector
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final Object emit(Object obj, Continuation continuation) {
                                AnonymousClass1 anonymousClass1;
                                if (continuation instanceof AnonymousClass1) {
                                    anonymousClass1 = (AnonymousClass1) continuation;
                                    int i = anonymousClass1.label;
                                    if ((i & Integer.MIN_VALUE) != 0) {
                                        anonymousClass1.label = i - Integer.MIN_VALUE;
                                    } else {
                                        anonymousClass1 = new AnonymousClass1(continuation);
                                    }
                                }
                                Object obj2 = anonymousClass1.result;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i2 = anonymousClass1.label;
                                if (i2 == 0) {
                                    ResultKt.throwOnFailure(obj2);
                                    FlowCollector flowCollector = this.$this_unsafeFlow;
                                    OnOff onOff = ((OnOffLightDevice) obj).getStandardTraits().getOnOff();
                                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                    anonymousClass1.I$0 = 0;
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(onOff, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else {
                                    if (i2 != 1) {
                                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                                        return null;
                                    }
                                    ResultKt.throwOnFailure(obj2);
                                }
                                return Unit.INSTANCE;
                            }
                        }

                        @Override // kotlinx.coroutines.flow.Flow
                        public Object collect(FlowCollector<? super OnOff> flowCollector, Continuation continuation2) {
                            Object objCollect = flowType.collect(new AnonymousClass2(flowCollector), continuation2);
                            return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                        }
                    });
                    c216812.L$0 = SpillingKt.nullOutSpilledVariable(list2);
                    c216812.L$1 = SpillingKt.nullOutSpilledVariable(iterable);
                    c216812.L$2 = it;
                    c216812.L$3 = SpillingKt.nullOutSpilledVariable(next);
                    c216812.L$4 = SpillingKt.nullOutSpilledVariable(homeDevice3);
                    c216812.L$5 = obj3;
                    c216812.Z$0 = z2;
                    c216812.I$0 = i;
                    c216812.I$1 = 0;
                    c216812.label = 1;
                    Object objFirstOrNull = FlowKt.firstOrNull(flowDistinctUntilChanged, c216812);
                    if (objFirstOrNull != coroutine_suspended) {
                        obj = next;
                        obj2 = objFirstOrNull;
                        int i8 = i;
                        z4 = z2;
                        i2 = i8;
                        it3 = it;
                        iterable2 = iterable;
                        homeDevice = homeDevice3;
                        list4 = list2;
                        c21681 = c216812;
                        i3 = 0;
                        try {
                        } catch (Exception e5) {
                            e = e5;
                            z3 = z4;
                            it2 = it3;
                            list3 = list4;
                            Logger.logSevere("Home: error " + e.getMessage());
                            boolean z5222 = z3;
                            c216812 = c21681;
                            list2 = list3;
                            iterable = iterable2;
                            it = it2;
                            i = i2;
                            z2 = z5222;
                            obj3 = null;
                            if (!it.hasNext()) {
                            }
                        }
                        OnOff onOff2 = (OnOff) obj2;
                        if (!z4) {
                            if (onOff2 != null) {
                                c21681.L$0 = SpillingKt.nullOutSpilledVariable(list4);
                                c21681.L$1 = SpillingKt.nullOutSpilledVariable(iterable2);
                                c21681.L$2 = it3;
                                c21681.L$3 = SpillingKt.nullOutSpilledVariable(obj);
                                c21681.L$4 = SpillingKt.nullOutSpilledVariable(homeDevice);
                                c21681.L$5 = SpillingKt.nullOutSpilledVariable(onOff2);
                                c21681.Z$0 = z4;
                                c21681.I$0 = i2;
                                c21681.I$1 = i3;
                                c21681.label = 3;
                            }
                            boolean z6 = z4;
                            i = i2;
                            z2 = z6;
                            c216812 = c21681;
                            iterable = iterable2;
                            it = it3;
                            list2 = list4;
                        } else if (onOff2 != null) {
                            c21681.L$0 = SpillingKt.nullOutSpilledVariable(list4);
                            c21681.L$1 = SpillingKt.nullOutSpilledVariable(iterable2);
                            c21681.L$2 = it3;
                            c21681.L$3 = SpillingKt.nullOutSpilledVariable(obj);
                            c21681.L$4 = SpillingKt.nullOutSpilledVariable(homeDevice);
                            c21681.L$5 = SpillingKt.nullOutSpilledVariable(onOff2);
                            c21681.Z$0 = z4;
                            c21681.I$0 = i2;
                            c21681.I$1 = i3;
                            c21681.label = 2;
                            if (onOff2.on(c21681) != coroutine_suspended) {
                                z3 = z4;
                                it2 = it3;
                                list3 = list4;
                                boolean z52222 = z3;
                                c216812 = c21681;
                                list2 = list3;
                                iterable = iterable2;
                                it = it2;
                                i = i2;
                                z2 = z52222;
                            }
                        } else {
                            boolean z62 = z4;
                            i = i2;
                            z2 = z62;
                            c216812 = c21681;
                            iterable = iterable2;
                            it = it3;
                            list2 = list4;
                        }
                    }
                    return coroutine_suspended;
                }
                obj3 = null;
                if (!it.hasNext()) {
                    return Unit.INSTANCE;
                }
            }
        }
    }

    public /* synthetic */ GoogleHomeClient(Context context, HomeClient homeClient, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, homeClient);
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.home.GoogleHomeClient$requestPermissionsIfNeeded$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.home.GoogleHomeClient$requestPermissionsIfNeeded$1", f = "GoogleHomeClient.kt", l = {258}, m = "invokeSuspend", v = 2)
    public static final class C21661 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ GoogleHomePermission $listener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C21661(GoogleHomePermission googleHomePermission, Continuation<? super C21661> continuation) {
            super(2, continuation);
            this.$listener = googleHomePermission;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GoogleHomeClient.this.new C21661(this.$listener, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C21661) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<PermissionsState> flowHasPermissions = GoogleHomeClient.this.getClient().hasPermissions();
                C00461 c00461 = new C00461(this.$listener, GoogleHomeClient.this);
                this.label = 1;
                if (flowHasPermissions.collect(c00461, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.home.GoogleHomeClient$requestPermissionsIfNeeded$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
        public static final class C00461<T> implements FlowCollector {
            final /* synthetic */ GoogleHomePermission $listener;
            final /* synthetic */ GoogleHomeClient this$0;

            /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.home.GoogleHomeClient$requestPermissionsIfNeeded$1$1$WhenMappings */
            @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
            public static final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[PermissionsState.values().length];
                    try {
                        iArr[PermissionsState.GRANTED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[PermissionsState.PERMISSIONS_STATE_UNAVAILABLE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[PermissionsState.NOT_GRANTED.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            public C00461(GoogleHomePermission googleHomePermission, GoogleHomeClient googleHomeClient) {
                this.$listener = googleHomePermission;
                this.this$0 = googleHomeClient;
            }

            /* JADX WARN: Code restructure failed: missing block: B:28:0x0086, code lost:
            
                if (r8.requestPermissionsSuspend(r0) == r1) goto L43;
             */
            /* JADX WARN: Code restructure failed: missing block: B:33:0x009a, code lost:
            
                if (r10.requestPermissionsSuspend(r0) == r1) goto L43;
             */
            /* JADX WARN: Code restructure failed: missing block: B:37:0x00b6, code lost:
            
                if (r8.requestPermissionsSuspend(r0) == r1) goto L43;
             */
            /* JADX WARN: Code restructure failed: missing block: B:42:0x00cf, code lost:
            
                if (r8.requestPermissionsSuspend(r0) == r1) goto L43;
             */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object emit(PermissionsState permissionsState, Continuation<? super Unit> continuation) {
                GoogleHomeClient$requestPermissionsIfNeeded$1$1$emit$1 googleHomeClient$requestPermissionsIfNeeded$1$1$emit$1;
                if (continuation instanceof GoogleHomeClient$requestPermissionsIfNeeded$1$1$emit$1) {
                    googleHomeClient$requestPermissionsIfNeeded$1$1$emit$1 = (GoogleHomeClient$requestPermissionsIfNeeded$1$1$emit$1) continuation;
                    int i = googleHomeClient$requestPermissionsIfNeeded$1$1$emit$1.label;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        googleHomeClient$requestPermissionsIfNeeded$1$1$emit$1.label = i - Integer.MIN_VALUE;
                    } else {
                        googleHomeClient$requestPermissionsIfNeeded$1$1$emit$1 = new GoogleHomeClient$requestPermissionsIfNeeded$1$1$emit$1(this, continuation);
                    }
                }
                Object obj = googleHomeClient$requestPermissionsIfNeeded$1$1$emit$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i2 = googleHomeClient$requestPermissionsIfNeeded$1$1$emit$1.label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (permissionsState != PermissionsState.GRANTED) {
                        PermissionsState permissionsState2 = PermissionsState.GRANTED;
                    }
                    int i3 = WhenMappings.$EnumSwitchMapping$0[permissionsState.ordinal()];
                    if (i3 == 1) {
                        this.$listener.hasPermission(true);
                        GoogleHomeClient googleHomeClient = this.this$0;
                        googleHomeClient$requestPermissionsIfNeeded$1$1$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(permissionsState);
                        googleHomeClient$requestPermissionsIfNeeded$1$1$emit$1.label = 1;
                    } else if (i3 == 2) {
                        this.$listener.hasPermission(false);
                        GoogleHomeClient googleHomeClient2 = this.this$0;
                        googleHomeClient$requestPermissionsIfNeeded$1$1$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(permissionsState);
                        googleHomeClient$requestPermissionsIfNeeded$1$1$emit$1.label = 2;
                    } else if (i3 != 3) {
                        this.$listener.hasPermission(false);
                        Logger.logSevere("HomeClient.hasPermissions state should be PermissionsState.GRANTED or PermissionsState.PERMISSIONS_STATE_UNAVAILABLE");
                        GoogleHomeClient googleHomeClient3 = this.this$0;
                        googleHomeClient$requestPermissionsIfNeeded$1$1$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(permissionsState);
                        googleHomeClient$requestPermissionsIfNeeded$1$1$emit$1.label = 4;
                    } else {
                        GoogleHomeClient googleHomeClient4 = this.this$0;
                        googleHomeClient$requestPermissionsIfNeeded$1$1$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(permissionsState);
                        googleHomeClient$requestPermissionsIfNeeded$1$1$emit$1.label = 3;
                    }
                    return coroutine_suspended;
                }
                if (i2 == 1) {
                    ResultKt.throwOnFailure(obj);
                    Boxing.boxBoolean(true);
                } else {
                    if (i2 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    if (i2 != 3) {
                        if (i2 != 4) {
                            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj);
                    this.$listener.hasPermission(false);
                }
                return Unit.INSTANCE;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((PermissionsState) obj, (Continuation<? super Unit>) continuation);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a1, code lost:
    
        if (r5.off(r0) == r8) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object toggle(HomeDevice homeDevice, boolean z, Continuation<? super Unit> continuation) {
        AnonymousClass3 anonymousClass3;
        if (continuation instanceof AnonymousClass3) {
            anonymousClass3 = (AnonymousClass3) continuation;
            int i = anonymousClass3.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass3.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass3 = new AnonymousClass3(continuation);
            }
        }
        Object objFirstOrNull = anonymousClass3.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass3.label;
        try {
        } catch (Exception e) {
            Logger.logSevere("Home: error " + e.getMessage());
        }
        if (i2 == 0) {
            ResultKt.throwOnFailure(objFirstOrNull);
            OnOff.Companion companion = OnOff.INSTANCE;
            if (homeDevice.has(companion)) {
                Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(homeDevice.trait(companion));
                anonymousClass3.L$0 = SpillingKt.nullOutSpilledVariable(homeDevice);
                anonymousClass3.Z$0 = z;
                anonymousClass3.label = 1;
                objFirstOrNull = FlowKt.firstOrNull(flowDistinctUntilChanged, anonymousClass3);
                if (objFirstOrNull != coroutine_suspended) {
                    OnOff onOff = (OnOff) objFirstOrNull;
                    if (!z) {
                    }
                }
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        if (i2 != 1) {
            if (i2 != 2 && i2 != 3) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(objFirstOrNull);
            return Unit.INSTANCE;
        }
        z = anonymousClass3.Z$0;
        homeDevice = (HomeDevice) anonymousClass3.L$0;
        ResultKt.throwOnFailure(objFirstOrNull);
        OnOff onOff2 = (OnOff) objFirstOrNull;
        if (!z) {
            if (onOff2 != null) {
                anonymousClass3.L$0 = SpillingKt.nullOutSpilledVariable(homeDevice);
                anonymousClass3.L$1 = SpillingKt.nullOutSpilledVariable(onOff2);
                anonymousClass3.Z$0 = z;
                anonymousClass3.label = 2;
                if (onOff2.on(anonymousClass3) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (onOff2 != null) {
            anonymousClass3.L$0 = SpillingKt.nullOutSpilledVariable(homeDevice);
            anonymousClass3.L$1 = SpillingKt.nullOutSpilledVariable(onOff2);
            anonymousClass3.Z$0 = z;
            anonymousClass3.label = 3;
        }
        return Unit.INSTANCE;
    }
}
