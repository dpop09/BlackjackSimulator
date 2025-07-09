import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameSettingsPanel extends JPanel {

    private MainFrame mainFrame;

    public GameSettingsPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new GridBagLayout());
        setBackground(new Color(0, 100, 0));

        JLabel playersNumberLabel = new JLabel("Enter the amount of players.");
        add(playersNumberLabel);

        JButton twoButton = new JButton("2");
        JButton threeButton = new JButton("3");
        JButton fourButton = new JButton("4");
        JButton fiveButton = new JButton("5");
        JButton sixButton = new JButton("6");
        JButton sevenButton = new JButton("7");
        twoButton.setPreferredSize(new Dimension(50, 50));
        threeButton.setPreferredSize(new Dimension(50, 50));
        fourButton.setPreferredSize(new Dimension(50, 50));
        fiveButton.setPreferredSize(new Dimension(50, 50));
        sixButton.setPreferredSize(new Dimension(50, 50));
        sevenButton.setPreferredSize(new Dimension(50, 50));
        add(twoButton);
        add(threeButton);
        add(fourButton);
        add(fiveButton);
        add(sixButton);
        add(sevenButton);

        JButton startGameButton = new JButton("Start Game");
        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameSettingsPanel.this.mainFrame.showPanel(MainFrame.GAME_PANEL);
            }
        });
        add(startGameButton);

        JButton backButton = new JButton("Back to Menu");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameSettingsPanel.this.mainFrame.showPanel(MainFrame.MENU_PANEL);
            }
        });
        add(backButton);
    }
}
