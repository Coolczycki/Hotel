import java.util.ArrayList;
import java.util.Scanner;

// TODO:
// 1. Opcja Zwolnij pokoj
// 2. Opcja pokaz stan
// 3. Do opcji pokaz stan dodac wyswietlanie z imienia nazwiska ile pokoi
// 4. W opcji zarezerwuj pokoj przypisywac do obiektu ilosc zarezerwowanych pokoi + ich numery ?
// 5. Hotel wielkosci 30 pokoi. W momencie rezerwacji uzytkownik wpisuje jakie pokoje rezerwuje
//    lista klucz + wartosc. Kluczem bedzie numer pokoju wartoscia true / false. Czyli mapa. Mapa elementow unikatowych bo
// pokoj nie moze wystapic dwa razy.
// 6. dodac date wykonania rezerwacji z data systemowa

public class Main {
    public static void main(String[] args) {
        ArrayList<Gosc> listaGosci = new ArrayList<>();
        listaGosci.add(new Gosc(1, "Jan", "Kowalski", 3456_2134_4213_1236L));
        listaGosci.add(new Gosc(2, "Maria", "Konopnicka", 6532_1245_3251_1235L));
        listaGosci.add(new Gosc(3, "Jozef", "Pilsudzki", 5432_1234_6432_1234L));
        Scanner scr = new Scanner(System.in);

        System.out.println("Witaj w aplikacji Hotel. Prosze podaj ile pokoi ma posiadac twoj hotel ? ");
        int ile = scr.nextInt();

        //tablica z numerami pokojow do rezerwacji;
        boolean[] dostepnePokoje = new boolean[ile];


        if (ile > 0) {
            Hotel mojHotel = new Hotel(ile);
            char L;
            do {
                System.out.println("Dysponujesz hotelem o wielkosci " + ile + " pokoi. Wybierz akcje:");
                System.out.println("Rejestracja nowego goscia - N");
                System.out.println("Zarezerwuj pokoj - Z");
                System.out.println("Zwolnij pokoj - W");
                System.out.println("Pokaz stan - P");
                System.out.println("Zakoncz - E");
                L = scr.next().charAt(0);
                L = Character.toLowerCase(L);

                switch (L) {

                    case 'z' -> {
                        while (true) {
                            System.out.println("Wybierz goscia");
                            System.out.println("");
                            System.out.println("Lista gosci: ");
                            for (Gosc gosc : listaGosci) {
                                System.out.println("ID: " + gosc.getID());
                                System.out.println("Imię: " + gosc.getImie());
                                System.out.println("Nazwisko: " + gosc.getNazwisko());
                                System.out.println("Numer konta: " + gosc.getNrKonta());
                                System.out.println("---------------------------------------");
                            }

                            int ktory = scr.nextInt();
                            Gosc wybranyGosc = null;
                            for (Gosc gosc : listaGosci) {
                                if (gosc.getID() == ktory) {
                                    wybranyGosc = gosc;
                                    break;
                                }
                            }

                            if (wybranyGosc != null) {
                                // Wybrany gość został znaleziony na liście
                                System.out.println("Wybrany gość to: " + wybranyGosc.getImie() + " " + wybranyGosc.getNazwisko());
                                System.out.println("Numer konta wskazany do rozliczenia: " + wybranyGosc.getNrKonta());
                            } else {
                                System.out.println("Nie znaleziono gościa o podanym numerze ID.");
                            }


                            System.out.println("Ile pokoi chcesz zarezerwowac?");
                            int liczbaRezerw = scr.nextInt();
                            mojHotel.rezerwacjaPokoju(liczbaRezerw);




                            System.out.println("Zostalo zarezerwowanych " + liczbaRezerw + " pokoi dla goscia " + wybranyGosc.getImie() + " " + wybranyGosc.getNazwisko());
                            System.out.println("");
                            break;
                        }

                    }

                    case 'n' -> {
                        System.out.println("Podaj imie: ");
                        String imie = scr.next();
                        System.out.println("Podaj nazwisko: ");
                        String nazwisko = scr.next();
                        System.out.println("Podaj numer konta: ");
                        Long nr = scr.nextLong();
                        Gosc ostatniGosc = listaGosci.get(listaGosci.size() - 1);
                        int ostatnieID = ostatniGosc.getID();
                        int newID = ostatnieID + 1;
                        listaGosci.add(new Gosc(newID, imie, nazwisko, nr));
                    }





                }
            } while (L != 'e');
        } else {
            System.out.println("Nie mozesz stworzyc hotelu o takiej wielkosci");

        }

    }
}