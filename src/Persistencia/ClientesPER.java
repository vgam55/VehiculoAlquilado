/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;

/**
 *
 * @author VictorManuel
 */
@Entity
@Table(name="clientes")
public class ClientesPER implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional=false)
    @Column(name="idCliente")
    private int idCliente;
    
    @Basic(optional=false)
    @Column(name="nombre")
    private String nombre;
    
    @Basic(optional=false)
    @Column(name="apellidos")
    private String apellidos;
    
    @Basic(optional=false)
    @Column(name="ciudad")
    private String ciudad;
    
    @OneToMany (cascade=CascadeType.ALL, mappedBy="cliente")
    private Collection<AlquileresPER> alquiler;    
       
    public ClientesPER() {
        this.idCliente=-1;
        this.nombre="";
        this.apellidos="";
        this.ciudad="";
    }

    public ClientesPER(int idCliente, String nombre, String apellidos, String ciudad) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.ciudad = ciudad;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final ClientesPER other = (ClientesPER) obj;
        if (this.idCliente != other.idCliente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String resultado="Id Cliente= "+this.idCliente+".\n"+"Nombre=  "+this.nombre+".\n";
        resultado=resultado+"Apellidos= "+this.apellidos+".\n"+"Ciudad= "+this.ciudad+".\n";
        return resultado;
    }

    public Collection getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(ArrayList<AlquileresPER> alquiler) {
        this.alquiler = alquiler;
    }
    
    
}
