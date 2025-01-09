package model;

import java.util.ArrayList;
import java.util.List;

public class ListaPedido {
    
    private static final List<Pedido> listaPedidos = new ArrayList<>();

    public static void adicionarPedido(Pedido pedido) {
        listaPedidos.add(pedido);
    }

    public static void removerPedido(int posPedido) {
        listaPedidos.remove(posPedido);
    }

    public static List<Pedido> listarPedidos() {
        return listaPedidos;
    }

    public static Pedido buscarPedidoPorId(int idPedido) {
        return listaPedidos.stream()
            .filter(p -> p.getId() == idPedido)
            .findFirst()
            .orElse(null);
    }
}
