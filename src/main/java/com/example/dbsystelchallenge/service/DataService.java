package com.example.dbsystelchallenge.service;

import com.example.dbsystelchallenge.model.Betriebsstelle;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class DataService {


    /**
     * reads Data from csv.file
     *
     * @param fileLocation path of csv.file
     * @param format       choice between "oldFormat" or "newFormat"
     * @return List with all 'Betriebsstellen'
     */
    private List<Betriebsstelle> readDatafromCSV(String fileLocation, String format) {

        try {
            return new CsvToBeanBuilder<Betriebsstelle>(new FileReader(fileLocation, StandardCharsets.UTF_8))
                    .withProfile(format)
                    .withType(Betriebsstelle.class)
                    .withSeparator(';')
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * method searches data from given list
     *
     * @param code    abbreviation in list ("RL100-Code" or "Abk")
     * @param entries list of "Betriebsstelle"
     * @return object with type "Betriebsstelle"
     */
    private Betriebsstelle getInformationFromCode(String code, List<Betriebsstelle> entries) {

        return entries.stream()
                .filter(entry -> code.equals(entry.getRl100Code()))
                .findAny()
                .orElse(null);
    }

    /**
     * @param code code abbreviation in list ("RL100-Code" or "Abk")
     * @return object with type "Betriebsstelle"
     */
    public Betriebsstelle getDataFromCsv(String code, String fileLocation, String format) {
        return getInformationFromCode(code, readDatafromCSV(fileLocation, format));
    }

}
