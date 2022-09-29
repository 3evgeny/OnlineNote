package Activities;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.melself.onlinenote.R;
import com.melself.onlinenote.databinding.FragmentNoteBinding;

import java.util.List;

import Adapters.NoteAdapter;
import Data.DBNote;
import Model.Note;
import ViewModel.AppViewModel;

public class NoteFragment extends Fragment {

    FragmentNoteBinding binding;
    AppViewModel model;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNoteBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        model = new ViewModelProvider(this).get(AppViewModel.class);

        binding.noteRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        binding.noteRecyclerView.setHasFixedSize(true);
        NoteAdapter noteAdapter = new NoteAdapter();
        binding.noteRecyclerView.setAdapter(noteAdapter);

        model.getAllNotes().observe(getViewLifecycleOwner(), new Observer<List<DBNote>>() {
            @Override
            public void onChanged(List<DBNote> notes) {
                noteAdapter.setNote(notes);
            }
        });

    }
}