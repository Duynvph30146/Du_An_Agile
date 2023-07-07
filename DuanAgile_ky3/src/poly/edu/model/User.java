
package poly.edu.model;


public class User {
    private String tenDangNhap;
    private String matKhau;

    public User() {
    }
    
    public User(String tenDangNhap, String matKhau) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    @Override
    public String toString() {
        return "User{" + "tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau + '}';
    }
           
}
