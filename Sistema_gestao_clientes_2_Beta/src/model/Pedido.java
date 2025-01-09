package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Pedido {
    private int id;
    private int idCliente;
    private List<Produto> produtos;
    private LocalDateTime dataHora;
    private BigDecimal valorTotal;

    // Construtor modificado para aceitar uma lista de produtos
    public Pedido(int id, int idCliente, List<Produto> produtos, LocalDateTime dataHora, BigDecimal valorTotal) {
        this.id = id;
        this.idCliente = idCliente;
        this.produtos = produtos;
        this.dataHora = dataHora;
        this.valorTotal = valorTotal;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}

