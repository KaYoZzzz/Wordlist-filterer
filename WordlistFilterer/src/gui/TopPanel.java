/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author david
 */
public class TopPanel extends JPanel{
    private JTextField wordlistField, outputPathField;
    private JButton browseButton, pathButton;
    private final String buttonWordlistText = "Browse";
    private final String buttonPathText = "Select";
    public TopPanel(ActionListener al) {
        super(new GridLayout(0,2));
       
        this.add(new JLabel ("Insert a wordlist"));
        this.add(new JLabel (""));
        
        this.wordlistField = new JTextField(1);
        this.add(this.wordlistField);
        this.browseButton = new JButton(buttonWordlistText);
        this.browseButton.addActionListener(al);
        this.add(this.browseButton);
        
        
        this.add(new JLabel ("Insert the destination path"));
        this.add(new JLabel (""));
       
        this.outputPathField = new JTextField(1);
        this.add(this.outputPathField);
        this.pathButton = new JButton(buttonPathText);
        this.pathButton.addActionListener(al);
        this.add(this.pathButton);
        }

    public void setWordlistFieldText(String text) {
        wordlistField.setText(text);
    }
    
    public void setOutputPathFieldText(String text) {
        outputPathField.setText(text);
    }
    
}
