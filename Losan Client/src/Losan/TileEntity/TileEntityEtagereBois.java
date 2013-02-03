package Losan.TileEntity;

import net.minecraft.src.TileEntity;

public class TileEntityEtagereBois extends TileEntity //ajout
{
   

    /** The current angle of the lid (between 0 and 1) */
    public float lidAngle;

    /** The angle of the lid last tick */
    public float prevLidAngle;


    /** The number of players currently using this chest */
    public int numUsingPlayers;

    /** Server sync counter (once per 20 ticks) */
    private int ticksSinceSync;
    
    
    public void updateEntity()
    {
    	super.updateEntity();
    }

    public void updateContainingBlockInfo()
    {
        super.updateContainingBlockInfo();
    }
    

}
