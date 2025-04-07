import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GameMenu {
    JLabel pacmanPointing;
    JFrame gameMenuFrame;

    GameMenu() {
        // ====================bottom panel section===============
        // we need bottom panel for thanks who build this game
        Panel bottomPanel = new Panel();
        bottomPanel.setBackground(Color.black); // panel color
        bottomPanel.setBounds(0, 400, 800, 100);


        // now we should put label on it
        JLabel programmersList = new JLabel();
        programmersList.setText("Programmers: Mahdi Tarvashe , Farid Afrakhteh , Zahra Taghipoor");
        programmersList.setBounds(0, 0, 800, 50);
        programmersList.setForeground(Color.green); // font color
        programmersList.setFont(new Font("MV Boli", Font.PLAIN, 16));

        // we can add it to panel now
        bottomPanel.add(programmersList);

        // ================top panel section ===============
        // we need top panel for make more menu pleasant
        Panel topPanel = new Panel();
        topPanel.setBackground(Color.black);
        topPanel.setBounds(0, 0, 800, 200);

        // we should make MenuBackground.png into icon
        ImageIcon menuBackgroundIcon = new ImageIcon("src/MenuBackground.png");

        // we can add that icon into label
        JLabel menuBackground = new JLabel();
//        menuBackground.setForeground(Color.black); //test
        menuBackground.setIcon(menuBackgroundIcon);

        // we should add label into panel and top panel section will finish
        topPanel.add(menuBackground);

        // main panel section
        // now we need a main panel for get user selection
        Panel mainPanel = new Panel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(0, 210, 800, 190);

        // main panel labels
        // single player section
        JLabel singlePlayerLabel = new JLabel();
        singlePlayerLabel.setText("Single Player");
        singlePlayerLabel.setBounds(350, 0, 150, 50);
        singlePlayerLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
        singlePlayerLabel.setForeground(Color.red);


        // leaderBoard section
        JLabel leaderboard = new JLabel();
        leaderboard.setText("Leaderboard");
        leaderboard.setBounds(349, 50, 150, 50);
        leaderboard.setFont(new Font("Verdana", Font.PLAIN, 14));
        leaderboard.setForeground(Color.red);


        //setting section
        JLabel settingLabel = new JLabel();
        settingLabel.setText("Setting");
        settingLabel.setBounds(370, 100, 150, 50);
        settingLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
        settingLabel.setForeground(Color.red);

        // small pacman for pointing an item in menu
        ImageIcon pacmanPointingIcon = new ImageIcon("src/small pacman icon.png");
        pacmanPointing = new JLabel();
        pacmanPointing.setIcon(pacmanPointingIcon);
        pacmanPointing.setBounds(300, 0, 50, 50);
        // need a method for move the pacmanIcon
        pacmanIconMovements();

        // we can add them to main panel now
        mainPanel.add(singlePlayerLabel);
        mainPanel.add(leaderboard);
        mainPanel.add(settingLabel);
        mainPanel.add(pacmanPointing);


        //after all we need a frame to add other things into it
        gameMenuFrame = new JFrame("Pacman");
        gameMenuFrame.setSize(800, 500);
        gameMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameMenuFrame.setResizable(true);
        gameMenuFrame.setLayout(null);
        gameMenuFrame.getContentPane().setBackground(Color.black);
        gameMenuFrame.setLocationRelativeTo(null); // for show the frame center of screen


        gameMenuFrame.add(topPanel);
        gameMenuFrame.add(bottomPanel);
        gameMenuFrame.add(mainPanel);
        gameMenuFrame.setVisible(true);
    }

    private void pacmanIconMovements() {
        MovementDown movementDown = new MovementDown();
        MovementUp movementUp = new MovementUp();
        SelectItem selectItem = new SelectItem();
        pacmanPointing.getInputMap().put(KeyStroke.getKeyStroke("UP"), "move up");
        pacmanPointing.getActionMap().put("move up", movementUp);
        pacmanPointing.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "move down");
        pacmanPointing.getActionMap().put("move down", movementDown);
        pacmanPointing.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "select item");
        pacmanPointing.getActionMap().put("select item", selectItem);
    }

    class MovementUp extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (pacmanPointing.getY() > 0 && pacmanPointing.getY() <= 100) {
                pacmanPointing.setLocation(pacmanPointing.getX(), pacmanPointing.getY() - 50);
            }
        }
    }

    class MovementDown extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (pacmanPointing.getY() >= 0 && pacmanPointing.getY() < 100) {
                pacmanPointing.setLocation(pacmanPointing.getX(), pacmanPointing.getY() + 50);
            }

        }

    }

    class SelectItem extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (pacmanPointing.getY() == 0) {
                getPlayerName();
            } else if (pacmanPointing.getY() == 50) {
                gameMenuFrame.dispose();
                new LeaderBoardWindow();
            } else if (pacmanPointing.getY() == 100) {
                new SettingMenu();
            }

        }

        private void getPlayerName() {
            String name = JOptionPane.showInputDialog("Please enter your name.\n (The name field should not be empty)");
            if (isNameValid(name)) {
                gameMenuFrame.dispose();
                new StartGame();
            } else getPlayerName();

        }

        private boolean isNameValid(String name) {
            name = name.replaceAll("\\s", ""); // removing spaces
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Inputed name was invalid", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }else return true;
        }
    }
}