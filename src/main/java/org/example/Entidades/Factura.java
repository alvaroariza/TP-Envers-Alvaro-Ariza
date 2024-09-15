package org.example.Entidades;

import javax.persistence.*;

import org.hibernate.envers.Audited;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Factura")
@Audited
public class Factura implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Fecha")
    private String fecha;
    @Column(name = "Numero")
    private int numero;
    @Column(name = "Total")
    private int total;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();

    @ManyToOne(cascade = CascadeType.PERSIST)                       //a diferencia de ALL, el PERSIST no refleja los cambios en la
                                                                    //otra entidad. De usar ALL podriamos borrar un cliente cuando
                                                                    //se borre su factura.
    @JoinColumn(name = "FK_Cliente")
    private Cliente cliente;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetalleFactura> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleFactura> detalles) {
        this.detalles = detalles;
    }

    public Factura(String fecha, int numero, int total, Cliente cliente) {
        this.fecha = fecha;
        this.numero = numero;
        this.total = total;
        this.cliente = cliente;
    }

    public Factura(String fecha, int numero, int total) {
        this.fecha = fecha;
        this.numero = numero;
        this.total = total;
    }

    public Factura(String fecha, int numero, int total, List<DetalleFactura> detalles, Cliente cliente) {
        this.fecha = fecha;
        this.numero = numero;
        this.total = total;
        this.detalles = detalles;
        this.cliente = cliente;
    }

    public Factura() {
    }
}
