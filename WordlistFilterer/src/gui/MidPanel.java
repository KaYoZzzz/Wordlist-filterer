/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author david
 */
public class MidPanel extends JPanel{
    private JTextField minCharsField;
    private JTextField maxCharsField;
    private JLabel panelTitle;
    public MidPanel() {
        super(new GridLayout(0,2));
        this.panelTitle = new JLabel("   Settings");
        this.panelTitle.setFont(new Font("", Font.PLAIN, 24));
        this.add(this.panelTitle);
        this.add(new JLabel(""));
        this.add(new JLabel("       Minimum characters"));
        this.minCharsField = new JTextField (1);
        this.add(this.minCharsField);   
        this.add(new JLabel("       Maximum characters"));
        this.maxCharsField = new JTextField (1);
        this.add(this.maxCharsField);
    }

    public String getMinCharsField() {
        return minCharsField.getText();
    }

    public String getMaxCharsField() {
        return maxCharsField.getText();
    }
}
