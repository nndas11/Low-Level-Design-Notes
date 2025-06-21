package BehaviouralDesignPatterns.LLDProblems.ParkingLot.Gate;

import BehaviouralDesignPatterns.LLDProblems.ParkingLot.ParkingLot;

public abstract class Gate {
    protected final int gateId;
    protected final GateType gateType;
    protected final ParkingLot parkingLot;

    public Gate(int gateId, GateType gateType, ParkingLot parkingLot) {
        this.gateId = gateId;
        this.gateType = gateType;
        this.parkingLot =  parkingLot;
    }

    public int getGateId() {
        return gateId;
    }

    public GateType getGateType() {
        return gateType;
    }
}
