package com.ust.dao;

import java.util.List;

import com.ust.model.Doctor;

public interface IDoctorDao {

	public abstract List<Doctor> getDoctorsAppointment(int dId);

	public abstract Doctor getdId(String username, String password);

	// get all medicines
	public abstract List<Doctor> getAllMedicines();

	public abstract Integer d_getLabId(String lName);

	// add lab request
	public abstract int getAddLabRequest(Doctor dr);

	// get all test
	public abstract List<Doctor> getAllTest();

	public abstract List<Doctor> getAlllabPrescription(int regId, int dId);

	public abstract int lab_delete(int assignLabId);

	// add patient comments
	public abstract int getPatientComments(Doctor doctor);

	// add medicine prescription by doctor
	public abstract int getMedicineId(String mName);

	public abstract int saveDoctorPrescription(Doctor d[]);

	public abstract List<Doctor> getAllPrescrip(int regId);

	public abstract List<Doctor> ObslistHistory(int regId);

	// View patient Details
	public abstract List<Doctor> pDetails(int regId);

	// Lab history Details
	public abstract List<Doctor> lablistHistory(int regId);

	// Save Doctor Prescription
	public abstract int saveDoctorPrescription(Doctor doc);

	public abstract List<Doctor> getAllPrescription(int regId, int dId);

	//Delete prescription
	public abstract int presc_delete(int prescId);

	public abstract List<Doctor> getTodaysAppoinment1(String searchString);

}