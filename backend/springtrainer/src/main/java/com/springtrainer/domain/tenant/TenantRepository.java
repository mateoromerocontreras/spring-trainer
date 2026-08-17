package com.springtrainer.domain.tenant;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<GymTenant, Long>{

}
