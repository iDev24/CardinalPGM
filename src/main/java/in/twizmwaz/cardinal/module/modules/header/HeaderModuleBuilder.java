package in.twizmwaz.cardinal.module.modules.header;

import in.twizmwaz.cardinal.match.Match;
import in.twizmwaz.cardinal.module.BuilderData;
import in.twizmwaz.cardinal.module.ModuleBuilder;
import in.twizmwaz.cardinal.module.ModuleCollection;
import in.twizmwaz.cardinal.module.ModuleLoadTime;

@BuilderData(load = ModuleLoadTime.LATEST)
public class HeaderModuleBuilder implements ModuleBuilder {

    @Override
    public ModuleCollection<HeaderModule> load(Match match) {
        return new ModuleCollection<>(new HeaderModule(match.getLoadedMap()));
    }
}
