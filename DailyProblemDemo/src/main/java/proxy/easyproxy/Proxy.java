package proxy.easyproxy;

import org.apache.commons.io.FileUtils;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author: pinnuli
 * @date: 2019-01-21
 */

public class Proxy {

    public static Object newProxyInstance(Class infce, InvocationHandler handler) throws IOException, NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String rt = "\r\n";
        String methodStr = "";
        for(Method m : infce.getMethods()){
            methodStr += "	@Override" + rt + "	public void " + m.getName() + "() {" + rt + "  try{" + rt
                    + "  Method md = " + infce.getName() + ".class.getMethod(\"" + m.getName() + "\");" + rt
                    + "  h.invoke(this,md);" + rt + "  }catch(Exception e){ e.printStackTrace();}" + rt + "	}";
        }

        String str =
                "package proxy.easyproxy;" + rt + "import java.lang.reflect.Method;" + rt
                        + "import proxy.easyproxy.InvocationHandler;" + rt + "public class $Proxy0 implements "
                        + infce.getName() + " {" + rt + "	public $Proxy0(InvocationHandler h) {" + rt + "		this.h = h;"
                        + rt + "	}" + rt + "  private InvocationHandler h;" + rt + methodStr + rt + "}";
        //产生代理类的java文件
        String javaFilename = System.getProperty("user.dir") +"/DailyProblemDemo/src/main/java/proxy/easyproxy/$Proxy0.java";
        File file = new File(javaFilename);
        FileUtils.writeStringToFile(file, str, "utf-8");

        //编译
        //拿到编译器
        JavaCompiler complier = ToolProvider.getSystemJavaCompiler();
        //文件管理者
        StandardJavaFileManager fileMgr =
                complier.getStandardFileManager(null, null, null);
        //获取文件
        Iterable units = fileMgr.getJavaFileObjects(javaFilename);
        //编译任务
        String classFilename = System.getProperty("user.dir") +"/DailyProblemDemo/target/classes/";
        JavaCompiler.CompilationTask t = complier.getTask(null, fileMgr, null, Arrays.asList("-g", "-d", classFilename), null, units);
        //进行编译
        t.call();
        fileMgr.close();


        //load 到内存
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        Class c = cl.loadClass("proxy.easyproxy.$Proxy0");

        Constructor ctr = c.getConstructor(InvocationHandler.class);
        return ctr.newInstance(handler);

    }
}
