import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BOTTOM_panel extends JFrame{
    
    private static JPanel BOTTOMpanel = new JPanel();

    private static JLabel dimensions = new JLabel();
    public static JLabel X = new JLabel();
    public static JLabel Y = new JLabel();

    public JPanel get_BOTTOM_PANEL(Interface that){

        int HEIGHT = that.HEIGHT;
        int WIDTH = that.WIDTH;

        Toolbox.implementa_label(dimensions,"Dimensions:",false,10,0,WIDTH/20,HEIGHT/25,BOTTOMpanel);
        Toolbox.edita_label(dimensions,null,null,Color.WHITE);

        Toolbox.implementa_label(X,"X: "+WIDTH/4+" px",false,10+WIDTH/20,10,WIDTH/20,HEIGHT/50,BOTTOMpanel);
        Toolbox.edita_label(X,null,null,Color.WHITE);
        
        Toolbox.implementa_label(Y,"Y: "+HEIGHT/4+" px",false,10+WIDTH/20,HEIGHT/50+10,WIDTH/20,HEIGHT/25,BOTTOMpanel);
        Toolbox.edita_label(Y,null,null,Color.WHITE);

        return BOTTOMpanel;

    }

}
