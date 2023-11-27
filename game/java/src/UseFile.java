import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class UseFile {


    public static Question getRandomQuestionFromBDD(){
        Properties pr = new Properties();
        
        try (FileInputStream fis = new FileInputStream("../../postgres.prop")) {
            pr.load(fis);
            Class.forName(pr.getProperty("driver"));
            try (Connection con = DriverManager.getConnection(pr.getProperty("url"), pr.getProperty("nom"), pr.getProperty("mdp"));
                PreparedStatement pstmt = con.prepareStatement("SELECT * FROM QUESTIONS_MUSCLES ORDER BY RANDOM() LIMIT 1;");
                ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String label = rs.getString("label");
                    String[] choices = rs.getString("choix").split(";");
                    String[] repStr = rs.getString("reponse").split(";");

                    ArrayList<String> choiceList = new ArrayList<>(Arrays.asList(choices));
                    
                    ArrayList<Integer> answerList = new ArrayList<>();
                    for (String s : repStr) {
                        answerList.add(Integer.parseInt(s));
                    }

                    return new Question(label, choiceList, answerList);
                } else {
                    return null;
                }
            }
            
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
            return null;
        }
    }

    public static void saveOnBdd(String playerName,int score){
        try{
            Properties pr = new Properties();
            FileInputStream fis = new FileInputStream("../../postgres.prop");
            pr.load(fis);
            Class.forName(pr.getProperty("driver"));
            Connection con = DriverManager.getConnection(pr.getProperty("url"), pr.getProperty("nom"), pr.getProperty("mdp"));
            PreparedStatement pstmt = con.prepareStatement("SELECT score FROM SCORE_PLAYER_MUSCLES WHERE nom = ?;");
            pstmt.setString(1, playerName);
            ResultSet rs = pstmt.executeQuery();
            int sc = -1;
            while(rs.next()){
                sc = Integer.parseInt(rs.getString("score"));
            }
            if(sc != -1 && score > sc){
                //le nom existe deja et le score est mieux
                Statement stmt1 = con.createStatement();
                stmt1.executeUpdate("UPDATE SCORE_PLAYER_MUSCLES SET score = "+score+" WHERE nom = '"+playerName+"'");
            }else if(sc != -1 && score <= sc){
                //le nom existe deja mais le score est pas mieux
                System.out.println("Score pas encore battu !");
            }else{
                //le nom n'existe pas encore dutout
                Statement stmt2 = con.createStatement();
                stmt2.executeUpdate("INSERT INTO SCORE_PLAYER_MUSCLES VALUES('"+playerName+"',"+score+")");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
