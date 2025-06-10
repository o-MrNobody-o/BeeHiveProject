package entity;

import java.util.Date;

public class ApiarySite 
{
    private int id;
    private String siteName;
    private double latitude;
    private double longitude;
    private double altitude;
    private Date setupDate;
    private Date closureDate;
    private int farmerId;

    // Constructors .. nzido wa7ed ma4ir id
    public ApiarySite() {}

    public ApiarySite(int id, String siteName, double latitude, double longitude, double altitude,
                      Date setupDate, Date closureDate, int farmerId) 
    {
        this.id = id;
        this.siteName = siteName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.setupDate = setupDate;
        this.closureDate = closureDate;
        this.farmerId = farmerId;
    }

    // Getters and setters
    public int getId() 
    { 
    	return id; 
    }
    
    public void setId(int id) 
    {
    	this.id = id; 
    }

    public String getSiteName() 
    { 
    	return siteName; 
    }
    
    public void setSiteName(String siteName) 
    {
    	this.siteName = siteName;
    }

    public double getLatitude() 
    { 
    	return latitude; 
    }
    
    public void setLatitude(double latitude) 
    { 
    	this.latitude = latitude; 
    }

    public double getLongitude() 
    { 
    	return longitude; 
    }
    
    public void setLongitude(double longitude) 
    { 
    	this.longitude = longitude;
    }

    public double getAltitude() 
    { 
    	return altitude; 
    }
    
    public void setAltitude(double altitude) 
    { 
    	this.altitude = altitude;
    }

    public Date getSetupDate() 
    { 
    	return setupDate;
    }
    public void setSetupDate(Date setupDate) 
    { 
    	this.setupDate = setupDate;
    }

    public Date getClosureDate() 
    { 
    	return closureDate; 
    }
    public void setClosureDate(Date closureDate) 
    { 
    	this.closureDate = closureDate;
    }

    public int getFarmerId() 
    { 
    	return farmerId; 
    }
    
    public void setFarmerId(int farmerId) 
    { 
    	this.farmerId = farmerId; 
    }
}
