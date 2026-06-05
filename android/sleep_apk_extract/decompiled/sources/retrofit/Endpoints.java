package retrofit;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Endpoints {

    public static class FixedEndpoint implements Endpoint {
        private final String apiUrl;
        private final String name;

        public FixedEndpoint(String str, String str2) {
            this.apiUrl = str;
            this.name = str2;
        }

        @Override // retrofit.Endpoint
        public String getUrl() {
            return this.apiUrl;
        }
    }

    public static Endpoint newFixedEndpoint(String str) {
        return new FixedEndpoint(str, "default");
    }
}
