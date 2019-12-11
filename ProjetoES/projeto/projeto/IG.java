package projeto;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollBar;

public class IG extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private readExcelFile excel;
	XSSFWorkbook wot;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IG frame = new IG();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IG() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DefaultTableModel info = new DefaultTableModel();
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== btnProcurar) {
					readExcelFile r = new readExcelFile();
					r.showExcel();
					ArrayList<String> lista = r.getLista();
					System.out.println(lista.size());
					
					boolean firstLine = false;
					
					int countDCIiPLASMA=0;
					int countDIIiPLASMA=0;
					int countADCIiPLASMA=0;
					int countADIIiPLASMA=0;
					int countDCIPMD=0;
					int countDIIPMD=0;
					int countADCIPMD=0;
					int countADIIPMD=0;
					
					for(int j=0; j<lista.size()-12; j+=12) {
						String[] listaAux = new String[12];
						
						for(int i=j; i<j+11; i++) {
							listaAux[i-j] = lista.get(i);
						}
						if(!firstLine) {
							for(String s : listaAux) {
								info.addColumn(s);
							}
							firstLine = true;
						}
						else {
							info.addRow(listaAux);
						}
						
						if(listaAux[8].equals("VERDADEIRO") && listaAux[9].equals("VERDADEIRO")) {
							countDCIiPLASMA++;
						}
						else if(listaAux[8].equals("VERDADEIRO") && listaAux[10].equals("VERDADEIRO")) {
							countDCIPMD++;
						}
						else if(listaAux[8].equals("FALSO") && listaAux[9].equals("VERDADEIRO")) {
							countDIIiPLASMA++;
						}
						else if(listaAux[8].equals("FALSO") && listaAux[10].equals("VERDADEIRO")) {
							countDIIPMD++;
						}
						else if(listaAux[8].equals("FALSO") && listaAux[9].equals("FALSO")) {
							countADCIiPLASMA++;
						}
						else if(listaAux[8].equals("FALSO") && listaAux[10].equals("FALSO")) {
							countADCIPMD++;
						}
						else if(listaAux[8].equals("VERDADEIRO") && listaAux[9].equals("FALSO")) {
							countADIIiPLASMA++;
						}
						else if(listaAux[8].equals("VERDADEIRO") && listaAux[10].equals("FALSO")) {
							countADIIPMD++;
						}
					}
					
					table_3 = new JTable();
					table_3.setModel(new DefaultTableModel(
						new Object[][] {
							{"DCI", "DII", "ADCI", "ADII"},
							{countDCIiPLASMA, countDIIiPLASMA, countADCIiPLASMA, countADIIiPLASMA},
						},
						new String[] {
							"New column", "New column", "New column", "New column"
						}
					));
					table_3.setBounds(541, 247, 306, 32);
					contentPane.add(table_3);
					
					table_4 = new JTable();
					table_4.setModel(new DefaultTableModel(
						new Object[][] {
							{"DCI", "DII", "ADCI", "ADII"},
							{countDCIPMD, countDIIPMD, countADCIPMD, countADIIPMD},
						},
						new String[] {
							"New column", "New column", "New column", "New column"
						}
					));
					table_4.setBounds(541, 314, 306, 32);
					contentPane.add(table_4);
					
				}
			}
		});
		btnProcurar.setBounds(125, 6, 220, 29);
		contentPane.add(btnProcurar);
		
//		JComboBox comboBox = new JComboBox();
//		comboBox.setEditable(true);
//		comboBox.setSelectedIndex(0);
//		comboBox.setBounds(609, 140, 133, 26);
//		contentPane.add(comboBox);
		
		JLabel lblLoc = new JLabel("LOC");
		lblLoc.setBounds(511, 35, 61, 16);
		contentPane.add(lblLoc);
		
		textField = new JTextField();
		textField.setBounds(579, 30, 70, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCyclo = new JLabel("CYCLO");
		lblCyclo.setBounds(664, 35, 61, 16);
		contentPane.add(lblCyclo);
		
		textField_1 = new JTextField();
		textField_1.setBounds(738, 30, 80, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAtfd = new JLabel("ATFD");
		lblAtfd.setBounds(511, 83, 61, 16);
		contentPane.add(lblAtfd);
		
		textField_2 = new JTextField();
		textField_2.setBounds(579, 78, 70, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblLaa = new JLabel("LAA");
		lblLaa.setBounds(680, 83, 45, 16);
		contentPane.add(lblLaa);
		
		textField_3 = new JTextField();
		textField_3.setBounds(738, 78, 80, 27);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 51, 480, 371);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(info);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int loc = Integer.parseInt(textField.getText());
				int cyclo = Integer.parseInt(textField_1.getText());
				int atfd = Integer.parseInt(textField_2.getText());
				double laa = Double.parseDouble(textField_3.getText());
				
			}
		});
		btnIniciar.setBounds(628, 182, 115, 29);
		contentPane.add(btnIniciar);
		
//		table_3 = new JTable();
//		table_3.setModel(new DefaultTableModel(
//			new Object[][] {
//				{"DCI", "DII", "ADCI", "ADII"},
//				{null, null, null, null},
//			},
//			new String[] {
//				"New column", "New column", "New column", "New column"
//			}
//		));
//		table_3.setBounds(541, 247, 306, 32);
//		contentPane.add(table_3);
//		
//		table_4 = new JTable();
//		table_4.setModel(new DefaultTableModel(
//			new Object[][] {
//				{"DCI", "DII", "ADCI", "ADII"},
//				{null, null, null, null},
//			},
//			new String[] {
//				"New column", "New column", "New column", "New column"
//			}
//		));
//		table_4.setBounds(541, 314, 306, 32);
//		contentPane.add(table_4);
		
		JLabel lblPmd = new JLabel("PMD");
		lblPmd.setBounds(541, 218, 69, 20);
		contentPane.add(lblPmd);
		
		JLabel lblIplasma = new JLabel("iPLASMA");
		lblIplasma.setBounds(541, 289, 69, 20);
		contentPane.add(lblIplasma);
	}
	
//	public int contadorDefeitos(String tool, String longMethod) {
//		
//		
//		readExcelFile r = new readExcelFile();
//		r.showExcel();
//		ArrayList<String> lista = r.getLista();
//		
//		for(String s : lista) {
//			
//			if(tool.equals(longMethod)) {
////				int
//			}
//		}
//		
//	}
}
