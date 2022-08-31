package by.academy.homework7;

import org.junit.runner.Description;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

public class TestRunner extends BlockJUnit4ClassRunner {

    final private CalculatorTestListener listener;

    public TestRunner(Class<CalculatorTestListener> testClass) throws InitializationError {
        super(testClass);
        listener = new CalculatorTestListener();
    }
    @Override
    public void run(final RunNotifier notifier) {
        notifier.addListener(listener);
        super.run(notifier);
    }
    public static class CalculatorTestListener extends RunListener{

        @Override
        public void testFinished(Description description) {
            System.out.println("Execution Finished : " + description.getMethodName());
        }
    }

}
