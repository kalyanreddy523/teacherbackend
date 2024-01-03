package TeacherPortalDB.TeacherPortal.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import TeacherPortalDB.TeacherPortal.Entity.DataEntity;
import TeacherPortalDB.TeacherPortal.Repository.ContactFormRepo;

@RestController
@RequestMapping("/api/contact")
public class DataController {
    
    private ContactFormRepo contactFormRepo = null;
    
    // Constructor injection
    public DataController(ContactFormRepo contactFormRepository) {
        this.contactFormRepo= contactFormRepo;
    }
    
    @PostMapping("/submit")
    public ResponseEntity<String> submitContactForm(@RequestBody DataEntity Data) {
        // Save the form submission to the database
        contactFormRepo.save(Data);
        return ResponseEntity.ok("Form submitted successfully!");
    }
    @GetMapping("/api/contact")
	public ResponseEntity<List<DataEntity>>getContacts(){
		return new ResponseEntity<>(contactFormRepo.findAll(),HttpStatus.OK);
}
}


