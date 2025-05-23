package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelEditarRestaurante extends JPanel
{
    /**
     * El campo para que el usuario ingrese el nombre del restaurante
     */
    private JTextField txtNombre;

    /**
     * Un selector (JComboBox) para que el usuario seleccione la calificación (1 a 5) del restaurante
     */
    private JComboBox<String> cbbCalificacion;

    /**
     * Un selector (JComboBox) para que el usuario indique si ya visitó el restaurante o no
     */
    private JComboBox<String> cbbVisitado;

    public PanelEditarRestaurante( )
    {
        // Crea el campo para el nombre con una etiqueta al frente
        // TODO completar
    	this.txtNombre = new JTextField(25);
    	txtNombre.setHorizontalAlignment(JTextField.LEFT);
    	JLabel labNombre = new JLabel("Nombre:     ");
    	JPanel nomLayout = new JPanel(new FlowLayout(FlowLayout.LEFT));
    	nomLayout.add(labNombre);
    	nomLayout.add(txtNombre);

        // Crea el selector para la calificación con una etiqueta al frente
        // TODO completar
    	this.cbbCalificacion = new JComboBox<String>();
    	for(int i = 1; i<6; i++) {
    		cbbCalificacion.addItem(String.valueOf(i) + "          ");
    	}
    	JLabel labCal = new JLabel("Calificacion:     ");
    	JPanel calLayout = new JPanel(new FlowLayout(FlowLayout.LEFT));
    	calLayout.add(labCal);
    	calLayout.add(cbbCalificacion);
    	

        // Crea el selector para indicar si ya ha sido visitado, con una etiqueta al frente
        // TODO completar
    	this.cbbVisitado = new JComboBox<String>();
    	cbbVisitado.addItem("Si          ");
    	cbbVisitado.addItem("No          ");
    	JLabel labVis = new JLabel("Visitado:     ");
    	JPanel visLayout = new JPanel(new FlowLayout(FlowLayout.LEFT));
    	visLayout.add(labVis);
    	visLayout.add(cbbVisitado);
    	

        // Agregar todos los elementos al panel
        // TODO completar
    	setLayout(new BorderLayout());
    	add(nomLayout, BorderLayout.NORTH);
    	add(calLayout);
    	add(visLayout, BorderLayout.SOUTH);
    }

    /**
     * Indica si en el selector se seleccionó la opción que dice que el restaurante fue visitado
     * @return
     */
    public boolean getVisitado( )
    {
        // TODO completar
    	String visitado = (String)cbbVisitado.getSelectedItem();
    	boolean vis = false;
    	if(visitado.contains("Si")) {
    		vis = true;
    	}
        return vis;
    }

    /**
     * Indica la calificación marcada en el selector
     * @return
     */
    public int getCalificacion( )
    {
        String calif = ( String )cbbCalificacion.getSelectedItem( );
        String califRedux = calif.substring(0, 1);
        return Integer.parseInt( califRedux );
    }

    /**
     * Indica el nombre digitado para el restaurante
     * @return
     */
    public String getNombre( )
    {
        // TODO completar
        return txtNombre.getText();
    }
}
