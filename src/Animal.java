import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public abstract class Animal extends Organism {
    protected int temp_x;
    protected int temp_y;
    protected int distance=1;


    public Animal(int strength, int initiative, int x, int y, Species species, World world) {
        super(strength,initiative, x,y, species,world);
    }


    @Override
    public void action() {

        int temp_x = x;
        int temp_y = y;

        ArrayList<Coords> available = new ArrayList<Coords>();
        Coords direction = new Coords();

        if ( x > distance-1 && willMove(x-1,y)) {
            direction = new Coords();
            direction.x = x - distance;
            direction.y = y;
            available.add(direction);
        }
        if ( x < world.getWidth() - distance && willMove(x+1,y)) {
            direction = new Coords();
            direction.x = x + distance;
            direction.y = y;
            available.add(direction);
        }
        if ( y < world.getHeight() - distance && willMove(x,y+1)) {
            direction = new Coords();
            direction.x = x;
            direction.y = y + distance;
            available.add(direction);
        }
        if ( y > distance-1 && willMove(x,y-1)) {
            direction = new Coords();
            direction.x = x;
            direction.y = y - distance;
            available.add(direction);
        }
        int size = available.size();
        if (size > 0) {
            direction = available.get(new Random().nextInt(size));
            if(willRunAway(direction.x,direction.y)==false)
                world.moveOrganism(temp_x, temp_y, direction.x, direction.y, true);
            else findNewPlace(temp_x,temp_y);
        }
    }
//

    public void reproduction(Organism organism) {
        x = temp_x;
        y = temp_y;

        if (temp_x < world.getWidth() - 1 && world.getTab()[temp_y][temp_x + 1] == null) {
            organism.createOrganism(temp_x + 1, temp_y);
        }
        else if (temp_x > 0 && world.getTab()[temp_y][temp_x - 1] == null) {
            organism.createOrganism(temp_x - 1, temp_y);
        }
        else if (temp_y < world.getHeight() - 1 && world.getTab()[temp_y + 1][temp_x] == null) {
            organism.createOrganism(temp_x, temp_y + 1);
        }
        else if (temp_y > 0 && world.getTab()[temp_y - 1][temp_x] == null) {
            organism.createOrganism(temp_x, temp_y - 1);
        }
    }

    @Override
    public void collision(Organism organism) {
        if (organism.killAllAnimals) {
            world.removeOrganism(this);
            return;
        }
        if (organism.species == this.species) {
            if (organism.age != 0)
            {
                reproduction(organism);
            }
            else
                return;
        }
        else {
            // walka
            if (this.strength >= organism.strength){
                if(organism.willReflectAttack(this) == false) {
                    if (organism.willIncreaseStrength(organism)) {
                        strength += 3;
                    }
                    // współrzędne zwierzęcia zabijanego
                    int temp_x = organism.getX();
                    int temp_y = organism.getY();
                    organism.getWorld().removeOrganism(organism);
                    world.moveOrganism(x, y, temp_x, temp_y, false);
                }
                else {
//                    swiat->dodajWyniki("Organizm " + swiat->wypiszOrganizmy(organizm) + "odbil atak organizmu " + swiat->wypiszOrganizmy(this) +
//                            "na polu (" + to_string(organizm->getX()) + ", " + to_string(organizm->getY()) + ")");
                }
            }
		else {
            //world.dodajWyniki("Zabito organizm " + swiat->wypiszOrganizmy(this));
            world.removeOrganism(this);
        }
        }
    }

    public boolean willMove(int x, int y) {
        return true;
    }
    public boolean willRunAway(int x,int y){
        return false;
    }
    public void findNewPlace(int x,int y){}

    public  void createOrganism(int x, int y){}
    public void draw(Graphics g, int x, int y, int width, int height){}

}
