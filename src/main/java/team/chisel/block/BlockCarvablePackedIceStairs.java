package team.chisel.block;

import java.util.Random;

import com.cricketcraft.chisel.api.carving.CarvableHelper;

import team.chisel.init.ChiselBlocks;
import net.minecraft.block.Block;
//import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockCarvablePackedIceStairs extends BlockCarvableStairs {

	public BlockCarvablePackedIceStairs(Block block, int meta, CarvableHelper helper) {
		super(block, meta, helper);
		this.setHarvestLevel("pickaxe", 0);
		slipperiness = 0.98F;
		setTickRandomly(true);
	}

	//@Override
	//public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6) {
	//	ChiselBlocks.packedice.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
	//}

	//@Override
	//public int quantityDropped(Random par1Random) {
	//	return ChiselBlocks.packedice.quantityDropped(par1Random);
	//}

	@Override
	public int damageDropped(int i) {
		if (i <= 7) {
			return 0;
		}
		else {
			return 8;
		}
	}

	@Override
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		ChiselBlocks.packedice.updateTick(par1World, par2, par3, par4, par5Random);
	}

	@Override
	public int getMobilityFlag() {
		return 0;
	}
}
