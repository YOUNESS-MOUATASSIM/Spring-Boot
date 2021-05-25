package metier;

import dao.IDAO;


public class Metier implements IMetier {
		  private IDAO dao;
			@Override
			public double calcule() {
				// TODO Auto-generated method stub
				double data=dao.getData();
				double res=data*Math.PI;
				
				return res;
			}
			public void setDao(IDAO dao) {
				this.dao = dao;
				System.out.println("Injection des dependances");
			}
			
			public void init() {
				System.out.println("Instanciation de Metier Impl");
			}

		}

