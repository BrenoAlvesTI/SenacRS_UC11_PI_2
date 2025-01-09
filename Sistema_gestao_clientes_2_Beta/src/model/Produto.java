package model;

public class Produto {
    private int id;
    private String nome;
    private double valorCusto;  
    private double valorVenda;  
    private int quantidade;
    private int quantidadeRequisitada;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(double valorCusto) {
        this.valorCusto = valorCusto;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    } 
    
    public int getQuantidadeRequisitada() {
        return quantidadeRequisitada;
    }

    public void setQuantidadeRequisitada(int quantidadeRequisitada) {
        this.quantidadeRequisitada = quantidadeRequisitada;
    }

}
