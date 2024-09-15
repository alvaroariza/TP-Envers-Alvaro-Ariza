package org.example.Entidades;

import javax.persistence.*;

import org.hibernate.envers.Audited;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Articulo")
@Audited
public class Articulo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Cantidad")
    private int cantidad;
    @Column(name = "Denominacion")
    private String denominacion;
    @Column(name = "Precio")
    private int precio;

    @OneToMany(mappedBy = "articulo", cascade = CascadeType.PERSIST)
    private List<DetalleFactura> detalle = new ArrayList<DetalleFactura>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "articulo_categoria",
            joinColumns = @JoinColumn(name = "articulo_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categoria> categorias = new ArrayList<Categoria>();

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

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public List<DetalleFactura> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<DetalleFactura> detalle) {
        this.detalle = detalle;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Articulo(int cantidad, String denominacion, int precio) {
        this.cantidad = cantidad;
        this.denominacion = denominacion;
        this.precio = precio;
    }

    public Articulo(int cantidad, String denominacion, int precio, List<DetalleFactura> detalle) {
        this.cantidad = cantidad;
        this.denominacion = denominacion;
        this.precio = precio;
        this.detalle = detalle;
    }

    public Articulo(int cantidad, String denominacion, int precio, List<DetalleFactura> detalle, List<Categoria> categorias) {
        this.cantidad = cantidad;
        this.denominacion = denominacion;
        this.precio = precio;
        this.detalle = detalle;
        this.categorias = categorias;
    }

    public Articulo() {
    }
}
