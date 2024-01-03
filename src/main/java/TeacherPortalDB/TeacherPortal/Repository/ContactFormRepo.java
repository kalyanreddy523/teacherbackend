package TeacherPortalDB.TeacherPortal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import TeacherPortalDB.TeacherPortal.Entity.DataEntity;

public interface ContactFormRepo extends JpaRepository<DataEntity, Long> {

	List<DataEntity> findAll();
    // Custom query methods if needed
}



