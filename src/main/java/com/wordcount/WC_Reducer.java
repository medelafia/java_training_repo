package com.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;
import org.w3c.dom.Text;

import java.io.IOException;

public class WC_Reducer extends Reducer<Text, IntWritable , Text , IntWritable>  {

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
        int sum = 0 ;

        for(IntWritable val : values) {
            sum += val.get();
        }

        context.write(key , new IntWritable(sum));

    }
}
