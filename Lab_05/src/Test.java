import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Test {
    public static void createAndShowGUI() { 
    	Font myFont2 = new Font("Arial", Font.BOLD, 12);
        JFrame f = new JFrame("My First Calculator - v.0.1");  
     	Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - f.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - f.getHeight()) / 2);
        f.setLocation(x, y);
        f.setLayout(new FlowLayout());
        JButton b1=new JButton("1");    
        JButton b2=new JButton("2");    
        JButton b3=new JButton("3");    
        JButton b4=new JButton("4");    
        JButton b5=new JButton("5");    
        JButton b6=new JButton("6");    
        JButton b7=new JButton("7");    
        JButton b8=new JButton("8");    
        JButton b9=new JButton("9");
        JButton b10=new JButton("0");
        JButton badd=new JButton("+");    
        JButton bdif=new JButton("-");    
        JButton bmul=new JButton("*");
        JButton bdiv=new JButton("/");    
        JButton bclc=new JButton("C");    
        JButton beq=new JButton("="); 
        JTextField textfield = new JTextField();
        textfield.setBounds(30,25,400,50);
        textfield.setFont(myFont2);
        f.add(textfield);
        textfield.setEditable(false);
        JPanel panel = new JPanel();
        panel.setBounds(30,90,400,200);
        panel.setLayout(new GridLayout(5,4,10,5));
        panel.add(b1); panel.add(b2); panel.add(b3);panel.add(badd);
        panel.add(b4); panel.add(b5); panel.add(b6); panel.add(bdif); 
        panel.add(b7); panel.add(b8); panel.add(b9); panel.add(bmul);
        panel.add(b10);panel.add(bclc); panel.add(beq); panel.add(bdiv); 
        f.add(panel);
        f.setLayout(null); 
        f.setSize(470,300);
        f.setResizable(false);
        f.setVisible(true);    
        
    }

	
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() { createAndShowGUI(); }
        });        
    }

}