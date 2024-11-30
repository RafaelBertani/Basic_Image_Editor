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
    private int content_x_start = WIDTH/2-CONTENT_X_SIZE/2;
    private int content_x_end = WIDTH/2-CONTENT_X_SIZE/2+WIDTH/4;
    private int content_y_start = (HEIGHT-(HEIGHT/8+HEIGHT/5))/2-CONTENT_Y_SIZE/2;
    private int content_y_end = (HEIGHT-(HEIGHT/8+HEIGHT/5))/2-CONTENT_Y_SIZE/2+HEIGHT/4;

    public void cria_FRAME_PRINCIPAL(){
        
        //IMPLEMENTA MENUBAR
        String[] princ = {"OP1","OP2","OP3"};
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
        //Toolbox.edita_label(CONTENT_image,null,Color.WHITE,null);
        CONTENT_save = (RandomImage.return_blank_image(HEIGHT/4,WIDTH/4));
        CONTENT_image.setIcon(new ImageIcon( CONTENT_save ));
        CONTENT_image.addMouseListener(ml_draw);
        Toolbox.implementa_panel_no_panel(CONTENTpanel,MAINpanel,0,HEIGHT/8,WIDTH,HEIGHT-(HEIGHT/8+HEIGHT/5));
        Toolbox.edita_panel(CONTENTpanel,false,new Color(31,32,37)); //1,32,37

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
    
    Point location;

    int X=0;
    int Y=0;
    public class thread_extends extends Thread {
        public void run() {
            while(!this.isInterrupted()){
                location = MouseInfo.getPointerInfo().getLocation();
                X = location.x;
                Y = location.y-HEIGHT/5+10;
                // System.out.println(X+" "+content_x_start+" "+content_x_end);
                // System.out.println(Y+" "+content_y_start+" "+content_y_end);
                if(X>=content_x_start && X<=content_x_end && Y>=content_y_start && Y<=content_y_end){
                    CONTENT_save = RandomImage.paint_pixel(CONTENT_save,X-content_x_start,Y-content_y_start,TOOLS_panel.current_color.getBackground());
                    CONTENT_image.setIcon(new ImageIcon(CONTENT_save)); 
                }
            }
        }
    
    }

    thread_extends thread = new thread_extends();
    
    MouseListener ml_draw = new MouseListener() {

        @Override public void mouseClicked(MouseEvent e) {}
        @Override public void mousePressed(MouseEvent e) {
            thread = new thread_extends();
            thread.start();
        }
        @Override public void mouseReleased(MouseEvent e) {
            thread.interrupt();
            thread=null;
        }
        @Override public void mouseEntered(MouseEvent e) {}
        @Override public void mouseExited(MouseEvent e) {}

    };

}
