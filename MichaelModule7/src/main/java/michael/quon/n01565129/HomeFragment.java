// Michael Quon N01565129
package michael.quon.n01565129;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

public class HomeFragment extends Fragment {

    private ProgressBar progressBar;
    private int counter = 0;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        progressBar = view.findViewById(R.id.MicProgressBar);
        ImageButton imageButton = view.findViewById(R.id.MicImageButton);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                if (counter < 8) {
                    Toast.makeText(getContext(), getString(R.string.name) + counter, Toast.LENGTH_SHORT).show();
                } else if (counter == 8) {
                    requireActivity().finish();
                }

                if (counter == 5) {
                    progressBar.setVisibility(View.GONE);
                }
            }
        });

        return view;
    }
}