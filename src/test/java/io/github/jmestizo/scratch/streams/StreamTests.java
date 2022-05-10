package io.github.jmestizo.scratch.streams;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StreamTests {

  @Test
  public void testSequentialStream() {
    long sum = sequentialSum(100);
    assertEquals(5050, sum);
  }

  @Test
  public void testParallelStream() {
    long sum = parallelSum(100);
    assertEquals(5050, sum);
  }

  private long parallelSum(long n) {
    return Stream.iterate(1L, i -> i + 1)
        .limit(n)
        .parallel()
        .reduce(0L , Long::sum);
  }

  long sequentialSum(long n) {
    return Stream.iterate(1L, i -> i + 1)
        .limit(n)
        .reduce(0L, Long::sum);
  }
}
