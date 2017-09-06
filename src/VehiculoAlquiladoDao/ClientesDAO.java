/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VehiculoAlquiladoDao;

import Persistencia.ClientesPER;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.*;
import javax.swing.JOptionPane;



/**
 *
 * @author VictorManuel
 */
public class ClientesDAO implements iClientesDAO{
    EntityManagerFactory emf=null;
    EntityManager em=null;
    EntityTransaction tx=null;
   
    public ClientesDAO()
    {
        emf=Persistence.createEntityManagerFactory("VehiculoAlquiladoPU");
        em=emf.createEntityManager();
        tx=em.getTransaction();
    }

    
    private String crearSQL(ClientesPER cliente1)
    {
        
        String cadena="SELECT cliente1 FROM ClientesPER cliente1 WHERE 1=1";
       
        if(cliente1.getIdCliente()>0)
        {
            cadena=cadena+" AND cliente1.idCliente>="+cliente1.getIdCliente();
        }
        if(!"".equals(cliente1.getNombre()))
        {
            cadena=cadena+" AND cliente1.nombre like '%"+cliente1.getNombre()+"%'";
        }
        
        if(!"".equals(cliente1.getApellidos()))
        {
            cadena=cadena+" AND cliente1.apellidos like '%"+cliente1.getApellidos()+"%'";
        }
        
        if(!"".equals(cliente1.getCiudad()))
        {
            cadena=cadena+" AND cliente1.ciudad like '%"+cliente1.getCiudad()+"%'";
        }
        return cadena;
    }
    
    @Override
    public List<ClientesPER> selectCUSTOM(ClientesPER cliente) 
    {
        List<ClientesPER> lista=new ArrayList();
        String selectCUSTOM=crearSQL(cliente);        
        Query consulta=em.createQuery(selectCUSTOM);       
        lista=consulta.getResultList();
        return lista;
    }

    @Override
    public ClientesPER selectID(Object idCliente) {
        ClientesPER cliente=null;
        String id=String.valueOf(idCliente);
        int id1=Integer.parseInt(id);
        tx.begin();
            cliente=em.find(ClientesPER.class, id1);
        tx.commit();
        return cliente;
    }

    @Override
    public List<ClientesPER> selectAll() {
       Query consulta=null;
       String SELECTALL="SELECT cliente FROM ClientesPER cliente";
       List<ClientesPER> lista=new ArrayList();
       consulta=em.createQuery(SELECTALL);
       lista=consulta.getResultList();
       return lista;
    }
    
    @Override
    public void insert(ClientesPER cliente) {
        tx.begin();
            em.persist(cliente);
        tx.commit();
    }

    @Override
    public void update(ClientesPER cliente) {
        ClientesPER cliente1;
        tx.begin();
            cliente1=em.find(ClientesPER.class, cliente.getIdCliente());
            if(!"".equals(cliente.getNombre()))
            {
                cliente1.setNombre(cliente.getNombre());
            }
            
            if(!"".equals(cliente.getApellidos()))
            {
                cliente1.setApellidos(cliente.getApellidos());
            }
            if(!"".equals(cliente.getCiudad()))
            {
                cliente1.setCiudad(cliente.getCiudad());
            }
        tx.commit();
    }

   
    @Override
    public void delete(Object idCliente) {
        ClientesPER cliente=null;
        String id=String.valueOf(idCliente);
        int id1=Integer.parseInt(id);
        tx.begin();
            cliente=em.find(ClientesPER.class,id1);
            if(cliente!=null)
            {
                em.remove(cliente);
            }
        tx.commit();
    }

}
