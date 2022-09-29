package Data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes")
public class DBNote {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "note_id")
    private long id;
    @ColumnInfo(name = "heading_id")
    private String heading;
    @ColumnInfo(name = "main_id")
    private String main;
    @ColumnInfo(name = "image_id")
    private String image;

    @Ignore
    public DBNote() {
    }

    public DBNote(long id, String heading, String main, String image) {
        this.id = id;
        this.heading = heading;
        this.main = main;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
