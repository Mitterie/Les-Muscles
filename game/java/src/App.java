import java.time.LocalTime;
import java.util.Scanner;

//Un big quiz sur l'univers des musclés
//on recup les question depuis une bdd
//et on save les score sur une bdd
public class App {

    public static final String CLEAR_SCREEN = "\033[H\033[2J";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";  
    public static final String RESET = "\033[0m";

    public static void wait(int sec){
        LocalTime t1 = LocalTime.now();
        LocalTime end = t1.plusSeconds(sec);
        while(t1.isBefore(end)){
            t1 = LocalTime.now();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player player;
        System.out.println("Quel est ton nom ?");
        player = new Player(sc.nextLine());
        System.out.println("C'est parti pour le Quiz des muscles !");
        Question q = null;
        String rep = "";
        String[] reps;
        Integer[] finalrep;
        wait(1);
        while(!player.isDead()){
            System.out.println(CLEAR_SCREEN);
            q = UseFile.getRandomQuestionFromBDD();
            System.out.println(player.getName()+"\nHP : "+player.getHp()+"\nScore : "+player.getPoints());
            System.out.println("(Si il y a plusieurs reponses correcte met un ';' entre chaque reponse)\n\n");
            q.afficher();
            rep = sc.nextLine();
            reps = rep.split(";");
            finalrep = new Integer[reps.length];
            for(int i = 0;i < reps.length;i ++){
                try{
                    finalrep[i] = Integer.parseInt(reps[i]);
                }catch(Exception e){
                    finalrep[i] = 1000;
                }
            }
            q.joueurChoix(finalrep);
            if(q.isCorrect()){
                System.out.println(GREEN+"CORRECT"+RESET);wait(2);
                player.win();
            }else{
                System.out.println(RED+"INCORRECT"+RESET);wait(2);
                player.lose();
            }
        }
        wait(1);
        System.out.println(CLEAR_SCREEN);
        System.out.println("BIEN JOUE "+player.getName()+"\nSCORE FINAL : "+player.getPoints());
        UseFile.saveOnBdd(player.getName(),player.getPoints());
        wait(5);
        System.out.println(CLEAR_SCREEN);
        sc.close();
    }

}