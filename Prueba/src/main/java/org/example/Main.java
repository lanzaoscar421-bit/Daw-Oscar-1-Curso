package org.example;

public class Main {
    public static void main(String[] args) {

        Usuario u1 = UsuarioFactory.crearUsuario("admin");
        Usuario u2 = UsuarioFactory.crearUsuario("cliente");

        u1.mostrarRol();
        u2.mostrarRol();
    }
}

// Interfaz
interface Usuario {
    void mostrarRol();
}

// Implementaciones
class Admin implements Usuario {
    public void mostrarRol() {
        System.out.println("Soy Admin");
    }
}

class Cliente implements Usuario {
    public void mostrarRol() {
        System.out.println("Soy Cliente");
    }
}

// Factory
class UsuarioFactory {
    public static Usuario crearUsuario(String tipo) {
        if (tipo.equalsIgnoreCase("admin")) {
            return new Admin();
        } else if (tipo.equalsIgnoreCase("cliente")) {
            return new Cliente();
        } else {
            return null;
        }
    }
}