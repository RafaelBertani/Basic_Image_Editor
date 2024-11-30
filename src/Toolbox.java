//import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;

import java.io.File;
import java.util.List;

//import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Toolbox{

    public static void implementa_frame(JFrame nome_frame, boolean setVisible, int setDefaultCloseOperation, int largura, int altura){
        nome_frame.setDefaultCloseOperation(setDefaultCloseOperation);
        nome_frame.setVisible(true);
        nome_frame.setSize(largura,altura);
    }

    public static void edita_frame(JFrame nome_jframe, String titulo, Color back){
        nome_jframe.setTitle(titulo);
        if(back!=null){nome_jframe.getContentPane().setBackground(back);}
    }

    public static void implementa_panel(JPanel nome_panel, JFrame frame_do_panel, int x, int y, int largura, int altura){

        nome_panel.setBounds(x,y,largura,altura);
        nome_panel.setLayout(null);
        
        //TERMINA DE IMPLEMENTAR JFRAME
        frame_do_panel.add(nome_panel);
        
    }

    public static void implementa_panel_no_panel(JPanel nome_panel, JPanel panel_do_panel, int x, int y, int largura, int altura){

        nome_panel.setBounds(x,y,largura,altura);
        nome_panel.setLayout(null);
        
        panel_do_panel.add(nome_panel);
        
    }

    public static void edita_panel(JPanel nome_panel, boolean transparente, Color back){
        if(transparente){nome_panel.setOpaque(false); nome_panel.setBackground(new Color(0,0,0,64));}
        else{nome_panel.setOpaque(true); nome_panel.setBackground(back);}
    }

    public static void implementa_label(JLabel nome_label, String texto_label, boolean borda, int x, int y, int largura, int altura, JPanel painel_do_label){

        nome_label.setText(texto_label);
        nome_label.setBounds(x, y, largura, altura);
        if(borda==false){nome_label.setBorder(null);}
        else{nome_label.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));}
        nome_label.setHorizontalAlignment(JLabel.CENTER);
        
        painel_do_label.add(nome_label);

    }
    
    public static void edita_label(JLabel nome_label, Font f, Color back, Color fore){
        if(f!=null){nome_label.setFont(f);}
        if(back!=null){nome_label.setOpaque(true);nome_label.setBackground(back);}
        if(fore!=null){nome_label.setForeground(fore);}
    }

    public static void implementa_textfield(JTextField nome_textfield, String texto_textfield, int x, int y, int largura, int altura, boolean editavel, boolean borda, JPanel painel_do_textfield){

        nome_textfield.setBounds(x, y, largura, altura);
        nome_textfield.setEditable(editavel);
        nome_textfield.setText(texto_textfield);
        if(borda==false){nome_textfield.setBorder(null);}
        nome_textfield.setHorizontalAlignment(JTextField.LEFT); //esquerda para facilitar

        painel_do_textfield.add(nome_textfield);

    }

    public static void edita_textfield(JTextField nome_textfield, Font f, Color back, Color fore){
        if(f!=null){nome_textfield.setFont(f);}
        if(back!=null){nome_textfield.setBackground(back);}
        if(fore!=null){nome_textfield.setForeground(fore);}
    }

    public static void implementa_passwordfield(JPasswordField nome_passwordfield, int x, int y, int largura, int altura, boolean borda, JPanel painel_do_passwordfield){

        nome_passwordfield.setBounds(x, y, largura, altura);
        nome_passwordfield.setEditable(true);
        nome_passwordfield.setText("");
        if(borda==false){nome_passwordfield.setBorder(null);}
        nome_passwordfield.setHorizontalAlignment(JTextField.LEFT); //esquerda para facilitar

        painel_do_passwordfield.add(nome_passwordfield);

    }
    
    public static void edita_passwordfield(JTextField nome_passwordfield, Font f, Color back, Color fore){
        if(f!=null){nome_passwordfield.setFont(f);}
        if(back!=null){nome_passwordfield.setBackground(back);}
        if(fore!=null){nome_passwordfield.setForeground(fore);}
    }

    public static void implementa_textarea(JTextArea nome_textarea, String texto_textarea, int x, int y, int largura, int altura, boolean editavel, boolean borda, JPanel painel_do_textarea){

        nome_textarea.setText(texto_textarea);
        nome_textarea.setBounds(x, y, largura, altura);
        nome_textarea.setEditable(editavel);
        if(borda==false){nome_textarea.setBorder(null);}
    
        painel_do_textarea.add(nome_textarea);

    }

    public static void edita_textarea(JTextArea nome_textarea, Font f, Color back, Color fore, MouseListener ml){
        if(f!=null){nome_textarea.setFont(f);}
        if(back!=null){nome_textarea.setBackground(back);}
        if(fore!=null){nome_textarea.setForeground(fore);}
        if(ml!=null){nome_textarea.addMouseListener(ml);}
    }

    public static void implementa_scrollpane(JTextArea nome_textarea, JFrame frame_do_scroll, String texto_scrollpane, int linhas, int colunas, int x, int y, int largura, int altura){
        
        nome_textarea.setRows(linhas);
        nome_textarea.setColumns(colunas);
        nome_textarea.setText(texto_scrollpane);
        JPanel panel_do_scroll = new JPanel();
        
        //panelPRINCIPAL.setBorder(new TitledBorder(new EtchedBorder(),"Display area"));
        panel_do_scroll.setBounds(x,y,largura,altura);
        //panelPRINCIPAL.setBackground(new Color(255,255,0));

        JScrollPane scrollPane = new JScrollPane(nome_textarea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel_do_scroll.add(scrollPane);

        frame_do_scroll.add(panel_do_scroll);

    }

    public static void implementa_scrollpane_em_panel_separado(JTextArea nome_textarea, JPanel panel_do_scroll, JFrame frame_do_scroll, String texto_scrollpane, int linhas, int colunas, int x, int y, int largura, int altura){
        
        nome_textarea.setRows(linhas);
        nome_textarea.setColumns(colunas);
        nome_textarea.setText(texto_scrollpane);
        
        //panelPRINCIPAL.setBorder(new TitledBorder(new EtchedBorder(),"Display area"));
        panel_do_scroll.setBounds(x,y,largura,altura);
        //panelPRINCIPAL.setBackground(new Color(255,255,0));

        JScrollPane scrollPane = new JScrollPane(nome_textarea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        panel_do_scroll.add(scrollPane);

        frame_do_scroll.add(panel_do_scroll);
    }

    public static void edita_scrollpane(JTextArea nome_textarea, Font f, Color back, Color fore, MouseListener ml){
        if(f!=null){nome_textarea.setFont(f);}
        if(back!=null){nome_textarea.setBackground(back);}
        if(fore!=null){nome_textarea.setForeground(fore);}
        if(ml!=null){nome_textarea.addMouseListener(ml);}
    }

    public static void implementa_button(JButton nome_button, String texto_button, int x, int y, int largura, int altura, Interface thisINTERFACE, JPanel painel_do_botao){
        
        nome_button.setText(texto_button);
        nome_button.addActionListener(thisINTERFACE);
        nome_button.setBounds(x,y,largura,altura);

        painel_do_botao.add(nome_button);

    }

    public static void implementa_button(JButton nome_button, String texto_button, int x, int y, int largura, int altura, TOOLS_panel thisTOOLS_PANEL, JPanel painel_do_botao){
        
        nome_button.setText(texto_button);
        nome_button.addActionListener(thisTOOLS_PANEL);
        nome_button.setBounds(x,y,largura,altura);

        painel_do_botao.add(nome_button);

    }

    public static void edita_button(JButton nome_button, Font f, Color back, Color fore){
        if(f!=null){nome_button.setFont(f);}
        if(back!=null){nome_button.setBackground(back);}
        if(fore!=null){nome_button.setForeground(fore);}
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void implementa_combobox(JComboBox nome_combobox, ItemListener il, int x, int y, int largura, int altura, int n_de_linhas_por_vez, int item_inicial, JPanel painel_da_combobox){
    
        nome_combobox.setMaximumRowCount(n_de_linhas_por_vez);
        nome_combobox.setEditable(false);
        nome_combobox.setBounds(x,y,largura,altura);
        nome_combobox.setAlignmentX(JComboBox.CENTER_ALIGNMENT); //centro para facilitar
        if(il!=null){nome_combobox.addItemListener(il);}
        nome_combobox.setSelectedIndex(item_inicial);
        //nome_combobox.setSelectedItem(item_inicial);
        
        //para centralizar os itens
        DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
        dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
        nome_combobox.setRenderer(dlcr);
        
        painel_da_combobox.add(nome_combobox);
        
    }

    @SuppressWarnings("rawtypes")
    public static void edita_combobox(JComboBox nome_combobox, Font f, Color back, Color fore){
        if(f!=null){nome_combobox.setFont(f);}
        if(back!=null){nome_combobox.setBackground(back);}
        if(fore!=null){nome_combobox.setForeground(fore);}
    }
   
    public static void implementa_radiobutton(JRadioButton nome_rb, String texto_radio_button, int x, int y, int largura, int altura, ButtonGroup nome_bg, JPanel painel_da_radio_button){
        
        nome_rb.setText(texto_radio_button);
        nome_rb.setBounds(x,y,largura,altura);    
        
        nome_rb.setActionCommand(nome_rb.getText());
        
        nome_bg.add(nome_rb);

        painel_da_radio_button.add(nome_rb);
    
    }

    public static void edita_radiobutton(JRadioButton nome_rb, Font f, Color back, Color fore){

        if(f!=null){nome_rb.setFont(f);}
        if(back!=null){nome_rb.setBackground(back);}
        if(fore!=null){nome_rb.setForeground(fore);}

    }

    public static void implementa_imagem(JLabel nome_label, String caminho_completo, int x, int y, int largura, int altura, JPanel painel_do_label){

        nome_label.setBounds(x,y,largura,altura);
        nome_label.setIcon(new ImageIcon(caminho_completo));
        painel_do_label.add(nome_label);

    }

    public static void implementa_menubar(JMenuBar nome_menubar, String[] principais, List<String[]> secundarios, List<String[]> terciario, Interface thisINTERFACE, JFrame jframe_da_menubar){
        
        int contador = 0;
        int subitemEmenu = -1; //localização da linha no terceario com os subsubitens
        for(String item : principais){
            JMenu menu = new JMenu(item);
            for(String subitem : secundarios.get(contador)){    
                
                subitemEmenu = -1;
                // key1,value,value,value
                // key2,value,value,value
                for(int k=0;k<terciario.size();k++){if(terciario.get(k)[0].equals(subitem)){subitemEmenu=k;}}

                if(subitemEmenu!=-1){ //se item é menu e possui subitens
                    JMenu i = new JMenu(subitem); //item é um menu
                    for(int j=1;j<terciario.get(subitemEmenu).length;j++){ //percorre todos os subitens do menu que foi descoberto
                        JMenuItem subsubitem = new JMenuItem(terciario.get(subitemEmenu)[j]); //item do menu descoberto
                        i.add(subsubitem); //adiciona item no menu (ou em outras palavras, subitem no submenu)
                        subsubitem.addActionListener(thisINTERFACE); //actionlistener no subitem
                    }
                    menu.add(i); //menu principal recebe o menu (agora arrumado) descoberto
                }
                else{JMenuItem i = new JMenuItem(subitem);menu.add(i);i.addActionListener(thisINTERFACE);}
                subitemEmenu=-1;

            }
            nome_menubar.add(menu);
            contador++;
        }


        jframe_da_menubar.setJMenuBar(nome_menubar);

    }

    public static void implementa_bar(JProgressBar nome_bar, java.awt.Color back, java.awt.Color fore, int value, int minimun, int maximum, int x, int y, int largura, int altura, JPanel panel_da_bar){
        nome_bar.setBackground(back);
        nome_bar.setForeground(fore);
        //nome_bar.setOrientation(JProgressBar.CENTER);
        nome_bar.setMinimum(minimun);
        nome_bar.setMaximum(maximum);
        nome_bar.setValue(value);
        nome_bar.setBounds(x,y,largura,altura);
        panel_da_bar.add(nome_bar);
    }

    public static void atualiza_cor_bar(JProgressBar nome_bar, int value, double[] maxima_porcentagem_cor, Color[] cores){
        
        if(maxima_porcentagem_cor.length==cores.length){
            nome_bar.setValue(value);
        
            double porcentagem = (
                Float.parseFloat(""+ (nome_bar.getValue()-nome_bar.getMinimum()) )
                /
                Float.parseFloat(""+ (nome_bar.getMaximum()-nome_bar.getMinimum()) )
            );
            for(int i=0;i<maxima_porcentagem_cor.length;i++){
                if(porcentagem<=maxima_porcentagem_cor[i]){nome_bar.setForeground(cores[i]);break;}
            }
                
        }
        nome_bar.setValue(value);
        
    }

    public static void implementa_checkbox(JCheckBox nome_checkbox, String text, int x, int y, int largura, int altura, boolean selected, JPanel panel_do_checkbox){
        nome_checkbox.setText(text);
        nome_checkbox.setBounds(x, y, largura, altura);
        nome_checkbox.setSelected(selected);
        panel_do_checkbox.add(nome_checkbox);
    }

    public static void edita_checkbox(JCheckBox nome_checkbox, Font font, Color back, Color fore){
        if(font!=null){nome_checkbox.setFont(font);}
        if(back!=null){nome_checkbox.setBackground(back);}
        if(fore!=null){nome_checkbox.setForeground(fore);}
    }

    public static File implementa_filechooser(String titulo, boolean qualquer_tipo_de_arquivo, boolean apenas_imagens, String tipo_do_arquivo){

        JFileChooser j = new JFileChooser();
        j.setDialogTitle(titulo);
        if(qualquer_tipo_de_arquivo==false){
            j.setAcceptAllFileFilterUsed(false);

            
            FileNameExtensionFilter t;

            if(apenas_imagens){
                t = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif", "bmp");
            }
            else{
                //FileNameExtensionFilter t = new FileNameExtensionFilter("Only .txt files","txt"); //"JPEG file", "jpg", "jpeg"
                t = new FileNameExtensionFilter("Only ."+tipo_do_arquivo+" files",tipo_do_arquivo);
            }
            
            j.addChoosableFileFilter(t);

        }

        j.showOpenDialog(null);
        
        return j.getSelectedFile();

    }

    public static File implementa_folderchooser(String titulo){
        
        JFileChooser j = new JFileChooser();
        j.setDialogTitle(titulo);
        j.setAcceptAllFileFilterUsed(false);
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        j.showOpenDialog(null);
    
        return j.getSelectedFile();
    
    }

    public static void TROCA_JFRAMES(JFrame de, JFrame para){
        de.setVisible(false);
        para.setVisible(true);
    }

    public static void mensagem_de_erro(String mensagem, String titulo){
        JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.ERROR_MESSAGE);
    }

    public static int mensagem_opcoes(String mensagem, String titulo, String opcoes[]){
        return JOptionPane.showOptionDialog(null,mensagem,titulo,JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE,null,opcoes,null);
    }

    public static void mensagem_informacao(String mensagem, String titulo){
        JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

}