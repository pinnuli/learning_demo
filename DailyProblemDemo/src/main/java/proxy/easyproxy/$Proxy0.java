package proxy.easyproxy;
import java.lang.reflect.Method;
import proxy.easyproxy.InvocationHandler;
public class $Proxy0 implements proxy.easyproxy.Move {
	public $Proxy0(InvocationHandler h) {
		this.h = h;
	}
  private InvocationHandler h;
	@Override
	public void move() {
  try{
  Method md = proxy.easyproxy.Move.class.getMethod("move");
  h.invoke(this,md);
  }catch(Exception e){ e.printStackTrace();}
	}
}