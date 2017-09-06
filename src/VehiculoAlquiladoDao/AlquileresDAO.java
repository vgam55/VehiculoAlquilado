/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VehiculoAlquiladoDao;

import Excepciones.NullRegisterException;
import Persistencia.AlquileresPER;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author VictorManuel
 */
public class AlquileresDAO implements iAlquileresDAO{
    EntityManagerFactory emf=null;
    EntityManager em=null;
    EntityTransaction tx=null;
    NullRegisterException devolucion=new NullRegisterException();
    private String createSQL(AlquileresPER alquiler)
    {
        String consulta="SELECT alquiler1 FROM AlquileresPER alquiler1 WHERE 1=1";
        if (alquiler.getIdAlquiler()>=0)
        {
            consulta=consulta+" AND alquiler1.idAlquiler>="+alquiler.getIdAlquiler();
        }
        
        if (alquiler.getIdCliente()>0)
        {
            consulta=consulta+" AND alquiler1.idCliente="+alquiler.getIdCliente();
        }
        
        if (alquiler.getIdVehiculo()>0)
        {
            consulta=consulta+" AND alquiler1.idVehiculo="+alquiler.getIdVehiculo();
        }
        
        if (alquiler.getKilometros()>0)
        {
            consulta=consulta+" AND alquiler1.kilometros<="+alquiler.getKilometros();
        }
        
        if(!"".equals(alquiler.getMatricula()))
        {
            consulta=consulta+" AND alquiler1.matricula like '%"+alquiler.getMatricula()+"%'";
        }
        return consulta;
    }
    
    public AlquileresDAO()
    {
        emf=Persistence.createEntityManagerFactory("VehiculoAlquiladoPU");
        em=emf.createEntityManager();
        tx=em.getTransaction();
    }
    
    @Override
    public List<AlquileresPER> selectCUSTOM(AlquileresPER alquiler){
        List<AlquileresPER> lista=new ArrayList();
        String SELECTCUSTOM=createSQL(alquiler);
        Query consulta=em.createQuery(SELECTCUSTOM);       
        lista=consulta.getResultList();
        //devolucion.devolucionNula(lista);
        return lista;
    }

    @Override
    public AlquileresPER selectID(Object idAlquiler) {
       AlquileresPER alquiler1=null;
        int id=Integer.parseInt(String.valueOf(idAlquiler));
        tx.begin();
            alquiler1=em.find(AlquileresPER.class, id);
        tx.commit();
        return alquiler1;
    }

    @Override
    public List<AlquileresPER> selectAll() {
        String SELECTALL="SELECT alquiler FROM AlquileresPER alquiler";
        Query consulta=null;
        List<AlquileresPER> listaAlqui=new ArrayList();
        consulta=em.createQuery(SELECTALL);
        listaAlqui=consulta.getResultList();
        return listaAlqui;
    }

    @Override
    public void insert(AlquileresPER alquiler) {
       tx.begin();
            em.persist(alquiler);
       tx.commit();
    }

    @Override
    public void delete(Object idAlquiler) {
        AlquileresPER alquiler1=null;
        int id=Integer.parseInt(String.valueOf(idAlquiler));
        tx.begin();
            alquiler1=em.find(AlquileresPER.class, id);
            if(alquiler1!=null)
            {
                em.remove(alquiler1);
            }
        tx.commit();
    }

    @Override
    public void update(AlquileresPER alquiler) {
        AlquileresPER alquiler1=null;
        tx.begin();
            alquiler1=em.find(AlquileresPER.class,alquiler.getIdAlquiler());
            
            if(alquiler.getIdCliente()>0)
            {
                alquiler1.setIdCliente(alquiler.getIdCliente());
            }
            
            if(alquiler.getIdVehiculo()>0)
            {
                alquiler1.setIdVehiculo(alquiler.getIdVehiculo());
            }
            
            if(alquiler.getKilometros()>0)
            {
                alquiler1.setKilometros(alquiler.getKilometros());
            }
            
            if(!"".equals(alquiler.getMatricula()))
            {
                alquiler1.setMatricula(alquiler.getMatricula());
            }
            
        tx.commit();
        
    }
    
}
