package Modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JFrame {
    private static final long serialVersionUID = 1L;
    private ArbolBinario<Libro> arbolLibros;
    private ArbolBinario<Usuario> arbolUsuarios;

    public Principal() {
        arbolLibros = new ArbolBinario<>();
        arbolUsuarios = new ArbolBinario<>();
        initComponents();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Crear una instancia de Principal
            Principal principal = new Principal();

            // Configurar la operación de cierre cuando se hace clic en el botón de cierre de la ventana
            principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Hacer visible la ventana
            principal.setVisible(true);
        });
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Biblioteca");
        setSize(400, 300);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

        // Panel de Películas
        JPanel panelLibros = new JPanel();
        panelLibros.setBackground(new Color(255, 255, 0));
        tabbedPane.addTab("Libros", null, panelLibros, null);

        JButton btnAgregarLibro = new JButton("Agregar Libro");
        panelLibros.add(btnAgregarLibro);

        btnAgregarLibro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarLibro();
            }
        });

        JButton btnBuscarLibro = new JButton("Buscar Libro");
        panelLibros.add(btnBuscarLibro);

        btnBuscarLibro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarLibro();
            }
        });

        JButton btnEliminarLibro = new JButton("Eliminar Libro");
        panelLibros.add(btnEliminarLibro);

        btnEliminarLibro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarLibro();
            }
        });

        JButton btnListarLibro = new JButton("Listar Libros");
        panelLibros.add(btnListarLibro);

        btnListarLibro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarLibros();
            }
        });
        
        JMenu menu = new JMenu("New menu");
        tabbedPane.addTab("New tab", null, menu, null);

        // Panel de Usuarios
        JPanel panelUsuarios = new JPanel();
        panelUsuarios.setBackground(new Color(255, 255, 0));
        tabbedPane.addTab("Usuarios", null, panelUsuarios, null);

        JButton btnAgregarUsuario = new JButton("Agregar Usuario");
        panelUsuarios.add(btnAgregarUsuario);

        btnAgregarUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarUsuario();
            }
        });

        JButton btnBuscarUsuario = new JButton("Buscar Usuario");
        panelUsuarios.add(btnBuscarUsuario);

        btnBuscarUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarUsuario();
            }
        });

        JButton btnEliminarUsuario = new JButton("Eliminar Usuario");
        panelUsuarios.add(btnEliminarUsuario);

        btnEliminarUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarUsuario();
            }
        });

        JButton btnListarUsuarios = new JButton("Listar Usuarios");
        panelUsuarios.add(btnListarUsuarios);

        btnListarUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarUsuarios();
            }
        });

        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }

    private void agregarLibro() {
        String id = JOptionPane.showInputDialog("Ingrese el ID del libro: ");
        String titulo = JOptionPane.showInputDialog("Ingrese el título del libro: ");
        String director = JOptionPane.showInputDialog("Ingrese el autor del libro: ");
        String clasificacion = JOptionPane.showInputDialog("Ingrese la sinopsis del libro: ");

        if (id != null && !id.isEmpty() && titulo != null && !titulo.isEmpty()
                && director != null && !director.isEmpty() && clasificacion != null && !clasificacion.isEmpty()) {

            Libro nuevaLibro = new Libro(titulo, id, director, clasificacion);
            arbolLibros.insertar(nuevaLibro);
            JOptionPane.showMessageDialog(this, "Libro agregado correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese datos válidos para el libro.");
        }
    }

    private void buscarLibro() {
        String id = JOptionPane.showInputDialog("Ingrese el ID del Libro a buscar:");
        if (id != null && !id.isEmpty()) {
            Libro LibroBuscada = arbolLibros.buscar(new Libro("", id, "", ""));
            if (LibroBuscada != null) {
                JOptionPane.showMessageDialog(this, "Libro encontrada:\n" + LibroBuscada.toString());
            } else {
                JOptionPane.showMessageDialog(this, "Libro no encontrada.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese un ID válido para buscar el Libro.");
        }
    }

    private void eliminarLibro() {
        String id = JOptionPane.showInputDialog("Ingrese el ID de el Libro a eliminar:");
        if (id != null && !id.isEmpty()) {
            Libro LibroAEliminar = arbolLibros.buscar(new Libro("", id, "", ""));
            if (LibroAEliminar != null) {
                arbolLibros.eliminar(LibroAEliminar);
                JOptionPane.showMessageDialog(this, "Libro eliminada correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Libro no encontrada para eliminar.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese un ID válido para eliminar el libro.");
        }
    }

    private void listarLibros() {
        JTextArea areaTexto = new JTextArea();
        areaTexto.setText("Lista de Películas (Título - ID - Autor - Sinopsis):\n");

        // Listar en preorden
        areaTexto.append("Preorden:\n");
        listarPreorden(arbolLibros.getRaiz(), areaTexto);

        // Listar en inorden
        areaTexto.append("\nInorden:\n");
        listarInorden(arbolLibros.getRaiz(), areaTexto);

        // Listar en postorden
        areaTexto.append("\nPostorden:\n");
        listarPostorden(arbolLibros.getRaiz(), areaTexto);

        JScrollPane scrollPane = new JScrollPane(areaTexto);
        JOptionPane.showMessageDialog(this, scrollPane, "Listar Libros", JOptionPane.PLAIN_MESSAGE);
    }

    private void listarPreorden(Nodo<Libro> nodo, JTextArea areaTexto) {
        if (nodo != null) {
            areaTexto.append(nodo.dato.toString() + "\n");
            listarPreorden(nodo.izquierda, areaTexto);
            listarPreorden(nodo.derecha, areaTexto);
        }
    }

    private void listarInorden(Nodo<Libro> nodo, JTextArea areaTexto) {
        if (nodo != null) {
            listarInorden(nodo.izquierda, areaTexto);
            areaTexto.append(nodo.dato.toString() + "\n");
            listarInorden(nodo.derecha, areaTexto);
        }
    }

    private void listarPostorden(Nodo<Libro> nodo, JTextArea areaTexto) {
        if (nodo != null) {
            listarPostorden(nodo.izquierda, areaTexto);
            listarPostorden(nodo.derecha, areaTexto);
            areaTexto.append(nodo.dato.toString() + "\n");
        }
    }

    private void agregarUsuario() {
        String id = JOptionPane.showInputDialog("Ingrese el ID del usuario:");
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del usuario:");
        String email = JOptionPane.showInputDialog("Ingrese el correo electrónico del usuario:");

        if (id != null && !id.isEmpty() && nombre != null && !nombre.isEmpty()
                && email != null && !email.isEmpty()) {

            Usuario nuevoUsuario = new Usuario(nombre, id, email);
            arbolUsuarios.insertar(nuevoUsuario);
            JOptionPane.showMessageDialog(this, "Usuario agregado correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese datos válidos para el usuario.");
        }
    }

    private void buscarUsuario() {
        String id = JOptionPane.showInputDialog("Ingrese el ID del Usuario a buscar:");
        if (id != null && !id.isEmpty()) {
            Usuario usuarioBuscado = arbolUsuarios.buscar(new Usuario("", id, ""));
            if (usuarioBuscado != null) {
                JOptionPane.showMessageDialog(this, "Usuario encontrado:\n" + usuarioBuscado.toString());
            } else {
                JOptionPane.showMessageDialog(this, "Usuario no encontrado.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese un ID válido para buscar el Usuario.");
        }
    }

    private void eliminarUsuario() {
        String id = JOptionPane.showInputDialog("Ingrese el ID del Usuario a eliminar:");
        if (id != null && !id.isEmpty()) {
            Usuario usuarioAEliminar = arbolUsuarios.buscar(new Usuario("", id, ""));
            if (usuarioAEliminar != null) {
                arbolUsuarios.eliminar(usuarioAEliminar);
                JOptionPane.showMessageDialog(this, "Usuario eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Usuario no encontrado para eliminar.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese un ID válido para eliminar el Usuario.");
        }
    }

    
    private void listarUsuarios() {
        JTextArea areaTexto = new JTextArea();
        areaTexto.setText("Lista de Usuarios (Nombre - ID - Email):\n");

        // Listar en preorden
        areaTexto.append("Preorden:\n");
        listarPreordenUsuarios(arbolUsuarios.getRaiz(), areaTexto);

        // Listar en inorden
        areaTexto.append("\nInorden:\n");
        listarInordenUsuarios(arbolUsuarios.getRaiz(), areaTexto);

        // Listar en postorden
        areaTexto.append("\nPostorden:\n");
        listarPostordenUsuarios(arbolUsuarios.getRaiz(), areaTexto);

        JScrollPane scrollPane = new JScrollPane(areaTexto);
        JOptionPane.showMessageDialog(this, scrollPane, "Listar Usuarios", JOptionPane.PLAIN_MESSAGE);
    }

    private void listarPreordenUsuarios(Nodo<Usuario> nodo, JTextArea areaTexto) {
        if (nodo != null) {
            areaTexto.append(nodo.dato.toString() + "\n");
            listarPreordenUsuarios(nodo.izquierda, areaTexto);
            listarPreordenUsuarios(nodo.derecha, areaTexto);
        }
    }

    private void listarInordenUsuarios(Nodo<Usuario> nodo, JTextArea areaTexto) {
        if (nodo != null) {
            listarInordenUsuarios(nodo.izquierda, areaTexto);
            areaTexto.append(nodo.dato.toString() + "\n");
            listarInordenUsuarios(nodo.derecha, areaTexto);
        }
    }

    private void listarPostordenUsuarios(Nodo<Usuario> nodo, JTextArea areaTexto) {
        if (nodo != null) {
            listarPostordenUsuarios(nodo.izquierda, areaTexto);
            listarPostordenUsuarios(nodo.derecha, areaTexto);
            areaTexto.append(nodo.dato.toString() + "\n");
        }
    }}