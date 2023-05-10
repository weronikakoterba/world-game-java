public class Main {
    public static void main(String[] args) {
        int h=20;
        int w=20;
      World newWorld = new World(h,w);
      newWorld.printOrganism();
        WorldFrame frame = new WorldFrame(w, h, newWorld.getTab());
        while (true) {
            newWorld.executeTurn();
            frame.redraw();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}