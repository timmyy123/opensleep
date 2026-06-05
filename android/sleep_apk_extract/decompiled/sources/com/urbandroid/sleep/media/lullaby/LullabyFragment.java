package com.urbandroid.sleep.media.lullaby;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0002\u0013\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0006\u0010\u0012\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/urbandroid/sleep/media/lullaby/LullabyFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "columnCount", "", "lullabyAdapter", "Lcom/urbandroid/sleep/media/lullaby/LullabyRecyclerViewAdapter;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "refresh", "Section", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LullabyFragment extends Fragment {
    private int columnCount = 1;
    private LullabyRecyclerViewAdapter lullabyAdapter;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbandroid/sleep/media/lullaby/LullabyFragment$Section;", "", "<init>", "(Ljava/lang/String;I)V", "LULLABY", "SPOTIFY", "RADIO", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Section {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Section[] $VALUES;
        public static final Section LULLABY = new Section("LULLABY", 0);
        public static final Section SPOTIFY = new Section("SPOTIFY", 1);
        public static final Section RADIO = new Section("RADIO", 2);

        private static final /* synthetic */ Section[] $values() {
            return new Section[]{LULLABY, SPOTIFY, RADIO};
        }

        static {
            Section[] sectionArr$values = $values();
            $VALUES = sectionArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(sectionArr$values);
        }

        private Section(String str, int i) {
        }

        public static Section valueOf(String str) {
            return (Section) Enum.valueOf(Section.class, str);
        }

        public static Section[] values() {
            return (Section[]) $VALUES.clone();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.columnCount = arguments.getInt("column-count");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) throws CloneNotSupportedException {
        inflater.getClass();
        View viewInflate = inflater.inflate(R.layout.fragment_lullaby, container, false);
        if (viewInflate instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) viewInflate;
            recyclerView.setLayoutManager(this.columnCount <= 1 ? new LinearLayoutManager(recyclerView.getContext()) : new GridLayoutManager(recyclerView.getContext(), this.columnCount));
            FragmentActivity activity = getActivity();
            if (activity != null) {
                LullabyRecyclerViewAdapter lullabyRecyclerViewAdapter = new LullabyRecyclerViewAdapter(activity);
                lullabyRecyclerViewAdapter.loadSection();
                this.lullabyAdapter = lullabyRecyclerViewAdapter;
                recyclerView.setAdapter(lullabyRecyclerViewAdapter);
            }
            recyclerView.setNestedScrollingEnabled(true);
        }
        return viewInflate;
    }

    public final void refresh() {
        Logger.logInfo("Lullaby: onResume refresh");
        LullabyRecyclerViewAdapter lullabyRecyclerViewAdapter = this.lullabyAdapter;
        LullabyRecyclerViewAdapter lullabyRecyclerViewAdapter2 = null;
        if (lullabyRecyclerViewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lullabyAdapter");
            lullabyRecyclerViewAdapter = null;
        }
        lullabyRecyclerViewAdapter.loadSection();
        LullabyRecyclerViewAdapter lullabyRecyclerViewAdapter3 = this.lullabyAdapter;
        if (lullabyRecyclerViewAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lullabyAdapter");
        } else {
            lullabyRecyclerViewAdapter2 = lullabyRecyclerViewAdapter3;
        }
        lullabyRecyclerViewAdapter2.notifyDataSetChanged();
    }
}
