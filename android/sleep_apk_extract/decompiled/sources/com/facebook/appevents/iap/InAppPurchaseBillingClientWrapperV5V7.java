package com.facebook.appevents.iap;

import android.content.Context;
import android.util.Log;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.work.impl.Schedulers$$ExternalSyntheticLambda1;
import com.facebook.appevents.iap.InAppPurchaseUtils;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u000e\b\u0007\u0018\u0000 K2\u00020\u0001:\u0002KLB\u0083\u0003\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u0017\u0012\u0006\u0010\u001f\u001a\u00020\u0017\u0012\u0006\u0010 \u001a\u00020\u0017\u0012\u0006\u0010!\u001a\u00020\u0017\u0012\u0006\u0010\"\u001a\u00020\u0017\u0012\u0006\u0010#\u001a\u00020\u0017\u0012\u0006\u0010$\u001a\u00020\u0017\u0012\u0006\u0010%\u001a\u00020\u0017\u0012\u0006\u0010&\u001a\u00020\u0017\u0012\u0006\u0010'\u001a\u00020\u0017\u0012\u0006\u0010(\u001a\u00020\u0017\u0012\u0006\u0010)\u001a\u00020\u0017\u0012\u0006\u0010*\u001a\u00020\u0017\u0012\u0006\u0010+\u001a\u00020\u0017¢\u0006\u0002\u0010,J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u000204J\"\u00106\u001a\u0004\u0018\u00010\u00032\u0006\u00107\u001a\u0002082\u000e\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001040:H\u0002J\u0012\u0010;\u001a\u0004\u0018\u00010\u00032\u0006\u00107\u001a\u000208H\u0002J\u0012\u0010<\u001a\u0004\u0018\u00010\u00032\u0006\u00107\u001a\u000208H\u0002J-\u0010=\u001a\u0002002\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010?2\u000e\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010?H\u0002¢\u0006\u0002\u0010AJ-\u0010B\u001a\u0002002\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010?2\u000e\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010?H\u0002¢\u0006\u0002\u0010AJ-\u0010C\u001a\u0002002\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010?2\u000e\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010?H\u0002¢\u0006\u0002\u0010AJ-\u0010D\u001a\u0002002\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010?2\u000e\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010?H\u0002¢\u0006\u0002\u0010AJ-\u0010E\u001a\u0002002\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010?2\u000e\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010?H\u0002¢\u0006\u0002\u0010AJ&\u0010F\u001a\u0002002\u0006\u00107\u001a\u0002082\f\u00109\u001a\b\u0012\u0004\u0012\u0002040:2\u0006\u0010G\u001a\u000202H\u0002J\u0018\u0010H\u001a\u0002002\u0006\u00107\u001a\u0002082\u0006\u0010G\u001a\u000202H\u0016J\u0018\u0010I\u001a\u0002002\u0006\u00107\u001a\u0002082\u0006\u0010G\u001a\u000202H\u0016J\u0010\u0010J\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0012\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapperV5V7;", "Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper;", "billingClient", "", "billingClientClazz", "Ljava/lang/Class;", "purchaseClazz", "productDetailsClazz", "purchaseHistoryRecordClazz", "queryProductDetailsParamsProductClazz", "billingResultClazz", "queryProductDetailsParamsClazz", "queryPurchaseHistoryParamsClazz", "queryPurchasesParamsClazz", "queryProductDetailsParamsBuilderClazz", "queryPurchaseHistoryParamsBuilderClazz", "queryPurchasesParamsBuilderClazz", "queryProductDetailsParamsProductBuilderClazz", "billingClientStateListenerClazz", "productDetailsResponseListenerClazz", "purchasesResponseListenerClazz", "purchaseHistoryResponseListenerClazz", "queryPurchasesAsyncMethod", "Ljava/lang/reflect/Method;", "queryPurchasesParamsNewBuilderMethod", "queryPurchasesParamsBuilderBuildMethod", "queryPurchasesParamsBuilderSetProductTypeMethod", "purchaseGetOriginalJsonMethod", "queryPurchaseHistoryAsyncMethod", "queryPurchaseHistoryParamsNewBuilderMethod", "queryPurchaseHistoryParamsBuilderBuildMethod", "queryPurchaseHistoryParamsBuilderSetProductTypeMethod", "purchaseHistoryRecordGetOriginalJsonMethod", "queryProductDetailsAsyncMethod", "queryProductDetailsParamsNewBuilderMethod", "queryProductDetailsParamsBuilderBuildMethod", "queryProductDetailsParamsBuilderSetProductListMethod", "queryProductDetailsParamsProductNewBuilderMethod", "queryProductDetailsParamsProductBuilderBuildMethod", "queryProductDetailsParamsProductBuilderSetProductIdMethod", "queryProductDetailsParamsProductBuilderSetProductTypeMethod", "productDetailsToStringMethod", "billingClientStartConnectionMethod", "billingResultGetResponseCodeMethod", "(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getBillingClient", "()Ljava/lang/Object;", "executeServiceRequest", "", "runnable", "Ljava/lang/Runnable;", InAppPurchaseConstants.METHOD_GET_ORIGINAL_JSON, "", "productDetailsString", "getQueryProductDetailsParams", "productType", "Lcom/facebook/appevents/iap/InAppPurchaseUtils$IAPProductType;", "productIds", "", "getQueryPurchaseHistoryParams", "getQueryPurchasesParams", InAppPurchaseConstants.METHOD_ON_BILLING_SERVICE_DISCONNECTED, "wrapperArgs", "", "listenerArgs", "([Ljava/lang/Object;[Ljava/lang/Object;)V", InAppPurchaseConstants.METHOD_ON_BILLING_SETUP_FINISHED, InAppPurchaseConstants.METHOD_ON_PRODUCT_DETAILS_RESPONSE, InAppPurchaseConstants.METHOD_ON_PURCHASE_HISTORY_RESPONSE, InAppPurchaseConstants.METHOD_ON_QUERY_PURCHASES_RESPONSE, InAppPurchaseConstants.METHOD_QUERY_PRODUCT_DETAILS_ASYNC, "completionHandler", "queryPurchaseHistory", InAppPurchaseConstants.METHOD_QUERY_PURCHASES, InAppPurchaseConstants.METHOD_START_CONNECTION, "Companion", "ListenerWrapper", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class InAppPurchaseBillingClientWrapperV5V7 implements InAppPurchaseBillingClientWrapper {
    private static InAppPurchaseBillingClientWrapperV5V7 instance;
    private final Object billingClient;
    private final Class<?> billingClientClazz;
    private final Method billingClientStartConnectionMethod;
    private final Class<?> billingClientStateListenerClazz;
    private final Class<?> billingResultClazz;
    private final Method billingResultGetResponseCodeMethod;
    private final Class<?> productDetailsClazz;
    private final Class<?> productDetailsResponseListenerClazz;
    private final Method productDetailsToStringMethod;
    private final Class<?> purchaseClazz;
    private final Method purchaseGetOriginalJsonMethod;
    private final Class<?> purchaseHistoryRecordClazz;
    private final Method purchaseHistoryRecordGetOriginalJsonMethod;
    private final Class<?> purchaseHistoryResponseListenerClazz;
    private final Class<?> purchasesResponseListenerClazz;
    private final Method queryProductDetailsAsyncMethod;
    private final Method queryProductDetailsParamsBuilderBuildMethod;
    private final Class<?> queryProductDetailsParamsBuilderClazz;
    private final Method queryProductDetailsParamsBuilderSetProductListMethod;
    private final Class<?> queryProductDetailsParamsClazz;
    private final Method queryProductDetailsParamsNewBuilderMethod;
    private final Method queryProductDetailsParamsProductBuilderBuildMethod;
    private final Class<?> queryProductDetailsParamsProductBuilderClazz;
    private final Method queryProductDetailsParamsProductBuilderSetProductIdMethod;
    private final Method queryProductDetailsParamsProductBuilderSetProductTypeMethod;
    private final Class<?> queryProductDetailsParamsProductClazz;
    private final Method queryProductDetailsParamsProductNewBuilderMethod;
    private final Method queryPurchaseHistoryAsyncMethod;
    private final Method queryPurchaseHistoryParamsBuilderBuildMethod;
    private final Class<?> queryPurchaseHistoryParamsBuilderClazz;
    private final Method queryPurchaseHistoryParamsBuilderSetProductTypeMethod;
    private final Class<?> queryPurchaseHistoryParamsClazz;
    private final Method queryPurchaseHistoryParamsNewBuilderMethod;
    private final Method queryPurchasesAsyncMethod;
    private final Method queryPurchasesParamsBuilderBuildMethod;
    private final Class<?> queryPurchasesParamsBuilderClazz;
    private final Method queryPurchasesParamsBuilderSetProductTypeMethod;
    private final Class<?> queryPurchasesParamsClazz;
    private final Method queryPurchasesParamsNewBuilderMethod;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = InAppPurchaseBillingClientWrapperV5V7.class.getCanonicalName();
    private static final AtomicBoolean isServiceConnected = new AtomicBoolean(false);
    private static final Map<String, JSONObject> iapPurchaseDetailsMap = new ConcurrentHashMap();
    private static final Map<String, JSONObject> subsPurchaseDetailsMap = new ConcurrentHashMap();
    private static final Map<String, JSONObject> productDetailsMap = new ConcurrentHashMap();

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u00192\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u00192\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u0019H\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J0\u0010\u001e\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020!2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010#H\u0096\u0002¢\u0006\u0002\u0010$R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000fR\u001d\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\nR\u001d\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\n¨\u0006%"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapperV5V7$Companion;", "Ljava/lang/reflect/InvocationHandler;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "iapPurchaseDetailsMap", "", "Lorg/json/JSONObject;", "getIapPurchaseDetailsMap", "()Ljava/util/Map;", "instance", "Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapperV5V7;", "isServiceConnected", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "productDetailsMap", "getProductDetailsMap", "subsPurchaseDetailsMap", "getSubsPurchaseDetailsMap", "createBillingClient", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "billingClientClazz", "Ljava/lang/Class;", "billingClientBuilderClazz", "purchasesUpdatedListenerClazz", "createInstance", "getOrCreateInstance", "invoke", "proxy", "m", "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion implements InvocationHandler {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Object createBillingClient(Context context, Class<?> billingClientClazz, Class<?> billingClientBuilderClazz, Class<?> purchasesUpdatedListenerClazz) {
            Object objInvokeMethod;
            Method method = InAppPurchaseUtils.getMethod(billingClientClazz, InAppPurchaseConstants.METHOD_NEW_BUILDER, Context.class);
            Method method2 = InAppPurchaseUtils.getMethod(billingClientBuilderClazz, InAppPurchaseConstants.METHOD_SET_LISTENER, purchasesUpdatedListenerClazz);
            Method method3 = InAppPurchaseUtils.getMethod(billingClientBuilderClazz, InAppPurchaseConstants.METHOD_ENABLE_PENDING_PURCHASES, new Class[0]);
            Method method4 = InAppPurchaseUtils.getMethod(billingClientBuilderClazz, InAppPurchaseConstants.METHOD_BUILD, new Class[0]);
            if (method4 == null || method2 == null || method == null || method3 == null || (objInvokeMethod = InAppPurchaseUtils.invokeMethod(billingClientBuilderClazz, method2, InAppPurchaseUtils.invokeMethod(billingClientClazz, method, null, context), Proxy.newProxyInstance(purchasesUpdatedListenerClazz.getClassLoader(), new Class[]{purchasesUpdatedListenerClazz}, this))) == null) {
                return null;
            }
            return InAppPurchaseUtils.invokeMethod(billingClientBuilderClazz, method4, InAppPurchaseUtils.invokeMethod(billingClientBuilderClazz, method3, objInvokeMethod, new Object[0]), new Object[0]);
        }

        private final InAppPurchaseBillingClientWrapperV5V7 createInstance(Context context) {
            Class<?> cls = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_BILLING_CLIENT);
            Class<?> cls2 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_PURCHASE);
            Class<?> cls3 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_PRODUCT_DETAILS);
            Class<?> cls4 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_PURCHASE_HISTORY_RECORD);
            Class<?> cls5 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_QUERY_PRODUCT_DETAILS_PARAMS_PRODUCT);
            Class<?> cls6 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_BILLING_RESULT);
            Class<?> cls7 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_QUERY_PRODUCT_DETAILS_PARAMS);
            Class<?> cls8 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_QUERY_PURCHASE_HISTORY_PARAMS);
            Class<?> cls9 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_QUERY_PURCHASES_PARAMS);
            Class<?> cls10 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_QUERY_PRODUCT_DETAILS_PARAMS_BUILDER);
            Class<?> cls11 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_QUERY_PURCHASE_HISTORY_PARAMS_BUILDER);
            Class<?> cls12 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_QUERY_PURCHASES_PARAMS_BUILDER);
            Class<?> cls13 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_QUERY_PRODUCT_DETAILS_PARAMS_PRODUCT_BUILDER);
            Class<?> cls14 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_BILLING_CLIENT_BUILDER);
            Class<?> cls15 = InAppPurchaseUtils.getClass("com.android.billingclient.api.PurchasesUpdatedListener");
            Class<?> cls16 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_BILLING_CLIENT_STATE_LISTENER);
            Class<?> cls17 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_PRODUCT_DETAILS_RESPONSE_LISTENER);
            Class<?> cls18 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_PURCHASES_RESPONSE_LISTENER);
            Class<?> cls19 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_PURCHASE_HISTORY_RESPONSE_LISTENER);
            if (cls == null || cls2 == null || cls3 == null || cls4 == null || cls5 == null || cls6 == null || cls7 == null || cls8 == null || cls9 == null || cls10 == null || cls11 == null || cls12 == null || cls13 == null || cls14 == null || cls15 == null || cls16 == null || cls17 == null || cls18 == null || cls19 == null) {
                Log.w(InAppPurchaseBillingClientWrapperV5V7.access$getTAG$cp(), "Failed to create Google Play billing library wrapper for in-app purchase auto-logging");
                return null;
            }
            Method method = InAppPurchaseUtils.getMethod(cls, InAppPurchaseConstants.METHOD_QUERY_PURCHASES_ASYNC, cls9, cls18);
            Method method2 = InAppPurchaseUtils.getMethod(cls9, InAppPurchaseConstants.METHOD_NEW_BUILDER, new Class[0]);
            Method method3 = InAppPurchaseUtils.getMethod(cls12, InAppPurchaseConstants.METHOD_BUILD, new Class[0]);
            Method method4 = InAppPurchaseUtils.getMethod(cls12, InAppPurchaseConstants.METHOD_SET_PRODUCT_TYPE, String.class);
            Method method5 = InAppPurchaseUtils.getMethod(cls2, InAppPurchaseConstants.METHOD_GET_ORIGINAL_JSON, new Class[0]);
            Method method6 = InAppPurchaseUtils.getMethod(cls, InAppPurchaseConstants.METHOD_QUERY_PURCHASE_HISTORY_ASYNC, cls8, cls19);
            Method method7 = InAppPurchaseUtils.getMethod(cls8, InAppPurchaseConstants.METHOD_NEW_BUILDER, new Class[0]);
            Method method8 = InAppPurchaseUtils.getMethod(cls11, InAppPurchaseConstants.METHOD_BUILD, new Class[0]);
            Method method9 = InAppPurchaseUtils.getMethod(cls11, InAppPurchaseConstants.METHOD_SET_PRODUCT_TYPE, String.class);
            Method method10 = InAppPurchaseUtils.getMethod(cls4, InAppPurchaseConstants.METHOD_GET_ORIGINAL_JSON, new Class[0]);
            Method method11 = InAppPurchaseUtils.getMethod(cls, InAppPurchaseConstants.METHOD_QUERY_PRODUCT_DETAILS_ASYNC, cls7, cls17);
            Method method12 = InAppPurchaseUtils.getMethod(cls7, InAppPurchaseConstants.METHOD_NEW_BUILDER, new Class[0]);
            Method method13 = InAppPurchaseUtils.getMethod(cls10, InAppPurchaseConstants.METHOD_BUILD, new Class[0]);
            Method method14 = InAppPurchaseUtils.getMethod(cls10, InAppPurchaseConstants.METHOD_SET_PRODUCT_LIST, List.class);
            Method method15 = InAppPurchaseUtils.getMethod(cls5, InAppPurchaseConstants.METHOD_NEW_BUILDER, new Class[0]);
            Method method16 = InAppPurchaseUtils.getMethod(cls13, InAppPurchaseConstants.METHOD_BUILD, new Class[0]);
            Method method17 = InAppPurchaseUtils.getMethod(cls13, InAppPurchaseConstants.METHOD_SET_PRODUCT_ID, String.class);
            Method method18 = InAppPurchaseUtils.getMethod(cls13, InAppPurchaseConstants.METHOD_SET_PRODUCT_TYPE, String.class);
            Method method19 = InAppPurchaseUtils.getMethod(cls3, InAppPurchaseConstants.METHOD_TO_STRING, new Class[0]);
            Method method20 = InAppPurchaseUtils.getMethod(cls, InAppPurchaseConstants.METHOD_START_CONNECTION, cls16);
            Method method21 = InAppPurchaseUtils.getMethod(cls6, InAppPurchaseConstants.METHOD_GET_RESPONSE_CODE, new Class[0]);
            if (method == null || method2 == null || method3 == null || method4 == null || method5 == null || method6 == null || method7 == null || method8 == null || method9 == null || method10 == null || method11 == null || method12 == null || method13 == null || method14 == null || method15 == null || method16 == null || method17 == null || method18 == null || method19 == null || method20 == null || method21 == null) {
                Log.w(InAppPurchaseBillingClientWrapperV5V7.access$getTAG$cp(), "Failed to create Google Play billing library wrapper for in-app purchase auto-logging");
                return null;
            }
            Object objCreateBillingClient = createBillingClient(context, cls, cls14, cls15);
            if (objCreateBillingClient == null) {
                Log.w(InAppPurchaseBillingClientWrapperV5V7.access$getTAG$cp(), "Failed to build a Google Play billing library wrapper for in-app purchase auto-logging");
                return null;
            }
            InAppPurchaseBillingClientWrapperV5V7.access$setInstance$cp(new InAppPurchaseBillingClientWrapperV5V7(objCreateBillingClient, cls, cls2, cls3, cls4, cls5, cls6, cls7, cls8, cls9, cls10, cls11, cls12, cls13, cls16, cls17, cls18, cls19, method, method2, method3, method4, method5, method6, method7, method8, method9, method10, method11, method12, method13, method14, method15, method16, method17, method18, method19, method20, method21, null));
            return InAppPurchaseBillingClientWrapperV5V7.access$getInstance$cp();
        }

        public final Map<String, JSONObject> getIapPurchaseDetailsMap() {
            return InAppPurchaseBillingClientWrapperV5V7.access$getIapPurchaseDetailsMap$cp();
        }

        public final synchronized InAppPurchaseBillingClientWrapperV5V7 getOrCreateInstance(Context context) {
            InAppPurchaseBillingClientWrapperV5V7 inAppPurchaseBillingClientWrapperV5V7Access$getInstance$cp;
            context.getClass();
            inAppPurchaseBillingClientWrapperV5V7Access$getInstance$cp = InAppPurchaseBillingClientWrapperV5V7.access$getInstance$cp();
            if (inAppPurchaseBillingClientWrapperV5V7Access$getInstance$cp == null) {
                inAppPurchaseBillingClientWrapperV5V7Access$getInstance$cp = createInstance(context);
            }
            return inAppPurchaseBillingClientWrapperV5V7Access$getInstance$cp;
        }

        public final Map<String, JSONObject> getProductDetailsMap() {
            return InAppPurchaseBillingClientWrapperV5V7.access$getProductDetailsMap$cp();
        }

        public final Map<String, JSONObject> getSubsPurchaseDetailsMap() {
            return InAppPurchaseBillingClientWrapperV5V7.access$getSubsPurchaseDetailsMap$cp();
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object proxy, Method m, Object[] args) {
            proxy.getClass();
            m.getClass();
            return null;
        }

        public final AtomicBoolean isServiceConnected() {
            return InAppPurchaseBillingClientWrapperV5V7.access$isServiceConnected$cp();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J0\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0002\u0010\fR\u0018\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapperV5V7$ListenerWrapper;", "Ljava/lang/reflect/InvocationHandler;", "wrapperArgs", "", "", "(Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapperV5V7;[Ljava/lang/Object;)V", "[Ljava/lang/Object;", "invoke", "proxy", "m", "Ljava/lang/reflect/Method;", "listenerArgs", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ListenerWrapper implements InvocationHandler {
        private Object[] wrapperArgs;

        public ListenerWrapper(Object[] objArr) {
            this.wrapperArgs = objArr;
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object proxy, Method m, Object[] listenerArgs) {
            proxy.getClass();
            m.getClass();
            String name = m.getName();
            if (name == null) {
                return null;
            }
            switch (name.hashCode()) {
                case -1642587947:
                    if (name.equals(InAppPurchaseConstants.METHOD_ON_PURCHASE_HISTORY_RESPONSE)) {
                        InAppPurchaseBillingClientWrapperV5V7.access$onPurchaseHistoryResponse(InAppPurchaseBillingClientWrapperV5V7.this, this.wrapperArgs, listenerArgs);
                        break;
                    }
                    break;
                case -1599362358:
                    if (name.equals(InAppPurchaseConstants.METHOD_ON_QUERY_PURCHASES_RESPONSE)) {
                        InAppPurchaseBillingClientWrapperV5V7.access$onQueryPurchasesResponse(InAppPurchaseBillingClientWrapperV5V7.this, this.wrapperArgs, listenerArgs);
                        break;
                    }
                    break;
                case -79406125:
                    if (name.equals(InAppPurchaseConstants.METHOD_ON_BILLING_SETUP_FINISHED)) {
                        InAppPurchaseBillingClientWrapperV5V7.access$onBillingSetupFinished(InAppPurchaseBillingClientWrapperV5V7.this, this.wrapperArgs, listenerArgs);
                        break;
                    }
                    break;
                case 1227540564:
                    if (name.equals(InAppPurchaseConstants.METHOD_ON_BILLING_SERVICE_DISCONNECTED)) {
                        InAppPurchaseBillingClientWrapperV5V7.access$onBillingServiceDisconnected(InAppPurchaseBillingClientWrapperV5V7.this, this.wrapperArgs, listenerArgs);
                        break;
                    }
                    break;
                case 1940131955:
                    if (name.equals(InAppPurchaseConstants.METHOD_ON_PRODUCT_DETAILS_RESPONSE)) {
                        InAppPurchaseBillingClientWrapperV5V7.access$onProductDetailsResponse(InAppPurchaseBillingClientWrapperV5V7.this, this.wrapperArgs, listenerArgs);
                        break;
                    }
                    break;
            }
            return null;
        }
    }

    private InAppPurchaseBillingClientWrapperV5V7(Object obj, Class<?> cls, Class<?> cls2, Class<?> cls3, Class<?> cls4, Class<?> cls5, Class<?> cls6, Class<?> cls7, Class<?> cls8, Class<?> cls9, Class<?> cls10, Class<?> cls11, Class<?> cls12, Class<?> cls13, Class<?> cls14, Class<?> cls15, Class<?> cls16, Class<?> cls17, Method method, Method method2, Method method3, Method method4, Method method5, Method method6, Method method7, Method method8, Method method9, Method method10, Method method11, Method method12, Method method13, Method method14, Method method15, Method method16, Method method17, Method method18, Method method19, Method method20, Method method21) {
        this.billingClient = obj;
        this.billingClientClazz = cls;
        this.purchaseClazz = cls2;
        this.productDetailsClazz = cls3;
        this.purchaseHistoryRecordClazz = cls4;
        this.queryProductDetailsParamsProductClazz = cls5;
        this.billingResultClazz = cls6;
        this.queryProductDetailsParamsClazz = cls7;
        this.queryPurchaseHistoryParamsClazz = cls8;
        this.queryPurchasesParamsClazz = cls9;
        this.queryProductDetailsParamsBuilderClazz = cls10;
        this.queryPurchaseHistoryParamsBuilderClazz = cls11;
        this.queryPurchasesParamsBuilderClazz = cls12;
        this.queryProductDetailsParamsProductBuilderClazz = cls13;
        this.billingClientStateListenerClazz = cls14;
        this.productDetailsResponseListenerClazz = cls15;
        this.purchasesResponseListenerClazz = cls16;
        this.purchaseHistoryResponseListenerClazz = cls17;
        this.queryPurchasesAsyncMethod = method;
        this.queryPurchasesParamsNewBuilderMethod = method2;
        this.queryPurchasesParamsBuilderBuildMethod = method3;
        this.queryPurchasesParamsBuilderSetProductTypeMethod = method4;
        this.purchaseGetOriginalJsonMethod = method5;
        this.queryPurchaseHistoryAsyncMethod = method6;
        this.queryPurchaseHistoryParamsNewBuilderMethod = method7;
        this.queryPurchaseHistoryParamsBuilderBuildMethod = method8;
        this.queryPurchaseHistoryParamsBuilderSetProductTypeMethod = method9;
        this.purchaseHistoryRecordGetOriginalJsonMethod = method10;
        this.queryProductDetailsAsyncMethod = method11;
        this.queryProductDetailsParamsNewBuilderMethod = method12;
        this.queryProductDetailsParamsBuilderBuildMethod = method13;
        this.queryProductDetailsParamsBuilderSetProductListMethod = method14;
        this.queryProductDetailsParamsProductNewBuilderMethod = method15;
        this.queryProductDetailsParamsProductBuilderBuildMethod = method16;
        this.queryProductDetailsParamsProductBuilderSetProductIdMethod = method17;
        this.queryProductDetailsParamsProductBuilderSetProductTypeMethod = method18;
        this.productDetailsToStringMethod = method19;
        this.billingClientStartConnectionMethod = method20;
        this.billingResultGetResponseCodeMethod = method21;
    }

    public static final /* synthetic */ Map access$getIapPurchaseDetailsMap$cp() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return null;
        }
        try {
            return iapPurchaseDetailsMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
            return null;
        }
    }

    public static final /* synthetic */ InAppPurchaseBillingClientWrapperV5V7 access$getInstance$cp() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return null;
        }
        try {
            return instance;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
            return null;
        }
    }

    public static final /* synthetic */ Map access$getProductDetailsMap$cp() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return null;
        }
        try {
            return productDetailsMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
            return null;
        }
    }

    public static final /* synthetic */ Map access$getSubsPurchaseDetailsMap$cp() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return null;
        }
        try {
            return subsPurchaseDetailsMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
            return null;
        }
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return null;
        }
        try {
            return TAG;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
            return null;
        }
    }

    public static final /* synthetic */ AtomicBoolean access$isServiceConnected$cp() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return null;
        }
        try {
            return isServiceConnected;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
            return null;
        }
    }

    public static final /* synthetic */ void access$onBillingServiceDisconnected(InAppPurchaseBillingClientWrapperV5V7 inAppPurchaseBillingClientWrapperV5V7, Object[] objArr, Object[] objArr2) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return;
        }
        try {
            inAppPurchaseBillingClientWrapperV5V7.onBillingServiceDisconnected(objArr, objArr2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
        }
    }

    public static final /* synthetic */ void access$onBillingSetupFinished(InAppPurchaseBillingClientWrapperV5V7 inAppPurchaseBillingClientWrapperV5V7, Object[] objArr, Object[] objArr2) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return;
        }
        try {
            inAppPurchaseBillingClientWrapperV5V7.onBillingSetupFinished(objArr, objArr2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
        }
    }

    public static final /* synthetic */ void access$onProductDetailsResponse(InAppPurchaseBillingClientWrapperV5V7 inAppPurchaseBillingClientWrapperV5V7, Object[] objArr, Object[] objArr2) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return;
        }
        try {
            inAppPurchaseBillingClientWrapperV5V7.onProductDetailsResponse(objArr, objArr2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
        }
    }

    public static final /* synthetic */ void access$onPurchaseHistoryResponse(InAppPurchaseBillingClientWrapperV5V7 inAppPurchaseBillingClientWrapperV5V7, Object[] objArr, Object[] objArr2) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return;
        }
        try {
            inAppPurchaseBillingClientWrapperV5V7.onPurchaseHistoryResponse(objArr, objArr2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
        }
    }

    public static final /* synthetic */ void access$onQueryPurchasesResponse(InAppPurchaseBillingClientWrapperV5V7 inAppPurchaseBillingClientWrapperV5V7, Object[] objArr, Object[] objArr2) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return;
        }
        try {
            inAppPurchaseBillingClientWrapperV5V7.onQueryPurchasesResponse(objArr, objArr2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
        }
    }

    public static final /* synthetic */ void access$setInstance$cp(InAppPurchaseBillingClientWrapperV5V7 inAppPurchaseBillingClientWrapperV5V7) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return;
        }
        try {
            instance = inAppPurchaseBillingClientWrapperV5V7;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
        }
    }

    private final void executeServiceRequest(Runnable runnable) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (isServiceConnected.get()) {
                runnable.run();
            } else {
                startConnection(runnable);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public static final synchronized InAppPurchaseBillingClientWrapperV5V7 getOrCreateInstance(Context context) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return null;
        }
        try {
            return INSTANCE.getOrCreateInstance(context);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
            return null;
        }
    }

    private final Object getQueryProductDetailsParams(InAppPurchaseUtils.IAPProductType productType, List<String> productIds) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            if (productIds.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : productIds) {
                Object objInvokeMethod = InAppPurchaseUtils.invokeMethod(this.queryProductDetailsParamsProductBuilderClazz, this.queryProductDetailsParamsProductBuilderBuildMethod, InAppPurchaseUtils.invokeMethod(this.queryProductDetailsParamsProductBuilderClazz, this.queryProductDetailsParamsProductBuilderSetProductTypeMethod, InAppPurchaseUtils.invokeMethod(this.queryProductDetailsParamsProductBuilderClazz, this.queryProductDetailsParamsProductBuilderSetProductIdMethod, InAppPurchaseUtils.invokeMethod(this.queryProductDetailsParamsProductClazz, this.queryProductDetailsParamsProductNewBuilderMethod, null, new Object[0]), str), productType.getType()), new Object[0]);
                if (objInvokeMethod != null) {
                    arrayList.add(objInvokeMethod);
                }
            }
            return InAppPurchaseUtils.invokeMethod(this.queryProductDetailsParamsBuilderClazz, this.queryProductDetailsParamsBuilderBuildMethod, InAppPurchaseUtils.invokeMethod(this.queryProductDetailsParamsBuilderClazz, this.queryProductDetailsParamsBuilderSetProductListMethod, InAppPurchaseUtils.invokeMethod(this.queryProductDetailsParamsClazz, this.queryProductDetailsParamsNewBuilderMethod, null, new Object[0]), arrayList), new Object[0]);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final Object getQueryPurchaseHistoryParams(InAppPurchaseUtils.IAPProductType productType) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return InAppPurchaseUtils.invokeMethod(this.queryPurchaseHistoryParamsBuilderClazz, this.queryPurchaseHistoryParamsBuilderBuildMethod, InAppPurchaseUtils.invokeMethod(this.queryPurchaseHistoryParamsBuilderClazz, this.queryPurchaseHistoryParamsBuilderSetProductTypeMethod, InAppPurchaseUtils.invokeMethod(this.queryPurchaseHistoryParamsClazz, this.queryPurchaseHistoryParamsNewBuilderMethod, null, new Object[0]), productType.getType()), new Object[0]);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final Object getQueryPurchasesParams(InAppPurchaseUtils.IAPProductType productType) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Object objInvokeMethod = InAppPurchaseUtils.invokeMethod(this.queryPurchasesParamsClazz, this.queryPurchasesParamsNewBuilderMethod, null, new Object[0]);
            if (objInvokeMethod == null) {
                return null;
            }
            return InAppPurchaseUtils.invokeMethod(this.queryPurchasesParamsBuilderClazz, this.queryPurchasesParamsBuilderBuildMethod, InAppPurchaseUtils.invokeMethod(this.queryPurchasesParamsBuilderClazz, this.queryPurchasesParamsBuilderSetProductTypeMethod, objInvokeMethod, productType.getType()), new Object[0]);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final void onBillingServiceDisconnected(Object[] wrapperArgs, Object[] listenerArgs) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            isServiceConnected.set(false);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private final void onBillingSetupFinished(Object[] wrapperArgs, Object[] listenerArgs) {
        Runnable runnable;
        if (CrashShieldHandler.isObjectCrashing(this) || listenerArgs == null) {
            return;
        }
        try {
            if (listenerArgs.length == 0) {
                return;
            }
            if (Intrinsics.areEqual(InAppPurchaseUtils.invokeMethod(this.billingResultClazz, this.billingResultGetResponseCodeMethod, listenerArgs[0], new Object[0]), (Object) 0)) {
                isServiceConnected.set(true);
                if (wrapperArgs != null && wrapperArgs.length != 0) {
                    Object obj = wrapperArgs[0];
                    if (!(obj instanceof Runnable) || (runnable = (Runnable) obj) == null) {
                        return;
                    }
                    runnable.run();
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private final void onProductDetailsResponse(Object[] wrapperArgs, Object[] listenerArgs) {
        Object orNull;
        String originalJson;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        if (wrapperArgs != null) {
            try {
                orNull = ArraysKt.getOrNull(wrapperArgs, 0);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return;
            }
        } else {
            orNull = null;
        }
        Object orNull2 = listenerArgs != null ? ArraysKt.getOrNull(listenerArgs, 1) : null;
        if (orNull2 != null && (orNull2 instanceof List)) {
            Iterator it = ((List) orNull2).iterator();
            while (it.hasNext()) {
                try {
                    Object objInvokeMethod = InAppPurchaseUtils.invokeMethod(this.productDetailsClazz, this.productDetailsToStringMethod, it.next(), new Object[0]);
                    String str = objInvokeMethod instanceof String ? (String) objInvokeMethod : null;
                    if (str != null && (originalJson = getOriginalJson(str)) != null) {
                        JSONObject jSONObject = new JSONObject(originalJson);
                        if (jSONObject.has("productId")) {
                            String string = jSONObject.getString("productId");
                            Map<String, JSONObject> map = productDetailsMap;
                            string.getClass();
                            map.put(string, jSONObject);
                        }
                    }
                } catch (Exception unused) {
                }
            }
            if (orNull == null || !(orNull instanceof Runnable)) {
                return;
            }
            ((Runnable) orNull).run();
        }
    }

    private final void onPurchaseHistoryResponse(Object[] wrapperArgs, Object[] listenerArgs) {
        Object orNull;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        if (wrapperArgs != null) {
            try {
                orNull = ArraysKt.getOrNull(wrapperArgs, 0);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return;
            }
        } else {
            orNull = null;
        }
        if (orNull != null && (orNull instanceof InAppPurchaseUtils.IAPProductType)) {
            Object orNull2 = ArraysKt.getOrNull(wrapperArgs, 1);
            if (orNull2 instanceof Runnable) {
                Object orNull3 = listenerArgs != null ? ArraysKt.getOrNull(listenerArgs, 1) : null;
                if (orNull3 != null && (orNull3 instanceof List)) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = ((List) orNull3).iterator();
                    while (it.hasNext()) {
                        try {
                            Object objInvokeMethod = InAppPurchaseUtils.invokeMethod(this.purchaseHistoryRecordClazz, this.purchaseHistoryRecordGetOriginalJsonMethod, it.next(), new Object[0]);
                            String str = objInvokeMethod instanceof String ? (String) objInvokeMethod : null;
                            if (str != null) {
                                JSONObject jSONObject = new JSONObject(str);
                                if (jSONObject.has("productId")) {
                                    String string = jSONObject.getString("productId");
                                    if (!productDetailsMap.containsKey(string)) {
                                        string.getClass();
                                        arrayList.add(string);
                                    }
                                    if (orNull == InAppPurchaseUtils.IAPProductType.INAPP) {
                                        Map<String, JSONObject> map = iapPurchaseDetailsMap;
                                        string.getClass();
                                        map.put(string, jSONObject);
                                    } else {
                                        Map<String, JSONObject> map2 = subsPurchaseDetailsMap;
                                        string.getClass();
                                        map2.put(string, jSONObject);
                                    }
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                    if (arrayList.isEmpty()) {
                        ((Runnable) orNull2).run();
                    } else {
                        queryProductDetailsAsync((InAppPurchaseUtils.IAPProductType) orNull, arrayList, (Runnable) orNull2);
                    }
                }
            }
        }
    }

    private final void onQueryPurchasesResponse(Object[] wrapperArgs, Object[] listenerArgs) {
        Object orNull;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        if (wrapperArgs != null) {
            try {
                orNull = ArraysKt.getOrNull(wrapperArgs, 0);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return;
            }
        } else {
            orNull = null;
        }
        if (orNull != null && (orNull instanceof InAppPurchaseUtils.IAPProductType)) {
            Object orNull2 = ArraysKt.getOrNull(wrapperArgs, 1);
            if (orNull2 instanceof Runnable) {
                Object orNull3 = listenerArgs != null ? ArraysKt.getOrNull(listenerArgs, 1) : null;
                if (orNull3 != null && (orNull3 instanceof List)) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = ((List) orNull3).iterator();
                    while (it.hasNext()) {
                        Object objInvokeMethod = InAppPurchaseUtils.invokeMethod(this.purchaseClazz, this.purchaseGetOriginalJsonMethod, it.next(), new Object[0]);
                        String str = objInvokeMethod instanceof String ? (String) objInvokeMethod : null;
                        if (str != null) {
                            JSONObject jSONObject = new JSONObject(str);
                            if (jSONObject.has("productId")) {
                                String string = jSONObject.getString("productId");
                                if (!productDetailsMap.containsKey(string)) {
                                    string.getClass();
                                    arrayList.add(string);
                                }
                                if (orNull == InAppPurchaseUtils.IAPProductType.INAPP) {
                                    Map<String, JSONObject> map = iapPurchaseDetailsMap;
                                    string.getClass();
                                    map.put(string, jSONObject);
                                } else {
                                    Map<String, JSONObject> map2 = subsPurchaseDetailsMap;
                                    string.getClass();
                                    map2.put(string, jSONObject);
                                }
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        ((Runnable) orNull2).run();
                    } else {
                        queryProductDetailsAsync((InAppPurchaseUtils.IAPProductType) orNull, arrayList, (Runnable) orNull2);
                    }
                }
            }
        }
    }

    private final void queryProductDetailsAsync(InAppPurchaseUtils.IAPProductType productType, List<String> productIds, Runnable completionHandler) {
        InAppPurchaseBillingClientWrapperV5V7 inAppPurchaseBillingClientWrapperV5V7;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            inAppPurchaseBillingClientWrapperV5V7 = this;
            try {
                inAppPurchaseBillingClientWrapperV5V7.executeServiceRequest(new Schedulers$$ExternalSyntheticLambda1((InAppPurchaseBillingClientWrapper) inAppPurchaseBillingClientWrapperV5V7, completionHandler, productType, (List) productIds, 2));
            } catch (Throwable th) {
                th = th;
                CrashShieldHandler.handleThrowable(th, inAppPurchaseBillingClientWrapperV5V7);
            }
        } catch (Throwable th2) {
            th = th2;
            inAppPurchaseBillingClientWrapperV5V7 = this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void queryProductDetailsAsync$lambda$2(InAppPurchaseBillingClientWrapperV5V7 inAppPurchaseBillingClientWrapperV5V7, Runnable runnable, InAppPurchaseUtils.IAPProductType iAPProductType, List list) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return;
        }
        try {
            inAppPurchaseBillingClientWrapperV5V7.getClass();
            runnable.getClass();
            iAPProductType.getClass();
            list.getClass();
            Object objNewProxyInstance = Proxy.newProxyInstance(inAppPurchaseBillingClientWrapperV5V7.productDetailsResponseListenerClazz.getClassLoader(), new Class[]{inAppPurchaseBillingClientWrapperV5V7.productDetailsResponseListenerClazz}, inAppPurchaseBillingClientWrapperV5V7.new ListenerWrapper(new Object[]{runnable}));
            Object queryProductDetailsParams = inAppPurchaseBillingClientWrapperV5V7.getQueryProductDetailsParams(iAPProductType, list);
            if (queryProductDetailsParams != null) {
                InAppPurchaseUtils.invokeMethod(inAppPurchaseBillingClientWrapperV5V7.billingClientClazz, inAppPurchaseBillingClientWrapperV5V7.queryProductDetailsAsyncMethod, inAppPurchaseBillingClientWrapperV5V7.getBillingClient(), queryProductDetailsParams, objNewProxyInstance);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void queryPurchaseHistory$lambda$1(InAppPurchaseBillingClientWrapperV5V7 inAppPurchaseBillingClientWrapperV5V7, InAppPurchaseUtils.IAPProductType iAPProductType, Runnable runnable) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return;
        }
        try {
            inAppPurchaseBillingClientWrapperV5V7.getClass();
            iAPProductType.getClass();
            runnable.getClass();
            InAppPurchaseUtils.invokeMethod(inAppPurchaseBillingClientWrapperV5V7.billingClientClazz, inAppPurchaseBillingClientWrapperV5V7.queryPurchaseHistoryAsyncMethod, inAppPurchaseBillingClientWrapperV5V7.getBillingClient(), inAppPurchaseBillingClientWrapperV5V7.getQueryPurchaseHistoryParams(iAPProductType), Proxy.newProxyInstance(inAppPurchaseBillingClientWrapperV5V7.purchaseHistoryResponseListenerClazz.getClassLoader(), new Class[]{inAppPurchaseBillingClientWrapperV5V7.purchaseHistoryResponseListenerClazz}, inAppPurchaseBillingClientWrapperV5V7.new ListenerWrapper(new Object[]{iAPProductType, runnable})));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void queryPurchases$lambda$0(InAppPurchaseBillingClientWrapperV5V7 inAppPurchaseBillingClientWrapperV5V7, InAppPurchaseUtils.IAPProductType iAPProductType, Runnable runnable) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return;
        }
        try {
            inAppPurchaseBillingClientWrapperV5V7.getClass();
            iAPProductType.getClass();
            runnable.getClass();
            InAppPurchaseUtils.invokeMethod(inAppPurchaseBillingClientWrapperV5V7.billingClientClazz, inAppPurchaseBillingClientWrapperV5V7.queryPurchasesAsyncMethod, inAppPurchaseBillingClientWrapperV5V7.getBillingClient(), inAppPurchaseBillingClientWrapperV5V7.getQueryPurchasesParams(iAPProductType), Proxy.newProxyInstance(inAppPurchaseBillingClientWrapperV5V7.purchasesResponseListenerClazz.getClassLoader(), new Class[]{inAppPurchaseBillingClientWrapperV5V7.purchasesResponseListenerClazz}, inAppPurchaseBillingClientWrapperV5V7.new ListenerWrapper(new Object[]{iAPProductType, runnable})));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
        }
    }

    private final void startConnection(Runnable runnable) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            InAppPurchaseUtils.invokeMethod(this.billingClientClazz, this.billingClientStartConnectionMethod, getBillingClient(), Proxy.newProxyInstance(this.billingClientStateListenerClazz.getClassLoader(), new Class[]{this.billingClientStateListenerClazz}, new ListenerWrapper(new Object[]{runnable})));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @Override // com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper
    public Object getBillingClient() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.billingClient;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final String getOriginalJson(String productDetailsString) {
        List<String> groupValues;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            productDetailsString.getClass();
            MatchResult matchResultFind$default = Regex.find$default(new Regex("jsonString='(.*?)'"), productDetailsString, 0, 2, null);
            if (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null) {
                return null;
            }
            return (String) CollectionsKt.getOrNull(groupValues, 1);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @Override // com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper
    public void queryPurchaseHistory(InAppPurchaseUtils.IAPProductType productType, Runnable completionHandler) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            productType.getClass();
            completionHandler.getClass();
            executeServiceRequest(new InAppPurchaseBillingClientWrapperV5V7$$ExternalSyntheticLambda0(this, productType, completionHandler, 1));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @Override // com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper
    public void queryPurchases(InAppPurchaseUtils.IAPProductType productType, Runnable completionHandler) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            productType.getClass();
            completionHandler.getClass();
            executeServiceRequest(new InAppPurchaseBillingClientWrapperV5V7$$ExternalSyntheticLambda0(this, productType, completionHandler, 0));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public /* synthetic */ InAppPurchaseBillingClientWrapperV5V7(Object obj, Class cls, Class cls2, Class cls3, Class cls4, Class cls5, Class cls6, Class cls7, Class cls8, Class cls9, Class cls10, Class cls11, Class cls12, Class cls13, Class cls14, Class cls15, Class cls16, Class cls17, Method method, Method method2, Method method3, Method method4, Method method5, Method method6, Method method7, Method method8, Method method9, Method method10, Method method11, Method method12, Method method13, Method method14, Method method15, Method method16, Method method17, Method method18, Method method19, Method method20, Method method21, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, cls, cls2, cls3, cls4, cls5, cls6, cls7, cls8, cls9, cls10, cls11, cls12, cls13, cls14, cls15, cls16, cls17, method, method2, method3, method4, method5, method6, method7, method8, method9, method10, method11, method12, method13, method14, method15, method16, method17, method18, method19, method20, method21);
    }
}
