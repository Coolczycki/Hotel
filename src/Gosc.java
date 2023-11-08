import java.math.BigInteger;

public class Gosc {
    int ID;
    String imie;
    String nazwisko;
    Long nrKonta;

    public Gosc(int ID, String imie, String nazwisko, Long nrKonta) {
        this.ID = ID;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nrKonta = nrKonta;
    }
    public int getID() {return ID;}

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Long getNrKonta() {
        return nrKonta;
    }

    public void setNrKonta(Long nrKonta) {
        this.nrKonta = nrKonta;
    }


}
