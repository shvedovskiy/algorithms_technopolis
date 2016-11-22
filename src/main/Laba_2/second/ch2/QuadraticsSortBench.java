package Laba_2.second.ch2;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class QuadraticsSortBench {

    private int[] arr;

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        arr = Helper.gen(1000);
    }

    @Benchmark
    public void measureBubbleSort(Blackhole bh) {
        bh.consume(BubbleSort.bubbleSort(arr));
    }

    @Benchmark
    public void measureInsertionSort(Blackhole bh) {
        bh.consume(InsertionSort.insertionSort(arr));
    }

    @Benchmark
    public void measureInsertionSortBinary(Blackhole bh) {
        bh.consume(InsertionSortBinary.insertionSort(arr));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(QuadraticsSortBench.class.getSimpleName())
                .warmupIterations(20)
                .measurementIterations(20)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
