package testbench;

import logging.ConsoleLogger;
import logging.ILog;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;
import bench.IBenchmark;
//import bench.cpu.CPUFixedPoint;
import bench.cpu.CPUFixedVsFloatingPoint;
//import bench.cpu.CPUNumberRepresentation;
import bench.cpu.NumberRepresentation;

public class TestCPUFixedVsFloatingPoint {

	public static void main(String[] args) {
		ITimer timer = new Timer();
		ILog log = /* new FileLogger("bench.log"); */new ConsoleLogger();
		TimeUnit timeUnit = TimeUnit.Milli;

		IBenchmark bench = new CPUFixedVsFloatingPoint();
		bench.initialize(1000, NumberRepresentation.PI);
		bench.warmUp();

		timer.start();

		bench.run();

		long time = timer.stop();
		log.writeTime("Finished in", time, timeUnit);

		bench.clean();
		log.close();
	}
}