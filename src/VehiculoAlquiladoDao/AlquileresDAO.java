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
    
    /* Busca los registros que cumplan con una serie de condicione en función
     * de los datos que recibe y devuelve una lista con el resultado
     */
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
    
    //Crea una sentencia SQL que luego utilizaremos en SelectCustom.
    public AlquileresDAO()
    {
        emf=Persistence.createEntityManagerFactory("VehiculoAlquiladoPU");
        em=emf.createEntityManager();
        tx=em.getTransaction();
    }
    
    /* Busca los registros que cumplan con una serie de condicione en función
     * de los datos que recibe y devuelve una lista con el resultado
     */
    @Override
    public List<AlquileresPER> selectCUSTOM(AlquileresPER alquiler){
        List<AlquileresPER> lista=new ArrayList();
        String SELECTCUSTOM=createSQL(alquiler);
        Query consulta=em.createQuery(SELECTCUSTOM);       
        lista=consulta.getResultList();
        //devolucion.devolucionNula(lista);
        return lista;
    }
   
   // Devuelve un registro cuyo Id sea igual al que se le pasa (si existe 
    @Override
    public AlquileresPER selectID(Object idAlquiler) {
       AlquileresPER alquiler1=null;
        int id=Integer.parseInt(String.valueOf(idAlquiler));
        tx.begin();
            alquiler1=em.find(AlquileresPER.class, id);
        tx.commit();
        return alquiler1;
    }

    //Devuelve todos los registros que componen la tabla Alquileres
    @Override
    public List<AlquileresPER> selectAll() {
        String SELECTALL="SELECT alquiler FROM AlquileresPER alquiler";
        Query consulta=null;
        List<AlquileresPER> listaAlqui=new ArrayList();
        consulta=em.createQuery(SELECTALL);
        listaAlqui=consulta.getResultList();
        return listaAlqui;
    }

    //Inserta un registro con los datos que se le pase
    @Override
    public void insert(AlquileresPER alquiler) {
       tx.begin();
            em.persist(alquiler);
       tx.commit();
    }

    //Borra un registro cuyo id sea igual al id que se le pasa
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

    // Actualiza un registro cuya id sea igual a la que se le pasa, con 
    // los datos que se les pasa
    @Override
    public void update(AlquileresPER alquiler) {
        AlquileresPER alquiler1=null;
        tx.begin();
          if (alquiler!=null)
          {
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
          }
            
        tx.commit();
        
    }
    
}
