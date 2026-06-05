package com.urbandroid.sleep.domain.tag;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.common.util.math.JulianDay;
import com.urbandroid.common.util.math.Moon;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.domain.EventLabel;
import com.urbandroid.sleep.domain.EventsUtil;
import com.urbandroid.sleep.domain.IEvent;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.location.LocationService;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.ResourceUtil;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r9v8 com.urbandroid.sleep.domain.tag.Tag, still in use, count: 1, list:
  (r9v8 com.urbandroid.sleep.domain.tag.Tag) from 0x02ff: FILLED_NEW_ARRAY 
  (r10v8 com.urbandroid.sleep.domain.tag.Tag)
  (r9v8 com.urbandroid.sleep.domain.tag.Tag)
  (r6v7 com.urbandroid.sleep.domain.tag.Tag)
  (r7v8 com.urbandroid.sleep.domain.tag.Tag)
  (r8v8 com.urbandroid.sleep.domain.tag.Tag)
 A[WRAPPED] (LINE:768) elemType: com.urbandroid.sleep.domain.tag.Tag
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:252)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:180)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes4.dex */
public final class Tag {
    FOOD("food", R.drawable.ic_action_food),
    SPORT("sport", R.drawable.ic_walk),
    ALCOHOL("alcohol", R.drawable.ic_martini),
    STRESS("stress", R.drawable.ic_action_stress),
    CAFFEINE("caffeine", R.drawable.ic_coffee),
    LOVE("love", R.drawable.ic_action_love),
    MED("med", R.drawable.ic_action_med),
    DREAM("dream", R.drawable.ic_action_dream),
    TALK("talk", R.drawable.ic_action_talk),
    SNORE("snore", R.drawable.ic_action_noise),
    LAUGH("laugh", R.drawable.ic_action_laugh),
    SICK("sick", R.drawable.ic_action_sick),
    WORK("work", R.drawable.ic_action_work),
    CPAP("cpap", R.drawable.ic_action_cpap),
    BABY("baby", R.drawable.ic_action_baby),
    NOTE("note", R.drawable.ic_action_mic, true, false),
    NEWMOON("newmoon", R.drawable.ic_action_newmoon, true, false),
    FULLMOON("fullmoon", R.drawable.ic_action_fullmoon, true, false),
    RAIN("rain", R.drawable.ic_action_rain, true),
    STORM("storm", R.drawable.ic_action_storm, true),
    CLOUDY("cloudy", R.drawable.ic_cloud, true),
    COLD("cold", R.drawable.ic_action_cold, true),
    HOT("hot", R.drawable.ic_action_hot, true),
    WATCH("watch", R.drawable.ic_action_watch, true, false),
    GEO1("geo1", R.drawable.ic_action_geo1, true, false),
    GEO2("geo2", R.drawable.ic_action_geo2, true, false),
    GEO3("geo3", R.drawable.ic_action_geo3, true, false),
    GEO0("geo0", R.drawable.ic_action_geo0, true, false),
    HOME("home", R.drawable.ic_action_home, true, false),
    CLOUD("cloud", R.drawable.ic_cloud_upload, true, false),
    GOODDREAM("gooddream", R.drawable.ic_dream_good),
    BADDREAM("baddream", R.drawable.ic_dream_bad),
    LULLABY("lullaby", R.drawable.ic_action_lullaby),
    MENSES("menses", R.drawable.ic_action_menses),
    SONAR("sonar", R.drawable.ic_sonar, true, false),
    PHASER("phaser", R.drawable.ic_sleep_phaser, true, false),
    PAIR("pair", R.drawable.ic_pair, true, false),
    AUTO("auto", R.drawable.ic_automagic, true, false),
    LIGHT("light", R.drawable.ic_lightbulb, true, false),
    DARK("dark", R.drawable.ic_lightbulb_off, true, false);

    public static final Pattern KNOWN_TAG_QUANTITY_VALUE_PATTERN;
    public static final Pattern TAG_NAME_PATTERN;
    public static final Pattern TAG_QUANTITY_VALUE_PATTERN;
    public static final Pattern TAG_QUANTITY_VALUE_PATTERN_NO_EMOJI;
    public static final Pattern TAG_VALUE_GROUP_PATTERN;
    private static Drawable emptyDrawable;
    private static Tag[] geoTags;
    private static String[] implicitTagStrings;
    private static String[] knownTagStrings;
    private static final Pattern removeDoubleWhitespace;
    private static Pattern removeGeoTagsPattern;
    private static Pattern removeImplicitTagsPattern;
    private static Pattern removeKnownTagsPattern;
    private static Tag[] values;
    private boolean canBeAddedByUser;
    private int drawableResource;
    private boolean implicit;
    private final String tagName;
    private final String tagString;

