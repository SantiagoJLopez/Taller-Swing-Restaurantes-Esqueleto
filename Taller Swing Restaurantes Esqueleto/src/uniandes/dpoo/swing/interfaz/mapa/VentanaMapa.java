package uniandes.dpoo.swing.interfaz.mapa;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import uniandes.dpoo.swing.interfaz.principal.VentanaPrincipal;
import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class VentanaMapa extends JFrame implements ActionListener
{
    /**
     * El comando para reconocer al radio que muestra sólo los restaurantes visitados
     */
    private static final String VISITADOS = "Visitados";

    /**
     * El comando para reconocer al radio que muestra todos los restaurantes
     */
    private static final String TODOS = "Todos";

    /**
     * El panel con el mapa
     */
    private PanelMapaVisualizar panelMapa;

    /**
     * El radio button para hacer que se muestren todos los restaurantes. Si este está activo, radioVisitados debe estar inactivo.
     */
    private JRadioButton radioTodos;

    /**
     * El radio button para hacer que se muestren sólo los restaurantes visitados. Si este está activo, radioTodos debe estar inactivo.
     */
    private JRadioButton radioVisitados;

    /**
     * La referencia a la ventana principal
     */
    private VentanaPrincipal ventanaPrincipal;

    public VentanaMapa( VentanaPrincipal ventanaPrincipal, List<Restaurante> restaurantes )
    {
        this.ventanaPrincipal = ventanaPrincipal;

        // Agrega el panel donde se muestra el mapa
        // TODO completar
        this.panelMapa = new PanelMapaVisualizar(ventanaPrincipal.getRestaurantes(true));
        add(panelMapa, BorderLayout.CENTER);

        // Agrega el panel con los RadioButtons y los configura
        // TODO completar
        ButtonGroup gBotones = new ButtonGroup();
        JPanel pBotones = new JPanel();
        
        this.radioTodos = new JRadioButton(TODOS);
        radioTodos.addActionListener(new ActionListener() {
        	public void actionPerformed( ActionEvent e ) {
        		panelMapa.actualizarMapa( ventanaPrincipal.getRestaurantes( true ) );
        		repaint();
        	}
        });
        gBotones.add(radioTodos);
        pBotones.add(radioTodos);
        
        this.radioVisitados = new JRadioButton(VISITADOS);
        radioVisitados.addActionListener(new ActionListener() {
        	public void actionPerformed( ActionEvent e ) {
        		panelMapa.actualizarMapa( ventanaPrincipal.getRestaurantes( false ) );
        		repaint();
        	}
        });
        gBotones.add(radioVisitados);
        pBotones.add(radioVisitados);
        
        add(pBotones, BorderLayout.SOUTH);

        // Termina de configurar la ventana y la muestra
        pack( );
        setResizable( false );
        setSize(480, 580);
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        setLocationRelativeTo( null );
        setVisible(true);
    }

    @Override
    public void actionPerformed( ActionEvent e )
    {
        String comando = e.getActionCommand( );
        if( TODOS.equals( comando ) )
        {
            panelMapa.actualizarMapa( ventanaPrincipal.getRestaurantes( true ) );
        }
        else if( VISITADOS.equals( comando ) )
        {
            panelMapa.actualizarMapa( ventanaPrincipal.getRestaurantes( false ) );
        }
    }

}
