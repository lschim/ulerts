package com.hackton.ulertsregistries.service;

import com.hackton.ulertsregistries.model.Sos;


public class MatchedSos {

    public MatchedSos(Sos sos, int fiability){
        this.sos=sos;
        this.fiability=fiability;
    }
    private Sos sos; //The matched Sos
    private int fiability; //The fiability of the matching
    
	public Sos getSos() {
		return sos;
	}
	public void setSos(Sos sos) {
		this.sos = sos;
	}
	public int getFiability() {
		return fiability;
	}
	public void setFiability(int fiability) {
		this.fiability = fiability;
	}
}
