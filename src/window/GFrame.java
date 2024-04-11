package window;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GFrame extends JFrame
{
    private final String iconPath = "./src/icons/ub.png";
    private final String bgPath = "./src/images/bg.png";

    private final Image backgroundImage;
    private final Image iconImage;

    public GFrame()       
    {
        backgroundImage = new ImageIcon(bgPath).getImage();
        iconImage = new ImageIcon(iconPath).getImage(); 
        

        setSize(800,600);

        JPanel bgPanel = new JPanel() {
            protected void paintComponent(Graphics graphic)
            {
                super.paintComponent(graphic);
                graphic.drawImage(backgroundImage,0,0,null);
            }
        };

        setContentPane(bgPanel);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("SISTEM");
        setIconImage(iconImage);
    }
}
