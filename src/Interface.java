import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import java.util.ArrayList;

public class Interface extends JFrame implements ActionListener{

    public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public final int WIDTH = (int) screenSize.getWidth();
    public final int HEIGHT = (int) screenSize.getHeight();

    private JFrame MAINframe = new JFrame();
    private JPanel MAINpanel = new JPanel();
    private JPanel TOOLSpanel = new JPanel();
    private JPanel BOTTOMpanel = new JPanel();
    private JMenuBar menubar = new JMenuBar();
    
    private JPanel CONTENTpanel = new JPanel();
    private JLabel CONTENT_image = new JLabel();
    private Image CONTENT_save;
    private int CONTENT_X_SIZE = WIDTH/4;
    private int CONTENT_Y_SIZE = HEIGHT/4;
    
    public void cria_FRAME_PRINCIPAL(){
        
        //IMPLEMENTA MENUBAR
        String[] princ = {"File","Options","OP3"};
        List<String[]> sec = new ArrayList<String[]>();
        sec.add(0,new String[]{"OP1.1","OP1.2"});
        sec.add(1,new String[]{"OP2.1","OP2.2"});
        sec.add(2,new String[]{"OP3.1","OP3.2"});
        List<String[]> terc = new ArrayList<String[]>();
        terc.add(0,new String[]{"OP2.2","OP2.2.2"});
        Toolbox.implementa_menubar(menubar,princ,sec,terc,this,MAINframe);
        
        //MAIN PANEL
        Toolbox.implementa_panel(MAINpanel,MAINframe,0,0,WIDTH,HEIGHT);
        Toolbox.edita_panel(MAINpanel,false,new Color(31,32,37));

        //TOOLS PANEL
        TOOLS_panel tp = new TOOLS_panel();
        TOOLSpanel = tp.get_TOOLS_PANEL(this);
        Toolbox.implementa_panel_no_panel(TOOLSpanel,MAINpanel,0,0,WIDTH,HEIGHT/8);
        Toolbox.edita_panel(TOOLSpanel,false,new Color(27,27,29));

        //CONTENT PANEL
        Toolbox.implementa_label(CONTENT_image,"",false,WIDTH/2-CONTENT_X_SIZE/2,(HEIGHT-(HEIGHT/8+HEIGHT/5))/2-CONTENT_Y_SIZE/2,WIDTH/4,HEIGHT/4,CONTENTpanel);
        CONTENT_save = (RandomImage.return_blank_image(HEIGHT/4,WIDTH/4));
        CONTENT_image.setIcon(new ImageIcon( CONTENT_save ));
        CONTENT_image.addMouseMotionListener(mml);
        CONTENT_image.addMouseListener(ml_draw);
        Toolbox.edita_panel(CONTENTpanel,false,new Color(31,32,37)); //1,32,37
        CONTENTpanel.add(CONTENT_image);
        JScrollPane jp = new JScrollPane(CONTENTpanel);
        jp.setBounds(0,HEIGHT/8,WIDTH,HEIGHT-(HEIGHT/8+HEIGHT/5));
        jp.setBackground(new Color(31,32,37));
        jp.setOpaque(true);
        jp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        MAINpanel.add(jp);

        //BOTTOM PANEL
        BOTTOM_panel bp = new BOTTOM_panel();
        BOTTOMpanel = bp.get_BOTTOM_PANEL(this);
        Toolbox.implementa_panel_no_panel(BOTTOMpanel,MAINpanel,0,HEIGHT-HEIGHT/5,WIDTH,HEIGHT/10);
        Toolbox.edita_panel(BOTTOMpanel,false,new Color(27,27,29));

        //MAIN FRAME    
        Toolbox.implementa_frame(MAINframe,true,JFrame.EXIT_ON_CLOSE,WIDTH,HEIGHT);
        Toolbox.edita_frame(MAINframe,"Image Editor",new Color(238,238,238));        

    }

    public Interface(){
        cria_FRAME_PRINCIPAL();
    }
    
    public static void main(String[] args){
        new Interface();
    }

