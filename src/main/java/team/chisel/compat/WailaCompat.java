package team.chisel.compat;

import java.util.List;

import com.cricketcraft.chisel.api.ICarvable;

import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import mcp.mobius.waila.api.IWailaRegistrar;
//import mcp.mobius.waila.utils.WailaExceptionHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class WailaCompat implements IWailaDataProvider {

	private WailaCompat() {
	}

	@Override
	public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler configHandler) {
		return null;
	}

	@Override
	public List<String> getWailaHead(ItemStack stack, List<String> strings, IWailaDataAccessor accessor, IWailaConfigHandler configHandler) {
		return strings;
	}

	@Override
	public List<String> getWailaBody(ItemStack stack, List<String> strings, IWailaDataAccessor accessor, IWailaConfigHandler configHandler) {
		EntityPlayer EntityPlayer = accessor.getPlayer();
		boolean isSneaking = EntityPlayer.isSneaking();
		if (isSneaking && accessor.getBlock() instanceof ICarvable) {
			ICarvable block = (ICarvable) accessor.getBlock();
			MovingObjectPosition pos = accessor.getPosition();
			String blockDesc = block.getManager(accessor.getWorld(), pos.blockX, pos.blockY, pos.blockZ, accessor.getMetadata()).getDescription();
			if (blockDesc != null && !blockDesc.equals("")) {
				strings.add(blockDesc);
			}
		}
		return strings;
	}

	@Override
	public List<String> getWailaTail(ItemStack stack, List<String> strings, IWailaDataAccessor accessor, IWailaConfigHandler configHandler) {
		return strings;
	}

	public NBTTagCompound getNBTData(EntityPlayerMP player, TileEntity te, NBTTagCompound tag, World world, int x, int y, int z) {
		return tag;
	}

	public static void register(IWailaRegistrar registrar) {
		registrar.registerBodyProvider(new WailaCompat(), ICarvable.class);
	}
}