    static {
        Tag tag = GEO1;
        Tag tag2 = GEO2;
        Tag tag3 = GEO3;
        Tag tag4 = HOME;
        TAG_NAME_PATTERN = Pattern.compile("(#((\\p{L}|\\p{N}|\\.\\d|,\\d|-)+))|((?:[\\u2700-\\u27bf]|(?:[\\ud83c\\udde6-\\ud83c\\uddff]){2}|[\\ud800\\udc00-\\uDBFF\\uDFFF]|[\\u2600-\\u26FF])[\\ufe0e\\ufe0f]?(?:[\\u0300-\\u036f\\ufe20-\\ufe23\\u20d0-\\u20f0]|[\\ud83c\\udffb-\\ud83c\\udfff])?(?:\\u200d(?:[^\\ud800-\\udfff]|(?:[\\ud83c\\udde6-\\ud83c\\uddff]){2}|[\\ud800\\udc00-\\uDBFF\\uDFFF]|[\\u2600-\\u26FF])[\\ufe0e\\ufe0f]?(?:[\\u0300-\\u036f\\ufe20-\\ufe23\\u20d0-\\u20f0]|[\\ud83c\\udffb-\\ud83c\\udfff])?)*|[\\u0023-\\u0039]\\ufe0f?\\u20e3|\\u3299|\\u3297|\\u303d|\\u3030|\\u24c2|[\\ud83c\\udd70-\\ud83c\\udd71]|[\\ud83c\\udd7e-\\ud83c\\udd7f]|\\ud83c\\udd8e|[\\ud83c\\udd91-\\ud83c\\udd9a]|[\\ud83c\\udde6-\\ud83c\\uddff]|[\\ud83c\\ude01-\\ud83c\\ude02]|\\ud83c\\ude1a|\\ud83c\\ude2f|[\\ud83c\\ude32-\\ud83c\\ude3a]|[\\ud83c\\ude50-\\ud83c\\ude51]|\\u203c|\\u2049|[\\u25aa-\\u25ab]|\\u25b6|\\u25c0|[\\u25fb-\\u25fe]|\\u00a9|\\u00ae|\\u2122|\\u2139|\\ud83c\\udc04|[\\u2600-\\u26FF]|\\u2b05|\\u2b06|\\u2b07|\\u2b1b|\\u2b1c|\\u2b50|\\u2b55|\\u231a|\\u231b|\\u2328|\\u23cf|[\\u23e9-\\u23f3]|[\\u23f8-\\u23fa]|\\ud83c\\udccf|\\u2934|\\u2935|[\\u2190-\\u21ff])+");
        TAG_QUANTITY_VALUE_PATTERN = Pattern.compile("(#((\\p{L}|\\p{N}|\\.\\d|,\\d|-)+))|((?:[\\u2700-\\u27bf]|(?:[\\ud83c\\udde6-\\ud83c\\uddff]){2}|[\\ud800\\udc00-\\uDBFF\\uDFFF]|[\\u2600-\\u26FF])[\\ufe0e\\ufe0f]?(?:[\\u0300-\\u036f\\ufe20-\\ufe23\\u20d0-\\u20f0]|[\\ud83c\\udffb-\\ud83c\\udfff])?(?:\\u200d(?:[^\\ud800-\\udfff]|(?:[\\ud83c\\udde6-\\ud83c\\uddff]){2}|[\\ud800\\udc00-\\uDBFF\\uDFFF]|[\\u2600-\\u26FF])[\\ufe0e\\ufe0f]?(?:[\\u0300-\\u036f\\ufe20-\\ufe23\\u20d0-\\u20f0]|[\\ud83c\\udffb-\\ud83c\\udfff])?)*|[\\u0023-\\u0039]\\ufe0f?\\u20e3|\\u3299|\\u3297|\\u303d|\\u3030|\\u24c2|[\\ud83c\\udd70-\\ud83c\\udd71]|[\\ud83c\\udd7e-\\ud83c\\udd7f]|\\ud83c\\udd8e|[\\ud83c\\udd91-\\ud83c\\udd9a]|[\\ud83c\\udde6-\\ud83c\\uddff]|[\\ud83c\\ude01-\\ud83c\\ude02]|\\ud83c\\ude1a|\\ud83c\\ude2f|[\\ud83c\\ude32-\\ud83c\\ude3a]|[\\ud83c\\ude50-\\ud83c\\ude51]|\\u203c|\\u2049|[\\u25aa-\\u25ab]|\\u25b6|\\u25c0|[\\u25fb-\\u25fe]|\\u00a9|\\u00ae|\\u2122|\\u2139|\\ud83c\\udc04|[\\u2600-\\u26FF]|\\u2b05|\\u2b06|\\u2b07|\\u2b1b|\\u2b1c|\\u2b50|\\u2b55|\\u231a|\\u231b|\\u2328|\\u23cf|[\\u23e9-\\u23f3]|[\\u23f8-\\u23fa]|\\ud83c\\udccf|\\u2934|\\u2935|[\\u2190-\\u21ff])+(_([a-zA-Z0-9|-]+))?");
        TAG_QUANTITY_VALUE_PATTERN_NO_EMOJI = Pattern.compile("(#((\\p{L}|\\p{N}|\\.\\d|,\\d|-)+))(_([a-zA-Z0-9|-]+))?");
        TAG_VALUE_GROUP_PATTERN = Pattern.compile("(#((\\p{L}|\\p{N}|\\.\\d|,\\d|-)+))|((?:[\\u2700-\\u27bf]|(?:[\\ud83c\\udde6-\\ud83c\\uddff]){2}|[\\ud800\\udc00-\\uDBFF\\uDFFF]|[\\u2600-\\u26FF])[\\ufe0e\\ufe0f]?(?:[\\u0300-\\u036f\\ufe20-\\ufe23\\u20d0-\\u20f0]|[\\ud83c\\udffb-\\ud83c\\udfff])?(?:\\u200d(?:[^\\ud800-\\udfff]|(?:[\\ud83c\\udde6-\\ud83c\\uddff]){2}|[\\ud800\\udc00-\\uDBFF\\uDFFF]|[\\u2600-\\u26FF])[\\ufe0e\\ufe0f]?(?:[\\u0300-\\u036f\\ufe20-\\ufe23\\u20d0-\\u20f0]|[\\ud83c\\udffb-\\ud83c\\udfff])?)*|[\\u0023-\\u0039]\\ufe0f?\\u20e3|\\u3299|\\u3297|\\u303d|\\u3030|\\u24c2|[\\ud83c\\udd70-\\ud83c\\udd71]|[\\ud83c\\udd7e-\\ud83c\\udd7f]|\\ud83c\\udd8e|[\\ud83c\\udd91-\\ud83c\\udd9a]|[\\ud83c\\udde6-\\ud83c\\uddff]|[\\ud83c\\ude01-\\ud83c\\ude02]|\\ud83c\\ude1a|\\ud83c\\ude2f|[\\ud83c\\ude32-\\ud83c\\ude3a]|[\\ud83c\\ude50-\\ud83c\\ude51]|\\u203c|\\u2049|[\\u25aa-\\u25ab]|\\u25b6|\\u25c0|[\\u25fb-\\u25fe]|\\u00a9|\\u00ae|\\u2122|\\u2139|\\ud83c\\udc04|[\\u2600-\\u26FF]|\\u2b05|\\u2b06|\\u2b07|\\u2b1b|\\u2b1c|\\u2b50|\\u2b55|\\u231a|\\u231b|\\u2328|\\u23cf|[\\u23e9-\\u23f3]|[\\u23f8-\\u23fa]|\\ud83c\\udccf|\\u2934|\\u2935|[\\u2190-\\u21ff])+_([a-zA-Z0-9|-]+)");
        KNOWN_TAG_QUANTITY_VALUE_PATTERN = getRemoveTagsPattern(getAllTagStrings());
        geoTags = new Tag[]{tag4, tag, tag2, tag3};
        implicitTagStrings = getImplicitTagStrings();
        knownTagStrings = getKnownTagStrings();
        removeDoubleWhitespace = Pattern.compile("  ");
        removeGeoTagsPattern = getRemoveTagsPattern(getTagsStrings(tag4, new Tag("geo0", R.drawable.ic_action_geo0, true, false), tag, tag2, tag3));
        removeImplicitTagsPattern = getRemoveTagsPattern(implicitTagStrings);
        removeKnownTagsPattern = getRemoveTagsPattern(knownTagStrings);
        values = values();
    }

