package Modelo;

public class Usuario implements Comparable<Usuario> {
    private String nombre;
    private String id;
    private String email;

    public Usuario(String nombre, String id, String email) {
        this.nombre = nombre;
        this.id = id;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int compareTo(Usuario otroUsuario) {
        return this.id.compareTo(otroUsuario.id);
    }

    @Override
    public String toString() {
        return "Usuario [nombre=" + nombre + ", id=" + id + ", email=" + email + "]";
    }
}
