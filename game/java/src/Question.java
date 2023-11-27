import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question {
    
    private String ennonce;
    private List<String> choix;
    private List<Integer> bonneReponses;
    private List<Integer> reponses;

    public Question(String e,List<String> c,List<Integer> b){
        this.ennonce = e;
        this.reponses = new ArrayList<Integer>();
        this.bonneReponses = b;
        this.choix = c;
    }

    public String getEnnonce(){
        return this.ennonce;
    }

    public void afficher(){
        String res ="";
        res = res + ennonce +"\n\n";
        for(int i = 0;i < choix.size();i ++){
            res = res +""+ (i+1) +" ) "+choix.get(i)+"\n";
        }
        res = res + "\n";
        System.out.println(res);
    }

    public void afficherCHEAT(){
        String res ="";
        res = res + ennonce +"\n\n";
        for(int i = 0;i < choix.size();i ++){
            res = res +""+ (i+1) +" ) "+choix.get(i)+"\n";
        }
        res = res +"bonne rep :";
        for(int i = 0;i < bonneReponses.size();i ++){
            res = res +bonneReponses.get(i)+"\n";
        }
        res = res + "\n";
        System.out.println(res);
    }

    public void joueurChoix(Integer[] reponses){
        ArrayList<Integer> reps = new ArrayList<Integer>();
        for(int r : reponses){
            reps.add(r);
        }
        this.reponses = reps;
    }

    public boolean isCorrect(){
        int nb = 0;
        Collections.sort(this.reponses);
        if(this.reponses.size() == this.bonneReponses.size()){
            for(int i = 0;i < this.reponses.size();i ++){
                if(this.reponses.get(i) == bonneReponses.get(i)){
                    nb ++;
                }
            }
            if(nb == this.bonneReponses.size()){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public void afficherBonneReponses(){
        String res = "";
        for(int i : bonneReponses){
            res = res + i+"\n";
        }
        System.out.println(res);
    }


}
