package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import uniandes.dpoo.swing.interfaz.principal.VentanaPrincipal;

@SuppressWarnings("serial")
public class VentanaAgregarRestaurante extends JFrame
{
    /**
     * El panel donde se editan los detalles del restaurante
     */
    private PanelEditarRestaurante panelDetalles;

    /**
     * El panel con los botones para agregar un restaurante o cerrar la ventana
     */
    private PanelBotonesAgregar panelBotones;

    /**
     * El panel para marcar la ubicación del restaurante
     */
    private PanelMapaAgregar panelMapa;

    /**
     * La ventana principal de la aplicación
     */
    private VentanaPrincipal ventanaPrincipal;

    public VentanaAgregarRestaurante( VentanaPrincipal principal )
    {
        this.ventanaPrincipal = principal;
        setLayout( new BorderLayout( ) );

        // Agrega el panel donde va a estar el mapa
        // TODO completar
        this.panelMapa = new PanelMapaAgregar();
        add(panelMapa, BorderLayout.NORTH);

        // Agrega en el sur un panel para los detalles del restaurante y para los botones
        // TODO completar
        this.panelDetalles = new PanelEditarRestaurante();
        this.panelBotones = new PanelBotonesAgregar(this);
        JPanel editFrame = new JPanel();
        editFrame.add(panelDetalles, BorderLayout.CENTER);
        editFrame.add(panelBotones, BorderLayout.SOUTH);
        
        add(editFrame, BorderLayout.CENTER);
        
        // Termina de configurar la ventana
        pack( );
        setLocationRelativeTo( null );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setSize( 470, 700 );
        setResizable( false );
        setVisible(true);
    }

    /**
     * Le pide al panelDetalles los datos del nuevo restaurante y se los envía a la ventana principal para que cree el nuevo restaurante, y luego cierra la ventana.
     */
    public void agregarRestaurante( )
    {
        // TODO completar
    	String nombre = panelDetalles.getNombre();
    	int calif = panelDetalles.getCalificacion();
    	boolean vis = panelDetalles.getVisitado();
    	
    	int[] coords = panelMapa.getCoordenadas();
    	
    	ventanaPrincipal.agregarRestaurante(nombre, calif, coords[0], coords[1], vis);
    }

    /**
     * Cierra la ventana sin crear un nuevo restaurante
     */
    public void cerrarVentana( )
    {
        dispose( );
    }

}
