/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author david
 */
public class Engine {

    private String wordlistPath;
    private String outputPath;
    private String fileName = "/"+"output.txt";
    private String line;
    FileWriter fw;
    BufferedReader reader;
    public Engine(String wordlistPath, String outputPath) {
        this.wordlistPath = wordlistPath;
        this.outputPath = outputPath;
    }

    public void start(int minLenght, int maxLenght) {
        try {
            reader = new BufferedReader(new FileReader(wordlistPath));
            this.createFile();
            fw = new FileWriter(this.outputPath + this.fileName);
            this.line = reader.readLine();
            while (line != null) {
                if(line.length() >= minLenght && line.length() <= maxLenght){
                    //System.out.println(line);
                    fw.write(line+"\n");
                }
                else{
                    
                }
                // read next line
                this.line = reader.readLine();
            }
            reader.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void createFile(){
        try {
            File file = new File(this.outputPath + this.fileName);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
