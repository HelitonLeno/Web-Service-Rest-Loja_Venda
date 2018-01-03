package br.com.tonsoft.modelagemwebservice.model.enums;

public enum EstadoPagamento {
    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    private int id;
    private String tipo;

    EstadoPagamento(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public static EstadoPagamento toEnum(Integer id) {
        if (id == null) return null;

        for (EstadoPagamento e : EstadoPagamento.values()) {
            if (id.equals(e.getId())) return e;
        }
        throw new IllegalArgumentException("Id invalido para " + id);
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }
}
