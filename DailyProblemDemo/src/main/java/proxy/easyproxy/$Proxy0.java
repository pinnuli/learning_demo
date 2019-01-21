package proxy.easyproxy;
public class $Proxy0 implements proxy.easyproxy.Move {
	public $Proxy0(proxy.easyproxy.Move m) {
		super();
		this.m = m;
	}
	private proxy.easyproxy.Move m;
	@Override
	public void move() {
		long startTime = System.currentTimeMillis();
		System.out.println("汽车开始行驶....");
		m.move();
		long endTime = System.currentTimeMillis();
		System.out.println("汽车结束行驶....  汽车行驶时间：" 
				+ (endTime - startTime) + "毫秒！");
	}
}