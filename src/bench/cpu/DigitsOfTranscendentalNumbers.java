package bench.cpu;

import bench.IBenchmark;

public class DigitsOfTranscendentalNumbers implements IBenchmark {

	private double result;
	private int size;
	private NumberRepresentation type;
	private IBenchmark benchmark;
	private IBenchmark benchmarkWarmUp;

	@Override
	public void initialize(Object ... params) {
		this.size = (Integer)params[0];
		this.type = (NumberRepresentation) params[1];

		switch ((NumberRepresentation) params[1]) {
			case PI:
				benchmark = new DigitsOfPi(size);
				benchmark.initialize();
				break;

			case E:
				benchmark = new DigitsOfE(size);
				benchmark.initialize();

				break;

			case PHI:
				benchmark = new DigitsOfPhi(size);
				benchmark.initialize();

				break;


			default:
				break;
		}

	}

	@Override
	public void warmUp() {
		int size = 5000;
		switch (type) {
			case PI:
				benchmarkWarmUp = new DigitsOfPi(size);
				benchmarkWarmUp.initialize();
				break;

			case E:
				benchmarkWarmUp = new DigitsOfE(size);
				benchmarkWarmUp.initialize();

				break;

			case PHI:
				benchmarkWarmUp = new DigitsOfPhi(size);
				benchmarkWarmUp.initialize();

				break;

			default:
				break;
		}
		benchmarkWarmUp.run();
		System.out.println("Warm-up done");
	}

	@Override
	@Deprecated	
	public String run() {
		return benchmark.run();
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
