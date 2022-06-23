//Assignment Name: Implement and Test ADT
//Name: Jaclyn Windorff
//Email: jwindorff@wisc.edu
//Due Date: 2/5/2018
//Bugs: None

//Tests the MaxPQ class for errors 
public class TestMaxPQ {
	//The main method that runs the tests that make sure the MaxPQ class for errors
	public static void main(String[] args)
	{
		MaxPQ<String> test = new MaxPQ<String>();
		
		test1_isEmpty(test);
		test2_getMaxError(test);
		test3_removeMaxError(test);
		test4_nullItemInsert(test);
		test8_insertRemoveMany(test);
		test10_duplicatesInitial(test);
		test11_duplicatesMixed(test);
	}
	
	//test to see if the isEmpty method of the MaxPQ class works when list is empty
	//@param MaxQP<String> test - the String type MaxPQ that is to be tested
	private static void test1_isEmpty(MaxPQ<String> test)
	{
		boolean emptyTest = test.isEmpty();
		if(!emptyTest)
			System.out.println("!!! TEST TEST1_ISEMPTY FAILED. EXPECTED TRUE; ACTUAL FALSE"
					+ "WHEN PQ FIRST CONSTRUCTED.");
		else
			System.out.println("test1_isEmpty passed.");
	}
	
	//test to see if trying getMax while the PQ is empty throws the proper exception
	//@param MaxQP<String> test - the String type MaxPQ that is to be tested
	private static void test2_getMaxError(MaxPQ<String> test)
	{
		try
		{
			String t = test.getMax();
			System.out.println("!!! TEST2_GETMAXERROR FAILED. WHEN PQ EMPTY, "
					+ "EXPECTED ERROR, ACTUAL: " + t);
		}
		catch(EmptyQueueException e)
		{
			System.out.println("test2_getMaxError passed.");
		}
		
	}
	
	//tests to see if removing from an empty PQ throws the proper error
	//@param MaxQP<String> test - the String type MaxPQ that is to be tested
	private static void test3_removeMaxError(MaxPQ<String> test)
	{
		try
		{
			String n = test.removeMax();
			System.out.println("!!! TEST3_REMOVEMAXERROR FAILED. WHEN PQ EMPTY, "
					+ "EXPECTED ERROR, ACTUAL: " + n);
		}
		catch(EmptyQueueException e)
		{
			System.out.println("test3_removeMaxError passed.");
		}
	}
	
	//test to see if inserting a null item into the list throws the proper error
	//@param MaxQP<String> test - the String type MaxPQ that is to be tested
	private static void test4_nullItemInsert(MaxPQ<String> test)
	{
		try
		{
			test.insert(null);
			System.out.println("!!! TEST4_NULLITEMINSERT FAILED. "
					+ "EXPECTED ERROR, ACTUAL NO ERROR.");
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("test4_nullItemInsert passed.");
		}
	}
	
	//test to see if the insert and remove methods work properly, even in the case of more data than the original
	//list can hold
	//also calls tests 5, 6, 7, and 9
	//@param MaxQP<String> test - the String type MaxPQ that is to be tested
	private static void test8_insertRemoveMany(MaxPQ<String> test)
	{
		test.insert("A");
		test.insert("I");
		test.insert("K");
		test.insert("D");
		test.insert("E");
		test.insert("B");
		test.insert("J");
		test.insert("F");
		test.insert("G");
		test.insert("H");
		test.insert("C");
		
		test5_size(test);
		test6_getMax(test);
		test7_isEmptyNot(test);
		
		String max = test.removeMax();
		if(max.equals("A"))
			System.out.println("test8_insertRemoveMany(1) passed.");
		else
			System.out.println("!!! TEST8_INSERTREMOVEMANY(1) TEST FAILED.\n"
					+ "EXPECTED A GOT " + max);
		max = test.removeMax();
		if(max.equals("B"))
			System.out.println("test8_insertRemoveMany(2) passed.");
		else
			System.out.println("!!! TEST8_INSERTREMOVEMANY(2) TEST FAILED.\n"
					+ "EXPECTED B GOT " + max);
		max = test.removeMax();
		if(max.equals("C"))
			System.out.println("test8_insertRemoveMany(3) passed.");
		else
			System.out.println("!!! TEST8_INSERTREMOVEMANY(3) TEST FAILED.\n"
					+ "EXPECTED C GOT " + max);
		max = test.removeMax();
		if(max.equals("D"))
			System.out.println("test8_insertRemoveMany(4) passed.");
		else
			System.out.println("!!! TEST8_INSERTREMOVEMANY(4) TEST FAILED.\n"
					+ "EXPECTED D GOT " + max);
		max = test.removeMax();
		if(max.equals("E"))
			System.out.println("test8_insertRemoveMany(5) passed.");
		else
			System.out.println("!!! TEST8_INSERTREMOVEMANY(5) TEST FAILED.\n"
					+ "EXPECTED E GOT " + max);
		max = test.removeMax();
		if(max.equals("F"))
			System.out.println("test8_insertRemoveMany(6) passed.");
		else
			System.out.println("!!! TEST8_INSERTREMOVEMANY(6) TEST FAILED.\n"
					+ "EXPECTED F GOT " + max);
		max = test.removeMax();
		if(max.equals("G"))
			System.out.println("test8_insertRemoveMany(7) passed.");
		else
			System.out.println("!!! TEST8_INSERTREMOVEMANY(7) TEST FAILED.\n"
					+ "EXPECTED G GOT " + max);
		max = test.removeMax();
		if(max.equals("H"))
			System.out.println("test8_insertRemoveMany(8) passed.");
		else
			System.out.println("!!! TEST8_INSERTREMOVEMANY(8) TEST FAILED.\n"
					+ "EXPECTED H GOT " + max);
		max = test.removeMax();
		if(max.equals("I"))
			System.out.println("test8_insertRemoveMany(9) passed.");
		else
			System.out.println("!!! TEST8_INSERTREMOVEMANY(9) TEST FAILED.\n"
					+ "EXPECTED I GOT " + max);
		max = test.removeMax();
		if(max.equals("J"))
			System.out.println("test8_insertRemoveMany(10) passed.");
		else
			System.out.println("!!! TEST8_INSERTREMOVEMANY(10) TEST FAILED.\n"
					+ "EXPECTED J GOT " + max);
		max = test.removeMax();
		if(max.equals("K"))
			System.out.println("test8_insertRemoveMany(11) passed.");
		else
			System.out.println("!!! TEST8_INSERTREMOVEMANY(11) TEST FAILED.\n"
					+ "EXPECTED K GOT " + max);
		
		test9_removeMaxAfterEmpty(test);
	}
	
	
	//test to see if the size method works correctly
	//@param MaxQP<String> test - the String type MaxPQ that is to be tested
	private static void test5_size(MaxPQ<String> test)
	{
		int size = test.size();
		if(size == 11)
			System.out.println("test5_size passed.");
		else
			System.out.println("!!! TEST6_SIZE AFTER 11 INSERTS FAILED."
					+ "\n EXPECTED 11 GOT " + size);
	}
	
