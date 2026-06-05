package androidx.dynamicanimation.animation;

import androidx.dynamicanimation.animation.DynamicAnimation;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
public final class SpringForce {
    private double mDampedFreq;
    double mDampingRatio;
    private double mFinalPosition;
    private double mGammaMinus;
    private double mGammaPlus;
    private boolean mInitialized;
    private final DynamicAnimation.MassState mMassState;
    double mNaturalFreq;
    private double mValueThreshold;
    private double mVelocityThreshold;

    public SpringForce(float f) {
        this.mNaturalFreq = Math.sqrt(1500.0d);
        this.mDampingRatio = 0.5d;
        this.mInitialized = false;
        this.mFinalPosition = Double.MAX_VALUE;
        this.mMassState = new DynamicAnimation.MassState();
        this.mFinalPosition = f;
    }

    private void init() {
        if (this.mInitialized) {
            return;
        }
        if (this.mFinalPosition == Double.MAX_VALUE) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Error: Final position of the spring must be set before the animation starts");
            return;
        }
        double d = this.mDampingRatio;
        if (d > 1.0d) {
            double d2 = this.mNaturalFreq;
            this.mGammaPlus = (Math.sqrt((d * d) - 1.0d) * d2) + ((-d) * d2);
            double d3 = this.mDampingRatio;
            double d4 = this.mNaturalFreq;
            this.mGammaMinus = ((-d3) * d4) - (Math.sqrt((d3 * d3) - 1.0d) * d4);
        } else if (d >= 0.0d && d < 1.0d) {
            this.mDampedFreq = Math.sqrt(1.0d - (d * d)) * this.mNaturalFreq;
        }
        this.mInitialized = true;
    }

    public float getDampingRatio() {
        return (float) this.mDampingRatio;
    }

    public float getFinalPosition() {
        return (float) this.mFinalPosition;
    }

    public float getStiffness() {
        double d = this.mNaturalFreq;
        return (float) (d * d);
    }

    public boolean isAtEquilibrium(float f, float f2) {
        return ((double) Math.abs(f2)) < this.mVelocityThreshold && ((double) Math.abs(f - getFinalPosition())) < this.mValueThreshold;
    }

    public SpringForce setDampingRatio(float f) {
        if (f < 0.0f) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Damping ratio must be non-negative");
            return null;
        }
        this.mDampingRatio = f;
        this.mInitialized = false;
        return this;
    }

    public SpringForce setFinalPosition(float f) {
        this.mFinalPosition = f;
        return this;
    }

    public SpringForce setStiffness(float f) {
        if (f <= 0.0f) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Spring stiffness constant must be positive.");
            return null;
        }
        this.mNaturalFreq = Math.sqrt(f);
        this.mInitialized = false;
        return this;
    }

    public void setValueThreshold(double d) {
        double dAbs = Math.abs(d);
        this.mValueThreshold = dAbs;
        this.mVelocityThreshold = dAbs * 62.5d;
    }

    public DynamicAnimation.MassState updateValues(double d, double d2, long j) {
        double dSin;
        double dCos;
        init();
        double d3 = j / 1000.0d;
        double d4 = d - this.mFinalPosition;
        double d5 = this.mDampingRatio;
        if (d5 > 1.0d) {
            double d6 = this.mGammaMinus;
            double d7 = this.mGammaPlus;
            double d8 = d4 - (((d6 * d4) - d2) / (d6 - d7));
            double d9 = ((d4 * d6) - d2) / (d6 - d7);
            dSin = (Math.pow(2.718281828459045d, this.mGammaPlus * d3) * d9) + (Math.pow(2.718281828459045d, d6 * d3) * d8);
            double d10 = this.mGammaMinus;
            double dPow = Math.pow(2.718281828459045d, d10 * d3) * d8 * d10;
            double d11 = this.mGammaPlus;
            dCos = (Math.pow(2.718281828459045d, d11 * d3) * d9 * d11) + dPow;
        } else if (d5 == 1.0d) {
            double d12 = this.mNaturalFreq;
            double d13 = (d12 * d4) + d2;
            double d14 = (d13 * d3) + d4;
            double dPow2 = Math.pow(2.718281828459045d, (-d12) * d3) * d14;
            double dPow3 = Math.pow(2.718281828459045d, (-this.mNaturalFreq) * d3) * d14;
            double d15 = this.mNaturalFreq;
            dCos = (Math.pow(2.718281828459045d, (-d15) * d3) * d13) + (dPow3 * (-d15));
            dSin = dPow2;
        } else {
            double d16 = 1.0d / this.mDampedFreq;
            double d17 = this.mNaturalFreq;
            double d18 = ((d5 * d17 * d4) + d2) * d16;
            dSin = ((Math.sin(this.mDampedFreq * d3) * d18) + (Math.cos(this.mDampedFreq * d3) * d4)) * Math.pow(2.718281828459045d, (-d5) * d17 * d3);
            double d19 = this.mNaturalFreq;
            double d20 = this.mDampingRatio;
            double d21 = (-d19) * dSin * d20;
            double dPow4 = Math.pow(2.718281828459045d, (-d20) * d19 * d3);
            double d22 = this.mDampedFreq;
            double dSin2 = Math.sin(d22 * d3) * (-d22) * d4;
            double d23 = this.mDampedFreq;
            dCos = (((Math.cos(d23 * d3) * d18 * d23) + dSin2) * dPow4) + d21;
        }
        DynamicAnimation.MassState massState = this.mMassState;
        massState.mValue = (float) (dSin + this.mFinalPosition);
        massState.mVelocity = (float) dCos;
        return massState;
    }

    public SpringForce() {
        this.mNaturalFreq = Math.sqrt(1500.0d);
        this.mDampingRatio = 0.5d;
        this.mInitialized = false;
        this.mFinalPosition = Double.MAX_VALUE;
        this.mMassState = new DynamicAnimation.MassState();
    }
}
