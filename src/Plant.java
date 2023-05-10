import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public abstract class Plant extends Organism {
    public final int CHANCE =20;

    public Plant(int strength, int initiative, int x, int y, Species specie, World world) {
        super(strength,initiative, x, y, specie, world);
    }
    public void createOrganism(int x,int y){}
    public void collision(Organism organism){}
    public void draw(Graphics g, int x, int y, int width, int height){}
    @Override
    public void action() {
        ArrayList<Coords> available = new ArrayList<Coords>();
        Coords direction = new Coords();

        int chance = new Random().nextInt(CHANCE);
        if (chance == 0) {
            if (x > 0) {
                direction = new Coords();
                direction.x = x - 1;
                direction.y = y;
                available.add(direction);
            }
            if (x < world.getWidth() - 1) {
                direction = new Coords();
                direction.x = x + 1;
                direction.y = y;
                available.add(direction);
            }
            if (y < world.getHeight() - 1) {
                direction = new Coords();
                direction.x = x;
                direction.y = y + 1;
                available.add(direction);
            }
            if (y > 0) {
                direction = new Coords();
                direction.x = x;
                direction.y = y - 1;
                available.add(direction);
            }
            int size = available.size();
            if (size > 0) {
                direction = available.get(new Random().nextInt(size));
                seeding(direction.x, direction.y);
            }
        }
    }

    public void seeding(int x, int y) {
        if(world.getTab()[y][x]==null){
            createOrganism(x,y);
        }

    }
}
