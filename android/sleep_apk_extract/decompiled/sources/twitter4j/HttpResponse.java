package twitter4j;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import oauth.signpost.OAuth;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class HttpResponse {
    private static final Logger logger = Logger.getLogger(HttpResponseImpl.class);
    protected final HttpClientConfiguration CONF;
    protected InputStream is;
    protected int statusCode;
    protected String responseAsString = null;
    private boolean streamConsumed = false;
    private JSONObject json = null;
    private JSONArray jsonArray = null;

    public HttpResponse(HttpClientConfiguration httpClientConfiguration) {
        this.CONF = httpClientConfiguration;
    }

    private void disconnectForcibly() {
        try {
            disconnect();
        } catch (Exception unused) {
        }
    }

    public JSONArray asJSONArray() {
        try {
            if (this.jsonArray == null) {
                try {
                    this.jsonArray = new JSONArray(asString());
                    if (this.CONF.isPrettyDebugEnabled()) {
                        logger.debug(this.jsonArray.toString(1));
                    } else {
                        Logger logger2 = logger;
                        String string = this.responseAsString;
                        if (string == null) {
                            string = this.jsonArray.toString();
                        }
                        logger2.debug(string);
                    }
                    disconnectForcibly();
                } catch (JSONException e) {
                    if (!logger.isDebugEnabled()) {
                        throw new TwitterException(e.getMessage(), e);
                    }
                    throw new TwitterException(e.getMessage() + ":" + this.responseAsString, e);
                }
            }
            return this.jsonArray;
        } catch (Throwable th) {
            disconnectForcibly();
            throw th;
        }
    }

    public JSONObject asJSONObject() {
        try {
            if (this.json == null) {
                try {
                    this.json = new JSONObject(asString());
                    if (this.CONF.isPrettyDebugEnabled()) {
                        logger.debug(this.json.toString(1));
                    } else {
                        Logger logger2 = logger;
                        String string = this.responseAsString;
                        if (string == null) {
                            string = this.json.toString();
                        }
                        logger2.debug(string);
                    }
                    disconnectForcibly();
                } catch (JSONException e) {
                    if (this.responseAsString == null) {
                        throw new TwitterException(e.getMessage(), e);
                    }
                    throw new TwitterException(e.getMessage() + ":" + this.responseAsString, e);
                }
            }
            return this.json;
        } catch (Throwable th) {
            disconnectForcibly();
            throw th;
        }
    }

    public InputStream asStream() {
        if (!this.streamConsumed) {
            return this.is;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Stream has already been consumed.");
        return null;
    }

    public String asString() throws Throwable {
        BufferedReader bufferedReader;
        Throwable th;
        InputStream inputStreamAsStream;
        IOException e;
        if (this.responseAsString == null) {
            try {
                try {
                    inputStreamAsStream = asStream();
                    if (inputStreamAsStream == null) {
                        if (inputStreamAsStream != null) {
                            try {
                                inputStreamAsStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        disconnectForcibly();
                        return null;
                    }
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStreamAsStream, OAuth.ENCODING));
                        try {
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                String line = bufferedReader2.readLine();
                                if (line == null) {
                                    break;
                                }
                                sb.append(line);
                                sb.append("\n");
                            }
                            String string = sb.toString();
                            this.responseAsString = string;
                            logger.debug(string);
                            inputStreamAsStream.close();
                            this.streamConsumed = true;
                            try {
                                inputStreamAsStream.close();
                            } catch (IOException unused2) {
                            }
                            try {
                                bufferedReader2.close();
                            } catch (IOException unused3) {
                            }
                            disconnectForcibly();
                        } catch (IOException e2) {
                            e = e2;
                            throw new TwitterException(e.getMessage(), e);
                        }
                    } catch (IOException e3) {
                        e = e3;
                    } catch (Throwable th2) {
                        bufferedReader = null;
                        th = th2;
                        if (inputStreamAsStream != null) {
                            try {
                                inputStreamAsStream.close();
                            } catch (IOException unused4) {
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused5) {
                            }
                        }
                        disconnectForcibly();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (IOException e4) {
                e = e4;
            } catch (Throwable th4) {
                bufferedReader = null;
                th = th4;
                inputStreamAsStream = null;
            }
        }
        return this.responseAsString;
    }

    public abstract void disconnect();

    public abstract String getResponseHeader(String str);

    public int getStatusCode() {
        return this.statusCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("HttpResponse{statusCode=");
        sb.append(this.statusCode);
        sb.append(", responseAsString='");
        sb.append(this.responseAsString);
        sb.append("', is=");
        sb.append(this.is);
        sb.append(", streamConsumed=");
        return Fragment$$ExternalSyntheticOutline1.m(sb, this.streamConsumed, '}');
    }
}
