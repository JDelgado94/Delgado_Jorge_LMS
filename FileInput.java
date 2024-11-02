/*Project: Library Management System
Name: Jorge Delgado
Date: 10/29/2024
Course: CEN:3024
Class Name: FileInput
Description: This class will contain the File input GUI, which will allow the
             user to input the list of books from the file into the database
             and transition to the Main menu GUI
*/


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileInput extends JFrame{
    private JPanel filePanel;
    private JTextField FileTextField1;
    private JLabel inputFileLabel;
    private JButton loadFileButton;
    private JButton exitButton;

    private Library library;

    //Constructor:------------------------------------------------------------------------------------------------------
    public FileInput() {
        library = new Library();
        setContentPane(filePanel);
        setTitle("Library Management System");
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        //Load File Button: --------------------------------------------------------------------------------------------
        loadFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = FileTextField1.getText();

                if(!fileName.isEmpty()){
                    File file = new File(fileName);
                    try  (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
                        String line;
                        while((line = reader.readLine()) != null){
                            String[] splitLine = line.split(",");
                            String barcode = splitLine[0];
                            String title = splitLine[1];
                            String author = splitLine[2];
                            String genre = splitLine[3];
                            Book book = new Book(barcode, title, author, genre, "Available", "N/A");
                            library.addBook(book);

                        }
                        JOptionPane.showMessageDialog(filePanel, "Library Added Successfully");
                        openMainMenu();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(filePanel, "Error occured while adding library");

                    }
                } else {
                    JOptionPane.showMessageDialog(filePanel, "Please Enter A Vaild File Name");
                }
            }
        });

        //Exit Button: -------------------------------------------------------------------------------------------------
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
//----------------------------------------------------------------------------------------------------------------------
    /*
     * method: openMainMenu
     * parameters: None
     * return: void
     * purpose: Transitions from the FileInput GUI to the MainMenu GUI
     * */
    private void openMainMenu() {
        this.dispose();
        MainMenu mainMenu = new MainMenu(library);
        mainMenu.setVisible(true);
    }



}

