package com.yogi.Utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * This class allows for creation of data
 * Used in creationData module too
 */
public class RandomUtil {
    protected static Random random = new Random(System.currentTimeMillis());
        public static String alphaCharacters = "abcdefghijklmnopqrstuvwxyz";
    public static String numericCharacters = "0123456789";


    private static final Logger LOGGER = LoggerFactory.getLogger(RandomUtil.class);

    public static synchronized int randomInt(final int min, final int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    public static synchronized String randomYesOrNo() {
        String[] selectionOfYesOrNo ={
                "Yes",
                "No",
        };
        int idx = new Random().nextInt(selectionOfYesOrNo.length);
        return selectionOfYesOrNo[idx];

    }
    public static synchronized String randomCharacterString(final int length) {
        return randomString(alphaCharacters, length);
    }

    public static synchronized List<String> randomItemListFromList(final List<String> listToGetRandomVal , int randomSeriesLength) {
        Random rand = new Random();
        Collections.shuffle(listToGetRandomVal);
        return listToGetRandomVal.subList(0, randomSeriesLength);
    }

    public static synchronized String randomItemFromList(final List<String> listToGetRandomVal) {
        Random rand = new Random();
        return listToGetRandomVal.get(rand.nextInt(listToGetRandomVal.size()));
    }


    public static synchronized String randomNumberString(final int length) {
        return randomString(numericCharacters, length);
    }

    public static synchronized String randomString(final String characters, final int length) {
        final char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(random.nextInt(characters.length() - 1));
        }
        return new String(text);
    }

    public static boolean randomBoolean() {
        return new Random().nextBoolean();
    }




    public static <E> List<E> randomListItems(final List<E> list, final int minimumListSize, final int maximumListSize) {
        final List randomList = new ArrayList<E>();

        final int numberOfItemsToAdd = randomInt(minimumListSize, maximumListSize);

        for (int i = 0; i < numberOfItemsToAdd; i++) {
            randomList.add(list.get(randomInt(0, list.size() - 1)));
        }

        return randomList;
    }

    public static <E> E randomListItem(final List<E> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Can't generate random item from empty list");
        }
        return list.get(randomInt(0, list.size() - 1));
    }

    public static <T> T randomArrayItem(final T[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Can't generate random item from empty array");
        }
        return array[randomInt(0, array.length - 1)];
    }

   /* public static MembershipStatusEnum randomMembershipStatus(final int length) {
        final int randomPosition = new Random().nextInt(length);
        if (MembershipStatusEnum.values()[randomPosition].name().equals(MembershipStatusEnum.EMPTY.name())) {
            return randomMembershipStatus(length);
        }
        return MembershipStatusEnum.values()[randomPosition];
    }
*/

    public static String randomEmail(final String firstName, final String lastName) {
        final String domain = randomString(alphaCharacters + numericCharacters, 10);
        final String extension = randomString(alphaCharacters, 3);

        return firstName + "." + lastName + "@" + domain + "." + extension;
    }

    public static String randomEmail() {
        final String firstName = randomString(alphaCharacters + numericCharacters, 12);
        final String lastName = randomString(alphaCharacters + numericCharacters, 12);

        return randomEmail(firstName, lastName);
    }

    public static <E> Set<E> randomSubset(final Set<E> initialSet, final int subsetSize) {
        final List<E> list = new ArrayList<>(initialSet);
        Collections.shuffle(list);
        return new HashSet(list.subList(0, subsetSize));
    }

    public static <E> E randomElementFromSet(final Set<E> set) {
        final List<E> list = new ArrayList<>(set);
        Collections.shuffle(list, random);
        return list.get(0);
    }

}