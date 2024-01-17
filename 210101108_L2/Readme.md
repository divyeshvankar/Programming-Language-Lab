NAME: VANKAR DIVYESH KUMAR
ROLL NUMBER: 210101108

Requirements that it satisfy:

1. Implement a ‘TrafficSignal’ with three threads, each representing a different light (red, yellow, green).

2. The threads should print the current color of the light they represent and then wait for the specified duration before transitioning to the next light.

3. The cycle should repeat indefinitely, transitioning in the order: red->green->yellow->red.

4. Implement a ‘Main’ class to create and start multiple instances of the ‘TrafficSignal’ class to simulate multiple intersections.

My program defines a TrafficSignal class that implements the Runnable interface to represent the overall traffic signal system. The system consists of three lights: Red, Green, and Yellow, each implemented by separate Runnable classes (Red, Green, and Yellow).

The Light class holds information about each traffic light, such as its name (color) and sleep time (duration of the signal). The program uses Thread.sleep() to simulate the duration of each signal state.

In the TrafficSignal class, an infinite loop cycles through the three signal states, creating threads for each state and starting them sequentially. The join() method is used to ensure that each thread completes its execution before moving to the next state. The Main class initializes two instances of the TrafficSignal class and starts threads for each traffic signal intersection.


Output for two intersection looks like:

RedRedGreenGreenYellowYelloeRedRedGreenGreenYellowYellow... ans so on. in this first two word showing that it has two intersection. To increase intersection uncomment the code in main section.








