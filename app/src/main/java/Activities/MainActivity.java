package Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.melself.onlinenote.R;
import com.melself.onlinenote.databinding.ActivityMainBinding;

import java.util.List;

import ViewModel.AppViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    AppViewModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Uri uri = getIntent().getData();
        if (uri != null){
            List<String> params = uri.getPathSegments();
            String id = params.get(params.size()-1);
            Toast.makeText(this, "id="+id, Toast.LENGTH_SHORT).show();
        }

        model = new ViewModelProvider(this).get(AppViewModel.class);

        replaceFragment(new NoteFragment());
        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AddNoteActivity.class);
                startActivity(i);
            }
        });
    }

    // Change Fragment
    public void replaceFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        //ft.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
        ft.replace(R.id.frame_layout, fragment);
        ft.commit();
    }
}