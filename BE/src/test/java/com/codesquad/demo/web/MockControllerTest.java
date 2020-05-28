package com.codesquad.demo.web;

import com.codesquad.demo.service.MockService;
import com.codesquad.demo.web.dto.AllAccommodationResponseDto;
import com.codesquad.demo.web.dto.request.FilterRequestDto;
import com.codesquad.demo.web.dto.request.ReservationRequestDto;
import com.codesquad.demo.web.dto.response.AllReservationInfoResponseDto;
import com.codesquad.demo.web.dto.response.DeleteReservationResponseDto;
import com.codesquad.demo.web.dto.response.ReservationResponseDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MockControllerTest {

    @LocalServerPort
    private int port;

    private Logger logger = LoggerFactory.getLogger(MockControllerTest.class);

    @Autowired
    private MockService mockService;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getInitTest() {

        // given
        String url = "http://localhost:" + port + "/mock/init";
        Long id = 1L;
        int size = 30;
        String hotelName = "Stylish Queen Anne Apartment";
        String location = "Seattle";
        String status = "200";
        int total = 140;

        // when
        ResponseEntity<AllAccommodationResponseDto> responseEntity
                = restTemplate.getForEntity(url, AllAccommodationResponseDto.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody().getStatus()).isEqualTo(status);
        assertThat(responseEntity.getBody().getAllData().size()).isEqualTo(size);
        assertThat(responseEntity.getBody().getAllData().get(0).getId()).isEqualTo(id);
        assertThat(responseEntity.getBody().getAllData().get(0).getHotelName()).isEqualTo(hotelName);
        assertThat(responseEntity.getBody().getAllData().get(0).getLocation()).isEqualTo(location);
        assertThat(responseEntity.getBody().getPrices().get(0).getTotal()).isEqualTo(total);
    }

    @Test
    public void getFiltering() {

        // given
        String url = "http://localhost:" + port + "/mock/filter";
        Long id = 81L;
        String hotelName = "Bright & Airy Queen Anne Apartment";
        String location = "Seattle";
        String status = "200";
        String startDate = "2020-05-20";
        String endDate = "2020-05-24";
        String people = "4";
        String min = "10000";
        String max = "30000";
        String zero = "0";
        String man = "10000";
        String eman = "20000";
        int one = 1;
        int six = 6;

        FilterRequestDto filterRequestDto = FilterRequestDto.builder()
                .startDate(startDate)
                .endDate(endDate)
                .people(people)
                .min(min)
                .max(max)
                .build();

        // when
        ResponseEntity<AllAccommodationResponseDto> responseEntity
                = restTemplate.postForEntity(url, filterRequestDto, AllAccommodationResponseDto.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody().getStatus()).isEqualTo(status);
        assertThat(responseEntity.getBody().getAllData().get(0).getId()).isEqualTo(id);
//        assertThat(responseEntity.getBody().getAllData().get(0).getHotelName()).isEqualTo(hotelName);
//        assertThat(responseEntity.getBody().getAllData().get(0).getLocation()).isEqualTo(location);
        assertThat(responseEntity.getBody().getPrices()).isNull();
    }

    @Test
    public void reserveTest() {

        // given
        Long id = 1L;
        String userEmail = "guswns1659@gmail.com";
        String url = "http://localhost:" + port +  "/mock/" + "1/" + userEmail;
        LocalDate startDate = LocalDate.parse("2020-06-01");
        LocalDate endDate = LocalDate.parse("2020-06-03");
        int people = 5;
        int totalPrice = 100000;
        String ok = "200";
        String successMessage = "예약에 성공했습니다.";

        ReservationRequestDto reservationRequestDto = ReservationRequestDto.builder()
                .startDate(startDate)
                .endDate(endDate)
                .people(people)
                .totalPrice(totalPrice)
                .build();

        // when
        ResponseEntity<ReservationResponseDto> responseEntity
                = restTemplate.postForEntity(url, reservationRequestDto ,ReservationResponseDto.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody().getStatus()).isEqualTo(ok);
        assertThat(responseEntity.getBody().getMessage()).isEqualTo(successMessage);
    }

    @Test
    public void getReservationInfo() {

        // given
        String url = "http://localhost:" + port + "/mock/reservationInfo" + "/guswns1659@gmail.com";
        String ok = "200";
        long id = 1L;

        // when
        ResponseEntity<AllReservationInfoResponseDto> responseEntity
                = restTemplate.getForEntity(url, AllReservationInfoResponseDto.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody().getStatus()).isEqualTo(ok);
        assertThat(responseEntity.getBody().getAllData().get(0).getAccommodationId()).isEqualTo(id);
        assertThat(responseEntity.getBody().getAllData().get(0).getUrls()).isNotNull();
        assertThat(responseEntity.getBody().getAllData().get(0).getReservation()).isNotNull();
    }

    @Test
    public void deleteTest() {

        // given
        long accommodationId = 1L;
        long reservationId = 2L;
        String url = "http://localhost:" + port + "/mock/" + accommodationId + "/" + reservationId;
        String ok = "200";

        // when
//        restTemplate.delete(url);

        ResponseEntity<DeleteReservationResponseDto> responseEntity =
                restTemplate.exchange(url, HttpMethod.DELETE, null , DeleteReservationResponseDto.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody().getStatus()).isEqualTo(ok);
    }
}
