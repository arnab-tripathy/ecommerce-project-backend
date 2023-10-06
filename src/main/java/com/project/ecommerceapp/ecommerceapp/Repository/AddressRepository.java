package com.project.ecommerceapp.ecommerceapp.Repository;

import com.project.ecommerceapp.ecommerceapp.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

    @Query("select a from Address a where a.userId= :id")
    List<Address> findByUserId(@Param("id") Long id);
}
