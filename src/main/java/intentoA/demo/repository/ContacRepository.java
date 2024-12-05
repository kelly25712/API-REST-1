package intentoA.demo.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import intentoA.demo.model.Contact;

@Repository
public interface  ContacRepository extends JpaRepository <Contact, Integer> {
    
    @Query(value = "SELECT * FROM Contact WHERE name = :name", nativeQuery = true)
    List<Contact> getContactsByName(@Param("name") String name);

    //@Query(value = "SELECT f FROM Contact f WHERE f.name = :name")
    //List<Contact> getFabricsByCompositionJPQL(@Param("name") String name);

}
