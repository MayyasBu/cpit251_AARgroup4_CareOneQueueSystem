/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cpit251_aargroup4_careonequeuesystem;

// Status class stores the booking’s current status
public class Status {
    
    // Stored as an enum: IN_QUEUE, WASHING, READY, CANCELLED
    // instead of using strings, enum = fixed list of constant values that doesn't change
    public enum State { IN_QUEUE, WASHING, READY, CANCELLED }

    private State state;

    public Status(State initial) { this.state = initial; }
    
    // Getter
    public State getState() { return state; }
    // Setter
    public void setState(State s) { this.state = s; }

    @Override
    public String toString() {
        switch (state) {
            case IN_QUEUE: return "In Queue";
            case WASHING:  return "Washing";
            case READY:    return "Ready";
            case CANCELLED:return "Cancelled";
            default:       return "Unknown";
        }
    }
}