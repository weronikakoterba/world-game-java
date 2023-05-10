import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class World {
    private int height;
    private int width;
    private int turn = 1;
    private Organism[][] tab;
    private ArrayList<Organism> organisms = new ArrayList<>();
    private ArrayList<String> results = new ArrayList<>();
    public static final int MAX_VALUE = 10;
    public World(int width, int height) {
        this.width = width;
        this.height = height;
        this.tab = new Organism[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tab[y][x] = null;
            }
        }
    }

    public World() {}
    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public Organism[][] getTab() {
        return this.tab;
    }

    public void executeTurn() {
        bubbleSortOrganisms();
        int howMuch = organisms.size();
        for (int i = 0; i < howMuch; i++)
        {
            if (organisms.get(i) != null) {
                organisms.get(i).action();
            }
        }
        organisms.removeIf(e -> e == null);
        for (int i = 0; i < organisms.size(); i++) {
            if (organisms.get(i) != null) {
                organisms.get(i).increaseAge();
            }
        }
        turn++;
    }

    public void newTurn() {
        // implementation
    }

//    public void drawWorld() {
//        for (int y = 0; y < height; y++) {
//            for (int x = 0; x < width; x++) {
//                if (tab[y][x] == null) {
//                    System.out.print('-');
//                }
//                else {
//                    tab[y][x].draw();
//                }
//            }
//            System.out.println();
//        }
//    }

    public void drawResults() {
        int amountOfNotifications;
        if (results.size() < MAX_VALUE)
        {
            amountOfNotifications = results.size();
        }
        else
        {
            amountOfNotifications = MAX_VALUE;
        }
        for (int i = 0; i < amountOfNotifications; i++) {
            System.out.println(results.get(i));
        }
    }

    public void addResult(String result) {
        this.results.add(result);
    }

    public int[] randomizeCoordinates() {
        Random rand = new Random();
        int x;
        int y;
        do {
            x = rand.nextInt(width-1);
            y = rand.nextInt(height-1);
        } while (tab[y][x] != null);
        return new int[] { x, y };
    }

    public void printOrganism() {
        Organism newOrganism;
        int[] coordinates;
        int newX;
        int newY;
        for (int i = 0; i <1; i++) {
            coordinates= randomizeCoordinates();
            newX = coordinates[0];
            newY = coordinates[1];
            newOrganism = new Sheep(newX, newY, this);
            addOrganism(newOrganism,newX,newY);

            coordinates= randomizeCoordinates();
            newX = coordinates[0];
            newY = coordinates[1];
            newOrganism = new Wolf(newX, newY, this);
            addOrganism(newOrganism,newX,newY);

            coordinates= randomizeCoordinates();
            newX = coordinates[0];
            newY = coordinates[1];
            newOrganism = new Fox(newX, newY, this);
            addOrganism(newOrganism,newX,newY);

            coordinates= randomizeCoordinates();
            newX = coordinates[0];
            newY = coordinates[1];
            newOrganism = new Tortoise(newX, newY, this);
            addOrganism(newOrganism,newX,newY);

            coordinates= randomizeCoordinates();
            newX = coordinates[0];
            newY = coordinates[1];
            newOrganism = new Antelope(newX, newY, this);
            addOrganism(newOrganism,newX,newY);

            coordinates= randomizeCoordinates();
            newX = coordinates[0];
            newY = coordinates[1];
            newOrganism = new Grass(newX, newY, this);
            addOrganism(newOrganism,newX,newY);

            coordinates= randomizeCoordinates();
            newX = coordinates[0];
            newY = coordinates[1];
            newOrganism = new Milkweed(newX, newY, this);
            addOrganism(newOrganism,newX,newY);

            coordinates= randomizeCoordinates();
            newX = coordinates[0];
            newY = coordinates[1];
            newOrganism = new Guarana(newX, newY, this);
            addOrganism(newOrganism,newX,newY);

            coordinates= randomizeCoordinates();
            newX = coordinates[0];
            newY = coordinates[1];
            newOrganism = new Hogweed(newX, newY, this);
            addOrganism(newOrganism,newX,newY);

            coordinates= randomizeCoordinates();
            newX = coordinates[0];
            newY = coordinates[1];
            newOrganism = new WolfBerries(newX, newY, this);
            addOrganism(newOrganism,newX,newY);

        }
    }

    public void bubbleSortOrganisms() {
        int number = organisms.size();
        for (int i = 0; i < number - 1; i++) {
            for (int j = 0; j < number - i - 1; j++) {
                Organism left = organisms.get(j);
                Organism right = organisms.get(j + 1);
                if (left.getInitiative() > right.getInitiative() ||
                        (left.getInitiative() == right.getInitiative() && left.getAge() < right.getAge())) {
                    organisms.set(j, right);
                    organisms.set(j + 1, left);
                }
            }
        }
    }

    public void removeOrganism(Organism organism) {
        // usunięcie z wektora
        int size = organisms.size();
        for (int i = 0; i < size; i++) {
            if (organisms.get(i) == organism) {
                organisms.set(i,null);
                break;
            }
        }
        // usunięcie z planszy
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (tab[y][x] == organism) {
                    tab[y][x] = null;
                    return;
                }
            }
        }
    }

    public void addOrganism(Organism organism, int x, int y) {
        tab[y][x] = organism;
        organisms.add(organism);
    }

    public void moveOrganism(int tempX, int tempY, int x, int y, boolean checkCollision) {
        Organism temp = tab[tempY][tempX];
        if (tab[y][x] != null)
        {
            temp.collision(tab[y][x]);
            return;
        }
        else
        {
            tab[tempY][tempX] = null;
            tab[y][x] = temp;
            temp.setX(x);
            temp.setY(y);
        }
    }

//    public int saveToFile(boolean abilityActive, int roundsLeft, int roundsToStart) {
//        // implementation
//    }
//
//    public int loadFromFile() {
//        // implementation
//    }
//
//    public void importantInformation() {
//        // implementation
//    }

    public class OrganismData {
        public Species species;
        public int initiative;
        public int strength;
        public int age;
        public int x;
        public int y;

        public OrganismData(Species species, int initiative, int strength, int age, int x, int y) {
            this.species = species;
            this.initiative = initiative;
            this.strength = strength;
            this.age = age;
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return this.species.toString() + ": " +
                    "initiative=" + this.initiative +
                    ", strength=" + this.strength +
                    ", age=" + this.age +
                    ", x=" + this.x +
                    ", y=" + this.y;
        }
    }
}
