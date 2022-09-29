package Activities;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.melself.onlinenote.R;
import com.melself.onlinenote.databinding.ActivityAddNoteBinding;

import Data.DBNote;
import Model.Note;
import ViewModel.AppViewModel;

public class AddNoteActivity extends AppCompatActivity {

    private ActivityAddNoteBinding binding;
    AppViewModel model;
    Uri uriImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        binding = ActivityAddNoteBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        model = new ViewModelProvider(this).get(AppViewModel.class);

        ActivityResultLauncher<String[]> getContent = getActivityResultRegistry().register("key", new ActivityResultContracts.OpenDocument(), result -> {
            getContentResolver().takePersistableUriPermission(result, Intent.FLAG_GRANT_READ_URI_PERMISSION);

            binding.imageView.setImageURI(result);
            uriImage = result;
        });

        binding.btnSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getContent.launch(new String[]{"image/*"});
            }
        });

        binding.btnSendNone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.insert(new DBNote(0, binding.inputHeader.getText().toString(),binding.inputMain.getText().toString(), uriImage.toString()));
                Intent i = new Intent(AddNoteActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}