package br.com.tonsoft.modelagemwebservice;

import br.com.tonsoft.modelagemwebservice.model.*;
import br.com.tonsoft.modelagemwebservice.model.enums.EstadoPagamento;
import br.com.tonsoft.modelagemwebservice.model.enums.TipoCliente;
import br.com.tonsoft.modelagemwebservice.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class ModelagemWebServiceRestApplication implements CommandLineRunner {
    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;
    private final EstadoRepository estadoRepository;
    private final CidadeRepository cidadeRepository;
    private final ClienteRepository clienteRepository;
    private final EnderecoRepository enderecoRepository;
    private final PedidoRepository pedidoRepository;
    private final PagamentoRepository pagamentoRepository;
    private final ItemPedidoRepository itemPedidoRepository;

    @Autowired
    public ModelagemWebServiceRestApplication(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository, EstadoRepository estadoRepository, CidadeRepository cidadeRepository, ClienteRepository clienteRepository, EnderecoRepository enderecoRepository, PedidoRepository pedidoRepository, PagamentoRepository pagamentoRepository, ItemPedidoRepository itemPedidoRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
        this.estadoRepository = estadoRepository;
        this.cidadeRepository = cidadeRepository;
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
        this.pedidoRepository = pedidoRepository;
        this.pagamentoRepository = pagamentoRepository;
        this.itemPedidoRepository = itemPedidoRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ModelagemWebServiceRestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Categoria categoria1 = new Categoria("Roupa");
        Categoria categoria2 = new Categoria("Calçado");

        Produto produto1 = new Produto("Blusa", 2000.00);
        Produto produto2 = new Produto("Sapato", 800.00);
        Produto produto3 = new Produto("Calça Jeans", 80.00);

        categoria1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
        categoria2.getProdutos().addAll(Arrays.asList(produto2));

        produto1.getCategorias().addAll(Arrays.asList(categoria1));
        produto2.getCategorias().addAll(Arrays.asList(categoria1, categoria2));
        produto3.getCategorias().addAll(Arrays.asList(categoria1));

        categoriaRepository.save(Arrays.asList(categoria1, categoria2));
        produtoRepository.save(Arrays.asList(produto1, produto2, produto3));

        Estado estado1 = new Estado("Parana");
        Estado estado2 = new Estado("São Paulo");

        Cidade cidade1 = new Cidade("Maringá", estado1);
        Cidade cidade2 = new Cidade("São Paulo", estado2);
        Cidade cidade3 = new Cidade("Campinas", estado2);

        estado1.getCidades().addAll(Arrays.asList(cidade1));
        estado2.getCidades().addAll(Arrays.asList(cidade2, cidade3));

        estadoRepository.save(Arrays.asList(estado1, estado2));
        cidadeRepository.save(Arrays.asList(cidade1, cidade2, cidade3));

        Cliente cliente1 = new Cliente("Heliton Leno", "ciencia_@live.com", "123456789", TipoCliente.PESSOA_FISICA);

        cliente1.getTelefones().addAll(Arrays.asList("44999214246", "44999214246"));

        Endereco endereco1 = new Endereco("Rua Gralha azul", "999", "Esquina Rel", "Hortência", "38220834", cliente1, cidade1);
        Endereco endereco2 = new Endereco("Alziro Zarur", "222", "Sala 123", "Centro", "38777012", cliente1, cidade2);

        cliente1.getEnderecos().addAll(Arrays.asList(endereco1, endereco2));

        clienteRepository.save(Arrays.asList(cliente1));
        enderecoRepository.save(Arrays.asList(endereco1, endereco2));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

        Pedido pedido1 = new Pedido(sdf.parse("30/09/2017 10:32"), cliente1, endereco1);
        Pedido pedido2 = new Pedido(sdf.parse("10/10/2017 19:35"), cliente1, endereco2);

        Pagamento pagamento1 = new PagamentoComCartao(EstadoPagamento.QUITADO, pedido1, 6);
        pedido1.setPagamento(pagamento1);

        Pagamento pagamento2 = new PagamentoComBoleto(EstadoPagamento.PENDENTE, pedido2, sdf.parse("20/10/2017 00:00"), null);
        pedido2.setPagamento(pagamento2);

        cliente1.getPedidos().addAll(Arrays.asList(pedido1, pedido2));

        pedidoRepository.save(Arrays.asList(pedido1, pedido2));
        pagamentoRepository.save(Arrays.asList(pagamento1, pagamento2));

        ItemPedido itemPedido1 = new ItemPedido(pedido1, produto1, 0.0, 1, 2000.0);
        ItemPedido itemPedido2 = new ItemPedido(pedido1, produto3, 0.0, 2, 80.0);
        ItemPedido itemPedido3 = new ItemPedido(pedido2, produto2, 100.0, 1, 800.0);

        pedido1.getItens().addAll(Arrays.asList(itemPedido1, itemPedido2));
        pedido2.getItens().add(itemPedido3);

        produto1.getItens().addAll(Arrays.asList(itemPedido1));
        produto2.getItens().addAll(Arrays.asList(itemPedido3));
        produto3.getItens().addAll(Arrays.asList(itemPedido2));

        itemPedidoRepository.save(Arrays.asList(itemPedido1, itemPedido2, itemPedido3));
    }
}