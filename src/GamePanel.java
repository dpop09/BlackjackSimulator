import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {

    private Deck dealerDeck;
    private JLabel revealedCardDisplay;
    private MainFrame mainFrame;

    public GamePanel(MainFrame mainFrame) {
        this.dealerDeck = new Deck();
        dealerDeck.shuffle();

        this.mainFrame = mainFrame;
        setLayout(new GridBagLayout());
        setBackground(new Color(0, 100, 0)); // Green background for game table

        // dealer deck button using the initial card back
        ImageIcon cardBackIcon = getCardIcon("back_of_card.png");
        JButton dealerDeckButton = new JButton(cardBackIcon);
        dealerDeckButton.setText("");
        dealerDeckButton.setRolloverEnabled(false);
        dealerDeckButton.setFocusPainted(false);
        dealerDeckButton.setContentAreaFilled(false);
        dealerDeckButton.setBorderPainted(false);
        // GridBagConstraints for the dealer deck button
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10,10,10,10);
        add(dealerDeckButton, gbc);

        // revealed card display is initially empty
        // so we initialize it with an empty label containing a white border
        revealedCardDisplay = new JLabel();
        revealedCardDisplay.setPreferredSize(new Dimension(120, 168));
        revealedCardDisplay.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10,10,10,10);
        add(revealedCardDisplay, gbc);

        dealerDeckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card revealedCard = dealerDeck.drawCard();
                if (revealedCard != null) {
                    ImageIcon revealedCardIcon = getCardIcon(revealedCard.getCardFileName());
                    if (revealedCardIcon != null) {
                        revealedCardDisplay.setIcon(revealedCardIcon);
                        revalidate();
                        repaint();
                    } else {
                        System.out.println("Could not get icon for " + revealedCard.getCardFileName());
                    }
                } else {
                    System.out.println("Deck is empty!");
                    dealerDeckButton.setEnabled((false));
                }
            }
        });

        JButton backButton = new JButton("Back to Menu");
        backButton.setFont(new Font("Arial", Font.PLAIN, 20));
        backButton.setPreferredSize(new Dimension(200, 50));
        backButton.addActionListener(e -> mainFrame.showPanel(MainFrame.MENU_PANEL));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(30,10,10,10);
        add(backButton, gbc);
    }

    public ImageIcon getCardIcon(String fileName) {
        // image loading and resizing
        try {
            java.net.URL imageURL = getClass().getResource(fileName);
            if (imageURL == null) {
                System.out.println("Card .png file was not found.");
                throw new RuntimeException("Image resource is missing.");
            }

            ImageIcon originalCardIcon= new ImageIcon(imageURL);
            Image originalImage = originalCardIcon.getImage();
            Image resizedImage = originalImage.getScaledInstance(120, 168, Image.SCALE_SMOOTH);

            return new ImageIcon(resizedImage);
        } catch (Exception e) {
            System.out.println("Card image cannot be found.");
            return null;
        }
    }
}