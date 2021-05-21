package it.uniba.main;

/**
 * <h2>Classe principale del progetto.</h2>
 * <b>Class Type:</b> &#60; Boundary &#62; <br><br>
 * <b>Responsabilities:</b><br>
 * <b>Knows:</b><br>
 *      <b>Does:</b>
 *          <ul>
 *          <li> Permette all'utente di utilizzare il menu</li>
 *          </ul>
 *
 * @author Gruppo Firesmith
 */

public final class AppMain {

    /**
     * Costruttore privato.
     */
    private AppMain() {

    }

    /**
     * Punto di partenza dell'applicazione.
     *
     * @param args Argomenti ottenuti dalla riga di comando.
     */


    public static void main(final String[] args) {

        System.out.println("Current working dir: "
                + System.getProperty("user.dir"));

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
        menu.generico();
    }

}

