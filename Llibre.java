public class Llibre {
    private String titol;
    private String autor;
    private boolean prestat;

    public Llibre(String titol, String autor) {
        this.titol = titol;
        this.autor = autor;
        this.prestat = false;
    }

    // Getters
    public String getTitol() { return titol; }
    public String getAutor() { return autor; }
    public boolean esPrestat() { return prestat; }

    // Setters (para modificar libro)
    public void setTitol(String titol) { this.titol = titol; }
    public void setAutor(String autor) { this.autor = autor; }

    // Métodos de préstamo
    public void prestar() { prestat = true; }
    public void retornar() { prestat = false; }

    @Override
    public String toString() {
        return titol + " de " + autor + (prestat ? " (En préstec)" : " (Disponible)");
    }
}