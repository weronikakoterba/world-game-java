import java.awt.*;

public class Fox extends Animal {
    public Fox(int x, int y, World world){
        super(3,7, x,y, Species.fox,world);
    }
    public void draw(Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.orange);
        g.fillRect(x, y, width, height);
    }
    public void createOrganism(int x, int y){
        Organism newFox= new Fox(x,y,world);
        world.addOrganism(newFox,x,y);
    }

    public boolean willMove(int x,int y){
        Organism organism = world.getTab()[y][x];
        if (organism == null) return true;
        if (organism.getStrength() > getStrength() && organism.getSpecies() != getSpecies()) {
            return false;
        }
        return true;
    }
}
