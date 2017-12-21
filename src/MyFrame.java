import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MyFrame extends JFrame {

    public MyFrame (){
        super("Map generator");
        setContentPane(new DrawPane());
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setInitialSize();
        setVisible(true);
    }

    private void setInitialSize() {
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final int screenWidth = 600;
        final int screenHeight = 600;
        setBounds(1500,1200,1500,1200);
        setLocation(0, 0);
    }
}

class DrawPane extends JPanel {
    JButton button = new JButton("Save to file");
    public DrawPane(){
        JPanel panel2 = new JPanel();
        add(panel2);
        panel2.add(button);
        add(panel2);

    }
    public void paintComponent(Graphics g) {
        try {
            g.setColor(Color.RED);
            drawPoints(g);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void drawPoints (Graphics g) throws IOException {
        super.paintComponent(g);
        //makefile();
        String fileName = "src/coorinates/xxxy.txt";
        BufferedReader file = new BufferedReader(new FileReader(fileName));
        ArrayList<Double> xCoordinate = new ArrayList<Double>();
        ArrayList<Double> yCoordinate = new ArrayList<Double>();
        String c2 = file.readLine();
        Graphics2D g2 = (Graphics2D) g;
        try{
            while ((c2 = file.readLine()) != null) {
                c2 = file.readLine();
                String[] arr = c2.split(" ");
                xCoordinate.add(Double.parseDouble(arr[0]));
                yCoordinate.add(Double.parseDouble(arr[1]));
                Ellipse2D point = new Ellipse2D.Double(Double.parseDouble(arr[0]), Double.parseDouble(arr[1]), 2, 2);
                g2.draw(point);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Graphics2D g2 = (Graphics2D) g;
//        for (double x : xCoordinate){
//            for (double y : yCoordinate){
//                Ellipse2D point = new Ellipse2D.Double(x,y,0.5,0.5);
//                g2.draw(point);
//            }
        //}
    }
}