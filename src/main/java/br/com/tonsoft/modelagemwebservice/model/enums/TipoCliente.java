package br.com.tonsoft.modelagemwebservice.model.enums;

public enum TipoCliente {
    PESSOA_FISICA(1, "Pessoa Fisica"),
    PESSOA_JURIDICA(2, "Pessoa Juridica");

    private int id;
    private String tipo;

    TipoCliente(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public static TipoCliente toEnum(Integer id) {
        if (id == null) return null;

        for (TipoCliente c : TipoCliente.values()) {
            if (id.equals(c.getId())) return c;
        }
        throw new IllegalArgumentException("ID invalido");
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }
}