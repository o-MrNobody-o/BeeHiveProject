package entity;

public class Beehive 
{
    private int id;
    private String hiveName;
    private int siteId;
    private String hiveType;
    private int extensionCount;
    private String responsibleAgent;

    // Constructors .. w7ayed ma4ir id
    public Beehive() {}

    public Beehive(int id, String hiveName, int siteId, String hiveType, int extensionCount, String responsibleAgent) 
    {
        this.id = id;
        this.hiveName = hiveName;
        this.siteId = siteId;
        this.hiveType = hiveType;
        this.extensionCount = extensionCount;
        this.responsibleAgent = responsibleAgent;
    }

    // Getters setters
    public int getId() 
    { 
    	return id; 
    }
    
    public void setId(int id) 
    {
    	this.id = id; 
    }

    public String getHiveName() 
    { 
    	return hiveName; 
    }
    
    public void setHiveName(String hiveName) 
    { 
    	this.hiveName = hiveName;
    }

    public int getSiteId() 
    { 
    	return siteId;
    }
    
    public void setSiteId(int siteId) 
    { 
    	this.siteId = siteId;
    }

    public String getHiveType() 
    { 
    	return hiveType;
    }
    
    public void setHiveType(String hiveType) 
    { 
    	this.hiveType = hiveType; 
    }

    public int getExtensionCount() 
    { 
    	return extensionCount; 
    }
    
    public void setExtensionCount(int extensionCount) 
    {
    	this.extensionCount = extensionCount;
    }

    public String getResponsibleAgent() 
    { 
    	return responsibleAgent; 
    }
    
    public void setResponsibleAgent(String responsibleAgent) 
    {
    	this.responsibleAgent = responsibleAgent; 
    }
}
