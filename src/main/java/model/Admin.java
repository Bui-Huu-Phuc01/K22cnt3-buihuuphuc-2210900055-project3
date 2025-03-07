package model;

import java.sql.Timestamp;

public class Admin {
    private int bhp_admin_id;
    private String bhp_username;
    private String bhp_password;
    private Timestamp bhp_created_at; // Có thể sử dụng nếu cần hiển thị thời gian tạo tài khoản

    public Admin() {
    }

    public Admin(int bhp_admin_id, String bhp_username, String bhp_password, Timestamp bhp_created_at) {
        this.bhp_admin_id = bhp_admin_id;
        this.bhp_username = bhp_username;
        this.bhp_password = bhp_password;
        this.bhp_created_at = bhp_created_at;
    }

    public int getbhp_admin_id() {
        return bhp_admin_id;
    }
    public void setbhp_admin_id(int bhp_admin_id) {
        this.bhp_admin_id = bhp_admin_id;
    }

    public String getbhp_username() {
        return bhp_username;
    }
    public void setbhp_username(String bhp_username) {
        this.bhp_username = bhp_username;
    }

    public String getbhp_password() {
        return bhp_password;
    }
    public void setbhp_password(String bhp_password) {
        this.bhp_password = bhp_password;
    }

    public Timestamp getbhp_created_at() {
        return bhp_created_at;
    }
    public void setbhp_created_at(Timestamp bhp_created_at) {
        this.bhp_created_at = bhp_created_at;
    }
}