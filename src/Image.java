import javax.swing.*;

public class Image extends JFrame {

    JFrame frame;
    JLabel displayField;
    ImageIcon image;

    public Image() {
        frame = new JFrame("Image Display Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            java.net.URL imageURL = getClass().getResource("2_of_clubs.png");
            if (imageURL == null) {
                System.out.println("Resource is not found.");
                throw new RuntimeException("Image resource is missing.");
            }
            image = new ImageIcon(imageURL);
            displayField = new JLabel(image);
            frame.add(displayField);
        } catch(Exception e) {
            System.out.println("Image cannot be found.");
        }
        frame.pack();
        frame.setVisible(true);
    }
}
