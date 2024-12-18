package voting;

public class Candidate {
    private String name;
    private String position;
    private int id;

    public Candidate(String name, String position, int id) {
        this.name = name;
        this.position = position;
        this.id = id;
    }

    public Candidate() {

    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getId() {
        return id;
    }




}
