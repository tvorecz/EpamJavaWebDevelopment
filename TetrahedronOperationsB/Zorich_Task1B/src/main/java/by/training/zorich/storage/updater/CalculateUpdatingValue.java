package by.training.zorich.storage.updater;

@FunctionalInterface
public interface CalculateUpdatingValue {
	double updatingValue(double firstValue, double secondValue);
}
