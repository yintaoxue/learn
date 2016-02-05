package org.ruogu.learn.nio.api;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * PathFileNIO
 * 
 * ref:http://javapapers.com/java/java-nio-path/
 * @author xueyintao 2016年2月5日 下午7:11:33
 */
public class PathFileNIO {
	public static void main(String... strings) {
		// instantiate a relative path
		Path p1 = FileSystems.getDefault().getPath("lib", "nio.jar");
		System.out.println("p1:" + p1);
		System.out.println("p1:" + p1.toAbsolutePath());

		// instantiate a absolute path - windows OS
		Path p2 = Paths.get("C:\\Users\\Java\\examples");
		System.out.println("p2:" + p2);

		// get current working directory
		Path currentDirectory = Paths.get("").toAbsolutePath();
		System.out.println(currentDirectory.toAbsolutePath());

		// resolve path in Windows OS
		Path path1 = Paths.get("C:\\Users\\Java\\examples");
		// Output is C:\Users\Java\examples\Test.java
		System.out.println(path1.resolve("Test.java"));

		// relativize
		Path path3 = Paths.get("/Users/xueyintao/");
		Path path4 = Paths.get("/Users/xueyintao/project/Github");
		// outcome is project/Github
		Path path3_to_path4 = path3.relativize(path4);
		System.out.println("path3_to_path4:" + path3_to_path4);
		// outcome is ../..
		Path path4_to_path3 = path4.relativize(path3);
		System.out.println("path4_to_path3:" + path4_to_path3);

		// normalize
		Path path5 = Paths.get("/Users/xueyintao/project/./Github");
		// output C:\Users\Java\examples
		System.out.println(path5.normalize());
		// output C:\Users\examples
		Path path6 = Paths.get("/Users/xueyintao/project/Github/../..//project");
		System.out.println(path6.normalize());
	}
}
