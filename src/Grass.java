import java.awt.*;

public class Grass extends Plant {
    public Grass(int x,int y, World world){
        super(0,0, x,y, Species.grass,world);
    }
    public void draw(Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.green);
        g.fillRect(x, y, width, height);
    }
    public void createOrganism(int x, int y){
        Organism newGrass= new Grass(x,y,world);
        world.addOrganism(newGrass,x,y);
    }
}
