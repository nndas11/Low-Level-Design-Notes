package BehaviouralDesignPatterns.LLDProblems.BookMyShow;

public class User {
    private final int Id;
    private final String name;
    private final String email;
    private final String phoneNumber;


    public User(int id, String name, String email, String phoneNumber) {
        Id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "Id=" + Id +
//                ", name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", phoneNumber='" + phoneNumber + '\'' +
//                '}';
//    }
}
