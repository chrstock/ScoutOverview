package oni.pepper.scoutoverview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ApartmentAdapter extends ArrayAdapter<Apartment> {

    private final Context context;
    private List<Apartment> apartments;

    public ApartmentAdapter(@NonNull Context context, List<Apartment> apartments) {
        super(context, 0);
        this.context = context;
        this.apartments = apartments;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Apartment apartment = getItem(position);

        //setting to default values
        //ToDo Changing to real placeholders
        String title = "";
        int image = R.drawable.ic_tomato;

        if (apartment != null) {
            title = apartment.getTitle();
            image = apartment.getImage();
        }

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_apartment, parent, false);
        }

        TextView mTextViewTitle = convertView.findViewById(R.id.text_title);
        ImageView mImageViewSymbol = convertView.findViewById(R.id.image_symbol);

        mTextViewTitle.setText(title);
        mImageViewSymbol.setImageResource(image);

        return convertView;
    }

}
