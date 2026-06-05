package com.google.android.gms.internal.serialization;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.home.Descriptor;
import com.google.home.FactoryRegistry;
import com.google.home.Field;
import com.google.home.HomeException;
import com.google.home.HomeManager;
import com.google.home.StructDescriptor;
import com.google.home.Trait;
import com.google.home.TraitFactory;
import com.google.home.automation.BaseUnit;
import com.google.home.automation.BitmapConstraint;
import com.google.home.automation.BooleanConstraint;
import com.google.home.automation.Constraint;
import com.google.home.automation.ConstraintUnit;
import com.google.home.automation.EnumConstraint;
import com.google.home.automation.MissingPresenceSensingSetup;
import com.google.home.automation.MissingStructureAddressSetup;
import com.google.home.automation.MissingSubscription;
import com.google.home.automation.NumberRangeConstraint;
import com.google.home.automation.NumberSetConstraint;
import com.google.home.automation.StringConstraint;
import com.google.home.automation.StructConstraint;
import com.google.home.automation.UnsupportedCandidateReason;
import com.google.home.google.PlatformTraitFactory;
import com.google.home.google.TimeTrait$SolarTimeType;
import com.google.home.matter.MatterTraitFactory;
import com.google.home.matter.serialization.EnumAdapter;
import com.google.home.platform.traits.ByteConstraint;
import com.google.home.platform.traits.CombinedBitsDescriptor;
import com.google.home.platform.traits.DoubleRangeConstraint;
import com.google.home.platform.traits.IntRangeConstraint;
import com.google.home.platform.traits.ListConstraint;
import com.google.home.platform.traits.MissingPresenceSensingSetup;
import com.google.home.platform.traits.StringAllowListConstraint;
import com.google.home.platform.traits.StructFieldConstraint;
import com.google.home.platform.traits.UIntRangeConstraint;
import com.google.home.platform.traits.UIntSetConstraint;
import com.google.home.platform.traits.UnsupportedCandidateReason;
import com.google.home.platform.traits.ValueTypeConstraint;
import com.google.home.platform.traits.metadata.Unit;
import j$.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J#\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\f\u001a\u00020\u000b*\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\f\u001a\u00020\u000b*\u00020\u000eH\u0002¢\u0006\u0004\b\f\u0010\u000fJ#\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013*\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\f\u0010\u0015J#\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013*\u00020\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\f\u0010\u0017J#\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00190\u0013*\u00020\u00182\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\f\u0010\u001aJ+\u0010\f\u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u00140\u00140\u001c*\u00020\u001b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\f\u0010\u001eJ%\u0010\f\u001a\u0004\u0018\u00010 *\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010!J'\u0010\f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030$0#*\u00020\"2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010%J\u0013\u0010\f\u001a\u00020'*\u00020&H\u0002¢\u0006\u0004\b\f\u0010(J\u0013\u0010\f\u001a\u00020**\u00020)H\u0002¢\u0006\u0004\b\f\u0010+J\u0013\u0010\f\u001a\u00020-*\u00020,H\u0002¢\u0006\u0004\b\f\u0010.J#\u0010\f\u001a\u000200*\u00020/2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u00101J\u0013\u0010\f\u001a\u0004\u0018\u000103*\u000202¢\u0006\u0004\b\f\u00104J\u0013\u0010\f\u001a\u0004\u0018\u000106*\u000205¢\u0006\u0004\b\f\u00107J\u0013\u0010\f\u001a\u0004\u0018\u00010\u0011*\u000208¢\u0006\u0004\b\f\u00109J\u0013\u0010\f\u001a\u0004\u0018\u00010;*\u00020:¢\u0006\u0004\b\f\u0010<J\u0011\u0010>\u001a\u00020=*\u00020=¢\u0006\u0004\b>\u0010?J\u0011\u0010@\u001a\u00020=*\u00020=¢\u0006\u0004\b@\u0010?J\u0019\u0010B\u001a\u00020=*\b\u0012\u0004\u0012\u00020=0AH\u0002¢\u0006\u0004\bB\u0010C¨\u0006D"}, d2 = {"Lcom/google/home/automation/serialization/AutomationCandidateConverter$Companion;", "", "Lcom/google/home/platform/traits/ValueTypeConstraint;", "Lcom/google/home/HomeManager;", "homeManager", "Lcom/google/home/Field;", "field", "Lcom/google/home/automation/Constraint;", "fromConstraintProto", "(Lcom/google/home/platform/traits/ValueTypeConstraint;Lcom/google/home/HomeManager;Lcom/google/home/Field;)Lcom/google/home/automation/Constraint;", "Lcom/google/home/platform/traits/StringConstraint;", "Lcom/google/home/automation/StringConstraint;", "fromProto", "(Lcom/google/home/platform/traits/StringConstraint;)Lcom/google/home/automation/StringConstraint;", "Lcom/google/home/platform/traits/StringAllowListConstraint;", "(Lcom/google/home/platform/traits/StringAllowListConstraint;)Lcom/google/home/automation/StringConstraint;", "Lcom/google/home/platform/traits/IntRangeConstraint;", "Lcom/google/home/automation/ConstraintUnit;", "unit", "Lcom/google/home/automation/NumberRangeConstraint;", "", "(Lcom/google/home/platform/traits/IntRangeConstraint;Lcom/google/home/automation/ConstraintUnit;)Lcom/google/home/automation/NumberRangeConstraint;", "Lcom/google/home/platform/traits/UIntRangeConstraint;", "(Lcom/google/home/platform/traits/UIntRangeConstraint;Lcom/google/home/automation/ConstraintUnit;)Lcom/google/home/automation/NumberRangeConstraint;", "Lcom/google/home/platform/traits/DoubleRangeConstraint;", "", "(Lcom/google/home/platform/traits/DoubleRangeConstraint;Lcom/google/home/automation/ConstraintUnit;)Lcom/google/home/automation/NumberRangeConstraint;", "Lcom/google/home/platform/traits/UIntSetConstraint;", "Lcom/google/home/automation/NumberSetConstraint;", "kotlin.jvm.PlatformType", "(Lcom/google/home/platform/traits/UIntSetConstraint;Lcom/google/home/automation/ConstraintUnit;)Lcom/google/home/automation/NumberSetConstraint;", "Lcom/google/home/platform/traits/ListConstraint;", "Lcom/google/home/automation/ListConstraint;", "(Lcom/google/home/platform/traits/ListConstraint;Lcom/google/home/HomeManager;Lcom/google/home/Field;)Lcom/google/home/automation/ListConstraint;", "Lcom/google/home/platform/traits/EnumConstraint;", "Lcom/google/home/automation/EnumConstraint;", "", "(Lcom/google/home/platform/traits/EnumConstraint;Lcom/google/home/HomeManager;)Lcom/google/home/automation/EnumConstraint;", "Lcom/google/home/platform/traits/BitmapConstraint;", "Lcom/google/home/automation/BitmapConstraint;", "(Lcom/google/home/platform/traits/BitmapConstraint;)Lcom/google/home/automation/BitmapConstraint;", "Lcom/google/home/platform/traits/ByteConstraint;", "Lcom/google/home/automation/ByteConstraint;", "(Lcom/google/home/platform/traits/ByteConstraint;)Lcom/google/home/automation/ByteConstraint;", "Lcom/google/home/platform/traits/CombinedBitsDescriptor;", "Lcom/google/home/automation/CombinedBitsDescriptor;", "(Lcom/google/home/platform/traits/CombinedBitsDescriptor;)Lcom/google/home/automation/CombinedBitsDescriptor;", "Lcom/google/home/platform/traits/StructConstraint;", "Lcom/google/home/automation/StructConstraint;", "(Lcom/google/home/platform/traits/StructConstraint;Lcom/google/home/HomeManager;Lcom/google/home/Field;)Lcom/google/home/automation/StructConstraint;", "Lcom/google/home/platform/traits/UnsupportedCandidateReason;", "Lcom/google/home/automation/UnsupportedCandidateReason;", "(Lcom/google/home/platform/traits/UnsupportedCandidateReason;)Lcom/google/home/automation/UnsupportedCandidateReason;", "Lcom/google/home/platform/traits/MissingPresenceSensingSetup;", "Lcom/google/home/automation/MissingPresenceSensingSetup;", "(Lcom/google/home/platform/traits/MissingPresenceSensingSetup;)Lcom/google/home/automation/MissingPresenceSensingSetup;", "Lcom/google/home/platform/traits/metadata/Unit;", "(Lcom/google/home/platform/traits/metadata/Unit;)Lcom/google/home/automation/ConstraintUnit;", "Lcom/google/home/platform/traits/metadata/BaseUnit;", "Lcom/google/home/automation/BaseUnit;", "(Lcom/google/home/platform/traits/metadata/BaseUnit;)Lcom/google/home/automation/BaseUnit;", "", "toUpperCamelCase", "(Ljava/lang/String;)Ljava/lang/String;", "toLowerCamelCase", "", "joinToCamelCaseString", "(Ljava/util/List;)Ljava/lang/String;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzkd {
    public /* synthetic */ zzkd(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public static final UnsupportedCandidateReason zzb(com.google.home.platform.traits.UnsupportedCandidateReason unsupportedCandidateReason) throws HomeException {
        unsupportedCandidateReason.getClass();
        UnsupportedCandidateReason.ReasonCase reasonCase = unsupportedCandidateReason.getReasonCase();
        ValueTypeConstraint.ConstraintCase constraintCase = ValueTypeConstraint.ConstraintCase.BOOLEAN_CONSTRAINT;
        UnsupportedCandidateReason.ReasonCase reasonCase2 = UnsupportedCandidateReason.ReasonCase.MISSING_STRUCTURE_ADDRESS_SETUP;
        MissingPresenceSensingSetup.SetupType setupType = MissingPresenceSensingSetup.SetupType.UNSPECIFIED;
        int iOrdinal = reasonCase.ordinal();
        if (iOrdinal == 0) {
            return new MissingStructureAddressSetup();
        }
        if (iOrdinal == 1) {
            MissingPresenceSensingSetup missingPresenceSensingSetup = unsupportedCandidateReason.getMissingPresenceSensingSetup();
            missingPresenceSensingSetup.getClass();
            missingPresenceSensingSetup.getClass();
            int iOrdinal2 = missingPresenceSensingSetup.getType().ordinal();
            return iOrdinal2 != 0 ? iOrdinal2 != 1 ? iOrdinal2 != 2 ? new com.google.home.automation.MissingPresenceSensingSetup(MissingPresenceSensingSetup.SetupType.UNSPECIFIED) : new com.google.home.automation.MissingPresenceSensingSetup(MissingPresenceSensingSetup.SetupType.USER_PRESENCE) : new com.google.home.automation.MissingPresenceSensingSetup(MissingPresenceSensingSetup.SetupType.STRUCTURE_PRESENCE) : new com.google.home.automation.MissingPresenceSensingSetup(MissingPresenceSensingSetup.SetupType.UNSPECIFIED);
        }
        if (iOrdinal == 2) {
            return new MissingSubscription();
        }
        if (iOrdinal == 3) {
            return null;
        }
        HomeException.Companion companion = HomeException.INSTANCE;
        StringBuilder sb = new StringBuilder(String.valueOf(unsupportedCandidateReason).length() + 31);
        sb.append("Unsupported reason: ");
        sb.append(unsupportedCandidateReason);
        sb.append(".reasonCase");
        throw companion.invalidArgument(sb.toString());
    }

    public static final String zzc(String str) {
        str.getClass();
        String lowerCase = str.toLowerCase(Locale.ROOT);
        lowerCase.getClass();
        return zzj(StringsKt.split$default(lowerCase, new String[]{"_"}, 0, 6));
    }

    private static final BitmapConstraint zzd(com.google.home.platform.traits.BitmapConstraint bitmapConstraint) {
        List<CombinedBitsDescriptor> combinedBitsList = bitmapConstraint.getCombinedBitsList();
        combinedBitsList.getClass();
        List<CombinedBitsDescriptor> list = combinedBitsList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (CombinedBitsDescriptor combinedBitsDescriptor : list) {
            combinedBitsDescriptor.getClass();
            int iM2389constructorimpl = UInt.m2389constructorimpl(combinedBitsDescriptor.getBitPositionStart());
            int iM2389constructorimpl2 = UInt.m2389constructorimpl(combinedBitsDescriptor.getBitPositionEnd());
            String name = combinedBitsDescriptor.getName();
            name.getClass();
            String strZzc = zzc(name);
            if (strZzc.length() > 0) {
                char lowerCase = Character.toLowerCase(strZzc.charAt(0));
                String strSubstring = strZzc.substring(1);
                StringBuilder sb = new StringBuilder(String.valueOf(lowerCase).length() + strSubstring.length());
                sb.append(lowerCase);
                sb.append(strSubstring);
                strZzc = sb.toString();
            }
            arrayList.add(new com.google.home.automation.CombinedBitsDescriptor(iM2389constructorimpl, iM2389constructorimpl2, strZzc, null));
        }
        return new BitmapConstraint(arrayList);
    }

    private static final EnumConstraint zze(com.google.home.platform.traits.EnumConstraint enumConstraint, HomeManager homeManager) throws HomeException {
        Enum r9;
        String typeId = enumConstraint.getTypeId();
        int iHashCode = typeId.hashCode();
        if (iHashCode != -1441256706) {
            if (iHashCode == 1365625768 && typeId.equals("google.type.DayOfWeek")) {
                Collection<Integer> collectionValues = enumConstraint.getEnumValuesMap().values();
                ArrayList<Integer> arrayList = new ArrayList();
                for (Object obj : collectionValues) {
                    Integer num = (Integer) obj;
                    if (num.intValue() > 0 && num.intValue() <= 7) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
                for (Integer num2 : arrayList) {
                    num2.getClass();
                    arrayList2.add(DayOfWeek.of(num2.intValue()));
                }
                return new EnumConstraint(CollectionsKt.toSet(arrayList2));
            }
        } else if (typeId.equals("home.platform.traits.TimeTrait.SolarTime.SolarTimeType")) {
            Set<String> setKeySet = enumConstraint.getEnumValuesMap().keySet();
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(setKeySet, 10));
            for (String str : setKeySet) {
                str.getClass();
                arrayList3.add(TimeTrait$SolarTimeType.valueOf(zzc(str)));
            }
            return new EnumConstraint(CollectionsKt.toSet(arrayList3));
        }
        homeManager.getClass();
        FactoryRegistry factoryRegistry = ((zzpu) homeManager).getZzb().getFactoryRegistry();
        String typeId2 = enumConstraint.getTypeId();
        typeId2.getClass();
        if (!zzku.zza(typeId2)) {
            String typeId3 = enumConstraint.getTypeId();
            typeId3.getClass();
            String strSubstringBeforeLast$default = StringsKt__StringsKt.substringBeforeLast$default(typeId3, ".", (String) null, 2, (Object) null);
            String typeId4 = enumConstraint.getTypeId();
            typeId4.getClass();
            String strSubstringAfterLast$default = StringsKt__StringsKt.substringAfterLast$default(typeId4, ".", (String) null, 2, (Object) null);
            TraitFactory<? extends Trait> traitOrNull = factoryRegistry.getTraitOrNull(strSubstringBeforeLast$default);
            Object factory = traitOrNull != null ? traitOrNull.getFactory() : null;
            if (!(factory instanceof PlatformTraitFactory)) {
                throw HomeException.INSTANCE.invalidArgument("Unsupported trait id: ".concat(String.valueOf(strSubstringBeforeLast$default)));
            }
            Set<String> setKeySet2 = enumConstraint.getEnumValuesMap().keySet();
            ArrayList arrayList4 = new ArrayList();
            for (String str2 : setKeySet2) {
                try {
                    zzmp.zzb((PlatformTraitFactory) factory, strSubstringAfterLast$default);
                    str2.getClass();
                    zzc(str2);
                    throw null;
                } catch (Exception unused) {
                    zzrt zzrtVarZzc = AutomationSdkLogger.zza().zzc();
                    StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(48, str2) + String.valueOf(enumConstraint).length());
                    sb.append("Exception while converting enum value ");
                    sb.append(str2);
                    sb.append(" for enum ");
                    sb.append(enumConstraint);
                    zzrtVarZzc.zza(sb.toString(), new Object[0]);
                }
            }
            return new EnumConstraint(CollectionsKt.toSet(arrayList4));
        }
        String typeId5 = enumConstraint.getTypeId();
        typeId5.getClass();
        String strSubstringBeforeLast$default2 = StringsKt__StringsKt.substringBeforeLast$default(typeId5, ".enum.", (String) null, 2, (Object) null);
        String typeId6 = enumConstraint.getTypeId();
        typeId6.getClass();
        String strSubstringAfterLast$default2 = StringsKt__StringsKt.substringAfterLast$default(typeId6, ".enum.", (String) null, 2, (Object) null);
        TraitFactory<? extends Trait> traitOrNull2 = factoryRegistry.getTraitOrNull(strSubstringBeforeLast$default2);
        Object factory2 = traitOrNull2 != null ? traitOrNull2.getFactory() : null;
        if (!(factory2 instanceof MatterTraitFactory)) {
            throw HomeException.INSTANCE.invalidArgument("Unsupported trait id: ".concat(String.valueOf(strSubstringBeforeLast$default2)));
        }
        Collection<Integer> collectionValues2 = enumConstraint.getEnumValuesMap().values();
        ArrayList arrayList5 = new ArrayList();
        for (Integer num3 : collectionValues2) {
            try {
                EnumAdapter enumAdapterZza = zzmp.zza((MatterTraitFactory) factory2, strSubstringAfterLast$default2);
                num3.getClass();
                Object objM557toRuntimeVKZWuLQ = enumAdapterZza.m557toRuntimeVKZWuLQ(ULong.m2411constructorimpl(num3.intValue()));
                objM557toRuntimeVKZWuLQ.getClass();
                r9 = (Enum) objM557toRuntimeVKZWuLQ;
            } catch (Exception unused2) {
                zzrt zzrtVarZzc2 = AutomationSdkLogger.zza().zzc();
                StringBuilder sb2 = new StringBuilder(String.valueOf(num3).length() + 48 + String.valueOf(enumConstraint).length());
                sb2.append("Exception while converting enum value ");
                sb2.append(num3);
                sb2.append(" for enum ");
                sb2.append(enumConstraint);
                zzrtVarZzc2.zza(sb2.toString(), new Object[0]);
                r9 = null;
            }
            if (r9 != null) {
                arrayList5.add(r9);
            }
        }
        return new EnumConstraint(CollectionsKt.toSet(arrayList5));
    }

    private static final StringConstraint zzf(StringAllowListConstraint stringAllowListConstraint) {
        List<String> valuesList = stringAllowListConstraint.getValuesList();
        valuesList.getClass();
        return new StringConstraint(CollectionsKt.toSet(valuesList), stringAllowListConstraint.getCaseSensitive());
    }

    private static final StringConstraint zzg(com.google.home.platform.traits.StringConstraint stringConstraint) {
        Regex regex;
        List<String> disallowedValuesList = stringConstraint.getDisallowedValuesList();
        disallowedValuesList.getClass();
        Set set = CollectionsKt.toSet(disallowedValuesList);
        int minLength = stringConstraint.hasMinLength() ? stringConstraint.getMinLength() : 0;
        int maxLength = stringConstraint.hasMaxLength() ? stringConstraint.getMaxLength() : 256;
        if (stringConstraint.hasRegex()) {
            String regex2 = stringConstraint.getRegex();
            regex2.getClass();
            regex = new Regex(regex2);
        } else {
            regex = null;
        }
        return new StringConstraint(set, minLength, maxLength, stringConstraint.getDisallowedValuesCaseSensitive(), regex);
    }

    private static final StructConstraint zzh(com.google.home.platform.traits.StructConstraint structConstraint, HomeManager homeManager, Field field) {
        Field fieldMo448getFieldByIdWZ4Q5Ns;
        Descriptor descriptor = field.getDescriptor();
        StructDescriptor structDescriptor = descriptor instanceof StructDescriptor ? (StructDescriptor) descriptor : null;
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        for (StructFieldConstraint structFieldConstraint : structConstraint.getStructFieldConstraintsList()) {
            if (structDescriptor != null && (fieldMo448getFieldByIdWZ4Q5Ns = structDescriptor.mo448getFieldByIdWZ4Q5Ns(UInt.m2389constructorimpl(structFieldConstraint.getId()))) != null) {
                zzkd zzkdVar = zzkf.zza;
                ValueTypeConstraint constraint = structFieldConstraint.getConstraint();
                constraint.getClass();
                Constraint constraintZza = zzkdVar.zza(constraint, homeManager, fieldMo448getFieldByIdWZ4Q5Ns);
                if (constraintZza != null) {
                    mapCreateMapBuilder.put(fieldMo448getFieldByIdWZ4Q5Ns, constraintZza);
                }
            }
        }
        return new StructConstraint(MapsKt.build(mapCreateMapBuilder));
    }

    private static final NumberSetConstraint zzi(UIntSetConstraint uIntSetConstraint, ConstraintUnit constraintUnit) {
        List<Long> valuesList = uIntSetConstraint.getValuesList();
        valuesList.getClass();
        return new NumberSetConstraint(CollectionsKt.toSet(valuesList), constraintUnit);
    }

    private static final String zzj(List list) {
        return CollectionsKt.joinToString$default(list, "", null, null, zzkc.zza, 30);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Constraint zza(ValueTypeConstraint valueTypeConstraint, HomeManager homeManager, Field field) {
        ConstraintUnit constraintUnit;
        BaseUnit baseUnit;
        valueTypeConstraint.getClass();
        homeManager.getClass();
        field.getClass();
        Unit unit = valueTypeConstraint.getUnit();
        if (unit != null) {
            double scale = unit.getScale();
            com.google.home.platform.traits.metadata.BaseUnit baseUnit2 = unit.getBaseUnit();
            baseUnit2.getClass();
            baseUnit2.getClass();
            BaseUnit[] baseUnitArrValues = BaseUnit.values();
            int length = baseUnitArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    baseUnit = null;
                    break;
                }
                baseUnit = baseUnitArrValues[i];
                if (baseUnit.getTagId() == baseUnit2.getNumber()) {
                    break;
                }
                i++;
            }
            constraintUnit = baseUnit != null ? new ConstraintUnit(baseUnit, Double.valueOf(scale)) : null;
        }
        ValueTypeConstraint.ConstraintCase constraintCase = valueTypeConstraint.getConstraintCase();
        ValueTypeConstraint.ConstraintCase constraintCase2 = ValueTypeConstraint.ConstraintCase.BOOLEAN_CONSTRAINT;
        UnsupportedCandidateReason.ReasonCase reasonCase = UnsupportedCandidateReason.ReasonCase.MISSING_STRUCTURE_ADDRESS_SETUP;
        MissingPresenceSensingSetup.SetupType setupType = MissingPresenceSensingSetup.SetupType.UNSPECIFIED;
        switch (constraintCase) {
            case BOOLEAN_CONSTRAINT:
                return new BooleanConstraint();
            case INT_RANGE:
                IntRangeConstraint intRange = valueTypeConstraint.getIntRange();
                intRange.getClass();
                return new NumberRangeConstraint(Long.valueOf(intRange.getLowerBound()), Long.valueOf(intRange.getUpperBound()), Long.valueOf(intRange.getStep()), constraintUnit);
            case UINT_RANGE:
                UIntRangeConstraint uintRange = valueTypeConstraint.getUintRange();
                uintRange.getClass();
                return new NumberRangeConstraint(Long.valueOf(uintRange.getLowerBound()), Long.valueOf(uintRange.getUpperBound()), Long.valueOf(uintRange.getStep()), constraintUnit);
            case UINT_SET:
                UIntSetConstraint uintSet = valueTypeConstraint.getUintSet();
                uintSet.getClass();
                return zzi(uintSet, constraintUnit);
            case DOUBLE_RANGE:
                DoubleRangeConstraint doubleRange = valueTypeConstraint.getDoubleRange();
                doubleRange.getClass();
                return new NumberRangeConstraint(Double.valueOf(doubleRange.getLowerBound()), Double.valueOf(doubleRange.getUpperBound()), Double.valueOf(doubleRange.getStep()), constraintUnit);
            case ENUM_CONSTRAINT:
                com.google.home.platform.traits.EnumConstraint enumConstraint = valueTypeConstraint.getEnumConstraint();
                enumConstraint.getClass();
                return zze(enumConstraint, homeManager);
            case STRUCT_CONSTRAINT:
                com.google.home.platform.traits.StructConstraint structConstraint = valueTypeConstraint.getStructConstraint();
                structConstraint.getClass();
                return zzh(structConstraint, homeManager, field);
            case STRING_CONSTRAINT:
                com.google.home.platform.traits.StringConstraint stringConstraint = valueTypeConstraint.getStringConstraint();
                stringConstraint.getClass();
                return zzg(stringConstraint);
            case STRING_ALLOW_LIST:
                StringAllowListConstraint stringAllowList = valueTypeConstraint.getStringAllowList();
                stringAllowList.getClass();
                return zzf(stringAllowList);
            case LIST_CONSTRAINT:
                ListConstraint listConstraint = valueTypeConstraint.getListConstraint();
                listConstraint.getClass();
                ValueTypeConstraint elementsConstraint = listConstraint.getElementsConstraint();
                elementsConstraint.getClass();
                Constraint constraintZza = zza(elementsConstraint, homeManager, field);
                if (constraintZza != null) {
                    return new com.google.home.automation.ListConstraint(constraintZza);
                }
                return null;
            case BITMAP_CONSTRAINT:
                com.google.home.platform.traits.BitmapConstraint bitmapConstraint = valueTypeConstraint.getBitmapConstraint();
                bitmapConstraint.getClass();
                return zzd(bitmapConstraint);
            case BYTE_CONSTRAINT:
                ByteConstraint byteConstraint = valueTypeConstraint.getByteConstraint();
                byteConstraint.getClass();
                return new com.google.home.automation.ByteConstraint(byteConstraint.hasMinLength() ? UInt.m2388boximpl(UInt.m2389constructorimpl(byteConstraint.getMinLength())) : null, byteConstraint.hasMaxLength() ? UInt.m2388boximpl(UInt.m2389constructorimpl(byteConstraint.getMaxLength())) : null, null);
            default:
                return null;
        }
    }
}
