import java.awt.*;

public class Hogweed extends Plant {
    public Hogweed(int x,int y, World world){

        super(10,0, x,y, Species.hogweed,world);
        killAllAnimals=true;
    }
    public void draw(Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.blue);
        g.fillRect(x, y, width, height);
    }
    public void createOrganism(int x, int y){
        Organism newHogweed= new Hogweed(x,y,world);
        world.addOrganism(newHogweed,x,y);
    }

    public void killNeighbours() {
        if (x < world.getWidth() - 1 && world.getTab()[y][x + 1] != null && world.getTab()[y][x + 1].getSpecies() != getSpecies() &&
                world.getTab()[y][x + 1].getInitiative() != 0) {
            world.removeOrganism(world.getTab()[y][x + 1]);
        }
        if (x > 0 && world.getTab()[y][x - 1] != null && world.getTab()[y][x - 1].getSpecies() != getSpecies() &&
                world.getTab()[y][x - 1].getInitiative() != 0) {
            world.removeOrganism(world.getTab()[y][x - 1]);
        }
        if (y < world.getHeight() - 1 && world.getTab()[y + 1][x] != null && world.getTab()[y + 1][x].getSpecies() != getSpecies() &&
                world.getTab()[y + 1][x].getInitiative() != 0) {
            world.removeOrganism(world.getTab()[y + 1][x]);
        }
        if (y > 0 && world.getTab()[y - 1][x] != null && world.getTab()[y - 1][x].getSpecies() != getSpecies() &&
                world.getTab()[y - 1][x].getInitiative() != 0) {
            world.removeOrganism(world.getTab()[y - 1][x]);
        }
    }

    public void action(){
        super.action();
        killNeighbours();
    }
}
