package com.urbandroid.sleep.service.google.home;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import com.facebook.internal.WebDialog$$ExternalSyntheticLambda1;
import com.google.android.material.materialswitch.MaterialSwitch;
import com.google.home.HomeDevice;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.wifi.WifiEnabler;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.ViewExtKt;
import com.urbandroid.sleep.gui.TintUtil;
import com.urbandroid.sleep.gui.ToolbarUtil;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import com.urbandroid.sleep.service.google.home.GoogleHomeLightActivity;
import com.urbandroid.smartlight.common.Common_smartlightKt;
import com.urbandroid.smartlight.common.Configuration;
import com.urbandroid.smartlight.common.model.AuthenticatedGateway;
import com.urbandroid.smartlight.common.model.Light;
import com.urbandroid.smartlight.hue.data.HueSharedPreferences;
import java.util.ArrayList;
import java.util.Collection;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002!\"B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0017J\b\u0010\u001b\u001a\u00020\u0018H\u0014J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0006\u0010 \u001a\u00020\u0018R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/urbandroid/sleep/service/google/home/GoogleHomeLightActivity;", "Lcom/urbandroid/common/BaseActivity;", "Lcom/urbandroid/common/FeatureLogger;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "lightsList", "Landroid/widget/ListView;", "selectedLights", "", "Lcom/urbandroid/smartlight/common/model/Light;", "job", "Lkotlinx/coroutines/CompletableJob;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "configuration", "Lcom/urbandroid/smartlight/common/Configuration;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "reset", "LightListAdapter", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GoogleHomeLightActivity extends BaseActivity implements FeatureLogger, CoroutineScope {
    private Configuration configuration;
    private final CoroutineContext coroutineContext;
    private final CompletableJob job;
    private ListView lightsList;
    private final String tag = Common_smartlightKt.TAG;
    private List<Light> selectedLights = CollectionsKt.emptyList();

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001:\u0001\u0015B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\nH\u0016J\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/urbandroid/sleep/service/google/home/GoogleHomeLightActivity$LightListAdapter;", "Landroid/widget/BaseAdapter;", "lights", "", "Lcom/urbandroid/smartlight/common/model/Light;", "<init>", "(Lcom/urbandroid/sleep/service/google/home/GoogleHomeLightActivity;Ljava/util/List;)V", "inflator", "Landroid/view/LayoutInflater;", "getCount", "", "getItem", "arg0", "getItemId", "", "getView", "Landroid/view/View;", "index", "convertView", "viewGroup", "Landroid/view/ViewGroup;", "RowView", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public final class LightListAdapter extends BaseAdapter {
        private final LayoutInflater inflator;
        private final List<Light> lights;
        final /* synthetic */ GoogleHomeLightActivity this$0;

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/urbandroid/sleep/service/google/home/GoogleHomeLightActivity$LightListAdapter$RowView;", "", "<init>", "(Lcom/urbandroid/sleep/service/google/home/GoogleHomeLightActivity$LightListAdapter;)V", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "setTitle", "(Landroid/widget/TextView;)V", "desc", "getDesc", "setDesc", "check", "Lcom/google/android/material/materialswitch/MaterialSwitch;", "getCheck", "()Lcom/google/android/material/materialswitch/MaterialSwitch;", "setCheck", "(Lcom/google/android/material/materialswitch/MaterialSwitch;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public final class RowView {
            private MaterialSwitch check;
            private TextView desc;
            private TextView title;

            public RowView() {
            }

            public final MaterialSwitch getCheck() {
                return this.check;
            }

            public final TextView getDesc() {
                return this.desc;
            }

            public final TextView getTitle() {
                return this.title;
            }

            public final void setCheck(MaterialSwitch materialSwitch) {
                this.check = materialSwitch;
            }

            public final void setDesc(TextView textView) {
                this.desc = textView;
            }

            public final void setTitle(TextView textView) {
                this.title = textView;
            }
        }

        public LightListAdapter(GoogleHomeLightActivity googleHomeLightActivity, List<Light> list) {
            list.getClass();
            this.this$0 = googleHomeLightActivity;
            this.lights = list;
            this.inflator = InflatorUtil.INSTANCE.get(googleHomeLightActivity);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.lights.size();
        }

        @Override // android.widget.Adapter
        public Light getItem(int arg0) {
            return this.lights.get(arg0);
        }

        @Override // android.widget.Adapter
        public long getItemId(int arg0) {
            return arg0;
        }

        @Override // android.widget.Adapter
        public View getView(int index, View convertView, ViewGroup viewGroup) {
            View viewInflate;
            RowView rowView;
            viewGroup.getClass();
            if (convertView == null) {
                rowView = new RowView();
                viewInflate = this.inflator.inflate(R.layout.activity_smartlight_light_item, (ViewGroup) null);
                View viewFindViewById = viewInflate.findViewById(R.id.light_title);
                viewFindViewById.getClass();
                rowView.setTitle((TextView) viewFindViewById);
                View viewFindViewById2 = viewInflate.findViewById(R.id.light_desc);
                viewFindViewById2.getClass();
                rowView.setDesc((TextView) viewFindViewById2);
                View viewFindViewById3 = viewInflate.findViewById(R.id.light_check);
                viewFindViewById3.getClass();
                rowView.setCheck((MaterialSwitch) viewFindViewById3);
                viewInflate.setTag(rowView);
            } else {
                Object tag = convertView.getTag();
                tag.getClass();
                RowView rowView2 = (RowView) tag;
                viewInflate = convertView;
                rowView = rowView2;
            }
            Light light = this.lights.get(index);
            GoogleHomeLightActivity googleHomeLightActivity = this.this$0;
            TextView title = rowView.getTitle();
            if (title != null) {
                title.setText(light.getName());
            }
            TextView desc = rowView.getDesc();
            if (desc != null) {
                desc.setText("");
            }
            MaterialSwitch check = rowView.getCheck();
            if (check != null) {
                check.setChecked(googleHomeLightActivity.selectedLights.contains(light));
            }
            viewInflate.setTag(rowView);
            return viewInflate;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.home.GoogleHomeLightActivity$onCreate$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.home.GoogleHomeLightActivity$onCreate$2", f = "GoogleHomeLightActivity.kt", l = {83}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ViewGroup $emptyView;
        final /* synthetic */ ProgressBar $progress;
        int label;
        final /* synthetic */ GoogleHomeLightActivity this$0;

        /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.home.GoogleHomeLightActivity$onCreate$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "com.urbandroid.sleep.service.google.home.GoogleHomeLightActivity$onCreate$2$1", f = "GoogleHomeLightActivity.kt", l = {84, 87}, m = "invokeSuspend", v = 2)
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ GoogleHomeLightActivity $context;
            final /* synthetic */ ViewGroup $emptyView;
            final /* synthetic */ ProgressBar $progress;
            Object L$0;
            int label;
            final /* synthetic */ GoogleHomeLightActivity this$0;

            /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.home.GoogleHomeLightActivity$onCreate$2$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
            @DebugMetadata(c = "com.urbandroid.sleep.service.google.home.GoogleHomeLightActivity$onCreate$2$1$1", f = "GoogleHomeLightActivity.kt", l = {}, m = "invokeSuspend", v = 2)
            public static final class C00471 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ ViewGroup $emptyView;
                final /* synthetic */ List<Light> $lights;
                final /* synthetic */ ProgressBar $progress;
                int label;
                final /* synthetic */ GoogleHomeLightActivity this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00471(ProgressBar progressBar, List<Light> list, GoogleHomeLightActivity googleHomeLightActivity, ViewGroup viewGroup, Continuation<? super C00471> continuation) {
                    super(2, continuation);
                    this.$progress = progressBar;
                    this.$lights = list;
                    this.this$0 = googleHomeLightActivity;
                    this.$emptyView = viewGroup;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void invokeSuspend$lambda$1$0(List list, GoogleHomeLightActivity googleHomeLightActivity, ListView listView, LightListAdapter lightListAdapter, AdapterView adapterView, View view, int i, long j) {
                    Light light = (Light) list.get(i);
                    Configuration configuration = null;
                    if (googleHomeLightActivity.selectedLights.contains(light)) {
                        String strM = FileInsert$$ExternalSyntheticOutline0.m(listView.getId(), "Removing light ");
                        Logger.logInfo(Logger.defaultTag, googleHomeLightActivity.getTag() + ": " + strM, null);
                        Configuration configuration2 = googleHomeLightActivity.configuration;
                        if (configuration2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("configuration");
                            configuration2 = null;
                        }
                        configuration2.removeLight(light);
                    } else {
                        String strM2 = FileInsert$$ExternalSyntheticOutline0.m(listView.getId(), "Adding light ");
                        Logger.logInfo(Logger.defaultTag, googleHomeLightActivity.getTag() + ": " + strM2, null);
                        Configuration configuration3 = googleHomeLightActivity.configuration;
                        if (configuration3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("configuration");
                            configuration3 = null;
                        }
                        configuration3.addLight(light);
                    }
                    Configuration configuration4 = googleHomeLightActivity.configuration;
                    if (configuration4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("configuration");
                    } else {
                        configuration = configuration4;
                    }
                    googleHomeLightActivity.selectedLights = CollectionsKt.toList(configuration.getSelectedLights());
                    lightListAdapter.notifyDataSetChanged();
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C00471(this.$progress, this.$lights, this.this$0, this.$emptyView, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C00471) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    final ListView listView = null;
                    if (this.label != 0) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    ProgressBar progressBar = this.$progress;
                    progressBar.getClass();
                    ViewExtKt.gone(progressBar);
                    boolean zIsEmpty = this.$lights.isEmpty();
                    GoogleHomeLightActivity googleHomeLightActivity = this.this$0;
                    if (zIsEmpty) {
                        Logger.logWarning(Logger.defaultTag, googleHomeLightActivity.getTag() + ": No lights found", null);
                        ViewGroup viewGroup = this.$emptyView;
                        viewGroup.getClass();
                        ViewExtKt.show(viewGroup);
                        return Unit.INSTANCE;
                    }
                    Configuration configuration = googleHomeLightActivity.configuration;
                    if (configuration == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("configuration");
                        configuration = null;
                    }
                    configuration.clearLights();
                    List<Light> list = this.$lights;
                    GoogleHomeLightActivity googleHomeLightActivity2 = this.this$0;
                    for (Light light : list) {
                        if (googleHomeLightActivity2.selectedLights.contains(light)) {
                            Configuration configuration2 = googleHomeLightActivity2.configuration;
                            if (configuration2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("configuration");
                                configuration2 = null;
                            }
                            configuration2.addLight(light);
                        }
                    }
                    ViewGroup viewGroup2 = this.$emptyView;
                    viewGroup2.getClass();
                    ViewExtKt.gone(viewGroup2);
                    ListView listView2 = this.this$0.lightsList;
                    if (listView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("lightsList");
                    } else {
                        listView = listView2;
                    }
                    final GoogleHomeLightActivity googleHomeLightActivity3 = this.this$0;
                    final List<Light> list2 = this.$lights;
                    final LightListAdapter lightListAdapter = new LightListAdapter(googleHomeLightActivity3, list2);
                    listView.setAdapter((ListAdapter) lightListAdapter);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.urbandroid.sleep.service.google.home.GoogleHomeLightActivity$onCreate$2$1$1$$ExternalSyntheticLambda0
                        @Override // android.widget.AdapterView.OnItemClickListener
                        public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                            GoogleHomeLightActivity.AnonymousClass2.AnonymousClass1.C00471.invokeSuspend$lambda$1$0(list2, googleHomeLightActivity3, listView, lightListAdapter, adapterView, view, i, j);
                        }
                    });
                    lightListAdapter.notifyDataSetChanged();
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(GoogleHomeLightActivity googleHomeLightActivity, ProgressBar progressBar, GoogleHomeLightActivity googleHomeLightActivity2, ViewGroup viewGroup, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$context = googleHomeLightActivity;
                this.$progress = progressBar;
                this.this$0 = googleHomeLightActivity2;
                this.$emptyView = viewGroup;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$context, this.$progress, this.this$0, this.$emptyView, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x007e, code lost:
            
                if (kotlinx.coroutines.BuildersKt.withContext(r10, r3, r9) == r0) goto L19;
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
                    obj = companion.getLightDevices(this);
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
                Iterable iterable = (Iterable) obj;
                GoogleHomeLightActivity googleHomeLightActivity = this.$context;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(GoogleHomeClient.INSTANCE.getInstance(googleHomeLightActivity).getLightForDevice((HomeDevice) it.next()));
                }
                MainCoroutineDispatcher main = Dispatchers.getMain();
                C00471 c00471 = new C00471(this.$progress, arrayList, this.this$0, this.$emptyView, null);
                this.L$0 = SpillingKt.nullOutSpilledVariable(arrayList);
                this.label = 2;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ProgressBar progressBar, GoogleHomeLightActivity googleHomeLightActivity, ViewGroup viewGroup, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$progress = progressBar;
            this.this$0 = googleHomeLightActivity;
            this.$emptyView = viewGroup;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GoogleHomeLightActivity.this.new AnonymousClass2(this.$progress, this.this$0, this.$emptyView, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineDispatcher io2 = Dispatchers.getIO();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(GoogleHomeLightActivity.this, this.$progress, this.this$0, this.$emptyView, null);
                this.label = 1;
                if (BuildersKt.withContext(io2, anonymousClass1, this) == coroutine_suspended) {
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

    public GoogleHomeLightActivity() {
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default(null, 1, null);
        this.job = completableJobSupervisorJob$default;
        this.coroutineContext = Dispatchers.getMain().plus(completableJobSupervisorJob$default).plus(new GoogleHomeLightActivity$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, this));
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smartlight_lights);
        TintUtil.tint(this);
        ToolbarUtil.apply(this);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        setTitle(R.string.light);
        View viewFindViewById = findViewById(R.id.lights_list);
        viewFindViewById.getClass();
        this.lightsList = (ListView) viewFindViewById;
        Configuration configuration = new Configuration(this, null, 2, 0 == true ? 1 : 0);
        this.configuration = configuration;
        this.selectedLights = CollectionsKt.toMutableList((Collection) configuration.getSelectedLights());
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.empty_list_view);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress);
        viewGroup.getClass();
        ViewExtKt.hide(viewGroup);
        ((Button) findViewById(R.id.buttonOk)).setOnClickListener(new WebDialog$$ExternalSyntheticLambda1(this, 25));
        if (WifiEnabler.getInstance().isWifiConnected()) {
            progressBar.getClass();
            ViewExtKt.show(progressBar);
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new AnonymousClass2(progressBar, this, viewGroup, null), 3, null);
        } else {
            String string = getString(R.string.share_disconnected, getString(R.string.wifi));
            string.getClass();
            Toast.makeText(this, string, 0).show();
            finish();
        }
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        CoroutineScopeKt.cancel$default(this, null, 1, null);
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        item.getClass();
        if (item.getItemId() == R.id.menu_item_reset) {
            reset();
            return true;
        }
        finish();
        return true;
    }

    public final void reset() {
        Configuration configuration = this.configuration;
        if (configuration == null) {
            Intrinsics.throwUninitializedPropertyAccessException("configuration");
            configuration = null;
        }
        configuration.clearLights();
        HueSharedPreferences.getInstance(this).reset();
        log("SmartLight: reset gateway");
        AuthenticatedGateway.INSTANCE.reset(this);
        finish();
    }
}