    private Tag(String str, int i, boolean z, boolean z2) {
        this.implicit = false;
        this.canBeAddedByUser = true;
        this.drawableResource = i;
        this.tagName = str;
        this.tagString = FileInsert$$ExternalSyntheticOutline0.m("#", str);
        this.implicit = z;
        this.canBeAddedByUser = z2;
    }

    private static void addGeos(SleepRecord sleepRecord) {
        String geo = sleepRecord.getGeo();
        if (geo == null || geo.length() < 1) {
            return;
        }
        try {
            sleepRecord.setComment(removeGeoTags(sleepRecord.getComment()));
            List<String> geos = SharedApplicationContext.getSettings().getGeos();
            for (int i = 0; i < geos.size() && i < geoTags.length; i++) {
                if (LocationService.sameOrAdjacent(geo, geos.get(i))) {
                    addTagToComment(sleepRecord, geoTags[i]);
                    return;
                }
            }
            addTagToComment(sleepRecord, GEO0);
        } catch (Exception e) {
            Logger.logSevere(e);
        }
    }

    public static void addImplicitTags(SleepRecord sleepRecord) {
        if (SharedApplicationContext.isInitialized() && SharedApplicationContext.getSettings().isImplicitTagsEnabled()) {
            addMoonPhases(sleepRecord);
            if (!SharedApplicationContext.getSettings().isGeoOptOut()) {
                addGeos(sleepRecord);
            }
            addLightTag(sleepRecord);
        }
    }

