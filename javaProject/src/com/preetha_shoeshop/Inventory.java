package com.preetha_shoeshop;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import com.ex4.Main;
public class Inventory {
	Statement stmt;
	 ResultSet rs;
	 Connection con;
	 String qry=null;
	 Dbcon db=new Dbcon();
	 int count=0;
	      Scanner sc=new Scanner(System.in);
	      List <shoeshop> list=new ArrayList <>();
	      Main m;
	      public void addP(shoeshop s) {
	     boolean sts=false;
	     try {
	     con=db.getDBConnection();
	     stmt=con.createStatement();
	     count=stmt.executeUpdate("insert into shoeshop(name,size,type,color) values('"+s.getname()+"','"+s.getsize()+"','"+s.gettype()+"','"+s.getcolor()+"')");
	     if(count==1)
	     sts=true;
	     else
	     throw new Exception();
	     }
	     catch(Exception ex) {
	     System.out.println(ex.getMessage());
	     }
	     //list.add(s);
	      }
	      public void update(shoeshop s) {
	     boolean sts=false;
	     try {
	     con=db.getDBConnection();
	     stmt=con.createStatement();
	     count=stmt.executeUpdate("update shoeshop set color='"+s.getcolor()+"' where name='"+s.getname()+"'");
	     if(count==1)
	     sts=true;
	     else
	     throw new Exception();
	     }catch(Exception ex) {
	     System.out.println(ex);
	     }
	     System.out.println("Successfully updated");
	      }
	      public shoeshop search(String idu) {
	    for(int i=0;i<list.size();i++) {
	    if(list.get(i).getid().equals(idu))
	    return list.get(i);
	    }
	return null;
	      }
	      public void Remove(String idr) {
	     boolean sts=false;
	     try {
	     con=db.getDBConnection();
	     stmt=con.createStatement();
	     count=stmt.executeUpdate("delete from shoeshop where id='"+idr+"'");
	     if(count==1)
	     sts=true;
	     }catch(Exception ex) {
	     System.out.println(ex);
	     }
	     /*for(int i=0;i<list.size();i++) {
	      if(list.get(i).getid().equals(idr))
	       list.remove(i);
	      }*/
	     System.out.println("Successfully deleted");
	      }
	      public void show() {
	     try {
	     con = db.getDBConnection();
	     stmt=(Statement) con.createStatement();
	     rs=((java.sql.Statement) stmt).executeQuery("select * from shoeshop");
	     while(rs.next())
	     System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3)+" "+rs.getString(4)+" "+rs.getString(5));
	     }
	     catch(Exception ex) {
	     System.out.println(ex.getMessage());
	     }
	     //System.out.println(list);
	      }
	      public void logout() {
	    System.out.println("Logged out");
	    m.main(null);
	    for(shoeshop s:list) {
	    System.out.println(s);
	    }
	      }

}
