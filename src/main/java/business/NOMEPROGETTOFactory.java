package business;

public abstract class NOMEPROGETTOFactory {
	private static NOMEPROGETTOFactory factory = new FileNOMEPROGETTOFactory();
	
	public static NOMEPROGETTOFactory getInstance() {
		return factory;
	}
	
//	public abstract UtenteService getUtenteService();
}
