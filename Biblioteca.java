import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Llibre> llibres;
    private List<Usuari> usuaris;

    public Biblioteca() {
        this.llibres = new ArrayList<>();
        this.usuaris = new ArrayList<>();
    }

    // Gestión de libros
    public void afegirLlibre(Llibre llibre) {
        llibres.add(llibre);
    }

    public boolean eliminarLlibre(String titol) {
        Llibre llibre = cercarLlibre(titol);
        if (llibre != null && !llibre.esPrestat()) {
            llibres.remove(llibre);
            return true;
        }
        return false;
    }

    public Llibre cercarLlibre(String titol) {
        for (Llibre llibre : llibres) {
            if (normalitzarText(llibre.getTitol()).equalsIgnoreCase(normalitzarText(titol))) {
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

    public boolean modificarLlibre(String titol, String nouTitol, String nouAutor) {
        Llibre llibre = cercarLlibre(titol);
        if (llibre != null) {
            llibre.setTitol(nouTitol);
            llibre.setAutor(nouAutor);
            return true;
        }
        return false;
    }

    // Gestión de usuarios
    public void afegirUsuari(Usuari usuari) {
        usuaris.add(usuari);
    }

    public boolean eliminarUsuari(String id) {
        Usuari usuari = cercarUsuari(id);
        if (usuari != null && usuari.getLlibresPrestats().isEmpty()) {
            usuaris.remove(usuari);
            return true;
        }
        return false;
    }

    public Usuari cercarUsuari(String id) {
        for (Usuari usuari : usuaris) {
            if (usuari.getId().equalsIgnoreCase(id)) {
                return usuari;
            }
        }
        return null;
    }

    public boolean modificarUsuari(String id, String nouNom) {
        Usuari usuari = cercarUsuari(id);
        if (usuari != null) {
            usuari.setNom(nouNom);
            return true;
        }
        return false;
    }

    // Listados
    public String llistarLlibres() {
        if (llibres.isEmpty()) {
            return "No hi ha llibres a la biblioteca";
        }
        StringBuilder llistat = new StringBuilder();
        for (Llibre llibre : llibres) {
            llistat.append(llibre.toString()).append("\n");
        }
        return llistat.toString();
    }

    public String llistarUsuaris() {
        if (usuaris.isEmpty()) {
            return "No hi ha usuaris registrats";
        }
        StringBuilder llistat = new StringBuilder();
        for (Usuari usuari : usuaris) {
            llistat.append(usuari.toString()).append("\n");
        }
        return llistat.toString();
    }

    // Préstamos y devoluciones
    public boolean prestarLlibre(String idUsuari, String titolLlibre) {
        Usuari usuari = cercarUsuari(idUsuari);
        Llibre llibre = cercarLlibre(titolLlibre);
        
        if (usuari != null && llibre != null && !llibre.esPrestat()) {
            usuari.afegirLlibre(llibre);
            return true;
        }
        return false;
    }

    public boolean retornarLlibre(String idUsuari, String titolLlibre) {
        Usuari usuari = cercarUsuari(idUsuari);
        Llibre llibre = cercarLlibre(titolLlibre);
        
        if (usuari != null && llibre != null && llibre.esPrestat()) {
            return usuari.retornarLlibre(llibre);
        }
        return false;
    }

    // Método para ignorar acentos
    private String normalitzarText(String text) {
        return text.toLowerCase()
                .replace("à", "a").replace("á", "a")
                .replace("è", "e").replace("é", "e")
                .replace("ì", "i").replace("í", "i")
                .replace("ò", "o").replace("ó", "o")
                .replace("ù", "u").replace("ú", "u")
                .replace("ç", "c").replace("ñ", "n");
    }
}