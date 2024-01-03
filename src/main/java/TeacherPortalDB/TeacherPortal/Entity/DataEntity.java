package TeacherPortalDB.TeacherPortal.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class DataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username;
    private String emailid;
    private String mobile;
    private String message;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public DataEntity(Long id, String username, String emailid, String mobile, String message) {
		super();
		this.id = id;
		this.username = username;
		this.emailid = emailid;
		this.mobile = mobile;
		this.message = message;
	}
	public DataEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "DataEntity [id=" + id + ", username=" + username + ", emailid=" + emailid + ", mobile=" + mobile
				+ ", message=" + message + "]";
	}
    
	
    
    
    // Constructors, getters, setters...
}


