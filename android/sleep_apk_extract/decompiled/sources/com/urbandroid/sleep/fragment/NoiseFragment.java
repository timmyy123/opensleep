package com.urbandroid.sleep.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.FileProvider;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.Environment;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.DummyFinishActivity;
import com.urbandroid.sleep.alarmclock.settings.NoiseSettingsActivity;
import com.urbandroid.sleep.async.AbstractProgressAsyncTask;
import com.urbandroid.sleep.async.IHasProgressContext;
import com.urbandroid.sleep.domain.Noise;
import com.urbandroid.sleep.domain.tag.Tag;
import com.urbandroid.sleep.gui.IFilterListAdapter;
import com.urbandroid.sleep.gui.NoiseCommentDialogFragment;
import com.urbandroid.sleep.gui.NoiseFilter;
import com.urbandroid.sleep.gui.NoiseListCursorAdapter;
import com.urbandroid.sleep.gui.dialog.DialogUtil;
import com.urbandroid.sleep.gui.fab.ScrollAnimator;
import com.urbandroid.sleep.media.NoiseDirectory;
import com.urbandroid.sleep.media.PlayAudioActivity;
import com.urbandroid.sleep.persistence.DbSleepRecordRepository;
import com.urbandroid.sleep.service.NoiseMediaStoreJob;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class NoiseFragment extends LazyFragment implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, View.OnClickListener, View.OnLayoutChangeListener {
    private View controlBar;
    private AlertDialog deleteConfirmDialog;
    private EditText filterEdit;
    private MaterialButton floating;
    private Handler handler;
    private ListView listView;
    private View main;
    private ViewGroup noRecords;
    private NoiseFilter noiseFilter;
    private AlertDialog noiseOptionDialog;
    private ImageButton ratingBar;
    private IFilterListAdapter recordingAdapter;
    private TextView recordingHeader;
    private Button turnOnRecordingButton;
    private int firstVisibleItem = 0;
    private boolean onlyStarred = false;
    private Parcelable mListState = null;
    private ScrollAnimator scrollAnimator = null;

    public enum DeleteMode {
        SINGLE,
        ALL,
        OLD,
        ALL_NO_TAGS
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteItem(final Noise noise, final DeleteMode deleteMode) {
        Logger.logDebug("Delete noise: " + noise + " mode " + deleteMode);
        if (getActivity() == null) {
            return;
        }
        final String uriFix = noise != null ? noise.getUriFix(getActivity()) : null;
        new AbstractProgressAsyncTask<Void, Void, Void>(((IHasProgressContext) getActivity()).getProgressContextInstance(), getActivity()) { // from class: com.urbandroid.sleep.fragment.NoiseFragment.7
            @Override // com.urbandroid.sleep.async.AbstractProgressAsyncTask
            public String getMessage() {
                return getContext().getString(R.string.in_progress);
            }

            @Override // com.urbandroid.sleep.async.AbstractProgressAsyncTask, android.os.AsyncTask
            public void onPostExecute(Void r1) {
                super.onPostExecute(r1);
                NoiseFragment.this.recordingAdapter.notifyChanged();
            }

            @Override // com.urbandroid.sleep.async.AbstractProgressAsyncTask
            public Void performInBackground() {
                Date date;
                boolean zExists;
                boolean zExists2;
                boolean z = false;
                if (deleteMode == DeleteMode.SINGLE) {
                    String str = uriFix;
                    if (str != null) {
                        if (NoiseDirectory.isContentUri(str)) {
                            zExists2 = NoiseFragment.this.deleteViaContentUri(getContext(), str);
                        } else {
                            new File(str).delete();
                            zExists2 = new File(str).exists();
                        }
                        z = zExists2;
                        if (noise.isSync()) {
                            zza$$ExternalSyntheticOutline0.m("NoiseFragment: deleted from MediaStore ", NoiseMediaStoreJob.deleteNoiseFromMediaStore(getContext(), noise));
                        }
                    }
                    if (!z) {
                        SharedApplicationContext.getInstance().getSleepRecordRepository().deleteNoise(noise);
                    }
                } else {
                    Date date2 = new Date();
                    if (deleteMode == DeleteMode.OLD) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.add(6, -7);
                        date2 = calendar.getTime();
                    }
                    if (NoiseFragment.this.noiseFilter.getFrom() <= 0 || NoiseFragment.this.noiseFilter.getTo() <= 0) {
                        date = null;
                    } else {
                        date = new Date(NoiseFragment.this.noiseFilter.getFrom());
                        date2 = new Date(Math.min(NoiseFragment.this.noiseFilter.getTo(), date2.getTime()));
                    }
                    for (Noise noise2 : SharedApplicationContext.getInstance().getSleepRecordRepository().getNoisesForDeletion(date, date2)) {
                        Logger.logDebug("Delete noise? " + noise2.toString());
                        if (deleteMode != DeleteMode.ALL_NO_TAGS || Tag.getTags(noise2.getComment()).size() <= 0) {
                            String uri = noise2.getUri();
                            if (uri == null) {
                                zExists = false;
                            } else if (NoiseDirectory.isContentUri(uri)) {
                                zExists = NoiseFragment.this.deleteViaContentUri(getContext(), uri);
                            } else {
                                Logger.logDebug("Delete noise: deleted " + new File(uri).delete());
                                zExists = new File(uri).exists();
                                Logger.logDebug("Delete noise: exists " + zExists);
                            }
                            if (!zExists) {
                                Logger.logDebug("Delete noise: Recordings delete from repo");
                                SharedApplicationContext.getInstance().getSleepRecordRepository().deleteNoise(noise2);
                            }
                        } else {
                            Logger.logDebug("Delete noise: Ignoring record with tags: " + noise2.getComment());
                        }
                    }
                }
                return null;
            }
        }.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean deleteViaContentUri(Context context, String str) {
        if (!Environment.isLollipopOrGreater()) {
            return true;
        }
        NoiseDirectory noiseDirectory = new NoiseDirectory(context);
        if (!noiseDirectory.exists(str)) {
            Logger.logDebug("Saf Recordings not found already deleted");
            return false;
        }
        NoiseDirectory.State stateDelete = noiseDirectory.delete(str);
        Logger.logDebug("Saf Recordings deleted: " + stateDelete);
        return stateDelete == NoiseDirectory.State.NOT_DELETED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onLayoutChange$0() {
        Parcelable parcelable;
        ListView listView = this.listView;
        if (listView != null && (parcelable = this.mListState) != null) {
            try {
                listView.onRestoreInstanceState(parcelable);
            } catch (Exception unused) {
            }
        }
        this.mListState = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$populateBaseView$1(View view) {
        startActivity(new Intent(getContext(), (Class<?>) NoiseSettingsActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$populateBaseView$2(View view) {
        startActivity(new Intent(getContext(), (Class<?>) NoiseSettingsActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$populateBaseView$3(View view) {
        showHideTabDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$populateBaseView$4(View view) {
        boolean z = !this.onlyStarred;
        this.onlyStarred = z;
        setStarred(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showHideTabDialog$5(DialogInterface dialogInterface, int i) {
        SharedApplicationContext.getSettings().setTabNoise(false);
        startActivity(new Intent(getActivity(), (Class<?>) DummyFinishActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showHideTabDialog$6(DialogInterface dialogInterface, int i) {
    }

    private void setStarred(boolean z) {
        this.ratingBar.setImageResource(z ? R.drawable.ic_star_color_24 : R.drawable.ic_star_outline);
        this.noiseFilter.setStarred(z);
        this.recordingAdapter.notifyChanged();
    }

    private void showHideTabDialog() {
        if (SharedApplicationContext.getSettings().isTabNoise()) {
            MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(getActivity());
            materialAlertDialogBuilder.setMessage((CharSequence) getString(R.string.tab_show_title, getString(R.string.noise)));
            materialAlertDialogBuilder.setCancelable(true);
            materialAlertDialogBuilder.setPositiveButton(R.string.hide, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.fragment.NoiseFragment$$ExternalSyntheticLambda5
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$showHideTabDialog$5(dialogInterface, i);
                }
            });
            materialAlertDialogBuilder.setNegativeButton(R.string.show, (DialogInterface.OnClickListener) new NoiseFragment$$ExternalSyntheticLambda6(0));
            DialogUtil.fixDivider(materialAlertDialogBuilder.show());
        }
    }

    private void showItemOptionsDialog(View view, int i) {
        String[] strArr = {getResources().getString(R.string.play_all_recording), getResources().getString(R.string.play_recording), getResources().getString(R.string.play_recording_external), getResources().getString(R.string.star_recording), getResources().getString(R.string.rating_comment_label), getResources().getString(R.string.share_android), getResources().getString(R.string.delete), getResources().getString(R.string.delete_all_recordings)};
        final Noise noise = (Noise) view.getTag();
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(getActivity());
        materialAlertDialogBuilder.setItems((CharSequence[]) strArr, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.fragment.NoiseFragment.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (i2 == 0) {
                    NoiseFragment.playAll(NoiseFragment.this.getActivity(), SharedApplicationContext.getInstance().getSleepRecordRepository().getNoises(300, NoiseFragment.this.noiseFilter));
                    return;
                }
                if (i2 == 1) {
                    NoiseFilter noiseFilter = new NoiseFilter(NoiseFragment.this.noiseFilter);
                    noiseFilter.setFrom(noise.getFrom().getTime());
                    NoiseFragment.playAll(NoiseFragment.this.getActivity(), SharedApplicationContext.getInstance().getSleepRecordRepository().getNoises(300, noiseFilter));
                    return;
                }
                if (i2 == 2) {
                    try {
                        if (noise != null) {
                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.setDataAndType(Uri.parse("file:/" + noise.getUriFix(NoiseFragment.this.getActivity())), "audio/*");
                            NoiseFragment.this.startActivity(intent);
                            return;
                        }
                        return;
                    } catch (Exception e) {
                        Logger.logSevere(e);
                        Toast.makeText(NoiseFragment.this.getActivity(), R.string.player_error, 0);
                        return;
                    }
                }
                if (i2 == 3) {
                    Noise noise2 = noise;
                    if (noise2 != null) {
                        noise2.setStarred(!noise2.isStarred());
                        SharedApplicationContext.getInstance().getSleepRecordRepository().updateNoise(noise);
                        NoiseFragment.this.recordingAdapter.notifyChanged();
                        if (noise.isStarred() && SharedApplicationContext.getSettings().isMediaStoreAlbum()) {
                            NoiseMediaStoreJob.start(NoiseFragment.this.getContext(), noise.getId().longValue());
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (i2 == 4) {
                    NoiseCommentDialogFragment noiseCommentDialogFragmentNewInstance = NoiseCommentDialogFragment.newInstance(noise.getId().longValue());
                    noiseCommentDialogFragmentNewInstance.setCallback(new NoiseCommentDialogFragment.ICallback() { // from class: com.urbandroid.sleep.fragment.NoiseFragment.3.1
                        @Override // com.urbandroid.sleep.gui.NoiseCommentDialogFragment.ICallback
                        public void after() {
                            NoiseFragment.this.recordingAdapter.notifyChanged();
                        }
                    });
                    noiseCommentDialogFragmentNewInstance.show(NoiseFragment.this.getActivity().getSupportFragmentManager(), "noise-comment");
                    return;
                }
                if (i2 == 5 && NoiseFragment.this.getActivity() != null) {
                    Intent intent2 = new Intent("android.intent.action.SEND");
                    intent2.setType("audio/*");
                    if (new Settings(NoiseFragment.this.getContext()).hasNoiseDirUri()) {
                        intent2.addFlags(1);
                        intent2.putExtra("android.intent.extra.STREAM", Uri.parse(noise.getUri()));
                    } else {
                        intent2.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(NoiseFragment.this.getActivity(), "com.urbandroid.sleep.fileprovider", new File(noise.getUriFix(NoiseFragment.this.getActivity()))));
                    }
                    NoiseFragment.this.getActivity().startActivity(Intent.createChooser(intent2, NoiseFragment.this.getActivity().getResources().getString(R.string.share_android)));
                    return;
                }
                if (i2 == 6) {
                    NoiseFragment.this.deleteItemConfirmCheck(noise, DeleteMode.SINGLE);
                } else if (i2 == 7) {
                    NoiseFragment.this.deleteItemConfirmCheck(noise, DeleteMode.ALL);
                } else if (i2 == 8) {
                    NoiseFragment.this.deleteItemConfirmCheck(noise, DeleteMode.OLD);
                }
            }
        });
        materialAlertDialogBuilder.setPositiveButton(R.string.button_cancel, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.fragment.NoiseFragment.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AlertDialog alertDialogCreate = materialAlertDialogBuilder.create();
        this.noiseOptionDialog = alertDialogCreate;
        alertDialogCreate.setTitle(getResources().getString(R.string.sleep_recording_title));
        this.noiseOptionDialog.show();
        DialogUtil.fixDivider(this.noiseOptionDialog);
    }

    private void updateHeader() {
        TextView textView = this.recordingHeader;
        if (textView != null) {
            textView.setText(getString(R.string.no_recordings));
        }
    }

    private void updateRecordingExpl() {
        if (this.turnOnRecordingButton != null) {
            boolean zIsRecordingMasterSwitchEnabled = SharedApplicationContext.getSettings().isRecordingMasterSwitchEnabled();
            Button button = this.turnOnRecordingButton;
            if (zIsRecordingMasterSwitchEnabled) {
                button.setText(getString(R.string.settings));
            } else {
                button.setText(getString(R.string.turn_on));
            }
        }
    }

    @Override // com.urbandroid.sleep.fragment.ILazyFragment
    public View createBaseView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_noise, viewGroup, false);
    }

    public void deleteItemConfirmCheck(final Noise noise, DeleteMode deleteMode) {
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), R.layout.select_dialog_item);
        arrayAdapter.add(getString(R.string.delete_all));
        arrayAdapter.add(getString(R.string.delete) + " (" + getString(R.string.not_tagged) + ")");
        StringBuilder sb = new StringBuilder();
        sb.append(getString(R.string.menu_delete_old));
        sb.append(" ");
        sb.append(getString(R.string.days, "7"));
        arrayAdapter.add(sb.toString());
        MaterialAlertDialogBuilder icon = new MaterialAlertDialogBuilder(getActivity()).setIcon(R.drawable.ic_alert);
        DeleteMode deleteMode2 = DeleteMode.SINGLE;
        MaterialAlertDialogBuilder negativeButton = icon.setTitle(deleteMode == deleteMode2 ? R.string.realy_delete_confirm_generic : R.string.delete_all_recordings).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null);
        if (deleteMode != deleteMode2) {
            negativeButton.setAdapter((ListAdapter) arrayAdapter, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.fragment.NoiseFragment.5
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (i == 0) {
                        NoiseFragment.this.deleteItem(noise, DeleteMode.ALL);
                    } else if (i == 1) {
                        NoiseFragment.this.deleteItem(noise, DeleteMode.ALL_NO_TAGS);
                    } else {
                        if (i != 2) {
                            return;
                        }
                        NoiseFragment.this.deleteItem(noise, DeleteMode.OLD);
                    }
                }
            });
        } else {
            negativeButton.setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.fragment.NoiseFragment.6
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    NoiseFragment.this.deleteItem(noise, DeleteMode.SINGLE);
                }
            });
        }
        AlertDialog alertDialogShow = negativeButton.show();
        this.deleteConfirmDialog = alertDialogShow;
        DialogUtil.fixDivider(alertDialogShow);
    }

    public NoiseFilter getNoiseFilter() {
        return this.noiseFilter;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.handler = new Handler();
        if (bundle != null) {
            this.mListState = bundle.getParcelable("listState");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.equals(this.filterEdit)) {
            Logger.logDebug("Filter clicked.");
            this.filterEdit.setText("");
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Noise noise = (Noise) view.getTag();
        Logger.logInfo("NoiseFragment: selected Noise " + noise);
        NoiseFilter noiseFilter = new NoiseFilter(this.noiseFilter);
        noiseFilter.setFrom(noise.getFrom().getTime());
        List<Noise> noises = SharedApplicationContext.getInstance().getSleepRecordRepository().getNoises(300, noiseFilter);
        Logger.logInfo("NoiseFragment: playing " + noises.size());
        playAll(getActivity(), noises);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        showItemOptionsDialog(view, i);
        return true;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (this.listView == null || this.mListState == null) {
            return;
        }
        this.handler.post(new GraphFragment$$ExternalSyntheticLambda0(this, 1));
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        updateHeader();
        if (isAlreadyLoaded()) {
            this.recordingAdapter.notifyChanged();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ListView listView = this.listView;
        if (listView != null) {
            Parcelable parcelableOnSaveInstanceState = listView.onSaveInstanceState();
            this.mListState = parcelableOnSaveInstanceState;
            bundle.putParcelable("listState", parcelableOnSaveInstanceState);
            bundle.putBoolean("starred", this.onlyStarred);
        }
    }

    @Override // com.urbandroid.sleep.fragment.LazyFragment
    public void onSetVisible() {
        super.onSetVisible();
        updateHeader();
        updateRecordingExpl();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (isAlreadyLoaded()) {
            this.recordingAdapter.notifyChanged();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (isAlreadyLoaded()) {
            this.recordingAdapter.pause();
        }
    }

    public void playAll(Activity activity) {
        List<Noise> noises = SharedApplicationContext.getInstance().getSleepRecordRepository().getNoises(300, new NoiseFilter(this.noiseFilter));
        Logger.logInfo("NoiseFragment: playing all " + noises.size());
        playAll(activity, noises);
    }

    @Override // com.urbandroid.sleep.fragment.ILazyFragment
    public void populateBaseView(View view, LayoutInflater layoutInflater, Bundle bundle) {
        this.main = view;
        this.noRecords = (ViewGroup) view.findViewById(R.id.no_records);
        View viewFindViewById = view.findViewById(R.id.card);
        this.turnOnRecordingButton = (Button) view.findViewById(R.id.enable);
        updateRecordingExpl();
        final int i = 0;
        if (this.turnOnRecordingButton != null) {
            viewFindViewById.setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.fragment.NoiseFragment$$ExternalSyntheticLambda1
                public final /* synthetic */ NoiseFragment f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    int i2 = i;
                    NoiseFragment noiseFragment = this.f$0;
                    switch (i2) {
                        case 0:
                            noiseFragment.lambda$populateBaseView$1(view2);
                            break;
                        case 1:
                            noiseFragment.lambda$populateBaseView$2(view2);
                            break;
                        case 2:
                            noiseFragment.lambda$populateBaseView$3(view2);
                            break;
                        default:
                            noiseFragment.lambda$populateBaseView$4(view2);
                            break;
                    }
                }
            });
            final int i2 = 1;
            this.turnOnRecordingButton.setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.fragment.NoiseFragment$$ExternalSyntheticLambda1
                public final /* synthetic */ NoiseFragment f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    int i22 = i2;
                    NoiseFragment noiseFragment = this.f$0;
                    switch (i22) {
                        case 0:
                            noiseFragment.lambda$populateBaseView$1(view2);
                            break;
                        case 1:
                            noiseFragment.lambda$populateBaseView$2(view2);
                            break;
                        case 2:
                            noiseFragment.lambda$populateBaseView$3(view2);
                            break;
                        default:
                            noiseFragment.lambda$populateBaseView$4(view2);
                            break;
                    }
                }
            });
        }
        final int i3 = 2;
        view.findViewById(R.id.hide).setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.fragment.NoiseFragment$$ExternalSyntheticLambda1
            public final /* synthetic */ NoiseFragment f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int i22 = i3;
                NoiseFragment noiseFragment = this.f$0;
                switch (i22) {
                    case 0:
                        noiseFragment.lambda$populateBaseView$1(view2);
                        break;
                    case 1:
                        noiseFragment.lambda$populateBaseView$2(view2);
                        break;
                    case 2:
                        noiseFragment.lambda$populateBaseView$3(view2);
                        break;
                    default:
                        noiseFragment.lambda$populateBaseView$4(view2);
                        break;
                }
            }
        });
        this.recordingHeader = (TextView) view.findViewById(R.id.no_records_text);
        DbSleepRecordRepository sleepRecordRepository = SharedApplicationContext.getInstance().getSleepRecordRepository();
        this.listView = (ListView) view.findViewById(R.id.recording_list);
        this.noiseFilter = new NoiseFilter("", false, getActivity().getIntent().getLongExtra("noise_from", -1L), getActivity().getIntent().getLongExtra("noise_to", -1L));
        this.recordingAdapter = new NoiseListCursorAdapter(getActivity(), sleepRecordRepository, this.noRecords, this.noiseFilter, this.listView, view);
        this.controlBar = view.findViewById(R.id.controlBar);
        this.listView.addHeaderView(new View(this.listView.getContext()));
        this.listView.setAdapter((ListAdapter) this.recordingAdapter);
        this.listView.setOnItemClickListener(this);
        this.listView.setOnItemLongClickListener(this);
        this.listView.addOnLayoutChangeListener(this);
        this.listView.setVerticalFadingEdgeEnabled(false);
        EditText editText = (EditText) view.findViewById(R.id.search_button);
        this.filterEdit = editText;
        if (editText != null) {
            editText.setOnClickListener(this);
            this.filterEdit.addTextChangedListener(new TextWatcher() { // from class: com.urbandroid.sleep.fragment.NoiseFragment.1
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
                    Logger.logDebug("Filtering record history.");
                    NoiseFragment.this.noiseFilter.setFilterString(charSequence.toString());
                    NoiseFragment.this.recordingAdapter.notifyChanged();
                }
            });
        }
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.noise_star_filter);
        this.ratingBar = imageButton;
        if (imageButton != null) {
            final int i4 = 3;
            imageButton.setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.fragment.NoiseFragment$$ExternalSyntheticLambda1
                public final /* synthetic */ NoiseFragment f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    int i22 = i4;
                    NoiseFragment noiseFragment = this.f$0;
                    switch (i22) {
                        case 0:
                            noiseFragment.lambda$populateBaseView$1(view2);
                            break;
                        case 1:
                            noiseFragment.lambda$populateBaseView$2(view2);
                            break;
                        case 2:
                            noiseFragment.lambda$populateBaseView$3(view2);
                            break;
                        default:
                            noiseFragment.lambda$populateBaseView$4(view2);
                            break;
                    }
                }
            });
        }
        if (bundle != null) {
            boolean z = bundle.getBoolean("starred", false);
            this.onlyStarred = z;
            setStarred(z);
        }
        this.recordingAdapter.notifyChanged();
        this.floating = (MaterialButton) getActivity().findViewById(R.id.fab);
        AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.show);
        AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.hide);
        final Animation animationLoadAnimation = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), android.R.anim.fade_in);
        final Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.fade_fast);
        this.listView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.urbandroid.sleep.fragment.NoiseFragment.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i5, int i6, int i7) {
                if (!NoiseFragment.this.isFramentVisible() || NoiseFragment.this.floating == null) {
                    return;
                }
                if (NoiseFragment.this.scrollAnimator == null) {
                    NoiseFragment.this.scrollAnimator = new ScrollAnimator(NoiseFragment.this.getActivity(), NoiseFragment.this.floating);
                }
                NoiseFragment.this.scrollAnimator.scroll(i5);
                if (i5 > 0 && NoiseFragment.this.controlBar.getVisibility() != 8) {
                    NoiseFragment.this.controlBar.startAnimation(animationLoadAnimation2);
                    NoiseFragment.this.controlBar.setVisibility(8);
                } else if (absListView.getVisibility() == 0 && i5 == 0 && NoiseFragment.this.controlBar != null && NoiseFragment.this.controlBar.getVisibility() == 8) {
                    NoiseFragment.this.controlBar.setVisibility(0);
                    NoiseFragment.this.controlBar.startAnimation(animationLoadAnimation);
                }
                NoiseFragment.this.firstVisibleItem = i5;
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i5) {
            }
        });
        updateHeader();
    }

    public static void playAll(Activity activity, List<Noise> list) {
        int size = list.size();
        long[] jArr = new long[size];
        for (int i = 0; i < size; i++) {
            jArr[i] = list.get(i).getId().longValue();
        }
        Intent intent = new Intent(activity, (Class<?>) PlayAudioActivity.class);
        intent.putExtra("noise_ids", jArr);
        activity.startActivityForResult(intent, 1);
    }
}
