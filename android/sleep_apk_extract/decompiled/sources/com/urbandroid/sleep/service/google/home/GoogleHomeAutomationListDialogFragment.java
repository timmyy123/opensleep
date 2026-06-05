package com.urbandroid.sleep.service.google.home;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.home.HomeDevice;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.fragment.NoiseFragment$$ExternalSyntheticLambda6;
import com.urbandroid.sleep.media.MediaListActivity$$ExternalSyntheticLambda1;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.google.home.GoogleHomeAutomationAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0017¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\u00020\u00128\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/urbandroid/sleep/service/google/home/GoogleHomeAutomationListDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/urbandroid/sleep/service/google/home/AutomationSelected;", "select", "<init>", "(Lcom/urbandroid/sleep/service/google/home/AutomationSelected;)V", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Lcom/urbandroid/sleep/service/google/home/AutomationSelected;", "getSelect", "()Lcom/urbandroid/sleep/service/google/home/AutomationSelected;", "Lkotlinx/coroutines/CompletableJob;", "job", "Lkotlinx/coroutines/CompletableJob;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GoogleHomeAutomationListDialogFragment extends DialogFragment implements CoroutineScope {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String PREF = "pref";
    private final CoroutineContext coroutineContext;
    private final CompletableJob job;
    private final AutomationSelected select;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0005\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/urbandroid/sleep/service/google/home/GoogleHomeAutomationListDialogFragment$Companion;", "", "<init>", "()V", "", "PREF", "Ljava/lang/String;", "getPREF", "()Ljava/lang/String;", "getPREF$annotations", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getPREF() {
            return GoogleHomeAutomationListDialogFragment.PREF;
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.home.GoogleHomeAutomationListDialogFragment$onCreateDialog$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.home.GoogleHomeAutomationListDialogFragment$onCreateDialog$1", f = "GoogleHomeAutomationListDialogFragment.kt", l = {65}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ GoogleHomeAutomationAdapter $adapter;
        final /* synthetic */ Context $context;
        int label;

        /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.home.GoogleHomeAutomationListDialogFragment$onCreateDialog$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "com.urbandroid.sleep.service.google.home.GoogleHomeAutomationListDialogFragment$onCreateDialog$1$1", f = "GoogleHomeAutomationListDialogFragment.kt", l = {66, 72}, m = "invokeSuspend", v = 2)
        public static final class C00451 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ GoogleHomeAutomationAdapter $adapter;
            final /* synthetic */ Context $context;
            Object L$0;
            int label;

            /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.home.GoogleHomeAutomationListDialogFragment$onCreateDialog$1$1$2, reason: invalid class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
            @DebugMetadata(c = "com.urbandroid.sleep.service.google.home.GoogleHomeAutomationListDialogFragment$onCreateDialog$1$1$2", f = "GoogleHomeAutomationListDialogFragment.kt", l = {}, m = "invokeSuspend", v = 2)
            public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ List<HomeDevice> $actions;
                final /* synthetic */ GoogleHomeAutomationAdapter $adapter;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public AnonymousClass2(GoogleHomeAutomationAdapter googleHomeAutomationAdapter, List<? extends HomeDevice> list, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.$adapter = googleHomeAutomationAdapter;
                    this.$actions = list;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass2(this.$adapter, this.$actions, continuation);
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
                    GoogleHomeAutomationAdapter googleHomeAutomationAdapter = this.$adapter;
                    List<HomeDevice> list = this.$actions;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    for (HomeDevice homeDevice : list) {
                        arrayList.add(new GoogleHomeAutomationAdapter.Item(homeDevice.getId(), homeDevice.getZzb()));
                    }
                    googleHomeAutomationAdapter.setItems(arrayList);
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00451(Context context, GoogleHomeAutomationAdapter googleHomeAutomationAdapter, Continuation<? super C00451> continuation) {
                super(2, continuation);
                this.$context = context;
                this.$adapter = googleHomeAutomationAdapter;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00451(this.$context, this.$adapter, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00451) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x0074, code lost:
            
                if (kotlinx.coroutines.BuildersKt.withContext(r1, r4, r6) == r0) goto L19;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    GoogleHomeClient companion = GoogleHomeClient.INSTANCE.getInstance(this.$context);
                    this.label = 1;
                    obj = companion.getOnOffDevices(this);
                    if (obj != coroutine_suspended) {
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
                ResultKt.throwOnFailure(obj);
                List list = (List) obj;
                zza$$ExternalSyntheticOutline0.m(list.size(), "Home: actions ");
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    zza$$ExternalSyntheticOutline0.m("Home: action ", ((HomeDevice) it.next()).getZzb());
                }
                MainCoroutineDispatcher main = Dispatchers.getMain();
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$adapter, list, null);
                this.L$0 = SpillingKt.nullOutSpilledVariable(list);
                this.label = 2;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, GoogleHomeAutomationAdapter googleHomeAutomationAdapter, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$adapter = googleHomeAutomationAdapter;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$context, this.$adapter, continuation);
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
                C00451 c00451 = new C00451(this.$context, this.$adapter, null);
                this.label = 1;
                if (BuildersKt.withContext(io2, c00451, this) == coroutine_suspended) {
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

    public GoogleHomeAutomationListDialogFragment(AutomationSelected automationSelected) {
        automationSelected.getClass();
        this.select = automationSelected;
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default(null, 1, null);
        this.job = completableJobSupervisorJob$default;
        this.coroutineContext = Dispatchers.getIO().plus(completableJobSupervisorJob$default).plus(new GoogleHomeAutomationListDialogFragment$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$0(String str, GoogleHomeAutomationAdapter googleHomeAutomationAdapter, Settings settings, GoogleHomeAutomationListDialogFragment googleHomeAutomationListDialogFragment, DialogInterface dialogInterface, int i) {
        dialogInterface.getClass();
        Logger.logInfo("Home: pref key " + str + " = " + googleHomeAutomationAdapter.getItems().get(i).id);
        settings.setGoogleHomeAutomation(str, googleHomeAutomationAdapter.getItems().get(i).id, googleHomeAutomationAdapter.getItems().get(i).title);
        googleHomeAutomationListDialogFragment.select.selected();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$1(DialogInterface dialogInterface, int i) {
        dialogInterface.getClass();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$2(Settings settings, String str, GoogleHomeAutomationListDialogFragment googleHomeAutomationListDialogFragment, DialogInterface dialogInterface, int i) {
        settings.removeGoogleHomeAutomation(str);
        Unit unit = Unit.INSTANCE;
        googleHomeAutomationListDialogFragment.select.selected();
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        FragmentActivity activity = getActivity();
        final Settings settings = new Settings(activity);
        Bundle arguments = getArguments();
        final String string = arguments != null ? arguments.getString(PREF, null) : null;
        Logger.logInfo("Home: pref key " + string);
        activity.getClass();
        final GoogleHomeAutomationAdapter googleHomeAutomationAdapter = new GoogleHomeAutomationAdapter(activity);
        AlertDialog alertDialogCreate = new MaterialAlertDialogBuilder(activity).setTitle(R.string.turn_on).setAdapter((ListAdapter) googleHomeAutomationAdapter, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.service.google.home.GoogleHomeAutomationListDialogFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                GoogleHomeAutomationListDialogFragment.onCreateDialog$lambda$0(string, googleHomeAutomationAdapter, settings, this, dialogInterface, i);
            }
        }).setPositiveButton(R.string.cancel, (DialogInterface.OnClickListener) new NoiseFragment$$ExternalSyntheticLambda6(8)).setNegativeButton(R.string.lullaby_name_NONE, (DialogInterface.OnClickListener) new MediaListActivity$$ExternalSyntheticLambda1(settings, string, this)).create();
        alertDialogCreate.getClass();
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new AnonymousClass1(activity, googleHomeAutomationAdapter, null), 3, null);
        return alertDialogCreate;
    }
}
