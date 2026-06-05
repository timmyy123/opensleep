package com.urbandroid.sleep.ai;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts$StartActivityForResult;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.ai.edge.aicore.DownloadCallback;
import com.google.ai.edge.aicore.DownloadConfig;
import com.google.ai.edge.aicore.GenerationConfig;
import com.google.ai.edge.aicore.GenerationConfigKt;
import com.google.firebase.Firebase;
import com.google.firebase.ai.FirebaseAI;
import com.google.firebase.ai.FirebaseAIKt;
import com.google.firebase.ai.GenerativeModel;
import com.google.firebase.ai.type.GenerationConfig;
import com.google.firebase.ai.type.GenerativeBackend;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.common.util.RootUtil;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.ai.AiMessageRecyclerAdapter;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.alarmclock.UnlockFlow;
import com.urbandroid.sleep.gui.TintUtil;
import com.urbandroid.sleep.gui.ToolbarUtil;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import com.urbandroid.util.EdgeToEdgeUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0001HB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJA\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0007H\u0014¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\u0007H\u0014¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010\"\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\"\u0010\u0004J\u000f\u0010#\u001a\u00020\u0007H\u0002¢\u0006\u0004\b#\u0010\u0004R\"\u0010%\u001a\u00020$8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010,\u001a\u00020+8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010:\u001a\u0004\u0018\u0001098\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020A0@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010G\u001a\u00020D8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bE\u0010F¨\u0006I"}, d2 = {"Lcom/urbandroid/sleep/ai/AiActivity;", "Lcom/urbandroid/common/BaseActivity;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/widget/LinearLayout;", "root", "", "Lcom/urbandroid/sleep/ai/AiPrompt;", "prompts", "", "selected", "Landroid/view/View;", "followUpView", "addPromptsToView", "(Landroid/content/Context;Landroid/widget/LinearLayout;Ljava/util/List;Ljava/lang/String;Landroid/view/View;)V", "Landroid/view/Menu;", "menu", "", "onCreateOptionsMenu", "(Landroid/view/Menu;)Z", "Landroid/view/MenuItem;", "item", "onOptionsItemSelected", "(Landroid/view/MenuItem;)Z", "onStart", "onStop", "onDestroy", "startVoiceInput", "Lcom/urbandroid/sleep/ai/AiMessageRecyclerAdapter;", "historyAdapter", "Lcom/urbandroid/sleep/ai/AiMessageRecyclerAdapter;", "getHistoryAdapter", "()Lcom/urbandroid/sleep/ai/AiMessageRecyclerAdapter;", "setHistoryAdapter", "(Lcom/urbandroid/sleep/ai/AiMessageRecyclerAdapter;)V", "Lcom/google/firebase/ai/GenerativeModel;", DeviceRequestsHelper.DEVICE_INFO_MODEL, "Lcom/google/firebase/ai/GenerativeModel;", "getModel", "()Lcom/google/firebase/ai/GenerativeModel;", "setModel", "(Lcom/google/firebase/ai/GenerativeModel;)V", "Lcom/google/ai/edge/aicore/GenerativeModel;", "modelNano", "Lcom/google/ai/edge/aicore/GenerativeModel;", "getModelNano", "()Lcom/google/ai/edge/aicore/GenerativeModel;", "setModelNano", "(Lcom/google/ai/edge/aicore/GenerativeModel;)V", "Landroid/speech/tts/TextToSpeech;", "tts", "Landroid/speech/tts/TextToSpeech;", "getTts", "()Landroid/speech/tts/TextToSpeech;", "setTts", "(Landroid/speech/tts/TextToSpeech;)V", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "speechResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AiActivity extends BaseActivity implements CoroutineScope {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_PROMPT = "prompt";
    public AiMessageRecyclerAdapter historyAdapter;
    public GenerativeModel model;
    public com.google.ai.edge.aicore.GenerativeModel modelNano;
    private TextToSpeech tts;
    private final /* synthetic */ CoroutineScope $$delegate_0 = CoroutineScopeKt.MainScope();
    private final ActivityResultLauncher<Intent> speechResultLauncher = registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new ActivityResultCallback() { // from class: com.urbandroid.sleep.ai.AiActivity$$ExternalSyntheticLambda0
        @Override // androidx.view.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            AiActivity.speechResultLauncher$lambda$0(this.f$0, (ActivityResult) obj);
        }
    });

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/urbandroid/sleep/ai/AiActivity$Companion;", "", "<init>", "()V", "EXTRA_PROMPT", "", "getEXTRA_PROMPT", "()Ljava/lang/String;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getEXTRA_PROMPT() {
            return AiActivity.EXTRA_PROMPT;
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addPromptsToView$lambda$0$0(AiActivity aiActivity, String str) {
        str.getClass();
        aiActivity.getHistoryAdapter().addMessage(str, AiMessageRecyclerAdapter.MessageType.AI);
        aiActivity.findViewById(R.id.progress).setVisibility(8);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addPromptsToView$lambda$0$1(AiActivity aiActivity, AiPrompt aiPrompt, Function1 function1, View view) {
        if (TrialFilter.getInstance().isTrial()) {
            Toast.makeText(aiActivity, R.string.sleep_assistant_premium, 1).show();
            return;
        }
        aiActivity.getHistoryAdapter().showFollowUp();
        aiActivity.findViewById(R.id.progress).setVisibility(0);
        aiActivity.getHistoryAdapter().addMessage(aiPrompt.getQuestion(), AiMessageRecyclerAdapter.MessageType.HUMAN);
        aiPrompt.execute(aiActivity.getModel(), aiActivity.getModelNano(), function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$1(AiActivity aiActivity, GenerationConfig.Builder builder) {
        builder.getClass();
        builder.setContext(aiActivity.getApplicationContext());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$2(GenerationConfig.Builder builder) {
        builder.getClass();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean onCreate$lambda$3(Ref$ObjectRef ref$ObjectRef, TextView textView, int i, KeyEvent keyEvent) {
        zza$$ExternalSyntheticOutline0.m(i, "Send enter ");
        if (i != 4) {
            return false;
        }
        ((View) ref$ObjectRef.element).findViewById(R.id.send).callOnClick();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$5(EditText editText, final AiActivity aiActivity, View view) {
        Logger.logInfo("Send button");
        final String string = editText.getText().toString();
        if (string.length() > 0) {
            aiActivity.findViewById(R.id.progress).setVisibility(0);
            aiActivity.getHistoryAdapter().hideFollowUp();
            View viewFindViewById = editText.findViewById(R.id.chatboxMessage);
            viewFindViewById.getClass();
            ((EditText) viewFindViewById).setText("");
            aiActivity.getHistoryAdapter().addMessage(string, AiMessageRecyclerAdapter.MessageType.HUMAN);
            new AiPrompt(aiActivity, string) { // from class: com.urbandroid.sleep.ai.AiActivity$onCreate$5$1$prompt$1
                final /* synthetic */ String $question;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(aiActivity, "FollowUp", string);
                    this.$question = string;
                }

                @Override // com.urbandroid.sleep.ai.AiPrompt
                public Object doLoad(Continuation<? super String> continuation) {
                    String lastResponse = AiPrompt.INSTANCE.getLastResponse();
                    if (lastResponse == null) {
                        return "";
                    }
                    String str = this.$question;
                    return "Here is your last response: ".concat(lastResponse).concat("My follow up question with respect to my sleep is: '" + str + "'");
                }
            }.askFollowUp(aiActivity.getModel(), aiActivity.getModelNano(), string, new AiActivity$$ExternalSyntheticLambda2(aiActivity, 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$5$0$0(AiActivity aiActivity, String str) {
        str.getClass();
        aiActivity.findViewById(R.id.progress).setVisibility(8);
        aiActivity.getHistoryAdapter().addMessage(str, AiMessageRecyclerAdapter.MessageType.AI);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStart$lambda$0(int i) {
        if (i == 0) {
            Logger.logInfo("TTS success", null);
            return;
        }
        Logger.logInfo("TTS fail " + i, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void speechResultLauncher$lambda$0(AiActivity aiActivity, ActivityResult activityResult) {
        String str;
        activityResult.getClass();
        if (activityResult.getResultCode() != -1 || activityResult.getData() == null) {
            return;
        }
        Intent data2 = activityResult.getData();
        ArrayList<String> stringArrayListExtra = data2 != null ? data2.getStringArrayListExtra("android.speech.extra.RESULTS") : null;
        TextView textView = (TextView) aiActivity.findViewById(R.id.chatboxMessage);
        if (stringArrayListExtra == null || (str = stringArrayListExtra.get(0)) == null) {
            str = "";
        }
        textView.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startVoiceInput() {
        Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
        intent.putExtra("android.speech.extra.LANGUAGE", Locale.getDefault());
        intent.putExtra("android.speech.extra.PROMPT", "Say something...");
        try {
            this.speechResultLauncher.launch(intent);
        } catch (Exception unused) {
            Toast.makeText(this, "Voice recognition not supported on this device", 0).show();
        }
    }

    public final void addPromptsToView(Context context, LinearLayout root, List<? extends AiPrompt> prompts, String selected, View followUpView) {
        context.getClass();
        prompts.getClass();
        followUpView.getClass();
        if (root != null) {
            LayoutInflater layoutInflater = InflatorUtil.INSTANCE.get(context);
            for (AiPrompt aiPrompt : prompts) {
                View viewInflate = layoutInflater.inflate(R.layout.activity_ai_question, (ViewGroup) null);
                LinearLayoutCompat.LayoutParams layoutParams = new LinearLayoutCompat.LayoutParams(-2, -2);
                layoutParams.setMargins(ActivityUtils.getDip(context, 8), ActivityUtils.getDip(context, 4), ActivityUtils.getDip(context, 0), ActivityUtils.getDip(context, 4));
                viewInflate.setLayoutParams(layoutParams);
                ((TextView) viewInflate.findViewById(R.id.name)).setText(aiPrompt.getName());
                ((TextView) viewInflate.findViewById(R.id.desc)).setText(aiPrompt.getQuestion());
                View.OnClickListener aiActivity$$ExternalSyntheticLambda8 = new AiActivity$$ExternalSyntheticLambda8(this, aiPrompt, new AiActivity$$ExternalSyntheticLambda2(this, 1), 0);
                viewInflate.setOnClickListener(aiActivity$$ExternalSyntheticLambda8);
                if (Intrinsics.areEqual(selected, aiPrompt.getClass().getSimpleName())) {
                    aiActivity$$ExternalSyntheticLambda8.onClick(viewInflate);
                }
                root.addView(viewInflate);
            }
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    public final AiMessageRecyclerAdapter getHistoryAdapter() {
        AiMessageRecyclerAdapter aiMessageRecyclerAdapter = this.historyAdapter;
        if (aiMessageRecyclerAdapter != null) {
            return aiMessageRecyclerAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("historyAdapter");
        return null;
    }

    public final GenerativeModel getModel() {
        GenerativeModel generativeModel = this.model;
        if (generativeModel != null) {
            return generativeModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException(DeviceRequestsHelper.DEVICE_INFO_MODEL);
        return null;
    }

    public final com.google.ai.edge.aicore.GenerativeModel getModelNano() {
        com.google.ai.edge.aicore.GenerativeModel generativeModel = this.modelNano;
        if (generativeModel != null) {
            return generativeModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("modelNano");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v0, types: [android.app.Activity, android.content.Context, androidx.appcompat.app.AppCompatActivity, com.urbandroid.common.BaseActivity, com.urbandroid.sleep.ai.AiActivity, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v2, types: [T, android.view.View] */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v1, types: [kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        Intent intent;
        super.onCreate(savedInstanceState);
        GlobalInitializator.initializeIfRequired(this);
        setContentView(R.layout.activity_ai);
        ToolbarUtil.apply(this);
        TintUtil.tint(this);
        ActionBar supportActionBar = getSupportActionBar();
        int i = 1;
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setDisplayShowHomeEnabled(true);
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.history);
        EdgeToEdgeUtil.Companion.insetsBottom$default(EdgeToEdgeUtil.INSTANCE, recyclerView, 0, false, 6, null);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        InflatorUtil.Companion companion = InflatorUtil.INSTANCE;
        ?? stringExtra = 0;
        stringExtra = 0;
        stringExtra = 0;
        ref$ObjectRef.element = companion.get(this).inflate(R.layout.activity_ai_bubble_follow_up, (ViewGroup) null);
        View viewInflate = companion.get(this).inflate(R.layout.activity_ai_bubble_prompts, (ViewGroup) null);
        viewInflate.getClass();
        Object obj = ref$ObjectRef.element;
        obj.getClass();
        setHistoryAdapter(new AiMessageRecyclerAdapter(this, recyclerView, viewInflate, (View) obj));
        recyclerView.setAdapter(getHistoryAdapter());
        AiMessageRecyclerAdapter historyAdapter = getHistoryAdapter();
        String string = getString(R.string.sleep_assistant_first_message);
        string.getClass();
        historyAdapter.addMessage(string, AiMessageRecyclerAdapter.MessageType.AI);
        int i2 = 0;
        if (!TrialFilter.getInstance().isTrial() && !new RootUtil().isDeviceRooted() && !TrialFilter.getInstance().isUnknownSource()) {
            setModelNano(new com.google.ai.edge.aicore.GenerativeModel(GenerationConfigKt.generationConfig(new AiActivity$$ExternalSyntheticLambda2(this, i2)), new DownloadConfig(new DownloadCallback() { // from class: com.urbandroid.sleep.ai.AiActivity$onCreate$downloadConfig$1
            })));
            setModel(FirebaseAI.generativeModel$default(FirebaseAIKt.ai$default(Firebase.INSTANCE, null, GenerativeBackend.Companion.vertexAI$default(GenerativeBackend.INSTANCE, null, 1, null), 1, null), "gemini-2.5-flash", com.google.firebase.ai.type.GenerationConfigKt.generationConfig(new AiPrompt$$ExternalSyntheticLambda0(i)), null, null, null, null, null, 124, null));
        }
        ArrayList arrayList = new ArrayList();
        int i3 = 2;
        arrayList.add(new ScoreBriefAiPrompt(this, i2, i3, stringExtra));
        arrayList.add(new TodayAiPrompt(this));
        arrayList.add(new ScoreAiPrompt(this, i2, i3, stringExtra));
        arrayList.add(new TrendsAiPrompt(this));
        arrayList.add(new OthersAiPrompt(this));
        Intent intent2 = getIntent();
        if (intent2 != null) {
            String str = EXTRA_PROMPT;
            if (intent2.hasExtra(str) && (intent = getIntent()) != null) {
                stringExtra = intent.getStringExtra(str);
            }
        }
        ?? r4 = stringExtra;
        if (TrialFilter.getInstance().isTrial()) {
            Toast.makeText((Context) this, R.string.sleep_assistant_premium, 1).show();
            UnlockFlow.showUnlockDialog(this, true);
            return;
        }
        if (new RootUtil().isDeviceRooted()) {
            UnlockFlow.showWarningDialog(this, getString(R.string.rooted_block), true);
            return;
        }
        if (TrialFilter.getInstance().isUnknownSource()) {
            UnlockFlow.showWarningDialog(this, getString(R.string.unknown_source_block), true);
            return;
        }
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.questions);
        Object obj2 = ref$ObjectRef.element;
        obj2.getClass();
        addPromptsToView(this, linearLayout, arrayList, r4, (View) obj2);
        EditText editText = (EditText) ((View) ref$ObjectRef.element).findViewById(R.id.chatboxMessage);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.urbandroid.sleep.ai.AiActivity$$ExternalSyntheticLambda4
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i4, KeyEvent keyEvent) {
                return AiActivity.onCreate$lambda$3(ref$ObjectRef, textView, i4, keyEvent);
            }
        });
        ((View) ref$ObjectRef.element).findViewById(R.id.live).setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.ai.AiActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.startVoiceInput();
            }
        });
        ((View) ref$ObjectRef.element).findViewById(R.id.send).setOnClickListener(new AiActivity$$ExternalSyntheticLambda6(editText, this, i2));
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.getClass();
        getMenuInflater().inflate(R.menu.doc_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
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
            return true;
        }
        ViewIntent.urlCustomTab(this, "https://sleep.urbandroid.org/docs//sleep/assistant.html");
        return true;
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.tts = new TextToSpeech(this, new AiActivity$$ExternalSyntheticLambda1());
        getHistoryAdapter().setTts(this.tts);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        TextToSpeech textToSpeech = this.tts;
        if (textToSpeech != null) {
            textToSpeech.stop();
        }
        TextToSpeech textToSpeech2 = this.tts;
        if (textToSpeech2 != null) {
            textToSpeech2.shutdown();
        }
    }

    public final void setHistoryAdapter(AiMessageRecyclerAdapter aiMessageRecyclerAdapter) {
        aiMessageRecyclerAdapter.getClass();
        this.historyAdapter = aiMessageRecyclerAdapter;
    }

    public final void setModel(GenerativeModel generativeModel) {
        generativeModel.getClass();
        this.model = generativeModel;
    }

    public final void setModelNano(com.google.ai.edge.aicore.GenerativeModel generativeModel) {
        generativeModel.getClass();
        this.modelNano = generativeModel;
    }
}
