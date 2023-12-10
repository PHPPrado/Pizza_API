package com.project.pizzaria.itemPedido;


import com.project.pizzaria.pedido.Pedido;
import com.project.pizzaria.produto.Produto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idItemPedido;

    @NotNull
    @Min(value = 1)
    private int quantidade;

    //Foreign de table tamanho

    @ManyToOne
    @JoinColumn(name = "IdTamanho")
    private Tamanho tamanho;

    //Foreign

    @ManyToOne
    @JoinColumn(name = "IdPedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "IdProduto")
    private Produto produto;

}
