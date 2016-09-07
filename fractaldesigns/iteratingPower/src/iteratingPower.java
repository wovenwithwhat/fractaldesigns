

public class iteratingPower {
	
	private double ra;
	private int nod = 16;	//set at setNodes
	
	public int[] getSpiralList(){
		int[] plac = new int[nod+1];
		int counter = 0;
		int x = 0;
		
		while(counter < nod){
			counter++;
			x = (x + counter - 1)%nod;
			//x1
			plac[counter] = x;
		}
		return plac;
	}
	
	public int[] getCircle(){
		int[] plac = new int[nod];
		for(int i = 0; i < nod; i++){
			plac[i] = i;
		}
		return plac;
	}
	
	public void setNodes(int nodes){
		ra = Math.toRadians((double) 360/nodes);
		nod = nodes;
	}
	public double nodeToX(int n){
		return (1 + Math.sin((double)n*ra))/2;
	}
	public double nodeToY(int n){
		return (1 - Math.cos((double)n*ra))/2;
	}
}
