package com.parcel;

import java.util.*;
import java.sql.*;

/**
 *
 * @author Group 9
 */

public class ParcelDao {
    public static Connection getConnection(){
        Connection con = null;
  
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/parcelsystem", "root", "admin");
        } 
        
        catch(Exception e){
            System.out.println(e);
        }
        return con;
    }

    public static int save(Parcel e) {
        int status = 0;
        
        try {
            Connection con = ParcelDao.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO parcel (noTracking, parcelWeight, parcelPrice, arrivedDate, parcelStatus, studid) VALUES (?,?,?,?,?,?)");

            ps.setString(1, e.getNoTracking());
            ps.setString(2, e.getParcelWeight());
            ps.setString(3, e.getParcelPrice());
            ps.setDate(4, e.getArrivedDate());
            ps.setString(5, e.getParcelStatus());
            ps.setString(6, e.getStudid());

            status = ps.executeUpdate();
            con.close();
        } 
        
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public static int update(Parcel e) {
        int status = 0;
        
        try {
            Connection con = ParcelDao.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE parcel SET parcelWeight=?, parcelPrice=?, arrivedDate=?, parcelStatus=?, studid=? WHERE noTracking=?");

            ps.setString(1, e.getParcelWeight());
            ps.setString(2, e.getParcelPrice());
            ps.setDate(3, e.getArrivedDate());
            ps.setString(4, e.getParcelStatus());
            ps.setString(5, e.getStudid());
            ps.setString(6, e.getNoTracking());
           
            status = ps.executeUpdate();
            con.close();
        } 
        
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

    public static int delete(String noTracking){       
        int status = 0;

        try{
            Connection con = ParcelDao.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM parcel WHERE noTracking=?");

            ps.setString(1, noTracking);
            
            status = ps.executeUpdate();
            con.close();
        }
        
        catch(Exception e){
            e.printStackTrace();
        }
        return status;
    }

    public static Parcel getParcelByNoTracking(String noTracking){       
        Parcel e = new Parcel();

        try{
            Connection con = ParcelDao.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM parcel WHERE noTracking=?");
            
            ps.setString(1, noTracking);           
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                e.setNoTracking(rs.getString("noTracking"));      
                e.setParcelWeight(rs.getString("parcelWeight"));
                e.setParcelPrice(rs.getString("parcelPrice"));
                e.setArrivedDate(rs.getDate("arrivedDate"));
                e.setParcelStatus(rs.getString("parcelStatus"));
                e.setStudid(rs.getString("studid"));
            }
            con.close(); 
        } 
        
        catch(Exception ex){
            ex.printStackTrace();
        }
        return e;
    }

    public static List <Parcel> getAllParcel(){
        List <Parcel> list = new ArrayList<Parcel>();

        try{
            Connection con = ParcelDao.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM parcel");

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Parcel e = new Parcel();
                
                e.setNoTracking(rs.getString("noTracking"));              
                e.setParcelWeight(rs.getString("parcelWeight"));
                e.setParcelPrice(rs.getString("parcelPrice"));
                e.setArrivedDate(rs.getDate("arrivedDate"));
                e.setParcelStatus(rs.getString("parcelStatus"));
                e.setStudid(rs.getString("studid"));
                
                list.add(e);
            }
            con.close();
        } 
        
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
    public static List <Parcel> getParcelByStudentId(String studid) {
        List <Parcel> list = new ArrayList<>();

        try {
            Connection con = ParcelDao.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM parcel WHERE studid=?");

            ps.setString(1, studid);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Parcel e = new Parcel();

                e.setNoTracking(rs.getString("noTracking"));
                e.setParcelWeight(rs.getString("parcelWeight"));
                e.setParcelPrice(rs.getString("parcelPrice"));
                e.setArrivedDate(rs.getDate("arrivedDate"));
                e.setParcelStatus(rs.getString("parcelStatus"));

                list.add(e);
            }
            con.close();
        } 
        
        catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}