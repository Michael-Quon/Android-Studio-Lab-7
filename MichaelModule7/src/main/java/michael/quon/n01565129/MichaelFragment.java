// Michael Quon N01565129
package michael.quon.n01565129;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MichaelFragment extends Fragment {

    public MichaelFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_michael, container, false);

        RadioGroup radioGroup = view.findViewById(R.id.MicRadioGroup);

        RadioButton radioButton1 = view.findViewById(R.id.MicRadioButton1);
        radioButton1.setChecked(true);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton selectedRadioButton = view.findViewById(checkedId);
                displayAlertDialog(selectedRadioButton.getText().toString());
            }
        });
        return view;
    }

    private void displayAlertDialog(String radioButtonText) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setIcon(R.drawable.cn_tower);
        builder.setTitle(getString(R.string.name));
        builder.setMessage(radioButtonText);
        builder.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

}