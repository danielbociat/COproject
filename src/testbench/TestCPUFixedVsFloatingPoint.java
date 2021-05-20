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
		bench.initialize(100000, NumberRepresentation.PI);
		bench.warmUp();

		IBenchmark bench2 = new CPUFixedVsFloatingPoint();
		bench2.initialize(100000, NumberRepresentation.E);
		bench2.warmUp();

		IBenchmark bench3 = new CPUFixedVsFloatingPoint();
		bench3.initialize(100000, NumberRepresentation.E);
		bench3.warmUp();

		BenchThread thread = new BenchThread(bench2);
		BenchThread thread2 = new BenchThread(bench);
		BenchThread thread3 = new BenchThread(bench);

		IBenchmark bench4 = new CPUFixedVsFloatingPoint();
		bench4.initialize(100000, NumberRepresentation.PI);
		bench4.warmUp();

		IBenchmark bench5 = new CPUFixedVsFloatingPoint();
		bench5.initialize(100000, NumberRepresentation.E);
		bench5.warmUp();

		IBenchmark bench6 = new CPUFixedVsFloatingPoint();
		bench6.initialize(100000, NumberRepresentation.E);
		bench6.warmUp();

		BenchThread thread4 = new BenchThread(bench2);
		BenchThread thread5 = new BenchThread(bench);
		BenchThread thread6 = new BenchThread(bench);

		IBenchmark bench7 = new CPUFixedVsFloatingPoint();
		bench7.initialize(100000, NumberRepresentation.PI);
		bench7.warmUp();

		IBenchmark bench8 = new CPUFixedVsFloatingPoint();
		bench8.initialize(100000, NumberRepresentation.E);
		bench8.warmUp();

		IBenchmark bench9 = new CPUFixedVsFloatingPoint();
		bench9.initialize(100000, NumberRepresentation.E);
		bench9.warmUp();

		BenchThread thread7 = new BenchThread(bench2);
		BenchThread thread8 = new BenchThread(bench);
		BenchThread thread9 = new BenchThread(bench);

		IBenchmark bench10 = new CPUFixedVsFloatingPoint();
		bench10.initialize(100000, NumberRepresentation.PI);
		bench10.warmUp();

		IBenchmark bench11 = new CPUFixedVsFloatingPoint();
		bench11.initialize(100000, NumberRepresentation.E);
		bench11.warmUp();

		IBenchmark bench12 = new CPUFixedVsFloatingPoint();
		bench12.initialize(100000, NumberRepresentation.E);
		bench12.warmUp();

		BenchThread thread10 = new BenchThread(bench2);
		BenchThread thread11 = new BenchThread(bench);
		BenchThread thread12 = new BenchThread(bench);

		IBenchmark bench13 = new CPUFixedVsFloatingPoint();
		bench13.initialize(100000, NumberRepresentation.PI);
		bench13.warmUp();

		IBenchmark bench14 = new CPUFixedVsFloatingPoint();
		bench14.initialize(100000, NumberRepresentation.E);
		bench14.warmUp();

		IBenchmark bench15 = new CPUFixedVsFloatingPoint();
		bench15.initialize(100000, NumberRepresentation.E);
		bench15.warmUp();

		BenchThread thread13 = new BenchThread(bench2);
		BenchThread thread14 = new BenchThread(bench);
		BenchThread thread15 = new BenchThread(bench);

		timer.start();

		new Thread(thread).start();
		new Thread(thread2).start();
		new Thread(thread3).start();
		new Thread(thread4).start();
		new Thread(thread5).start();
		new Thread(thread6).start();
		new Thread(thread7).start();
		new Thread(thread8).start();
		new Thread(thread9).start();
		new Thread(thread10).start();
		new Thread(thread11).start();
		new Thread(thread12).start();
//		new Thread(thread13).start();
//		new Thread(thread14).start();
//		new Thread(thread15).start();


		long time = timer.stop();
		log.writeTime("Finished in", time, timeUnit);

		bench.clean();
		log.close();
	}
}
