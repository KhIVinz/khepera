import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Map extends JPanel {

    JPanel pnlButton = new JPanel();
    JFrame frame = new JFrame();
    JButton btnAddFlight = new JButton("Save to file");

    public Map() {
        btnAddFlight.setBounds(60, 400, 220, 30);
        // JPanel bounds
        pnlButton.setBounds(600, 600, 200, 100);

        // Adding to JFrame
        pnlButton.add(btnAddFlight);
        add(pnlButton);

        // JFrame properties
        frame.setSize(400, 400);
        frame.setTitle("Air Traffic Control");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        g.setColor(Color.RED);
        g.drawOval(500,500,10,10);
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
