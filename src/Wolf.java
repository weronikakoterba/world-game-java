import java.awt.*;

public class Wolf extends Animal{
    public Wolf(int x,int y, World world){
       super(9,5, x,y, Species.wolf,world);
    }
    public void draw(Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.BLACK);
        g.fillRect(x, y, width, height);
    }
    public void createOrganism(int x, int y){
        Organism newWolf= new Wolf(x,y,world);
        world.addOrganism(newWolf,x,y);
    }
}
