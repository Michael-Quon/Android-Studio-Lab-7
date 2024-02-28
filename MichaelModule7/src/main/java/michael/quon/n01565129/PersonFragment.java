package michael.quon.n01565129;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PersonFragment extends Fragment {

    private String[] provincesAndTerritories;
    private int selectedItemPosition = -1; // Initially no item is selected

    public PersonFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        provincesAndTerritories = getResources().getStringArray(R.array.provinces_territories);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_person, container, false);
        ListView listView = view.findViewById(R.id.MicListView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, provincesAndTerritories) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View itemView = super.getView(position, convertView, parent);

                // Check if the current position is the selected item
                if (position == selectedItemPosition) {
                    itemView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.selectedItem));
                } else {
                    itemView.setBackgroundColor(Color.TRANSPARENT);
                }

                return itemView;
            }
        };

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Update the selected item position
                selectedItemPosition = position;
                adapter.notifyDataSetChanged();

                // Pass the selected province and position to the activity or another fragment
                String selectedProvince = provincesAndTerritories[position];
                sendResult(selectedProvince, position);
            }

            private void sendResult(String selectedProvince, int position) {
                Bundle result = new Bundle();
                result.putString(getString(R.string.selectedprovinceterritory), selectedProvince);
                result.putInt(getString(R.string.selectedindex), position + 1);

                getParentFragmentManager().setFragmentResult(getString(R.string.key), result);
            }
        });
        return view;
    }

    public interface OnItemSelectedListener {
        void onItemSelected(String item, int index);
    }

}
