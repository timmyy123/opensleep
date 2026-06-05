package com.urbandroid.sleep.fragment.preview;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.service.PrefStore;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.EdgeToEdgeUtil;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0003J\r\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0003R(\u0010\u0015\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/urbandroid/sleep/fragment/preview/PreviewPageFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "", "animate", "(Landroid/view/View;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onResume", "animateFirst", "Lcom/urbandroid/sleep/fragment/preview/PreviewPage;", SDKConstants.PARAM_VALUE, "page", "Lcom/urbandroid/sleep/fragment/preview/PreviewPage;", "getPage", "()Lcom/urbandroid/sleep/fragment/preview/PreviewPage;", "Landroid/view/animation/Animation;", "anim", "Landroid/view/animation/Animation;", "Landroid/os/Handler;", "h", "Landroid/os/Handler;", "", "wasAnimated", "Z", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PreviewPageFragment extends Fragment {
    private Animation anim;
    private final Handler h = new Handler();
    private PreviewPage page;
    private boolean wasAnimated;

    private final void animate(View view) {
        PreviewPage previewPage = this.page;
        CharSequence title = previewPage != null ? previewPage.getTitle() : null;
        Logger.logInfo("Preview: Fragment animate " + ((Object) title) + " " + view + " Was " + this.wasAnimated);
        View viewFindViewById = view.findViewById(R.id.image);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(0);
        }
        if (this.anim == null || view.findViewById(R.id.image) == null) {
            Logger.logInfo("Preview: Fragment Animate view null");
            return;
        }
        View viewFindViewById2 = view.findViewById(R.id.image);
        if (viewFindViewById2 != null) {
            viewFindViewById2.startAnimation(this.anim);
        }
        View viewFindViewById3 = view.findViewById(R.id.image);
        if (viewFindViewById3 != null) {
            viewFindViewById3.setVisibility(0);
        }
        this.wasAnimated = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$0$0(PreviewPage previewPage, int i, PrefStore prefStore, CompoundButton compoundButton, boolean z) {
        compoundButton.getClass();
        Logger.logInfo("Preview: " + previewPage.getId() + " check checked '" + previewPage.getPoints()[i] + "'");
        prefStore.save(previewPage.getId() + "_check_" + i, Integer.valueOf(z ? 1 : 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$0$1(PreviewPage previewPage, int i, PrefStore prefStore, CompoundButton compoundButton, boolean z) {
        compoundButton.getClass();
        Logger.logInfo("Preview: " + previewPage.getId() + " radio checked '" + previewPage.getPoints()[i] + "'");
        prefStore.save(previewPage.getId() + "_check_" + i, Integer.valueOf(z ? 1 : 0));
    }

    public final void animateFirst() {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        inflater.getClass();
        Bundle arguments = getArguments();
        FragmentActivity activity = getActivity();
        arguments.getClass();
        PreviewPage previewPage = (PreviewPage) arguments.getSerializable("page");
        this.page = previewPage;
        previewPage.getClass();
        final int i = 0;
        View viewInflate = inflater.inflate(previewPage.getPageLayout(), container, false);
        Context context = viewInflate.getContext();
        PreviewPage previewPage2 = this.page;
        zza$$ExternalSyntheticOutline0.m("Preview: Fragment onCreateView ", previewPage2 != null ? previewPage2.getId() : null);
        PreviewPage previewPage3 = this.page;
        Logger.logInfo("Preview: Fragment onCreateView " + ((Object) (previewPage3 != null ? previewPage3.getTitle() : null)));
        final PreviewPage previewPage4 = this.page;
        if (previewPage4 != null) {
            if (activity != null) {
                Logger.logInfo("Preview: adjustLayout");
                previewPage4.adjustLayout(activity, viewInflate);
            }
            if (!(previewPage4 instanceof PremiumPreviewPage)) {
                EdgeToEdgeUtil.Companion companion = EdgeToEdgeUtil.INSTANCE;
                EdgeToEdgeUtil.Companion.insetsBottom$default(companion, viewInflate.findViewById(R.id.bottom), 0, false, 6, null);
                EdgeToEdgeUtil.Companion.insetsTop$default(companion, viewInflate.findViewById(R.id.indicator_placeholder), 0, 2, null);
            }
            Logger.logInfo("Preview: anim");
            if (previewPage4.getAnim() > 0) {
                this.anim = AnimationUtils.loadAnimation(context, previewPage4.getAnim());
                View viewFindViewById = viewInflate.findViewById(R.id.image);
                if (viewFindViewById != null) {
                    viewFindViewById.setVisibility(4);
                }
            }
            Logger.logInfo("Preview: title");
            if (previewPage4.getTitle() != null && viewInflate.findViewById(R.id.title) != null) {
                View viewFindViewById2 = viewInflate.findViewById(R.id.title);
                viewFindViewById2.getClass();
                ((TextView) viewFindViewById2).setText(previewPage4.getTitle());
            }
            Logger.logInfo("Preview: background");
            if (previewPage4.getBackgroundResource() > -1) {
                if (previewPage4.getBackgroundResource() == previewPage4.getBottomBackgroundResource()) {
                    View viewFindViewById3 = viewInflate.findViewById(R.id.background);
                    if (viewFindViewById3 != null) {
                        viewFindViewById3.setBackgroundResource(previewPage4.getBackgroundResource());
                    }
                } else {
                    GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{ColorUtil.i(getContext(), previewPage4.getBackgroundResource()), ColorUtil.i(getContext(), previewPage4.getBottomBackgroundResource())});
                    View viewFindViewById4 = viewInflate.findViewById(R.id.background);
                    if (viewFindViewById4 != null) {
                        viewFindViewById4.setBackground(gradientDrawable);
                    }
                }
            }
            Logger.logInfo("Preview: text");
            if (viewInflate.findViewById(R.id.text) != null) {
                if (previewPage4.getText() == null || StringsKt__StringsJVMKt.contentEquals("", previewPage4.getText())) {
                    View viewFindViewById5 = viewInflate.findViewById(R.id.text);
                    if (viewFindViewById5 != null) {
                        viewFindViewById5.setVisibility(8);
                    }
                } else {
                    TextView textView = (TextView) viewInflate.findViewById(R.id.text);
                    textView.setText(previewPage4.getText());
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                }
            }
            Logger.logInfo("Preview: image");
            if (previewPage4.getImageResource() > -1) {
                View viewFindViewById6 = viewInflate.findViewById(R.id.image);
                viewFindViewById6.getClass();
                ((ImageView) viewFindViewById6).setImageResource(previewPage4.getImageResource());
            } else {
                View viewFindViewById7 = viewInflate.findViewById(R.id.image);
                if (viewFindViewById7 != null) {
                    viewFindViewById7.setVisibility(8);
                }
            }
            Logger.logInfo("Preview: imageBottom");
            if (viewInflate.findViewById(R.id.imageBottom) != null) {
                if (previewPage4.getImageBottomResource() > -1) {
                    View viewFindViewById8 = viewInflate.findViewById(R.id.imageBottom);
                    viewFindViewById8.getClass();
                    ((ImageView) viewFindViewById8).setImageResource(previewPage4.getImageBottomResource());
                } else {
                    View viewFindViewById9 = viewInflate.findViewById(R.id.imageBottom);
                    if (viewFindViewById9 != null) {
                        viewFindViewById9.setVisibility(8);
                    }
                }
            }
            Logger.logInfo("Preview: done");
            if (previewPage4.getPoints().length != 0) {
                int[] iArr = {R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5, R.id.point6, R.id.point7, R.id.point8, R.id.point9};
                context.getClass();
                final PrefStore prefStore = new PrefStore(context, "onboarding_prefs");
                int iMin = Math.min(previewPage4.getPoints().length, 9);
                for (final int i2 = 0; i2 < iMin; i2++) {
                    TextView textView2 = (TextView) viewInflate.findViewById(iArr[i2]);
                    Logger.logInfo("Preview: point text " + textView2);
                    if (textView2 != null) {
                        textView2.setVisibility(0);
                        textView2.setText(previewPage4.getPoints()[i2]);
                        final int i3 = 1;
                        if (previewPage4.getPoints().length == 1) {
                            textView2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_achievement_info, 0, 0, 0);
                        }
                        Logger.logInfo("Preview: " + previewPage4.getId() + " check listener '" + previewPage4.getPoints()[i2] + "'");
                        if (textView2 instanceof CheckBox) {
                            prefStore.save(previewPage4.getId() + "_check_" + i2, -1);
                            ((CheckBox) textView2).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.urbandroid.sleep.fragment.preview.PreviewPageFragment$$ExternalSyntheticLambda0
                                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                                    int i4 = i;
                                    PrefStore prefStore2 = prefStore;
                                    int i5 = i2;
                                    PreviewPage previewPage5 = previewPage4;
                                    switch (i4) {
                                        case 0:
                                            PreviewPageFragment.onCreateView$lambda$0$0(previewPage5, i5, prefStore2, compoundButton, z);
                                            break;
                                        default:
                                            PreviewPageFragment.onCreateView$lambda$0$1(previewPage5, i5, prefStore2, compoundButton, z);
                                            break;
                                    }
                                }
                            });
                        } else if (textView2 instanceof RadioButton) {
                            prefStore.save(previewPage4.getId() + "_check_" + i2, -1);
                            ((RadioButton) textView2).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.urbandroid.sleep.fragment.preview.PreviewPageFragment$$ExternalSyntheticLambda0
                                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                                    int i4 = i3;
                                    PrefStore prefStore2 = prefStore;
                                    int i5 = i2;
                                    PreviewPage previewPage5 = previewPage4;
                                    switch (i4) {
                                        case 0:
                                            PreviewPageFragment.onCreateView$lambda$0$0(previewPage5, i5, prefStore2, compoundButton, z);
                                            break;
                                        default:
                                            PreviewPageFragment.onCreateView$lambda$0$1(previewPage5, i5, prefStore2, compoundButton, z);
                                            break;
                                    }
                                }
                            });
                        }
                    }
                }
            }
        }
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        PreviewPage previewPage = this.page;
        CharSequence title = previewPage != null ? previewPage.getTitle() : null;
        Logger.logInfo("Preview: Fragment visible to user " + ((Object) title) + " Was " + this.wasAnimated);
        if (getView() == null || requireView().findViewById(R.id.image) == null || requireView().findViewById(R.id.image).getVisibility() != 4) {
            return;
        }
        View viewRequireView = requireView();
        viewRequireView.getClass();
        animate(viewRequireView);
    }
}
