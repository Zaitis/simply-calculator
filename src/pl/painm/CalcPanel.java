package pl.painm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcPanel extends JPanel implements ActionListener {
    int PANEL_WIDTH=300;
    int PANEL_HEIGHT=350;
    JButton[] button =new JButton[10];
    JButton dotButton,sumButton, addButton, minusButton, divButton, multiButton;
    double temp = 0, temp2;
    String tempChar;


    CalcPanel(){
        this.setBounds(10,150,PANEL_WIDTH,PANEL_HEIGHT);
        this.setBackground(Color.darkGray);

        this.setLayout(new GridLayout(4,4));

        for (int i=0; i<=9;i++){
            button[i]=new JButton(String.valueOf(i));
            button[i].addActionListener(this);
            button[i].setFont(new Font("MV Boli", Font.BOLD,25));
        }
        addButton= new JButton("+");
        addButton.addActionListener(this);
        addButton.setFont(new Font("MV Boli", Font.BOLD,25));
        minusButton= new JButton("-");
        minusButton.addActionListener(this);
        minusButton.setFont(new Font("MV Boli", Font.BOLD,25));
        multiButton= new JButton("*");
        multiButton.addActionListener(this);
        multiButton.setFont(new Font("MV Boli", Font.BOLD,25));
        divButton= new JButton("/");
        divButton.addActionListener(this);
        divButton.setFont(new Font("MV Boli", Font.BOLD,25));
        dotButton= new JButton(".");
        dotButton.addActionListener(this);
        dotButton.setFont(new Font("MV Boli", Font.BOLD,25));
        sumButton= new JButton("=");
        sumButton.addActionListener(this);
        sumButton.setFont(new Font("MV Boli", Font.BOLD,25));

        this.add(button[1]);
        this.add(button[2]);
        this.add(button[3]);
        this.add(addButton);
        this.add(button[4]);
        this.add(button[5]);
        this.add(button[6]);
        this.add(minusButton);
        this.add(button[7]);
        this.add(button[8]);
        this.add(button[9]);
        this.add(multiButton);
        this.add(dotButton);
        this.add(button[0]);
        this.add(sumButton);
        this.add(divButton);




    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=0; i<=9;i++) {
            if (e.getSource() == button[i]) {
                CalcFrame.displayField.setText(CalcFrame.displayField.getText() + String.valueOf(i));
            }
        }

        if(e.getSource()==addButton){
            temp= Double.parseDouble(CalcFrame.displayField.getText());
            CalcFrame.displayField.setText("");
            tempChar="+";
        }
        if(e.getSource()==minusButton){
            temp= Double.parseDouble(CalcFrame.displayField.getText());
            CalcFrame.displayField.setText("");
            tempChar="-";
        }
        if(e.getSource()==multiButton){
            temp= Double.parseDouble(CalcFrame.displayField.getText());
            CalcFrame.displayField.setText("");
            tempChar="*";
        }
        if(e.getSource()==divButton){
            temp= Double.parseDouble(CalcFrame.displayField.getText());
            CalcFrame.displayField.setText("");
            tempChar="/";
        }

        if(e.getSource()==dotButton) {

            String temp= CalcFrame.displayField.getText();
            boolean tak= temp.contains(".");
            if(!tak)
            CalcFrame.displayField.setText(CalcFrame.displayField.getText() + ".");
        }
        if(e.getSource()==sumButton){
            temp2= Double.parseDouble(CalcFrame.displayField.getText());

            switch(tempChar){
                case "+": temp+=temp2;
                break;
                case "-": temp-=temp2;
                    break;
                case "*": temp*=temp2;
                    break;
                case "/":
                    if(temp2==0)
                        JOptionPane.showMessageDialog(null,"Cholero nie dziel przez ZERO, chyba sam jesteś ZEREM","NIE DZIEL PRZEZ ZERO",JOptionPane.PLAIN_MESSAGE);
                    else
                    temp/=temp2;
                    break;
            }
            CalcFrame.displayField.setText(String.valueOf(temp));

        }

    }
}
