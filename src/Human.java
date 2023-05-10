import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Human extends Animal  { //implements keylistener
    public Human(int x,int y, World world){
        super(5,4, x,y, Species.human,world);
    }
    public void draw(Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.cyan);
        g.fillRect(x, y, width, height);
    }
    public void createOrganism(int x, int y){}
//    public void action(){
//        while(true){
//
//        }
//    }
//
//    public void keyReleased(KeyEvent e) {}
//
//    public void keyTyped(KeyEvent e) {}
//    public void keyPressed(KeyEvent e) {
//        int distance = 1; // odległość o jaką się przesuwamy
//        int temp_x = x; // zapamiętujemy poprzednie współrzędne
//        int temp_y = y;
//
//        switch (e.getKeyCode()) {
//            case KeyEvent.VK_UP: // strzałka w górę
//                if (y > (distance - 1)) {
//                    y -= distance; // zmieniamy współrzędne w pionie
//                    world.moveOrganism(temp_x, temp_y, x, y, true); // przesuwamy organizm w grze
//                }
//                break;
//            case KeyEvent.VK_LEFT: // strzałka w lewo
//                if (x > (distance - 1)) {
//                    x -= distance; // zmieniamy współrzędne w poziomie
//                    world.moveOrganism(temp_x, temp_y, x, y, true); // przesuwamy organizm w grze
//                }
//                break;
//            case KeyEvent.VK_DOWN: // strzałka w dół
//                if (y < world.getHeight() - distance) {
//                    y += distance; // zmieniamy współrzędne w pionie
//                    world.moveOrganism(temp_x, temp_y, x, y, true); // przesuwamy organizm w grze
//                }
//                break;
//            case KeyEvent.VK_RIGHT: // strzałka w prawo
//                if (x < world.getWidth() - distance) {
//                    x += distance; // zmieniamy współrzędne w poziomie
//                    world.moveOrganism(temp_x, temp_y, x, y, true); // przesuwamy organizm w grze
//                }
//                break;
//        }
//    }
}
