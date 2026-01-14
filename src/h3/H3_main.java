package h3;

import java.util.Arrays;

public class H3_main {

	public static void main(String[] args) {
		
		

	}

	public static int[] mergeSort(int[] array) {

		if (array.length <= 1) {

			return array;

		}

		int part = array.length / 2;

		int[] firstHalf = Arrays.copyOfRange(array, 0, part);
		int[] secondHalf = Arrays.copyOfRange(array, part, array.length);

		firstHalf = mergeSort(firstHalf);
		secondHalf = mergeSort(secondHalf);

		return merge(firstHalf, secondHalf);

	}

	public static int[] merge(int[] firstHalf, int[] secondHalf) {

		int[] resultingArray = new int[firstHalf.length + secondHalf.length];

		int i = 0;
		int k = 0;
		int z = 0;

		while (i < firstHalf.length && k < secondHalf.length) {

			if (firstHalf[i] <= secondHalf[k]) {

				resultingArray[z++] = firstHalf[i++];

			} else {

				resultingArray[z++] = secondHalf[k++];

			}

		}
		while (i < firstHalf.length) {

			resultingArray[z++] = firstHalf[i++];

		}
		while (k < secondHalf.length) {

			resultingArray[z++] = secondHalf[k++];

		}

		return resultingArray;

	}

}
