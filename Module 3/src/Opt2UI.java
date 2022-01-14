import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class Opt2UI extends Frame {

    // panel for color background
    JPanel background = new JPanel();
    JLabel header;
    JButton dateTime;
    JButton log;
    JButton orange;
    Color Orange = new Color(255, 153, 0);
    JButton exit;
    JFrame OrangeApp;

    Opt2UI() {
        JFrame OrangeApp = new JFrame();
        OrangeApp.add(background);

        // header and variables
        header = new JLabel("Pick a button");
        dateTime = new JButton("I write the date and time");
        log = new JButton("I save whatever you type into the pop up");
        orange = new JButton("I make this app turn orange");
        exit = new JButton("I take you out of this app");

        // add buttons and headers
        background.setLayout(new BorderLayout(50, 30));
        background.add(header, BorderLayout.NORTH);
        background.add(exit, BorderLayout.SOUTH);
        background.add(dateTime, BorderLayout.WEST);
        background.add(log, BorderLayout.CENTER);
        background.add(orange, BorderLayout.EAST);
        background.setBackground(Color.WHITE);

        // action listeners
        beenClicked buttonz = new beenClicked();
        dateTime.addActionListener(buttonz);
        exit.addActionListener(buttonz);
        log.addActionListener(buttonz);
        orange.addActionListener(buttonz);
        // set Size and make visible
        OrangeApp.setSize(800, 800);
        OrangeApp.setVisible(true);
    }

    class beenClicked implements ActionListener {
        public void actionPerformed(ActionEvent click) {
            if (click.getSource() == dateTime) {
                Date date = new Date();
                String strDateFormat = "yyyy-MM-dd 'at' HH:mm:ss z";
                DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
                String formattedDate = dateFormat.format(date);
                JOptionPane.showMessageDialog(OrangeApp,
                        "Current time of the day using Date - 12 hour format: " + formattedDate + ".",
                        "A plain message", JOptionPane.PLAIN_MESSAGE);
            }
            if (click.getSource() == exit) {
                System.exit(ABORT);
            }
            if (click.getSource() == orange) {
                background.setBackground(Orange);

            }
            if (click.getSource() == log) {
                String name = JOptionPane.showInputDialog(OrangeApp, "Enter What You Want Saved");
                PrintWriter out;
                try {
                    out = new PrintWriter("log.txt");
                    out.println(name);
                    out.close();
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Opt2UI();
    }

}