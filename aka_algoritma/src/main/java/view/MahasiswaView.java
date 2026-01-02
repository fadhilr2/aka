package view;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import javax.swing.table.DefaultTableModel; 

public class MahasiswaView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField prodi;
	private JButton hapus;
	private JTextField nim;
	private JButton cari;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTable table;
	private DefaultTableModel model;
	private JButton update;
	private JButton simpan;
	

	/**
	 * Create the frame.
	 */
	public MahasiswaView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		firstName = new JTextField();
		firstName.setBounds(149, 23, 115, 18);
		contentPane.add(firstName);
		firstName.setColumns(10);
		
		simpan = new JButton();
		simpan.setText("Simpan");
		simpan.setBounds(34, 50, 84, 20);
		contentPane.add(simpan);
		
		lastName = new JTextField();
		lastName.setBounds(274, 23, 115, 18);
		contentPane.add(lastName);
		lastName.setColumns(10);
		
		prodi = new JTextField();
		prodi.setBounds(399, 23, 96, 18);
		contentPane.add(prodi);
		prodi.setColumns(10);
		
		hapus = new JButton("Hapus");
		hapus.setBounds(222, 51, 84, 20);
		contentPane.add(hapus);
		
		nim = new JTextField();
		nim.setBounds(34, 22, 96, 18);
		contentPane.add(nim);
		nim.setColumns(10);
		
		cari = new JButton("Cari");
		cari.setBounds(316, 50, 84, 20);
		contentPane.add(cari);
		
		lblNewLabel = new JLabel("First Name");
		lblNewLabel.setBounds(149, 1, 72, 12);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Last Name");
		lblNewLabel_1.setBounds(274, 1, 60, 12);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Prodi");
		lblNewLabel_2.setBounds(399, 1, 44, 12);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("NIM");
		lblNewLabel_3.setBounds(34, 0, 44, 12);
		contentPane.add(lblNewLabel_3);
		
		String[] columnNames = {"NIM", "First Name", "Last Name", "Prodi"};

		model = new DefaultTableModel(columnNames, 0);

		table = new JTable(model);
		
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(27, 80, 553, 215);
		
		contentPane.add(scrollpane);
		
		update = new JButton("Perbarui");
		update.setBounds(128, 51, 84, 20);
		contentPane.add(update);
		

	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getFirstName() {
		return firstName;
	}

	public JTextField getLastName() {
		return lastName;
	}

	public JTextField getProdi() {
		return prodi;
	}

	public JButton getHapus() {
		return hapus;
	}

	public JTextField getNim() {
		return nim;
	}

	public JButton getCari() {
		return cari;
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public JLabel getLblNewLabel_1() {
		return lblNewLabel_1;
	}

	public JLabel getLblNewLabel_2() {
		return lblNewLabel_2;
	}

	public JLabel getLblNewLabel_3() {
		return lblNewLabel_3;
	}

	public JTable getTable() {
		return table;
	}



	public DefaultTableModel getModel() {
		return model;
	}
	
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Informasi", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void highlightRow(int row) {
        table.setRowSelectionInterval(row, row);
        
        table.scrollRectToVisible(table.getCellRect(row, 0, true));
    }

    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Kesalahan", JOptionPane.ERROR_MESSAGE);
    }

	public JButton getSimpan() {
		return simpan;
	}

	public JButton getUpdate() {
		return update;
	}

	
	
	
	
}
