package Bean;

public class Actor {
    private String name;
    private String actFilm;
    private String[] role;

    public Actor(String name,String actFilm, String[] role){
        this.name = name;
        this.actFilm = actFilm;
        this.role = role;
    }

    public String getActFilm() {
        return actFilm;
    }

    public String[] getRole() {
        return role;
    }
}
