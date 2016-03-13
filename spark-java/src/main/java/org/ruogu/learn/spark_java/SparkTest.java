package org.ruogu.learn.spark_java;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;

import scala.Tuple2;

/**
 * SparkTest
 * 
 * @author xueyintao 2016年3月13日 上午12:37:41
 */
public class SparkTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		sparkWordCountLambda();
//		map();
//		flatmap();
		reduce();
	}
	
	public static void map() {
		SparkConf conf = new SparkConf().setMaster("local").setAppName("My App");
		JavaSparkContext sc = new JavaSparkContext(conf);
		
		JavaRDD<Integer> rdd = sc.parallelize(Arrays.asList(1, 2, 3, 4));
		JavaRDD<Integer> result = rdd.map(x -> x * x);
		
		String rs = StringUtils.join(result.collect(), ",");
		System.out.println(rs);
	}
	
	public static void flatmap() {
		SparkConf conf = new SparkConf().setMaster("local").setAppName("My App");
		JavaSparkContext sc = new JavaSparkContext(conf);
		
		JavaRDD<String> rdd = sc.parallelize(Arrays.asList("a b", "c d"));
		JavaRDD<String> result = rdd.flatMap(x -> Arrays.asList(x.split(" ")));
		
		String rs = StringUtils.join(result.collect(), ",");
		System.out.println(rs);
	}
	
	public static void reduce() {
		SparkConf conf = new SparkConf().setMaster("local").setAppName("My App");
		JavaSparkContext sc = new JavaSparkContext(conf);
		
		JavaRDD<Integer> rdd = sc.parallelize(Arrays.asList(1, 2, 3, 4));
		Integer sum = rdd.reduce((x, y) -> x + y);
		
		System.out.println(sum);
	}
	
	public static void loadData() {
		SparkConf conf = new SparkConf().setMaster("local").setAppName("My App");
		JavaSparkContext sc = new JavaSparkContext(conf);
		JavaRDD<String> lines = sc.parallelize(Arrays.asList("pandas", "i like pandas"));
		
		long c = lines.count();
		List<String> subList = lines.take(10);
		
		// 匿名内部类的方式传入函数
		JavaRDD<String> error = lines.filter(new Function<String , Boolean>() {
			public Boolean call(String x) {
				return x.contains("error");
			}
		});
		
		// java8 lambda
		JavaRDD<String> error2 = lines.filter(s -> s.contains("error"));
		
		
	}
	
	/**
	 * 使用java8 lambda 实现的 spark wordcount
	 */
	public static void sparkWordCountLambda() {
		SparkConf conf = new SparkConf().setMaster("local").setAppName("My App");
		JavaSparkContext sc = new JavaSparkContext(conf);
		JavaRDD<String> lines = sc.textFile("/opt/data/tmp/wordcount.txt");

		// Split up into words.
		JavaRDD<String> words = lines.flatMap(line -> Arrays.asList(line.split(" ")));

		// Transform into pairs and count.
		JavaPairRDD<String, Integer> counts = words.mapToPair( w -> new Tuple2<String, Integer>(w, 1))
				.reduceByKey( (x, y) -> x + y);
		
		counts.saveAsTextFile("/opt/data/tmp/wordcount-spark-output-lambda");
	}
	
	/**
	 * 使用Java内部类实现的spark wordcount
	 */
	public static void sparkWordCount() {
		SparkConf conf = new SparkConf().setMaster("local").setAppName("My App");
		JavaSparkContext sc = new JavaSparkContext(conf);
		JavaRDD<String> input = sc.textFile("/opt/data/tmp/wordcount.txt");
		


		// Split up into words.
		JavaRDD<String> words = input.flatMap(new FlatMapFunction<String, String>() {
			public Iterable<String> call(String x) {
				return Arrays.asList(x.split(" "));
			}
		});

		// Transform into pairs and count.
		JavaPairRDD<String, Integer> counts = words.mapToPair(new PairFunction<String, String, Integer>() {
			public Tuple2<String, Integer> call(String x) {
				return new Tuple2(x, 1);
			}
		}).reduceByKey(new Function2<Integer, Integer, Integer>() {
			public Integer call(Integer x, Integer y) {
				return x + y;
			}
		});
		
		counts.saveAsTextFile("/opt/data/tmp/wordcount-spark-output");
	}

}
