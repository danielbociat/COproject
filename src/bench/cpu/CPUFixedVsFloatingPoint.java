package bench.cpu;

import bench.IBenchmark;
import bench.cpu.PiSpigot;

public class CPUFixedVsFloatingPoint implements IBenchmark {

	private double result;
	private int size;
	private IBenchmark benchmark;

	@Override
	public void initialize(Object ... params) {
		this.size = (Integer)params[0];

		switch ((NumberRepresentation) params[1]) {
			case PI:
				benchmark = new PiSpigot(size);
				benchmark.initialize();
				break;

			case E:
				benchmark = new DigitsOfE(size);
				benchmark.initialize();

				break;


			default:
				break;
		}

	}

	@Override
	public void warmUp() {
		for (int i = 0; i < size; ++i) {
			result = 100000; // fixed
			result = 100000; // floating
		}
	}

	@Override
	@Deprecated	
	public void run() {
		benchmark.run();

	}

	@Override
	public void run(Object ...options) {
		result = 0;



	}
	
	@Override
	public void cancel() {
		
	}

	@Override
	public void clean() {
	}

	@Override
	public String getResult() {
		return String.valueOf(result);
	}

}