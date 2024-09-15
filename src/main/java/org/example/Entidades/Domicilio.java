package org.example.Entidades;

import javax.persistence.*;

import org.hibernate.envers.Audited;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "Domicilio")
@Audited
public class Domicilio implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Calle")
    private String nombreCalle;
    @Column(name = "Numero")
    private int numero;

    @OneToOne(mappedBy = "domicilio")                           //se mapea la relacion inversa parq que sea posible acceder desde dolicilio
    private Cliente cliente;                                    //tambien se crearon los getters, setters y el constructor necesarios

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCalle() {
        return nombreCalle;
    }

    public void setNombreCalle(String nombreCalle) {
        this.nombreCalle = nombreCalle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Domicilio(String nombreCalle, int numero, Cliente cliente) {
        this.nombreCalle = nombreCalle;
        this.numero = numero;
        this.cliente = cliente;
    }

    public Domicilio(String nombreCalle, int numero) {
        this.nombreCalle = nombreCalle;
        this.numero = numero;
    }

    public Domicilio() {
    }
}
