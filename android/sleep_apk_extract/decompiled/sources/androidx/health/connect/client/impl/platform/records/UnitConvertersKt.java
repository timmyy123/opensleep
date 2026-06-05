package androidx.health.connect.client.impl.platform.records;

import android.health.connect.datatypes.units.BloodGlucose;
import android.health.connect.datatypes.units.Length;
import android.health.connect.datatypes.units.Percentage;
import android.health.connect.datatypes.units.Power;
import android.health.connect.datatypes.units.Pressure;
import android.health.connect.datatypes.units.Temperature;
import android.health.connect.datatypes.units.TemperatureDelta;
import android.health.connect.datatypes.units.Velocity;
import android.health.connect.datatypes.units.Volume;
import androidx.health.connect.client.units.Energy;
import androidx.health.connect.client.units.Mass;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a\u0010\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00020\u0003H\u0000\u001a\u0010\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006*\u00020\u0007H\u0000\u001a\u0010\u0010\b\u001a\u00060\tj\u0002`\n*\u00020\u000bH\u0000\u001a\u0010\u0010\f\u001a\u00060\rj\u0002`\u000e*\u00020\u000fH\u0000\u001a\u0010\u0010\u0010\u001a\u00060\u0011j\u0002`\u0012*\u00020\u0013H\u0000\u001a\u0010\u0010\u0014\u001a\u00060\u0015j\u0002`\u0016*\u00020\u0017H\u0000\u001a\u0010\u0010\u0018\u001a\u00060\u0019j\u0002`\u001a*\u00020\u001bH\u0000\u001a\u0010\u0010\u001c\u001a\u00060\u001dj\u0002`\u001e*\u00020\u001fH\u0000\u001a\u0010\u0010 \u001a\u00060!j\u0002`\"*\u00020#H\u0001\u001a\u0010\u0010$\u001a\u00060%j\u0002`&*\u00020'H\u0000\u001a\u0010\u0010(\u001a\u00060)j\u0002`**\u00020+H\u0000\u001a\u0010\u0010,\u001a\u00020\u0003*\u00060\u0001j\u0002`\u0002H\u0000\u001a\u0012\u0010-\u001a\u0004\u0018\u00010\u0007*\u00060\u0005j\u0002`\u0006H\u0000\u001a\u0010\u0010.\u001a\u00020\u0007*\u00060\u0005j\u0002`\u0006H\u0000\u001a\u0010\u0010/\u001a\u00020\u000b*\u00060\tj\u0002`\nH\u0000\u001a\u0012\u00100\u001a\u0004\u0018\u00010\u000f*\u00060\rj\u0002`\u000eH\u0000\u001a\u0010\u00101\u001a\u00020\u000f*\u00060\rj\u0002`\u000eH\u0000\u001a\u0010\u00102\u001a\u00020\u0013*\u00060\u0011j\u0002`\u0012H\u0000\u001a\u0010\u00103\u001a\u00020\u0017*\u00060\u0015j\u0002`\u0016H\u0000\u001a\u0010\u00104\u001a\u00020\u001b*\u00060\u0019j\u0002`\u001aH\u0000\u001a\u0010\u00105\u001a\u00020\u001f*\u00060\u001dj\u0002`\u001eH\u0000\u001a\u0010\u00106\u001a\u00020#*\u00060!j\u0002`\"H\u0001\u001a\u0010\u00107\u001a\u00020'*\u00060%j\u0002`&H\u0000\u001a\u0010\u00108\u001a\u00020+*\u00060)j\u0002`*H\u0000¨\u00069"}, d2 = {"toPlatformBloodGlucose", "Landroid/health/connect/datatypes/units/BloodGlucose;", "Landroidx/health/connect/client/impl/platform/records/PlatformBloodGlucose;", "Landroidx/health/connect/client/units/BloodGlucose;", "toPlatformEnergy", "Landroid/health/connect/datatypes/units/Energy;", "Landroidx/health/connect/client/impl/platform/records/PlatformEnergy;", "Landroidx/health/connect/client/units/Energy;", "toPlatformLength", "Landroid/health/connect/datatypes/units/Length;", "Landroidx/health/connect/client/impl/platform/records/PlatformLength;", "Landroidx/health/connect/client/units/Length;", "toPlatformMass", "Landroid/health/connect/datatypes/units/Mass;", "Landroidx/health/connect/client/impl/platform/records/PlatformMass;", "Landroidx/health/connect/client/units/Mass;", "toPlatformPercentage", "Landroid/health/connect/datatypes/units/Percentage;", "Landroidx/health/connect/client/impl/platform/records/PlatformPercentage;", "Landroidx/health/connect/client/units/Percentage;", "toPlatformPower", "Landroid/health/connect/datatypes/units/Power;", "Landroidx/health/connect/client/impl/platform/records/PlatformPower;", "Landroidx/health/connect/client/units/Power;", "toPlatformPressure", "Landroid/health/connect/datatypes/units/Pressure;", "Landroidx/health/connect/client/impl/platform/records/PlatformPressure;", "Landroidx/health/connect/client/units/Pressure;", "toPlatformTemperature", "Landroid/health/connect/datatypes/units/Temperature;", "Landroidx/health/connect/client/impl/platform/records/PlatformTemperature;", "Landroidx/health/connect/client/units/Temperature;", "toPlatformTemperatureDelta", "Landroid/health/connect/datatypes/units/TemperatureDelta;", "Landroidx/health/connect/client/impl/platform/records/PlatformTemperatureDelta;", "Landroidx/health/connect/client/units/TemperatureDelta;", "toPlatformVelocity", "Landroid/health/connect/datatypes/units/Velocity;", "Landroidx/health/connect/client/impl/platform/records/PlatformVelocity;", "Landroidx/health/connect/client/units/Velocity;", "toPlatformVolume", "Landroid/health/connect/datatypes/units/Volume;", "Landroidx/health/connect/client/impl/platform/records/PlatformVolume;", "Landroidx/health/connect/client/units/Volume;", "toSdkBloodGlucose", "toNonDefaultSdkEnergy", "toSdkEnergy", "toSdkLength", "toNonDefaultSdkMass", "toSdkMass", "toSdkPercentage", "toSdkPower", "toSdkPressure", "toSdkTemperature", "toSdkTemperatureDelta", "toSdkVelocity", "toSdkVolume", "connect-client_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class UnitConvertersKt {
    public static final Energy toNonDefaultSdkEnergy(android.health.connect.datatypes.units.Energy energy) {
        energy.getClass();
        if (energy.getInCalories() == Double.MIN_VALUE) {
            energy = null;
        }
        if (energy != null) {
            return toSdkEnergy(energy);
        }
        return null;
    }

    public static final Mass toNonDefaultSdkMass(android.health.connect.datatypes.units.Mass mass) {
        mass.getClass();
        if (mass.getInGrams() == Double.MIN_VALUE) {
            mass = null;
        }
        if (mass != null) {
            return toSdkMass(mass);
        }
        return null;
    }

    public static final BloodGlucose toPlatformBloodGlucose(androidx.health.connect.client.units.BloodGlucose bloodGlucose) {
        bloodGlucose.getClass();
        BloodGlucose bloodGlucoseFromMillimolesPerLiter = BloodGlucose.fromMillimolesPerLiter(bloodGlucose.getMillimolesPerLiter());
        bloodGlucoseFromMillimolesPerLiter.getClass();
        return bloodGlucoseFromMillimolesPerLiter;
    }

    public static final android.health.connect.datatypes.units.Energy toPlatformEnergy(Energy energy) {
        energy.getClass();
        android.health.connect.datatypes.units.Energy energyFromCalories = android.health.connect.datatypes.units.Energy.fromCalories(energy.getCalories());
        energyFromCalories.getClass();
        return energyFromCalories;
    }

    public static final Length toPlatformLength(androidx.health.connect.client.units.Length length) {
        length.getClass();
        Length lengthFromMeters = Length.fromMeters(length.getMeters());
        lengthFromMeters.getClass();
        return lengthFromMeters;
    }

    public static final android.health.connect.datatypes.units.Mass toPlatformMass(Mass mass) {
        mass.getClass();
        android.health.connect.datatypes.units.Mass massFromGrams = android.health.connect.datatypes.units.Mass.fromGrams(mass.getGrams());
        massFromGrams.getClass();
        return massFromGrams;
    }

    public static final Percentage toPlatformPercentage(androidx.health.connect.client.units.Percentage percentage) {
        percentage.getClass();
        Percentage percentageFromValue = Percentage.fromValue(percentage.getValue());
        percentageFromValue.getClass();
        return percentageFromValue;
    }

    public static final Power toPlatformPower(androidx.health.connect.client.units.Power power) {
        power.getClass();
        Power powerFromWatts = Power.fromWatts(power.getWatts());
        powerFromWatts.getClass();
        return powerFromWatts;
    }

    public static final Pressure toPlatformPressure(androidx.health.connect.client.units.Pressure pressure) {
        pressure.getClass();
        Pressure pressureFromMillimetersOfMercury = Pressure.fromMillimetersOfMercury(pressure.getValue());
        pressureFromMillimetersOfMercury.getClass();
        return pressureFromMillimetersOfMercury;
    }

    public static final Temperature toPlatformTemperature(androidx.health.connect.client.units.Temperature temperature) {
        temperature.getClass();
        Temperature temperatureFromCelsius = Temperature.fromCelsius(temperature.getCelsius());
        temperatureFromCelsius.getClass();
        return temperatureFromCelsius;
    }

    public static final TemperatureDelta toPlatformTemperatureDelta(androidx.health.connect.client.units.TemperatureDelta temperatureDelta) {
        temperatureDelta.getClass();
        TemperatureDelta temperatureDeltaFromCelsius = TemperatureDelta.fromCelsius(temperatureDelta.getCelsius());
        temperatureDeltaFromCelsius.getClass();
        return temperatureDeltaFromCelsius;
    }

    public static final Velocity toPlatformVelocity(androidx.health.connect.client.units.Velocity velocity) {
        velocity.getClass();
        Velocity velocityFromMetersPerSecond = Velocity.fromMetersPerSecond(velocity.getMetersPerSecond());
        velocityFromMetersPerSecond.getClass();
        return velocityFromMetersPerSecond;
    }

    public static final Volume toPlatformVolume(androidx.health.connect.client.units.Volume volume) {
        volume.getClass();
        Volume volumeFromLiters = Volume.fromLiters(volume.getLiters());
        volumeFromLiters.getClass();
        return volumeFromLiters;
    }

    public static final androidx.health.connect.client.units.BloodGlucose toSdkBloodGlucose(BloodGlucose bloodGlucose) {
        bloodGlucose.getClass();
        return androidx.health.connect.client.units.BloodGlucose.INSTANCE.millimolesPerLiter(bloodGlucose.getInMillimolesPerLiter());
    }

    public static final Energy toSdkEnergy(android.health.connect.datatypes.units.Energy energy) {
        energy.getClass();
        return Energy.INSTANCE.calories(energy.getInCalories());
    }

    public static final androidx.health.connect.client.units.Length toSdkLength(Length length) {
        length.getClass();
        return androidx.health.connect.client.units.Length.INSTANCE.meters(length.getInMeters());
    }

    public static final Mass toSdkMass(android.health.connect.datatypes.units.Mass mass) {
        mass.getClass();
        return Mass.INSTANCE.grams(mass.getInGrams());
    }

    public static final androidx.health.connect.client.units.Percentage toSdkPercentage(Percentage percentage) {
        percentage.getClass();
        return new androidx.health.connect.client.units.Percentage(percentage.getValue());
    }

    public static final androidx.health.connect.client.units.Power toSdkPower(Power power) {
        power.getClass();
        return androidx.health.connect.client.units.Power.INSTANCE.watts(power.getInWatts());
    }

    public static final androidx.health.connect.client.units.Pressure toSdkPressure(Pressure pressure) {
        pressure.getClass();
        return androidx.health.connect.client.units.Pressure.INSTANCE.millimetersOfMercury(pressure.getInMillimetersOfMercury());
    }

    public static final androidx.health.connect.client.units.Temperature toSdkTemperature(Temperature temperature) {
        temperature.getClass();
        return androidx.health.connect.client.units.Temperature.INSTANCE.celsius(temperature.getInCelsius());
    }

    public static final androidx.health.connect.client.units.TemperatureDelta toSdkTemperatureDelta(TemperatureDelta temperatureDelta) {
        temperatureDelta.getClass();
        return androidx.health.connect.client.units.TemperatureDelta.INSTANCE.celsius(temperatureDelta.getInCelsius());
    }

    public static final androidx.health.connect.client.units.Velocity toSdkVelocity(Velocity velocity) {
        velocity.getClass();
        return androidx.health.connect.client.units.Velocity.INSTANCE.metersPerSecond(velocity.getInMetersPerSecond());
    }

    public static final androidx.health.connect.client.units.Volume toSdkVolume(Volume volume) {
        volume.getClass();
        return androidx.health.connect.client.units.Volume.INSTANCE.liters(volume.getInLiters());
    }
}
