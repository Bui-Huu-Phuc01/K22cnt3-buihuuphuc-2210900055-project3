package model;

public class bhp_Appointment {
    public int getBhp_appointment_id() {
		return bhp_appointment_id;
	}

	public void setBhp_appointment_id(int bhp_appointment_id) {
		this.bhp_appointment_id = bhp_appointment_id;
	}

	public String getBhp_customer_name() {
		return bhp_customer_name;
	}

	public void setBhp_customer_name(String bhp_customer_name) {
		this.bhp_customer_name = bhp_customer_name;
	}

	public String getBhp_customer_phone() {
		return bhp_customer_phone;
	}

	public void setBhp_customer_phone(String bhp_customer_phone) {
		this.bhp_customer_phone = bhp_customer_phone;
	}

	public String getBhp_customer_email() {
		return bhp_customer_email;
	}

	public void setBhp_customer_email(String bhp_customer_email) {
		this.bhp_customer_email = bhp_customer_email;
	}

	public String getBhp_appointment_date() {
		return bhp_appointment_date;
	}

	public void setBhp_appointment_date(String bhp_appointment_date) {
		this.bhp_appointment_date = bhp_appointment_date;
	}

	public String getBhp_appointment_time() {
		return bhp_appointment_time;
	}

	public void setBhp_appointment_time(String bhp_appointment_time) {
		this.bhp_appointment_time = bhp_appointment_time;
	}

	public String getBhp_notes() {
		return bhp_notes;
	}

	public void setBhp_notes(String bhp_notes) {
		this.bhp_notes = bhp_notes;
	}

	public String getBhp_created_at() {
		return bhp_created_at;
	}

	public void setBhp_created_at(String bhp_created_at) {
		this.bhp_created_at = bhp_created_at;
	}

	private int bhp_appointment_id;
    private String bhp_customer_name;
    private String bhp_customer_phone;
    private String bhp_customer_email;
    private String bhp_appointment_date;
    private String bhp_appointment_time;
    private String bhp_notes;
    private String bhp_created_at;

    // Constructor đầy đủ
    public bhp_Appointment(int bhp_appointment_id, String bhp_customer_name, String bhp_customer_phone,
                           String bhp_customer_email, String bhp_appointment_date, String bhp_appointment_time,
                           String bhp_notes, String bhp_created_at) {
        this.bhp_appointment_id = bhp_appointment_id;
        this.bhp_customer_name = bhp_customer_name;
        this.bhp_customer_phone = bhp_customer_phone;
        this.bhp_customer_email = bhp_customer_email;
        this.bhp_appointment_date = bhp_appointment_date;
        this.bhp_appointment_time = bhp_appointment_time;
        this.bhp_notes = bhp_notes;
        this.bhp_created_at = bhp_created_at;
    }
}