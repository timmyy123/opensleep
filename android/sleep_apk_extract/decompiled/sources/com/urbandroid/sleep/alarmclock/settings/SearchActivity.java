package com.urbandroid.sleep.alarmclock.settings;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.facebook.login.widget.ToolTipPopup;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.ads.AdMobController$$ExternalSyntheticLambda0;
import com.urbandroid.sleep.alarmclock.Alarms;
import com.urbandroid.sleep.domain.addon.AddonApp;
import com.urbandroid.sleep.fragment.AlarmFragment;
import com.urbandroid.sleep.fragment.addon.AddonAdapter;
import com.urbandroid.sleep.gui.EnsembleListAdapter;
import com.urbandroid.sleep.gui.GraphListCursorAdapter;
import com.urbandroid.sleep.gui.IFilterListAdapter;
import com.urbandroid.sleep.gui.NoiseFilter;
import com.urbandroid.sleep.gui.NoiseListCursorAdapter;
import com.urbandroid.sleep.gui.ToolbarUtil;
import com.urbandroid.sleep.gui.fab.ScrollAnimator;
import com.urbandroid.sleep.gui.pref.PreferenceFragment;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 H2\u00020\u0001:\u0001HB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0003J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u0003J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR.\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00040\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010)\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010/\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R$\u00104\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010:\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010E\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010;\u001a\u0004\bF\u0010=\"\u0004\bG\u0010?¨\u0006I"}, d2 = {"Lcom/urbandroid/sleep/alarmclock/settings/SearchActivity;", "Lcom/urbandroid/common/BaseActivity;", "<init>", "()V", "", "show", "", "showNoData", "(Z)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "", "searchTerm", "search", "(Ljava/lang/String;)V", "updateAdapter", "Landroid/view/MenuItem;", "item", "onOptionsItemSelected", "(Landroid/view/MenuItem;)Z", "clearAllLenses", "Landroid/view/Menu;", "menu", "onCreateOptionsMenu", "(Landroid/view/Menu;)Z", "", "enabled_lense", "I", "", "lenses", "Ljava/util/Map;", "getLenses", "()Ljava/util/Map;", "setLenses", "(Ljava/util/Map;)V", "Landroid/widget/EditText;", "searchText", "Landroid/widget/EditText;", "Landroid/widget/ListView;", "searchList", "Landroid/widget/ListView;", "Lcom/urbandroid/sleep/gui/EnsembleListAdapter;", "searchAdapter", "Lcom/urbandroid/sleep/gui/EnsembleListAdapter;", "Lcom/urbandroid/sleep/gui/NoiseFilter;", "noiseFilter", "Lcom/urbandroid/sleep/gui/NoiseFilter;", "currentSearch", "Ljava/lang/String;", "Lcom/urbandroid/sleep/gui/fab/ScrollAnimator;", "scrollAnimator", "Lcom/urbandroid/sleep/gui/fab/ScrollAnimator;", "getScrollAnimator", "()Lcom/urbandroid/sleep/gui/fab/ScrollAnimator;", "setScrollAnimator", "(Lcom/urbandroid/sleep/gui/fab/ScrollAnimator;)V", "clearItem", "Landroid/view/MenuItem;", "getClearItem", "()Landroid/view/MenuItem;", "setClearItem", "(Landroid/view/MenuItem;)V", "Landroid/view/Menu;", "getMenu", "()Landroid/view/Menu;", "setMenu", "(Landroid/view/Menu;)V", "menuLenses", "getMenuLenses", "setMenuLenses", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SearchActivity extends BaseActivity {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private MenuItem clearItem;
    private Menu menu;
    private MenuItem menuLenses;
    private NoiseFilter noiseFilter;
    private ScrollAnimator scrollAnimator;
    private EnsembleListAdapter searchAdapter;
    private ListView searchList;
    private EditText searchText;
    private int enabled_lense = -1;
    private Map<Integer, Boolean> lenses = new LinkedHashMap();
    private String currentSearch = "";

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/urbandroid/sleep/alarmclock/settings/SearchActivity$Companion;", "", "<init>", "()V", "EXTRA_LENSE", "", "EXTRA_SHOW_KEYBOARD", "SEARCH_MAX_WITH", "", "SEARCH_MIN_WITH", "start", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/app/Activity;", "lenses", "keyboard", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void start$default(Companion companion, Activity activity, int i, boolean z, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = -1;
            }
            if ((i2 & 4) != 0) {
                z = true;
            }
            companion.start(activity, i, z);
        }

        public final void start(Activity context, int lenses, boolean keyboard) {
            context.getClass();
            Intent intent = new Intent(context, (Class<?>) SearchActivity.class);
            if (lenses != -1) {
                intent.putExtra("extra_lense", lenses);
            }
            intent.putExtra("show_keyboard", keyboard);
            if (!new Settings(context).isTransitionAnimation()) {
                context.startActivity(intent);
                return;
            }
            ActivityOptionsCompat activityOptionsCompatMakeSceneTransitionAnimation = ActivityOptionsCompat.makeSceneTransitionAnimation(context, context.findViewById(R.id.search_button), "searchTr");
            activityOptionsCompatMakeSceneTransitionAnimation.getClass();
            ContextCompat.startActivity(context, intent, activityOptionsCompatMakeSceneTransitionAnimation.toBundle());
        }

        private Companion() {
        }

        public final void start(Activity activity) {
            activity.getClass();
            start$default(this, activity, 0, false, 6, null);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.alarmclock.settings.SearchActivity$onCreate$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/urbandroid/sleep/alarmclock/settings/SearchActivity$onCreate$4", "Landroid/graphics/drawable/Animatable2$AnimationCallback;", "onAnimationStart", "", "drawable", "Landroid/graphics/drawable/Drawable;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass4 extends Animatable2.AnimationCallback {
        final /* synthetic */ AnimatedVectorDrawable $animateVector;

        public AnonymousClass4(AnimatedVectorDrawable animatedVectorDrawable) {
            this.$animateVector = animatedVectorDrawable;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onAnimationStart$lambda$0(AnimatedVectorDrawable animatedVectorDrawable) {
            animatedVectorDrawable.start();
        }

        @Override // android.graphics.drawable.Animatable2.AnimationCallback
        public void onAnimationStart(Drawable drawable) {
            drawable.getClass();
            ((BaseActivity) SearchActivity.this).h.postDelayed(new SearchActivity$$ExternalSyntheticLambda2(this.$animateVector, 1), ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(SearchActivity searchActivity) {
        EditText editText = searchActivity.searchText;
        if (editText != null) {
            editText.setFocusableInTouchMode(true);
        }
        EditText editText2 = searchActivity.searchText;
        if (editText2 != null) {
            editText2.setFocusable(true);
        }
        EditText editText3 = searchActivity.searchText;
        if (editText3 != null) {
            editText3.requestFocus();
        }
        Object systemService = searchActivity.getSystemService("input_method");
        systemService.getClass();
        ((InputMethodManager) systemService).showSoftInput(searchActivity.searchText, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(AnimatedVectorDrawable animatedVectorDrawable) {
        animatedVectorDrawable.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onOptionsItemSelected$lambda$0(SearchActivity searchActivity) {
        ((Toolbar) searchActivity.findViewById(R.id.toolbar)).showOverflowMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String search$lambda$0$0(String str) {
        return str;
    }

    public static final void start(Activity activity) {
        INSTANCE.start(activity);
    }

    public final void clearAllLenses() {
        Iterator<T> it = this.lenses.keySet().iterator();
        while (it.hasNext()) {
            this.lenses.put(Integer.valueOf(((Number) it.next()).intValue()), Boolean.FALSE);
        }
        Iterator<T> it2 = this.lenses.keySet().iterator();
        while (it2.hasNext()) {
            int iIntValue = ((Number) it2.next()).intValue();
            Menu menu = this.menu;
            if (menu != null) {
                menu.findItem(iIntValue).setChecked(false);
            }
        }
    }

    public final ScrollAnimator getScrollAnimator() {
        return this.scrollAnimator;
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ToolbarUtil.apply(this);
        this.searchText = (EditText) findViewById(R.id.search);
        if (getSupportActionBar() != null) {
            ActionBar supportActionBar = getSupportActionBar();
            supportActionBar.getClass();
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.surface_variant));
        Intent intent = getIntent();
        if (intent != null) {
            this.enabled_lense = intent.getIntExtra("extra_lense", -1);
        }
        this.searchList = (ListView) findViewById(R.id.search_list_view);
        this.noiseFilter = new NoiseFilter("", false, -1L, -1L);
        this.searchAdapter = new EnsembleListAdapter(this);
        showNoData(true);
        EditText editText = this.searchText;
        if (editText != null) {
            editText.addTextChangedListener(new TextWatcher() { // from class: com.urbandroid.sleep.alarmclock.settings.SearchActivity.onCreate.2
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    editable.getClass();
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    charSequence.getClass();
                }

                /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
                @Override // android.text.TextWatcher
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    String lowerCase;
                    String string;
                    SearchActivity searchActivity = SearchActivity.this;
                    if (charSequence == null || (string = charSequence.toString()) == null) {
                        lowerCase = "";
                    } else {
                        int length = string.length() - 1;
                        int i3 = 0;
                        boolean z = false;
                        while (i3 <= length) {
                            boolean z2 = Intrinsics.compare((int) string.charAt(!z ? i3 : length), 32) <= 0;
                            if (z) {
                                if (!z2) {
                                    break;
                                } else {
                                    length--;
                                }
                            } else if (z2) {
                                i3++;
                            } else {
                                z = true;
                            }
                        }
                        String string2 = string.subSequence(i3, length + 1).toString();
                        if (string2 != null) {
                            lowerCase = string2.toLowerCase(Locale.ROOT);
                            lowerCase.getClass();
                            if (lowerCase == null) {
                            }
                        }
                    }
                    searchActivity.currentSearch = lowerCase;
                    SearchActivity searchActivity2 = SearchActivity.this;
                    searchActivity2.search(searchActivity2.currentSearch);
                    int length2 = SearchActivity.this.currentSearch.length();
                    SearchActivity searchActivity3 = SearchActivity.this;
                    if (length2 == 0) {
                        searchActivity3.showNoData(true);
                    } else {
                        searchActivity3.showNoData(false);
                    }
                }
            });
        }
        int i = 0;
        if (getIntent().hasExtra("show_keyboard")) {
            new Handler().postDelayed(new SearchActivity$$ExternalSyntheticLambda1(this, i), 1500L);
        }
        new Settings(this).addShowCaseShown("sc_search_used");
        View viewFindViewById = findViewById(R.id.no_data_image);
        viewFindViewById.getClass();
        Drawable drawable = ((ImageView) viewFindViewById).getDrawable();
        drawable.getClass();
        AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) drawable;
        animatedVectorDrawable.registerAnimationCallback(new AnonymousClass4(animatedVectorDrawable));
        this.h.postDelayed(new SearchActivity$$ExternalSyntheticLambda2(animatedVectorDrawable, i), 2000L);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.getClass();
        getMenuInflater().inflate(R.menu.search_menu, menu);
        this.menu = menu;
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            int i2 = this.enabled_lense;
            if (i2 == -1 || i2 == menu.getItem(i).getItemId()) {
                this.lenses.put(Integer.valueOf(menu.getItem(i).getItemId()), Boolean.TRUE);
                menu.getItem(i).setChecked(true);
            } else {
                this.lenses.put(Integer.valueOf(menu.getItem(i).getItemId()), Boolean.FALSE);
                menu.getItem(i).setChecked(false);
            }
        }
        this.clearItem = menu.findItem(R.id.menu_clear_text);
        this.menuLenses = menu.findItem(R.id.search_lenses);
        MenuItem menuItem = this.clearItem;
        if (menuItem != null) {
            menuItem.setVisible(false);
        }
        updateAdapter();
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        Editable editableText;
        item.getClass();
        Logger.logInfo("Search: menu item " + item);
        int i = 1;
        if (item.getItemId() == 16908332) {
            ActivityCompat.finishAfterTransition(this);
            return true;
        }
        if (item.getItemId() == R.id.menu_clear_text) {
            EditText editText = this.searchText;
            if (editText != null && (editableText = editText.getEditableText()) != null) {
                editableText.clear();
            }
            MenuItem menuItem = this.clearItem;
            if (menuItem != null) {
                menuItem.setVisible(false);
            }
            return true;
        }
        if (item.getItemId() == R.id.menu_clear_lenses) {
            clearAllLenses();
            this.h.post(new SearchActivity$$ExternalSyntheticLambda1(this, i));
            return true;
        }
        Boolean bool = this.lenses.get(Integer.valueOf(item.getItemId()));
        boolean z = !(bool != null ? bool.booleanValue() : false);
        this.lenses.put(Integer.valueOf(item.getItemId()), Boolean.valueOf(z));
        item.setChecked(z);
        updateAdapter();
        return true;
    }

    public final void search(String searchTerm) {
        Collection<IFilterListAdapter> adapters;
        searchTerm.getClass();
        int i = 1;
        if (searchTerm.length() >= 1) {
            MenuItem menuItem = this.clearItem;
            if (menuItem != null) {
                menuItem.setVisible(true);
            }
            EnsembleListAdapter ensembleListAdapter = this.searchAdapter;
            if (ensembleListAdapter != null && (adapters = ensembleListAdapter.getAdapters()) != null) {
                for (IFilterListAdapter iFilterListAdapter : adapters) {
                    if (iFilterListAdapter instanceof NoiseListCursorAdapter) {
                        NoiseFilter noiseFilter = this.noiseFilter;
                        if (noiseFilter != null) {
                            noiseFilter.setFilterString(searchTerm);
                        }
                        ((NoiseListCursorAdapter) iFilterListAdapter).filter(this.noiseFilter);
                    } else {
                        iFilterListAdapter.filter(new AdMobController$$ExternalSyntheticLambda0(searchTerm, i));
                    }
                    iFilterListAdapter.notifyChanged();
                }
            }
            EnsembleListAdapter ensembleListAdapter2 = this.searchAdapter;
            if (ensembleListAdapter2 != null) {
                ensembleListAdapter2.notifyDataSetChanged();
            }
            showNoData(false);
        } else {
            showNoData(true);
        }
        ListView listView = this.searchList;
        if (listView != null) {
            listView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.urbandroid.sleep.alarmclock.settings.SearchActivity.search.2
                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                    if (SearchActivity.this.getScrollAnimator() == null) {
                        SearchActivity.this.setScrollAnimator(new ScrollAnimator(SearchActivity.this, null, 0, false, 14, null));
                    }
                    ScrollAnimator scrollAnimator = SearchActivity.this.getScrollAnimator();
                    if (scrollAnimator != null) {
                        scrollAnimator.scroll(firstVisibleItem);
                    }
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView view, int scrollState) {
                }
            });
        }
    }

    public final void setScrollAnimator(ScrollAnimator scrollAnimator) {
        this.scrollAnimator = scrollAnimator;
    }

    public final void showNoData(boolean show) {
        if (show) {
            findViewById(R.id.search_list_view).setVisibility(8);
            findViewById(R.id.no_data).setVisibility(0);
        } else {
            findViewById(R.id.search_list_view).setVisibility(0);
            findViewById(R.id.no_data).setVisibility(8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x017e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateAdapter() {
        SearchActivity searchActivity;
        Fragment fragmentFindFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragment_settings);
        fragmentFindFragmentById.getClass();
        PreferenceManager preferenceManager = ((PreferenceFragment) fragmentFindFragmentById).getPreferenceManager();
        int iMin = Math.min(Math.max(ActivityUtils.getDip(this, 36), 64), 144);
        int dip = (iMin - ActivityUtils.getDip(this, 24)) / 2;
        EnsembleListAdapter ensembleListAdapter = this.searchAdapter;
        if (ensembleListAdapter != null) {
            ensembleListAdapter.clear();
        }
        Boolean bool = this.lenses.get(Integer.valueOf(R.id.search_lenses_settings));
        Boolean bool2 = Boolean.FALSE;
        if (!Intrinsics.areEqual(bool, bool2)) {
            Logger.logInfo("Adding lense search", null);
            EnsembleListAdapter ensembleListAdapter2 = this.searchAdapter;
            if (ensembleListAdapter2 != null) {
                String string = getString(R.string.settings);
                preferenceManager.getClass();
                SearchPreferenceAdapter searchPreferenceAdapter = new SearchPreferenceAdapter(this, preferenceManager);
                searchPreferenceAdapter.init();
                Unit unit = Unit.INSTANCE;
                ensembleListAdapter2.addSection(string, searchPreferenceAdapter);
            }
        }
        if (!Intrinsics.areEqual(this.lenses.get(Integer.valueOf(R.id.search_lenses_docs)), bool2)) {
            Logger.logInfo("Adding lense docs", null);
            EnsembleListAdapter ensembleListAdapter3 = this.searchAdapter;
            if (ensembleListAdapter3 != null) {
                String string2 = getString(R.string.documentation);
                SearchDocumentationAdapter searchDocumentationAdapter = new SearchDocumentationAdapter(this);
                Unit unit2 = Unit.INSTANCE;
                ensembleListAdapter3.addSection(string2, searchDocumentationAdapter);
            }
        }
        if (!Intrinsics.areEqual(this.lenses.get(Integer.valueOf(R.id.search_lenses_alarm)), bool2)) {
            Logger.logInfo("Adding lense alarm", null);
            EnsembleListAdapter ensembleListAdapter4 = this.searchAdapter;
            if (ensembleListAdapter4 != null) {
                ensembleListAdapter4.addSection(getString(R.string.alarm_list_title), new AlarmFragment.AlarmTimeAdapter(this, Alarms.getAlarmsCursor(this), null, true));
            }
        }
        if (!Intrinsics.areEqual(this.lenses.get(Integer.valueOf(R.id.search_lenses_addon)), bool2)) {
            Logger.logInfo("Adding lense addon", null);
            EnsembleListAdapter ensembleListAdapter5 = this.searchAdapter;
            if (ensembleListAdapter5 != null) {
                String string3 = getString(R.string.addon);
                AddonApp.Companion companion = AddonApp.INSTANCE;
                Context applicationContext = getApplicationContext();
                applicationContext.getClass();
                String[] stringArray = getResources().getStringArray(R.array.addons_entries);
                stringArray.getClass();
                ensembleListAdapter5.addSection(string3, new AddonAdapter(this, companion.from(applicationContext, stringArray, false), iMin, dip));
            }
        }
        if (!Intrinsics.areEqual(this.lenses.get(Integer.valueOf(R.id.search_lenses_graphs)), bool2)) {
            Logger.logInfo("Adding lense graphs", null);
            EnsembleListAdapter ensembleListAdapter6 = this.searchAdapter;
            if (ensembleListAdapter6 != null) {
                ensembleListAdapter6.addSection(getString(R.string.graphs), new GraphListCursorAdapter(this, SharedApplicationContext.getInstance().getSleepRecordRepository(), null));
            }
        }
        if (!Intrinsics.areEqual(this.lenses.get(Integer.valueOf(R.id.search_lenses_noise)), bool2)) {
            Logger.logInfo("Adding lense noise", null);
            EnsembleListAdapter ensembleListAdapter7 = this.searchAdapter;
            if (ensembleListAdapter7 != null) {
                searchActivity = this;
                ensembleListAdapter7.addSection(getString(R.string.noise), new NoiseListCursorAdapter(searchActivity, SharedApplicationContext.getInstance().getSleepRecordRepository(), null, this.noiseFilter, this.searchList, null));
            } else {
                searchActivity = this;
            }
        }
        ListView listView = searchActivity.searchList;
        if (listView != null) {
            listView.setOnItemClickListener(searchActivity.searchAdapter);
        }
        ListView listView2 = searchActivity.searchList;
        if (listView2 != null) {
            listView2.setAdapter((ListAdapter) searchActivity.searchAdapter);
        }
        searchActivity.search(searchActivity.currentSearch);
        EnsembleListAdapter ensembleListAdapter8 = searchActivity.searchAdapter;
        if (ensembleListAdapter8 != null) {
            ensembleListAdapter8.notifyDataSetChanged();
        }
        TextView textView = (TextView) searchActivity.findViewById(R.id.no_data_text);
        EnsembleListAdapter ensembleListAdapter9 = searchActivity.searchAdapter;
        textView.setText(ensembleListAdapter9 != null ? ensembleListAdapter9.getSectionTexts() : null);
    }

    public static final void start(Activity activity, int i, boolean z) {
        INSTANCE.start(activity, i, z);
    }
}
