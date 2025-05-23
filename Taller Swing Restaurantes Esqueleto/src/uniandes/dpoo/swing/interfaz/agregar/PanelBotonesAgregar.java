package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelBotonesAgregar extends JPanel implements ActionListener
{
    /**
     * El comando utilizado para el botón que sirve para crear un nuevo restaurante
     */
    private static final String CREAR = "Crear";

    /**
     * El comando utilizado para el botón que sirve para cerrar la ventana sin crear un restaurante
     */
    private static final String CERRAR = "Cerrar";

    private JButton butNuevo;
    private JButton butCerrar;

    /**
     * La ventana principal de la aplicación
     */
    private VentanaAgregarRestaurante ventanaPrincipal;

    public PanelBotonesAgregar( VentanaAgregarRestaurante vPrincipal )
    {
        this.ventanaPrincipal = vPrincipal;

        setLayout( new FlowLayout( ) );

        // Agrega el botón para crear el restaurante
        // TODO completar
        this.butNuevo = new JButton(CREAR);
        butNuevo.setBounds(butNuevo.getX(), butNuevo.getX(), 5, 5);
        butNuevo.addActionListener(new ActionListener() {
        	public void actionPerformed( ActionEvent e ) {
        		ventanaPrincipal.agregarRestaurante( );
        		ventanaPrincipal.cerrarVentana( );
        	}
        });
        add(butNuevo);
        // Agrga el boton para cerrar la ventana
        // TODO completar
        this.butCerrar = new JButton(CERRAR);
        butCerrar.setBounds(butNuevo.getX(), butNuevo.getX(), 5, 5);
        butCerrar.addActionListener(new ActionListener() {
        	public void actionPerformed( ActionEvent e ) {
        		ventanaPrincipal.cerrarVentana( );
        	}
        });
        add(butCerrar);
    }

    @Override
    public void actionPerformed( ActionEvent e )
    {
        String comando = e.getActionCommand( );
        if( comando.equals( CREAR ) )
        {
            ventanaPrincipal.agregarRestaurante( );
        }
        else if( comando.equals( CERRAR ) )
        {
            ventanaPrincipal.cerrarVentana( );
        }
    }
}
