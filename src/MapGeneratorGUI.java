import javax.swing.*;
import java.awt.*;

public class MapGeneratorGUI extends JFrame{
    private JPanel panel1 = new MapGenerator();
    private JButton button1;
    JFrame frame1 = new JFrame();
    Graphics g;

    public MapGeneratorGUI(){
        setDefaultCloseOperation(this.HIDE_ON_CLOSE);
        setInitialSize();
        setContentPane(panel1);
        setVisible(true);
        panel1.add(button1);
        button1.setVisible(true);
        panel1.add(frame1);
        frame1.setVisible(true);
    }

    /**
     * Sets initial size on startup
     */
    private void setInitialSize() {
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final int screenWidth = 600;
        final int screenHeight = 600;
        setBounds(screenWidth, screenHeight , screenWidth ,
                screenHeight );
        setLocation(0, 0);

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
