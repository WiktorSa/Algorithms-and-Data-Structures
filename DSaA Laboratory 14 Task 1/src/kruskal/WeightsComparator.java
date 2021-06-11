package kruskal;

import java.util.Comparator;

public class WeightsComparator implements Comparator<Edge>
{
	@Override
	public int compare(Edge arg0, Edge arg1) 
	{
		if (arg0.getWeight() - arg1.getWeight() != 0) {
			return arg0.getWeight() - arg1.getWeight();
		}
		
		return arg0.getSource().compareTo(arg1.getSource());
	}

}
