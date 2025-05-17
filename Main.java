import java.util.Scanner;

public class Main {
     
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca(); 

        boolean sortir = false;
        int opcio;

        System.out.println("Com et dius:");
        Usuari usuari = new Usuari(scanner.next());
        GestorBiblioteca gestor = new GestorBiblioteca();

        while (!sortir) {
            System.out.println("Gestió de llibres");
            System.out.println("1. Afegir llibre");
            System.out.println("2. Prestar llibre");
            System.out.println("3. Eliminar llibre");
            System.out.println("0. Sortir");
            System.out.print("Opció: ");
            opcio = scanner.nextInt();
            scanner.nextLine();

             switch (opcio) {
                case 1:
                    System.out.print("Títol: ");
                    String titol = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    
                    Llibre llibre = new Llibre(titol, autor);

                    biblioteca.afegirLlibre(llibre);
                    
                    break;
                    
                case 2:
                System.out.print("Quin llibre vols prestar ");

                String llibreABuscar = scanner.nextLine();

                    if (llibreABuscar != null) {
                       gestor.prestarLlibre(usuari, biblioteca.buscarLlibre(llibreABuscar));
                    } else {
                        System.out.println("Llibre no trobat.");
                    }
                    break;

                case 3:
                    System.out.print("Quin llibre vols eliminar: ");
                    String titolAEliminar = scanner.nextLine();
                    Llibre llibreAEliminar = biblioteca.buscarLlibre(titolAEliminar);
                   
                    if (llibreAEliminar != null) {
                        biblioteca.getLlibres().remove(llibreAEliminar);
                        System.out.println("Llibre eliminat.");
                    } else {
                        System.out.println("Llibre no trobat.");
                    }
                    break;
               
                case 0:
                    sortir = true;
                    break;

                default:
                    System.out.println("Aquesta opció no existeix");
            }
        }
    }
}
