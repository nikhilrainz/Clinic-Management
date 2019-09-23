package com.ust.dao;

import java.time.DayOfWeek;
import java.util.Date;
import java.util.List;

import com.ust.model.FrontOffice;

public interface IFrontOfficeDao {

	// method save to insert record into db table
	public abstract int save(FrontOffice objFO);

	// method update to update db table
	public abstract int update(FrontOffice objFO);

	// Age Calculation
	public abstract int ageCalculation(Date s);

	//Search for a Patient
	public abstract List<FrontOffice> getPatient(String searchString);

	//Getting required patient details
	public abstract FrontOffice getPatientDetails(int regId, FrontOffice objFO);

	//Getting DOB for age calculation
	public abstract Date getdob(int regId);

	// Display all patients
	public abstract List<FrontOffice> getPatients();

	//Finding the exact day using system date
	public abstract DayOfWeek getDay();

	// Method to get Todays Appointment
	public abstract List<FrontOffice> getTodaysAppointment();

	// Method to search in Todays Appointment using doctor name
	public abstract List<FrontOffice> getTodaysAppoinment(String searchString);

	// Search doctor by name for consultation
	public abstract FrontOffice getDoctorForConsult(String sName);

	// Picking up exact day
	public abstract DayOfWeek getToday();

	// Get available doctors
	public abstract List<FrontOffice> getAvailableDoctor();

	//Edit Patient Details
	public abstract List<FrontOffice> getEditPatientDetails(int regId);

	//Adding a new appointment
	public abstract int addAppoinment(FrontOffice fob);

}