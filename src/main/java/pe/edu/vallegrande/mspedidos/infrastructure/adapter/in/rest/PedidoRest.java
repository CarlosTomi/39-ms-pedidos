package pe.edu.vallegrande.mspedidos.infrastructure.adapter.in.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pe.edu.vallegrande.mspedidos.application.port.in.IPedidoServicePort;
import pe.edu.vallegrande.mspedidos.domain.model.Pedido;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoRest {

    private final IPedidoServicePort servicePort;

    @GetMapping
    public Flux<Pedido> findAll(){
        return servicePort.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Pedido> findById(@PathVariable Long id){
        return servicePort.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Pedido> save(@RequestBody Pedido order){
        return servicePort.create(order);
    }

    @PatchMapping("/{id}/cancel")
    public Mono<Pedido> cancel(@PathVariable Long id){
        return servicePort.cancel(id);
    }
}