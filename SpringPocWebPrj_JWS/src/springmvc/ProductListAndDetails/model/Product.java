package springmvc.ProductListAndDetails.model;
 
public class Product {
    
    String sku="";
	String productName, productDescription="", availableColors, picture="", note="";
	double msrp=0, unitPrice=0, unitWeight, discount=0;
	private long productId, supplierProductId, supplierId, subCategoryId, quantityPerUnit;
	int unitsInStock, unitsOnOrder, reorderLevel, unitSize;
	boolean availableSize, discount_available, productAvailable; 

    /* constructor definitions starts */
    public Product(){
    	productId=0;
    }
     
    public Product(long productId, long supplierId, long subCategoryId, String sku, String productName, 
			String productDescription, double msrp,  double discount, long quantityPerUnit)
	{
		this.productId = productId;
		this.supplierId = supplierId;
		this.subCategoryId = subCategoryId; 
		this.sku = sku;
		this.productName = productName;
		this.productDescription = productDescription;
		this.msrp = msrp;
		this.discount = discount;
		this.quantityPerUnit= quantityPerUnit;
	}
    
    /* constructor definitions ends */ 
    /* getters and setters starts */ 
    public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getAvailableColors() {
		return availableColors;
	}

	public void setAvailableColors(String availableColors) {
		this.availableColors = availableColors;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public double getMsrp() {
		return msrp;
	}

	public void setMsrp(double msrp) {
		this.msrp = msrp;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getUnitWeight() {
		return unitWeight;
	}

	public void setUnitWeight(double unitWeight) {
		this.unitWeight = unitWeight;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getSupplierProductId() {
		return supplierProductId;
	}

	public void setSupplierProductId(long supplierProductId) {
		this.supplierProductId = supplierProductId;
	}

	public long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}

	public long getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(long subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public long getQuantityPerUnit() {
		return quantityPerUnit;
	}

	public void setQuantityPerUnit(long quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}

	public int getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public int getUnitsOnOrder() {
		return unitsOnOrder;
	}

	public void setUnitsOnOrder(int unitsOnOrder) {
		this.unitsOnOrder = unitsOnOrder;
	}

	public int getReorderLevel() {
		return reorderLevel;
	}

	public void setReorderLevel(int reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public int getUnitSize() {
		return unitSize;
	}

	public void setUnitSize(int unitSize) {
		this.unitSize = unitSize;
	}

	public boolean isAvailableSize() {
		return availableSize;
	}

	public void setAvailableSize(boolean availableSize) {
		this.availableSize = availableSize;
	}

	public boolean isDiscount_available() {
		return discount_available;
	}

	public void setDiscount_available(boolean discount_available) {
		this.discount_available = discount_available;
	}

	public boolean isProductAvailable() {
		return productAvailable;
	}

	public void setProductAvailable(boolean productAvailable) {
		this.productAvailable = productAvailable;
	}

	
	/* getters and setters ends */
	
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (productId ^ (productId >>> 32));
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
        Product other = (Product) obj;
        if (productId != other.productId)
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "Product [id=" + productId + ", product_name=" + productName + ", productDescription=" +productDescription + "]";
    }
 
 
}