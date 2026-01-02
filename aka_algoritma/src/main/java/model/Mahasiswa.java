package model;

public class Mahasiswa implements Comparable<Mahasiswa> {
	long NIM;
	String first_name;
	String last_name;
	String prodi;
	
	public Mahasiswa(long NIM, String first_name, String last_name, String prodi) {
		super();
		this.NIM = NIM;
		this.first_name = first_name;
		this.last_name = last_name;
		this.prodi = prodi;
	}

	@Override
	public int compareTo(Mahasiswa o) {
		// TODO Auto-generated method stub
		return Long.compare(this.NIM, o.NIM);
	}


	public long getNIM() {
		return NIM;
	}

	public void setNIM(long nIM) {
		NIM = nIM;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getProdi() {
		return prodi;
	}

	public void setProdi(String prodi) {
		this.prodi = prodi;
	}
	
	
}
