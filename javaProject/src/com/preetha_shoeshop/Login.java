package com.preetha_shoeshop;

public class Login {
	public String aname="Preetha";
    public String apwd="Pre@123";
   public boolean admin(user u) {
if(u.getLname().equals(aname) && u.getPassword().equals(apwd)) {
  return true;
}
else {
return false;  
}
   }
}
