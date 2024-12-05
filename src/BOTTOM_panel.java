import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BOTTOM_panel extends JFrame{
    
    private static JPanel BOTTOMpanel = new JPanel();

    private static JLabel dimensions = new JLabel();
    public static JLabel X = new JLabel();
    public static JLabel Y = new JLabel();
    public static JTextField width_textfield = new JTextField();
    public static JTextField height_textfield = new JTextField();
    public static JLabel X_px = new JLabel();
    public static JLabel Y_px = new JLabel();

    public JPanel get_BOTTOM_PANEL(Interface that){

        int HEIGHT = that.HEIGHT;
        int WIDTH = that.WIDTH;

        Toolbox.implementa_label(dimensions,"Dimensions:",false,10,0,WIDTH/20,HEIGHT/25,BOTTOMpanel);
        Toolbox.edita_label(dimensions,null,null,Color.WHITE);


        Toolbox.implementa_label(X,"X: ",false,10+WIDTH/20,0,WIDTH/50,HEIGHT/50,BOTTOMpanel);
        Toolbox.edita_label(X,null,null,Color.WHITE);
        
        Toolbox.implementa_textfield(width_textfield,""+WIDTH/4,10+WIDTH/20+WIDTH/50,2,WIDTH/25,HEIGHT/50,true,true,BOTTOMpanel);
        Toolbox.edita_textfield(width_textfield,null,new Color(31,32,37),Color.WHITE);
        width_textfield.setHorizontalAlignment(JTextField.CENTER);
        width_textfield.addActionListener(that.th);
        
        Toolbox.implementa_label(X_px,"px",false,10+WIDTH/20+WIDTH/50+WIDTH/25,0,WIDTH/50,HEIGHT/50,BOTTOMpanel);
        Toolbox.edita_label(X_px,null,null,Color.WHITE);
        

        Toolbox.implementa_label(Y,"Y: ",false,10+WIDTH/20,HEIGHT/50+10,WIDTH/50,HEIGHT/50,BOTTOMpanel);
        Toolbox.edita_label(Y,null,null,Color.WHITE);

        Toolbox.implementa_textfield(height_textfield,""+HEIGHT/4,10+WIDTH/20+WIDTH/50,HEIGHT/50+12,WIDTH/25,HEIGHT/50,true,true,BOTTOMpanel);
        Toolbox.edita_textfield(height_textfield,null,new Color(31,32,37),Color.WHITE);
        height_textfield.setHorizontalAlignment(JTextField.CENTER);
        height_textfield.addActionListener(that.th);

        Toolbox.implementa_label(Y_px,"px",false,10+WIDTH/20+WIDTH/50+WIDTH/25,HEIGHT/50+12,WIDTH/50,HEIGHT/50,BOTTOMpanel);
        Toolbox.edita_label(Y_px,null,null,Color.WHITE);

        return BOTTOMpanel;

    }

}
