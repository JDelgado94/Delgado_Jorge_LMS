/*Project: Library Management System
Name: Jorge Delgado
Date: 11/08/2024
Course: CEN:3024
*/

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * <h1>Library Management System</h1>
 *
 * Description -- This application will allow the user to connect to a library
 *              database and add, remove, and check in/out books that are in
 *              the library.
 *
 * @author -- Jorge Delgado
 * @version -- 1.3
 */


public class Main {

    /**
     *
     * Main -- This method starts the GUI LMS application.
     * @param args -- Unused
     *
     */

    public static void main(String[] args) {

        Library lib = new Library();
        MainMenu mainMenu = new MainMenu(lib);

    }

    }
