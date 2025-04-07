import org.w3c.dom.ls.LSOutput;
import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class Test {
    JLabel pacmanPointing;


    Test() {


        ImageIcon pacmanPointingIcon  = new ImageIcon("src/small pacman icon.png");
        pacmanPointing = new JLabel();
        pacmanPointing.setIcon(pacmanPointingIcon);
        pacmanPointing.setBounds(0 , 100, 50 , 50);

        UpAction upAction = new UpAction();
        DownAction downAction = new DownAction();
        pacmanPointing.getInputMap().put(KeyStroke.getKeyStroke('w') ,"moving up");
        pacmanPointing.getActionMap().put("moving up" , upAction);

        pacmanPointing.getInputMap().put(KeyStroke.getKeyStroke('s') , "moving down");
        pacmanPointing.getActionMap().put("moving down" , downAction);
        JFrame gameMenuFrame = new JFrame("Pacman");
        gameMenuFrame.setSize(800 , 500);
        gameMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameMenuFrame.setResizable(true);
        gameMenuFrame.setLayout(null);
        gameMenuFrame.getContentPane().setBackground(Color.black);
        gameMenuFrame.add(pacmanPointing);
        gameMenuFrame.setVisible(true);



    }

    class UpAction extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (pacmanPointing.getY() >= 100) {
                pacmanPointing.setLocation(pacmanPointing.getX() , pacmanPointing.getY()-10);
            }
        }
    }
    class DownAction extends  AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            pacmanPointing.setLocation(pacmanPointing.getX() , pacmanPointing.getY()+10);
        }
    }
}