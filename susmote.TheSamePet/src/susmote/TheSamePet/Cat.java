package susmote.TheSamePet;

import java.awt.Color;

public class Cat {
	private String name;
	private int age;
	private double weight;
	private Color color;
	public Cat(String name, int age, double weight, Color color) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.color = color;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Cat cat = (Cat) obj;
		return name.equals(cat.name) && (age == cat.age) && (weight == cat.weight)
				&& (color.equals(cat.color));
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("名字： " + name + "\n");
		sb.append("年龄： " + age + "\n");
		sb.append("重量： " + weight + "\n");
		sb.append("颜色： " + color + "\n");
		return sb.toString();
	}
}
