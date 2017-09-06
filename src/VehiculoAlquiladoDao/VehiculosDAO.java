/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VehiculoAlquiladoDao;

import Persistencia.VehiculoPER;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.persistence.Query;

/**
 *
 * @author VictorManuel
 */
public class VehiculosDAO implements iVehiculosDAO{

    EntityManagerFactory emf=null;
    EntityManager em=null;
    EntityTransaction tx=null;
    
    
    public VehiculosDAO()
    {
        emf=Persistence.createEntityManagerFactory("VehiculoAlquiladoPU");
        em=emf.createEntityManager();
        tx=em.getTransaction();
    }
    
    private String crearSQL(VehiculoPER vehiculo1)
    {
        String tmpSQL="SELECT vehiculo1 FROM VehiculoPER vehiculo1 WHERE 1=1";
        if(vehiculo1.getIdVehiculo()>0)
           {
               tmpSQL=tmpSQL+" AND vehiculo1.idVehiculo>="+vehiculo1.getIdVehiculo();
           }
        
        if(!"".equals(vehiculo1.getMarca()))
        {
            tmpSQL=tmpSQL+" AND vehiculo1.marca like '%"+vehiculo1.getMarca() +"%'";
        }
            
        if(!"".equals(vehiculo1.getModelo()))
        {
            tmpSQL=tmpSQL+" AND vehiculo1.modelo LIKE '%"+ vehiculo1.getModelo()+"%'";
        }
        return tmpSQL;
    }
    @Override
    public List<VehiculoPER> selectCUSTOM(VehiculoPER vehiculo) {
        List<VehiculoPER> lista=new ArrayList();
        String SELECTCUSTOM=crearSQL(vehiculo);
        Query consulta=em.createQuery(SELECTCUSTOM);
        lista=consulta.getResultList();
        return lista;
    }

    @Override
    public VehiculoPER selectID(Object idVehiculo) {
        VehiculoPER vehiculo=null;        
        int id=Integer.parseInt(String.valueOf(idVehiculo));
        tx.begin();
            vehiculo=em.find(VehiculoPER.class,id);
        tx.commit();
        return vehiculo;        
    }

    @Override
    public List<VehiculoPER> selectAll() {
        String SELECTALL="SELECT vehiculo FROM VehiculoPER vehiculo";
        Query consulta=null;
        List<VehiculoPER> listaVehi=new ArrayList();
        consulta=em.createQuery(SELECTALL);
        listaVehi=consulta.getResultList();
        return listaVehi;
    }

    @Override
    public void insert(VehiculoPER vehiculo) {
        tx.begin();
            em.persist(vehiculo);
        tx.commit();
    }
    @Override
    public void delete(Object idVehiculo) {
       VehiculoPER vehiculo1=null;
       int id1=Integer.parseInt(String.valueOf(idVehiculo));
       tx.begin();
            vehiculo1=em.find(VehiculoPER.class,id1);
            if(vehiculo1!=null)
            {
                em.remove(vehiculo1);
            }
       tx.commit();
    }

    @Override
    public void update(VehiculoPER vehiculo) {
       // String UPDATESQL="UPDATE vehiculos SET marca=?, modelo=? WHERE idVehiculo=?";
        VehiculoPER vehiculo1=null;
        tx.begin();
            vehiculo1=em.find(VehiculoPER.class, vehiculo.getIdVehiculo());
            if(!"".equals(vehiculo.getMarca()))
            {
                vehiculo1.setMarca(vehiculo.getMarca());
            }
            
            if(!"".equals(vehiculo.getModelo()))
            {
                vehiculo1.setModelo(vehiculo.getModelo());
            }
        tx.commit();
    }
    
}
