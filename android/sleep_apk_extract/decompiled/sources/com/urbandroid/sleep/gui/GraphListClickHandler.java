package com.urbandroid.sleep.gui;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.ClipboardManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.addon.stats.model.Measure;
import com.urbandroid.sleep.alarmclock.AlarmClock;
import com.urbandroid.sleep.alarmclock.EditActivity;
import com.urbandroid.sleep.alarmclock.GraphActivity;
import com.urbandroid.sleep.alarmclock.settings.SocialSettingsActivity;
import com.urbandroid.sleep.async.ExportDataAsyncTask;
import com.urbandroid.sleep.async.ProgressContext;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.SleepRecordStringBuilder;
import com.urbandroid.sleep.domain.tag.Tag;
import com.urbandroid.sleep.domain.undo.UndoOperationGroup;
import com.urbandroid.sleep.fragment.NoiseFragment$$ExternalSyntheticLambda6;
import com.urbandroid.sleep.fragment.dashboard.detail.SleepDetailActivity;
import com.urbandroid.sleep.graph.SleepGraphImageGenerator;
import com.urbandroid.sleep.gui.dialog.DialogUtil;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import com.urbandroid.sleep.location.Location;
import com.urbandroid.sleep.location.LocationService;
import com.urbandroid.sleep.media.MediaListActivity$$ExternalSyntheticLambda1;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.share.ShareAfterDismissService;
import com.urbandroid.sleep.share.image.ShareDataUtil;
import java.io.IOException;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u001f\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0019\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0018\u001a\u00020\u0011H$¢\u0006\u0004\b\u0019\u0010\u001aJ5\u0010 \u001a\u00020\u000b2\f\u0010\u001c\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J5\u0010&\u001a\u00020%2\f\u0010\"\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u001eH\u0016¢\u0006\u0004\b&\u0010'J\u001f\u0010(\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\tH\u0004¢\u0006\u0004\b(\u0010)R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010*R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010+R\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.¨\u0006/"}, d2 = {"Lcom/urbandroid/sleep/gui/GraphListClickHandler;", "Landroid/widget/AdapterView$OnItemClickListener;", "Landroid/widget/AdapterView$OnItemLongClickListener;", "Landroid/app/Activity;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/urbandroid/sleep/gui/IFilterListAdapter;", "listAdapter", "<init>", "(Landroid/app/Activity;Lcom/urbandroid/sleep/gui/IFilterListAdapter;)V", "Lcom/urbandroid/sleep/domain/SleepRecord;", "record", "", "showEditDialog", "(Lcom/urbandroid/sleep/domain/SleepRecord;)V", "editItem", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "", "itemIndex", "showItemOptionsDialog", "(Landroid/view/View;I)V", "sleepRecord", "showDetail", "(Lcom/urbandroid/sleep/domain/SleepRecord;Landroid/view/View;)V", "index", "getRecordFromItem", "(Landroid/view/View;I)Lcom/urbandroid/sleep/domain/SleepRecord;", "Landroid/widget/AdapterView;", "parent", "position", "", "id", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "adapterView", "i", "l", "", "onItemLongClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)Z", "deleteItem", "(ILcom/urbandroid/sleep/domain/SleepRecord;)V", "Landroid/app/Activity;", "Lcom/urbandroid/sleep/gui/IFilterListAdapter;", "Landroidx/appcompat/app/AlertDialog;", "contextDialog", "Landroidx/appcompat/app/AlertDialog;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class GraphListClickHandler implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    private final Activity context;
    private AlertDialog contextDialog;
    private final IFilterListAdapter listAdapter;

    public GraphListClickHandler(Activity activity, IFilterListAdapter iFilterListAdapter) {
        activity.getClass();
        iFilterListAdapter.getClass();
        this.context = activity;
        this.listAdapter = iFilterListAdapter;
    }

    private final void editItem(SleepRecord record) {
        showEditDialog(record);
    }

    private final void showDetail(SleepRecord sleepRecord, View view) {
        if (sleepRecord != null) {
            SleepDetailActivity.Companion.start$default(SleepDetailActivity.INSTANCE, this.context, sleepRecord, false, 4, null);
        }
    }

    private final void showEditDialog(SleepRecord record) {
        EditActivity.showRatingForResult(this.context, record);
    }

    private final void showItemOptionsDialog(final View view, final int itemIndex) {
        final SleepRecord recordFromItem = getRecordFromItem(view, itemIndex);
        if (recordFromItem == null) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        String string = this.context.getResources().getString(R.string.delete);
        string.getClass();
        linkedList.add(string);
        String string2 = this.context.getResources().getString(R.string.menu_delete_old);
        string2.getClass();
        linkedList.add(string2);
        if (recordFromItem.getGeo() != null) {
            String string3 = this.context.getResources().getString(R.string.show_map);
            string3.getClass();
            linkedList.add(string3);
            String string4 = this.context.getResources().getString(R.string.delete_location);
            string4.getClass();
            linkedList.add(string4);
        }
        String string5 = this.context.getResources().getString(R.string.rating_comment_label);
        string5.getClass();
        linkedList.add(string5);
        linkedList.add(this.context.getResources().getString(R.string.share_facebook) + " (" + SharedApplicationContext.getInstance().getShareService().getName(this.context) + ")");
        if (TrialFilter.getInstance().getVersion() != TrialFilter.Version.SAMSUNG) {
            String string6 = this.context.getResources().getString(R.string.share_android);
            string6.getClass();
            linkedList.add(string6);
        }
        String string7 = this.context.getResources().getString(R.string.show_details);
        string7.getClass();
        linkedList.add(string7);
        String string8 = this.context.getResources().getString(R.string.rename_tags);
        string8.getClass();
        linkedList.add(string8);
        String string9 = this.context.getResources().getString(R.string.copy_record);
        string9.getClass();
        linkedList.add(string9);
        UndoOperationGroup currentUndoOperation = SharedApplicationContext.getInstance().getSleepRecordRepository().getCurrentUndoOperation();
        if (currentUndoOperation != null) {
            linkedList.add(this.context.getString(R.string.undo) + " (" + currentUndoOperation.getName() + ")");
        }
        final String[] strArr = (String[]) linkedList.toArray(new String[0]);
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(this.context);
        materialAlertDialogBuilder.setItems((CharSequence[]) strArr, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.gui.GraphListClickHandler$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                GraphListClickHandler.showItemOptionsDialog$lambda$0(this.f$0, strArr, recordFromItem, itemIndex, view, dialogInterface, i);
            }
        });
        materialAlertDialogBuilder.setPositiveButton(R.string.button_cancel, (DialogInterface.OnClickListener) new NoiseFragment$$ExternalSyntheticLambda6(7));
        AlertDialog alertDialogCreate = materialAlertDialogBuilder.create();
        alertDialogCreate.setTitle(alertDialogCreate.getContext().getResources().getString(R.string.graphs));
        alertDialogCreate.show();
        this.contextDialog = alertDialogCreate;
        DialogUtil.fixDivider(alertDialogCreate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showItemOptionsDialog$lambda$0(GraphListClickHandler graphListClickHandler, String[] strArr, SleepRecord sleepRecord, int i, View view, DialogInterface dialogInterface, int i2) {
        if (Intrinsics.areEqual(graphListClickHandler.context.getString(R.string.show_map), strArr[i2])) {
            Location locationComputeLocation = LocationService.computeLocation(sleepRecord.getGeo());
            zza$$ExternalSyntheticOutline0.m("GEO ", sleepRecord.getGeo());
            if (locationComputeLocation != null) {
                try {
                    graphListClickHandler.context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationComputeLocation.getLat() + "," + locationComputeLocation.getLon() + "?q=" + locationComputeLocation.getLat() + "," + locationComputeLocation.getLon() + "(" + graphListClickHandler.context.getString(R.string.app_name) + MqttTopic.SINGLE_LEVEL_WILDCARD + new SleepRecordStringBuilder(graphListClickHandler.context).build(sleepRecord) + ")")));
                    return;
                } catch (ActivityNotFoundException unused) {
                    Toast.makeText(graphListClickHandler.context, R.string.message_missing_feature, 0).show();
                    return;
                }
            }
            return;
        }
        if (Intrinsics.areEqual(graphListClickHandler.context.getString(R.string.delete), strArr[i2])) {
            graphListClickHandler.deleteItem(i, sleepRecord);
            Activity activity = graphListClickHandler.context;
            if (activity instanceof AlarmClock) {
                ((AlarmClock) activity).updateOnGraphsChange();
                return;
            } else {
                if (activity instanceof GraphActivity) {
                    graphListClickHandler.listAdapter.notifyChanged();
                    return;
                }
                return;
            }
        }
        boolean zAreEqual = Intrinsics.areEqual(graphListClickHandler.context.getString(R.string.menu_delete_old), strArr[i2]);
        Activity activity2 = graphListClickHandler.context;
        Intent intentCreateIntent = null;
        if (zAreEqual) {
            AlarmClock alarmClock = activity2 instanceof AlarmClock ? (AlarmClock) activity2 : null;
            if (alarmClock != null) {
                alarmClock.showDialog(50);
                return;
            } else {
                new MaterialAlertDialogBuilder(graphListClickHandler.context).setTitle(R.string.menu_delete_old).setItems((CharSequence[]) graphListClickHandler.context.getResources().getStringArray(R.array.delete_older_than_entries), (DialogInterface.OnClickListener) new GraphListClickHandler$$ExternalSyntheticLambda2(graphListClickHandler, activity2, 0)).show();
                return;
            }
        }
        if (Intrinsics.areEqual(activity2.getString(R.string.rating_comment_label), strArr[i2])) {
            graphListClickHandler.editItem(sleepRecord);
            return;
        }
        String str = strArr[i2];
        String string = graphListClickHandler.context.getString(R.string.share_facebook);
        string.getClass();
        if (StringsKt.startsWith$default(str, string)) {
            if (SharedApplicationContext.getInstance().getShareService().isConnected(graphListClickHandler.context)) {
                ShareAfterDismissService.shareExplicit(graphListClickHandler.context, sleepRecord);
                return;
            }
            Intent intent = new Intent(graphListClickHandler.context, (Class<?>) SocialSettingsActivity.class);
            intent.setFlags(ClientDefaults.MAX_MSG_SIZE);
            graphListClickHandler.context.startActivity(intent);
            return;
        }
        if (Intrinsics.areEqual(graphListClickHandler.context.getString(R.string.share_android), strArr[i2])) {
            try {
                String str2 = "graph_" + DateUtil.getDatetimestamp(sleepRecord.getFrom()) + ".png";
                Activity activity3 = graphListClickHandler.context;
                intentCreateIntent = ShareDataUtil.createIntent(activity3, str2, new SleepRecordStringBuilder(activity3).setAppendMeasures(true, Measure.ALL_MEASURES).setPrependSleep(true).setAppendAppName(true).build(sleepRecord));
                ShareDataUtil.saveData(graphListClickHandler.context, str2, SleepGraphImageGenerator.generateSleepGraph((Context) graphListClickHandler.context, sleepRecord, true));
            } catch (IOException unused2) {
                Toast.makeText(graphListClickHandler.context, R.string.save_to_card_failed, 0).show();
            }
            Activity activity4 = graphListClickHandler.context;
            activity4.startActivity(Intent.createChooser(intentCreateIntent, activity4.getResources().getString(R.string.share_android)));
            return;
        }
        if (Intrinsics.areEqual(graphListClickHandler.context.getString(R.string.copy_record), strArr[i2])) {
            String strSerialize = sleepRecord.serialize();
            Object systemService = graphListClickHandler.context.getSystemService("clipboard");
            systemService.getClass();
            ((ClipboardManager) systemService).setText(strSerialize);
            return;
        }
        if (Intrinsics.areEqual(graphListClickHandler.context.getString(R.string.delete_location), strArr[i2])) {
            SleepRecord sleepRecord2 = new SleepRecord(sleepRecord, false);
            sleepRecord2.setGeo(null);
            UndoOperationGroup undoOperationGroup = new UndoOperationGroup(graphListClickHandler.context.getString(R.string.delete_location), sleepRecord);
            SharedApplicationContext.getInstance().recordDataUpdated(sleepRecord, sleepRecord2, undoOperationGroup);
            SharedApplicationContext.getInstance().getSleepRecordRepository().addUndoOperation(undoOperationGroup);
            Activity activity5 = graphListClickHandler.context;
            if (activity5 instanceof AlarmClock) {
                ((AlarmClock) activity5).showUndoToastIfNeeded();
            }
            graphListClickHandler.listAdapter.notifyChanged();
            return;
        }
        if (Intrinsics.areEqual(graphListClickHandler.context.getString(R.string.show_details), strArr[i2])) {
            graphListClickHandler.showDetail(sleepRecord, view);
            return;
        }
        if (!Intrinsics.areEqual(graphListClickHandler.context.getString(R.string.rename_tags), strArr[i2])) {
            String str3 = strArr[i2];
            String string2 = graphListClickHandler.context.getString(R.string.undo);
            string2.getClass();
            if (StringsKt.startsWith$default(str3, string2)) {
                SharedApplicationContext.getInstance().getSleepRecordRepository().performUndo();
                Activity activity6 = graphListClickHandler.context;
                if (activity6 instanceof AlarmClock) {
                    ((AlarmClock) activity6).updateOnGraphsChange();
                    return;
                }
                return;
            }
            return;
        }
        View viewInflate = InflatorUtil.INSTANCE.get(graphListClickHandler.context).inflate(R.layout.dialog_replace_tag, (ViewGroup) null);
        EditText editText = (EditText) viewInflate.findViewById(R.id.from);
        EditText editText2 = (EditText) viewInflate.findViewById(R.id.to);
        editText2.setHint(graphListClickHandler.context.getString(R.string.add_record_to) + " (" + graphListClickHandler.context.getString(R.string.rename_tags_keep_empty_delete) + ")");
        AlertDialog alertDialogCreate = new MaterialAlertDialogBuilder(graphListClickHandler.context).setView(viewInflate).setTitle(R.string.rename_tags).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.button_ok, (DialogInterface.OnClickListener) new MediaListActivity$$ExternalSyntheticLambda1(editText, editText2, graphListClickHandler, 4)).create();
        alertDialogCreate.getClass();
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showItemOptionsDialog$lambda$0$0(GraphListClickHandler graphListClickHandler, final Activity activity, DialogInterface dialogInterface, int i) {
        final int i2 = Integer.parseInt(graphListClickHandler.context.getResources().getStringArray(R.array.delete_older_than_values)[i]);
        if (i2 >= 0) {
            final ProgressContext progressContext = new ProgressContext(graphListClickHandler.context);
            final Activity activity2 = graphListClickHandler.context;
            new ExportDataAsyncTask(progressContext, activity2) { // from class: com.urbandroid.sleep.gui.GraphListClickHandler$showItemOptionsDialog$1$1$1
                @Override // com.urbandroid.sleep.async.ExportDataAsyncTask, com.urbandroid.sleep.async.AbstractProgressAsyncTask
                public String getSuccessString() {
                    return null;
                }

                @Override // com.urbandroid.sleep.async.ExportDataAsyncTask, com.urbandroid.sleep.async.AbstractProgressAsyncTask, android.os.AsyncTask
                public void onPostExecute(Void aVoid) {
                    super.onPostExecute(aVoid);
                    zza$$ExternalSyntheticOutline0.m(i2, "AlarmClock: Deleting records older than: ");
                    try {
                        Activity activity3 = activity;
                        if (activity3 instanceof GraphActivity) {
                            ((GraphActivity) activity3).showUndoAfterDeleteAll();
                        }
                        activity.recreate();
                    } catch (Exception e) {
                        Logger.logSevere(e);
                    }
                }

                @Override // com.urbandroid.sleep.async.ExportDataAsyncTask, com.urbandroid.sleep.async.AbstractProgressAsyncTask
                public Void performInBackground() {
                    super.performInBackground();
                    SharedApplicationContext.getInstance().getSleepRecordRepository().deleteOld(i2);
                    return null;
                }
            }.execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showItemOptionsDialog$lambda$0$1(EditText editText, EditText editText2, GraphListClickHandler graphListClickHandler, DialogInterface dialogInterface, int i) {
        String string;
        String string2 = StringsKt.trim(StringsKt__StringsKt.substringAfter$default(editText.getText().toString(), "#", (String) null, 2, (Object) null)).toString();
        String string3 = StringsKt.trim(StringsKt__StringsKt.substringAfter$default(editText2.getText().toString(), "#", (String) null, 2, (Object) null)).toString();
        if (string2.length() == 0 || !Tag.isValidTag(string2)) {
            new MaterialAlertDialogBuilder(graphListClickHandler.context).setMessage((CharSequence) (graphListClickHandler.context.getString(R.string.generic_invalid_input) + " '#" + string2 + "'!")).setPositiveButton(R.string.button_ok, (DialogInterface.OnClickListener) null).show();
            return;
        }
        if (string3.length() > 0 && !Tag.isValidTag(string3)) {
            new MaterialAlertDialogBuilder(graphListClickHandler.context).setMessage((CharSequence) (graphListClickHandler.context.getString(R.string.generic_invalid_input) + " '#" + string3 + "'!")).setPositiveButton(R.string.button_ok, (DialogInterface.OnClickListener) null).show();
            return;
        }
        Logger.logInfo("Renaming tags " + string2 + " -> " + string3);
        MaterialAlertDialogBuilder title = new MaterialAlertDialogBuilder(graphListClickHandler.context).setTitle(R.string.are_you_sure);
        int length = string3.length();
        Activity activity = graphListClickHandler.context;
        if (length == 0) {
            string = FileInsert$$ExternalSyntheticOutline0.m(activity.getString(R.string.delete_all), " '#", string2, "'?");
        } else {
            StringBuilder sbM66m = Fragment$$ExternalSyntheticOutline1.m66m(activity.getString(R.string.rename_tags), " '#", string2, "' → '#", string3);
            sbM66m.append("'?");
            string = sbM66m.toString();
        }
        title.setMessage((CharSequence) string).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null).setPositiveButton(R.string.button_ok, (DialogInterface.OnClickListener) new MediaListActivity$$ExternalSyntheticLambda1(graphListClickHandler, string2, string3, 5)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showItemOptionsDialog$lambda$0$1$0(GraphListClickHandler graphListClickHandler, String str, String str2, DialogInterface dialogInterface, int i) {
        ProgressDialog progressDialog = new ProgressDialog(graphListClickHandler.context);
        progressDialog.setTitle(R.string.please_wait);
        progressDialog.show();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new GraphListClickHandler$showItemOptionsDialog$1$dialog$1$1$1(str, str2, null), 3, null);
        progressDialog.hide();
        graphListClickHandler.context.recreate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showItemOptionsDialog$lambda$1(DialogInterface dialogInterface, int i) {
    }

    public final void deleteItem(int itemIndex, SleepRecord record) {
        record.getClass();
        Logger.logDebug("Deleting item from GLA: " + itemIndex + " Record start: " + record.getFrom());
        UndoOperationGroup undoOperationGroup = new UndoOperationGroup(this.context.getString(R.string.deleted), new SleepRecord(record, false));
        SharedApplicationContext.getInstance().deleteRecord(record, undoOperationGroup);
        new Settings(this.context).decRecordsCount();
        SharedApplicationContext.getInstance().getSleepRecordRepository().addUndoOperation(undoOperationGroup);
        Activity activity = this.context;
        if (activity instanceof AlarmClock) {
            ((AlarmClock) activity).showUndoToastIfNeeded();
        } else if (activity instanceof GraphActivity) {
            ((GraphActivity) activity).showUndoToastIfNeeded();
        }
        this.listAdapter.notifyChanged();
    }

    public abstract SleepRecord getRecordFromItem(View view, int index);

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        view.getClass();
        showDetail(getRecordFromItem(view, position), view);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        view.getClass();
        showItemOptionsDialog(view, i);
        return true;
    }
}
