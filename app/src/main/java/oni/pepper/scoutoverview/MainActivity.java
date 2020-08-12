package oni.pepper.scoutoverview;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.widget.Toolbar;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.List;

import javax.inject.Inject;

import oni.pepper.scoutoverview.requestmanagement.DaggerRequestComponent;
import oni.pepper.scoutoverview.requestmanagement.HttpRequestService;

public class MainActivity extends Activity implements ApartmentView {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Inject
    HttpRequestService requestService;

    private EditText editTextTitle;

    private ApartmentPresenter presenter;

    @Override
    public void showApartments(List<Apartment> apartments) {

        ApartmentAdapter adapter = new ApartmentAdapter(this,apartments);

        apartments.forEach(adapter::add);

        ListView listView = findViewById(R.id.list_view_apartments);
        listView.setAdapter(adapter);

        Log.d(LOG_TAG, "Apartments neu geladen..." + apartments.toString());
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerRequestComponent.builder().build().inject(this);

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

        StringRequest request = requestService.sendGetRequest("https://www.immobilienscout24.de");
        queue.add(request);

        JsonObjectRequest jsonrequest = requestService.sendGetRequestJson("https://www.immobilienscout24.de");
        Log.i("test",jsonrequest.toString());

        presenter = new ApartmentPresenterImpl(this);
        presenter.loadApartments();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.loadApartments();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}