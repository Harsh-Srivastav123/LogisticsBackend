package com.liveasyBackend.LiveasyBackend.dao;

import com.liveasyBackend.LiveasyBackend.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDetailsDAO extends JpaRepository<UserDetails,String> {

    //native query
    @Query(value = "SELECT * FROM user_details WHERE total_weight>= :n",nativeQuery = true)
    List<UserDetails> findUserByWeight(@Param("n") int weight);
}
