package utilityPkg;

enum SeatRows { 
    A,B,C,D,E,F,G,H;
}

public class ArrayUpdate {
   
    public int[] updateTickets(String seatNo){
        /*
        2. input aise hoga, 1 char, phir 1 num
        3. phir aise kuch maano;
        A1 matlab
        A - 0th row, 1 matlab 0th column
        B3 matlab
        B - 1st row, 3 matlab 2nd column

        phir array me iss location pe jaake -1 karo,
        B3 diya matlab
        arr[1][2] = -1;
        */
        int col = (int)seatNo.charAt(1);
        // replace all digits with empty string
        seatNo = seatNo.replaceAll("\\d", "");
        //seatNo me row hai as A,B,C... ab isse enum me pass karke iske corrosponding row number le sakte
        String rowStr = seatNo;
        
        /*
        char me '1' matlab int me 49
        to isiliye 48 minus kiya.
        */
        int row = SeatRows.valueOf(rowStr).ordinal();
        col =col-49;
        
        
        /*
        program me 8x8 ka array hai,
        indexes from [0,0] to [7,7]
        A matlab 0th row,
        1 matlab 0th col,
        
        agar user A1 seat choose kar raha matlab woh 0th row, 0th col ki seat choose kar raha.
        
        */
        /*
        hume program ko aise bana hai ki agar A aaye to usse 0 bana de, B aaye to usse 1 bana de,
        similarly col me 1 aaye to usse zero bana de
        */
        int[] index = new int[2];
        index[0] = row;
        index[1] = col;
        
        return index;
    }
}
 

