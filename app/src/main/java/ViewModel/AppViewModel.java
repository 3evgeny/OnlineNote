package ViewModel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;
import Data.AppRepository;
import Data.DBNote;

public class AppViewModel extends AndroidViewModel {
    private final AppRepository appRepository;
    private LiveData<List<DBNote>> getAllNotes;

    public AppViewModel(@NonNull Application application) {
        super(application);
        appRepository = new AppRepository(application);
        getAllNotes = appRepository.getAllNotes();
    }

    // Methods ViewModel for the local database
    public void insert(DBNote note){
        appRepository.insert(note);
    }

    public void update(DBNote note){
        appRepository.update(note);
    }

    public void delete(DBNote note){
        appRepository.delete(note);
    }

    public LiveData<List<DBNote>> getAllNotes(){
        return getAllNotes;
    }
}
