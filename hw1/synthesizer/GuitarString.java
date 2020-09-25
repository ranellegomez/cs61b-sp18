package synthesizer;// TODO: Make sure to make this class a part of the synthesizer package
//package <package name>;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

//Make sure this class is public
public class GuitarString {
    /** Constants. Do not change. In case you're curious, the keyword final means
     * the values cannot be changed at runtime. We'll discuss this and other topics
     * in lecture on Friday. */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private BoundedQueue<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        // TODO: Create a buffer with capacity = SR / frequency. You'll need to
        //       cast the result of this divsion operation into an int. For better
        //       accuracy, use the Math.round() function before casting.
        //       Your buffer should be initially filled with zeros.
        int bufferSize = (int) Math.round(SR / frequency);
        buffer = new ArrayRingBuffer<>(bufferSize);

        for (int i = 0; i < this.buffer.capacity(); i += 1) {
            this.buffer.enqueue(0.0);
        }
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        // TODO: Dequeue everything in the buffer, and replace it with random numbers
        //       between -0.5 and 0.5. You can get such a number by using:
        //       double r = Math.random() - 0.5;
        ArrayList<Double> randoms = new ArrayList<Double>();
        int i = 0;
        while (randoms.size() < buffer.capacity()) {
            double randomDouble = StdRandom.uniform(-0.5, 0.5);
            if (!randoms.contains(randomDouble)) {
                randoms.add(randomDouble);
            }
        }
        while (!buffer.isEmpty()) {
            buffer.dequeue();
        }
        while (!buffer.isFull()) {
            buffer.enqueue(randoms.get(i++));
        }
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm. 
     */
    public void tic() {
        // TODO: Dequeue the front sample and enqueue a new sample that is
        //       the average of the two multiplied by the DECAY factor.
        //       Do not call StdAudio.play().
        if (buffer.isEmpty()) {
            return;
        }
        double c = (0.996 * (buffer.dequeue() + buffer.peek())) / 2;
        buffer.enqueue(c);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        return (buffer.isEmpty()) ? 0 : buffer.peek();
        // TODO: Return the correct thing.
    }
}
