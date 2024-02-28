// Michael Quon N01565129
package michael.quon.n01565129;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SettingsFragment extends Fragment {

    private TextView provinceTextView;
    private TextView indexTextView;

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        // Initialize views
        provinceTextView = view.findViewById(R.id.MicProvince);
        indexTextView = view.findViewById(R.id.MicIndex);

        // Set up fragment result listener to receive province and index data
        getParentFragmentManager().setFragmentResultListener(getString(R.string.key), this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                String selectedProvince = result.getString(getString(R.string.selectedprovinceterritory));
                int selectedIndex = result.getInt(getString(R.string.selectedindex));

                updateUI(selectedProvince, selectedIndex);
            }
        });

        return view;
    }

    private void updateUI(String selectedProvince, int selectedIndex) {
        provinceTextView.setText(selectedProvince);
        indexTextView.setText(getString(R.string.index2) + selectedIndex);
    }
}
