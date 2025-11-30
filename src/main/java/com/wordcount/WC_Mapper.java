package com.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class WC_Mapper extends Mapper <LongWritable , Text , Text , IntWritable>{
    private IntWritable one = new IntWritable(1);
    private Text word = new Text();


    @Override
    public void map(LongWritable key , Text value , Context context) throws IOException, InterruptedException {
        String line = value.toString();

        String[] words = line.split("\\s+");
        for (String w : words) {
            word.set(w);
            context.write(word , one );
        }
    }

}
