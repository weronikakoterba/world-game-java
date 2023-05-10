import java.awt.*;

public class Milkweed extends Plant{
    public Milkweed(int x,int y, World world){
        super(0,0, x,y, Species.milkweed,world);
    }
    public void draw(Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.yellow);
        g.fillRect(x, y, width, height);
    }
    public void createOrganism(int x, int y){
        Organism newMilkweed= new Milkweed(x,y,world);
        world.addOrganism(newMilkweed,x,y);
    }
    public void action(){
        for(int i=0;i<3;i++){
            super.action();
        }
    }
}
