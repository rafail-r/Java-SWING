import java.util.List;



public class MyOtherThread extends Thread {

	public final List<Circle> allMyCircles;
	public final int index;
	public final Canvas canvas;

	public MyOtherThread(List<Circle> allMyCircles, int index, Canvas canvas) {
		
		this.allMyCircles = allMyCircles;
		this.canvas = canvas;
		this.index = index;
		this.setDaemon(true);
	}
	public void run(){
		while (true){
			try {
				System.out.println("going to sleep..");
				sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("sleep interrupted");
				
				e.printStackTrace();
			}
			System.out.println("woke up");
			if (allMyCircles.get(index).rad == 20)
				allMyCircles.get(index).rad = 10;
			else
				allMyCircles.get(index).rad = 20;
			canvas.repaint();
		}
	}
	
	
}
