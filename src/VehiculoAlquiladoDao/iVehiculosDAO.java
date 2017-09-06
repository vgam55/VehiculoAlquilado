/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VehiculoAlquiladoDao;

import Persistencia.ClientesPER;
import Persistencia.VehiculoPER;
import java.util.List;

/**
 *
 * @author VictorManuel
 */
public interface iVehiculosDAO {
    public List<VehiculoPER> selectCUSTOM(VehiculoPER vehiculo);
    public VehiculoPER selectID(Object idVehiculo);
    public List<VehiculoPER> selectAll();
    public void insert(VehiculoPER vehiculo);
    public void delete(Object idVehiculo);
    public void update(VehiculoPER vehiculo);
}
