package dao;

public class DAO implements IDAO {

	@Override
	public double getData() {
		// TODO Auto-generated method stub
		System.out.println("Version base de données ");
		double data=88;
		return data;
	}
	
	public void init() {
		System.out.println("Instanciation de Dao Impl");
	}

	
}

