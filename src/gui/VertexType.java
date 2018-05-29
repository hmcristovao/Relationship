package gui;

import java.io.Serializable;

import org.apache.commons.collections15.Transformer;

public class VertexType implements Serializable {

	private final String vertexTitle;
	private  Double x = 0.0;
	private  Double y= 0.0;
	VertexType(String vertexTitle)
    {
        this.vertexTitle = vertexTitle;
    }
	@Override
	public String toString()
    {
        return vertexTitle;
    }
	@Override
    public boolean equals(Object vertex){
        return ((VertexType) vertex).vertexTitle.equals(this.vertexTitle);
    }
	@Override
	public int hashCode(){
		return vertexTitle.hashCode();
	}
	public Double getX() {
		return x;
	}
	public void setX(Double x) {
		this.x = x;
	}
	public Double getY() {
		return y;
	}
	public void setY(Double y) {
		this.y = y;
	}
}
class VertexLabelTransformer implements Transformer<VertexType, String>
{
    @Override
    public String transform(VertexType vertex)
    {
        return vertex.toString();
    }
}