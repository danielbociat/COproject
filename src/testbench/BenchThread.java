package testbench;

import bench.IBenchmark;

public class BenchThread extends Thread {
    private IBenchmark _bench;
    public BenchThread(IBenchmark bench) {
        _bench = bench;
    }

    @Override
    public void run()
    {
        _bench.run();
    }
}
