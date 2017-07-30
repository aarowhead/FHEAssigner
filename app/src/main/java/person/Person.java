package person;

/**
 * Used to hold the information of a participant in Family Home Evening
 *
 * Created by Aaron on 7/29/2017.
 */

public class Person {

    private String name;
    private ContactInfo contact;
    private boolean participating;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ContactInfo getContact() {
        return contact;
    }

    public void setContact(ContactInfo contact) {
        this.contact = contact;
    }

    public boolean isParticipating() {
        return participating;
    }

    public void setParticipating(boolean participating) {
        this.participating = participating;
    }
}
