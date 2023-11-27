public class Test {

    //compil :  javac -d bin src/*.java
    //exe :  java -cp "bin;lib\postgresql-42.6.0.jar;.;" Test
    //depuis java
    
    public static void main(String[] args) {
        Question q = UseFile.getRandomQuestionFromBDD();
        q.afficherCHEAT();
    }
}
