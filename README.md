# FlightControllAttestationTask
# Test assignment on knowledge of the basics of the Java programming language.
There is a certain system that processes air travel. A flight is the transportation of a passenger from one point to another with possible intermediate landings. That. a flight can be thought of as a set of one or more elementary movements called segments. A segment is an atomic transportation, which, for simplicity, will be characterized by only two attributes: departure date/time and arrival date/time.

You need to write a small module that will filter a set of flights according to different rules. There can be a lot of filtering rules. Also sets of flights can be very large. Rules can be selected and set dynamically depending on the context of the filtering operation.

Think over the structure of the module, create the necessary classes and interfaces. If you are familiar with JUnit, then cover your code with tests. Do not consider the user interface. It is enough to output information to the console. You don't need to use any third party libraries.

The attached file TestClasses.java contains simplified model classes and a factory for getting test samples. All code must be placed in the com.gridnine.testing package

For a test run, create a public class Main with the main() method. This method should display the results of processing a test set of flights to the console. You need to get a test set using the FlightBuilder.createFlights() method

Put this test code in main(). Exclude flights from the test set according to the following rules (each rule requires a separate output of the list of flights):

- flight up to the current point in time;
- there are segments with an arrival date earlier than the departure date;
- the total time spent on the ground exceeds two hours (time on the ground is the interval between the arrival of one segment and the departure of the next one after it).
