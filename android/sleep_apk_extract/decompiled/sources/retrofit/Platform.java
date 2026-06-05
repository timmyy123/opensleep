package retrofit;

import android.os.Process;
import com.google.gson.Gson;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import retrofit.RestAdapter;
import retrofit.Utils;
import retrofit.android.AndroidLog;
import retrofit.android.MainThreadExecutor;
import retrofit.appengine.UrlFetchClient;
import retrofit.client.Client;
import retrofit.client.OkClient;
import retrofit.client.UrlConnectionClient;
import retrofit.converter.Converter;
import retrofit.converter.GsonConverter;

/* JADX INFO: loaded from: classes5.dex */
abstract class Platform {
    private static final Platform PLATFORM = findPlatform();
    static final boolean HAS_RX_JAVA = hasRxJavaOnClasspath();

    public static class Android extends Platform {
        private Android() {
        }

        @Override // retrofit.Platform
        public Executor defaultCallbackExecutor() {
            return new MainThreadExecutor();
        }

        @Override // retrofit.Platform
        public Client.Provider defaultClient() {
            final Client clientInstantiate = Platform.hasOkHttpOnClasspath() ? OkClientInstantiator.instantiate() : new UrlConnectionClient();
            return new Client.Provider() { // from class: retrofit.Platform.Android.1
                @Override // retrofit.client.Client.Provider
                public Client get() {
                    return clientInstantiate;
                }
            };
        }

        @Override // retrofit.Platform
        public Converter defaultConverter() {
            return new GsonConverter(new Gson());
        }

        @Override // retrofit.Platform
        public Executor defaultHttpExecutor() {
            return Executors.newCachedThreadPool(new ThreadFactory() { // from class: retrofit.Platform.Android.2
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(final Runnable runnable) {
                    return new Thread(new Runnable() { // from class: retrofit.Platform.Android.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Process.setThreadPriority(10);
                            runnable.run();
                        }
                    }, "Retrofit-Idle");
                }
            });
        }

        @Override // retrofit.Platform
        public RestAdapter.Log defaultLog() {
            return new AndroidLog("Retrofit");
        }
    }

    public static class AppEngine extends Base {
        private AppEngine() {
            super();
        }

        @Override // retrofit.Platform.Base, retrofit.Platform
        public Client.Provider defaultClient() {
            final UrlFetchClient urlFetchClient = new UrlFetchClient();
            return new Client.Provider() { // from class: retrofit.Platform.AppEngine.1
                @Override // retrofit.client.Client.Provider
                public Client get() {
                    return urlFetchClient;
                }
            };
        }
    }

    public static class Base extends Platform {
        private Base() {
        }

        @Override // retrofit.Platform
        public Executor defaultCallbackExecutor() {
            return new Utils.SynchronousExecutor();
        }

        @Override // retrofit.Platform
        public Client.Provider defaultClient() {
            final Client clientInstantiate = Platform.hasOkHttpOnClasspath() ? OkClientInstantiator.instantiate() : new UrlConnectionClient();
            return new Client.Provider() { // from class: retrofit.Platform.Base.1
                @Override // retrofit.client.Client.Provider
                public Client get() {
                    return clientInstantiate;
                }
            };
        }

        @Override // retrofit.Platform
        public Converter defaultConverter() {
            return new GsonConverter(new Gson());
        }

        @Override // retrofit.Platform
        public Executor defaultHttpExecutor() {
            return Executors.newCachedThreadPool(new ThreadFactory() { // from class: retrofit.Platform.Base.2
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(final Runnable runnable) {
                    return new Thread(new Runnable() { // from class: retrofit.Platform.Base.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Thread.currentThread().setPriority(1);
                            runnable.run();
                        }
                    }, "Retrofit-Idle");
                }
            });
        }

        @Override // retrofit.Platform
        public RestAdapter.Log defaultLog() {
            return new RestAdapter.Log() { // from class: retrofit.Platform.Base.3
                @Override // retrofit.RestAdapter.Log
                public void log(String str) {
                    System.out.println(str);
                }
            };
        }
    }

    public static class OkClientInstantiator {
        public static Client instantiate() {
            return new OkClient();
        }
    }

    private static Platform findPlatform() {
        try {
            Class.forName("android.os.Build");
            return new Android();
        } catch (ClassNotFoundException unused) {
            return System.getProperty("com.google.appengine.runtime.version") != null ? new AppEngine() : new Base();
        }
    }

    public static Platform get() {
        return PLATFORM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hasOkHttpOnClasspath() {
        try {
            Class.forName("com.squareup.okhttp.OkHttpClient");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static boolean hasRxJavaOnClasspath() {
        try {
            Class.forName("rx.Observable");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public abstract Executor defaultCallbackExecutor();

    public abstract Client.Provider defaultClient();

    public abstract Converter defaultConverter();

    public abstract Executor defaultHttpExecutor();

    public abstract RestAdapter.Log defaultLog();
}
