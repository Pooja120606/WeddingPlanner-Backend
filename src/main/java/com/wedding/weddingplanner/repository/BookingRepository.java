package com.wedding.weddingplanner.repository;

import com.wedding.weddingplanner.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByClientId(Long clientId);

    @Query("SELECT b FROM Booking b WHERE b.eventDate BETWEEN :startDate AND :endDate")
List<Booking> findBookingsBetween(@Param("startDate") LocalDate startDate,
                                  @Param("endDate") LocalDate endDate);

    List<Booking> findByVendor_User_Id(Long userId);
}