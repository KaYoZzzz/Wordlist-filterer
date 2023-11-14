package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Engine;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author david
 */
public class MyFrame extends JFrame implements ActionListener {

    private static final String TITLE = "Wordlist Filter";
    private static final int LENGHT = 500;
    private static final int WIDTH = 800;
    private TopPanel topPanel;
    private MidPanel midPanel;
    private BotPanel botPanel;
    
    private String wordlistPath;
    private String outputPath;
    private int minLenght;
    private int maxLenght;
    private Engine engine;
    
    public MyFrame() {
        super();
        this.setTitle(this.TITLE);
        this.setSize(this.LENGHT, this.WIDTH);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.topPanel = new TopPanel(this);
        this.midPanel = new MidPanel();
        this.botPanel = new BotPanel(this);
        this.add(this.topPanel, BorderLayout.NORTH);
        this.add(this.midPanel, BorderLayout.CENTER);
        this.add(this.botPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case ("Browse"):
                //System.out.println("mbare");

                JFileChooser file_upload = new JFileChooser();
                int res_2 = file_upload.showSaveDialog(null);
                if (res_2 == JFileChooser.APPROVE_OPTION) {
                    wordlistPath = new File(file_upload.getSelectedFile().getAbsolutePath()).toString(); 
                    //System.out.println(wordlistPath);
                    this.topPanel.setWordlistFieldText(wordlistPath);
                }
                break;

            case ("Select"):
                //System.out.println("hellew");

                JFileChooser chooser;
                chooser = new JFileChooser();
                chooser.setCurrentDirectory(new java.io.File("."));
                String choosertitle = "";
                chooser.setDialogTitle(choosertitle);
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                //
                // disable the "All files" option.
                //
                chooser.setAcceptAllFileFilterUsed(false);
                //    
                if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                    outputPath = new File(chooser.getSelectedFile().getAbsolutePath()).toString(); 
                    //System.out.println(outputPath);
                    this.topPanel.setOutputPathFieldText(outputPath);
                } else {
                    JOptionPane.showMessageDialog(this, "No folder has been insert, try again");
                }

                break;
            case ("Confirm"):
                //System.out.println("ciao");
                JOptionPane.showMessageDialog(null, "The filtering is starting!\nDO NOT CLOSE THE PROGRAM\nA pop-up will show up when the filtering is complete");
                this.engine = new Engine(this.wordlistPath, this.outputPath);
                this.minLenght = Integer.parseInt(this.midPanel.getMinCharsField());
                this.maxLenght = Integer.parseInt(this.midPanel.getMaxCharsField());
                this.engine.start(this.minLenght, this.maxLenght);
                JOptionPane.showMessageDialog(null, "Filtering complete!");
        }
    }
}
