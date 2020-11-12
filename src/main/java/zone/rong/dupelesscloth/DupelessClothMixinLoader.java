package zone.rong.dupelesscloth;

import org.spongepowered.asm.mixin.Mixins;
import zone.rong.mixinbooter.MixinLoader;

@MixinLoader
public class DupelessClothMixinLoader {

    {
        Mixins.addConfiguration("mixins.dupelesscloth.json");
    }

}
