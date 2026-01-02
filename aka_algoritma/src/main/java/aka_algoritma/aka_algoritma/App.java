package aka_algoritma.aka_algoritma;
import view.MahasiswaView;
import controller.MahasiswaController;
import repository.MahasiswaRepository;

public class App 
{
    public static void main( String[] args )
    {
        MahasiswaRepository r = new MahasiswaRepository();
        MahasiswaView v = new MahasiswaView();
        
        new MahasiswaController(v, r);
		v.setVisible(true);

    }
}
