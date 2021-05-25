package pres;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

import dao.IDAO;
import metier.IMetier;

public class Presentation {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/*
      DAO dao =new DAO();
      Metier metier =new Metier();
      metier.setDao(dao);
      System.out.println(metier.calcule());
      */
		System.out.println("--------- Version base de donnees --------");
		Scanner sc=new Scanner(new File("config.txt"));
        
		String daoClassName=sc.nextLine();
		Class cDao=Class.forName(daoClassName);
		IDAO dao=(IDAO) cDao.newInstance();
		
		
		String metierClassName=sc.nextLine();
		Class cMetier=Class.forName(metierClassName);
		IMetier metier=(IMetier) cMetier.newInstance();
		
		Method m=cMetier.getMethod("setDao",IDAO.class);
		m.invoke(metier, dao);
		
		System.out.println(dao.getData());
		System.out.println("----------- Version web service -----------");
		
		daoClassName=sc.nextLine();
	    cDao=Class.forName(daoClassName);
	    dao=(IDAO) cDao.newInstance();
		
		
	    metierClassName=sc.nextLine();
		cMetier=Class.forName(metierClassName);
	    metier=(IMetier) cMetier.newInstance();
		
	    m=cMetier.getMethod("setDao",IDAO.class);
		m.invoke(metier, dao);
		
		System.out.println(dao.getData());
		
      
      
      
      
	}

}
