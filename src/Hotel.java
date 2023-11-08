import java.util.*;

public class Hotel {
    private HashMap<String, Integer> informacjaOPokojach = new HashMap<>();
    private LinkedHashMap<Integer, Boolean> rezerwacjaPokoje = new LinkedHashMap<>();
    public Hotel(int lacznaLiczbaPokoi) {
        informacjaOPokojach.put("liczbaZajetychPokoi", 0);
        informacjaOPokojach.put("liczbaWolnychPokoi", lacznaLiczbaPokoi);
        informacjaOPokojach.put("lacznaLiczbaPokoi", lacznaLiczbaPokoi);
        for (int i = 1; i < lacznaLiczbaPokoi; i++) {
            rezerwacjaPokoje.put(i, true);
        }
    }
    public int getLacznaLiczbaPokoi() {
        return informacjaOPokojach.get("lacznaLiczbaPokoi");
    }

    public int getLiczbaZajetychPokoi() {
        return informacjaOPokojach.get("liczbaZajetychPokoi");
    }

    public int getLiczbaWolnychPokoi() {
        return informacjaOPokojach.get("liczbaWolnychPokoi");
    }

    public void rezerwacjaPokoju (int liczbaRezerwowanych) {
            int aktualnaLiczbaWolnych = informacjaOPokojach.get(("liczbaWolnychPokoi"));
            if (liczbaRezerwowanych <= aktualnaLiczbaWolnych) {
                informacjaOPokojach.put("liczbaZajetychPokoi", getLiczbaZajetychPokoi() + liczbaRezerwowanych);
                informacjaOPokojach.put("liczbaWolnychPokoi", getLiczbaWolnychPokoi() - liczbaRezerwowanych);
            } else {
                if (getLiczbaWolnychPokoi() > 0) {
                    System.out.println("Przykro mi, nie ma takiej ilosci dostepnych pokoi");
                } else {
                    System.out.println("Przykro mi, nie ma zadnych wolnych pokoi.");
                }
            }
        }

    public void zwolnijPokoj (int liczbaZwalnianych) {
        int aktualnaLiczbaZajetch = informacjaOPokojach.get("liczbaZajetychPokoi");
        if (liczbaZwalnianych > 0 && aktualnaLiczbaZajetch >= liczbaZwalnianych) {
            informacjaOPokojach.put("liczbaZajetychPokoi", getLiczbaZajetychPokoi() - liczbaZwalnianych);
            informacjaOPokojach.put("liczbaWolnychPokoi", getLiczbaWolnychPokoi() + liczbaZwalnianych);
        } else {
            System.out.println("Nieprawidlowa ilosc zwalnianych pokoi");
        }
    }





}
