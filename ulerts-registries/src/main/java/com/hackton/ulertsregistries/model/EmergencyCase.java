package com.hackton.ulertsregistries.model;

import com.hackton.ulertsregistries.service.MatchedSos;

import java.time.LocalDateTime;

/**
 * Class representing a case that is open by the 911 central and contains the shared information between all the centrals
 */
public class EmergencyCase {

    private final long id;

    private EmergencyType emergencyType;
    private int numberPeopleHurt;
    private int numberCarImplied;
    private int desincarcerateNumber; //Number of people to desincarcerate from cars
    private LocalDateTime ETAPolice;
    private LocalDateTime ETAFirefighters;
    private LocalDateTime ETAAmbulance;
    private FireState fireState;
    private MatchedSos matchedSos;



    public EmergencyCase(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }



    public enum FireState{
        ONLY_SMOKE,
        SINGLE_HOUSE,
        MULTIPLE_FLOORS,
        MULTIPLE_BUILDINGS
    }

    public enum EmergencyType
    {
        FIRE,
        HOUSE_FIRE,
        CAR_ACCIDENT,
        PEOPLE_ACCIDENT,
        FLOOD,
        ARMED_ATTACK,
        HOSTAGE_SITUATION,
        WILD_ANIMAL,
    }

    public EmergencyType getEmergencyType() {
        return emergencyType;
    }

    public void setEmergencyType(EmergencyType emergencyType) {
        this.emergencyType = emergencyType;
    }

    public int getNumberPeopleHurt() {
        return numberPeopleHurt;
    }

    public void setNumberPeopleHurt(int numberPeopleHurt) {
        this.numberPeopleHurt = numberPeopleHurt;
    }

    public int getNumberCarImplied() {
        return numberCarImplied;
    }

    public void setNumberCarImplied(int numberCarImplied) {
        this.numberCarImplied = numberCarImplied;
    }

    public int getDesincarcerateNumber() {
        return desincarcerateNumber;
    }

    public void setDesincarcerateNumber(int desincarcerateNumber) {
        this.desincarcerateNumber = desincarcerateNumber;
    }

    public LocalDateTime getETAPolice() {
        return ETAPolice;
    }

    public void setETAPolice(LocalDateTime ETAPolice) {
        this.ETAPolice = ETAPolice;
    }

    public LocalDateTime getETAFirefighters() {
        return ETAFirefighters;
    }

    public void setETAFirefighters(LocalDateTime ETAFirefighters) {
        this.ETAFirefighters = ETAFirefighters;
    }

    public LocalDateTime getETAAmbulance() {
        return ETAAmbulance;
    }

    public void setETAAmbulance(LocalDateTime ETAAmbulance) {
        this.ETAAmbulance = ETAAmbulance;
    }

    public FireState getFireState() {
        return fireState;
    }

    public void setFireState(FireState fireState) {
        this.fireState = fireState;
    }

    public MatchedSos getMatchedSos() {
        return matchedSos;
    }

    public void setMatchedSos(MatchedSos matchedSos) {
        this.matchedSos = matchedSos;
    }
}