package twitter4j;

import com.facebook.internal.ServerProtocol;
import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Query implements Serializable {
    private static final long serialVersionUID = 7196404519192910019L;
    public static final Unit MILES = Unit.mi;
    public static final Unit KILOMETERS = Unit.km;
    public static final ResultType MIXED = ResultType.mixed;
    public static final ResultType POPULAR = ResultType.popular;
    public static final ResultType RECENT = ResultType.recent;
    private static final HttpParameter WITH_TWITTER_USER_ID = new HttpParameter("with_twitter_user_id", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);

    public enum ResultType {
        popular,
        mixed,
        recent
    }

    public enum Unit {
        mi,
        km
    }
}
