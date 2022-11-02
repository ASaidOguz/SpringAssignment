package kodlama.io.Devs.entities.concretes;

public class Language {
    private int id;
    private String name;

    public Language(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Language(int _id, String _name){
        this.id=_id;
        this.name=_name;
    }
}
