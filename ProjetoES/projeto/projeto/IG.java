package projeto;
import java.awt.BorderLayout;
import java.awt.Color;
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
	private JTable table_3;
	private JTable table_4;

	private ArrayList<String> lista;
	private JTable table_5;
	private JTable table_1;
	private JTable table_2;
	private ArrayList<String> listaTabela3;

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
		excel = new readExcelFile();
		excel.showExcel();
		lista = excel.getLista();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 917, 849);
		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		DefaultTableModel info = new DefaultTableModel();
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== btnProcurar) {

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

						for(int i=j; i<j+12; i++) {
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

						if(listaAux[8].equals("true") && listaAux[9].equals("true")) {
							countDCIiPLASMA++;
						}
						else if(listaAux[8].equals("false") && listaAux[9].equals("true")) {
							countDIIiPLASMA++;
						}
						else if(listaAux[8].equals("false") && listaAux[9].equals("false")) {
							countADCIiPLASMA++;
						}
						else if(listaAux[8].equals("true") && listaAux[9].equals("false")) {
							countADIIiPLASMA++;
						}

						if(listaAux[8].equals("true") && listaAux[10].equals("true")) {
							countDCIPMD++;
						}
						else if(listaAux[8].equals("false") && listaAux[10].equals("true")) {
							countDIIPMD++;
						}
						else if(listaAux[8].equals("false") && listaAux[10].equals("false")) {
							countADCIPMD++;
						}
						else if(listaAux[8].equals("true") && listaAux[10].equals("false")) {
							countADIIPMD++;
						}
					}

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

				}
			}
		});
		btnProcurar.setBounds(125, 6, 220, 29);
		contentPane.add(btnProcurar);

		JLabel lblLoc = new JLabel("LOC");
		lblLoc.setBounds(511, 35, 61, 16);
		contentPane.add(lblLoc);

		table_3 = new JTable();
		contentPane.add(table_3);
		table_4 = new JTable();
		contentPane.add(table_4);

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

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(557, 437, 273, 116);
		contentPane.add(scrollPane_1);


		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"AND", "OR"}));
		comboBox.setBounds(642, 131, 67, 26);
		contentPane.add(comboBox);

		table_5 = new JTable();
		scrollPane_1.setViewportView(table_5);

		DefaultTableModel info2 = new DefaultTableModel();
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				listaTabela3 = new ArrayList<String>();

				int loc = Integer.parseInt(textField.getText());
				int cyclo = Integer.parseInt(textField_1.getText());
				int atfd = Integer.parseInt(textField_2.getText());
				double laa = Double.parseDouble(textField_3.getText());
				String operadorLogico = comboBox.getSelectedItem().toString();
				boolean firstLine = false;	

				for(int j=0; j<lista.size()-12; j+=12) {
					String [] listaFinal = new String[3];

					if(!firstLine) {
						String s1 = "MethodID";
						String s2 = "is_long_method";
						String s3 = "is_feature_envy";

						info2.addColumn(s1);
						info2.addColumn(s2);
						info2.addColumn(s3);

						firstLine = true;
						listaTabela3.add(s1);
						listaTabela3.add(s2);
						listaTabela3.add(s3);
					}
					else {
						double locTable = Double.parseDouble(lista.get(j+4));
						double cycloTable = Double.parseDouble(lista.get(j+5));
						double atfdTable = Double.parseDouble(lista.get(j+6));
						double laaTable = Double.parseDouble(lista.get(j+7));

						Long_Method longmethod = new Long_Method(loc, cyclo);
						boolean is_long_method = longmethod.detetarDefeitos(locTable, cycloTable, operadorLogico);

						Feature_Envy featureEnvy = new Feature_Envy(atfd, laa);
						boolean is_feature_envy = featureEnvy.detetarDefeitos(atfdTable, laaTable, operadorLogico);

						listaFinal[0] = lista.get(j);
						listaFinal[1] = String.valueOf(is_long_method);
						listaFinal[2] = String.valueOf(is_feature_envy);

						listaTabela3.add(listaFinal[0]);
						listaTabela3.add(listaFinal[1]);
						listaTabela3.add(listaFinal[2]);

						info2.addRow(listaFinal);
					}				
				}

				int countDCIiPLASMA=0;
				int countDIIiPLASMA=0;
				int countADCIiPLASMA=0;
				int countADIIiPLASMA=0;
				int countDCIPMD=0;
				int countDIIPMD=0;
				int countADCIPMD=0;
				int countADIIPMD=0;

				for(int i=1; i<table.getRowCount(); i++) {

					if(info.getValueAt(i, 9).equals("true") && info2.getValueAt(i, 1).equals("true"))
						countDCIiPLASMA++;
					else if(info.getValueAt(i, 9).equals("false") && info2.getValueAt(i, 1).equals("true"))
						countDIIiPLASMA++;
					else if(info.getValueAt(i, 9).equals("false") && info2.getValueAt(i, 1).equals("false"))
						countADCIiPLASMA++;
					else if(info.getValueAt(i, 9).equals("true") && info2.getValueAt(i, 1).equals("false"))
						countADIIiPLASMA++;

					if(info.getValueAt(i, 10).equals("true") && info2.getValueAt(i, 1).equals("true"))
						countDCIPMD++;
					else if(info.getValueAt(i, 10).equals("false") && info2.getValueAt(i, 1).equals("true"))
						countDIIPMD++;
					else if(info.getValueAt(i, 10).equals("false") && info2.getValueAt(i, 1).equals("false"))
						countADCIPMD++;
					else if(info.getValueAt(i, 10).equals("true") && info2.getValueAt(i, 1).equals("false"))
						countADIIPMD++;

				}

				table_1.setModel(new DefaultTableModel(
						new Object[][] {
							{"DCI", "DII", "ADCI", "ADII"},
							{countDCIiPLASMA, countDIIiPLASMA, countADCIiPLASMA, countADIIiPLASMA},
						},
						new String[] {
								"New column", "New column", "New column", "New column"
						}
						));
				table_1.setBounds(61, 631, 335, 32);


				table_2.setModel(new DefaultTableModel(
						new Object[][] {
							{"DCI", "DII", "ADCI", "ADII"},
							{countDCIPMD, countDIIPMD, countADCIPMD, countADIIPMD},
						},
						new String[] {
								"New column", "New column", "New column", "New column"
						}
						));
				table_2.setBounds(499, 631, 342, 32);
			}

		});

		table_5.setModel(info2);

		btnIniciar.setBounds(628, 182, 115, 29);
		contentPane.add(btnIniciar);

		JLabel lblPmd = new JLabel("PMD");
		lblPmd.setBounds(541, 218, 69, 20);
		contentPane.add(lblPmd);

		JLabel lblIplasma = new JLabel("iPLASMA");
		lblIplasma.setBounds(541, 289, 69, 20);
		contentPane.add(lblIplasma);

		table_1 = new JTable();
		contentPane.add(table_1);

		JLabel lblPmdwithNew = new JLabel("PMD (with new thresholds)");
		lblPmdwithNew.setBounds(61, 603, 204, 20);
		contentPane.add(lblPmdwithNew);

		table_2 = new JTable();
		contentPane.add(table_2);

		JLabel lblIplasmawithNew = new JLabel("iPlasma (with new threasholds)");
		lblIplasmawithNew.setBounds(503, 603, 233, 20);
		contentPane.add(lblIplasmawithNew);

	}
}
