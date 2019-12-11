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

public class IG extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private readExcelFile excel;
	XSSFWorkbook wot;

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
		setBounds(100, 100, 905, 513);
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
					
					for(int j=0; j<lista.size()-12; j+=12) {
						String[] listaAux = new String[11];
						
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
					}
				}
			}
		});
		btnProcurar.setBounds(6, 6, 220, 29);
		contentPane.add(btnProcurar);
		
		JLabel lblLoc = new JLabel("LOC");
		lblLoc.setBounds(259, 35, 61, 16);
		contentPane.add(lblLoc);
		
		textField = new JTextField();
		textField.setBounds(299, 30, 70, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCyclo = new JLabel("CYCLO");
		lblCyclo.setBounds(381, 35, 61, 16);
		contentPane.add(lblCyclo);
		
		textField_1 = new JTextField();
		textField_1.setBounds(439, 30, 80, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAtfd = new JLabel("ATFD");
		lblAtfd.setBounds(259, 83, 61, 16);
		contentPane.add(lblAtfd);
		
		textField_2 = new JTextField();
		textField_2.setBounds(299, 78, 70, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblLaa = new JLabel("LAA");
		lblLaa.setBounds(397, 83, 45, 16);
		contentPane.add(lblLaa);
		
		textField_3 = new JTextField();
		textField_3.setBounds(439, 78, 80, 27);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 51, 228, 188);
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
		btnIniciar.setBounds(327, 133, 115, 29);
		contentPane.add(btnIniciar);
	}
}
