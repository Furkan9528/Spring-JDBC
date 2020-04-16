package com.furkankara.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.furkankara.dao.PersonelDao;
import com.furkankara.model.Personel;

public class PersonelDaoImpl implements PersonelDao {

	private Connection baglanti = null; 
	private String sqlKodu=null;
	private DataSource veriKaynagi;
	//---------------------------------
	
	
	public Connection getBaglanti() {
		return baglanti;
	}

	public void setBaglanti(Connection baglanti) {
		this.baglanti = baglanti;
	}

	public DataSource getVeriKaynagi() {
		return veriKaynagi;
	}

	public void setVeriKaynagi(DataSource veriKaynagi) {
		this.veriKaynagi = veriKaynagi;
	}

	
	@Override
	public void ekle(Personel personel) {
		
		sqlKodu = "INSERT INTO  test.personel  ( adi ,  soyadi ,  tecrube ) "
				+ "VALUES (? , ? , ?)";
	
		Connection baglanti = null; 
		
		try {
			baglanti = veriKaynagi.getConnection();
			
			//Statement parametren yoksa kullaniliyorsun
			PreparedStatement preparedStatement = baglanti.prepareStatement(sqlKodu);
			preparedStatement.setString(1, personel.getAdi());
			preparedStatement.setString(2, personel.getSoyadi());
			preparedStatement.setInt(3, personel.getTecrube());
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
		} catch (SQLException e) {
			System.out.println("HATA  :" + e);
			throw new RuntimeException();
		}finally {
			if(baglanti != null) {
				try {
					baglanti.close();
				} catch (SQLException e) {
				}
			}
		}
	
	}
	
	

	@Override
	public Personel idAra(int id) {
		sqlKodu = " SELECT * FROM test.personel WHERE id= ?";
	
		
		try {
			baglanti = veriKaynagi.getConnection();
			
			//Statement parametren yoksa kullaniliyorsun
			PreparedStatement preparedStatement = baglanti.prepareStatement(sqlKodu);
			preparedStatement.setInt(1,id);
			
			preparedStatement.executeQuery();
			
			Personel personel = null;
					
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				personel = new Personel(resultSet.getInt("id"),resultSet.getString("adi") , resultSet.getString("soyadi"), resultSet.getInt("tecrube"));
				
			}
			
			resultSet.close();
			preparedStatement.close();
			return personel;

			
			
		} catch (SQLException e) {
			throw new RuntimeException();
		}finally {
			if(baglanti != null) {
				try {
					baglanti.close();
				} catch (SQLException e) {
				}
			}
		}
	
	}

	@Override
	public Personel adiAra(String adi) {
		sqlKodu = " SELECT * FROM test.personel WHERE adi= ?";
	
		
		try {
			baglanti = veriKaynagi.getConnection();
			
			//Statement parametren yoksa kullaniliyorsun
			PreparedStatement preparedStatement = baglanti.prepareStatement(sqlKodu);
			preparedStatement.setString(1,adi);
			
			preparedStatement.executeQuery();
			
			Personel personel = null;
					
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				personel = new Personel(resultSet.getInt("id"),resultSet.getString("adi") , resultSet.getString("soyadi"), resultSet.getInt("tecrube"));
			}
			
			resultSet.close();
			preparedStatement.close();
			return personel;

			
			
		} catch (SQLException e) {
			throw new RuntimeException();
		}finally {
			if(baglanti != null) {
				try {
					baglanti.close();
				} catch (SQLException e) {
				}
			}
		}
	
	}

	@Override
	public Personel soyadiAra(String soyadi) {
		sqlKodu = " SELECT * FROM test.personel WHERE soyadi= ?";

		
		try {
			baglanti = veriKaynagi.getConnection();
			
			//Statement parametren yoksa kullaniliyorsun
			//Statement statement= baglanti.createStatement();
			
			PreparedStatement preparedStatement = baglanti.prepareStatement(sqlKodu);
			preparedStatement.setString(1,soyadi);
			
			preparedStatement.executeQuery();

			
			Personel personel=null;
					
			ResultSet resultSet = preparedStatement.executeQuery();
			//ResultSet resultSet = statement.executeQuery(sqlKodu);
		
			while(resultSet.next()) {
					personel = new Personel(resultSet.getInt("id"),resultSet.getString("adi") , resultSet.getString("soyadi"), resultSet.getInt("tecrube"));	
			}	
		
			resultSet.close();
			preparedStatement.close();
			
			return personel;
			
		} catch (SQLException e) {
			throw new RuntimeException();
		}finally {
			if(baglanti != null) {
				try {
					baglanti.close();
				} catch (SQLException e) {
				} 
			}
		}
	
	
	}

	@Override
	public Personel tecrubeAra(int tecrube) {
		sqlKodu = " SELECT * FROM test.personel WHERE tecrube= ?";
	
		
		try {
			baglanti = veriKaynagi.getConnection();
			
			//Statement parametren yoksa kullaniliyorsun
			PreparedStatement preparedStatement = baglanti.prepareStatement(sqlKodu);
			preparedStatement.setInt(1,tecrube);
			
			preparedStatement.executeQuery();
			
			Personel personel = null;
					
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
					personel = new Personel(resultSet.getInt("id"),resultSet.getString("adi") , resultSet.getString("soyadi"), resultSet.getInt("tecrube"));	

			}
			
			
			resultSet.close();
			preparedStatement.close();
			return personel;

			
			
		} catch (SQLException e) {
			throw new RuntimeException();
		}finally {
			if(baglanti != null) {
				try {
					baglanti.close();
				} catch (SQLException e) {
				}
			}
		}
		}

}
