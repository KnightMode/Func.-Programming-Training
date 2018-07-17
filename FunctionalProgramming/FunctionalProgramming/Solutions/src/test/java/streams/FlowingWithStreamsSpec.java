package streams;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class FlowingWithStreamsSpec {

    FlowingWithStreams flowingWithStreams = new FlowingWithStreams();
    // 1. Generate a stream of first N natural numbers - 10/20
    @Test
    public void shouldGenerateNaturals() {
        assertThat(flowingWithStreams.firstNaturals(10).toString()).isEqualTo("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]");
    }
    // 2. Generate N random numbers
    // 3. Generate the sets of pythogoreans within 10.
    // X,Y,Z are said to be pythogorean when X^2 + Y^2 = Z^2
    @Test
    public void shouldFirstNPythogoreans() {
        assertThat(flowingWithStreams.pythoGoreans(10).toString()).isEqualTo("[[3, 4, 5], [4, 3, 5], [6, 8, 10], [8, 6, 10]]");
    }

    // 4. Use streams to solve factorials fibonacci series
}
