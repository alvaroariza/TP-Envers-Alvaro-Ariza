package org.example.Principal;

import org.example.Entidades.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceApp {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-unit");
        EntityManager em =emf.createEntityManager();

        try{
            em.getTransaction().begin();                                                        //iniciamos una transaccion

            Factura factura1 = new Factura();
            factura1.setNumero(12);
            factura1.setFecha("10/09/2024");

            Domicilio domicilio1 = new Domicilio("Rivadavia", 432);
            Cliente cliente = new Cliente("Ruben", "Rodriguez", 23445645);
            cliente.setDomicilio(domicilio1);
            domicilio1.setCliente(cliente);

            factura1.setCliente(cliente);

            Categoria perecederos = new Categoria("Perecederos");
            Categoria lacteos = new Categoria("Lacteos");
            Categoria limpieza = new Categoria("Limpieza");

            Articulo art1 = new Articulo(200, "postre", 50);
            Articulo art2 = new Articulo(450, "Desengrasante", 150);

            art1.getCategorias().add(perecederos);
            art1.getCategorias().add(lacteos);
            lacteos.getArticulo().add(art1);
            perecederos.getArticulo().add(art1);

            art2.getCategorias().add(limpieza);
            limpieza.getArticulo().add(art2);

            DetalleFactura det1 = new DetalleFactura();
            det1.setArticulo(art1);
            det1.setCantidad(4);
            det1.setSubtotal(200);

            art1.getDetalle().add(det1);
            factura1.getDetalles().add(det1);
            det1.setFactura(factura1);

            DetalleFactura det2 = new DetalleFactura();

            det2.setArticulo(art2);
            det2.setCantidad(3);
            det2.setSubtotal(450);

            art2.getDetalle().add(det2);
            factura1.getDetalles().add(det2);
            det2.setFactura(factura1);

            factura1.setTotal(650);

            //Las siguientes 3 lineas son para crear una nueva revision
            //Factura factura1 = em.find(Factura.class, 1L);
            //factura1.setNumero(36);
            //em.merge(factura1);
            
            //La siguiente linea es para eliminar la factura
            //em.remove(factura1);

            em.persist(factura1); 

            em.flush();                                                                         //limpiamos la conexion
            em.getTransaction().commit();                                                       //commiteamos los cambios

        }catch (Exception e){
            em.getTransaction().rollback();                                                     //si se produce un error se dehacen los cambios en la BD
        }
        em.close();
        emf.close();
    }
}
