//import javax.swing.JFrame;
//
//public class WorldFrame extends JFrame {
//    private static final long serialVersionUID = 1L;
//    private WorldPanel worldPanel;
//
//    public WorldFrame(int width, int height, Organism[][] tab) {
//        worldPanel = new WorldPanel(width, height, tab);
//        add(worldPanel);
//        setSize(800, 600);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setVisible(true);
//    }
//
//    public void redraw() {
//        worldPanel.redraw();
//    }
//}
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WorldFrame extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JButton myButton;
    private WorldPanel myWorldPanel;

    public WorldFrame(int width, int height, Organism[][] tab) {

        super("WORLD");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myButton = new JButton("NEXT TURN");
        myButton.addActionListener(this);

        myWorldPanel = new WorldPanel(width, height, tab);



        JPanel panel = new JPanel();
        panel.setSize(800, 600);
        panel.setLayout(new BorderLayout());
        panel.add(myButton, BorderLayout.NORTH);
        panel.add(myWorldPanel, BorderLayout.CENTER);
        setContentPane(panel);
        setSize(800,600);
        setVisible(true);
    }



    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == myButton) {
            System.out.println("NEXT TURN");
        }
    }
    public void redraw() {
       myWorldPanel.redraw();
   }
}
