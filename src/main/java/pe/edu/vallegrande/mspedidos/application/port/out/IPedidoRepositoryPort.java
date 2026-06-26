package pe.edu.vallegrande.mspedidos.application.port.out;
import pe.edu.vallegrande.mspedidos.domain.model.Pedido;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

public interface IPedidoRepositoryPort {

    Flux<Pedido> findAll();
    Mono<Pedido> findById(Long id);
    Mono<Pedido> save(Pedido order);

}
