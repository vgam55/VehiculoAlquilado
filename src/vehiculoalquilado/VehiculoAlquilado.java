/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiculoalquilado;

import javax.swing.JFrame;
import VehiculoAlquiladoDao.*;
import Persistencia.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import Excepciones.*;
/**
 *
 * @author VictorManuel
 */
public class VehiculoAlquilado extends JFrame{

    //Menu
    private JMenuBar jmbBarraMenu=null;
    private JMenu jmArchivo=null;
    private JMenu jmAyuda=null;
    private JMenuItem jmiElegirBD=null;
    private JSeparator jsSeparador=null;
    private JMenuItem jmiSalir=null;
    private JMenuItem jmiAyuda=null;
    //Pestañas
    private JTabbedPane jtpPestanias=null;
    private JPanel jpClientes=null;
    private JPanel jpVehiculos=null;
    private JPanel jpAlquiler=null;
    GridBagConstraints constrains=null; //Sirve para 
    //Paneles
    private JPanel jpcliVisual=null;
    private JPanel jpcliFiltro=null;
    private JPanel jpCliEdicion=null;
    private JPanel jpVehVisual=null;
    private JPanel jpVehFiltro=null;
    private JPanel jpVehEdicion=null;
    private JPanel jpAlquiVisual=null;
    private JPanel jpAlquiFiltro=null;
    private JPanel jpAlquiEdicion=null;
    //Elementos de ClientesDto
    JScrollPane jspVisualClien=null;
    JTable jtVisualClien=null;
    Object [][] datosCli=null;
    String [] columCli={"Id Cliente","Nombre","Apellidos","Ciudades"};
    //Elementos de Filtros ClientesDto
    JLabel lblFilIdCliente=null;
    JLabel lblFilNom=null;   
    JLabel lblFilApellidos=null;
    JLabel lblFilCiudad=null;
    JLabel lblEdiResul=null;
    JTextField jtfFilId=null;
    JTextField jtfFilNombre=null;
    JTextField jtfFilApellidos=null;
    JTextField jtfFilCiudad=null;
    JButton jbtLimpiarFil=null;
    //Elementos de Edicion ClientesPER
    JLabel lblEdiIdCliente=null;
    JLabel lblEdiNom=null;   
    JLabel lblEdiApellidos=null;
    JLabel lblEdiCiudad=null;
    JTextField jtfEdiId=null;
    JTextField jtfEdiNombre=null;
    JTextField jtfEdiApellidos=null;
    JTextField jtfEdiCiudad=null;
    JButton jbtAniadirCli=null;
    JButton jbtActualizarCli=null;
    JButton jbtBorrarCli=null;
    JButton jbtLimpiarEdiCli=null;
    
    //Elementos diseño vehiculos
    JScrollPane jspVisualVehi=null;
    JTable jtVisualVehi=null;
    Object [][] datosVehi=null;
    String [] columVehi={"Id Vehiculo","Marca","Modelo"};
    //Elementos de Filtros VehiculosDto
    JLabel lblFilIdVehi=null;
    JLabel lblFilMarcaVehi=null;   
    JLabel lblFilModeloVehi=null;
    JTextField jtfFilIdVehi=null;
    JTextField jtfFilMarcaVehi=null;
    JTextField jtfFilModeloVehi=null;
    JButton jbtLimpiarFilVehi=null;
    //Elementos de Edicion ClientesDto
    JLabel lblEdiIdVehi=null;
    JLabel lblEdiMarcaVehi=null;   
    JLabel lblEdiModelo=null;
    private JLabel lblResulEdiVehi=null;
    JTextField jtfEdiIdVehi=null;
    JTextField jtfEdiMarcaVehi=null;
    JTextField jtfEdiModeloVehi=null;
    JButton jbtAniadirVehi=null;
    JButton jbtActualizarVehi=null;
    JButton jbtBorrarVehi=null;
    JButton jbtLimpiarEdiVehi=null;
    
    //Elementos de diseño de AlquileresDto
     private JScrollPane jspVisualAlqui=null;
     private JTable jtVisualAlqui=null;
     private Object[][] datosAlqui=null;
     private String[] columAlqui={"Id Alquiler","Id Cliente", "Id Vehiculo","Matricula","Kilometros"};
     private JLabel lblFilIdCliAlqui=null;
     private JLabel lblFilIdVehiAlqui=null;
     private JLabel lblFilMatriculaAlqui=null;
     private JLabel lblFilKilometrosAlqui=null;
     private JTextField jtfFilIdCliAlqui=null;
     private JTextField jtfFilIdVehiAlqui=null;
     private JTextField jtfFilMatriculaAlqui=null;
     private JTextField jtfFilKilometrosAlqui=null;
     private JButton jbtLimpiarFilAlqui=null;
     
     private JLabel lblEdiIdCliAlqui=null;
     private JLabel lblEdiIdVehiAlqui=null;
     private JLabel lblEdiMatriculaAlqui=null;
     private JLabel lblEdiKilometrosAlqui=null;
     private JLabel lblResulEdiAlqui=null;
     private JTextField jtfEdiIdCliAlqui=null;
     private JTextField jtfEdiIdVehiAlqui=null;
     private JTextField jtfEdiMatriculaAlqui=null;
     private JTextField jtfEdiKilometrosAlqui=null;
     private JButton jbtLimpiarEdiAlqui=null;
     private JButton jbtAniadirAlqui=null;
     private JButton jbtActualizarAlqui=null;
     private JButton jbtBorrarAlqui=null;
    //Listeners
    private WindowListener wlSalir=null;
    private ActionListener alSalir=null;
    private ActionListener alElegirBD=null;
    private ActionListener alAyuda=null;
    private ActionListener alBorrarFilCli=null;
    private ActionListener alAniadirCli=null;
    private ActionListener alActualizarCli=null;
    private ActionListener alBorrarCli=null;
    private ActionListener alLimpiarEdiCli=null;
    private DocumentListener dlIdCli=null;
    private DocumentListener dlCiudCli=null;
    private DocumentListener dlNomCli=null;
    private DocumentListener dlApellCli=null;
    private MouseListener mlFilaCli=null;
    
    //Listeners Filtros VehiculosDto.
    private DocumentListener dlIdVehi=null;
    private DocumentListener dlMarcaVehi=null;
    private DocumentListener dlModeloVehi=null;
    private ActionListener alLimpiarEdiVehi=null;
    ActionListener alLimpiarFilVehi=null;
    ActionListener alAniadirVehi=null;
    ActionListener alActualizarVehi=null;
    ActionListener alBorrarVehi=null;
    MouseListener mlFilaVehi=null;
    //Listeners de AlquileresDto
    DocumentListener dlIdCliAlqui=null;
    DocumentListener dlIdVehiAlqui=null;
    DocumentListener dlMatriculaAlqui=null;
    DocumentListener dlKilometrosAlqui=null;
    ActionListener alLimpiarFilAlqui=null;
    ActionListener alLimpiarEdiAlqui=null;;
    ActionListener alAniadirAlqui=null;
    ActionListener alActualizarAlqui=null;
    ActionListener alBorrarAlqui=null;
    MouseListener mlFilaAlqui=null;
    //Instancias de la clase controladora
    ClientesPER cliente=null;
    VehiculoPER vehiculo=null;
    AlquileresPER alquiler=null;
    //Modelo de datos que usaremos para llenar las JTable de clientes
     ClientesDAO clienteDao=null;
     VehiculosDAO vehiculoDao=null;
     DefaultTableModel datos=null; 
     AlquileresDAO alquilerDao=null;
    
    Object [] fila=null;
    List resultado=new ArrayList();
    /*
        Uso esta variable por que el diseño viene de otro ejemplo anterior y es
        más facil crear esta variable que cambiar el diseño para añadir un campo
        de texto en la parte de edición de alquileres.
    */
    int idAlquiTemp=0;
    
    //Excepciones
    IdIncorrectoExcepcion idIncorrecto=new IdIncorrectoExcepcion();
    NullRegisterException devolucionNula=new NullRegisterException();
    //Devuelve un string con consejos de uso.
    private String ayuda()
    {
        String result="";
        result="MODO DE USO: \n";
        result=result+"1. Haciendo doble clic en una fila de la taba en Visualización los datos aparecen en Edición. Luego puedo borrar o actualizar.\n";
        result=result+"2. Los campos de Filtros cojen los datos automaticamente y filtra los registros de la Base de Datos\n";
        result=result+"3. El botón de Borrar Filtros borra el contenido de los campos de filtros\n";
        result=result+"4. Los botones Añadir, Actualizar y Borrar sirven realizan esa acción con los datos en las tablas correspondientes.\n";
        result=result+"5. Los botones Limpiar Edición sirven para limpiar los campos de Edición";
        return result;
    }
    
   //Limpia los JTextFields de los "filtros" de ClientesDto
    private void limpiarFiltrosCli()
    {
        jtfFilId.setText("");
        jtfFilNombre.setText("");
        jtfFilApellidos.setText("");
        jtfFilCiudad.setText("");
        resultado=clienteDao.selectAll();
        llenarTabClient();
    }
    
    //Limpia los JTextFields de la zona de "edicion" de clientes
    private void limpiarEdiCli()
    {
        jtfEdiId.setText("");
        jtfEdiNombre.setText("");
        jtfEdiApellidos.setText("");
        jtfEdiCiudad.setText("");
    }
     
    //Coge los datos de los jtextfield de la zona "Filtros" de cliente
    private void cogerDatosFilClientes() throws IdIncorrectoExcepcion
    {        
        if(!jtfFilId.getText().equals(""))
        {
            
            int id=Integer.parseInt(jtfFilId.getText());
            cliente.setIdCliente(id);
            idIncorrecto.idIncorrecto(id);           
        }
        if (!jtfFilNombre.getText().equals(""))
        {
            cliente.setNombre(jtfFilNombre.getText());
        }
        if(!jtfFilApellidos.getText().equals(""))
        {
            cliente.setApellidos(jtfFilApellidos.getText());
        }
        if(!jtfFilCiudad.getText().equals(""))
        {
            cliente.setCiudad(jtfFilCiudad.getText());
        }
    }
    
