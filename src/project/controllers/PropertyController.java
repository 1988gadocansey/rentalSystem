package project.controllers;

import project.models.Property;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import project.database.DBConnection;


public class PropertyController {



    public static void insert(int id,String streetName, String suburb, String streetNumber, String status, int numOfBedRoom,String ptype) {

        DBConnection.insert(id,streetName, suburb,streetNumber,status,numOfBedRoom, ptype);
    }


}