package in.mittu.models;

import java.sql.Timestamp;

public class MenuItemModel {
	
	private int menuItemId;
	private String menuItemCode;
	private String name;
	private String description;
	private String availableTime;
	private int deliveryTime;
	private String keywords;
	private String image;
	private int position;
	private double price;
	private int hotelId;
	private int createdBy;
	private int modifiedBy;
	private Timestamp createdOn;
	private Timestamp modifiedOn;
	
	@Override
	public String toString() {
		return "MenuItemModel [menuItemId=" + menuItemId + ", menuItemCode=" + menuItemCode + ", name=" + name
				+ ", description=" + description + ", availableTime=" + availableTime + ", deliveryTime=" + deliveryTime
				+ ", keywords=" + keywords + ", image=" + image + ", position=" + position + ", price=" + price
				+ ", hotelId=" + hotelId + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + ", createdOn="
				+ createdOn + ", modifiedOn=" + modifiedOn + "]";
	}
	
	
	public int getMenuItemId() {
		return menuItemId;
	}
	public void setMenuItemId(int menuItemId) {
		this.menuItemId = menuItemId;
	}
	
	public String getMenuItemCode() {
		return menuItemCode;
	}
	public void setMenuItemCode(String menuItemCode) {
		this.menuItemCode = menuItemCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAvailableTime() {
		return availableTime;
	}
	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}
	public int getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public int getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Timestamp getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}
	public Timestamp getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Timestamp modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	
	
}
