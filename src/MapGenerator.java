import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.io.*;
import java.util.ArrayList;

public class MapGenerator extends JPanel {

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
              Ellipse2D  point = new Ellipse2D.Double(x,y,0.5,0.5);
              g2.draw(point);
            }
        }
    }

    public void makefile() throws IOException {
        String fileName = "src/coorinates/xyz2.txt";
        BufferedReader file = new BufferedReader(new FileReader(fileName));
        PrintWriter out = new PrintWriter("filename.txt");
        String c;
        try {
            while ((c = file.readLine()) != null) {
                c = file.readLine().replaceAll("\t", " ").replaceAll("-0.0", "").replaceAll("0.0", "").replaceAll("   ", " ").replaceAll("  ", " ").replaceAll("  ", " ").replaceAll("(?m)^[ \t]*\r?\n", "");
                if (!c.equals("  ") && !c.equals(" ")) {
                    System.out.println(c);
                    out.println(c);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            file.close();
        }
    }
}
