package gui;

import java.io.Serializable;

import org.apache.commons.collections15.Transformer;

public class VertexType implements Serializable {

	private final String vertexTitle;
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
	
}
class VertexLabelTransformer implements Transformer<VertexType, String>
{
    @Override
    public String transform(VertexType vertex)
    {
        return vertex.toString();
    }
}