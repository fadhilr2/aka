package controller;
import view.MahasiswaView;


import repository.MahasiswaRepository;
import model.Mahasiswa;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.util.Collections;

public class MahasiswaController {
	private MahasiswaView v;
	private MahasiswaRepository r;
	private List<Mahasiswa> students;
	private DefaultTableModel model;
	
	public MahasiswaController(MahasiswaView v, MahasiswaRepository r) {

		super();
		this.v = v;
		this.r = r;
		
		r.initData();
		students = r.getData();
		model = v.getModel();
		
		for(Mahasiswa s : students) {
			Object[] rowData = {s.getNIM(), s.getFirst_name(), s.getLast_name(), s.getProdi()};
			model.addRow(rowData);
		}
		
		v.getCari().addActionListener(e -> {
			searchMahasiswa();
		});
		
		v.getSimpan().addActionListener(e -> {
			addMahasiswa();
		});
		
		v.getUpdate().addActionListener(e -> {
			updateMahasiswa();
		});
		
		v.getHapus().addActionListener(e -> {
			deleteMahasiswa();
		});
	}
	
	// TODO; binary search based on NIM, 
	// return array index if found, otherwise return -1
	public int search_iterative(long nim) {
	    int left = 0;
	    int right = students.size() - 1;

	    while (left <= right) {
	        int mid = left + (right - left) / 2;
	        long midNIM = students.get(mid).getNIM();

	        if (midNIM == nim) {
	            return mid;
	        } else if (midNIM < nim) {
	            left = mid + 1;
	        } else {
	            right = mid - 1;
	        }
	    }
	    return -1;
	}
	
	public int search_recursive(long nim, int left, int right) {
		if (left > right) {
		        return -1;
		    }
	    int mid = left + (right - left) / 2;
	    long midNIM = students.get(mid).getNIM();

	    if (midNIM == nim) {
	        return mid;
	    }else if (midNIM < nim) {
	        return search_recursive(nim, mid + 1, right);
	    }else {
	        return search_recursive(nim, left, mid - 1);}
	}
	
	//yg ini masih error g tau kenapa

	
	public Mahasiswa fetchInput() {
		String nimStr = v.getNim().getText();
		String first_name = v.getFirstName().getText();
		String last_name = v.getLastName().getText();
		String prodi = v.getProdi().getText();
		
		if(nimStr.isEmpty() || first_name.isEmpty() || 
				last_name.isEmpty() || prodi.isEmpty()) {
			return null;
		}
		long nim = Long.parseLong(nimStr);

		Mahasiswa m = new Mahasiswa(nim, first_name, last_name, prodi);
		
		return m;
	}
	
	public void addMahasiswa() {
		Mahasiswa data = fetchInput();
		if(data == null) {
			v.showErrorMessage("Input tidak valid");
			return;
		}
		
		
		
		Object[] rowData = {data.getNIM(), data.getFirst_name(), 
				data.getLast_name(), data.getFirst_name()};
		
		int idx = search_iterative(data.getNIM());
//		int idx = search_recursive(nim, 0, students.size()-1);
		if(idx != -1) {
			v.showErrorMessage("NIM " + data.getNIM() + " Sudah ada");
		} else {
			students.add(data);
			model.addRow(rowData);
			v.showMessage("Mahasiswa berhasil ditambahkan.");
			Collections.sort(students);

		}
        v.highlightRow(students.size()-1);

	}
	
	public void updateMahasiswa() {
		Mahasiswa data = fetchInput();
		if(data == null) {
			v.showErrorMessage("Input tidak valid");
			return;
		}
		
		int idx = search_iterative(data.getNIM());
//		int idx = search_recursive(nim, 0, students.size()-1);
		
		if(idx == -1) {
			v.showErrorMessage("Mahasiswa dengan nim " + data.getNIM() + " tidak ditemukan.");
		} else {
			model.setValueAt(data.getNIM(), idx, 0);
		    model.setValueAt(data.getFirst_name(), idx, 1);
		    model.setValueAt(data.getLast_name(), idx, 2);
		    model.setValueAt(data.getProdi(), idx, 3);
			v.showMessage("Mahasiswa dengan nim " + data.getNIM() + " berhasil diperbarui.");
			Collections.sort(students);

		}
	}
	
	public void deleteMahasiswa() {
		String nimStr = v.getNim().getText();
		if(nimStr.isEmpty()) {
			v.showErrorMessage("Input tidak valid");
			return;
		}
		long nim = Long.parseLong(nimStr);
		
		int idx = search_iterative(nim);
//		int idx = search_recursive(nim, 0, students.size()-1);
		
		if(idx == -1) {
			v.showErrorMessage("Mahasiswa dengan nim " + nimStr + " tidak ditemukan.");
		} else {
			students.remove(idx);
			model.removeRow(idx);
			v.showMessage("Mahasiswa berhasil dihapus");
			Collections.sort(students);
		}
	}
	
	public void searchMahasiswa() {
	    String text = v.getNim().getText();
	    if(text.isEmpty()) {
			v.showErrorMessage("Input tidak valid");
			return;
		}
	    long nim = Long.parseLong(text);

	    // pilih salah satu
	    int index = search_iterative(nim);
	    // int index = search_recursive(nim);

	    if (index != -1) {
	        Mahasiswa m = students.get(index);
	        v.showMessage(
	            "Data ditemukan:\n" +
	            "NIM: " + m.getNIM() + "\n" +
	            "Nama: " + m.getFirst_name() + " " + m.getLast_name() + "\n" +
	            "Prodi: " + m.getProdi()
	        );
	        v.highlightRow(index);
	    } else {
	        v.showErrorMessage("Data mahasiswa tidak ditemukan");
	    }
	}

}
