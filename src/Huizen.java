import java.util.Scanner;

public class Huizen {
    public static void main(String[] args) {
        Woning kloksteeg = new Woning();
        Bouwvakker herman = new Bouwvakker();
        herman.repareren(kloksteeg.lekkage);
        Woning europaplein = new Appartement();
        europaplein.lekkage = false;
        herman.repareren(europaplein.lekkage);
        Bewoner minke = new Bewoner();
        minke.reparatieverzoek();
        if (minke.reparatieverzoek()) {
            herman.repareren(kloksteeg.lekkage);
        }

    }
}

class Woning {
    int kamer;
    int raam;
    int verdieping;
    boolean lekkage = false;
}

// is relatie / inheritance
class Appartement extends Woning {


}

// has relatie
class Bewoner {
    Woning c = new Woning();
    boolean lekkage = false;
    boolean  reparatieverzoek() {
        System.out.println("Heeft u een lekkage? Y/N");
        Scanner input = new Scanner(System.in);
        String antwoord = input.next();
        if (antwoord.equals("y")){
            c.lekkage = true;
            System.out.println("Er komt een monteur langs");
            return true;
        } else {
            c.lekkage = false;
            System.out.println("Er hoeft niemand langs te komen");
            return false;
        }
    }
}

class Bouwvakker {
    void repareren (boolean lekkage){
        if (lekkage){
            System.out.println("Ik ben de woning aan het repareren");
        } else {
            System.out.println("Er hoeft niks aan gerepareerd te worden");
        }
    }
}