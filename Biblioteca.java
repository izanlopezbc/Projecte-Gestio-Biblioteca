
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Llibre> llibres;

    public Biblioteca() {
        this.llibres = new ArrayList<>();
    }

    public void afegirLlibre(Llibre llibre) {
        llibres.add(llibre);
    }

    public Llibre buscarLlibre(String titol) {
        for (Llibre llibre : llibres) {
            if (llibre.getTitol().equalsIgnoreCase(titol)) {
                return llibre;
            }
        }
        return null;
    }

    public Llibre buscarLlibreSenseAccents(String titol) {
    String titolLlibreSenseAccents = treureAccents(titol.toLowerCase());

    for (Llibre llibre : llibres) {
        String titolSenseAccents = treureAccents(llibre.getTitol().toLowerCase());
        if (titolSenseAccents.equals(titolLlibreSenseAccents)) {
            return llibre;
        }
    }
    return null;
}

private String treureAccents(String text) {
    String resultat = "";

    for (int i = 0; i < text.length(); i++) {
        char c = text.charAt(i);

        if (c == 'á' || c == 'à' || c == 'â' || c == 'ä') {
            resultat = resultat + 'a';
        } else if (c == 'é' || c == 'è' || c == 'ê' || c == 'ë') {
            resultat = resultat + 'e';
        } else if (c == 'í' || c == 'ì' || c == 'î' || c == 'ï') {
            resultat = resultat + 'i';
        } else if (c == 'ó' || c == 'ò' || c == 'ô' || c == 'ö') {
            resultat = resultat + 'o';
        } else if (c == 'ú' || c == 'ù' || c == 'û' || c == 'ü') {
            resultat = resultat + 'u';
        } else {
            resultat = resultat + c;
        }
    }

    return resultat;
}

    public List<Llibre> getLlibres() {
        return llibres;
    }
}
