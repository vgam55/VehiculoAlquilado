/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VehiculoAlquiladoDao;

import Excepciones.NullRegisterException;
import Persistencia.ClientesPER;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VictorManuel
 */
public interface iClientesDAO {
    public List selectCUSTOM(ClientesPER cliente);
    public ClientesPER selectID(Object idCliente);
    public List selectAll() throws NullRegisterException;
    public void insert(ClientesPER cliente);
    public void delete(Object idCliente);
    public void update(ClientesPER cliente);   
}
