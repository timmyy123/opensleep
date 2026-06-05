package com.urbandroid.sleep.gui.dialog;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.content.FileProvider;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.PreferencesUtils;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.alarmclock.AlarmClock;
import com.urbandroid.sleep.alarmclock.settings.TrackSettingsActivity$$ExternalSyntheticLambda8;
import com.urbandroid.sleep.async.ExportDataAsyncTask;
import com.urbandroid.sleep.async.IHasProgressContext;
import com.urbandroid.sleep.persistence.Export;
import com.urbandroid.sleep.persistence.ExportUtilKt;
import com.urbandroid.sleep.service.health.HealthServiceProvider;
import com.urbandroid.sleep.service.health.HeathImportDataService;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\u0003J\r\u0010\n\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/urbandroid/sleep/gui/dialog/BackupItemDialogFragment;", "Lcom/urbandroid/sleep/gui/dialog/ItemDialogFragment;", "<init>", "()V", "Landroid/app/Activity;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "createItems", "(Landroid/app/Activity;)Lcom/urbandroid/sleep/gui/dialog/ItemDialogFragment;", "", "showPurchaseToast", "showPleaseWait", "", "getIconRes", "()I", "getSubtitleRes", "getTitleRes", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class BackupItemDialogFragment extends ItemDialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: loaded from: classes4.dex */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\u000b"}, d2 = {"Lcom/urbandroid/sleep/gui/dialog/BackupItemDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/urbandroid/sleep/gui/dialog/BackupItemDialogFragment;", "startDownloadFromCloud", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/app/Activity;", "startUploadToCloud", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BackupItemDialogFragment newInstance() {
            return new BackupItemDialogFragment();
        }

        public final void startDownloadFromCloud(Activity context) {
            context.getClass();
            try {
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.setComponent(new ComponentName("com.urbandroid.sleep.addon.port", "com.urbandroid.sleep.addon.port.PullActivity"));
                context.startActivityForResult(intent, 765);
            } catch (Exception e) {
                Logger.logSevere(null, e);
                ViewIntent.market(context, "com.urbandroid.sleep.addon.port");
            }
        }

        public final void startUploadToCloud(Activity context) {
            context.getClass();
            try {
                long cloudTimestamp = TrialFilter.getCloudTimestamp(context);
                File file = new File(Export.getExportZipFilePath(context));
                Uri uriForFile = FileProvider.getUriForFile(context, "com.urbandroid.sleep.fileprovider", file);
                Logger.logInfo("Backup: Starting Cloud backup. Ts: " + cloudTimestamp + " Prem: " + PreferencesUtils.isCloudPremiumStatus(context) + " Prem unk: " + PreferencesUtils.isCloudPremiumStatusUnknown(context) + "  uri " + uriForFile, null);
                Intent intent = new Intent("com.urbandroid.sleep.addon.port.backup.BackupConnectivityService");
                intent.setClassName("com.urbandroid.sleep.addon.port", "com.urbandroid.sleep.addon.port.backup.BackupConnectivityService");
                intent.putExtra("is_manually_started", true);
                intent.putExtra("TS", cloudTimestamp);
                Logger.logInfo("Backup: Sharing uri: " + uriForFile + " file: " + file, null);
                if (uriForFile != null && file.exists()) {
                    context.grantUriPermission("com.urbandroid.sleep.addon.port", uriForFile, 1);
                    intent.setData(uriForFile);
                    intent.addFlags(1);
                }
                ContextExtKt.startForegroundServiceWithLog(context, intent);
                Logger.logInfo("Backup: Cloud backup started", null);
            } catch (Exception e) {
                Logger.logSevere(null, e);
            }
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.gui.dialog.BackupItemDialogFragment$createItems$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/urbandroid/sleep/gui/dialog/BackupItemDialogFragment$createItems$3", "Lcom/urbandroid/sleep/gui/dialog/DialogItem;", "onClick", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass3 extends DialogItem {
        final /* synthetic */ Activity $context;
        final /* synthetic */ BackupItemDialogFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Activity activity, BackupItemDialogFragment backupItemDialogFragment, String str) {
            super(str, R.drawable.ic_download_plain);
            this.$context = activity;
            this.this$0 = backupItemDialogFragment;
            str.getClass();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final void onClick$lambda$1$0(Activity activity, DialogInterface dialogInterface, int i) {
            activity.getClass();
            ExportUtilKt.showImportDialog$default(activity, null, ((IHasProgressContext) activity).getProgressContextInstance(), null, 10, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onClick$lambda$1$1(Activity activity, DialogInterface dialogInterface, int i) {
            Logger.logInfo("starting browse and pick import file", null);
            ExportUtilKt.pickAndImportZipFile(activity);
        }

        @Override // com.urbandroid.sleep.gui.dialog.DialogItem
        public void onClick() {
            TrialFilter trialFilter = TrialFilter.getInstance();
            trialFilter.reevaluate();
            if (trialFilter.isTrial() && trialFilter.getVersion() != TrialFilter.Version.FULL && !trialFilter.isAddonImport()) {
                this.this$0.showPurchaseToast();
                return;
            }
            Logger.logDebug("Backup: Importing records", null);
            File exportFile = Export.getExportFile(this.$context, false, "sleep-export.zip");
            if (exportFile.exists() && exportFile.canRead() && exportFile.length() > 0) {
                MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(this.$context);
                Activity activity = this.$context;
                materialAlertDialogBuilder.setTitle(R.string.menu_import);
                materialAlertDialogBuilder.setMessage((CharSequence) (exportFile + " ?"));
                materialAlertDialogBuilder.setPositiveButton(R.string.button_ok, (DialogInterface.OnClickListener) new TrackSettingsActivity$$ExternalSyntheticLambda8(activity, 2));
                materialAlertDialogBuilder.setNeutralButton(R.string.browse, (DialogInterface.OnClickListener) new TrackSettingsActivity$$ExternalSyntheticLambda8(activity, 3));
                materialAlertDialogBuilder.setNegativeButton(R.string.button_cancel, (DialogInterface.OnClickListener) null);
                AlertDialog alertDialogCreate = materialAlertDialogBuilder.create();
                if (this.$context.isFinishing()) {
                    return;
                }
                alertDialogCreate.show();
                return;
            }
            Logger.logWarning(exportFile.getAbsolutePath() + " exists: " + exportFile.exists() + " canRead: " + exportFile.canRead() + " length: " + exportFile.length(), null);
            String absolutePath = exportFile.getAbsolutePath();
            StringBuilder sb = new StringBuilder();
            sb.append(absolutePath);
            sb.append(" not found - showing pick file dialog");
            Logger.logWarning(sb.toString(), null);
            ExportUtilKt.pickAndImportZipFile(this.$context);
        }
    }

    public static final BackupItemDialogFragment newInstance() {
        return INSTANCE.newInstance();
    }

    public static final void startDownloadFromCloud(Activity activity) {
        INSTANCE.startDownloadFromCloud(activity);
    }

    @Override // com.urbandroid.sleep.gui.dialog.ItemDialogFragment
    public ItemDialogFragment createItems(final Activity context) {
        context.getClass();
        List<DialogItem> items = getItems();
        DialogItem dialogItem = new DialogItem(context, context.getString(R.string.menu_export)) { // from class: com.urbandroid.sleep.gui.dialog.BackupItemDialogFragment.createItems.1
            final /* synthetic */ Activity $context;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(str, R.drawable.ic_upload_plain);
                str.getClass();
            }

            @Override // com.urbandroid.sleep.gui.dialog.DialogItem
            public void onClick() {
                Logger.logInfo("Backup: Export data task.", null);
                ComponentCallbacks2 componentCallbacks2 = this.$context;
                componentCallbacks2.getClass();
                new ExportDataAsyncTask(((IHasProgressContext) componentCallbacks2).getProgressContextInstance(), this.$context).zipped().execute(new Void[0]);
            }
        };
        dialogItem.setSubtitle(getString(R.string.settings_backup_local));
        items.add(dialogItem);
        List<DialogItem> items2 = getItems();
        AnonymousClass3 anonymousClass3 = new AnonymousClass3(context, this, context.getString(R.string.menu_import));
        anonymousClass3.setSubtitle(getString(R.string.settings_backup_local));
        items2.add(anonymousClass3);
        List<DialogItem> items3 = getItems();
        DialogItem dialogItem2 = new DialogItem(context, context.getString(R.string.menu_upload_cloud)) { // from class: com.urbandroid.sleep.gui.dialog.BackupItemDialogFragment.createItems.5
            final /* synthetic */ Activity $context;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(str, R.drawable.ic_cloud_upload);
                str.getClass();
            }

            @Override // com.urbandroid.sleep.gui.dialog.DialogItem
            public void onClick() {
                Logger.logInfo("Backup: Cloud upload", null);
                TrialFilter.getInstance().reevaluate();
                if (TrialFilter.getInstance().isAddonImport()) {
                    BackupItemDialogFragment.INSTANCE.startUploadToCloud(this.$context);
                } else {
                    ViewIntent.market(this.$context, "com.urbandroid.sleep.addon.port");
                }
            }
        };
        dialogItem2.setSubtitle(getString(R.string.settings_category_backup));
        items3.add(dialogItem2);
        List<DialogItem> items4 = getItems();
        DialogItem dialogItem3 = new DialogItem(context, context.getString(R.string.menu_download_cloud)) { // from class: com.urbandroid.sleep.gui.dialog.BackupItemDialogFragment.createItems.7
            final /* synthetic */ Activity $context;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(str, R.drawable.ic_cloud_download);
                str.getClass();
            }

            @Override // com.urbandroid.sleep.gui.dialog.DialogItem
            public void onClick() {
                Logger.logInfo("Backup: Cloud download", null);
                TrialFilter.getInstance().reevaluate();
                if (TrialFilter.getInstance().isAddonImport()) {
                    BackupItemDialogFragment.INSTANCE.startDownloadFromCloud(this.$context);
                } else {
                    ViewIntent.market(this.$context, "com.urbandroid.sleep.addon.port");
                }
            }
        };
        dialogItem3.setSubtitle(getString(R.string.settings_category_backup));
        items4.add(dialogItem3);
        if (ContextExtKt.getSettings(context).isGoogleFit()) {
            List<DialogItem> items5 = getItems();
            DialogItem dialogItem4 = new DialogItem(context, this, context.getString(R.string.menu_download_from_service, context.getString(R.string.google_fit))) { // from class: com.urbandroid.sleep.gui.dialog.BackupItemDialogFragment.createItems.9
                final /* synthetic */ Activity $context;
                final /* synthetic */ BackupItemDialogFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(str, R.drawable.ic_service_fit);
                    str.getClass();
                }

                @Override // com.urbandroid.sleep.gui.dialog.DialogItem
                public void onClick() {
                    Logger.logInfo("Backup: Google Fit download", null);
                    TrialFilter.getInstance().reevaluate();
                    if (TrialFilter.getInstance().isTrial() && TrialFilter.getInstance().getVersion() != TrialFilter.Version.FULL && !TrialFilter.getInstance().isAddonImport()) {
                        this.this$0.showPurchaseToast();
                    } else {
                        HeathImportDataService.INSTANCE.start(this.$context, HealthServiceProvider.GoogleFit.INSTANCE);
                        this.this$0.showPleaseWait();
                    }
                }
            };
            dialogItem4.setSubtitle(getString(R.string.google_fit));
            items5.add(dialogItem4);
        }
        if (ContextExtKt.getSettings(context).isHealthConnect()) {
            List<DialogItem> items6 = getItems();
            DialogItem dialogItem5 = new DialogItem(context, this, context.getString(R.string.menu_download_from_service, context.getString(R.string.health_connect))) { // from class: com.urbandroid.sleep.gui.dialog.BackupItemDialogFragment.createItems.11
                final /* synthetic */ Activity $context;
                final /* synthetic */ BackupItemDialogFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(str, R.drawable.ic_service_hc_png);
                    str.getClass();
                }

                @Override // com.urbandroid.sleep.gui.dialog.DialogItem
                public void onClick() {
                    Logger.logInfo("Backup: Heath Connect download", null);
                    TrialFilter.getInstance().reevaluate();
                    if (TrialFilter.getInstance().isTrial() && TrialFilter.getInstance().getVersion() != TrialFilter.Version.FULL && !TrialFilter.getInstance().isAddonImport()) {
                        this.this$0.showPurchaseToast();
                    } else {
                        HeathImportDataService.INSTANCE.start(this.$context, HealthServiceProvider.HealthConnect.INSTANCE);
                        this.this$0.showPleaseWait();
                    }
                }
            };
            dialogItem5.setSubtitle(getString(R.string.health_connect));
            items6.add(dialogItem5);
        }
        if (ContextExtKt.getSettings(context).isSamsungSHealth()) {
            List<DialogItem> items7 = getItems();
            DialogItem dialogItem6 = new DialogItem(context, this, context.getString(R.string.menu_download_from_service, context.getString(R.string.samsung_shealth))) { // from class: com.urbandroid.sleep.gui.dialog.BackupItemDialogFragment.createItems.13
                final /* synthetic */ Activity $context;
                final /* synthetic */ BackupItemDialogFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(str, R.drawable.ic_service_shealth);
                    str.getClass();
                }

                @Override // com.urbandroid.sleep.gui.dialog.DialogItem
                public void onClick() {
                    Logger.logInfo("Backup: Samsung Health download", null);
                    TrialFilter.getInstance().reevaluate();
                    if (TrialFilter.getInstance().isTrial() && TrialFilter.getInstance().getVersion() != TrialFilter.Version.FULL && !TrialFilter.getInstance().isAddonImport()) {
                        this.this$0.showPurchaseToast();
                    } else {
                        HeathImportDataService.INSTANCE.start(this.$context, HealthServiceProvider.SamsungSHealth.INSTANCE);
                        this.this$0.showPleaseWait();
                    }
                }
            };
            dialogItem6.setSubtitle(getString(R.string.samsung_shealth));
            items7.add(dialogItem6);
        }
        List<DialogItem> items8 = getItems();
        DialogItem dialogItem7 = new DialogItem(FileInsert$$ExternalSyntheticOutline0.m$1(context.getString(TrialFilter.getInstance().isAddonImport() ? R.string.rate : R.string.install_button), " ", getString(R.string.addons_backup_title)), TrialFilter.getInstance().isAddonImport() ? R.drawable.ic_star_outline : R.drawable.ic_puzzle) { // from class: com.urbandroid.sleep.gui.dialog.BackupItemDialogFragment.createItems.15
            @Override // com.urbandroid.sleep.gui.dialog.DialogItem
            public void onClick() {
                ViewIntent.market(context, "com.urbandroid.sleep.addon.port");
            }
        };
        if (TrialFilter.getInstance().isAddonImport()) {
            dialogItem7.setSubtitle(getString(R.string.rate_text_2));
        }
        items8.add(dialogItem7);
        List<DialogItem> items9 = getItems();
        String string = context.getString(R.string.help);
        string.getClass();
        items9.add(new ViewDialogItem(context, string, R.drawable.ic_help_q, "https://sleep.urbandroid.org/docs//services/backup_data.html"));
        return this;
    }

    @Override // com.urbandroid.sleep.gui.dialog.ItemDialogFragment
    public int getIconRes() {
        return R.drawable.preview_backup;
    }

    @Override // com.urbandroid.sleep.gui.dialog.ItemDialogFragment
    public int getSubtitleRes() {
        return R.string.backup_summary;
    }

    @Override // com.urbandroid.sleep.gui.dialog.ItemDialogFragment
    public int getTitleRes() {
        return R.string.backup;
    }

    public final void showPleaseWait() {
        Context context = getContext();
        if (context != null) {
            Toast.makeText(context, getString(R.string.please_wait) + " " + getString(R.string.please_wait_long), 1).show();
        }
    }

    public final void showPurchaseToast() {
        Context context = getContext();
        if (context != null) {
            Toast.makeText(context, R.string.unlock_text, 1).show();
            Intent intent = new Intent(getContext(), (Class<?>) AlarmClock.class);
            intent.putExtra("com.urbandroid.sleep.START_UNLOCK_CLOUD_PURCHASE", true);
            intent.addFlags(536870912);
            context.startActivity(intent);
        }
    }
}
