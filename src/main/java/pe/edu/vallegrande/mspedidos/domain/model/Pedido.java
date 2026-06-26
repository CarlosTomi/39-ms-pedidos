package pe.edu.vallegrande.mspedidos.domain.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("pedidos")
public class Pedido {

    @Id
    private Long id;
    private Long productId;
    private Integer quantity;
    private Double total;
    private String status;
    private LocalDateTime date;

}