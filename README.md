# Web Service Rest 
## Para expor dados de uma venda em formato JSON

### Uso:
    URL: http://localhost:8080/pedido/{id}
    URL: http://localhost:8080/cliente/{id}
    URL: http://localhost:8080/categoria/{id}
    
### Saida: 
    {
         id: 1,
         dataCompra: "30/09/2017 01:32",
         pagamento: {
            id: 1,
            estadoPagamento: "QUITADO",
            numeroDeParcelas: 6,
         },
            cliente: {
            id: 1,
            nome: "",
            email: "",
            cpfOuCnpj: "123456789",
            tipoCliente: "PESSOA_FISICA",
            enderecos: [
                 {
                    id: 1,
                    logradouro: "",
                    numero: "999",
                    complemento: "Esquina Rel",
                    bairro: "",
                    cep: "38220834",
                    cidade: {
                        id: 1,
                        nome: "",
                        estado: {
                             id: 1,
                             nome: "",
                        },
                     },
                 },
                 {
                    id: 2,
                    logradouro: " ",
                    numero: "222",
                    complemento: "Sala 123",
                    bairro: "Centro",
                    cep: "38777012",
                    cidade: {
                        id: 2,
                        nome: "São Paulo",
                        estado: {
                            id: 2,
                            nome: "São Paulo",
                        },
                    },
                 },
            ],
            telefones: [
                ""
             ],
    },
    enderecoDeEntrega: {
        id: 1,
        logradouro: "",
        numero: "999",
        complemento: "Esquina Rel",
        bairro: "",
        cep: "38220834",
        cidade: {
        id: 1,
        nome: "",
            estado: {
                id: 1,
                nome: "",
            },
        },
    },
    itens: [
        {
            desconto: 0,
            quantidade: 1,
            preco: 2000,
            produto: {
                id: 1,
                nome: "Blusa",
                preco: 2000,
            },
        },
        {
            desconto: 0,
            quantidade: 2,
            preco: 80,
            produto: {
                id: 3,
                nome: "Calça Jeans",
                preco: 80,
            },
        },
      ],
    }
 
 
### Tecnologias: 
    Java 8
    Spring boot
        Jpa Hibernate
        DevTools
    MySql

