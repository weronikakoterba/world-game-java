import java.awt.*;

public class WolfBerries extends Plant {
    public WolfBerries(int x, int y, World world) {
        super(99, 0, x, y, Species.wolfBerries, world);
        killAllAnimals=true;
    }

    public void draw(Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.pink);
        g.fillRect(x, y, width, height);
    }

    public void createOrganism(int x, int y) {
        Organism newWolfBerries = new WolfBerries(x, y, world);
        world.addOrganism(newWolfBerries, x, y);
    }

}
