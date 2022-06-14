package com.example.blogcodeerrormessage.common.exception;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ErrorcodeDataRepository extends JpaRepository<ErrorcodeData, Long> {

	Optional<ErrorcodeData> findByNameAndLocale(final String name, final String locale);
}
