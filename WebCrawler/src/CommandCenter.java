
public class CommandCenter implements Runnable {

	@Override
	public void run() {
		System.out.println("Somethjing");
		try {
			Thread.sleep(1500);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("yeah");
	}
}
