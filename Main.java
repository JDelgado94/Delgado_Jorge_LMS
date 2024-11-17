/*
Project: Library Management System
Name: Jorge Delgado
Date: 11/08/2024
Course: CEN:3024
App Name: LMS.java
Description: This application will allow the user to connect to a library
 database and add, remove, and check in/out books that are in the library.
*/

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


//Main Method:
public class Main {
    public static void main(String[] args) {
        //Starts GUI Operation:
        Library lib = new Library();
        MainMenu mainMenu = new MainMenu(lib);

    }

    }
