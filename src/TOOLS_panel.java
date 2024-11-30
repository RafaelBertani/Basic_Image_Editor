import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TOOLS_panel extends JFrame implements ActionListener{
    
    private static JPanel TOOLSpanel = new JPanel();

    //colors
    private static JPanel COLORSpanel = new JPanel();
    private static JLabel colors = new JLabel();
    private static JLabel[] colors_line_1 = new JLabel[6];
    private static JLabel[] colors_line_2 = new JLabel[6];
    private static JLabel[] colors_line_3 = new JLabel[6];
    public static JLabel current_color = new JLabel();
    private static JButton select_color = new JButton();

    //bar
    private JLabel bar1 = new JLabel();

    public JPanel get_TOOLS_PANEL(Interface that){
        
        int HEIGHT = that.HEIGHT;
        int WIDTH = that.WIDTH;

        //initialize colors lines
        for(int i=0;i<6;i++){
        
            colors_line_1[i]=new JLabel();
            colors_line_1[i].setOpaque(true);
            colors_line_1[i].addMouseListener(ml_color);

            colors_line_2[i]=new JLabel();
            colors_line_2[i].setOpaque(true);
            colors_line_2[i].addMouseListener(ml_color);
            
            colors_line_3[i]=new JLabel();
            colors_line_3[i].setOpaque(true);
            colors_line_3[i].setBackground(Color.WHITE);
            colors_line_3[i].addMouseListener(ml_color);
        
        }
        colors_line_1[0].setBackground(Color.WHITE);
        colors_line_1[1].setBackground(Color.RED);
        colors_line_1[2].setBackground(Color.GREEN);
        colors_line_1[3].setBackground(Color.BLUE);
        colors_line_1[4].setBackground(Color.YELLOW);
        colors_line_1[5].setBackground(Color.ORANGE);
        colors_line_2[0].setBackground(Color.BLACK);
        colors_line_2[1].setBackground(Color.GRAY);
        colors_line_2[2].setBackground(Color.MAGENTA);
        colors_line_2[3].setBackground(Color.PINK);
        colors_line_2[4].setBackground(new Color(128, 0, 128));
        colors_line_2[5].setBackground(new Color(150, 75, 0));

        //add label colors
        Toolbox.implementa_label(colors,"Colors",false,10,0,6*HEIGHT/35,HEIGHT/40,COLORSpanel);
        Toolbox.edita_label(colors,null,null,Color.WHITE);

        int size=HEIGHT/40;
        
        //add colors to colors panel
        for(int i=0;i<6;i++){
            Toolbox.implementa_label(colors_line_1[i],"",true,10+i*HEIGHT/35,HEIGHT/35,size,size,COLORSpanel);
            Toolbox.implementa_label(colors_line_2[i],"",true,10+i*HEIGHT/35,2*HEIGHT/35,size,size,COLORSpanel);
            Toolbox.implementa_label(colors_line_3[i],"",true,10+i*HEIGHT/35,3*HEIGHT/35,size,size,COLORSpanel);
        }

        //add current color to the panel
        current_color.setOpaque(true);
        current_color.setBackground(Color.WHITE);
        Toolbox.implementa_label(current_color,"",true,10+6*HEIGHT/35,HEIGHT/35,size,2*HEIGHT/35+size,COLORSpanel);

        //add select color to the panel
        try {
            select_color.setIcon(new ImageIcon(ResizeImage.resizeImage("./src/Images/select_image_icon.png",2*HEIGHT/35+size,2*HEIGHT/35+size)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toolbox.implementa_button(select_color,"",10+7*HEIGHT/35,HEIGHT/35,2*HEIGHT/35+size,2*HEIGHT/35+size,this,COLORSpanel);

        //add colors panel do tools panel
        Toolbox.implementa_panel_no_panel(COLORSpanel,TOOLSpanel,0,0,10+HEIGHT/5+2*HEIGHT/35+size,HEIGHT/30+50+size+2*HEIGHT/35+size);
        Toolbox.edita_panel(COLORSpanel,false,new Color(27,27,29));

        int end_colors=10+HEIGHT/5+2*HEIGHT/35+size;

        //add bar to tools panel
        bar1.setOpaque(true);
        bar1.setBackground(Color.LIGHT_GRAY);
        Toolbox.implementa_label(bar1,"",false,end_colors+10,10,1,HEIGHT/8-20,TOOLSpanel);

        return TOOLSpanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==select_color){
            Color newColor = JColorChooser.showDialog(null, "Choose a color", Color.RED);
            current_color.setBackground(newColor);
            
            boolean put = false;
            for(int i=0;i<colors_line_3.length;i++){
                if(colors_line_3[i].getBackground()==Color.WHITE){colors_line_3[i].setBackground(newColor);put=true;break;}
            }
            if(!put){colors_line_3[0].setBackground(newColor);}
        }
    }

    MouseListener ml_color = new MouseListener() {

        @Override
        public void mouseClicked(MouseEvent e) {
            JLabel selected_jlabel = (JLabel)e.getSource();
            current_color.setBackground(selected_jlabel.getBackground());
        }
        @Override public void mousePressed(MouseEvent e) {}
        @Override public void mouseReleased(MouseEvent e) {}
        @Override public void mouseEntered(MouseEvent e) {}
        @Override public void mouseExited(MouseEvent e) {}
    };

}
