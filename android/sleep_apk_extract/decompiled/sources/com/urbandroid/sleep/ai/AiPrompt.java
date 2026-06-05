package com.urbandroid.sleep.ai;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.ai.Chat;
import com.google.firebase.ai.GenerativeModel;
import com.google.firebase.ai.type.Content;
import com.google.firebase.ai.type.ContentKt;
import com.google.firebase.ai.type.GenerateContentResponse;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.SleepScore;
import com.urbandroid.sleep.addon.stats.StatsRepoLoaderKt;
import com.urbandroid.sleep.addon.stats.model.IMeasureRecord;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.addon.stats.model.collector.AverageStatRecord;
import com.urbandroid.sleep.addon.stats.model.extractor.IValueExtractor;
import com.urbandroid.sleep.addon.stats.util.DateUtil;
import com.urbandroid.sleep.service.Settings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001.B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006J:\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u00192\n\u0010\u001a\u001a\u00060\u001bj\u0002`\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u0006J4\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u00192\n\u0010\u001a\u001a\u00060\u001bj\u0002`\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u0006J*\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140&J\u000e\u0010'\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010(J2\u0010)\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140&R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0012\u0010*\u001a\u00020+X\u0096\u0005¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u0006/"}, d2 = {"Lcom/urbandroid/sleep/ai/AiPrompt;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/urbandroid/common/FeatureLogger;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "name", "", "question", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "getName", "()Ljava/lang/String;", "getQuestion", "tag", "getTag", "fixPresentation", SDKConstants.PARAM_VALUE, "buildPromptFromRecords", "", "records", "", "Lcom/urbandroid/sleep/addon/stats/model/StatRecord;", "score", "Lcom/urbandroid/sleep/addon/stats/SleepScore;", "promptBuilder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "subject", "record", "Lcom/urbandroid/sleep/addon/stats/model/IMeasureRecord;", "execute", DeviceRequestsHelper.DEVICE_INFO_MODEL, "Lcom/google/firebase/ai/GenerativeModel;", "modelNano", "Lcom/google/ai/edge/aicore/GenerativeModel;", "process", "Lkotlin/Function1;", "doLoad", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "askFollowUp", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class AiPrompt implements CoroutineScope, FeatureLogger {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<String, String> history = new LinkedHashMap();
    private static final List<String> historyList = new ArrayList();
    private static String lastQuestion;
    private static String lastResponse;
    private final /* synthetic */ CoroutineScope $$delegate_0;
    private final Context context;
    private final String name;
    private final String question;
    private final String tag;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/urbandroid/sleep/ai/AiPrompt$Companion;", "", "<init>", "()V", "", "", "history", "Ljava/util/Map;", "getHistory", "()Ljava/util/Map;", "", "historyList", "Ljava/util/List;", "getHistoryList", "()Ljava/util/List;", "lastQuestion", "Ljava/lang/String;", "getLastQuestion", "()Ljava/lang/String;", "setLastQuestion", "(Ljava/lang/String;)V", "lastResponse", "getLastResponse", "setLastResponse", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Map<String, String> getHistory() {
            return AiPrompt.history;
        }

        public final List<String> getHistoryList() {
            return AiPrompt.historyList;
        }

        public final String getLastResponse() {
            return AiPrompt.lastResponse;
        }

        public final void setLastQuestion(String str) {
            AiPrompt.lastQuestion = str;
        }

        public final void setLastResponse(String str) {
            AiPrompt.lastResponse = str;
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.ai.AiPrompt$askFollowUp$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.ai.AiPrompt$askFollowUp$1", f = "AiPrompt.kt", l = {293}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Chat $chat;
        final /* synthetic */ Function1<String, Unit> $process;
        final /* synthetic */ String $question;
        int label;

        /* JADX INFO: renamed from: com.urbandroid.sleep.ai.AiPrompt$askFollowUp$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "com.urbandroid.sleep.ai.AiPrompt$askFollowUp$1$1", f = "AiPrompt.kt", l = {299, 300, 305}, m = "invokeSuspend", v = 2)
        public static final class C00271 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Chat $chat;
            final /* synthetic */ Function1<String, Unit> $process;
            final /* synthetic */ String $question;
            Object L$0;
            Object L$1;
            int label;

            /* JADX INFO: renamed from: com.urbandroid.sleep.ai.AiPrompt$askFollowUp$1$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
            @DebugMetadata(c = "com.urbandroid.sleep.ai.AiPrompt$askFollowUp$1$1$1", f = "AiPrompt.kt", l = {}, m = "invokeSuspend", v = 2)
            public static final class C00281 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Function1<String, Unit> $process;
                final /* synthetic */ String $result;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public C00281(Function1<? super String, Unit> function1, String str, Continuation<? super C00281> continuation) {
                    super(2, continuation);
                    this.$process = function1;
                    this.$result = str;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C00281(this.$process, this.$result, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C00281) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    this.$process.invoke(this.$result);
                    return Unit.INSTANCE;
                }
            }

            /* JADX INFO: renamed from: com.urbandroid.sleep.ai.AiPrompt$askFollowUp$1$1$2, reason: invalid class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
            @DebugMetadata(c = "com.urbandroid.sleep.ai.AiPrompt$askFollowUp$1$1$2", f = "AiPrompt.kt", l = {}, m = "invokeSuspend", v = 2)
            public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Function1<String, Unit> $process;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public AnonymousClass2(Function1<? super String, Unit> function1, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.$process = function1;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass2(this.$process, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    this.$process.invoke("Something went wrong");
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C00271(String str, Chat chat, Function1<? super String, Unit> function1, Continuation<? super C00271> continuation) {
                super(2, continuation);
                this.$question = str;
                this.$chat = chat;
                this.$process = function1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00271(this.$question, this.$chat, this.$process, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00271) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code restructure failed: missing block: B:26:0x008d, code lost:
            
                if (kotlinx.coroutines.BuildersKt.withContext(r5, r6, r9) == r0) goto L30;
             */
            /* JADX WARN: Code restructure failed: missing block: B:29:0x00b2, code lost:
            
                if (kotlinx.coroutines.BuildersKt.withContext(r4, r5, r9) != r0) goto L31;
             */
            /* JADX WARN: Type inference failed for: r1v0, types: [int, java.lang.Object] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                String strM;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                ?? r1 = this.label;
                try {
                } catch (Exception e) {
                    Logger.logSevere("follow up error ", e);
                    MainCoroutineDispatcher main = Dispatchers.getMain();
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$process, null);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(r1);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(e);
                    this.label = 3;
                }
                if (r1 == 0) {
                    ResultKt.throwOnFailure(obj);
                    strM = FileInsert$$ExternalSyntheticOutline0.m("Please answer the following question in ", Locale.getDefault().getDisplayLanguage(Locale.ENGLISH), " language. Keep your answer related only to my sleep. The question is: '", this.$question, "'.");
                    Chat chat = this.$chat;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(strM);
                    this.label = 1;
                    obj = chat.sendMessage(strM, this);
                    if (obj == coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (r1 != 1) {
                    if (r1 == 2) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (r1 != 3) {
                            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
                strM = (String) this.L$0;
                ResultKt.throwOnFailure(obj);
                String text = ((GenerateContentResponse) obj).getText();
                if (text == null) {
                    text = "Something went wrong";
                }
                MainCoroutineDispatcher main2 = Dispatchers.getMain();
                C00281 c00281 = new C00281(this.$process, text, null);
                this.L$0 = SpillingKt.nullOutSpilledVariable(strM);
                this.L$1 = SpillingKt.nullOutSpilledVariable(text);
                this.label = 2;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(String str, Chat chat, Function1<? super String, Unit> function1, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$question = str;
            this.$chat = chat;
            this.$process = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$question, this.$chat, this.$process, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineDispatcher io2 = Dispatchers.getIO();
                C00271 c00271 = new C00271(this.$question, this.$chat, this.$process, null);
                this.label = 1;
                if (BuildersKt.withContext(io2, c00271, this) == coroutine_suspended) {
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
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.ai.AiPrompt$execute$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.ai.AiPrompt$execute$1", f = "AiPrompt.kt", l = {232, 261}, m = "invokeSuspend", v = 2)
    public static final class C20831 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ GenerativeModel $model;
        final /* synthetic */ Function1<String, Unit> $process;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX INFO: renamed from: com.urbandroid.sleep.ai.AiPrompt$execute$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "com.urbandroid.sleep.ai.AiPrompt$execute$1$1", f = "AiPrompt.kt", l = {}, m = "invokeSuspend", v = 2)
        public static final class C00291 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $errorString;
            final /* synthetic */ Function1<String, Unit> $process;
            final /* synthetic */ Ref$ObjectRef<String> $prompt;
            final /* synthetic */ String $result;
            int label;
            final /* synthetic */ AiPrompt this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C00291(Ref$ObjectRef<String> ref$ObjectRef, String str, String str2, AiPrompt aiPrompt, Function1<? super String, Unit> function1, Continuation<? super C00291> continuation) {
                super(2, continuation);
                this.$prompt = ref$ObjectRef;
                this.$result = str;
                this.$errorString = str2;
                this.this$0 = aiPrompt;
                this.$process = function1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00291(this.$prompt, this.$result, this.$errorString, this.this$0, this.$process, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00291) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                String str = this.$prompt.element;
                if (str != null) {
                    String str2 = this.$result;
                    String str3 = this.$errorString;
                    if (str2 != null && !Intrinsics.areEqual(str2, str3)) {
                        Companion companion = AiPrompt.INSTANCE;
                        companion.getHistory().put(str, str2);
                        companion.getHistoryList().add("AI Assistent responds: ".concat(str2));
                        companion.setLastResponse(str2);
                    }
                }
                String str4 = this.$result;
                if (str4 == null) {
                    str4 = this.$errorString;
                }
                AiPrompt aiPrompt = this.this$0;
                String strM = FileInsert$$ExternalSyntheticOutline0.m("result processed: ", str4);
                Logger.logInfo(Logger.defaultTag, aiPrompt.getTag() + ": " + strM, null);
                this.$process.invoke(str4);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C20831(GenerativeModel generativeModel, Function1<? super String, Unit> function1, Continuation<? super C20831> continuation) {
            super(2, continuation);
            this.$model = generativeModel;
            this.$process = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AiPrompt.this.new C20831(this.$model, this.$process, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C20831) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0093, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r11, r3, r10) == r0) goto L17;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Ref$ObjectRef ref$ObjectRef;
            String str;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String string = AiPrompt.this.getContext().getString(R.string.general_unspecified_error);
                string.getClass();
                ref$ObjectRef = new Ref$ObjectRef();
                CoroutineDispatcher io2 = Dispatchers.getIO();
                AiPrompt$execute$1$result$1 aiPrompt$execute$1$result$1 = new AiPrompt$execute$1$result$1(ref$ObjectRef, AiPrompt.this, this.$model, null);
                this.L$0 = string;
                this.L$1 = ref$ObjectRef;
                this.label = 1;
                Object objWithContext = BuildersKt.withContext(io2, aiPrompt$execute$1$result$1, this);
                if (objWithContext != coroutine_suspended) {
                    str = string;
                    obj = objWithContext;
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ref$ObjectRef = (Ref$ObjectRef) this.L$1;
            String str2 = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
            str = str2;
            Ref$ObjectRef ref$ObjectRef2 = ref$ObjectRef;
            String str3 = (String) obj;
            MainCoroutineDispatcher main = Dispatchers.getMain();
            C00291 c00291 = new C00291(ref$ObjectRef2, str3, str, AiPrompt.this, this.$process, null);
            this.L$0 = SpillingKt.nullOutSpilledVariable(str);
            this.L$1 = SpillingKt.nullOutSpilledVariable(ref$ObjectRef2);
            this.L$2 = SpillingKt.nullOutSpilledVariable(str3);
            this.label = 2;
        }
    }

    public AiPrompt(Context context, String str, String str2) {
        context.getClass();
        str.getClass();
        str2.getClass();
        this.$$delegate_0 = CoroutineScopeKt.MainScope();
        this.context = context;
        this.name = str;
        this.question = str2;
        this.tag = "AI Prompt";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit askFollowUp$lambda$0(Content.Builder builder) {
        builder.getClass();
        String str = lastQuestion;
        if (str == null) {
            str = "";
        }
        builder.addText(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit askFollowUp$lambda$1(Content.Builder builder) {
        builder.getClass();
        String str = lastResponse;
        if (str == null) {
            str = "";
        }
        builder.addText(str);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void buildPromptFromRecords$default(AiPrompt aiPrompt, Context context, List list, SleepScore sleepScore, StringBuilder sb, String str, int i, Object obj) {
        if (obj != null) {
            Utf8$$ExternalSyntheticBUOutline0.m("Super calls with default arguments not supported in this target, function: buildPromptFromRecords");
            return;
        }
        if ((i & 16) != 0) {
            str = "My";
        }
        aiPrompt.buildPromptFromRecords(context, (List<? extends StatRecord>) list, sleepScore, sb, str);
    }

    public final void askFollowUp(GenerativeModel model, com.google.ai.edge.aicore.GenerativeModel modelNano, String question, Function1<? super String, Unit> process) {
        model.getClass();
        modelNano.getClass();
        question.getClass();
        process.getClass();
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new AnonymousClass1(question, model.startChat(CollectionsKt.listOf((Object[]) new Content[]{ContentKt.content("user", new AiPrompt$$ExternalSyntheticLambda0(0)), ContentKt.content(DeviceRequestsHelper.DEVICE_INFO_MODEL, new AiPrompt$$ExternalSyntheticLambda0(2))})), process, null), 3, null);
    }

    public final void buildPromptFromRecords(Context context, IMeasureRecord record, SleepScore score, StringBuilder promptBuilder, String subject) {
        Settings settings;
        Iterator it;
        Object obj;
        Context context2 = context;
        context2.getClass();
        record.getClass();
        score.getClass();
        promptBuilder.getClass();
        subject.getClass();
        Settings settings2 = new Settings(context2);
        List<SleepScore.ScoreMeasure> all_measures = StatsRepoLoaderKt.getALL_MEASURES();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : all_measures) {
            if (((SleepScore.ScoreMeasure) obj2) != SleepScore.ScoreMeasure.RATING) {
                arrayList.add(obj2);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            SleepScore.ScoreMeasure scoreMeasure = (SleepScore.ScoreMeasure) it2.next();
            IValueExtractor extractor = scoreMeasure.getMeasure().getExtractor(context2);
            double value = extractor.getValue(record);
            if (value == -1.0d || value == -2.0d || value == 0.0d || value < -20.0d) {
                settings = settings2;
                it = it2;
            } else {
                score.updateMeasure(scoreMeasure, (float) value);
                promptBuilder.append(" " + scoreMeasure.getEnglishNamesForAi());
                String valuePresentation = extractor.getValuePresentation(value);
                valuePresentation.getClass();
                String strFixPresentation = fixPresentation(valuePresentation);
                Boolean bool = scoreMeasure.max;
                promptBuilder.append(FileInsert$$ExternalSyntheticOutline0.m(" is ", strFixPresentation, " ", bool == null ? ". " : Intrinsics.areEqual(bool, Boolean.TRUE) ? " more is better. " : " less is better.", " "));
                settings = settings2;
                it = it2;
                if (scoreMeasure == SleepScore.ScoreMeasure.DURATION) {
                    if (value < scoreMeasure.limitPositive) {
                        String englishNamesForAi = scoreMeasure.getEnglishNamesForAi();
                        String valuePresentation2 = extractor.getValuePresentation(scoreMeasure.limitPositive);
                        valuePresentation2.getClass();
                        StringBuilder sbM66m = Fragment$$ExternalSyntheticOutline1.m66m(subject, " ", englishNamesForAi, " is below ", fixPresentation(valuePresentation2));
                        sbM66m.append(" which is considered as sleep deprivation and may negatively affect ");
                        sbM66m.append(subject);
                        sbM66m.append(" health in many areas. ");
                        promptBuilder.append(sbM66m.toString());
                        obj = "Your";
                    } else {
                        obj = "Your";
                        if (value > scoreMeasure.limitNegative) {
                            String englishNamesForAi2 = scoreMeasure.getEnglishNamesForAi();
                            String valuePresentation3 = extractor.getValuePresentation(scoreMeasure.limitNegative);
                            valuePresentation3.getClass();
                            StringBuilder sbM66m2 = Fragment$$ExternalSyntheticOutline1.m66m(subject, " ", englishNamesForAi2, " is over ", fixPresentation(valuePresentation3));
                            sbM66m2.append(" which is considered as unhealthy oversleeping and may hint at some underlying health issues. ");
                            promptBuilder.append(sbM66m2.toString());
                        } else {
                            String englishNamesForAi3 = scoreMeasure.getEnglishNamesForAi();
                            String valuePresentation4 = extractor.getValuePresentation(scoreMeasure.limitPositive);
                            valuePresentation4.getClass();
                            String strFixPresentation2 = fixPresentation(valuePresentation4);
                            String valuePresentation5 = extractor.getValuePresentation(scoreMeasure.limitNegative);
                            valuePresentation5.getClass();
                            String strFixPresentation3 = fixPresentation(valuePresentation5);
                            StringBuilder sbM66m3 = Fragment$$ExternalSyntheticOutline1.m66m(subject, " ", englishNamesForAi3, " is between ", strFixPresentation2);
                            sbM66m3.append(" and ");
                            sbM66m3.append(strFixPresentation3);
                            sbM66m3.append(" which is considered as healthy. ");
                            promptBuilder.append(sbM66m3.toString());
                            obj = obj;
                            if (value < 480.0d && Intrinsics.areEqual(subject, obj)) {
                                String englishNamesForAi4 = scoreMeasure.getEnglishNamesForAi();
                                String englishNamesForAi5 = scoreMeasure.getEnglishNamesForAi();
                                StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("Still ", subject, " ", englishNamesForAi4, " is under 8 hours and ");
                                FileInsert$$ExternalSyntheticOutline0.m(sbM6m, subject, " may consider increasing ", subject, " ");
                                sbM6m.append(englishNamesForAi5);
                                sbM6m.append(" for additional health benefits. ");
                                promptBuilder.append(sbM6m.toString());
                            }
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                    if (Intrinsics.areEqual(subject, obj)) {
                        if (value >= settings.getIdealSleepMinutes()) {
                            String minutes = DateUtil.formatMinutes(Integer.valueOf(settings.getIdealSleepMinutes()));
                            minutes.getClass();
                            promptBuilder.append("Good news is that you are meeting your own sleep duration goal of " + fixPresentation(minutes) + ". ");
                        } else {
                            String minutes2 = DateUtil.formatMinutes(Integer.valueOf(settings.getIdealSleepMinutes()));
                            minutes2.getClass();
                            promptBuilder.append("But you are missing your own sleep duration goal of " + fixPresentation(minutes2) + ". ");
                        }
                    }
                } else {
                    Boolean bool2 = scoreMeasure.max;
                    if (bool2 == null) {
                        if (value < scoreMeasure.limitPositive) {
                            String englishNamesForAi6 = scoreMeasure.getEnglishNamesForAi();
                            String valuePresentation6 = extractor.getValuePresentation(scoreMeasure.limitPositive);
                            valuePresentation6.getClass();
                            StringBuilder sbM66m4 = Fragment$$ExternalSyntheticOutline1.m66m(subject, " ", englishNamesForAi6, " is below ", fixPresentation(valuePresentation6));
                            sbM66m4.append(" which is considered lower than optimal. ");
                            promptBuilder.append(sbM66m4.toString());
                        } else if (value > scoreMeasure.limitNegative) {
                            String englishNamesForAi7 = scoreMeasure.getEnglishNamesForAi();
                            String valuePresentation7 = extractor.getValuePresentation(scoreMeasure.limitNegative);
                            valuePresentation7.getClass();
                            StringBuilder sbM66m5 = Fragment$$ExternalSyntheticOutline1.m66m(subject, " ", englishNamesForAi7, " is over ", fixPresentation(valuePresentation7));
                            sbM66m5.append(" which is considered higher then optimal. ");
                            promptBuilder.append(sbM66m5.toString());
                        } else {
                            String englishNamesForAi8 = scoreMeasure.getEnglishNamesForAi();
                            String valuePresentation8 = extractor.getValuePresentation(scoreMeasure.limitPositive);
                            valuePresentation8.getClass();
                            String strFixPresentation4 = fixPresentation(valuePresentation8);
                            String valuePresentation9 = extractor.getValuePresentation(scoreMeasure.limitNegative);
                            valuePresentation9.getClass();
                            String strFixPresentation5 = fixPresentation(valuePresentation9);
                            StringBuilder sbM66m6 = Fragment$$ExternalSyntheticOutline1.m66m(subject, " ", englishNamesForAi8, " is between ", strFixPresentation4);
                            sbM66m6.append(" and ");
                            sbM66m6.append(strFixPresentation5);
                            sbM66m6.append(" which is considered as healthy. ");
                            promptBuilder.append(sbM66m6.toString());
                        }
                    } else if (bool2 == null || !bool2.booleanValue()) {
                        Boolean bool3 = scoreMeasure.max;
                        if (bool3 != null && !bool3.booleanValue()) {
                            if (value <= scoreMeasure.limitPositive) {
                                String englishNamesForAi9 = scoreMeasure.getEnglishNamesForAi();
                                String valuePresentation10 = extractor.getValuePresentation(scoreMeasure.limitPositive);
                                valuePresentation10.getClass();
                                StringBuilder sbM66m7 = Fragment$$ExternalSyntheticOutline1.m66m(subject, " ", englishNamesForAi9, " is below ", fixPresentation(valuePresentation10));
                                sbM66m7.append(" which is considered as perfect, the less the better.");
                                promptBuilder.append(sbM66m7.toString());
                            } else if (value > scoreMeasure.limitNegative) {
                                String englishNamesForAi10 = scoreMeasure.getEnglishNamesForAi();
                                String valuePresentation11 = extractor.getValuePresentation(scoreMeasure.limitNegative);
                                valuePresentation11.getClass();
                                StringBuilder sbM66m8 = Fragment$$ExternalSyntheticOutline1.m66m(subject, " ", englishNamesForAi10, " is above ", fixPresentation(valuePresentation11));
                                sbM66m8.append(" which is considered as a health risk, the higher the worse. ");
                                promptBuilder.append(sbM66m8.toString());
                            } else {
                                String englishNamesForAi11 = scoreMeasure.getEnglishNamesForAi();
                                String valuePresentation12 = extractor.getValuePresentation(scoreMeasure.limitPositive);
                                valuePresentation12.getClass();
                                String strFixPresentation6 = fixPresentation(valuePresentation12);
                                String valuePresentation13 = extractor.getValuePresentation(scoreMeasure.limitNegative);
                                valuePresentation13.getClass();
                                String strFixPresentation7 = fixPresentation(valuePresentation13);
                                StringBuilder sbM66m9 = Fragment$$ExternalSyntheticOutline1.m66m(subject, " ", englishNamesForAi11, " is between ", strFixPresentation6);
                                sbM66m9.append(" and ");
                                sbM66m9.append(strFixPresentation7);
                                sbM66m9.append(" which is considered fine but may be improved: the lower the better. ");
                                promptBuilder.append(sbM66m9.toString());
                            }
                        }
                    } else if (value >= scoreMeasure.limitPositive) {
                        String englishNamesForAi12 = scoreMeasure.getEnglishNamesForAi();
                        String valuePresentation14 = extractor.getValuePresentation(scoreMeasure.limitPositive);
                        valuePresentation14.getClass();
                        StringBuilder sbM66m10 = Fragment$$ExternalSyntheticOutline1.m66m(subject, " ", englishNamesForAi12, " is above ", fixPresentation(valuePresentation14));
                        sbM66m10.append(" which is considered as perfect, the more the better.");
                        promptBuilder.append(sbM66m10.toString());
                    } else if (value < scoreMeasure.limitNegative) {
                        String englishNamesForAi13 = scoreMeasure.getEnglishNamesForAi();
                        String valuePresentation15 = extractor.getValuePresentation(scoreMeasure.limitNegative);
                        valuePresentation15.getClass();
                        StringBuilder sbM66m11 = Fragment$$ExternalSyntheticOutline1.m66m(subject, " ", englishNamesForAi13, " is below ", fixPresentation(valuePresentation15));
                        sbM66m11.append(" which is considered as potential health risk, the lower the worse. ");
                        promptBuilder.append(sbM66m11.toString());
                    } else {
                        String englishNamesForAi14 = scoreMeasure.getEnglishNamesForAi();
                        String valuePresentation16 = extractor.getValuePresentation(scoreMeasure.limitNegative);
                        valuePresentation16.getClass();
                        String strFixPresentation8 = fixPresentation(valuePresentation16);
                        String valuePresentation17 = extractor.getValuePresentation(scoreMeasure.limitPositive);
                        valuePresentation17.getClass();
                        String strFixPresentation9 = fixPresentation(valuePresentation17);
                        StringBuilder sbM66m12 = Fragment$$ExternalSyntheticOutline1.m66m(subject, " ", englishNamesForAi14, " is between ", strFixPresentation8);
                        sbM66m12.append(" and ");
                        sbM66m12.append(strFixPresentation9);
                        sbM66m12.append(" which is considered fine but may be improved: the higher the better. ");
                        promptBuilder.append(sbM66m12.toString());
                    }
                }
            }
            context2 = context;
            settings2 = settings;
            it2 = it;
        }
    }

    public abstract Object doLoad(Continuation<? super String> continuation);

    public final void execute(GenerativeModel model, com.google.ai.edge.aicore.GenerativeModel modelNano, Function1<? super String, Unit> process) {
        model.getClass();
        modelNano.getClass();
        process.getClass();
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new C20831(model, process, null), 3, null);
    }

    public final String fixPresentation(String value) {
        value.getClass();
        return StringsKt.contains$default(value, ":") ? FileInsert$$ExternalSyntheticOutline0.m$1(StringsKt.replace$default(value, ":", " hours and "), " minutes ") : value;
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    public final String getName() {
        return this.name;
    }

    public final String getQuestion() {
        return this.question;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    public static /* synthetic */ void buildPromptFromRecords$default(AiPrompt aiPrompt, Context context, IMeasureRecord iMeasureRecord, SleepScore sleepScore, StringBuilder sb, String str, int i, Object obj) {
        if (obj != null) {
            Utf8$$ExternalSyntheticBUOutline0.m("Super calls with default arguments not supported in this target, function: buildPromptFromRecords");
            return;
        }
        if ((i & 16) != 0) {
            str = "My";
        }
        aiPrompt.buildPromptFromRecords(context, iMeasureRecord, sleepScore, sb, str);
    }

    public final void buildPromptFromRecords(Context context, List<? extends StatRecord> records, SleepScore score, StringBuilder promptBuilder, String subject) {
        context.getClass();
        records.getClass();
        score.getClass();
        promptBuilder.getClass();
        subject.getClass();
        buildPromptFromRecords(context, new AverageStatRecord(context, records), score, promptBuilder, subject);
    }
}
