package it.uniba.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.util.Scanner;



/** Class Type: <<Boundary>>
 *  Responsabilities: The main class for the project.
 *
 * <b>DO NOT RENAME</b>
 */

public final class AppMain {

    /**
     * Private constructor. Change if needed.
     */
    private AppMain() {

    }

    /**
     * 	 * This is the main entry of the application.
     *
     * @param args The command-line arguments.
     */

    public static void main(final String[] args) {

        System.out.println("Current working dir: " + System.getProperty("user.dir"));

        if (args.length > 0) {
            switch (args[0]) {
                case "it":
                    System.out.println("Applicazione avviata.");
                    break;

                case "en":
                    System.out.println("Application started.");
                    break;

                default:
                    System.out.println("Specify the language. "
                            + "Languages supported: 'it' or 'en'");
                    break;
            }
        } else {
            System.out.println("Using default language 'en'");
            System.out.println("Application started.");
        }

        Menu menu = new Menu();
        menu.Generico();
    }

}

