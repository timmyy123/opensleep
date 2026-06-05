package com.urbandroid.sleep.captcha.list;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.captcha.list.AbstractCaptchaDialogFragment;
import com.urbandroid.sleep.captcha.list.CaptchaItem;
import com.urbandroid.util.VolumeUtil$$ExternalSyntheticLambda0;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/urbandroid/sleep/captcha/list/CaptchaTileDialogFragment;", "Lcom/urbandroid/sleep/captcha/list/AbstractCaptchaDialogFragment;", "<init>", "()V", "Landroid/content/DialogInterface;", "dialog", "", "onDismiss", "(Landroid/content/DialogInterface;)V", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "", "titleRes", "I", "Lcom/urbandroid/sleep/captcha/list/CaptchaRecyclerViewAdapter;", "captchaAdapter", "Lcom/urbandroid/sleep/captcha/list/CaptchaRecyclerViewAdapter;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CaptchaTileDialogFragment extends AbstractCaptchaDialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private CaptchaRecyclerViewAdapter captchaAdapter;
    private int titleRes = R.string.captcha_default_title;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lcom/urbandroid/sleep/captcha/list/CaptchaTileDialogFragment$Companion;", "", "<init>", "()V", "inflateCaptchaList", "Lkotlin/Pair;", "Landroid/view/View;", "Lcom/urbandroid/sleep/captcha/list/CaptchaRecyclerViewAdapter;", "list", "Lcom/urbandroid/sleep/captcha/list/ICaptchaTileList;", "activity", "Landroid/app/Activity;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [T, com.urbandroid.sleep.captcha.list.CaptchaRecyclerViewAdapter] */
        public final Pair<View, CaptchaRecyclerViewAdapter> inflateCaptchaList(ICaptchaTileList list, Activity activity) throws Exception {
            list.getClass();
            activity.getClass();
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            View viewFindViewById = activity.findViewById(R.id.list);
            viewFindViewById.getClass();
            if (!(viewFindViewById instanceof RecyclerView)) {
                throw new Exception("View is not recyclerView");
            }
            RecyclerView recyclerView = (RecyclerView) viewFindViewById;
            recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 2));
            ?? captchaRecyclerViewAdapter = new CaptchaRecyclerViewAdapter(activity, list);
            captchaRecyclerViewAdapter.load();
            ref$ObjectRef.element = captchaRecyclerViewAdapter;
            recyclerView.setAdapter((RecyclerView.Adapter) captchaRecyclerViewAdapter);
            if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                layoutManager.getClass();
                ((GridLayoutManager) layoutManager).setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.urbandroid.sleep.captcha.list.CaptchaTileDialogFragment$Companion$inflateCaptchaList$1$2
                    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                    public int getSpanSize(int position) {
                        return ref$ObjectRef.element.getItemViewType(position) == CaptchaItem.Type.ADDON.ordinal() ? 2 : 1;
                    }
                });
            }
            recyclerView.setNestedScrollingEnabled(true);
            return new Pair<>(viewFindViewById, ref$ObjectRef.element);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$1$0(CaptchaTileDialogFragment captchaTileDialogFragment, DialogInterface dialogInterface, int i) {
        ViewIntent.url(captchaTileDialogFragment.getContext(), "https://sleep.urbandroid.org/docs//alarms/captcha.html");
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) throws Exception {
        TrialFilter.getInstance().reevaluate();
        Bundle arguments = getArguments();
        if (arguments != null) {
            setPerAlarm(arguments.getBoolean("perAlarm"));
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
            dialogOnCreateDialog.getClass();
            return dialogOnCreateDialog;
        }
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(activity);
        materialAlertDialogBuilder.setTitle(getPerAlarm() ? R.string.captcha_preferene_title : R.string.captcha_default_title);
        Companion companion = INSTANCE;
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        fragmentActivityRequireActivity.getClass();
        Pair<View, CaptchaRecyclerViewAdapter> pairInflateCaptchaList = companion.inflateCaptchaList(this, fragmentActivityRequireActivity);
        View viewComponent1 = pairInflateCaptchaList.component1();
        this.captchaAdapter = pairInflateCaptchaList.component2();
        materialAlertDialogBuilder.setPositiveButton(R.string.cancel, (DialogInterface.OnClickListener) null);
        materialAlertDialogBuilder.setNeutralButton(R.string.help, (DialogInterface.OnClickListener) new VolumeUtil$$ExternalSyntheticLambda0(this, 8));
        materialAlertDialogBuilder.setView(viewComponent1);
        AlertDialog alertDialogCreate = materialAlertDialogBuilder.create();
        alertDialogCreate.getClass();
        return alertDialogCreate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        AbstractCaptchaDialogFragment.OnCloseListener onCloseListener;
        dialog.getClass();
        super.onDismiss(dialog);
        if (!(getActivity() instanceof AbstractCaptchaDialogFragment.OnCloseListener) || getSelectedCaptchaId() == AbstractCaptchaDialogFragment.INSTANCE.getNOT_INITIALIZED() || (onCloseListener = (AbstractCaptchaDialogFragment.OnCloseListener) getActivity()) == null) {
            return;
        }
        onCloseListener.onClose(getSelectedCaptchaId());
    }
}
