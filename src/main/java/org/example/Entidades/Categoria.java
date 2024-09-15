package org.example.Entidades;

import javax.persistence.*;

import org.hibernate.envers.Audited;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Categoria")
@Audited
public class Categoria implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Denomiancion")
    private String denominacion;

    @ManyToMany(mappedBy = "categorias")
    private List<Articulo> articulo = new ArrayList<Articulo>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public List<Articulo> getArticulo() {
        return articulo;
    }

    public void setArticulo(List<Articulo> articulo) {
        this.articulo = articulo;
    }

    public Categoria(String denominacion) {
        this.denominacion = denominacion;
    }

    public Categoria(String denominacion, List<Articulo> articulo) {
        this.denominacion = denominacion;
        this.articulo = articulo;
    }

    public Categoria() {
    }
}
