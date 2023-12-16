package com.liveasyBackend.LiveasyBackend.dao;

import com.liveasyBackend.LiveasyBackend.model.Loads;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoadDAO extends JpaRepository<Loads,String> {
    List<Loads> findByLoadingPoint(String startingPoint);
    List<Loads> findByUnloadingPoint(String loadingPoint);
    List<Loads> findByProductType(String productType);
}
