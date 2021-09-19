package pl.painm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcFrame extends JFrame implements ActionListener {
CalcPanel panel;

   static JTextField displayField;
   private JButton bClear, bDel;


    CalcFrame(){
        panel= new CalcPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Kalkulator");
        this.setLayout(null);
        this.setSize(new Dimension(350,550));

        displayField= new JTextField();
        displayField.setFont(new Font("MV Boli", Font.BOLD,30));
        displayField.setForeground(new Color(175,122,60));
        displayField.setBounds(10,10,300,50);
        displayField.setEditable(false);

        bClear= new JButton("Clear");
        bClear.setBounds(10,100,150,50);
        bClear.addActionListener(this);

        bDel= new JButton("Delete");
        bDel.setBounds(160,100,150,50);
        bDel.addActionListener(this);

        this.add(displayField);
        this.add(bClear);
        this.add(bDel);
        this.add(panel);

        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==bClear){
            displayField.setText("");

        }

        if(e.getSource()==bDel){
            String temp;
            temp=displayField.getText();
            displayField.setText("");
            for (int i=0; i<=temp.length()-2;i++){
                displayField.setText(displayField.getText()+temp.charAt(i));
            }

        }

    }
}
