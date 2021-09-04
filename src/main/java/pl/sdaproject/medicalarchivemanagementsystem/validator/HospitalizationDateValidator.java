package pl.sdaproject.medicalarchivemanagementsystem.validator;

import pl.sdaproject.medicalarchivemanagementsystem.exception.HospitalizationDateException;

import java.time.LocalDate;

public class HospitalizationDateValidator {

    private static final LocalDate MINIMUM_DATE = LocalDate.of(2000, 1, 1);

    public static boolean validateHospitalizationDate(LocalDate startDate, LocalDate endDate) {

        validateStartDate(startDate);
        validateEndDate(startDate, endDate);

        return true;
    }

    public static boolean validateStartDate(LocalDate startDate) {
        if (!startDate.isAfter(MINIMUM_DATE)) {
            throw new HospitalizationDateException("Wrong begin date. Should be after: " + MINIMUM_DATE.toString());
        }
        return startDate.isAfter(MINIMUM_DATE);
    }

    public static boolean validateEndDate(LocalDate startDate, LocalDate endDate) {
        if (endDate.isBefore(startDate)) {
            throw new HospitalizationDateException("Wrong end date. Should be after: " + startDate.toString());
        }
        return startDate.isBefore(endDate);
    }
}
