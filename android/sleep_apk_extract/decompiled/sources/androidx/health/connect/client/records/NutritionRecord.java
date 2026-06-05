package androidx.health.connect.client.records;

import android.os.Build;
import androidx.health.connect.client.aggregate.AggregateMetric;
import androidx.health.connect.client.impl.platform.records.RecordConvertersKt;
import androidx.health.connect.client.units.Energy;
import androidx.health.connect.client.units.EnergyKt;
import androidx.health.connect.client.units.Mass;
import androidx.health.connect.client.units.MassKt;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import j$.time.Instant;
import j$.time.ZoneOffset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\bG\u0018\u0000 \u0084\u00012\u00020\u0001:\u0002\u0084\u0001BÁ\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u000106\u0012\b\b\u0002\u00109\u001a\u000208¢\u0006\u0004\b:\u0010;J\u001a\u0010?\u001a\u00020>2\b\u0010=\u001a\u0004\u0018\u00010<H\u0096\u0002¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u000208H\u0016¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u000206H\u0016¢\u0006\u0004\bC\u0010DR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010E\u001a\u0004\bF\u0010GR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010H\u001a\u0004\bI\u0010JR\u001a\u0010\u0006\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010E\u001a\u0004\bK\u0010GR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010H\u001a\u0004\bL\u0010JR\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010M\u001a\u0004\bN\u0010OR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010P\u001a\u0004\bQ\u0010RR\u0019\u0010\f\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\f\u0010P\u001a\u0004\bS\u0010RR\u0019\u0010\r\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\r\u0010P\u001a\u0004\bT\u0010RR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010U\u001a\u0004\bV\u0010WR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u0010\u0010U\u001a\u0004\bX\u0010WR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u0011\u0010P\u001a\u0004\bY\u0010RR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u0012\u0010P\u001a\u0004\bZ\u0010RR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u0013\u0010P\u001a\u0004\b[\u0010RR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u0014\u0010P\u001a\u0004\b\\\u0010RR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u0015\u0010P\u001a\u0004\b]\u0010RR\u0019\u0010\u0016\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u0016\u0010P\u001a\u0004\b^\u0010RR\u0019\u0010\u0017\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u0017\u0010P\u001a\u0004\b_\u0010RR\u0019\u0010\u0018\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u0018\u0010P\u001a\u0004\b`\u0010RR\u0019\u0010\u0019\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u0019\u0010P\u001a\u0004\ba\u0010RR\u0019\u0010\u001a\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u001a\u0010P\u001a\u0004\bb\u0010RR\u0019\u0010\u001b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u001b\u0010P\u001a\u0004\bc\u0010RR\u0019\u0010\u001c\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u001c\u0010P\u001a\u0004\bd\u0010RR\u0019\u0010\u001d\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u001d\u0010P\u001a\u0004\be\u0010RR\u0019\u0010\u001e\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u001e\u0010P\u001a\u0004\bf\u0010RR\u0019\u0010\u001f\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u001f\u0010P\u001a\u0004\bg\u0010RR\u0019\u0010 \u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b \u0010P\u001a\u0004\bh\u0010RR\u0019\u0010!\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b!\u0010P\u001a\u0004\bi\u0010RR\u0019\u0010\"\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\"\u0010P\u001a\u0004\bj\u0010RR\u0019\u0010#\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b#\u0010P\u001a\u0004\bk\u0010RR\u0019\u0010$\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b$\u0010P\u001a\u0004\bl\u0010RR\u0019\u0010%\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b%\u0010P\u001a\u0004\bm\u0010RR\u0019\u0010&\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b&\u0010P\u001a\u0004\bn\u0010RR\u0019\u0010'\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b'\u0010P\u001a\u0004\bo\u0010RR\u0019\u0010(\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b(\u0010P\u001a\u0004\bp\u0010RR\u0019\u0010)\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b)\u0010P\u001a\u0004\bq\u0010RR\u0019\u0010*\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b*\u0010P\u001a\u0004\br\u0010RR\u0019\u0010+\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b+\u0010P\u001a\u0004\bs\u0010RR\u0019\u0010,\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b,\u0010P\u001a\u0004\bt\u0010RR\u0019\u0010-\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b-\u0010P\u001a\u0004\bu\u0010RR\u0019\u0010.\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b.\u0010P\u001a\u0004\bv\u0010RR\u0019\u0010/\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b/\u0010P\u001a\u0004\bw\u0010RR\u0019\u00100\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b0\u0010P\u001a\u0004\bx\u0010RR\u0019\u00101\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b1\u0010P\u001a\u0004\by\u0010RR\u0019\u00102\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b2\u0010P\u001a\u0004\bz\u0010RR\u0019\u00103\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b3\u0010P\u001a\u0004\b{\u0010RR\u0019\u00104\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b4\u0010P\u001a\u0004\b|\u0010RR\u0019\u00105\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b5\u0010P\u001a\u0004\b}\u0010RR\u0019\u00107\u001a\u0004\u0018\u0001068\u0006¢\u0006\f\n\u0004\b7\u0010~\u001a\u0004\b\u007f\u0010DR!\u00109\u001a\u0002088\u0006¢\u0006\u0016\n\u0005\b9\u0010\u0080\u0001\u0012\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0005\b\u0081\u0001\u0010B¨\u0006\u0085\u0001"}, d2 = {"Landroidx/health/connect/client/records/NutritionRecord;", "Landroidx/health/connect/client/records/IntervalRecord;", "j$/time/Instant", "startTime", "j$/time/ZoneOffset", "startZoneOffset", SDKConstants.PARAM_END_TIME, "endZoneOffset", "Landroidx/health/connect/client/records/metadata/Metadata;", "metadata", "Landroidx/health/connect/client/units/Mass;", "biotin", "caffeine", "calcium", "Landroidx/health/connect/client/units/Energy;", "energy", "energyFromFat", "chloride", "cholesterol", "chromium", "copper", "dietaryFiber", "folate", "folicAcid", "iodine", "iron", "magnesium", "manganese", "molybdenum", "monounsaturatedFat", "niacin", "pantothenicAcid", "phosphorus", "polyunsaturatedFat", "potassium", "protein", "riboflavin", "saturatedFat", "selenium", "sodium", "sugar", "thiamin", "totalCarbohydrate", "totalFat", "transFat", "unsaturatedFat", "vitaminA", "vitaminB12", "vitaminB6", "vitaminC", "vitaminD", "vitaminE", "vitaminK", "zinc", "", "name", "", "mealType", "<init>", "(Lj$/time/Instant;Lj$/time/ZoneOffset;Lj$/time/Instant;Lj$/time/ZoneOffset;Landroidx/health/connect/client/records/metadata/Metadata;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Energy;Landroidx/health/connect/client/units/Energy;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Landroidx/health/connect/client/units/Mass;Ljava/lang/String;I)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lj$/time/Instant;", "getStartTime", "()Lj$/time/Instant;", "Lj$/time/ZoneOffset;", "getStartZoneOffset", "()Lj$/time/ZoneOffset;", "getEndTime", "getEndZoneOffset", "Landroidx/health/connect/client/records/metadata/Metadata;", "getMetadata", "()Landroidx/health/connect/client/records/metadata/Metadata;", "Landroidx/health/connect/client/units/Mass;", "getBiotin", "()Landroidx/health/connect/client/units/Mass;", "getCaffeine", "getCalcium", "Landroidx/health/connect/client/units/Energy;", "getEnergy", "()Landroidx/health/connect/client/units/Energy;", "getEnergyFromFat", "getChloride", "getCholesterol", "getChromium", "getCopper", "getDietaryFiber", "getFolate", "getFolicAcid", "getIodine", "getIron", "getMagnesium", "getManganese", "getMolybdenum", "getMonounsaturatedFat", "getNiacin", "getPantothenicAcid", "getPhosphorus", "getPolyunsaturatedFat", "getPotassium", "getProtein", "getRiboflavin", "getSaturatedFat", "getSelenium", "getSodium", "getSugar", "getThiamin", "getTotalCarbohydrate", "getTotalFat", "getTransFat", "getUnsaturatedFat", "getVitaminA", "getVitaminB12", "getVitaminB6", "getVitaminC", "getVitaminD", "getVitaminE", "getVitaminK", "getZinc", "Ljava/lang/String;", "getName", "I", "getMealType", "getMealType$annotations", "()V", "Companion", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NutritionRecord implements IntervalRecord {
    public static final AggregateMetric<Mass> BIOTIN_TOTAL;
    public static final AggregateMetric<Mass> CAFFEINE_TOTAL;
    public static final AggregateMetric<Mass> CALCIUM_TOTAL;
    public static final AggregateMetric<Mass> CHLORIDE_TOTAL;
    public static final AggregateMetric<Mass> CHOLESTEROL_TOTAL;
    public static final AggregateMetric<Mass> CHROMIUM_TOTAL;
    public static final AggregateMetric<Mass> COPPER_TOTAL;
    public static final AggregateMetric<Mass> DIETARY_FIBER_TOTAL;
    public static final AggregateMetric<Energy> ENERGY_FROM_FAT_TOTAL;
    public static final AggregateMetric<Energy> ENERGY_TOTAL;
    public static final AggregateMetric<Mass> FOLATE_TOTAL;
    public static final AggregateMetric<Mass> FOLIC_ACID_TOTAL;
    public static final AggregateMetric<Mass> IODINE_TOTAL;
    public static final AggregateMetric<Mass> IRON_TOTAL;
    public static final AggregateMetric<Mass> MAGNESIUM_TOTAL;
    public static final AggregateMetric<Mass> MANGANESE_TOTAL;
    public static final AggregateMetric<Mass> MOLYBDENUM_TOTAL;
    public static final AggregateMetric<Mass> MONOUNSATURATED_FAT_TOTAL;
    public static final AggregateMetric<Mass> NIACIN_TOTAL;
    public static final AggregateMetric<Mass> PANTOTHENIC_ACID_TOTAL;
    public static final AggregateMetric<Mass> PHOSPHORUS_TOTAL;
    public static final AggregateMetric<Mass> POLYUNSATURATED_FAT_TOTAL;
    public static final AggregateMetric<Mass> POTASSIUM_TOTAL;
    public static final AggregateMetric<Mass> PROTEIN_TOTAL;
    public static final AggregateMetric<Mass> RIBOFLAVIN_TOTAL;
    public static final AggregateMetric<Mass> SATURATED_FAT_TOTAL;
    public static final AggregateMetric<Mass> SELENIUM_TOTAL;
    public static final AggregateMetric<Mass> SODIUM_TOTAL;
    public static final AggregateMetric<Mass> SUGAR_TOTAL;
    public static final AggregateMetric<Mass> THIAMIN_TOTAL;
    public static final AggregateMetric<Mass> TOTAL_CARBOHYDRATE_TOTAL;
    public static final AggregateMetric<Mass> TOTAL_FAT_TOTAL;
    public static final AggregateMetric<Mass> TRANS_FAT_TOTAL;
    public static final AggregateMetric<Mass> UNSATURATED_FAT_TOTAL;
    public static final AggregateMetric<Mass> VITAMIN_A_TOTAL;
    public static final AggregateMetric<Mass> VITAMIN_B12_TOTAL;
    public static final AggregateMetric<Mass> VITAMIN_B6_TOTAL;
    public static final AggregateMetric<Mass> VITAMIN_C_TOTAL;
    public static final AggregateMetric<Mass> VITAMIN_D_TOTAL;
    public static final AggregateMetric<Mass> VITAMIN_E_TOTAL;
    public static final AggregateMetric<Mass> VITAMIN_K_TOTAL;
    public static final AggregateMetric<Mass> ZINC_TOTAL;
    private final Mass biotin;
    private final Mass caffeine;
    private final Mass calcium;
    private final Mass chloride;
    private final Mass cholesterol;
    private final Mass chromium;
    private final Mass copper;
    private final Mass dietaryFiber;
    private final Instant endTime;
    private final ZoneOffset endZoneOffset;
    private final Energy energy;
    private final Energy energyFromFat;
    private final Mass folate;
    private final Mass folicAcid;
    private final Mass iodine;
    private final Mass iron;
    private final Mass magnesium;
    private final Mass manganese;
    private final int mealType;
    private final androidx.health.connect.client.records.metadata.Metadata metadata;
    private final Mass molybdenum;
    private final Mass monounsaturatedFat;
    private final String name;
    private final Mass niacin;
    private final Mass pantothenicAcid;
    private final Mass phosphorus;
    private final Mass polyunsaturatedFat;
    private final Mass potassium;
    private final Mass protein;
    private final Mass riboflavin;
    private final Mass saturatedFat;
    private final Mass selenium;
    private final Mass sodium;
    private final Instant startTime;
    private final ZoneOffset startZoneOffset;
    private final Mass sugar;
    private final Mass thiamin;
    private final Mass totalCarbohydrate;
    private final Mass totalFat;
    private final Mass transFat;
    private final Mass unsaturatedFat;
    private final Mass vitaminA;
    private final Mass vitaminB12;
    private final Mass vitaminB6;
    private final Mass vitaminC;
    private final Mass vitaminD;
    private final Mass vitaminE;
    private final Mass vitaminK;
    private final Mass zinc;
    private static final Mass MIN_MASS = MassKt.getGrams(0.0d);
    private static final Mass MAX_MASS_100 = MassKt.getGrams(4.94E-322d);
    private static final Mass MAX_MASS_100K = MassKt.getGrams(4.94066E-319d);
    private static final Energy MIN_ENERGY = EnergyKt.getCalories(0.0d);
    private static final Energy MAX_ENERGY = EnergyKt.getCalories(4.94065646E-316d);

    static {
        AggregateMetric.Companion companion = AggregateMetric.INSTANCE;
        AggregateMetric.AggregationType aggregationType = AggregateMetric.AggregationType.TOTAL;
        Mass.Companion companion2 = Mass.INSTANCE;
        BIOTIN_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "biotin", new NutritionRecord$Companion$BIOTIN_TOTAL$1(companion2));
        CAFFEINE_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "caffeine", new NutritionRecord$Companion$CAFFEINE_TOTAL$1(companion2));
        CALCIUM_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "calcium", new NutritionRecord$Companion$CALCIUM_TOTAL$1(companion2));
        Energy.Companion companion3 = Energy.INSTANCE;
        ENERGY_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "calories", new NutritionRecord$Companion$ENERGY_TOTAL$1(companion3));
        ENERGY_FROM_FAT_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "caloriesFromFat", new NutritionRecord$Companion$ENERGY_FROM_FAT_TOTAL$1(companion3));
        CHLORIDE_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "chloride", new NutritionRecord$Companion$CHLORIDE_TOTAL$1(companion2));
        CHOLESTEROL_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "cholesterol", new NutritionRecord$Companion$CHOLESTEROL_TOTAL$1(companion2));
        CHROMIUM_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "chromium", new NutritionRecord$Companion$CHROMIUM_TOTAL$1(companion2));
        COPPER_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "copper", new NutritionRecord$Companion$COPPER_TOTAL$1(companion2));
        DIETARY_FIBER_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "dietaryFiber", new NutritionRecord$Companion$DIETARY_FIBER_TOTAL$1(companion2));
        FOLATE_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "folate", new NutritionRecord$Companion$FOLATE_TOTAL$1(companion2));
        FOLIC_ACID_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "folicAcid", new NutritionRecord$Companion$FOLIC_ACID_TOTAL$1(companion2));
        IODINE_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "iodine", new NutritionRecord$Companion$IODINE_TOTAL$1(companion2));
        IRON_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "iron", new NutritionRecord$Companion$IRON_TOTAL$1(companion2));
        MAGNESIUM_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "magnesium", new NutritionRecord$Companion$MAGNESIUM_TOTAL$1(companion2));
        MANGANESE_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "manganese", new NutritionRecord$Companion$MANGANESE_TOTAL$1(companion2));
        MOLYBDENUM_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "molybdenum", new NutritionRecord$Companion$MOLYBDENUM_TOTAL$1(companion2));
        MONOUNSATURATED_FAT_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "monounsaturatedFat", new NutritionRecord$Companion$MONOUNSATURATED_FAT_TOTAL$1(companion2));
        NIACIN_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "niacin", new NutritionRecord$Companion$NIACIN_TOTAL$1(companion2));
        PANTOTHENIC_ACID_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "pantothenicAcid", new NutritionRecord$Companion$PANTOTHENIC_ACID_TOTAL$1(companion2));
        PHOSPHORUS_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "phosphorus", new NutritionRecord$Companion$PHOSPHORUS_TOTAL$1(companion2));
        POLYUNSATURATED_FAT_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "polyunsaturatedFat", new NutritionRecord$Companion$POLYUNSATURATED_FAT_TOTAL$1(companion2));
        POTASSIUM_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "potassium", new NutritionRecord$Companion$POTASSIUM_TOTAL$1(companion2));
        PROTEIN_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "protein", new NutritionRecord$Companion$PROTEIN_TOTAL$1(companion2));
        RIBOFLAVIN_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "riboflavin", new NutritionRecord$Companion$RIBOFLAVIN_TOTAL$1(companion2));
        SATURATED_FAT_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "saturatedFat", new NutritionRecord$Companion$SATURATED_FAT_TOTAL$1(companion2));
        SELENIUM_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "selenium", new NutritionRecord$Companion$SELENIUM_TOTAL$1(companion2));
        SODIUM_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "sodium", new NutritionRecord$Companion$SODIUM_TOTAL$1(companion2));
        SUGAR_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "sugar", new NutritionRecord$Companion$SUGAR_TOTAL$1(companion2));
        THIAMIN_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "thiamin", new NutritionRecord$Companion$THIAMIN_TOTAL$1(companion2));
        TOTAL_CARBOHYDRATE_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "totalCarbohydrate", new NutritionRecord$Companion$TOTAL_CARBOHYDRATE_TOTAL$1(companion2));
        TOTAL_FAT_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "totalFat", new NutritionRecord$Companion$TOTAL_FAT_TOTAL$1(companion2));
        TRANS_FAT_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "transFat", new NutritionRecord$Companion$TRANS_FAT_TOTAL$1(companion2));
        UNSATURATED_FAT_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "unsaturatedFat", new NutritionRecord$Companion$UNSATURATED_FAT_TOTAL$1(companion2));
        VITAMIN_A_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "vitaminA", new NutritionRecord$Companion$VITAMIN_A_TOTAL$1(companion2));
        VITAMIN_B12_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "vitaminB12", new NutritionRecord$Companion$VITAMIN_B12_TOTAL$1(companion2));
        VITAMIN_B6_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "vitaminB6", new NutritionRecord$Companion$VITAMIN_B6_TOTAL$1(companion2));
        VITAMIN_C_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "vitaminC", new NutritionRecord$Companion$VITAMIN_C_TOTAL$1(companion2));
        VITAMIN_D_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "vitaminD", new NutritionRecord$Companion$VITAMIN_D_TOTAL$1(companion2));
        VITAMIN_E_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "vitaminE", new NutritionRecord$Companion$VITAMIN_E_TOTAL$1(companion2));
        VITAMIN_K_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "vitaminK", new NutritionRecord$Companion$VITAMIN_K_TOTAL$1(companion2));
        ZINC_TOTAL = companion.doubleMetric$connect_client_release("Nutrition", aggregationType, "zinc", new NutritionRecord$Companion$ZINC_TOTAL$1(companion2));
    }

    public NutritionRecord(Instant instant, ZoneOffset zoneOffset, Instant instant2, ZoneOffset zoneOffset2, androidx.health.connect.client.records.metadata.Metadata metadata, Mass mass, Mass mass2, Mass mass3, Energy energy, Energy energy2, Mass mass4, Mass mass5, Mass mass6, Mass mass7, Mass mass8, Mass mass9, Mass mass10, Mass mass11, Mass mass12, Mass mass13, Mass mass14, Mass mass15, Mass mass16, Mass mass17, Mass mass18, Mass mass19, Mass mass20, Mass mass21, Mass mass22, Mass mass23, Mass mass24, Mass mass25, Mass mass26, Mass mass27, Mass mass28, Mass mass29, Mass mass30, Mass mass31, Mass mass32, Mass mass33, Mass mass34, Mass mass35, Mass mass36, Mass mass37, Mass mass38, Mass mass39, Mass mass40, String str, int i) {
        instant.getClass();
        instant2.getClass();
        metadata.getClass();
        this.startTime = instant;
        this.startZoneOffset = zoneOffset;
        this.endTime = instant2;
        this.endZoneOffset = zoneOffset2;
        this.metadata = metadata;
        this.biotin = mass;
        this.caffeine = mass2;
        this.calcium = mass3;
        this.energy = energy;
        this.energyFromFat = energy2;
        this.chloride = mass4;
        this.cholesterol = mass5;
        this.chromium = mass6;
        this.copper = mass7;
        this.dietaryFiber = mass8;
        this.folate = mass9;
        this.folicAcid = mass10;
        this.iodine = mass11;
        this.iron = mass12;
        this.magnesium = mass13;
        this.manganese = mass14;
        this.molybdenum = mass15;
        this.monounsaturatedFat = mass16;
        this.niacin = mass17;
        this.pantothenicAcid = mass18;
        this.phosphorus = mass19;
        this.polyunsaturatedFat = mass20;
        this.potassium = mass21;
        this.protein = mass22;
        this.riboflavin = mass23;
        this.saturatedFat = mass24;
        this.selenium = mass25;
        this.sodium = mass26;
        this.sugar = mass27;
        this.thiamin = mass28;
        this.totalCarbohydrate = mass29;
        this.totalFat = mass30;
        this.transFat = mass31;
        this.unsaturatedFat = mass32;
        this.vitaminA = mass33;
        this.vitaminB12 = mass34;
        this.vitaminB6 = mass35;
        this.vitaminC = mass36;
        this.vitaminD = mass37;
        this.vitaminE = mass38;
        this.vitaminK = mass39;
        this.zinc = mass40;
        this.name = str;
        this.mealType = i;
        if (!getStartTime().isBefore(getEndTime())) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("startTime must be before endTime.");
            throw null;
        }
        if (Build.VERSION.SDK_INT >= 34) {
            RecordConvertersKt.toPlatformRecord(this);
            return;
        }
        Mass mass41 = this.biotin;
        if (mass41 != null) {
            UtilsKt.requireInRange(mass41, MIN_MASS, MAX_MASS_100, "biotin");
        }
        Mass mass42 = this.caffeine;
        if (mass42 != null) {
            UtilsKt.requireInRange(mass42, MIN_MASS, MAX_MASS_100, "caffeine");
        }
        Mass mass43 = this.calcium;
        if (mass43 != null) {
            UtilsKt.requireInRange(mass43, MIN_MASS, MAX_MASS_100, "calcium");
        }
        Energy energy3 = this.energy;
        if (energy3 != null) {
            UtilsKt.requireInRange(energy3, MIN_ENERGY, MAX_ENERGY, "energy");
        }
        Energy energy4 = this.energyFromFat;
        if (energy4 != null) {
            UtilsKt.requireInRange(energy4, MIN_ENERGY, MAX_ENERGY, "energyFromFat");
        }
        Mass mass44 = this.chloride;
        if (mass44 != null) {
            UtilsKt.requireInRange(mass44, MIN_MASS, MAX_MASS_100, "chloride");
        }
        Mass mass45 = this.cholesterol;
        if (mass45 != null) {
            UtilsKt.requireInRange(mass45, MIN_MASS, MAX_MASS_100, "cholesterol");
        }
        Mass mass46 = this.chromium;
        if (mass46 != null) {
            UtilsKt.requireInRange(mass46, MIN_MASS, MAX_MASS_100, "chromium");
        }
        Mass mass47 = this.copper;
        if (mass47 != null) {
            UtilsKt.requireInRange(mass47, MIN_MASS, MAX_MASS_100, "copper");
        }
        Mass mass48 = this.dietaryFiber;
        if (mass48 != null) {
            UtilsKt.requireInRange(mass48, MIN_MASS, MAX_MASS_100K, "dietaryFiber");
        }
        Mass mass49 = this.folate;
        if (mass49 != null) {
            UtilsKt.requireInRange(mass49, MIN_MASS, MAX_MASS_100, "chloride");
        }
        Mass mass50 = this.folicAcid;
        if (mass50 != null) {
            UtilsKt.requireInRange(mass50, MIN_MASS, MAX_MASS_100, "folicAcid");
        }
        Mass mass51 = this.iodine;
        if (mass51 != null) {
            UtilsKt.requireInRange(mass51, MIN_MASS, MAX_MASS_100, "iodine");
        }
        Mass mass52 = this.iron;
        if (mass52 != null) {
            UtilsKt.requireInRange(mass52, MIN_MASS, MAX_MASS_100, "iron");
        }
        Mass mass53 = this.magnesium;
        if (mass53 != null) {
            UtilsKt.requireInRange(mass53, MIN_MASS, MAX_MASS_100, "magnesium");
        }
        Mass mass54 = this.manganese;
        if (mass54 != null) {
            UtilsKt.requireInRange(mass54, MIN_MASS, MAX_MASS_100, "manganese");
        }
        Mass mass55 = this.molybdenum;
        if (mass55 != null) {
            UtilsKt.requireInRange(mass55, MIN_MASS, MAX_MASS_100, "molybdenum");
        }
        if (mass16 != null) {
            UtilsKt.requireInRange(mass16, MIN_MASS, MAX_MASS_100K, "monounsaturatedFat");
        }
        if (mass17 != null) {
            UtilsKt.requireInRange(mass17, MIN_MASS, MAX_MASS_100, "niacin");
        }
        if (mass18 != null) {
            UtilsKt.requireInRange(mass18, MIN_MASS, MAX_MASS_100, "pantothenicAcid");
        }
        if (mass19 != null) {
            UtilsKt.requireInRange(mass19, MIN_MASS, MAX_MASS_100, "phosphorus");
        }
        if (mass20 != null) {
            UtilsKt.requireInRange(mass20, MIN_MASS, MAX_MASS_100K, "polyunsaturatedFat");
        }
        if (mass21 != null) {
            UtilsKt.requireInRange(mass21, MIN_MASS, MAX_MASS_100, "potassium");
        }
        if (mass22 != null) {
            UtilsKt.requireInRange(mass22, MIN_MASS, MAX_MASS_100K, "protein");
        }
        if (mass23 != null) {
            UtilsKt.requireInRange(mass23, MIN_MASS, MAX_MASS_100, "riboflavin");
        }
        if (mass24 != null) {
            UtilsKt.requireInRange(mass24, MIN_MASS, MAX_MASS_100K, "saturatedFat");
        }
        if (mass25 != null) {
            UtilsKt.requireInRange(mass25, MIN_MASS, MAX_MASS_100, "selenium");
        }
        if (mass26 != null) {
            UtilsKt.requireInRange(mass26, MIN_MASS, MAX_MASS_100, "sodium");
        }
        if (mass27 != null) {
            UtilsKt.requireInRange(mass27, MIN_MASS, MAX_MASS_100K, "sugar");
        }
        if (mass28 != null) {
            UtilsKt.requireInRange(mass28, MIN_MASS, MAX_MASS_100, "thiamin");
        }
        if (mass29 != null) {
            UtilsKt.requireInRange(mass29, MIN_MASS, MAX_MASS_100K, "totalCarbohydrate");
        }
        if (mass30 != null) {
            UtilsKt.requireInRange(mass30, MIN_MASS, MAX_MASS_100K, "totalFat");
        }
        if (mass31 != null) {
            UtilsKt.requireInRange(mass31, MIN_MASS, MAX_MASS_100K, "transFat");
        }
        if (mass32 != null) {
            UtilsKt.requireInRange(mass32, MIN_MASS, MAX_MASS_100K, "unsaturatedFat");
        }
        if (mass33 != null) {
            UtilsKt.requireInRange(mass33, MIN_MASS, MAX_MASS_100, "vitaminA");
        }
        if (mass34 != null) {
            UtilsKt.requireInRange(mass34, MIN_MASS, MAX_MASS_100, "vitaminB12");
        }
        if (mass35 != null) {
            UtilsKt.requireInRange(mass35, MIN_MASS, MAX_MASS_100, "vitaminB6");
        }
        if (mass36 != null) {
            UtilsKt.requireInRange(mass36, MIN_MASS, MAX_MASS_100, "vitaminC");
        }
        if (mass37 != null) {
            UtilsKt.requireInRange(mass37, MIN_MASS, MAX_MASS_100, "vitaminD");
        }
        if (mass38 != null) {
            UtilsKt.requireInRange(mass38, MIN_MASS, MAX_MASS_100, "vitaminE");
        }
        if (mass39 != null) {
            UtilsKt.requireInRange(mass39, MIN_MASS, MAX_MASS_100, "vitaminK");
        }
        if (mass40 != null) {
            UtilsKt.requireInRange(mass40, MIN_MASS, MAX_MASS_100, "zinc");
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NutritionRecord)) {
            return false;
        }
        NutritionRecord nutritionRecord = (NutritionRecord) other;
        return Intrinsics.areEqual(this.biotin, nutritionRecord.biotin) && Intrinsics.areEqual(this.caffeine, nutritionRecord.caffeine) && Intrinsics.areEqual(this.calcium, nutritionRecord.calcium) && Intrinsics.areEqual(this.energy, nutritionRecord.energy) && Intrinsics.areEqual(this.energyFromFat, nutritionRecord.energyFromFat) && Intrinsics.areEqual(this.chloride, nutritionRecord.chloride) && Intrinsics.areEqual(this.cholesterol, nutritionRecord.cholesterol) && Intrinsics.areEqual(this.chromium, nutritionRecord.chromium) && Intrinsics.areEqual(this.copper, nutritionRecord.copper) && Intrinsics.areEqual(this.dietaryFiber, nutritionRecord.dietaryFiber) && Intrinsics.areEqual(this.folate, nutritionRecord.folate) && Intrinsics.areEqual(this.folicAcid, nutritionRecord.folicAcid) && Intrinsics.areEqual(this.iodine, nutritionRecord.iodine) && Intrinsics.areEqual(this.iron, nutritionRecord.iron) && Intrinsics.areEqual(this.magnesium, nutritionRecord.magnesium) && Intrinsics.areEqual(this.manganese, nutritionRecord.manganese) && Intrinsics.areEqual(this.molybdenum, nutritionRecord.molybdenum) && Intrinsics.areEqual(this.monounsaturatedFat, nutritionRecord.monounsaturatedFat) && Intrinsics.areEqual(this.niacin, nutritionRecord.niacin) && Intrinsics.areEqual(this.pantothenicAcid, nutritionRecord.pantothenicAcid) && Intrinsics.areEqual(this.phosphorus, nutritionRecord.phosphorus) && Intrinsics.areEqual(this.polyunsaturatedFat, nutritionRecord.polyunsaturatedFat) && Intrinsics.areEqual(this.potassium, nutritionRecord.potassium) && Intrinsics.areEqual(this.protein, nutritionRecord.protein) && Intrinsics.areEqual(this.riboflavin, nutritionRecord.riboflavin) && Intrinsics.areEqual(this.saturatedFat, nutritionRecord.saturatedFat) && Intrinsics.areEqual(this.selenium, nutritionRecord.selenium) && Intrinsics.areEqual(this.sodium, nutritionRecord.sodium) && Intrinsics.areEqual(this.sugar, nutritionRecord.sugar) && Intrinsics.areEqual(this.thiamin, nutritionRecord.thiamin) && Intrinsics.areEqual(this.totalCarbohydrate, nutritionRecord.totalCarbohydrate) && Intrinsics.areEqual(this.totalFat, nutritionRecord.totalFat) && Intrinsics.areEqual(this.transFat, nutritionRecord.transFat) && Intrinsics.areEqual(this.unsaturatedFat, nutritionRecord.unsaturatedFat) && Intrinsics.areEqual(this.vitaminA, nutritionRecord.vitaminA) && Intrinsics.areEqual(this.vitaminB12, nutritionRecord.vitaminB12) && Intrinsics.areEqual(this.vitaminB6, nutritionRecord.vitaminB6) && Intrinsics.areEqual(this.vitaminC, nutritionRecord.vitaminC) && Intrinsics.areEqual(this.vitaminD, nutritionRecord.vitaminD) && Intrinsics.areEqual(this.vitaminE, nutritionRecord.vitaminE) && Intrinsics.areEqual(this.vitaminK, nutritionRecord.vitaminK) && Intrinsics.areEqual(this.zinc, nutritionRecord.zinc) && Intrinsics.areEqual(this.name, nutritionRecord.name) && this.mealType == nutritionRecord.mealType && Intrinsics.areEqual(getStartTime(), nutritionRecord.getStartTime()) && Intrinsics.areEqual(getStartZoneOffset(), nutritionRecord.getStartZoneOffset()) && Intrinsics.areEqual(getEndTime(), nutritionRecord.getEndTime()) && Intrinsics.areEqual(getEndZoneOffset(), nutritionRecord.getEndZoneOffset()) && Intrinsics.areEqual(getMetadata(), nutritionRecord.getMetadata());
    }

    public final Mass getBiotin() {
        return this.biotin;
    }

    public final Mass getCaffeine() {
        return this.caffeine;
    }

    public final Mass getCalcium() {
        return this.calcium;
    }

    public final Mass getChloride() {
        return this.chloride;
    }

    public final Mass getCholesterol() {
        return this.cholesterol;
    }

    public final Mass getChromium() {
        return this.chromium;
    }

    public final Mass getCopper() {
        return this.copper;
    }

    public final Mass getDietaryFiber() {
        return this.dietaryFiber;
    }

    @Override // androidx.health.connect.client.records.IntervalRecord
    public Instant getEndTime() {
        return this.endTime;
    }

    @Override // androidx.health.connect.client.records.IntervalRecord
    public ZoneOffset getEndZoneOffset() {
        return this.endZoneOffset;
    }

    public final Energy getEnergy() {
        return this.energy;
    }

    public final Energy getEnergyFromFat() {
        return this.energyFromFat;
    }

    public final Mass getFolate() {
        return this.folate;
    }

    public final Mass getFolicAcid() {
        return this.folicAcid;
    }

    public final Mass getIodine() {
        return this.iodine;
    }

    public final Mass getIron() {
        return this.iron;
    }

    public final Mass getMagnesium() {
        return this.magnesium;
    }

    public final Mass getManganese() {
        return this.manganese;
    }

    public final int getMealType() {
        return this.mealType;
    }

    @Override // androidx.health.connect.client.records.Record
    public androidx.health.connect.client.records.metadata.Metadata getMetadata() {
        return this.metadata;
    }

    public final Mass getMolybdenum() {
        return this.molybdenum;
    }

    public final Mass getMonounsaturatedFat() {
        return this.monounsaturatedFat;
    }

    public final String getName() {
        return this.name;
    }

    public final Mass getNiacin() {
        return this.niacin;
    }

    public final Mass getPantothenicAcid() {
        return this.pantothenicAcid;
    }

    public final Mass getPhosphorus() {
        return this.phosphorus;
    }

    public final Mass getPolyunsaturatedFat() {
        return this.polyunsaturatedFat;
    }

    public final Mass getPotassium() {
        return this.potassium;
    }

    public final Mass getProtein() {
        return this.protein;
    }

    public final Mass getRiboflavin() {
        return this.riboflavin;
    }

    public final Mass getSaturatedFat() {
        return this.saturatedFat;
    }

    public final Mass getSelenium() {
        return this.selenium;
    }

    public final Mass getSodium() {
        return this.sodium;
    }

    @Override // androidx.health.connect.client.records.IntervalRecord
    public Instant getStartTime() {
        return this.startTime;
    }

    @Override // androidx.health.connect.client.records.IntervalRecord
    public ZoneOffset getStartZoneOffset() {
        return this.startZoneOffset;
    }

    public final Mass getSugar() {
        return this.sugar;
    }

    public final Mass getThiamin() {
        return this.thiamin;
    }

    public final Mass getTotalCarbohydrate() {
        return this.totalCarbohydrate;
    }

    public final Mass getTotalFat() {
        return this.totalFat;
    }

    public final Mass getTransFat() {
        return this.transFat;
    }

    public final Mass getUnsaturatedFat() {
        return this.unsaturatedFat;
    }

    public final Mass getVitaminA() {
        return this.vitaminA;
    }

    public final Mass getVitaminB12() {
        return this.vitaminB12;
    }

    public final Mass getVitaminB6() {
        return this.vitaminB6;
    }

    public final Mass getVitaminC() {
        return this.vitaminC;
    }

    public final Mass getVitaminD() {
        return this.vitaminD;
    }

    public final Mass getVitaminE() {
        return this.vitaminE;
    }

    public final Mass getVitaminK() {
        return this.vitaminK;
    }

    public final Mass getZinc() {
        return this.zinc;
    }

    public int hashCode() {
        Mass mass = this.biotin;
        int iHashCode = (mass != null ? mass.hashCode() : 0) * 31;
        Mass mass2 = this.caffeine;
        int iHashCode2 = (iHashCode + (mass2 != null ? mass2.hashCode() : 0)) * 31;
        Mass mass3 = this.calcium;
        int iHashCode3 = (iHashCode2 + (mass3 != null ? mass3.hashCode() : 0)) * 31;
        Energy energy = this.energy;
        int iHashCode4 = (iHashCode3 + (energy != null ? energy.hashCode() : 0)) * 31;
        Energy energy2 = this.energyFromFat;
        int iHashCode5 = (iHashCode4 + (energy2 != null ? energy2.hashCode() : 0)) * 31;
        Mass mass4 = this.chloride;
        int iHashCode6 = (iHashCode5 + (mass4 != null ? mass4.hashCode() : 0)) * 31;
        Mass mass5 = this.cholesterol;
        int iHashCode7 = (iHashCode6 + (mass5 != null ? mass5.hashCode() : 0)) * 31;
        Mass mass6 = this.chromium;
        int iHashCode8 = (iHashCode7 + (mass6 != null ? mass6.hashCode() : 0)) * 31;
        Mass mass7 = this.copper;
        int iHashCode9 = (iHashCode8 + (mass7 != null ? mass7.hashCode() : 0)) * 31;
        Mass mass8 = this.dietaryFiber;
        int iHashCode10 = (iHashCode9 + (mass8 != null ? mass8.hashCode() : 0)) * 31;
        Mass mass9 = this.folate;
        int iHashCode11 = (iHashCode10 + (mass9 != null ? mass9.hashCode() : 0)) * 31;
        Mass mass10 = this.folicAcid;
        int iHashCode12 = (iHashCode11 + (mass10 != null ? mass10.hashCode() : 0)) * 31;
        Mass mass11 = this.iodine;
        int iHashCode13 = (iHashCode12 + (mass11 != null ? mass11.hashCode() : 0)) * 31;
        Mass mass12 = this.iron;
        int iHashCode14 = (iHashCode13 + (mass12 != null ? mass12.hashCode() : 0)) * 31;
        Mass mass13 = this.magnesium;
        int iHashCode15 = (iHashCode14 + (mass13 != null ? mass13.hashCode() : 0)) * 31;
        Mass mass14 = this.manganese;
        int iHashCode16 = (iHashCode15 + (mass14 != null ? mass14.hashCode() : 0)) * 31;
        Mass mass15 = this.molybdenum;
        int iHashCode17 = (iHashCode16 + (mass15 != null ? mass15.hashCode() : 0)) * 31;
        Mass mass16 = this.monounsaturatedFat;
        int iHashCode18 = (iHashCode17 + (mass16 != null ? mass16.hashCode() : 0)) * 31;
        Mass mass17 = this.niacin;
        int iHashCode19 = (iHashCode18 + (mass17 != null ? mass17.hashCode() : 0)) * 31;
        Mass mass18 = this.pantothenicAcid;
        int iHashCode20 = (iHashCode19 + (mass18 != null ? mass18.hashCode() : 0)) * 31;
        Mass mass19 = this.phosphorus;
        int iHashCode21 = (iHashCode20 + (mass19 != null ? mass19.hashCode() : 0)) * 31;
        Mass mass20 = this.polyunsaturatedFat;
        int iHashCode22 = (iHashCode21 + (mass20 != null ? mass20.hashCode() : 0)) * 31;
        Mass mass21 = this.potassium;
        int iHashCode23 = (iHashCode22 + (mass21 != null ? mass21.hashCode() : 0)) * 31;
        Mass mass22 = this.protein;
        int iHashCode24 = (iHashCode23 + (mass22 != null ? mass22.hashCode() : 0)) * 31;
        Mass mass23 = this.riboflavin;
        int iHashCode25 = (iHashCode24 + (mass23 != null ? mass23.hashCode() : 0)) * 31;
        Mass mass24 = this.saturatedFat;
        int iHashCode26 = (iHashCode25 + (mass24 != null ? mass24.hashCode() : 0)) * 31;
        Mass mass25 = this.selenium;
        int iHashCode27 = (iHashCode26 + (mass25 != null ? mass25.hashCode() : 0)) * 31;
        Mass mass26 = this.sodium;
        int iHashCode28 = (iHashCode27 + (mass26 != null ? mass26.hashCode() : 0)) * 31;
        Mass mass27 = this.sugar;
        int iHashCode29 = (iHashCode28 + (mass27 != null ? mass27.hashCode() : 0)) * 31;
        Mass mass28 = this.thiamin;
        int iHashCode30 = (iHashCode29 + (mass28 != null ? mass28.hashCode() : 0)) * 31;
        Mass mass29 = this.totalCarbohydrate;
        int iHashCode31 = (iHashCode30 + (mass29 != null ? mass29.hashCode() : 0)) * 31;
        Mass mass30 = this.totalFat;
        int iHashCode32 = (iHashCode31 + (mass30 != null ? mass30.hashCode() : 0)) * 31;
        Mass mass31 = this.transFat;
        int iHashCode33 = (iHashCode32 + (mass31 != null ? mass31.hashCode() : 0)) * 31;
        Mass mass32 = this.unsaturatedFat;
        int iHashCode34 = (iHashCode33 + (mass32 != null ? mass32.hashCode() : 0)) * 31;
        Mass mass33 = this.vitaminA;
        int iHashCode35 = (iHashCode34 + (mass33 != null ? mass33.hashCode() : 0)) * 31;
        Mass mass34 = this.vitaminB12;
        int iHashCode36 = (iHashCode35 + (mass34 != null ? mass34.hashCode() : 0)) * 31;
        Mass mass35 = this.vitaminB6;
        int iHashCode37 = (iHashCode36 + (mass35 != null ? mass35.hashCode() : 0)) * 31;
        Mass mass36 = this.vitaminC;
        int iHashCode38 = (iHashCode37 + (mass36 != null ? mass36.hashCode() : 0)) * 31;
        Mass mass37 = this.vitaminD;
        int iHashCode39 = (iHashCode38 + (mass37 != null ? mass37.hashCode() : 0)) * 31;
        Mass mass38 = this.vitaminE;
        int iHashCode40 = (iHashCode39 + (mass38 != null ? mass38.hashCode() : 0)) * 31;
        Mass mass39 = this.vitaminK;
        int iHashCode41 = (iHashCode40 + (mass39 != null ? mass39.hashCode() : 0)) * 31;
        Mass mass40 = this.zinc;
        int iHashCode42 = (iHashCode41 + (mass40 != null ? mass40.hashCode() : 0)) * 31;
        String str = this.name;
        int iHashCode43 = (getStartTime().hashCode() + ((((iHashCode42 + (str != null ? str.hashCode() : 0)) * 31) + this.mealType) * 31)) * 31;
        ZoneOffset startZoneOffset = getStartZoneOffset();
        int iHashCode44 = (getEndTime().hashCode() + ((iHashCode43 + (startZoneOffset != null ? startZoneOffset.hashCode() : 0)) * 31)) * 31;
        ZoneOffset endZoneOffset = getEndZoneOffset();
        return getMetadata().hashCode() + ((iHashCode44 + (endZoneOffset != null ? endZoneOffset.hashCode() : 0)) * 31);
    }

    public String toString() {
        return "NutritionRecord(startTime=" + getStartTime() + ", startZoneOffset=" + getStartZoneOffset() + ", endTime=" + getEndTime() + ", endZoneOffset=" + getEndZoneOffset() + ", biotin=" + this.biotin + ", caffeine=" + this.caffeine + ", calcium=" + this.calcium + ", energy=" + this.energy + ", energyFromFat=" + this.energyFromFat + ", chloride=" + this.chloride + ", cholesterol=" + this.cholesterol + ", chromium=" + this.chromium + ", copper=" + this.copper + ", dietaryFiber=" + this.dietaryFiber + ", folate=" + this.folate + ", folicAcid=" + this.folicAcid + ", iodine=" + this.iodine + ", iron=" + this.iron + ", magnesium=" + this.magnesium + ", manganese=" + this.manganese + ", molybdenum=" + this.molybdenum + ", monounsaturatedFat=" + this.monounsaturatedFat + ", niacin=" + this.niacin + ", pantothenicAcid=" + this.pantothenicAcid + ", phosphorus=" + this.phosphorus + ", polyunsaturatedFat=" + this.polyunsaturatedFat + ", potassium=" + this.potassium + ", protein=" + this.protein + ", riboflavin=" + this.riboflavin + ", saturatedFat=" + this.saturatedFat + ", selenium=" + this.selenium + ", sodium=" + this.sodium + ", sugar=" + this.sugar + ", thiamin=" + this.thiamin + ", totalCarbohydrate=" + this.totalCarbohydrate + ", totalFat=" + this.totalFat + ", transFat=" + this.transFat + ", unsaturatedFat=" + this.unsaturatedFat + ", vitaminA=" + this.vitaminA + ", vitaminB12=" + this.vitaminB12 + ", vitaminB6=" + this.vitaminB6 + ", vitaminC=" + this.vitaminC + ", vitaminD=" + this.vitaminD + ", vitaminE=" + this.vitaminE + ", vitaminK=" + this.vitaminK + ", zinc=" + this.zinc + ", name=" + this.name + ", mealType=" + this.mealType + ", metadata=" + getMetadata() + ')';
    }
}
