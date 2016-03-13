package org.ruogu.learn.spark_java;

import java.util.Arrays;
import java.util.List;

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
		
	}
	
	public static void loadData() {
		SparkConf conf = new SparkConf().setMaster("local").setAppName("My App");
		JavaSparkContext sc = new JavaSparkContext(conf);
		JavaRDD<String> lines = sc.parallelize(Arrays.asList("pandas", "i like pandas"));
		
		// 匿名内部类的方式传入函数
		JavaRDD<String> error = lines.filter(new Function<String , Boolean>() {
			public Boolean call(String x) {
				return x.contains("error");
			}
		});
		
		// java8 lambda
		JavaRDD<String> error2 = lines.filter(s -> s.contains("error"));
		
		
	}
	
	public static void sparkMR() {
		SparkConf conf = new SparkConf().setMaster("local").setAppName("My App");
		JavaSparkContext sc = new JavaSparkContext(conf);
		JavaRDD<String> input = sc.textFile("/opt/data/tmp/wordcount.txt");
		
		long c = input.count();
		List<String> subList = input.take(10);

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
