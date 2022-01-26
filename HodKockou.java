import java.util.Random;
import java.util.Scanner;

public class HodKockou {

    static Scanner sc = new Scanner( System.in );

    public static int galtonBoard( int depth, int index ) {
        Random r = new Random();

        if ( depth == 0 ) return index;
        int desicion = r.nextDouble() >= 0.5? 1 : 0;
        if ( desicion == 1 ) return galtonBoard( depth - 1, index - 1 );
        else return galtonBoard( depth - 1, index + 1 );
    }


    public static void printBoard( int[] board ) {

        for ( int i = 0; i < board.length; i++ ) {
            System.out.print( ( i + 1 ) + " " );
            for ( int j = 0; j < board[ i ]; j++ ) {
                System.out.print( "*" );
            }
            System.out.println( "\n" );
        }
    }

    public static int getInput( String text ) {

        System.out.println( "Enter number of " + text );
        return sc.nextInt();

    }


    public static void main( String[] args ) {

        int depth = 0;
        int numberAttempts = 0;
        int[] attempts;
        int[] result = new int[0];

        System.out.println( "Throw dice -> press D" );
        System.out.println( "Galton Board -> press G" );
        String desicion = sc.next();


        if ( desicion.equals( "D" ) || desicion.equals( "d" )) {

            depth = getInput( "dices" );
            numberAttempts = getInput( "throws" );

            attempts = new int[ numberAttempts ];
            result = new int[ depth * 6 ];

            for ( int i = 0; i < attempts.length; i++ ) {
                for ( int j = 0; j < depth; j++ ) {
                    attempts[ i ] += ( int ) ( Math.random() * 6 ) + 1;
                }
                result[ ( attempts[ i ] - 1 ) ]++;
            }

        } else if ( desicion.equals( "G" ) || desicion.equals( "g" ) ) {

            depth = getInput( "depth" );
            numberAttempts = getInput( "balls" );

            attempts = new int[ numberAttempts ];
            result = new int[ depth * 2 + 1 ];
            int middle = (depth * 2 + 1) / 2;
            int index = 0;
            for ( int i = 0; i < attempts.length; i++ ) {
                index = galtonBoard( depth, middle );
                result[index]++;
            }

        }

        printBoard( result );








    }
}