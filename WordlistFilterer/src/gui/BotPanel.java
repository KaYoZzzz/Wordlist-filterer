/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author david
 */
public class BotPanel extends JPanel{
    private JButton confirmButton;
    private final String textButton = "Confirm";
    public BotPanel(ActionListener al) {
        super(new FlowLayout());
        this.confirmButton = new JButton(this.textButton);
        this.confirmButton.addActionListener(al);
        this.add(this.confirmButton);
    }
    
}
