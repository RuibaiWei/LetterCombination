package com.future;

import com.future.exception.MyException;

import java.util.*;

/**
 * Description: given an integer array containing digits from 0-9,the task is to print all possible
 * letter combinations that the numbers could represent.A mapping of digit to letter(just like on
 * the telephone buttons) is being followed.Note that 0 and 1 do not map to any letters. all the
 * mapping are shown in the image below.
 */
public class CombinationUtils {

  /**
   * Description:the program need to support converting the digits from 0 to 99 into letters
   *
   * @param inputDigits
   */
  public static List<String> combination(int[] inputDigits) throws MyException {

    if (null == inputDigits || inputDigits.length <= 0) {
      return null;
    }
    List<String> result = new ArrayList<>();
    Map<Integer, List<Character>> integerListMap = buildNumber2ArrayStrMapper();
    if (inputDigits.length == 1) {
      List<Character> characters = integerListMap.get(inputDigits[0]);
      Optional.ofNullable(characters).orElse(new ArrayList<>()).stream()
          .forEach(
              character -> {
                result.add(character.toString());
              });
    } else if (inputDigits.length == 2) {
      // one of the arrays contains 0 or 1
      int indexZero = inputDigits[0];
      int indexTwo = inputDigits[1];
      if ((indexZero == 0 || indexZero == 1) && (indexTwo != 0 || indexTwo != 1)) {
        Optional.ofNullable(integerListMap.get(indexTwo)).orElse(new ArrayList<>()).stream()
            .forEach(
                character -> {
                  result.add(character.toString());
                });
      } else if ((indexZero != 0 || indexZero != 1) && (indexTwo == 0 || indexTwo == 1)) {
        Optional.ofNullable(integerListMap.get(indexZero)).orElse(new ArrayList<>()).stream()
            .forEach(
                character -> {
                  result.add(character.toString());
                });
      } else {
        List<Character> listCharIndexOne = integerListMap.get(indexZero);
        List<Character> listCharIndexTwo = integerListMap.get(indexTwo);
        for (Character one : listCharIndexOne) {
          for (Character two : listCharIndexTwo) {
            result.add(one + "" + two);
          }
        }
      }
    } else {
      throw new MyException("the array size only support the digits from 0 to 99");
    }
    System.out.println(result);
    return result;
  }

  /**
   * Description:build digits 0-9 mapper to String arrays
   *
   * @return get the map result
   */
  private static Map<Integer, List<Character>> buildNumber2ArrayStrMapper() {

    Map<Integer, List<Character>> mpper = new HashMap<>();
    mpper.put(0, null);
    mpper.put(1, null);
    mpper.put(2, Arrays.asList('A', 'B', 'C'));
    mpper.put(3, Arrays.asList('D', 'E', 'F'));
    mpper.put(4, Arrays.asList('G', 'H', 'I'));
    mpper.put(5, Arrays.asList('J', 'K', 'L'));
    mpper.put(6, Arrays.asList('M', 'N', 'O'));
    mpper.put(7, Arrays.asList('P', 'G', 'R', 'S'));
    mpper.put(8, Arrays.asList('T', 'U', 'V'));
    mpper.put(9, Arrays.asList('W', 'X', 'Y', 'Z'));
    return mpper;
  }
}
