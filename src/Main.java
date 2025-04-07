import javax.swing.*;

/*
Project Pacman
Farid Afrakhte       990122680092
Zahra Taghipour      990122680050
*/

public class Main extends JFrame {
    public Main() {
        initUI();
    }

    // for start the game
    private void initUI() {
        add(new Board());
        setTitle("Pacman");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 700);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
            new GameMenu();
            var ex = new Main();
            ex.setVisible(true);
        };
    }

