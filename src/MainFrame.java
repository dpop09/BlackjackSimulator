import javax.swing.*;
import java.awt.*;

/*
MainFrame will have a stack of panels layered on top of it and each panel is its own separate page.
Buttons can be clicked to call the showPanel function to switchout the panels to be presented to the user.
*/
public class MainFrame extends JFrame { // MainFrame IS the JFrame

    private JPanel cardPanel; // A panel to hold all the "cards" (pages)
    private CardLayout cardLayout; // The layout manager to switch between cards

    // Constants for card names (good practice for CardLayout)
    public static final String MENU_PANEL = "Menu";
    public static final String SETTINGS_PANEL = "Settings";
    public static final String GAME_PANEL = "Game";
    public static final String GAME_SETTINGS_PANEL = "Game Settings";

    public MainFrame() {
        // Configure the JFrame itself
        super("Blackjack Simulator"); // Set the title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize to full screen

        // Initialize CardLayout and the panel that uses it
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout); // Assign CardLayout to cardPanel

        // Create instances of your page panels
        // Pass 'this' (the MainFrame instance) to allow panels to request page changes
        MenuPanel menuPanel = new MenuPanel(this);
        SettingsPanel settingsPanel = new SettingsPanel(this);
        GamePanel gamePanel = new GamePanel(this);
        GameSettingsPanel gameSettingsPanel = new GameSettingsPanel(this);

        // Add each panel to the cardPanel with a unique name
        cardPanel.add(menuPanel, MENU_PANEL);
        cardPanel.add(settingsPanel, SETTINGS_PANEL);
        cardPanel.add(gamePanel, GAME_PANEL);
        cardPanel.add(gameSettingsPanel, GAME_SETTINGS_PANEL);

        // Add the cardPanel to the JFrame's content pane
        add(cardPanel, BorderLayout.CENTER);

        // Make the frame visible
        setVisible(true);

        // Show the initial panel (e.g., the menu)
        showPanel(MENU_PANEL);
    }

    /**
     * Switches to the specified panel.
     * @param panelName The name of the panel to show (e.g., MainFrame.MENU_PANEL)
     */
    public void showPanel(String panelName) {
        cardLayout.show(cardPanel, panelName);
    }

    // You might add other methods here, like a getter for the frame if needed,
    // but generally, panels should interact via the showPanel method.

    public static void main(String[] args) {
        // Ensure GUI updates are done on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> new MainFrame());
    }
}