import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {

    private MainFrame mainFrame;

    public GamePanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new GridBagLayout());
        setBackground(new Color(0, 100, 0)); // Green background for game table

        JLabel gameLabel = new JLabel("Blackjack Game In Progress...");
        gameLabel.setFont(new Font("Arial", Font.BOLD, 40));
        gameLabel.setForeground(Color.WHITE);
        add(gameLabel);

        JButton backButton = new JButton("Back to Menu");
        backButton.setFont(new Font("Arial", Font.PLAIN, 20));
        backButton.setPreferredSize(new Dimension(200, 50));
        backButton.addActionListener(e -> mainFrame.showPanel(MainFrame.MENU_PANEL));
        add(backButton);
    }
}