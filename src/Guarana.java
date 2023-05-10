import java.awt.*;

public class Guarana extends Plant {
    public Guarana(int x,int y, World world){
        super(0,0, x,y, Species.guarana,world);
    }
    public void draw(Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.red);
        g.fillRect(x, y, width, height);
    }
    public void createOrganism(int x, int y){
        Organism newGuarana= new Guarana(x,y,world);
        world.addOrganism(newGuarana,x,y);
    }
    public boolean willIncreaseStrength(){
        return true;
    }
}
