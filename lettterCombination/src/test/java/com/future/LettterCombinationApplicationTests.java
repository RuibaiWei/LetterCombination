package com.future;

import com.future.exception.MyException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration
class LettterCombinationApplicationTests {

  /**
   *
   * @throws MyException
   */
  @Test
  public void testCombinationWithNormal() throws MyException {

    int[] array = {2, 2};
    CombinationUtils.combination(array);
    array = new int[] {1, 2};
    CombinationUtils.combination(array);
    CombinationUtils.combination(new int[] {3, 3});
    CombinationUtils.combination(new int[] {0, 0});
    CombinationUtils.combination(new int[] {9, 9});
  }

  /**
   *
   */
  @Test
  public void testCombinationWithException() {
    try {
      CombinationUtils.combination(new int[] {9, 9, 9});
    } catch (MyException e) {
      e.printStackTrace();
    }
  }
}
