import java.awt.*;

public abstract class Organism {
    protected World world;
    protected Species species;
    protected int initiative;
    protected int strength;
    protected int age = 0;

    protected int x;
    protected int y;
    protected boolean killAllAnimals = false;

    public Organism(int strength, int initiative, int x, int y, Species species, World world) {
        this.strength = strength;
        this.initiative = initiative;
        this.x = x;
        this.y = y;
        this.species = species;
        this.world = world;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getAge() {
        return age;
    }

    public int getInitiative() {
        return initiative;
    }

    public int getStrength() {
        return strength;
    }

    public Species getSpecies() {
        return species;
    }

    public World getWorld() {
        return world;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void increaseAge() {
        age++;
    }
    public abstract void action();
//
    public abstract void collision(Organism organism);

    public abstract void createOrganism(int x,int y);

    public abstract void draw(Graphics g, int x, int y, int width, int height);


    public boolean willReflectAttack(Organism organism){
        return false;
    }
    public boolean willIncreaseStrength(Organism organism){
        return false;
    }
//
//    public abstract boolean willAttack(int x, int y);
//
//    public abstract void createOrganism(int x, int y);

    //public abstract boolean willIncreaseStrength(Organism organism);

    //public abstract boolean willDie();

}
