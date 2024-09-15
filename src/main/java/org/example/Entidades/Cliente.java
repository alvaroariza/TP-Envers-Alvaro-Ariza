package org.example.Entidades;

import javax.persistence.*;

import org.hibernate.envers.Audited;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity                                         //Se le indica a JPA que esto va a ser una entidad y va
                                                //ser guardada an la base de datos.

@Table(name = "Cliente")                        //se indica que sera una tabla en la base de datos y se
                                                //le da un nombre.
@Audited
public class Cliente implements Serializable {  //se implementa serializable para convertir el objeto
                                                //en una serie de bits para que sea posible almacenarlo
                                                //en elgun medio.

    @Serial
    private static final long serialVersionUID = 1L;
    @Id                                         //indicamos que el atributo "id" sera la PK de la tabla

    @GeneratedValue(strategy = GenerationType.IDENTITY)        //Hacemos autoincremental al Id
    private Long id;

    @Column(name = "Nombre")                    //para cada atributo creamos una columna y le damos nombre. Si
                                                //no uso esta etiqueta la columna tomara el nombre del atributo.
    private String nombre;
    @Column(name = "Apellido")
    private String apellido;
    @Column(name = "DNI", unique = true)        //Con el atributo unique en true no vamos a poder ingresar al
                                                //mismo registro 2 DNIs iguales.
    private int dni;

    @OneToOne(cascade = CascadeType.ALL)        //con el valor ALL cualquier cambio en Cliente se reflejara en Domicilio
    @JoinColumn(name = "FK_Domicilio")          //Agregamos una columna que contiene la FK de Domicilio
    private Domicilio domicilio;                //Relacion con Domicilio

    @OneToMany (mappedBy = "cliente")                                 //como es de uno a muchos cremos una "lista de facturas".
    private List<Factura> facturas = new ArrayList<Factura>();

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public Cliente(String nombre, String apellido, int dni) {       //No se incluye el ID porque va a ser
                                                                    //generado automaticamente en la BD.
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public Cliente(String nombre, String apellido, int dni, Domicilio domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.domicilio = domicilio;
    }

    public Cliente(String nombre, String apellido, int dni, Domicilio domicilio, List<Factura> facturas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.domicilio = domicilio;
        this.facturas = facturas;
    }

    public Cliente() {
    }
}