	//test to see if the getMax method works correctly
	//@param MaxQP<String> test - the String type MaxPQ that is to be tested
	private static void test6_getMax(MaxPQ<String> test)
	{
		String max = test.getMax();
		if(max.equals("A"))
			System.out.println("test6_getMax passed.");
		else
			System.out.println("!!! GETMAX TEST FAILED, INSERT ROOT POSSIBLY WRONG. \n"
					+ "EXPECTED A GOT " + max);
	}
	
	//test to see if the isEmpty method works correctly when the PQ is not empty
	//@param MaxQP<String> test - the String type MaxPQ that is to be tested
	private static void test7_isEmptyNot(MaxPQ<String> test)
	{
		boolean emptyTest = test.isEmpty();
		if(emptyTest)
			System.out.println("!!! TEST TEST7_ISEMPTYNOT FAILED. EXPECTED FALSE; ACTUAL TRUE"
					+ "WHEN PQ HAS 11 ITEMS.");
		else
			System.out.println("test7_isEmptyNot passed.");
	}
	
	//test to see if the removeMax method throws the proper error if called after all of the items are removed from
	//the PQ
	//@param MaxQP<String> test - the String type MaxPQ that is to be tested
	private static void test9_removeMaxAfterEmpty(MaxPQ<String> test)
	{
		try
		{
			String max = test.removeMax();
			System.out.println("!!! TEST9_REMOVEMAXAFTEREMPTY FAILED. EXPECTED ERROR GOT " + max);
		}
		catch(EmptyQueueException e)
		{
			System.out.println("test9_removeMaxAfterEmpty passed.");
		}
	}
	
	//test to see if duplicates are allowed when they are the initial values in the PQ
	//@param MaxQP<String> test - the String type MaxPQ that is to be tested
	private static void test10_duplicatesInitial(MaxPQ<String> test)
	{
		test.insert("A");
		test.insert("A");
		test.insert("B");
		test.insert("A");
		
		String max = test.removeMax();
		if(max.equals("A"))
			System.out.println("test10_duplicatesInitial(1) passed.");
		else
			System.out.println("!!! TEST10_DUPLICATESINITIAL(1) FAILED. EXPECTED A, GOT " + max);
		max = test.removeMax();
		if(max.equals("A"))
			System.out.println("test10_duplicatesInitial(2) passed.");
		else
			System.out.println("!!! TEST10_DUPLICATESINITIAL(2) FAILED. EXPECTED A, GOT " + max);
		max = test.removeMax();
		if(max.equals("A"))
			System.out.println("test10_duplicatesInitial(3) passed.");
		else
			System.out.println("!!! TEST10_DUPLICATESINITIAL(3) FAILED. EXPECTED A, GOT " + max);
		max = test.removeMax();
		if(max.equals("B"))
			System.out.println("test10_duplicatesInitial(4) passed.");
		else
			System.out.println("!!! TEST10_DUPLICATESINTITIAL(4) FAILED. EXPECTED A, GOT " + max);
	}
	
	//test to see if duplicate values are allowed when they are mixed in with other values
	//@param MaxQP<String> test - the String type MaxPQ that is to be tested
	private static void test11_duplicatesMixed(MaxPQ<String> test)
	{
		test.insert("A");
		test.insert("I");
		test.insert("K");
		test.insert("I");
		test.insert("E");
		test.insert("B");
		test.insert("J");
		test.insert("F");
		test.insert("G");
		test.insert("H");
		test.insert("C");
		
		test.removeMax();
		test.removeMax();
		test.removeMax();
		test.removeMax();
		test.removeMax();
		test.removeMax();
		test.removeMax();
		
		String max = test.removeMax();
		if(max.equals("I"))
			System.out.println("test11_duplicatesMixed(1) passed.");
		else
			System.out.println("!!! TEST11_DUPLICATESMIXED(1) FAILED. EXPECTED I GOT " + max);
		max = test.removeMax();
		if(max.equals("I"))
			System.out.println("test11_duplicatesMixed(2) passed.");
		else
			System.out.println("!!! TEST11_DUPLICATESMIXED(2) FAILED. EXPECTED I GOT " + max);
	}

}
