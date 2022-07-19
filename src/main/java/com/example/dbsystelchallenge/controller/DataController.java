package com.example.dbsystelchallenge.controller;

import com.example.dbsystelchallenge.dto.BetriebsstelleDto;
import com.example.dbsystelchallenge.model.Betriebsstelle;
import com.example.dbsystelchallenge.service.DataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DataController {

    /**
     *  location of csv.file
     */
    String fileLocation = "C:\\Users\\Vincent\\Documents\\DBSystel\\DBNetz-Betriebsstellenverzeichnis-Stand2021-10.csv";
    //String fileLocation = "C:\\Users\\Vincent\\Documents\\DBSystel\\DBNetz-Betriebsstellenverzeichnis-Stand2018-04.csv";

    /**
     * user for new csv.file format (since 2021) or old csv.file format
     */
    String user = "newFormat";
    // String format = "oldFormat";


    @GetMapping(path = "/betriebsstelle/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BetriebsstelleDto> getBetriebsstelle(@PathVariable String code) {

        DataService data = new DataService();
        Betriebsstelle searchedLocation = data.getDataFromCsv(code, fileLocation, user);
        BetriebsstelleDto betriebsstelleDto = new BetriebsstelleDto();

        if (searchedLocation != null) {

            betriebsstelleDto.setName(searchedLocation.getRl100NameLong());
            betriebsstelleDto.setKurzname(searchedLocation.getRl100NameShort());
            betriebsstelleDto.setTyp(searchedLocation.getTypeLong());

            return new ResponseEntity<>(betriebsstelleDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }


    }
}
