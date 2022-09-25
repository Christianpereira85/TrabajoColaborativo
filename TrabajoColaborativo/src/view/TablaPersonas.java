package view;

import java.awt.Dimension;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dto.PersonaBO;
import model.Persona;

public class TablaPersonas {
	public void mostrar() {
		PersonaBO personaBO = new PersonaBO();
        JFrame frame = new JFrame("Mostrar");

        DefaultTableModel modelo = new DefaultTableModel();

        final JTable table = new JTable(modelo);

        final String[] columnNames = {"Rol", "Primer Nombre", "Segundo Nombre", "Primer Apellido", "Segundo Apellido", "Documento", "Fecha Nacimiento", "Email"};

        for (int column = 0; column < columnNames.length; column ++) {
            modelo.addColumn(columnNames[column]);
        }

        Object[] fila = new Object[columnNames.length];

        LinkedList<Persona> todasPersonas = personaBO.findAll();

        for (int i=0; i<todasPersonas.size(); i++) {
            String nombre=todasPersonas.get(i).getNombre1();
            String segundoNombre=todasPersonas.get(i).getNombre2();
            String apellido=todasPersonas.get(i).getApellido1();
            String segundoApellido = todasPersonas.get(i).getApellido2();
            String documento=todasPersonas.get(i).getDocumento();
            String fechaNacimiento = todasPersonas.get(i).getFechaNac();
            String mail = todasPersonas.get(i).getMail();
            String rol = todasPersonas.get(i).getRol().name();
            
            fila[0] = rol;
            fila[1] = nombre;
            fila[2] = segundoNombre;
            fila[3] = apellido;
            fila[4] = segundoApellido;
            fila[5] = documento;
            fila[6] = fechaNacimiento;
            fila[7] = mail;

            modelo.addRow(fila);
        }

        table.setPreferredScrollableViewportSize(new Dimension(800,500));

        JScrollPane scrollPane = new JScrollPane(table);

        JPanel panel = new JPanel();

        panel.add(scrollPane);

        frame.add(scrollPane);

        frame.pack();

        frame.setVisible(true);

    }

}
