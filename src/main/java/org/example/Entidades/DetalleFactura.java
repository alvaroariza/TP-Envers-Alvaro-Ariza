package org.example.Entidades;

import javax.persistence.*;

import org.hibernate.envers.Audited;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "DetalleFactura")
@Audited
public class DetalleFactura implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Cantidad")
    private int cantidad;
    @Column(name = "Subtotal")
    private int subtotal;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_Factura")
    private Factura factura;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_Articulo")
    private Articulo articulo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public DetalleFactura(int cantidad, int subtotal) {
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public DetalleFactura(int cantidad, int subtotal, Articulo articulo) {
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.articulo = articulo;
    }

    public DetalleFactura(int cantidad, int subtotal, Factura factura, Articulo articulo) {
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.factura = factura;
        this.articulo = articulo;
    }

    public DetalleFactura() {
    }
}
