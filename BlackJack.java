import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.List;

public class BlackJack {
    public static void main(String[] args) {
        int[] kaartnummer = new int[52];
        int[] kaartkleur = new int[52];
        int[] kaartcode = new int[52];
        int[] kaartwaarde = new int[52];
        String[] kleur = new String[52];

        //AFBLIJVEN! ARRAY WERKT ZO!
        ArrayList<Kaart> kaarten = new ArrayList<Kaart>(52);
        for (int x = 0; x < kaartnummer.length; x++){

            kaarten.add(new Kaart(kaartnummer,kaartkleur,kaartcode,kaartwaarde,kleur));
        }



        for (int x = 0; x < kaartnummer.length; x++) { // kaartnummer.length wordt geteld als een mens (begint bij 1), terwijl de array telt als een index (dus begint bij 0). Hij moet dus x < .length zijn, want bij <= valt hij buiten de array.
            kaartnummer[x] = x + 1;
            kaartkleur[x] = (kaartnummer[x] - 1) / 13;
            kaartcode[x] = (kaartnummer[x]) % 13;
            switch (kaartcode[x]) {
                    case 0:
                        kaartwaarde[x] = 10;
                        kaartcode[x] = 13;
                        break;
                    case 1:
                        kaartwaarde[x] = 11;
                        break;
                    case 11:
                        kaartwaarde[x] = 10;
                        break;
                    case 12:
                        kaartwaarde[x] = 10;
                        break;
                    default:
                        kaartwaarde[x] = kaartcode[x];
                        break;
                }

                switch (kaartkleur[x]) {
                    case 0:
                        kleur[x] = "S";
                        break;
                    case 1:
                        kleur[x] = "H";
                        break;
                    case 2:
                        kleur[x] = "R";
                        break;
                    case 3:
                        kleur[x] = "K";
                        break;
                    }
                    System.out.println("kaartid is " + kaartnummer[x] + ", dit is de " + kleur[x] + kaartcode[x] + " met waarde " + kaartwaarde[x]);
            }
        Collections.shuffle(kaarten);
        System.out.println(kaarten.get(0).kaartnummer());
        Scanner player = new Scanner(System.in);
        int punten = kaarten.get(0).kaartwaarde() + kaarten.get(1).kaartwaarde();
        int i = 2;
        System.out.println("U heeft nu " + punten + " punten. Wilt u een kaart? Toets K. Wilt u passen? Toets P. Wilt u stoppen? Toets Q.");
        String antwoord = player.next();
        switch (antwoord) {
            case "K":
            case "k":
                punten +=  kaarten.get(i).kaartwaarde();
                i++;
                if(punten>21){
                    System.out.println("Helaas, u heeft verloren, wilt u een nieuw spel starten? J/N");
                    antwoord = player.next();
                    if(antwoord = "J");
                }
                break;
            case "P":
            case "p":
                ;
                break;
            case "Q":
            case "q":
                ;
                break;
            default:
                System.out.println("Gelieve een K, P of Q invoeren");
                antwoord = player.next();
                ;
                break;
        }
    }
}







class Kaart {
    public Kaart(int[] kaartnummer, int[] kaartkleur, int[] kaartcode, int[] kaartwaarde, String[] kleur) {
    }

    int kaartnummer(int x){
        return x + 1;
    };
    int kaartkleur(int x){
        return (x - 1) / 13;
    };
    int kaartwaarde(int x){
        x = x % 13;
        switch (x) {
            case 0:
                x = 10;
                break;
            case 1:
                x = 11;
                break;
            case 11:
                x = 10;
                break;
            case 12:
                x = 10;
                break;
        }
        return x;

    };
    String kleur (int x){
        String soort;
        switch (x) {
            case 0:
                soort = "S";
                break;
            case 1:
                soort = "H";
                break;
            case 2:
                soort = "R";
                break;
            case 3:
                soort = "K";
                break;
            default:
                soort = "";
        }
        return soort;
    };
    }

