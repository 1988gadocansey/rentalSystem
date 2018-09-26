package project.models;
import java.math.*;
import java.util.Date;
/**
 *
 * @author SL002
 */
public class PremiumSuite extends Property{
    private static final BigDecimal RENTAL_FEES = new BigDecimal(554);
    private static final BigDecimal DAILY_LATE_FEE = new BigDecimal(662);
    private Date mentainanceCompletionDate;

    public PremiumSuite(String propertyId, String streetNumber, String streetName, String suburb, String propertyType, int numOfBedRoom, String status) {
        super(propertyId, streetNumber, streetName, suburb, propertyType, numOfBedRoom, status);
    }
    
   // @Override
    protected BigDecimal lateFees() {
//        RentalRecord record = this.getRentalRecord();
//        DateTime expectedRetunDate = record.getReturnDate();
//        DateTime actualReturnDate = record.getActualReturnDate();
//        
//        int noOfDaysLate =  DateTime.diffDays(expectedRetunDate, actualReturnDate);
        
//        return DAILY_LATE_FEE.multiply(new BigDecimal(noOfDaysLate));

return null;
       
        
    }

    public Date getMentainanceCompletionDate() {
        return mentainanceCompletionDate;
    }

    public void setMentainanceCompletionDate(Date mentainanceCompletionDate) {
        this.mentainanceCompletionDate = mentainanceCompletionDate;
    }   
}
