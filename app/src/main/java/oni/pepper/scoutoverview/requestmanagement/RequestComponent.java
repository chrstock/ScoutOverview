package oni.pepper.scoutoverview.requestmanagement;

import dagger.Component;
import oni.pepper.scoutoverview.MainActivity;

@Component(modules = RequestModule.class)
public interface RequestComponent {

    void inject(MainActivity mainActivity);
}
