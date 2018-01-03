package br.com.tonsoft.modelagemwebservice.model;

import br.com.tonsoft.modelagemwebservice.model.enums.EstadoPagamento;

import javax.persistence.Entity;

@Entity
public class PagamentoComCartao extends Pagamento {
    private static final long serialVersionUID = 1L;

    private int numeroDeParcelas;

    public PagamentoComCartao() {
    }

    public PagamentoComCartao(EstadoPagamento estadoPagamento, Pedido pedido, int numeroDeParcelas) {
        super(estadoPagamento, pedido);
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public int getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(int numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }
}

