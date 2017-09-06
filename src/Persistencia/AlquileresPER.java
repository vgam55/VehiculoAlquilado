/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author VictorManuel
 */
@Entity
@Table(name="alquileres")
public class AlquileresPER implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional=false)
    @Column(name="idAlquiler")
    private int idAlquiler;
    
    @Basic(optional=false)
    @Column(name="idVehiculo")
    private int idVehiculo;
    @Basic (optional=false)
    @Column(name="idCliente")
    private int idCliente;
    @Basic (optional=false)
    @Column(name="matricula")
    private String matricula;
    @Basic(optional=false)
    @Column(name="kilometros")
    private int kilometros;

    private ArrayList alquiler=null;
    
    
    public AlquileresPER()
    {
        this.idAlquiler=-1;
        this.idCliente=-1;
        this.idVehiculo=-1;
        this.kilometros=-1;
        this.matricula="";
    }
    
    public AlquileresPER(int idAlquiler, int idCliente, int idVehiculo, String matricula, int kilometros)
    {
        this.idAlquiler=idAlquiler;
        this.idCliente=idCliente;
        this.idVehiculo=idVehiculo;
        this.matricula=matricula;
        this.kilometros=kilometros;
    }
    
    public int getIdAlquiler() 
    {
        return idAlquiler;
    }

    public void setIdAlquiler(int idAlquiler) 
    {
        this.idAlquiler = idAlquiler;
    }
    
    public int getIdVehiculo()
    {
        return this.idVehiculo;
    }
    
    public void setIdVehiculo(int idVehiculo)
    {
        this.idVehiculo=idVehiculo;
    }
    
    public int getIdCliente()
    {
        return this.idCliente;
    }
    
    public void setIdCliente(int idCliente)
    {
        this.idCliente=idCliente;
    }
    
    public String getMatricula()
    {
        return this.matricula;
    }
    
    public void setMatricula(String matricula)
    {
        this.matricula=matricula;
    }
    
    public int getKilometros()
    {
        return this.kilometros;
    }
 
    public void setKilometros(int kilometros)
    {
        this.kilometros=kilometros;
    }
            
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.idAlquiler;
        hash = 71 * hash + this.idCliente;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AlquileresPER other = (AlquileresPER) obj;
        if (this.idAlquiler != other.idAlquiler) {
            return false;
        }
        if (this.idVehiculo != other.idVehiculo) {
            return false;
        }
        if (this.idCliente != other.idCliente) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString()
    {
        String retorno="Id Alquiler= "+this.idAlquiler+".\n"+"Matricula= "+this.matricula+".\n";
        retorno=retorno+"Id Vehiculo= "+this.idVehiculo+".\n"+"Id Cliente= "+this.idCliente+".\n";
        retorno=retorno+"Kilometros= "+this.kilometros;
        return retorno;
    }
    
    @JoinColumn(name="idCliente", referencedColumnName="idCliente", insertable=false, updatable=false)
    @ManyToOne(optional=false)
    private ClientesPER cliente;
    
    @JoinColumn(name="idVehiculo",referencedColumnName="idVehiculo",insertable=false, updatable=false)
    @ManyToOne(optional=false)
    private VehiculoPER vehiculo;

    public ClientesPER getCliente() {
        return cliente;
    }

    public VehiculoPER getVehiculo() {
        return vehiculo;
    }
    
    
}
