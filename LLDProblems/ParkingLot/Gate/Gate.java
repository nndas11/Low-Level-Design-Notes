package BehaviouralDesignPatterns.LLDProblems.ParkingLot.Gate;

public abstract class Gate {
    protected final int gateId;
    protected final GateType gateType;

    public Gate(int gateId, GateType gateType) {
        this.gateId = gateId;
        this.gateType = gateType;
    }

    public int getGateId() {
        return gateId;
    }

    public GateType getGateType() {
        return gateType;
    }
}
