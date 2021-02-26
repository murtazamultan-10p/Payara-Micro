package fish.payara.temp;

public class Actor {

    private Integer id;
    private String fname;
    private String lname;

    public Actor() {
    }

    public Actor(int actor_id, String first_name, String last_name) {
        this.id = actor_id;
        this.fname = first_name;
        this.lname = last_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                '}';
    }
}
