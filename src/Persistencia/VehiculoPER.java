/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author VictorManuel
 */
@Entity
@Table(name="vehiculos")
public class VehiculoPER implements Serializable {

    @Id
    @Basic(optional=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idVehiculo")
    private int idVehiculo;
    
    @Basic(optional=false)
    @Column(name="marca")
    private String marca;
    
    @Basic(optional=false)
    @Column(name="modelo")
    private String modelo;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="vehiculo")
    private Collection<AlquileresPER> alquiler;
   
    public VehiculoPER() {
        this.idVehiculo=-1;
        this.marca="";
        this.modelo="";
    }

    public VehiculoPER(int idVehiculo, String marca, String modelo) {
        this.idVehiculo = idVehiculo;
        this.marca = marca;
        this.modelo = modelo;
    }
   
    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int id) {
        this.idVehiculo = id;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.idVehiculo;
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
        final VehiculoPER other = (VehiculoPER) obj;
        return true;
    }

    @Override
    public String toString() {
        String resultado="Id Vehiculo= "+this.idVehiculo+"./n"+"Marca= "+this.marca+"./n";
        resultado=resultado+"Modelo= "+this.modelo+"./n";
        return resultado;
    }

    public Collection<AlquileresPER> getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(ArrayList<AlquileresPER> alquiler) {
        this.alquiler = alquiler;
    }
       
}
