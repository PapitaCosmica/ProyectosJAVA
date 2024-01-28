package Modelo;

class Nodo<T extends Comparable<T>> {
    T dato;
    Nodo<T> izquierda, derecha;

    public Nodo(T dato) {
        this.dato = dato;
        this.izquierda = this.derecha = null;
    }
}

public class ArbolBinario<T extends Comparable<T>> {
    private Nodo<T> raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public void insertar(T dato) {
        this.raiz = insertarRec(this.raiz, dato);
    }

    private Nodo<T> insertarRec(Nodo<T> raiz, T dato) {
        if (raiz == null) {
            return new Nodo<>(dato);
        }

        if (dato.compareTo(raiz.dato) < 0) {
            raiz.izquierda = insertarRec(raiz.izquierda, dato);
        } else if (dato.compareTo(raiz.dato) > 0) {
            raiz.derecha = insertarRec(raiz.derecha, dato);
        }

        return raiz;
    }

    public T buscar(T dato) {
        return buscarRec(this.raiz, dato);
    }

    private T buscarRec(Nodo<T> raiz, T dato) {
        if (raiz == null) {
            return null;
        }

        if (dato.compareTo(raiz.dato) == 0) {
            return raiz.dato;
        } else if (dato.compareTo(raiz.dato) < 0) {
            return buscarRec(raiz.izquierda, dato);
        } else {
            return buscarRec(raiz.derecha, dato);
        }
    }

    public void eliminar(T dato) {
        this.raiz = eliminarRec(this.raiz, dato);
    }

    private Nodo<T> eliminarRec(Nodo<T> raiz, T dato) {
        if (raiz == null) {
            return null;
        }

        if (dato.compareTo(raiz.dato) < 0) {
            raiz.izquierda = eliminarRec(raiz.izquierda, dato);
        } else if (dato.compareTo(raiz.dato) > 0) {
            raiz.derecha = eliminarRec(raiz.derecha, dato);
        } else {
 
            if (raiz.izquierda == null) {
                return raiz.derecha;
            } else if (raiz.derecha == null) {
                return raiz.izquierda;
            }

     
            raiz.dato = encontrarMenor(raiz.derecha);

      
            raiz.derecha = eliminarRec(raiz.derecha, raiz.dato);
        }

        return raiz;
    }

    private T encontrarMenor(Nodo<T> raiz) {
        T min = raiz.dato;
        while (raiz.izquierda != null) {
            min = raiz.izquierda.dato;
            raiz = raiz.izquierda;
        }
        return min;
    }

    public Nodo<T> getRaiz() {
        return this.raiz;
    }

 
    public void preorden() {
        preordenRec(this.raiz);
    }

    private void preordenRec(Nodo<T> nodo) {
        if (nodo != null) {
            System.out.print(nodo.dato + " ");
            preordenRec(nodo.izquierda);
            preordenRec(nodo.derecha);
        }
    }

    public void inorden() {
        inordenRec(this.raiz);
    }

    private void inordenRec(Nodo<T> nodo) {
        if (nodo != null) {
            inordenRec(nodo.izquierda);
            System.out.print(nodo.dato + " ");
            inordenRec(nodo.derecha);
        }
    }

    public void postorden() {
        postordenRec(this.raiz);
    }

    private void postordenRec(Nodo<T> nodo) {
        if (nodo != null) {
            postordenRec(nodo.izquierda);
            postordenRec(nodo.derecha);
            System.out.print(nodo.dato + " ");
        }
    }
}
