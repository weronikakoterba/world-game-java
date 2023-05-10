import java.awt.Color;
import java.awt.Graphics;
public class Sheep extends Animal{
    public Sheep(int x,int y, World world){

        super(4,4, x,y, Species.sheep,world);
    }
    public void draw(Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.GRAY);
        g.fillRect(x, y, width, height);
    }
    public void createOrganism(int x, int y){
        Organism newSheep= new Sheep(x,y,world);
        world.addOrganism(newSheep,x,y);
    }
}
