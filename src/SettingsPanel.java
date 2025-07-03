import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsPanel extends JPanel {

    private MainFrame mainFrame;

    public SettingsPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new GridBagLayout());
        setBackground(new Color(100, 100, 100)); // Grey background

        JLabel titleLabel = new JLabel("Settings");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        titleLabel.setForeground(Color.WHITE);
        add(titleLabel); // Add to GridBagLayout (default constraints)

        JButton backButton = new JButton("Back to Menu");
        backButton.setFont(new Font("Arial", Font.PLAIN, 20));
        backButton.setPreferredSize(new Dimension(200, 50));
        backButton.addActionListener(e -> mainFrame.showPanel(MainFrame.MENU_PANEL));
        add(backButton);
    }
}