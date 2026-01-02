package repository;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collections;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import model.Mahasiswa;


public class MahasiswaRepository {
	List<Mahasiswa> data;
	
	public MahasiswaRepository() {
		super();
		this.data = new ArrayList<>();
	}
	
	public void initData() {
		
		InputStream inputStream = MahasiswaRepository.class.getClassLoader().getResourceAsStream("MOCK_DATA.csv");

        if (inputStream == null) {
            System.err.println("File not found!");
            return;
        }
        

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
        	reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
            	String[] values = line.split(",");
            	long nim = Long.parseLong(values[0]);
            	String first_name = values[1];
            	String last_name = values[2];
            	String prodi = values[3];
            	
            	data.add(new Mahasiswa(nim, first_name, last_name, prodi));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
		Collections.sort(data);
	}

	public List<Mahasiswa> getData() {
		return data;
	}
	
	
	public DefaultTableModel getTableModel() {
		String[] columnNames = {"NIM", "First Name", "Last Name", "Prodi"};
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		return model;
	}
	
}
