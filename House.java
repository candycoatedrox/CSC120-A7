import java.util.ArrayList;

public class House extends Building implements HouseRequirements {

    private ArrayList<Student> residents;
    private boolean hasDiningRoom;

    public House(String name, String address, int nFloors, boolean hasDiningRoom) {
        super(name, address, nFloors);
        this.residents = new ArrayList<>();
        this.hasDiningRoom = hasDiningRoom;
        System.out.println("You have built a house: 🏠");
    }

    public boolean hasDiningRoom() {
        return this.hasDiningRoom;
    }

    public int nResidents() {
        return this.residents.size();
    }

    public void moveIn(Student s) {
        this.residents.add(s);
    }

    public Student moveOut(Student s) {
        this.residents.remove(s);
        return s;
    }

    public boolean isResident(Student s) {
        return this.residents.contains(s);
    }

}