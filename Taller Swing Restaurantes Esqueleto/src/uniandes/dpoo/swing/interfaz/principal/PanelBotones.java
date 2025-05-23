package uniandes.dpoo.swing.interfaz.principal;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelBotones extends JPanel implements ActionListener
{
    /**
     * El comando para el botón para crear un nuevo restaurante
     */
    private static final String NUEVO = "Nuevo";

    /**
     * El comando para el botón para ver todos los restaurantes en el mapa
     */
    private static final String VER = "Ver todos";

    private JButton butNuevo;
    private JButton butVerTodos;
    private VentanaPrincipal ventanaPrincipal;

    public PanelBotones( VentanaPrincipal vPrincipal )
    {
        this.ventanaPrincipal = vPrincipal;

        setLayout( new FlowLayout( ) );
        
        // Agrega el botón para crear un nuevo restaurante
        // TODO completar
        this.butNuevo = new JButton(NUEVO);
        butNuevo.addActionListener(new ActionListener() {
        	public void actionPerformed( ActionEvent e ) {
        		ventanaPrincipal.mostrarVetanaNuevoRestaurante( );
        	}
        });
        add(butNuevo);

        // Agrega el botón para ver todos los restaurantes
        // TODO completar
        this.butVerTodos = new JButton(VER);
        butVerTodos.addActionListener(new ActionListener() {
        	public void actionPerformed( ActionEvent e ) {
        		ventanaPrincipal.mostrarVentanaMapa( );
        	}
        });
        add(butVerTodos);
    }

    @Override
    public void actionPerformed( ActionEvent e )
    {
        String comando = e.getActionCommand( );
        if( comando.equals( NUEVO ) )
        {
            ventanaPrincipal.mostrarVetanaNuevoRestaurante( );
        }
        else if( comando.equals( VER ) )
        {
            ventanaPrincipal.mostrarVentanaMapa( );
        }
    }
}
