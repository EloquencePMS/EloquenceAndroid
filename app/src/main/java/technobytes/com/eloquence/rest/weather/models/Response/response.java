package technobytes.com.eloquence.rest.weather.models.Response;


/**
 * Created by Michael Leffert on 11/12/2015.
 */
public class response {


    String version, termsofService;
    features features;

    public String getTermsofService() {
        return termsofService;
    }

    public void setTermsofService(String termsofService) {
        this.termsofService = termsofService;
    }

    public features getFeatures() {
        return features;
    }

    public void setFeatures(features features) {
        this.features = features;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }


}
