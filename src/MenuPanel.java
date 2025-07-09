import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {

    // reference to the main frame for navigation
    private MainFrame mainFrame;

    public MenuPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new GridBagLayout()); // Use GridBagLayout for flexible centering
        setBackground(new Color(0, 100, 0)); // A dark green background

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0); // Padding between components
        gbc.gridx = 0; // All components in one column

        // Title Label
        JLabel titleLabel = new JLabel("Blackjack Simulator");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 48));
        titleLabel.setForeground(Color.WHITE);
        gbc.gridy = 0;
        add(titleLabel, gbc);

        // Start Game Button
        JButton startGameButton = new JButton("Start Game");
        styleButton(startGameButton);
        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuPanel.this.mainFrame.showPanel(MainFrame.GAME_SETTINGS_PANEL); // Request to show the game panel
            }
        });
        gbc.gridy = 1;
        add(startGameButton, gbc);

        // Settings Button
        JButton settingsButton = new JButton("Settings");
        styleButton(settingsButton);
        settingsButton.addActionListener(e -> this.mainFrame.showPanel(MainFrame.SETTINGS_PANEL)); // Lambda for brevity
        gbc.gridy = 2;
        add(settingsButton, gbc);

        // Exit Button
        JButton exitButton = new JButton("Exit");
        styleButton(exitButton);
        exitButton.addActionListener(e -> System.exit(0)); // Exit the application
        gbc.gridy = 3;
        add(exitButton, gbc);
    }
    // Helper method to style buttons
    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 24));
        button.setPreferredSize(new Dimension(250, 60));
        button.setBackground(new Color(70, 180, 250)); // Lighter blue
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true)); // Rounded border
        button.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Hand cursor on hover
    }
}
