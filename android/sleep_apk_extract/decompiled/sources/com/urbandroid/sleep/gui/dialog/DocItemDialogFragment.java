package com.urbandroid.sleep.gui.dialog;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.facebook.login.LoginFragment$$ExternalSyntheticLambda0;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.common.error.ErrorReporter;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.QuickStartPreviewActivity;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.AlarmClock;
import com.urbandroid.sleep.alarmclock.settings.SimpleSettingsActivity;
import com.urbandroid.sleep.errorreporting.ErrorReporting;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.smartwatch.Wearable;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.Experiments;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J$\u0010\r\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0002J\u001a\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/urbandroid/sleep/gui/dialog/DocItemDialogFragment;", "Lcom/urbandroid/sleep/gui/dialog/ItemDialogFragment;", "<init>", "()V", "createItems", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/app/Activity;", "titleRes", "", "getSubtitleRes", "getIconRes", "getTitleRes", "createHelpDefaults", "createDocEntry", "title", "", "link", "createListenerDocEntry", "createLegendEntry", "createCommon", "canShowSendWearableReport", "", "settings", "Lcom/urbandroid/sleep/service/Settings;", "createDialog", "Landroid/app/Dialog;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DocItemDialogFragment extends ItemDialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private int titleRes = R.string.support;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/urbandroid/sleep/gui/dialog/DocItemDialogFragment$Companion;", "", "<init>", "()V", "EXTRA_TYPE", "", "EXTRA_DOC_TITLE", "EXTRA_DOC_LINK", "MENU", "SETTINGS", "GRAPH", "newInstance", "Lcom/urbandroid/sleep/gui/dialog/DocItemDialogFragment;", "type", "title", "link", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DocItemDialogFragment newInstance(String type, String title, String link) {
            type.getClass();
            DocItemDialogFragment docItemDialogFragment = new DocItemDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("type", type);
            bundle.putString("doc_title", title);
            bundle.putString("doc_link", link);
            docItemDialogFragment.setArguments(bundle);
            return docItemDialogFragment;
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.gui.dialog.DocItemDialogFragment$createCommon$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/urbandroid/sleep/gui/dialog/DocItemDialogFragment$createCommon$2", "Lcom/urbandroid/sleep/gui/dialog/DialogItem;", "onClick", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass2 extends DialogItem {
        final /* synthetic */ Activity $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Activity activity, String str) {
            super(str, R.drawable.ic_bug);
            this.$context = activity;
            str.getClass();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onClick$lambda$0(Activity activity, DialogInterface dialogInterface, String str) {
            try {
                ErrorReporting.reportWearableThroughAddonActivity(activity, str);
            } catch (ActivityNotFoundException e) {
                Logger.logDebug("ErrorReportActivity not found, reporting using REPORT broadcast", e);
                ErrorReporting.reportWearableThroughBroadcast(activity, str);
            }
            dialogInterface.dismiss();
        }

        @Override // com.urbandroid.sleep.gui.dialog.DialogItem
        public void onClick() {
            Dialog dialogProvideOnDemandDialog = ErrorReporter.getInstance().provideOnDemandDialog(this.$context, new LoginFragment$$ExternalSyntheticLambda0(this.$context, 27));
            dialogProvideOnDemandDialog.setCanceledOnTouchOutside(false);
            dialogProvideOnDemandDialog.show();
        }
    }

    private final boolean canShowSendWearableReport(Settings settings) {
        if (settings.getSelectedWearable() != null) {
            Wearable selectedWearable = settings.getSelectedWearable();
            selectedWearable.getClass();
            if (selectedWearable.canGatherWearableReport()) {
                return true;
            }
        }
        return Experiments.getInstance().isOurExperimentalPhone();
    }

    private final DocItemDialogFragment createCommon(Activity context) {
        List<DialogItem> items = getItems();
        String string = context.getString(R.string.faq);
        string.getClass();
        items.add(new ViewDialogItem(context, string, R.drawable.ic_help_q, "https://sleep.urbandroid.org/docs/faqs/"));
        List<DialogItem> items2 = getItems();
        String string2 = context.getString(R.string.menu_about);
        string2.getClass();
        items2.add(new IntentDialogItem(context, string2, R.drawable.ic_information, new Intent(context, (Class<?>) QuickStartPreviewActivity.class)));
        List<DialogItem> items3 = getItems();
        String string3 = context.getString(R.string.watch_video);
        string3.getClass();
        items3.add(new ViewDialogItem(context, string3, R.drawable.ic_action_play, "https://youtu.be/whUibMSqkO4"));
        List<DialogItem> items4 = getItems();
        String string4 = context.getString(R.string.forum);
        string4.getClass();
        items4.add(new ViewDialogItem(context, string4, R.drawable.ic_action_forum, "https://forum.urbandroid.org/"));
        getItems().add(new DialogItem(context, context.getString(R.string.on_demand_report_title)) { // from class: com.urbandroid.sleep.gui.dialog.DocItemDialogFragment.createCommon.1
            final /* synthetic */ Activity $context;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(str, R.drawable.ic_bug);
                str.getClass();
            }

            @Override // com.urbandroid.sleep.gui.dialog.DialogItem
            public void onClick() {
                Dialog dialogProvideOnDemandDialog = ErrorReporter.getInstance().provideOnDemandDialog(this.$context);
                dialogProvideOnDemandDialog.setCanceledOnTouchOutside(false);
                dialogProvideOnDemandDialog.show();
            }
        });
        if (canShowSendWearableReport(new Settings(getActivity()))) {
            getItems().add(new AnonymousClass2(context, context.getString(R.string.send_wearable_report)));
        }
        List<DialogItem> items5 = getItems();
        String string5 = context.getString(R.string.get_support);
        string5.getClass();
        String string6 = context.getString(R.string.get_support);
        int i = Build.VERSION.SDK_INT;
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        StringBuilder sb = new StringBuilder();
        sb.append(string6);
        sb.append(" - 20260519 (231055) ");
        sb.append(i);
        sb.append(" ");
        sb.append(str);
        Intent sendToIntent = ViewIntent.getSendToIntent(context, "support@urbandroid.org", FileInsert$$ExternalSyntheticOutline0.m(sb, " ", str2), "");
        sendToIntent.getClass();
        items5.add(new IntentDialogItem(context, string5, R.drawable.ic_mail, sendToIntent));
        getItems().add(new DialogItem(context.getString(R.string.release)) { // from class: com.urbandroid.sleep.gui.dialog.DocItemDialogFragment.createCommon.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(str, R.drawable.ic_gift);
                str.getClass();
            }

            @Override // com.urbandroid.sleep.gui.dialog.DialogItem
            public void onClick() {
                AlarmClock.showReleaseNotes(DocItemDialogFragment.this.getActivity());
            }
        });
        getItems().add(new DialogItem(context.getString(R.string.backup)) { // from class: com.urbandroid.sleep.gui.dialog.DocItemDialogFragment.createCommon.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(str, R.drawable.ic_cloud_upload);
                str.getClass();
            }

            @Override // com.urbandroid.sleep.gui.dialog.DialogItem
            public void onClick() {
                BackupItemDialogFragment backupItemDialogFragmentNewInstance = BackupItemDialogFragment.INSTANCE.newInstance();
                FragmentActivity activity = DocItemDialogFragment.this.getActivity();
                FragmentManager supportFragmentManager = activity != null ? activity.getSupportFragmentManager() : null;
                supportFragmentManager.getClass();
                backupItemDialogFragmentNewInstance.show(supportFragmentManager, "backup");
            }
        });
        getItems().add(new DialogItem(context.getString(R.string.contribute_translation)) { // from class: com.urbandroid.sleep.gui.dialog.DocItemDialogFragment.createCommon.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(str, R.drawable.ic_translate);
                str.getClass();
            }

            @Override // com.urbandroid.sleep.gui.dialog.DialogItem
            public void onClick() {
                ViewIntent.url(DocItemDialogFragment.this.getActivity(), "https://docs.google.com/spreadsheets/d/1N3CrEP19aB66DBFzONIPooH5dWUW_mU4ENH_MeD1QFU/edit?usp=sharing");
            }
        });
        return this;
    }

    private final DocItemDialogFragment createDocEntry(Activity context, String title, String link) {
        List<DialogItem> items = getItems();
        String string = context.getString(R.string.documentation);
        string.getClass();
        ViewDialogItem viewDialogItem = new ViewDialogItem(context, string, R.drawable.ic_help_q, link);
        viewDialogItem.setSubtitle(title);
        items.add(viewDialogItem);
        return this;
    }

    public static /* synthetic */ DocItemDialogFragment createDocEntry$default(DocItemDialogFragment docItemDialogFragment, Activity activity, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = activity.getString(R.string.app_name_long);
            str.getClass();
        }
        if ((i & 4) != 0) {
            str2 = "https://sleep.urbandroid.org/docs/";
        }
        return docItemDialogFragment.createDocEntry(activity, str, str2);
    }

    private final DocItemDialogFragment createHelpDefaults(Activity context) {
        createDocEntry$default(this, context, null, null, 6, null);
        createCommon(context);
        return this;
    }

    private final DocItemDialogFragment createLegendEntry(Activity context) {
        getItems().add(new DialogItem(context, getString(R.string.legend)) { // from class: com.urbandroid.sleep.gui.dialog.DocItemDialogFragment.createLegendEntry.1
            final /* synthetic */ Activity $context;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(str, R.drawable.ic_information);
                str.getClass();
            }

            @Override // com.urbandroid.sleep.gui.dialog.DialogItem
            public void onClick() {
                View viewInflate = DocItemDialogFragment.this.getLayoutInflater().inflate(R.layout.dialog_legend, (ViewGroup) null);
                viewInflate.findViewById(R.id.label_light_sleep).setBackgroundColor(ColorUtil.i(DocItemDialogFragment.this.getContext(), R.color.light_sleep));
                viewInflate.findViewById(R.id.label_deep_sleep).setBackgroundColor(ColorUtil.i(DocItemDialogFragment.this.getContext(), R.color.deep_sleep));
                viewInflate.findViewById(R.id.label_awake).setBackgroundColor(ColorUtil.i(DocItemDialogFragment.this.getContext(), R.color.awake));
                viewInflate.findViewById(R.id.label_rem).setBackgroundColor(ColorUtil.i(DocItemDialogFragment.this.getContext(), R.color.light_sleep));
                new MaterialAlertDialogBuilder(this.$context).setTitle(R.string.legend).setView(viewInflate).setPositiveButton(R.string.button_ok, (DialogInterface.OnClickListener) null).show();
            }
        });
        return this;
    }

    private final DocItemDialogFragment createListenerDocEntry(Activity context, String title) {
        List<DialogItem> items = getItems();
        DialogItem dialogItem = new DialogItem(context, context.getString(R.string.documentation)) { // from class: com.urbandroid.sleep.gui.dialog.DocItemDialogFragment.createListenerDocEntry.1
            final /* synthetic */ Activity $context;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(str, R.drawable.ic_help_q);
                str.getClass();
            }

            @Override // com.urbandroid.sleep.gui.dialog.DialogItem
            public void onClick() {
                Activity activity = this.$context;
                if (activity instanceof SimpleSettingsActivity) {
                    ((SimpleSettingsActivity) activity).showDocumentation();
                }
            }
        };
        dialogItem.setSubtitle(title);
        items.add(dialogItem);
        return this;
    }

    public static final DocItemDialogFragment newInstance(String str, String str2, String str3) {
        return INSTANCE.newInstance(str, str2, str3);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0072  */
    @Override // com.urbandroid.sleep.gui.dialog.ItemDialogFragment, com.urbandroid.sleep.gui.dialog.FixedDialogFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Dialog createDialog() {
        String string;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Bundle arguments = getArguments();
            String string2 = arguments != null ? arguments.getString("type") : null;
            if (string2 == null) {
                createHelpDefaults(activity);
            } else {
                int iHashCode = string2.hashCode();
                if (iHashCode != 3347807) {
                    if (iHashCode != 98615630) {
                        if (iHashCode == 1434631203 && string2.equals("settings")) {
                            Bundle arguments2 = getArguments();
                            if (arguments2 == null || (string = arguments2.getString("doc_title")) == null) {
                                string = "";
                            }
                            createListenerDocEntry(activity, string);
                            createCommon(activity);
                        }
                    } else if (string2.equals("graph")) {
                        String string3 = activity.getString(R.string.graphs);
                        string3.getClass();
                        createDocEntry(activity, string3, "https://sleep.urbandroid.org/docs//sleep/graph_edit.html");
                        createLegendEntry(activity);
                    }
                } else if (string2.equals("menu")) {
                    createHelpDefaults(activity);
                }
            }
        }
        return super.createDialog();
    }

    @Override // com.urbandroid.sleep.gui.dialog.ItemDialogFragment
    public ItemDialogFragment createItems(Activity context) {
        context.getClass();
        return this;
    }

    @Override // com.urbandroid.sleep.gui.dialog.ItemDialogFragment
    public int getIconRes() {
        return R.drawable.preview_support;
    }

    @Override // com.urbandroid.sleep.gui.dialog.ItemDialogFragment
    public int getSubtitleRes() {
        return R.string.support_summary;
    }

    @Override // com.urbandroid.sleep.gui.dialog.ItemDialogFragment
    public int getTitleRes() {
        return this.titleRes;
    }
}
