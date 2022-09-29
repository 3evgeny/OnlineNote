package Data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import Model.Note;

@Dao
public interface NoteDAO {

    @Insert
    public void insertNote(DBNote dbNote);

    @Update
    public void updateNote(DBNote dbNote);

    @Delete
    public void deleteNote(DBNote dbNote);

    @Query("select * from notes")
    public LiveData<List<DBNote>> getAllNoteLive();

    @Query("select * from notes where note_id ==:note_id ")
    public DBNote getNote(long note_id);
}
