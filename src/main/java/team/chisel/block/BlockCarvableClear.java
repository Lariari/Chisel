package team.chisel.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;
import team.chisel.ctmlib.CTM;

public class BlockCarvableClear extends BlockCarvable {
	private CTM ctm = CTM.getInstance();

	public BlockCarvableClear() {
		super();
		useNeighborBrightness = true;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass() {
		return 1;
	}
	
	@Override
	public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side) {
		ForgeDirection face = ForgeDirection.getOrientation(side).getOpposite();
		int meX = x + face.offsetX;
		int meY = y + face.offsetY;
		int meZ = z + face.offsetZ;
		Block block = world.getBlock(meX, meY, meZ);
		int meta = world.getBlockMetadata(meX, meY, meZ);
		Block otherBlock = ctm.getBlockOrFacade(world, x, y, z, face.ordinal());
		int otherMeta = ctm.getBlockOrFacadeMetadata(world, x, y, z, face.ordinal());
		return block != otherBlock || meta != otherMeta;
	}
	
}

	