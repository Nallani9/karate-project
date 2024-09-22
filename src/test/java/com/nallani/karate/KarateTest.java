package com.nallani.karate;

import com.intuit.karate.junit5.Karate;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KarateTest {

  @Karate.Test
  Karate testAll() {
    return Karate.run("classpath:features/get.feature", "classpath:features/post.feature");
  }

  /*    @Test
  void testParallel() {
      Results results = Runner.path("classpath:features/get.feature")
              .parallel(2);
      assertEquals(0, results.getFailCount(), results.getErrorMessages());
  }*/
}
