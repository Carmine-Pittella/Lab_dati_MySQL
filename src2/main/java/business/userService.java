package business;

import domain.AmministratoreAziendale;
import domain.Studente;
import domain.TutorAziendale;
import domain.TutorUniversitario;

public interface userService {
	

	void creaStudente(Studente s) throws Exception;
	
	void creaTutorAziendale (TutorAziendale ta) throws Exception;
	
	void creaTutorUniversitario (TutorUniversitario tu) throws Exception;
	
	void creaAdminAziendale (AmministratoreAziendale aa) throws Exception;

}
