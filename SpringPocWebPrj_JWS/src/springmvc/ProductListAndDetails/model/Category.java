package springmvc.ProductListAndDetails.model;
 
public class Category {
 
    private long id;
    String category_name, status;

    /* constructor definitions starts */
    public Category(){
        id=0;
    }
     
    public Category(long id, String category_name, String status){
        this.id = id;
        this.category_name = category_name;
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

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	/* getters and setters ends */
	
   
 
    @Override
    public String toString() {
        return "Category [id=" + id + ", category_name=" + category_name + ", status=" + status + "]";
    }
 
 
}