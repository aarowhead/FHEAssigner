package person;

import fheActivity.FheActivity;

/**
 * Used to hold a person's contact information
 *
 * Created by Aaron on 7/29/2017.
 */

public class ContactInfo {

    private String phoneNumber;
    private String email;
    private boolean sendSmsReminder;
    private boolean sendEmailReminder;

    private boolean sendEmail(String Name, FheActivity assignment){
        //TODO: Make this function send a email reminder

        return false;
    }

    private boolean sendSms(String Name, FheActivity assignment){
        //TODO: Make this function send a reminder text

        return false;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isSendSmsReminder() {
        return sendSmsReminder;
    }

    public void setSendSmsReminder(boolean sendSmsReminder) {
        this.sendSmsReminder = sendSmsReminder;
    }

    public boolean isSendEmailReminder() {
        return sendEmailReminder;
    }

    public void setSendEmailReminder(boolean sendEmailReminder) {
        this.sendEmailReminder = sendEmailReminder;
    }
}