    private static void addLightTag(SleepRecord sleepRecord) {
        List<IEvent> events = EventsUtil.getEvents(sleepRecord.getEvents().getCopiedEvents(), EventLabel.LUX);
        if (events == null || events.isEmpty()) {
            return;
        }
        long millis = TimeUnit.MINUTES.toMillis(sleepRecord.getSleepLengthMinutes());
        Iterator<IEvent> it = events.iterator();
        long j = 0;
        while (it.hasNext()) {
            if (it.next().getValue() > 60.0f) {
                j += 120000;
            }
            if (j >= millis * 0.5d) {
                addTagToComment(sleepRecord, LIGHT);
                return;
            }
        }
    }

    private static void addMoonPhases(SleepRecord sleepRecord) {
        String comment = sleepRecord.getComment();
        Tag tag = FULLMOON;
        Tag tag2 = NEWMOON;
        if (hasOneOfTags(comment, tag, tag2)) {
            return;
        }
        try {
            GregorianCalendar gregorianCalendar = (GregorianCalendar) Calendar.getInstance();
            gregorianCalendar.setTime(sleepRecord.getFrom());
            int iIlluminatedPercentage = new Moon(new JulianDay(gregorianCalendar)).illuminatedPercentage();
            if (iIlluminatedPercentage < 1) {
                addTagToComment(sleepRecord, tag2);
            } else if (iIlluminatedPercentage > 99) {
                addTagToComment(sleepRecord, tag);
            }
        } catch (Exception e) {
            Logger.logSevere(e);
        }
    }

    public static void addTagToComment(SleepRecord sleepRecord, Tag tag) {
        String tagString;
        if (sleepRecord != null) {
            String comment = sleepRecord.getComment();
            if (hasTag(comment, tag)) {
                return;
            }
            if (comment == null) {
                tagString = tag.getTagString();
            } else {
                tagString = comment.trim() + " " + tag.getTagString();
            }
            sleepRecord.setComment(tagString);
        }
    }

    public static String collapseTags(String str) {
        if (str == null) {
            return null;
        }
        return TAG_QUANTITY_VALUE_PATTERN.matcher(str).replaceAll("T");
    }

    public static String filterTags(String str) {
        if (str == null) {
            return null;
        }
        return removeKnownTags(str);
    }

    private static String[] getAllTagStrings() {
        LinkedList linkedList = new LinkedList();
        for (Tag tag : values()) {
            linkedList.add(tag.getTagString());
        }
        return (String[]) linkedList.toArray(new String[0]);
    }

    private static String[] getImplicitTagStrings() {
        LinkedList linkedList = new LinkedList();
        for (Tag tag : values()) {
            if (tag.isImplicit()) {
                linkedList.add(tag.getTagString());
            }
        }
        return (String[]) linkedList.toArray(new String[0]);
    }

    private static String[] getKnownTagStrings() {
        LinkedList linkedList = new LinkedList();
        for (Tag tag : values()) {
            linkedList.add(tag.getTagString());
        }
        return (String[]) linkedList.toArray(new String[0]);
    }

