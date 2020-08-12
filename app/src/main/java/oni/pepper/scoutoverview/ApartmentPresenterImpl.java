package oni.pepper.scoutoverview;

import java.util.Collections;
import java.util.List;

public class ApartmentPresenterImpl implements ApartmentPresenter {

    private ApartmentView view;

    private final static String ERROR_EMPTY_TITLE = "Das Feld darf nicht leer sein";

    public ApartmentPresenterImpl(ApartmentView view){
        this.view = view;
    }

    @Override
    public void loadApartments() {
        List<Apartment> apartments = Collections.singletonList(new Apartment(R.drawable.ic_tomato,"Testapartment"));
        view.showApartments(apartments);
    }
}
