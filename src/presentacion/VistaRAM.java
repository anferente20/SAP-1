package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class VistaRAM extends JFrame {
				
	private ControlVistaRAM control;
    private final Modelo modelo;
    private JTable table;
    private JButton btnAceptar;
    private JButton btnBorrar;
    private JButton btnCargar;    
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modelo modelo1 = new Modelo();
					VistaRAM frame = new VistaRAM(modelo1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public VistaRAM(Modelo modelo) {		
		this.modelo = modelo;
        initComponents();
        capturaEventos();		
	}
	
	public void initComponents() {
		JLabel lblRow_0;
		JLabel lblRow_1;
		JLabel lblRow_2;
		JLabel lblRow_3;
		JLabel lblRow_4;
		JLabel lblRow_5;
		JLabel lblRow_6;
		JLabel lblRow_7;
		JLabel lblRow_8;
		JLabel lblRow_9;
		JLabel lblRow_10;
		JLabel lblRow_11;
		JLabel lblRow_12;
		JLabel lblRow_13;
		JLabel lblRow_14;
		JLabel lblRow_15;
		JPanel contentPane;
		JPanel contentPane2;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		this.setTitle("RAM");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 600, 550);				
		this.setContentPane(contentPane);
		lblRow_0 = new JLabel("0");
		lblRow_0.setBounds(15, 46, 23, 14);
		lblRow_0.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblRow_1 = new JLabel("1");
		lblRow_1.setBounds(15, 71, 23, 14);
		lblRow_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblRow_2 = new JLabel("2");
		lblRow_2.setBounds(15, 98, 23, 14);
		lblRow_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblRow_3 = new JLabel("3");
		lblRow_3.setBounds(15, 123, 23, 14);
		lblRow_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblRow_4 = new JLabel("4");
		lblRow_4.setBounds(15, 148, 23, 14);
		lblRow_4.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblRow_5 = new JLabel("5");
		lblRow_5.setBounds(15, 173, 23, 14);
		lblRow_5.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblRow_6 = new JLabel("6");
		lblRow_6.setBounds(15, 198, 23, 14);
		lblRow_6.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblRow_7 = new JLabel("7");
		lblRow_7.setBounds(15, 223, 23, 14);
		lblRow_7.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblRow_8 = new JLabel("8");
		lblRow_8.setBounds(15, 248, 23, 14);
		lblRow_8.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblRow_9 = new JLabel("9");
		lblRow_9.setBounds(15, 273, 23, 14);
		lblRow_9.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblRow_10 = new JLabel("10");
		lblRow_10.setBounds(15, 298, 23, 14);
		lblRow_10.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblRow_11 = new JLabel("11");
		lblRow_11.setBounds(15, 323, 23, 14);
		lblRow_11.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblRow_12 = new JLabel("12");
		lblRow_12.setBounds(15, 348, 23, 14);
		lblRow_12.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblRow_13 = new JLabel("13");
		lblRow_13.setBounds(15, 373, 23, 14);
		lblRow_13.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblRow_14 = new JLabel("14");
		lblRow_14.setBounds(15, 398, 23, 14);
		lblRow_14.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblRow_15 = new JLabel("15");
		lblRow_15.setBounds(15, 423, 23, 14);
		lblRow_15.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		table = new JTable();
		table.setBounds(50, 40, 500, 400);
		table.setRowHeight(25);		
		String[] columnNames = { "7", "6", "5", "4", "3", "2", "1", "0" };		
		table.setModel(new DefaultTableModel(columnNames, 16));								
		contentPane2 = new JPanel( new BorderLayout());		
		contentPane2.setSize(500, 425);
		contentPane2.setLocation(50, 15);
		contentPane2.add( table.getTableHeader(), BorderLayout.NORTH );
		contentPane2.add( table, BorderLayout.CENTER );
		contentPane.add(contentPane2);
		contentPane.add(lblRow_0);
		contentPane.add(lblRow_1);
		contentPane.add(lblRow_2);
		contentPane.add(lblRow_3);
		contentPane.add(lblRow_4);
		contentPane.add(lblRow_5);
		contentPane.add(lblRow_6);
		contentPane.add(lblRow_7);
		contentPane.add(lblRow_8);
		contentPane.add(lblRow_9);
		contentPane.add(lblRow_10);
		contentPane.add(lblRow_11);
		contentPane.add(lblRow_12);
		contentPane.add(lblRow_13);
		contentPane.add(lblRow_14);
		contentPane.add(lblRow_15);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(15, 487, 80, 23);
		contentPane.add(btnAceptar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(470, 487, 80, 23);
		contentPane.add(btnBorrar);
		
		btnCargar = new JButton("Cargar Programa");
		btnCargar.setBounds(205, 487, 160, 23);
		contentPane.add(btnCargar);
	}
	
	public ControlVistaRAM getControl() {
        if(control == null){
            control = new ControlVistaRAM(this);
        }
        return control;
    }
	
	private void capturaEventos() {        
        btnAceptar.addActionListener(getControl());
        btnBorrar.addActionListener(getControl());        
        btnCargar.addActionListener(getControl());           
    }

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	public JButton getBtnCargar() {
		return btnCargar;
	}
	
}
