package itay.finci.org.periodictable;


public class Periodic {
    private String name;
    private  String symbole;

    public Periodic(String name1, String symbole1){
        name = name1;
        symbole = symbole1;
    }

    public String getName() {
        return name;
    }

    public void setName(String body) {
        this.name = body;
    }

    public String  getSymbole() {
        return symbole;
    }

    public void setSymbole(String symbole) {
        this.symbole = symbole;
    }
}
