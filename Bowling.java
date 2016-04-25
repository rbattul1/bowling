import java.io.*;
import java.util.*;

public class Bowling
{

static Scanner keyIn = new Scanner(System.in);

public Bowling()
{
}

public static void main(String args[])
{

  int frame[] = new int[10];
  int allframe[][] = new int[2][12];
  String s;

 do {
  System.out.println("\n\t  Welcome to Java Bowling Gaming Score Board ");
   for(int l1 = 0; l1 < 10; l1++)
	  frame[l1] = 0;
     for(int l2 = 0; l2 < 12; l2++)
	   allframe[0][l2] = allframe[1][l2] = 0;
   nxtframe:

 for(int i = 0; i < 10; i++) {
    boolean chk = false;
    int Pins = 0;

   while(!chk) {
    System.out.printf("\n\t   FRAME %2d ", new Object[] {
	 Integer.valueOf(i + 1)	});

    System.out.printf("\n\t Ball 1: ");
	 Pins = keyIn.nextInt();

     if(Pins <= 10 && Pins >= 0) {
	  allframe[0][i] = Pins;
	  chk = true;
	 }
   }
   if(Pins == 10) {
     System.out.println("\n\t\t\tExcelent, Strike!!");
	 continue;

   }
  chk = false;

do {
  int Pins2 = 0;

  if(chk)
    continue nxtframe;
    System.out.print("\n\t Ball 2: ");
    Pins2 = keyIn.nextInt();

   if(Pins2 <= 10 && Pins2 >= 0 && Pins2 + allframe[0][i] < 11) {
	 allframe[1][i] = Pins2;

   if(Pins2 + allframe[0][i] == 10)
	    System.out.println("\n\t\t\tNice, Spare!!");
   else if(allframe[0][i] < 4 || Pins2 < 4)
	    System.out.println("\n\t\t\tDo better next time");

	chk = true;
    }

  } while(true);

}

 if(allframe[0][9] == 10) {
   boolean chk1 = false;

   int Pins3 = 0;

  while(!chk1) {
    System.out.print("\n\t  XTR1\n\n\t Ball 1: ");
	Pins3 = keyIn.nextInt();

   if(Pins3 < 11 && Pins3 >= 0) {
     allframe[0][10] = Pins3;
	 chk1 = true;
   }
  }

if(allframe[0][10] == 10) {
   boolean chk2 = false;

   int Pins4 = 0;

   System.out.println("\n\t\t\tExcelent, Strike...");

   if(allframe[0][11] == 10)
    System.out.print("\n\t\t\tExcelent, Strike...");

 while(!chk2) {
    System.out.print("\n\t  XTR2\n\n\t Ball 2: ");
	Pins4 = keyIn.nextInt();

   if(Pins4 < 11 && Pins4 > 0) {
	 allframe[0][11] = Pins4;
	 chk2 = true;
   }
  }

 }else {
   boolean chk3 = false;

   int Pins5 = 0;

   while(!chk3) {
    System.out.print("\n\t  XTR2\n\n\t Ball 2: ");
	Pins5 = keyIn.nextInt();

	if(Pins5 < 11 && Pins5 >= 0 && Pins5 + allframe[0][10] < 11)
	{
		allframe[1][10] = Pins5;
		chk3 = true;
	}

   }
  }

 }else if(allframe[0][9] + allframe[1][9] == 10){
  boolean chk4 = false;

  int Pins6 = 0;

  while(!chk4){
    System.out.print("\n\t  XTR2\n\n\t Ball 2: ");
        Pins6 = keyIn.nextInt();

   if(Pins6 <= 10 && Pins6 >= 0){
     allframe[0][10] = Pins6;
     chk4 = true;
   }
 }

 }

//start
if(allframe[0][0] + allframe[0][1] == 10)
   frame[0] = 10 + allframe[0][1];
 else
   frame[0] = allframe[0][0] + allframe[1][0];

//middle
if(allframe[0][0] == 10) {
  if(allframe[0][1] == 10)
	 frame[0] = 20 + allframe[0][2];
   else
	 frame[0] = 10 + allframe[0][1] + allframe[1][1];
}

//end
for(int j = 1; j < 10; j++) {

 if(allframe[0][j] == 10){
  if(allframe[0][j + 1] == 10)
	frame[j] = frame[j - 1] + 20 + allframe[0][j + 2];
  else
	frame[j] = frame[j - 1] + 10 + allframe[0][j + 1] + allframe[1][j + 1];
    continue;
 }

if(allframe[0][j] + allframe[1][j] == 10)
   frame[j] = frame[j - 1] + 10 + allframe[0][j + 1];
else
   frame[j] = frame[j - 1] + allframe[0][j] + allframe[1][j];

}

//Print
 System.out.print("\n\n\t  FRAME");
  for(int k = 1; k < 11; k++)
	 System.out.printf("%4d", new Object[] {
	   Integer.valueOf(k) });

   if(allframe[0][9] == 10) {
	 if(allframe[0][10] == 10)
	   System.out.print("  XTR1 XTR2");
	 else
	   System.out.print("  EXTRA");

   }else if(allframe[0][9] + allframe[1][9] == 10)
	System.out.print("  XTRA");
	System.out.print("\n\n\tBall 1 ");

  for(int l = 0; l < 10; l++)
		System.out.printf("%4d", new Object[] {
			Integer.valueOf(allframe[0][l])
		});

 if(allframe[0][9] == 10)	{
  if(allframe[0][10] == 10)
    System.out.printf("%4d%4d", new Object[] {
     Integer.valueOf(allframe[0][10]), Integer.valueOf(allframe[0][11]) });
   else
      System.out.printf("%4d", new Object[] {
       Integer.valueOf(allframe[0][10]) });

 } else
  if(allframe[0][9] + allframe[1][9] == 10)
	System.out.printf("%4d", new Object[] {
		Integer.valueOf(allframe[0][10])
	});
    System.out.print("\n\tBall 2 ");
  for(int i1 = 0; i1 < 10; i1++)
	System.out.printf("%4d", new Object[] {
		Integer.valueOf(allframe[1][i1])
	});

  if(allframe[0][9] == 10 && allframe[0][10] != 10)
	System.out.printf("%4d", new Object[] {
		Integer.valueOf(allframe[1][10])
	});

    System.out.print("\n\n\t  SCORE");          //print this statements.
  for(int j1 = 0; j1 < 10; j1++)
	System.out.printf("%4d", new Object[] {
		Integer.valueOf(frame[j1])
	});

System.out.print("\n\n\t\t\tPlay more (Y/N)? "); // print this statements.
s = keyIn.next();
String s1 = keyIn.nextLine();

	} while(s.toUpperCase().charAt(0) == 'Y'); // this changes to upper case.
}
}
