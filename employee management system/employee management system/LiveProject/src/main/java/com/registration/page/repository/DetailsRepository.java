package com.registration.page.repository;

import com.registration.page.model.Details;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailsRepository extends JpaRepository<Details, Long> {
    Details findByEmail(String email);
}
