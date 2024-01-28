package lista;

public class Listalibro {
    private Nodo inicio;

    public Listalibro() {
        inicio = null;
    }

    public boolean listalibrovacio() {
        return inicio == null;
    }

    public void agregarLibro(Libro libro) {
        Nodo nodo = new Nodo();
        nodo.setLibro(libro);
        nodo.setApuntador(null);

        if (listalibrovacio()) {
            inicio = nodo;
        } else {
            Nodo aux = inicio;
            while (aux.getApuntador() != null) {
                aux = aux.getApuntador();
            }
            aux.setApuntador(nodo);
        }
    }

    public Libro buscarLibro(int isbn) {
        Nodo aux = inicio;

        while (aux != null) {
            if (aux.getLibro().getIsbn() == isbn) {
                return aux.getLibro();
            }
            aux = aux.getApuntador();
        }

        return null; // Si no se encuentra el libro con el ISBN especificado
    }
}
