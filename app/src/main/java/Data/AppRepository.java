package Data;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import Model.Note;

public class AppRepository {
    private NoteDAO noteDAO;
    private LiveData<List<DBNote>> allNote;

    public AppRepository(Application application){
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        noteDAO = appDatabase.getNoteDao();
        allNote = noteDAO.getAllNoteLive();
    }

    // Methods for the local database
    public void insert(DBNote note){
        new InsertNoteAsyncTask(noteDAO).execute(note);
    }

    public void update(DBNote note){
        new UpdateNoteAsyncTask(noteDAO).execute(note);
    }

    public void delete(DBNote note){
        new DeleteNoteAsyncTask(noteDAO).execute(note);
    }

    public LiveData<List<DBNote>> getAllNotes(){
        return allNote;
    }

    private static class InsertNoteAsyncTask extends AsyncTask<DBNote, Void, Void> {
        private NoteDAO noteDAO;
        private InsertNoteAsyncTask(NoteDAO noteDAO){
            this.noteDAO = noteDAO;
        }

        @Override
        protected Void doInBackground(DBNote... notes) {
            noteDAO.insertNote(notes[0]);
            return null;
        }
    }

    private static class UpdateNoteAsyncTask extends AsyncTask<DBNote, Void, Void>{
        private NoteDAO noteDAO;
        private UpdateNoteAsyncTask(NoteDAO noteDAO){
            this.noteDAO = noteDAO;
        }

        @Override
        protected Void doInBackground(DBNote... notes) {
            noteDAO.updateNote(notes[0]);
            return null;
        }
    }

    private static class DeleteNoteAsyncTask extends AsyncTask<DBNote, Void, Void>{
        private NoteDAO noteDAO;
        private DeleteNoteAsyncTask(NoteDAO noteDAO){
            this.noteDAO = noteDAO;
        }

        @Override
        protected Void doInBackground(DBNote... notes) {
            noteDAO.deleteNote(notes[0]);
            return null;
        }
    }
}
