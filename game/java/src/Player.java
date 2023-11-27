public class Player {
    
    private int points;
    private final String name;
    private int hp;

    public Player(String n){
        this.name = n;
        this.points = 0;
        this.hp = 5;
    }

    public boolean isDead(){
        return this.hp <= 0;
    }

    public int getPoints(){
        return this.points;
    }

    public int getHp(){
        return this.hp;
    }

    public String getName(){
        return this.name;
    }

    public void win(){
        this.points += 100;
    }

    public void lose(){
        this.hp --;
    }
}
