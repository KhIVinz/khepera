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
        setSize(400,400);
        setVisible(true);
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
            drawPoints(g);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void drawPoints (Graphics g) throws IOException {
        super.paintComponent(g);
        //makefile();
        String fileName = "src/coorinates/xyz.txt";
        BufferedReader file = new BufferedReader(new FileReader(fileName));
        ArrayList<Double> xCoordinate = new ArrayList<Double>();
        ArrayList<Double> yCoordinate = new ArrayList<Double>();
        String c2 = file.readLine();
        try{
            while ((c2 = file.readLine()) != null) {
                c2 = file.readLine();
                String[] arr = c2.split(" ");
                xCoordinate.add(Double.parseDouble(arr[0]));
                yCoordinate.add(Double.parseDouble(arr[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Graphics2D g2 = (Graphics2D) g;
        for (double x : xCoordinate){
            for (double y : yCoordinate){
                Ellipse2D point = new Ellipse2D.Double(x,y,0.5,0.5);
                g2.draw(point);
            }
        }
    }
}