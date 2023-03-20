package main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import modelo.Emp;
import util.SessionFactoryUtil;

public class Main {

	public static void main(String[] args) {
		SessionFactory sf = SessionFactoryUtil.getSessionFactory();
		
		Session session = sf.openSession();
		
		List<Emp> empleados = session.createQuery("select p.emps from Project p where p.projno=:projno").setParameter("projno", 1).list();
		
		for (Emp emp : empleados) {
			System.out.println(emp);
		}
		
		session.close();
	}
}
