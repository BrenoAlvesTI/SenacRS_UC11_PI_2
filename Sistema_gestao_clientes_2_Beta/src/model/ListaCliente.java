package model;

import java.util.ArrayList;
import java.util.List;

public class ListaCliente {
    
    private static final List<Cliente> listaClientes = new ArrayList<>();

    public static void adicionarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public static void removerCliente(int posCliente) {
        listaClientes.remove(posCliente);
    }

    public static List<Cliente> listarClientes() {
        return listaClientes;
    }

}


