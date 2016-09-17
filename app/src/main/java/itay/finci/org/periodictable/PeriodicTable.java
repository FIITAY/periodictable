package itay.finci.org.periodictable;


import android.content.Context;
import android.content.res.Resources;

/**
 * Created by itay on 17/09/16.
 */
public class PeriodicTable {
    private static PeriodicTable ourInstance = new PeriodicTable();
    private Periodic[] periodic;
    private static boolean firstTime = true;

    public static PeriodicTable getInstance(Context ctx) {
        if (firstTime) {
            ourInstance.periodic  = new Periodic[27];
            ourInstance.periodic[0] = new Periodic(ctx.getString(R.string.Hydrogen) , "H");
            ourInstance.periodic[1] = new Periodic(ctx.getString(R.string.lithium) , "Li");
            ourInstance.periodic[2] = new Periodic(ctx.getString(R.string.sodium) , "Na");
            ourInstance.periodic[3] = new Periodic(ctx.getString(R.string.Potassium) , "K");
            ourInstance.periodic[4] = new Periodic(ctx.getString(R.string.Calcium) , "Ca");
            ourInstance.periodic[5] = new Periodic(ctx.getString(R.string.Magnesium) , "Mg");
            ourInstance.periodic[6] = new Periodic(ctx.getString(R.string.Beryllium) , "Be");
            ourInstance.periodic[7] = new Periodic(ctx.getString(R.string.Helium) , "He");
            ourInstance.periodic[8] = new Periodic(ctx.getString(R.string.Neon) , "Ne");
            ourInstance.periodic[9] = new Periodic(ctx.getString(R.string.Fluorine) , "F");
            ourInstance.periodic[10] = new Periodic(ctx.getString(R.string.Oxygen) , "O");
            ourInstance.periodic[11] = new Periodic(ctx.getString(R.string.Nitrogen) , "N");
            ourInstance.periodic[12] = new Periodic(ctx.getString(R.string.Carbon) , "C");
            ourInstance.periodic[13] = new Periodic(ctx.getString(R.string.Boron) , "B");
            ourInstance.periodic[14] = new Periodic(ctx.getString(R.string.Chlorine) , "Cl");
            ourInstance.periodic[15] = new Periodic(ctx.getString(R.string.Sulfur) , "S");
            ourInstance.periodic[16] = new Periodic(ctx.getString(R.string.Phosphorus) , "P");
            ourInstance.periodic[17] = new Periodic(ctx.getString(R.string.Silicon) , "Si");
            ourInstance.periodic[18] = new Periodic(ctx.getString(R.string.Aluminium) , "Al");
            ourInstance.periodic[19] = new Periodic(ctx.getString(R.string.Bromine) , "Br");
            ourInstance.periodic[20] = new Periodic(ctx.getString(R.string.Iodine) , "I");
            ourInstance.periodic[21] = new Periodic(ctx.getString(R.string.Copper) , "Cu");
            ourInstance.periodic[22] = new Periodic(ctx.getString(R.string.Zinc) , "Zn");
            ourInstance.periodic[23] = new Periodic(ctx.getString(R.string.Silver) , "Ag");
            ourInstance.periodic[24] = new Periodic(ctx.getString(R.string.Gold) , "Au");
            ourInstance.periodic[25] = new Periodic(ctx.getString(R.string.Mercury) , "Hg");
            ourInstance.periodic[26] = new Periodic(ctx.getString(R.string.Iron) , "Fe");
            firstTime = false;
        }
            return ourInstance;
    }

    private final static int NUM_ELEMENTS = 27;

    private PeriodicTable() {
    }

    public Periodic getPeriodic(int place) {
        return periodic[place];
    }
}
