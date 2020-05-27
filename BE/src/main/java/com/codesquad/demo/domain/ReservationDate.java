package com.codesquad.demo.domain;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class ReservationDate {

    @Id
    private Long id;

    private LocalDate startDate;
    private LocalDate endDate;
}