    //AÇÃO POR BOTÃO
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==null){

        }
    }
    

    MouseListener ml_draw = new MouseListener() {

        @Override public void mouseClicked(MouseEvent e) {
            if(x_pos>=0 && x_pos<=CONTENT_X_SIZE && y_pos>=0 && y_pos<=CONTENT_Y_SIZE){
                if(TOOLS_panel.is_fill_selected){
                    CONTENT_save = RandomImage.paint_pixel(CONTENT_save,x_pos,y_pos,TOOLS_panel.current_color.getBackground(),TOOLS_panel.pixels_Selector.getSelectedIndex(),3,false);
                    CONTENT_image.setIcon(new ImageIcon(CONTENT_save));
                }
                else{
                    CONTENT_save = RandomImage.paint_pixel(CONTENT_save,x_pos,y_pos,TOOLS_panel.current_color.getBackground(),TOOLS_panel.pixels_Selector.getSelectedIndex(),TOOLS_panel.checkBox_circle.isSelected()?1:2,TOOLS_panel.checkBox_spray.isSelected());
                    CONTENT_image.setIcon(new ImageIcon(CONTENT_save)); 
                }
            }
        }
        @Override public void mousePressed(MouseEvent e) {
            
        }
        @Override public void mouseReleased(MouseEvent e) {
            
        }
        @Override public void mouseEntered(MouseEvent e) {}
        @Override public void mouseExited(MouseEvent e) {}

    };

    public int x_pos = 0;
    public int y_pos = 0;          

    MouseMotionListener mml = new MouseMotionListener() {

        @Override
        public void mouseDragged(MouseEvent e) {
            x_pos = e.getX();
            y_pos = e.getY();
            if(x_pos>=0 && x_pos<=CONTENT_X_SIZE && y_pos>=0 && y_pos<=CONTENT_Y_SIZE){
                CONTENT_save = RandomImage.paint_pixel(CONTENT_save,x_pos,y_pos,TOOLS_panel.current_color.getBackground(),TOOLS_panel.pixels_Selector.getSelectedIndex(),TOOLS_panel.checkBox_circle.isSelected()?1:2,TOOLS_panel.checkBox_spray.isSelected());
                CONTENT_image.setIcon(new ImageIcon(CONTENT_save)); 
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            x_pos = e.getX();
            y_pos = e.getY();
        }
        
    };

    
    TextFieldHandler th = new TextFieldHandler();
    public class TextFieldHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            if(event.getSource()==BOTTOM_panel.width_textfield){
                CONTENTpanel.setVisible(false);
                CONTENTpanel.remove(CONTENT_image);

                CONTENT_X_SIZE=Integer.parseInt(BOTTOM_panel.width_textfield.getText());

                CONTENT_save = (RandomImage.return_blank_image(CONTENT_Y_SIZE,CONTENT_X_SIZE));
                CONTENT_image.setIcon(new ImageIcon( CONTENT_save ));
                CONTENT_image.addMouseMotionListener(mml);
                CONTENT_image.addMouseListener(ml_draw);
                Toolbox.implementa_label(CONTENT_image,"",false,WIDTH/2-CONTENT_X_SIZE/2,(HEIGHT-(HEIGHT/8+HEIGHT/5))/2-CONTENT_Y_SIZE/2,CONTENT_X_SIZE,CONTENT_Y_SIZE,CONTENTpanel);
                Toolbox.edita_panel(CONTENTpanel,false,new Color(31,32,37)); //1,32,37
                CONTENTpanel.setVisible(true);
            }
            else if(event.getSource()==BOTTOM_panel.height_textfield){
                CONTENTpanel.setVisible(false);
                CONTENTpanel.removeAll();

                CONTENT_Y_SIZE=Integer.parseInt(BOTTOM_panel.height_textfield.getText());

                CONTENT_save = (RandomImage.return_blank_image(CONTENT_Y_SIZE,CONTENT_X_SIZE));
                CONTENT_image.setIcon(new ImageIcon( CONTENT_save ));
                CONTENT_image.addMouseMotionListener(mml);
                CONTENT_image.addMouseListener(ml_draw);
                CONTENTpanel.setVisible(true);
                Toolbox.implementa_label(CONTENT_image,"",false,WIDTH/2-CONTENT_X_SIZE/2,(HEIGHT-(HEIGHT/8+HEIGHT/5))/2-CONTENT_Y_SIZE/2,CONTENT_X_SIZE,CONTENT_Y_SIZE,CONTENTpanel);
                Toolbox.edita_panel(CONTENTpanel,false,new Color(31,32,37)); //1,32,37
            }
        }

    }

}
