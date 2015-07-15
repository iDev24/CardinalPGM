package in.twizmwaz.cardinal.module.modules.itemRemove;

import in.twizmwaz.cardinal.match.Match;
import in.twizmwaz.cardinal.module.ModuleBuilder;
import in.twizmwaz.cardinal.module.ModuleCollection;
import in.twizmwaz.cardinal.util.Numbers;
import org.bukkit.Material;
import org.jdom2.Element;

public class ItemRemoveBuilder implements ModuleBuilder {

    @Override
    public ModuleCollection<ItemRemove> load(Match match) {
        ModuleCollection<ItemRemove> results = new ModuleCollection<>();
        for (Element itemRemove : match.getDocument().getRootElement().getChildren("itemremove")) {
            for (Element item : itemRemove.getChildren("item")) {
                String[] broken = item.getText().split(":");
                Material material;
                try {
                    material = Material.getMaterial(Numbers.parseInt(broken[0]));
                } catch (NumberFormatException e) {
                    material = Material.matchMaterial(broken[0]);
                }
                short damage = -1;
                try {
                    damage = Short.parseShort(broken[1]);
                } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                }
                results.add(new ItemRemove(new RemovedItem(material, damage)));
            }
        }
        return results;
    }

}
