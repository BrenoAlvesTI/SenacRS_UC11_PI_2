
package model;


import java.util.ArrayList;
import java.util.List;

public class ListaProduto {
    
    private static final List<Produto> listaProdutos = new ArrayList<>();

    public static void adicionarProduto(Produto produto) {
        listaProdutos.add(produto);
    }

    public static void removerProduto(int posProduto) {
        listaProdutos.remove(posProduto);
    }

    public static List<Produto> listarProdutos() {
        return listaProdutos;
    }

}
