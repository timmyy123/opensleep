package com.urbandroid.sleep.media.lullaby;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.ColorUtil;
import com.urbandroid.common.util.Environment;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.SleepService;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.alarmclock.AlarmClock;
import com.urbandroid.sleep.alarmclock.settings.ILullabySelect;
import com.urbandroid.sleep.domain.CurrentSleepRecord;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.tag.Tag;
import com.urbandroid.sleep.gui.dialog.DialogUtil;
import com.urbandroid.sleep.gui.dialog.MaterialProgressDialog;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import com.urbandroid.sleep.media.MediaListActivity$$ExternalSyntheticLambda1;
import com.urbandroid.sleep.media.OnlineRadioRingtones;
import com.urbandroid.sleep.media.lullaby.LullabyPlayer;
import com.urbandroid.sleep.media.mode.RingerModeUtil;
import com.urbandroid.sleep.media.spotify.ISpotifyPlayer;
import com.urbandroid.sleep.media.spotify.SpotifyServiceExecutor;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.FixButtonColorOnShowDialogListener;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LullabyDialogFragment extends DialogFragment {
    private LayoutInflater vi;
    private boolean select = false;
    private boolean radios = false;
    private boolean dark = false;
    private boolean preview = false;

    public static class RadioItem extends Item {
        public RadioItem(String str, String str2) {
            super(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateDialog$0(List list, Context context, DialogInterface dialogInterface, int i) {
        String str;
        Item item = (Item) list.get(i);
        if (item instanceof RadioItem) {
            startPlayingLullaby(getActivity(), item);
            tagLullaby(CurrentSleepRecord.getInstance().getRecord());
        } else if (item != null && (str = item.f70data) != null) {
            LullabyPlayer.Lullaby lullabyValueOf = LullabyPlayer.Lullaby.valueOf(str);
            Logger.logInfo("Lullaby " + lullabyValueOf + " data " + item.f70data + " item " + i);
            boolean zIsTrial = lullabyValueOf.isTrial();
            if (!lullabyValueOf.isLocalPackage() && !TrialFilter.getInstance().isAddonLullaby() && !TrialFilter.getInstance().isAddonLullabyFree()) {
                ViewIntent.market(getActivity(), TrialFilter.getInstance().isTrial() ? "com.urbandroid.sleep.addon.lullaby" : "com.urbandroid.sleep.lullaby");
            } else if (TrialFilter.getInstance().isTrial() && !zIsTrial && !TrialFilter.getInstance().isAddonLullaby()) {
                AlarmClock.startPurchaseFlow(context);
            } else if (this.select) {
                ((ILullabySelect) getActivity()).onLullabySelected(getActivity(), lullabyValueOf, item.title);
            } else {
                tagLullaby(CurrentSleepRecord.getInstance().getRecord());
                startPlayingLullaby(getActivity(), item);
            }
        }
        if (!this.preview) {
            Logger.logInfo("Lullaby cancel ");
            dialogInterface.cancel();
            return;
        }
        BaseActivity baseActivity = (BaseActivity) getActivity();
        if (baseActivity != null) {
            LullabyDialogFragment lullabyDialogFragment = new LullabyDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("preview", true);
            bundle.putBoolean("select", this.select);
            bundle.putBoolean("radios", this.radios);
            bundle.putBoolean("dark", this.dark);
            lullabyDialogFragment.setArguments(bundle);
            lullabyDialogFragment.show(baseActivity.getSupportFragmentManager(), "lullaby");
            Logger.logInfo("Lullaby no cancel in preview");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$startPlayingLullaby$1(Context context, BroadcastReceiver broadcastReceiver, DialogInterface dialogInterface) {
        try {
            context.unregisterReceiver(broadcastReceiver);
        } catch (Exception e) {
            Logger.logSevere(e);
        }
    }

    public static void startPlayingLullaby(final Context context, Item item, final ProgressBar progressBar) {
        final AlertDialog alertDialogBuild;
        if (RingerModeUtil.isModeSilent(context.getApplicationContext()) && !RingerModeUtil.isStreamInSilent(context.getApplicationContext(), 3)) {
            RingerModeUtil.setStreamInSilent(context.getApplicationContext(), true, 3);
        }
        if (Environment.isLollipopOrGreater()) {
            IntentFilter intentFilter = new IntentFilter("com.urbandroid.sleep.ACTION_LULLABY_START_PLAYBACK");
            intentFilter.addAction("com.urbandroid.sleep.ACTION_LULLABY_STOPPED_PLAYBACK");
            try {
                alertDialogBuild = MaterialProgressDialog.INSTANCE.build(context, context.getString(R.string.lullaby), context.getString(R.string.stats_caption_loading));
            } catch (Exception e) {
                Logger.logSevere(e);
                alertDialogBuild = null;
            }
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
            final BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.urbandroid.sleep.media.lullaby.LullabyDialogFragment.6
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context2, Intent intent) {
                    ProgressBar progressBar2 = progressBar;
                    if (progressBar2 != null) {
                        progressBar2.setVisibility(8);
                    }
                    AlertDialog alertDialog = alertDialogBuild;
                    if (alertDialog == null || !alertDialog.isShowing()) {
                        return;
                    }
                    try {
                        alertDialogBuild.dismiss();
                    } catch (Exception e2) {
                        Logger.logSevere(e2);
                    }
                }
            };
            ContextCompat.registerReceiver(context, broadcastReceiver, intentFilter, 2);
            if (progressBar == null && alertDialogBuild != null) {
                alertDialogBuild.setTitle(context.getString(R.string.lullaby));
                alertDialogBuild.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.urbandroid.sleep.media.lullaby.LullabyDialogFragment$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        LullabyDialogFragment.lambda$startPlayingLullaby$1(context, broadcastReceiver, dialogInterface);
                    }
                });
                try {
                    alertDialogBuild.show();
                    DialogUtil.fixDivider(alertDialogBuild);
                } catch (Exception e2) {
                    Logger.logSevere(e2);
                }
            }
        }
        Intent intent = new Intent(context, (Class<?>) LullabyService.class);
        intent.putExtra("extra_lullaby_name", item.title);
        if (!(item instanceof RadioItem)) {
            intent.putExtra("extra_lullaby", item.f70data);
            try {
                new Settings(context).reportLullabyUsed(LullabyPlayer.Lullaby.valueOf(item.f70data));
            } catch (IllegalArgumentException e3) {
                Logger.logSevere(e3);
                return;
            }
        } else if (ISpotifyPlayer.INSTANCE.isSpotifyUri(item.f70data)) {
            intent.putExtra("extra_lullaby", "spotify");
            intent.putExtra("extra_online_radio_url", item.f70data);
        } else {
            OnlineRadioRingtones.Radio radioByName = SharedApplicationContext.getSettings().getRadioByName(item.title);
            if (radioByName != null) {
                intent.putExtra("extra_lullaby", "online_radio");
                intent.putExtra("extra_online_radio_url", radioByName.url);
                intent.putExtra("extra_lullaby_name", radioByName.title);
            }
        }
        ContextExtKt.startForegroundServiceWithLog(context, intent);
    }

    private void tagLullaby(SleepRecord sleepRecord) {
        if (sleepRecord != null) {
            String comment = sleepRecord.getComment();
            Tag tag = Tag.LULLABY;
            if (Tag.hasTag(comment, tag)) {
                return;
            }
            Tag.addTagToComment(sleepRecord, tag);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Logger.logInfo("LullabyDialog: onCreate()");
        final FragmentActivity activity = getActivity();
        final boolean zIsAlwaysDarkTheme = (activity == null || !(activity instanceof BaseActivity)) ? false : ((BaseActivity) activity).isAlwaysDarkTheme();
        final Settings settings = new Settings(activity);
        this.vi = InflatorUtil.get(activity);
        TrialFilter.getInstance().reevaluate();
        if (getArguments() != null) {
            this.select = getArguments().getBoolean("select", false);
            this.radios = getArguments().getBoolean("radio", false);
            this.preview = getArguments().getBoolean("preview", false);
            this.dark = getArguments().getBoolean("dark", false);
        }
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(getActivity());
        StringBuilder sb = new StringBuilder();
        sb.append(getActivity().getString(R.string.lullaby));
        if (TrialFilter.getInstance().isTrial()) {
            sb.append(" (");
            sb.append(getActivity().getString(R.string.full_version_more));
            sb.append(")");
        }
        View viewInflate = this.vi.inflate(R.layout.dialog_lullaby_title, (ViewGroup) null);
        materialAlertDialogBuilder.setTitle((CharSequence) sb.toString());
        if (SleepService.isRunning()) {
            materialAlertDialogBuilder.setCustomTitle(viewInflate);
            Spinner spinner = (Spinner) viewInflate.findViewById(R.id.turn_off_spinner);
            ArrayAdapter arrayAdapter = new ArrayAdapter(activity, zIsAlwaysDarkTheme ? R.layout.spinner_dark : R.layout.spinner, getResources().getStringArray(R.array.media_decreasing_volume_after_entries));
            spinner.setAdapter((SpinnerAdapter) arrayAdapter);
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            int lullabyVolumeDownAfter = settings.getLullabyVolumeDownAfter();
            final String[] stringArray = getResources().getStringArray(R.array.media_decreasing_volume_after_values);
            int i = 0;
            while (true) {
                if (i >= stringArray.length) {
                    i = 0;
                    break;
                }
                int iIntValue = -1;
                try {
                    String str = stringArray[i];
                    if (str != null) {
                        iIntValue = Integer.valueOf(str).intValue();
                    }
                } catch (NumberFormatException unused) {
                }
                zza$$ExternalSyntheticOutline0.m(iIntValue, lullabyVolumeDownAfter, "LullabyDialog: current ", " selected ");
                if (lullabyVolumeDownAfter <= iIntValue) {
                    zza$$ExternalSyntheticOutline0.m(i, "LullabyDialog: selected index ");
                    break;
                }
                i++;
            }
            spinner.setSelection(i);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.urbandroid.sleep.media.lullaby.LullabyDialogFragment.1
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j) {
                    StringBuilder sbM65m = Fragment$$ExternalSyntheticOutline1.m65m(i2, "LullabyDialog: selected index ", " value ");
                    sbM65m.append(stringArray[i2]);
                    Logger.logInfo(sbM65m.toString());
                    settings.setLullabyVolumeDownAfter(Integer.parseInt(stringArray[i2]));
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
        } else {
            viewInflate.findViewById(R.id.timeout_layout).setVisibility(8);
        }
        final ArrayList arrayList = new ArrayList();
        if (!this.radios) {
            for (LullabyPlayer.Lullaby lullaby : settings.getLullabyByUsed()) {
                if (!lullaby.isLocalPackage() && !TrialFilter.getInstance().isAddonLullaby()) {
                    Item item = new Item(activity.getString(R.string.lullaby) + " - " + activity.getString(R.string.addon));
                    if (!arrayList.contains(item)) {
                        arrayList.add(item);
                    }
                } else if (TrialFilter.getInstance().isTrial() && !lullaby.isTrial() && !TrialFilter.getInstance().isAddonLullaby()) {
                    Item item2 = new Item(activity.getString(R.string.trial_unlock));
                    if (!arrayList.contains(item2)) {
                        arrayList.add(item2);
                    }
                }
                LullabyPlayer.Lullaby lullaby2 = LullabyPlayer.Lullaby.NONE;
                if (lullaby == lullaby2 && this.select) {
                    arrayList.add(new Item(activity.getString(R.string.disabled), lullaby.name()));
                } else if (lullaby != lullaby2) {
                    arrayList.add(new Item(lullaby.getDisplayName(activity), lullaby.name()));
                }
            }
        }
        if (!this.select) {
            ArrayList<OnlineRadioRingtones.Radio> arrayList2 = new ArrayList();
            if (TrialFilter.getInstance().isSpotify()) {
                arrayList2.add(new OnlineRadioRingtones.Radio(getContext().getResources().getString(R.string.spotify) + ": " + getContext().getResources().getString(R.string.spotify_current_playlist), null, "spotify-play-last-song"));
                List<SpotifyServiceExecutor.SpotifyUri> spotifyAlbums = new Settings(activity).getSpotifyAlbums();
                if (spotifyAlbums != null) {
                    for (SpotifyServiceExecutor.SpotifyUri spotifyUri : spotifyAlbums) {
                        arrayList2.add(new OnlineRadioRingtones.Radio(getContext().getResources().getString(R.string.spotify) + ": " + spotifyUri.getTitle() + ", " + spotifyUri.getArtistString(), null, spotifyUri.getUri()));
                    }
                }
            }
            arrayList2.addAll(settings.getOnlineRadios("key_online_radios"));
            arrayList2.addAll(settings.getOnlineRadios("key_online_radios_featured"));
            if (arrayList2.size() > 0) {
                arrayList.add(new Item(activity.getString(R.string.online_radio)));
                for (OnlineRadioRingtones.Radio radio : arrayList2) {
                    arrayList.add(new RadioItem(radio.title, radio.url));
                }
            }
        }
        materialAlertDialogBuilder.setAdapter((ListAdapter) new BaseAdapter() { // from class: com.urbandroid.sleep.media.lullaby.LullabyDialogFragment.2
            @Override // android.widget.Adapter
            public int getCount() {
                return arrayList.size();
            }

            @Override // android.widget.Adapter
            public Object getItem(int i2) {
                return arrayList.get(i2);
            }

            @Override // android.widget.Adapter
            public long getItemId(int i2) {
                return i2;
            }

            @Override // android.widget.BaseAdapter, android.widget.Adapter
            public int getItemViewType(int i2) {
                return !((Item) getItem(i2)).separator ? 1 : 0;
            }

            @Override // android.widget.Adapter
            public View getView(int i2, View view, ViewGroup viewGroup) {
                Item item3 = (Item) arrayList.get(i2);
                if (item3 != null) {
                    boolean z = item3.separator;
                    LullabyDialogFragment lullabyDialogFragment = LullabyDialogFragment.this;
                    LullabyPlayer.Lullaby lullabyValueOf = null;
                    if (z) {
                        view = lullabyDialogFragment.vi.inflate(R.layout.dialog_item_section, (ViewGroup) null);
                        view.setOnClickListener(null);
                        view.setOnLongClickListener(null);
                        view.setLongClickable(false);
                    } else {
                        view = lullabyDialogFragment.vi.inflate(R.layout.dialog_item_entry, (ViewGroup) null);
                    }
                    ImageView imageView = (ImageView) view.findViewById(R.id.icon);
                    ((TextView) view.findViewById(R.id.title)).setText(item3.title);
                    try {
                        lullabyValueOf = LullabyPlayer.Lullaby.valueOf(item3.f70data);
                    } catch (Exception unused2) {
                    }
                    if (imageView != null) {
                        if (item3 instanceof RadioItem) {
                            if (ISpotifyPlayer.INSTANCE.isSpotifyUri(item3.f70data)) {
                                imageView.setImageResource(R.drawable.ic_lullaby_spotify_color);
                            } else {
                                imageView.setImageResource(R.drawable.ic_lullaby_radio);
                            }
                        } else if (lullabyValueOf != null) {
                            imageView.setImageDrawable(LullabyPlayer.Lullaby.valueOf(item3.f70data).getIcon(activity));
                        } else {
                            imageView.setImageResource(R.drawable.ic_next);
                        }
                        if (zIsAlwaysDarkTheme) {
                            imageView.getDrawable().setColorFilter(ColorUtil.i(activity, R.color.white), PorterDuff.Mode.SRC_ATOP);
                        }
                    }
                }
                return view;
            }

            @Override // android.widget.BaseAdapter, android.widget.Adapter
            public int getViewTypeCount() {
                return 2;
            }
        }, (DialogInterface.OnClickListener) new MediaListActivity$$ExternalSyntheticLambda1(this, arrayList, activity, 6));
        materialAlertDialogBuilder.setPositiveButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.media.lullaby.LullabyDialogFragment.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        });
        if (LullabyService.isRunning()) {
            materialAlertDialogBuilder.setNegativeButton(R.string.player_stop, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.media.lullaby.LullabyDialogFragment.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    boolean zIsRunning = LullabyService.isRunning();
                    Context context = activity;
                    if (zIsRunning) {
                        LullabyService.stop(context);
                    } else {
                        Toast.makeText(context, R.string.not_playing, 0).show();
                    }
                    dialogInterface.dismiss();
                }
            });
        }
        materialAlertDialogBuilder.setNeutralButton(R.string.help, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.media.lullaby.LullabyDialogFragment.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (LullabyDialogFragment.this.getActivity() != null) {
                    ViewIntent.urlCustomTab(LullabyDialogFragment.this.getActivity(), "https://sleep.urbandroid.org/docs//sleep/lullaby.html");
                }
            }
        });
        AlertDialog alertDialogCreate = materialAlertDialogBuilder.create();
        if (this.dark) {
            alertDialogCreate.setOnShowListener(new FixButtonColorOnShowDialogListener(R.color.white));
        }
        return alertDialogCreate;
    }

    public static class Item {

        /* JADX INFO: renamed from: data, reason: collision with root package name */
        public String f70data;
        public boolean separator = true;
        public String title;

        public Item(String str, String str2) {
            this.title = str;
            this.f70data = str2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Item)) {
                return false;
            }
            Item item = (Item) obj;
            if (this.separator != item.separator) {
                return false;
            }
            String str = this.title;
            String str2 = item.title;
            if (str == null ? str2 != null : !str.equals(str2)) {
                return false;
            }
            String str3 = this.f70data;
            String str4 = item.f70data;
            return str3 == null ? str4 == null : str3.equals(str4);
        }

        public int hashCode() {
            int i = (this.separator ? 1 : 0) * 31;
            String str = this.title;
            int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f70data;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public Item(String str) {
            this.title = str;
        }
    }

    public static void startPlayingLullaby(Context context, String str) {
        startPlayingLullaby(context, new Item(str, str), (ProgressBar) null);
    }

    public static void startPlayingLullaby(Context context, Item item) {
        startPlayingLullaby(context, item, (ProgressBar) null);
    }

    public static void startPlayingLullaby(Context context, String str, ProgressBar progressBar) {
        startPlayingLullaby(context, new Item(str, str), progressBar);
    }
}
