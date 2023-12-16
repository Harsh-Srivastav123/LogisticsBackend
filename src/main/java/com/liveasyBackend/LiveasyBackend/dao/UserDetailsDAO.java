package com.liveasyBackend.LiveasyBackend.dao;

import com.liveasyBackend.LiveasyBackend.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsDAO extends JpaRepository<UserDetails,String> {
}