    public static String getMostFrequentGeo(int i) {
        int maxGeoFreq = SharedApplicationContext.getSettings().getMaxGeoFreq();
        List<String> geos = SharedApplicationContext.getSettings().getGeos();
        if (geos != null && maxGeoFreq >= i && geos.size() != 0) {
            return geos.get(0);
        }
        Logger.logDebug("Slept at home: no data");
        return null;
    }

    private static Pattern getRemoveTagsPattern(String... strArr) {
        StringBuilder sb = new StringBuilder("(");
        int length = strArr.length;
        boolean z = true;
        int i = 0;
        while (i < length) {
            String str = strArr[i];
            if (!z) {
                sb.append("|");
            }
            sb.append(str);
            i++;
            z = false;
        }
        sb.append(")(_\\d+x|_[a-zA-Z0-9|-]+)?(\\s|$)");
        return Pattern.compile(sb.toString());
    }

    public static Set<String> getRemovedTags(String str, String str2) {
        Set<String> tags = getTags(str);
        Iterator<String> it = getTags(str2).iterator();
        while (it.hasNext()) {
            tags.remove(it.next());
        }
        return tags;
    }

    public static Set<String> getTags(Pattern pattern, String str) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (str != null) {
            Matcher matcher = pattern.matcher(str);
            while (matcher.find()) {
                String strGroup = matcher.group(0);
                if (strGroup.substring(0, 1).equals("#")) {
                    strGroup = strGroup.substring(1, strGroup.length());
                }
                linkedHashSet.add(strGroup);
            }
        }
        return linkedHashSet;
    }

    private static String[] getTagsStrings(Tag... tagArr) {
        LinkedList linkedList = new LinkedList();
        for (Tag tag : tagArr) {
            linkedList.add(tag.getTagString());
        }
        return (String[]) linkedList.toArray(new String[0]);
    }

    public static void handleTag(Context context, String str, final String str2, final EditText editText, ViewGroup viewGroup, final boolean z, int i, boolean z2, boolean z3, final View.OnClickListener onClickListener) {
        Tag tagValueOf;
        View view;
        try {
            tagValueOf = valueOf(str.toUpperCase());
        } catch (IllegalArgumentException unused) {
            tagValueOf = null;
        }
        if (z2 || tagValueOf == null || tagValueOf.canBeAddedByUser()) {
            String strConcat = str.matches("((?:[\\u2700-\\u27bf]|(?:[\\ud83c\\udde6-\\ud83c\\uddff]){2}|[\\ud800\\udc00-\\uDBFF\\uDFFF]|[\\u2600-\\u26FF])[\\ufe0e\\ufe0f]?(?:[\\u0300-\\u036f\\ufe20-\\ufe23\\u20d0-\\u20f0]|[\\ud83c\\udffb-\\ud83c\\udfff])?(?:\\u200d(?:[^\\ud800-\\udfff]|(?:[\\ud83c\\udde6-\\ud83c\\uddff]){2}|[\\ud800\\udc00-\\uDBFF\\uDFFF]|[\\u2600-\\u26FF])[\\ufe0e\\ufe0f]?(?:[\\u0300-\\u036f\\ufe20-\\ufe23\\u20d0-\\u20f0]|[\\ud83c\\udffb-\\ud83c\\udfff])?)*|[\\u0023-\\u0039]\\ufe0f?\\u20e3|\\u3299|\\u3297|\\u303d|\\u3030|\\u24c2|[\\ud83c\\udd70-\\ud83c\\udd71]|[\\ud83c\\udd7e-\\ud83c\\udd7f]|\\ud83c\\udd8e|[\\ud83c\\udd91-\\ud83c\\udd9a]|[\\ud83c\\udde6-\\ud83c\\uddff]|[\\ud83c\\ude01-\\ud83c\\ude02]|\\ud83c\\ude1a|\\ud83c\\ude2f|[\\ud83c\\ude32-\\ud83c\\ude3a]|[\\ud83c\\ude50-\\ud83c\\ude51]|\\u203c|\\u2049|[\\u25aa-\\u25ab]|\\u25b6|\\u25c0|[\\u25fb-\\u25fe]|\\u00a9|\\u00ae|\\u2122|\\u2139|\\ud83c\\udc04|[\\u2600-\\u26FF]|\\u2b05|\\u2b06|\\u2b07|\\u2b1b|\\u2b1c|\\u2b50|\\u2b55|\\u231a|\\u231b|\\u2328|\\u23cf|[\\u23e9-\\u23f3]|[\\u23f8-\\u23fa]|\\ud83c\\udccf|\\u2934|\\u2935|[\\u2190-\\u21ff])+") ? str : "#".concat(str);
            TextView textView = new TextView(context);
            int i2 = R.color.primary;
            textView.setTextColor(ColorUtil.i(context, R.color.primary));
            textView.setMinimumWidth(1);
            textView.setBackgroundColor(ColorUtil.i(context, R.color.transparent));
            textView.setPadding(ActivityUtils.getDip(context, 8), ActivityUtils.getDip(context, 16), ActivityUtils.getDip(context, 8), ActivityUtils.getDip(context, 16));
            if (tagValueOf != null) {
                int drawableResource = tagValueOf.getDrawableResource();
                if (str2 != null) {
                    textView.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(context, drawableResource), (Drawable) null, (Drawable) null, (Drawable) null);
                    textView.setText(" ".concat(str2));
                    view = textView;
                } else {
                    ImageButton imageButton = new ImageButton(context);
                    imageButton.setBackgroundColor(ColorUtil.i(context, R.color.transparent));
                    imageButton.setPadding(ActivityUtils.getDip(context, 16), ActivityUtils.getDip(context, 16), ActivityUtils.getDip(context, 16), ActivityUtils.getDip(context, 16));
                    Drawable drawable = ContextCompat.getDrawable(context, drawableResource);
                    if (z3) {
                        DrawableCompat.setTint(drawable, ColorUtil.i(context, R.color.white));
                    }
                    imageButton.setImageDrawable(drawable);
                    view = imageButton;
                }
            } else {
                textView.setText(str2 == null ? strConcat : FileInsert$$ExternalSyntheticOutline0.m$1(strConcat, "_", str2));
                view = textView;
            }
            View view2 = view;
            if (view2 instanceof Button) {
                TextView textView2 = (TextView) view2;
                Resources resources = context.getResources();
                if (z3) {
                    i2 = R.color.white;
                }
                textView2.setTextColor(resources.getColor(i2));
            }
            final String str3 = strConcat;
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.domain.tag.Tag$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    Tag.lambda$handleTag$0(editText, str3, str2, z, onClickListener, view3);
                }
            });
            view2.setOnLongClickListener(new Tag$$ExternalSyntheticLambda1(editText, str3, 0));
            if (i == -1) {
                viewGroup.addView(view2);
            } else {
                viewGroup.addView(view2, i);
            }
        }
    }

    public static boolean hasOneOfTags(String str, Tag... tagArr) {
        for (Tag tag : tagArr) {
            if (hasTag(str, tag)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasTag(String str, Tag tag) {
        return hasTag(str, tag.getTagString());
    }

    public static String highlightTags(String str) {
        if (str == null) {
            return null;
        }
        return KNOWN_TAG_QUANTITY_VALUE_PATTERN.matcher(str).replaceAll("").trim().length() == 0 ? "" : TAG_QUANTITY_VALUE_PATTERN_NO_EMOJI.matcher(str).replaceAll("<b>$1</b>");
    }

    public static boolean isValidTag(String str) {
        return TAG_NAME_PATTERN.matcher("#" + str).matches();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$handleTag$0(EditText editText, String str, String str2, boolean z, View.OnClickListener onClickListener, View view) {
        if (!matches(FileInsert$$ExternalSyntheticOutline0.m$1(str, "(_\\d+x)?"), editText.getText().toString())) {
            StringBuilder sb = new StringBuilder();
            sb.append((Object) editText.getText());
            sb.append(" ");
            sb.append(str);
            sb.append(str2 != null ? "_".concat(str2) : " ");
            editText.setText(sb.toString().replaceAll("  ", " "));
            Logger.logInfo("SleepCommentCard:pefrom DONE");
            editText.onEditorAction(0);
        } else if (z) {
            editText.setText(editText.getText().toString().replaceFirst(str + "_3x(\\s|$)", "").replaceFirst(FileInsert$$ExternalSyntheticOutline0.m$1(str, "_2x(\\s|$)"), str + "_3x ").replaceFirst(FileInsert$$ExternalSyntheticOutline0.m$1(str, "(\\s|$)"), str + "_2x ").replaceAll("  ", " "));
            Logger.logInfo("SleepCommentCard:pefrom DONE");
            editText.onEditorAction(0);
        } else {
            editText.setText(editText.getText().toString().replaceAll(str + "(\\s|$)", "").replaceAll("  ", " "));
            Logger.logInfo("SleepCommentCard:pefrom DONE");
            editText.onEditorAction(0);
        }
        if (editText.length() > 0) {
            try {
                editText.setSelection(editText.length());
            } catch (Exception e) {
                Logger.logSevere(e);
            }
        }
        Logger.logInfo("Edit " + ((Object) editText.getText()));
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$handleTag$1(EditText editText, String str, View view) {
        editText.setText(removeTag(editText.getText().toString(), str));
        Logger.logInfo("SleepCommentCard:pefrom DONE");
        editText.onEditorAction(0);
        return true;
    }

    private static String matchGroup(Pattern pattern, String str, int i) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(i);
        }
        return null;
    }

    private static boolean matches(String str, String str2) {
        return Pattern.compile(str).matcher(str2).find();
    }

    public static Tag nullSafeParseTag(String str) {
        try {
            return valueOf(str.toUpperCase());
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    private static String removeDoubleWhitespace(String str) {
        Matcher matcher = removeDoubleWhitespace.matcher(str);
        return !matcher.matches() ? str : matcher.replaceAll(" ");
    }

    private static String removeGeoTags(String str) {
        return removeTagsUsingPattern(str, removeGeoTagsPattern);
    }

    private static String removeKnownTags(String str) {
        return removeTagsUsingPattern(str, removeKnownTagsPattern);
    }

    public static String removeTag(String str, String str2) {
        return removeTagsUsingPattern(str, Pattern.compile(str2 + "(_\\d+x|_[a-zA-Z0-9|-]+)?(\\s|$|)"));
    }

    private static String removeTagsUsingPattern(String str, Pattern pattern) {
        return removeDoubleWhitespace(pattern.matcher(str).replaceAll(""));
    }

    public static String replaceTag(String str, String str2, String str3) {
        return str.replaceAll(FileInsert$$ExternalSyntheticOutline0.m("\\#", str2, "(\\s|_|)"), "#" + str3 + "$1");
    }

    public static void tagBitmapToTextView(Context context, TextView textView, Drawable drawable) {
        textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setCompoundDrawablePadding(4);
    }

    public static Drawable tagDrawable(Context context, String str) {
        try {
            if (valueOf(str.toUpperCase()) != null) {
                return ContextCompat.getDrawable(context, valueOf(str.toUpperCase()).getDrawableResource());
            }
            return null;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static boolean tagTextView(Context context, TextView textView, Set<String> set, boolean z, boolean z2) {
        Drawable drawableTagToBitmap = tagToBitmap(context, set, z, z2);
        if (drawableTagToBitmap == emptyDrawable) {
            return false;
        }
        tagBitmapToTextView(context, textView, drawableTagToBitmap);
        return true;
    }

    public static Drawable tagToBitmap(Context context, Set<String> set, boolean z, boolean z2) {
        Tag tagValueOf;
        float f;
        float f2;
        synchronized (Tag.class) {
            try {
                if (emptyDrawable == null) {
                    emptyDrawable = context.getResources().getDrawable(R.drawable.empty);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Bitmap bitmap = ResourceUtil.getBitmap(context, R.drawable.ic_martini);
        float f3 = 1.0f;
        int iRound = Math.round(bitmap.getHeight() * 1.0f);
        int iRound2 = Math.round(bitmap.getWidth() * 1.0f);
        if (!z) {
            iRound = 32;
            iRound2 = 32;
        }
        TextPaint textPaint = new TextPaint();
        textPaint.setStyle(Paint.Style.FILL);
        int width = 0;
        textPaint.setAlpha(0);
        textPaint.setColor(ContextCompat.getColor(context, R.color.secondary_html));
        textPaint.setTextSize(iRound * 0.45f);
        textPaint.setFakeBoldText(true);
        textPaint.setTextAlign(Paint.Align.LEFT);
        textPaint.setAntiAlias(true);
        textPaint.setDither(true);
        float f4 = 0.0f;
        float width2 = 0.0f;
        String strMatchGroup = null;
        for (String str : set) {
            if (valueOf((str.startsWith("#") ? matchGroup(TAG_NAME_PATTERN, str, 1) : str).toUpperCase()) != null) {
                float f5 = (iRound2 / f3) + width2;
                try {
                    strMatchGroup = matchGroup(TAG_VALUE_GROUP_PATTERN, str, 1);
                    if (strMatchGroup != null && strMatchGroup.length() > 1) {
                        strMatchGroup = strMatchGroup.replaceAll("x", "");
                    }
                    String str2 = strMatchGroup;
                    if (str2 != null) {
                        float f6 = f4;
                        try {
                            try {
                                f = f3;
                                f2 = f6;
                                try {
                                    strMatchGroup = str2;
                                    width2 = (new StaticLayout(str2, textPaint, Math.round(textPaint.measureText(str2)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getWidth() / 2.0f) + f5;
                                } catch (IllegalArgumentException unused) {
                                    strMatchGroup = str2;
                                    width2 = f5;
                                }
                            } catch (IllegalArgumentException unused2) {
                                f = f3;
                                f2 = f6;
                            }
                        } catch (IllegalArgumentException unused3) {
                            f = f3;
                            f2 = f6;
                        }
                    } else {
                        f = f3;
                        f2 = f4;
                    }
                    strMatchGroup = str2;
                } catch (IllegalArgumentException unused4) {
                    f = f3;
                    f2 = f4;
                }
                width2 = f5;
            } else {
                f = f3;
                f2 = f4;
            }
            f4 = f2;
            f3 = f;
        }
        float f7 = f3;
        float f8 = f4;
        if (width2 <= f8 || iRound <= 0) {
            return emptyDrawable;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(Math.round(width2), iRound, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next.startsWith("#")) {
                next = matchGroup(TAG_NAME_PATTERN, next, 1);
            }
            try {
                tagValueOf = valueOf(next.toUpperCase());
            } catch (IllegalArgumentException unused5) {
                tagValueOf = null;
            }
            if (width2 > f8 && tagValueOf != null) {
                Bitmap bitmap2 = ResourceUtil.getBitmap(context, tagValueOf.getDrawableResource());
                if (strMatchGroup == null || strMatchGroup.length() < 3) {
                    float f9 = width;
                    canvas.drawBitmap(bitmap2, f9, f8, textPaint);
                    width = (int) ((bitmap2.getWidth() / f7) + f9);
                }
            }
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmapCreateBitmap);
        bitmapDrawable.mutate().setColorFilter(ContextCompat.getColor(context, R.color.secondary), PorterDuff.Mode.MULTIPLY);
        return bitmapDrawable;
    }

    public static Tag valueOf(String str) {
        return (Tag) Enum.valueOf(Tag.class, str);
    }

    public static Tag[] values() {
        return (Tag[]) $VALUES.clone();
    }

    public boolean canBeAddedByUser() {
        return this.canBeAddedByUser;
    }

    public int getDrawableResource() {
        return this.drawableResource;
    }

    public String getTagName() {
        return this.tagName;
    }

    public String getTagString() {
        return this.tagString;
    }

    public boolean isImplicit() {
        return this.implicit;
    }

    public static boolean hasTag(String str, String str2) {
        if (str == null) {
            return false;
        }
        return str.contains(str2);
    }

    private Tag(String str, int i, boolean z) {
        this.implicit = false;
        this.canBeAddedByUser = true;
        this.drawableResource = i;
        this.tagName = str;
        this.tagString = FileInsert$$ExternalSyntheticOutline0.m("#", str);
        this.implicit = z;
    }

    private Tag(String str, int i) {
        this.implicit = false;
        this.canBeAddedByUser = true;
        this.drawableResource = i;
        this.tagName = str;
        this.tagString = FileInsert$$ExternalSyntheticOutline0.m("#", str);
    }

    public static Set<String> getTags(String str) {
        return getTags(TAG_NAME_PATTERN, str);
    }

    public static void handleTag(Context context, String str, EditText editText, ViewGroup viewGroup, boolean z, boolean z2) {
        handleTag(context, str, null, editText, viewGroup, z, -1, false, z2, null);
    }

    public static void handleTag(Context context, String str, EditText editText, ViewGroup viewGroup, boolean z, int i, boolean z2) {
        handleTag(context, str, null, editText, viewGroup, z, i, false, z2, null);
    }

    public static void handleTag(Context context, String str, EditText editText, ViewGroup viewGroup, boolean z, View.OnClickListener onClickListener) {
        handleTag(context, str, null, editText, viewGroup, z, -1, false, false, onClickListener);
    }

    public static void handleTag(Context context, String str, String str2, EditText editText, ViewGroup viewGroup, boolean z, int i, boolean z2, boolean z3) {
        handleTag(context, str, str2, editText, viewGroup, z, i, z2, z3, null);
    }

    public static void handleTag(Context context, String str, EditText editText, ViewGroup viewGroup, boolean z) {
        handleTag(context, str, null, editText, viewGroup, z, -1, false, false, null);
    }
}
