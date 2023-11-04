package structure.domain;

public class Profile {
   private String name;
    private Long id;
    private String email;
    private String password;
    private  String photo;
    private String info;
       private String lastLogining;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getLastLogining() {
        return lastLogining;
    }

    public void setLastLogining(String lastLogining) {
        this.lastLogining = lastLogining;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public Profile(String name,String photo, String email, String password, long id) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.password = password;
        this.photo = photo;
    }

    public Profile(String name, String photo) {
        this.name = name;
        this.photo = photo;
    }

    public Profile(long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public Profile(String name, Long id, String email, String password, String photo, String info, String lastLogining) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.password = password;
        this.photo = photo;
        this.info = info;
        this.lastLogining = lastLogining;
    }
}
