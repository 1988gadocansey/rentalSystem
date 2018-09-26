package project.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Andrew Kpobi
 */
@SuppressWarnings("unused")
public class  Property {
    private static int MAX_LENGTH=50;
    protected String propertyId;
    protected String streetNumber;
    protected String streetName;

    public static int getMaxLength() {
        return MAX_LENGTH;
    }

    public static void setMaxLength(int maxLength) {
        MAX_LENGTH = maxLength;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public int getNumOfBedRoom() {
        return numOfBedRoom;
    }

    public void setNumOfBedRoom(int numOfBedRoom) {
        this.numOfBedRoom = numOfBedRoom;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RentalRecord getRentalRecord() {
        return rentalRecord;
    }

    public void setRentalRecord(RentalRecord rentalRecord) {
        this.rentalRecord = rentalRecord;
    }

    public RentalRecord[] getRentalRecords() {
        return rentalRecords;
    }

    public void setRentalRecords(RentalRecord[] rentalRecords) {
        this.rentalRecords = rentalRecords;
    }

    public Property getType() {
        return type;
    }

    public void setType(Property type) {
        this.type = type;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public Property[] getList() {
        return list;
    }

    public void setList(Property[] list) {
        this.list = list;
    }

    protected String suburb;
    protected String propertyType;
    protected int numOfBedRoom;
    protected String status;
    protected RentalRecord rentalRecord;
    //protected List<RentalRecord> rentalRecords = new ArrayList<>();
    protected RentalRecord[] rentalRecords = {};
    protected Property type;
    protected String type2;
    private Property[] list;

    public Property(String propertyId, String streetNumber, String streetName, String suburb, 
            String propertyType, int numOfBedRoom, String status) {
        this.propertyId = propertyId;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.suburb = suburb;
        this.propertyType = propertyType;
        this.numOfBedRoom = numOfBedRoom;
        this.status = status;
        list = new Property[MAX_LENGTH];
    }

    public Property() {
        list  = new Property[MAX_LENGTH];
    }

    public void create(Property p){
        System.out.println("creating property ....");
        System.out.println("Property ...."+p);
        
        boolean contains = Arrays.stream(list).anyMatch(x -> x == p);
        if(contains){
            System.out.println("Property already exist");
            return ;
        }
        append(list, p);
        System.out.println("list "+list);
    }
    
    public Property[] append(Property[] array, Property value) {
        System.out.println("adding property...."+value);
        Property[] result = null;
        if(array.length !=MAX_LENGTH){
            System.out.println("adding MAX_LENGTH...."+MAX_LENGTH);
            result = Arrays.copyOf(array, array.length + 1);
            result[result.length - 1] = value;
        }
       return result; 
    }

    
    public void appendRentalRecord(RentalRecord[] array, RentalRecord value) {
        System.out.println("adding RentalRecord...."+value);
        RentalRecord[] result = null;
    }
 }