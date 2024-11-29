package model;

import java.util.Date;

/**
 * Represents a person with basic personal information.
 * This is an abstract class to be extended by specific types of persons.
 */
public abstract class Person {
    private String id;
    private String fullName;
    private Date dateOfBirth;
    private String contactInformation;

    /**
     * Default constructor for creating an instance of Person.
     */
    public Person() {
    }

    /**
     * Constructs a Person with the specified details.
     *
     * @param id The unique identifier of the person.
     * @param fullName The full name of the person.
     * @param dateOfBirth The date of birth of the person.
     * @param contactInformation The contact information of the person.
     */
    public Person(String id, String fullName, Date dateOfBirth, String contactInformation) {
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.contactInformation = contactInformation;
    }

    /**
     * Sets the unique identifier of the person.
     *
     * @param id The unique identifier.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the unique identifier of the person.
     *
     * @return The unique identifier.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the full name of the person.
     *
     * @param fullName The full name.
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Gets the full name of the person.
     *
     * @return The full name.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the date of birth of the person.
     *
     * @param dateOfBirth The date of birth.
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets the date of birth of the person.
     *
     * @return The date of birth.
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the contact information of the person.
     *
     * @param contactInformation The contact information.
     */
    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    /**
     * Gets the contact information of the person.
     *
     * @return The contact information.
     */
    public String getContactInformation() {
        return contactInformation;
    }
}