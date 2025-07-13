package BehaviouralDesignPatterns.LLDProblems.BookMyShow.Seat;

public class Seat {
    private int id;
    private int row;
    private int col;
    private SeatStatus seatStatus;
    private SeatType seatType;

    public Seat(int id, int row, int col, SeatType seatType) {
        this.id = id;
        this.row = row;
        this.col = col;
        this.seatStatus = SeatStatus.AVAILABLE;
        this.seatType = seatType;
    }

    public boolean isAvailable(){
        return this.seatStatus == SeatStatus.AVAILABLE;
    }

    public void bookSeat(){
        this.seatStatus = SeatStatus.OCCUPIED;
    }

    public void reserveSeat(){
        this.seatStatus = SeatStatus.RESERVED;
    }

    public void releaseSeat(){
        this.seatStatus = SeatStatus.AVAILABLE;
    }


    public int getId() {
        return id;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }


    public SeatType getSeatType() {
        return seatType;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", row=" + row +
                ", col=" + col +
                ", seatStatus=" + seatStatus +
                ", seatType=" + seatType +
                '}';
    }
}
