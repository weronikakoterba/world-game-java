import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WorldPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private int width;
    private int height;
    private Organism[][] tab;

    public WorldPanel(int width, int height, Organism[][] tab) {
        this.width = width;
        this.height = height;
        this.tab = tab;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cellWidth = getWidth() / width;
        int cellHeight = getHeight() / height;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (tab[y][x] == null) {
                    g.setColor(Color.WHITE);
                    g.fillRect(x * cellWidth, y * cellHeight, cellWidth, cellHeight);
                } else {
                    tab[y][x].draw(g, x * cellWidth, y * cellHeight, cellWidth, cellHeight);
                }
            }
        }
    }

    public void redraw() {
        repaint();
    }
}
