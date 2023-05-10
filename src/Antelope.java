import java.awt.*;
import java.util.Random;

public class Antelope extends Animal {
    public Antelope(int x, int y, World world) {
        super(4, 4, x, y, Species.antelope, world);
        distance = 2;
    }

    public void draw(Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.yellow);
        g.fillRect(x, y, width, height);
    }

    public void createOrganism(int x, int y) {
        Organism newAntelope = new Antelope(x, y, world);
        world.addOrganism(newAntelope, x, y);
    }

    public boolean willRunAway(int x, int y) {
        if (world.getTab()[y][x] != null && species != world.getTab()[y][x].species) {
            int chance = new Random().nextInt(2);
            if (chance == 0) return true;
            else return false;
        }
         else return false;
    }

    public void findNewPlace(int x,int y){
        distance=1;
        temp_x = x;
        temp_y = y;

        if (x < world.getWidth() - 1 && world.getTab()[y][x+1]==null) {
            world.moveOrganism(temp_x, temp_y, x + 1, y, true);
        }
        else if (x > 0 && world.getTab()[y][x-1]==null) {
            world.moveOrganism(temp_x, temp_y, x - 1, y, true);
        }
        else if (y < world.getHeight() - 1 && world.getTab()[y+1][x]==null) {
            world.moveOrganism(temp_x, temp_y, x, y + 1, true);
        }
        else if (y > 0 && world.getTab()[y-1][x]==null) {
            world.moveOrganism(temp_x, temp_y, x, y - 1, true);
        }
    }
}