     //Coge los datos de los jtextfield de la zona de edición de clientes
    private void cogerDatosEdiClientes() throws IdIncorrectoExcepcion
    {
        if(!jtfEdiId.getText().equals(""))
        {
            int id=Integer.parseInt(jtfEdiId.getText());
            cliente.setIdCliente(id);
            idIncorrecto.idIncorrecto(id);
        }
        if (!jtfEdiNombre.getText().equals(""))
        {
            cliente.setNombre(jtfEdiNombre.getText());
        }
        if(!jtfEdiApellidos.getText().equals(""))
        {
            cliente.setApellidos(jtfEdiApellidos.getText());
        }
        if(!jtfEdiCiudad.getText().equals(""))
        {
            cliente.setCiudad(jtfEdiCiudad.getText());
        }
    }
    
    //Limpia los JTextFields de la zona de "filtros" de vehiculos.
    private void limpiarFilVehi()
    {
      jtfFilIdVehi.setText("");
      jtfFilMarcaVehi.setText("");
      jtfFilModeloVehi.setText("");
      resultado=clienteDao.selectAll();
      llenarTabClient();
    }
    //Limpia los JTextFields de la zona de "edicion" de vehiculos.
    private void limpiarEdiVehi()
    {
       jtfEdiIdVehi.setText("");
       jtfEdiMarcaVehi.setText("");
       jtfEdiModeloVehi.setText("");
    }
    
    private void cogerDatosFilVehi() throws IdIncorrectoExcepcion
    {
     
      if(!jtfFilIdVehi.getText().equals(""))
      {
          int id=Integer.parseInt(jtfFilIdVehi.getText());
          idIncorrecto.idIncorrecto(id);
          vehiculo.setIdVehiculo(id);
          
      }
      if(!jtfFilMarcaVehi.getText().equals(""))
      {
          vehiculo.setMarca(jtfFilMarcaVehi.getText());
      }
      if(!jtfFilModeloVehi.getText().equals(""))
      {
          vehiculo.setModelo(jtfFilModeloVehi.getText());
      }
    }
    
    private void cogerDatosEdiVehi() throws IdIncorrectoExcepcion
    {
         if(!jtfEdiIdVehi.getText().equals(""))
      {
          int id=Integer.parseInt(jtfEdiIdVehi.getText());
          idIncorrecto.idIncorrecto(id);
          vehiculo.setIdVehiculo(id);
      }
      if(!jtfEdiMarcaVehi.getText().equals(""))
      {
          vehiculo.setMarca(jtfEdiMarcaVehi.getText());
      }
      if(!jtfEdiModeloVehi.getText().equals(""))
      {
          vehiculo.setModelo(jtfEdiModeloVehi.getText());
      }
    }
    
    private void limpiarFilAlqui()
    {
        jtfFilIdCliAlqui.setText("");
        jtfFilIdVehiAlqui.setText("");
        jtfFilMatriculaAlqui.setText("");
        jtfFilKilometrosAlqui.setText("");
        resultado=alquilerDao.selectAll();
        llenarTabAlqui();
    }
    
    private void limpiarEdiAlqui()
    {
        jtfEdiIdVehiAlqui.setText("");
        jtfEdiMatriculaAlqui.setText("");
        jtfEdiKilometrosAlqui.setText("");
    }
    
    private void cogerDatosFilAlqui() throws IdIncorrectoExcepcion
    {
        int id;
        if(!jtfFilIdCliAlqui.getText().equals(""))
        { 
            id=Integer.parseInt(jtfFilIdCliAlqui.getText());
            idIncorrecto.idIncorrecto(id);
            alquiler.setIdCliente(id);
            
        }
        if(!jtfFilIdVehiAlqui.getText().equals(""))
        { 
            id=Integer.parseInt(jtfFilIdVehiAlqui.getText());
            idIncorrecto.idIncorrecto(id);
            alquiler.setIdVehiculo(id);
        }
        
        if(!jtfFilMatriculaAlqui.getText().equals(""))
        { 
            alquiler.setMatricula(jtfFilMatriculaAlqui.getText());
        }
        if(!jtfFilKilometrosAlqui.getText().equals(""))
        {
            int km;
            km=Integer.parseInt(jtfFilKilometrosAlqui.getText());
            idIncorrecto=new IdIncorrectoExcepcion("Los Kilometros han de ser mayores a 0");
            idIncorrecto.idIncorrecto(km);
            alquiler.setKilometros(km);
        };
       
    }
    
    private void cogerDatosEdiAlqui() throws IdIncorrectoExcepcion
    {
        int id;
        alquiler.setIdAlquiler(idAlquiTemp);
        if(!jtfEdiIdCliAlqui.getText().equals(""))
        { 
            id=Integer.parseInt(jtfEdiIdCliAlqui.getText());
            idIncorrecto.idIncorrecto(id);
            alquiler.setIdCliente(id);
            
        }
        if(!jtfEdiIdVehiAlqui.getText().equals(""))
        { 
            id=Integer.parseInt(jtfEdiIdVehiAlqui.getText());
            idIncorrecto.idIncorrecto(id);
            alquiler.setIdVehiculo(id);
        }
        
        if(!jtfEdiMatriculaAlqui.getText().equals(""))
        { 
            alquiler.setMatricula(jtfEdiMatriculaAlqui.getText());
        }
        if(!jtfEdiKilometrosAlqui.getText().equals(""))
        {
            id=Integer.parseInt(jtfEdiKilometrosAlqui.getText());
             idIncorrecto=new IdIncorrectoExcepcion("Los Kilometros han de ser mayores a 0");
            idIncorrecto.idIncorrecto(id);
            alquiler.setKilometros(id);
        };
    }
        
   //Llenamos la tabla de clientes
    private void llenarTabClient()
    {
        Object []fila=new Object[4];
        datosCli=new Object[0][0];
        datos=new DefaultTableModel(datosCli,columCli);
        for(int i=0;i<resultado.size();i++)
        {
            cliente=(ClientesPER)resultado.get(i);
            fila[0]=cliente.getIdCliente();
            fila[1]=cliente.getNombre();
            fila[2]=cliente.getApellidos();
            fila[3]=cliente.getCiudad();
            datos.addRow(fila);
        }
        jtVisualClien=new JTable(datos);
        jtVisualClien.addMouseListener(mlFilaCli);
        jtVisualClien.setRowSelectionAllowed(true);
        jspVisualClien.setViewportView(jtVisualClien);
    }
    
    private void llenarTabVehi()
    {
        Object []fila=new Object[3];
        datosCli=new Object[0][0];
        datos=new DefaultTableModel(datosCli,columVehi);
        for(int i=0;i<resultado.size();i++)
        {
            vehiculo=(VehiculoPER)resultado.get(i);
            fila[0]=vehiculo.getIdVehiculo();
            fila[1]=vehiculo.getMarca();
            fila[2]=vehiculo.getModelo();
            datos.addRow(fila);
        }
        jtVisualVehi=new JTable(datos);
        jtVisualVehi.addMouseListener(mlFilaVehi);
        jtVisualVehi.setRowSelectionAllowed(true);
        jspVisualVehi.setViewportView(jtVisualVehi);
        jpVehVisual.add(jspVisualVehi);
    }
    
    private void llenarTabAlqui()
    {
        Object []fila1= new Object[5];
        datosAlqui=new Object[0][0];
        datos=new DefaultTableModel(datosAlqui,columAlqui);
        for(int i=0;i<resultado.size();i++)
        {
            alquiler=(AlquileresPER)resultado.get(i);
            fila1[0]=alquiler.getIdAlquiler();
            fila1[1]=alquiler.getIdCliente();
            fila1[2]=alquiler.getIdVehiculo();
            fila1[3]=alquiler.getMatricula();
            fila1[4]=alquiler.getKilometros();
            datos.addRow(fila1);
        }
       jtVisualAlqui=new JTable(datos);
       jtVisualAlqui.addMouseListener(mlFilaAlqui);
       jtVisualAlqui.setRowSelectionAllowed(true);
       jspVisualAlqui.setViewportView(jtVisualAlqui);
       jpAlquiVisual.add(jspVisualAlqui);
    }
   
