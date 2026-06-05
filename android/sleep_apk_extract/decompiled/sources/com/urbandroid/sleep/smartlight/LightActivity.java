package com.urbandroid.sleep.smartlight;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
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
import com.google.android.material.materialswitch.MaterialSwitch;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.wifi.WifiEnabler;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.ViewExtKt;
import com.urbandroid.sleep.gui.TintUtil;
import com.urbandroid.sleep.gui.ToolbarUtil;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import com.urbandroid.sleep.smartlight.LightActivity;
import com.urbandroid.smartlight.common.Common_smartlightKt;
import com.urbandroid.smartlight.common.Configuration;
import com.urbandroid.smartlight.common.controller.Controller;
import com.urbandroid.smartlight.common.controller.ControllerFactory;
import com.urbandroid.smartlight.common.model.AuthenticatedGateway;
import com.urbandroid.smartlight.common.model.Light;
import com.urbandroid.smartlight.hue.data.HueSharedPreferences;
import com.urbandroid.util.EdgeToEdgeUtil;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 %2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002$%B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0018H\u0014J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"H\u0016J\u0006\u0010#\u001a\u00020\u0018R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/urbandroid/sleep/smartlight/LightActivity;", "Lcom/urbandroid/common/BaseActivity;", "Lcom/urbandroid/common/FeatureLogger;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "lightsList", "Landroid/widget/ListView;", "selectedLights", "", "Lcom/urbandroid/smartlight/common/model/Light;", "job", "Lkotlinx/coroutines/CompletableJob;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "configuration", "Lcom/urbandroid/smartlight/common/Configuration;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "reset", "LightListAdapter", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LightActivity extends BaseActivity implements FeatureLogger, CoroutineScope {
    private Configuration configuration;
    private final CoroutineContext coroutineContext;
    private final CompletableJob job;
    private ListView lightsList;
    private final String tag = Common_smartlightKt.TAG;
    private List<Light> selectedLights = CollectionsKt.emptyList();

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001:\u0001\u0015B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\nH\u0016J\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/urbandroid/sleep/smartlight/LightActivity$LightListAdapter;", "Landroid/widget/BaseAdapter;", "lights", "", "Lcom/urbandroid/smartlight/common/model/Light;", "<init>", "(Lcom/urbandroid/sleep/smartlight/LightActivity;Ljava/util/List;)V", "inflator", "Landroid/view/LayoutInflater;", "getCount", "", "getItem", "arg0", "getItemId", "", "getView", "Landroid/view/View;", "index", "convertView", "viewGroup", "Landroid/view/ViewGroup;", "RowView", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public final class LightListAdapter extends BaseAdapter {
        private final LayoutInflater inflator;
        private final List<Light> lights;
        final /* synthetic */ LightActivity this$0;

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/urbandroid/sleep/smartlight/LightActivity$LightListAdapter$RowView;", "", "<init>", "(Lcom/urbandroid/sleep/smartlight/LightActivity$LightListAdapter;)V", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "setTitle", "(Landroid/widget/TextView;)V", "desc", "getDesc", "setDesc", "check", "Lcom/google/android/material/materialswitch/MaterialSwitch;", "getCheck", "()Lcom/google/android/material/materialswitch/MaterialSwitch;", "setCheck", "(Lcom/google/android/material/materialswitch/MaterialSwitch;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
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

        public LightListAdapter(LightActivity lightActivity, List<Light> list) {
            list.getClass();
            this.this$0 = lightActivity;
            this.lights = list;
            this.inflator = InflatorUtil.INSTANCE.get(lightActivity);
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
            LightActivity lightActivity = this.this$0;
            TextView title = rowView.getTitle();
            if (title != null) {
                title.setText(light.getName());
            }
            TextView desc = rowView.getDesc();
            if (desc != null) {
                desc.setText(light.getId());
            }
            MaterialSwitch check = rowView.getCheck();
            if (check != null) {
                check.setChecked(lightActivity.selectedLights.contains(light));
            }
            viewInflate.setTag(rowView);
            return viewInflate;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.smartlight.LightActivity$onCreate$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.smartlight.LightActivity$onCreate$3", f = "LightActivity.kt", l = {89}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ViewGroup $emptyView;
        final /* synthetic */ AuthenticatedGateway $gateway;
        final /* synthetic */ ProgressBar $progress;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(AuthenticatedGateway authenticatedGateway, ProgressBar progressBar, ViewGroup viewGroup, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$gateway = authenticatedGateway;
            this.$progress = progressBar;
            this.$emptyView = viewGroup;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$1$0(List list, LightActivity lightActivity, ListView listView, LightListAdapter lightListAdapter, Controller controller, AdapterView adapterView, View view, int i, long j) {
            Light light = (Light) list.get(i);
            Configuration configuration = null;
            if (lightActivity.selectedLights.contains(light)) {
                String strM = FileInsert$$ExternalSyntheticOutline0.m(listView.getId(), "Removing light ");
                Logger.logInfo(Logger.defaultTag, lightActivity.getTag() + ": " + strM, null);
                Configuration configuration2 = lightActivity.configuration;
                if (configuration2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("configuration");
                    configuration2 = null;
                }
                configuration2.removeLight(light);
            } else {
                BuildersKt__Builders_commonKt.launch$default(lightActivity, null, null, new LightActivity$onCreate$3$2$1$1(lightActivity, listView, controller, light, null), 3, null);
                String strM2 = FileInsert$$ExternalSyntheticOutline0.m(listView.getId(), "Adding light ");
                Logger.logInfo(Logger.defaultTag, lightActivity.getTag() + ": " + strM2, null);
                Configuration configuration3 = lightActivity.configuration;
                if (configuration3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("configuration");
                    configuration3 = null;
                }
                configuration3.addLight(light);
            }
            Configuration configuration4 = lightActivity.configuration;
            if (configuration4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("configuration");
            } else {
                configuration = configuration4;
            }
            lightActivity.selectedLights = CollectionsKt.toList(configuration.getSelectedLights());
            lightListAdapter.notifyDataSetChanged();
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LightActivity.this.new AnonymousClass3(this.$gateway, this.$progress, this.$emptyView, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            final Controller controller;
            final ListView listView;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Controller controllerCreate = new ControllerFactory(LightActivity.this).create(this.$gateway);
                this.L$0 = controllerCreate;
                this.label = 1;
                Object lights = controllerCreate.getLights(this);
                if (lights == coroutine_suspended) {
                    return coroutine_suspended;
                }
                controller = controllerCreate;
                obj = lights;
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                Controller controller2 = (Controller) this.L$0;
                ResultKt.throwOnFailure(obj);
                controller = controller2;
            }
            final List<Light> list = (List) obj;
            ProgressBar progressBar = this.$progress;
            progressBar.getClass();
            ViewExtKt.gone(progressBar);
            boolean zIsEmpty = list.isEmpty();
            LightActivity lightActivity = LightActivity.this;
            if (zIsEmpty) {
                Logger.logWarning(Logger.defaultTag, lightActivity.getTag() + ": No lights found", null);
                ViewGroup viewGroup = this.$emptyView;
                viewGroup.getClass();
                ViewExtKt.show(viewGroup);
                return Unit.INSTANCE;
            }
            Configuration configuration = lightActivity.configuration;
            if (configuration == null) {
                Intrinsics.throwUninitializedPropertyAccessException("configuration");
                configuration = null;
            }
            configuration.clearLights();
            LightActivity lightActivity2 = LightActivity.this;
            for (Light light : list) {
                if (lightActivity2.selectedLights.contains(light)) {
                    Configuration configuration2 = lightActivity2.configuration;
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
            ListView listView2 = LightActivity.this.lightsList;
            if (listView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lightsList");
                listView = null;
            } else {
                listView = listView2;
            }
            final LightActivity lightActivity3 = LightActivity.this;
            final LightListAdapter lightListAdapter = new LightListAdapter(lightActivity3, list);
            listView.setAdapter((ListAdapter) lightListAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.urbandroid.sleep.smartlight.LightActivity$onCreate$3$$ExternalSyntheticLambda0
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i2, long j) {
                    LightActivity.AnonymousClass3.invokeSuspend$lambda$1$0(list, lightActivity3, listView, lightListAdapter, controller, adapterView, view, i2, j);
                }
            });
            lightListAdapter.notifyDataSetChanged();
            return Unit.INSTANCE;
        }
    }

    public LightActivity() {
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default(null, 1, null);
        this.job = completableJobSupervisorJob$default;
        this.coroutineContext = Dispatchers.getMain().plus(completableJobSupervisorJob$default).plus(new LightActivity$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(LightActivity lightActivity, View view) {
        Logger.logInfo(Logger.defaultTag, lightActivity.getTag() + ": Click", null);
        lightActivity.reset();
        lightActivity.startActivity(new Intent(lightActivity, (Class<?>) DiscoveryActivity.class));
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
        final int i = 1;
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
        EdgeToEdgeUtil.Companion.insetsBottom$default(EdgeToEdgeUtil.INSTANCE, findViewById(R.id.buttonOk), 0, false, 6, null);
        final int i2 = 0;
        ((Button) findViewById(R.id.buttonOk)).setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.smartlight.LightActivity$$ExternalSyntheticLambda0
            public final /* synthetic */ LightActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3 = i2;
                LightActivity lightActivity = this.f$0;
                switch (i3) {
                    case 0:
                        lightActivity.finish();
                        break;
                    default:
                        LightActivity.onCreate$lambda$1(lightActivity, view);
                        break;
                }
            }
        });
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.empty_list_view);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress);
        findViewById(R.id.find_new_bridge).setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.smartlight.LightActivity$$ExternalSyntheticLambda0
            public final /* synthetic */ LightActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3 = i;
                LightActivity lightActivity = this.f$0;
                switch (i3) {
                    case 0:
                        lightActivity.finish();
                        break;
                    default:
                        LightActivity.onCreate$lambda$1(lightActivity, view);
                        break;
                }
            }
        });
        viewGroup.getClass();
        ViewExtKt.hide(viewGroup);
        AuthenticatedGateway.Companion companion = AuthenticatedGateway.INSTANCE;
        Context applicationContext = getApplicationContext();
        applicationContext.getClass();
        AuthenticatedGateway authenticatedGatewayLoad = companion.load(applicationContext);
        if (authenticatedGatewayLoad == null) {
            finish();
            return;
        }
        if (WifiEnabler.getInstance().isWifiConnected()) {
            progressBar.getClass();
            ViewExtKt.show(progressBar);
            BuildersKt__Builders_commonKt.launch$default(this, null, null, new AnonymousClass3(authenticatedGatewayLoad, progressBar, viewGroup, null), 3, null);
        } else {
            String string = getString(R.string.share_disconnected, getString(R.string.wifi));
            string.getClass();
            Toast.makeText(this, string, 0).show();
            finish();
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.getClass();
        getMenuInflater().inflate(R.menu.light_menu, menu);
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
