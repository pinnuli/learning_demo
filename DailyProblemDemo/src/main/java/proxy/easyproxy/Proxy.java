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

/**
 * @author: pinnuli
 * @date: 2019-01-21
 */

public class Proxy {

    public static Object newProxyInstance(Class infce) throws IOException, NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String rt = "\r\n";
        String methodStr = "";
        for(Method m : infce.getMethods()){
            methodStr += "	@Override" + rt +
                    "	public void " + m.getName() + "() {" + rt +
                    "		long startTime = System.currentTimeMillis();" + rt +
                    "		System.out.println(\"汽车开始行驶....\");" + rt +
                    "		m." + m.getName() + "();" + rt +
                    "		long endTime = System.currentTimeMillis();" + rt +
                    "		System.out.println(\"汽车结束行驶....  汽车行驶时间：\" " + rt +
                    "				+ (endTime - startTime) + \"毫秒！\");" + rt +
                    "	}" ;
        }

        String str =
                "package proxy.easyproxy;" + rt +
                        "public class $Proxy0 implements " + infce.getName() + " {" + rt +
                        "	public $Proxy0(" + infce.getName() + " m) {" + rt +
                        "		super();" + rt +
                        "		this.m = m;" + rt +
                        "	}" + rt +
                        "	private " + infce.getName() + " m;" + rt +
                        methodStr + rt +
                        "}" ;
        //产生代理类的java文件
        String filename = System.getProperty("user.dir") +"/DailyProblemDemo/src/main/java/proxy/easyproxy/$Proxy0.java";
        File file = new File(filename);
        FileUtils.writeStringToFile(file, str);

        //编译
        //拿到编译器
        JavaCompiler complier = ToolProvider.getSystemJavaCompiler();
        //文件管理者
        StandardJavaFileManager fileMgr =
                complier.getStandardFileManager(null, null, null);
        //获取文件
        Iterable units = fileMgr.getJavaFileObjects(filename);
        //编译任务
        JavaCompiler.CompilationTask t = complier.getTask(null, fileMgr, null, null, null, units);
        //进行编译
        t.call();
        fileMgr.close();

        //load 到内存
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        Class c = cl.loadClass("proxy.easyproxy.$Proxy0");

        Constructor ctr = c.getConstructor(infce);
        return ctr.newInstance(new Car());

    }
}
