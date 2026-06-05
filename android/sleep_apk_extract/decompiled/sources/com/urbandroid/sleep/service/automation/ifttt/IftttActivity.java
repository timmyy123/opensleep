package com.urbandroid.sleep.service.automation.ifttt;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.CookieUtil;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.ViewExtKt;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.gui.TintUtil;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.automation.AutomationEvent;
import com.urbandroid.sleep.service.automation.AutomationEventMapping;
import com.urbandroid.sleep.service.automation.AutomationTrigger;
import com.urbandroid.util.ThemeUtil;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt__JobKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001'B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0007H\u0002J\b\u0010\u001b\u001a\u00020\u0016H\u0014J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"H\u0016J\u0016\u0010#\u001a\u00020\u001d2\u0006\u0010\n\u001a\u00020$H\u0082@¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\u0016H\u0014R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/urbandroid/sleep/service/automation/ifttt/IftttActivity;", "Lcom/urbandroid/common/BaseActivity;", "Lcom/urbandroid/common/FeatureLogger;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "getContext", "()Lcom/urbandroid/sleep/service/automation/ifttt/IftttActivity;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "keyText", "Landroid/widget/EditText;", "browser", "Landroid/webkit/WebView;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "checkKey", SDKConstants.PARAM_KEY, "onStop", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "isKeyValid", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDestroy", "IftttJavaScriptInterface", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class IftttActivity extends BaseActivity implements FeatureLogger, CoroutineScope {
    private WebView browser;
    private EditText keyText;
    private final String tag = "ifttt";
    private final IftttActivity context = this;
    private final CoroutineContext coroutineContext = Dispatchers.getMain().plus(JobKt__JobKt.Job$default(null, 1, null)).plus(new IftttActivity$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, this));

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0007¨\u0006\t"}, d2 = {"Lcom/urbandroid/sleep/service/automation/ifttt/IftttActivity$IftttJavaScriptInterface;", "", "<init>", "(Lcom/urbandroid/sleep/service/automation/ifttt/IftttActivity;)V", "processHTML", "", "url", "", "html", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public final class IftttJavaScriptInterface {
        public IftttJavaScriptInterface() {
        }

        @JavascriptInterface
        public final void processHTML(String url, String html) {
            url.getClass();
            html.getClass();
            IftttActivity iftttActivity = IftttActivity.this;
            String strConcat = "webview processing: ".concat(url);
            Logger.logInfo(Logger.defaultTag, iftttActivity.getTag() + ": " + strConcat, null);
            AtomicReference atomicReference = new AtomicReference(null);
            if (StringsKt.startsWith$default(url, "https://maker.ifttt.com/use/")) {
                atomicReference.set(url.substring(28));
            } else {
                int iIndexOf$default = StringsKt__StringsKt.indexOf$default(html, "https://maker.ifttt.com/use/", StringsKt__StringsKt.indexOf$default(html, "service-settings-view", 0, false, 6, (Object) null), false, 4, (Object) null);
                if (iIndexOf$default != -1) {
                    int i = iIndexOf$default + 28;
                    int iIndexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) html, '<', i, false, 4, (Object) null);
                    if (iIndexOf$default2 != -1) {
                        atomicReference.set(html.substring(i, iIndexOf$default2));
                    }
                }
            }
            if (atomicReference.get() != null) {
                IftttActivity iftttActivity2 = IftttActivity.this;
                Logger.logInfo(Logger.defaultTag, iftttActivity2.getTag() + ": key from url: success", null);
                IftttActivity iftttActivity3 = IftttActivity.this;
                BuildersKt__Builders_commonKt.launch$default(iftttActivity3, null, null, new IftttActivity$IftttJavaScriptInterface$processHTML$1(iftttActivity3, atomicReference, null), 3, null);
            }
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.automation.ifttt.IftttActivity$checkKey$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.automation.ifttt.IftttActivity$checkKey$1", f = "IftttActivity.kt", l = {108}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return IftttActivity.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IftttActivity iftttActivity;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                IftttActivity iftttActivity2 = IftttActivity.this;
                if (!ContextExtKt.hasConnectivity(iftttActivity2)) {
                    Logger.logSevere(" - no connectivity", null);
                    return Unit.INSTANCE;
                }
                IftttActivity context = iftttActivity2.getContext();
                this.L$0 = SpillingKt.nullOutSpilledVariable(iftttActivity2);
                this.L$1 = iftttActivity2;
                this.I$0 = 0;
                this.I$1 = 0;
                this.label = 1;
                Object objIsKeyValid = iftttActivity2.isKeyValid(context, this);
                if (objIsKeyValid == coroutine_suspended) {
                    return coroutine_suspended;
                }
                iftttActivity = iftttActivity2;
                obj = objIsKeyValid;
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                iftttActivity = (IftttActivity) this.L$1;
                ResultKt.throwOnFailure(obj);
            }
            boolean zBooleanValue = ((Boolean) obj).booleanValue();
            String str = Logger.defaultTag;
            Logger.logInfo(str, iftttActivity.getTag() + ": " + ("Checking key valid = " + zBooleanValue), null);
            if (zBooleanValue) {
                String string = iftttActivity.getResources().getString(R.string.share_connected, "IFTTT");
                string.getClass();
                Toast.makeText(iftttActivity, string, 1).show();
            } else {
                Toast.makeText(iftttActivity, R.string.ifttt_invalid_key, 1).show();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.automation.ifttt.IftttActivity$isKeyValid$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.automation.ifttt.IftttActivity$isKeyValid$2", f = "IftttActivity.kt", l = {181}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Context $context;
        int label;
        final /* synthetic */ IftttActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Context context, IftttActivity iftttActivity, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$context = context;
            this.this$0 = iftttActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$context, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0050 A[Catch: IOException -> 0x0069, IftttInvalidKeyException -> 0x006c, TRY_ENTER, TryCatch #6 {IftttInvalidKeyException -> 0x006c, IOException -> 0x0069, blocks: (B:19:0x0046, B:22:0x0050, B:27:0x006f, B:16:0x003f), top: B:38:0x003f }] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x006f A[Catch: IOException -> 0x0069, IftttInvalidKeyException -> 0x006c, TRY_LEAVE, TryCatch #6 {IftttInvalidKeyException -> 0x006c, IOException -> 0x0069, blocks: (B:19:0x0046, B:22:0x0050, B:27:0x006f, B:16:0x003f), top: B:38:0x003f }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            AnonymousClass2 anonymousClass2;
            IOException iOException;
            IftttInvalidKeyException iftttInvalidKeyException;
            boolean zBooleanValue;
            IftttActivity iftttActivity;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            boolean z = false;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    IftttTrigger iftttTrigger = new IftttTrigger(this.$context);
                    AutomationEvent automationEventFromSleepEvent = AutomationEvent.INSTANCE.fromSleepEvent(AutomationEventMapping.UNKNOWN);
                    this.label = 1;
                    anonymousClass2 = this;
                    try {
                        obj = AutomationTrigger.fire$default(iftttTrigger, automationEventFromSleepEvent, 0L, anonymousClass2, 2, null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        zBooleanValue = ((Boolean) obj).booleanValue();
                        iftttActivity = anonymousClass2.this$0;
                        if (zBooleanValue) {
                        }
                    } catch (IftttInvalidKeyException e) {
                        e = e;
                        iftttInvalidKeyException = e;
                        IftttActivity iftttActivity2 = anonymousClass2.this$0;
                        Logger.logSevere(Logger.defaultTag, iftttActivity2.getTag() + ": invalid key", iftttInvalidKeyException);
                    } catch (IOException e2) {
                        e = e2;
                        iOException = e;
                        IftttActivity iftttActivity3 = anonymousClass2.this$0;
                        Logger.logSevere(Logger.defaultTag, iftttActivity3.getTag() + ": fire test failure", iOException);
                    }
                } catch (IftttInvalidKeyException e3) {
                    e = e3;
                    anonymousClass2 = this;
                } catch (IOException e4) {
                    e = e4;
                    anonymousClass2 = this;
                }
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                try {
                    ResultKt.throwOnFailure(obj);
                    anonymousClass2 = this;
                    zBooleanValue = ((Boolean) obj).booleanValue();
                    iftttActivity = anonymousClass2.this$0;
                } catch (IftttInvalidKeyException e5) {
                    iftttInvalidKeyException = e5;
                    anonymousClass2 = this;
                    IftttActivity iftttActivity22 = anonymousClass2.this$0;
                    Logger.logSevere(Logger.defaultTag, iftttActivity22.getTag() + ": invalid key", iftttInvalidKeyException);
                } catch (IOException e6) {
                    iOException = e6;
                    anonymousClass2 = this;
                    IftttActivity iftttActivity32 = anonymousClass2.this$0;
                    Logger.logSevere(Logger.defaultTag, iftttActivity32.getTag() + ": fire test failure", iOException);
                }
                if (zBooleanValue) {
                    Logger.logInfo(Logger.defaultTag, iftttActivity.getTag() + ": key is invalid", null);
                } else {
                    Logger.logInfo(Logger.defaultTag, iftttActivity.getTag() + ": key is valid", null);
                    z = true;
                }
            }
            return Boxing.boxBoolean(z);
        }
    }

    private final void checkKey(String key) {
        if (StringsKt.isBlank(key)) {
            return;
        }
        Logger.logInfo(Logger.defaultTag, getTag() + ": Checking key ...", null);
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object isKeyValid(Context context, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(context, this, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(IftttActivity iftttActivity, View view) {
        EditText editText = iftttActivity.keyText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("keyText");
            editText = null;
        }
        iftttActivity.checkKey(editText.getText().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$4(final IftttActivity iftttActivity, View view) {
        if (!ContextExtKt.hasConnectivity(iftttActivity)) {
            String string = iftttActivity.getResources().getString(R.string.share_disconnected, "Internet");
            string.getClass();
            Toast.makeText(iftttActivity, string, 1).show();
            return;
        }
        final WebView webView = (WebView) iftttActivity.findViewById(R.id.ifttt_webview);
        if (webView != null) {
            ViewExtKt.show(webView);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.addJavascriptInterface(iftttActivity.new IftttJavaScriptInterface(), "HTMLOUT");
            webView.setWebViewClient(new WebViewClient() { // from class: com.urbandroid.sleep.service.automation.ifttt.IftttActivity$onCreate$5$1$1
                @Override // android.webkit.WebViewClient
                public void onPageFinished(WebView view2, String url) {
                    view2.getClass();
                    url.getClass();
                    IftttActivity iftttActivity2 = this.this$0;
                    String strConcat = "Web Page loaded: ".concat(url);
                    Logger.logInfo(Logger.defaultTag, iftttActivity2.getTag() + ": " + strConcat, null);
                    if (!StringsKt.startsWith$default(url, "https://ifttt.com/login")) {
                        webView.loadUrl("https://ifttt.com/maker_webhooks/settings");
                    }
                    webView.loadUrl("javascript:window.HTMLOUT.processHTML('" + url + "', document.getElementsByTagName('html')[0].innerHTML);");
                }
            });
            webView.loadUrl("https://ifttt.com/login?wp_=1");
        }
        ThemeUtil.setTheme(iftttActivity);
    }

    public final IftttActivity getContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GlobalInitializator.initializeIfRequired(this);
        Context applicationContext = getApplicationContext();
        applicationContext.getClass();
        final Settings settings = ContextExtKt.getSettings(applicationContext);
        setContentView(R.layout.activity_ifttt);
        TintUtil.tint(this);
        ActionBar supportActionBar = getSupportActionBar();
        final int i = 1;
        if (supportActionBar != null) {
            supportActionBar.setTitle(R.string.ifttt);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        View viewFindViewById = findViewById(R.id.ifttt_key_text);
        EditText editText = (EditText) viewFindViewById;
        editText.setText(settings.getIftttKey());
        editText.addTextChangedListener(new TextWatcher() { // from class: com.urbandroid.sleep.service.automation.ifttt.IftttActivity$onCreate$2$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                s.getClass();
                settings.setIftttKey(s.toString());
                settings.setIfttt(true);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                s.getClass();
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                s.getClass();
            }
        });
        viewFindViewById.getClass();
        this.keyText = editText;
        View viewFindViewById2 = findViewById(R.id.ifttt_webview);
        WebView webView = (WebView) viewFindViewById2;
        webView.clearCache(true);
        webView.clearHistory();
        viewFindViewById2.getClass();
        this.browser = webView;
        CookieUtil.clearCookies(getApplicationContext());
        final int i2 = 0;
        findViewById(R.id.button_test).setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.service.automation.ifttt.IftttActivity$$ExternalSyntheticLambda0
            public final /* synthetic */ IftttActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3 = i2;
                IftttActivity iftttActivity = this.f$0;
                switch (i3) {
                    case 0:
                        IftttActivity.onCreate$lambda$3(iftttActivity, view);
                        break;
                    default:
                        IftttActivity.onCreate$lambda$4(iftttActivity, view);
                        break;
                }
            }
        });
        findViewById(R.id.button_retrieve).setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.service.automation.ifttt.IftttActivity$$ExternalSyntheticLambda0
            public final /* synthetic */ IftttActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3 = i;
                IftttActivity iftttActivity = this.f$0;
                switch (i3) {
                    case 0:
                        IftttActivity.onCreate$lambda$3(iftttActivity, view);
                        break;
                    default:
                        IftttActivity.onCreate$lambda$4(iftttActivity, view);
                        break;
                }
            }
        });
        String iftttKey = settings.getIftttKey();
        iftttKey.getClass();
        checkKey(iftttKey);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.getClass();
        getMenuInflater().inflate(R.menu.doc_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        CoroutineScopeKt.cancel$default(this, null, 1, null);
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        item.getClass();
        int itemId = item.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        }
        if (itemId != R.id.menu_doc) {
            return false;
        }
        ViewIntent.url(this, "https://sleep.urbandroid.org/docs//services/ifttt.html");
        return true;
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        WebView webView = this.browser;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("browser");
            webView = null;
        }
        webView.destroy();
    }
}
