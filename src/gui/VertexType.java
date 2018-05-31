package gui;

import java.awt.Color;
import java.awt.Paint;
import java.io.Serializable;

import org.apache.commons.collections15.Transformer;

import edu.uci.ics.jung.visualization.picking.PickedInfo;

public class VertexType implements Serializable {

	private final String vertexTitle;
	private Double x = 0.0;
	private Double y = 0.0;
	private Color color = Color.red;

	VertexType(String vertexTitle) {
		this.vertexTitle = vertexTitle;
	}

	@Override
	public String toString() {
		return vertexTitle;
	}

	@Override
	public boolean equals(Object vertex) {
		return ((VertexType) vertex).vertexTitle.equals(this.vertexTitle);
	}

	@Override
	public int hashCode() {
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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}

class VertexLabelTransformer implements Transformer<VertexType, String> {
	@Override
	public String transform(VertexType vertex) {
		return vertex.toString();
	}
}

class VertexColorTransformer implements Transformer<VertexType, Paint> {
	@Override
	public Paint transform(VertexType vertex) {
		return vertex.getColor();
	}
}
class PaintPickedVertexTransformer implements Transformer<VertexType, Paint> {
	private PickedInfo<VertexType> pi;
	private Color color;
	public PaintPickedVertexTransformer(PickedInfo<VertexType> pi, Color color)
	       {
	            this.pi = pi;
	            this.color = color;
	        }

	@Override
	public Paint transform(VertexType vertex) {
		if (pi.isPicked(vertex)) {
			vertex.setColor(color);
			System.out.printf("Vertex: %s Cor: %s", vertex.toString(), vertex.getColor().toString());
			return this.color;
		}
		return vertex.getColor();
	}
}	