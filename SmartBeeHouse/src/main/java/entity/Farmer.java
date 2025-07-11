package entity;

public class Farmer 
{
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    // Constructors .. mba3ed zid one without id
    public Farmer() {}

    public Farmer(int id, String firstName, String lastName, String email, String phone) 
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    // Getters and setters .. cz all are private 
    public int getId() 
    {
    	return id; 
    }
    
    public void setId(int id) 
    { 
    	this.id = id; 
    }

    public String getFirstName() 
    {
    	return firstName;
    }
    
    public void setFirstName(String firstName) 
    {
    	this.firstName = firstName; 
    }

    public String getLastName() 
    {
    	return lastName; 
    }
    
    public void setLastName(String lastName) 
    {
    	this.lastName = lastName; 
    }

    public String getEmail() 
    {
    	return email; 
    }
    
    public void setEmail(String email) 
    {
    	this.email = email;
    }

    public String getPhone() 
    {
    	return phone; 
    }
    
    public void setPhone(String phone) 
    {
    	this.phone = phone; 
    }
}
