/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.GregorianCalendar;
/**
 *
 * @author Milan
 */
public class Main extends JFrame{
    
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Time: ");
    JLabel time = new JLabel(getTime());
    int i;
    
    Main(){
         int width = Toolkit.getDefaultToolkit().getScreenSize().width;
         int height = Toolkit.getDefaultToolkit().getScreenSize().height;
         
         this.setSize(width/2,height/2);
         
         int frameWidth = this.getSize().width;
         int frameHeight = this.getSize().height;
         
         this.setLocation((width-frameWidth)/2, (height-frameHeight)/2);
         
         this.setDefaultCloseOperation(3);
         
         initComponents();
    }

    public void initComponents(){
        panel.add(label);
        panel.add(time);
        this.getContentPane().add(panel);
        
        ActionListener timer = new Clock();
        
        Timer clock = new Timer(1000, timer);
        clock.start(); 
        pack();
    }
    
    private class Clock implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {


            time.setText(getTime());             
        }        
    }
    String getTime(){
        GregorianCalendar calendar = new GregorianCalendar();
        String hour = "" + calendar.get(calendar.HOUR_OF_DAY);
        String minute = "" + calendar.get(calendar.MINUTE);
        String second = "" + calendar.get(calendar.SECOND);
//        System.out.println(hour);
        if(Integer.parseInt(second) < 10) second = "0" + second;
        if(Integer.parseInt(minute) < 10) minute = "0" + minute;
        if(Integer.parseInt(hour) < 10) hour = "0" + hour;
        
        return hour + ":" + minute + ":" + second; 
    }    
    public static void main(String[] args) {
        new Main().setVisible(true);
    }
    
}
