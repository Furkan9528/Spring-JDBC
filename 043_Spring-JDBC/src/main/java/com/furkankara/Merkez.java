package com.furkankara;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.furkankara.dao.PersonelDao;
import com.furkankara.model.Personel;
import com.furkankara.dao.impl.PersonelDaoImpl;


public class Merkez {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("SpringBeansConfig.xml");
		
		PersonelDaoImpl personelDao = context.getBean("personelDaoBean",PersonelDaoImpl.class);

		Personel personel = new Personel("Perihan","Donmez",26);
		
		personelDao.ekle(personel);
		
		
		//System.out.println(personelDao.idAra(1));

	//	System.out.println(personelDao.adiAra("furkan"));
		
		System.out.println(personelDao.soyadiAra("KARA"));
		
//		System.out.println(personelDao.tecrubeAra(10));
		
		context.close();
		
	}

}
