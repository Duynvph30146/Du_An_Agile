
package poly.edu.model;

import java.util.ArrayList;


public class UserQLLX {
    ArrayList<User> list=new ArrayList<>();
    public UserQLLX(){
        list.add(new User("Admin","12345"));
        list.add(new User("Admin2","12345"));
        list.add(new User("Admin3","12345"));
        list.add(new User("Admin4","12345"));
        list.add(new User("Admin5","12345"));
    }
    public boolean  checkLogin(String UserName,String matKhau){
        for (User u : list) {
            if(u.getTenDangNhap().equals(UserName)&& u.getMatKhau().equals(matKhau)){
                return  true;
            }           
        }
        return false;
    }   
}
