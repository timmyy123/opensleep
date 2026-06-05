package org.apache.commons.math3.analysis.polynomials;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.AppEventsConstants;
import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math3.analysis.ParametricUnivariateFunction;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes5.dex */
public class PolynomialFunction implements Serializable {
    private static final long serialVersionUID = -7726511984200295583L;
    private final double[] coefficients;

    public static class Parametric implements ParametricUnivariateFunction {
        @Override // org.apache.commons.math3.analysis.ParametricUnivariateFunction
        public double[] gradient(double d, double... dArr) {
            double[] dArr2 = new double[dArr.length];
            double d2 = 1.0d;
            for (int i = 0; i < dArr.length; i++) {
                dArr2[i] = d2;
                d2 *= d;
            }
            return dArr2;
        }

        @Override // org.apache.commons.math3.analysis.ParametricUnivariateFunction
        public double value(double d, double... dArr) {
            return PolynomialFunction.evaluate(dArr, d);
        }
    }

    public PolynomialFunction(double[] dArr) {
        MathUtils.checkNotNull(dArr);
        int length = dArr.length;
        if (length == 0) {
            throw new NoDataException(LocalizedFormats.EMPTY_POLYNOMIALS_COEFFICIENTS_ARRAY);
        }
        while (length > 1 && dArr[length - 1] == 0.0d) {
            length--;
        }
        double[] dArr2 = new double[length];
        this.coefficients = dArr2;
        System.arraycopy(dArr, 0, dArr2, 0, length);
    }

    public static double evaluate(double[] dArr, double d) {
        MathUtils.checkNotNull(dArr);
        int length = dArr.length;
        if (length == 0) {
            throw new NoDataException(LocalizedFormats.EMPTY_POLYNOMIALS_COEFFICIENTS_ARRAY);
        }
        double d2 = dArr[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            d2 = (d2 * d) + dArr[i];
        }
        return d2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PolynomialFunction) && Arrays.equals(this.coefficients, ((PolynomialFunction) obj).coefficients);
    }

    public int hashCode() {
        return Arrays.hashCode(this.coefficients) + 31;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        double[] dArr = this.coefficients;
        double d = dArr[0];
        if (d != 0.0d) {
            sb.append(toString(d));
        } else if (dArr.length == 1) {
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        int i = 1;
        while (true) {
            double[] dArr2 = this.coefficients;
            if (i >= dArr2.length) {
                return sb.toString();
            }
            if (dArr2[i] != 0.0d) {
                int length = sb.length();
                double[] dArr3 = this.coefficients;
                if (length > 0) {
                    if (dArr3[i] < 0.0d) {
                        sb.append(" - ");
                    } else {
                        sb.append(" + ");
                    }
                } else if (dArr3[i] < 0.0d) {
                    sb.append("-");
                }
                double dAbs = FastMath.abs(this.coefficients[i]);
                if (dAbs - 1.0d != 0.0d) {
                    sb.append(toString(dAbs));
                    sb.append(' ');
                }
                sb.append("x");
                if (i > 1) {
                    sb.append('^');
                    sb.append(Integer.toString(i));
                }
            }
            i++;
        }
    }

    public double value(double d) {
        return evaluate(this.coefficients, d);
    }

    private static String toString(double d) {
        String string = Double.toString(d);
        return string.endsWith(".0") ? Fragment$$ExternalSyntheticOutline1.m(2, 0, string) : string;
    }
}
