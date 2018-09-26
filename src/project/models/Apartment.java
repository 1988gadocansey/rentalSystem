package project.models;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import static java.time.DayOfWeek.SUNDAY;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Andrew Kpobi
 */
public class Apartment extends Property{
    private static final BigDecimal ONE_BEDROOM_RATE = new BigDecimal(143); 
    private static final BigDecimal TWO_BEDROOM_RATE = new BigDecimal(210); 
    private static final BigDecimal THREE_BEDROOM_RATE = new BigDecimal(319); 
    private BigDecimal rentalRate;



    public Apartment(String propertyId, String streetNumber, String streetName, String suburb, String propertyType, int numOfBedRoom, String status) {
        super(propertyId, streetNumber, streetName, suburb, propertyType, numOfBedRoom, status);
        

    }

    Apartment() {
    }
   
    protected boolean rent(String customerId, LocalDateTime rentDate, int numOfRentDay) {
        if(status.equals("Available") || status.equals("Maintenance")){
            return false;
        }
        DayOfWeek dayOfWeek = rentDate.getDayOfWeek();
        
        switch(dayOfWeek){
            case SUNDAY:
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
                return minimumOfTwoDaysRent(numOfRentDay);
                
            case FRIDAY:
            case SATURDAY: 
                return minimumOfThreeDaysRent(numOfRentDay);
        }
       return numOfRentDay > 28;

    }

    private boolean minimumOfTwoDaysRent(int numOfRentDay) {
        return numOfRentDay >=2;
    }
    private boolean minimumOfThreeDaysRent(int numOfRentDay) {
        return numOfRentDay >=3;
    }

    //@Override
    protected BigDecimal lateFees() {
        RentalRecord record = null;
        Date expectedRetunDate = record.getEstimatedReturnDate();
        Date actualReturnDate = record.getActualReturnDate();
        int noOfDaysLate =  5;
        
        BigDecimal lateFees = new BigDecimal(0);
       switch(numOfBedRoom){
           case 1: 
               lateFees= (new BigDecimal(115).divide(new BigDecimal(100))).multiply(ONE_BEDROOM_RATE);
               return lateFees.add(ONE_BEDROOM_RATE);
           case 2: 
               lateFees=  (new BigDecimal(115).divide(new BigDecimal(100))).multiply(TWO_BEDROOM_RATE);
               return lateFees.add(TWO_BEDROOM_RATE);
           case 3: 
               lateFees= (new BigDecimal(115).divide(new BigDecimal(100))).multiply(THREE_BEDROOM_RATE);
               return lateFees.add(THREE_BEDROOM_RATE);
       }
        return BigDecimal.ZERO;
    }

    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }
    
}