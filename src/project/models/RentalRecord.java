package project.models;



import java.util.Date;
import java.math.*;

/**
 *
 * @author SL002
 */
public class RentalRecord {
    
    private String recordId;
    private String propertyId;
    private String customerId;
    private DateTime rentDate;
    private Date estimatedReturnDate;
    private Date actualReturnDate;
    private BigDecimal rentalFee;
    private BigDecimal lateFees;
    private int numberOfDays;
    private static int RECORD_SIZE=10;
    private String status;
    private Object objReturnDate,objRentalFees,objLateFees = null;
    private RentalRecord[] data ;
    private static final BigDecimal ONE_BEDROOM_RATE = new BigDecimal(143); 
    private static final BigDecimal TWO_BEDROOM_RATE = new BigDecimal(210); 
    private static final BigDecimal THREE_BEDROOM_RATE = new BigDecimal(319); 

    public RentalRecord() {
        data = new RentalRecord[RECORD_SIZE];
    }

    public RentalRecord(String recordId, String propertyId) {
        this.recordId = recordId;
        this.propertyId = propertyId;
    }

    
    public RentalRecord(String recordId, String propertyId, String customerId, DateTime rentDate, Date returnDate, Date actualReturnDate) {
        this.recordId = recordId;
        this.propertyId = propertyId;
        this.customerId = customerId;
        this.rentDate = rentDate;
        this.estimatedReturnDate = returnDate;
        this.actualReturnDate = actualReturnDate;
    }

    

    public String getRecordId() {
        
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public DateTime getRentDate() {
        return rentDate;
    }

    public void setRentDate(DateTime rentDate) {
        this.rentDate = rentDate;
    }

    public Date getEstimatedReturnDate() {
        return estimatedReturnDate;
    }

    public void setEstimatedReturnDate(Date estimatedReturnDate) {
        this.estimatedReturnDate = estimatedReturnDate;
    }

    public Date getActualReturnDate() {
        return actualReturnDate;
    }

    public void setActualReturnDate(Date actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }

    

   

    public BigDecimal getRentalFee() {
        
        return rentalFee;
    }

    public void setRentalFee(BigDecimal rentalFee) {
        this.rentalFee = rentalFee;
    }

    public BigDecimal getLateFees() {
        return lateFees;
    }

    public void setLateFees(BigDecimal lateFees) {
        this.lateFees = lateFees;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

   
    public String generateRecordId(){
        DateTime currentDate = new DateTime();
        return propertyId +"_"+ customerId +"_"+ currentDate.getEightDigitDate();
    }
    
    public String getDetails(){
        StringBuilder builder = new StringBuilder();
        builder.append("Record ID:             ").append(generateRecordId()).append("\n")
               .append("Rent Date:             ").append(getRentDate()).append("\n")
               .append("Estimated Return Date: ").append(getEstimatedReturnDate());

        if(status.equals("Rented")){
            builder.append("Actual Return Date:  ").append(getActualReturnDate()).append("\n")
                   .append("Rental Fee:          ").append(getRentalFee()).append("\n")
                   .append("Late Fee:            ").append(getLateFees());

        }
        return builder.toString();

    }
    
    public void storeRentalRecord(RentalRecord record){
        int size = data.length;
        switch(size){
            case 0:data[0] = record;
            break;
        }
        /**
         * Copies an array from the specified source array, beginning at the specified position, 
         * to the specified position of the destination array.
         * A subsequence of array components are 
         * copied from the source array referenced by src to the destination array referenced by dest. 
         * The number of components copied is equal to the length argument. The components at positions 
         * srcPos through srcPos+length-1 in the source array are copied into positions destPos through
         */
//        System.a
    }
    
    @Override
    public String toString() {
        
        if(actualReturnDate == null){
            objReturnDate= "none";
        }else{
            objReturnDate =actualReturnDate;
        }
        
        if(rentalFee == null){
            objRentalFees= "none";
        }else{
            objRentalFees =rentalFee;
        }
        
        if(lateFees == null){
            objLateFees= "none";
        }else{
            objLateFees =lateFees;
        }
       return generateRecordId()+":"+rentDate+":"+estimatedReturnDate+":"+objReturnDate+":"+objRentalFees+":"+objLateFees;

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}

