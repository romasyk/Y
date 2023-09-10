package structure.domain;

public class Profile {
   private String name;
    private  String photo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Profile(String name, String photo) {
        this.name = name;
        this.photo = photo;
    }
}
