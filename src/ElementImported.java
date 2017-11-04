
public class ElementImported {
	private String type;
	private int xCoordinate;
	private int yCoordinate;
	private String text; 
	private int width;
	private int height;
	private int layer;
	private int fontSize;
	
	
	
	
	public ElementImported(String type, String text, int xCoordinate, int yCoordinate, int width, int height, int layer, int fontSize) {
		super();
		this.type = type;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.text = text;
		this.width = width;
		this.height = height;
		this.layer = layer;
		this.fontSize = fontSize;
	}
	
	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getxCoordinate() {
		return xCoordinate;
	}
	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	public int getyCoordinate() {
		return yCoordinate;
	}
	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getLayer() {
		return layer;
	}
	public void setLayer(int layer) {
		this.layer = layer;
	}
	
	
}
