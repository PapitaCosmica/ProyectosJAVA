package lista;

import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {
        String menu = "***MiniBiblioteca\n" +
                "1) Ingresar un Libro\n" +
                "2) Buscar libro\n" +
                "3) Eliminar un libro\n" +
                "4) Salir";

        Listalibro lista = new Listalibro();

        int opcion = 0;

        while (opcion != 4) {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcion) {
                case 1:
                    Libro libro = new Libro();
                    libro.setIsbn(Integer.parseInt(JOptionPane.showInputDialog("Ingresar el ISBN del libro")));
                    libro.setTitulo(JOptionPane.showInputDialog("Ingresar el TITULO del libro"));
                    libro.setAutor(JOptionPane.showInputDialog("Ingresar el AUTOR del libro"));
                    libro.setEditorial(JOptionPane.showInputDialog("Ingresar el EDITORIAL del libro"));
                    lista.agregarLibro(libro);
                    break;

                case 2:
                    int isbnABuscar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ISBN a buscar:"));
                    Libro libroEncontrado = lista.buscarLibro(isbnABuscar);
                    if (libroEncontrado != null) {
                        JOptionPane.showMessageDialog(null, "Libro encontrado:\n" +
                                "Título: " + libroEncontrado.getTitulo() + "\n" +
                                "Autor: " + libroEncontrado.getAutor() + "\n" +
                                "Editorial: " + libroEncontrado.getEditorial());
                    } else {
                        JOptionPane.showMessageDialog(null, "Libro no encontrado.");
                    }
                    break;

                case 3:
                    // Agrega aquí la lógica para eliminar un libro
                    break;

                case 4:
                    // Salir
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
                    break;
            }
        }
    }
}