   //Inicializa los listeners      
    public void initListeners()
    {
        wlSalir=new WindowAdapter()
        {
            public void windowClosing(WindowEvent evt)
            {
                System.exit(0);
            }
        };
        
        alSalir=new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }           
        };
        
        alAyuda=new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(null, ayuda());
            }
        };
        
        dlIdCli=new DocumentListener()
        {
            @Override
            public void insertUpdate(DocumentEvent e) {
                try
                {
                cliente=new ClientesPER();
                cogerDatosFilClientes();
                resultado=clienteDao.selectCUSTOM(cliente);
                llenarTabClient();
                }
                catch(IdIncorrectoExcepcion ex)
                    {
                        lblEdiResul.setText(ex.getMessage());
                    }
                catch(NumberFormatException ex)
                {
                        lblEdiResul.setText(ex.getMessage());
                }
               
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                try
                {
                cliente=new ClientesPER();
                cogerDatosFilClientes();
                resultado=clienteDao.selectCUSTOM(cliente);               
                llenarTabClient();
                }
                catch(IdIncorrectoExcepcion ex)
                    {
                        lblEdiResul.setText(ex.getMessage());
                    }
                catch(NumberFormatException ex)
                {
                        lblEdiResul.setText(ex.getMessage());
                }
              }

            @Override
            public void changedUpdate(DocumentEvent e) {
               try
                {
                cliente=new ClientesPER();
                cogerDatosFilClientes();
                resultado=clienteDao.selectCUSTOM(cliente);
                llenarTabClient();
                }
                catch(IdIncorrectoExcepcion ex)
                    {
                        lblEdiResul.setText(ex.getMessage());
                    }
                catch(NumberFormatException ex)
                {
                        lblEdiResul.setText(ex.getMessage());
                }
            }        
        };
       
        dlCiudCli=new DocumentListener()
        {
            @Override
            public void insertUpdate(DocumentEvent e) {
            try
                {
                cliente=new ClientesPER();
                cogerDatosFilClientes();
                resultado=clienteDao.selectCUSTOM(cliente);
                llenarTabClient();
                }
                catch(IdIncorrectoExcepcion ex)
                    {
                        lblEdiResul.setText(ex.getMessage());
                    }
                catch(NumberFormatException ex)
                {
                        lblEdiResul.setText(ex.getMessage());
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
              try
                {
                cliente=new ClientesPER();
                cogerDatosFilClientes();
                resultado=clienteDao.selectCUSTOM(cliente);
                llenarTabClient();
                }
                catch(IdIncorrectoExcepcion ex)
                    {
                        lblEdiResul.setText(ex.getMessage());
                    }
                catch(NumberFormatException ex)
                {
                        lblEdiResul.setText(ex.getMessage());
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
              try
                {
                cliente=new ClientesPER();
                cogerDatosFilClientes();
                resultado=clienteDao.selectCUSTOM(cliente);
                llenarTabClient();
                }
                catch(IdIncorrectoExcepcion ex)
                    {
                        lblEdiResul.setText(ex.getMessage());
                    }
                catch(NumberFormatException ex)
                {
                        lblEdiResul.setText(ex.getMessage());
                }
            }        
        };
        
        dlNomCli=new DocumentListener()
        {
            @Override
            public void insertUpdate(DocumentEvent e) {
              try
                {
                cliente=new ClientesPER();
                cogerDatosFilClientes();
                resultado=clienteDao.selectCUSTOM(cliente);
                llenarTabClient();
                }
                catch(IdIncorrectoExcepcion ex)
                    {
                        lblEdiResul.setText(ex.getMessage());
                    }
                catch(NumberFormatException ex)
                {
                        lblEdiResul.setText(ex.getMessage());
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                try
                {
                cliente=new ClientesPER();
                cogerDatosFilClientes();
                resultado=clienteDao.selectCUSTOM(cliente);
                llenarTabClient();
                }
                catch(IdIncorrectoExcepcion ex)
                    {
                        lblEdiResul.setText(ex.getMessage());
                    }
                catch(NumberFormatException ex)
                {
                        lblEdiResul.setText(ex.getMessage());
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                try
                {
                cliente=new ClientesPER();
                cogerDatosFilClientes();
                resultado=clienteDao.selectCUSTOM(cliente);
                llenarTabClient();
                }
                catch(IdIncorrectoExcepcion ex)
                    {
                        lblEdiResul.setText(ex.getMessage());
                    }
                catch(NumberFormatException ex)
                {
                        lblEdiResul.setText(ex.getMessage());
                }
            }        
        };
        
        dlApellCli=new DocumentListener()
        {
            @Override
            public void insertUpdate(DocumentEvent e) {
                 try
                {
                cliente=new ClientesPER();
                cogerDatosFilClientes();
                resultado=clienteDao.selectCUSTOM(cliente);
                llenarTabClient();
                }
                catch(IdIncorrectoExcepcion ex)
                    {
                        lblEdiResul.setText(ex.getMessage());
                    }
                catch(NumberFormatException ex)
                {
                        lblEdiResul.setText(ex.getMessage());
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                 try
                {
                cliente=new ClientesPER();
                cogerDatosFilClientes();
                resultado=clienteDao.selectCUSTOM(cliente);
                llenarTabClient();
                }
                catch(IdIncorrectoExcepcion ex)
                    {
                        lblEdiResul.setText(ex.getMessage());
                    }
                catch(NumberFormatException ex)
                {
                        lblEdiResul.setText(ex.getMessage());
                } 
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                  try
                {
                cliente=new ClientesPER();
                cogerDatosFilClientes();
                resultado=clienteDao.selectCUSTOM(cliente);
                llenarTabClient();
                }
                catch(IdIncorrectoExcepcion ex)
                    {
                        lblEdiResul.setText(ex.getMessage());
                    }
                catch(NumberFormatException ex)
                {
                        lblEdiResul.setText(ex.getMessage());
                }  
            }        
        };
       
        alBorrarFilCli=new ActionListener()
        {
          @Override
          public void actionPerformed(ActionEvent evt)
          {
              limpiarFiltrosCli();   
              cliente=null;
          }
        };
        
        mlFilaCli=new MouseAdapter()
        {
            public void mouseClicked(MouseEvent evt)
            {
                int fila=jtVisualClien.rowAtPoint(evt.getPoint());
                jtfEdiId.setText(String.valueOf(jtVisualClien.getValueAt(fila,0)));
                jtfEdiNombre.setText(String.valueOf(jtVisualClien.getValueAt(fila,1)));
                jtfEdiApellidos.setText(String.valueOf(jtVisualClien.getValueAt(fila,2)));
                jtfEdiCiudad.setText(String.valueOf(jtVisualClien.getValueAt(fila,3)));
            }
        };
        
       alAniadirCli=new ActionListener()
       {
           public void actionPerformed(ActionEvent e)
           {
              try
                {
                cliente=new ClientesPER();
                cogerDatosFilClientes();
                cogerDatosEdiClientes();
               clienteDao.insert(cliente); 
               resultado=clienteDao.selectAll();
               llenarTabClient();
               lblEdiResul.setText("Registro guardado con exito");
                
                }
                catch(IdIncorrectoExcepcion ex)
                    {
                        lblEdiResul.setText(ex.getMessage());
                    }
                catch(NumberFormatException ex)
                {
                        lblEdiResul.setText(ex.getMessage());
                }
               cliente=new ClientesPER();
               
           }
       };
      
       alActualizarCli=new ActionListener()
       {
           public void actionPerformed(ActionEvent e)
           {
               try
                {
                cliente=new ClientesPER();
                cogerDatosFilClientes();
                clienteDao.update(cliente);
                resultado=clienteDao.selectAll();                    
                llenarTabClient();
                }
                catch(IdIncorrectoExcepcion ex)
                    {
                        lblEdiResul.setText(ex.getMessage());
                    }
                catch(NumberFormatException ex)
                {
                        lblEdiResul.setText(ex.getMessage());
                }
            }
       };
       
       alBorrarCli=new ActionListener()
       {
           public void actionPerformed(ActionEvent e)
           {
              int opcion=0;
              try
                {
                cliente=new ClientesPER();
                cogerDatosFilClientes();
                resultado=clienteDao.selectCUSTOM(cliente);opcion=JOptionPane.showConfirmDialog(null, "¿Quiere borrar este registro?\n"+cliente+"\nEsto puede suponer borrar uno o varios registros relacionados de la tabla alquileres.\n ");
                devolucionNula.devolucionNula(resultado);
                if(opcion==JOptionPane.YES_OPTION)
                {
                  clienteDao.delete(cliente.getIdCliente());
                }
               resultado=clienteDao.selectAll();
               devolucionNula.devolucionNula(resultado);
               llenarTabClient();
               lblEdiResul.setText("Registro borrado con exito");
               limpiarEdiCli();
                }
                catch(IdIncorrectoExcepcion ex)
                    {
                        lblEdiResul.setText(ex.getMessage());
                    }
                catch(NumberFormatException ex)
                {
                        lblEdiResul.setText(ex.getMessage());
                }              
                catch (NullRegisterException ex)
                {
                        lblEdiResul.setText(ex.getMessage());
                }
           }
       };
        
        alLimpiarEdiCli=new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                limpiarEdiCli();
            }
        };
        
       dlIdVehi=new DocumentListener()
        {
            @Override
            public void insertUpdate(DocumentEvent e) {
                try{
                vehiculo=new VehiculoPER();
                cogerDatosFilVehi();
                resultado=vehiculoDao.selectCUSTOM(vehiculo);
                devolucionNula.devolucionNula(resultado);
                llenarTabVehi();     
                }
                catch (IdIncorrectoExcepcion ex)
                {
                   lblResulEdiVehi.setText(ex.getMessage());
                }
                catch(NumberFormatException ex)
                {
                    lblResulEdiVehi.setText(ex.getMessage());
                }
                catch (NullRegisterException ex)
                {
                       lblResulEdiVehi.setText(ex.getMessage());
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
               try{
                vehiculo=new VehiculoPER();
                cogerDatosFilVehi();
                resultado=vehiculoDao.selectCUSTOM(vehiculo);
                devolucionNula.devolucionNula(resultado);
                llenarTabVehi();     
                }
                catch (IdIncorrectoExcepcion ex)
                {
                   lblResulEdiVehi.setText(ex.getMessage());
                }
                catch(NumberFormatException ex)
                {
                    lblResulEdiVehi.setText(ex.getMessage());
                }
                 catch (NullRegisterException ex)
                {
                       lblResulEdiVehi.setText(ex.getMessage());
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
               try{
                vehiculo=new VehiculoPER();
                cogerDatosFilVehi();
                resultado=vehiculoDao.selectCUSTOM(vehiculo);
                devolucionNula.devolucionNula(resultado);
                llenarTabVehi();     
                }
                catch (IdIncorrectoExcepcion ex)
                {
                   lblResulEdiVehi.setText(ex.getMessage());
                }
                catch(NumberFormatException ex)
                {
                    lblResulEdiVehi.setText(ex.getMessage());
                }
                 catch (NullRegisterException ex)
                {
                       lblResulEdiVehi.setText(ex.getMessage());
                }
            }
        
        };
       
        dlMarcaVehi=new DocumentListener()
        {
            @Override
            public void insertUpdate(DocumentEvent e) {
               try{
                vehiculo=new VehiculoPER();
                cogerDatosFilVehi();
                resultado=vehiculoDao.selectCUSTOM(vehiculo);
                devolucionNula.devolucionNula(resultado);
                llenarTabVehi();     
                }
                catch (IdIncorrectoExcepcion ex)
                {
                    lblResulEdiVehi.setText(ex.getMessage());
                }
                catch(NumberFormatException ex)
                {
                    lblResulEdiVehi.setText(ex.getMessage());
                }
                 catch (NullRegisterException ex)
                {
                       lblResulEdiVehi.setText(ex.getMessage());
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
               try{
                vehiculo=new VehiculoPER();
                cogerDatosFilVehi();
                resultado=vehiculoDao.selectCUSTOM(vehiculo);
                devolucionNula.devolucionNula(resultado);
                llenarTabVehi();     
                }
                catch (IdIncorrectoExcepcion ex)
                {
                    lblResulEdiVehi.setText(ex.getMessage());
                }
                catch(NumberFormatException ex)
                {
                    lblResulEdiVehi.setText(ex.getMessage());
                }
                 catch (NullRegisterException ex)
                {
                       lblResulEdiVehi.setText(ex.getMessage());
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
              try{
                vehiculo=new VehiculoPER();
                cogerDatosFilVehi();
                resultado=vehiculoDao.selectCUSTOM(vehiculo);
                devolucionNula.devolucionNula(resultado);
                llenarTabVehi();     
                }
                catch (IdIncorrectoExcepcion ex)
                {
                    lblEdiResul.setText(ex.getMessage());
                }
                catch(NumberFormatException ex)
                {
                    lblEdiResul.setText(ex.getMessage());
                }
                catch (NullRegisterException ex)
                {
                       lblResulEdiVehi.setText(ex.getMessage());
                }
            }        
        };
       
        dlModeloVehi=new DocumentListener()
        {
            @Override
            public void insertUpdate(DocumentEvent e) {
               try{
                vehiculo=new VehiculoPER();
                cogerDatosFilVehi();
                resultado=vehiculoDao.selectCUSTOM(vehiculo);
                devolucionNula.devolucionNula(resultado);
                llenarTabVehi();     
                }
                catch (IdIncorrectoExcepcion ex)
                {
                    lblResulEdiVehi.setText(ex.getMessage());
                }
                catch(NumberFormatException ex)
                {
                    lblResulEdiVehi.setText(ex.getMessage());
                }
                 catch (NullRegisterException ex)
                {
                       lblResulEdiVehi.setText(ex.getMessage());
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
               try{
                vehiculo=new VehiculoPER();
                cogerDatosFilVehi();
                resultado=vehiculoDao.selectCUSTOM(vehiculo);
                devolucionNula.devolucionNula(resultado);
                llenarTabVehi();     
                }
                 catch (IdIncorrectoExcepcion ex)
                {
                    lblResulEdiVehi.setText(ex.getMessage());
                }
                catch(NumberFormatException ex)
                {
                    lblResulEdiVehi.setText(ex.getMessage());
                }
                 catch (NullRegisterException ex)
                {
                       lblResulEdiVehi.setText(ex.getMessage());
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
               try{
                vehiculo=new VehiculoPER();
                cogerDatosFilVehi();
                resultado=vehiculoDao.selectCUSTOM(vehiculo);
                devolucionNula.devolucionNula(resultado);
                llenarTabVehi();     
                }
                catch (IdIncorrectoExcepcion ex)
                {
                    lblEdiResul.setText(ex.getMessage());
                }
                catch(NumberFormatException ex)
                {
                    lblEdiResul.setText(ex.getMessage());
                }
                 catch (NullRegisterException ex)
                {
                       lblResulEdiVehi.setText(ex.getMessage());
                }
            }        
        };
        
        alAniadirVehi=new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                vehiculo=new VehiculoPER();
                cogerDatosEdiVehi();
                vehiculoDao.insert(vehiculo);
                resultado=vehiculoDao.selectAll();
                devolucionNula.devolucionNula(resultado);
                llenarTabVehi();
                resultado=null;
                }
                catch (IdIncorrectoExcepcion ex)
                {
                    lblResulEdiVehi.setText(ex.getMessage());
                }
                catch(NumberFormatException ex)
                {
                    lblResulEdiVehi.setText(ex.getMessage());
                }
                  catch (NullRegisterException ex)
                {
                       lblResulEdiVehi.setText(ex.getMessage());
                }
            }
        };
        
        alActualizarVehi= new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                resultado=new ArrayList();
                vehiculo=new VehiculoPER();
                cogerDatosEdiVehi();
                vehiculoDao.update(vehiculo);
                resultado=vehiculoDao.selectAll();
                devolucionNula.devolucionNula(resultado);
                llenarTabVehi();
                }
                 catch (IdIncorrectoExcepcion ex)
                {
                    lblResulEdiVehi.setText(ex.getMessage());
                }
                catch(NumberFormatException ex)
                {
                    lblResulEdiVehi.setText(ex.getMessage());
                }
                 catch (NullRegisterException ex)
                {
                       lblResulEdiVehi.setText(ex.getMessage());
                }
            }
        };
       
        alBorrarVehi=new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
               int opcion,r;
               try
               {
               vehiculo=new VehiculoPER();
               cogerDatosEdiVehi();  
               vehiculo=vehiculoDao.selectID(Integer.parseInt(jtfEdiIdVehi.getText()));
               devolucionNula.devolucionNula(vehiculo);
               opcion=JOptionPane.showConfirmDialog(null,"¿Quiere borrar este registro\n"+vehiculo+"\nEsto puede suponer borrar registros relacionados de la tabla de alquileres");
               if(opcion==JOptionPane.YES_OPTION)
               {                 
                 vehiculoDao.delete(jtfEdiIdVehi.getText());
                 JOptionPane.showMessageDialog(null,"Registro borrado con exito");
                 resultado=vehiculoDao.selectAll();
                 llenarTabVehi();
               }
               }
                catch(IdIncorrectoExcepcion ex)
                {
                     lblEdiResul.setText(ex.getMessage());
                }
                catch(NumberFormatException ex)
                {
                     lblEdiResul.setText(ex.getMessage());
                }
                 catch (NullRegisterException ex)
                {
                       lblResulEdiVehi.setText(ex.getMessage());
                }
            }
        };
        
        alLimpiarFilVehi=new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
            {
                limpiarFilVehi();
                vehiculo=null;
            }
        };
        
        alLimpiarEdiVehi=new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {     
                limpiarEdiVehi();
                cliente=null;
            }
        };
        
        mlFilaVehi= new MouseAdapter()
        {
            public void mouseClicked(MouseEvent evt)
            {
                int fila=jtVisualVehi.rowAtPoint(evt.getPoint());
                jtfEdiIdVehi.setText(String.valueOf(jtVisualVehi.getValueAt(fila,0)));
                jtfEdiMarcaVehi.setText(String.valueOf(jtVisualVehi.getValueAt(fila,1)));
                jtfEdiModeloVehi.setText(String.valueOf(jtVisualVehi.getValueAt(fila,2)));     
            }
        };
      
        dlIdCliAlqui=new DocumentListener()
        {
            @Override
            public void insertUpdate(DocumentEvent e) {
              try
               {
               alquiler=new AlquileresPER();
               cogerDatosFilAlqui();
               resultado=alquilerDao.selectCUSTOM(alquiler);
               llenarTabAlqui();
               }
               catch(IdIncorrectoExcepcion ex)
                {
                     lblResulEdiAlqui.setText(ex.getMessage());
                }
                catch(NumberFormatException ex)
                {
                     lblResulEdiAlqui.setText(ex.getMessage());
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
              try
               {
               alquiler=new AlquileresPER();
               cogerDatosFilAlqui();
               resultado=alquilerDao.selectCUSTOM(alquiler);
               llenarTabAlqui();
               }
               catch(IdIncorrectoExcepcion ex)
                {
                     lblResulEdiAlqui.setText(ex.getMessage());
                }
                catch(NumberFormatException ex)
                {
                     lblResulEdiAlqui.setText(ex.getMessage());
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
               try
               {
               alquiler=new AlquileresPER();
               cogerDatosFilAlqui();
               resultado=alquilerDao.selectCUSTOM(alquiler);
               llenarTabAlqui();
               }
               catch(IdIncorrectoExcepcion ex)
                {
                     lblResulEdiAlqui.setText(ex.getMessage());
                }
                catch(NumberFormatException ex)
                {
                     lblResulEdiAlqui.setText(ex.getMessage());
                }
            }        
        };
        
        dlIdVehiAlqui=new DocumentListener()        
        {
            @Override
            public void insertUpdate(DocumentEvent e) {
                try
               {
               alquiler=new AlquileresPER();
               cogerDatosFilAlqui();
               resultado=alquilerDao.selectCUSTOM(alquiler);
               llenarTabAlqui();
               }
               catch(IdIncorrectoExcepcion ex)
                {
                     lblResulEdiAlqui.setText(ex.getMessage());
                }
                catch(NumberFormatException ex)
                {
                     lblResulEdiAlqui.setText(ex.getMessage());
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
              try
               {
               alquiler=new AlquileresPER();
               cogerDatosFilAlqui();
               resultado=alquilerDao.selectCUSTOM(alquiler);
               llenarTabAlqui();
               }
               catch(IdIncorrectoExcepcion ex)
                {
                     lblResulEdiAlqui.setText(ex.getMessage());
                }
                catch(NumberFormatException ex)
                {
                     lblResulEdiAlqui.setText(ex.getMessage());
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                try
               {
               alquiler=new AlquileresPER();
               cogerDatosFilAlqui();
               resultado=alquilerDao.selectCUSTOM(alquiler);
               llenarTabAlqui();
               }
               catch(IdIncorrectoExcepcion ex)
                {
                     lblResulEdiAlqui.setText(ex.getMessage());
                }
                catch(NumberFormatException ex)
                {
                     lblResulEdiAlqui.setText(ex.getMessage());
                }
            }        
        };
      
        dlMatriculaAlqui=new DocumentListener()
        {
            @Override
            public void insertUpdate(DocumentEvent e) {
               try
               {
               alquiler=new AlquileresPER();
               cogerDatosFilAlqui();
               resultado=alquilerDao.selectCUSTOM(alquiler);
               llenarTabAlqui();
               }
               catch(IdIncorrectoExcepcion ex)
                {
                     lblResulEdiAlqui.setText(ex.getMessage());
                }
                catch(NumberFormatException ex)
                {
                     lblResulEdiAlqui.setText(ex.getMessage());
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
               try
               {
               alquiler=new AlquileresPER();
               cogerDatosFilAlqui();
               resultado=alquilerDao.selectCUSTOM(alquiler);
               llenarTabAlqui();
               }
               catch(IdIncorrectoExcepcion ex)
                {
                     lblResulEdiAlqui.setText(ex.getMessage());
                }
                catch(NumberFormatException ex)
                {
                     lblResulEdiAlqui.setText(ex.getMessage());
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
               try
               {
               alquiler=new AlquileresPER();
               cogerDatosFilAlqui();
               resultado=alquilerDao.selectCUSTOM(alquiler);
               llenarTabAlqui();
               }
               catch(IdIncorrectoExcepcion ex)
                {
                     lblResulEdiAlqui.setText(ex.getMessage());
                }
                catch(NumberFormatException ex)
                {
                     lblResulEdiAlqui.setText(ex.getMessage());
                }
            }        
        };
      
        dlKilometrosAlqui=new DocumentListener()
        {
            @Override
            public void insertUpdate(DocumentEvent e) {
               try
               {
               alquiler=new AlquileresPER();
               cogerDatosFilAlqui();
               resultado=alquilerDao.selectCUSTOM(alquiler);
               llenarTabAlqui();
               }
               catch(IdIncorrectoExcepcion ex)
                {
                     lblResulEdiAlqui.setText(ex.getMessage());
                }
                catch(NumberFormatException ex)
                {
                     lblResulEdiAlqui.setText(ex.getMessage());
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                try
               {
               alquiler=new AlquileresPER();
               cogerDatosFilAlqui();
               resultado=alquilerDao.selectCUSTOM(alquiler);
               llenarTabAlqui();
               }
               catch(IdIncorrectoExcepcion ex)
                {
                     lblResulEdiAlqui.setText(ex.getMessage());
                }
                catch(NumberFormatException ex)
                {
                     lblResulEdiAlqui.setText(ex.getMessage());
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                try
               {
               alquiler=new AlquileresPER();
               cogerDatosFilAlqui();
               resultado=alquilerDao.selectCUSTOM(alquiler);
               llenarTabAlqui();
               }
               catch(IdIncorrectoExcepcion ex)
                {
                     lblResulEdiAlqui.setText(ex.getMessage());
                }
                catch(NumberFormatException ex)
                {
                     lblResulEdiAlqui.setText(ex.getMessage());
                }
            }       
        };
        
        mlFilaAlqui=new MouseAdapter()
        {
            public void mouseClicked(MouseEvent evt)
            {
                int fila=jtVisualAlqui.rowAtPoint(evt.getPoint());
                idAlquiTemp=Integer.parseInt(String.valueOf(jtVisualAlqui.getValueAt(fila,0)));
                jtfEdiIdCliAlqui.setText(String.valueOf(jtVisualAlqui.getValueAt(fila,1)));
                jtfEdiIdVehiAlqui.setText(String.valueOf(jtVisualAlqui.getValueAt(fila,2)));
                jtfEdiMatriculaAlqui.setText(String.valueOf(jtVisualAlqui.getValueAt(fila, 3)));
                jtfEdiKilometrosAlqui.setText(String.valueOf(jtVisualAlqui.getValueAt(fila,4)));
            }
        };
        
        alAniadirAlqui=new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
               try
               {
                alquiler=new AlquileresPER();
                cogerDatosEdiAlqui();
                alquilerDao.insert(alquiler);
                resultado=alquilerDao.selectAll();
                llenarTabAlqui();
                resultado=null;
               }
               catch(IdIncorrectoExcepcion ex)
                {
                     lblResulEdiAlqui.setText(ex.getMessage());
                }
                catch(NumberFormatException ex)
                {
                     lblResulEdiAlqui.setText(ex.getMessage());
                }
            }
        };
      
        alActualizarAlqui=new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
               try
               {
                alquiler=new AlquileresPER();
                cogerDatosEdiAlqui();
                alquilerDao.update(alquiler);
                JOptionPane.showMessageDialog(null,"Registro actualizado con exito");
                resultado=alquilerDao.selectAll();
                llenarTabAlqui();
               }
               catch(IdIncorrectoExcepcion ex)
                {
                     lblResulEdiAlqui.setText(ex.getMessage());
                }
                catch(NumberFormatException ex)
                {
                     lblResulEdiAlqui.setText(ex.getMessage());
                }
            }
        };
       
        alBorrarAlqui=new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    alquiler=new AlquileresPER();
                    cogerDatosEdiAlqui();
                    alquilerDao.delete(alquiler.getIdAlquiler());
                    resultado=alquilerDao.selectAll();
                    llenarTabAlqui();
                    resultado=null;
                }
                catch(IdIncorrectoExcepcion ex)
                {
                     lblResulEdiAlqui.setText(ex.getMessage());
                }
                catch(NumberFormatException ex)
                {
                     lblResulEdiAlqui.setText(ex.getMessage());
                }
            }
        };
        
        alLimpiarEdiAlqui=new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                limpiarEdiAlqui();
            }
        };
       
        alLimpiarFilAlqui=new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                limpiarFilAlqui();
                alquiler=null;
            }
        };
    }
    
    //Añade la barra de menu con sus correspondientes menus.
    private void initMenu()
    {
        jmbBarraMenu=new JMenuBar();
        jmArchivo=new JMenu("Archivo");
        jmiElegirBD=new JMenuItem("Elegir BD");
        jmiElegirBD.addActionListener(alElegirBD);
        jmArchivo.add(jmiElegirBD);
        jsSeparador=new JSeparator();
        jmiSalir=new JMenuItem("Salir");
        jmiSalir.addActionListener(alSalir);
        jmArchivo.add(jmiSalir);
        jmbBarraMenu.add(jmArchivo);
        jmAyuda=new JMenu("Ayuda");
        jmiAyuda=new JMenuItem("Ayuda");
        jmiAyuda.addActionListener(alAyuda);
        jmAyuda.add(jmiAyuda);
        jmbBarraMenu.add(jmAyuda);
        constrains.gridx=0;
        constrains.gridy=0;
        constrains.weightx=1.0;
        constrains.fill=GridBagConstraints.HORIZONTAL;
        getContentPane().add(jmbBarraMenu,constrains);
        constrains.weightx=0.0;
    }
   
    private void initFitroClientes()
    {
        JPanel jpBotonesFiltroClientes=new JPanel();
        jpBotonesFiltroClientes.setLayout(new GridBagLayout());
        lblFilIdCliente=new JLabel("Id Cliente");
        constrains.gridx=0;
        constrains.gridy=0;
        constrains.weightx=1.0;
        jpcliFiltro.add(lblFilIdCliente,constrains);
        constrains.weightx=0.0;
        
        jtfFilId=new JTextField();
        jtfFilId.getDocument().addDocumentListener(dlIdCli);
        constrains.gridx=1;
        constrains.gridy=0;
        constrains.weightx=1.0;
        constrains.fill=GridBagConstraints.HORIZONTAL;
        jpcliFiltro.add(jtfFilId,constrains);
        constrains.weightx=0.0;
        
        lblFilCiudad=new JLabel("Ciudad");
        constrains.gridx=2;
        constrains.gridy=0;
        constrains.weightx=1.0;
        constrains.fill=GridBagConstraints.HORIZONTAL;
        jpcliFiltro.add(lblFilCiudad,constrains);
        constrains.weightx=0.0;
        
        jtfFilCiudad=new JTextField();
        jtfFilCiudad.getDocument().addDocumentListener(dlCiudCli);
        constrains.gridx=3;
        constrains.gridy=0;
        constrains.weightx=1.0;
        constrains.fill=GridBagConstraints.HORIZONTAL;
        jpcliFiltro.add(jtfFilCiudad,constrains);
        constrains.weightx=0.0;
        
        lblFilApellidos=new JLabel("Apellidos");
        constrains.gridx=0;
        constrains.gridy=1;
        constrains.weightx=1.0;
        constrains.fill=GridBagConstraints.HORIZONTAL;
        jpcliFiltro.add(lblFilApellidos,constrains);        
        constrains.weightx=0.0;
        
        jtfFilApellidos=new JTextField();
        jtfFilApellidos.getDocument().addDocumentListener(dlApellCli);
        constrains.gridx=1;
        constrains.gridy=1;
        constrains.weightx=1.0;
        constrains.fill=GridBagConstraints.HORIZONTAL;
        jpcliFiltro.add(jtfFilApellidos,constrains);        
        constrains.weightx=0.0;
        
        lblFilNom=new JLabel("Nombre");
        constrains.gridx=2;
        constrains.gridy=1;
        constrains.weightx=1.0;
        constrains.fill=GridBagConstraints.HORIZONTAL;
        jpcliFiltro.add(lblFilNom,constrains);
        
        jtfFilNombre=new JTextField();
        jtfFilNombre.getDocument().addDocumentListener(dlNomCli);
        constrains.gridx=3;
        constrains.gridy=1;
        constrains.weightx=1.0;
        constrains.fill=GridBagConstraints.HORIZONTAL;
        jpcliFiltro.add(jtfFilNombre,constrains);        
        constrains.weightx=0.0;
        
        jbtLimpiarFil=new JButton("Limpiar Filtros");
        jbtLimpiarFil.addActionListener(alBorrarFilCli);
        constrains.gridx=2;
        constrains.gridy=0;
        constrains.gridwidth=1;
        constrains.anchor=GridBagConstraints.CENTER;
        jpBotonesFiltroClientes.add(jbtLimpiarFil,constrains);  
        constrains.weightx=0.0;
        
        constrains.gridx=0;
        constrains.gridy=2;
        constrains.gridwidth=4;
        constrains.weightx=1.0;
        jpcliFiltro.add(jpBotonesFiltroClientes,constrains);
        constrains.weightx=0.0;
    }
    
    private void initEdiClientes()
    {
        JPanel jpBotonesEdiClientes=new JPanel();
        jpBotonesEdiClientes.setLayout(new GridBagLayout());
        GridBagConstraints constrains1=new GridBagConstraints();
        lblEdiIdCliente=new JLabel("Id Cliente");
        constrains1.gridx=0;
        constrains1.gridy=0;
        constrains1.weightx=1.0;
        constrains1.fill=GridBagConstraints.HORIZONTAL;
        jpCliEdicion.add(lblEdiIdCliente,constrains1);
        constrains1.weightx=0.0;
        
        jtfEdiId=new JTextField();
        jtfEdiId.setEditable(false);
        constrains1.gridx=1;
        constrains1.gridy=0;
        constrains1.weightx=1.0;
        constrains1.fill=GridBagConstraints.HORIZONTAL;
        jpCliEdicion.add(jtfEdiId,constrains1);
        constrains.weightx=0.0;
        
        lblEdiCiudad=new JLabel("Ciudad");
        constrains1.gridx=2;
        constrains1.gridy=0;
        constrains1.weightx=1.0;
        constrains1.fill=GridBagConstraints.HORIZONTAL;
        jpCliEdicion.add(lblEdiCiudad,constrains1);
        constrains1.weightx=0.0;
        
        jtfEdiCiudad=new JTextField();
        jtfFilCiudad.getDocument().addDocumentListener(dlCiudCli);
        constrains1.gridx=3;
        constrains1.gridy=0;
        constrains1.weightx=1.0;
        constrains1.fill=GridBagConstraints.HORIZONTAL;
        jpCliEdicion.add(jtfEdiCiudad,constrains1);
        constrains1.weightx=0.0;
        
        lblEdiApellidos=new JLabel("Apellidos");
        constrains1.gridx=0;
        constrains1.gridy=1;
        constrains1.weightx=1.0;
        constrains1.fill=GridBagConstraints.HORIZONTAL;
        jpCliEdicion.add(lblEdiApellidos,constrains1);        
        constrains1.weightx=0.0;
        
        jtfEdiApellidos=new JTextField();
        constrains1.gridx=1;
        constrains1.gridy=1;
        constrains1.weightx=1.0;
        constrains1.fill=GridBagConstraints.HORIZONTAL;
        jpCliEdicion.add(jtfEdiApellidos,constrains1);        
        constrains1.weightx=0.0;
        
        lblEdiNom=new JLabel("Nombre");
        constrains1.gridx=2;
        constrains1.gridy=1;
        constrains1.weightx=1.0;
        constrains1.fill=GridBagConstraints.HORIZONTAL;
        jpCliEdicion.add(lblEdiNom,constrains1);
        constrains1.weightx=0.0;
        
        jtfEdiNombre=new JTextField();
        constrains1.gridx=3;
        constrains1.gridy=1;
        constrains1.weightx=1.0;
        constrains1.fill=GridBagConstraints.HORIZONTAL;
        jpCliEdicion.add(jtfEdiNombre,constrains1);        
        constrains1.weightx=0.0;
        
        jbtAniadirCli=new JButton("Añadir");
        jbtAniadirCli.addActionListener(alAniadirCli);
        constrains1.gridx=0;
        constrains1.gridy=0;
        constrains1.weightx=1.0;
        jpBotonesEdiClientes.add(jbtAniadirCli,constrains1);
        constrains1.weightx=0.0;
        
        jbtActualizarCli=new JButton("Actualizar");
        jbtActualizarCli.addActionListener(alActualizarCli);
        constrains1.gridx=1;
        constrains1.gridy=0;
        constrains1.weightx=1.0;
        jpBotonesEdiClientes.add(jbtActualizarCli,constrains1);
        constrains1.weightx=0.0;
        
        jbtBorrarCli=new JButton("Borrar");
        jbtBorrarCli.addActionListener(alBorrarCli);
        constrains1.gridx=2;
        constrains1.gridy=0;
        constrains1.weightx=1.0;
        jpBotonesEdiClientes.add(jbtBorrarCli,constrains1);
        constrains1.weightx=0.0;
        
        jbtLimpiarEdiCli=new JButton("Limpiar Edición");
        jbtLimpiarEdiCli.addActionListener(alLimpiarEdiCli);
        constrains1.gridx=3;
        constrains1.gridy=0;
        constrains1.weightx=1.0;
        jpBotonesEdiClientes.add(jbtLimpiarEdiCli,constrains1);      
        
        
        lblEdiResul=new JLabel("Listo");
        constrains1.gridx=0;
        constrains1.gridy=3;
        constrains1.weightx=1;
        jpCliEdicion.add(lblEdiResul,constrains1);
        
        constrains1.weightx=0.0;
        constrains1.gridx=0;
        constrains1.gridy=2;
        constrains1.gridwidth=4;
        jpCliEdicion.add(jpBotonesEdiClientes,constrains1);
        
    }
    
    private void initClientes()
    {
        jpcliVisual=new JPanel();
        jpcliVisual.setLayout(new GridBagLayout());
        jpcliVisual.setBorder(javax.swing.BorderFactory.createTitledBorder("Visualización"));
        jspVisualClien=new JScrollPane();
        datosCli=new Object[0][0];
        jtVisualClien=new JTable(datosCli,columCli);
        jspVisualClien.setViewportView(jtVisualClien);
       
        resultado=clienteDao.selectAll();
       
        llenarTabClient();
        constrains.gridx=0;
        constrains.gridy=0;
        constrains.weightx=1.0;
        constrains.weighty=1.0;
        constrains.fill=GridBagConstraints.HORIZONTAL;
        jpcliVisual.add(jspVisualClien,constrains);
        constrains.weightx=0.0;
        constrains.weighty=0.0;
        constrains.gridx=0;
        constrains.gridy=0;
        constrains.weightx=1.0;
        constrains.weighty=1.0;
        constrains.fill=GridBagConstraints.HORIZONTAL;
        jpClientes.add(jpcliVisual,constrains);
         constrains.weightx=0.0;
        constrains.weighty=0.0;
        jpcliFiltro=new JPanel();
        jpcliFiltro.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));
        jpcliFiltro.setLayout(new GridBagLayout());
        initFitroClientes();
        constrains.gridx=0;
        constrains.gridy=1;
        constrains.weightx=1.0;
        constrains.weighty=1.0;
        jpClientes.add(jpcliFiltro,constrains);
         constrains.weightx=0.0;
        constrains.weighty=0.0;
        jpCliEdicion=new JPanel();
        jpCliEdicion.setBorder(javax.swing.BorderFactory.createTitledBorder("Edicion"));
        jpCliEdicion.setLayout(new GridBagLayout());
        constrains.gridx=0;
        constrains.gridy=2;
        constrains.weightx=1.0;
        constrains.weighty=1.0;
        constrains.fill=GridBagConstraints.HORIZONTAL;
        jpClientes.add(jpCliEdicion,constrains);
        constrains.weightx=0.0;
        constrains.weighty=0.0;
        initEdiClientes();
    }
  
    private void initFiltroVehi()
    {
        JPanel jpBotonesFiltroVehi=new JPanel();
        jpBotonesFiltroVehi.setLayout(new GridBagLayout());
        GridBagConstraints constrains3=new GridBagConstraints();
        lblFilIdVehi=new JLabel("Id Vehiculo");
        constrains3.gridx=0;
        constrains3.gridy=0;
        constrains3.weightx=1.0;
        jpVehFiltro.add(lblFilIdVehi,constrains3);
        constrains3.weightx=0.0;
        
        jtfFilIdVehi=new JTextField();
        jtfFilIdVehi.getDocument().addDocumentListener(dlIdVehi);
        constrains3.gridx=1;
        constrains3.gridy=0;
        constrains3.weightx=1.0;
        constrains3.fill=GridBagConstraints.HORIZONTAL;
        jpVehFiltro.add(jtfFilIdVehi,constrains3);
        constrains3.weightx=0.0;
        
        lblFilMarcaVehi=new JLabel("Marca");
        constrains3.gridx=2;
        constrains3.gridy=0;
        constrains3.weightx=1.0;
        constrains3.fill=GridBagConstraints.HORIZONTAL;
        jpVehFiltro.add(lblFilMarcaVehi,constrains3);
        constrains3.weightx=0.0;
        
        jtfFilMarcaVehi=new JTextField();
        jtfFilMarcaVehi.getDocument().addDocumentListener(dlMarcaVehi);
        constrains3.gridx=3;
        constrains3.gridy=0;
        constrains3.weightx=1.0;
        constrains3.fill=GridBagConstraints.HORIZONTAL;
        jpVehFiltro.add(jtfFilMarcaVehi,constrains3);
        constrains3.weightx=0.0;
        
        lblFilModeloVehi=new JLabel("Modelo");
        constrains3.gridx=1;
        constrains3.gridy=1;
        constrains3.weightx=1.0;
        constrains3.fill=GridBagConstraints.HORIZONTAL;
        jpVehFiltro.add(lblFilModeloVehi,constrains3);        
        constrains3.weightx=0.0;
        
        jtfFilModeloVehi=new JTextField();
        jtfFilModeloVehi.getDocument().addDocumentListener(dlModeloVehi);
        constrains3.gridx=2;
        constrains3.gridy=1;
        constrains3.weightx=1.0;
        constrains3.fill=GridBagConstraints.HORIZONTAL;
        jpVehFiltro.add(jtfFilModeloVehi,constrains3);        
        constrains.weightx=0.0;     
        
        jbtLimpiarFilVehi=new JButton("Limpiar Filtros Vehiculos");
        jbtLimpiarFilVehi.addActionListener(alLimpiarFilVehi);
        constrains3.gridx=2;
        constrains3.gridy=0;
        constrains3.gridwidth=1;
        constrains3.anchor=GridBagConstraints.CENTER;
        jpBotonesFiltroVehi.add(jbtLimpiarFilVehi,constrains3);  
                
        constrains3.gridx=0;
        constrains3.gridy=2;
        constrains3.gridwidth=4;
        constrains3.weightx=1.0;
        jpVehFiltro.add(jpBotonesFiltroVehi,constrains3);
        constrains3.weightx=0.0;    
    }
    
    private void initEdiVehi()
    {
        GridBagConstraints constrains4=new GridBagConstraints();
        JPanel jpBotonesEdiVehi=new JPanel();
        jpBotonesEdiVehi.setLayout(new GridBagLayout());
        
        lblEdiIdVehi=new JLabel("Id Vehiculo");
        constrains4.gridx=0;
        constrains4.gridy=0;
        constrains4.weightx=1.0;
        jpVehEdicion.add(lblEdiIdVehi,constrains4);
        constrains4.weightx=0.0;
        
        jtfEdiIdVehi=new JTextField();
        //jtfEdiIdVehi.setText(Integer.toString(vehiculoDao.selectMaxId()+1));
        jtfEdiIdVehi.setEditable(false);
        constrains4.gridx=1;
        constrains4.gridy=0;
        constrains4.weightx=1.0;
        constrains4.fill=GridBagConstraints.HORIZONTAL;
        jpVehEdicion.add(jtfEdiIdVehi,constrains4);
        constrains4.weightx=0.0;
        
        lblEdiMarcaVehi=new JLabel("Marca");
        constrains4.gridx=2;
        constrains4.gridy=0;
        constrains4.weightx=1.0;
        constrains4.fill=GridBagConstraints.HORIZONTAL;
        jpVehEdicion.add(lblEdiMarcaVehi,constrains4);
        constrains4.weightx=0.0;
        
        jtfEdiMarcaVehi=new JTextField();
        constrains4.gridx=3;
        constrains4.gridy=0;
        constrains4.weightx=1.0;
        constrains4.fill=GridBagConstraints.HORIZONTAL;
        jpVehEdicion.add(jtfEdiMarcaVehi,constrains4);
        constrains4.weightx=0.0;
        
        lblEdiModelo=new JLabel("Modelo");
        constrains4.gridx=1;
        constrains4.gridy=1;
        constrains4.weightx=1.0;
        constrains4.fill=GridBagConstraints.HORIZONTAL;
        jpVehEdicion.add(lblEdiModelo,constrains4);        
        constrains4.weightx=0.0;
        
        jtfEdiModeloVehi=new JTextField();
        constrains4.gridx=2;
        constrains4.gridy=1;
        constrains4.weightx=1.0;
        constrains4.fill=GridBagConstraints.HORIZONTAL;
        jpVehEdicion.add(jtfEdiModeloVehi,constrains4);        
        constrains.weightx=0.0;     
        
        jbtAniadirVehi=new JButton("Añadir");
        jbtAniadirVehi.addActionListener(alAniadirVehi);
        constrains4.gridx=0;
        constrains4.gridy=0;
        constrains4.weightx=1.0;
        jpBotonesEdiVehi.add(jbtAniadirVehi,constrains4);
        constrains4.weightx=0.0;
        
        jbtActualizarVehi=new JButton("Actualizar");
        jbtActualizarVehi.addActionListener(alActualizarVehi);
        constrains4.gridx=1;
        constrains4.gridy=0;
        constrains4.weightx=1.0;
        jpBotonesEdiVehi.add(jbtActualizarVehi,constrains4);
        constrains4.weightx=0.0;
        
        jbtBorrarVehi=new JButton("Borrar");
        jbtBorrarVehi.addActionListener(alBorrarVehi);
        constrains4.gridx=2;
        constrains4.gridy=0;
        constrains4.weightx=1.0;
        jpBotonesEdiVehi.add(jbtBorrarVehi,constrains4);
        constrains4.weightx=0.0;
        
        jbtLimpiarEdiVehi=new JButton("Limpiar Edición");
        jbtLimpiarEdiVehi.addActionListener(alLimpiarEdiVehi);
        constrains4.gridx=3;
        constrains4.gridy=0;
        constrains4.weightx=1.0;
        jpBotonesEdiVehi.add(jbtLimpiarEdiVehi,constrains4);        
        constrains4.weightx=0.0;
        
        constrains4.gridx=0;
        constrains4.gridy=2;
        constrains4.gridwidth=4;
        jpVehEdicion.add(jpBotonesEdiVehi,constrains4);
        
        
        lblResulEdiVehi=new JLabel("Listo");
        constrains4.gridx=0;
        constrains4.gridy=3;
        constrains4.weightx=1.0;
        constrains4.gridwidth=3;
        jpVehEdicion.add(lblResulEdiVehi,constrains4);
    }
    
    private void initVehiculo()
    {
        vehiculoDao=new VehiculosDAO();
        GridBagConstraints constrains2=new GridBagConstraints();
        jpVehVisual=new JPanel();
        jpVehVisual.setLayout(new GridBagLayout());
        jpVehVisual.setBorder(javax.swing.BorderFactory.createTitledBorder("Visualización"));
        jspVisualVehi=new JScrollPane();
        resultado=vehiculoDao.selectAll();
        llenarTabVehi();
        constrains2.gridx=0;
        constrains2.gridy=0;
        constrains2.weightx=1.0;
        constrains2.weighty=1.0;
        constrains2.fill=GridBagConstraints.HORIZONTAL;
        jpVehVisual.add(jspVisualVehi,constrains2);
        jpVehiculos.add(jpVehVisual,constrains2);
        constrains2.weightx=0.0;
        constrains2.weighty=0.0;
        jpVehFiltro=new JPanel();
        jpVehFiltro.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));
        jpVehFiltro.setLayout(new GridBagLayout());
        initFiltroVehi();
        constrains2.gridx=0;
        constrains2.gridy=1;
        constrains2.weightx=1.0;
         constrains2.weighty=1.0;
        jpVehiculos.add(jpVehFiltro,constrains2);
        constrains2.weightx=0.0;
        jpVehEdicion=new JPanel();
        jpVehEdicion.setBorder(javax.swing.BorderFactory.createTitledBorder("Edicion"));
        jpVehEdicion.setLayout(new GridBagLayout());
        constrains2.gridx=0;
        constrains2.gridy=2;
        constrains2.weightx=1.0;
        constrains2.weighty=1.0;
        constrains2.fill=GridBagConstraints.HORIZONTAL;
        jpVehiculos.add(jpVehEdicion,constrains2);
        initEdiVehi();
    }
    
    private void initFiltroAlqui()
    {
        GridBagConstraints constrains6=new GridBagConstraints();
        JPanel jpBotonesFiltroAlqui=new JPanel();
        jpBotonesFiltroAlqui.setLayout(new GridBagLayout());
        
        lblFilIdCliAlqui=new JLabel("Id Cliente");
        constrains6.gridx=0;
        constrains6.gridy=0;
        constrains6.weightx=1.0;
        constrains6.fill=GridBagConstraints.HORIZONTAL;
        jpAlquiFiltro.add(lblFilIdCliAlqui,constrains6);
        constrains6.weightx=0.0;
        
        jtfFilIdCliAlqui=new JTextField();
        jtfFilIdCliAlqui.getDocument().addDocumentListener(dlIdCliAlqui);
        constrains6.gridx=1;
        constrains6.gridy=0;
        constrains6.weightx=1.0;
        constrains6.fill=GridBagConstraints.HORIZONTAL;
        jpAlquiFiltro.add(jtfFilIdCliAlqui,constrains6);
        constrains6.weightx=0.0;
        
        lblFilIdVehiAlqui=new JLabel("Id Vehiculo");
        constrains6.gridx=2;
        constrains6.gridy=0;
        constrains6.weightx=1.0;
        constrains6.fill=GridBagConstraints.HORIZONTAL;
        jpAlquiFiltro.add(lblFilIdVehiAlqui,constrains6);
        constrains6.weightx=0.0;
        
        jtfFilIdVehiAlqui=new JTextField();
        jtfFilIdVehiAlqui.getDocument().addDocumentListener(dlIdVehiAlqui);
        constrains6.gridx=3;
        constrains6.gridy=0;
        constrains6.weightx=1.0;
        constrains6.fill=GridBagConstraints.HORIZONTAL;
        jpAlquiFiltro.add(jtfFilIdVehiAlqui,constrains6);
        constrains6.weightx=0.0;
        
        lblFilMatriculaAlqui=new JLabel("Matricula");
        constrains6.gridx=0;
        constrains6.gridy=1;
        constrains6.weightx=1.0;
        constrains6.fill=GridBagConstraints.HORIZONTAL;
        jpAlquiFiltro.add(lblFilMatriculaAlqui,constrains6);        
        constrains6.weightx=0.0;
        
        jtfFilMatriculaAlqui=new JTextField();
        jtfFilMatriculaAlqui.getDocument().addDocumentListener(dlMatriculaAlqui);
        constrains6.gridx=1;
        constrains6.gridy=1;
        constrains6.weightx=1.0;
        constrains6.fill=GridBagConstraints.HORIZONTAL;
        jpAlquiFiltro.add(jtfFilMatriculaAlqui,constrains6);        
        constrains6.weightx=0.0;
        
        lblFilKilometrosAlqui=new JLabel("Kilometros");
        constrains6.gridx=2;
        constrains6.gridy=1;
        constrains6.weightx=1.0;
        constrains6.fill=GridBagConstraints.HORIZONTAL;
        jpAlquiFiltro.add(lblFilKilometrosAlqui,constrains6);
        
        jtfFilKilometrosAlqui=new JTextField();
        jtfFilKilometrosAlqui.getDocument().addDocumentListener(dlKilometrosAlqui);
        constrains6.gridx=3;
        constrains6.gridy=1;
        constrains6.weightx=1.0;
        constrains6.fill=GridBagConstraints.HORIZONTAL;
        jpAlquiFiltro.add(jtfFilKilometrosAlqui,constrains6);        
        constrains6.weightx=0.0;
        
        jbtLimpiarFilAlqui=new JButton("Limpiar Filtros");
        jbtLimpiarFilAlqui.addActionListener(alLimpiarFilAlqui);
        constrains6.gridx=2;
        constrains6.gridy=0;
        constrains6.gridwidth=1;
        constrains6.anchor=GridBagConstraints.CENTER;
        jpBotonesFiltroAlqui.add(jbtLimpiarFilAlqui,constrains6);  
        constrains6.weightx=0.0;
        
        constrains6.gridx=0;
        constrains6.gridy=2;
        constrains6.gridwidth=4;
        constrains6.weightx=1.0;
        jpAlquiFiltro.add(jpBotonesFiltroAlqui,constrains6);
        constrains.weightx=0.0;
    }
    
    private void initEdiAlqui()
    {
        GridBagConstraints constrains7=new GridBagConstraints();
        JPanel jpBotonesEdiAlqui=new JPanel();
        jpBotonesEdiAlqui.setLayout(new GridBagLayout());
        lblEdiIdCliAlqui=new JLabel("Id Cliente");
        constrains7.gridx=0;
        constrains7.gridy=0;
        constrains7.weightx=1.0;
        constrains7.fill=GridBagConstraints.HORIZONTAL;
        jpAlquiEdicion.add(lblEdiIdCliAlqui,constrains7);
        constrains7.weightx=0.0;
        
        jtfEdiIdCliAlqui=new JTextField();
        constrains7.gridx=1;
        constrains7.gridy=0;
        constrains7.weightx=1.0;
        constrains7.fill=GridBagConstraints.HORIZONTAL;
        jpAlquiEdicion.add(jtfEdiIdCliAlqui,constrains7);
        constrains7.weightx=0.0;
        
        lblEdiIdVehiAlqui=new JLabel("Id Vehiculo");
        constrains7.gridx=2;
        constrains7.gridy=0;
        constrains7.weightx=1.0;
        constrains7.fill=GridBagConstraints.HORIZONTAL;
        jpAlquiEdicion.add(lblEdiIdVehiAlqui,constrains7);
        constrains7.weightx=0.0;
        
        jtfEdiIdVehiAlqui=new JTextField();
        constrains7.gridx=3;
        constrains7.gridy=0;
        constrains7.weightx=1.0;
        constrains7.fill=GridBagConstraints.HORIZONTAL;
        jpAlquiEdicion.add(jtfEdiIdVehiAlqui,constrains7);
        constrains7.weightx=0.0;
        
        lblEdiMatriculaAlqui=new JLabel("Matricula");
        constrains7.gridx=0;
        constrains7.gridy=1;
        constrains7.weightx=1.0;
        constrains7.fill=GridBagConstraints.HORIZONTAL;
        jpAlquiEdicion.add(lblEdiMatriculaAlqui,constrains7);        
        constrains7.weightx=0.0;
        
        jtfEdiMatriculaAlqui=new JTextField();
        constrains7.gridx=1;
        constrains7.gridy=1;
        constrains7.weightx=1.0;
        constrains7.fill=GridBagConstraints.HORIZONTAL;
        jpAlquiEdicion.add(jtfEdiMatriculaAlqui,constrains7);        
        constrains7.weightx=0.0;
        
        lblEdiKilometrosAlqui=new JLabel("Kilometros");
        constrains7.gridx=2;
        constrains7.gridy=1;
        constrains7.weightx=1.0;
        constrains7.fill=GridBagConstraints.HORIZONTAL;
        jpAlquiEdicion.add(lblEdiKilometrosAlqui,constrains7);
        
        jtfEdiKilometrosAlqui=new JTextField();
        constrains7.gridx=3;
        constrains7.gridy=1;
        constrains7.weightx=1.0;
        constrains7.fill=GridBagConstraints.HORIZONTAL;
        jpAlquiEdicion.add(jtfEdiKilometrosAlqui,constrains7);        
        constrains7.weightx=0.0;
        
        jbtAniadirAlqui=new JButton("Añadir");
        jbtAniadirAlqui.addActionListener(alAniadirAlqui);
        constrains7.gridx=0;
        constrains7.gridy=0;
        constrains7.weightx=1.0;
        jpBotonesEdiAlqui.add(jbtAniadirAlqui,constrains7);
        constrains7.weightx=0.0;
        
        jbtActualizarAlqui=new JButton("Actualizar");
        jbtActualizarAlqui.addActionListener(alActualizarAlqui);
        constrains7.gridx=1;
        constrains7.gridy=0;
        constrains7.weightx=1.0;
        jpBotonesEdiAlqui.add(jbtActualizarAlqui,constrains7);
        constrains7.weightx=0.0;
        
        jbtBorrarAlqui=new JButton("Borrar");
        jbtBorrarAlqui.addActionListener(alBorrarAlqui);
        constrains7.gridx=2;
        constrains7.gridy=0;
        constrains7.weightx=1.0;
        jpBotonesEdiAlqui.add(jbtBorrarAlqui,constrains7);
        constrains7.weightx=0.0;
        
        jbtLimpiarEdiAlqui=new JButton("Limpiar Edición");
        jbtLimpiarEdiAlqui.addActionListener(alLimpiarEdiAlqui);
        constrains7.gridx=3;
        constrains7.gridy=0;
        constrains7.weightx=1.0;
        jpBotonesEdiAlqui.add(jbtLimpiarEdiAlqui,constrains7);        
        constrains7.weightx=0.0;
        
        constrains7.gridx=0;
        constrains7.gridy=2;
        constrains7.gridwidth=4;
        jpAlquiEdicion.add(jpBotonesEdiAlqui,constrains7);
        constrains7.weightx=0.0;
        
        lblResulEdiAlqui=new JLabel("Listo");
        constrains7.gridx=0;
        constrains7.gridy=4;
        constrains7.gridwidth=3;
        jpAlquiEdicion.add(lblResulEdiAlqui,constrains7);
    }
    
    private void initAlquileres()
    {
        alquilerDao=new AlquileresDAO();
        GridBagConstraints restricciones1=new GridBagConstraints();
        
        jpAlquiVisual=new JPanel();
        jpAlquiVisual.setLayout(new GridBagLayout());
        jpAlquiVisual.setBorder(javax.swing.BorderFactory.createTitledBorder("Visualización alquileres"));
        jspVisualAlqui=new JScrollPane();
        datosAlqui=new Object[0][0];
        jtVisualAlqui=new JTable(datosAlqui,columAlqui);
        jspVisualAlqui.setViewportView(jtVisualAlqui);
        resultado=alquilerDao.selectAll();
        llenarTabAlqui();
        restricciones1.gridx=0;
        restricciones1.gridy=0;
        restricciones1.weightx=1.0;
        restricciones1.weighty=1.0;
        restricciones1.fill=GridBagConstraints.HORIZONTAL;
        jpAlquiVisual.add(jspVisualAlqui,restricciones1);
        restricciones1.weightx=0.0;
        restricciones1.weighty=0.0;
        
        restricciones1.gridx=0;
        restricciones1.gridy=0;
        restricciones1.weightx=1.0;
        restricciones1.weighty=1.0;
        restricciones1.fill=GridBagConstraints.HORIZONTAL;
        jpAlquiler.add(jpAlquiVisual,restricciones1);
        restricciones1.weightx=0.0;
        restricciones1.weighty=0.0;
        
        jpAlquiFiltro=new JPanel();
        jpAlquiFiltro.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));
        jpAlquiFiltro.setLayout(new GridBagLayout());
        initFiltroAlqui();
        restricciones1.gridx=0;
        restricciones1.gridy=1;
        restricciones1.weightx=1.0;
        restricciones1.weighty=1.0;
        jpAlquiler.add(jpAlquiFiltro,restricciones1);
        restricciones1.weightx=0.0;
        restricciones1.weighty=0.0;
        
        jpAlquiEdicion=new JPanel();
        jpAlquiEdicion.setBorder(javax.swing.BorderFactory.createTitledBorder("Edicion"));
        jpAlquiEdicion.setLayout(new GridBagLayout());
        restricciones1.gridx=0;
        restricciones1.gridy=2;
        restricciones1.weightx=1.0;
        restricciones1.weighty=1.0;
        restricciones1.fill=GridBagConstraints.HORIZONTAL;
        jpAlquiler.add(jpAlquiEdicion,restricciones1);
        restricciones1.weightx=0.0;
        restricciones1.weighty=0.0;
        initEdiAlqui();       
    }
    
    private void initPestanias()
    {      
        jtpPestanias=new JTabbedPane();
        jpClientes=new JPanel();
        jpClientes.setLayout(new GridBagLayout());
        jtpPestanias.addTab("Clientes",jpClientes);
        jpVehiculos=new JPanel();
        jpVehiculos.setLayout(new GridBagLayout());
        jtpPestanias.addTab("Vehiculos",jpVehiculos);
        jpAlquiler=new JPanel();
        jpAlquiler.setLayout(new GridBagLayout());
        jtpPestanias.addTab("Alquileres",jpAlquiler);
        constrains.gridx=0;
        constrains.gridy=1;
        constrains.weightx=1.0;
        constrains.weighty=1.0;
        constrains.fill=GridBagConstraints.BOTH;
        getContentPane().add(jtpPestanias,constrains);
        constrains.weightx=0.0;
        constrains.weighty=0.0;
    }
    
    public void initComponents()
    {
        setTitle("Alquiler de vehiculos");
        setLayout(new GridBagLayout());
        constrains=new GridBagConstraints();
        setExtendedState(MAXIMIZED_BOTH);
        clienteDao=new ClientesDAO();
        initListeners();
        initMenu();
        initPestanias();
        initClientes(); 
        initVehiculo();
        initAlquileres();        
        addWindowListener(wlSalir);
    }
    
    public VehiculoAlquilado()
    {
        initComponents();
    }
    
    public static void main(String[] args) {
        VehiculoAlquilado vehiAlqui=new VehiculoAlquilado();
        vehiAlqui.setVisible(true);
    }
    
}
