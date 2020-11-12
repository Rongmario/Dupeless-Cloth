package zone.rong.dupelesscloth.mixins;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.ForgeHooks;
import org.spongepowered.asm.mixin.Mixin;
import vazkii.botania.common.crafting.recipe.SpellClothRecipe;
import vazkii.botania.common.item.ModItems;

@Mixin(SpellClothRecipe.class)
public abstract class SpellClothRecipeMixin implements IRecipe {

    @Override
    public NonNullList<ItemStack> getRemainingItems(InventoryCrafting inv) {
        NonNullList<ItemStack> returnStacks = NonNullList.withSize(inv.getSizeInventory(), ItemStack.EMPTY);
        for (int i = 0; i < returnStacks.size(); i++) {
            ItemStack stack = inv.getStackInSlot(i);
            if (stack.isItemEnchanted() && stack.getItem() != ModItems.spellCloth) {
                inv.setInventorySlotContents(i, ItemStack.EMPTY); // Directly set and update the crafting matrix
            } else {
                returnStacks.set(i, ForgeHooks.getContainerItem(stack));
            }
        }
        return returnStacks;
    }

}
