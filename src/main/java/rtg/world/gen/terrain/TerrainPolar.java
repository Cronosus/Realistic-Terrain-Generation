package rtg.world.gen.terrain;

import rtg.config.ConfigRTG;
import rtg.util.noise.CellNoise;
import rtg.util.noise.OpenSimplexNoise;

public class TerrainPolar extends TerrainBase {
    public TerrainPolar() {
    }

    @Override
    public float generateNoise(OpenSimplexNoise simplex, CellNoise cell, int x, int y, float border, float river) {
        float st = (simplex.noise2(x / 160f, y / 160f) + 0.38f) * (ConfigRTG.duneHeight + 23f) * river;
        st = st < 0.2f ? 0.2f : st;

        float h = simplex.noise2(x / 60f, y / 60f) * st * 2f;
        h = h > 0f ? -h : h;
        h += st;
        h *= h / 50f;
        h += st;

        return 70f + h;
    }
}
