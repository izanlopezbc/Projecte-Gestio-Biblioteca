import java.util.ArrayList;
import java.util.List;

public class Usuari {
    private String nom;
    private String id;
    private List<Llibre> llibresPrestats;

    public Usuari(String nom, String id) {
        this.nom = nom;
        this.id = id;
        this.llibresPrestats = new ArrayList<>();
    }

    // Getters
    public String getNom() { return nom; }
    public String getId() { return id; }
    public List<Llibre> getLlibresPrestats() { return llibresPrestats; }

    // Setters (para modificar usuario)
    public void setNom(String nom) { this.nom = nom; }
    public void setId(String id) { this.id = id; }

    // Gestión de préstamos
    public void afegirLlibre(Llibre llibre) {
        if (!llibre.esPrestat()) {
            llibresPrestats.add(llibre);
            llibre.prestar();
        }
    }

    public boolean retornarLlibre(Llibre llibre) {
        if (llibresPrestats.contains(llibre)) {
            llibresPrestats.remove(llibre);
            llibre.retornar();
            return true;
        }
        return false;
    }

    // Listado de libros prestados
    public String llistarLlibresPrestats() {
        if (llibresPrestats.isEmpty()) {
            return "L'usuari no té llibres prestats";
        }
        StringBuilder llistat = new StringBuilder();
        for (Llibre llibre : llibresPrestats) {
            llistat.append("- ").append(llibre.toString()).append("\n");
        }
        return llistat.toString();
    }

    @Override
    public String toString() {
        return "Usuari: " + nom + " (ID: " + id + ") - Llibres prestats: " + llibresPrestats.size();
    }
}