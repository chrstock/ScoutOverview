package oni.pepper.scoutoverview.requestmanagement;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RequestModule {

    @Provides
    public HttpRequestService provideHttpRequestService() {
        return new HttpRequestServiceImpl();
    }
}
