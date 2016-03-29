package springmvc.ProductListAndDetails.model;
 
public class SubCategory {
 
    private long id, category_id;
    String subcategory_name, status;

    /* constructor definitions starts */
    public SubCategory(){
        id=0;
    }
     
    public SubCategory(long id, String subcategory_name, long category_id, String status){
        this.id = id;
        this.subcategory_name = subcategory_name;
        this.category_id = category_id;
        this.status = status;
    }
    
    /* constructor definitions ends */ 
    /* getters and setters starts */ 
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(long category_id) {
		this.category_id = category_id;
	}

	public String getSubcategory_name() {
		return subcategory_name;
	}

	public void setSubcategory_name(String subcategory_name) {
		this.subcategory_name = subcategory_name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/* getters and setters ends */
	
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SubCategory other = (SubCategory) obj;
        if (id != other.id)
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "SubCategory [id=" + id + ", subcategory_name=" + subcategory_name + ", category ="+ category_id+ ", status=" + status + "]";
    }
 
 
}