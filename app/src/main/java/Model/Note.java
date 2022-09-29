package Model;

public class Note {
    private long id;
    private String heading;
    private String main;
    private String image;

    public Note() {
    }
    public Note(long id, String heading, String main, String image) {
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
