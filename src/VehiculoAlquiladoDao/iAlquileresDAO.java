/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VehiculoAlquiladoDao;

import Persistencia.AlquileresPER;
import java.util.List;

/**
 *
 * @author VictorManuel
 */
public interface iAlquileresDAO {
    public List<AlquileresPER> selectCUSTOM(AlquileresPER vehiculo);
    public AlquileresPER selectID(Object idAlquiler);
    public List<AlquileresPER> selectAll();
    public void insert(AlquileresPER alquiler);
    public void delete(Object idAlquiler);
    public void update(AlquileresPER alquiler);
}
