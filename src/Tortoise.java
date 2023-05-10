import java.awt.*;
import java.util.Random;

public class Tortoise extends Animal{
    private int chance=4;
    public Tortoise(int x,int y, World world){

        super(9,5, x,y, Species.tortoise,world);
    }
    public void draw(Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.green);
        g.fillRect(x, y, width, height);
    }
    public void createOrganism(int x, int y){
        Organism newTortoise= new Tortoise(x,y,world);
        world.addOrganism(newTortoise,x,y);
    }
    public void action(){
        if(new Random().nextInt(chance)==0){
            super.action();
        }
    }
    public boolean willReflectAttack(Organism organism){
       if(organism.strength<5 && organism.species!=species) return true;
       return false;
    }
}
