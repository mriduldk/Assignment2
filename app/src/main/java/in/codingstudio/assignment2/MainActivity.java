package in.codingstudio.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import in.codingstudio.assignment2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private final String[] colors = {"Select Color","RED", "GREEN", "BLUE"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = binding.editTextMessage.getText().toString().trim();
                if(!message.equals("")){
                    int position = binding.spinnerColors.getSelectedItemPosition();

                    switch (position){
                        case 0:
                            Snackbar.make(binding.relativeLayoutParent, "Please select any color", BaseTransientBottomBar.LENGTH_LONG).show();
                            break;
                        case 1:
                            binding.textViewResult.setText(message);
                            binding.textViewResult.setBackgroundColor(getResources().getColor(R.color.red));
                            break;
                        case 2:
                            binding.textViewResult.setText(message);
                            binding.textViewResult.setBackgroundColor(getResources().getColor(R.color.green));
                            break;
                        case 3:
                            binding.textViewResult.setText(message);
                            binding.textViewResult.setBackgroundColor(getResources().getColor(R.color.blue));
                            break;
                    }


                }else{
                    binding.editTextMessage.setError("Message is empty");
                    binding.editTextMessage.requestFocus();
                }
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, colors);
        //adapter.setDropDownViewResource();
        binding.spinnerColors.setAdapter(adapter);


    }
}